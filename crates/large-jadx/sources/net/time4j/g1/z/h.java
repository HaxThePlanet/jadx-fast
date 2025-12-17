package net.time4j.g1.z;

import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
interface h<V>  {
    public abstract p<V> getElement();

    public abstract boolean isNumerical();

    public abstract void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5);

    public abstract int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5);

    public abstract net.time4j.g1.z.h<V> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3);

    public abstract net.time4j.g1.z.h<V> withElement(p<V> p);
}
