package com.alianza.clientes.dto;


import java.util.Date;
//import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSp {

	private String value;
	private String message; 
    
}