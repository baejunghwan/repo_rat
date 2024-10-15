package com.zoo.infra.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	public List<UserDto> selectList(UserVo userVo);

	public List<UserVo> selectList();

	public UserDto selectOne(UserDto userDto);

	public int insert(UserDto userDto);

	public int update(UserDto userDto);

	public int delete(UserDto userDto);

	public int uelete(UserDto userDto);

	// paging
	public int selectOneCount(UserVo vo);

	// for cache
	public List<UserDto> selectListCachedCodeArrayList();

	// login
	public UserDto selectOneLogin(UserDto userDto);  
}