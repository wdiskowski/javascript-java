package org.wd.example.rhino;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Random;

import org.junit.Test;

public class RhinoStarterTest {
	private RhinoStarter rhino = new RhinoStarter();

	@Test
	public void cosJsTest() {
		int angle = new Random().nextInt();
		assertThat(rhino.cosJs(angle), equalTo(Math.cos(Math.toRadians(angle))));
	}
}
