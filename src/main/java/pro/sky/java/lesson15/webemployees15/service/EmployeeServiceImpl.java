package pro.sky.java.lesson15.webemployees15.service;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.lesson15.webemployees15.exceptions.EmployeeArrayIsFullException;
import pro.sky.java.lesson15.webemployees15.exceptions.EmployeeIsAlreadyInsideArrayException;
import pro.sky.java.lesson15.webemployees15.exceptions.EmployeeIsNotFoundException;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Employee[] employees = new Employee[4];

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee addingEmployee = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee != null && employee.equals(addingEmployee)) {
                throw new EmployeeIsAlreadyInsideArrayException();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = addingEmployee;
                return addingEmployee;
            }
        }
        throw new EmployeeArrayIsFullException();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee removingEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].equals(removingEmployee)) {
                employees[i] = null;
                return removingEmployee;
            }
        }
        throw new EmployeeIsNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee ourEmployee = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee != null && employee.equals(ourEmployee)) {
                return ourEmployee;
            }
        }
        throw new EmployeeIsNotFoundException();
    }
}
