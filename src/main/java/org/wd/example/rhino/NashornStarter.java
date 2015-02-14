package org.wd.example.rhino;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornStarter {

	public Long sumJsFromSource(String jsSource, long first, long second)
			throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");

		engine.eval(jsSource);
		String js = "summe(" + first + ", " + second + ");";
		return ((Number) engine.eval(js)).longValue();
	}

	public Long sumJsFromFile(String jsPath, long first, long second)
			throws ScriptException, IOException, URISyntaxException {
		return sumJsFromSource(getResourceContents(jsPath), first, second);
	}

	private String getResourceContents(String jsPath) throws IOException,
			URISyntaxException {
		return new String(Files.readAllBytes(Paths.get(this.getClass()
				.getResource(jsPath).toURI())));
	}
}
