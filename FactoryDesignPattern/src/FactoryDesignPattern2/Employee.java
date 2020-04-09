
package FactoryDesignPattern2;

import java.util.ArrayList;

public class Employee {
    //if i use database this class useless
    private int id;
    private String name;
    public final static ArrayList<Employee> employees;
    
    static {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Tamer"));
        employees.add(new Employee(2, "Ali"));
        employees.add(new Employee(3, "Waseem"));
        employees.add(new Employee(4, "Nour"));
        employees.add(new Employee(5, "Bassem"));
        employees.add(new Employee(6, "Iyad"));
        employees.add(new Employee(7, "Kahled"));
        employees.add(new Employee(8, "Hassan"));
        employees.add(new Employee(9, "Ahmad"));
    }
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
