package in.nitish.dto;

import lombok.Data;

@Data
public class ResvDetails {
     private String reservationId;
     private String reservationMode;
     private String transactionDate;
     private String noOfTicket;
     private String totalAmntRes;
     private String paymentType;
     private String refundStatusRes;
     private String userId;
     private String agentUserId;
     private String mobileNumber;
     private String reservationStatus;
	
	
}
