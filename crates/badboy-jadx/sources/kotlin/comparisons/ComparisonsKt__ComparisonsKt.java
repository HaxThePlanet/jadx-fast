package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a>\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u00022\u001a\u0008\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u0005H\u0087\u0008ø\u0001\u0000\u001aY\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u000226\u0010\u0007\u001a\u001c\u0012\u0018\u0008\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u00050\u0008\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\t\u001aZ\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\n`\u00032\u0014\u0008\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\u0008ø\u0001\u0000\u001a>\u0010\u000c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u00022\u001a\u0008\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u0005H\u0087\u0008ø\u0001\u0000\u001aZ\u0010\u000c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\n`\u00032\u0014\u0008\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\u0008ø\u0001\u0000\u001a-\u0010\r\u001a\u00020\u000e\"\u000c\u0008\u0000\u0010\u0002*\u0006\u0012\u0002\u0008\u00030\u00062\u0008\u0010\u000f\u001a\u0004\u0018\u0001H\u00022\u0008\u0010\u0010\u001a\u0004\u0018\u0001H\u0002¢\u0006\u0002\u0010\u0011\u001aA\u0010\u0012\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u0005H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aY\u0010\u0012\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u000226\u0010\u0007\u001a\u001c\u0012\u0018\u0008\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u00050\u0008\"\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0014\u001a]\u0010\u0012\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n2\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\n`\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aG\u0010\u0016\u001a\u00020\u000e\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u0006\u0010\u0010\u001a\u0002H\u00022 \u0010\u0007\u001a\u001c\u0012\u0018\u0008\u0001\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u00050\u0008H\u0002¢\u0006\u0004\u0008\u0017\u0010\u0014\u001a&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0006\u001a-\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\u0008\u001a@\u0010\u0019\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u0008\u0008\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0002`\u0003\u001a-\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0006H\u0087\u0008\u001a@\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001j\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0002`\u0003\"\u0008\u0008\u0000\u0010\u0002*\u00020\u001a2\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0002`\u0003\u001a&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0006\u001a0\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\u001aO\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u001aR\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0008\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u0005H\u0087\u0008ø\u0001\u0000\u001an\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\n`\u00032\u0014\u0008\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\u0008ø\u0001\u0000\u001aR\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0008\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00060\u0005H\u0087\u0008ø\u0001\u0000\u001an\u0010 \u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\n*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\n0\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\n`\u00032\u0014\u0008\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\n0\u0005H\u0087\u0008ø\u0001\u0000\u001ap\u0010!\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u000328\u0008\u0004\u0010\"\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u000e0#H\u0087\u0008ø\u0001\u0000\u001aO\u0010&\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\u0008\u0012\u0004\u0012\u0002H\u0002`\u00032\u001a\u0010\u000b\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u0001j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0002`\u0003H\u0086\u0004\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006'", d2 = {"compareBy", "Ljava/util/Comparator;", "T", "Lkotlin/Comparator;", "selector", "Lkotlin/Function1;", "", "selectors", "", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "K", "comparator", "compareByDescending", "compareValues", "", "a", "b", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "compareValuesByImpl", "compareValuesByImpl$ComparisonsKt__ComparisonsKt", "naturalOrder", "nullsFirst", "", "nullsLast", "reverseOrder", "reversed", "then", "thenBy", "thenByDescending", "thenComparator", "comparison", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "thenDescending", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt__ComparisonsKt {
    public static int $r8$lambda$75RqBHjEE2iU7zbZ3cBiUB4M5DE(Comparator comparator, Object object2, Object object3) {
        return ComparisonsKt__ComparisonsKt.nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(comparator, object2, object3);
    }

    public static int $r8$lambda$OB0mUMQVuAc-U0wu9PhfvNNbqqs(Comparator comparator, Comparator comparator2, Object object3, Object object4) {
        return ComparisonsKt__ComparisonsKt.thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(comparator, comparator2, object3, object4);
    }

    public static int $r8$lambda$W8AWSBCuy65sMGWfMo6pJ3RDjRw(Function1[] function1Arr, Object object2, Object object3) {
        return ComparisonsKt__ComparisonsKt.compareBy$lambda$0$ComparisonsKt__ComparisonsKt(function1Arr, object2, object3);
    }

    public static int $r8$lambda$fFv4wzBXuBoGFl05zSxqQb7pKRU(Comparator comparator, Comparator comparator2, Object object3, Object object4) {
        return ComparisonsKt__ComparisonsKt.then$lambda$1$ComparisonsKt__ComparisonsKt(comparator, comparator2, object3, object4);
    }

    public static int $r8$lambda$tgO5p6pL1ym8xxzpZUrxHlIPkYM(Comparator comparator, Object object2, Object object3) {
        return ComparisonsKt__ComparisonsKt.nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(comparator, object2, object3);
    }

    private static final <T, K> Comparator<T> compareBy(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.compareBy.3 anon = new ComparisonsKt__ComparisonsKt.compareBy.3(comparator, selector);
        return (Comparator)anon;
    }

    private static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.compareBy.2 anon = new ComparisonsKt__ComparisonsKt.compareBy.2(selector);
        return (Comparator)anon;
    }

    public static final <T> Comparator<T> compareBy(Function1<? super T, ? extends Comparable<?>>... selectors) {
        int i;
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        i = selectors.length > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda3(selectors);
            return externalSyntheticLambda3;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    private static final int compareBy$lambda$0$ComparisonsKt__ComparisonsKt(Function1[] $selectors, Object a, Object b) {
        return ComparisonsKt__ComparisonsKt.compareValuesByImpl$ComparisonsKt__ComparisonsKt(a, b, $selectors);
    }

    private static final <T, K> Comparator<T> compareByDescending(Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.compareByDescending.2 anon = new ComparisonsKt__ComparisonsKt.compareByDescending.2(comparator, selector);
        return (Comparator)anon;
    }

    private static final <T> Comparator<T> compareByDescending(Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.compareByDescending.1 anon = new ComparisonsKt__ComparisonsKt.compareByDescending.1(selector);
        return (Comparator)anon;
    }

    public static final <T extends Comparable<?>> int compareValues(T a, T b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        return a.compareTo(b);
    }

    private static final <T, K> int compareValuesBy(T a, T b, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return comparator.compare(selector.invoke(a), selector.invoke(b));
    }

    private static final <T> int compareValuesBy(T a, T b, Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter(selector, "selector");
        return ComparisonsKt.compareValues((Comparable)selector.invoke(a), (Comparable)selector.invoke(b));
    }

    public static final <T> int compareValuesBy(T a, T b, Function1<? super T, ? extends Comparable<?>>... selectors) {
        int i;
        Intrinsics.checkNotNullParameter(selectors, "selectors");
        i = selectors.length > 0 ? 1 : 0;
        if (i == 0) {
        } else {
            return ComparisonsKt__ComparisonsKt.compareValuesByImpl$ComparisonsKt__ComparisonsKt(a, b, selectors);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    private static final <T> int compareValuesByImpl$ComparisonsKt__ComparisonsKt(T a, T b, Function1<? super T, ? extends Comparable<?>>[] selectors) {
        int i;
        Object obj;
        Object invoke;
        Object invoke2;
        int compareValues;
        final int i2 = 0;
        i = i2;
        while (i < selectors.length) {
            obj = selectors[i];
            compareValues = ComparisonsKt.compareValues((Comparable)obj.invoke(a), (Comparable)obj.invoke(b));
            i++;
        }
        return i2;
    }

    public static final <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        final kotlin.comparisons.NaturalOrderComparator iNSTANCE = NaturalOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return (Comparator)iNSTANCE;
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsFirst() {
        return ComparisonsKt.nullsFirst(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda4(comparator);
        return externalSyntheticLambda4;
    }

    private static final int nullsFirst$lambda$3$ComparisonsKt__ComparisonsKt(Comparator $comparator, Object a, Object b) {
        int compare;
        if (a == b) {
            compare = 0;
        } else {
            if (a == null) {
                compare = -1;
            } else {
                if (b == null) {
                    compare = 1;
                } else {
                    compare = $comparator.compare(a, b);
                }
            }
        }
        return compare;
    }

    private static final <T extends Comparable<? super T>> Comparator<T> nullsLast() {
        return ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
    }

    public static final <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0(comparator);
        return externalSyntheticLambda0;
    }

    private static final int nullsLast$lambda$4$ComparisonsKt__ComparisonsKt(Comparator $comparator, Object a, Object b) {
        int compare;
        if (a == b) {
            compare = 0;
        } else {
            if (a == null) {
                compare = 1;
            } else {
                if (b == null) {
                    compare = -1;
                } else {
                    compare = $comparator.compare(a, b);
                }
            }
        }
        return compare;
    }

    public static final <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        final kotlin.comparisons.ReverseOrderComparator iNSTANCE = ReverseOrderComparator.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return (Comparator)iNSTANCE;
    }

    public static final <T> Comparator<T> reversed(Comparator<T> $this$reversed) {
        Object reversedComparator;
        String str;
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        if ($this$reversed instanceof ReversedComparator) {
            reversedComparator = (ReversedComparator)$this$reversed.getComparator();
        } else {
            str = "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }";
            if (Intrinsics.areEqual($this$reversed, NaturalOrderComparator.INSTANCE)) {
                Intrinsics.checkNotNull(ReverseOrderComparator.INSTANCE, str);
            } else {
                if (Intrinsics.areEqual($this$reversed, ReverseOrderComparator.INSTANCE)) {
                    Intrinsics.checkNotNull(NaturalOrderComparator.INSTANCE, str);
                } else {
                    reversedComparator = new ReversedComparator($this$reversed);
                }
            }
        }
        return reversedComparator;
    }

    public static final <T> Comparator<T> then(Comparator<T> $this$then, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter($this$then, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda2($this$then, comparator);
        return externalSyntheticLambda2;
    }

    private static final int then$lambda$1$ComparisonsKt__ComparisonsKt(Comparator $this_then, Comparator $comparator, Object a, Object b) {
        int compare;
        final int compare2 = $this_then.compare(a, b);
        if (compare2 != 0) {
            compare = compare2;
        } else {
            compare = $comparator.compare(a, b);
        }
        return compare;
    }

    private static final <T, K> Comparator<T> thenBy(Comparator<T> $this$thenBy, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter($this$thenBy, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.thenBy.2 anon = new ComparisonsKt__ComparisonsKt.thenBy.2($this$thenBy, comparator, selector);
        return (Comparator)anon;
    }

    private static final <T> Comparator<T> thenBy(Comparator<T> $this$thenBy, Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter($this$thenBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.thenBy.1 anon = new ComparisonsKt__ComparisonsKt.thenBy.1($this$thenBy, selector);
        return (Comparator)anon;
    }

    private static final <T, K> Comparator<T> thenByDescending(Comparator<T> $this$thenByDescending, Comparator<? super K> comparator, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter($this$thenByDescending, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.thenByDescending.2 anon = new ComparisonsKt__ComparisonsKt.thenByDescending.2($this$thenByDescending, comparator, selector);
        return (Comparator)anon;
    }

    private static final <T> Comparator<T> thenByDescending(Comparator<T> $this$thenByDescending, Function1<? super T, ? extends Comparable<?>> selector) {
        Intrinsics.checkNotNullParameter($this$thenByDescending, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        ComparisonsKt__ComparisonsKt.thenByDescending.1 anon = new ComparisonsKt__ComparisonsKt.thenByDescending.1($this$thenByDescending, selector);
        return (Comparator)anon;
    }

    private static final <T> Comparator<T> thenComparator(Comparator<T> $this$thenComparator, Function2<? super T, ? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter($this$thenComparator, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        ComparisonsKt__ComparisonsKt.thenComparator.1 anon = new ComparisonsKt__ComparisonsKt.thenComparator.1($this$thenComparator, comparison);
        return (Comparator)anon;
    }

    public static final <T> Comparator<T> thenDescending(Comparator<T> $this$thenDescending, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter($this$thenDescending, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda1($this$thenDescending, comparator);
        return externalSyntheticLambda1;
    }

    private static final int thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(Comparator $this_thenDescending, Comparator $comparator, Object a, Object b) {
        int compare;
        final int compare2 = $this_thenDescending.compare(a, b);
        if (compare2 != 0) {
            compare = compare2;
        } else {
            compare = $comparator.compare(b, a);
        }
        return compare;
    }
}
