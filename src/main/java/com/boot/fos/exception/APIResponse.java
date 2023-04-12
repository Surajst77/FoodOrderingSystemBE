package com.boot.fos.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class APIResponse extends RuntimeException{
	
	private String message;
	private boolean status;

}
