package com.yc.service;

import java.util.List;

import com.yc.po.User;

public interface UserService {  
	/**
	 * 获取用户 + 分页 + 筛选
	 * @param pageNo 页码
	 * @param size 页的大小
	 * @param search_name 按姓名匹配
	 * @param search_account 按账号匹配
	 * @return
	 */
	public List<User> getAllUsers(int pageNo, int size, String search_name, String search_account);
	/**
	 * 用户数量
	 * @return
	 */
	public int getCount(String search_name, String search_account);
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUserById(int id);
}  
