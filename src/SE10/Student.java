package SE10;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Student {

    public String name;
    public int id;
    public String lastname;
    public int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return id;
    }

    private String query;
    private Connection connection;

    public Student(Connection connection) {
        this.connection = connection;
    }


    public List<String> select(int age) {
        List<String> lastNames = new ArrayList<String>();
        query = "SELECT name FROM Students.student WHERE age=" + "'" + age + "'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                lastNames.add(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lastNames;
    }

   /* public List<Student> selectAll() {
        query = "SELECT * FROM Students.student";
        List<Student> students = new ArrayList<Student>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
                        resultSet.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;*/
   // }


    public void insert(Student student) {
        query = "INSERT INTO Students.student(id, name, lastname, age) VALUES(?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getLastname());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTable(String tableName) {
        query = "DROP TABLE Students."+tableName;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}