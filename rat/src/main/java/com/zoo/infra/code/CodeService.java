package com.zoo.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	@Autowired
	public CodeDao codeDao;

//	public List<CodeDto> selectList(CodeVo codeVo) {
//		int totalRows = codeDao.selectOneCount(codeVo); // 총 데이터 개수 조회
//		codeVo.setParamsPaging(totalRows); // 페이징 정보 설정
//	    List<CodeDto> codeList = codeDao.selectList(codeVo); // 데이터 리스트 조회
//	    return codeList; // 결과 반환
//	}
	
	public List<CodeDto> selectList(CodeVo codeVo) {
		return codeDao.selectList(codeVo);
	}

	public CodeDto selectOne(CodeDto codeDto) {
		return codeDao.selectOne(codeDto);
	}

	// mybatics가 정수형태로 값을 보내서 int 사용함
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
	
	public int update(CodeDto codeDto) {
		return codeDao.update(codeDto);
	}

	public int delete(CodeDto codeDto) {
		return codeDao.delete(codeDto);
	}

	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}

	// paging
	public int selectOneCount(CodeVo vo) {
		return codeDao.selectOneCount(vo);
	}

	// for cache
	// 서버올라갈때 특정함수를 cache 에 올리고 싶다
	@PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
		CodeDto.cachedCodeArrayList.clear();
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
	}

	// 추가로 for cahce 목적으로 사용할 함수들 추가
	public static void clear() throws Exception {
		System.out.println("CodeDto.cachedCodeArrayList: " + CodeDto.cachedCodeArrayList);
		CodeDto.cachedCodeArrayList.clear();
	}

	// cgSeq string이 들어오면 dto로 반환하겠다는 의미
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for (CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcgSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	// 특정 용도 함수처럼 사용 (int를 주면 string으로 변환해주는 역할)
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for (CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		}
		System.out.println("rt: " + rt);
		return rt;
	}
}