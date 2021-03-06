package com.example.demo.util;

import com.example.demo.model.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;


public class ShiroUtils {

    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static UserInfo getUser() {
        Object object = getSubject().getPrincipal();
        return (UserInfo) object;
    }

    public static Long getUserId() {
        return getUser().getUid();
    }

    public static void logout() {
        getSubject().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }

}
