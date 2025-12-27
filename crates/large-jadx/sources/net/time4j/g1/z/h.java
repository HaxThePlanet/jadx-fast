package net.time4j.g1.z;

import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* compiled from: FormatProcessor.java */
/* loaded from: classes3.dex */
interface h<V> {
    p<V> getElement();

    boolean isNumerical();

    void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z);

    int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z);

    h<V> quickPath(c<?> cVar, d dVar, int i);

    h<V> withElement(p<V> pVar);
}
