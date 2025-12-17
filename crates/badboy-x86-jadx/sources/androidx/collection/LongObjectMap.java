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
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0016\n\u0002\u0008\u0006\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\u0008ø\u0001\u0000J\u0006\u0010\u001c\u001a\u00020\u0018J&\u0010\u001c\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\u0008ø\u0001\u0000J\u0011\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001bH\u0086\u0002J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001bJ\u0013\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u0006\u0010#\u001a\u00020\u0005J&\u0010#\u001a\u00020\u00052\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\u0008ø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00182\u0008\u0010%\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001bH\u0080\u0008¢\u0006\u0002\u0008'JD\u0010(\u001a\u00020)26\u0010*\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020)0\u001aH\u0086\u0008ø\u0001\u0000J/\u0010-\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(/\u0012\u0004\u0012\u00020)0.H\u0081\u0008ø\u0001\u0000J/\u00100\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020)0.H\u0086\u0008ø\u0001\u0000J/\u00101\u001a\u00020)2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020)0.H\u0086\u0008ø\u0001\u0000J\u0018\u00102\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\u001bH\u0086\u0002¢\u0006\u0002\u00103J\u001b\u00104\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u00105\u001a\u00028\u0000¢\u0006\u0002\u00106J'\u00107\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001b2\u000c\u00105\u001a\u0008\u0012\u0004\u0012\u00028\u000008H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u00109J\u0008\u0010:\u001a\u00020\u0005H\u0016J\u0006\u0010;\u001a\u00020\u0018J\u0006\u0010<\u001a\u00020\u0018J:\u0010=\u001a\u00020>2\u0008\u0008\u0002\u0010?\u001a\u00020@2\u0008\u0008\u0002\u0010A\u001a\u00020@2\u0008\u0008\u0002\u0010B\u001a\u00020@2\u0008\u0008\u0002\u0010C\u001a\u00020\u00052\u0008\u0008\u0002\u0010D\u001a\u00020@H\u0007Jx\u0010=\u001a\u00020>2\u0008\u0008\u0002\u0010?\u001a\u00020@2\u0008\u0008\u0002\u0010A\u001a\u00020@2\u0008\u0008\u0002\u0010B\u001a\u00020@2\u0008\u0008\u0002\u0010C\u001a\u00020\u00052\u0008\u0008\u0002\u0010D\u001a\u00020@28\u0008\u0004\u0010E\u001a2\u0012\u0013\u0012\u00110\u001b¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(\u001e\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008+\u0012\u0008\u0008,\u0012\u0004\u0008\u0008(!\u0012\u0004\u0012\u00020@0\u001aH\u0087\u0008ø\u0001\u0000J\u0006\u0010F\u001a\u00020\u0018J\u0008\u0010G\u001a\u00020>H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0018\u0010\u000c\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000e\u0010\u0003R\u0018\u0010\u000f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0003R\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000bR\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u0016\u0012\u0004\u0008\u0015\u0010\u0003\u0082\u0001\u0001H\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006I", d2 = {"Landroidx/collection/LongObjectMap;", "V", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(J)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableLongObjectMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LongObjectMap<V>  {

    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public Object[] values;
    private LongObjectMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public LongObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
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

    public static String joinToString$default(androidx.collection.LongObjectMap longObjectMap, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, int i7, Object object8) {
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
            return longObjectMap.joinToString(obj2, obj3, obj4, obj5, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public static String joinToString$default(androidx.collection.LongObjectMap $this, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2 transform, int i8, Object object9) {
        String separator3;
        String prefix2;
        int m$iv$iv;
        String postfix2;
        int limit2;
        String truncated2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        Object this_$iv;
        int j$iv$iv;
        long slot$iv$iv;
        int i;
        long l2;
        int i2;
        long l;
        int i5;
        int i3;
        String separator2;
        Object obj31;
        int obj32;
        int obj34;
        int obj35;
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
            i4 = 0;
            this_$iv = $this;
            final int i19 = 0;
            final String obj28 = prefix2;
            long[] prefix3 = obj2.metadata;
            final int obj29 = i12;
            $i$f$joinToString += -2;
            if (0 <= i13) {
            } else {
                separator2 = separator3;
                obj34 = $this$maskEmptyOrDeleted$iv$iv$iv;
                obj31 = this_$iv;
                obj32 = j$iv$iv;
                this_$iv = i4;
                sb.append(postfix2);
            }
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw unsupportedOperationException;
    }

    public final boolean all(Function2<? super Long, ? super V, Boolean> predicate) {
        int $i$f$all2;
        int i$iv$iv;
        int cmp;
        int i3;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i7;
        int i2;
        int i;
        long slot$iv$iv;
        int i6;
        int i4;
        long l;
        int i5;
        int $i$f$all;
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
            i = 1;
        }
        return i;
    }

    public final boolean any() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final boolean any(Function2<? super Long, ? super V, Boolean> predicate) {
        int $i$f$any2;
        int i$iv$iv;
        int cmp;
        int i4;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i7;
        int i2;
        int i;
        long slot$iv$iv;
        int i6;
        int i3;
        long l;
        int i5;
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

    public final boolean contains(long key) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i6;
        int i10;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i7;
        int i11;
        int i13;
        int i9;
        long l;
        int i4;
        int i2;
        int i3;
        int i8;
        int i;
        int i12;
        int i5;
        int numberOfTrailingZeros;
        final Object obj = this;
        m$iv2 = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = obj._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i35 = 0;
            i5 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i5;
                i7 = 0;
                i2 = 0;
                int i29 = m$iv;
                i13 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i5 = 1;
                $this$hasNext$iv$iv = i12;
            }
            $this$hasNext$iv$iv = i12;
            int i28 = i;
            i7 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i6 & _capacity;
            m$iv2 = i3;
            $i$f$hash = i8;
            long[] metadata = obj.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i9;
            i7 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i10;
            l = -9187201950435737472L;
            i18 &= l;
            i7 = 0;
            i2 = 0;
            i29 = m$iv;
            i13 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i5;
        }
        if (i10 >= 0) {
            i12 = i5;
        }
        return i12;
    }

    public final boolean containsKey(long key) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i8;
        int i;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i2;
        int i10;
        int i9;
        int i6;
        long l;
        int i4;
        int i11;
        int i3;
        int i7;
        int i12;
        int i5;
        int i13;
        int numberOfTrailingZeros;
        final Object obj = this;
        m$iv2 = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = obj._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i35 = 0;
            i13 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i13;
                i2 = 0;
                i11 = 0;
                int i29 = m$iv;
                i9 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i13 = 1;
                $this$hasNext$iv$iv = i5;
            }
            $this$hasNext$iv$iv = i5;
            int i28 = i12;
            i2 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i8 & _capacity;
            m$iv2 = i3;
            $i$f$hash = i7;
            long[] metadata = obj.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i6;
            i2 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i;
            l = -9187201950435737472L;
            i18 &= l;
            i2 = 0;
            i11 = 0;
            i29 = m$iv;
            i9 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i13;
        }
        if (i >= 0) {
            i5 = i13;
        }
        return i5;
    }

    public final boolean containsValue(V value) {
        int i$iv$iv;
        int i7;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object obj;
        int i4;
        Object obj2;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i6;
        long l;
        int i2;
        int i5;
        int i3;
        int i;
        boolean equal;
        final Object obj3 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            obj = value;
            i2 = 0;
        }
        return i2;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super Long, ? super V, Boolean> predicate) {
        int cmp;
        int i2;
        Object booleanValue;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i6;
        int $i$f$count;
        int count;
        long l;
        int i3;
        int i5;
        int i4;
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
        Object obj2;
        int j$iv$iv;
        int $i$f$isFull;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i;
        int cmp;
        int i2;
        long l;
        Object this_$iv;
        int i4;
        int i3;
        int i5;
        equal = other;
        $this$maskEmptyOrDeleted$iv$iv$iv = 1;
        obj = this;
        if (equal == obj) {
            return $this$maskEmptyOrDeleted$iv$iv$iv;
        }
        j$iv$iv = 0;
        if (equal instanceof LongObjectMap == null) {
            return j$iv$iv;
        }
        if ((LongObjectMap)equal.getSize() != obj.getSize()) {
            return j$iv$iv;
        }
        obj2 = this;
        final int i13 = 0;
        final long[] metadata = obj8.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            i2 = $this$maskEmptyOrDeleted$iv$iv$iv;
            this_$iv = obj2;
            i = $i$f$isFull;
        }
        return i2;
    }

    public final int findKeyIndex$collection(long key) {
        int m;
        int m2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex;
        int i2;
        int i8;
        int $this$next$iv;
        int i12;
        int i14;
        int i11;
        int i13;
        int i5;
        long l;
        int i9;
        int i;
        int i4;
        int i3;
        int i6;
        int i10;
        int i7;
        final Object obj = this;
        m = 0;
        int i20 = 0;
        i21 *= i24;
        $i$f$hash = i22 ^ i25;
        int i23 = 0;
        int _capacity = obj._capacity;
        int i26 = 0;
        $i$f$h12 &= _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i32 = 0;
            int i36 = 0;
            while (Long.compare(i27, i36) != 0) {
                i4 = 1;
                i14 = 0;
                i = 0;
                i8 = i38 & _capacity;
                int i30 = m2;
                i13 = 0;
                m2 = $this$next$iv;
                i32 = 0;
                i36 = 0;
                i4 = 0;
            }
            i4 = 0;
            int i29 = i10;
            i12 = 0;
            $i$f$h1 = i2 & _capacity;
            m = i3;
            $i$f$hash = i6;
            long[] metadata = obj.metadata;
            $this$next$iv = 0;
            int i31 = $i$f$h1 >> 3;
            i33 <<= 3;
            l4 >>>= i34;
            i17 |= i5;
            i14 = 0;
            long l5 = 72340172838076673L;
            i35 ^= i8;
            l = -9187201950435737472L;
            i19 &= l;
            i14 = 0;
            i = 0;
            i8 = i38 & _capacity;
            i30 = m2;
            i13 = 0;
            m2 = $this$next$iv;
            i4 = 1;
        }
        return i8;
    }

    public final void forEach(Function2<? super Long, ? super V, Unit> block) {
        Object obj;
        int cmp;
        long[] valueOf;
        int i$iv;
        long slot$iv;
        long j$iv;
        int i;
        int i2;
        int $i$f$forEach;
        long[] lArr;
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
            lArr = valueOf;
        }
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        int i4;
        long slot;
        int $this$maskEmptyOrDeleted$iv;
        int i3;
        int j;
        int i;
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

    public final void forEachKey(Function1<? super Long, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i3;
        int i;
        long l;
        int i4;
        int i2;
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
        int i;
        int i3;
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

    public final V get(long key) {
        Object obj2;
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i4;
        int i2;
        Object obj3;
        int $this$next$iv$iv;
        Object obj;
        int i5;
        int i3;
        int i6;
        int i7;
        long l;
        int i11;
        int i9;
        int i;
        int i12;
        int i10;
        int i8;
        int numberOfTrailingZeros;
        Object obj4 = this;
        m$iv2 = 0;
        int i18 = 0;
        i19 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        int _capacity = obj4._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i34 = 0;
            while (Long.compare(i25, i34) != 0) {
                i = 1;
                i5 = 0;
                i9 = 0;
                int i28 = m$iv;
                i6 = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i34 = 0;
                i = 0;
            }
            i = 0;
            int i27 = i8;
            i5 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj3 = this;
            $i$f$h1 = i4 & _capacity;
            m$iv2 = i12;
            $i$f$hash = i10;
            long[] metadata = obj4.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            l4 >>>= i32;
            i15 |= i7;
            i5 = 0;
            long l5 = 72340172838076673L;
            i33 ^= i2;
            l = -9187201950435737472L;
            i17 &= l;
            i5 = 0;
            i9 = 0;
            i28 = m$iv;
            i6 = 0;
            m$iv = $this$next$iv$iv;
            i = 1;
        }
        if (i2 >= 0) {
            obj2 = obj.values[i2];
        } else {
            obj = this;
            obj2 = 0;
        }
        return obj2;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final V getOrDefault(long key, V defaultValue) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i7;
        int i6;
        Object obj;
        int $this$next$iv$iv;
        int i5;
        int i12;
        int i2;
        int i8;
        long l;
        int i3;
        int i11;
        int i4;
        int i;
        int i10;
        int i9;
        int numberOfTrailingZeros;
        Object obj2 = this;
        m$iv = 0;
        int i18 = 0;
        i19 *= i22;
        $i$f$hash = i20 ^ i23;
        int i21 = 0;
        int _capacity = obj2._capacity;
        int i24 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i30 = 0;
            int i34 = 0;
            while (Long.compare(i25, i34) != 0) {
                i4 = 1;
                i5 = 0;
                i11 = 0;
                int i28 = m$iv2;
                i2 = 0;
                m$iv2 = $this$next$iv$iv;
                i30 = 0;
                i34 = 0;
                i4 = 0;
            }
            i4 = 0;
            int i27 = i9;
            i5 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            obj = this;
            $i$f$h1 = i7 & _capacity;
            m$iv = i;
            $i$f$hash = i10;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            l4 >>>= i32;
            i15 |= i8;
            i5 = 0;
            long l5 = 72340172838076673L;
            i33 ^= i6;
            l = -9187201950435737472L;
            i17 &= l;
            i5 = 0;
            i11 = 0;
            i28 = m$iv2;
            i2 = 0;
            m$iv2 = $this$next$iv$iv;
            i4 = 1;
        }
        if (i6 >= 0) {
            return obj4.values[i6];
        }
        Object obj5 = this;
        return obj24;
    }

    public final V getOrElse(long key, Function0<? extends V> defaultValue) {
        Object invoke;
        Intrinsics.checkNotNullParameter(obj5, "defaultValue");
        int i = 0;
        if (get(key) == null) {
            invoke = obj5.invoke();
        }
        return invoke;
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
        int i;
        int i4;
        Object this_$iv;
        int hash;
        long l;
        int i5;
        int i2;
        long l2;
        int i3;
        int i6;
        bitCount$iv$iv = 0;
        obj = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj2.metadata;
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
        return LongObjectMap.joinToString$default(this, 0, 0, 0, 0, 0, 31, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return LongObjectMap.joinToString$default(this, charSequence, 0, 0, 0, 0, 30, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return LongObjectMap.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 28, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return LongObjectMap.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 24, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return LongObjectMap.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 16, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated) {
        int obj;
        int i$iv$iv;
        Object obj2;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i5;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i4;
        int i;
        int i6;
        int i3;
        long l2;
        int key;
        StringBuilder sb;
        int i2;
        long l;
        Object obj3 = prefix;
        final Object obj4 = postfix;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj3, "prefix");
        Intrinsics.checkNotNullParameter(obj4, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj3);
        i5 = 0;
        index = this;
        final int i12 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            sb = stringBuilder;
            i6 = $this$maskEmptyOrDeleted$iv$iv$iv;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = index;
            i4 = j$iv$iv;
            index = i5;
            sb2.append(obj4);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2<? super Long, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv;
        int i3;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i7;
        int i8;
        int i5;
        int i6;
        long l;
        int i4;
        int i9;
        int i2;
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
        i = 0;
        index = this;
        final int i17 = 0;
        long[] metadata = obj5.metadata;
        final int i18 = i10;
        $i$f$joinToString += -2;
        if (0 <= i11) {
        } else {
            sb = stringBuilder;
            i5 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index;
            i7 = j$iv$iv;
            i3 = limit;
            index = i;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, Function2<? super Long, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int $i$a$BuildStringLongObjectMap$joinToString$2$iv;
        int i4;
        int i3;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i2;
        int i;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i7;
        int i6;
        int i8;
        int i5;
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
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = i4;
            $i$a$BuildStringLongObjectMap$joinToString$2$iv = limit;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, Function2<? super Long, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i;
        int i3;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i5;
        int i4;
        int i2;
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

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, Function2<? super Long, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i2;
        int i5;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i;
        int i4;
        int i3;
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
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
            sb2.append((CharSequence)"");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, Function2<? super Long, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i3;
        int i2;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i4;
        int i5;
        int i;
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

    public final String joinToString(Function2<? super Long, ? super V, ? extends java.lang.CharSequence> transform) {
        int separator$iv2;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i5;
        int i6;
        int i4;
        StringBuilder sb;
        long l;
        int i;
        int i2;
        int i3;
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
            i4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
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
        int i2;
        int bitCount$iv$iv;
        Object obj;
        Object str;
        int append;
        long[] k$iv;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i6;
        int i7;
        Object this_$iv;
        int i3;
        long l2;
        int $i$f$forEach;
        int i4;
        int i5;
        long[] lArr;
        int i;
        long l;
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append3 = stringBuilder.append('{');
        bitCount$iv$iv = 0;
        obj = this;
        final int i18 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i19) {
        } else {
            this_$iv = obj;
            $i$f$forEach = append;
            lArr = k$iv;
            i3 = bitCount$iv$iv;
        }
        String string = append3.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(string, "s.append('}').toString()");
        return string;
    }
}
