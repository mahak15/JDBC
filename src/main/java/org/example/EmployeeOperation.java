package org.example;
import org.example.EmployeeModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeOperation {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;




    {
        jdbcURL = "jdbc:mysql://localhost:3306/employee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        jdbcUsername = "root";
        jdbcPassword = "root15$";
    }

    public EmployeeOperation() {
        try{
            jdbcConnection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            if(jdbcConnection != null){
                System.out.println("Connected !");
            }
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        jdbcConnection.close();
        System.out.println("Connection Closed !");
    }


    public boolean insertEmployee(EmployeeModel employee) throws SQLException {
        String sql = "insert into  employee(employee_id,employee_name,employee_city,employee_age,employee_deptName) VALUES(?,?,?,?,?)";

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1,employee.emp_id);
        statement.setString(2,employee.emp_name);
        statement.setString(3,employee.emp_city);
        statement.setInt(4,employee.emp_age);
        statement.setString(5,employee.emp_deptName);
        boolean rowInsert=statement.executeUpdate()>0;
        statement.close();

   return rowInsert;

    }
    public List<EmployeeModel> listAllEmployee ()throws SQLException{
        List<EmployeeModel> employeeList=new ArrayList<>();
        String sql="select* from table employee where=";

        Statement statement=jdbcConnection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            int id=resultSet.getInt("employee_id");
            String name=resultSet.getString("employee_name");
            String city=resultSet.getString("employee_city");
            int age=resultSet.getInt("employee_age");
            String departmentName=resultSet.getString("employee_deptName");
            EmployeeModel employeeModel=new EmployeeModel(id,name,city,age,departmentName);
            employeeList.add(employeeModel);
        }
        resultSet.close();
        statement.close();

        return employeeList;
    }
    public boolean deleteEmployee(EmployeeModel employeeModel)throws SQLException{
        String sql="delete from employee where employee_id=?";

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1,employeeModel.getEmp_id());
        boolean rowDelete=statement.executeUpdate()>0;
        statement.close();

        return rowDelete;
    }
    public boolean updatedEmployee(EmployeeModel employee) throws  SQLException{
        String sql="update employee SET employee_name=?,employee_city=?,employee_age=?,employee_deptName=?";
         sql +="Where employee_id=?";

   PreparedStatement statement= jdbcConnection.prepareStatement(sql);

        statement.setString(1,employee.emp_name);
        statement.setString(2,employee.emp_city);
        statement.setInt(3,employee.emp_age);
        statement.setString(4,employee.emp_deptName);
        statement.setInt(5,employee.emp_id);
        boolean rowUpdate=statement.executeUpdate() >0;
        statement.close();

        return rowUpdate;

    }
    public EmployeeModel getEmployee(int id)throws SQLException{
        EmployeeModel employeeModel=null;
        String sql="select * from employee where employee_id=?";

        PreparedStatement statement=jdbcConnection.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resultSet=statement.executeQuery();
        if(resultSet.next()){
            String name=resultSet.getString("employee_name");
            String city=resultSet.getString("employee_city");
            int age=resultSet.getInt("employee_age");
            String departmentName=resultSet.getString("employee_deptName");
            employeeModel=new EmployeeModel(id,name,city,age,departmentName);

        }
        resultSet.close();
        statement.close();
        return employeeModel;
    }

}

