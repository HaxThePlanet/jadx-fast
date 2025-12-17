package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a\u009e\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002\"\u0004\u0008\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u0008ø\u0001\u0000\u001a·\u0001\u0010\u000f\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002\"\u0004\u0008\u0002\u0010\u0003\"\u0016\u0008\u0003\u0010\u0010*\u0010\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0013\u0012\u00110\r¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002\"\u0016\u0008\u0002\u0010\u0010*\u0010\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a¿\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002\"\u0004\u0008\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0008ø\u0001\u0000\u001a\u007f\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002\"\u0004\u0008\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aØ\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002\"\u0004\u0008\u0002\u0010\u0003\"\u0016\u0008\u0003\u0010\u0010*\u0010\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u001026\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0093\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002\"\u0004\u0008\u0002\u0010\u0003\"\u0016\u0008\u0003\u0010\u0010*\u0010\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u008b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\u0008\u0000\u0010!\"\u0008\u0008\u0001\u0010\u0004*\u0002H!\"\u0004\u0008\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u0011H!¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H!0\u001aH\u0087\u0008ø\u0001\u0000\u001a¤\u0001\u0010\"\u001a\u0002H\u0010\"\u0004\u0008\u0000\u0010!\"\u0008\u0008\u0001\u0010\u0004*\u0002H!\"\u0004\u0008\u0002\u0010\u0002\"\u0016\u0008\u0003\u0010\u0010*\u0010\u0012\u0006\u0008\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0013\u0012\u0011H!¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u0002H!0\u001aH\u0087\u0008ø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006$", d2 = {"aggregate", "", "K", "R", "T", "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingKt extends kotlin.collections.GroupingKt__GroupingJVMKt {
    public static final <T, K, R> Map<K, R> aggregate(kotlin.collections.Grouping<T, ? extends K> $this$aggregate, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        Object next;
        Object keyOf;
        Object obj;
        Object invoke;
        int i;
        Intrinsics.checkNotNullParameter($this$aggregate, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Object obj2 = $this$aggregate;
        final int i3 = 0;
        final Iterator sourceIterator = obj2.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj2.keyOf(next);
            obj = (Map)linkedHashMap.get(keyOf);
            if (obj == null && !linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            i = 0;
            linkedHashMap.put(keyOf, operation.invoke(keyOf, obj, next, Boolean.valueOf(i)));
            if (!linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            i = 1;
        }
        return linkedHashMap;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(kotlin.collections.Grouping<T, ? extends K> $this$aggregateTo, M destination, Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        Object next;
        Object keyOf;
        Object obj;
        Object invoke;
        int i;
        Intrinsics.checkNotNullParameter($this$aggregateTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        final Iterator sourceIterator = $this$aggregateTo.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = $this$aggregateTo.keyOf(next);
            obj = destination.get(keyOf);
            if (obj == null && !destination.containsKey(keyOf)) {
            } else {
            }
            i = 0;
            destination.put(keyOf, operation.invoke(keyOf, obj, next, Boolean.valueOf(i)));
            if (!destination.containsKey(keyOf)) {
            } else {
            }
            i = 1;
        }
        return destination;
    }

    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(kotlin.collections.Grouping<T, ? extends K> $this$eachCountTo, M destination) {
        Object next;
        Object keyOf;
        Object obj;
        Integer valueOf;
        int key;
        Object obj3;
        Object obj2;
        int i;
        int acc;
        Object num;
        int i2;
        final Object obj4 = destination;
        Intrinsics.checkNotNullParameter($this$eachCountTo, "<this>");
        Intrinsics.checkNotNullParameter(obj4, "destination");
        int i3 = 0;
        final int i4 = 0;
        final Object obj7 = obj6;
        final int i5 = 0;
        final Iterator sourceIterator = obj7.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj7.keyOf(next);
            obj = obj4.get(keyOf);
            if (obj == null && !obj4.containsKey(keyOf)) {
            } else {
            }
            key = i3;
            obj3 = next;
            i = 0;
            if (key != null) {
            } else {
            }
            num = obj2;
            i2 = 0;
            obj4.put(keyOf, Integer.valueOf(intValue++));
            num = valueOf2;
            if (!obj4.containsKey(keyOf)) {
            } else {
            }
            key = i6;
        }
        return obj4;
    }

    public static final <T, K, R> Map<K, R> fold(kotlin.collections.Grouping<T, ? extends K> $this$fold, R initialValue, Function2<? super R, ? super T, ? extends R> operation) {
        int i;
        Object $i$f$fold;
        Object next;
        Object keyOf;
        Object obj;
        int key;
        Object obj3;
        Object obj2;
        int i2;
        int i3;
        final Object obj4 = operation;
        Intrinsics.checkNotNullParameter($this$fold, "<this>");
        Intrinsics.checkNotNullParameter(obj4, "operation");
        i = 0;
        final int i4 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Object obj7 = obj6;
        final int i5 = 0;
        final Iterator sourceIterator = obj7.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj7.keyOf(next);
            obj = (Map)linkedHashMap.get(keyOf);
            if (obj == null && !linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 0;
            i2 = 0;
            if (key != null) {
            } else {
            }
            $i$f$fold = obj3;
            linkedHashMap.put(keyOf, obj4.invoke($i$f$fold, next));
            i = i3;
            $i$f$fold = initialValue;
            if (!linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 1;
        }
        return linkedHashMap;
    }

    public static final <T, K, R> Map<K, R> fold(kotlin.collections.Grouping<T, ? extends K> $this$fold, Function2<? super K, ? super T, ? extends R> initialValueSelector, Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        Object obj5;
        Object obj;
        int i;
        Object $i$f$fold;
        Object next;
        Object keyOf;
        Object obj2;
        int key;
        Object obj3;
        Object obj4;
        Object invoke;
        int i2;
        int $i$f$fold2;
        final Object obj6 = operation;
        Intrinsics.checkNotNullParameter($this$fold, "<this>");
        Intrinsics.checkNotNullParameter(initialValueSelector, "initialValueSelector");
        Intrinsics.checkNotNullParameter(obj6, "operation");
        i = 0;
        final int i3 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Object obj9 = obj8;
        final int i4 = 0;
        final Iterator sourceIterator = obj9.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj9.keyOf(next);
            obj2 = (Map)linkedHashMap.get(keyOf);
            if (obj2 == null && !linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 0;
            obj4 = next;
            invoke = keyOf;
            i2 = 0;
            if (key != null) {
            } else {
            }
            $i$f$fold2 = i;
            $i$f$fold = invoke;
            obj = obj3;
            linkedHashMap.put(keyOf, obj6.invoke($i$f$fold, obj, obj4));
            obj5 = initialValueSelector;
            i = $i$f$fold2;
            $i$f$fold2 = i;
            obj = invoke;
            if (!linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 1;
        }
        return linkedHashMap;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(kotlin.collections.Grouping<T, ? extends K> $this$foldTo, M destination, R initialValue, Function2<? super R, ? super T, ? extends R> operation) {
        Object next;
        Object keyOf;
        Object obj4;
        Object first;
        int i2;
        Object obj3;
        Object obj2;
        int i;
        Object obj;
        Intrinsics.checkNotNullParameter($this$foldTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i3 = 0;
        final Object obj5 = $this$foldTo;
        final int i4 = 0;
        final Iterator sourceIterator = obj5.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj5.keyOf(next);
            obj4 = destination.get(keyOf);
            if (obj4 == null && !destination.containsKey(keyOf)) {
            } else {
            }
            i2 = 0;
            i = 0;
            if (i2 != 0) {
            } else {
            }
            obj = obj2;
            destination.put(keyOf, operation.invoke(obj, next));
            obj = initialValue;
            if (!destination.containsKey(keyOf)) {
            } else {
            }
            i2 = 1;
        }
        return destination;
    }

    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(kotlin.collections.Grouping<T, ? extends K> $this$foldTo, M destination, Function2<? super K, ? super T, ? extends R> initialValueSelector, Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        Object obj2;
        Object obj5;
        Object next;
        Object keyOf;
        Object obj3;
        int key;
        Object obj6;
        Object obj4;
        Object obj;
        int i;
        Object invoke;
        final Object obj7 = destination;
        final Object obj8 = operation;
        Intrinsics.checkNotNullParameter($this$foldTo, "<this>");
        Intrinsics.checkNotNullParameter(obj7, "destination");
        Intrinsics.checkNotNullParameter(initialValueSelector, "initialValueSelector");
        Intrinsics.checkNotNullParameter(obj8, "operation");
        int i2 = 0;
        final Object obj10 = $this$foldTo;
        final int i3 = 0;
        final Iterator sourceIterator = obj10.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj10.keyOf(next);
            obj3 = obj7.get(keyOf);
            if (obj3 == null && !obj7.containsKey(keyOf)) {
            } else {
            }
            key = 0;
            obj6 = keyOf;
            obj4 = next;
            i = 0;
            if (key != null) {
            } else {
            }
            obj5 = obj;
            obj7.put(keyOf, obj8.invoke(obj6, obj5, obj4));
            obj2 = initialValueSelector;
            obj5 = invoke;
            if (!obj7.containsKey(keyOf)) {
            } else {
            }
            key = 1;
        }
        return obj7;
    }

    public static final <S, T extends S, K> Map<K, S> reduce(kotlin.collections.Grouping<T, ? extends K> $this$reduce, Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        Object next;
        Object keyOf;
        Object obj2;
        int key;
        Object obj;
        Object obj3;
        Object e;
        int i;
        Object invoke;
        final Object obj4 = operation;
        Intrinsics.checkNotNullParameter($this$reduce, "<this>");
        Intrinsics.checkNotNullParameter(obj4, "operation");
        int i2 = 0;
        final int i3 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        final Object obj7 = obj6;
        final int i4 = 0;
        final Iterator sourceIterator = obj7.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj7.keyOf(next);
            obj2 = (Map)linkedHashMap.get(keyOf);
            if (obj2 == null && !linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 0;
            i = 0;
            if (key != null) {
            } else {
            }
            e = invoke;
            linkedHashMap.put(keyOf, e);
            if (!linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 1;
        }
        return linkedHashMap;
    }

    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(kotlin.collections.Grouping<T, ? extends K> $this$reduceTo, M destination, Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        Object next;
        Object keyOf;
        Object obj2;
        int key;
        Object obj3;
        Object obj;
        Object e;
        int i;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$reduceTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 0;
        final Object obj4 = $this$reduceTo;
        final int i3 = 0;
        final Iterator sourceIterator = obj4.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj4.keyOf(next);
            obj2 = destination.get(keyOf);
            if (obj2 == null && !destination.containsKey(keyOf)) {
            } else {
            }
            key = 0;
            i = 0;
            if (key != null) {
            } else {
            }
            e = invoke;
            destination.put(keyOf, e);
            if (!destination.containsKey(keyOf)) {
            } else {
            }
            key = 1;
        }
        return destination;
    }
}
