package com.tmb.requests.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Data {
	
	private int id;
	private String fname;
	private List<String> jobs;
	private FavFood favfood;

}
