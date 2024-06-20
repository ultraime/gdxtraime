package com.libs.gdxtraime.anotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SingletonManager {
    private static final Map<Class<?>, Object> instances = new HashMap<>();

    public static <T> T getInstance(Class<T> clazz) {
        if (!clazz.isAnnotationPresent(Singleton.class)) {
            throw new IllegalArgumentException("Class is not annotated with @Singleton");
        }

        if (!instances.containsKey(clazz)) {
            synchronized (SingletonManager.class) {
                if (!instances.containsKey(clazz)) {
                    try {
                        Constructor<T> constructor = clazz.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        T instance = constructor.newInstance();
                        instances.put(clazz, instance);
                    } catch (NoSuchMethodException | InstantiationException |
                             IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException("Error creating singleton instance", e);
                    }
                }
            }
        }

        return clazz.cast(instances.get(clazz));
    }
}
