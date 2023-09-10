package in.nitish.cancellationforTrain;

import java.util.HashMap;
import java.util.Map;

import org.h2.util.json.JSONValue;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import in.nitish.dto.PsgnDtlList;
import in.nitish.pojo.BookingResponseList2;

public class CancellationHistoryResponse {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		/*
		String string="{\n"
				+ "  \"bookingResponseList\": [\n"
				+ "    {\n"
				+ "      \"trainName\": \"ERNAKULAM EXP\",\n"
				+ "      \"distance\": \"60\",\n"
				+ "      \"boardingStn\": \"SBC\",\n"
				+ "      \"boardingDate\": \"2023-02-25T06:10:00.000\",\n"
				+ "      \"journeyDate\": \"2023-02-25T00:00:00.000\",\n"
				+ "      \"trainOwner\": \"0\",\n"
				+ "      \"serviceTax\": \"0.0\",\n"
				+ "      \"cateringCharge\": \"0\",\n"
				+ "      \"totalFare\": \"65\",\n"
				+ "      \"wpServiceCharge\": \"15.0\",\n"
				+ "      \"wpServiceTax\": \"2.7\",\n"
				+ "      \"travelInsuranceCharge\": \"0.3\",\n"
				+ "      \"travelInsuranceServiceTax\": \"0.05\",\n"
				+ "      \"insuredPsgnCount\": \"1\",\n"
				+ "      \"otpAuthenticationFlag\": \"0\",\n"
				+ "      \"transactionId\": \"100003836411515\",\n"
				+ "      \"reservationId\": \"100003836411515\",\n"
				+ "      \"lapNumber\": \"0\",\n"
				+ "      \"tktBookedFrom\": \"REWRD\",\n"
				+ "      \"timeTableFlag\": \"1\",\n"
				+ "      \"pnrNumber\": \"4440981029\",\n"
				+ "      \"departureTime\": \"06:10\",\n"
				+ "      \"arrivalTime\": \"07:19\",\n"
				+ "      \"destArrvDate\": \"2023-02-25T07:19:00.000\",\n"
				+ "      \"bookingDate\": \"2022-12-13T16:17:37.000\",\n"
				+ "      \"trainNumber\": \"12677\",\n"
				+ "      \"fromStn\": \"SBC\",\n"
				+ "      \"destStn\": \"HSRA\",\n"
				+ "      \"journeyClass\": \"2S\",\n"
				+ "      \"journeyQuota\": \"GENERAL\",\n"
				+ "      \"insuranceCharge\": \"0.35\",\n"
				+ "      \"totalCollectibleAmount\": \"83.05\",\n"
				+ "      \"psgnDtlList\": [\n"
				+ "        {\n"
				+ "          \"passengerSerialNumber\": \"1\",\n"
				+ "          \"passengerName\": \"Nitish Kumar\",\n"
				+ "          \"passengerAge\": \"26\",\n"
				+ "          \"passengerGender\": \"M\",\n"
				+ "          \"passengerBerthChoice\": \"WS\",\n"
				+ "          \"passengerIcardFlag\": \"false\",\n"
				+ "          \"passengerNationality\": \"IN\",\n"
				+ "          \"childPassenger\": \"false\",\n"
				+ "          \"passUPN\": \"0\",\n"
				+ "          \"fareChargedPercentage\": \"0.0\",\n"
				+ "          \"validationFlag\": \"N\",\n"
				+ "          \"bookingStatusIndex\": \"0\",\n"
				+ "          \"bookingStatus\": \"CNF\",\n"
				+ "          \"bookingCoachId\": \"D3\",\n"
				+ "          \"bookingBerthNo\": \"55\",\n"
				+ "          \"bookingBerthCode\": \"WS\",\n"
				+ "          \"bookingStatusDetails\": \"CNF/D3/55/WS\",\n"
				+ "          \"currentStatusIndex\": \"0\",\n"
				+ "          \"currentStatus\": \"CNF\",\n"
				+ "          \"currentCoachId\": \"D3\",\n"
				+ "          \"currentBerthNo\": \"55\",\n"
				+ "          \"passengerNetFare\": \"65\",\n"
				+ "          \"currentBerthChoice\": \"WS\",\n"
				+ "          \"policyNumber\": \"211622000148619396\",\n"
				+ "          \"psgnwlType\": \"0\",\n"
				+ "          \"dropWaitlistFlag\": \"false\"\n"
				+ "        }\n"
				+ "      ],\n"
				+ "      \"scheduleDepartureFlag\": \"false\",\n"
				+ "      \"scheduleArrivalFlag\": \"false\",\n"
				+ "      \"resvDetails\": [\n"
				+ "        {\n"
				+ "          \"reservationId\": \"100003836411515\",\n"
				+ "          \"reservationMode\": \"WTBC\",\n"
				+ "          \"transactionDate\": \"13-Dec-2022 04:17:36 PM\",\n"
				+ "          \"noOfTicket\": \"1\",\n"
				+ "          \"totalAmntRes\": \"83.05\",\n"
				+ "          \"paymentType\": \"NON_CASH\",\n"
				+ "          \"refundStatusRes\": \"not applicable\",\n"
				+ "          \"userId\": \"Boksa\",\n"
				+ "          \"agentUserId\": \"100000152916649\",\n"
				+ "          \"mobileNumber\": \"9708040890\",\n"
				+ "          \"reservationStatus\": \"PRS_SUCCESS\"\n"
				+ "        }\n"
				+ "      ],\n"
				+ "      \"noOfCanPsgn\": \"0\",\n"
				+ "      \"noOfCanChild\": \"0\",\n"
				+ "      \"transactionStatusEtTkt\": \"TKT_BOOKED_ONLINE\",\n"
				+ "      \"trainChartStatus\": \"Chart Not Prepared\",\n"
				+ "      \"currentPrsAmt\": \"65\",\n"
				+ "      \"taServiceCharge\": \"20\",\n"
				+ "      \"serviceChargeTotal\": \"17.7\",\n"
				+ "      \"prsBookingResponse\": \" \",\n"
				+ "      \"trainStartDate\": \"2023-02-25T00:00:00.000\",\n"
				+ "      \"tktLegendMessage\": \"* N        ICHECK TIMINGS BEFORE BOAR\\n* DING\",\n"
				+ "      \"bookingTatkalCharge\": \"0\",\n"
				+ "      \"bookingResvCharge\": \"15\",\n"
				+ "      \"bookingFuelCharge\": \"0\",\n"
				+ "      \"bookingSuperFastCharge\": \"15\",\n"
				+ "      \"curTatkalCharge\": \"0\",\n"
				+ "      \"curResvCharge\": \"15\",\n"
				+ "      \"curFuelCharge\": \"0\",\n"
				+ "      \"curSuperFastCharge\": \"15\",\n"
				+ "      \"ticketType\": \"E-ticket\",\n"
				+ "      \"cancellationStatus\": \" \",\n"
				+ "      \"reservationStatus\": \"Booked\",\n"
				+ "      \"lapNumberEtTkt\": \"0\",\n"
				+ "      \"ignoreChoiceIf\": \"No\",\n"
				+ "      \"autoUpgradeChoice\": \"No\",\n"
				+ "      \"gnToCkOpt\": \"N/A\",\n"
				+ "      \"ticketChoiceBerth\": \"None\",\n"
				+ "      \"ticketChoiceCoach\": \"No\",\n"
				+ "      \"dispatchDate\": \"13-Dec-2022\",\n"
				+ "      \"bookedQuota\": \"GENERAL\",\n"
				+ "      \"reservationUpTo\": \"HSRA\",\n"
				+ "      \"noOfBkdChild\": \"0\",\n"
				+ "      \"noOfBkdPsgn\": \"1\",\n"
				+ "      \"policyIssueDate\": \"13-Dec-2022 04:17:03 PM\",\n"
				+ "      \"insuranceCompany\": \"Liberty General Insurance\",\n"
				+ "      \"insuranceCompanyUrl\": \"https://www.libertyinsurance.in/products/irctc/UpdateNomineeDetails?TXNId=100003836411515\",\n"
				+ "      \"insuranceOpted\": \"Yes\",\n"
				+ "      \"policyStatus\": \"Issued\",\n"
				+ "      \"avlForVikalp\": \"false\",\n"
				+ "      \"vikalpStatus\": \"No\",\n"
				+ "      \"bankName\": \"RDS\",\n"
				+ "      \"gstCharge\": {\n"
				+ "        \"totalPRSGst\": \"0.0\",\n"
				+ "        \"irctcCgstCharge\": \"0.0\",\n"
				+ "        \"irctcSgstCharge\": \"0.0\",\n"
				+ "        \"irctcIgstCharge\": \"2.16\",\n"
				+ "        \"irctcUgstCharge\": \"0.0\",\n"
				+ "        \"totalIrctcGst\": \"2.16\"\n"
				+ "      },\n"
				+ "      \"gstFlag\": \"false\",\n"
				+ "      \"softFlag\": \"0\",\n"
				+ "      \"linkedPnr\": \"false\",\n"
				+ "      \"sai\": \"false\",\n"
				+ "      \"pnrLinkStatus\": \"0\",\n"
				+ "      \"journeyLap\": \"0\",\n"
				+ "      \"sectorId\": \"false\",\n"
				+ "      \"canSpouseFlag\": \"false\",\n"
				+ "      \"mahakalFlag\": \"false\",\n"
				+ "      \"rrHbFlag\": \"NN\",\n"
				+ "      \"mealChoiceEnable\": \"true\",\n"
				+ "      \"complaintFlag\": \"0\",\n"
				+ "      \"travelnsuranceRefundAmount\": \"0.0\",\n"
				+ "      \"multiLapFlag\": \"false\",\n"
				+ "      \"mlUserId\": \"0\",\n"
				+ "      \"mlReservationStatus\": \"0\",\n"
				+ "      \"mlTransactionStatus\": \"0\",\n"
				+ "      \"mlJourneyType\": \"0\",\n"
				+ "      \"timeDiff\": \"0\",\n"
				+ "      \"mlTimeDiff\": \"0\",\n"
				+ "      \"totalRefundAmount\": \"0.0\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"tdrReasonList\": [\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"2\",\n"
				+ "      \"tdrReason\": \"Train Late More Than Three Hours and Passenger Not Travelled.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"3\",\n"
				+ "      \"tdrReason\": \"Difference Of Fare In Case proper Coach Not Attached.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"7\",\n"
				+ "      \"tdrReason\": \"Party Partially Travelled. (Journey terminated short of destination) \"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"8\",\n"
				+ "      \"tdrReason\": \"ALL Confirmed Passenger Not Travelled\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"9\",\n"
				+ "      \"tdrReason\": \"Train Diverted And Passenger Not Travelled\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"11\",\n"
				+ "      \"tdrReason\": \"Train Diverted And Train Not Touching Boarding Station.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"12\",\n"
				+ "      \"tdrReason\": \"Train Diverted And Train Not Touching Destination Station.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"13\",\n"
				+ "      \"tdrReason\": \"Passenger Not Travelled As Reservation Provided In Lower Class.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"14\",\n"
				+ "      \"tdrReason\": \"Passenger Not Travelled Due To Ticket In RAC After Chart Preparation.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"15\",\n"
				+ "      \"tdrReason\": \"Train Terminated Short Of Destination.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"16\",\n"
				+ "      \"tdrReason\": \"Party Partially Confirmed/Waitlisted And Waitlisted Passengers Did Not Travel.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"17\",\n"
				+ "      \"tdrReason\": \"Party Partially Confirmed/Waitlisted And All Passengers Did Not Travel.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"22\",\n"
				+ "      \"tdrReason\": \"Difference Of Fare As Passenger Travelled In Lower Class.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"25\",\n"
				+ "      \"tdrReason\": \"Passenger Not Travelled Due To Coach Damage.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"28\",\n"
				+ "      \"tdrReason\": \"Unable To Cancel Due To Train Restored After Train Cancellation.\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"reasonIndex\": \"29\",\n"
				+ "      \"tdrReason\": \"Passengers Not Allowed To Travel by Railway due To COVID-19 Condition\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"serverId\": \"DM07AP35MS3\",\n"
				+ "  \"timeStamp\": \"2023-02-17T11:11:12.626\",\n"
				+ "  \"eligibleForCancel\": \"false\",\n"
				+ "  \"showLastTxn\": \"false\"\n"
				+ "}";
		
		System.out.println("String" +string);
        org.json.JSONObject jsonObject=new org.json.JSONObject(string);
        System.out.println(jsonObject.get("bookingResponseList"));
        JSONArray bookingResponseListArray=(JSONArray)jsonObject.get("bookingResponseList");
        System.out.println(bookingResponseListArray.get(0));
        org.json.JSONObject bookingResponseObject=(org.json.JSONObject)bookingResponseListArray.get(0);
        
        JSONArray psgnDtlList =(JSONArray)bookingResponseObject.get("psgnDtlList");
        org.json.JSONObject psgnDtlListObj  =(org.json.JSONObject)psgnDtlList.get(0);
        System.out.println("psgnDtlListObj" +psgnDtlListObj);
        bookingResponseObject.put("psgnDtlList", psgnDtlListObj);
        JSONArray resvDetailsArray =(JSONArray)bookingResponseObject.get("resvDetails");
        org.json.JSONObject resvDetailsObj  =(org.json.JSONObject)psgnDtlList.get(0);
        System.out.println("resvDetailsObj" +resvDetailsObj);
        bookingResponseObject.put("resvDetails",resvDetailsObj );
        
        jsonObject.put("bookingResponseList",bookingResponseObject);
        
        System.out.println("updated");
        System.out.println("JsonObject" +jsonObject);
        */
		String jsonString12 ="{\n" +        "  \"errorcode\": 0,\n" +        "  \"errorDesc\": \"Success\",\n" +        "  \"partnerResponse\": \"{\\\"timeStamp\\\":\\\"2023-02-17T16:02:22.957\\\",\\\"showLastTxn\\\":\\\"false\\\",\\\"bookingResponseList\\\":{\\\"ticketChoiceBerth\\\":\\\"None\\\",\\\"totalFare\\\":\\\"65\\\",\\\"noOfBkdChild\\\":\\\"0\\\",\\\"trainStartDate\\\":\\\"2023-02-25T00:00:00.000\\\",\\\"mahakalFlag\\\":\\\"false\\\",\\\"mlTimeDiff\\\":\\\"0\\\",\\\"otpAuthenticationFlag\\\":\\\"0\\\",\\\"cateringCharge\\\":\\\"0\\\",\\\"trainChartStatus\\\":\\\"Chart Not Prepared\\\",\\\"cancellationStatus\\\":\\\" \\\",\\\"linkedPnr\\\":\\\"false\\\",\\\"ignoreChoiceIf\\\":\\\"No\\\",\\\"curFuelCharge\\\":\\\"0\\\",\\\"journeyClass\\\":\\\"2S\\\",\\\"transactionId\\\":\\\"100003836411515\\\",\\\"insuranceOpted\\\":\\\"Yes\\\",\\\"curResvCharge\\\":\\\"15\\\",\\\"trainNumber\\\":\\\"12677\\\",\\\"softFlag\\\":\\\"0\\\",\\\"totalRefundAmount\\\":\\\"0.0\\\",\\\"destArrvDate\\\":\\\"2023-02-25T07:19:00.000\\\",\\\"ticketChoiceCoach\\\":\\\"No\\\",\\\"bookedQuota\\\":\\\"GENERAL\\\",\\\"currentPrsAmt\\\":\\\"65\\\",\\\"trainOwner\\\":\\\"0\\\",\\\"insuredPsgnCount\\\":\\\"1\\\",\\\"mlUserId\\\":\\\"0\\\",\\\"timeDiff\\\":\\\"0\\\",\\\"boardingDate\\\":\\\"2023-02-25T06:10:00.000\\\",\\\"trainName\\\":\\\"ERNAKULAM EXP\\\",\\\"bookingResvCharge\\\":\\\"15\\\",\\\"canSpouseFlag\\\":\\\"false\\\",\\\"insuranceCompany\\\":\\\"Liberty General Insurance\\\",\\\"mlTransactionStatus\\\":\\\"0\\\",\\\"travelInsuranceCharge\\\":\\\"0.3\\\",\\\"travelInsuranceServiceTax\\\":\\\"0.05\\\",\\\"pnrNumber\\\":\\\"4440981029\\\",\\\"totalCollectibleAmount\\\":\\\"83.05\\\",\\\"lapNumber\\\":\\\"0\\\",\\\"noOfCanPsgn\\\":\\\"0\\\",\\\"pnrLinkStatus\\\":\\\"0\\\",\\\"timeTableFlag\\\":\\\"1\\\",\\\"tktBookedFrom\\\":\\\"REWRD\\\",\\\"bookingFuelCharge\\\":\\\"0\\\",\\\"multiLapFlag\\\":\\\"false\\\",\\\"serviceTax\\\":\\\"0.0\\\",\\\"travelnsuranceRefundAmount\\\":\\\"0.0\\\",\\\"prsBookingResponse\\\":\\\" \\\",\\\"reservationId\\\":\\\"100003836411515\\\",\\\"psgnDtlList\\\":{\\\"passengerName\\\":\\\"Nitish Kumar\\\",\\\"bookingStatusDetails\\\":\\\"CNF/D3/55/WS\\\",\\\"passengerNationality\\\":\\\"IN\\\",\\\"passengerBerthChoice\\\":\\\"WS\\\",\\\"validationFlag\\\":\\\"N\\\",\\\"policyNumber\\\":\\\"211622000148619396\\\",\\\"psgnwlType\\\":\\\"0\\\",\\\"fareChargedPercentage\\\":\\\"0.0\\\",\\\"currentStatusIndex\\\":\\\"0\\\",\\\"passengerNetFare\\\":\\\"65\\\",\\\"bookingBerthCode\\\":\\\"WS\\\",\\\"bookingStatus\\\":\\\"CNF\\\",\\\"bookingCoachId\\\":\\\"D3\\\",\\\"currentBerthNo\\\":\\\"55\\\",\\\"passengerAge\\\":\\\"26\\\",\\\"bookingStatusIndex\\\":\\\"0\\\",\\\"currentStatus\\\":\\\"CNF\\\",\\\"passUPN\\\":\\\"0\\\",\\\"currentCoachId\\\":\\\"D3\\\",\\\"dropWaitlistFlag\\\":\\\"false\\\",\\\"bookingBerthNo\\\":\\\"55\\\",\\\"passengerGender\\\":\\\"M\\\",\\\"currentBerthChoice\\\":\\\"WS\\\",\\\"passengerIcardFlag\\\":\\\"false\\\",\\\"childPassenger\\\":\\\"false\\\",\\\"passengerSerialNumber\\\":\\\"1\\\"},\\\"arrivalTime\\\":\\\"07:19\\\",\\\"bookingSuperFastCharge\\\":\\\"15\\\",\\\"tktLegendMessage\\\":\\\"* N        ICHECK TIMINGS BEFORE BOAR\\\\n* DING\\\",\\\"reservationStatus\\\":\\\"Booked\\\",\\\"sectorId\\\":\\\"false\\\",\\\"boardingStn\\\":\\\"SBC\\\",\\\"scheduleArrivalFlag\\\":\\\"false\\\",\\\"gnToCkOpt\\\":\\\"N/A\\\",\\\"journeyDate\\\":\\\"2023-02-25T00:00:00.000\\\",\\\"lapNumberEtTkt\\\":\\\"0\\\",\\\"mlJourneyType\\\":\\\"0\\\",\\\"fromStn\\\":\\\"SBC\\\",\\\"taServiceCharge\\\":\\\"20\\\",\\\"bookingDate\\\":\\\"2022-12-13T16:17:37.000\\\",\\\"journeyLap\\\":\\\"0\\\",\\\"complaintFlag\\\":\\\"0\\\",\\\"reservationUpTo\\\":\\\"HSRA\\\",\\\"insuranceCharge\\\":\\\"0.35\\\",\\\"departureTime\\\":\\\"06:10\\\",\\\"bookingTatkalCharge\\\":\\\"0\\\",\\\"distance\\\":\\\"60\\\",\\\"dispatchDate\\\":\\\"13-Dec-2022\\\",\\\"rrHbFlag\\\":\\\"NN\\\",\\\"wpServiceTax\\\":\\\"2.7\\\",\\\"bankName\\\":\\\"RDS\\\",\\\"scheduleDepartureFlag\\\":\\\"false\\\",\\\"policyStatus\\\":\\\"Issued\\\",\\\"avlForVikalp\\\":\\\"false\\\",\\\"curTatkalCharge\\\":\\\"0\\\",\\\"curSuperFastCharge\\\":\\\"15\\\",\\\"mealChoiceEnable\\\":\\\"true\\\",\\\"sai\\\":\\\"false\\\",\\\"noOfBkdPsgn\\\":\\\"1\\\",\\\"insuranceCompanyUrl\\\":\\\"https://www.libertyinsurance.in/products/irctc/UpdateNomineeDetails?TXNId=100003836411515\\\",\\\"gstCharge\\\":{\\\"irctcIgstCharge\\\":\\\"2.16\\\",\\\"totalIrctcGst\\\":\\\"2.16\\\",\\\"totalPRSGst\\\":\\\"0.0\\\",\\\"irctcCgstCharge\\\":\\\"0.0\\\",\\\"irctcSgstCharge\\\":\\\"0.0\\\",\\\"irctcUgstCharge\\\":\\\"0.0\\\"},\\\"mlReservationStatus\\\":\\\"0\\\",\\\"vikalpStatus\\\":\\\"No\\\",\\\"autoUpgradeChoice\\\":\\\"No\\\",\\\"journeyQuota\\\":\\\"GENERAL\\\",\\\"resvDetails\\\":{\\\"agentUserId\\\":\\\"100000152916649\\\",\\\"reservationId\\\":\\\"100003836411515\\\",\\\"reservationMode\\\":\\\"WTBC\\\",\\\"noOfTicket\\\":\\\"1\\\",\\\"mobileNumber\\\":\\\"9708040890\\\",\\\"refundStatusRes\\\":\\\"not applicable\\\",\\\"transactionDate\\\":\\\"13-Dec-2022 04:17:36 PM\\\",\\\"totalAmntRes\\\":\\\"83.05\\\",\\\"userId\\\":\\\"Boksa\\\",\\\"reservationStatus\\\":\\\"PRS_SUCCESS\\\",\\\"paymentType\\\":\\\"NON_CASH\\\"},\\\"noOfCanChild\\\":\\\"0\\\",\\\"serviceChargeTotal\\\":\\\"17.7\\\",\\\"ticketType\\\":\\\"E-ticket\\\",\\\"transactionStatusEtTkt\\\":\\\"TKT_BOOKED_ONLINE\\\",\\\"wpServiceCharge\\\":\\\"15.0\\\",\\\"policyIssueDate\\\":\\\"13-Dec-2022 04:17:03 PM\\\",\\\"gstFlag\\\":\\\"false\\\",\\\"destStn\\\":\\\"HSRA\\\"},\\\"eligibleForCancel\\\":\\\"false\\\",\\\"serverId\\\":\\\"DM06AP29MS2\\\",\\\"tdrReasonList\\\":[{\\\"reasonIndex\\\":\\\"2\\\",\\\"tdrReason\\\":\\\"Train Late More Than Three Hours and Passenger Not Travelled.\\\"},{\\\"reasonIndex\\\":\\\"3\\\",\\\"tdrReason\\\":\\\"Difference Of Fare In Case proper Coach Not Attached.\\\"},{\\\"reasonIndex\\\":\\\"7\\\",\\\"tdrReason\\\":\\\"Party Partially Travelled. (Journey terminated short of destination) \\\"},{\\\"reasonIndex\\\":\\\"8\\\",\\\"tdrReason\\\":\\\"ALL Confirmed Passenger Not Travelled\\\"},{\\\"reasonIndex\\\":\\\"9\\\",\\\"tdrReason\\\":\\\"Train Diverted And Passenger Not Travelled\\\"},{\\\"reasonIndex\\\":\\\"11\\\",\\\"tdrReason\\\":\\\"Train Diverted And Train Not Touching Boarding Station.\\\"},{\\\"reasonIndex\\\":\\\"12\\\",\\\"tdrReason\\\":\\\"Train Diverted And Train Not Touching Destination Station.\\\"},{\\\"reasonIndex\\\":\\\"13\\\",\\\"tdrReason\\\":\\\"Passenger Not Travelled As Reservation Provided In Lower Class.\\\"},{\\\"reasonIndex\\\":\\\"14\\\",\\\"tdrReason\\\":\\\"Passenger Not Travelled Due To Ticket In RAC After Chart Preparation.\\\"},{\\\"reasonIndex\\\":\\\"15\\\",\\\"tdrReason\\\":\\\"Train Terminated Short Of Destination.\\\"},{\\\"reasonIndex\\\":\\\"16\\\",\\\"tdrReason\\\":\\\"Party Partially Confirmed/Waitlisted And Waitlisted Passengers Did Not Travel.\\\"},{\\\"reasonIndex\\\":\\\"17\\\",\\\"tdrReason\\\":\\\"Party Partially Confirmed/Waitlisted And All Passengers Did Not Travel.\\\"},{\\\"reasonIndex\\\":\\\"22\\\",\\\"tdrReason\\\":\\\"Difference Of Fare As Passenger Travelled In Lower Class.\\\"},{\\\"reasonIndex\\\":\\\"25\\\",\\\"tdrReason\\\":\\\"Passenger Not Travelled Due To Coach Damage.\\\"},{\\\"reasonIndex\\\":\\\"28\\\",\\\"tdrReason\\\":\\\"Unable To Cancel Due To Train Restored After Train Cancellation.\\\"},{\\\"reasonIndex\\\":\\\"29\\\",\\\"tdrReason\\\":\\\"Passengers Not Allowed To Travel by Railway due To COVID-19 Condition\\\"}]}\",\n" +        "  \"message\": null,\n" +        "  \"status\": null\n" +        "}";
      
        org.json.JSONObject jsonObject=new org.json.JSONObject(jsonString12);
        System.out.println("jsonObject "+jsonObject);
        String string2 = jsonObject.toString();
        System.out.println("String2" +string2);
         Object object = jsonObject.get("partnerResponse");
        System.out.println("string"+object);
//		ObjectMapper objectMapper=new ObjectMapper();
//		JsonNode readTree = objectMapper.readTree(jsonString12);
//		System.out.println("readtree "+readTree);
//		String booking_details = readTree.get("booking_details").asText();
//		System.out.println("booking_details "+booking_details);
//		String trainName = objectMapper.readTree(booking_details).get("trainName").asText();
//		System.out.println("trainName" +trainName);
        
        
	}

}
