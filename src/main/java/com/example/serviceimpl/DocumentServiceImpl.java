package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Document;
import com.example.repository.DocumentRepository;
import com.example.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public String addDocument(Document document) {
		
		Document savedDocument = documentRepository.save(document);
		
		return "Document Saved :" + savedDocument.getDocumentId();
	}

}
