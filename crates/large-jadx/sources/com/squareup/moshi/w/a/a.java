package com.squareup.moshi.w.a;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.i.a;
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
import kotlin.i0.c;
import kotlin.i0.g;
import kotlin.i0.j;
import kotlin.i0.k;
import kotlin.y.e;
import kotlin.y.p;

/* compiled from: KotlinJsonAdapter.kt */
/* loaded from: classes2.dex */
public final class a<T> extends f<T> {

    private final g<T> a;
    private final List<a.a<T, Object>> b;
    private final List<a.a<T, Object>> c;
    private final i.a d;

    public static final class a<K, P> {

        private final String a;
        private final String b;
        private final f<P> c;
        private final kotlin.i0.n<K, P> d;
        private final k e;
        private final int f;
        public a(String str, String str2, f<P> fVar, kotlin.i0.n<K, ? extends P> nVar, k kVar, int i) {
            n.f(str, "name");
            n.f(fVar, "adapter");
            n.f(nVar, "property");
            super();
            this.a = str;
            this.b = str2;
            this.c = fVar;
            this.d = nVar;
            this.e = kVar;
            this.f = i;
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

        public final String f() {
            return this.a;
        }

        public final kotlin.i0.n<K, P> g() {
            return this.d;
        }

        public final int h() {
            return this.f;
        }

        public final void i(K k, P p) {
            if (p != c.b) {
                str = "null cannot be cast to non-null type kotlin.reflect.KMutableProperty1<K, P>";
                Objects.requireNonNull(this.d, str);
                nVar.i(k, p);
            }
        }

        public static /* synthetic */ a.a b(a.a aVar, String str, String str2, f fVar, kotlin.i0.n nVar, k kVar, int i, int i2, Object object) {
            String str22;
            String object92;
            f fVar42;
            kotlin.i0.n nVar52;
            k kVar62;
            int i72;
            if (i2 & 1 != 0) {
            }
            if (i2 & 2 != 0) {
            }
            if (i2 & 4 != 0) {
            }
            if (i2 & 8 != 0) {
            }
            if (i2 & 16 != 0) {
            }
            if (i2 & 32 != 0) {
            }
            return aVar.a(str22, object92, fVar42, nVar52, kVar62, i72);
        }

        public final a.a<K, P> a(String str, String str2, f<P> fVar, kotlin.i0.n<K, ? extends P> nVar, k kVar, int i) {
            n.f(str, "name");
            n.f(fVar, "adapter");
            n.f(nVar, "property");
            a.a aVar = new a.a(str, str2, fVar, nVar, kVar, i);
            return aVar;
        }

        public boolean equals(Object object) {
            if (this != object) {
                z = object instanceof a.a;
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            i = 0;
            if (this.a != null) {
                i = this.a.hashCode();
            } else {
            }
            if (this.b != null) {
                i = this.b.hashCode();
            } else {
            }
            if (this.c != null) {
                i = this.c.hashCode();
            } else {
            }
            if (this.d != null) {
                i = this.d.hashCode();
            } else {
            }
            if (this.e != null) {
                i = this.e.hashCode();
            }
            return (i * 31) + i * 31 + i * 31 + i * 31 + i * 31 + this.f;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Binding(name=";
            String str4 = ", jsonName=";
            String str6 = ", adapter=";
            String str7 = ", property=";
            String str8 = ", parameter=";
            String str9 = ", propertyIndex=";
            String str10 = ")";
            str = str2 + this.a + str4 + this.b + str6 + this.c + str7 + this.d + str8 + this.e + str9 + this.f + str10;
            return str;
        }
    }

    public static final class b extends e<k, Object> {

        private final List<k> a;
        private final Object[] b;
        public b(List<? extends k> list, Object[] objectArr) {
            n.f(list, "parameterKeys");
            n.f(objectArr, "parameterValues");
            super();
            this.a = list;
            this.b = objectArr;
        }

        @Override // kotlin.y.e
        public Set<Map.Entry<k, Object>> a() {
            int i;
            boolean hasNext = true;
            ArrayList arrayList = new ArrayList(p.r(this.a, 10));
            Iterator it = this.a.iterator();
            i = 0;
            while (it.hasNext()) {
                i = i + 1;
                if (i < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object item = it2.next();
                int r4 = (AbstractMap.SimpleEntry)item.getValue() != c.b ? 1 : i;
            }
            return linkedHashSet;
        }

        @Override // kotlin.y.e
        public final boolean containsKey(Object object) {
            if (object instanceof KParameter) {
                return f(object);
            }
            return false;
        }

        @Override // kotlin.y.e
        public boolean f(k kVar) {
            boolean z = true;
            n.f(kVar, "key");
            kVar = this.b[kVar.getIndex()] != c.b ? 1 : 0;
            return (this.b[kVar.getIndex()] != c.b ? 1 : 0);
        }

        @Override // kotlin.y.e
        public Object g(k kVar) {
            Object obj = null;
            n.f(kVar, "key");
            if (this.b[kVar.getIndex()] == c.b) {
                int i = 0;
            }
            return obj;
        }

        @Override // kotlin.y.e
        public final Object get(Object object) {
            if (object instanceof KParameter) {
                return g(object);
            }
            return null;
        }

        @Override // kotlin.y.e
        public final Object getOrDefault(Object object, Object object2) {
            if (object instanceof KParameter) {
                return h(object, object2);
            }
            return object2;
        }

        @Override // kotlin.y.e
        public Object h(k kVar, Object object) {
            return super.getOrDefault(kVar, object);
        }

        @Override // kotlin.y.e
        public Object j(k kVar) {
            return super.remove(kVar);
        }

        @Override // kotlin.y.e
        public boolean k(k kVar, Object object) {
            return super.remove(kVar, object);
        }

        @Override // kotlin.y.e
        public final Object remove(Object object) {
            if (object instanceof KParameter) {
                return j(object);
            }
            return null;
        }

        @Override // kotlin.y.e
        public final boolean remove(Object object, Object object2) {
            if (object instanceof KParameter) {
                return k(object, object2);
            }
            return false;
        }

        @Override // kotlin.y.e
        public Object i(k kVar, Object object) {
            n.f(kVar, "key");
            return null;
        }
    }
    public a(g<? extends T> gVar, List<a.a<T, Object>> list, List<a.a<T, Object>> list2, i.a aVar) {
        n.f(gVar, "constructor");
        n.f(list, "allBindings");
        n.f(list2, "nonTransientBindings");
        n.f(aVar, "options");
        super();
        this.a = gVar;
        this.b = list;
        this.c = list2;
        this.d = aVar;
    }

    @Override // com.squareup.moshi.f
    public T b(i iVar) throws JsonDataException {
        int size;
        int i = 0;
        Object obj;
        Object obj2;
        Object obj3;
        String str = null;
        Object callBy;
        n.f(iVar, "reader");
        size = this.a.getParameters().size();
        int size2 = this.b.size();
        Object[] arr = new Object[size2];
        i = 0;
        while (i < this.b) {
            arr[i] = c.b;
            i = i + 1;
        }
        iVar.c();
        while (iVar.j()) {
            i = iVar.J(this.d);
            obj = -1;
            if (i != -1) {
                Object item4 = this.c.get(i);
                int i2 = item4.h();
            }
        }
        iVar.f();
        int r4 = this.b.size() == this.a ? 1 : i;
        while (c.b < this.a) {
            if (arr[i] == c.b) {
            }
        }
        if (this.d != 0) {
            callBy = this.a.call(Arrays.copyOf(arr, size2));
        } else {
            callBy = this.a.callBy(new a.b(this.a.getParameters(), arr));
        }
        while (this.a < this.b.size()) {
            Object item3 = this.b.get(size);
            n.d(item3);
            item3.i(callBy, arr[size]);
            size = size + 1;
        }
        return callBy;
    }

    @Override // com.squareup.moshi.f
    public void i(com.squareup.moshi.o oVar, T t) {
        f fVar;
        n.f(oVar, "writer");
        Objects.requireNonNull(t, "value == null");
        oVar.c();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        oVar.i();
    }

    @Override // com.squareup.moshi.f
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "KotlinJsonAdapter(";
        kotlin.i0.o returnType = this.a.getReturnType();
        str = str2 + returnType + 41;
        return str;
    }
}
