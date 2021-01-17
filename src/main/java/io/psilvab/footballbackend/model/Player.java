package io.psilvab.footballbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@Document(collection="player")
public class Player {
	@Id
	private String id;
	private String name;
	private String team;

}
