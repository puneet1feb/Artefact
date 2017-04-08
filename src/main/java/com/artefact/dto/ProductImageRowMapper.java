package com.artefact.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class ProductImageRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		List<String> images = new ArrayList<>();
		images.add(rs.getString("IMAGE_S3_LINK"));
		return images;
	}

}
