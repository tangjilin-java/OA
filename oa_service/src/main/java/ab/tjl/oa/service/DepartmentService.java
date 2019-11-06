package ab.tjl.oa.service;

import ab.tjl.oa.entity.Department;

import java.util.List;
/**
 * Descrption: 部门业务层接口
 */
public interface DepartmentService {
    void add(Department department);
    void edit(Department department);
    void remove(String sn);
    Department get(String sn);
    List<Department> getAll();
}
