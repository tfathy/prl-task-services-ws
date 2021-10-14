package org.dhaman.prl.entity.lookup;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WhoColumns implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8570695234829605438L;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="last_updated_by")
	private String lastUpdatedBy;
	
	@Column(name="last_update_date")
	private Date lastUpdateDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@Override
	public String toString() {
		return "WhoColumns [createdBy=" + createdBy + ", creationDate=" + creationDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdateDate=" + lastUpdateDate + "]";
	}
	
	

}
