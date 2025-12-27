package net.time4j.g1.a0;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.o;
import net.time4j.g1.g;
import net.time4j.g1.m;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* compiled from: GregorianTextElement.java */
/* loaded from: classes3.dex */
public interface e<V> extends t<V> {
    V parse(java.lang.CharSequence charSequence, ParsePosition parsePosition, Locale locale, v vVar, m mVar, g gVar);

    void print(o oVar, java.lang.Appendable appendable, Locale locale, v vVar, m mVar);
}
