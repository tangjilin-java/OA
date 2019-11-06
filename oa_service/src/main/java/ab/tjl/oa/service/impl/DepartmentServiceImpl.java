package ab.tjl.oa.service.impl;

import ab.tjl.oa.service.DepartmentService;
import ab.tjl.oa.dao.DepartmentDao;
import ab.tjl.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Descrption: 部门业务层接口实现类
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
