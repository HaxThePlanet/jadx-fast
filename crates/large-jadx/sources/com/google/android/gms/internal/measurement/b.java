package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b {

    private String a;
    private final long b;
    private final Map<String, Object> c;
    public b(String string, long l2, Map<String, Object> map3) {
        super();
        this.a = string;
        this.b = l2;
        HashMap obj1 = new HashMap();
        this.c = obj1;
        if (obj4 != null) {
            obj1.putAll(obj4);
        }
    }

    public final long a() {
        return this.b;
    }

    public final com.google.android.gms.internal.measurement.b b() {
        HashMap hashMap = new HashMap(this.c);
        b bVar = new b(this.a, this.b, obj3, hashMap);
        return bVar;
    }

    public final Object c(String string) {
        if (this.c.containsKey(string)) {
            return this.c.get(string);
        }
        return null;
    }

    public final Object clone() {
        return b();
    }

    public final String d() {
        return this.a;
    }

    public final Map<String, Object> e() {
        return this.c;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (!object instanceof b) {
            return i;
        }
        if (Long.compare(l, l2) != 0) {
            return i;
        }
        if (!this.a.equals(object.a)) {
            return i;
        }
        return this.c.equals(object.c);
    }

    public final void f(String string) {
        this.a = string;
    }

    public final void g(String string, Object object2) {
        if (object2 == null) {
            this.c.remove(string);
        }
        this.c.put(string, object2);
    }

    public final int hashCode() {
        long l = this.b;
        return i4 += i8;
    }

    public final String toString() {
        String str = this.a;
        String string2 = this.c.toString();
        StringBuilder stringBuilder = new StringBuilder(i2 += length2);
        stringBuilder.append("Event{name='");
        stringBuilder.append(str);
        stringBuilder.append("', timestamp=");
        stringBuilder.append(this.b);
        stringBuilder.append(", params=");
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
