package com.kpts.vanshawali.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Document(collection = "Vanshawali")
@RequiredArgsConstructor
@ToString
public class Vyakti {
	
	@Id
	@Getter
	private String vyaktiId;
	
	@Getter
	private String name;
	
	@Getter
	private String fatherName;
	
	@Getter
	private boolean isLiving;
	
	@Getter
	private String gender;
	
	@Getter
	private String maritalStatus;
	
	@Getter
	private boolean isFirst;
	
	@Getter
	private Vyakti nearestRelative;
	
	@Getter
	private String relationship;
	
	@Getter
	private boolean isDeletable;
	
	@Getter
	private String remarks;

}
