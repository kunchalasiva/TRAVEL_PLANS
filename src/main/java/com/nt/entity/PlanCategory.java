package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategory {

	@Id
	@GeneratedValue(generator = "gen",strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID")
	private Integer planId;
	
	@Column(name="PLANCATEGORY_NAME",length = 30)
	private String planCategoryName;
	
	@Column(name="ACTIVE")
	private String activeSM;
	
	@Column(name = "CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE",insertable = false)
	private LocalDateTime updatedDate; 
	
	@Column(name="CREATED_BY",length = 30)
	private String createdby;
	@Column(name="UPDATED_BY",length = 30)
	private String updatedby;
}
