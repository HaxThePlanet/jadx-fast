package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0019J&\u0010\u001c\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0011\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0005J\u0013\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00192\u0008\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0080\u0008¢\u0006\u0002\u0008'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020)0\u001bH\u0086\u0008ø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(/\u0012\u0004\u0012\u00020)0.H\u0081\u0008ø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\u0008ø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020)0.H\u0086\u0008ø\u0001\u0000J\u0018\u00102\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0002\u00103J\u001b\u00104\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u00105\u001a\u00028\u0000¢\u0006\u0002\u00106J'\u00107\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u00028\u000008H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00109J\u0008\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u0019J\u0006\u0010<\u001a\u00020\u0019J:\u0010=\u001a\u00020>2\u0008\u0008\u0002\u0010?\u001a\u00020@2\u0008\u0008\u0002\u0010A\u001a\u00020@2\u0008\u0008\u0002\u0010B\u001a\u00020@2\u0008\u0008\u0002\u0010C\u001a\u00020\u00052\u0008\u0008\u0002\u0010D\u001a\u00020@H\u0007Jx\u0010=\u001a\u00020>2\u0008\u0008\u0002\u0010?\u001a\u00020@2\u0008\u0008\u0002\u0010A\u001a\u00020@2\u0008\u0008\u0002\u0010B\u001a\u00020@2\u0008\u0008\u0002\u0010C\u001a\u00020\u00052\u0008\u0008\u0002\u0010D\u001a\u00020@28\u0008\u0004\u0010E\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020@0\u001bH\u0087\u0008ø\u0001\u0000J\u0006\u0010F\u001a\u00020\u0019J\u0008\u0010G\u001a\u00020>H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0018\u0010\u000c\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000e\u0010\u0003R\u0018\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0011\u0010\u0003R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000bR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u0017\u0012\u0004\u0008\u0016\u0010\u0003\u0082\u0001\u0001H\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006I", d2 = {"Landroidx/collection/IntObjectMap;", "V", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "all", "", "predicate", "Lkotlin/Function2;", "any", "contains", "key", "containsKey", "containsValue", "value", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(I)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(ILjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableIntObjectMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class IntObjectMap<V>  {

    public int _capacity;
    public int _size;
    public int[] keys;
    public long[] metadata;
    public Object[] values;
    private IntObjectMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = IntSetKt.getEmptyIntArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public IntObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
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

    public static String joinToString$default(androidx.collection.IntObjectMap intObjectMap, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, int i7, Object object8) {
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
            return intObjectMap.joinToString(obj2, obj3, obj4, obj5, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public static String joinToString$default(androidx.collection.IntObjectMap $this, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2 transform, int i8, Object object9) {
        String separator3;
        String prefix2;
        int m$iv$iv;
        String postfix2;
        int limit2;
        String truncated2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i2;
        Object this_$iv;
        int j$iv$iv;
        long slot$iv$iv;
        int i4;
        long l;
        int i5;
        int i6;
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
            i2 = 0;
            this_$iv = $this;
            final int i20 = 0;
            final String obj27 = prefix2;
            long[] prefix3 = obj2.metadata;
            final int obj28 = i13;
            $i$f$joinToString += -2;
            if (0 <= i14) {
            } else {
                separator2 = separator3;
                obj33 = $this$maskEmptyOrDeleted$iv$iv$iv;
                obj30 = this_$iv;
                obj31 = j$iv$iv;
                this_$iv = i2;
                sb.append(postfix2);
            }
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw unsupportedOperationException;
    }

    public final boolean all(Function2<? super Integer, ? super V, Boolean> predicate) {
        int $i$f$all;
        int i$iv$iv;
        int cmp;
        int i;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i2;
        int i7;
        int i4;
        long slot$iv$iv;
        long cmp2;
        int i3;
        int i5;
        int i6;
        int $i$f$all2;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            $i$f$all2 = $i$f$all;
            i4 = 1;
        }
        return i4;
    }

    public final boolean any() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final boolean any(Function2<? super Integer, ? super V, Boolean> predicate) {
        int $i$f$any2;
        int i$iv$iv;
        int cmp2;
        int i3;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i5;
        int i7;
        int i;
        long slot$iv$iv;
        long cmp;
        int i2;
        int i4;
        int i6;
        int $i$f$any;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            $i$f$any = $i$f$any2;
            i = 0;
        }
        return i;
    }

    public final boolean contains(int key) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i6;
        int i8;
        int $this$hasNext$iv$iv;
        int i4;
        int i9;
        int i;
        int $this$next$iv$iv;
        int i10;
        long l;
        int i5;
        int i7;
        int i11;
        int i12;
        int i13;
        int i3;
        int i2;
        int numberOfTrailingZeros;
        int i14;
        final Object obj = this;
        m$iv = 0;
        int i20 = 0;
        i21 *= i24;
        $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int _capacity = obj._capacity;
        int i26 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i36 = 0;
            i2 = 1;
            while (Long.compare(i27, i36) != 0) {
                $this$hasNext$iv$iv = i2;
                int i32 = 0;
                i7 = 0;
                int i38 = m$iv2;
                i4 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i36 = 0;
                i2 = 1;
                $this$hasNext$iv$iv = i3;
            }
            $this$hasNext$iv$iv = i3;
            i9 = key;
            int i29 = i13;
            i7 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i6 & _capacity;
            m$iv = i11;
            $i$f$hash = i12;
            long[] metadata = obj.metadata;
            i4 = 0;
            int i30 = $i$f$h1 >> 3;
            i33 <<= 3;
            l3 >>>= i34;
            i17 |= i10;
            i9 = 0;
            long l4 = 72340172838076673L;
            i35 ^= i8;
            l = -9187201950435737472L;
            i19 &= l;
            i32 = 0;
            i7 = 0;
            i38 = m$iv2;
            i4 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$hasNext$iv$iv = i2;
        }
        if (i8 >= 0) {
            i3 = i2;
        }
        return i3;
    }

    public final boolean containsKey(int key) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i10;
        int i4;
        int $this$hasNext$iv$iv;
        int i9;
        int i12;
        int i13;
        int $this$next$iv$iv;
        int i8;
        long l;
        int i6;
        int i14;
        int i3;
        int i5;
        int i11;
        int i7;
        int i;
        int numberOfTrailingZeros;
        int i2;
        final Object obj = this;
        m$iv2 = 0;
        int i20 = 0;
        i21 *= i24;
        $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int _capacity = obj._capacity;
        int i26 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i36 = 0;
            i = 1;
            while (Long.compare(i27, i36) != 0) {
                $this$hasNext$iv$iv = i;
                int i32 = 0;
                i14 = 0;
                int i38 = m$iv;
                i9 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i36 = 0;
                i = 1;
                $this$hasNext$iv$iv = i7;
            }
            $this$hasNext$iv$iv = i7;
            i12 = key;
            int i29 = i11;
            i14 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i10 & _capacity;
            m$iv2 = i3;
            $i$f$hash = i5;
            long[] metadata = obj.metadata;
            i9 = 0;
            int i30 = $i$f$h1 >> 3;
            i33 <<= 3;
            l3 >>>= i34;
            i17 |= i8;
            i12 = 0;
            long l4 = 72340172838076673L;
            i35 ^= i4;
            l = -9187201950435737472L;
            i19 &= l;
            i32 = 0;
            i14 = 0;
            i38 = m$iv;
            i9 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i;
        }
        if (i4 >= 0) {
            i7 = i;
        }
        return i7;
    }

    public final boolean containsValue(V value) {
        int i$iv$iv;
        int i5;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object obj2;
        int i6;
        Object obj;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i;
        long l;
        int i2;
        int i7;
        int i4;
        int i3;
        boolean equal;
        final Object obj3 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            obj2 = value;
            i2 = 0;
        }
        return i2;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super Integer, ? super V, Boolean> predicate) {
        int cmp;
        int i2;
        Object booleanValue;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i6;
        int $i$f$count;
        int count;
        long l;
        int i5;
        int i4;
        int i;
        Object this_$iv;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        i2 = 0;
        booleanValue = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$count = cmp;
            this_$iv = booleanValue;
            count = i2;
        }
        return count;
    }

    public boolean equals(Object other) {
        int equal;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int obj;
        int j$iv$iv;
        int $i$f$isFull;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i2;
        int cmp;
        int i4;
        long l;
        int i5;
        int i3;
        int i;
        equal = other;
        $this$maskEmptyOrDeleted$iv$iv$iv = 1;
        obj = this;
        if (equal == obj) {
            return $this$maskEmptyOrDeleted$iv$iv$iv;
        }
        j$iv$iv = 0;
        if (equal instanceof IntObjectMap == null) {
            return j$iv$iv;
        }
        if ((IntObjectMap)equal.getSize() != obj.getSize()) {
            return j$iv$iv;
        }
        Object obj7 = this;
        final int i13 = 0;
        final long[] metadata = obj8.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            i4 = $this$maskEmptyOrDeleted$iv$iv$iv;
            i2 = $i$f$isFull;
        }
        return i4;
    }

    public final int findKeyIndex$collection(int key) {
        int m;
        int m2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex;
        int i3;
        int i4;
        int i5;
        int i11;
        int i;
        int i9;
        int $this$next$iv;
        int i8;
        long l;
        int i2;
        int i14;
        int i6;
        int i10;
        int i12;
        int i15;
        int i13;
        int i7;
        final Object obj = this;
        m = 0;
        int i21 = 0;
        i22 *= i25;
        $i$f$hash = i23 ^ i26;
        int i24 = 0;
        int _capacity = obj._capacity;
        int i27 = 0;
        $i$f$h12 &= _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i33 = 0;
            int i38 = 0;
            while (Long.compare(i28, i38) != 0) {
                i6 = 1;
                int i34 = 0;
                i14 = 0;
                i4 = i40 & _capacity;
                int i41 = m2;
                i5 = 0;
                m2 = $this$next$iv;
                i33 = 0;
                i38 = 0;
                i6 = 0;
            }
            i6 = 0;
            i11 = key;
            int i30 = i15;
            i14 = 0;
            $i$f$h1 = i3 & _capacity;
            m = i10;
            $i$f$hash = i12;
            long[] metadata = obj.metadata;
            i5 = 0;
            int i32 = $i$f$h1 >> 3;
            i35 <<= 3;
            l3 >>>= i36;
            i18 |= i8;
            i = 0;
            long l4 = 72340172838076673L;
            i37 ^= i4;
            l = -9187201950435737472L;
            i20 &= l;
            i34 = 0;
            i14 = 0;
            i4 = i40 & _capacity;
            i41 = m2;
            i5 = 0;
            m2 = $this$next$iv;
            i6 = 1;
        }
        return i4;
    }

    public final void forEach(Function2<? super Integer, ? super V, Unit> block) {
        Object obj;
        int cmp;
        int[] valueOf;
        int i$iv;
        long slot$iv;
        long j$iv;
        int i;
        int i2;
        int $i$f$forEach;
        int[] iArr;
        long l;
        int i3;
        int i4;
        obj = this;
        final Object obj2 = block;
        Intrinsics.checkNotNullParameter(obj2, "block");
        final int i11 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i12) {
        } else {
            $i$f$forEach = cmp;
            iArr = valueOf;
        }
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        int i;
        long slot;
        int $this$maskEmptyOrDeleted$iv;
        int i4;
        int j;
        int i3;
        Integer valueOf;
        long l;
        int i2;
        Intrinsics.checkNotNullParameter(block, "block");
        int i5 = 0;
        final long[] metadata = this.metadata;
        length += -2;
        if (0 <= i6) {
        }
    }

    public final void forEachKey(Function1<? super Integer, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i2;
        int i;
        long l;
        int i3;
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

    public final void forEachValue(Function1<? super V, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int i2;
        int j$iv;
        int i5;
        int i;
        long l;
        int i3;
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

    public final V get(int key) {
        Object obj3;
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i7;
        int i2;
        Object obj;
        int i;
        Object obj2;
        int i3;
        int i9;
        int $this$next$iv$iv;
        int i6;
        long l;
        int i13;
        int i12;
        int i5;
        int i11;
        int i8;
        int i10;
        int numberOfTrailingZeros;
        int i4;
        Object obj4 = this;
        m$iv = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = obj4._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            while (Long.compare(i26, i35) != 0) {
                i5 = 1;
                int i31 = 0;
                i12 = 0;
                int i37 = m$iv2;
                i = 0;
                m$iv2 = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i5 = 0;
            }
            i5 = 0;
            i3 = key;
            int i28 = i10;
            i12 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj = this;
            $i$f$h1 = i7 & _capacity;
            m$iv = i11;
            $i$f$hash = i8;
            long[] metadata = obj4.metadata;
            i = 0;
            int i29 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i6;
            i3 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i2;
            l = -9187201950435737472L;
            i18 &= l;
            i31 = 0;
            i12 = 0;
            i37 = m$iv2;
            i = 0;
            m$iv2 = $this$next$iv$iv;
            i5 = 1;
        }
        if (i2 >= 0) {
            obj3 = obj2.values[i2];
        } else {
            obj2 = this;
            obj3 = 0;
        }
        return obj3;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final V getOrDefault(int key, V defaultValue) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i2;
        int i10;
        Object obj;
        int i5;
        int i8;
        int i;
        int $this$next$iv$iv;
        int i6;
        long l;
        int i7;
        int i9;
        int i11;
        int i13;
        int i12;
        int i4;
        int numberOfTrailingZeros;
        int i3;
        Object obj2 = this;
        m$iv2 = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = obj2._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i35 = 0;
            while (Long.compare(i26, i35) != 0) {
                i11 = 1;
                int i31 = 0;
                i9 = 0;
                int i37 = m$iv;
                i5 = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i11 = 0;
            }
            i11 = 0;
            i8 = key;
            int i28 = i4;
            i9 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj = this;
            $i$f$h1 = i2 & _capacity;
            m$iv2 = i13;
            $i$f$hash = i12;
            long[] metadata = obj2.metadata;
            i5 = 0;
            int i29 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i6;
            i8 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i10;
            l = -9187201950435737472L;
            i18 &= l;
            i31 = 0;
            i9 = 0;
            i37 = m$iv;
            i5 = 0;
            m$iv = $this$next$iv$iv;
            i11 = 1;
        }
        if (i10 >= 0) {
            return obj4.values[i10];
        }
        Object obj5 = this;
        return defaultValue;
    }

    public final V getOrElse(int key, Function0<? extends V> defaultValue) {
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
        Object obj2;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i4;
        int i3;
        Object this_$iv;
        int hash;
        long l;
        int i6;
        int i5;
        Object obj;
        int i2;
        int i;
        bitCount$iv$iv = 0;
        obj2 = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            this_$iv = obj2;
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
        return IntObjectMap.joinToString$default(this, 0, 0, 0, 0, 0, 31, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return IntObjectMap.joinToString$default(this, charSequence, 0, 0, 0, 0, 30, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return IntObjectMap.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 28, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return IntObjectMap.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 24, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return IntObjectMap.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 16, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated) {
        int key2;
        int i$iv$iv;
        int i5;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i7;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i;
        int i3;
        int i8;
        int i6;
        long l;
        int key;
        int i2;
        int i4;
        StringBuilder sb;
        Object obj = prefix;
        final Object obj2 = postfix;
        final Object obj3 = truncated;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj2, "postfix");
        Intrinsics.checkNotNullParameter(obj3, "truncated");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj);
        i7 = 0;
        index = this;
        final int i15 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i16) {
        } else {
            sb = stringBuilder;
            i8 = $this$maskEmptyOrDeleted$iv$iv$iv;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = index;
            i = j$iv$iv;
            i5 = limit;
            index = i7;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2<? super Integer, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv;
        int i;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i2;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i9;
        int i8;
        int i7;
        int i3;
        long l;
        int i5;
        int i6;
        int i4;
        StringBuilder sb;
        Object obj = prefix;
        final Object obj2 = postfix;
        final Object obj3 = truncated;
        final Object obj4 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj2, "postfix");
        Intrinsics.checkNotNullParameter(obj3, "truncated");
        Intrinsics.checkNotNullParameter(obj4, "transform");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj);
        i2 = 0;
        index = this;
        final int i17 = 0;
        long[] metadata = obj5.metadata;
        final int i18 = i10;
        $i$f$joinToString += -2;
        if (0 <= i11) {
        } else {
            sb = stringBuilder;
            i7 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index;
            i9 = j$iv$iv;
            i = limit;
            index = i2;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, Function2<? super Integer, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int $i$a$BuildStringIntObjectMap$joinToString$2$iv;
        int i6;
        int i2;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i;
        int i7;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i3;
        int i5;
        int i8;
        int i4;
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
        final int i17 = 0;
        final int i18 = 0;
        long[] metadata = obj5.metadata;
        final int i19 = i10;
        $i$f$joinToString2 += -2;
        if (0 <= i11) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = i6;
            $i$a$BuildStringIntObjectMap$joinToString$2$iv = limit;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, Function2<? super Integer, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i4;
        int i5;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i3;
        int i2;
        int i;
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
        final int i13 = 0;
        final int i14 = 0;
        Object obj2 = obj6;
        int this_$iv$iv$iv2 = i7;
        long[] $i$f$joinToString2 = obj2.metadata;
        final Object obj7 = obj2;
        this_$iv$iv$iv += -2;
        if (0 <= i6) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
            sb2.append(obj3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, Function2<? super Integer, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i2;
        int i;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i5;
        int i3;
        int i4;
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
        final int i13 = 0;
        final int i14 = 0;
        Object obj2 = obj5;
        int this_$iv$iv$iv2 = i7;
        long[] $i$f$joinToString2 = obj2.metadata;
        final Object obj6 = obj2;
        this_$iv$iv$iv += -2;
        if (0 <= i6) {
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

    public final String joinToString(java.lang.CharSequence separator, Function2<? super Integer, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i5;
        int i;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i4;
        int i3;
        int i2;
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
        final int i13 = 0;
        final int i14 = 0;
        final int i15 = i6;
        Object $i$f$joinToString2 = obj3;
        String this_$iv$iv$iv2 = str5;
        long[] prefix$iv = $i$f$joinToString2.metadata;
        final Object obj4 = $i$f$joinToString2;
        this_$iv$iv$iv += -2;
        if (0 <= i7) {
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

    public final String joinToString(Function2<? super Integer, ? super V, ? extends java.lang.CharSequence> transform) {
        int separator$iv2;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i6;
        int i;
        int i5;
        StringBuilder sb;
        long l;
        int i3;
        int i2;
        int i4;
        String separator$iv;
        final Object obj = transform;
        Intrinsics.checkNotNullParameter(obj, "transform");
        final String str3 = "";
        String str4 = str3;
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append((CharSequence)str4);
        index$iv = 0;
        final Object obj2 = this;
        final int i14 = 0;
        final int i15 = 0;
        final int i16 = i7;
        Object $i$f$joinToString = obj3;
        String this_$iv$iv$iv2 = str4;
        long[] prefix$iv = $i$f$joinToString.metadata;
        final Object obj4 = $i$f$joinToString;
        this_$iv$iv$iv += -2;
        if (0 <= i8) {
        } else {
            separator$iv = separator$iv2;
            i5 = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
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
        Object str;
        int value;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i5;
        int i7;
        Object this_$iv;
        int i2;
        long l;
        int i3;
        int i6;
        int $i$f$forEach;
        int i8;
        int i;
        Object obj2;
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append2 = stringBuilder.append('{');
        bitCount$iv$iv = 0;
        obj = this;
        final int i20 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i21) {
        } else {
            this_$iv = obj;
            $i$f$forEach = value;
            i2 = bitCount$iv$iv;
        }
        String string = append2.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(string, "s.append('}').toString()");
        return string;
    }
}
