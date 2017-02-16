package filters;

import controller.MainController;
import to.User;
import view.entities.ViewItem;

import javax.jms.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 2/10/2017.
 */
@WebFilter(servletNames = {"DispatcherServlet"})
public class AccessFilter implements Filter {

    private MainController mainController;

    public void init(FilterConfig filterConfig) throws ServletException {
        mainController=MainController.getInstance();
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session=request.getSession(true);
        String requestURL=request.getRequestURI();
        String requestMethod=request.getMethod();

        //Attempt authorize
        if(requestURL.equals("/login") && requestMethod.equals("POST")){
            if(isAuthorize(request)){
                String login=request.getParameter("login");
                session.setAttribute("user", mainController.getUserByLogin(login));
                response.sendRedirect("/showItems");
            } else {
                request.setAttribute("error","No exist such login or password");
                request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(servletRequest,servletResponse);
            }
        } else {
            //Attempt access to pages when no authorize user
            if(session.getAttribute("user")==null && (requestURL.equals("/editItem") || requestURL.equals("/showMyItems"))){
                response.sendRedirect("/login");
            } else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    public void destroy() {

    }

    protected boolean isAuthorize(HttpServletRequest request){
        String login=request.getParameter("login").toLowerCase();
        String password=request.getParameter("password").toLowerCase();

        return mainController.isLogin(request) && mainController.isRegister(login,password);
    }
}
