package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) throws SQLException {
        boolean status;
        EmployeeModel employeeModel;
        EmployeeOperation emp_operation= new EmployeeOperation();

        EmployeeModel employeeModel1=new EmployeeModel(1,"mahak","indore",25,"PTO");
        EmployeeModel employeeModel2=new EmployeeModel(2,"Parth","Lucknow",24,"PS");
      // status=emp_operation.insertEmployee(employeeModel1);
      // System.out.println(status);
      // status= emp_operation.insertEmployee(employeeModel2);
       // System.out.println(status);
      employeeModel= emp_operation.getEmployee(1);
      System.out.println(employeeModel);
      status=emp_operation.updatedEmployee(employeeModel2);
      System.out.println(status);
     status= emp_operation.deleteEmployee(employeeModel2);
     System.out.println(status);
    // emp_operation.disconnect();



    }
}