import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet   {
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws IOException, ServletException{
	
		HttpSession session = req.getSession();
        session.removeAttribute("name");
        res.sendRedirect("Login.jsp");
	}
}
