<template>
  <div>
    <div id="navbar" class="navbar navbar-default          ace-save-state">
        <div class="navbar-container ace-save-state" id="navbar-container">
            <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                <span class="sr-only">Toggle sidebar</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <div class="navbar-header pull-left">
                <a href="index.html" class="navbar-brand">
                    <small>
                        <i class="fa fa-leaf"></i>
                        红十字信息平台
                    </small>
                </a>
            </div>
        </div><!-- /.navbar-container -->
    </div>

    <div class="main-container ace-save-state" id="main-container">
        <div id="sidebar" class="sidebar responsive ace-save-state">
            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="ace-icon fa fa-signal"></i>
                    </button>

                    <button class="btn btn-info">
                        <i class="ace-icon fa fa-pencil"></i>
                    </button>

                    <button class="btn btn-warning">
                        <i class="ace-icon fa fa-users"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="ace-icon fa fa-cogs"></i>
                    </button>
                </div>

                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>
                    <span class="btn btn-info"></span>
                    <span class="btn btn-warning"></span>
                    <span class="btn btn-danger"></span>
                </div>
            </div><!-- /.sidebar-shortcuts -->

            <ul class="nav nav-list">
                <li class="">
                    <!-- 在vue中使用router-link来进行我们页面的跳转 -->
                    <router-link to="/admin">
                        <i class="menu-icon fa fa-tachometer"></i>
                        <span class="menu-text"> 欢迎 </span>
                    </router-link>

                    <b class="arrow"></b>
                </li>


                <li class="open optionLi">
                  <a href="#" class="dropdown-toggle">
                      <i class="menu-icon fa fa-desktop"></i>
                      <span class="menu-text">
                          用户信息管理
                      </span>
                      <b class="arrow fa fa-angle-down"></b>
                  </a>

                  <b class="arrow"></b>
                  <ul class="submenu">
                      <li class="">
                        <router-link to="/admin/user/maneger">
                              <i class="menu-icon fa fa-caret-right"></i>
                              管理员信息
                        </router-link>
                      </li>

                      <li class="">
                            <router-link to="/admin/user/prohibit/maneger">
                              <i class="menu-icon fa fa-caret-right"></i>
                              禁用管理员信息
                            </router-link>
                      </li>
                  </ul>
              </li>

                <li class="open optionLi">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-pencil-square-o"></i>
                        <span class="menu-text">
                            捐赠详情
                        </span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>
                    <ul class="submenu open">
                        <li class="">
                          <router-link to="/admin/donation/good">
                                <i class="menu-icon fa fa-caret-right"></i>
                                物品捐赠详情
                          </router-link>
                        </li>

                        <li class="">
                              <router-link to="/admin/donation/money">
                                <i class="menu-icon fa fa-caret-right"></i>
                                捐款详情
                              </router-link>
                        </li>
                    </ul>
                </li>


                <li class="open">
                  <a href="#" class="dropdown-toggle">
                      <i class="menu-icon fa fa-calendar"></i>
                      <span class="menu-text">
                          资助信息详情
                      </span>
                      <b class="arrow fa fa-angle-down"></b>
                  </a>

                  <b class="arrow"></b>
                  <ul class="submenu">
                      <li class="">
                        <router-link to="/admin/receiving/good/donation">
                              <i class="menu-icon fa fa-caret-right"></i>
                              物品资助详情
                        </router-link>
                      </li>

                      <li class="">
                            <router-link to="/admin/receiving/money/donation">
                              <i class="menu-icon fa fa-caret-right"></i>
                              金钱资助详情
                            </router-link>
                      </li>
                  </ul>
              </li>
            </ul><!-- /.nav-list -->

            <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
            </div>
        </div>

        <div class="main-content">
            <div class="main-content-inner">
                <div class="page-content">
                    <div class="row">
                        <div class="col-xs-12">
                            <!-- PAGE CONTENT BEGINS -->
                            <router-view/>
                            <!-- PAGE CONTENT ENDS -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                </div><!-- /.page-content -->
            </div>
        </div><!-- /.main-content -->

        <div class="footer">
            <div class="footer-inner">
                <div class="footer-content">
                    <span class="bigger-120">
                        <span class="blue bolder">红十字信息平台</span>
                         &copy; 2020-2025
                    </span>

                    &nbsp; &nbsp;
                    <span class="action-buttons">
                        <a href="#">
                            <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                        </a>
                        <a href="#">
                            <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                        </a>
                        <a href="#">
                            <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                        </a>
                    </span>
                </div>
            </div>
        </div>
        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
    </div><!-- /.main-container -->
  </div>
</template>
  <script>
  export default {
    name: 'home',
    // components: {
    //   HelloWorld
    // }
    //页面渲染之后执行的函数
    mounted: () => {
        $('body').removeClass('login-layout light-login');
        $('body').attr('class', 'no-skin');
      let _this = this;
      $("body").removeClass("login-layout light-login");
      $("body").attr("class", "no-skin");
      // console.log("admin");
      // sidebar激活样式方法二
      _this.activeSidebar(_this.$route.name.replace("/", "-") + "-sidebar");

      $.getScript('/ace/assets/js/ace.min.js');

      _this.loginUser = Tool.getLoginUser();

      if (!_this.hasResourceRouter(_this.$route.name)) {
        _this.$router.push("/login");
      }
    },

    watch: {
      $route: {
        handler:function(val, oldVal){
          // sidebar激活样式方法二
          console.log("---->页面跳转：", val, oldVal);
          let _this = this;

          if (!_this.hasResourceRouter(val.name)) {
            _this.$router.push("/login");
            return;
          }

          _this.$nextTick(function(){  //页面加载完成后执行
            _this.activeSidebar(_this.$route.name.replace("/", "-") + "-sidebar");
          })
        }
      }
    },
    methods: {
      /**
       * 菜单激活样式，id是当前点击的菜单的id
       * @param id
       */
       activeSidebar: function (id) {
        // 兄弟菜单去掉active样式，自身增加active样式
        $("#" + id).siblings().removeClass("active");
        $("#" + id).siblings().find("li").removeClass("active");
        $("#" + id).addClass("active");

        // 如果有父菜单，父菜单的兄弟菜单去掉open active，父菜单增加open active
        let parentLi = $("#" + id).parents("li");
        if (parentLi) {
          parentLi.siblings().removeClass("open active");
          parentLi.siblings().find("li").removeClass("active");
          parentLi.addClass("open active");
        }
      },
    },
  }
  </script>
  