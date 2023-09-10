package in.nitish.demomain1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.JsonObject;

import in.nitish.dto.BookingResponseList;

public class JsonDemo {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		{
	        System.out.println("Hi");

	        String str="{\n" +
	                "  \"errorcode\": 0,\n" +
	                "  \"errorDesc\": \"Success\",\n" +
	                "  \"partnerResponse\": {\n" +
	                "    \"bookingResponseList\": [\n" +
	                "      {\n" +
	                "        \"trainName\": \"ERNAKULAM EXP\",\n" +
	                "        \"distance\": \"60\",\n" +
	                "        \"boardingStn\": \"SBC\",\n" +
	                "        \"boardingDate\": \"2023-02-25T06:10:00.000\",\n" +
	                "        \"journeyDate\": \"2023-02-25T00:00:00.000\",\n" +
	                "        \"trainOwner\": \"0\",\n" +
	                "        \"serviceTax\": \"0.0\",\n" +
	                "        \"cateringCharge\": \"0\",\n" +
	                "        \"totalFare\": \"65\",\n" +
	                "        \"wpServiceCharge\": \"15.0\",\n" +
	                "        \"wpServiceTax\": \"2.7\",\n" +
	                "        \"travelInsuranceCharge\": \"0.3\",\n" +
	                "        \"travelInsuranceServiceTax\": \"0.05\",\n" +
	                "        \"insuredPsgnCount\": \"1\",\n" +
	                "        \"otpAuthenticationFlag\": \"0\",\n" +
	                "        \"transactionId\": \"100003836411515\",\n" +
	                "        \"reservationId\": \"100003836411515\",\n" +
	                "        \"lapNumber\": \"0\",\n" +
	                "        \"tktBookedFrom\": \"REWRD\",\n" +
	                "        \"timeTableFlag\": \"1\",\n" +
	                "        \"pnrNumber\": \"4440981029\",\n" +
	                "        \"departureTime\": \"06:10\",\n" +
	                "        \"arrivalTime\": \"07:19\",\n" +
	                "        \"destArrvDate\": \"2023-02-25T07:19:00.000\",\n" +
	                "        \"bookingDate\": \"2022-12-13T16:17:37.000\",\n" +
	                "        \"trainNumber\": \"12677\",\n" +
	                "        \"fromStn\": \"SBC\",\n" +
	                "        \"destStn\": \"HSRA\",\n" +
	                "        \"journeyClass\": \"2S\",\n" +
	                "        \"journeyQuota\": \"GENERAL\",\n" +
	                "        \"insuranceCharge\": \"0.35\",\n" +
	                "        \"totalCollectibleAmount\": \"83.05\",\n" +
	                "        \"psgnDtlList\": [\n" +
	                "          {\n" +
	                "            \"passengerSerialNumber\": \"1\",\n" +
	                "            \"passengerName\": \"Nitish Kumar\",\n" +
	                "            \"passengerAge\": \"26\",\n" +
	                "            \"passengerGender\": \"M\",\n" +
	                "            \"passengerBerthChoice\": \"WS\",\n" +
	                "            \"passengerIcardFlag\": \"false\",\n" +
	                "            \"passengerNationality\": \"IN\",\n" +
	                "            \"childPassenger\": \"false\",\n" +
	                "            \"passUPN\": \"0\",\n" +
	                "            \"fareChargedPercentage\": \"0.0\",\n" +
	                "            \"validationFlag\": \"N\",\n" +
	                "            \"bookingStatusIndex\": \"0\",\n" +
	                "            \"bookingStatus\": \"CNF\",\n" +
	                "            \"bookingCoachId\": \"D3\",\n" +
	                "            \"bookingBerthNo\": \"55\",\n" +
	                "            \"bookingBerthCode\": \"WS\",\n" +
	                "            \"bookingStatusDetails\": \"CNF/D3/55/WS\",\n" +
	                "            \"currentStatusIndex\": \"0\",\n" +
	                "            \"currentStatus\": \"CNF\",\n" +
	                "            \"currentCoachId\": \"D3\",\n" +
	                "            \"currentBerthNo\": \"55\",\n" +
	                "            \"passengerNetFare\": \"65\",\n" +
	                "            \"currentBerthChoice\": \"WS\",\n" +
	                "            \"policyNumber\": \"211622000148619396\",\n" +
	                "            \"psgnwlType\": \"0\",\n" +
	                "            \"dropWaitlistFlag\": \"false\"\n" +
	                "          }\n" +
	                "        ],\n" +
	                "        \"scheduleDepartureFlag\": \"false\",\n" +
	                "        \"scheduleArrivalFlag\": \"false\",\n" +
	                "        \"resvDetails\": [\n" +
	                "          {\n" +
	                "            \"reservationId\": \"100003836411515\",\n" +
	                "            \"reservationMode\": \"WTBC\",\n" +
	                "            \"transactionDate\": \"13-Dec-2022 04:17:36 PM\",\n" +
	                "            \"noOfTicket\": \"1\",\n" +
	                "            \"totalAmntRes\": \"83.05\",\n" +
	                "            \"paymentType\": \"NON_CASH\",\n" +
	                "            \"refundStatusRes\": \"not applicable\",\n" +
	                "            \"userId\": \"Boksa\",\n" +
	                "            \"agentUserId\": \"100000152916649\",\n" +
	                "            \"mobileNumber\": \"9708040890\",\n" +
	                "            \"reservationStatus\": \"PRS_SUCCESS\"\n" +
	                "          }\n" +
	                "        ],\n" +
	                "        \"noOfCanPsgn\": \"0\",\n" +
	                "        \"noOfCanChild\": \"0\",\n" +
	                "        \"transactionStatusEtTkt\": \"TKT_BOOKED_ONLINE\",\n" +
	                "        \"trainChartStatus\": \"Chart Not Prepared\",\n" +
	                "        \"currentPrsAmt\": \"65\",\n" +
	                "        \"taServiceCharge\": \"20\",\n" +
	                "        \"serviceChargeTotal\": \"17.7\",\n" +
	                "        \"prsBookingResponse\": \" \",\n" +
	                "        \"trainStartDate\": \"2023-02-25T00:00:00.000\",\n" +
	                "        \"tktLegendMessage\": \"* N        ICHECK TIMINGS BEFORE BOAR\\n* DING\",\n" +
	                "        \"bookingTatkalCharge\": \"0\",\n" +
	                "        \"bookingResvCharge\": \"15\",\n" +
	                "        \"bookingFuelCharge\": \"0\",\n" +
	                "        \"bookingSuperFastCharge\": \"15\",\n" +
	                "        \"curTatkalCharge\": \"0\",\n" +
	                "        \"curResvCharge\": \"15\",\n" +
	                "        \"curFuelCharge\": \"0\",\n" +
	                "        \"curSuperFastCharge\": \"15\",\n" +
	                "        \"ticketType\": \"E-ticket\",\n" +
	                "        \"cancellationStatus\": \" \",\n" +
	                "        \"reservationStatus\": \"Booked\",\n" +
	                "        \"lapNumberEtTkt\": \"0\",\n" +
	                "        \"ignoreChoiceIf\": \"No\",\n" +
	                "        \"autoUpgradeChoice\": \"No\",\n" +
	                "        \"gnToCkOpt\": \"N/A\",\n" +
	                "        \"ticketChoiceBerth\": \"None\",\n" +
	                "        \"ticketChoiceCoach\": \"No\",\n" +
	                "        \"dispatchDate\": \"13-Dec-2022\",\n" +
	                "        \"bookedQuota\": \"GENERAL\",\n" +
	                "        \"reservationUpTo\": \"HSRA\",\n" +
	                "        \"noOfBkdChild\": \"0\",\n" +
	                "        \"noOfBkdPsgn\": \"1\",\n" +
	                "        \"policyIssueDate\": \"13-Dec-2022 04:17:03 PM\",\n" +
	                "        \"insuranceCompany\": \"Liberty General Insurance\",\n" +
	                "        \"insuranceCompanyUrl\": \"https://www.libertyinsurance.in/products/irctc/UpdateNomineeDetails?TXNId=100003836411515\",\n" +
	                "        \"insuranceOpted\": \"Yes\",\n" +
	                "        \"policyStatus\": \"Issued\",\n" +
	                "        \"avlForVikalp\": \"false\",\n" +
	                "        \"vikalpStatus\": \"No\",\n" +
	                "        \"bankName\": \"RDS\",\n" +
	                "        \"gstCharge\": {\n" +
	                "          \"totalPRSGst\": \"0.0\",\n" +
	                "          \"irctcCgstCharge\": \"0.0\",\n" +
	                "          \"irctcSgstCharge\": \"0.0\",\n" +
	                "          \"irctcIgstCharge\": \"2.16\",\n" +
	                "          \"irctcUgstCharge\": \"0.0\",\n" +
	                "          \"totalIrctcGst\": \"2.16\"\n" +
	                "        },\n" +
	                "        \"gstFlag\": \"false\",\n" +
	                "        \"softFlag\": \"0\",\n" +
	                "        \"linkedPnr\": \"false\",\n" +
	                "        \"sai\": \"false\",\n" +
	                "        \"pnrLinkStatus\": \"0\",\n" +
	                "        \"journeyLap\": \"0\",\n" +
	                "        \"sectorId\": \"false\",\n" +
	                "        \"canSpouseFlag\": \"false\",\n" +
	                "        \"mahakalFlag\": \"false\",\n" +
	                "        \"rrHbFlag\": \"NN\",\n" +
	                "        \"mealChoiceEnable\": \"true\",\n" +
	                "        \"complaintFlag\": \"0\",\n" +
	                "        \"travelnsuranceRefundAmount\": \"0.0\",\n" +
	                "        \"multiLapFlag\": \"false\",\n" +
	                "        \"mlUserId\": \"0\",\n" +
	                "        \"mlReservationStatus\": \"0\",\n" +
	                "        \"mlTransactionStatus\": \"0\",\n" +
	                "        \"mlJourneyType\": \"0\",\n" +
	                "        \"timeDiff\": \"0\",\n" +
	                "        \"mlTimeDiff\": \"0\",\n" +
	                "        \"totalRefundAmount\": \"0.0\"\n" +
	                "      }\n" +
	                "    ],\n" +
	                "    \"tdrReasonList\": [\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"2\",\n" +
	                "        \"tdrReason\": \"Train Late More Than Three Hours and Passenger Not Travelled.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"3\",\n" +
	                "        \"tdrReason\": \"Difference Of Fare In Case proper Coach Not Attached.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"7\",\n" +
	                "        \"tdrReason\": \"Party Partially Travelled. (Journey terminated short of destination) \"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"8\",\n" +
	                "        \"tdrReason\": \"ALL Confirmed Passenger Not Travelled\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"9\",\n" +
	                "        \"tdrReason\": \"Train Diverted And Passenger Not Travelled\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"11\",\n" +
	                "        \"tdrReason\": \"Train Diverted And Train Not Touching Boarding Station.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"12\",\n" +
	                "        \"tdrReason\": \"Train Diverted And Train Not Touching Destination Station.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"13\",\n" +
	                "        \"tdrReason\": \"Passenger Not Travelled As Reservation Provided In Lower Class.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"14\",\n" +
	                "        \"tdrReason\": \"Passenger Not Travelled Due To Ticket In RAC After Chart Preparation.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"15\",\n" +
	                "        \"tdrReason\": \"Train Terminated Short Of Destination.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"16\",\n" +
	                "        \"tdrReason\": \"Party Partially Confirmed/Waitlisted And Waitlisted Passengers Did Not Travel.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"17\",\n" +
	                "        \"tdrReason\": \"Party Partially Confirmed/Waitlisted And All Passengers Did Not Travel.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"22\",\n" +
	                "        \"tdrReason\": \"Difference Of Fare As Passenger Travelled In Lower Class.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"25\",\n" +
	                "        \"tdrReason\": \"Passenger Not Travelled Due To Coach Damage.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"28\",\n" +
	                "        \"tdrReason\": \"Unable To Cancel Due To Train Restored After Train Cancellation.\"\n" +
	                "      },\n" +
	                "      {\n" +
	                "        \"reasonIndex\": \"29\",\n" +
	                "        \"tdrReason\": \"Passengers Not Allowed To Travel by Railway due To COVID-19 Condition\"\n" +
	                "      }\n" +
	                "    ],\n" +
	                "    \"serverId\": \"DM05AP24MS4\",\n" +
	                "    \"timeStamp\": \"2023-02-11T18:03:04.765\",\n" +
	                "    \"eligibleForCancel\": \"false\",\n" +
	                "    \"showLastTxn\": \"false\"\n" +
	                "  },\n" +
	                "  \"message\": null,\n" +
	                "  \"status\": null\n" +
	                "}";
	        ObjectMapper objectMapper=new ObjectMapper();
	        str=str.replace("\n","");
	        System.out.println("str1"+str);
	        System.out.println("partnerResponse" +objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(str));
	        str=str.replace("[", "");
	        System.out.println("str2" +str);
	        str=str.replace("],", "");
	        System.out.println("str2" +str);
	        System.out.println("partnerResponse" +objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(str));
	        
	        JsonNode readTree = objectMapper.readTree(str);
	        System.out.println("Response"+readTree);
	        String errorCode = readTree.get("errorcode").asText();
	        System.out.println("ErrorCode : "+errorCode);
	        JsonNode partnerResponse = readTree.get("partnerResponse");
	        System.out.println("partnerResponse" +objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(partnerResponse));
	        
	        ArrayNode arrayNode=(ArrayNode)partnerResponse.get("bookingResponseList");
	        for(int i=0;i<arrayNode.size();i++)
			{
				 JsonNode asText = arrayNode.get(i);
				 objectMapper.readValue(asText.asText(),BookingResponseList.class );
				 System.out.println("Data Parsed");
				 System.out.println("asText ABC" +asText);
				 System.out.println("asText" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(asText));
				 System.out.println("boardingDate" +asText.get("boardingDate").asText());
				 if(asText.get("boardingDate").asText().equals("2023-02-25T06:10:00.000"))
				 {
					 
				 DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
				 LocalDateTime boardingDate = LocalDateTime.parse(asText.get("boardingDate").asText(),dateTimeFormatter);
				 LocalDate boardingDate1= LocalDate.parse(asText.get("boardingDate").asText(),dateTimeFormatter);
				 LocalTime boardingDate2= LocalTime.parse(asText.get("boardingDate").asText(),dateTimeFormatter);
				 System.out.println("boardingDate" +boardingDate);
				 System.out.println("boardingDate1" +boardingDate1);
				 System.out.println("boardingDate2 " +boardingDate2);
				 }else {
					 System.out.println("n");
				 }
				 
				  				 
			}
	        
	        
	    }
		

	}

}
