package net.time4j.g1;

import java.text.ParsePosition;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
public interface t<V>  extends p<V> {
    public abstract V parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3);

    @Override // net.time4j.engine.p
    public abstract void print(o o, java.lang.Appendable appendable2, d d3);
}
