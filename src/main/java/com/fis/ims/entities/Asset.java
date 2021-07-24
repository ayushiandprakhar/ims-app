package com.fis.ims.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "asset")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "asset_id")
	private String assetId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "allocated")
	private boolean allocated;
	
	@Column(name = "allocated_to")
	private String allocatedTo;
	
	@JsonIgnore
	@ManyToOne
	@JoinTable(name = "asset_allocation_table", 
    joinColumns = {@JoinColumn(name="allocated_to")},
    inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private User user;
}
