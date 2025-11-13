import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private static final String URL = "jdbc:mysql://localhost:3306/companydb";
    private static final String USER = "root";
    private static final String PASS = "yourpassword";

    public void addStudent(Student s) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement("INSERT INTO Student VALUES(?,?,?,?)");
        ps.setInt(1, s.getStudentID());
        ps.setString(2, s.getName());
        ps.setString(3, s.getDepartment());
        ps.setDouble(4, s.getMarks());
        ps.executeUpdate();
        con.close();
    }

    public List<Student> getAllStudents() throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Student");
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Student(rs.getInt(1), rs.getString(2),
                                 rs.getString(3), rs.getDouble(4)));
        }
        con.close();
        return list;
    }

    public void updateMarks(int id, double newMarks) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement("UPDATE Student SET Marks=? WHERE StudentID=?");
        ps.setDouble(1, newMarks);
        ps.setInt(2, id);
        ps.executeUpdate();
        con.close();
    }

    public void deleteStudent(int id) throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement ps = con.prepareStatement("DELETE FROM Student WHERE StudentID=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
