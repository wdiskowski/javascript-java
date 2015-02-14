package org.wd.example.nashorn;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import javax.script.ScriptException;

import org.junit.Test;
import org.wd.example.rhino.NashornStarter;

public class NashornStarterTest {

	private NashornStarter nashorn = new NashornStarter();

	@Test
	public void sumJsFromSourceTest() throws ScriptException {
		Random random = new Random();
		long first = random.nextInt();
		long second = random.nextInt();
		long result = nashorn
				.sumJsFromSource(
						"var summe = function(a, b) { print('perform ' + a +  ' + ' + b); return a + b;};",
						first, second);
		assertThat(result, equalTo(first + second));

	}

	@Test
	public void sumJsFromFileTest() throws ScriptException, IOException,
			URISyntaxException {
		Random random = new Random();
		long first = random.nextInt();
		long second = random.nextInt();
		long result = nashorn.sumJsFromFile("/wd-sum.js", first, second);
		assertThat(result, equalTo(first + second));

	}

}
