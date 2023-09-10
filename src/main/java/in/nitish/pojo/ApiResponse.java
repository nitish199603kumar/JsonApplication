package in.nitish.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class ApiResponse<T> implements Serializable{
	private Object apiResponse;
}
