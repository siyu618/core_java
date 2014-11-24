package com.my.learn.core_java2.ch11;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by yidianadmin on 14-11-24.
 */
public class ScriptEngineTest {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.eval("n = 1728");
        Object result = engine.eval("n + 1");
        System.out.println(result);
    }
}
