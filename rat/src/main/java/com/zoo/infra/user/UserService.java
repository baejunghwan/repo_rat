package com.zoo.infra.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	public UserDao userDao;

	public List<UserDto> selectList(UserVo userVo) {
		return userDao.selectList(userVo);
	}

	public int insert(UserDto userDto) {
		return userDao.insert(userDto);
//		mybatics가 정수형태로 값을 보내서 int 사용함
	}

	public UserDto selectOne(UserDto userDto) {
		return userDao.selectOne(userDto);
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
	
}
