package net.time4j.g1;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: CalendarType.java */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
/* loaded from: classes3.dex */
public @interface c {
    String value();
}
