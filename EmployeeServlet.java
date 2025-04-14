import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");
        List<Employee> employees = new ArrayList<>();

        try {
            // Connect to database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password");

            // Query database
            String sql = "SELECT * FROM employees WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, empId);
            ResultSet rs = stmt.executeQuery();

            // Process results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String email = rs.getString("email");
                employees.add(new Employee(id, name, department, email));
            }

            // Set employees as request attribute
            request.setAttribute("employees", employees);
            RequestDispatcher dispatcher = request.getRequestDispatcher("employeeList.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
