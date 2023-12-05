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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet  {
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws IOException, ServletException{
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		DBconfig config = new DBconfig();
		try {
			Connection connection = config.returnConnection();
			String getUserSQL = "select * from users where name=? and password=?"; 
//			(name, password, email) values (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(getUserSQL);
			preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            
            ResultSet result = preparedStatement.executeQuery();
            int count = 0;
			while(result.next()) {
				count ++;
			}
			
			if(count != 0) {
				ResultSet result2 = preparedStatement.executeQuery();
				result2.next();
				String name2 = result2.getString("name");
				HttpSession session = req.getSession();
		        session.setAttribute("name", name2);
				res.sendRedirect("index.jsp");
			}else {
				res.sendRedirect("LoginFailed.jsp");
			}
            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
