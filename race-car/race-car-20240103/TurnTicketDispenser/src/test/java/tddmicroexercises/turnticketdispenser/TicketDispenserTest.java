package tddmicroexercises.turnticketdispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TicketDispenserTest {

	@Test
	void foo() {
		final TicketDispenser dispenser = new TicketDispenser();
		final TurnTicket ticket = dispenser.getTurnTicket();
		assertEquals(0, ticket.getTurnNumber());
	}

}
