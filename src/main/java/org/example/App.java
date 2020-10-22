package org.example;

import java.sql.*;
import java.util.List;

public class App {
    public static final String DATABASE_HOST = "jdbc:mysql://localhost:3306/jdbc";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "root";

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        try {
            Connection conn = DriverManager.getConnection(DATABASE_HOST, DATABASE_USERNAME, DATABASE_PASSWORD);
            System.out.println("conexiune ok " + conn.getCatalog());

            System.out.println("Afiseaza departamentele");
            departmentSelect(conn);

            System.out.println("Afiseaza taote proeictele");
            displayAllProjects(conn);

            System.out.println("Afiseaza toti angajatii");
            displayAllEmployees(conn);

            System.out.println("Afiseaza toti angajatii al caror nume incepe cu J");
            displayAllEmployeesWithJ(conn);

            System.out.println("Afiseaza toti angajatii care nu apartin nici unui departament");
            displayAllEmployeesWithNoDept(conn);

            System.out.println("Afiseaza angajatii si numele departamentului din care fac parte ");
            displayAllEmployeesAlongWithDeptName(conn);

            conn.close();


        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("Eroare la conexiune " + e.getMessage());

        }
    }

    private static List<Department> findAllDep(Connection conn) throws SQLException {
        List<Department> deps = findAllDep(conn);

        Statement statement = conn.createStatement();


        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");


        while (resultSet.next()) {
            Integer deptId = resultSet.getInt("departmentId");
            String deptName = resultSet.getString("name");

            Department tempDepartment = new Department(deptId, deptName);
            deps.add(tempDepartment);
        }
        resultSet.close();
        statement.close();
        return deps;
    }

    private static void departmentSelect(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        while (resultSet.next()) {
            Integer deptId = resultSet.getInt("departmentId");
            String deptName = resultSet.getString("name");
            System.out.println("deptId: " + deptId + " deptName: " + deptName);
        }

        resultSet.close();
        statement.close();
    }

    private static void displayAllProjects(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM projects");

        while (resultSet.next()) {
            Integer projectId = resultSet.getInt("projectId");
            String projectDescription = resultSet.getString("description");
            System.out.println("ProjectId: " + projectId + " description:" + projectDescription);
        }
        resultSet.close();
        statement.close();
    }

    private static void displayAllEmployees(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM employees");

        while (resultSet.next()) {
            Integer employeeId = resultSet.getInt("employeeId");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            Date dateOfBirth = resultSet.getDate("dateOfBirth");
            System.out.println("EmployeeId: " + employeeId + " " + firstName + " " + lastName + " " + dateOfBirth);

        }
        resultSet.close();
        statement.close();
    }

    private static void displayAllEmployeesWithJ(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM employees WHERE firstName like 'J%'");

        while (resultSet.next()) {
            Integer employeeId = resultSet.getInt("employeeId");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            Date dateOfBirth = resultSet.getDate("dateOfBirth");
            System.out.println("EmployeeId: " + employeeId + " " + firstName + " " + lastName + " " + dateOfBirth);

        }
        resultSet.close();
        statement.close();
    }

    private static void displayAllEmployeesAlongWithDeptName(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT e.employeeId ,e.firstName,e.lastName,e.dateOfBirth,d.name FROM employees e INNER JOIN departments d ON e.departmentId=d.departmentId");

        while (resultSet.next()) {
            Integer employeeId = resultSet.getInt("employeeId");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            Date dateOfBirth = resultSet.getDate("dateOfBirth");
            String deptName = resultSet.getString("name");
            System.out.println("EmployeeId: " + employeeId + " " + firstName + " " + lastName + " " + dateOfBirth + " dep.Name " + deptName);

        }
        resultSet.close();
        statement.close();
    }

    private static void displayAllEmployeesWithNoDept(Connection conn) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM employees WHERE departmentId is null");

        while (resultSet.next()) {
            Integer employeeId = resultSet.getInt("employeeId");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            Date dateOfBirth = resultSet.getDate("dateOfBirth");
            System.out.println("EmployeeId: " + employeeId + " " + firstName + " " + lastName + " " + dateOfBirth);

        }
        resultSet.close();
        statement.close();
    }
}

