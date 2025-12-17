package kotlin.y;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.j0.h;
import kotlin.o;

/* loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/collections/MapsKt__MapWithDefaultKt", "kotlin/collections/MapsKt__MapsJVMKt", "kotlin/collections/MapsKt__MapsKt", "kotlin/collections/MapsKt___MapsKt"}, k = 4, mv = {1, 5, 1}, xi = 1)
public final class j0 extends kotlin.y.n0 {
    public static <K, V> Map<K, V> b(Map<K, V> map) {
        return l0.b(map);
    }

    public static <K, V> Map<K, V> c() {
        return l0.c();
    }

    public static int d(int i) {
        return l0.d(i);
    }

    public static <K, V> Map<K, V> e(o<? extends K, ? extends V> o) {
        return l0.e(o);
    }

    public static <K, V> SortedMap<K, V> g(Map<? extends K, ? extends V> map, Comparator<? super K> comparator2) {
        return l0.g(map, comparator2);
    }

    public static <K, V> Map<K, V> h() {
        return m0.h();
    }

    public static <K, V> V i(Map<K, ? extends V> map, K k2) {
        return m0.i(map, k2);
    }

    public static <K, V> HashMap<K, V> j(o<? extends K, ? extends V>... oArr) {
        return m0.j(oArr);
    }

    public static <K, V> Map<K, V> k(o<? extends K, ? extends V>... oArr) {
        return m0.k(oArr);
    }

    public static <K, V> Map<K, V> l(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable2) {
        return m0.l(map, iterable2);
    }

    public static <K, V> Map<K, V> m(o<? extends K, ? extends V>... oArr) {
        return m0.m(oArr);
    }

    public static <K, V> Map<K, V> o(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        return m0.o(map, map2);
    }

    public static <K, V> void p(Map<? super K, ? super V> map, Iterable<? extends o<? extends K, ? extends V>> iterable2) {
        m0.p(map, iterable2);
    }

    public static <K, V> Map<K, V> s(Iterable<? extends o<? extends K, ? extends V>> iterable) {
        return m0.s(iterable);
    }

    public static <K, V> Map<K, V> u(Map<? extends K, ? extends V> map) {
        return m0.u(map);
    }

    public static <K, V> Map<K, V> v(h<? extends o<? extends K, ? extends V>> h) {
        return m0.v(h);
    }

    public static <K, V> Map<K, V> y(Map<? extends K, ? extends V> map) {
        return m0.y(map);
    }
}
