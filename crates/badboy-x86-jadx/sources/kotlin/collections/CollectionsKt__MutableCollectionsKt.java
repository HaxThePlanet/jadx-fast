package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000P\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u001a\u001e\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a9\u0010\u000b\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0008\u0010\u001a9\u0010\u000b\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0008\u0010\u001a(\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0015\u001a.\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0012\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0087\n\u001a(\u0010\u0017\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0015\u001a.\u0010\u0017\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0016\u001a)\u0010\u0017\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007H\u0087\n\u001a)\u0010\u0017\u001a\u00020\u0013\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008H\u0087\n\u001a-\u0010\u0018\u001a\u00020\u0001\"\t\u0008\u0000\u0010\u0002¢\u0006\u0002\u0008\u0019*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0002H\u0087\u0008¢\u0006\u0002\u0010\u001a\u001a&\u0010\u0018\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u0087\u0008¢\u0006\u0002\u0010\u001d\u001a-\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u001a.\u0010\u001e\u001a\u00020\u0001\"\t\u0008\u0000\u0010\u0002¢\u0006\u0002\u0008\u0019*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\nH\u0087\u0008\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a*\u0010\u001e\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a\u001d\u0010\u001f\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0004\u0018\u0001H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001d\u0010\"\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a\u001f\u0010#\u001a\u0004\u0018\u0001H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010 \u001a-\u0010$\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a&\u0010$\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\u001a&\u0010$\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0008\u001a.\u0010$\u001a\u00020\u0001\"\t\u0008\u0000\u0010\u0002¢\u0006\u0002\u0008\u0019*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\nH\u0087\u0008\u001a*\u0010$\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000c2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a*\u0010$\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00112\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u000e\u001a\u0015\u0010%\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u0003H\u0002¢\u0006\u0002\u0008&¨\u0006'", d2 = {"addAll", "", "T", "", "elements", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "Lkotlin/sequences/Sequence;", "convertToListIfNotCollection", "", "filterInPlace", "", "predicate", "Lkotlin/Function1;", "predicateResultToRemove", "filterInPlace$CollectionsKt__MutableCollectionsKt", "", "minusAssign", "", "element", "(Ljava/util/Collection;Ljava/lang/Object;)V", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "plusAssign", "remove", "Lkotlin/internal/OnlyInputTypes;", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "index", "", "(Ljava/util/List;I)Ljava/lang/Object;", "removeAll", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "retainNothing", "retainNothing$CollectionsKt__MutableCollectionsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsKt extends kotlin.collections.CollectionsKt__MutableCollectionsJVMKt {
    public static final <T> boolean addAll(Collection<? super T> $this$addAll, Iterable<? extends T> elements) {
        int result;
        Object next;
        boolean z;
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection != null) {
            return $this$addAll.addAll((Collection)elements);
        }
        result = 0;
        final Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            if ($this$addAll.add(iterator.next())) {
            }
            result = 1;
        }
        return result;
    }

    public static final <T> boolean addAll(Collection<? super T> $this$addAll, Sequence<? extends T> elements) {
        int result;
        Object next;
        boolean z;
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        result = 0;
        final Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            if ($this$addAll.add(iterator.next())) {
            }
            result = 1;
        }
        return result;
    }

    public static final <T> boolean addAll(Collection<? super T> $this$addAll, T[] elements) {
        Intrinsics.checkNotNullParameter($this$addAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return $this$addAll.addAll((Collection)ArraysKt.asList(elements));
    }

    public static final <T> Collection<T> convertToListIfNotCollection(Iterable<? extends T> $this$convertToListIfNotCollection) {
        Object list;
        Intrinsics.checkNotNullParameter($this$convertToListIfNotCollection, "<this>");
        if ($this$convertToListIfNotCollection instanceof Collection != null) {
            list = $this$convertToListIfNotCollection;
        } else {
            list = CollectionsKt.toList($this$convertToListIfNotCollection);
        }
        return list;
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable<? extends T> $this$filterInPlace, Function1<? super T, Boolean> predicate, boolean predicateResultToRemove) {
        int result;
        boolean booleanValue;
        result = 0;
        final Iterator iterator = $this$filterInPlace.iterator();
        final int i = 0;
        while (iterator.hasNext()) {
            if ((Boolean)predicate.invoke(iterator.next()).booleanValue() == predicateResultToRemove) {
            }
            iterator.remove();
            result = 1;
        }
        return result;
    }

    private static final <T> boolean filterInPlace$CollectionsKt__MutableCollectionsKt(List<T> $this$filterInPlace, Function1<? super T, Boolean> predicate, boolean predicateResultToRemove) {
        int writeIndex;
        int readIndex;
        int removeIndex;
        Object obj;
        boolean booleanValue;
        if (!$this$filterInPlace instanceof RandomAccess) {
            Intrinsics.checkNotNull($this$filterInPlace, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt(TypeIntrinsics.asMutableIterable($this$filterInPlace), predicate, predicateResultToRemove);
        }
        writeIndex = 0;
        final int lastIndex = CollectionsKt.getLastIndex($this$filterInPlace);
        if (0 <= lastIndex) {
        }
        if (writeIndex < $this$filterInPlace.size() && writeIndex <= CollectionsKt.getLastIndex($this$filterInPlace)) {
            if (writeIndex <= CollectionsKt.getLastIndex($this$filterInPlace)) {
            }
            return 1;
        }
        return 0;
    }

    private static final <T> void minusAssign(Collection<? super T> $this$minusAssign, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.removeAll($this$minusAssign, elements);
    }

    private static final <T> void minusAssign(Collection<? super T> $this$minusAssign, T element) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        $this$minusAssign.remove(element);
    }

    private static final <T> void minusAssign(Collection<? super T> $this$minusAssign, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.removeAll($this$minusAssign, elements);
    }

    private static final <T> void minusAssign(Collection<? super T> $this$minusAssign, T[] elements) {
        Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.removeAll($this$minusAssign, elements);
    }

    private static final <T> void plusAssign(Collection<? super T> $this$plusAssign, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.addAll($this$plusAssign, elements);
    }

    private static final <T> void plusAssign(Collection<? super T> $this$plusAssign, T element) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        $this$plusAssign.add(element);
    }

    private static final <T> void plusAssign(Collection<? super T> $this$plusAssign, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.addAll($this$plusAssign, elements);
    }

    private static final <T> void plusAssign(Collection<? super T> $this$plusAssign, T[] elements) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        CollectionsKt.addAll($this$plusAssign, elements);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(...))
    private static final <T> T remove(List<T> $this$remove, int index) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return $this$remove.remove(index);
    }

    private static final <T> boolean remove(Collection<? extends T> $this$remove, T element) {
        Intrinsics.checkNotNullParameter($this$remove, "<this>");
        return TypeIntrinsics.asMutableCollection($this$remove).remove(element);
    }

    public static final <T> boolean removeAll(Iterable<? extends T> $this$removeAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt($this$removeAll, predicate, true);
    }

    public static final <T> boolean removeAll(Collection<? super T> $this$removeAll, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return $this$removeAll.removeAll(CollectionsKt.convertToListIfNotCollection(elements));
    }

    private static final <T> boolean removeAll(Collection<? extends T> $this$removeAll, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection($this$removeAll).removeAll(elements);
    }

    public static final <T> boolean removeAll(Collection<? super T> $this$removeAll, Sequence<? extends T> elements) {
        boolean empty;
        int i;
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        List list = SequencesKt.toList(elements);
        if (!(Collection)list.isEmpty() && $this$removeAll.removeAll((Collection)list)) {
            i = $this$removeAll.removeAll((Collection)list) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final <T> boolean removeAll(Collection<? super T> $this$removeAll, T[] elements) {
        int all;
        int i;
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        final int i2 = 0;
        all = elements.length == 0 ? i : i2;
        if (all == 0 && $this$removeAll.removeAll((Collection)ArraysKt.asList(elements))) {
            if ($this$removeAll.removeAll((Collection)ArraysKt.asList(elements))) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public static final <T> boolean removeAll(List<T> $this$removeAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt($this$removeAll, predicate, true);
    }

    public static final <T> T removeFirst(List<T> $this$removeFirst) {
        Intrinsics.checkNotNullParameter($this$removeFirst, "<this>");
        if ($this$removeFirst.isEmpty()) {
        } else {
            return $this$removeFirst.remove(0);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("List is empty.");
        throw noSuchElementException;
    }

    public static final <T> T removeFirstOrNull(List<T> $this$removeFirstOrNull) {
        int remove;
        Intrinsics.checkNotNullParameter($this$removeFirstOrNull, "<this>");
        if ($this$removeFirstOrNull.isEmpty()) {
            remove = 0;
        } else {
            remove = $this$removeFirstOrNull.remove(0);
        }
        return remove;
    }

    public static final <T> T removeLast(List<T> $this$removeLast) {
        Intrinsics.checkNotNullParameter($this$removeLast, "<this>");
        if ($this$removeLast.isEmpty()) {
        } else {
            return $this$removeLast.remove(CollectionsKt.getLastIndex($this$removeLast));
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("List is empty.");
        throw noSuchElementException;
    }

    public static final <T> T removeLastOrNull(List<T> $this$removeLastOrNull) {
        int remove;
        Intrinsics.checkNotNullParameter($this$removeLastOrNull, "<this>");
        if ($this$removeLastOrNull.isEmpty()) {
            remove = 0;
        } else {
            remove = $this$removeLastOrNull.remove(CollectionsKt.getLastIndex($this$removeLastOrNull));
        }
        return remove;
    }

    public static final <T> boolean retainAll(Iterable<? extends T> $this$retainAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt($this$retainAll, predicate, false);
    }

    public static final <T> boolean retainAll(Collection<? super T> $this$retainAll, Iterable<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return $this$retainAll.retainAll(CollectionsKt.convertToListIfNotCollection(elements));
    }

    private static final <T> boolean retainAll(Collection<? extends T> $this$retainAll, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return TypeIntrinsics.asMutableCollection($this$retainAll).retainAll(elements);
    }

    public static final <T> boolean retainAll(Collection<? super T> $this$retainAll, Sequence<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        List list = SequencesKt.toList(elements);
        if (!(Collection)list.isEmpty()) {
            return $this$retainAll.retainAll((Collection)list);
        }
        return CollectionsKt__MutableCollectionsKt.retainNothing$CollectionsKt__MutableCollectionsKt($this$retainAll);
    }

    public static final <T> boolean retainAll(Collection<? super T> $this$retainAll, T[] elements) {
        int i;
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        i = elements.length == 0 ? 1 : 0;
        if (i == 0) {
            return $this$retainAll.retainAll((Collection)ArraysKt.asList(elements));
        }
        return CollectionsKt__MutableCollectionsKt.retainNothing$CollectionsKt__MutableCollectionsKt($this$retainAll);
    }

    public static final <T> boolean retainAll(List<T> $this$retainAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$retainAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return CollectionsKt__MutableCollectionsKt.filterInPlace$CollectionsKt__MutableCollectionsKt($this$retainAll, predicate, false);
    }

    private static final boolean retainNothing$CollectionsKt__MutableCollectionsKt(Collection<?> $this$retainNothing) {
        $this$retainNothing.clear();
        return empty ^= 1;
    }
}
