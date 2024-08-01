package com.bootproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import helper.UploadHelper;


@RestController
public class UploadingController {
//	@Autowired  
// private UploadHelper uploadHelper;
		@PostMapping("upload-file")
		public ResponseEntity<String>   uploadFile(@RequestParam("file") MultipartFile file) {
			 System.out.println(file.getOriginalFilename());
			 System.out.println(file.getName());
			 System.out.println(file.getSize());
			 System.out.println(file.getContentType());
			 System.out.println(file.getResource());
			 try {
				if(file.isEmpty()) {
					return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("this is empty form");
				 }
				else if(!file.getContentType().equals("image/jpeg")) {
					  return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("jpg not allowed");
				  }
					
					 else {
						 boolean b  = UploadHelper.uploadFile(file);
					 
							 if(b) {
								 return ResponseEntity.ok("working");
							 }
							 
					 }
				  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			 return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error");
				}
			
			 
		}
		

