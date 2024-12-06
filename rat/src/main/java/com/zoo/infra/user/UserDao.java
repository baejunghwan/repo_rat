package com.zoo.infra.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	//Product 연결
//	public List<ProductDto> selectList(ProductVo ProductVo);
//	public ProductDto selectOne(ProductVo productVo);

	public List<UserDto> selectList(UserVo userVo);
	public UserDto selectOne(UserVo userVo);
	
	//CRUD
	public int insert(UserDto userDto);
	public int update(UserDto userDto);
	public int delete(UserDto userDto);
	public int uelete(UserDto userDto);

	// Paging
	public int selectOneCount(UserVo vo);

	// for cache
	public List<UserDto> selectListCachedCodeArrayList();

	// Login
	public UserDto selectOneLogin(UserDto userDto);  
}