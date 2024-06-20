package com.libs.gdxtraime.screen;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import lombok.Getter;

@Getter
public abstract class GameTraime extends Game {
    protected Screen lastScreen;

    protected void createScreens() {
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Screen.class.isAssignableFrom(field.getType())) {
                try {
                    field.setAccessible(true);
                    Class<?> screenClass = field.getType();
                    Constructor<?> constructor = screenClass.getDeclaredConstructor();
                    Screen screen = (Screen) constructor.newInstance();
                    field.set(this, screen);
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                         InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setScreen(Screen screen) {
        if (this.screen != null) {
            this.screen.hide();
            lastScreen = this.screen;
        }
        this.screen = screen;
        if (this.screen != null) {
            this.screen.show();
            this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    public void setScreen(ScreenTraime screen) {
        setScreen((Screen) screen);
    }
}
