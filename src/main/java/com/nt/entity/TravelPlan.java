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
import jakarta.persistence.Version;
import lombok.Data;

@Data
@Entity
@Table(name="TRAVELPLAN")
public class TravelPlan {

	@Id
	@GeneratedValue(generator = "gen",strategy = GenerationType.AUTO)
	@Column(name="PLAN_ID")
	private Integer planId;

	@Column(name="PLAN_NAME",length = 30)
	private String planName;
	
	@Column(name="PLAN_DESC",length = 30)
	private String planDescription;
	
	@Column(name="MIN_AMOUNT",length = 30)
	private Double minAmount;
	
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name="ACTIVE",length = 30)
	private String activeSW;
	
	// META INFORMATION
	@Column(name="CREATED_BY",length = 30)
	private String createdby;
	
	@Column(name="UPDATED_BY",length = 30)
	private String updatedby;
	
	@Column(name="UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Version
	@Column(name="UPDATED_COUNT")
	private Integer count;
}
