package com.tmb.requests.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class FavFood {

	private String breakfast;
	private String lunch;
	private String dinner;
}
