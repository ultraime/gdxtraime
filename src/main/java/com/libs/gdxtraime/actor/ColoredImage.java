package com.libs.gdxtraime.actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColoredImage extends Actor {
    private TextureRegionDrawable drawable;

    public ColoredImage(Color color, float width, float height) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fill();

        drawable = new TextureRegionDrawable(new Texture(pixmap));
        setSize(width, height);
        pixmap.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        drawable.draw(batch, getX(), getY(), getWidth(), getHeight());
    }
}
