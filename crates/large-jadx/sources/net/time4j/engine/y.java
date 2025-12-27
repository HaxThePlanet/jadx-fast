package net.time4j.engine;

/* compiled from: ElementRule.java */
/* loaded from: classes3.dex */
public interface y<T, V> {
    p<?> getChildAtCeiling(T t);

    p<?> getChildAtFloor(T t);

    V getMaximum(T t);

    V getMinimum(T t);

    V getValue(T t);

    boolean isValid(T t, V v);

    T withValue(T t, V v, boolean z);
}
