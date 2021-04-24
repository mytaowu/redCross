<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>捐款详情</el-breadcrumb-item>
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
        <el-table-column align="center" label="捐赠单位" width="150">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>住址: {{ scope.row.donationMoneyAdd }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.donationMoneyCompany }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="捐赠时间" width="100" prop="donationMoneyTime">
        </el-table-column>
        <el-table-column align="center" label="联系人" width="100" prop="donationMoneyContact">
        </el-table-column>
        <el-table-column align="center" label="邮箱" width="150" prop="donationMoneyMail">
        </el-table-column>
        <el-table-column align="center" label="联系电话" width="150" prop="donationMoneyTel">
        </el-table-column>
        <el-table-column align="center" label="金额" width="150" prop="donationMoneyAmount">
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
      <el-form ref="editSelectRow" :rules="rules" :model="editSelectRow" label-width="80px">
        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠单位:" prop="donationOtherExplain" label-width="100px">
                <el-input v-model="editSelectRow.donationMoneyCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠时间:" label-width="100px">
                <el-input v-model="editSelectRow.donationMoneyTime" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" prop="donationOtherExplain" label-width="100px">
                <el-input v-model="editSelectRow.donationMoneyAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" prop="donationOtherExplain" label-width="100px">
                <el-input v-model="editSelectRow.donationMoneyContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" prop="donationOtherExplain" label-width="100px">
                <el-input v-model="editSelectRow.donationMoneyTel" oninput="value=value.replace(/[^\d]/g,'')">
                </el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" label-width="100px">
                <el-input v-model="editSelectRow.donationMoneyMail"></el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠金额:" label-width="100px">
                <el-input v-model="editSelectRow.donationMoneyAmount" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="其他说明:" prop="donationOtherExplain" label-width="100px">
                <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="editSelectRow.donationOtherExplain">
                </el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="是否保密:" label-width="100px">
                <el-input v-model="editSelectRow.donationIsSecrecyName" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="大金额:" label-width="100px">
                <el-input v-model="editSelectRow.donationIsLargeMoneyName" :disabled="true"></el-input>
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
    <el-dialog width="80%" modal="true" title="添加捐赠信息" :visible.sync="addDialogFormVisible">
      <el-form ref="addRow" :rules="rules" :model="addRow" label-width="80px">
        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠单位:" label-width="100px">
                <el-input v-model="addRow.donationMoneyCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="18">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" label-width="100px">
                <el-input v-model="addRow.donationMoneyAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" label-width="100px">
                <el-input v-model="addRow.donationMoneyContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" label-width="100px">
                <el-input v-model="addRow.donationMoneyTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" label-width="100px">
                <el-input v-model="addRow.donationMoneyMail"></el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠金额:" label-width="100px">
                <el-input v-model="addRow.donationMoneyAmount" oninput="value=value.replace(/[^\d]/g,'')"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="其他说明:" label-width="100px">
                <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="addRow.donationOtherExplain">
                </el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="是否保密:" label-width="100px">
                <el-select v-model="addRow.donationIsSecrecy">
                  <el-option label="保密" value="1"></el-option>
                  <el-option label="不保密" value="0"></el-option>
                </el-select>
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
    name: 'donationMoney',
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
        editSelectRow: {},
        addRow: {},
        rules: {
          donationCompany: [
            { required: true, message: '请输入单位名称', trigger: 'blur' },
            { min: 3, message: '长度在大于 3 个字符', trigger: 'blur' }
          ],
          donationAdd: [
            { required: true, message: '请输入信息', trigger: 'blur' },
          ],
          donationContact: [
            { required: true, message: '请输入联系人', trigger: 'blur' },
          ],
          donationTel: [
            { required: true, message: '请输入电话', trigger: 'blur' },
          ],
          donationMail: [
            { required: true, message: '请输入邮箱', trigger: 'blur' },
          ],
          donationOtherExplain: [
            { required: true, message: '请输入描述内容', trigger: 'blur' },
          ],
          input: [
            { required: true, message: '请输入该字段', trigger: 'blur' },
          ]
        }
      }
    },
    mounted() {
      this.list();
    },
    methods: {
      list: function () {
        this.$ajax.get('donation/money/list', {
          params: {
            "rows": this.pageSize,
            "page": this.pageNo,
            "keyWord": this.keyWord
          }
        }).then((res) => {
          this.total = res.data.total;
          this.tableData = res.data.rows;
        }).catch((res) => { })
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
                "donation/money/add/or/update",
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
        console.log(this.addRow);
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
                "donation/money/add/or/update",
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
        DonationGoodUtil.baseMoneyDateInvoke(this.editSelectRow);
        this.editDialogFormVisible = true;
      },
      handleDelete(index, row) {
        console.log("进入删除逻辑");
        this.$confirm('是否删除该数据?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$ajax.get(
            "donation/money/delete", {
            params: {
              "donationMoneyId": row.donationMoneyId,
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
        DonationGoodUtil.baseDateInvoke(selected);
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