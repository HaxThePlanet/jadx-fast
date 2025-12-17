package com.squareup.moshi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
final class q<K, V>  extends com.squareup.moshi.f<Map<K, V>> {

    public static final com.squareup.moshi.f.d c;
    private final com.squareup.moshi.f<K> a;
    private final com.squareup.moshi.f<V> b;

    class a implements com.squareup.moshi.f.d {
        public com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set2, com.squareup.moshi.r r3) {
            int i = 0;
            if (!set2.isEmpty()) {
                return i;
            }
            Class obj4 = t.g(type);
            if (obj4 != Map.class) {
                return i;
            }
            Type[] obj3 = t.i(type, obj4);
            obj4 = new q(r3, obj3[0], obj3[1]);
            return obj4.f();
        }
    }
    static {
        q.a aVar = new q.a();
        q.c = aVar;
    }

    q(com.squareup.moshi.r r, Type type2, Type type3) {
        super();
        this.a = r.d(type2);
        this.b = r.d(type3);
    }

    @Override // com.squareup.moshi.f
    public Object b(com.squareup.moshi.i i) {
        return k(i);
    }

    @Override // com.squareup.moshi.f
    public void i(com.squareup.moshi.o o, Object object2) {
        l(o, (Map)object2);
    }

    public Map<K, V> k(com.squareup.moshi.i i) {
        Object obj3;
        Object obj2;
        Object obj;
        p pVar = new p();
        i.c();
        while (i.j()) {
            i.F();
            obj3 = this.a.b(i);
            obj2 = this.b.b(i);
            obj = pVar.put(obj3, obj2);
        }
        i.f();
        return pVar;
    }

    public void l(com.squareup.moshi.o o, Map<K, V> map2) {
        Object value;
        com.squareup.moshi.f fVar;
        Object key;
        o.c();
        Iterator obj5 = map2.entrySet().iterator();
        for (Map.Entry next2 : obj5) {
            o.r();
            this.a.i(o, next2.getKey());
            this.b.i(o, next2.getValue());
        }
        o.i();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonAdapter(");
        stringBuilder.append(this.a);
        stringBuilder.append("=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
