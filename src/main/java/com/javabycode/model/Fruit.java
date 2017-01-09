package com.javabycode.model;

public class Fruit {

	private Integer id;
	private String name;
	private String produceBy;

	public Fruit() {
	}

	public Fruit(Integer id, String name, String produceby) {
		this.id = id;
		this.name = name;
		this.produceBy = produceby;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProduceBy() {
		return produceBy;
	}
}