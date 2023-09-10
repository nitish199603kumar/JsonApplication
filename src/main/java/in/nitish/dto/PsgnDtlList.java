package in.nitish.dto;

import lombok.Data;

@Data
public class PsgnDtlList {
	
	private String passengerSerialNumber;
	private String passengerName;
	private String passengerAge;
	private String passengerGender;
	private String passengerBerthChoice;
	private String passengerIcardFlag;
	private String passengerNationality;
	private String childPassenger;
	private String passUPN;
	private String fareChargedPercentage;
	private String validationFlag;
	private String bookingStatusIndex;
	private String bookingStatus;
	private String bookingCoachId;
	private String bookingBerthNo;
	private String bookingBerthCode;
	private String bookingStatusDetails;
	private String currentStatusIndex;
	private String currentStatus;
	private String currentCoachId;
	private String currentBerthNo;
	private String passengerNetFare;
	private String currentBerthChoice;
	private String policyNumber;
	private String psgnwlType;
	private String dropWaitlistFlag;

}
