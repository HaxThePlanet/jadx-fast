package kotlin.y;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.g0.c;
import kotlin.h0.f;
import kotlin.j0.h;
import kotlin.o;

/* loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/collections/CollectionsKt__CollectionsJVMKt", "kotlin/collections/CollectionsKt__CollectionsKt", "kotlin/collections/CollectionsKt__IterablesKt", "kotlin/collections/CollectionsKt__IteratorsJVMKt", "kotlin/collections/CollectionsKt__IteratorsKt", "kotlin/collections/CollectionsKt__MutableCollectionsJVMKt", "kotlin/collections/CollectionsKt__MutableCollectionsKt", "kotlin/collections/CollectionsKt__ReversedViewsKt", "kotlin/collections/CollectionsKt___CollectionsJvmKt", "kotlin/collections/CollectionsKt___CollectionsKt"}, k = 4, mv = {1, 5, 1}, xi = 1)
public final class p extends kotlin.y.z {
    public static <T> T A0(Iterable<? extends T> iterable) {
        return z.A0(iterable);
    }

    public static <T> T B0(List<? extends T> list) {
        return z.B0(list);
    }

    public static <T extends Comparable<? super T>> List<T> C0(Iterable<? extends T> iterable) {
        return z.C0(iterable);
    }

    public static <T> List<T> D0(Iterable<? extends T> iterable, Comparator<? super T> comparator2) {
        return z.D0(iterable, comparator2);
    }

    public static <T> List<T> E(List<? extends T> list) {
        return x.E(list);
    }

    public static <T> Set<T> E0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return z.E0(iterable, iterable2);
    }

    public static <T> List<T> F(List<T> list) {
        return x.F(list);
    }

    public static <T> List<T> F0(Iterable<? extends T> iterable, int i2) {
        return z.F0(iterable, i2);
    }

    public static <T> List<T> G0(List<? extends T> list, int i2) {
        return z.G0(list, i2);
    }

    public static <R> List<R> I(Iterable<?> iterable, Class<R> class2) {
        return y.I(iterable, class2);
    }

    public static float[] I0(Collection<Float> collection) {
        return z.I0(collection);
    }

    public static <T> HashSet<T> J0(Iterable<? extends T> iterable) {
        return z.J0(iterable);
    }

    public static int[] K0(Collection<Integer> collection) {
        return z.K0(collection);
    }

    public static <T> boolean L(Iterable<? extends T> iterable, l<? super T, Boolean> l2) {
        return z.L(iterable, l2);
    }

    public static <T> List<T> L0(Iterable<? extends T> iterable) {
        return z.L0(iterable);
    }

    public static <T> h<T> M(Iterable<? extends T> iterable) {
        return z.M(iterable);
    }

    public static <T> boolean N(Iterable<? extends T> iterable, T t2) {
        return z.N(iterable, t2);
    }

    public static <T> List<T> N0(Collection<? extends T> collection) {
        return z.N0(collection);
    }

    public static <T> List<T> O(Iterable<? extends T> iterable) {
        return z.O(iterable);
    }

    public static <T> Set<T> O0(Iterable<? extends T> iterable) {
        return z.O0(iterable);
    }

    public static <T> List<T> P(Iterable<? extends T> iterable, int i2) {
        return z.P(iterable, i2);
    }

    public static <T> Set<T> P0(Iterable<? extends T> iterable) {
        return z.P0(iterable);
    }

    public static <T> List<T> Q(List<? extends T> list, int i2) {
        return z.Q(list, i2);
    }

    public static <T> Set<T> Q0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return z.Q0(iterable, iterable2);
    }

    public static <T> Iterable<kotlin.y.e0<T>> R0(Iterable<? extends T> iterable) {
        return z.R0(iterable);
    }

    public static <T, R> List<o<T, R>> S0(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        return z.S0(iterable, iterable2);
    }

    public static <T> List<T> T(Iterable<? extends T> iterable, l<? super T, Boolean> l2) {
        return z.T(iterable, l2);
    }

    public static <T> List<T> U(Iterable<? extends T> iterable) {
        return z.U(iterable);
    }

    public static <T> T W(Iterable<? extends T> iterable) {
        return z.W(iterable);
    }

    public static <T> T X(List<? extends T> list) {
        return z.X(list);
    }

    public static <T> T Y(Iterable<? extends T> iterable) {
        return z.Y(iterable);
    }

    public static <T> T Z(List<? extends T> list) {
        return z.Z(list);
    }

    public static <T> T a0(List<? extends T> list, int i2) {
        return z.a0(list, i2);
    }

    public static <T> List<T> b(T t) {
        return q.b(t);
    }

    public static <T> ArrayList<T> c(T... tArr) {
        return r.c(tArr);
    }

    public static <T> int c0(List<? extends T> list, T t2) {
        return z.c0(list, t2);
    }

    public static <T> Set<T> d0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return z.d0(iterable, iterable2);
    }

    public static int f(List list, Comparable comparable2, int i3, int i4, int i5, Object object6) {
        return r.f(list, comparable2, i3, i4, i5, object6);
    }

    public static java.lang.Appendable f0(Iterable iterable, java.lang.Appendable appendable2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, java.lang.CharSequence charSequence5, int i6, java.lang.CharSequence charSequence7, l l8, int i9, Object object10) {
        z.f0(iterable, appendable2, charSequence3, charSequence4, charSequence5, i6, charSequence7, l8, i9, object10);
        return appendable2;
    }

    public static <T> List<T> g() {
        return r.g();
    }

    public static <T> String g0(Iterable<? extends T> iterable, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, l<? super T, ? extends java.lang.CharSequence> l7) {
        return z.g0(iterable, charSequence2, charSequence3, charSequence4, i5, charSequence6, l7);
    }

    public static f h(Collection<?> collection) {
        return r.h(collection);
    }

    public static String h0(Iterable iterable, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, l l7, int i8, Object object9) {
        return z.h0(iterable, charSequence2, charSequence3, charSequence4, i5, charSequence6, l7, i8, object9);
    }

    public static <T> int i(List<? extends T> list) {
        return r.i(list);
    }

    public static <T> T i0(Iterable<? extends T> iterable) {
        return z.i0(iterable);
    }

    public static <T> List<T> j(T... tArr) {
        return r.j(tArr);
    }

    public static <T> T j0(List<? extends T> list) {
        return z.j0(list);
    }

    public static <T> List<T> k(T t) {
        return r.k(t);
    }

    public static <T> T k0(Iterable<? extends T> iterable) {
        return z.k0(iterable);
    }

    public static <T> List<T> l(T... tArr) {
        return r.l(tArr);
    }

    public static <T> T l0(List<? extends T> list) {
        return z.l0(list);
    }

    public static <T> List<T> m(T... tArr) {
        return r.m(tArr);
    }

    public static <T, R> List<R> m0(Iterable<? extends T> iterable, l<? super T, ? extends R> l2) {
        return z.m0(iterable, l2);
    }

    public static <T> List<T> n(List<? extends T> list) {
        return r.n(list);
    }

    public static <T extends Comparable<? super T>> T n0(Iterable<? extends T> iterable) {
        return z.n0(iterable);
    }

    public static <T extends Comparable<? super T>> T o0(Iterable<? extends T> iterable) {
        return z.o0(iterable);
    }

    public static void p() {
        r.p();
        throw 0;
    }

    public static <T> List<T> p0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return z.p0(iterable, iterable2);
    }

    public static void q() {
        r.q();
        throw 0;
    }

    public static <T> List<T> q0(Iterable<? extends T> iterable, T t2) {
        return z.q0(iterable, t2);
    }

    public static <T> int r(Iterable<? extends T> iterable, int i2) {
        return s.r(iterable, i2);
    }

    public static <T> List<T> r0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return z.r0(iterable, iterable2);
    }

    public static <T> List<T> s0(Iterable<? extends T> iterable, T t2) {
        return z.s0(iterable, t2);
    }

    public static <T> List<T> t0(Collection<? extends T> collection, Iterable<? extends T> iterable2) {
        return z.t0(collection, iterable2);
    }

    public static <T> List<T> u(Iterable<? extends Iterable<? extends T>> iterable) {
        return s.u(iterable);
    }

    public static <T> List<T> u0(Collection<? extends T> collection, T t2) {
        return z.u0(collection, t2);
    }

    public static <T> T v0(Collection<? extends T> collection, c c2) {
        return z.v0(collection, c2);
    }

    public static <T extends Comparable<? super T>> void w(List<T> list) {
        v.w(list);
    }

    public static <T> List<T> w0(List<? extends T> list) {
        z.w0(list);
        return list;
    }

    public static <T> void x(List<T> list, Comparator<? super T> comparator2) {
        v.x(list, comparator2);
    }

    public static <T> List<T> x0(Iterable<? extends T> iterable) {
        return z.x0(iterable);
    }

    public static <T> boolean y(Collection<? super T> collection, Iterable<? extends T> iterable2) {
        return w.y(collection, iterable2);
    }

    public static <T> T y0(Iterable<? extends T> iterable) {
        return z.y0(iterable);
    }

    public static <T> boolean z(Collection<? super T> collection, T[] t2Arr2) {
        return w.z(collection, t2Arr2);
    }

    public static <T> T z0(List<? extends T> list) {
        return z.z0(list);
    }
}
