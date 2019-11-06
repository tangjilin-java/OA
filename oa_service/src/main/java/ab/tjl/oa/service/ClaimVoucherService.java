package ab.tjl.oa.service;

import ab.tjl.oa.entity.ClaimVoucher;
import ab.tjl.oa.entity.ClaimVoucherItem;
import ab.tjl.oa.entity.DealRecord;

import java.util.List;
/**
 * Descrption: 账单提出信息业务层接口
 */
public interface ClaimVoucherService {

    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItems(int cvid);
    List<DealRecord> getRecords(int cvid);

    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);
    void submit(int id);
    void deal(DealRecord dealRecord);
}
