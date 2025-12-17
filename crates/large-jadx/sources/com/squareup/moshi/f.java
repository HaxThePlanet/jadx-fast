package com.squareup.moshi;

import com.squareup.moshi.v.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import l.f;
import l.g;

/* loaded from: classes2.dex */
public abstract class f<T>  {

    public interface d {
        public abstract com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set2, com.squareup.moshi.r r3);
    }

    class a extends com.squareup.moshi.f<T> {

        final com.squareup.moshi.f a;
        a(com.squareup.moshi.f f, com.squareup.moshi.f f2) {
            this.a = f2;
            super();
        }

        public T b(com.squareup.moshi.i i) {
            return this.a.b(i);
        }

        @Override // com.squareup.moshi.f
        boolean d() {
            return this.a.d();
        }

        public void i(com.squareup.moshi.o o, T t2) {
            o.F(true);
            this.a.i(o, t2);
            o.F(o.j());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".serializeNulls()");
            return stringBuilder.toString();
        }
    }

    class b extends com.squareup.moshi.f<T> {

        final com.squareup.moshi.f a;
        b(com.squareup.moshi.f f, com.squareup.moshi.f f2) {
            this.a = f2;
            super();
        }

        public T b(com.squareup.moshi.i i) {
            i.M(true);
            i.M(i.k());
            return this.a.b(i);
        }

        @Override // com.squareup.moshi.f
        boolean d() {
            return 1;
        }

        public void i(com.squareup.moshi.o o, T t2) {
            o.E(true);
            this.a.i(o, t2);
            o.E(o.k());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".lenient()");
            return stringBuilder.toString();
        }
    }

    class c extends com.squareup.moshi.f<T> {

        final com.squareup.moshi.f a;
        c(com.squareup.moshi.f f, com.squareup.moshi.f f2) {
            this.a = f2;
            super();
        }

        public T b(com.squareup.moshi.i i) {
            i.L(true);
            i.L(i.i());
            return this.a.b(i);
        }

        @Override // com.squareup.moshi.f
        boolean d() {
            return this.a.d();
        }

        public void i(com.squareup.moshi.o o, T t2) {
            this.a.i(o, t2);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".failOnUnknown()");
            return stringBuilder.toString();
        }
    }
    public final com.squareup.moshi.f<T> a() {
        f.c cVar = new f.c(this, this);
        return cVar;
    }

    public abstract T b(com.squareup.moshi.i i);

    public final T c(String string) {
        boolean eND_DOCUMENT;
        Object obj3;
        f fVar = new f();
        fVar.b1(string);
        obj3 = i.x(fVar);
        if (!d()) {
            if (obj3.E() != i.b.END_DOCUMENT) {
            } else {
            }
            obj3 = new JsonDataException("JSON document was not fully consumed.");
            throw obj3;
        }
        return b(obj3);
    }

    boolean d() {
        return 0;
    }

    public final com.squareup.moshi.f<T> e() {
        f.b bVar = new f.b(this, this);
        return bVar;
    }

    public final com.squareup.moshi.f<T> f() {
        if (this instanceof a) {
            return this;
        }
        a aVar = new a(this);
        return aVar;
    }

    public final com.squareup.moshi.f<T> g() {
        f.a aVar = new f.a(this, this);
        return aVar;
    }

    public final String h(T t) {
        f fVar = new f();
        j(fVar, t);
        return fVar.r1();
    }

    public abstract void i(com.squareup.moshi.o o, T t2);

    public final void j(g g, T t2) {
        i(o.o(g), t2);
    }
}
