package com.hungit.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class AbstractBaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	private Date created_at;

	
	@Temporal(TemporalType.DATE)
	@Column(name = "updated_at")
	private Date update_at;

	public Date getCreated_at() {
		return created_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	@PrePersist
	public void prePersist() {
		this.created_at = this.update_at = new Date();
	}

	@PreUpdate
	public void preUpdate() {
		this.update_at = new Date();
	}

}
