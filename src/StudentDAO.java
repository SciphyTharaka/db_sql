import java.sql.*;
import java.util.*;

public class RecordDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/db_students";
    private final String DB_USER = "root";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, "");
    }

    public void addRecord(Record rec) {
        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rec.getFullName());
            ps.setInt(2, rec.getYears());
            ps.setString(3, rec.getMail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Record> getAllRecords() {
        List<Record> data = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = connect();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                data.add(new Record(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void updateRecord(Record rec) {
        String sql = "UPDATE students SET name=?, age=?, email=? WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, rec.getFullName());
            ps.setInt(2, rec.getYears());
            ps.setString(3, rec.getMail());
            ps.setInt(4, rec.getCode());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRecord(int code) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, code);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
