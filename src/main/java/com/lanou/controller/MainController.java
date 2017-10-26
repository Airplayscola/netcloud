package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.AdminInfo;
import com.lanou.bean.Cost;
import com.lanou.service.AdminInfoService;
import com.lanou.service.CostService;
import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
@Controller
public class MainController {

    @Resource
    private AdminInfoService adminInfoService;

    @Resource
    private CostService costService;


    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/show")
    public String show() {
        System.out.println(2132);
        return "index";
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "error";
    }

    @RequestMapping(value = "/list")
    public String feeList() {
        return "/fee/fee_list";
    }

    @RequestMapping(value = "/addcost")
    public String addCost() {
        return "/fee/fee_add";
    }

    @RequestMapping(value = "/modi")
    public String modiCost() {
        return "/fee/fee_modi";
    }

    @RequestMapping(value = "/detail")
    public String detailCost(){return "/fee/fee_detail";}


    //登录
    @ResponseBody
    @RequestMapping(value = "/loginpage")
    public AjaxResult login(AdminInfo adminInfo) {
        AdminInfo select = adminInfoService.select(adminInfo);

        if (select == null) {
            return new AjaxResult(0);
        } else {
            return new AjaxResult(1);
        }
    }


    //显示全部
    @ResponseBody
    @RequestMapping(value = "/showallcost")
    public AjaxResult showCost() {
        Cost cost=new Cost();
        System.out.println(cost.getCostId());
        List<Cost> all = costService.findAll();
        return new AjaxResult(all);
    }

    //添加
    @ResponseBody
    @RequestMapping(value = "/addallcost",method = RequestMethod.POST)
    public AjaxResult addCost(Cost record) {
        System.out.println(record.getName());

        record.setStatus("0");
        record.setCreatime(new Timestamp(System.currentTimeMillis()));
        Integer insert = costService.insert(record);
        return new AjaxResult(insert);
    }

    //根据id查找删除
    @ResponseBody
    @RequestMapping(value = "/findbyIddel")
    public AjaxResult findByIdDel(HttpServletRequest request, HttpServletResponse response, Integer costId) {

        Cost cost = costService.findById(costId);
        request.getSession().setAttribute("cost", cost);
        return new AjaxResult(cost);
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/deletecost")
    public AjaxResult delete(Integer costId) {
        System.out.println(costId);
        Integer delete = costService.delete(costId);
        return new AjaxResult(delete);
    }

    //通过id查找
    @ResponseBody
    @RequestMapping(value = "/findbyId")
    public AjaxResult findById(HttpServletRequest request, HttpServletResponse response, Integer costId) {

        Cost cost = costService.findById(costId);
        request.getSession().setAttribute("cost", cost);
        return new AjaxResult(cost);
    }

    //找到session中的id
    @ResponseBody
    @RequestMapping(value = "/modiCost")
    public AjaxResult modi(HttpServletRequest request, HttpServletResponse response) {
        Cost cost = (Cost) request.getSession().getAttribute("cost");
        return new AjaxResult(cost);
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/updateById")
    public AjaxResult update(Cost cost) {
        System.out.println(cost.getCostId());
        cost.setCreatime(new Date());
        Integer update = costService.update(cost);
        return new AjaxResult(update);
    }

    //更新状态
    @ResponseBody
    @RequestMapping(value = "/updateWithStatus")
    public AjaxResult updateWithStatus(Cost cost) {
        System.out.println(cost.getCostId());
        System.out.println(cost.getStartime());
        Integer status = costService.updateWithStatus(cost);
        return new AjaxResult(status);

    }
    //更新开通时间
    @ResponseBody
    @RequestMapping(value = "/updateWithStartime")
    public AjaxResult updateWithStartime(Integer costId){
        System.out.println(costId);
        Cost cost=new Cost();

        Integer integer = costService.updateWithStartime(costId);
        return new AjaxResult(integer);
    }


    //在session中根据id查找
    @ResponseBody
    @RequestMapping(value = "/findbyId1")
    public AjaxResult findById1(HttpServletRequest request, HttpServletResponse response, Integer costId) {

        Cost cost = costService.findById(costId);
        request.getSession().setAttribute("cost", cost);
        return new AjaxResult(cost);
    }

    //查看细节
    @ResponseBody
    @RequestMapping(value = "/detailCost")
    public AjaxResult detailCost(HttpServletRequest request, HttpServletResponse response){
        Cost cost = (Cost) request.getSession().getAttribute("cost");
        return new AjaxResult(cost);
    }



    @RequestMapping(value = "/selectByBaseCost")
    public AjaxResult selectByBaseCost(Integer baseCost){
        System.out.println(baseCost);
        List<Cost> costs = costService.selectByBaseCose(baseCost);
        return new AjaxResult(costs);
    }

    //分页
    @ResponseBody
    @RequestMapping(value = "/pageinfo")
    public PageInfo<Cost> pageInfo(@RequestParam("pageNo")Integer pageNo,@RequestParam("pagesize") Integer pageSize){

        return costService.getPageInfo(pageNo,pageSize);
    }
}
