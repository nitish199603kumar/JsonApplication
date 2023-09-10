package in.nitish.dto;
import lombok.Data;
@Data
public class PartnerResponse {
	
	private BookingResponseList bookingResponseList;
	private TdrReasonList tdrReasonList;
	private String serverId;
    private String timeStamp;
    private String eligibleForCancel;
    private String showLastTxn;
}
