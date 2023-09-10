package in.nitish.dto;

import lombok.Data;

@Data
public class GstCharge {
     private String totalPRSGst;
     private String irctcCgstCharge;
     private String irctcSgstCharge;
     private String irctcIgstCharge;
     private String irctcUgstCharge;
     private String totalIrctcGst;
}
