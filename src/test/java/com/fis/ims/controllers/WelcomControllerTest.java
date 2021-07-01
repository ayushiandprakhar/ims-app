package com.fis.ims.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WelcomControllerTest {

	WelcomController welcomController = new WelcomController();

	@Test
	void testGetWelcomeMessage() {
		Assertions.assertNotNull(welcomController.getWelcomeMessage());
	}

}
