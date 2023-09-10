package in.nitish.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import in.nitish.dto.ReadJsonDto;
import in.nitish.entity.ReadJson3;
import in.nitish.entity.ReadJsonEntityMain;
import in.nitish.pojo.FileResponse;
import in.nitish.service.ReadJsonService;

@RestController
public class ReadJsonController {

	@Autowired
	private ReadJsonService readJsonService;

//	@Value("${url}")
//	private String JSON_FILE_URL;
	
	//Using ObjectMapper

	@GetMapping("/get")
	public ResponseEntity<Object> string1()

	{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		try {
			jsonNode = objectMapper.readTree(new File(
					"C:\\Users\\NKSK\\Desktop\\New SpringBoot\\2-JsonToJavaToJson\\JsonFile\\InsideJsonFile\\data.json"));
			JsonNode partnerResponse = (JsonNode) jsonNode.get("SkyResBody").get("partnerResponse");
			System.out.println("partnerResponse" + partnerResponse);
			ArrayNode trainBtwnStnsList = (ArrayNode) partnerResponse.get("trainBtwnStnsList");
			System.out.println("trainBtwnStnList" + trainBtwnStnsList);
			trainBtwnStnsList.forEach(trainBtwnStnsListNew->{
				
				ArrayNode avlClasses=(ArrayNode)trainBtwnStnsListNew.get("avlClasses");
				for(int i=0;i<avlClasses.size();i++)
				{
					System.out.println("Hi2");
					if(avlClasses.get(i).asText().equals("EV"))
					{
						avlClasses.remove(i);
					}
				}
				
			});
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String string= trainBtwnStnsList.get("arrivalTime").textValue();
		// System.out.println("String"+string);

//		for (int i = 0; i < trainBtwnStnsList.size(); i++) {
//
//			ArrayNode avlClassArrayNode = (ArrayNode) trainBtwnStnsList.get("avlClasses");
//			System.out.println("avlClassArrayNode" + avlClassArrayNode);
//			for (int j = 0; j < avlClassArrayNode.size(); j++) {
//
//				if (avlClassArrayNode.get(j).equals("EV")) {
//					avlClassArrayNode.remove(j);
//				}
//			}
//		}
		return new ResponseEntity<Object>(jsonNode, HttpStatus.OK);

	}

	//Using Simple Json
	@GetMapping("/getjson")
	public ResponseEntity<Object> string2() {

		JSONParser parser = new JSONParser();

		// JsonParser to convert JSON string into Json Object
		Object obj = null;

		try {

			obj = parser.parse(new FileReader(
					"C:\\\\Users\\\\NKSK\\\\Desktop\\\\New SpringBoot\\\\2-JsonToJavaToJson\\\\JsonFile\\\\InsideJsonFile\\\\data.json"));
			JSONObject jsonObject = (JSONObject) obj;

			// SkyResHeader

			JSONObject skyResHeaderObj = (JSONObject) jsonObject.get("SkyResHeader");
			String errMsgUsr = (String) skyResHeaderObj.get("ErrMsgUsr");
//			System.out.println("errMsgUSR" +errMsgUsr);

			String errMsgSys = (String) skyResHeaderObj.get("ErrMsgSys");
			System.out.println("errMsgSys :- " + errMsgSys);

			if (errMsgSys == "") {
				System.out.println("errMsgSys is blank");
			} else {
				// System.out.println("errMsgSys Not blank :-" +errMsgSys);
			}

			String reqRefNo = (String) skyResHeaderObj.get("ReqRefNo");
			System.out.println("reqRefNo :- " + reqRefNo);

			// SkyRespBody

			JSONObject skyResBody = (JSONObject) jsonObject.get("SkyResBody");
			System.out.println("SkyResBody" + skyResBody);

			Long errorCodeString = (Long) skyResBody.get("errorcode");
			System.out.println("SkyResBody---ErrorCodeString  -> " + errorCodeString);

			String errorDesc = (String) skyResBody.get("errorDesc");
			System.out.println("SkyResBody---errorDesc -> " + errorDesc);

			String message = (String) skyResBody.get("message");
			if (message == null) {
				System.out.println("SkyResBody---message -> " + message);
			} else {
				System.out.println("SkyResBody---message Not Null -> " + message);
			}

			String status = (String) skyResBody.get("status");
			System.out.println("SkyResBody---status -> " + status);
			// partnerResponse

			JSONObject partnerResObject = (JSONObject) skyResBody.get("partnerResponse");

			String alternateEnquiryFlag = (String) partnerResObject.get("alternateEnquiryFlag");
			System.out.println("PartnerResponse---alternateEnquiryFlag ->" + alternateEnquiryFlag);

			JSONArray arrQuotaList = (JSONArray) partnerResObject.get("quotaList");

			for (int i = 0; i < arrQuotaList.size(); i++) {
				// String object =(String)arrQuotaList.get(i);
				// System.out.println("OBJECT -> "+object);

				if (arrQuotaList.get(i).equals("SS")) {
					arrQuotaList.remove(i);
					System.out.println(arrQuotaList);
				}
			}

			JSONArray trainBtwnStnsList = (JSONArray) partnerResObject.get("trainBtwnStnsList");

			for (int i = 0; i < trainBtwnStnsList.size(); i++) {
				JSONObject obj1 = (JSONObject) trainBtwnStnsList.get(i);

				JSONArray avlClasses = (JSONArray) obj1.get("avlClasses");
				for (int j = 0; j < avlClasses.size(); j++) {
					// String avlClasses1=(String)avlClasses.get(j);
					// System.out.println(avlClasses1);
					if (avlClasses.get(j).equals("EV")) {
						avlClasses.remove(j);

					}
					System.out.println(avlClasses);
				}

				// String arrivalTime=(String) obj1.get("arrivalTime");
				// System.out.println("Arrival TIme" +arrivalTime);
				// System.out.println(arrivalTime);

			}

		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	@GetMapping("/getjson1")
	public ResponseEntity<Object> string3() {

		Object jsonResponse = readJsonService.getJsonResponse();
		return new ResponseEntity<Object>(jsonResponse, HttpStatus.OK);

	}
	
	@PostMapping("/getjson2")
	public ResponseEntity<ReadJsonDto> string4(@RequestBody ReadJsonDto readJsonDto)
	{
		ReadJsonDto jasonResponse = this.readJsonService.jsonResponse(readJsonDto);
		return new ResponseEntity<ReadJsonDto>(jasonResponse,HttpStatus.OK);
	}
	
	@GetMapping("/readjsonandsavedb")
	public ResponseEntity<ReadJsonEntityMain> readJsonEntityAndSaveDb()
	{
		ReadJsonEntityMain readJsonEntityAndSaveDb = this.readJsonService.readJsonEntityAndSaveDb();
		System.out.println("readJsonEntityAndSaveDb --->" +readJsonEntityAndSaveDb);
		return new ResponseEntity<ReadJsonEntityMain>(readJsonEntityAndSaveDb,HttpStatus.OK);
			
	}
	
	@GetMapping("/readjson3")
	public ResponseEntity<ReadJson3> readJson3(){
		
		ReadJson3 readJson3 = readJsonService.readJson3();
		
		return new ResponseEntity<ReadJson3>(readJson3,HttpStatus.OK);
	}
	
	@GetMapping("/uploadFile")
	public ResponseEntity<FileResponse> readFile(@RequestParam("file") MultipartFile file){
		System.out.println("File Name : " +file.getOriginalFilename());
		String uploadFile=null;
		try {
			
			System.out.println("File Name : " +file.getName());
			uploadFile = this.readJsonService.uploadFile(file); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<FileResponse>(new FileResponse(null, "File is not uploaded due to error on server !!"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<FileResponse>(new FileResponse(uploadFile, "File is successfully Uploaded...!!"),HttpStatus.OK);
		
//		
//		return new ResponseEntity<Object>("File Uploaded Successfully",HttpStatus.OK);
	}
	
	
	

	
	
		
}
