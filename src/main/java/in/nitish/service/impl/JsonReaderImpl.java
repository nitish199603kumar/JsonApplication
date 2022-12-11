package in.nitish.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.nitish.dto.ReadJsonDto;
import in.nitish.entity.ReadJsonEntity;
import in.nitish.entity.ReadJsonEntityMain;
import in.nitish.pojo.SkyResHeader;
import in.nitish.service.ReadJsonService;

@Service
public class JsonReaderImpl implements ReadJsonService {

	@Value("${url1}")
	private String JSON_FILE_URL;

	// getjson1
	@Override
	public Object getJsonResponse() {

		JSONParser parser = new JSONParser();
		Object object = null;
		try {
			// object = parser.parse(new FileReader(
			// "/home/nitish.kumar@reward360.local/Desktop/stsworkspace/2-JsonToJavaToJson/JsonFile/InsideJsonFile/data.json"));
			object = parser.parse(new FileReader(JSON_FILE_URL));

			JSONObject jsonObject = (JSONObject) object;
			JSONObject skyResHeaderObject = (JSONObject) jsonObject.get("SkyResHeader");
			String skyRefNoString = (String) skyResHeaderObject.get("SkyRefNo");
			System.out.println("skyRefNoString ->" + skyRefNoString);

			JSONObject skyResBody = (JSONObject) jsonObject.get("SkyResBody");
			JSONObject partnerResObject = (JSONObject) skyResBody.get("partnerResponse");
			JSONArray trainBtwnStnsList = (JSONArray) partnerResObject.get("trainBtwnStnsList");
			for (int i = 0; i < trainBtwnStnsList.size(); i++) {
				JSONObject obj1 = (JSONObject) trainBtwnStnsList.get(i);

				JSONArray avlClasses = (JSONArray) obj1.get("avlClasses");
				for (int j = 0; j < avlClasses.size(); j++) {
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
					"/home/nitish.kumar@reward360.local/Desktop/stsworkspace/2-JsonToJavaToJson/JsonFile/InsideJsonFile/data.json"));
		//	object = parser.parse(new FileReader(JSON_FILE_URL));

			JSONObject jsonObject = (JSONObject) object;
			JSONObject skyResHeaderObject = (JSONObject) jsonObject.get("SkyResHeader");
			String skyRefNoString = (String) skyResHeaderObject.get("SkyRefNo");
			System.out.println("skyRefNoString ->" + skyRefNoString);

			JSONObject skyResBody = (JSONObject) jsonObject.get("SkyResBody");
			if (readJsonDto.getChannel_id().contains("ANDROID")) {

				JSONObject partnerResObject = (JSONObject) skyResBody.get("partnerResponse");
				JSONArray trainBtwnStnsList = (JSONArray) partnerResObject.get("trainBtwnStnsList");
				for (int i = 0; i < trainBtwnStnsList.size(); i++) {
					JSONObject obj1 = (JSONObject) trainBtwnStnsList.get(i);

					JSONArray avlClasses = (JSONArray) obj1.get("avlClasses");
					for (int j = 0; j < avlClasses.size(); j++) {
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
			
			System.out.println("add git");
			
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
			 
				 jsonNode = objectMapper.readTree(new File(".//data1.json"));
				  String str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode );
				  System.out.println("STR----->" +str);
				  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
				  System.out.println("JSONNode aaa -> " +jsonNode); 
				  readJsonEntityMain=objectMapper.readValue(jsonNode.toString(), ReadJsonEntityMain.class);
				  System.out.println("READJSONENTITYMAIN INSIDE  --->" +readJsonEntityMain);
				  String writeValueAsString = objectMapper.writeValueAsString(jsonNode);
				  System.out.println("writeValueAsString ---> " +writeValueAsString);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("READJSONENTITYMAIN OUTSIDE  --->" +readJsonEntityMain);
		return readJsonEntityMain;
		
	}

}
