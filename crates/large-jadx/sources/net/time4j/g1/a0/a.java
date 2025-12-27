package net.time4j.g1.a0;

import java.text.ParsePosition;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.g1.a;
import net.time4j.g1.j;
import net.time4j.g1.t;

/* compiled from: DualFormatElement.java */
/* loaded from: classes3.dex */
public interface a extends t<Integer> {

    public static final c<Integer> u;
    static {
        a.u = a.e("COUNT_OF_PATTERN_SYMBOLS", Integer.class);
    }

    Integer q(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar, q<?> qVar);

    void t(o oVar, java.lang.Appendable appendable, d dVar, j jVar, char c, int i, int i2);
}
