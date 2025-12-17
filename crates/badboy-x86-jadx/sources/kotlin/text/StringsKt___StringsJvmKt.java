package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0010\u000c\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0008\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u000e\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\t*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00080\u000bH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u000c\u001a/\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\u000e\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u00010\u000fj\n\u0012\u0006\u0008\u0000\u0012\u00020\u0001`\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0013\u001a\u0004\u0018\u00010\u0001\"\u000e\u0008\u0000\u0010\u0008*\u0008\u0012\u0004\u0012\u0002H\u00080\t*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u00080\u000bH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u000c\u001a/\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010\u000e\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u00020\u00010\u000fj\n\u0012\u0006\u0008\u0000\u0012\u00020\u0001`\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a)\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u000bH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008\u0017\u001a)\u0010\u0015\u001a\u00020\u0018*\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\u000bH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0008\u0019\u001a\u0010\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u001b*\u00020\u0002\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u001c", d2 = {"elementAt", "", "", "index", "", "max", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt___StringsJvmKt extends kotlin.text.StringsKt__StringsKt {
    private static final char elementAt(java.lang.CharSequence $this$elementAt, int index) {
        Intrinsics.checkNotNullParameter($this$elementAt, "<this>");
        return $this$elementAt.charAt(index);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Character max(java.lang.CharSequence $this$max) {
        Intrinsics.checkNotNullParameter($this$max, "<this>");
        return StringsKt.maxOrNull($this$max);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Character maxBy(java.lang.CharSequence $this$maxBy, Function1<? super Character, ? extends R> selector) {
        int i;
        Character maxElem$iv2;
        char maxElem$iv;
        int lastIndex;
        Object maxValue$iv;
        Character valueOf;
        int i$iv;
        char charAt;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$maxBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        final Object obj = $this$maxBy;
        final int i3 = 0;
        lastIndex = 0;
        i = obj.length() == 0 ? 1 : lastIndex;
        if (i != 0) {
            maxElem$iv2 = 0;
        } else {
            maxElem$iv = obj.charAt(lastIndex);
            lastIndex = StringsKt.getLastIndex(obj);
            if (lastIndex == 0) {
                maxElem$iv2 = maxValue$iv;
            } else {
                maxValue$iv = selector.invoke(Character.valueOf(maxElem$iv));
                if (1 <= lastIndex) {
                }
                maxElem$iv2 = valueOf;
            }
        }
        return maxElem$iv2;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Character maxWith(java.lang.CharSequence $this$maxWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$maxWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.maxWithOrNull($this$maxWith, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Character min(java.lang.CharSequence $this$min) {
        Intrinsics.checkNotNullParameter($this$min, "<this>");
        return StringsKt.minOrNull($this$min);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Character minBy(java.lang.CharSequence $this$minBy, Function1<? super Character, ? extends R> selector) {
        int i;
        Character minElem$iv2;
        char minElem$iv;
        int lastIndex;
        Object minValue$iv;
        Character valueOf;
        int i$iv;
        char charAt;
        Object invoke;
        int compareTo;
        Intrinsics.checkNotNullParameter($this$minBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        final Object obj = $this$minBy;
        final int i3 = 0;
        lastIndex = 0;
        i = obj.length() == 0 ? 1 : lastIndex;
        if (i != 0) {
            minElem$iv2 = 0;
        } else {
            minElem$iv = obj.charAt(lastIndex);
            lastIndex = StringsKt.getLastIndex(obj);
            if (lastIndex == 0) {
                minElem$iv2 = minValue$iv;
            } else {
                minValue$iv = selector.invoke(Character.valueOf(minElem$iv));
                if (1 <= lastIndex) {
                }
                minElem$iv2 = valueOf;
            }
        }
        return minElem$iv2;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final Character minWith(java.lang.CharSequence $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return StringsKt.minWithOrNull($this$minWith, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(java.lang.CharSequence $this$sumOf, Function1<? super Character, ? extends BigDecimal> selector) {
        BigDecimal sum;
        int i;
        char charAt;
        BigDecimal num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigDecimal.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < $this$sumOf.length()) {
            num = sum.add((BigDecimal)selector.invoke(Character.valueOf($this$sumOf.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(java.lang.CharSequence $this$sumOf, Function1<? super Character, ? extends BigInteger> selector) {
        BigInteger sum;
        int i;
        char charAt;
        BigInteger num;
        String str;
        Intrinsics.checkNotNullParameter($this$sumOf, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullExpressionValue(BigInteger.valueOf(0), "valueOf(...)");
        i = 0;
        while (i < $this$sumOf.length()) {
            num = sum.add((BigInteger)selector.invoke(Character.valueOf($this$sumOf.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(num, "add(...)");
            sum = num;
            i++;
        }
        return sum;
    }

    public static final SortedSet<Character> toSortedSet(java.lang.CharSequence $this$toSortedSet) {
        Intrinsics.checkNotNullParameter($this$toSortedSet, "<this>");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)StringsKt.toCollection($this$toSortedSet, (Collection)treeSet);
    }
}
