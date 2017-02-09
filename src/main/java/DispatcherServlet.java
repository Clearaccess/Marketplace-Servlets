import to.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Aleksandr_Vaniukov on 2/2/2017.
 */
@WebServlet(name="DispatcherServlet", urlPatterns = {"/welcome","/login","/logout","/registration", "/editItem", "/showItems", "/showMyItems"})
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getRequestURI());
        String requestURL=req.getRequestURI();
        HttpSession session = req.getSession(true);
        session.removeAttribute("noauth");
        if (requestURL.equals("/welcome")) {
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
        } else if (requestURL.equals("/login")) {
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
        } else if (requestURL.equals("/registration")) {
            req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);
        } else if (requestURL.equals("/editItem") && session.getAttribute("user")!=null) {
            req.getRequestDispatcher("WEB-INF/jsp/editItem.jsp").forward(req, resp);

        } else if (requestURL.equals("/showItems")) {
            req.getRequestDispatcher("WEB-INF/jsp/showItems.jsp").forward(req, resp);

        } else if (requestURL.equals("/showMyItems") && session.getAttribute("user")!=null) {
            req.getRequestDispatcher("WEB-INF/jsp/showMyItems.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        String requestURL=req.getRequestURI();
        HttpSession session=req.getSession(true);
        if (requestURL.equals("/login")) {
            //Login and password are in DataBase
            if(isAutorisation(req)){
                session.setAttribute("user",new User(1,"ADMIN","adr1","admin","admin"));
                req.getRequestDispatcher("WEB-INF/jsp/showItems.jsp").forward(req, resp);
                System.out.println("Success");
            } else{
                session.setAttribute("noauth","No exist such login or password");
                req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
            }
        } else if(requestURL.equals("/logout")){
            session.removeAttribute("user");
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
        }
    }

    protected boolean isAutorisation(HttpServletRequest request){
        return request.getParameter("login").equals("admin") && request.getParameter("password").equals("admin");
    }
}
