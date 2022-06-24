package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Double dailyIncome;
	
	public Worker() {
	}

	public Worker(Integer id, String name, Double dailyIncome) {
		super();
		this.id = id;
		this.name = name;
		this.dailyIncome = dailyIncome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
}
