package i.b.m0.e.f;

import i.b.g0;
import i.b.l0.n;
import i.b.r;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import m.c.a;

/* loaded from: classes3.dex */
public final class h0 {

    static enum a implements Callable<NoSuchElementException> {

        INSTANCE;
        @Override // java.lang.Enum
        public Object call() {
            return call();
        }

        @Override // java.lang.Enum
        public NoSuchElementException call() {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            return noSuchElementException;
        }
    }

    static enum b implements n<g0, a> {

        INSTANCE;
        @Override // java.lang.Enum
        public Object apply(Object object) {
            return apply((g0)object);
        }

        @Override // java.lang.Enum
        public a apply(g0 g0) {
            u0 u0Var = new u0(g0);
            return u0Var;
        }
    }

    static enum c implements n<g0, r> {

        INSTANCE;
        @Override // java.lang.Enum
        public r apply(g0 g0) {
            v0 v0Var = new v0(g0);
            return v0Var;
        }

        @Override // java.lang.Enum
        public Object apply(Object object) {
            return apply((g0)object);
        }
    }
    public static <T> Callable<NoSuchElementException> a() {
        return h0.a.INSTANCE;
    }

    public static <T> n<g0<? extends T>, a<? extends T>> b() {
        return h0.b.INSTANCE;
    }

    public static <T> n<g0<? extends T>, r<? extends T>> c() {
        return h0.c.INSTANCE;
    }
}
