package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a,\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0086\u0002\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0086\u0002\u001a-\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u0010\u0004¨\u0006\r", d2 = {"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
class SetsKt___SetsKt extends kotlin.collections.SetsKt__SetsKt {
    public static final <T> Set<T> minus(Set<? extends T> $this$minus, Iterable<? extends T> elements) {
        Object next;
        boolean it;
        int i;
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection convertToListIfNotCollection = CollectionsKt.convertToListIfNotCollection(elements);
        if (convertToListIfNotCollection.isEmpty()) {
            return CollectionsKt.toSet((Iterable)$this$minus);
        }
        if (convertToListIfNotCollection instanceof Set != null) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            final int i2 = 0;
            final Iterator iterator = (Iterable)$this$minus.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                i = 0;
                if (!convertToListIfNotCollection.contains(next)) {
                }
                (Collection)linkedHashSet2.add(next);
            }
            return (Set)linkedHashSet2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection)$this$minus);
        linkedHashSet.removeAll(convertToListIfNotCollection);
        return (Set)linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> $this$minus, T element) {
        int removed;
        Object next;
        Object obj;
        int i;
        int equal;
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity($this$minus.size()));
        removed = 0;
        final int i2 = 0;
        final Iterator iterator = (Iterable)$this$minus.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            i = 0;
            if (removed == 0 && Intrinsics.areEqual(next, element)) {
            } else {
            }
            equal = 1;
            if (equal != 0) {
            }
            (Collection)linkedHashSet.add(next);
            if (Intrinsics.areEqual(obj, element)) {
            } else {
            }
            removed = 1;
            equal = 0;
        }
        return (Set)(Collection)linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> $this$minus, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection)$this$minus);
        CollectionsKt.removeAll((Collection)linkedHashSet, elements);
        return (Set)linkedHashSet;
    }

    public static final <T> Set<T> minus(Set<? extends T> $this$minus, T[] elements) {
        Intrinsics.checkNotNullParameter($this$minus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection)$this$minus);
        CollectionsKt.removeAll((Collection)linkedHashSet, elements);
        return (Set)linkedHashSet;
    }

    private static final <T> Set<T> minusElement(Set<? extends T> $this$minusElement, T element) {
        Intrinsics.checkNotNullParameter($this$minusElement, "<this>");
        return SetsKt.minus($this$minusElement, element);
    }

    public static final <T> Set<T> plus(Set<? extends T> $this$plus, Iterable<? extends T> elements) {
        int intValue;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        Integer collectionSizeOrNull = CollectionsKt.collectionSizeOrNull(elements);
        if (collectionSizeOrNull != null) {
            i = 0;
            size += intValue;
        } else {
            i2 = intValue * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(i2));
        linkedHashSet.addAll((Collection)$this$plus);
        CollectionsKt.addAll((Collection)linkedHashSet, elements);
        return (Set)linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> $this$plus, T element) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(size++));
        linkedHashSet.addAll((Collection)$this$plus);
        linkedHashSet.add(element);
        return (Set)linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> $this$plus, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(size *= 2));
        linkedHashSet.addAll((Collection)$this$plus);
        CollectionsKt.addAll((Collection)linkedHashSet, elements);
        return (Set)linkedHashSet;
    }

    public static final <T> Set<T> plus(Set<? extends T> $this$plus, T[] elements) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.mapCapacity(size += length));
        linkedHashSet.addAll((Collection)$this$plus);
        CollectionsKt.addAll((Collection)linkedHashSet, elements);
        return (Set)linkedHashSet;
    }

    private static final <T> Set<T> plusElement(Set<? extends T> $this$plusElement, T element) {
        Intrinsics.checkNotNullParameter($this$plusElement, "<this>");
        return SetsKt.plus($this$plusElement, element);
    }
}
