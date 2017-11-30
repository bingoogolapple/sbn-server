package cn.bingoogolapple.sbn.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebUtil {

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获得 request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    /**
     * 获得 response
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

    /**
     * 获取 session
     *
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取 application
     *
     * @return
     */
    public static ServletContext getApplication() {
        return getRequest().getServletContext();
    }

    /**
     * 向 request 作用域添加一个属性
     *
     * @param name
     * @param value
     */
    public static void requestPut(String name, Object value) {
        getRequest().setAttribute(name, value);
    }

    /**
     * 从 request 作用域获取一个属性
     *
     * @param name
     * @return
     */
    public static Object requestGet(String name) {
        return getRequest().getAttribute(name);
    }

    /**
     * 向 session 作用域添加一个属性
     *
     * @param name
     * @param value
     */
    public static void sessionPut(String name, Object value) {
        getSession().setAttribute(name, value);
    }

    /**
     * 向 session 作用域删除一个属性
     *
     * @param name
     */
    public static void sessionRemove(String name) {
        getSession().removeAttribute(name);
    }

    /**
     * 从 session 作用域获取一个属性
     *
     * @param name
     * @return
     */
    public static Object sessionGet(String name) {
        return getSession().getAttribute(name);
    }

    /**
     * 向 application 作用域添加一个属性
     *
     * @param name
     * @param value
     */
    public static void applicationPut(String name, Object value) {
        getApplication().setAttribute(name, value);
    }

    /**
     * 从 application 作用域获取一个属性
     *
     * @param name
     * @return
     */
    public static Object applicationGet(String name) {
        return getApplication().getAttribute(name);
    }
}