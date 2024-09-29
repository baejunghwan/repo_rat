package com.zoo.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.infra.codegroup.CodeGroupVo;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	@Autowired
	public CodeDao codeDao;

	public List<CodeDto> selectList(CodeVo codeVo) {
		return codeDao.selectList(codeVo);
	}

	public int insert(CodeDto codeDto) {
//		System.out.println("Inst 확인 : ");
		return codeDao.insert(codeDto);
//		mybatics가 정수형태로 값을 보내서 int 사용함
	}

	public CodeDto selectOne(CodeDto codeDto) {
		return codeDao.selectOne(codeDto);
	}
//	밑 구문을 더 간결하게 작성한것
//	public CodeDto selectOne(CodeDto codeDto){
//		CodeDto dto = codeDao.selectOne(codeDto);
//		return dto;
//	}
	public int update(CodeDto codeDto) {
		return codeDao.update(codeDto);
	}

	public int delete(CodeDto codeDto) {
		return codeDao.delete(codeDto);
	}

	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}
	
	//paging
		public int selectOneCount(CodeVo vo) { 
	    	return codeDao.selectOneCount(vo); 
	    }
	
	//for cache
	//서버올라갈떄 특정함수를 cache 에 올리고 싶다
    @PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) codeDao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
    //추가로 for cahce 목적으로 사용할 함수들 추가함
    public static void clear() throws Exception {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	// cgSeq string이 들어오면 dto로 반환하겠다는 의미
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcgSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}
	
	public static String selectOneCachedCode(int memberGender) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcgSeq().equals(Integer.toString(memberGender))) {
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		}
		System.out.println("rt: " + rt);
		return rt;
	}
}
