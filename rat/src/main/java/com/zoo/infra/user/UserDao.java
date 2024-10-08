package com.zoo.infra.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	public List<UserDto> selectList(UserVo userVo);

	public UserDto selectOne(UserDto userDto);
	// mybatics가 select 일때는 값을 다 하나씩 땅땅 매핑해주고 나머지 insert,update, delete일때는 int형태로
	// 받아준다.
	// 이 구문의 의미 : mapper에서 쟁반을 들고 오면 dto로 넘겨주는 역할을 하는 용도.

	public int insert(UserDto userDto);
	// int쓰는 이유가 mybatis가 값 몇건 이렇게 정수 형식으로 보내줘서이다.

	public int update(UserDto userDto);

	public int delete(UserDto userDto);

	public int uelete(UserDto userDto);

	// paging
	public int selectOneCount(UserVo vo);

	//
	public List<UserDto> getAllUsers(); // 전체 코드 그룹 조회 메서드
	
}
