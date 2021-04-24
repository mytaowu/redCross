<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>正常使用的管理员管理</el-breadcrumb-item>
      </el-breadcrumb>
      <el-row :gutter="20" class="row">
        <el-col :span="5" class="col">
          <div class="grid-content bg-purple">
            <div class="demo-input-suffix">
              <el-input placeholder="请搜索内容" prefix-icon="el-icon-search" v-model="keyWord" clearable
                @input="inputExchange()">
              </el-input>
            </div>
          </div>
        </el-col>
        <el-col :span="5" class="col">
          <div class="grid-content bg-purple">
            <el-button icon="el-icon-circle-plus-outline" @click="addRowBtn()">添加</el-button>
          </div>
        </el-col>

      </el-row>
      <el-table :data="tableData" :stripe="true" style="width: 100%">
        <el-table-column align="center" label="姓名" width="150" prop = "adminInfoName">
        </el-table-column>
        <el-table-column align="center" label="联系电话" width="150" prop="adminInfoTel">
        </el-table-column>
        <el-table-column align="center" label="登录名" prop = "adminInfoLoginName" width="150">
        </el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="restPass(scope.$index, scope.row)">重置密码</el-button>
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">修改账号</el-button>
            <el-button size="mini" type="danger" @click="adminPprohibit(scope.$index, scope.row)">禁用账号</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="block">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[5, 10, 15]"
        :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </div>

    <!-- editForm -->
    <el-dialog width="80%" modal="true" title="修改信息" :visible.sync="editDialogFormVisible">
      <el-form ref="editSelectRow" :model="editSelectRow" label-width="80px">
        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="姓名:" label-width="100px">
                <el-input v-model="editSelectRow.adminInfoName"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="电话:" label-width="100px">
                <el-input v-model="editSelectRow.adminInfoTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="登录名:" label-width="100px">
                <!-- 登录名必须是数字类型 -->
                <el-input v-model="editSelectRow.adminInfoLoginName"  oninput="value=value.replace(/[^\d]/g,'')"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <div class="outurOkBtnDiv">
          <div class="okBtnDiv">
            <el-form-item>
              <el-button type="primary" @click="submitForm('editSelectRow')">点击修改</el-button>
            </el-form-item>
          </div>
        </div>
      </el-form>
    </el-dialog>


    <!-- addForm -->
    <el-dialog width="80%" modal="true" title="添加信息" :visible.sync="addDialogFormVisible">
      <el-form ref="addRow" :model="addRow" label-width="80px">
        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="姓名:" label-width="100px">
                <el-input v-model="addRow.adminInfoName"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="电话:" label-width="100px">
                <el-input v-model="addRow.adminInfoTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="登录名:" label-width="100px">
                <!-- 登录名必须是数字类型 -->
                <el-input v-model="addRow.adminInfoLoginName" ></el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="密码:" label-width="100px">
                <!-- 登录名必须是数字类型 -->
                <el-input v-model="addRow.adminInfoPass" ></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <div class="outurOkBtnDiv">
          <div class="okBtnDiv">
            <el-form-item>
              <el-button type="primary" @click="addSubmitFrom('addRow')">点击添加</el-button>
            </el-form-item>
          </div>
        </div>
      </el-form>
    </el-dialog>
  </el-card>
</template>
<script>
  export default {
    name: 'UserInfoManager',
    data() {
      return {
        tableData: [],
        total: 0,
        pageNo: 1,
        pageSize: 5,
        keyWord: "",
        editDialogFormVisible: false,
        addDialogFormVisible: false,
        formLabelWidth: "120px",
        editSelectRow: {
          "donationGoods": {}
        },
        addRow: {
          "donationGoods": {}
        }

      }
    },
    mounted() {
      this.list();
    },
    methods: {
      list: function () {
        this.$ajax.get('user/get/all/info', {
          params: {
            "rows": this.pageSize,
            "page": this.pageNo,
            "keyWord": this.keyWord
          }
        }).then((res) => {
          this.total = res.data.total;
          this.tableData = res.data.rows;
        })
      },
      addRowBtn: function () {
        this.addDialogFormVisible = true;
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否更新该管理员数据?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              const loading = this.$loading({
                lock: true,
                text: 'Loading',
                spinner: 'el-icon-loading',
                background: 'rgba(0, 0, 0, 0.7)'
              });
              this.$ajax.post(
                "user/modify",
                this.editSelectRow
              ).then(res => {
                this.postSuccessAjax("更新成功");
                loading.close();
                this.list();
              }).catch(res => {
                this.postErrorAjax("更新失败");
              })
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消更新'
              });
            });
          } else {
            this.$message({
              type: 'info',
              message: '请先填写表单数据！'
            });
          }
        });
      },

      addSubmitFrom: function (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$confirm('是否添加该管理员数据?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              const loading = this.$loading({
                lock: true,
                text: 'Loading',
                spinner: 'el-icon-loading',
                background: 'rgba(0, 0, 0, 0.7)'
              });
              this.$ajax.post(
                "user/add",
                this.addRow
              ).then(res => {
                if (res.data.result == "FAILED"){
                  this.postErrorAjax("信息已经存在");
                }else{
                  this.postSuccessAjax("添加成功");
                }
                loading.close();
                this.addRow = {};
                this.list();
              }).catch(res => {
                this.postErrorAjax("添加失败");
                this.addRow = {};
              })
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消添加'
              });
            });
          } else {
            this.$message({
              type: 'info',
              message: '请先填写表单数据！'
            });
          }
        });
      },
      inputExchange() {
        this.list();
      },
      handleSizeChange(val) {
        this.pageSize = val;
        this.list();
      },
      handleCurrentChange(val) {
        this.pageNo = val;
        this.list();
      },

      restPass(index, row) {
        this.$confirm('是否重置该用户的密码?(默认密码12345678)', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$ajax.get(
            "user/reset/pass", {
            params: {
              "adminInfoId": row.adminInfoId,
            }
          }).then((res) => {
            this.$message({
              type: 'success',
              message: "重置成功！"
            });
            this.list();
          }).catch((res) => {
            this.$message({
              type: 'info',
              message: "重置失败"
            });
          })
        })
      },
      adminPprohibit(index, row) {
        this.$confirm('是否禁用该管理员?(可以在禁用列表重新启用)', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$ajax.get(
            "user/prohibit", {
            params: {
              "adminInfoId": row.adminInfoId,
            }
          }).then((res) => {
            this.$message({
              type: 'success',
              message: "禁用成功"
            });
            this.list();
          }).catch((res) => {
            this.$message({
              type: 'info',
              message: "禁用失败"
            });
          })
        })
      },
      handleEdit(index, row) {
        this.editSelectRow = { ...row };
        // 处理一些基础数据;
        // DonationGoodUtil.baseDateInvoke(this.editSelectRow);
        this.editDialogFormVisible = true;
      },
      handleDelete(index, row) {
        this.$confirm('是否删除该数据?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$ajax.get(
            "user/delete", {
            params: {
              "adminInfoId": row.adminInfoId,
            }
          }).then((res) => {
            this.$message({
              type: 'success',
              message: "删除成功！"
            });
            this.list();
          }).catch((res) => {
            this.$message({
              type: 'info',
              message: "删除失败"
            });
          })
        }
        )
      },

      postSuccessAjax(message) {
        this.$message({
          type: 'success',
          message: message
        });
        this.editDialogFormVisible = false;
        this.addDialogFormVisible = false;
      },

      postErrorAjax(message) {
        this.$message({
          type: 'info',
          message: message
        });
        this.editDialogFormVisible = false;
        this.addDialogFormVisible = false;
      }
    }
  }
</script>

<style scoped>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }

  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }

  .row {
    margin: 20px;
  }

  .myClass input.el-input__inner {
    border-radius: 15px;
  }

  .outurOkBtnDiv {
    text-align: left;
    position: relative;
    height: 30px;
  }

  .okBtnDiv {
    width: 200px;
    position: absolute;
    right: 10px;
  }
</style>