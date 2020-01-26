package com.unilever.outlet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Entity
@Table(name = "outlet")
@Validated
public class Outlet {

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@NotNull
	@NotEmpty
	private String lastName;
	@NotNull
	@NotEmpty
	private String location;
	@NotNull
	@NotEmpty
	private String outletName;
	@NotNull
	@NotEmpty
	private String outletType;
}
