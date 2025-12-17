package org.jetbrains.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes5.dex */
public final class Debug {

    @Retention(RetentionPolicy.CLASS)
    @Target(ElementType.TYPE)
    public @interface Renderer {
        @Override // java.lang.annotation.Annotation
        public abstract String childrenArray() default "";

        @Override // java.lang.annotation.Annotation
        public abstract String hasChildren() default "";

        @Override // java.lang.annotation.Annotation
        public abstract String text() default "";
    }
    private Debug() {
        super();
        AssertionError assertionError = new AssertionError("Debug should not be instantiated");
        throw assertionError;
    }
}
