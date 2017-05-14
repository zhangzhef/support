package com.learning.persistence.js;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by zzf on 17/5/10.
 */
public class JSUtils {

//    private ScriptEngineManager manager = new ScriptEngineManager();
//    private ScriptEngine engine = null;
//
//    public JSUtils() {
//        engine = manager.getEngineByExtension("js");
//    }

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager scriptEngineManager =
                new ScriptEngineManager();
        ScriptEngine nashorn =
                scriptEngineManager.getEngineByName("nashorn");
        String name = "Olli";
        nashorn.eval("print('" + name + "')");
    }
}
