package net.time4j.engine;

/* loaded from: classes3.dex */
public interface y<T, V>  {
    public abstract net.time4j.engine.p<?> getChildAtCeiling(T t);

    public abstract net.time4j.engine.p<?> getChildAtFloor(T t);

    public abstract V getMaximum(T t);

    public abstract V getMinimum(T t);

    public abstract V getValue(T t);

    public abstract boolean isValid(T t, V v2);

    public abstract T withValue(T t, V v2, boolean z3);
}
