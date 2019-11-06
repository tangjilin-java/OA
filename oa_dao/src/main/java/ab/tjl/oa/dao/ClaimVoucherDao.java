package ab.tjl.oa.dao;

import ab.tjl.oa.entity.ClaimVoucher;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Descrption: 账单提出持久层接口
 */
@Repository("claimVoucherDao")
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(int id);
    ClaimVoucher select(int id);
    List<ClaimVoucher> selectByCreateSn(String csn);
    List<ClaimVoucher> selectByNextDealSn(String ndsn);
}
