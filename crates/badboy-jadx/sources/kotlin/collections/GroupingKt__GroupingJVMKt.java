package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00080\u0007\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\t\"\u0004\u0008\u0002\u0010\u0008*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u000c\u0012\u0004\u0012\u0002H\u00080\u000bH\u0081\u0008ø\u0001\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\r", d2 = {"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt {
    public static final <T, K> Map<K, Integer> eachCount(kotlin.collections.Grouping<T, ? extends K> $this$eachCount) {
        Object obj3;
        Object valueOf;
        int mutableMapEntry;
        Object obj6;
        int value;
        Object next;
        Object keyOf;
        Object obj5;
        Ref.IntRef intRef;
        int key;
        Object obj2;
        Object obj;
        Object obj4;
        int i;
        int i2;
        int i4;
        Object intRef2;
        Object $this$eachCount_u24lambda_u242_u24lambda_u241;
        int i3;
        Intrinsics.checkNotNullParameter($this$eachCount, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        mutableMapEntry = 0;
        obj6 = valueOf;
        value = 0;
        final Iterator sourceIterator = obj6.sourceIterator();
        while (sourceIterator.hasNext()) {
            next = sourceIterator.next();
            keyOf = obj6.keyOf(next);
            obj5 = (Map)linkedHashMap.get(keyOf);
            if (obj5 == null && !linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 0;
            obj = keyOf;
            obj4 = next;
            i = 0;
            if (key != null) {
            } else {
            }
            intRef2 = obj2;
            i2 = 1;
            intRef = intRef2;
            i4 = 0;
            i3 = 0;
            Ref.IntRef intRef3 = intRef4;
            intRef3.element = $this$foldTo$iv++;
            linkedHashMap.put(keyOf, intRef);
            obj3 = $this$eachCount;
            valueOf = $this$eachCount_u24lambda_u242_u24lambda_u241;
            i2 = 0;
            intRef2 = new Ref.IntRef();
            if (!linkedHashMap.containsKey(keyOf)) {
            } else {
            }
            key = 1;
        }
        Object $this$foldTo$iv2 = valueOf;
        Iterator iterator = (Iterable)linkedHashMap.entrySet().iterator();
        for (Map.Entry next3 : iterator) {
            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            obj6 = 0;
            TypeIntrinsics.asMutableMapEntry(next3).setValue(Integer.valueOf(value.element));
        }
        return TypeIntrinsics.asMutableMap(linkedHashMap);
    }

    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> $this$mapValuesInPlace, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> f) {
        Object next;
        Object obj;
        int i;
        Map.Entry mutableMapEntry;
        Object invoke;
        Intrinsics.checkNotNullParameter($this$mapValuesInPlace, "<this>");
        Intrinsics.checkNotNullParameter(f, "f");
        final int i2 = 0;
        final Iterator iterator = (Iterable)$this$mapValuesInPlace.entrySet().iterator();
        for (Object next : iterator) {
            obj = next;
            i = 0;
            Intrinsics.checkNotNull((Map.Entry)obj, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            TypeIntrinsics.asMutableMapEntry(obj).setValue(f.invoke(obj));
        }
        return TypeIntrinsics.asMutableMap($this$mapValuesInPlace);
    }
}
