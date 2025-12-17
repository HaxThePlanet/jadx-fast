package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0008\u001a!\u0010\u0006\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0087\u0008\u001a \u0010\t\u001a\u00020\u0001\"\u000e\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\n*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u001a6\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\r0\u000cH\u0087\u0008ø\u0001\u0000\u001a5\u0010\t\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u000e\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u000fj\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0002`\u0010H\u0087\u0008\u001a2\u0010\u0011\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u000e\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u000fj\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0002`\u0010\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0012", d2 = {"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsJVMKt extends kotlin.collections.CollectionsKt__IteratorsKt {
    private static final <T> void fill(List<T> $this$fill, T value) {
        Intrinsics.checkNotNullParameter($this$fill, "<this>");
        Collections.fill($this$fill, value);
    }

    private static final <T> void shuffle(List<T> $this$shuffle) {
        Intrinsics.checkNotNullParameter($this$shuffle, "<this>");
        Collections.shuffle($this$shuffle);
    }

    private static final <T> void shuffle(List<T> $this$shuffle, Random random) {
        Intrinsics.checkNotNullParameter($this$shuffle, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        Collections.shuffle($this$shuffle, random);
    }

    public static final <T extends Comparable<? super T>> void sort(List<T> $this$sort) {
        Intrinsics.checkNotNullParameter($this$sort, "<this>");
        if ($this$sort.size() > 1) {
            Collections.sort($this$sort);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(...))
    private static final <T> void sort(List<T> $this$sort, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter($this$sort, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        final int i = 0;
        NotImplementedError notImplementedError = new NotImplementedError(i, 1, i);
        throw notImplementedError;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(...))
    private static final <T> void sort(List<T> $this$sort, Function2<? super T, ? super T, Integer> comparison) {
        Intrinsics.checkNotNullParameter($this$sort, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        final int i = 0;
        NotImplementedError notImplementedError = new NotImplementedError(i, 1, i);
        throw notImplementedError;
    }

    public static final <T> void sortWith(List<T> $this$sortWith, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter($this$sortWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if ($this$sortWith.size() > 1) {
            Collections.sort($this$sortWith, comparator);
        }
    }
}
