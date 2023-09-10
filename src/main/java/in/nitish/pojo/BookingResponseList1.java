package in.nitish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingResponseList1 {
	
	private String trainName;
    private String distance;
    private String boardingStn;
    private String boardingDate;
    private String journeyDate;
    private String trainOwner;

}
