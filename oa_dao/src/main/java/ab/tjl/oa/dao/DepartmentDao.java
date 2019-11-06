package ab.tjl.oa.dao;

import ab.tjl.oa.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Descrption: 部门持久层接口
 */
@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(String sn);
    Department select(String sn);
    List<Department> selectAll();
}
