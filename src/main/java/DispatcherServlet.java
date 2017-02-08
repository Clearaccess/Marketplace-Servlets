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
@WebServlet(name="DispatcherServlet", urlPatterns = {"/", "/login", "/registration", "/editItem", "/showItems", "/showMyItems"})
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(true);
        if(session.getAttribute("user")==null){
            System.out.println("User no log in");
        } else {
            System.out.println("User is log in");
        }
        System.out.println(req.getRequestURI());
        String requestURL=req.getRequestURI();
        if (requestURL.equals("/")) {
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);

        } else if (requestURL.equals("/login")) {
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);

        } else if (requestURL.equals("/registration")) {
            req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);

        } else if (requestURL.equals("/editItem")) {
            req.getRequestDispatcher("WEB-INF/jsp/editItem.jsp").forward(req, resp);

        } else if (requestURL.equals("/showItems")) {
            req.getRequestDispatcher("WEB-INF/jsp/showItems.jsp").forward(req, resp);

        } else if (requestURL.equals("/showMyItems")) {
            req.getRequestDispatcher("WEB-INF/jsp/showMyItems.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        String requestURL=req.getRequestURI();
        if (requestURL.equals("/login")) {
            req.getRequestDispatcher("WEB-INF/jsp/showItems.jsp").forward(req, resp);
        }
    }
}
