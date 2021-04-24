<template>

  <el-card class="box-card">

    <div slot="header" class="clearfix">
      <el-page-header @back="goBack" content="捐赠详情">
      </el-page-header>
      <el-button style="float: right; padding: 3px 0" type="text" v-print="'#printInner'">点击打印</el-button>
    </div>

    <div>
      <body lang=ZH-CN link=blue vlink=purple style='tab-interval:21.0pt;text-justify-trim:
      punctuation'>
      <div id="printInner" class=WordSection1 style='layout-grid:15.6pt'>
      <p class=MsoNormal align=center style='margin-top:7.8pt;margin-right:0cm;
      margin-bottom:7.8pt;margin-left:0cm;text-align:center;text-indent:0cm;
      mso-char-indent-count:0'><span style='font-size:16.0pt;line-height:150%;
      font-family:黑体'>上海市红十字会接收社会物资捐赠函<span lang=EN-US>(</span>数据库作业专用<span
      lang=EN-US>)</span></span></p>
      
      <table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0 width="100%"
       style='width:100.0%;border-collapse:collapse;border:none;mso-border-alt:solid windowtext .5pt;
       mso-yfti-tbllook:1184;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
       <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes;height:66.1pt'>
        <td width="100%" colspan=8 valign=top style='width:100.0%;border:solid windowtext 1.0pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:66.1pt'>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span style='font-size:10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:
        minor-fareast;mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>捐赠单位名称<span
        lang=EN-US>(</span>盖章<span lang=EN-US>)</span>：<span lang=EN-US></span></span></p>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationCompany }}<span
        lang=EN-US></span></span></p>
        <p class=MsoNormal align=right style='margin:0cm;text-align:right;text-indent:
        325.5pt;mso-char-indent-count:31.0'><span lang=EN-US style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'></span><span
        style='font-size:10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:
        minor-fareast;mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationTime }}<span lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:1'>
        <td width="29%" colspan=3 valign=top style='width:29.58%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>捐赠者通讯地址<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="70%" colspan=5 valign=top style='width:70.42%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationAdd }}<span lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:2;height:23.45pt'>
        <td width="12%" valign=top style='width:12.9%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt;height:23.45pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>联系人<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="16%" colspan=2 valign=top style='width:16.68%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:23.45pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationContact }}<span
        lang=EN-US></span></span></p>
        </td>
        <td width="9%" valign=top style='width:9.98%;border-top:none;border-left:
        none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:23.45pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>电话<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="19%" colspan=2 valign=top style='width:19.96%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:23.45pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span lang=EN-US style='font-size:
        10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationTel }}</span></p>
        </td>
        <td width="9%" valign=top style='width:9.96%;border-top:none;border-left:
        none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:23.45pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>邮箱<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="30%" valign=top style='width:30.52%;border-top:none;border-left:
        none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:23.45pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span lang=EN-US style='font-size:
        10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'><a
        href="mailto:1579587634@qq.com">{{ row.donationMail }}</a></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:3'>
        <td width="100%" colspan=8 valign=top style='width:100.0%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span style='font-size:10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:
        minor-fareast;mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>物资名称：<span
        lang=EN-US></span></span></p>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationGood }}<span lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:4'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>规格<span
        lang=EN-US>/</span>型号<span lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span lang=EN-US style='font-size:
        10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationGoodModel }}</span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:5'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>单位<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationGoodUnit }}<span
        lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:6'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>单价<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span lang=EN-US style='font-size:
        10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationGoodUnit }}</span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:7'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>数量<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span lang=EN-US style='font-size:
        10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationGoodCount }}</span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:8'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>总价值<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span lang=EN-US style='font-size:
        10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationGoodTotalValue }}</span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:9'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>用途<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationPurposeName }}<span
        lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:10'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>分类<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationTypeName }}<span
        lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:11'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>是否对外保密<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationIsSecrecyName }}<span
        lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:12'>
        <td width="19%" colspan=2 valign=top style='width:19.6%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>是否大金额<span
        lang=EN-US>:</span></span></p>
        </td>
        <td width="80%" colspan=6 valign=top style='width:80.4%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=center style='margin:0cm;text-align:center;
        text-indent:0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;
        line-height:150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;
        mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationIsLargeMoneyName }}<span
        lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:13'>
        <td width="100%" colspan=8 valign=top style='width:100.0%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt'>
        <p class=MsoNormal align=left style='margin:0cm;text-align:left;text-indent:
        0cm;mso-char-indent-count:0'><span style='font-size:10.5pt;line-height:150%;
        font-family:宋体;mso-ascii-theme-font:minor-fareast;mso-fareast-theme-font:
        minor-fareast;mso-hansi-theme-font:minor-fareast'>备注：物资质量、安全性由捐赠者负责并提供相关证明：食品保质期或有效期须在半年以上；药品保质期需要在九个月以上，价格按照出厂价或者批发价计算。<span
        lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:14;height:55.9pt'>
        <td width="100%" colspan=8 valign=top style='width:100.0%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt;height:55.9pt'>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span style='font-size:10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:
        minor-fareast;mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>其他需要说明的事宜：<span
        lang=EN-US></span></span></p>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span style='font-size:10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:
        minor-fareast;mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>{{ row.donationOtherExplain }}<span
        lang=EN-US></span></span></p>
        </td>
       </tr>
       <tr style='mso-yfti-irow:15;mso-yfti-lastrow:yes;height:63.05pt'>
        <td width="47%" colspan=5 valign=top style='width:47.84%;border:solid windowtext 1.0pt;
        border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
        padding:0cm 5.4pt 0cm 5.4pt;height:63.05pt'>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span style='font-size:10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:
        minor-fareast;mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>红十字接收人签名<span
        lang=EN-US>(</span>盖章<span lang=EN-US>)</span>：<span lang=EN-US></span></span></p>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span lang=EN-US style='font-size:10.5pt;line-height:150%;font-family:
        宋体;mso-ascii-theme-font:minor-fareast;mso-fareast-theme-font:minor-fareast;
        mso-hansi-theme-font:minor-fareast'>&nbsp;</span></p>
        </td>
        <td width="52%" colspan=3 valign=top style='width:52.16%;border-top:none;
        border-left:none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
        mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
        mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt;height:63.05pt'>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span style='font-size:10.5pt;line-height:150%;font-family:宋体;mso-ascii-theme-font:
        minor-fareast;mso-fareast-theme-font:minor-fareast;mso-hansi-theme-font:minor-fareast'>捐赠单位<span
        lang=EN-US>(</span>个人<span lang=EN-US>)</span>签名：<span lang=EN-US></span></span></p>
        <p class=MsoNormal style='margin:0cm;text-indent:0cm;mso-char-indent-count:
        0'><span lang=EN-US style='font-size:10.5pt;line-height:150%;font-family:
        宋体;mso-ascii-theme-font:minor-fareast;mso-fareast-theme-font:minor-fareast;
        mso-hansi-theme-font:minor-fareast'>&nbsp;</span></p>
        </td>
       </tr>
       <![if !supportMisalignedColumns]>
       <tr height=0>
        <td width=71 style='border:none'></td>
        <td width=37 style='border:none'></td>
        <td width=55 style='border:none'></td>
        <td width=55 style='border:none'></td>
        <td width=46 style='border:none'></td>
        <td width=65 style='border:none'></td>
        <td width=55 style='border:none'></td>
        <td width=169 style='border:none'></td>
       </tr>
       <![endif]>
      </table>
      <p class=MsoNormal style='margin-top:7.8pt;margin-right:0cm;margin-bottom:7.8pt;
      margin-left:0cm;text-indent:21.0pt'><span style='font-size:10.5pt;line-height:
      150%;font-family:宋体;mso-ascii-theme-font:minor-fareast;mso-fareast-theme-font:
      minor-fareast;mso-hansi-theme-font:minor-fareast'>注：<span style='color:#333333;
      background:white'>各类捐赠物资均要求在保质期内，正规企业产品，符合国家各项质量标准，外包装完好，无污损，且限于以下品种：<span
      lang=EN-US>N95</span>口罩（有注册证，无阀门）、防护服（连体带鞋套）、一次性医院外科口罩、防护面罩、护目镜、<span
      lang=EN-US>84</span>消毒液、一次性消毒床罩、一次性普通口罩、一次性医用帽、一次性使用手术衣、医用手套等。</span><span
      lang=EN-US></span></span></p>
      </div>
      </body>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'donationGoodInfo',
  data () {
    return {
      row: {

      }
    }
  },
  mounted() {
    this.row = this.$route.params;
  },
  methods: {
    goBack:function(){
      // 路由跳转到上一级;
      this.$router.push({ name: 'donationGood'});
    }
  },
}
</script>

<style  scoped>
  body{
    background-color: #fff;
  }
  .WordSection1{
    background-color: #fff;
  }
</style>
