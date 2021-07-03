package com.fis.ims.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WelcomeControllerTest {

	WelcomeController welcomController = new WelcomeController();

	@Test
	void testGetWelcomeMessage() {
		Assertions.assertNotNull(welcomController.getWelcomeMessage());
	}

}
