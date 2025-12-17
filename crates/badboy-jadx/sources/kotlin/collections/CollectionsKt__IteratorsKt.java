package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\u0008ø\u0001\u0000\u001a\u001f\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\n\u001a\"\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u00080\u0003\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\t", d2 = {"forEach", "", "T", "", "operation", "Lkotlin/Function1;", "iterator", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__IteratorsKt extends kotlin.collections.CollectionsKt__IteratorsJVMKt {
    public static final <T> void forEach(Iterator<? extends T> $this$forEach, Function1<? super T, Unit> operation) {
        Object next;
        Intrinsics.checkNotNullParameter($this$forEach, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i = 0;
        for (Object next : $this$forEach) {
            operation.invoke(next);
        }
    }

    private static final <T> Iterator<T> iterator(Iterator<? extends T> $this$iterator) {
        Intrinsics.checkNotNullParameter($this$iterator, "<this>");
        return $this$iterator;
    }

    public static final <T> Iterator<kotlin.collections.IndexedValue<T>> withIndex(Iterator<? extends T> $this$withIndex) {
        Intrinsics.checkNotNullParameter($this$withIndex, "<this>");
        IndexingIterator indexingIterator = new IndexingIterator($this$withIndex);
        return (Iterator)indexingIterator;
    }
}
