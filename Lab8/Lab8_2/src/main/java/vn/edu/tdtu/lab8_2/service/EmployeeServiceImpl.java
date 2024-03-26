package vn.edu.tdtu.lab8_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.lab8_2.model.Employee;
import vn.edu.tdtu.lab8_2.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee item) {
        employeeRepository.save(item);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee find(int id) {
        return employeeRepository.findById(id);
    }
}
