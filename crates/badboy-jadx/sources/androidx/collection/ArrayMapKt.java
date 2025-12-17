package androidx.collection;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u0003H\u0086\u0008\u001aO\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032*\u0010\u0004\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00060\u0005\"\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0006¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"arrayMapOf", "Landroidx/collection/ArrayMap;", "K", "V", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/collection/ArrayMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ArrayMapKt {
    public static final <K, V> androidx.collection.ArrayMap<K, V> arrayMapOf() {
        final int i = 0;
        ArrayMap arrayMap = new ArrayMap();
        return arrayMap;
    }

    public static final <K, V> androidx.collection.ArrayMap<K, V> arrayMapOf(Pair<? extends K, ? extends V>... pairs) {
        int i;
        Object obj;
        androidx.collection.ArrayMap map;
        Object first;
        Object second;
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        ArrayMap arrayMap = new ArrayMap(pairs.length);
        i = 0;
        while (i < pairs.length) {
            obj = pairs[i];
            (Map)arrayMap.put(obj.getFirst(), obj.getSecond());
            i++;
        }
        return arrayMap;
    }
}
