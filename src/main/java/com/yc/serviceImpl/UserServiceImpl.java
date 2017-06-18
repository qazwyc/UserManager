package com.yc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.mybatis.mapper.UserDAO;
import com.yc.po.User;
import com.yc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserDAO userDao;  
	//获取用户数量 + 按账号姓名匹配
	public int getCount(String search_name, String search_account) {
		// TODO Auto-generated method stub
		return userDao.getCount("%"+search_name+"%", "%"+search_account+"%");
	}
	//获取用户 + 分页 + 按账号姓名匹配
	public List<User> getAllUsers(int pageNo, int size, String search_name, String search_account) {
		// TODO Auto-generated method stub
		return userDao.getAllUsers((pageNo-1)*size, size, "%"+search_name+"%", "%"+search_account+"%");
	}
	//添加用户
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}
	//更新用户
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}
	//删除指定id用户
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUserById(id);
	}
}