package com.squareup.moshi.w.a;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.i.a;
import com.squareup.moshi.o;
import com.squareup.moshi.v.b;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.d0.d.n;
import kotlin.i0.c;
import kotlin.i0.g;
import kotlin.i0.j;
import kotlin.i0.k;
import kotlin.i0.n;
import kotlin.i0.o;
import kotlin.y.e;
import kotlin.y.p;

/* loaded from: classes2.dex */
public final class a<T>  extends f<T> {

    private final g<T> a;
    private final List<com.squareup.moshi.w.a.a.a<T, Object>> b;
    private final List<com.squareup.moshi.w.a.a.a<T, Object>> c;
    private final i.a d;

    public static final class a {

        private final String a;
        private final String b;
        private final f<P> c;
        private final n<K, P> d;
        private final k e;
        private final int f;
        public a(String string, String string2, f<P> f3, n<K, ? extends P> n4, k k5, int i6) {
            n.f(string, "name");
            n.f(f3, "adapter");
            n.f(n4, "property");
            super();
            this.a = string;
            this.b = string2;
            this.c = f3;
            this.d = n4;
            this.e = k5;
            this.f = i6;
        }

        public static com.squareup.moshi.w.a.a.a b(com.squareup.moshi.w.a.a.a a$a, String string2, String string3, f f4, n n5, k k6, int i7, int i8, Object object9) {
            String obj5;
            String obj6;
            f obj7;
            n obj8;
            k obj9;
            int obj10;
            if (i8 & 1 != 0) {
                obj5 = a.a;
            }
            if (i8 & 2 != 0) {
                obj6 = a.b;
            }
            if (i8 & 4 != 0) {
                obj7 = a.c;
            }
            if (i8 & 8 != 0) {
                obj8 = a.d;
            }
            if (i8 & 16 != 0) {
                obj9 = a.e;
            }
            if (i8 & 32 != 0) {
                obj10 = a.f;
            }
            return a.a(obj5, obj6, obj7, obj8, obj9, obj10);
        }

        public final com.squareup.moshi.w.a.a.a<K, P> a(String string, String string2, f<P> f3, n<K, ? extends P> n4, k k5, int i6) {
            n.f(string, "name");
            n.f(f3, "adapter");
            n.f(n4, "property");
            super(string, string2, f3, n4, k5, i6);
            return aVar;
        }

        public final P c(K k) {
            return this.d.get(k);
        }

        public final f<P> d() {
            return this.c;
        }

        public final String e() {
            return this.b;
        }

        public boolean equals(Object object) {
            int i;
            Object obj;
            Object obj3;
            if (this != (a.a)object && object instanceof a.a && n.b(this.a, object.a) && n.b(this.b, object.b) && n.b(this.c, object.c) && n.b(this.d, object.d) && n.b(this.e, object.e) && this.f == object.f) {
                if (object instanceof a.a) {
                    if (n.b(this.a, object.a)) {
                        if (n.b(this.b, object.b)) {
                            if (n.b(this.c, object.c)) {
                                if (n.b(this.d, object.d)) {
                                    if (n.b(this.e, object.e)) {
                                        if (this.f == object.f) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return 0;
            }
            return 1;
        }

        public final String f() {
            return this.a;
        }

        public final n<K, P> g() {
            return this.d;
        }

        public final int h() {
            return this.f;
        }

        public int hashCode() {
            int i4;
            int i;
            int i2;
            int i3;
            int i5;
            String str = this.a;
            i = 0;
            if (str != null) {
                i4 = str.hashCode();
            } else {
                i4 = i;
            }
            String str2 = this.b;
            if (str2 != null) {
                i2 = str2.hashCode();
            } else {
                i2 = i;
            }
            f fVar = this.c;
            if (fVar != null) {
                i3 = fVar.hashCode();
            } else {
                i3 = i;
            }
            n nVar = this.d;
            if (nVar != null) {
                i5 = nVar.hashCode();
            } else {
                i5 = i;
            }
            k kVar = this.e;
            if (kVar != null) {
                i = kVar.hashCode();
            }
            return i14 += i16;
        }

        public final void i(K k, P p2) {
            Object obj;
            String str;
            if (p2 != c.a()) {
                obj = this.d;
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K, P>");
                (j)obj.i(k, p2);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Binding(name=");
            stringBuilder.append(this.a);
            stringBuilder.append(", jsonName=");
            stringBuilder.append(this.b);
            stringBuilder.append(", adapter=");
            stringBuilder.append(this.c);
            stringBuilder.append(", property=");
            stringBuilder.append(this.d);
            stringBuilder.append(", parameter=");
            stringBuilder.append(this.e);
            stringBuilder.append(", propertyIndex=");
            stringBuilder.append(this.f);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public static final class b extends e<k, Object> {

        private final List<k> a;
        private final Object[] b;
        public b(List<? extends k> list, Object[] object2Arr2) {
            n.f(list, "parameterKeys");
            n.f(object2Arr2, "parameterValues");
            super();
            this.a = list;
            this.b = object2Arr2;
        }

        public Set<Map.Entry<k, Object>> a() {
            int next2;
            Object next3;
            boolean next;
            int i;
            AbstractMap.SimpleEntry simpleEntry;
            Object[] objArr;
            List list = this.a;
            ArrayList arrayList = new ArrayList(p.r(list, 10));
            Iterator iterator = list.iterator();
            int i5 = 0;
            next2 = i5;
            for (Object next3 : iterator) {
                simpleEntry = new AbstractMap.SimpleEntry((k)next3, this.b[next2]);
                arrayList.add(simpleEntry);
                next2 = i;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                next2 = iterator2.next();
                if ((AbstractMap.SimpleEntry)next2.getValue() != c.a()) {
                } else {
                }
                next = i5;
                if (next) {
                }
                linkedHashSet.add(next2);
                next = 1;
            }
            return linkedHashSet;
        }

        @Override // kotlin.y.e
        public final boolean containsKey(Object object) {
            if (object instanceof k) {
                return f((k)object);
            }
            return 0;
        }

        @Override // kotlin.y.e
        public boolean f(k k) {
            int obj2;
            n.f(k, "key");
            obj2 = this.b[k.getIndex()] != c.a() ? 1 : 0;
            return obj2;
        }

        @Override // kotlin.y.e
        public Object g(k k) {
            Object obj2;
            n.f(k, "key");
            if (this.b[k.getIndex()] != c.a()) {
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        @Override // kotlin.y.e
        public final Object get(Object object) {
            if (object instanceof k) {
                return g((k)object);
            }
            return null;
        }

        @Override // kotlin.y.e
        public final Object getOrDefault(Object object, Object object2) {
            if (object instanceof k) {
                return h((k)object, object2);
            }
            return object2;
        }

        @Override // kotlin.y.e
        public Object h(k k, Object object2) {
            return super.getOrDefault(k, object2);
        }

        @Override // kotlin.y.e
        public Object i(k k, Object object2) {
            n.f(k, "key");
            return null;
        }

        @Override // kotlin.y.e
        public Object j(k k) {
            return super.remove(k);
        }

        @Override // kotlin.y.e
        public boolean k(k k, Object object2) {
            return super.remove(k, object2);
        }

        @Override // kotlin.y.e
        public Object put(Object object, Object object2) {
            return i((k)object, object2);
        }

        @Override // kotlin.y.e
        public final Object remove(Object object) {
            if (object instanceof k) {
                return j((k)object);
            }
            return null;
        }

        @Override // kotlin.y.e
        public final boolean remove(Object object, Object object2) {
            if (object instanceof k) {
                return k((k)object, object2);
            }
            return 0;
        }
    }
    public a(g<? extends T> g, List<com.squareup.moshi.w.a.a.a<T, Object>> list2, List<com.squareup.moshi.w.a.a.a<T, Object>> list3, i.a i$a4) {
        n.f(g, "constructor");
        n.f(list2, "allBindings");
        n.f(list3, "nonTransientBindings");
        n.f(a4, "options");
        super();
        this.a = g;
        this.b = list2;
        this.c = list3;
        this.d = a4;
    }

    public T b(i i) {
        int size;
        Object[] copyOf;
        int parameters;
        int i2;
        int i4;
        Object obj2;
        int i3;
        Object obj3;
        Object obj;
        Object obj9;
        n.f(i, "reader");
        size = this.a.getParameters().size();
        int size2 = this.b.size();
        Object[] arr = new Object[size2];
        parameters = 0;
        i2 = parameters;
        while (i2 < size2) {
            arr[i2] = c.a();
            i2++;
        }
        i.c();
        while (i.j()) {
            i2 = i.J(this.d);
            i2 = this.c.get(i2);
            int i5 = (a.a)i2.h();
            arr[i5] = i2.d().b(i);
            i.T();
            i.U();
        }
        i.f();
        i4 = this.b.size() == size ? 1 : parameters;
        i3 = parameters;
        while (i3 < size) {
            i3++;
            arr[i3] = 0;
            i4 = parameters;
        }
        if (i4 != 0) {
            obj9 = this.a.call(Arrays.copyOf(arr, size2));
        } else {
            copyOf = new a.b(this.a.getParameters(), arr);
            obj9 = this.a.callBy(copyOf);
        }
        while (size < this.b.size()) {
            parameters = this.b.get(size);
            n.d(parameters);
            (a.a)parameters.i(obj9, arr[size]);
            size++;
        }
        return obj9;
    }

    public void i(o o, T t2) {
        Object next;
        f fVar;
        n.f(o, "writer");
        Objects.requireNonNull(t2, "value == null");
        o.c();
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((a.a)next == null) {
            } else {
            }
            o.m((a.a)next.f());
            next.d().i(o, next.c(t2));
        }
        o.i();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KotlinJsonAdapter(");
        stringBuilder.append(this.a.getReturnType());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
