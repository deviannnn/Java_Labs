package vn.edu.tdtu.lab8_2.service;

import vn.edu.tdtu.lab8_2.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> list();
    void save(Employee item);
    void delete(int id);
    Employee find(int id);
}
