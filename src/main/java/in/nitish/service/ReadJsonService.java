package in.nitish.service;

import in.nitish.dto.ReadJsonDto;
import in.nitish.entity.ReadJsonEntityMain;

public interface ReadJsonService {
	
	Object getJsonResponse();
	ReadJsonDto jsonResponse(ReadJsonDto readJsonDto);
	
	ReadJsonEntityMain readJsonEntityAndSaveDb();

}
