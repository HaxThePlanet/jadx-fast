package com.google.android.datatransport.runtime.backends;

import f.c.a.b.i.j;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
final class a extends com.google.android.datatransport.runtime.backends.f {

    private final Iterable<j> a;
    private final byte[] b;

    static class a {
    }

    static final class b extends com.google.android.datatransport.runtime.backends.f.a {

        private Iterable<j> a;
        private byte[] b;
        @Override // com.google.android.datatransport.runtime.backends.f$a
        public com.google.android.datatransport.runtime.backends.f a() {
            Object stringBuilder;
            String string;
            if (this.a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" events");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                a aVar = new a(this.a, this.b, 0);
                return aVar;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing required properties:");
            stringBuilder2.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        public com.google.android.datatransport.runtime.backends.f.a b(Iterable<j> iterable) {
            Objects.requireNonNull(iterable, "Null events");
            this.a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.f$a
        public com.google.android.datatransport.runtime.backends.f.a c(byte[] bArr) {
            this.b = bArr;
            return this;
        }
    }
    private a(Iterable<j> iterable, byte[] b2Arr2) {
        super();
        this.a = iterable;
        this.b = b2Arr2;
    }

    a(Iterable iterable, byte[] b2Arr2, com.google.android.datatransport.runtime.backends.a.a a$a3) {
        super(iterable, b2Arr2);
    }

    public Iterable<j> b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public byte[] c() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Iterable iterable;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof f) {
            if (this.a.equals((f)object.b())) {
                if (object instanceof a) {
                    obj5 = object.b;
                } else {
                    obj5 = (a)object.c();
                }
                if (Arrays.equals(this.b, obj5)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.android.datatransport.runtime.backends.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BackendRequest{events=");
        stringBuilder.append(this.a);
        stringBuilder.append(", extras=");
        stringBuilder.append(Arrays.toString(this.b));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
