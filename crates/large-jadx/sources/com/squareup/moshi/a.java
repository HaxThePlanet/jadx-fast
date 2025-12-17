package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
final class a extends com.squareup.moshi.f<Object> {

    public static final com.squareup.moshi.f.d c;
    private final Class<?> a;
    private final com.squareup.moshi.f<Object> b;

    class a implements com.squareup.moshi.f.d {
        public com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set2, com.squareup.moshi.r r3) {
            Type obj2 = t.a(type);
            final int i = 0;
            if (obj2 == null) {
                return i;
            }
            if (!set2.isEmpty()) {
                return i;
            }
            a obj4 = new a(t.g(obj2), r3.d(obj2));
            return obj4.f();
        }
    }
    static {
        a.a aVar = new a.a();
        a.c = aVar;
    }

    a(Class<?> class, com.squareup.moshi.f<Object> f2) {
        super();
        this.a = class;
        this.b = f2;
    }

    @Override // com.squareup.moshi.f
    public Object b(com.squareup.moshi.i i) {
        Object obj2;
        int i2;
        Object obj;
        ArrayList arrayList = new ArrayList();
        i.a();
        while (i.j()) {
            arrayList.add(this.b.b(i));
        }
        i.e();
        Object obj4 = Array.newInstance(this.a, arrayList.size());
        i2 = 0;
        while (i2 < arrayList.size()) {
            Array.set(obj4, i2, arrayList.get(i2));
            i2++;
        }
        return obj4;
    }

    @Override // com.squareup.moshi.f
    public void i(com.squareup.moshi.o o, Object object2) {
        int i;
        com.squareup.moshi.f fVar;
        Object obj;
        o.a();
        i = 0;
        while (i < Array.getLength(object2)) {
            this.b.i(o, Array.get(object2, i));
            i++;
        }
        o.f();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append(".array()");
        return stringBuilder.toString();
    }
}
