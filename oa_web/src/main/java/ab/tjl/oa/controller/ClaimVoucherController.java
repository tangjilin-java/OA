package ab.tjl.oa.controller;

import ab.tjl.oa.dto.ClaimVoucherInfo;
import ab.tjl.oa.entity.DealRecord;
import ab.tjl.oa.entity.Employee;
import ab.tjl.oa.global.Contant;
import ab.tjl.oa.service.ClaimVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;
/**
 * Descrption: 账单提出信息控制层
 */
@Controller("claimVoucherController")
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {
    @Autowired
    private ClaimVoucherService claimVoucherService;
    /**
     * Descrption: 打开填写报销单界面
     * @Param: [map]
     * @Return: java.lang.String
     */
    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("items", Contant.getItems());
        map.put("info",new ClaimVoucherInfo());
        return "claim_voucher_add";
    }
    /**
     * Descrption: 提交报销单功能
     * @Param: [session, info]
     * @Return: java.lang.String
     */
    @RequestMapping("/add")
    public String add(HttpSession session, ClaimVoucherInfo info){
        Employee employee = (Employee) session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherService.save(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }
    /**
     * Descrption: 报销单详情
     * @Param: [id, map]
     * @Return: java.lang.String
     */
    @RequestMapping("/detail")
    public String detail(int id, Map<String,Object> map){
        map.put("claimVoucher",claimVoucherService.get(id));
        map.put("items",claimVoucherService.getItems(id));
        map.put("records",claimVoucherService.getRecords(id));
        return "claim_voucher_detail";
    }
    /**
     * Descrption: 个人报销单
     * @Param: [session, map]
     * @Return: java.lang.String
     */
    @RequestMapping("/self")
    public String self(HttpSession session, Map<String,Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list",claimVoucherService.getForSelf(employee.getSn()));
        return "claim_voucher_self";
    }
    /**
     * Descrption: 待处理报销单
     * @Param: [session, map]
     * @Return: java.lang.String
     */
    @RequestMapping("/deal")
    public String deal(HttpSession session, Map<String,Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("list",claimVoucherService.getForDeal(employee.getSn()));
        return "claim_voucher_deal";
    }

    /**
     * Descrption: 打开修改报销单信息界面
     * @Param: [id, map]
     * @Return: java.lang.String
     */
    @RequestMapping("/to_update")
    public String toUpdate(int id,Map<String,Object> map){
        map.put("items", Contant.getItems());
        ClaimVoucherInfo info =new ClaimVoucherInfo();
        info.setClaimVoucher(claimVoucherService.get(id));
        info.setItems(claimVoucherService.getItems(id));
        map.put("info",info);
        return "claim_voucher_update";
    }
    /**
     * Descrption: 修改报销单信息功能
     * @Param: [session, info]
     * @Return: java.lang.String
     */
    @RequestMapping("/update")
    public String update(HttpSession session, ClaimVoucherInfo info){
        Employee employee = (Employee)session.getAttribute("employee");
        info.getClaimVoucher().setCreateSn(employee.getSn());
        claimVoucherService.update(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }
    /**
     * Descrption: 提交报销单功能
     * @Param: [id]
     * @Return: java.lang.String
     */
    @RequestMapping("/submit")
    public String submit(int id){
        claimVoucherService.submit(id);
        return "redirect:deal";
    }

    /**
     * Descrption: 打开审核报销单界面
     * @Param: [id, map]
     * @Return: java.lang.String
     */
    @RequestMapping("/to_check")
    public String toCheck(int id,Map<String,Object> map){
        map.put("claimVoucher",claimVoucherService.get(id));
        map.put("items",claimVoucherService.getItems(id));
        map.put("records",claimVoucherService.getRecords(id));
        DealRecord dealRecord =new DealRecord();
        dealRecord.setClaimVoucherId(id);
        map.put("record",dealRecord);
        return "claim_voucher_check";
    }
    /**
     * Descrption: 审核报销单功能
     * @Param: [session, dealRecord]
     * @Return: java.lang.String
     */
    @RequestMapping("/check")
    public String check(HttpSession session, DealRecord dealRecord){
        Employee employee = (Employee)session.getAttribute("employee");
        dealRecord.setDealSn(employee.getSn());
        claimVoucherService.deal(dealRecord);
        return "redirect:deal";
    }
}
