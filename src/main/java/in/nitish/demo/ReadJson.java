package in.nitish.demo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ReadJson {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("After Main Method");

		JSONParser parser = new JSONParser();
		
		// JsonParser to convert JSON string into Json Object

		try {

			Object obj = parser.parse(new FileReader(
					"/home/nitish.kumar@reward360.local/Desktop/stsworkspace/2-JsonToJavaToJson/JsonFile/InsideJsonFile/data.json"));
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
			if (message == null ) {
				System.out.println("SkyResBody---message -> " + message);
			}else {
				System.out.println("SkyResBody---message Not Null -> " + message);
			}
			
			String status = (String) skyResBody.get("status");
			System.out.println("SkyResBody---status -> " + status);
			// partnerResponse

			JSONObject partnerResObject = (JSONObject) skyResBody.get("partnerResponse");

			String alternateEnquiryFlag = (String) partnerResObject.get("alternateEnquiryFlag");
			System.out.println("PartnerResponse---alternateEnquiryFlag ->" + alternateEnquiryFlag);
			
			JSONArray arrQuotaList=(JSONArray)partnerResObject.get("quotaList");
			
			for(int i=0;i<arrQuotaList.size();i++)
			{
				//String object =(String)arrQuotaList.get(i);
				//System.out.println("OBJECT -> "+object);
				
				if(arrQuotaList.get(i).equals("SS"))
				{
					arrQuotaList.remove(i);		
					System.out.println(arrQuotaList);
				}
			}
			
			JSONArray trainBtwnStnsList=(JSONArray)partnerResObject.get("trainBtwnStnsList");
			
			for(int i=0;i<trainBtwnStnsList.size();i++)
			{
				JSONObject obj1=(JSONObject)trainBtwnStnsList.get(i);
				
				JSONArray avlClasses=(JSONArray) obj1.get("avlClasses");  
				for(int j=0;j<avlClasses.size();j++)
				{
			//		String avlClasses1=(String)avlClasses.get(j);
			//		System.out.println(avlClasses1);
					if(avlClasses.get(j).equals("EV"))
					{
						avlClasses.remove(j);
						
					}
					System.out.println(avlClasses);
				}
				
			//	String arrivalTime=(String) obj1.get("arrivalTime");
				//System.out.println("Arrival TIme" +arrivalTime);
				//System.out.println(arrivalTime);
				
			}
			


		} catch (IOException | ParseException e) {

			e.printStackTrace();
		}

	}

}

//<dependency>
//<groupId>org.springframework.boot</groupId>
//<artifactId>spring-boot-starter-data-jpa</artifactId>
//</dependency>
//<dependency>
//<groupId>mysql</groupId>
//<artifactId>mysql-connector-java</artifactId>
//
//</dependency>
//{
//	  "SkyResHeader": {
//	    "SvrId": "",
//	    "ReqRefNo": "62289430027428",
//	    "SkyRefNo": "1668776778146",
//	    "ProcStatus": "",
//	    "ErrCode": "00",
//	    "ErrMsgSys": "Successfull",
//	    "ErrMsgUsr": ""
//	  }
//	}
