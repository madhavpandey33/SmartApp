package com.mpandey.smart.app.objects;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_TICKET")
public class Ticket
{
	@Id
	@Column(name = "TICKET_ID", nullable = false)
	private int id;

	private Date dateCreated;

	@NotEmpty
	private String description;

	@NotEmpty
	private String category;

	@NotEmpty
	private String priority;

	@NotEmpty
	private boolean assigned;

	@NotEmpty
	private String assignedTo;

	@NotEmpty
	private String status;

	@NotEmpty
	private String createdBy;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getDateCreated()
	{
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getPriority()
	{
		return priority;
	}

	public void setPriority(String priority)
	{
		this.priority = priority;
	}

	public boolean isAssigned()
	{
		return assigned;
	}

	public void setAssigned(boolean assigned)
	{
		this.assigned = assigned;
	}

	public String getAssignedTo()
	{
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo)
	{
		this.assignedTo = assignedTo;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	@Override
	public String toString()
	{
		return "Ticket [id:" + this.id + ", category:" + this.category + ", description:" + this.description + "]";
	}
}