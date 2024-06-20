package com.libs.gdxtraime.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libs.gdxtraime.anotation.SingletonManager;
import com.libs.gdxtraime.screen.input.InputManager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ScreenTraime implements Screen {
    protected Stage stage;

    @Override
    public void show() {
        SingletonManager.getInstance(InputManager.class).addProcessor(stage);
        for (Actor actor : stage.getActors()) {
            if (actor instanceof ScreenListener) {
                ((ScreenListener) actor).onScreenShow();
            }
        }
    }
}
