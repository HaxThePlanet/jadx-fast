package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import f.c.a.b.i.b0.a;
import java.util.Objects;

/* loaded from: classes.dex */
final class c extends com.google.android.datatransport.runtime.backends.h {

    private final Context a;
    private final a b;
    private final a c;
    private final String d;
    c(Context context, a a2, a a3, String string4) {
        super();
        Objects.requireNonNull(context, "Null applicationContext");
        this.a = context;
        Objects.requireNonNull(a2, "Null wallClock");
        this.b = a2;
        Objects.requireNonNull(a3, "Null monotonicClock");
        this.c = a3;
        Objects.requireNonNull(string4, "Null backendName");
        this.d = string4;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public Context b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public String c() {
        return this.d;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public a d() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public a e() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object context;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof h) {
            if (this.a.equals((h)object.b()) && this.b.equals(object.e()) && this.c.equals(object.d()) && this.d.equals(object.c())) {
                if (this.b.equals(object.e())) {
                    if (this.c.equals(object.d())) {
                        if (this.d.equals(object.c())) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public int hashCode() {
        int i9 = 1000003;
        return i7 ^= i10;
    }

    @Override // com.google.android.datatransport.runtime.backends.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CreationContext{applicationContext=");
        stringBuilder.append(this.a);
        stringBuilder.append(", wallClock=");
        stringBuilder.append(this.b);
        stringBuilder.append(", monotonicClock=");
        stringBuilder.append(this.c);
        stringBuilder.append(", backendName=");
        stringBuilder.append(this.d);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
