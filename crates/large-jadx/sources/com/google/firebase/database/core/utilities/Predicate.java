package com.google.firebase.database.core.utilities;

/* loaded from: classes2.dex */
public interface Predicate<T>  {

    public static final com.google.firebase.database.core.utilities.Predicate<Object> TRUE;
    static {
        Predicate.1 anon = new Predicate.1();
        Predicate.TRUE = anon;
    }

    public abstract boolean evaluate(T t);
}
