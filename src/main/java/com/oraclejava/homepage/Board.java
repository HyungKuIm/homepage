package com.oraclejava.homepage;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int no;
	private String name;
	private String email;
	private String content;
	private Date date;
	private String pass;

}
