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
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J&\u0010\u0018\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0006\u0010\u001d\u001a\u00020\u0019J&\u0010\u001d\u001a\u00020\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0011\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cH\u0086\u0002J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001cJ\u0013\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00028\u0000¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0005J&\u0010$\u001a\u00020\u00052\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190\u001bH\u0086\u0008ø\u0001\u0000J\u0013\u0010%\u001a\u00020\u00192\u0008\u0010&\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001cH\u0080\u0008¢\u0006\u0002\u0008(JD\u0010)\u001a\u00020*26\u0010+\u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020*0\u001bH\u0086\u0008ø\u0001\u0000J/\u0010.\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(0\u0012\u0004\u0012\u00020*0/H\u0081\u0008ø\u0001\u0000J/\u00101\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(\u001f\u0012\u0004\u0012\u00020*0/H\u0086\u0008ø\u0001\u0000J/\u00102\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020*0/H\u0086\u0008ø\u0001\u0000J\u0018\u00103\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001f\u001a\u00020\u001cH\u0086\u0002¢\u0006\u0002\u00104J\u001b\u00105\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u00106\u001a\u00028\u0000¢\u0006\u0002\u00107J'\u00108\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u001c2\u000c\u00106\u001a\u0008\u0012\u0004\u0012\u00028\u000009H\u0086\u0008ø\u0001\u0000¢\u0006\u0002\u0010:J\u0008\u0010;\u001a\u00020\u0005H\u0016J\u0006\u0010<\u001a\u00020\u0019J\u0006\u0010=\u001a\u00020\u0019J:\u0010>\u001a\u00020?2\u0008\u0008\u0002\u0010@\u001a\u00020A2\u0008\u0008\u0002\u0010B\u001a\u00020A2\u0008\u0008\u0002\u0010C\u001a\u00020A2\u0008\u0008\u0002\u0010D\u001a\u00020\u00052\u0008\u0008\u0002\u0010E\u001a\u00020AH\u0007Jx\u0010>\u001a\u00020?2\u0008\u0008\u0002\u0010@\u001a\u00020A2\u0008\u0008\u0002\u0010B\u001a\u00020A2\u0008\u0008\u0002\u0010C\u001a\u00020A2\u0008\u0008\u0002\u0010D\u001a\u00020\u00052\u0008\u0008\u0002\u0010E\u001a\u00020A28\u0008\u0004\u0010F\u001a2\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008,\u0012\u0008\u0008-\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u00020A0\u001bH\u0087\u0008ø\u0001\u0000J\u0006\u0010G\u001a\u00020\u0019J\u0008\u0010H\u001a\u00020?H\u0016R\u0018\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0003R\u0018\u0010\u0007\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0003R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0018\u0010\u000c\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000e\u0010\u0003R\u0018\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0011\u0010\u0003R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000bR\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\u0017\u0012\u0004\u0008\u0016\u0010\u0003\u0082\u0001\u0001I\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006J", d2 = {"Landroidx/collection/FloatObjectMap;", "V", "", "()V", "_capacity", "", "get_capacity$collection$annotations", "_size", "get_size$collection$annotations", "capacity", "getCapacity", "()I", "keys", "", "getKeys$annotations", "metadata", "", "getMetadata$annotations", "size", "getSize", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "all", "", "predicate", "Lkotlin/Function2;", "", "any", "contains", "key", "containsKey", "containsValue", "value", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findKeyIndex", "findKeyIndex$collection", "forEach", "", "block", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function1;", "index", "forEachKey", "forEachValue", "get", "(F)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(FLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(FLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableFloatObjectMap;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class FloatObjectMap<V>  {

    public int _capacity;
    public int _size;
    public float[] keys;
    public long[] metadata;
    public Object[] values;
    private FloatObjectMap() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = FloatSetKt.getEmptyFloatArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public FloatObjectMap(DefaultConstructorMarker defaultConstructorMarker) {
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

    public static String joinToString$default(androidx.collection.FloatObjectMap floatObjectMap, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, int i7, Object object8) {
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
            return floatObjectMap.joinToString(obj2, obj3, obj4, obj5, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public static String joinToString$default(androidx.collection.FloatObjectMap $this, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2 transform, int i8, Object object9) {
        String separator2;
        String prefix2;
        int m$iv$iv;
        String postfix2;
        int limit2;
        String truncated2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        Object this_$iv;
        int j$iv$iv;
        long slot$iv$iv;
        int i5;
        long l;
        int i4;
        float f;
        int i2;
        int i;
        String separator3;
        Object obj30;
        int obj31;
        int obj33;
        int obj34;
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
            i3 = 0;
            this_$iv = $this;
            final int i19 = 0;
            final String obj27 = prefix2;
            long[] prefix3 = obj2.metadata;
            final int obj28 = i12;
            $i$f$joinToString += -2;
            if (0 <= i13) {
            } else {
                separator3 = separator2;
                obj33 = $this$maskEmptyOrDeleted$iv$iv$iv;
                obj30 = this_$iv;
                obj31 = j$iv$iv;
                this_$iv = i3;
                sb.append(postfix2);
            }
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw unsupportedOperationException;
    }

    public final boolean all(Function2<? super Float, ? super V, Boolean> predicate) {
        int $i$f$all;
        int i$iv$iv;
        int cmp;
        int i5;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i7;
        int i4;
        int i;
        long slot$iv$iv;
        long cmp2;
        int i3;
        int i6;
        int i2;
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
            i = 1;
        }
        return i;
    }

    public final boolean any() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final boolean any(Function2<? super Float, ? super V, Boolean> predicate) {
        int $i$f$any;
        int i$iv$iv;
        int cmp2;
        int i7;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i3;
        int i6;
        int i;
        long slot$iv$iv;
        long cmp;
        int i4;
        int i2;
        int i5;
        int $i$f$any2;
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
            i = 0;
        }
        return i;
    }

    public final boolean contains(float key) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i3;
        int i12;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i2;
        int i8;
        int i7;
        int i6;
        long l;
        int i4;
        int i10;
        int i9;
        int i5;
        int i;
        int i11;
        int i13;
        int numberOfTrailingZeros;
        final Object obj = this;
        m$iv = 0;
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
            i11 = 0;
            i13 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i13;
                i2 = 0;
                i10 = 0;
                if (Float.compare(f, key) == 0) {
                } else {
                }
                $this$next$iv$iv = i11;
                int i29 = m$iv2;
                i7 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i11 = 0;
                i13 = 1;
                $this$hasNext$iv$iv = i11;
                $this$next$iv$iv = i13;
            }
            $this$hasNext$iv$iv = i11;
            int i28 = i;
            i2 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i3 & _capacity;
            m$iv = i9;
            $i$f$hash = i5;
            long[] metadata = obj.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i6;
            i2 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i12;
            l = -9187201950435737472L;
            i18 &= l;
            i2 = 0;
            i10 = 0;
            if (Float.compare(f, key) == 0) {
            } else {
            }
            $this$next$iv$iv = i11;
            i29 = m$iv2;
            i7 = 0;
            m$iv2 = $this$next$iv$iv;
            $this$next$iv$iv = i13;
            $this$hasNext$iv$iv = i13;
        }
        if (i12 >= 0) {
            i11 = i13;
        }
        return i11;
    }

    public final boolean containsKey(float key) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i6;
        int i13;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i3;
        int i8;
        int i5;
        int i9;
        long l;
        int i4;
        int i;
        int i2;
        int i12;
        int i7;
        int i10;
        int i11;
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
            i10 = 0;
            i11 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i11;
                i3 = 0;
                i = 0;
                if (Float.compare(f, key) == 0) {
                } else {
                }
                $this$next$iv$iv = i10;
                int i29 = m$iv;
                i5 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i10 = 0;
                i11 = 1;
                $this$hasNext$iv$iv = i10;
                $this$next$iv$iv = i11;
            }
            $this$hasNext$iv$iv = i10;
            int i28 = i7;
            i3 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i6 & _capacity;
            m$iv2 = i2;
            $i$f$hash = i12;
            long[] metadata = obj.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i9;
            i3 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i13;
            l = -9187201950435737472L;
            i18 &= l;
            i3 = 0;
            i = 0;
            if (Float.compare(f, key) == 0) {
            } else {
            }
            $this$next$iv$iv = i10;
            i29 = m$iv;
            i5 = 0;
            m$iv = $this$next$iv$iv;
            $this$next$iv$iv = i11;
            $this$hasNext$iv$iv = i11;
        }
        if (i13 >= 0) {
            i10 = i11;
        }
        return i10;
    }

    public final boolean containsValue(V value) {
        int i$iv$iv;
        int i;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        Object obj2;
        int i3;
        Object obj;
        int j$iv$iv;
        int value$iv$iv$iv;
        int i6;
        long l;
        int i4;
        int i5;
        int i2;
        int i7;
        boolean equal;
        final Object obj3 = this;
        final int i8 = 0;
        final int i9 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i10) {
        } else {
            obj2 = value;
            i4 = 0;
        }
        return i4;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function2<? super Float, ? super V, Boolean> predicate) {
        int cmp;
        int i5;
        Object booleanValue;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i3;
        int $i$f$count;
        int count;
        long l;
        int i4;
        int i6;
        int i2;
        Object this_$iv;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        i5 = 0;
        booleanValue = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$count = cmp;
            this_$iv = booleanValue;
            count = i5;
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
        int i3;
        int cmp;
        int i;
        long l;
        int i2;
        int i5;
        int i4;
        equal = other;
        $this$maskEmptyOrDeleted$iv$iv$iv = 1;
        obj = this;
        if (equal == obj) {
            return $this$maskEmptyOrDeleted$iv$iv$iv;
        }
        j$iv$iv = 0;
        if (equal instanceof FloatObjectMap == null) {
            return j$iv$iv;
        }
        if ((FloatObjectMap)equal.getSize() != obj.getSize()) {
            return j$iv$iv;
        }
        Object obj7 = this;
        final int i13 = 0;
        final long[] metadata = obj8.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            i = $this$maskEmptyOrDeleted$iv$iv$iv;
            i3 = $i$f$isFull;
        }
        return i;
    }

    public final int findKeyIndex$collection(float key) {
        int m2;
        int m;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex;
        int i10;
        int i;
        int $this$hasNext$iv;
        int $this$next$iv;
        int i9;
        int i5;
        int i12;
        int i3;
        int i4;
        long l;
        int i15;
        int i11;
        int i14;
        int i8;
        int i6;
        int i7;
        int i2;
        int i13;
        int numberOfTrailingZeros;
        final Object obj = this;
        m2 = 0;
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
            int i37 = 0;
            i13 = 1;
            while (Long.compare(i28, i37) != 0) {
                $this$hasNext$iv = i13;
                i5 = 0;
                i11 = 0;
                i = i41 & _capacity;
                if (Float.compare(f, key) == 0) {
                }
                int i31 = m;
                i3 = 0;
                m = $this$next$iv;
                i33 = 0;
                i37 = 0;
                i13 = 1;
                $this$hasNext$iv = i2;
                i2 = i13;
            }
            $this$hasNext$iv = i2;
            int i29 = i6;
            i9 = 0;
            $i$f$h1 = i10 & _capacity;
            m2 = i14;
            $i$f$hash = i8;
            long[] metadata = obj.metadata;
            $this$next$iv = 0;
            int i32 = $i$f$h1 >> 3;
            i34 <<= 3;
            l3 >>>= i35;
            i18 |= i4;
            i5 = 0;
            long l4 = 72340172838076673L;
            i36 ^= i;
            l = -9187201950435737472L;
            i20 &= l;
            i5 = 0;
            i11 = 0;
            i = i41 & _capacity;
            if (Float.compare(f, key) == 0) {
            }
            i31 = m;
            i3 = 0;
            m = $this$next$iv;
            i2 = i13;
            $this$hasNext$iv = i13;
        }
        return i;
    }

    public final void forEach(Function2<? super Float, ? super V, Unit> block) {
        Object obj;
        int cmp;
        float[] valueOf;
        int i$iv;
        long slot$iv;
        long j$iv;
        int i2;
        int i;
        int $i$f$forEach;
        float[] fArr;
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
            fArr = valueOf;
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

    public final void forEachKey(Function1<? super Float, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i;
        int i2;
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
        int i3;
        int j$iv;
        int i;
        int i5;
        long l;
        int i4;
        int i2;
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

    public final V get(float key) {
        Object obj;
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i10;
        int i8;
        int $this$hasNext$iv$iv;
        Object obj2;
        int $this$next$iv$iv;
        Object obj3;
        int i6;
        int i3;
        int i7;
        int i;
        long l;
        int i2;
        int i13;
        int i9;
        int i5;
        int i11;
        int i4;
        int i12;
        int numberOfTrailingZeros;
        Object obj4 = this;
        m$iv2 = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = obj4._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i35 = 0;
            i12 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i12;
                i6 = 0;
                i13 = 0;
                if (Float.compare(f, key) == 0) {
                }
                int i29 = m$iv;
                i7 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i12 = 1;
                $this$hasNext$iv$iv = i4;
                i4 = i12;
            }
            $this$hasNext$iv$iv = i4;
            int i27 = i11;
            i6 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i4) != 0) {
                break;
            } else {
            }
            obj2 = this;
            $i$f$h1 = i10 & _capacity;
            m$iv2 = i9;
            $i$f$hash = i5;
            long[] metadata = obj4.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i;
            i6 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i8;
            l = -9187201950435737472L;
            i18 &= l;
            i6 = 0;
            i13 = 0;
            if (Float.compare(f, key) == 0) {
            }
            i29 = m$iv;
            i7 = 0;
            m$iv = $this$next$iv$iv;
            i4 = i12;
            $this$hasNext$iv$iv = i12;
        }
        if (i8 >= 0) {
            obj = obj3.values[i8];
        } else {
            obj3 = this;
            obj = 0;
        }
        return obj;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final V getOrDefault(float key, V defaultValue) {
        int m$iv;
        int m$iv2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i11;
        int i8;
        int $this$hasNext$iv$iv;
        Object obj;
        int $this$next$iv$iv;
        int i9;
        int i6;
        int i7;
        int i;
        long l;
        int i5;
        int i10;
        int i4;
        int i2;
        int i12;
        int i3;
        int i13;
        int numberOfTrailingZeros;
        Object obj2 = this;
        m$iv = 0;
        int i19 = 0;
        i20 *= i23;
        $i$f$hash = i21 ^ i24;
        int i22 = 0;
        int _capacity = obj2._capacity;
        int i25 = 0;
        $i$f$h12 &= _capacity;
        probeIndex$iv = 0;
        while (/* condition */) {
            int i31 = 0;
            int i35 = 0;
            i13 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i13;
                i9 = 0;
                i10 = 0;
                if (Float.compare(f, key) == 0) {
                }
                int i29 = m$iv2;
                i7 = 0;
                m$iv2 = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i13 = 1;
                $this$hasNext$iv$iv = i3;
                i3 = i13;
            }
            $this$hasNext$iv$iv = i3;
            int i27 = i12;
            i9 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, i3) != 0) {
                break;
            } else {
            }
            obj = this;
            $i$f$h1 = i11 & _capacity;
            m$iv = i4;
            $i$f$hash = i2;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l3 >>>= i33;
            i16 |= i;
            i9 = 0;
            long l4 = 72340172838076673L;
            i34 ^= i8;
            l = -9187201950435737472L;
            i18 &= l;
            i9 = 0;
            i10 = 0;
            if (Float.compare(f, key) == 0) {
            }
            i29 = m$iv2;
            i7 = 0;
            m$iv2 = $this$next$iv$iv;
            i3 = i13;
            $this$hasNext$iv$iv = i13;
        }
        if (i8 >= 0) {
            return obj4.values[i8];
        }
        Object obj5 = this;
        return defaultValue;
    }

    public final V getOrElse(float key, Function0<? extends V> defaultValue) {
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
        int i2;
        int i6;
        Object this_$iv;
        int hash;
        long l;
        int i5;
        int i;
        Object obj;
        int i4;
        int i3;
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
        return FloatObjectMap.joinToString$default(this, 0, 0, 0, 0, 0, 31, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return FloatObjectMap.joinToString$default(this, charSequence, 0, 0, 0, 0, 30, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return FloatObjectMap.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 28, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return FloatObjectMap.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 24, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return FloatObjectMap.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 16, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated) {
        int key;
        int i$iv$iv;
        int i2;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i3;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i;
        int i5;
        int i4;
        int i6;
        long l;
        int key2;
        int i7;
        float f;
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
        i3 = 0;
        index = this;
        final int i13 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            sb = stringBuilder;
            i4 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index;
            i = j$iv$iv;
            i2 = limit;
            index = i3;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function2<? super Float, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv;
        int i6;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i2;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i5;
        int i;
        int i3;
        int i7;
        long l;
        int i4;
        int i8;
        int i9;
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
            i3 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index;
            i5 = j$iv$iv;
            i6 = limit;
            index = i2;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, Function2<? super Float, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int $i$a$BuildStringFloatObjectMap$joinToString$2$iv;
        int i2;
        int i;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i8;
        int i6;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i7;
        int i3;
        int i4;
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
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = i2;
            $i$a$BuildStringFloatObjectMap$joinToString$2$iv = limit;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, Function2<? super Float, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i5;
        int i4;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i3;
        int i;
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
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            sb2.append(obj3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, Function2<? super Float, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i3;
        int i;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i2;
        int i5;
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

    public final String joinToString(java.lang.CharSequence separator, Function2<? super Float, ? super V, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i;
        int i4;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i5;
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

    public final String joinToString(Function2<? super Float, ? super V, ? extends java.lang.CharSequence> transform) {
        int separator$iv2;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i3;
        int i4;
        int i5;
        StringBuilder sb;
        long l;
        int i;
        int i2;
        int i6;
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
            i5 = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
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
        int i;
        int bitCount$iv$iv;
        Object obj;
        Object str;
        int value;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i2;
        int i3;
        Object this_$iv;
        int i7;
        long l;
        int i4;
        int i5;
        int $i$f$forEach;
        int i6;
        float f;
        Object obj2;
        if (this.isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append2 = stringBuilder.append('{');
        bitCount$iv$iv = 0;
        obj = this;
        final int i18 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i19) {
        } else {
            this_$iv = obj;
            $i$f$forEach = value;
            i7 = bitCount$iv$iv;
        }
        String string = append2.append('}').toString();
        Intrinsics.checkNotNullExpressionValue(string, "s.append('}').toString()");
        return string;
    }
}
