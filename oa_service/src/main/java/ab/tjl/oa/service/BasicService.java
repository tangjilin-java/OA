package ab.tjl.oa.service;

import ab.tjl.oa.entity.Employee;
/**
 * Descrption: 基础信息业务层接口
 */
public interface BasicService {
    Employee login(String sn, String password);
    void changePassword(Employee employee);
}
