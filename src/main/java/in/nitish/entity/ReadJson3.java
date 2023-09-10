package in.nitish.entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class ReadJson3 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String SvrId;
	private String ReqRefNo;
	private String SkyRefNo;
	private String ProcStatus;
	private String ErrCode;
	private String ErrMsgSys;
	private String ErrMsgUsr;
	
//	private List<String> avlClasses;
//	private String[] avlClasses;
}
