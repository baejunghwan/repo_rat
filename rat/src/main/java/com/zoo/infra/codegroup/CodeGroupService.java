package com.zoo.infra.codegroup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.common.config.S3Config;
import com.zoo.common.constants.Constants;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	//AWS
	@Autowired
	S3Config s3Config;

	public List<CodeGroupDto> selectList(CodeGroupVo codeGroupVo) {
		return codeGroupDao.selectList(codeGroupVo); // DAO 호출
	}

	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectOne(codeGroupDto); // DAO 호출
	}

	// 더 간결하게 작성된 selectOne 메서드 예시
	// public CodeGroupDto selectOne(CodeGroupDto codeGroupDto){
	// CodeGroupDto dto = codeGroupDao.selectOne(codeGroupDto);
	// return dto;
	// }

	//AWS 파일첨부
	public static String nowString() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.now();
		String localDateTimeString = localDateTime.format(DateTimeFormatter.ofPattern(Constants.DATETIME_FORMAT_BASIC));
		return localDateTimeString;
	}
	
	//AWS 파일첨부
	public int insert(CodeGroupDto codeGroupDto) {
	
//		for(int i=0; i<multipartFiles.length; i++) { //향상된 반복문 쓰는 이유: 데이터집합에서 하나씩 꺼낼때
//		
//			if(!multipartFiles[i].isEmpty()) {
//				
//				System.out.println("codeGroupDto.getClass().getSimpleName().toString().toLowerCase() : " + codeGroupDto.getClass().getSimpleName().toString().toLowerCase());
//				String className = codeGroupDto.getClass().getSimpleName().toString().toLowerCase();		
//				System.out.println("multipartFiles[i].getOriginalFilename() : " + multipartFiles[i].getOriginalFilename());
//				String fileName = multipartFiles[i].getOriginalFilename();
//				System.out.println("fileName.substring(fileName.lastIndexOf(\".\") + 1) : " + fileName.substring(fileName.lastIndexOf(".") + 1));
//				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
//				System.out.println("UUID.randomUUID().toString() : " + UUID.randomUUID().toString());
//				String uuid = UUID.randomUUID().toString(); // UUID = 유효아이디
//				System.out.println("uuid + \".\" + ext : " + uuid + "." + ext);
//				String uuidFileName = uuid + "." + ext;
//				System.out.println("className : " + className);
//				String pathModule = className;
//				System.out.println("UtilDateTime.nowString() : " + UtilDateTime.nowString());
//				String nowString = UtilDateTime.nowString();
//				System.out.println("nowString.substring(0,4) + \"/\" + nowString.substring(5,7) + \"/\" + nowString.substring(8,10) : " + nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10));
//				String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
//				System.out.println("pathModule + \"/\" + type + \"/\" + pathDate + \"/\" : " + pathModule + "/" + type + "/" + pathDate + "/");
//				String path = pathModule + "/" + type + "/" + pathDate + "/";
//				String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
//		        ObjectMetadata metadata = new ObjectMetadata();
//		        System.out.println("metadata.setContentLength(multipartFiles[i].getSize()) : " + metadata.setContentLength(multipartFiles[i].getSize()));
//		        metadata.setContentLength(multipartFiles[i].getSize());
//		        System.out.println("metadata.setContentType(multipartFiles[i].getContentType()) : " + metadata.setContentType(multipartFiles[i].getContentType()));
//		        metadata.setContentType(multipartFiles[i].getContentType());
//		        System.out.println(" amazonS3Client.putObject(bucket, path + uuidFileName, multipartFiles[i].getInputStream(), metadata) : " +  amazonS3Client.putObject(bucket, path + uuidFileName, multipartFiles[i].getInputStream(), metadata));
//		        amazonS3Client.putObject(bucket, path + uuidFileName, multipartFiles[i].getInputStream(), metadata);
//				
//		        String objectUrl = amazonS3Client.getUrl(bucket, path + uuidFileName).toString();
		        
//		        codeGroupDto.setPath(objectUrl);
//		        codeGroupDto.setOriginalName(fileName);
//		        codeGroupDto.setUuidName(uuidFileName);
//		        codeGroupDto.setExt(ext);
//		        codeGroupDto.setSize(multipartFiles[i].getSize());
//				
//				codeGroupDto.setTableName(tableName);
//				codeGroupDto.setType(type);
//	//			dto.setDefaultNy();
//				codeGroupDto.setSort(maxNumber + i);
//				codeGroupDto.setPseq(pSeq);
//				
//				codeGroupDao.insertUploaded(codeGroupDto);
//			}
//		}
		return codeGroupDao.insert(codeGroupDto);
		// MyBatis가 등록된 레코드 수를 정수형태로 반환
	}

	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto); 
	}

	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto); 
	}

	// 코드 그룹 복구 메서드 (Soft Delete)
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto); 
	}

	// 전체 레코드 수 조회 메서드 (페이징 용도)
	public int selectOneCount(CodeGroupVo vo) {
		return codeGroupDao.selectOneCount(vo); 
	}

	// 전체 코드 그룹 조회 메서드
	public List<CodeGroupDto> getAllCodeGroups() {
		return codeGroupDao.getAllCodeGroups(); 
	}
}