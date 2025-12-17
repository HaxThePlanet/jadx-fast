package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0002\u0008\u0004\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0019J&\u0010\u001c\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\u001fJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00192\u0008\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0015\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020)0\u001bH\u0086\u0008ø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(/\u0012\u0004\u0012\u00020)0.H\u0081\u0008ø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\u0008ø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020)0.H\u0086\u0008ø\u0001\u0000J\u0016\u00102\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010'J\u001b\u00103\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u00104\u001a\u00020\u0005¢\u0006\u0002\u00105J'\u00106\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00028\u00002\u000c\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u000507H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00108J\u0008\u00109\u001a\u00020\u0005H\u0016J\u0006\u0010:\u001a\u00020\u0019J\u0006\u0010;\u001a\u00020\u0019J:\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020?2\u0008\u0008\u0002\u0010@\u001a\u00020?2\u0008\u0008\u0002\u0010A\u001a\u00020?2\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010C\u001a\u00020?H\u0007Jx\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020?2\u0008\u0008\u0002\u0010@\u001a\u00020?2\u0008\u0008\u0002\u0010A\u001a\u00020?2\u0008\u0008\u0002\u0010B\u001a\u00020\u00052\u0008\u0008\u0002\u0010C\u001a\u00020?28\u0008\u0004\u0010D\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020?0\u001bH\u0087\u0008ø\u0001\u0000J\u0006\u0010E\u001a\u00020\u0019J\u0008\u0010F\u001a\u00020=H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\"\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u000f\u0012\u0004\u0008\u000e\u0010\u0003R\u0018\u0010\u0010\u001a\u00020\u00118\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0012\u0010\u0003R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0017\u0010\u0003\u0082\u0001\u0001G\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006H", d2 = {"Landroidx/collection/ObjectIntMap;", "K", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "any", "contains", "key", "(Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "(Ljava/lang/Object;)I", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "(Ljava/lang/Object;I)I", "getOrElse", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)I", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableObjectIntMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ObjectIntMap<K>  {

    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public int[] values;
    private ObjectIntMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = IntSetKt.getEmptyIntArray();
    }

    public ObjectIntMap(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static void getKeys$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public static void getValues$annotations() {
    }

    public static void get_capacity$collection$annotations() {
    }

    public static void get_size$collection$annotations() {
    }

    public static String joinToString$default(androidx.collection.ObjectIntMap objectIntMap, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, int i7, Object object8) {
        String obj2;
        String obj3;
        String obj4;
        int obj5;
        String obj6;
        String obj8;
        if (object8 != null) {
        } else {
            if (i7 & 1 != 0) {
                obj2 = ", ";
            }
            final String str = "";
            if (i7 & 2 != 0) {
                obj3 = str;
            }
            if (i7 & 4 != 0) {
                obj4 = str;
            }
            if (i7 & 8 != 0) {
                obj5 = -1;
            }
            if (i7 &= 16 != 0) {
                obj8 = obj6;
            } else {
                obj8 = charSequence6;
            }
            return objectIntMap.joinToString(obj2, obj3, obj4, obj5, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public static String joinToString$default(androidx.collection.ObjectIntMap $this, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2 transform, int i8, Object object9) {
        String separator3;
        String prefix2;
        int m$iv$iv;
        String postfix2;
        int limit2;
        String truncated2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int invoke;
        Object this_$iv;
        int j$iv$iv;
        long slot$iv$iv;
        int i2;
        long l;
        int i4;
        int key;
        int i;
        int i3;
        String separator2;
        Object obj30;
        int obj31;
        int obj33;
        int obj34;
        final Object obj = transform;
        if (object9 != null) {
        } else {
            if (i8 & 1 != 0) {
                separator3 = ", ";
            } else {
                separator3 = separator;
            }
            if (i8 & 2 != 0) {
                prefix2 = postfix2;
            } else {
                prefix2 = prefix;
            }
            if (i8 & 4 != 0) {
            } else {
                postfix2 = postfix;
            }
            limit2 = i8 & 8 != 0 ? -1 : limit;
            if (i8 & 16 != 0) {
                truncated2 = "...";
            } else {
                truncated2 = truncated;
            }
            Intrinsics.checkNotNullParameter(separator3, "separator");
            Intrinsics.checkNotNullParameter(prefix2, "prefix");
            Intrinsics.checkNotNullParameter(postfix2, "postfix");
            Intrinsics.checkNotNullParameter(truncated2, "truncated");
            Intrinsics.checkNotNullParameter(obj, "transform");
            StringBuilder stringBuilder = new StringBuilder();
            final StringBuilder sb = stringBuilder;
            sb.append(prefix2);
            invoke = 0;
            this_$iv = $this;
            final int i18 = 0;
            final String obj27 = prefix2;
            long[] prefix3 = obj2.metadata;
            final int obj28 = i11;
            $i$f$joinToString += -2;
            if (0 <= i12) {
            } else {
                separator2 = separator3;
                obj33 = $this$maskEmptyOrDeleted$iv$iv$iv;
                obj30 = this_$iv;
                obj31 = j$iv$iv;
                this_$iv = invoke;
                sb.append(postfix2);
            }
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw unsupportedOperationException;
    }

    public final boolean all(Function2<? super K, ? super Integer, Boolean> predicate) {
        int $i$f$all2;
        int i$iv$iv;
        int cmp;
        int i2;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i3;
        int i6;
        int i5;
        long slot$iv$iv;
        int i7;
        int i;
        int i8;
        int i4;
        int $i$f$all;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i9 = 0;
        final int i10 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i11) {
        } else {
            $i$f$all = $i$f$all2;
            i5 = 1;
        }
        return i5;
    }

    public final boolean any() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final boolean any(Function2<? super K, ? super Integer, Boolean> predicate) {
        int $i$f$any2;
        int i$iv$iv;
        int cmp;
        int i;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i5;
        int i7;
        int i3;
        long slot$iv$iv;
        int i6;
        int i4;
        int i8;
        int i2;
        int $i$f$any;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i9 = 0;
        final int i10 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i11) {
        } else {
            $i$f$any = $i$f$any2;
            i3 = 0;
        }
        return i3;
    }

    public final boolean contains(K key) {
        int i;
        i = findKeyIndex(key) >= 0 ? 1 : 0;
        return i;
    }

    public final boolean containsKey(K key) {
        int i;
        i = findKeyIndex(key) >= 0 ? 1 : 0;
        return i;
    }

    public final boolean containsValue(int value) {
        int i$iv$iv;
        int i6;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i;
        int i2;
        int i8;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i7;
        long l;
        int i9;
        int i3;
        int i4;
        int i5;
        final Object obj = this;
        final int i10 = 0;
        final int i11 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i12) {
        } else {
            i = value;
            i9 = 0;
        }
        return i9;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super K, ? super Integer, Boolean> predicate) {
        int cmp;
        int booleanValue;
        Object this_$iv;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i;
        int $i$f$count;
        int count;
        long l;
        int key;
        int i4;
        Object obj;
        int i2;
        Object this_$iv2;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        booleanValue = 0;
        this_$iv = this;
        final int i11 = 0;
        final int i12 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            $i$f$count = cmp;
            this_$iv2 = this_$iv;
            count = booleanValue;
        }
        return count;
    }

    public boolean equals(Object other) {
        Object obj;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int obj3;
        int i3;
        Object $i$f$isFull;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object obj2;
        int cmp;
        int i2;
        long l;
        int i5;
        int i;
        int i4;
        obj = other;
        $this$maskEmptyOrDeleted$iv$iv$iv2 = 1;
        obj3 = this;
        if (obj == obj3) {
            return $this$maskEmptyOrDeleted$iv$iv$iv2;
        }
        i3 = 0;
        if (obj instanceof ObjectIntMap == null) {
            return i3;
        }
        if ((ObjectIntMap)obj.getSize() != obj3.getSize()) {
            return i3;
        }
        $i$f$isFull = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj6.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            i2 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            obj2 = $i$f$isFull;
        }
        return i2;
    }

    public final int findKeyIndex(K key) {
        int $i$f$hash;
        int m;
        int i9;
        int i8;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex;
        int $this$maskEmpty$iv;
        int $this$next$iv;
        int i5;
        int i6;
        int i11;
        int i2;
        int i3;
        int i;
        int i12;
        long l;
        int i7;
        int i4;
        int i10;
        int numberOfTrailingZeros;
        final Object obj = this;
        final Object obj2 = key;
        int i13 = 0;
        if (obj2 != null) {
            i8 = obj2.hashCode();
        } else {
            i8 = 0;
        }
        i8 *= i24;
        $i$f$hash = i18 ^ i25;
        int i19 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj._capacity;
        int i26 = 0;
        $i$f$h12 &= _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i20 = 0;
            int i38 = 0;
            while (Long.compare(i27, i38) != 0) {
                i2 = 1;
                int i21 = 0;
                int i32 = 0;
                $i$f$h2 = i33 & _capacity;
                int i29 = m;
                i11 = 0;
                m = $this$next$iv;
                i20 = 0;
                i38 = 0;
                i2 = 0;
            }
            i2 = 0;
            int i30 = i10;
            int i22 = 0;
            $i$f$h1 = i23 & _capacity;
            $i$f$h2 = i3;
            $i$f$hash = i4;
            long[] metadata = obj.metadata;
            i5 = 0;
            int i31 = $i$f$h1 >> 3;
            i34 <<= 3;
            i17 |= i36;
            i11 = 0;
            i3 = i46;
            long l6 = 72340172838076673L;
            i37 ^= $this$next$iv;
            l = -9187201950435737472L;
            i14 &= l;
            i21 = 0;
            i32 = 0;
            $i$f$h2 = i33 & _capacity;
            i29 = m;
            i11 = 0;
            m = $this$next$iv;
            i2 = 1;
        }
        return $i$f$h2;
    }

    public final void forEach(Function2<? super K, ? super Integer, Unit> block) {
        Object valueOf;
        int cmp;
        Object[] keys;
        int i$iv;
        long slot$iv;
        long j$iv;
        int i5;
        int i;
        int $i$f$forEach;
        Object[] objArr;
        long l;
        int i2;
        int i4;
        int i3;
        valueOf = this;
        final Object obj = block;
        Intrinsics.checkNotNullParameter(obj, "block");
        final int i12 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            $i$f$forEach = cmp;
            objArr = keys;
        }
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        int i4;
        long slot;
        int $this$maskEmptyOrDeleted$iv;
        int i3;
        int j;
        int i2;
        Integer valueOf;
        long l;
        int i;
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

    public final void forEachValue(Function1<? super Integer, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i;
        int i3;
        long l;
        int i2;
        int i4;
        final Object obj = block;
        Intrinsics.checkNotNullParameter(obj, "block");
        int i5 = 0;
        final int i6 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i7) {
        } else {
        }
    }

    public final int get(K key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex < 0) {
        } else {
            return this.values[keyIndex];
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("There is no key ").append(key).append(" in the map").toString());
        throw noSuchElementException;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getOrDefault(K key, int defaultValue) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            return this.values[keyIndex];
        }
        return defaultValue;
    }

    public final int getOrElse(K key, Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int i = 0;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            return this.values[keyIndex];
        }
        return (Number)defaultValue.invoke().intValue();
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int bitCount$iv$iv;
        Object obj;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i5;
        int i2;
        Object this_$iv;
        int hash;
        long l;
        int i7;
        int i;
        int i6;
        int i3;
        int i4;
        bitCount$iv$iv = 0;
        obj = this;
        final int i14 = 0;
        final int i15 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i16) {
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
        return ObjectIntMap.joinToString$default(this, 0, 0, 0, 0, 0, 31, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return ObjectIntMap.joinToString$default(this, charSequence, 0, 0, 0, 0, 30, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return ObjectIntMap.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 28, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ObjectIntMap.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 24, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ObjectIntMap.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 16, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated) {
        int key;
        int i$iv$iv;
        int i;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i4;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i2;
        int i3;
        int i5;
        int i7;
        long l;
        int key2;
        int i6;
        Object obj;
        StringBuilder sb;
        Object obj3 = prefix;
        final Object obj4 = postfix;
        final Object obj5 = truncated;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj3, "prefix");
        Intrinsics.checkNotNullParameter(obj4, "postfix");
        Intrinsics.checkNotNullParameter(obj5, "truncated");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj3);
        i4 = 0;
        index = this;
        final int i13 = 0;
        final long[] metadata = obj6.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            sb = stringBuilder;
            i5 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index;
            i2 = j$iv$iv;
            i = limit;
            index = i4;
            sb2.append(obj4);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2<? super K, ? super Integer, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv;
        Object obj2;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int index2;
        int i6;
        int i3;
        int this_$iv;
        Object index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i2;
        int i7;
        int $i$a$BuildStringObjectIntMap$joinToString$2;
        int i4;
        long l;
        int key;
        int i5;
        Object obj;
        int i;
        Object obj3 = prefix;
        final Object obj4 = postfix;
        final Object obj5 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj3, "prefix");
        Intrinsics.checkNotNullParameter(obj4, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        Intrinsics.checkNotNullParameter(obj5, "transform");
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        sb.append(obj3);
        index = this;
        final int i16 = 0;
        long[] metadata = obj6.metadata;
        final int i17 = i8;
        $i$f$joinToString += -2;
        if (0 <= i9) {
        } else {
            $i$a$BuildStringObjectIntMap$joinToString$2 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index;
            i2 = j$iv$iv;
            index2 = limit;
            this_$iv = invoke;
            sb.append(obj4);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, Function2<? super K, ? super Integer, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int $i$a$BuildStringObjectIntMap$joinToString$2$iv;
        int i7;
        int i6;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i;
        int i8;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i4;
        int i2;
        int i5;
        int i3;
        int i9;
        Object obj = prefix;
        final Object obj2 = postfix;
        final Object obj3 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj2, "postfix");
        Intrinsics.checkNotNullParameter(obj3, "transform");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj);
        index$iv = 0;
        final Object obj4 = this;
        final int i18 = 0;
        final int i19 = 0;
        long[] metadata = obj5.metadata;
        final int i20 = i11;
        $i$f$joinToString2 += -2;
        if (0 <= i12) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = i7;
            $i$a$BuildStringObjectIntMap$joinToString$2$iv = limit;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, Function2<? super K, ? super Integer, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i3;
        int i6;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i5;
        int i2;
        int i;
        int i4;
        Object obj = prefix;
        final Object obj3 = postfix;
        final Object obj4 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "transform");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj);
        index$iv = 0;
        final Object obj5 = this;
        final int i14 = 0;
        final int i15 = 0;
        Object obj2 = obj6;
        int this_$iv$iv$iv2 = i8;
        long[] $i$f$joinToString2 = obj2.metadata;
        final Object obj7 = obj2;
        this_$iv$iv$iv += -2;
        if (0 <= i7) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            sb2.append(obj3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, Function2<? super K, ? super Integer, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i3;
        int i4;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i6;
        int i5;
        int i;
        int i2;
        Object obj = prefix;
        final Object obj3 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "transform");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj);
        index$iv = 0;
        final Object obj4 = this;
        final int i14 = 0;
        final int i15 = 0;
        Object obj2 = obj5;
        int this_$iv$iv$iv2 = i8;
        long[] $i$f$joinToString2 = obj2.metadata;
        final Object obj6 = obj2;
        this_$iv$iv$iv += -2;
        if (0 <= i7) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            sb2.append((CharSequence)"");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, Function2<? super K, ? super Integer, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i6;
        int i5;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i;
        int i2;
        int i3;
        int i4;
        final Object obj = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "transform");
        final String str4 = "";
        String str5 = str4;
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append((CharSequence)str5);
        index$iv = 0;
        final Object obj2 = this;
        final int i14 = 0;
        final int i15 = 0;
        final int i16 = i7;
        Object $i$f$joinToString2 = obj3;
        String this_$iv$iv$iv2 = str5;
        long[] prefix$iv = $i$f$joinToString2.metadata;
        final Object obj4 = $i$f$joinToString2;
        this_$iv$iv$iv += -2;
        if (0 <= i8) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            sb2.append((CharSequence)str4);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(Function2<? super K, ? super Integer, ? extends java.lang.CharSequence> transform) {
        int separator$iv;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i5;
        int i3;
        int i2;
        StringBuilder sb;
        long l;
        int i;
        int i6;
        int i4;
        int i7;
        String separator$iv2;
        final Object obj = transform;
        Intrinsics.checkNotNullParameter(obj, "transform");
        final String str3 = "";
        String str4 = str3;
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append((CharSequence)str4);
        index$iv = 0;
        final Object obj2 = this;
        final int i15 = 0;
        final int i16 = 0;
        final int i17 = i8;
        Object $i$f$joinToString = obj3;
        String this_$iv$iv$iv2 = str4;
        long[] prefix$iv = $i$f$joinToString.metadata;
        final Object obj4 = $i$f$joinToString;
        this_$iv$iv$iv += -2;
        if (0 <= i9) {
        } else {
            separator$iv2 = separator$iv;
            i2 = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            sb2.append((CharSequence)str3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final boolean none() {
        int i;
        i = this._size == 0 ? 1 : 0;
        return i;
    }

    public String toString() {
        int i4;
        int bitCount$iv$iv;
        Object obj;
        Object key;
        int value;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i8;
        int i3;
        Object this_$iv;
        int i;
        long l;
        int i2;
        int i6;
        int $i$f$forEach;
        int i7;
        Object obj2;
        int i5;
        String str;
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append2 = stringBuilder.append('{');
        bitCount$iv$iv = 0;
        obj = this;
        final int i19 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i20) {
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
