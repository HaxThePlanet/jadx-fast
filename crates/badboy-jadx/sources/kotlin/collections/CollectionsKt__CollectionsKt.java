package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000f\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\u000c\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\u0008ø\u0001\u0000\u001aC\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\u0008\u0000\u0010\u00072\u0006\u0010\u000c\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u000f\u0012\u0008\u0008\u0010\u0012\u0004\u0008\u0008(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\u0008ø\u0001\u0000\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\u0008\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\u0008\u0000\u0010\u0007H\u0087\u0008\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\u0008\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aN\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\u0008\"\u0004\u0008\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\u0008\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\u0008\u001fH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\u0008\"\u0004\u0008\u0000\u0010\u001b2\u001f\u0008\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\u0008\u001fH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001\u001a!\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00182\n\u0010\"\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0000¢\u0006\u0002\u0010#\u001a3\u0010 \u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0018\"\u0004\u0008\u0000\u0010\u00072\n\u0010\"\u001a\u0006\u0012\u0002\u0008\u00030\u00022\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010%\u001a\u0012\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007\u001a\u0015\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007H\u0087\u0008\u001a+\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010)\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0008\u0008\u0000\u0010\u0007*\u00020!2\u0008\u0010*\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010+\u001a3\u0010)\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0008\u0008\u0000\u0010\u0007*\u00020!2\u0016\u0010\u0017\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010(\u001a\u0015\u0010,\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\u0008\u0000\u0010\u0007H\u0087\u0008\u001a+\u0010,\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\u0008\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010(\u001a%\u0010-\u001a\u00020\u001e2\u0006\u0010\u000c\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0002\u00080\u001a\u0008\u00101\u001a\u00020\u001eH\u0001\u001a\u0008\u00102\u001a\u00020\u001eH\u0001\u001a%\u00103\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u00104\u001aS\u00105\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00082\u0006\u0010*\u001a\u0002H\u00072\u001a\u00106\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u000707j\n\u0012\u0006\u0008\u0000\u0012\u0002H\u0007`82\u0008\u0008\u0002\u0010.\u001a\u00020\u00062\u0008\u0008\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u00109\u001a>\u00105\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00082\u0008\u0008\u0002\u0010.\u001a\u00020\u00062\u0008\u0008\u0002\u0010/\u001a\u00020\u00062\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00105\u001a\u00020\u0006\"\u000e\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070;*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\u00082\u0008\u0010*\u001a\u0004\u0018\u0001H\u00072\u0008\u0008\u0002\u0010.\u001a\u00020\u00062\u0008\u0008\u0002\u0010/\u001a\u00020\u0006¢\u0006\u0002\u0010<\u001ag\u0010=\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007\"\u000e\u0008\u0001\u0010>*\u0008\u0012\u0004\u0012\u0002H>0;*\u0008\u0012\u0004\u0012\u0002H\u00070\u00082\u0008\u0010?\u001a\u0004\u0018\u0001H>2\u0008\u0008\u0002\u0010.\u001a\u00020\u00062\u0008\u0008\u0002\u0010/\u001a\u00020\u00062\u0016\u0008\u0004\u0010@\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H>0\u000eH\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010A\u001a,\u0010B\u001a\u00020C\"\t\u0008\u0000\u0010\u0007¢\u0006\u0002\u0008D*\u0008\u0012\u0004\u0012\u0002H\u00070\u00022\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\u0008\u001aH\u0010E\u001a\u0002HF\"\u0010\u0008\u0000\u0010G*\u0006\u0012\u0002\u0008\u00030\u0002*\u0002HF\"\u0004\u0008\u0001\u0010F*\u0002HG2\u000c\u0010H\u001a\u0008\u0012\u0004\u0012\u0002HF0IH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010J\u001a\u0019\u0010K\u001a\u00020C\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\u0008\u001a,\u0010L\u001a\u00020C\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\u0008\u0082\u0002\u000e\n\u000c\u0008\u0000\u0012\u0002\u0018\u0001\u001a\u0004\u0008\u0003\u0010\u0000\u001a\u001e\u0010M\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u0008H\u0000\u001a!\u0010N\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\u0008\u001a!\u0010N\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0008H\u0087\u0008\u001a&\u0010O\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\u0008\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070P2\u0006\u0010Q\u001a\u00020RH\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\u0008\u00030\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\u0008\u0000\u0010\u0007*\u0008\u0012\u0004\u0012\u0002H\u00070\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006S", d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "collectionToArrayCommonImpl", "", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", "", "random", "Lkotlin/random/Random;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__CollectionsKt extends kotlin.collections.CollectionsKt__CollectionsJVMKt {
    private static final <T> List<T> List(int size, Function1<? super Integer, ? extends T> init) {
        int i;
        Object invoke;
        Intrinsics.checkNotNullParameter(init, "init");
        ArrayList arrayList = new ArrayList(size);
        i = 0;
        while (i < size) {
            arrayList.add(init.invoke(Integer.valueOf(i)));
            i++;
        }
        return (List)arrayList;
    }

    private static final <T> List<T> MutableList(int size, Function1<? super Integer, ? extends T> init) {
        int i3;
        int i;
        int i2;
        Object invoke;
        Intrinsics.checkNotNullParameter(init, "init");
        ArrayList arrayList = new ArrayList(size);
        i3 = 0;
        while (i3 < size) {
            i2 = 0;
            arrayList.add(init.invoke(Integer.valueOf(i3)));
            i3++;
        }
        return (List)arrayList;
    }

    private static final <T> ArrayList<T> arrayListOf() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public static final <T> ArrayList<T> arrayListOf(T... elements) {
        ArrayList arrayList;
        kotlin.collections.ArrayAsCollection arrayAsCollection;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            arrayList = new ArrayList();
        } else {
            arrayAsCollection = new ArrayAsCollection(elements, 1);
            arrayList = new ArrayList((Collection)arrayAsCollection);
        }
        return arrayList;
    }

    public static final <T> Collection<T> asCollection(T[] $this$asCollection) {
        Intrinsics.checkNotNullParameter($this$asCollection, "<this>");
        ArrayAsCollection arrayAsCollection = new ArrayAsCollection($this$asCollection, 0);
        return (Collection)arrayAsCollection;
    }

    public static final <T> int binarySearch(List<? extends T> $this$binarySearch, int fromIndex, int toIndex, Function1<? super T, Integer> comparison) {
        int low;
        int high;
        int i;
        Object obj;
        int intValue;
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        Intrinsics.checkNotNullParameter(comparison, "comparison");
        CollectionsKt__CollectionsKt.rangeCheck$CollectionsKt__CollectionsKt($this$binarySearch.size(), fromIndex, toIndex);
        low = fromIndex;
        high = toIndex + -1;
        while (low <= high) {
            i3 >>>= 1;
            intValue = (Number)comparison.invoke($this$binarySearch.get(i)).intValue();
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static final <T extends Comparable<? super T>> int binarySearch(List<? extends T> $this$binarySearch, T element, int fromIndex, int toIndex) {
        int low;
        int high;
        int i;
        Object obj;
        int compareValues;
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        CollectionsKt__CollectionsKt.rangeCheck$CollectionsKt__CollectionsKt($this$binarySearch.size(), fromIndex, toIndex);
        low = fromIndex;
        high = toIndex + -1;
        while (low <= high) {
            i3 >>>= 1;
            compareValues = ComparisonsKt.compareValues((Comparable)$this$binarySearch.get(i), element);
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static final <T> int binarySearch(List<? extends T> $this$binarySearch, T element, Comparator<? super T> comparator, int fromIndex, int toIndex) {
        int low;
        int high;
        int i;
        Object obj;
        int compare;
        Intrinsics.checkNotNullParameter($this$binarySearch, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        CollectionsKt__CollectionsKt.rangeCheck$CollectionsKt__CollectionsKt($this$binarySearch.size(), fromIndex, toIndex);
        low = fromIndex;
        high = toIndex + -1;
        while (low <= high) {
            i3 >>>= 1;
            compare = comparator.compare($this$binarySearch.get(i), element);
            high = i + -1;
            low = i + 1;
        }
        return -mid;
    }

    public static int binarySearch$default(List list, int i2, int i3, Function1 function14, int i5, Object object6) {
        int obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 &= 2 != 0) {
            obj2 = list.size();
        }
        return CollectionsKt.binarySearch(list, obj1, obj2, function14);
    }

    public static int binarySearch$default(List list, Comparable comparable2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = list.size();
        }
        return CollectionsKt.binarySearch(list, comparable2, obj2, obj3);
    }

    public static int binarySearch$default(List list, Object object2, Comparator comparator3, int i4, int i5, int i6, Object object7) {
        int obj3;
        int obj4;
        if (i6 & 4 != 0) {
            obj3 = 0;
        }
        if (i6 &= 8 != 0) {
            obj4 = list.size();
        }
        return CollectionsKt.binarySearch(list, object2, comparator3, obj3, obj4);
    }

    public static final <T, K extends Comparable<? super K>> int binarySearchBy(List<? extends T> $this$binarySearchBy, K key, int fromIndex, int toIndex, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter($this$binarySearchBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i = 0;
        CollectionsKt__CollectionsKt.binarySearchBy.1 anon = new CollectionsKt__CollectionsKt.binarySearchBy.1(selector, key);
        return CollectionsKt.binarySearch($this$binarySearchBy, fromIndex, toIndex, (Function1)anon);
    }

    public static int binarySearchBy$default(List $this$binarySearchBy_u24default, Comparable key, int fromIndex, int toIndex, Function1 selector, int i6, Object object7) {
        int obj2;
        int obj3;
        if (i6 & 2 != 0) {
            obj2 = 0;
        }
        if (i6 &= 4 != 0) {
            obj3 = $this$binarySearchBy_u24default.size();
        }
        Intrinsics.checkNotNullParameter($this$binarySearchBy_u24default, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int obj5 = 0;
        CollectionsKt__CollectionsKt.binarySearchBy.1 obj6 = new CollectionsKt__CollectionsKt.binarySearchBy.1(selector, key);
        return CollectionsKt.binarySearch($this$binarySearchBy_u24default, obj2, obj3, (Function1)obj6);
    }

    private static final <E> List<E> buildList(int capacity, Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listBuilder = CollectionsKt.createListBuilder(capacity);
        builderAction.invoke(listBuilder);
        return CollectionsKt.build(listBuilder);
    }

    private static final <E> List<E> buildList(Function1<? super List<E>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        List listBuilder = CollectionsKt.createListBuilder();
        builderAction.invoke(listBuilder);
        return CollectionsKt.build(listBuilder);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection<?> collection) {
        int i;
        int i2;
        Object next;
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (collection.isEmpty()) {
            return new Object[0];
        }
        Object[] arr2 = new Object[collection.size()];
        final Iterator iterator = collection.iterator();
        i = 0;
        for (Object next : iterator) {
            arr2[i] = next;
            i = i2;
        }
        return arr2;
    }

    public static final <T> T[] collectionToArrayCommonImpl(Collection<?> collection, T[] array) {
        Object[] arrayOfNulls;
        int i2;
        int i;
        Object next;
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(array, "array");
        if (collection.isEmpty()) {
            return CollectionsKt.terminateCollectionToArray(0, array);
        }
        if (array.length < collection.size()) {
            arrayOfNulls = ArraysKt.arrayOfNulls(array, collection.size());
        } else {
            arrayOfNulls = array;
        }
        Iterator iterator = collection.iterator();
        i2 = 0;
        for (Object next : iterator) {
            arrayOfNulls[i2] = next;
            i2 = i;
        }
        return CollectionsKt.terminateCollectionToArray(collection.size(), arrayOfNulls);
    }

    private static final <T> boolean containsAll(Collection<? extends T> $this$containsAll, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter($this$containsAll, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        return $this$containsAll.containsAll(elements);
    }

    public static final <T> List<T> emptyList() {
        return (List)EmptyList.INSTANCE;
    }

    public static final IntRange getIndices(Collection<?> $this$indices) {
        Intrinsics.checkNotNullParameter($this$indices, "<this>");
        IntRange intRange = new IntRange(0, size--);
        return intRange;
    }

    public static final <T> int getLastIndex(List<? extends T> $this$lastIndex) {
        Intrinsics.checkNotNullParameter($this$lastIndex, "<this>");
        return size--;
    }

    private static final <C extends Collection<?> & R, R> R ifEmpty(C $this$ifEmpty, Function0<? extends R> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if ($this$ifEmpty.isEmpty()) {
            invoke = defaultValue.invoke();
        } else {
            invoke = $this$ifEmpty;
        }
        return invoke;
    }

    private static final <T> boolean isNotEmpty(Collection<? extends T> $this$isNotEmpty) {
        Intrinsics.checkNotNullParameter($this$isNotEmpty, "<this>");
        return empty ^= 1;
    }

    private static final <T> boolean isNullOrEmpty(Collection<? extends T> $this$isNullOrEmpty) {
        int i;
        boolean empty;
        if ($this$isNullOrEmpty != null) {
            if ($this$isNullOrEmpty.isEmpty()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private static final <T> List<T> listOf() {
        return CollectionsKt.emptyList();
    }

    public static final <T> List<T> listOf(T... elements) {
        List emptyList;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length > 0) {
            emptyList = ArraysKt.asList(elements);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public static final <T> List<T> listOfNotNull(T element) {
        List emptyList;
        if (element != null) {
            emptyList = CollectionsKt.listOf(element);
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        return emptyList;
    }

    public static final <T> List<T> listOfNotNull(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return ArraysKt.filterNotNull(elements);
    }

    private static final <T> List<T> mutableListOf() {
        ArrayList arrayList = new ArrayList();
        return (List)arrayList;
    }

    public static final <T> List<T> mutableListOf(T... elements) {
        ArrayList arrayList;
        kotlin.collections.ArrayAsCollection arrayAsCollection;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            arrayList = new ArrayList();
        } else {
            arrayAsCollection = new ArrayAsCollection(elements, 1);
            arrayList = new ArrayList((Collection)arrayAsCollection);
        }
        return (List)arrayList;
    }

    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> $this$optimizeReadOnlyList) {
        Object emptyList;
        Intrinsics.checkNotNullParameter($this$optimizeReadOnlyList, "<this>");
        switch (size) {
            case 0:
                emptyList = CollectionsKt.emptyList();
                break;
            case 1:
                emptyList = CollectionsKt.listOf($this$optimizeReadOnlyList.get(0));
                break;
            default:
                emptyList = $this$optimizeReadOnlyList;
        }
        return emptyList;
    }

    private static final <T> Collection<T> orEmpty(Collection<? extends T> $this$orEmpty) {
        List emptyList;
        if ($this$orEmpty == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = $this$orEmpty;
        }
        return emptyList;
    }

    private static final <T> List<T> orEmpty(List<? extends T> $this$orEmpty) {
        List emptyList;
        if ($this$orEmpty == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = $this$orEmpty;
        }
        return emptyList;
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int size, int fromIndex, int toIndex) {
        String str = ").";
        String str2 = "fromIndex (";
        if (fromIndex > toIndex) {
        } else {
            if (fromIndex < 0) {
            } else {
                if (toIndex > size) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder2.append("toIndex (").append(toIndex).append(") is greater than size (").append(size).append(str).toString());
                throw indexOutOfBoundsException2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append(str2).append(fromIndex).append(") is less than zero.").toString());
            throw indexOutOfBoundsException;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.append(str2).append(fromIndex).append(") is greater than toIndex (").append(toIndex).append(str).toString());
        throw illegalArgumentException;
    }

    public static final <T> List<T> shuffled(Iterable<? extends T> $this$shuffled, Random random) {
        Intrinsics.checkNotNullParameter($this$shuffled, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        List mutableList = CollectionsKt.toMutableList($this$shuffled);
        final int i = 0;
        CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    public static final void throwCountOverflow() {
        ArithmeticException arithmeticException = new ArithmeticException("Count overflow has happened.");
        throw arithmeticException;
    }

    public static final void throwIndexOverflow() {
        ArithmeticException arithmeticException = new ArithmeticException("Index overflow has happened.");
        throw arithmeticException;
    }
}
