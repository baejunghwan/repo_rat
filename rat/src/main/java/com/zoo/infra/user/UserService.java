package com.zoo.infra.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.infra.product.ProductDao;
import com.zoo.infra.product.ProductDto;
import com.zoo.infra.product.ProductVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;

	public List<UserDto> selectList(UserVo userVo) {
		return userDao.selectList(userVo);
	}
	public UserDto selectOne(UserVo userVo) {
		return userDao.selectOne(userVo);
	}
	
	//Product
//	public List<ProductDto> productSelectList(ProductVo productVo) {
//		return productDao.selectList(productVo);
//	}
//	public ProductDto productSelectOne(ProductVo productVo) {
//		return productDao.selectOne(productVo);
//	}
	
	// CURD
	//	mybatics가 정수형태로 값을 보내서 int 사용함
	public int insert(UserDto userDto) {
		return userDao.insert(userDto);
	}
	public int update(UserDto userDto) {
		return userDao.update(userDto);
	}
	public int delete(UserDto userDto) {
		return userDao.delete(userDto);
	}
	public int uelete(UserDto userDto) {
		return userDao.uelete(userDto);
	}

	// paging
	public int selectOneCount(UserVo vo) {
		return userDao.selectOneCount(vo);
	}
	// login
	public UserDto selectOneLogin(UserDto userDto) {
		return userDao.selectOneLogin(userDto);
	}
}