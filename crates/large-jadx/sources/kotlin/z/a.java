package kotlin.z;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.d0.c.l;

/* loaded from: classes3.dex */
@Metadata(d1 = {"kotlin/comparisons/ComparisonsKt__ComparisonsKt", "kotlin/comparisons/ComparisonsKt___ComparisonsJvmKt", "kotlin/comparisons/ComparisonsKt___ComparisonsKt"}, k = 4, mv = {1, 5, 1}, xi = 1)
public final class a extends kotlin.z.d {
    public static <T> Comparator<T> b(l<? super T, ? extends Comparable<?>>... lArr) {
        return b.b(lArr);
    }

    public static <T extends Comparable<?>> int c(T t, T t2) {
        return b.c(t, t2);
    }

    public static <T extends Comparable<? super T>> Comparator<T> e() {
        return b.e();
    }

    public static <T extends Comparable<? super T>> T f(T t, T t2) {
        return c.f(t, t2);
    }
}
