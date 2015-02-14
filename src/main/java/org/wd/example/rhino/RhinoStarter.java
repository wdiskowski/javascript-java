package org.wd.example.rhino;

import java.util.Locale;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class RhinoStarter {

	public double cosJs(double angleGrad) {
		Context cx = Context.enter();
		try {
			Scriptable scope = cx.initStandardObjects();
			String script = String.format(Locale.ENGLISH, "Math.cos(%f / 180. * Math.PI);", angleGrad);
			Object result = cx.evaluateString(scope, script, "<cos>", 1, null);
			return Context.toNumber(result);
		} finally {
			Context.exit();
		}
	}
}
