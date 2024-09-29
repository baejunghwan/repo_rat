//package com.zoo.infra.product;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductService {
//	// 로직 알고리즘 영역 = service
//	@Autowired
//	public ProductDao productDao;
//
//	public List<ProductDto> selectList(ProductVo productVo) {
//		return productDao.selectList(productVo);
//	}
//
//	public int insert(ProductDto productDto) {
//		return productDao.insert(productDto);
//	}
//
//	public ProductDto selectOne(ProductDto productDto) {
//		return productDao.selectOne(productDto);
//	}
////  함수 선언은 (데이터 타입, 데이터) 사용은 (하나만) : 이게 제일큰 차이점.
//
//	public int update(ProductDto productDto) {
//		return productDao.update(productDto);
//	}
//
//	public int delete(ProductDto productDto) {
//		return productDao.delete(productDto);
//	}
//
//	public int uelete(ProductDto productDto) {
//		return productDao.uelete(productDto);
//	}
//
//}
