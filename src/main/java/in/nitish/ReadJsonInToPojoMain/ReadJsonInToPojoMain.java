package in.nitish.ReadJsonInToPojoMain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.nitish.pojo.Amenities;
import in.nitish.pojo.Root1;
import in.nitish.pojo.Body;

public class ReadJsonInToPojoMain {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String str ="{\n"
				+ "  \"amenities\": {\n"
				+ "    \"aet\": \"A330-200\",\n"
				+ "    \"entTyp\": \"\",\n"
				+ "    \"power\": \"\",\n"
				+ "    \"seat\": \"\",\n"
				+ "    \"wifi\": \"\"\n"
				+ "  }\n"
				+ "}";
		
		System.out.println("str : " +str);
		ObjectMapper objectMapper=new ObjectMapper();
		JsonNode jsonNode1=objectMapper.readTree(str);
		System.out.println("jsonNode : " +str);
		String  aet= jsonNode1.get("amenities").get("aet").asText();
		System.out.println("aet : " +aet);
		Body root1=objectMapper.readValue(jsonNode1.toString(), Body.class);
		System.out.println("Root1 : " +root1);
		

	}

}
