package net.time4j.g1;

import java.text.ParsePosition;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* compiled from: TextElement.java */
/* loaded from: classes3.dex */
public interface t<V> extends p<V> {
    V parse(java.lang.CharSequence charSequence, ParsePosition parsePosition, d dVar);

    void print(o oVar, java.lang.Appendable appendable, d dVar);
}
