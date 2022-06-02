import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Current-Root-Password");
			s = c.createStatement();
			r = s.executeQuery("select * from employee");
			while (r.next()) {
				pw.print("<br>" + r.getString("empl_id") + "," + r.getString("id") + ": :" + r.getString("empl_name")
						+ ": :" + r.getString("phone_number") + ": :" + r.getString("place") + ": :"
						+ r.getString("role"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}