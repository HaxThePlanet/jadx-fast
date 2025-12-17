package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0008\u0003\u001aG\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\u0008\u001a?\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\u000c\u001aG\u0010\r\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\u0008\u001a?\u0010\r\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\r\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u00012\u0012\u0010\n\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00010\u000b\"\u0002H\u00012\u001a\u0010\u0005\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00010\u0006j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0001`\u0007H\u0007¢\u0006\u0002\u0010\u000c¨\u0006\u000e", d2 = {"maxOf", "T", "a", "b", "c", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "other", "", "(Ljava/lang/Object;[Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsKt extends kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt {
    public static final <T> T maxOf(T a, T b, T c, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ComparisonsKt.maxOf(a, ComparisonsKt.maxOf(b, c, comparator), comparator);
    }

    public static final <T> T maxOf(T a, T b, Comparator<? super T> comparator) {
        Object obj;
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        obj = comparator.compare(a, b) >= 0 ? a : b;
        return obj;
    }

    public static final <T> T maxOf(T a, T[] other, Comparator<? super T> comparator) {
        Object max;
        int i;
        Object obj;
        int compare;
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        max = a;
        i = 0;
        while (i < other.length) {
            obj = other[i];
            if (comparator.compare(max, obj) < 0) {
            }
            i++;
            max = obj;
        }
        return max;
    }

    public static final <T> T minOf(T a, T b, T c, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ComparisonsKt.minOf(a, ComparisonsKt.minOf(b, c, comparator), comparator);
    }

    public static final <T> T minOf(T a, T b, Comparator<? super T> comparator) {
        Object obj;
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        obj = comparator.compare(a, b) <= 0 ? a : b;
        return obj;
    }

    public static final <T> T minOf(T a, T[] other, Comparator<? super T> comparator) {
        Object min;
        int i;
        Object obj;
        int compare;
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        min = a;
        i = 0;
        while (i < other.length) {
            obj = other[i];
            if (comparator.compare(min, obj) > 0) {
            }
            i++;
            min = obj;
        }
        return min;
    }
}
