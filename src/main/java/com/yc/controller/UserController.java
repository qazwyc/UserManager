package com.yc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yc.po.User;
import com.yc.serviceImpl.UserServiceImpl;


@Controller  
public class UserController {  
    @Autowired  
    private UserServiceImpl userInfoServiceImpl; 
    
    /*
     * 获取用户 + 分页 + 按账号姓名筛选
     */
    @RequestMapping(value="/getUsers")  
    public String getAllUsers(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException{
    	//分页,easyui-datagrid会自动传递页码page和页长size
    	int page = request.getParameter("page") == null ?
    			1 : Integer.parseInt(request.getParameter("page"));
    	int rows = request.getParameter("rows") == null ? 
    			10 : Integer.parseInt(request.getParameter("rows"));
    	//筛选条件
    	String search_name = request.getParameter("search_name") == null ? 
    			"" : request.getParameter("search_name");
    	String search_account = request.getParameter("search_account") == null ? 
    			"" : request.getParameter("search_account");
        //调用服务
    	List<User> users = userInfoServiceImpl.getAllUsers(
    			page, rows, search_name, search_account); 
        //封装json数据,total存放数据总数,rows存放数据数组，以提供给easyui的datagrid
        JSONObject json = new JSONObject();
        //筛选后的总数
        json.put("total", userInfoServiceImpl.getCount(search_name, search_account));
        JSONArray row = new JSONArray();
        for(User info : users){
        	JSONObject jo = new JSONObject();
            jo.put("id", info.getId());
            jo.put("account", info.getAccount());
            jo.put("name", info.getName());
            jo.put("phone", info.getPhone());
            jo.put("email", info.getEmail());
            jo.put("address", info.getAddress());
            row.put(jo);
        }
        json.put("rows", row);
        System.out.println(json.toString());
        //写入响应
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json.toString());
        return null;  
    }  
    /*
     * 用户管理界面
     */
    @RequestMapping(value="/list")  
    public String showAllUsers(HttpServletRequest request,
    		HttpServletResponse response){  
        return "list";  
    }       
    /*
     * 新增用户
     */
    @RequestMapping(value="/add")  
    public String addUser(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException{  
    	User newuser = new User();
    	newuser.setName(request.getParameter("name"));
    	newuser.setAccount(request.getParameter("account"));
    	newuser.setPhone(request.getParameter("phone"));
    	newuser.setEmail(request.getParameter("email"));
    	newuser.setAddress(request.getParameter("address"));
    	//封装操作结果，包括success是否成功和msg消息提示
    	JSONObject result = new JSONObject();
    	try{
    		userInfoServiceImpl.addUser(newuser);
    		result.put("success", true);
    		result.put("msg", "添加成功！");
    	}catch(Exception e){
    		result.put("success", false);
    		result.put("msg", "账号已被占用！");
    	}
    	//写入响应
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result.toString());
        return null;
    }
    /*
     * 更新指定id的用户
     */
    @RequestMapping(value="/update/{id}")  
    public String updateUser(@PathVariable int id, HttpServletRequest request, 
    		HttpServletResponse response) throws IOException{  
    	User newuser = new User();
    	newuser.setId(id);
    	newuser.setName(request.getParameter("name"));
    	newuser.setAccount(request.getParameter("account"));
    	newuser.setPhone(request.getParameter("phone"));
    	newuser.setEmail(request.getParameter("email"));
    	newuser.setAddress(request.getParameter("address"));
    	//封装操作结果，包括success是否成功和msg消息提示
    	JSONObject result = new JSONObject();
    	try{
    		userInfoServiceImpl.updateUser(newuser);
    		result.put("success", true);
    		result.put("msg", "修改成功！");
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		result.put("success", false);
    		result.put("msg", "账号已被占用！");
    	}
    	//写入响应
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result.toString());
        return null;
    } 
    /*
     * 删除指定id用户
     */
    @RequestMapping(value="/delete")  
    public String deleteUser(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException{  
    	//封装操作结果，包括success是否成功和msg消息提示
    	JSONObject result = new JSONObject();
    	try{
    		userInfoServiceImpl.deleteUserById(Integer.parseInt(request.getParameter("id")));
    		result.put("success", true);
    		result.put("msg", "删除成功！");
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    		result.put("success", false);
    		result.put("msg", "删除失败！");
    	}
    	//写入响应
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result.toString());
        return null;
    } 
}  