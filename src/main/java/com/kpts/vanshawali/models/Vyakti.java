package com.kpts.vanshawali.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "Vanshawali")
@RequiredArgsConstructor
@ToString
public class Vyakti {
	
	@Id
	@Getter
	@Setter
	private String vyaktiId;
	
	@Getter
	private String name;
	
	@Getter
	private boolean isLiving;
	
	@Getter
	private String gender;
	
	@Getter
	private String maritalStatus;
	
	@Getter
	private boolean isFirst;
	
	@Getter
	private String nearestRelative;
	
	@Getter
	private String relationship;
	
	@Getter
	@Setter
	private boolean isDeletable;
	
	@Getter
	private String remarks;

}
