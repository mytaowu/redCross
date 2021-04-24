<template>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>捐物详情</el-breadcrumb-item>
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
              <p>住址: {{ scope.row.donationAdd }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.donationCompany }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="捐赠时间" width="100" prop="donationTime">
        </el-table-column>
        <el-table-column align="center" label="联系人" width="100">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>电话: {{ scope.row.donationTel }}</p>
              <p>邮箱: {{ scope.row.donationMail }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.donationContact }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="捐赠物品" width="200">
          <template slot-scope="scope">
            <el-popover trigger="hover" placement="top">
              <p>单位: {{ scope.row.donationGoodUnit }}</p>
              <p>型号: {{ scope.row.donationGoodModel }}</p>
              <p>数量: {{ scope.row.donationGoodCount }}</p>
              <div slot="reference" class="name-wrapper">
                <el-tag size="medium">{{ scope.row.donationGood }}</el-tag>
              </div>
            </el-popover>
          </template>
        </el-table-column>
        <el-table-column align="center" label="总价值" width="100" prop="donationGoodTotalValue">
        </el-table-column>
        <el-table-column align="center" label="库存" width="100" prop="donationGoodSurplusCount">
        </el-table-column>
        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button size="mini" @click="showInfo(scope.$index, scope.row)">查看报表</el-button>
            <el-button size="mini" @click="showSteam(scope.$index, scope.row)">查看流水</el-button>
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
              <el-form-item label="捐赠单位:" prop="donationCompany" label-width="100px">
                <el-input v-model="editSelectRow.donationCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠时间:" label-width="100px">
                <el-input v-model="editSelectRow.donationTime" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" prop="donationAdd" label-width="100px">
                <el-input v-model="editSelectRow.donationAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" prop="donationContact" label-width="100px">
                <el-input v-model="editSelectRow.donationContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" prop="donationTel" label-width="100px">
                <el-input v-model="editSelectRow.donationTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" prop="donationMail" label-width="100px">
                <el-input v-model="editSelectRow.donationMail"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠物品:" label-width="100px">
                <el-input v-model="editSelectRow.donationGood" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="规格型号:" label-width="100px">
                <el-input v-model="editSelectRow.donationGoodModel" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位:" label-width="100px">
                <el-input v-model="editSelectRow.donationGoodUnit" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple" :disabled="true">
              <el-form-item label="总价值:" label-width="100px">
                <el-input v-model="editSelectRow.donationGoodTotalValue" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="用途:" label-width="100px">
                <el-input v-model="editSelectRow.donationPurposeName" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="分类:" label-width="100px">
                <el-input v-model="editSelectRow.donationTypeName" :disabled="true"></el-input>
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
              <el-form-item label="是否大金额:" label-width="100px">
                <el-input v-model="editSelectRow.donationIsLargeMoneyName" :disabled="true"></el-input>
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
              <el-form-item label="捐赠数量:">
                <el-input v-model="editSelectRow.donationGoodCount" :disabled="true"></el-input>
              </el-form-item>
            </div>
          </el-col>

          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="剩余数量:">
                <el-input v-model="editSelectRow.donationGoodSurplusCount" :disabled="true"></el-input>
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
    <el-dialog width="80%" modal="true" title="添加捐赠信息"  :visible.sync="addDialogFormVisible">
      <el-form ref="addRow" :rules="rules" :model="addRow" label-width="80px">
        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠单位:" prop="donationCompany" label-width="100px">
                <el-input v-model="addRow.donationCompany"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="总价值:" label-width="100px" >
                <el-input v-model="addRow.donationGoodTotalValue" oninput = "value=value.replace(/[^\d]/g,'')"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="单位地址:" prop="donationAdd" label-width="100px">
                <el-input v-model="addRow.donationAdd"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="单位联系人:" prop="donationContact" label-width="100px">
                <el-input v-model="addRow.donationContact"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="联系电话:" prop="donationTel" label-width="100px">
                <el-input v-model="addRow.donationTel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="联系人邮箱:" prop="donationMail" label-width="100px">
                <el-input v-model="addRow.donationMail"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="捐赠物品:" label-width="100px"  >
                <el-input v-model="addRow.donationGood"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="规格型号:" label-width="100px"  >
                <el-input v-model="addRow.donationGoodModel"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="物品单位:" label-width="100px"  >
                <el-input v-model="addRow.donationGoodUnit"></el-input>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple">
              <el-form-item label="数量:">
                <el-input v-model="addRow.donationGoodCount" oninput = "value=value.replace(/[^\d]/g,'')"></el-input>
              </el-form-item>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="6">
            <div class="grid-content bg-purple">

              <el-form-item label="物资用途" >
                <el-select v-model="addRow.donationPurposeId" label-width="100px">
                  <el-option label="教育" value="1"></el-option>
                  <el-option label="医疗" value="2"></el-option>
                  <el-option label="抗洪" value="3"></el-option>
                  <el-option label="救灾" value="4"></el-option>
                  <el-option label="其他" value="5"></el-option>
                </el-select>
              </el-form-item>
            </div>
          </el-col>
          <el-col :span="6">
            <div class="grid-content bg-purple" >
              <el-form-item label="物资分类:"  label-width="100px">
                <el-select v-model="addRow.donationTypeId">
                  <el-option label="医用物资" value="1"></el-option>
                  <el-option label="民间捐赠" value="2"></el-option>
                  <el-option label="政府发放" value="3"></el-option>
                  <el-option label="国外资助" value="4"></el-option>
                  <el-option label="其他" value="5"></el-option>
                </el-select>
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
          <el-col :span="6">
            <div class="grid-content bg-purple">
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20">
          <el-col :span="12">
            <div class="grid-content bg-purple">
              <el-form-item label="其他说明:" prop="donationOtherExplain" label-width="100px">
                <el-input type="textarea" :rows="3" placeholder="请输入内容" v-model="addRow.donationOtherExplain">
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


    <!-- 流水信息 -->
    <el-dialog width="70.35%" modal="true" title="捐赠物资流水信息"  :visible.sync="showDialogFormVisible">
        <el-table
        border
        max-height="350"
        :data="showData"
        style="width: 100%">
        <el-table-column
          align="center"
          prop="donationCompany"
          label="捐赠单位"
          width="150">
        </el-table-column>
        <el-table-column
          align="center"
          prop="donationGood"
          label="物品名称"
          width="150">
        </el-table-column>
        <el-table-column
          align="center"
          prop="donationContact"
          label="捐赠联系人"
          width="100">
        </el-table-column>
        <el-table-column
          align="center"
          prop="donationTel"
          label="联系人电话"
          width="120">
        </el-table-column>
        <el-table-column
          align="center"
          prop="receivingGoodDonationCompany"
          label="接收单位"
          width="150">
        </el-table-column>
        <el-table-column
          align="center"
          prop="receivingGoodDonationTime"
          label="接收时间"
          width="100">
        </el-table-column>
        <el-table-column
          align="center"
          prop="receivingGoodDonationContact"
          label="接收联系人"
          width="100">
        </el-table-column>
        <el-table-column
          align="center"
          prop="receivingGoodDonationTel"
          label="电话"
          width="120">
        </el-table-column>
        <el-table-column
          align="center"
          prop="receivingGoodDonationGoodCount"
          label="数量"
          width="50">
        </el-table-column>
      </el-table>

    </el-dialog>
  </el-card>
</template>
<script>
  export default {
    name: 'donationGood',
    data() {
      return {
        tableData: [],
        showData: [],
        total: 0,
        pageNo: 1,
        pageSize: 5,
        keyWord: "",
        editDialogFormVisible: false,
        addDialogFormVisible: false,
        showDialogFormVisible: false,
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
        this.$ajax.get('donation/good/list', {
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

      addRowBtn: function() {
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
                "donation/good/add/or/update",
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

      addSubmitFrom:function(formName){
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
                "donation/good/add/or/update",
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

      showSteam(index, row){
        this.showDialogFormVisible = true;
        this.$ajax.get('donation/good/detail/info', {
          params: {
            "donationId": row.donationId,
          }
        }).then((res)=>{
          console.log(res.data.data);
          this.showData = res.data.data;
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
      handleEdit(index, row) {
        this.editSelectRow = { ...row };
        // 处理一些基础数据;
        DonationGoodUtil.baseDateInvoke(this.editSelectRow);
        this.editDialogFormVisible = true;
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