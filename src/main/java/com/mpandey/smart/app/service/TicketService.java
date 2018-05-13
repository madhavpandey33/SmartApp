/**
 * 
 */
package com.mpandey.smart.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpandey.smart.app.dao.TicketRespository;
import com.mpandey.smart.app.objects.Ticket;

/**
 * @author Madhav Pandey
 * @date Aug 23, 2017
 */
@Service
public class TicketService
{
	@Autowired
	private TicketRespository ticketRespository;
	
	public List<Ticket> getAllTickets()
	{
		List<Ticket> ticketList = new ArrayList<>();
		this.ticketRespository.findAll().forEach(ticket -> ticketList.add(ticket));
		return ticketList;
	}

	public Ticket getTicket(String id)
	{
		return this.ticketRespository.findOne(id);
		//return this.ticketList.stream().filter(ticket -> ticket.getId().equals(id)).findFirst().get();
	}

	public void addTicket(Ticket ticket)
	{
		this.ticketRespository.save(ticket);
	}

	public void updateTicket(String id, Ticket ticket)
	{
		this.ticketRespository.save(ticket);
		/*for (int i = 0; i < ticketList.size(); i++)
		{
			Ticket currentTicket = ticketList.get(i);
			if (currentTicket.getId().equals(id))
			{
				ticketList.set(i, t);
			}
		}*/
	}

	public void deleteTicket(String id)
	{
		this.ticketRespository.delete(id);
		//this.ticketList.removeIf(t -> t.getId().equals(id));
	}
	
	public void addAll(List<Ticket> tickets){
		tickets.forEach(ticket ->
		{
			ticket.setDateCreated(new Date());
			ticket.setAssigned(false);
			ticket.setAssignedTo("madhav");
			ticket.setCreatedBy("madhav");
			this.ticketRespository.save(ticket);
		});
	}
}
