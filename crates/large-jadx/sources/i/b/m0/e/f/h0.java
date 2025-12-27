package i.b.m0.e.f;

import i.b.g0;
import i.b.l0.n;
import i.b.r;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import m.c.a;

/* compiled from: SingleInternalHelper.java */
/* loaded from: classes3.dex */
public final class h0 {

    enum a implements Callable<NoSuchElementException> {

        INSTANCE;
        @Override // java.lang.Enum
        public NoSuchElementException call() {
            return new NoSuchElementException();
        }
    }

    enum b implements n<g0, a> {

        INSTANCE;
        @Override // java.lang.Enum
        public a apply(g0 g0Var) {
            return new u0(g0Var);
        }
    }

    enum c implements n<g0, r> {

        INSTANCE;
        @Override // java.lang.Enum
        public r apply(g0 g0Var) {
            return new v0(g0Var);
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
