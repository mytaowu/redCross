<template>
  <div class="main-content">
    <div class="main-content-inner">
      <div class="breadcrumbs ace-save-state" id="breadcrumbs">
        <ul class="breadcrumb">
          <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="#">首页</a>
          </li>
          <li class="active">信息展示</li>
        </ul><!-- /.breadcrumb -->
      </div>

      <div class="page-content">
        <div class="ace-settings-container" id="ace-settings-container">
          <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
            <i class="ace-icon fa fa-cog bigger-130"></i>
          </div>
        </div>
        <div class="page-header">
          <h1>
            主页
            <small>
              <i class="ace-icon fa fa-angle-double-right"></i>
              信息一览表
            </small>
          </h1>
        </div><!-- /.page-header -->

        <div class="row">
          <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="alert alert-block alert-success">
              <button type="button" class="close" data-dismiss="alert">
                <i class="ace-icon fa fa-times"></i>
              </button>

              <i class="ace-icon fa fa-check green"></i>

              欢迎来到华东师范大学
              <strong class="green">
                红十字信息管理系统
                <small>(v1.4)</small>
              </strong>,
            </div>

            <div class="row">
              <div class="space-6"></div>

              <div class="col-sm-7 infobox-container">
                <div class="infobox infobox-green">
                  <div class="infobox-icon">
                    <i class="ace-icon fa fa-comments"></i>
                  </div>

                  <div class="infobox-data">
                    <span class="infobox-data-number" style="font-size: 15px;">{{ info.totalDonationGoodsCount }} 次</span>
                    <div class="infobox-content">累计接收捐物</div>
                  </div>

                  <div class="stat stat-success">5%</div>
                </div>

                <div class="infobox infobox-blue">
                  <div class="infobox-icon">
                    <i class="ace-icon fa fa-twitter"></i>
                  </div>

                  <div class="infobox-data">
                    <span class="infobox-data-number" style="font-size: 15px;">{{ info.totalDonationGoodsMoney }} 元</span>
                    <div class="infobox-content">累计接收物品总金额</div>
                  </div>

                  <div class="badge badge-success">
                    +32%
                    <i class="ace-icon fa fa-arrow-up"></i>
                  </div>
                </div>

                <div class="infobox infobox-pink">
                  <div class="infobox-icon">
                    <i class="ace-icon fa fa-shopping-cart"></i>
                  </div>

                  <div class="infobox-data">
                    <span class="infobox-data-number" style="font-size: 15px;">{{ info.totalDonationMoney }}  元</span>
                    <div class="infobox-content">累计接收捐款</div>
                  </div>
                  <div class="stat stat-important">4%</div>
                </div>

                <div class="infobox infobox-red">
                  <div class="infobox-icon">
                    <i class="ace-icon fa fa-flask"></i>
                  </div>

                  <div class="infobox-data">
                    <span class="infobox-data-number" style="font-size: 15px;">{{ info.totalReceivingDonationGoodsCount }} 家</span>
                    <div class="infobox-content">累计资助物品单位</div>
                  </div>
                </div>

                <div class="infobox infobox-orange2">
                  <div class="infobox-chart">
                    <span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"></span>
                  </div>

                  <div class="infobox-data">
                    <span class="infobox-data-number" style="font-size: 15px;">{{ info.totalRecevingDonationMoneyCount }} 家</span>
                    <div class="infobox-content">累计捐款单位</div>
                  </div>

                  <div class="badge badge-success">
                    7.2%
                    <i class="ace-icon fa fa-arrow-up"></i>
                  </div>
                </div>

                <div class="infobox infobox-blue2">
                  <div class="infobox-progress">
                    <div class="easy-pie-chart percentage" data-percent="42" data-size="46">
                      <span class="percent">42</span>%
                    </div>
                  </div>

                  <div class="infobox-data">
                    <span class="infobox-text" style="font-size: 15px;">{{ info.totalMoney }} 元</span>

                    <div class="infobox-content">
                      <span class="bigger-110">现存资金</span>
                    </div>
                  </div>
                </div>

              </div>

              <div class="vspace-12-sm"></div>

              <div class="col-sm-5">
                <div class="widget-box">
                  <div class="widget-header widget-header-flat widget-header-small">
                    <h5 class="widget-title">
                      <i class="ace-icon fa fa-signal"></i>
                      Traffic Sources
                    </h5>

                    <div class="widget-toolbar no-border">
                      <div class="inline dropdown-hover">
                        <button class="btn btn-minier btn-primary">
                          This Week
                          <i class="ace-icon fa fa-angle-down icon-on-right bigger-110"></i>
                        </button>

                        <ul class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret">
                          <li class="active">
                            <a href="#" class="blue">
                              <i class="ace-icon fa fa-caret-right bigger-110">&nbsp;</i>
                              This Week
                            </a>
                          </li>

                          <li>
                            <a href="#">
                              <i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
                              Last Week
                            </a>
                          </li>

                          <li>
                            <a href="#">
                              <i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
                              This Month
                            </a>
                          </li>

                          <li>
                            <a href="#">
                              <i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
                              Last Month
                            </a>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>

                  <div class="widget-body">
                    <div class="widget-main">
                      <div id="piechart-placeholder"></div>

                      <div class="hr hr8 hr-double"></div>

                      <div class="clearfix">
                        <div class="grid3">
                          <span class="grey">
                            <i class="ace-icon fa fa-facebook-square fa-2x blue"></i>
                            &nbsp; likes
                          </span>
                          <h4 class="bigger pull-right">1,255</h4>
                        </div>

                        <div class="grid3">
                          <span class="grey">
                            <i class="ace-icon fa fa-twitter-square fa-2x purple"></i>
                            &nbsp; tweets
                          </span>
                          <h4 class="bigger pull-right">941</h4>
                        </div>

                        <div class="grid3">
                          <span class="grey">
                            <i class="ace-icon fa fa-pinterest-square fa-2x red"></i>
                            &nbsp; pins
                          </span>
                          <h4 class="bigger pull-right">1,050</h4>
                        </div>
                      </div>
                    </div><!-- /.widget-main -->
                  </div><!-- /.widget-body -->
                </div><!-- /.widget-box -->
              </div><!-- /.col -->
            </div><!-- /.row -->
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.page-content -->
    </div>
  </div><!-- /.main-content -->
</template>

<script>
export default {
  name: "adminMian",
  data () {
    return {
      info:{}
    }
  },
  mounted() {
    this.$ajax.get('getInfo').then(res=>{
      console.log(res);
      this.info = res.data;
    })
  }
}
</script>

<style  scoped>

</style>
