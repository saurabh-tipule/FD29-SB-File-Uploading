package com.example.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Document;
import com.example.service.DocumentService;

@RestController
@RequestMapping(value = "/doc-api")
public class DocumentController {

     public void m1()
     {

     }
 

	@Autowired
	private DocumentService documentService;

	@PostMapping(value = "/documents")
	public ResponseEntity<String> addDocument(
			@RequestPart MultipartFile adharCard, @RequestPart MultipartFile panCard,
			@RequestPart MultipartFile drivingLicense, @RequestPart MultipartFile passport)
	{
		Document document = new Document();

		try {

			document.setAdharCard(adharCard.getBytes());
			document.setPanCard(panCard.getBytes());
			document.setDrivingLicense(drivingLicense.getBytes());
			document.setPassport(passport.getBytes());

			String msg = documentService.addDocument(document);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
