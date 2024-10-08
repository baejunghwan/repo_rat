package com.zoo.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 서비스 클래스: 비즈니스 로직을 처리하는 역할
@Service
public class CodeGroupService {

	@Autowired
	public CodeGroupDao codeGroupDao; // DAO 주입: 데이터베이스와의 상호작용을 담당

	// 코드 그룹 리스트 조회 메서드
	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo) {
		return codeGroupDao.selectList(codeGroupVo); // DAO 호출
	}

	// 코드 그룹 등록 메서드
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
		// MyBatis가 등록된 레코드 수를 정수형태로 반환
	}

	// 특정 코드 그룹 조회 메서드
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectOne(codeGroupDto); // DAO 호출
	}

	// 더 간결하게 작성된 selectOne 메서드 예시
	// public CodeGroupDto selectOne(CodeGroupDto codeGroupDto){
	// CodeGroupDto dto = codeGroupDao.selectOne(codeGroupDto);
	// return dto;
	// }

	// 코드 그룹 업데이트 메서드
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto); // DAO 호출
	}

	// 코드 그룹 삭제 메서드
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto); // DAO 호출
	}

	// 코드 그룹 복구 메서드 (Soft Delete)
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto); // DAO 호출
	}

	// 전체 레코드 수 조회 메서드 (페이징 용도)
	public int selectOneCount(CodeGroupVo vo) {
		return codeGroupDao.selectOneCount(vo); // DAO 호출
	}

	// 전체 코드 그룹 조회 메서드
	public List<CodeGroupDto> getAllCodeGroups() {
		return codeGroupDao.getAllCodeGroups(); // DAO 호출
	}
}
