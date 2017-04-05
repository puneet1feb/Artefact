package com.artefact.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.artefact.dto.ProductDTO;
import com.artefact.dto.ProductImageRowMapper;

public class ProductJDBCTemplate implements ProductDAO {

	private JdbcTemplate jdbcTemplateObject;

	public ProductJDBCTemplate(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public int addProduct(ProductDTO product) {
		int id = 0;
		/*String SQL = "INSERT INTO PRODUCT(CATEGORY_ID, PRODUCT_NAME, PRODUCT_DESC, EBAY_LINK, AMAZON_LINK) VALUES (?, ?, ?, ?, ?)";
		int return1 = jdbcTemplateObject.update(SQL, product.getCategory(), product.getText(), product.getText(),
				product.getEbayLink(), product.getAmazonLink());*/
		
		/*String SQL = "{? = CALL INSERT_PRODUCT( ?,?,?,?,?,?)}";
		
		id =jdbcTemplateObject.update(SQL, product.getText(), product.getText(), product.getEbayLink(), product.getAmazonLink()
				, product.getCategory(), product.getPriority());
		*/
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplateObject).withProcedureName("INSERT_PRODUCT");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("PNAME", product.getName());
		inParamMap.put("PDESC", product.getText());
		inParamMap.put("P_EBAY_LINK", product.getEbayLink());
		inParamMap.put("P_AMAZON_LINK", product.getAmazonLink());
		inParamMap.put("P_CATEGORY", product.getCategory());
		inParamMap.put("P_PRIORITY", product.getPriority());
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);

		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		
		
		 Iterator<Entry<String, Object>> it = simpleJdbcCallResult.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
		        String key = (String) entry.getKey();
		        Object value = (Object) entry.getValue();
		        
		        if(StringUtils.equals(key, "P_ID")) {
		        	id = (Integer) value;
		        }
		        
		    }
		    System.out.println(" id ==   " + id);
		return id;
	}

	@Override
	public int updateProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductDTO> getProductsList(int category, int startIndex, int endIndex) {
		String SQL = "SELECT PROD.PRODUCT_ID, PROD_PRIORITY, CATEGORY_ID, PRODUCT_NAME, PRODUCT_DESC, EBAY_LINK, IMAGE_S3_LINK, EBAY_LINK FROM PRODUCT PROD "
				+"LEFT OUTER JOIN PRODUCT_IMAGES IMAGE ON PROD.PRODUCT_ID = IMAGE.PRODUCT_ID WHERE CATEGORY_ID = ? ORDER BY PROD_PRIORITY ASC LIMIT ?,?";
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(SQL, new Object[]{category,startIndex,endIndex});
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		for (Map row : rows) {
			ProductDTO product = new ProductDTO((Integer)row.get("PRODUCT_ID"), (String)row.get("IMAGE_S3_LINK"), (Integer)row.get("CATEGORY_ID"), 
					(Integer)row.get("PROD_PRIORITY"), (String)row.get("PRODUCT_DESC"), (String)row.get("PRODUCT_NAME"), (String)row.get("EBAY_LINK"), (String)row.get("EBAY_LINK"));
			products.add(product);
		}
		return products;
	}

	@Override
	public int addProductImage(int id, String link) {
		String SQL = "INSERT INTO PRODUCT_IMAGES(PRODUCT_ID, IMAGE_S3_LINK) VALUES (?, ?)";
		int return1 = jdbcTemplateObject.update(SQL, id, link);
		return return1;
		
	}

	@Override
	public List<String> getCarouselImages() {
		String SQL = "select IMAGE_ID, PRODUCT_ID, IMAGE_S3_LINK from PRODUCT_IMAGES ORDER BY IMAGE_ID DESC LIMIT 3";
		List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(SQL);
		List<String> images = new ArrayList<String>();
		for (Map row : rows) {
			images.add((String)row.get("IMAGE_S3_LINK"));
		}
		return images;
	}

}
