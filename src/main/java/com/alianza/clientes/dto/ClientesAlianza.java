package com.alianza.clientes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientesAlianza {
	private int id;
	private String sharedKey;
	private String name;
	private Long phone;
	private String email;
	private String startDate;
	private String endDate;
}