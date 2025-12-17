package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000d\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000f\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u001a4\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007H\u0001\u001aQ\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u00052\u0006\u0010\t\u001a\u00020\u00012#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0002\u0008\rH\u0081\u0008ø\u0001\u0000\u001aI\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u00052#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0002\u0008\rH\u0081\u0008ø\u0001\u0000\u001a \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0005H\u0001\u001a(\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0007\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u00052\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0001\u001a2\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0013\u001aa\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u00052\u000e\u0010\u0016\u001a\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00040\u00172*\u0010\u0018\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00130\u0019\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0013H\u0007¢\u0006\u0002\u0010\u001a\u001aY\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u000e\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u001b\"\u0004\u0008\u0001\u0010\u00052*\u0010\u0018\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00130\u0019\"\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0013¢\u0006\u0002\u0010\u001c\u001aC\u0010\u001d\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u001e2\u0006\u0010\u001f\u001a\u0002H\u00042\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u0002H\u00050!H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u0019\u0010#\u001a\u00020$*\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u0003H\u0087\u0008\u001a2\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0005*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0000\u001a1\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003H\u0081\u0008\u001a:\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u000e\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u001b\"\u0004\u0008\u0001\u0010\u0005*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\u001a@\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0015\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0005*\u0010\u0012\u0006\u0008\u0001\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00032\u000e\u0010\u0016\u001a\n\u0012\u0006\u0008\u0000\u0012\u0002H\u00040\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006)", d2 = {"INT_MAX_POWER_OF_TWO", "", "build", "", "K", "V", "builder", "", "buildMapInternal", "capacity", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "createMapBuilder", "mapCapacity", "expectedSize", "mapOf", "pair", "Lkotlin/Pair;", "sortedMapOf", "Ljava/util/SortedMap;", "comparator", "Ljava/util/Comparator;", "pairs", "", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMap", "toSingletonMapOrSelf", "toSortedMap", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
class MapsKt__MapsJVMKt extends kotlin.collections.MapsKt__MapWithDefaultKt {

    private static final int INT_MAX_POWER_OF_TWO = 1073741824;
    public static final <K, V> Map<K, V> build(Map<K, V> builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return (MapBuilder)builder.build();
    }

    private static final <K, V> Map<K, V> buildMapInternal(int capacity, Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map mapBuilder = MapsKt.createMapBuilder(capacity);
        builderAction.invoke(mapBuilder);
        return MapsKt.build(mapBuilder);
    }

    private static final <K, V> Map<K, V> buildMapInternal(Function1<? super Map<K, V>, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        Map mapBuilder = MapsKt.createMapBuilder();
        builderAction.invoke(mapBuilder);
        return MapsKt.build(mapBuilder);
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        MapBuilder mapBuilder = new MapBuilder();
        return (Map)mapBuilder;
    }

    public static final <K, V> Map<K, V> createMapBuilder(int capacity) {
        MapBuilder mapBuilder = new MapBuilder(capacity);
        return (Map)mapBuilder;
    }

    public static final <K, V> V getOrPut(ConcurrentMap<K, V> $this$getOrPut, K key, Function0<? extends V> defaultValue) {
        Object _default;
        int i;
        Object ifAbsent;
        Intrinsics.checkNotNullParameter($this$getOrPut, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i2 = 0;
        if ($this$getOrPut.get(key) == null) {
            i = 0;
            ifAbsent = $this$getOrPut.putIfAbsent(key, defaultValue.invoke());
            if (ifAbsent == null) {
            } else {
                _default = ifAbsent;
            }
        }
        return _default;
    }

    public static final int mapCapacity(int expectedSize) {
        int i2;
        int i;
        if (expectedSize < 0) {
            i2 = expectedSize;
        } else {
            if (expectedSize < 3) {
                i2 = expectedSize + 1;
            } else {
                if (expectedSize < 1073741824) {
                    i2 = (int)i6;
                } else {
                    i2 = Integer.MAX_VALUE;
                }
            }
        }
        return i2;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Map singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final <K, V> SortedMap<K, V> sortedMapOf(Comparator<? super K> comparator, Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        final int i = 0;
        MapsKt.putAll((Map)treeMap, pairs);
        return (SortedMap)treeMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(Pair<? extends K, ? extends V>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        final int i = 0;
        MapsKt.putAll((Map)treeMap, pairs);
        return (SortedMap)treeMap;
    }

    private static final Properties toProperties(Map<String, String> $this$toProperties) {
        Intrinsics.checkNotNullParameter($this$toProperties, "<this>");
        Properties properties = new Properties();
        final int i = 0;
        properties.putAll($this$toProperties);
        return properties;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> $this$toSingletonMap) {
        Intrinsics.checkNotNullParameter($this$toSingletonMap, "<this>");
        Object next = $this$toSingletonMap.entrySet().iterator().next();
        int i = 0;
        Map $this$toSingletonMap_u24lambda_u245 = Collections.singletonMap((Map.Entry)next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue($this$toSingletonMap_u24lambda_u245, "with(...)");
        return $this$toSingletonMap_u24lambda_u245;
    }

    private static final <K, V> Map<K, V> toSingletonMapOrSelf(Map<K, ? extends V> $this$toSingletonMapOrSelf) {
        Intrinsics.checkNotNullParameter($this$toSingletonMapOrSelf, "<this>");
        return MapsKt.toSingletonMap($this$toSingletonMapOrSelf);
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> $this$toSortedMap) {
        Intrinsics.checkNotNullParameter($this$toSortedMap, "<this>");
        TreeMap treeMap = new TreeMap($this$toSortedMap);
        return (SortedMap)treeMap;
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> $this$toSortedMap, Comparator<? super K> comparator) {
        Intrinsics.checkNotNullParameter($this$toSortedMap, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        final int i = 0;
        treeMap.putAll($this$toSortedMap);
        return (SortedMap)treeMap;
    }
}
