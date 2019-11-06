package ab.tjl.oa.service.impl;


import ab.tjl.oa.service.BasicService;
import ab.tjl.oa.dao.EmployeeDao;
import ab.tjl.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Descrption: 基础信息业务层实现类
 */
@Service("basicService")
public class BasicServiceImpl implements BasicService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if(employee!=null&&employee.getPassword().equals(password)){
            return  employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
