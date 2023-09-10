package in.nitish.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import in.nitish.service.impl.JsonReaderImpl;

@RestController
@RequestMapping(value = "/api")
public class ReadJsonControllerNew {

	@Autowired 
	private JsonReaderImpl jsonReaderImpl;
	
	@GetMapping(value="/getdata", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> get() throws JsonProcessingException
	{
		String get4 = jsonReaderImpl.get4();
		
		return new ResponseEntity<String>(get4,HttpStatus.OK);
	}
	
}
