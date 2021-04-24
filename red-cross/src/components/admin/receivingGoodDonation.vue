<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>接收捐赠详情</el-breadcrumb-item>
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
              <p>住址: {{ scope.row.receivingGoodDonationAdd }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.receivingGoodDonationCompany }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="受助时间" width="100" prop="receivingGoodDonationTime">
        </el-table-column>
        <el-table-column align="center" label="联系人" width="100">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>电话: {{ scope.row.receivingGoodDonationTel }}</p>
              <p>邮箱: {{ scope.row.receivingGoodDonationMail }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.receivingGoodDonationContact }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="受助物品" width="200">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>单位: {{ scope.row.donationGoods.donationGoodUnit }}</p>
              <p>型号: {{ scope.row.donationGoods.donationGoodModel }}</p>
              <p>数量: {{ scope.row.donationGoods.donationGoodCount }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.donationGoods.donationGood }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="数量" width="100" prop="receivingGoodDonationGoodCount">
        </el-table-column>
        <el-table-column align="center" label="总价值" width="100" prop="receivingGoodDonationGoodTotalValue">
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
                <el-input v-model="editSelectRow.receivingGoodDonationCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="接收时间:" label-width="100px">
                <el-input v-model="editSelectRow.receivingGoodDonationTime" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" label-width="100px">
                <el-input v-model="editSelectRow.receivingGoodDonationAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" label-width="100px">
                <el-input v-model="editSelectRow.receivingGoodDonationContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" label-width="100px">
                <el-input v-model="editSelectRow.receivingGoodDonationTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" label-width="100px">
                <el-input v-model="editSelectRow.receivingGoodDonationMail"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="资助物品:" label-width="100px">
                <el-input v-model="editSelectRow.donationGoods.donationGood" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="规格型号:" label-width="100px">
                <el-input v-model="editSelectRow.donationGoods.donationGoodModel" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位:" label-width="100px">
                <el-input v-model="editSelectRow.donationGoods.donationGoodUnit" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple" :disabled="true">
              <el-form-item label="总价值:" label-width="100px">
                <el-input v-model="editSelectRow.receivingGoodDonationGoodTotalValue" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="其他说明:" label-width="100px">
                <el-input type="textarea" :rows="3" placeholder="请输入内容"
                  v-model="editSelectRow.receivingGoodDonationOtherExplain">
                </el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="接收数量:">
                <el-input v-model="editSelectRow.receivingGoodDonationGoodCount" :disabled="true"></el-input>
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
      <el-form ref="addRow" :model="addRow" label-width="80px">
        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="受助单位:" label-width="100px">
                <el-input v-model="addRow.receivingGoodDonationCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="18">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" label-width="100px">
                <el-input v-model="addRow.receivingGoodDonationAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" label-width="100px">
                <el-input v-model="addRow.receivingGoodDonationContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" label-width="100px">
                <el-input v-model="addRow.receivingGoodDonationTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" label-width="100px">
                <el-input v-model="addRow.receivingGoodDonationMail"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="资助物品:" label-width="100px">
                <el-select v-model="value" placeholder="请选择">
                  <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="规格型号:" label-width="100px">
                <el-input v-model="value.donationGoodModel" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位:" label-width="100px">
                <el-input v-model="value.donationGoodUnit" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple" :disabled="true">
              <el-form-item label="剩余数量:" label-width="100px">
                <el-input v-model="value.donationGoodSurplusCount" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="其他说明:" label-width="100px">
                <el-input type="textarea" :rows="3" placeholder="请输入内容"
                  v-model="addRow.receivingGoodDonationOtherExplain">
                </el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="接收数量:">
                <el-input v-model="addRow.receivingGoodDonationGoodCount" oninput="value=value.replace(/[^\d]/g,'')">
                </el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple" :disabled="true">
              <el-form-item label="总价值:" label-width="100px">
                <el-input v-model="addRow.receivingGoodDonationGoodTotalValue"
                  oninput="value=value.replace(/[^\d]/g,'')"></el-input>
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
        options: [],
        value: {},
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
      this.goodList();
    },
    methods: {
      goodList: function () {
        this.$ajax.get('donation/good/all').then((res) => {
          var array = res.data;
          for (var i = 0; i < array.length; i++) {
            array[i].label = array[i].donationGood + "(" + array[i].donationCompany + ")";
            array[i].value = array[i];
          }
          this.options = array;
        })
      },
      list: function () {
        this.$ajax.get('receiving/good/donation/list', {
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
                "receiving/good/donation/add/or/update",
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
        this.addRow.donationId = this.value.donationId;
        if (this.addRow.receivingGoodDonationGoodCount > this.value.donationGoodSurplusCount) {
          this.$message({
            type: 'info',
            message: "库存不足，无法外借！"
          });
          return;
        }
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
                "receiving/good/donation/add/or/update",
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
            "receiving/good/donation/delete", {
            params: {
              "receivingGoodDonationId": row.receivingGoodDonationId,
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