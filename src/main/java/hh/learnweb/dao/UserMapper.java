package hh.learnweb.dao;

import hh.learnweb.model.User;

public interface UserMapper {
	
    public int deleteByPrimaryKey(Long id);

    public int insert(User record);

    public int insertSelective(User record);

    public User selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);
}