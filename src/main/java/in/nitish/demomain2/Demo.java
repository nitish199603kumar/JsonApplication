package in.nitish.demomain2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import in.nitish.pojo.BookingResponseList1;

public class Demo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		System.out.println("Line 1");
		String string="{\n"
				+ "  \"errorcode\": 0,\n"
				+ "  \"errorDesc\": \"Success\",\n"
				+ "  \"partnerResponse\": {\n"
				+ "    \"bookingResponseList\": [\n"
				+ "      {\n"
				+ "        \"trainName\": \"ERNAKULAM EXP\",\n"
				+ "        \"distance\": \"60\",\n"
				+ "        \"boardingStn\": \"SBC\",\n"
				+ "        \"boardingDate\": \"2023-02-25T06:10:00.000\",\n"
				+ "        \"journeyDate\": \"2023-02-25T00:00:00.000\",\n"
				+ "        \"trainOwner\": \"0\"\n"
				+ "      }\n"
				+ "    ]\n"
				+ "  }\n"
				+ "}";
		
		string=string.replace("\n", "");
		System.out.println(string);
		 ObjectMapper objectMapper=new ObjectMapper();
	        JsonNode readTree = objectMapper.readTree(string);
	        System.out.println("Response"+readTree);
	        String errorCode = readTree.get("errorcode").asText();
	        System.out.println("ErrorCode : "+errorCode);
	        JsonNode partnerResponse = readTree.get("partnerResponse");
	        System.out.println("partnerResponse" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(partnerResponse));
	        ArrayNode arrayNode=(ArrayNode)partnerResponse.get("bookingResponseList");
	        
	        for(int i=0;i<arrayNode.size();i++)
			{
	        	 System.out.println("asText1");
				 JsonNode asText1 = arrayNode.get(i);
	//			 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	//			 BookingResponseList1 readValue1 = objectMapper.readValue(asText1.asText(), BookingResponseList1.class);
				 BookingResponseList1 bookingResponseList1=new BookingResponseList1();
				 bookingResponseList1.setBoardingDate(asText1.get("boardingDate").asText());
				 bookingResponseList1.setBoardingStn(asText1.get("boardingStn").asText());
				 bookingResponseList1.setDistance(asText1.get("distance").asText());
				 bookingResponseList1.setJourneyDate(asText1.get("journeyDate").asText());
				 bookingResponseList1.setTrainOwner(asText1.get("trainOwner").asText());
				 System.out.println("Data parsed");
				 System.out.println("asText" +asText1);
				 
				 
				  				 
			}
	        
		
	}

}
      