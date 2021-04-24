<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>禁用列表(注册未经过审核)</el-breadcrumb-item>
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
            <el-button size="mini" type="danger" @click="adminPprohibit(scope.$index, scope.row)">解除禁用</el-button>
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
  </el-card>
</template>
<script>
  export default {
    name: 'UserInfoProhibitManager',
    data() {
      return {
        tableData: [],
        total: 0,
        pageNo: 1,
        pageSize: 5,
        keyWord: "",
        formLabelWidth: "120px",

      }
    },
    mounted() {
      this.list();
    },
    methods: {
      list: function () {
        this.$ajax.get('user/get/prohibit/info', {
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
      adminPprohibit(index, row) {
        this.$confirm('是否解除该用户的禁用', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$ajax.get(
            "user/no/prohibit", {
            params: {
              "adminInfoId": row.adminInfoId,
            }
          }).then((res) => {
            this.$message({
              type: 'success',
              message: "解除成功"
            });
            this.list();
          }).catch((res) => {
            this.$message({
              type: 'info',
              message: "解除失败"
            });
          })
        })
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