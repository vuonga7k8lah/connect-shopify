package com.wiloke.corecommon.utils;

import java.util.List;

public class RoleUtil {
    public static final String SUPPER_ADMIN = "SUPPER_ADMIN";
    public static final String ADMIN_GLOBAL = "ADMIN_GLOBAL";
    public static final String SUPPORT_GLOBAL = "SUPPORT_GLOBAL";
    public static final String DEV_PRIVATE = "DEV_PRIVATE";
    public static final String USER_PRIVATE = "USER_PRIVATE";

    public static final String ADMIN_OR_SUPPER_ADMIN = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.SUPPER_ADMIN;
    public static final String ADMIN_OR_SUPPER_ADMIN_OR_SUPPORT_GLOBAL = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.SUPPER_ADMIN + "','" + RoleUtil.SUPPORT_GLOBAL;
//    public static final String ADMIN_OR_SUPPER_ADMIN_OR_SUPPORT_GLOBAL_USER = RoleUtil.USER_PRIVATE + "','" + RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.SUPPER_ADMIN + "','" + RoleUtil.SUPPORT_GLOBAL;
    public static final String ADMIN_OR_SUPPORT = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.SUPPORT_GLOBAL;
    public static final String ADMIN_OR_DEV = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.DEV_PRIVATE;
    public static final String ADMIN_OR_USER = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.USER_PRIVATE;
    public static final String ADMIN_OR_DEV_OR_USER = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.DEV_PRIVATE + "','" + RoleUtil.USER_PRIVATE;
    public static final String ADMIN_OR_SUPPORT_OR_USER = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.SUPPORT_GLOBAL + "','" + RoleUtil.USER_PRIVATE;
    public static final String ADMIN_OR_SUPPORT_OR_DEV = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.SUPPORT_GLOBAL + "','" + RoleUtil.DEV_PRIVATE;
    public static final String ALL = RoleUtil.ADMIN_GLOBAL + "','" + RoleUtil.SUPPORT_GLOBAL + "','" + RoleUtil.DEV_PRIVATE + "','" + RoleUtil.USER_PRIVATE;

    public static List<String> getRoles() {
        return List.of(RoleUtil.ADMIN_GLOBAL, RoleUtil.SUPPORT_GLOBAL, RoleUtil.DEV_PRIVATE, RoleUtil.USER_PRIVATE);
    }
}
