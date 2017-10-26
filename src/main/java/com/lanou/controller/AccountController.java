package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.service.AccountService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/23.
 */
@Controller
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/account")
    public String account(){
        return "/account/account_list";
    }
    @RequestMapping(value = "/accountAdd")
    public String accountAdd(){
        return "/account/account_add";
    }
    @RequestMapping(value = "/accountmodi")
    public String accountModi(){return "/account/account_modi";}
    @RequestMapping(value = "/accountdetail")
    public String accountDetail(){return "/account/account_detail";}

    //显示全部
    @ResponseBody
    @RequestMapping(value = "/showallaccount")
    public AjaxResult showAccount() {
        Account account=new Account();

        List<Account> all = accountService.findAll();
        System.out.println(all);
        return new AjaxResult(all);
    }
    //分页
    @ResponseBody
    @RequestMapping(value = "/pageinfoaccount")
    public PageInfo<Account> pageInfo(@RequestParam("pageNo")Integer pageNo, @RequestParam("pagesize") Integer pageSize){

        return accountService.getPageInfo(pageNo,pageSize);
    }
    //添加
    @ResponseBody
    @RequestMapping(value = "/addallaccount",method = RequestMethod.POST)
    public AjaxResult addAccount(Account record) {
//        System.out.println(record.getAccountId());
//        record.setAccountId(122);
        record.setStatus("1");
        record.setCreateDate(new Date());
        Integer insert = accountService.insert(record);

        return new AjaxResult(insert);
    }

//    //删除
//    @ResponseBody
//    @RequestMapping(value = "/deleteaccount")
//    public AjaxResult delete(Integer accountId) {
//        System.out.println(accountId);
//        Integer delete = accountService.delete(accountId);
//        return new AjaxResult(delete);
//    }

    //通过id查找
    @ResponseBody
    @RequestMapping(value = "/findbyaccountId")
    public AjaxResult findById(HttpServletRequest request, HttpServletResponse response, Integer accountId) {

        Account account = accountService.selectByPrimaryKey(accountId);
        request.getSession().setAttribute("account", account);
        return new AjaxResult(account);
    }

    //找到session中的id
    @ResponseBody
    @RequestMapping(value = "/modiAccount")
    public AjaxResult modi(HttpServletRequest request, HttpServletResponse response) {
        Account account = (Account) request.getSession().getAttribute("account");
        return new AjaxResult(account);
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateByaccountId")
    public AjaxResult update(Account account) {
        System.out.println(account.getAccountId());
        Integer update = accountService.update(account);
        return new AjaxResult(update);
    }

    //删除状态
    //更新状态
    @ResponseBody
    @RequestMapping(value = "/updateByDelete")
    public AjaxResult updateByDelete(Account account) {
        System.out.println(account.getAccountId());

        System.out.println(account.getCloseDate());
        Integer status = accountService.updateByDelete(account);
        return new AjaxResult(status);
    }

    //根据id查找删除
    @ResponseBody
    @RequestMapping(value = "/findbyIdaccountdel")
    public AjaxResult findByIdDel(HttpServletRequest request, HttpServletResponse response, Integer accountId) {
        System.out.println(accountId);
        Account account = accountService.selectByPrimaryKey(accountId);

        request.getSession().setAttribute("account", account);
        return new AjaxResult(account);
    }

    //修改为暂停
    @ResponseBody
    @RequestMapping(value = "/updateByStart")
    public AjaxResult updateByStart(Account account) {
        System.out.println(account.getAccountId());

        System.out.println(account.getCloseDate());
        Integer status = accountService.updateByStart(account);
        return new AjaxResult(status);
    }

    //修改为启用
    @ResponseBody
    @RequestMapping(value = "/updateByPause")
    public AjaxResult updateByPause(Account account) {
        System.out.println(account.getAccountId());

        System.out.println(account.getCloseDate());
        Integer status = accountService.updateByPause(account);
        return new AjaxResult(status);
    }

    //在session中根据id查找
    @ResponseBody
    @RequestMapping(value = "/findbyIdaccount")
    public AjaxResult findById1(HttpServletRequest request, HttpServletResponse response, Integer accountId) {

        Account account = accountService.selectByPrimaryKey(accountId);
        request.getSession().setAttribute("account", account);
        return new AjaxResult(account);
    }

    //查看细节
    @ResponseBody
    @RequestMapping(value = "/detaiaccountl")
    public AjaxResult detailCost(HttpServletRequest request, HttpServletResponse response){
        Account account = (Account) request.getSession().getAttribute("account");
        return new AjaxResult(account);
    }

    //根据idcard模糊查询
    @ResponseBody
    @RequestMapping(value = "/selectbyIdcard")
    public AjaxResult selectByIdcard(Account account){
        if (account.getIdcardNo().equals("")){
            account.setIdcardNo(null);
        }
        if (account.getLoginName().equals("")){
            account.setLoginName(null);
        }
        if (account.getRealName().equals("")){
            account.setRealName(null);
        }if (account.getStatus().equals("")){
            account.setStatus(null);
        }
        System.out.println(account);
        List<Account> account1 = accountService.selectByIdcardNo(account);
        System.out.println(account1);
        return new AjaxResult(account1);
    }


}
