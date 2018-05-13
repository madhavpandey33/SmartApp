/**
 * 
 */
package com.mpandey.smart.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.mpandey.smart.app.objects.Ticket;

/**
 * @author Madhav Pandey
 * @date Aug 23, 2017
 */
public interface TicketRespository extends CrudRepository<Ticket, String>
{
	//public List<Ticket> findAll();
}
