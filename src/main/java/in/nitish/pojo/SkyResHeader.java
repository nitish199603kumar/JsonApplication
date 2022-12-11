package in.nitish.pojo;

import lombok.Data;

@Data
public class SkyResHeader {

	private String SvrId;
	private String ReqRefNo;
	private String SkyRefNo;
	private String ProcStatus;
	private String ErrCode;
	private String ErrMsgSys;
	private String ErrMsgUsr;

}
