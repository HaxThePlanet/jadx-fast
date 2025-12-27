package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapJsonAdapter.java */
/* loaded from: classes2.dex */
final class q<K, V> extends f<Map<K, V>> {

    public static final f.d c = new q$a();
    private final f<K> a;
    private final f<V> b;

    class a implements f.d {
        a() {
            super();
        }

        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            int i = 0;
            if (!set.isEmpty()) {
                return null;
            }
            Class cls = t.g(type);
            if (cls != Map.class) {
                return i;
            }
            Type[] objArr = t.i(type, cls);
            return new q(rVar, objArr[0], objArr[1]).f();
        }
    }

    q(r rVar, Type type, Type type2) {
        super();
        this.a = rVar.d(type);
        this.b = rVar.d(type2);
    }

    @Override // com.squareup.moshi.f
    public Map<K, V> k(i iVar) throws JsonDataException {
        com.squareup.moshi.p pVar = new p();
        iVar.c();
        while (iVar.j()) {
            iVar.F();
            Object obj = this.a.b(iVar);
            Object obj2 = this.b.b(iVar);
            Object obj3 = pVar.put(obj, obj2);
            if (obj3 != null) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Map key '";
                String str = "' has multiple values at path ";
                String path = iVar.getPath();
                String str3 = ": ";
                String str4 = " and ";
                iVar = str2 + obj + str + path + str3 + obj3 + str4 + obj2;
                throw new JsonDataException(iVar);
            }
        }
        iVar.f();
        return pVar;
    }

    @Override // com.squareup.moshi.f
    public void l(o oVar, Map<K, V> map) throws JsonDataException {
        oVar.c();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.getKey() == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Map key is null at ";
                String path = oVar.getPath();
                oVar = str + path;
                throw new JsonDataException(oVar);
            }
        }
        oVar.i();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "JsonAdapter(";
        String str3 = "=";
        String str4 = ")";
        str = str2 + this.a + str3 + this.b + str4;
        return str;
    }
}
