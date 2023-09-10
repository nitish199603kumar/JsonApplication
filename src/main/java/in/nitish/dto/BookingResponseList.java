package in.nitish.dto;

import lombok.Data;

@Data
public class BookingResponseList {

    private String trainName;
    private String  distance;
    private String boardingStn;
    private String boardingDate ;
    private String journeyDate;
    private String trainOwner;
    private String serviceTax;
    private String cateringCharge;
    private String totalFare;
    private String wpServiceCharge;
    private String wpServiceTax;
    private String travelInsuranceCharge;
    private String travelInsuranceServiceTax;
    private String insuredPsgnCount;
    private String otpAuthenticationFlag;
    private String transactionId;
    private String reservationId;
    private String lapNumber;
    private String tktBookedFrom;
    private String timeTableFlag;
    private String pnrNumber;
    private String departureTime;
    private String arrivalTime;
    private String destArrvDate;
    private String bookingDate;
    private String trainNumber;
    private String fromStn;
    private String destStn;
    private String journeyClass;
    private String journeyQuota;
    private String insuranceCharge;
    private String totalCollectibleAmount;
    
	private PsgnDtlList psgnDtlList;
	
	private String scheduleDepartureFlag;
    private String scheduleArrivalFlag;
    
    private ResvDetails resvDetails;
	
    private String noOfCanPsgn;
    private String noOfCanChild;
    private String transactionStatusEtTkt;
    private String trainChartStatus;
    private String currentPrsAmt;
    private String taServiceCharge;
    private String serviceChargeTotal;
    private String prsBookingResponse;
    private String trainStartDate;
    private String tktLegendMessage;
    private String bookingTatkalCharge;
    private String bookingResvCharge;
    private String bookingFuelCharge;
    private String bookingSuperFastCharge;
    private String curTatkalCharge;
    private String curResvCharge;
    private String curFuelCharge;
    private String curSuperFastCharge;
    private String ticketType;
    private String cancellationStatus;
    private String reservationStatus;
    private String lapNumberEtTkt;
    private String ignoreChoiceIf;
    private String autoUpgradeChoice;
    private String gnToCkOpt;
    private String ticketChoiceBerth;
    private String ticketChoiceCoach;
    private String dispatchDate;
    private String bookedQuota;
    private String reservationUpTo;
    private String noOfBkdChild;
    private String noOfBkdPsgn;
    private String policyIssueDate;
    private String insuranceCompany;
    private String insuranceCompanyUrl;
    private String insuranceOpted;
    private String policyStatus;
    private String avlForVikalp;
    private String vikalpStatus;
    private String bankName;
    
    private GstCharge gstCharge;
    
    private String gstFlag;
    private String softFlag;
    private String linkedPnr;
    private String sai;
    private String pnrLinkStatus;
    private String journeyLap;
    private String sectorId;
    private String canSpouseFlag;
    private String mahakalFlag;
    private String rrHbFlag;
    private String mealChoiceEnable;
    private String complaintFlag;
    private String travelnsuranceRefundAmount;
    private String multiLapFlag;
    private String mlUserId;
    private String mlReservationStatus;
    private String mlTransactionStatus;
    private String mlJourneyType;
    private String timeDiff;
    private String mlTimeDiff;
    private String totalRefundAmount;
}
