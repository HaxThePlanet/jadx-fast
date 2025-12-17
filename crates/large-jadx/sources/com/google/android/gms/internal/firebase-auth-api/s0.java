package com.google.android.gms.internal.firebase-auth-api;

import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class s0 implements Map.Entry, Comparable<com.google.android.gms.internal.firebase-auth-api.s0> {

    private final Comparable a;
    private Object b;
    final com.google.android.gms.internal.firebase-auth-api.v0 c;
    s0(com.google.android.gms.internal.firebase-auth-api.v0 v0, Comparable comparable2, Object object3) {
        this.c = v0;
        super();
        this.a = comparable2;
        this.b = object3;
    }

    private static final boolean c(Object object, Object object2) {
        int obj0;
        if (object == null && object2 != null) {
            if (object2 != null) {
                obj0 = 0;
                return obj0;
            }
            return 1;
        }
        obj0 = object.equals(object2);
    }

    @Override // java.util.Map$Entry
    public final Comparable a() {
        return this.a;
    }

    @Override // java.util.Map$Entry
    public final int compareTo(Object object) {
        return this.a.compareTo(object.a);
    }

    @Override // java.util.Map$Entry
    public final boolean equals(Object object) {
        boolean z;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Map.Entry) {
            return i2;
        }
        if (s0.c(this.a, (Map.Entry)object.getKey()) && s0.c(this.b, object.getValue())) {
            if (s0.c(this.b, object.getValue())) {
                return i;
            }
        }
        return i2;
    }

    @Override // java.util.Map$Entry
    public final Object getKey() {
        return this.a;
    }

    @Override // java.util.Map$Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map$Entry
    public final int hashCode() {
        int i2;
        int i;
        Comparable comparable = this.a;
        if (comparable == null) {
            i2 = i;
        } else {
            i2 = comparable.hashCode();
        }
        final Object obj = this.b;
        if (obj == null) {
        } else {
            i = obj.hashCode();
        }
        return i2 ^= i;
    }

    @Override // java.util.Map$Entry
    public final Object setValue(Object object) {
        v0.j(this.c);
        this.b = object;
        return this.b;
    }

    @Override // java.util.Map$Entry
    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.b);
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(valueOf);
        stringBuilder.append("=");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }
}
