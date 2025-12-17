package com.google.android.datatransport.runtime.backends;

import java.util.Objects;

/* loaded from: classes.dex */
final class b extends com.google.android.datatransport.runtime.backends.g {

    private final com.google.android.datatransport.runtime.backends.g.a a;
    private final long b;
    b(com.google.android.datatransport.runtime.backends.g.a g$a, long l2) {
        super();
        Objects.requireNonNull(a, "Null status");
        this.a = a;
        this.b = l2;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public long b() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public com.google.android.datatransport.runtime.backends.g.a c() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public boolean equals(Object object) {
        int i;
        com.google.android.datatransport.runtime.backends.g.a aVar;
        long l;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof g) {
            if (this.a.equals((g)object.c()) && Long.compare(aVar, l) == 0) {
                if (Long.compare(aVar, l) == 0) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public int hashCode() {
        int i5 = 1000003;
        long l = this.b;
        return i3 ^= i7;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BackendResponse{status=");
        stringBuilder.append(this.a);
        stringBuilder.append(", nextRequestWaitMillis=");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
