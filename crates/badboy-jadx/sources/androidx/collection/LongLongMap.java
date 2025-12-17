package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0016\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J&\u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000J\u0006\u0010\u0019\u001a\u00020\u0015J&\u0010\u0019\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000J\u0011\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0018H\u0086\u0002J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0004J&\u0010\u001f\u001a\u00020\u00042\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00150\u0017H\u0086\u0008ø\u0001\u0000J\u0013\u0010 \u001a\u00020\u00152\u0008\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0018H\u0001JD\u0010#\u001a\u00020$26\u0010%\u001a2\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\u001b\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020$0\u0017H\u0086\u0008ø\u0001\u0000J/\u0010(\u001a\u00020$2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(*\u0012\u0004\u0012\u00020$0)H\u0081\u0008ø\u0001\u0000J/\u0010+\u001a\u00020$2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020$0)H\u0086\u0008ø\u0001\u0000J/\u0010,\u001a\u00020$2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u00020$0)H\u0086\u0008ø\u0001\u0000J\u0011\u0010-\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0086\u0002J\u0016\u0010.\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0018J\"\u00100\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u000c\u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u001801H\u0086\u0008ø\u0001\u0000J\u0008\u00102\u001a\u00020\u0004H\u0016J\u0006\u00103\u001a\u00020\u0015J\u0006\u00104\u001a\u00020\u0015J:\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u00109\u001a\u0002082\u0008\u0008\u0002\u0010:\u001a\u0002082\u0008\u0008\u0002\u0010;\u001a\u00020\u00042\u0008\u0008\u0002\u0010<\u001a\u000208H\u0007Jx\u00105\u001a\u0002062\u0008\u0008\u0002\u00107\u001a\u0002082\u0008\u0008\u0002\u00109\u001a\u0002082\u0008\u0008\u0002\u0010:\u001a\u0002082\u0008\u0008\u0002\u0010;\u001a\u00020\u00042\u0008\u0008\u0002\u0010<\u001a\u00020828\u0008\u0004\u0010=\u001a2\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\u001b\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008&\u0012\u0008\u0008'\u0012\u0004\u0008\u0008(\u001e\u0012\u0004\u0012\u0002080\u0017H\u0087\u0008ø\u0001\u0000J\u0006\u0010>\u001a\u00020\u0015J\u0008\u0010?\u001a\u000206H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0002R\u0011\u0010\u0008\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\r\u0010\u0002R\u0018\u0010\u000e\u001a\u00020\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000f\u0010\u0002R\u0011\u0010\u0010\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\nR\u0018\u0010\u0012\u001a\u00020\u000c8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0013\u0010\u0002\u0082\u0001\u0001@\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006A", d2 = {"Landroidx/collection/LongLongMap;", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "getMetadata$annotations", "size", "getSize", "values", "getValues$annotations", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "count", "equals", "other", "findKeyIndex", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableLongLongMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LongLongMap {

    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public long[] values;
    private LongLongMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    public LongLongMap(DefaultConstructorMarker defaultConstructorMarker) {
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

    public static String joinToString$default(androidx.collection.LongLongMap longLongMap, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, int i7, Object object8) {
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
            return longLongMap.joinToString(obj2, obj3, obj4, obj5, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public static String joinToString$default(androidx.collection.LongLongMap $this, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2 transform, int i8, Object object9) {
        String separator2;
        String prefix2;
        int m$iv$iv;
        String postfix2;
        int limit2;
        String truncated2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int valueOf;
        Object this_$iv;
        int j$iv$iv;
        long slot$iv$iv;
        int i3;
        long l;
        int i2;
        long l2;
        long l3;
        int i4;
        int i;
        String separator3;
        Object obj33;
        int obj34;
        int obj36;
        int obj37;
        final Object obj = transform;
        if (object9 != null) {
        } else {
            if (i8 & 1 != 0) {
                separator2 = ", ";
            } else {
                separator2 = separator;
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
            Intrinsics.checkNotNullParameter(separator2, "separator");
            Intrinsics.checkNotNullParameter(prefix2, "prefix");
            Intrinsics.checkNotNullParameter(postfix2, "postfix");
            Intrinsics.checkNotNullParameter(truncated2, "truncated");
            Intrinsics.checkNotNullParameter(obj, "transform");
            StringBuilder stringBuilder = new StringBuilder();
            final StringBuilder sb = stringBuilder;
            sb.append(prefix2);
            valueOf = 0;
            this_$iv = $this;
            final int i18 = 0;
            final String obj30 = prefix2;
            long[] prefix3 = obj2.metadata;
            final int obj31 = i11;
            $i$f$joinToString += -2;
            if (0 <= i12) {
            } else {
                separator3 = separator2;
                obj36 = $this$maskEmptyOrDeleted$iv$iv$iv;
                obj33 = this_$iv;
                obj34 = j$iv$iv;
                this_$iv = valueOf;
                sb.append(postfix2);
            }
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw unsupportedOperationException;
    }

    public final boolean all(Function2<? super Long, ? super Long, Boolean> predicate) {
        int $i$f$all;
        int i$iv$iv;
        int cmp;
        int valueOf;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i2;
        int i3;
        int i4;
        long slot$iv$iv;
        long cmp2;
        int i;
        long l;
        long l2;
        int i5;
        int $i$f$all2;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i6 = 0;
        final int i7 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i8) {
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

    public final boolean any(Function2<? super Long, ? super Long, Boolean> predicate) {
        int $i$f$any2;
        int i$iv$iv;
        int cmp2;
        int valueOf;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i4;
        int i5;
        int i;
        long slot$iv$iv;
        long cmp;
        int i2;
        long l;
        long l2;
        int i3;
        int $i$f$any;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        final Object obj2 = this;
        final int i6 = 0;
        final int i7 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i8) {
        } else {
            $i$f$any = $i$f$any2;
            i = 0;
        }
        return i;
    }

    public final boolean contains(long key) {
        int i;
        i = findKeyIndex(key) >= 0 ? 1 : 0;
        return i;
    }

    public final boolean containsKey(long key) {
        int i;
        i = findKeyIndex(key) >= 0 ? 1 : 0;
        return i;
    }

    public final boolean containsValue(long value) {
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i2;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i;
        long l;
        int cmp2;
        int i3;
        long l2;
        int cmp;
        final Object obj = this;
        final int i4 = 0;
        final int i5 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        final int i7 = 0;
        if (0 <= i6) {
        } else {
        }
        return i7;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super Long, ? super Long, Boolean> predicate) {
        int cmp;
        int booleanValue;
        Object valueOf;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i2;
        int $i$f$count;
        int count;
        long l2;
        int i3;
        long l;
        int i5;
        int i4;
        Object this_$iv;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        booleanValue = 0;
        valueOf = this;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$count = cmp;
            this_$iv = valueOf;
            count = booleanValue;
        }
        return count;
    }

    public boolean equals(Object other) {
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i;
        Object obj;
        int j$iv$iv;
        int $i$f$isFull;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i5;
        int cmp;
        int i3;
        long l3;
        Object this_$iv;
        int i2;
        long l2;
        int i6;
        int i4;
        long l;
        final Object obj2 = other;
        $this$maskEmptyOrDeleted$iv$iv$iv = 1;
        i = this;
        if (obj2 == i) {
            return $this$maskEmptyOrDeleted$iv$iv$iv;
        }
        j$iv$iv = 0;
        if (obj2 instanceof LongLongMap == null) {
            return j$iv$iv;
        }
        if ((LongLongMap)obj2.getSize() != i.getSize()) {
            return j$iv$iv;
        }
        obj = this;
        final int i14 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            i3 = $this$maskEmptyOrDeleted$iv$iv$iv;
            this_$iv = obj;
            i5 = $i$f$isFull;
        }
        return i3;
    }

    public final int findKeyIndex(long key) {
        int $i$f$hash;
        int m;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex;
        int metadata$iv;
        int i8;
        int i4;
        int i;
        int $this$next$iv;
        int i7;
        int i11;
        int i6;
        int i5;
        int i12;
        long l;
        int i9;
        int i13;
        int i2;
        int i14;
        int i3;
        int numberOfTrailingZeros;
        int i10;
        final Object obj = this;
        int i15 = 0;
        i17 *= i20;
        $i$f$hash = i18 ^ i21;
        int i19 = 0;
        $i$f$h2 = $i$f$hash & 127;
        int _capacity = obj._capacity;
        int i22 = 0;
        $i$f$h12 &= _capacity;
        probeIndex = 0;
        while (/* condition */) {
            int i30 = 0;
            int i32 = 0;
            while (Long.compare(i24, i32) != 0) {
                i3 = 1;
                i11 = 0;
                int i43 = 0;
                i = i34 & _capacity;
                int i28 = m;
                i5 = 0;
                m = $this$next$iv;
                i30 = 0;
                i32 = 0;
                i3 = 0;
            }
            i3 = 0;
            int i26 = metadata$iv;
            i7 = 0;
            $i$f$h1 = i4 & _capacity;
            $i$f$hash = i13;
            $i$f$h2 = i2;
            long[] metadata = obj.metadata;
            i8 = 0;
            int i23 = $i$f$h1 >> 3;
            i27 <<= 3;
            i38 &= i9;
            metadata$iv = i29 | i12;
            i11 = 0;
            long l6 = 72340172838076673L;
            i31 ^= i;
            l = -9187201950435737472L;
            i16 &= l;
            i11 = 0;
            i43 = 0;
            i = i34 & _capacity;
            i28 = m;
            i5 = 0;
            m = $this$next$iv;
            i3 = 1;
        }
        return i;
    }

    public final void forEach(Function2<? super Long, ? super Long, Unit> block) {
        Object valueOf;
        int cmp;
        long[] valueOf2;
        int i$iv;
        long slot$iv;
        long j$iv;
        int i;
        int i3;
        int $i$f$forEach;
        long[] lArr;
        long l;
        int i2;
        int i4;
        valueOf = this;
        final Object obj = block;
        Intrinsics.checkNotNullParameter(obj, "block");
        final int i11 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i12) {
        } else {
            $i$f$forEach = cmp;
            lArr = valueOf2;
        }
    }

    public final void forEachIndexed(Function1<? super Integer, Unit> block) {
        int i;
        long slot;
        int $this$maskEmptyOrDeleted$iv;
        int i3;
        int j;
        int i2;
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

    public final void forEachKey(Function1<? super Long, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i3;
        int i4;
        long l;
        int i2;
        int i;
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

    public final void forEachValue(Function1<? super Long, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i4;
        int i;
        long l;
        int i2;
        int i3;
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

    public final long get(long key) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex < 0) {
        } else {
            return this.values[keyIndex];
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Cannot find value for key ").append(key).toString());
        throw noSuchElementException;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final long getOrDefault(long key, long defaultValue) {
        final int keyIndex = findKeyIndex(key);
        if (keyIndex >= 0) {
            return this.values[keyIndex];
        }
        return obj6;
    }

    public final long getOrElse(long key, Function0<Long> defaultValue) {
        Intrinsics.checkNotNullParameter(obj7, "defaultValue");
        int i = 0;
        final int keyIndex = findKeyIndex(key);
        if (keyIndex < 0) {
            return (Number)obj7.invoke().longValue();
        }
        return this.values[keyIndex];
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
        int i;
        int i5;
        Object this_$iv;
        int hash;
        long l2;
        int i3;
        long l;
        int i4;
        int i6;
        int i2;
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
        return LongLongMap.joinToString$default(this, 0, 0, 0, 0, 0, 31, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return LongLongMap.joinToString$default(this, charSequence, 0, 0, 0, 0, 30, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return LongLongMap.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 28, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return LongLongMap.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 24, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return LongLongMap.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 16, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated) {
        Object obj;
        int i$iv$iv;
        int i7;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i;
        int this_$iv;
        int j$iv$iv;
        long[] keys;
        long[] v$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i9;
        int i6;
        int i10;
        int i4;
        long l;
        int i8;
        int i5;
        long[] index;
        long[] lArr;
        int i3;
        int i2;
        StringBuilder sb;
        Object obj2 = prefix;
        final Object obj3 = postfix;
        final Object obj4 = truncated;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "truncated");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj2);
        i = 0;
        this_$iv = this;
        final int i17 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        if (0 <= i18) {
        } else {
            sb = stringBuilder;
            i10 = $this$maskEmptyOrDeleted$iv$iv$iv;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = this_$iv;
            i9 = j$iv$iv;
            lArr = keys;
            index = v$iv;
            i7 = limit;
            this_$iv = i;
            sb2.append(obj3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2<? super Long, ? super Long, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv;
        Object valueOf;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int index;
        int i;
        int i5;
        int this_$iv;
        Object index2;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        int i8;
        int $i$a$BuildStringLongLongMap$joinToString$2;
        int i2;
        long l2;
        int i6;
        long l;
        int i7;
        int i3;
        Object obj = prefix;
        final Object obj2 = postfix;
        final Object obj3 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj2, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        Intrinsics.checkNotNullParameter(obj3, "transform");
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        sb.append(obj);
        index2 = this;
        final int i17 = 0;
        long[] metadata = obj4.metadata;
        final int i18 = i9;
        $i$f$joinToString += -2;
        if (0 <= i10) {
        } else {
            $i$a$BuildStringLongLongMap$joinToString$2 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index2;
            i4 = j$iv$iv;
            index = limit;
            this_$iv = invoke;
            sb.append(obj2);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, Function2<? super Long, ? super Long, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        String valueOf;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i;
        StringBuilder stringBuilder;
        int i8;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i4;
        int i6;
        int i2;
        StringBuilder sb;
        long l;
        int i3;
        long l2;
        int i7;
        int i5;
        String truncated$iv;
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
        final int i15 = 0;
        final int i16 = 0;
        long[] metadata = obj5.metadata;
        final int i17 = i9;
        $i$f$joinToString += -2;
        if (0 <= i10) {
        } else {
            truncated$iv = valueOf;
            i2 = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv = j$iv$iv$iv;
            i = limit;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, Function2<? super Long, ? super Long, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i3;
        int i5;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i2;
        long l2;
        int i4;
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
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            sb2.append(obj3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, Function2<? super Long, ? super Long, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i4;
        int i3;
        int $i$f$joinToString;
        StringBuilder sb;
        long l2;
        int i;
        long l;
        int i2;
        int i5;
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

    public final String joinToString(java.lang.CharSequence separator, Function2<? super Long, ? super Long, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i4;
        int i5;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i2;
        long l2;
        int i;
        int i3;
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

    public final String joinToString(Function2<? super Long, ? super Long, ? extends java.lang.CharSequence> transform) {
        int separator$iv;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i6;
        int i;
        int i4;
        StringBuilder sb;
        long l2;
        int i5;
        long l;
        int i2;
        int i3;
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
            separator$iv2 = separator$iv;
            i4 = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
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
        int bitCount$iv$iv;
        int value;
        int i3;
        long[] keys;
        Object v$iv;
        long[] values;
        Object v$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i5;
        int i;
        Object this_$iv;
        int i2;
        long l2;
        int key;
        long[] lArr2;
        int $i$f$forEach;
        int i4;
        long l3;
        long[] lArr;
        long l;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append('{');
        bitCount$iv$iv = 0;
        value = this;
        final int i16 = 0;
        final long[] metadata = obj.metadata;
        length += -2;
        if (0 <= i17) {
        } else {
            this_$iv = value;
            $i$f$forEach = i3;
            lArr2 = keys;
            lArr = values;
            v$iv = this;
            i2 = bitCount$iv$iv;
        }
        String string = append.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(string, "s.append('}').toString()");
        return string;
    }
}
