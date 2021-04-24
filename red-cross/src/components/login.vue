<template>
  <div class="main-container">
    <div class="main-content">
      <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
          <div class="login-container">
            <div class="center">
              <h1>
                <span class="white" id="id-text2">红十字信息系统</span>
              </h1>
              <h4 class="blue" id="id-company-text">&copy; 华东师范大学</h4>
            </div>
            <div class="space-6"></div>
            <div class="position-relative">
              <div id="login-box" class="login-box visible widget-box no-border">
                <div class="widget-body">
                  <div class="widget-main">
                    <h4 class="header blue lighter bigger">
                      <i class="ace-icon fa fa-coffee green"></i>
                      请输入你的账号信息
                    </h4>

                    <div class="space-6"></div>

                    <form>
                      <fieldset>
                        <label class="block clearfix">
                          <span class="block input-icon input-icon-right">
                            <input type="text" v-model="adminInfologinName" class="form-control" placeholder="请输入登录名" />
                            <i class="ace-icon fa fa-user"></i>
                          </span>
                        </label>

                        <label class="block clearfix">
                          <span class="block input-icon input-icon-right">
                            <input type="password" v-model="adminInfoPass" class="form-control" placeholder="请输入密码" />
                            <i class="ace-icon fa fa-lock"></i>
                          </span>
                        </label>

                        <div class="space"></div>

                        <div class="clearfix">
                          <label class="inline">
                            <input type="checkbox" class="ace" />
                            <span class="lbl">记住我</span>
                          </label>

                          <button @click="toAdmin()" type="button" class="width-35 pull-right btn btn-sm btn-primary">
                            <i class="ace-icon fa fa-key"></i>
                            <span class="bigger-110">登录</span>
                          </button>
                        </div>
                        <div class="space-4"></div>
                      </fieldset>
                    </form>
                    <div class="space-6"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
        adminInfologinName: "",
        adminInfoPass: ""
      }
    },
    // components: {
    //   HelloWorld
    // }
    //页面渲染之后执行的函数
    mounted: () => {
      $('body').attr('class', 'login-layout light-login');
    },

    methods: {
      toAdmin() {
        if (this.adminInfologinName == null || this.adminInfologinName == undefined || this.adminInfologinName == "") {
          this.$message({
            type: 'info',
            message: '请输入登录名'
          });
          return;
        };
        if (this.adminInfoPass == null || this.adminInfoPass == undefined ||this.adminInfoPass == "") {
          this.$message({
            type: 'info',
            message: '请输入密码'
          });
          return;
        }
        this.$ajax.get("dologin", {
          params: {
            "adminInfologinName": this.adminInfologinName,
            "adminInfoPass": this.adminInfoPass
          }
        }).then((res) => {
          if (res.data.result == "SUCCESS"){
            this.$message({
            type: 'seccess',
            message: '登录成功'
          });
          if (res.data.data == 1) {
            this.$router.push("/admin");
          } else {
            this.$router.push("/normal/admin");
          }
          }else{
            this.$message({
            type: 'info',
            message: res.data.message
          });
          }
          
        }).catch((res) => {
          this.$message({
            type: 'info',
            message: res.data.message
          });
        })
      }
    }
  }
</script>