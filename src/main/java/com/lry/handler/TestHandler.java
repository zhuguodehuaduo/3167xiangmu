package com.lry.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lry.po.product;
import com.lry.po.sale;
import com.lry.po.users;
import com.lry.service.ProductService;
import com.lry.service.SaleService;
import com.lry.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author liurenyi
 * @create 2019--10--21--19:07
 */
@Controller
public class TestHandler {

    @Resource
    private UsersService ser;
    @Resource
    private ProductService ser2;
    @Resource
    private SaleService ser3;

    //进入页面
    @RequestMapping("selectAll")
    public String selectAll(){
        return "index";
    }


    @RequestMapping("select")
    public String select(Map<String,Object> map){
        map.put("user",users);
        return "caidan";
    }

    @RequestMapping("selectkucun")
    public String selectkucun(Map<String,Object> map){
        map.put("list",ser2.selectProductName());
        System.out.println(ser2.selectProductName());
        return "kucun";
    }

    private users users;

    //登陆查询
    @RequestMapping("/selectIndex")
    public void selectIndex(String username,String password,HttpServletResponse res) throws IOException {
        users list = ser.SelectIndex(username,password);
        this.users=list;
        PrintWriter out = res.getWriter();
        res.setContentType("text/html;charset=utf-8");
        if(username.equals("")){
            out.print("<script>alert('用户名必填!');location.href='select';</script>");
        }else if(password.equals("")){
            out.print("<script>alert('密码必填!');location.href='selectAll';</script>");
        }
        else if(list!=null){
            out.print("<script>alert('登录成功！');location.href='select';</script>");
        }else{
            out.print("<script>alert('登录失败！');location.href='selectAll';</script>");
        }
    }

    //跳转主页面
    @RequestMapping("/toselectIndex")
    public String toselectIndex(Map<String,Object> map) {
        map.put("emps",ser2.selectProductName()); //查询商品名称
        map.put("user",users);
        return "insert";
    }

    //退出登陆
    @RequestMapping("tuichu")
    public String tuichu(){
         int n = JOptionPane.showConfirmDialog(null, "确认要退出系统?", "确认对话框", JOptionPane.YES_NO_OPTION);
         if (n == JOptionPane.YES_OPTION) {
             JOptionPane.showMessageDialog(new JFrame(),"已退出");
         }
         else if (n == JOptionPane.NO_OPTION)
         {
            JOptionPane.showMessageDialog(new JFrame(),"已取消");
         }
         return "index";
    }

    //查询全部商品
    @RequestMapping("selectAllSale")
    public String selectAllSale(Map<String,Object>map,HttpServletRequest request){
        map.put("user",users);

        String ob = request.getParameter("orderby");
        Integer orderby=0;
        if(ob!=null){
            orderby=Integer.parseInt(ob);
            System.out.println("排序Id(0代表销售日期 1代表单笔总价)"+orderby);
        }

        int pageNum=1;
        String page=request.getParameter("pageNum");
        System.out.println(page);
        //判断首页和末页
        if(page!=null){
            pageNum=Integer.valueOf(page); //强转
            if(pageNum==0){ //判断是否等于第0页 然后让他等于第1页
                pageNum=1;
            }
            if(pageNum==3){ //判断是否是最后一页+1
                pageNum=2;//总共两页
            }
        }

        //分页startPage
        PageHelper.startPage(pageNum,3);  //当前页面 每页页数
        //查询全部
        List<sale> sales =ser3.selectAllSale(orderby); //查询全部操作
        //根据结果集获取分页后的数据
        PageInfo<sale> info=new PageInfo<sale>(sales); //根据查询到的结果集来进行分页
        //获取分页后的集合数据
        List<sale> list = info.getList(); //从info中获取分页后的集合数据

        //info.get 都是关于分页的方法

        map.put("list",list); //调用的数据
        map.put("info",info);
        map.put("pageNum",pageNum);
        map.put("end",info.getLastPage());
        map.put("totalItems",info.getTotal());
        map.put("orderby",orderby);
        map.put("select",list);

        return "select";
    }


    //查询货物数量
    @RequestMapping("/selectQuantity")
    public String selectQuantity(Map<String,Object> map,HttpServletRequest req,HttpServletResponse res) throws IOException {
        map.put("user",users);

        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();

        String productname = req.getParameter("productname");
        Integer id=1;
        Integer quantity=0;
        if(productname!=null){
            id=Integer.parseInt(productname);
        }
        product product = ser2.selectQuantity(id);
        quantity = product.getQuantity();
        map.put("kucun",quantity);
        map.put("list",ser2.selectProductName());
        return "kucun";
    }



    //增加销售信息
    @RequestMapping("InsertSale")
    public void InsertSale(double price, int quantity, HttpServletRequest req, HttpServletResponse res) throws IOException {
          res.setCharacterEncoding("utf-8");
          res.setContentType("text/html;charset=utf-8");
          PrintWriter out = res.getWriter();
          Integer id= Integer.valueOf(req.getParameter("productName"));
          double totalprice=price*quantity;
          sale sale = new sale(price, quantity, totalprice,new users(this.users.getId()),new product(id));
          int insert = ser3.insert(sale); //增加方法
          int update = ser2.update(new product(id,quantity));
          System.out.println(update);
        if(insert>0&&update>0){
            out.print("<script>alert('新增成功!');location.href='selectAllSale';</script>");
        }else{
            out.print("<script>alert('新增失败!');location.href='toselectIndex';</script>");
        }
    }


    public  void myOut(String msg, HttpServletResponse res){

        try {
            res.setContentType("text/html,charset=UTF-8");
            res.getWriter().print("<script>alert('"+msg+"');location.href='selectAll';</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
