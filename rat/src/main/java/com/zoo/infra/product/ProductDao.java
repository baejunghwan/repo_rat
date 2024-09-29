//package com.zoo.infra.product;
//
//import java.util.List;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProductDao {
//
//	public List<ProductDto> selectList(ProductVo productVo);
//
////	 내가 작성한 VO
////	public List<ProductVo> selectList();
//
//	public ProductDto selectOne(ProductDto productDto);
//	// mybatics가 select일때는 값을 다 하나씩 땅땅 매핑해주고 나머지 insert,update,delete일때는 int형태로
//	// 받아준다.
//	// 이 구문의 의미는 mapper에서 쟁반을 들고 오면 dto로 넘겨주는 역할을 하는 용도.
//
//	public int insert(ProductDto productDto);
////	int쓰는 이유가 mybatis가 값 몇건 이렇게 정수 형식으로 보내줘서이다.
//
//	// 내가 임의로 작성한 update
//	public int update(ProductDto productDto);
//
//	// 내가 임의로 작성한 delete
//	public int delete(ProductDto productDto);
//
//	// 내가 임의로 작성한 uelete
//	public int uelete(ProductDto productDto);
//
//}
