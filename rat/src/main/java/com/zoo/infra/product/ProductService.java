package com.zoo.infra.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;

	public List<ProductDto> selectList(ProductVo productVo) {
		return productDao.selectList(productVo);
	}
	public ProductDto selectOne(ProductDto productDto) {
		return productDao.selectOne(productDto);
	}
	
//	public int selectOneCount(ProductVo productVo) {
//		return productDao.selectOneCount(productVo);
//	}

	//Review
	public List<ProductDto> selectListReview(ProductDto productDto) {
		return productDao.selectListReview(productDto);
	}

	public Integer selectListReviewCount(ProductDto productDto) {
		return productDao.selectListReviewCount(productDto);
	}

	// CRUD
	public int insert(ProductDto productDto) {
		return productDao.insert(productDto);
	}

	public int update(ProductDto productDto) {
		return productDao.update(productDto);
	}

	public int delete(ProductDto productDto) {
		return productDao.delete(productDto);
	}

	public int uelete(ProductDto productDto) {
		return productDao.uelete(productDto);
	}
}