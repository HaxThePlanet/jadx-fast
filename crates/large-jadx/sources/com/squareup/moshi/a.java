package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: ArrayJsonAdapter.java */
/* loaded from: classes2.dex */
final class a extends f<Object> {

    public static final f.d c = new a$a();
    private final Class<?> a;
    private final f<Object> b;

    class a implements f.d {
        a() {
            super();
        }

        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            Type type2 = t.a(type);
            final int i = 0;
            if (type2 == null) {
                return null;
            }
            if (!set.isEmpty()) {
                return i;
            }
            return new a(t.g(type2), rVar.d(type2)).f();
        }
    }

    a(Class<?> cls, f<Object> fVar) {
        super();
        this.a = cls;
        this.b = fVar;
    }

    @Override // com.squareup.moshi.f
    public Object b(i iVar) {
        int i = 0;
        final ArrayList arrayList = new ArrayList();
        iVar.a();
        while (iVar.j()) {
            arrayList.add(this.b.b(iVar));
        }
        iVar.e();
        Object array = Array.newInstance(this.a, arrayList.size());
        i = 0;
        while (this.b < arrayList.size()) {
            Array.set(array, i, arrayList.get(i));
            i = i + 1;
        }
        return array;
    }

    @Override // com.squareup.moshi.f
    public void i(o oVar, Object object) {
        int i = 0;
        oVar.a();
        i = 0;
        while (i < Array.getLength(object)) {
            this.b.i(oVar, Array.get(object, i));
            i = i + 1;
        }
        oVar.f();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ".array()";
        str = this.b + str2;
        return str;
    }
}
