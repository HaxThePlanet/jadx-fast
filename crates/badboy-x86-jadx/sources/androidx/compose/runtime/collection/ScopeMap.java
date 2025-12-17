package androidx.compose.runtime.collection;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\u0008\u000f\u0008\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0008\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\u0008¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00010\u001b0\u001aJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086\u0008¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020\u000e2#\u0008\u0004\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\u0008J\u001b\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006*", d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "anyScopeOf", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "asMap", "", "", "clear", "contains", "element", "(Ljava/lang/Object;)Z", "forEachScopeOf", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", "set", "value", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScopeMap<Key, Scope>  {

    public static final int $stable = 8;
    private final MutableScatterMap<Object, Object> map;
    static {
        final int i = 8;
    }

    public ScopeMap() {
        super();
        this.map = ScatterMapKt.mutableScatterMapOf();
    }

    public final void add(Key key, Scope scope) {
        int str;
        int values2;
        Object[] values;
        int i;
        int i2;
        MutableScatterSet mutableScatterSet;
        final MutableScatterMap map = this.map;
        final int i3 = 0;
        final int insertIndex = map.findInsertIndex(key);
        str = 1;
        values = 0;
        i = insertIndex < 0 ? str : values;
        final int i4 = 0;
        i2 = i != 0 ? i4 : values3[insertIndex];
        final int i5 = 0;
        if (i2 == 0) {
            mutableScatterSet = scope;
        } else {
            if (i2 instanceof MutableScatterSet != null) {
                Intrinsics.checkNotNull(i2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                (MutableScatterSet)i2.add(scope);
                mutableScatterSet = i2;
            } else {
                if (i2 != scope) {
                    mutableScatterSet = new MutableScatterSet(values, str, i4);
                    Intrinsics.checkNotNull(i2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                    mutableScatterSet.add(i2);
                    mutableScatterSet.add(scope);
                } else {
                }
            }
        }
        if (i != 0) {
            values2 = ~insertIndex;
            map.keys[values2] = key;
            map.values[values2] = mutableScatterSet;
        } else {
            map.values[insertIndex] = mutableScatterSet;
        }
    }

    public final boolean anyScopeOf(Key key, Function1<? super Scope, Boolean> block) {
        Object $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i5;
        boolean j$iv$iv$iv;
        int $i$f$isFull;
        Object[] elements;
        Object obj;
        int i4;
        long[] metadata;
        int i;
        int i$iv$iv$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i7;
        int cmp;
        int i6;
        Object this_$iv$iv;
        long l;
        int i3;
        int i2;
        boolean booleanValue;
        final Object obj2 = block;
        final int i8 = 0;
        final int i9 = 0;
        Object obj4 = this.getMap().get(key);
        if (obj4 != null) {
            if (obj4 instanceof MutableScatterSet != null) {
                i5 = obj4;
                i4 = 0;
                metadata = obj.metadata;
                length += -2;
                if (0 <= i) {
                } else {
                    this_$iv$iv = i5;
                    i7 = $i$f$isFull;
                    i6 = 0;
                }
            } else {
                i6 = 0;
                i5 = 0;
                if ((Boolean)obj2.invoke(obj4).booleanValue()) {
                    return 1;
                }
            }
        } else {
            i6 = 0;
        }
        return i6;
    }

    public final Map<Key, Set<Scope>> asMap() {
        int hashMap;
        int obj;
        MutableScatterMap this_$iv;
        int $i$f$forEach;
        Object[] set;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i5;
        int i2;
        HashMap result;
        long l;
        int i3;
        int i6;
        MutableScatterMap this_$iv2;
        int i4;
        int i;
        Object[] objArr;
        hashMap = new HashMap();
        this_$iv = obj.map;
        final int i13 = 0;
        final long[] metadata = map2.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            result = hashMap;
            this_$iv2 = this_$iv;
            i = $i$f$forEach;
            objArr = set;
        }
        return (Map)result;
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean contains(Key element) {
        return this.map.containsKey(element);
    }

    public final void forEachScopeOf(Key key, Function1<? super Scope, Unit> block) {
        Object cmp;
        int i5;
        int i4;
        Object[] elements;
        Object obj;
        int i8;
        long[] metadata;
        int i;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i7;
        int i2;
        Object this_$iv;
        long l;
        int i6;
        int i3;
        final Object obj2 = block;
        final int i9 = 0;
        Object obj3 = getMap().get(key);
        if (obj3 != null) {
            if (obj3 instanceof MutableScatterSet != null) {
                i5 = obj3;
                i4 = 0;
                i8 = 0;
                metadata = obj.metadata;
                length += -2;
                if (0 <= i) {
                } else {
                    this_$iv = i5;
                }
            } else {
                obj2.invoke(obj3);
            }
        }
    }

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.getSize();
    }

    public final boolean remove(Key key, Scope scope) {
        int i;
        boolean empty;
        Object obj = this.map.get(key);
        if (obj == null) {
            return 0;
        }
        Object obj2 = obj;
        boolean remove = (MutableScatterSet)obj2.remove(scope);
        if (obj instanceof MutableScatterSet != null && remove && obj2.isEmpty()) {
            obj2 = obj;
            remove = (MutableScatterSet)obj2.remove(scope);
            if (remove) {
                if (obj2.isEmpty()) {
                    this.map.remove(key);
                }
            }
            return remove;
        }
        if (Intrinsics.areEqual(obj, scope)) {
            this.map.remove(key);
            i = 1;
        } else {
        }
        return i;
    }

    public final void removeScope(Scope scope) {
        Object obj;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i2;
        long l;
        int i5;
        int empty;
        int i;
        int i4;
        final Object obj2 = scope;
        final MutableScatterMap map = obj.map;
        final int i6 = 0;
        final int i7 = 0;
        final long[] metadata = map2.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
        }
    }

    public final void removeScopeIf(Function1<? super Scope, Boolean> predicate) {
        int index$iv;
        boolean booleanValue;
        int i14;
        MutableScatterMap m$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int j$iv$iv3;
        int booleanValue2;
        int i$iv$iv;
        long value$iv$iv$iv2;
        int i;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i13;
        int j$iv$iv2;
        int i12;
        int i8;
        int i15;
        long l;
        int value$iv$iv$iv;
        int i4;
        int i7;
        int i5;
        int cmp;
        int i9;
        int i3;
        int i10;
        int this_$iv;
        int i6;
        int $i$f$removeScopeIf;
        Object[] objArr;
        int i11;
        MutableScatterMap map;
        Object obj;
        long[] lArr;
        long slot$iv$iv;
        long $this$maskEmptyOrDeleted$iv$iv$iv3;
        int i2;
        int $i$f$forEachIndexed;
        long[] lArr2;
        int j$iv$iv;
        final Object obj2 = predicate;
        final MutableScatterMap map2 = getMap();
        m$iv$iv = map2;
        j$iv$iv3 = m$iv$iv.metadata;
        length += -2;
        if (0 <= i19) {
        } else {
            $i$f$removeScopeIf = index$iv;
            this_$iv = i14;
            map = m$iv$iv;
            $i$f$forEachIndexed = $this$maskEmptyOrDeleted$iv$iv$iv2;
            lArr2 = j$iv$iv3;
        }
    }

    public final void set(Key key, Scope value) {
        this.map.set(key, value);
    }
}
