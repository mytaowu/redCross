<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>接收捐款详情</el-breadcrumb-item>
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
        <el-table-column align="center" label="受助单位" width="150">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>住址: {{ scope.row.receivingMoneyDonationAdd }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.receivingMoneyDonationCompany }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="受助时间" width="100" prop="receivingMoneyDonationTime">
        </el-table-column>
        <el-table-column align="center" label="联系人" prop = "receivingMoneyDonationContact" width="100">
        </el-table-column>
        <el-table-column align="center" label="电话" prop="receivingMoneyDonationTel"  width="100">
        </el-table-column>
        <el-table-column align="center" label="邮箱" width="200" prop="receivingMoneyDonationMail">
        </el-table-column>
        <el-table-column align="center" label="金额" width="100" prop="receivingMoneyDonationAmount">
        </el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
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
              <el-form-item label="受助单位:" label-width="100px">
                <el-input v-model="editSelectRow.receivingMoneyDonationCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="接收时间:" label-width="100px">
                <el-input v-model="editSelectRow.receivingMoneyDonationTime" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" label-width="100px">
                <el-input v-model="editSelectRow.receivingMoneyDonationAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" label-width="100px">
                <el-input v-model="editSelectRow.receivingMoneyDonationContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" label-width="100px">
                <el-input v-model="editSelectRow.receivingMoneyDonationTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" label-width="100px">
                <el-input v-model="editSelectRow.receivingMoneyDonationMail"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="其他说明:" label-width="100px">
                <el-input type="textarea" :rows="3" placeholder="请输入内容"
                  v-model="editSelectRow.receivingMoneyDonationOtherExplain">
                </el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="接收金额:">
                <el-input v-model="editSelectRow.receivingMoneyDonationAmount" :disabled="true"></el-input>
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
    <el-dialog width="80%" modal="true" title="添加捐款信息" :visible.sync="addDialogFormVisible">
      <el-form ref="addRow" :model="addRow" label-width="80px">
        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="受助单位:" label-width="100px">
                <el-input v-model="addRow.receivingMoneyDonationCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="18">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" label-width="100px">
                <el-input v-model="addRow.receivingMoneyDonationAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" label-width="100px">
                <el-input v-model="addRow.receivingMoneyDonationContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" label-width="100px">
                <el-input v-model="addRow.receivingMoneyDonationTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" label-width="100px">
                <el-input v-model="addRow.receivingMoneyDonationMail"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="其他说明:" label-width="100px">
                <el-input type="textarea" :rows="3" placeholder="请输入内容"
                  v-model="addRow.receivingMoneyDonationOtherExplain">
                </el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="接收金额:">
                <el-input v-model="addRow.receivingMoneyDonationAmount" oninput="value=value.replace(/[^\d]/g,'')">
                </el-input>
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
    name: 'receivingMoneyDonation',
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
        this.$ajax.get('receiving/money/donation/list', {
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
            this.$confirm('是否更新该捐赠数据?', '提示', {
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
                "receiving/money/donation/add/or/update",
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
            this.$confirm('是否添加该捐赠数据?', '提示', {
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
                "receiving/money/donation/add/or/update",
                this.addRow
              ).then(res => {
                this.postSuccessAjax("添加成功");
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
            "receiving/money/donation/delete", {
            params: {
              "receivingMoneyDonationId": row.receivingMoneyDonationId,
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
      showInfo(index, row) {
        var selected = { ...row };
        // 处理一些基础数据;
        // DonationGoodUtil.baseDateInvoke(selected);
        // this.$router.push({
        //   name:'donationGoodInfo',
        //   params: selected});
        this.$router.push({ name: 'donationGoodInfo', params: selected });
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