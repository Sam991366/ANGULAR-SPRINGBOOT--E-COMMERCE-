package com.luv2code.ecommerce.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private ProductCategory category;
	
	@Column(name = "sku")
	private String sku;
		
	@Column(name = "name")
	private String name;
	
	@Column(name = "descprition")
	private String descprition;
	
	@Column(name = "unitPrice")
	private BigDecimal unitPrice;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "unitsInStock")
	private int unitsInStock;
	
	@Column(name = "dateCreated")
	@CreationTimestamp //will automatically take the created time stamp
	private Date dateCreated;
	
	@Column(name = "lastUpdated")
	@UpdateTimestamp // will take automatically take the new time stamp and update it accordingly
	private Date lastUpdated;
}
