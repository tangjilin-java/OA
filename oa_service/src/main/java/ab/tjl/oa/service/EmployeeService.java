package ab.tjl.oa.service;

import ab.tjl.oa.entity.Employee;

import java.util.List;
/**
 * Descrption: 员工业务层接口
 */
public interface EmployeeService {
    void add(Employee employee);
    void edit(Employee employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
