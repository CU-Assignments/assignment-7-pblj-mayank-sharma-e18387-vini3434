<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Attendance</title>
</head>
<body>
    <h2>Enter Attendance</h2>
    <form action="AttendanceServlet" method="POST">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required><br><br>
        <label for="attendance">Attendance (Present/Absent):</label>
        <input type="text" id="attendance" name="attendance" required><br><br>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
