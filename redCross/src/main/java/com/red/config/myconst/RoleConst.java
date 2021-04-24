package com.red.config.myconst;

//角色常量
public enum RoleConst {

    //数字表示等级
    ROLE_TYPE_TOPADMIN(3),
    ROLE_TYPE_ADMIN(2),
    ROLE_TYPE_USER(1);

    private Integer value;

    private RoleConst(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
