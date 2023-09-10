package in.nitish.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;


import in.nitish.dto.ReadJsonDto;
import in.nitish.entity.ReadJson3;
import in.nitish.entity.ReadJsonEntity;
import in.nitish.entity.ReadJsonEntityMain;
import in.nitish.pojo.ApiResponse;
import in.nitish.pojo.BookingResponseList1;
import in.nitish.pojo.BookingResponseList2;
import in.nitish.pojo.SkyResHeader;
import in.nitish.repository.ReadJson3Repo;
import in.nitish.service.ReadJsonService;

@Service
public class JsonReaderImpl implements ReadJsonService {
	public static final Logger LOGGER=LoggerFactory.getLogger(JsonReaderImpl.class);

//	@Value("${url1}")
//	private String JSON_FILE_URL;
	
	@Autowired
	private ReadJson3Repo readJson3Repo;

	// getjson1
	@Override
	public Object getJsonResponse() {

		JSONParser parser = new JSONParser();
		Object object = null;
		try {
			 object = parser.parse(new FileReader(
			 "C:\\Users\\NKSK\\Desktop\\New SpringBoot\\2-JsonToJavaToJson\\JsonFile\\InsideJsonFile\\data.json"));
//			object = parser.parse(new FileReader(JSON_FILE_URL));

			JSONObject jsonObject = (JSONObject) object;
			JSONObject skyResHeaderObject = (JSONObject) jsonObject.get("SkyResHeader");
			String skyRefNoString = (String) skyResHeaderObject.get("SkyRefNo");
			System.out.println("skyRefNoString ->" + skyRefNoString);

			JSONObject skyResBody = (JSONObject) jsonObject.get("SkyResBody");
			JSONObject partnerResObject = (JSONObject) skyResBody.get("partnerResponse");
			JSONArray trainBtwnStnsList = (JSONArray) partnerResObject.get("trainBtwnStnsList");
			for (int i = 0; i < trainBtwnStnsList.length(); i++) {
				JSONObject obj1 = (JSONObject) trainBtwnStnsList.get(i);

				JSONArray avlClasses = (JSONArray) obj1.get("avlClasses");
				for (int j = 0; j < avlClasses.length(); j++) {
					if (avlClasses.get(j).equals("EV")) {
						avlClasses.remove(j);

					}
					// System.out.println(avlClasses);
				}

			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;

	}

	public ReadJsonEntity dtoToReadJsonEntity(ReadJsonDto readJsonDto) {
		ReadJsonEntity readJsonEntity = new ReadJsonEntity();
		readJsonEntity.setChannel_id(readJsonDto.getChannel_id());
		return readJsonEntity;

	}

	public ReadJsonDto readJsonEntityToDto(ReadJsonEntity readJsonEntity) {
		ReadJsonDto readJsonDto = new ReadJsonDto();
		readJsonDto.setChannel_id(readJsonEntity.getChannel_id());
		return readJsonDto;

	}

	// getjson2
	@Override
	public ReadJsonDto jsonResponse(ReadJsonDto readJsonDto) {

		ReadJsonDto string = readJsonDto;
//		if(readJsonDto.getChannel_id().contains("ANDROID"))
//		{
//			System.out.println("ANDROID");
//		}else {
//			System.out.println("Not ANDROID");
//		}

		JSONParser parser = new JSONParser();
		Object object = null;
		try {
			
			
			
			object = parser.parse(new FileReader(
					"C:\\\\Users\\\\NKSK\\\\Desktop\\\\New SpringBoot\\\\2-JsonToJavaToJson\\\\JsonFile\\\\InsideJsonFile\\\\data.json"));
//			object = parser.parse(new FileReader(JSON_FILE_URL));

			JSONObject jsonObject = (JSONObject) object;
			JSONObject skyResHeaderObject = (JSONObject) jsonObject.get("SkyResHeader");
			String skyRefNoString = (String) skyResHeaderObject.get("SkyRefNo");
			System.out.println("skyRefNoString ->" + skyRefNoString);

			JSONObject skyResBody = (JSONObject) jsonObject.get("SkyResBody");
			if (readJsonDto.getChannel_id().contains("ANDROID")) {

				JSONObject partnerResObject = (JSONObject) skyResBody.get("partnerResponse");
				JSONArray trainBtwnStnsList = (JSONArray) partnerResObject.get("trainBtwnStnsList");
				for (int i = 0; i < trainBtwnStnsList.length(); i++) {
					JSONObject obj1 = (JSONObject) trainBtwnStnsList.get(i);

					JSONArray avlClasses = (JSONArray) obj1.get("avlClasses");
					for (int j = 0; j < avlClasses.length(); j++) {
						if (avlClasses.get(j).equals("EV")) {
							avlClasses.remove(j);

						}
						System.out.println("avlClasses" + avlClasses);
					}

				}
			} else {
				System.out.println("NOT");
			}

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return string;

	}

	@Override
	public ReadJsonEntityMain readJsonEntityAndSaveDb() {
		
		ObjectMapper objectMapper=new ObjectMapper();
		ReadJsonEntityMain readJsonEntityMain=null;
		JsonNode jsonNode = null;
		try {
			jsonNode = objectMapper.readTree(new File(".//data3.json"));
			
			
			Object object=objectMapper.writeValueAsString(jsonNode);
			System.out.println("add git" +object);
			
						//1
			
			/*
			 jsonNode = objectMapper.readTree(new File(".//data2.json")).get("booking_details");
			 System.out.println("JsonNode -> "+jsonNode);
			 JsonNode booking_details_obj = objectMapper.readTree(jsonNode.asText());
			 System.out.println("booking_details_obj" +booking_details_obj);
			 String total_fare = booking_details_obj.get("total_fare").asText();
			 System.out.println("total_fare ->" +total_fare);
			 System.out.println("trainName ---> "+objectMapper.readTree(jsonNode.asText()).get("trainName").asText());
			 
			 */
			 
						//2
		    /*	
			jsonNode = objectMapper.readTree(new File(".//data2.json"));
			System.out.println("JSONNode -> " +jsonNode);
			String errCode = jsonNode.get("errCode").asText();
			System.out.println("errCode --->" +errCode);
			String booking_details = jsonNode.get("booking_details").asText();
			System.out.println("Booking_Details " +booking_details);
			JsonNode bookingDetailsJsonObj = objectMapper.readTree(booking_details);
			System.out.println("bookingDetailsJsonObj -> "+bookingDetailsJsonObj );
			String pnr=bookingDetailsJsonObj.get("pnr").asText();
			System.out.println("pnr--> " +pnr);	
		    */	
						//3
	        /*	
			String jsonString12="{\n"
					+ "    \"svrId\": \"001\",\n"
					+ "    \"reqRefNo\": \"62289430027428\",\n"
					+ "    \"skyRefNo\": \"1668776778146\",\n"
					+ "    \"procStatus\": \"1\",\n"
					+ "    \"errCode\": \"00\",\n"
					+ "    \"errMsgSys\": \"Successfull\",\n"
					+ "    \"errMsgUsr\": \"Successfull\",\n"
					+ "    \"booking_details\": \"{\\\"reservationId\\\":\\\"100003822781535\\\",\\\"pnr\\\":\\\"4440643791\\\",\\\"trainName\\\":\\\"KAVERI EXPRESS\\\",\\\"total_fare\\\":145,\\\"trainNo\\\":\\\"16021\\\"}\"\n"
					+ "}";
			
			JsonNode readTree = objectMapper.readTree(jsonString12);
			System.out.println("readtree "+readTree);
			String booking_details = readTree.get("booking_details").asText();
			System.out.println("booking_details "+booking_details);
			String trainName = objectMapper.readTree(booking_details).get("trainName").asText();
			System.out.println("trainName" +trainName);
			*/
		    
		        		//4 
			
				 jsonNode = objectMapper.readTree(new File(".//data1.json"));
				  String str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode );
				  System.out.println("STR----->" +str);
				  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
				  System.out.println("JSONNode aaa -> " +jsonNode); 
				  readJsonEntityMain=objectMapper.readValue(jsonNode.toString(), ReadJsonEntityMain.class);
				  System.out.println("READJSONENTITYMAIN INSIDE  --->" +readJsonEntityMain); //Here response in java object(Class)
				  String writeValueAsString = objectMapper.writeValueAsString(jsonNode); 	// Already Json data into String but converting into String
				  String readJsonEntityMainAsString = objectMapper.writeValueAsString(readJsonEntityMain); //Here readjsonentity in java object ,Convert that object into string
				  System.out.println("writeValueAsString ---> " +readJsonEntityMainAsString);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("READJSONENTITYMAIN OUTSIDE  --->" +readJsonEntityMain);  //Here response in java object
		return readJsonEntityMain;
		
	}

	@Override
	public ReadJson3 readJson3() {
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			JsonNode readTree = objectMapper.readTree(new File("data3.json"));
			LOGGER.info("readTree ---> {} ",readTree);
			ReadJson3 readJson3=new ReadJson3();
			
			readJson3.setSvrId(readTree.get("svrId").asText());
			readJson3.setReqRefNo(readTree.get("reqRefNo").asText());
			readJson3.setSkyRefNo(readTree.get("skyRefNo").asText());
			readJson3.setProcStatus(readTree.get("procStatus").asText());
			readJson3.setErrCode(readTree.get("errCode").asText());
			readJson3.setErrMsgSys(readTree.get("errMsgSys").asText());
			readJson3.setErrMsgUsr(readTree.get("errMsgUsr").asText());
			
			List<String> availableClassList = new ArrayList<>();
			ArrayNode avlClassesObj = (ArrayNode) readTree.get("avlClasses");
			for(int i=0;i<avlClassesObj.size();i++)
			{
				 String asText = avlClassesObj.get(i).asText();
				 System.out.println("asText" +asText);
				 availableClassList.add(asText);	 				 
			}
			
//			readJson3.setAvlClasses(availableClassList);
	//		System.out.println("ReadJson3 Data" +readJson3);
			
			LOGGER.info("ReadJson3 Pojo Class Data : {} ",readJson3.toString());
//			readJson3Repo.save(readJson3);
			/*
			ArrayNode avlClassesObj = (ArrayNode) readTree.get("avlClasses");
			for(int i=0;i<avlClassesObj.size();i++)
			{
				 String asText = avlClassesObj.get(i).asText();
				 System.out.println("asText" +asText);
				 readJson3.setAvlClasses(asText);
				 				 
			}
			*/
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String get4() throws JsonProcessingException
	{

		System.out.println("Line 1");
//		String string="{\n"
//				+ "  \"errorcode\": 0,\n"
//				+ "  \"errorDesc\": \"Success\",\n"
//				+ "  \"partnerResponse\": {\n"
//				+ "    \"bookingResponseList\": [\n"
//				+ "      {\n"
//				+ "        \"trainName\": \"ERNAKULAM EXP\",\n"
//				+ "        \"distance\": \"60\",\n"
//				+ "        \"boardingStn\": \"SBC\",\n"
//				+ "        \"boardingDate\": \"2023-02-25T06:10:00.000\",\n"
//				+ "        \"journeyDate\": \"2023-02-25T00:00:00.000\",\n"
//				+ "        \"trainOwner\": \"0\"\n"
//				+ "      }\n"
//				+ "    ]\n"
//				+ "  }\n"
//				+ "}";
//		
		String string2="{\n" + 
				"  \"errorcode\": \"0\",\n" + 
				"  \"errorDesc\": \"Success\",\n" + 
				"  \"partnerResponse\": {\n" + 
				"    \"bookingResponseList\": [\n" + 
				"      {\n" + 
				"        \"trainName\": \"ERNAKULAMEXP\",\n" + 
				"        \"distance\": \"60\",\n" + 
				"        \"boardingStn\": \"SBC\",\n" + 
				"        \"boardingDate\": \"2023-02-25T06:10:00.000\",\n" + 
				"        \"journeyDate\": \"2023-02-25T00:00:00.000\",\n" + 
				"        \"trainOwner\": \"0\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"        \"trainName\": \"ERNAKULAMEXP\",\n" + 
				"        \"distance\": \"60\",\n" + 
				"        \"boardingStn\": \"CST\",\n" + 
				"        \"boardingDate\": \"2023-02-26T06:10:00.000\",\n" + 
				"        \"journeyDate\": \"2023-02-25T00:00:00.000\",\n" + 
				"        \"trainOwner\": \"0\"\n" + 
				"      }\n" + 
				"    ]\n" + 
				"  }\n" + 
				"}";
		
		string2=string2.replace("\n", "");
		System.out.println(string2);
		 ObjectMapper objectMapper=new ObjectMapper();
	        JsonNode readTree = objectMapper.readTree(string2);
	        System.out.println("Response"+readTree);
	        String errorCode = readTree.get("errorcode").asText();
	        System.out.println("ErrorCode : "+errorCode);
	        JsonNode partnerResponse = readTree.get("partnerResponse");
	        System.out.println("partnerResponse :" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(partnerResponse));
	        ArrayNode arrayNode=(ArrayNode)partnerResponse.get("bookingResponseList");
	//        ApiResponse apiResponse=new ApiResponse();
	//        BookingResponseList2 bookingResponseList2=new BookingResponseList2();
	        List<BookingResponseList1> lst= new ArrayList<>();
	        BookingResponseList1 bookingResponseList1 = null;
	 //       apiResponse.setApiResponse(bookingResponseList1);
	        lst.add(bookingResponseList1);
	        JSONObject jObject=new JSONObject();
	        
	        JSONArray jsonArray=new JSONArray();
	        for(int i=0;i<arrayNode.size();i++)
			{
	        	  System.out.println("ArrayNode Size "+ arrayNode.size());
	        	 System.out.println("asText1");
				 JsonNode asText1 = arrayNode.get(i);
				 System.out.println("ASTEXT :" +asText1);
				
//				 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//				 bookingResponseList1 = objectMapper.readValue(asText1.asText(), BookingResponseList1.class);
				 
				 JSONObject jsonObject=new JSONObject();
				 new JSONArray();
//				 bookingResponseList1=new BookingResponseList1();			 
//				 bookingResponseList1.setBoardingDate(asText1.get("boardingDate").asText());
//				 bookingResponseList1.setBoardingStn(asText1.get("boardingStn").asText());
//				 bookingResponseList1.setDistance(asText1.get("distance").asText());
//				 bookingResponseList1.setJourneyDate(asText1.get("journeyDate").asText());
//				 bookingResponseList1.setTrainOwner(asText1.get("trainOwner").asText());
//				 bookingResponseList1.setTrainName(asText1.get("trainName").asText());
//				 System.out.println("Data parsed");
//				 System.out.println("asText" +asText1);
				 jsonObject.put("bD", asText1.get("boardingDate").asText());
				 jsonObject.put("bs", asText1.get("boardingStn").asText());
				 jsonArray.put(jsonObject);				  				 
			}
//	        jsonObject.put("trains", bookingResponseList1);
//	        System.out.println("JSONObject : " +jsonObject);
//	        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//	        String writeValueAsString = objectMapper.writeValueAsString(jsonObject);
//	        System.out.println(writeValueAsString);
	       
	       
	      
	        jObject.put("a", jsonArray);
			
//	        new JSONObject();
	        
	        
			return jObject.toString();
	        
	
	}

	@Override
	public String uploadFile(MultipartFile file) {
		System.out.println("Inside uploadFile method--->");
		String originalFilename = file.getOriginalFilename();
		File readFileData=new File(originalFilename);
		System.out.println("readFileData : " +readFileData);
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			 Object readValue = objectMapper.readValue(file.getInputStream(), Object.class);
			 System.out.println("readValue :" +readValue);
			 String writeValueAsString = objectMapper.writeValueAsString(readValue);
			 System.out.println(" writeValueAsString" +writeValueAsString);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return originalFilename;
	}

	

}
