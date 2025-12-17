package net.time4j.g1.a0;

import java.text.ParsePosition;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.g1.a;
import net.time4j.g1.j;
import net.time4j.g1.t;

/* loaded from: classes3.dex */
public interface a extends t<Integer> {

    public static final c<Integer> u;
    static {
        a.u = a.e("COUNT_OF_PATTERN_SYMBOLS", Integer.class);
    }

    public abstract Integer q(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3, q<?> q4);

    @Override // net.time4j.g1.t
    public abstract void t(o o, java.lang.Appendable appendable2, d d3, j j4, char c5, int i6, int i7);
}
