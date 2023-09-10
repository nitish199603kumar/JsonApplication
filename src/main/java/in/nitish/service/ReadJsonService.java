package in.nitish.service;

import org.springframework.web.multipart.MultipartFile;

import in.nitish.dto.ReadJsonDto;
import in.nitish.entity.ReadJson3;
import in.nitish.entity.ReadJsonEntityMain;

public interface ReadJsonService {
	
	Object getJsonResponse();
	
	ReadJsonDto jsonResponse(ReadJsonDto readJsonDto);
	
	ReadJsonEntityMain readJsonEntityAndSaveDb();
	
	ReadJson3 readJson3();

	String uploadFile(MultipartFile file);
	


}
