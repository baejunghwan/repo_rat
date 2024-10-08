package com.zoo.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/xdm/v1/infra/product/productXdmList")
	public String productXdmList(Model model, ProductVo productVo) {
		List<ProductDto> ifcgSeq = productService.selectList(productVo);
		for (ProductDto productDto : ifcgSeq) {
			System.out.println("ProductDto productDto : " + productDto.getModDateTime());
		}

		model.addAttribute("list", ifcgSeq);
		model.addAttribute("vo", productVo); // 추가함
		return "/xdm/v1/infra/product/productXdmList";
	}

	@RequestMapping(value = "/xdm/v1/infra/product/productXdmForm")
	public String productXdmForm() {

		return "/xdm/v1/infra/product/productXdmForm";

	}

	@RequestMapping(value = "/xdm/v1/infra/product/productXdmInst")
	public String productXdmInst(ProductDto productDto) {
//			html에서 넘어온 정보가 정상적인지 확인 
		System.out.println("productDto.getProductName(): " + productDto.getProductName());

		int a = productService.insert(productDto);
		System.out.println("productService.insert(productDto): " + a);

		return "redirect:/xdm/v1/infra/product/productXdmList";
		// return값이 아니라 주소를 써넣어야 한다.
//			-----
//				Inst에서 ProductDto의 productDto 함수를 끌어와서 사용
//				중간에 sysout은 html에서 서버쪽으로 정보가 넘어가는지 확인하는 로그	
//				redirect:는 내가 Inst하는 과정을 클라이언트한테 보여줄 필요가 없으니까 대체할 화면으로 사용하는 목적.
	}

	@RequestMapping(value = "/xdm/v1/infra/product/productXdmMfom")
	public String productXdmMfom(ProductDto productDto, Model model) {
		model.addAttribute("item", productService.selectOne(productDto));
		return "/xdm/v1/infra/product/productXdmMfom";
	}

////		#내가 임의로 Update 작성한 부분 
	@RequestMapping(value = "/xdm/v1/infra/product/productXdmUpdate")
	public String productXdmUpdate(ProductDto productDto) {
//			html에서 넘어온 정보가 정상적인지 확인 
		System.out.println("productDto.getProductSeq(): " + productDto.getProductSeq());

		int b = productService.update(productDto);
		System.out.println("productService.update(productDto): " + b);
		return "redirect:/xdm/v1/infra/product/productXdmList";
	}

	//// #내가 임의로 delete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/product/productXdmDelete")
	public String productXdmDelete(ProductDto productDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("productDto.getProductSeq(): " + productDto.getProductSeq());

		int c = productService.delete(productDto);
		System.out.println("productService.delete(productDto): " + c);
		return "redirect:/xdm/v1/infra/product/productXdmList";
	}

	//// #내가 임의로 uelete 작성한 부분
	@RequestMapping(value = "/xdm/v1/infra/product/productXdmUelete")
	public String productXdmUelete(ProductDto productDto) {
		// html에서 넘어온 정보가 정상적인지 확인
		System.out.println("productDto.getProductSeq(): " + productDto.getProductSeq());

		int d = productService.uelete(productDto);
		System.out.println("productService.uelete(productDto): " + d);
		return "redirect:/xdm/v1/infra/product/productXdmList";
	}
}
