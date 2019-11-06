package ab.tjl.oa.dao;

import ab.tjl.oa.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Descrption: 账单处理记录持久层接口
 */
@Repository("dealRecordDao")
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    List<DealRecord> selectByClaimVoucher(int cvid);
}
