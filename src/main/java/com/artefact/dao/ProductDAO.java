package com.artefact.dao;

import java.util.List;

import com.artefact.dto.ProductDTO;

public interface ProductDAO {
	
	public int addProduct(ProductDTO product);
	
	public int addProductImage(int id, String link);
	
	public int updateProduct(ProductDTO product);
	
	public List<String> getCarouselImages();
	
	public boolean deleteProduct(ProductDTO product);
	
	public List<ProductDTO> getProductsList(int category, int startIndex, int endIndex);
}
