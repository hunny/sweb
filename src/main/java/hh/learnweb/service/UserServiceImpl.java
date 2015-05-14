package hh.learnweb.service;

import hh.learnweb.dao.UserMapper;
import hh.learnweb.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	public User findUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public int insertUser(User user) {
		return userMapper.insertSelective(user);
	}

}
