package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\r\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u00020\u0003:\u0001KB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0004J&\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000J\u0006\u0010\u001a\u001a\u00020\u0017J&\u0010\u001a\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008\u001dJ\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fJ\u0016\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u0013\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00028\u0001¢\u0006\u0002\u0010\"J\u0006\u0010&\u001a\u00020\u0006J&\u0010&\u001a\u00020\u00062\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\u0008ø\u0001\u0000J\u0013\u0010'\u001a\u00020\u00172\u0008\u0010(\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010!\u001a\u00028\u0000H\u0080\u0008¢\u0006\u0004\u0008*\u0010+JD\u0010,\u001a\u00020-26\u0010.\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u00118\u0001¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020-0\u0019H\u0086\u0008ø\u0001\u0000J/\u00101\u001a\u00020-2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(3\u0012\u0004\u0012\u00020-02H\u0081\u0008ø\u0001\u0000J/\u00104\u001a\u00020-2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020-02H\u0086\u0008ø\u0001\u0000J/\u00105\u001a\u00020-2!\u0010.\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020-02H\u0086\u0008ø\u0001\u0000J\u0018\u00106\u001a\u0004\u0018\u00018\u00012\u0006\u0010!\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u00107J\u001b\u00108\u001a\u00028\u00012\u0006\u0010!\u001a\u00028\u00002\u0006\u00109\u001a\u00028\u0001¢\u0006\u0002\u0010:J'\u0010;\u001a\u00028\u00012\u0006\u0010!\u001a\u00028\u00002\u000c\u00109\u001a\u0008\u0012\u0004\u0012\u00028\u00010<H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010=J\u0008\u0010>\u001a\u00020\u0006H\u0016J\u0006\u0010?\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020\u0017Jv\u0010A\u001a\u00020\u001c2\u0008\u0008\u0002\u0010B\u001a\u00020C2\u0008\u0008\u0002\u0010D\u001a\u00020C2\u0008\u0008\u0002\u0010E\u001a\u00020C2\u0008\u0008\u0002\u0010F\u001a\u00020\u00062\u0008\u0008\u0002\u0010G\u001a\u00020C2:\u0008\u0002\u0010H\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u00118\u0001¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(%\u0012\u0004\u0012\u00020C\u0018\u00010\u0019H\u0007J\u0006\u0010I\u001a\u00020\u0017J\u0008\u0010J\u001a\u00020\u001cH\u0016R\u0012\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\u0008\r\u0010\u0004R\u0018\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0011\u0010\u0004R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\nR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\u0008\u0015\u0010\u0004\u0082\u0001\u0001L\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006M", d2 = {"Landroidx/collection/ScatterMap;", "K", "V", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "any", "asDebugString", "", "asDebugString$collection", "asMap", "", "contains", "key", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "(Ljava/lang/Object;)I", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "MapWrapper", "Landroidx/collection/MutableScatterMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ScatterMap<K, V>  {

    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public Object[] values;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008\u0090\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019J\u0008\u0010\u001a\u001a\u00020\u0013H\u0016R&\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u001a\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001b", d2 = {"Landroidx/collection/ScatterMap$MapWrapper;", "", "(Landroidx/collection/ScatterMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public class MapWrapper implements Map<K, V>, KMappedMarker {

        final androidx.collection.ScatterMap<K, V> this$0;
        public MapWrapper(androidx.collection.ScatterMap this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // java.util.Map
        public void clear() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public V computeIfAbsent(K k, Function<? super K, ? extends V> function2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return this.this$0.containsKey(key);
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            return this.this$0.containsValue(value);
        }

        public final Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        public V get(Object key) {
            return this.this$0.get(key);
        }

        public Set<Map.Entry<K, V>> getEntries() {
            ScatterMap.MapWrapper.entries.1 anon = new ScatterMap.MapWrapper.entries.1(this.this$0);
            return (Set)anon;
        }

        public Set<K> getKeys() {
            ScatterMap.MapWrapper.keys.1 anon = new ScatterMap.MapWrapper.keys.1(this.this$0);
            return (Set)anon;
        }

        @Override // java.util.Map
        public int getSize() {
            return this$0._size;
        }

        public Collection<V> getValues() {
            ScatterMap.MapWrapper.values.1 anon = new ScatterMap.MapWrapper.values.1(this.this$0);
            return (Collection)anon;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        public final Set<K> keySet() {
            return getKeys();
        }

        public V merge(K k, V v2, BiFunction<? super V, ? super V, ? extends V> biFunction3) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public V put(K k, V v2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public V putIfAbsent(K k, V v2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public V remove(Object object) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Map
        public boolean remove(Object object, Object object2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public V replace(K k, V v2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public boolean replace(K k, V v2, V v3) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Map
        public final int size() {
            return getSize();
        }

        public final Collection<V> values() {
            return getValues();
        }
    }
    private ScatterMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public ScatterMap(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static void getKeys$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public static void getValues$annotations() {
    }

    public static String joinToString$default(androidx.collection.ScatterMap scatterMap, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, Function2 function27, int i8, Object object9) {
        String obj2;
        String obj3;
        String obj4;
        int obj5;
        String obj6;
        int obj7;
        int obj9;
        if (object9 != null) {
        } else {
            if (i8 & 1 != 0) {
                obj2 = ", ";
            }
            final String str = "";
            if (i8 & 2 != 0) {
                obj3 = str;
            }
            if (i8 & 4 != 0) {
                obj4 = str;
            }
            if (i8 & 8 != 0) {
                obj5 = -1;
            }
            if (i8 & 16 != 0) {
                obj6 = "...";
            }
            obj9 = i8 &= 32 != 0 ? obj7 : function27;
            return scatterMap.joinToString(obj2, obj3, obj4, obj5, obj6, obj9);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public final boolean all(Function2<? super K, ? super V, Boolean> predicate) {
        int $i$f$all2;
        int i$iv$iv;
        int cmp;
        int i6;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i2;
        int i;
        int i7;
        long slot$iv$iv;
        int i4;
        int i3;
        int $i$f$all;
        int i5;
        boolean booleanValue;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            $i$f$all = $i$f$all2;
            i7 = 1;
        }
        return i7;
    }

    public final boolean any() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final boolean any(Function2<? super K, ? super V, Boolean> predicate) {
        int $i$f$any;
        int i$iv$iv;
        int cmp;
        int i2;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i;
        int i6;
        int i5;
        long slot$iv$iv;
        int i7;
        int i4;
        int $i$f$any2;
        int i3;
        boolean booleanValue;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            $i$f$any2 = $i$f$any;
            i5 = 0;
        }
        return i5;
    }

    public final String asDebugString$collection() {
        int i3;
        int i4;
        int i2;
        String str;
        int data$iv;
        int length;
        int i;
        String str2;
        int i5;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i6 = 0;
        sb.append('{');
        sb.append("metadata=[");
        i3 = 0;
        str = ", ";
        while (i3 < getCapacity()) {
            data$iv = i12 & i5;
            if (Long.compare(data$iv, i13) == 0) {
            } else {
            }
            if (Long.compare(data$iv, i14) == 0) {
            } else {
            }
            sb.append(data$iv);
            sb.append(str);
            i3++;
            str = ", ";
            sb.append("Deleted");
            sb.append("Empty");
        }
        String i8 = "], ";
        sb.append(i8);
        sb.append("keys=[");
        i2 = 0;
        while (i2 < keys.length) {
            sb.append(this.keys[i2]);
            sb.append(str);
            i2++;
        }
        sb.append(i8);
        sb.append("values=[");
        i4 = 0;
        while (i4 < values.length) {
            sb.append(this.values[i4]);
            sb.append(str);
            i4++;
        }
        sb.append("]");
        sb.append('}');
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final Map<K, V> asMap() {
        ScatterMap.MapWrapper mapWrapper = new ScatterMap.MapWrapper(this);
        return (Map)mapWrapper;
    }

    public final boolean contains(K key) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int i2;
        int i;
        int i12;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i11;
        int i6;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i8;
        int i4;
        int i7;
        int i5;
        long l;
        int i3;
        int i13;
        int i9;
        int i10;
        int i14;
        int numberOfTrailingZeros;
        final Object obj = key;
        final Object obj2 = this;
        m$iv2 = 0;
        int i16 = 0;
        if (obj != null) {
            i12 = obj.hashCode();
        } else {
            i12 = 0;
        }
        i12 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj2._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            i14 = 1;
            while (Long.compare(i25, i35) != 0) {
                $this$hasNext$iv$iv = i14;
                i8 = 0;
                i10 = 0;
                int i28 = m$iv;
                i5 = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i14 = 1;
                $this$hasNext$iv$iv = 0;
            }
            $this$hasNext$iv$iv = 0;
            int i27 = i2;
            i8 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i11 & _capacity;
            $i$f$h2 = i4;
            m$iv2 = i13;
            $i$f$hash = i9;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            i19 |= i33;
            i8 = 0;
            i4 = i42;
            long l6 = 72340172838076673L;
            i34 ^= i6;
            l = -9187201950435737472L;
            i15 &= l;
            i8 = 0;
            i10 = 0;
            i28 = m$iv;
            i5 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i14;
        }
        i = i6 >= 0 ? i14 : 0;
        return i;
    }

    public final boolean containsKey(K key) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int i10;
        int i7;
        int i12;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i9;
        int i13;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i3;
        int i8;
        int i14;
        int i6;
        long l;
        int i2;
        int i;
        int i5;
        int i4;
        int i11;
        int numberOfTrailingZeros;
        final Object obj = key;
        final Object obj2 = this;
        m$iv = 0;
        int i16 = 0;
        if (obj != null) {
            i12 = obj.hashCode();
        } else {
            i12 = 0;
        }
        i12 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj2._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            i11 = 1;
            while (Long.compare(i25, i35) != 0) {
                $this$hasNext$iv$iv = i11;
                i3 = 0;
                i4 = 0;
                int i28 = m$iv2;
                i6 = 0;
                m$iv2 = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i11 = 1;
                $this$hasNext$iv$iv = 0;
            }
            $this$hasNext$iv$iv = 0;
            int i27 = i10;
            i3 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i9 & _capacity;
            $i$f$h2 = i8;
            m$iv = i;
            $i$f$hash = i5;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            i19 |= i33;
            i3 = 0;
            i8 = i42;
            long l6 = 72340172838076673L;
            i34 ^= i13;
            l = -9187201950435737472L;
            i15 &= l;
            i3 = 0;
            i4 = 0;
            i28 = m$iv2;
            i6 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$hasNext$iv$iv = i11;
        }
        i7 = i13 >= 0 ? i11 : 0;
        return i7;
    }

    public final boolean containsValue(V value) {
        int i$iv$iv;
        int i7;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object obj2;
        int i4;
        Object obj;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i2;
        long l;
        int i3;
        int i;
        int i6;
        int i5;
        boolean equal;
        final Object obj3 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            obj2 = value;
            i3 = 0;
        }
        return i3;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super K, ? super V, Boolean> predicate) {
        int cmp;
        int i4;
        Object this_$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i2;
        int $i$f$count;
        int count;
        long l;
        int key;
        int i;
        boolean booleanValue;
        Object this_$iv;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        i4 = 0;
        this_$iv2 = this;
        final int i11 = 0;
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            $i$f$count = cmp;
            this_$iv = this_$iv2;
            count = i4;
        }
        return count;
    }

    public boolean equals(Object other) {
        int obj2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int obj3;
        int equal;
        Object $i$f$isFull;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        Object obj;
        int cmp;
        int i3;
        long l;
        int i4;
        int i;
        int i2;
        Object key;
        obj2 = other;
        $this$maskEmptyOrDeleted$iv$iv$iv = 1;
        obj3 = this;
        if (obj2 == obj3) {
            return $this$maskEmptyOrDeleted$iv$iv$iv;
        }
        equal = 0;
        if (obj2 instanceof ScatterMap == null) {
            return equal;
        }
        if ((ScatterMap)obj2.getSize() != obj3.getSize()) {
            return equal;
        }
        Object obj5 = obj2;
        $i$f$isFull = this;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj7.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            i3 = $this$maskEmptyOrDeleted$iv$iv$iv;
            obj = $i$f$isFull;
        }
        return i3;
    }

    public final int findKeyIndex$collection(K key) {
        int m;
        int m2;
        int $i$f$hash;
        int i;
        int i13;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex;
        int i2;
        int i14;
        int $this$next$iv;
        int i7;
        int i6;
        int i8;
        int i3;
        int i9;
        long l;
        int i15;
        int i4;
        int i10;
        int i11;
        int i5;
        int numberOfTrailingZeros;
        int i12;
        final Object obj = this;
        final Object obj2 = key;
        m = 0;
        int i17 = 0;
        if (obj2 != null) {
            i13 = obj2.hashCode();
        } else {
            i13 = 0;
        }
        i13 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i31 = 0;
            int i36 = 0;
            while (Long.compare(i26, i36) != 0) {
                i5 = 1;
                i6 = 0;
                int i46 = 0;
                i14 = i38 & _capacity;
                int i29 = m2;
                i9 = 0;
                m2 = $this$next$iv;
                i31 = 0;
                i36 = 0;
                i5 = 0;
            }
            i5 = 0;
            int i28 = i;
            i7 = 0;
            $i$f$h1 = i2 & _capacity;
            $i$f$h2 = i8;
            m = i4;
            $i$f$hash = i10;
            long[] metadata = obj.metadata;
            $this$next$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            i20 |= i34;
            i6 = 0;
            i8 = i44;
            long l6 = 72340172838076673L;
            i35 ^= i14;
            l = -9187201950435737472L;
            i16 &= l;
            i6 = 0;
            i46 = 0;
            i14 = i38 & _capacity;
            i29 = m2;
            i9 = 0;
            m2 = $this$next$iv;
            i5 = 1;
        }
        return i14;
    }

    public final void forEach(Function2<? super K, ? super V, Unit> block) {
        Object obj;
        int cmp;
        Object[] keys;
        int i$iv;
        long slot$iv;
        long j$iv;
        int i4;
        int i;
        int $i$f$forEach;
        Object[] objArr;
        long l;
        int i2;
        int i3;
        obj = this;
        final Object obj2 = block;
        Intrinsics.checkNotNullParameter(obj2, "block");
        final int i11 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i12) {
        } else {
            $i$f$forEach = cmp;
            objArr = keys;
        }
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        int i3;
        long slot;
        int $this$maskEmptyOrDeleted$iv;
        int i2;
        int j;
        int i;
        Integer valueOf;
        long l;
        int i4;
        Intrinsics.checkNotNullParameter(block, "block");
        int i5 = 0;
        final long[] metadata = this.metadata;
        length += -2;
        if (0 <= i6) {
        }
    }

    public final void forEachKey(Function1<? super K, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int i2;
        int j$iv;
        int i3;
        int i;
        long l;
        int i5;
        int i4;
        final Object obj = block;
        Intrinsics.checkNotNullParameter(obj, "block");
        int i6 = 0;
        final int i7 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
        }
    }

    public final void forEachValue(Function1<? super V, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int i2;
        int j$iv;
        int i4;
        int i5;
        long l;
        int i;
        int i3;
        final Object obj = block;
        Intrinsics.checkNotNullParameter(obj, "block");
        int i6 = 0;
        final int i7 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
        }
    }

    public final V get(K key) {
        Object obj2;
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int i2;
        int i11;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i14;
        int i4;
        Object obj3;
        int $this$next$iv$iv;
        Object obj;
        int i6;
        int i5;
        int i;
        int i10;
        long l;
        int i9;
        int i3;
        int i7;
        int i12;
        int i13;
        int numberOfTrailingZeros;
        int i8;
        final Object obj4 = key;
        Object obj5 = this;
        m$iv = 0;
        int i16 = 0;
        if (obj4 != null) {
            i11 = obj4.hashCode();
        } else {
            i11 = 0;
        }
        i11 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj5._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            while (Long.compare(i25, i35) != 0) {
                i13 = 1;
                i6 = 0;
                i12 = 0;
                int i28 = m$iv2;
                i10 = 0;
                m$iv2 = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i13 = 0;
            }
            i13 = 0;
            int i27 = i2;
            i6 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i12) != 0) {
                break;
            } else {
            }
            obj3 = this;
            $i$f$h1 = i14 & _capacity;
            $i$f$h2 = i5;
            m$iv = i3;
            $i$f$hash = i7;
            long[] metadata = obj5.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            i19 |= i33;
            i6 = 0;
            i5 = i42;
            long l6 = 72340172838076673L;
            i34 ^= i4;
            l = -9187201950435737472L;
            i15 &= l;
            i6 = 0;
            i12 = 0;
            i28 = m$iv2;
            i10 = 0;
            m$iv2 = $this$next$iv$iv;
            i13 = 1;
        }
        if (i4 >= 0) {
            obj2 = obj.values[i4];
        } else {
            obj = this;
            obj2 = 0;
        }
        return obj2;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final V getOrDefault(K key, V defaultValue) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int i8;
        int i9;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i13;
        int i;
        Object obj;
        int $this$next$iv$iv;
        int i12;
        int i4;
        int i14;
        int i3;
        long l;
        int i11;
        int i6;
        int i5;
        int i10;
        int i7;
        int numberOfTrailingZeros;
        int i2;
        final Object obj2 = key;
        Object obj3 = this;
        m$iv2 = 0;
        int i16 = 0;
        if (obj2 != null) {
            i9 = obj2.hashCode();
        } else {
            i9 = 0;
        }
        i9 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj3._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            while (Long.compare(i25, i35) != 0) {
                i7 = 1;
                i12 = 0;
                i10 = 0;
                int i28 = m$iv;
                i3 = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i7 = 0;
            }
            i7 = 0;
            int i27 = i8;
            i12 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i10) != 0) {
                break;
            } else {
            }
            obj = this;
            $i$f$h1 = i13 & _capacity;
            $i$f$h2 = i4;
            m$iv2 = i6;
            $i$f$hash = i5;
            long[] metadata = obj3.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            i19 |= i33;
            i12 = 0;
            i4 = i42;
            long l6 = 72340172838076673L;
            i34 ^= i;
            l = -9187201950435737472L;
            i15 &= l;
            i12 = 0;
            i10 = 0;
            i28 = m$iv;
            i3 = 0;
            m$iv = $this$next$iv$iv;
            i7 = 1;
        }
        if (i >= 0) {
            return obj5.values[i];
        }
        Object obj6 = this;
        return defaultValue;
    }

    public final V getOrElse(K key, Function0<? extends V> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        if (get(key) == null) {
            invoke = defaultValue.invoke();
        }
        return invoke;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int bitCount$iv$iv;
        int obj;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i6;
        int i3;
        Object this_$iv;
        int hash;
        long l;
        int i;
        int i4;
        Object obj2;
        int i5;
        int i2;
        bitCount$iv$iv = 0;
        obj = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            this_$iv = obj;
            hash = bitCount$iv$iv;
        }
        return hash;
    }

    public final boolean isEmpty() {
        int i;
        i = this._size == 0 ? 1 : 0;
        return i;
    }

    public final boolean isNotEmpty() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final String joinToString() {
        return ScatterMap.joinToString$default(this, 0, 0, 0, 0, 0, 0, 63, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return ScatterMap.joinToString$default(this, charSequence, 0, 0, 0, 0, 0, 62, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return ScatterMap.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 0, 60, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ScatterMap.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 0, 56, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ScatterMap.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 0, 48, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4, java.lang.CharSequence charSequence5) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence5, "truncated");
        return ScatterMap.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, charSequence5, 0, 32, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2<? super K, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int i$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        int index;
        int j$iv$iv;
        int k$iv;
        Object[] keys;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i2;
        int i4;
        int $i$a$BuildStringScatterMap$joinToString$1;
        int i8;
        long l;
        int i7;
        int i5;
        int i6;
        int i;
        Object[] k$iv2;
        Object obj = prefix;
        final Object obj2 = postfix;
        final Object obj3 = truncated;
        final Object obj4 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj2, "postfix");
        Intrinsics.checkNotNullParameter(obj3, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        sb.append(obj);
        i3 = 0;
        index = this;
        final int i15 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            $i$a$BuildStringScatterMap$joinToString$1 = $this$maskEmptyOrDeleted$iv$iv$iv;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = index;
            i2 = j$iv$iv;
            k$iv2 = keys;
            k$iv = limit;
            index = i3;
            sb.append(obj2);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final boolean none() {
        int i;
        i = this._size == 0 ? 1 : 0;
        return i;
    }

    public String toString() {
        int i2;
        int bitCount$iv$iv;
        Object obj;
        Object key;
        Object obj3;
        int value;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i4;
        int i7;
        Object this_$iv;
        int i;
        long l;
        int i5;
        int i3;
        int $i$f$forEach;
        int i6;
        Object obj4;
        Object obj2;
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append2 = stringBuilder.append('{');
        bitCount$iv$iv = 0;
        obj = this;
        final int i18 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        if (0 <= i19) {
        } else {
            this_$iv = obj;
            $i$f$forEach = value;
            i = bitCount$iv$iv;
        }
        String string = append2.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(string, "s.append('}').toString()");
        return string;
    }
}
