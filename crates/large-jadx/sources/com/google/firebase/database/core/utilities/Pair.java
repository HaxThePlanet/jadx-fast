package com.google.firebase.database.core.utilities;

/* loaded from: classes2.dex */
public final class Pair<T, U>  {

    private final T first;
    private final U second;
    public Pair(T t, U u2) {
        super();
        this.first = t;
        this.second = u2;
    }

    public boolean equals(Object object) {
        boolean equals;
        Class<com.google.firebase.database.core.utilities.Pair> obj;
        Object class;
        boolean obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (Pair.class != object.getClass()) {
            } else {
                Object first = this.first;
                if (first != null) {
                    if (!first.equals(object.first)) {
                        return i2;
                    }
                } else {
                    if (object.first != null) {
                    }
                }
                Object second = this.second;
                obj5 = object.second;
                if (second != null) {
                    if (!second.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    public T getFirst() {
        return this.first;
    }

    public U getSecond() {
        return this.second;
    }

    public int hashCode() {
        int i2;
        int i;
        Object first = this.first;
        if (first != null) {
            i2 = first.hashCode();
        } else {
            i2 = i;
        }
        final Object second = this.second;
        if (second != null) {
            i = second.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair(");
        stringBuilder.append(this.first);
        stringBuilder.append(",");
        stringBuilder.append(this.second);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
