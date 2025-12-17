package net.time4j.g1.a0;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.o;
import net.time4j.g1.g;
import net.time4j.g1.m;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public interface e<V>  extends t<V> {
    public abstract V parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, Locale locale3, v v4, m m5, g g6);

    @Override // net.time4j.g1.t
    public abstract void print(o o, java.lang.Appendable appendable2, Locale locale3, v v4, m m5);
}
