import controller.MainController;
import to.Item;
import to.User;
import view.entities.ViewItem;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 2/2/2017.
 */
@WebServlet(name="DispatcherServlet", urlPatterns = {"/welcome","/login","/logout","/registration", "/editItem", "/showItems", "/showMyItems", "/register", "/edit", "/makeBid", "/buyItem", "/search"})
public class DispatcherServlet extends HttpServlet {

    private MainController mainController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        mainController=MainController.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getRequestURI());
        String requestURL=req.getRequestURI();
        HttpSession session = req.getSession(true);

        if (requestURL.equals("/login")) {

            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);

        } else if (requestURL.equals("/registration")) {

            req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);

        } else if (requestURL.equals("/editItem")) {

            Item item = mainController.getItemById(req);
            if (item != null) {
                req.setAttribute("item", item);
            }
            req.getRequestDispatcher("WEB-INF/jsp/editItem.jsp").forward(req, resp);

        } else if (requestURL.equals("/showItems")) {

            ArrayList<ViewItem>items=mainController.getViewItems();
            req.setAttribute("items", items);
            req.getRequestDispatcher("WEB-INF/jsp/showItems.jsp").forward(req, resp);

        } else if (requestURL.equals("/showMyItems")) {

            req.getRequestDispatcher("WEB-INF/jsp/showMyItems.jsp").forward(req, resp);

        } else if(requestURL.equals("/search")) {

            System.out.println(req.getParameterMap());
            System.out.println(req.getParameter("keyWord"));
            System.out.println(req.getParameter("field"));
            ArrayList<ViewItem>items=mainController.getViewItemsBySubstr(req);
            req.setAttribute("items", items);
            req.getRequestDispatcher("WEB-INF/jsp/showItems.jsp").forward(req, resp);

        } else {

            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getRequestURI()+" POST");
        String requestURL=req.getRequestURI();
        HttpSession session=req.getSession(true);

        if(requestURL.equals("/logout")){

            session.removeAttribute("user");
            resp.sendRedirect("/login");

        } else if(requestURL.equals("/register")){

            if(mainController.isLogin(req)){
                req.setAttribute("error","Such login already exist");
                req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);
            } else {
                User user=mainController.register(req,resp);
                session.setAttribute("user",user);
                resp.sendRedirect("/login");
            }

        } else if(requestURL.equals("/edit")){

            System.out.println(req.getParameterMap());
            System.out.println(req.getParameter("itemId"));
            if(req.getParameter("itemId").isEmpty()){
                mainController.createItem(req,session);
            } else {
                mainController.updateItem(req,session);
            }

            resp.sendRedirect("/showItems");
        } else if(requestURL.equals("/makeBid")){

            mainController.makeBid(req,session);
            resp.sendRedirect("/showItems");

        } else if(requestURL.equals("/buyItem")){

            mainController.buyItem(req,session);
            resp.sendRedirect("/showItems");
        }
    }
}
