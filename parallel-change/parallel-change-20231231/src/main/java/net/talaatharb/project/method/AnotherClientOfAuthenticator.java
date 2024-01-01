package net.talaatharb.project.method;

public class AnotherClientOfAuthenticator {
	public void unusedClientCode() {
		try {
			new AuthenticationService().isAuthenticated(3545);
		} catch (final Exception e) {
			// ignored
		}
	}
}
