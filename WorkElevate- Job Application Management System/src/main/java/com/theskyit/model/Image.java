package com.theskyit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
public class Image {
	
    @Id
    private String id;
    private String name;
    private byte[] data;
    
    public Image() {
    	
    }
    
	public Image(String id, String name, byte[] data) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
    
}