package com.libs.gdxtraime.screen.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.libs.gdxtraime.anotation.Singleton;

@Singleton
public class InputManager {

    private InputMultiplexer multiplexer;

    private InputManager() {
        multiplexer = new InputMultiplexer();
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void addProcessor(InputProcessor inputProcessor) {
        if (!multiplexer.getProcessors().contains(inputProcessor, false)) {
            multiplexer.addProcessor(0, inputProcessor);
        }
        Gdx.input.setInputProcessor(multiplexer);
    }


    public void removeProcessor(InputProcessor inputProcessor) {
        multiplexer.removeProcessor(inputProcessor);
    }
}
