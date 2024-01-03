package tddmicroexercises.telemetrysystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TelemetryDiagnosticControlsTest {

	private static final String FAKE_INFO_MESSAGE = "FAKE_INFO";

	@InjectMocks
	private TelemetryDiagnosticControls telemetryDiagnosticControls;

	@Mock
	private TelemetryClient telemetryClient;

	@Test
	void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
		Mockito.when(telemetryClient.getOnlineStatus()).thenReturn(false).thenReturn(true);
		Mockito.when(telemetryClient.receive()).thenReturn(FAKE_INFO_MESSAGE);

		telemetryDiagnosticControls.checkTransmission();

		Mockito.verify(telemetryClient).send(TelemetryClient.DIAGNOSTIC_MESSAGE);
		Mockito.verify(telemetryClient).receive();
		assertEquals(FAKE_INFO_MESSAGE, telemetryDiagnosticControls.getDiagnosticInfo());
	}

	@Test
	void CheckTransmission_throws_when_unable_to_connect() throws Exception {
		Mockito.when(telemetryClient.getOnlineStatus()).thenReturn(false);

		final Executable e = () -> telemetryDiagnosticControls.checkTransmission();

		assertThrows(Exception.class, e);
	}

}
