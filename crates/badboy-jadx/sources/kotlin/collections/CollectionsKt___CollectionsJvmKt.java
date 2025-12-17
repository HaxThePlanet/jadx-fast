package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001f\n\u0002\u0008\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0006\u0012\u0002\u0008\u00030\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005\u001aA\u0010\u0006\u001a\u0002H\u0007\"\u0010\u0008\u0000\u0010\u0007*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u0008\"\u0004\u0008\u0001\u0010\u0002*\u0006\u0012\u0002\u0008\u00030\u00032\u0006\u0010\t\u001a\u0002H\u00072\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\n\u001a)\u0010\u000b\u001a\u0004\u0018\u0001H\u000c\"\u000e\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\r*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0003H\u0007¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u000f*\u0008\u0012\u0004\u0012\u00020\u000f0\u0003H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u0011*\u0008\u0012\u0004\u0012\u00020\u00110\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001aG\u0010\u0013\u001a\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0000\u0010\u000c\"\u000e\u0008\u0001\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\r*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\u00020\u0015H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00032\u001a\u0010\u0018\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u000c0\u0019j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u000c`\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a)\u0010\u001c\u001a\u0004\u0018\u0001H\u000c\"\u000e\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\r*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0003H\u0007¢\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000f*\u0008\u0012\u0004\u0012\u00020\u000f0\u0003H\u0007¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u0011*\u0008\u0012\u0004\u0012\u00020\u00110\u0003H\u0007¢\u0006\u0002\u0010\u0012\u001aG\u0010\u001d\u001a\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0000\u0010\u000c\"\u000e\u0008\u0001\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\r*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\u00020\u0015H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a;\u0010\u001e\u001a\u0004\u0018\u0001H\u000c\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00032\u001a\u0010\u0018\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u000c0\u0019j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u000c`\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a\u0016\u0010\u001f\u001a\u00020 \"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0!\u001a5\u0010\"\u001a\u00020#\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u00020#0\u0015H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008$\u001a5\u0010\"\u001a\u00020%\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00032\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u00020%0\u0015H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008&\u001a&\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0(\"\u000e\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\r*\u0008\u0012\u0004\u0012\u0002H\u000c0\u0003\u001a8\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0(\"\u0004\u0008\u0000\u0010\u000c*\u0008\u0012\u0004\u0012\u0002H\u000c0\u00032\u001a\u0010\u0018\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u000c0\u0019j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u000c`\u001a\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006)", d2 = {"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "max", "T", "", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "maxBy", "selector", "Lkotlin/Function1;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "reverse", "", "", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt___CollectionsJvmKt extends kotlin.collections.CollectionsKt__ReversedViewsKt {
    public static final <R> List<R> filterIsInstance(Iterable<?> $this$filterIsInstance, Class<R> klass) {
        Intrinsics.checkNotNullParameter($this$filterIsInstance, "<this>");
        Intrinsics.checkNotNullParameter(klass, "klass");
        ArrayList arrayList = new ArrayList();
        return (List)CollectionsKt.filterIsInstanceTo($this$filterIsInstance, (Collection)arrayList, klass);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Iterable<?> $this$filterIsInstanceTo, C destination, Class<R> klass) {
        Object next;
        boolean instance;
        Intrinsics.checkNotNullParameter($this$filterIsInstanceTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(klass, "klass");
        Iterator iterator = $this$filterIsInstanceTo.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (klass.isInstance(next)) {
            }
            destination.add(next);
        }
        return destination;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Comparable max(Iterable $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return CollectionsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Double max(Iterable $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return CollectionsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Float max(Iterable $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return CollectionsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T maxBy(Iterable<? extends T> $this$maxBy, Function1<? super T, ? extends R> selector) {
        Object maxElem$iv;
        Object maxValue$iv;
        boolean next;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        final int i2 = 0;
        final Iterator iterator = $this$maxBy.iterator();
        if (!iterator.hasNext()) {
            maxElem$iv = 0;
        } else {
            if (!iterator.hasNext()) {
            } else {
                maxValue$iv = selector.invoke(iterator.next());
                Object next3 = iterator.next();
                invoke = selector.invoke(next3);
                do {
                    next3 = iterator.next();
                    invoke = selector.invoke(next3);
                    if (iterator.hasNext()) {
                    }
                    maxElem$iv = next3;
                    maxValue$iv = invoke;
                } while (maxValue$iv.compareTo((Comparable)invoke) < 0);
            }
        }
        return maxElem$iv;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Object maxWith(Iterable $this$maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt.maxWithOrNull($this$maxWith, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Comparable min(Iterable $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return CollectionsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Double min(Iterable $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return CollectionsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Float min(Iterable $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return CollectionsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T minBy(Iterable<? extends T> $this$minBy, Function1<? super T, ? extends R> selector) {
        Object minElem$iv;
        Object minValue$iv;
        boolean next;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        final int i2 = 0;
        final Iterator iterator = $this$minBy.iterator();
        if (!iterator.hasNext()) {
            minElem$iv = 0;
        } else {
            if (!iterator.hasNext()) {
            } else {
                minValue$iv = selector.invoke(iterator.next());
                Object next3 = iterator.next();
                invoke = selector.invoke(next3);
                do {
                    next3 = iterator.next();
                    invoke = selector.invoke(next3);
                    if (iterator.hasNext()) {
                    }
                    minElem$iv = next3;
                    minValue$iv = invoke;
                } while (minValue$iv.compareTo((Comparable)invoke) > 0);
            }
        }
        return minElem$iv;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Object minWith(Iterable $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return CollectionsKt.minWithOrNull($this$minWith, comparator);
    }

    public static final <T> void reverse(List<T> $this$reverse) {
        Intrinsics.checkNotNullParameter($this$reverse, "<this>");
        Collections.reverse($this$reverse);
    }

    private static final <T> BigDecimal sumOfBigDecimal(Iterable<? extends T> $this$sumOf, Function1<? super T, ? extends BigDecimal> selector) {
        BigDecimal sum;
        Object next;
        BigDecimal num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigDecimal.valueOf(0), "valueOf(...)");
        Iterator iterator = $this$sumOf.iterator();
        for (Object next : iterator) {
            num = sum.add((BigDecimal)selector.invoke(next));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
        }
        return sum;
    }

    private static final <T> BigInteger sumOfBigInteger(Iterable<? extends T> $this$sumOf, Function1<? super T, ? extends BigInteger> selector) {
        BigInteger sum;
        Object next;
        BigInteger num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigInteger.valueOf(0), "valueOf(...)");
        Iterator iterator = $this$sumOf.iterator();
        for (Object next : iterator) {
            num = sum.add((BigInteger)selector.invoke(next));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
        }
        return sum;
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(Iterable<? extends T> $this$toSortedSet) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)CollectionsKt.toCollection($this$toSortedSet, (Collection)treeSet);
    }

    public static final <T> SortedSet<T> toSortedSet(Iterable<? extends T> $this$toSortedSet, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        TreeSet treeSet = new TreeSet(comparator);
        return (SortedSet)CollectionsKt.toCollection($this$toSortedSet, (Collection)treeSet);
    }
}
