package com.zoo.infra.product;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

	public List<ProductDto> selectList(ProductVo productVo);
	public ProductDto selectOne(ProductDto productDto);
	public List<ProductDto> selectListReview(ProductDto productDto);
	public ProductDto selectOneCount(ProductDto productDto);
	public Integer selectListReviewCount(ProductDto productDto);

	// int쓰는 이유가 mybatis가 값 몇건 이렇게 정수 형식으로 보내줘서이다.
	public int insert(ProductDto productDto);
	public int update(ProductDto productDto);
	public int delete(ProductDto productDto);
	public int uelete(ProductDto productDto);
}