package in.nitish.pojo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OD {
	
	public String bga ;
    public String isHB ;
    public String classtype ;
    public String specialFare ;
    public String ylp ;
    public String fid ;
    public String tdu ;
    public String fids ;
    public String fidb ;
    public String fareId ;
    public String starRating ;
    public String tlot ;
    public String ts ;
    public String co2 ;
    public String co2unit ;
    
    public ArrayList<F> fS ;
	

}
