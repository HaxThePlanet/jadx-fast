package kotlin.y;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/collections/SetsKt__SetsJVMKt", "kotlin/collections/SetsKt__SetsKt", "kotlin/collections/SetsKt___SetsKt"}, k = 4, mv = {1, 5, 1}, xi = 1)
public final class q0 extends kotlin.y.t0 {
    public static <T> Set<T> a(T t) {
        return r0.a(t);
    }

    public static <T> Set<T> b() {
        return s0.b();
    }

    public static <T> HashSet<T> c(T... tArr) {
        return s0.c(tArr);
    }

    public static <T> LinkedHashSet<T> d(T... tArr) {
        return s0.d(tArr);
    }

    public static <T> Set<T> e(T... tArr) {
        return s0.e(tArr);
    }

    public static <T> Set<T> f(Set<? extends T> set) {
        return s0.f(set);
    }

    public static <T> Set<T> g(T... tArr) {
        return s0.g(tArr);
    }

    public static <T> Set<T> h(Set<? extends T> set, Iterable<? extends T> iterable2) {
        return t0.h(set, iterable2);
    }

    public static <T> Set<T> i(Set<? extends T> set, Iterable<? extends T> iterable2) {
        return t0.i(set, iterable2);
    }

    public static <T> Set<T> j(Set<? extends T> set, T t2) {
        return t0.j(set, t2);
    }
}
