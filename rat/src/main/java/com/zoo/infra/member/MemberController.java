package com.zoo.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoo.infra.codegroup.CodeGroupDto;
import com.zoo.infra.codegroup.CodeGroupVo;

@Controller
public class MemberController {

		@Autowired
		MemberService memberService;

//		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmList")
//		public String memberXdmList(Model model, MemberVo memberVo) {
//			List<MemberDto> memberSeq = memberService.selectList(memberVo);
//			for (MemberDto memberDto : memberSeq) {
//				System.out.println("MemberDto memberDto : " + memberDto.getModDateTime());
//			}
//
//			model.addAttribute("list", memberService.selectList(memberVo));
////			for (int i=0; i<10; i++) {
////				
////				System.out.println("ifcgSeq : " + memberService.selectList(memberVo).get(i));
////			}
//			
//			return "/xdm/v1/infra/member/memberXdmList";	
//		}

		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmForm")
		public String memberXdmForm() {
			
			return "/xdm/v1/infra/member/memberXdmForm";
			
		}

		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmInst")
		public String memberXdmInst(MemberDto memberDto) {
//			html에서 넘어온 정보가 정상적인지 확인 
			System.out.println("memberDto.getMemberName(): " + memberDto.getMemberName());

			int a = memberService.insert(memberDto);
			System.out.println("memberService.insert(memberDto): " + a);

			return "redirect:/xdm/v1/infra/member/memberXdmList";
			// return값이 아니라 주소를 써넣어야 한다.
//			-----
//				Inst에서 MemberDto의 memberDto 함수를 끌어와서 사용
//				중간에 sysout은 html에서 서버쪽으로 정보가 넘어가는지 확인하는 로그	
//				redirect:는 내가 Inst하는 과정을 클라이언트한테 보여줄 필요가 없으니까 대체할 화면으로 사용하는 목적.
		}

		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmMfom")
		public String memberXdmMfom(MemberDto memberDto, Model model) {
			model.addAttribute("item", memberService.selectOne(memberDto));
			System.out.println("memberMfom Gender : " + memberService.selectOne(memberDto).getMemberGender());
			return "/xdm/v1/infra/member/memberXdmMfom";
		}

		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmUpdate")
		public String memberXdmUpdate(MemberDto memberDto) {
//			html에서 넘어온 정보가 정상적인지 확인 
			System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq());

			int b = memberService.update(memberDto);
			System.out.println("memberService.update(memberDto): " + b);
			return "redirect:/xdm/v1/infra/member/memberXdmList";
		}

		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmDelete")
		public String memberXdmDelete(MemberDto memberDto) {
			// html에서 넘어온 정보가 정상적인지 확인
			System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq());

			int c = memberService.delete(memberDto);
			System.out.println("memberService.delete(memberDto): " + c);
			return "redirect:/xdm/v1/infra/member/memberXdmList";
		}

		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmUelete")
		public String memberXdmUelete(MemberDto memberDto) {
			// html에서 넘어온 정보가 정상적인지 확인
			System.out.println("memberDto.getMemberSeq(): " + memberDto.getMemberSeq());

			int d = memberService.uelete(memberDto);
			System.out.println("memberService.uelete(memberDto): " + d);
			return "redirect:/xdm/v1/infra/member/memberXdmList";
		}
		
		@RequestMapping(value = "/xdm/v1/infra/member/membersigninXdmForm")
		public String membersigninXdmForm() {
			
			return "/xdm/v1/infra/member/membersigninXdmForm";
		}
		
		@RequestMapping(value = "/xdm/v1/infra/member/memberXdmList")
		public String memberXdmList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception{
			
			/* 초기값 세팅이 없는 경우 사용 */
//			vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
//			vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));

			List<MemberDto> memberSeq = memberService.selectList(vo);
			for (MemberDto memberDto : memberSeq) {
				System.out.println("MemberDto memberDto : " + memberDto.getModDateTime());
			}
			
			model.addAttribute("list", memberService.selectList(vo));
//			for (int i=0; i<10; i++) {
//			
//			System.out.println("ifcgSeq : " + codeGroupService.selectList(vo).get(i));
//		}
			
			
			vo.setParamsPaging(memberService.selectOneCount(vo));
			
			if (vo.getTotalRows() > 0) {
//				List<CodeGroupDao> list = codeGroupService.selectList(vo));
				model.addAttribute("list", memberService.selectList(vo));
			}
			
//			return pathCommonXdm + "codeGroupXdmList";
			return "/xdm/v1/infra/member/memberXdmList";
	  	}
		
	}