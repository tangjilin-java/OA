package ab.tjl.oa.dao;

import ab.tjl.oa.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Descrption: 账单详情持久层接口
 */
@Repository("claimVoucherItemDao")
public interface ClaimVoucherItemDao {
    void insert(ClaimVoucherItem claimVoucherItem);
    void update(ClaimVoucherItem claimVoucherItem);
    void delete(int id);
    List<ClaimVoucherItem> selectByClaimVoucher(int cvid);
}
