package com.google.firebase.perf.util;

import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class Optional<T>  {

    private final T value;
    private Optional() {
        super();
        this.value = 0;
    }

    private Optional(T t) {
        super();
        Objects.requireNonNull(t, "value for optional is empty.");
        this.value = t;
    }

    public static <T> com.google.firebase.perf.util.Optional<T> absent() {
        Optional optional = new Optional();
        return optional;
    }

    public static <T> com.google.firebase.perf.util.Optional<T> fromNullable(T t) {
        com.google.firebase.perf.util.Optional obj0;
        if (t == null) {
            obj0 = Optional.absent();
        } else {
            obj0 = Optional.of(t);
        }
        return obj0;
    }

    public static <T> com.google.firebase.perf.util.Optional<T> of(T t) {
        Optional optional = new Optional(t);
        return optional;
    }

    public T get() {
        Object value = this.value;
        if (value == null) {
        } else {
            return value;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("No value present");
        throw noSuchElementException;
    }

    public boolean isAvailable() {
        int i;
        i = this.value != null ? 1 : 0;
        return i;
    }
}
