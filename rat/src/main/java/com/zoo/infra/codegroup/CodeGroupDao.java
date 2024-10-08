package com.zoo.infra.codegroup;

// 필요한 라이브러리 임포트
import java.util.List;

// 이 인터페이스가 DAO(데이터 접근 객체)임을 명시
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {

	// 코드 그룹 리스트를 조회하는 메서드
	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo);

	// 특정 코드 그룹을 조회하는 메서드
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
	// MyBatis에서 select 시 DTO에 매핑하여 반환하는 역할을 수행
	// insert, update, delete 메서드는 정수형 반환으로 데이터베이스에서 영향을 받은 행 수를 나타냄

	// 코드 그룹을 데이터베이스에 추가하는 메서드
	public int insert(CodeGroupDto codeGroupDto);
	// MyBatis에서 영향을 받은 행 수를 정수형으로 반환하여 성공 여부를 나타냄

	// 코드 그룹을 업데이트하는 메서드
	public int update(CodeGroupDto codeGroupDto);

	// 코드 그룹을 삭제하는 메서드
	public int delete(CodeGroupDto codeGroupDto);

	// 코드 그룹을 복구하는 메서드 (Soft Delete)
	public int uelete(CodeGroupDto codeGroupDto);

	// 페이지네이션을 위한 총 행 수를 조회하는 메서드
	public int selectOneCount(CodeGroupVo vo);

	// 모든 코드 그룹을 조회하는 메서드
	public List<CodeGroupDto> getAllCodeGroups();
}
