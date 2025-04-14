import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("studentId");
        String attendance = request.getParameter("attendance");

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "user", "password");
            String sql = "INSERT INTO attendance (student_id, attendance_status) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studentId);
            stmt.setString(2, attendance);
            stmt.executeUpdate();

            response.sendRedirect("attendance-success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
