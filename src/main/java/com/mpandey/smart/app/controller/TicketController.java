package com.mpandey.smart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpandey.smart.app.objects.Ticket;
import com.mpandey.smart.app.service.TicketService;

/**
 * @author Madhav Pandey
 * @date Aug 23, 2017
 */

@RestController
@RequestMapping(value="/tickets")
public class TicketController
{
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("/hello")
	public String sayHi(){
		return "Hi";
	}
	
	@GetMapping
	public List<Ticket> getTickets(){
		return this.ticketService.getAllTickets();
	}
	
	@RequestMapping("/{id}")
	public Ticket getTicket(@PathVariable String id){
		return this.ticketService.getTicket(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addTicket(@RequestBody Ticket ticket){
		this.ticketService.addTicket(ticket);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public String updateTicket(@PathVariable String id, @RequestBody Ticket ticket){
		this.ticketService.updateTicket(id, ticket);
		return "Success";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public String deleteTicket(@PathVariable String id){
		this.ticketService.deleteTicket(id);
		return "Success";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addAll")
	public void addAll(@RequestBody List<Ticket> tickets){
		this.ticketService.addAll(tickets);
	}
}
