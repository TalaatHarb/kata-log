package net.talaatharb.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OhceTests {

	private Ohce ohce;

	@Mock
	private SystemTime systemTime;

	@Mock
	private InputSystem inputSystem;

	@Mock
	private OutputSystem outputSystem;

	private String userName;

	@BeforeEach
	void setup() {
		userName = "Pedro";
		ohce = new Ohce(systemTime, inputSystem, outputSystem, userName);
	}

	@ParameterizedTest
	@CsvSource(value = { "21,¡Buenas noches", "7,¡Buenos días", "13,¡Buenas tardes" })
	void testAtStartAndOutputsCorrectWelcomeMessage(int hour, String welcome) {
		Mockito.when(systemTime.getHour()).thenReturn(hour);
		Mockito.when(inputSystem.getInput()).thenReturn(Ohce.STOP_PHRASE);

		ohce.run();

		Mockito.verify(outputSystem).output(welcome + " " + userName);
	}

	@ParameterizedTest
	@CsvSource(value = { "echo,ohce", "hola,aloh", "stop,pots" })
	void testOutputsReverse(String message, String output) {
		Mockito.when(inputSystem.getInput()).thenReturn(message).thenReturn(Ohce.STOP_PHRASE);

		ohce.run();

		final ArgumentCaptor<String> outputCaptor = ArgumentCaptor.forClass(String.class);

		Mockito.verify(outputSystem, Mockito.times(3)).output(outputCaptor.capture());

		assertEquals(output, outputCaptor.getAllValues().get(1));
	}

	@ParameterizedTest
	@CsvSource(value = { "oto" })
	void testHandlesPalindrome(String message) {
		Mockito.when(inputSystem.getInput()).thenReturn(message).thenReturn(Ohce.STOP_PHRASE);

		ohce.run();

		final ArgumentCaptor<String> outputCaptor = ArgumentCaptor.forClass(String.class);

		Mockito.verify(outputSystem, Mockito.times(4)).output(outputCaptor.capture());

		final List<String> outputedValues = outputCaptor.getAllValues();
		assertEquals(message, outputedValues.get(1));
		assertEquals("¡Bonita palabra!", outputedValues.get(2));
	}

	@Test
	void testStopsWhenSentStopPhrase() {
		Mockito.when(inputSystem.getInput()).thenReturn(Ohce.STOP_PHRASE);

		ohce.run();

		Mockito.verify(outputSystem).output("Adios " + userName);
	}

}
