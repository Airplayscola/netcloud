package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Cost;
import com.lanou.bean.Service;
import com.lanou.mapper.CostMapper;
import com.lanou.service.CostService;
import com.lanou.service.SeService;
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
 * Created by dllo on 17/10/25.
 */
@Controller
public class ServiceController {

    @Resource
    private SeService seService;

    @Resource
    private CostService costService;

    @RequestMapping(value = "/service")
    public String service(){
        return "/service/service_list";
    }

    @RequestMapping(value = "/serviceadd")
    public String serviceAdd(){
        return "/service/service_add";
    }

    //显示全部
    @ResponseBody
    @RequestMapping(value = "/showallservice")
    public AjaxResult showAccount() {
        Service service=new Service();
        Account account=new Account();
        System.out.println(account.getIdcardNo());
        List<Service> all = seService.findAll();
        System.out.println(account.getIdcardNo());
        return new AjaxResult(all);
    }

    //分页
    @ResponseBody
    @RequestMapping(value = "/pageinfoservice")
    public PageInfo<Service> pageInfo(@RequestParam("pageNo")Integer pageNo, @RequestParam("pagesize") Integer pageSize){

        return seService.getPageInfo(pageNo,pageSize);
    }


    //根据idcard查找
    @ResponseBody
    @RequestMapping(value = "/selectbyidcard")
    public AjaxResult selectByIdCard(HttpServletRequest request, HttpServletResponse response, @RequestParam("idcard")String idcard){


        System.out.println(idcard);
        Account account = seService.selectByIdCard(idcard);
        request.getSession().setAttribute("account",account);
        System.out.println(account.getAccountId());
        System.out.println(idcard);
        return new AjaxResult(account);
    }

    //从session找到accountid
    @ResponseBody
    @RequestMapping(value = "/getAccountId")
    public AjaxResult getAccountId(HttpServletRequest request,HttpServletResponse response){
        Account account = (Account) request.getSession().getAttribute("account");
        return new AjaxResult(account);

    }

    //显示costName
    @ResponseBody
    @RequestMapping(value = "/getcosttypename")
    public AjaxResult getCostName(){
        Cost cost=new Cost();
        String name = cost.getName();
        System.out.println(name);
        List<Cost> all = costService.findAll();
        return new AjaxResult(all);
    }




    //添加
    @ResponseBody
    @RequestMapping(value = "/addservice")
    public AjaxResult addService(Service service) {

        service.setStatus("1");
        service.setCreateDate(new Date());
        Integer insert = seService.insertService(service);
        return new AjaxResult(insert);
    }

    //删除状态
    //更新状态
    @ResponseBody
    @RequestMapping(value = "/updateByServiceDelete")
    public AjaxResult updateByDelete(Service service) {
        System.out.println(service.getAccountId());

        System.out.println(service.getCloseDate());
        Integer status = seService.updateByDelete(service);
        return new AjaxResult(status);
    }

    //根据id查找删除
    @ResponseBody
    @RequestMapping(value = "/findbyIdServicedel")
    public AjaxResult findByIdSeviceDel(HttpServletRequest request, HttpServletResponse response, Integer serviceId) {
        System.out.println(serviceId);
        Service service = seService.selectBySerPrimaryKey(serviceId);

        request.getSession().setAttribute("service", service);
        return new AjaxResult(service);
    }

    //修改为暂停
    @ResponseBody
    @RequestMapping(value = "/updateByServiceStart")
    public AjaxResult updateByServiceStart(Service service) {
        System.out.println(service.getServiceId());

        System.out.println(service.getCloseDate());
        Integer status = seService.updateByStart(service);
        return new AjaxResult(status);
    }

    //修改为启用
    @ResponseBody
    @RequestMapping(value = "/updateByServicePause")
    public AjaxResult updateByServicePause(Service service) {
        System.out.println(service.getServiceId());

        System.out.println(service.getCloseDate());
        Integer status = seService.updateByPause(service);
        return new AjaxResult(status);
    }

}
