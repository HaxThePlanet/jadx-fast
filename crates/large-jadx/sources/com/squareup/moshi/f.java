package com.squareup.moshi;

import com.squareup.moshi.v.a;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import l.f;
import l.g;

/* compiled from: JsonAdapter.java */
/* loaded from: classes2.dex */
public abstract class f<T> {

    public interface d {
        f<?> a(Type type, Set<? extends Annotation> set, r rVar);
    }

    class a extends f<T> {

        final /* synthetic */ f a;
        a(f fVar) {
            this.a = fVar2;
            super();
        }

        @Override // com.squareup.moshi.f
        public T b(i iVar) {
            return this.a.b(iVar);
        }

        @Override // com.squareup.moshi.f
        boolean d() {
            return this.a.d();
        }

        @Override // com.squareup.moshi.f
        public void i(o oVar, T t) {
            oVar.F(true);
            try {
                this.a.i(oVar, t);
            } finally {
                oVar.F(z);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) t;
            }
            oVar.F(oVar.j());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".serializeNulls()";
            str = this.a + str2;
            return str;
        }
    }

    class b extends f<T> {

        final /* synthetic */ f a;
        b(f fVar) {
            this.a = fVar2;
            super();
        }

        @Override // com.squareup.moshi.f
        public T b(i iVar) {
            iVar.M(true);
            try {
            } finally {
                iVar.M(z);
                throw th;
            }
            iVar.M(iVar.k());
            return this.a.b(iVar);
        }

        @Override // com.squareup.moshi.f
        public void i(o oVar, T t) {
            oVar.E(true);
            try {
                this.a.i(oVar, t);
            } finally {
                oVar.E(z);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) t;
            }
            oVar.E(oVar.k());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".lenient()";
            str = this.a + str2;
            return str;
        }

        @Override // com.squareup.moshi.f
        boolean d() {
            return true;
        }
    }

    class c extends f<T> {

        final /* synthetic */ f a;
        c(f fVar) {
            this.a = fVar2;
            super();
        }

        @Override // com.squareup.moshi.f
        public T b(i iVar) {
            iVar.L(true);
            try {
            } finally {
                iVar.L(z);
                throw th;
            }
            iVar.L(iVar.i());
            return this.a.b(iVar);
        }

        @Override // com.squareup.moshi.f
        boolean d() {
            return this.a.d();
        }

        @Override // com.squareup.moshi.f
        public void i(o oVar, T t) {
            this.a.i(oVar, t);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".failOnUnknown()";
            str = this.a + str2;
            return str;
        }
    }
    public final f<T> a() {
        return new f.c(this, this);
    }

    public final T c(String str) throws JsonDataException {
        f fVar = new f();
        fVar.b1(str);
        com.squareup.moshi.i iVar = i.x(fVar);
        if (!d()) {
            if (iVar.E() != i.b.END_DOCUMENT) {
                throw new JsonDataException("JSON document was not fully consumed.");
            }
        }
        return b(iVar);
    }

    public final f<T> e() {
        return new f.b(this, this);
    }

    public final f<T> f() {
        if (this instanceof a) {
            return this;
        }
        return new a(this);
    }

    public final f<T> g() {
        return new f.a(this, this);
    }

    public final String h(T t) {
        final f fVar = new f();
        try {
            j(fVar, t);
        } catch (java.io.IOException ioException) {
            throw new AssertionError(ioException);
        }
        return fVar.r1();
    }

    public final void j(g gVar, T t) {
        i(o.o(gVar), t);
    }

    public abstract T b(i iVar);

    boolean d() {
        return false;
    }

    public abstract void i(o oVar, T t);
}
