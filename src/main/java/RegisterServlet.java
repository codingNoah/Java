import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws IOException, ServletException{
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		DBconfig config = new DBconfig();
		try {
			Connection connection = config.returnConnection();
			String createUserSQL = "insert into users (name, password, email) values (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(createUserSQL);
			preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            int affectedRows = preparedStatement.executeUpdate();
            
            res.sendRedirect("Confirmation.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
