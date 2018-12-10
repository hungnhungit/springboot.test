package com.hungit.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hungit.common.AbstractBaseModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee extends AbstractBaseModel {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "EMP_NO", length = 30, nullable = false)
	private String empNo;

	@Column(name = "FULL_NAME", length = 128, nullable = false)
	private String fullName;

	@Temporal(TemporalType.DATE)
	@Column(name = "HIRE_DATE", nullable = false)
	private Date hireDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DEP_ID")
	private Department department;

}