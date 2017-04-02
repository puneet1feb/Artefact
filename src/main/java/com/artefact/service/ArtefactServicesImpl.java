package com.artefact.service;

import java.io.File;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Resource
public class ArtefactServicesImpl implements ArtefactServices {

	@Override
	public String addProductImage(MultipartFile multiPartfile) {
		
		StringBuffer link = new StringBuffer();
		link.append("https://s3-us-west-2.amazonaws.com/elasticbeanstalk-us-west-2-970839045576/images/");
		link.append(multiPartfile.getOriginalFilename());
		
		String bucketName     = "elasticbeanstalk-us-west-2-970839045576/images";
		String keyName        = multiPartfile.getOriginalFilename();
		
		AWSCredentials credentials = new BasicAWSCredentials("AKIAI2724I5CUF4ATFZA", "a8cOKlKvKJkMxpzYIPBkgYraIEFd2lej+3QaiB53");
		AmazonS3 s3client = new AmazonS3Client(credentials);
        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            
            File file = new File(multiPartfile.getName());
            
            try{
            	FileUtils.writeByteArrayToFile(file, multiPartfile.getBytes());
            }
            catch(Exception ex) {
            	//Do nothig
            }
            
            s3client.putObject(new PutObjectRequest(
            		                 bucketName, keyName, file).withCannedAcl(CannedAccessControlList.PublicRead));

         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        }
        
		return link.toString();
	}
	

}
