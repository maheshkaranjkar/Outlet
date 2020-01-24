package com.unilever.outlet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "outlet")
public class Outlet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	private String lastName;
	private String location;
	private String outletName;
	private String outletType;
}
