//package book.manage.config.shiro;
//
//import UserInfo;
//import UserInfoService;
//import org.apache.catalina.User;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author: TMingYi
// * @date: 2020/6/20 11:23
// */
//public class MyRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        // 获取用户名
//        String userNum = (String) principalCollection.getPrimaryPrincipal();
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        // 给该用户设置角色，角色信息存在 t_role 表中取
//        authorizationInfo.setRoles(userInfoService.getRoles(userNum));
//        // 给该用户设置权限，权限信息存在 t_permission 表中取
//        authorizationInfo.setStringPermissions(userInfoService.getPermissions(userNum));
//        return authorizationInfo;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        // 根据 Token 获取用户名，如果您不知道该 Token 怎么来的，先可以不管，下文会解释
//        String userNum = (String) authenticationToken.getPrincipal();
//        // 根据用户名从数据库中查询该用户
//        UserInfo user = userInfoService.getUserByNum(userNum);
//        if(user != null) {
//            // 把当前用户存到 Session 中
//            SecurityUtils.getSubject().getSession().setAttribute("user", user);
//            // 传入用户名和密码进行身份认证，并返回认证信息
//            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserNum(), user.getUserPass(), "myRealm");
//            return authcInfo;
//        } else {
//            return null;
//        }
//    }
//}
