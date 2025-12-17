package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0083@\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0003B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0001¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\u0008\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t\u0088\u0001\u0004¨\u0006 ", d2 = {"Landroidx/compose/runtime/MutableScatterMultiMap;", "K", "V", "", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "equals", "", "other", "equals-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/collection/MutableScatterMap;)I", "pop", "key", "pop-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "", "value", "put-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "toString-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class MutableScatterMultiMap<K, V>  {

    private final MutableScatterMap<K, Object> map;
    private MutableScatterMultiMap(MutableScatterMap map) {
        super();
        this.map = map;
    }

    public static final androidx.compose.runtime.MutableScatterMultiMap box-impl(MutableScatterMap mutableScatterMap) {
        MutableScatterMultiMap mutableScatterMultiMap = new MutableScatterMultiMap(mutableScatterMap);
        return mutableScatterMultiMap;
    }

    public static <K, V> MutableScatterMap<K, Object> constructor-impl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    public static boolean equals-impl(MutableScatterMap<K, Object> mutableScatterMap, Object object2) {
        final int i2 = 0;
        if (object2 instanceof MutableScatterMultiMap == null) {
            return i2;
        }
        if (!Intrinsics.areEqual(mutableScatterMap, (MutableScatterMultiMap)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(MutableScatterMap<K, Object> mutableScatterMap, MutableScatterMap<K, Object> mutableScatterMap2) {
        return Intrinsics.areEqual(mutableScatterMap, mutableScatterMap2);
    }

    public static int hashCode-impl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    public static final V pop-impl(MutableScatterMap<K, Object> arg0, K key) {
        int i;
        List mutableList;
        String str;
        Object remove;
        boolean empty;
        final Object obj = arg0.get(key);
        if (obj != null) {
            i = 0;
            if (TypeIntrinsics.isMutableList(obj)) {
                mutableList = TypeIntrinsics.asMutableList(obj);
                remove = mutableList.remove(0);
                if (mutableList.isEmpty()) {
                    arg0.remove(key);
                }
            } else {
                arg0.remove(key);
                remove = obj;
            }
            Intrinsics.checkNotNull(remove, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        } else {
            remove = 0;
        }
        return remove;
    }

    public static final void put-impl(MutableScatterMap<K, Object> arg0, K key, V value) {
        int i;
        int i2;
        int values;
        Object[] values2;
        Object mutableListOf;
        final Object obj = arg0;
        final int i3 = 0;
        final int insertIndex = obj.findInsertIndex(key);
        i = insertIndex < 0 ? 1 : 0;
        i2 = i != 0 ? 0 : values3[insertIndex];
        values2 = 0;
        if (i2 == 0) {
            mutableListOf = value;
        } else {
            if (TypeIntrinsics.isMutableList(i2)) {
                Intrinsics.checkNotNull(i2, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                TypeIntrinsics.asMutableList(i2).add(value);
            } else {
                mutableListOf = CollectionsKt.mutableListOf(/* result */);
            }
        }
        if (i != 0) {
            values = ~insertIndex;
            obj.keys[values] = key;
            obj.values[values] = mutableListOf;
        } else {
            obj.values[insertIndex] = mutableListOf;
        }
    }

    public static String toString-impl(MutableScatterMap<K, Object> mutableScatterMap) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MutableScatterMultiMap(map=").append(mutableScatterMap).append(')').toString();
    }

    public boolean equals(Object object) {
        return MutableScatterMultiMap.equals-impl(this.map, object);
    }

    public final MutableScatterMap<K, Object> getMap() {
        return this.map;
    }

    public int hashCode() {
        return MutableScatterMultiMap.hashCode-impl(this.map);
    }

    public String toString() {
        return MutableScatterMultiMap.toString-impl(this.map);
    }

    public final MutableScatterMap unbox-impl() {
        return this.map;
    }
}
