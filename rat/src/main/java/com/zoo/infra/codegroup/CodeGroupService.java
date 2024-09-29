package com.zoo.infra.codegroup;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	// 로직 알고리즘 영역 = service
	@Autowired
	public CodeGroupDao codeGroupDao;

	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo) {
		return codeGroupDao.selectList(codeGroupVo);
	}

	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);	
//		mybatics가 정수형태로 값을 보내서 int 사용함
	}

	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectOne(codeGroupDto);
	}
//	이 구문은 아래 구문을 더 간결하게 작성한것
//	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto){
//		CodeGroupDto dto = codeGroupDao.selectOne(codeGroupDto);
//		return dto;
//	}

	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}

	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}

	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}
	
	//paging
	public int selectOneCount(CodeGroupVo vo) { 
    	return codeGroupDao.selectOneCount(vo); 
    }
	
//	public class UtilDateTime {
//		
//		public static String add00TimeString(String date) {
//			return date + " 00:00:00";
//		}
//
//		public static String add59TimeString(String date) {
//			return date + " 23:59:59";
//		}
//		
//	}
	
}