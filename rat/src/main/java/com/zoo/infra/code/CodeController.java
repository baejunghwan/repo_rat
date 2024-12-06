package com.zoo.infra.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoo.infra.codegroup.CodeGroupDto;
import com.zoo.infra.codegroup.CodeGroupService;

@Controller
public class CodeController {

	@Autowired
	CodeService codeService;

	@Autowired
	private CodeGroupService codeGroupService;

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmForm")
	public String codeXdmForm(Model model, CodeVo codeVo) {
		List<CodeDto> ifcdSeq = codeService.selectList(codeVo);
		model.addAttribute("list", ifcdSeq); // list를 model에 추가

		List<CodeGroupDto> codeGroups = codeGroupService.getAllCodeGroups(); // 코드 그룹 가져오기
		model.addAttribute("codeGroups", codeGroups); // 코드 그룹을 모델에 추가
		return "xdm/v1/infra/code/codeXdmForm";
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
//		html에서 넘어온 정보가 정상적인지 확인 
//		System.out.println("codeDto.getIfcdName(): " + codeDto.getIfcdName());

		int a = codeService.insert(codeDto);
		System.out.println("codeService.insert(codeDto): " + a);

		return "redirect:/xdm/v1/infra/code/codeXdmList";
		// return값이 아니라 주소를 써넣어야 한다.
//		-----
//			Inst에서 CodeDto의 codeDto 함수를 끌어와서 사용
//			중간에 sysout은 html에서 서버쪽으로 정보가 넘어가는지 확인하는 로그	
//			redirect:는 내가 Inst하는 과정을 클라이언트한테 보여줄 필요가 없으니까 대체할 화면으로 사용하는 목적.
	}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmMfom")
	public String codeXdmMfom(CodeDto codeDto, Model model) {
		model.addAttribute("item", codeService.selectOne(codeDto));
		return "xdm/v1/infra/code/codeXdmMfom";
	}

////	#내가 임의로 Update 작성한 부분 
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmUpdate")
	public String codeXdmUpdate(CodeDto codeDto) {
//		html에서 넘어온 정보가 정상적인지 확인 
		System.out.println("codeDto.getIfcdSeq(): " + codeDto.getIfcdSeq());

		int b = codeService.update(codeDto);
		System.out.println("codeService.update(codeDto): " + b);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

	//// #내가 임의로 delete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmDelete")
	public String codeXdmDelete(CodeDto codeDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("codeDto.getIfcdSeq(): " + codeDto.getIfcdSeq());

		int c = codeService.delete(codeDto);
		System.out.println("codeService.delete(codeDto): " + c);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

	//// #내가 임의로 uelete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmUelete")
	public String codeXdmUelete(CodeDto codeDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("codeDto.getIfcdSeq(): " + codeDto.getIfcdSeq());

		int d = codeService.uelete(codeDto);
		System.out.println("codeService.uelete(codeDto): " + d);
		return "redirect:/xdm/v1/infra/code/codeXdmList";
	}

//	codeService.update(codeDto);
//	System.out.println("codeService.update(codeDto): " + codeService.update(codeDto));

//		@RequestMapping(value="/v1/infra/code/codeXdmMfom") 
//		public String codeXdmMfom(CodeDto codeDto, Model model) { 
//			CodeDto dto = codeService.selectOne(codeDto); 
//			model.addAttribute("item", dto); 
//			return "/xdm/v1/infra/code/codeXdmMfom";		
//}

	@RequestMapping(value = "/xdm/v1/infra/code/codeXdmList")
	public String codeXdmList(@ModelAttribute("vo") CodeVo codeVo, Model model) throws Exception {
//		System.out.println("Initial values: thisPage = " + codeVo.getThisPage() + ", rowNumToShow = "
//				+ codeVo.getRowNumToShow() + ", pageNumToShow = " + codeVo.getPageNumToShow());
//
//		// 페이지네이션을 위한 파라미터 설정
//		codeVo.setStartRnumForMysql((codeVo.getThisPage() - 1) * codeVo.getRowNumToShow());
//
//		// 리스트 조회
//		List<CodeDto> ifcdSeq = codeService.selectList(codeVo);
//		for (CodeDto codeDto : ifcdSeq) {
//			System.out.println("CodeDto codeDto : " + codeDto.getModDateTime());
//		}
//
//		model.addAttribute("list", codeService.selectList(codeVo));
////		for (int i=0; i<10; i++) {
////			System.out.println("ifcdSeq : " + codeService.selectList(codeVo).get(i));
////		}
//
//		// totalRows를 조회하여 확인
//		int totalRows = codeService.selectOneCount(codeVo);
//		System.out.println("Total rows from database: " + totalRows);
//
//		codeVo.setParamsPaging(codeService.selectOneCount(codeVo));
//
//		if (codeVo.getTotalRows() > 0) {
////			List<CodeGroupDao> list = codeGroupService.selectList(vo));
//			model.addAttribute("list", codeService.selectList(codeVo));
//		}

		//
		System.out.println("Initial values: thisPage = " + codeVo.getThisPage() + ", rowNumToShow = "
				+ codeVo.getRowNumToShow() + ", pageNumToShow = " + codeVo.getPageNumToShow());

// 페이지네이션을 위한 파라미터 설정
		codeVo.setStartRnumForMysql((codeVo.getThisPage() - 1) * codeVo.getRowNumToShow());

// 리스트 조회
		List<CodeDto> ifcgSeq = codeService.selectList(codeVo);
		model.addAttribute("list", ifcgSeq);

// 조회한 리스트 크기 확인
		System.out.println("Fetched list size: " + ifcgSeq.size());

// totalRows를 조회하여 확인
		int totalRows = codeService.selectOneCount(codeVo);
		System.out.println("Total rows from database: " + totalRows);

// 페이지네이션 세부사항 설정
		codeVo.setParamsPaging(totalRows);

		// 페이지네이션 상태 확인
		System.out.println("After pagination setup: ");
		System.out.println("rowNumToShow: " + codeVo.getRowNumToShow());
		System.out.println("pageNumToShow: " + codeVo.getPageNumToShow());
		System.out.println("totalRows: " + codeVo.getTotalRows());
		System.out.println("totalPages: " + codeVo.getTotalPages());
		System.out.println("startPage: " + codeVo.getStartPage());
		System.out.println("endPage: " + codeVo.getEndPage());

		
		//공공데이터 API
	    StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/CovidDagnsRgntProdExprtStusService/getCovidDagnsRgntProdExprtStusInq"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=7%2FqfkBurY8fWkrCwDHilm5Pi8IkL4BXdxifBaclLvJ2ZKmEku5y6JasjAA0WtJAPAydvDlhc%2FwJdRXjKs0xLUw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("3", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) default : xml*/
        urlBuilder.append("&" + URLEncoder.encode("YYYY","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*년도*/
        urlBuilder.append("&" + URLEncoder.encode("MM","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*실적월*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        //Slack구문 추가 (Json형식의 데이터를 뽑아내는 코드)
    	ObjectMapper objectMapper = new ObjectMapper();
		JsonNode node = objectMapper.readTree(sb.toString());
		
		System.out.println("node.get(\"header\").get(\"resultCode\").asText(): " + node.get("header").get("resultCode").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("header").get("resultMsg").asText());
		System.out.println("node.get(\"header\").get(\"resultMsg\").asText(): " + node.get("body").get("items").get(0).get("KIT_PROD_QTY").asText());
        
		return "xdm/v1/infra/code/codeXdmList";
	}

}
