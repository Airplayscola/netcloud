package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.bean.Service;
import com.lanou.service.SeService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/25.
 */
@Controller
public class ServiceController {

    @Resource
    private SeService seService;

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
    public AjaxResult selectByIdCard(@RequestParam("idcard")String idcard){

        System.out.println(idcard);
        Account account = seService.selectByIdCard(idcard);
        System.out.println(idcard);
        return new AjaxResult(account);
    }

    //添加
    @ResponseBody
    @RequestMapping(value = "/addservice",method = RequestMethod.POST)
    public AjaxResult addService(Service service) {

        service.setStatus("1");
        service.setCreateDate(new Date());
        Integer insert = seService.insertService(service);
        return new AjaxResult(insert);
    }

}
