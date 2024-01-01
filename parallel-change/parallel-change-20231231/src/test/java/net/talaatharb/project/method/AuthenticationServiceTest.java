package net.talaatharb.project.method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthenticationServiceTest {

	@Test
	void administratorIsAlwaysAuthenticated() throws Exception {
		final AuthenticationService service = new AuthenticationService();
		final int adminId = 12345;
		assertTrue(service.isAuthenticated(adminId));
	}
	@Test
	void normalUserIsNotAuthenticatedInitially() throws Exception {
		final AuthenticationService service = new AuthenticationService();
		final int normalUserId = 11111;
		assertFalse(service.isAuthenticated(normalUserId));
	}

}
