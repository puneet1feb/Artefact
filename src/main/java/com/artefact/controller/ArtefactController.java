package com.artefact.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.artefact.dto.CarouselDTO;
import com.artefact.dto.ProductDTO;

@RestController
public class ArtefactController {

	@RequestMapping(value = "/carousel", method = RequestMethod.GET)
	public ResponseEntity<CarouselDTO> getHomeCarousel() {

		CarouselDTO carousel = new CarouselDTO();
		String[] image = new String[3];
		String[] imageText = new String[3];
		carousel.setImage(image);
		carousel.setImageText(imageText);
		image[0] = "https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg";
		imageText[1] = "image 01";
		image[1] = "https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image2.jpg";
		imageText[1] = "image 02";
		image[2] = "https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image3.jpg";
		imageText[2] = "image 03";
		return new ResponseEntity<CarouselDTO>(carousel, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryId}/{pageNumber}", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getProductList(@PathVariable String categoryId,
			@PathVariable String pageNumber) {

		List<ProductDTO> products = new ArrayList<>();

		ProductDTO product = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", null, "http://www.amazon.co.uk");

		ProductDTO product1 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", "http://www.ebay.co.uk", null);

		ProductDTO product2 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", "http://www.ebay.co.uk", null);

		ProductDTO product3 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", "http://www.ebay.co.uk", null);

		ProductDTO product4 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", null, "http://www.amazon.co.uk");

		ProductDTO product5 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", "http://www.ebay.co.uk", null);

		ProductDTO product6 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", "http://www.ebay.co.uk", null);

		ProductDTO product7 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", "http://www.ebay.co.uk", null);

		ProductDTO product8 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", null, "http://www.amazon.co.uk");

		ProductDTO product9 = new ProductDTO(
				"https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/image1.jpg",
				"Product 1", "http://www.ebay.co.uk", null);
		products.add(product);
		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);
		products.add(product6);
		products.add(product7);
		products.add(product8);
		products.add(product9);

		return new ResponseEntity<List<ProductDTO>>(products, HttpStatus.OK);
	}

}
