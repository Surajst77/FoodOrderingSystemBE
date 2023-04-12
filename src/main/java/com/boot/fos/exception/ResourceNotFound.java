package com.boot.fos.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResourceNotFound extends RuntimeException{
	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public ResourceNotFound(String resourceName, String fieldName, int fieldValue)
	{
		super(String.format("%s is not found %s: %d",resourceName, fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public ResourceNotFound(String resourceName2, String fieldName2, String id) {
		
	}

}
