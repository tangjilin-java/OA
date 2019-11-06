package ab.tjl.oa.dto;

import ab.tjl.oa.entity.ClaimVoucher;
import ab.tjl.oa.entity.ClaimVoucherItem;

import java.util.List;
/**
 * Descrption:封装报销单信息
 */
public class ClaimVoucherInfo {
    private ClaimVoucher claimVoucher;
    private List<ClaimVoucherItem> items;

    public ClaimVoucher getClaimVoucher() {
        return claimVoucher;
    }

    public void setClaimVoucher(ClaimVoucher claimVoucher) {
        this.claimVoucher = claimVoucher;
    }

    public List<ClaimVoucherItem> getItems() {
        return items;
    }

    public void setItems(List<ClaimVoucherItem> items) {
        this.items = items;
    }
}
