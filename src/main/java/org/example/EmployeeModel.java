package org.example;

public class EmployeeModel {
        protected int emp_id;
        protected String emp_name;
        protected String emp_city;
        protected int emp_age;
        protected  String emp_deptName;



        public EmployeeModel(int id) {
            this.emp_id = id;
        }

        public EmployeeModel(int id, String name,String city,int age,String deptName) {
            this(name, city, age, deptName);
            this.emp_id = id;
        }
    public EmployeeModel(String name, String city, int age, String deptName) {
            this.emp_name=name;
            this.emp_age=age;
            this.emp_city=city;
            this.emp_deptName=deptName;
    }

        public EmployeeModel() {

        }

        public int getEmp_id() {
            return emp_id;
        }

        public void setEmp_id(int id) {
            this.emp_id = id;
        }
    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String name) {
        this.emp_name=name;
    }
    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String city) {
        this.emp_city=city;
    }
    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int age) {
        this.emp_age=age;
    }
 public  String getEmp_deptName(String deptName)   {
            return this.emp_deptName;
        }

    public String setEmp_deptName() {
        return emp_deptName=emp_deptName;
    }

    public String getEmp_deptName() {
            return emp_deptName;
    }
}
