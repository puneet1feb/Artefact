package com.artefact.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.RowSetWarning;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.artefact.dao.ProductDAO;
import com.artefact.dto.CarouselDTO;
import com.artefact.dto.ProductDTO;
import com.artefact.dto.Status;
import com.artefact.service.ArtefactServices;

@RestController
public class ArtefactController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ArtefactServices artefactServices;
	
	

	@RequestMapping(value = "/carousel", method = RequestMethod.GET)
	public ResponseEntity<CarouselDTO> getHomeCarousel() {

		CarouselDTO carousel = new CarouselDTO();
		String[] image = new String[3];
		String[] imageText = new String[3];
		carousel.setImage(image);
		carousel.setImageText(imageText);
		/*image[0] = "https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg";
		imageText[1] = "image 01";
		image[1] = "https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image2.jpg";
		imageText[1] = "image 02";
		image[2] = "https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image3.jpg";
		imageText[2] = "image 03";*/
		
		List<String> images = productDAO.getCarouselImages();
		
		image[0] = images.get(0);
		imageText[0] = StringUtils.substringAfter(images.get(0), "images/");
		image[1] = images.get(1);
		imageText[1] = StringUtils.substringAfter(images.get(1), "images/");
		image[2] = images.get(2);
		imageText[2] = StringUtils.substringAfter(images.get(2), "images/");
		
		return new ResponseEntity<CarouselDTO>(carousel, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryId}/{pageNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getProductList(@PathVariable String categoryId,
			@PathVariable String pageNumber) {
		
		List<ProductDTO> products = new ArrayList<>();
		int pageNum = Integer.valueOf(pageNumber);
		int startIdx;
		int endIdx;
		
		if(pageNum == 0) {
			startIdx = 0;
			endIdx = 9999999;
		} else {
			startIdx = (12 * (pageNum - 1)) + 1;
			endIdx = (12 * (pageNum - 1)) +  +12;
		}
		products = productDAO.getProductsList(Integer.valueOf(categoryId), startIdx, endIdx);
		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/admin/product", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Status> addProduct(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "text") String text, @RequestParam(value = "name") String name,
			@RequestParam(value = "category") int category, @RequestParam(value = "priority") int priority, 
			@RequestParam(value = "ebayLink") String ebayLink, @RequestParam(value = "amazonLink") String amazonLink,
			HttpServletRequest request) {
		ProductDTO product = new ProductDTO(0, null, category, priority, text, name, ebayLink, amazonLink);
		
		int res = productDAO.addProduct(product);
		
		if(res > 0) {
			//upload image to AWS
			String link = artefactServices.addProductImage(name, file);
			productDAO.addProductImage(res, link);
			
			
		}
		Status status = new Status(res, "");
		
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/product", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Status> removeproduct(@RequestBody String[] products) {
		
		System.out.println(products);
		
		
		StringBuffer statusMsg = new StringBuffer();
		
		
		for(String productId : products) {
			String imageLink = productDAO.deleteProduct(Integer.valueOf(productId));
			boolean deleted = artefactServices.removeProductImage(imageLink);
			if(deleted) {
				statusMsg.append("Removed " + productId + "		");
			} else {
				statusMsg.append("Failed " + productId + "		");
			}
		}
		
		Status status = new Status(000, statusMsg.toString());
		
		return new ResponseEntity<Status>(status, HttpStatus.OK);
		
	}

}
