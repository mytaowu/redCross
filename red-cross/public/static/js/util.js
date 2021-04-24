DonationGoodUtil = {
  baseDateInvoke: function (row) {
    if (row.donationPurposeId == 1){
      row.donationPurposeName = "教育";
    }else if (row.donationPurposeId == 2){
      row.donationPurposeName = "医疗";
    }else if (row.donationPurposeId == 3){
      row.donationPurposeName = "抗洪";
    }else if (row.donationPurposeId == 4){
      row.donationPurposeName = "救灾";
    }else{
      row.donationPurposeName = "其他";

    }
    if (row.donationTypeId == 1){
      row.donationTypeName = "医用物资";
    }else if (row.donationTypeId == 2){
      row.donationTypeName = "民间捐赠";
    }else if (row.donationTypeId == 3){
      row.donationTypeName = "政府发放";
    }else if (row.donationTypeId == 4){
      row.donationTypeName = "国外资助";
    }else{
      row.donationTypeName = "其他";

    }
    this.baseMoneyDateInvoke(row);
  },
  baseMoneyDateInvoke: function (row) {
    if (row.donationIsSecrecy == 1){
      row.donationIsSecrecyName = "保密";
    }else{
      row.donationIsSecrecyName = "公开";
    }

    if (row.donationIsLargeMoney == 1){
      row.donationIsLargeMoneyName = "大金额";
    }else{
      row.donationIsLargeMoneyName = "普通金额";
    }
  }
};