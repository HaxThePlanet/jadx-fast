package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0016\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J:\u0010\u0010\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0018\u001a\u00020\u0011J:\u0010\u0018\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0014H\u0086\u0002J\u0008\u0010\u001a\u001a\u00020\u0004H\u0007J:\u0010\u001a\u001a\u00020\u00042!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0087\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0013\u0010\u001b\u001a\u00020\u00112\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0014H\u0080\u0008¢\u0006\u0002\u0008\u001eJ\t\u0010\u001f\u001a\u00020\u0014H\u0086\u0008J:\u0010\u001f\u001a\u00020\u00142!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J:\u0010 \u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0004\u0012\u00020!0\u0013H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J:\u0010#\u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020!0\u0013H\u0081\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0008\u0010%\u001a\u00020\u0004H\u0016J\u0006\u0010&\u001a\u00020\u0011J\u0006\u0010'\u001a\u00020\u0011J:\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020\u00042\u0008\u0008\u0002\u0010/\u001a\u00020+H\u0007JT\u0010(\u001a\u00020)2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u0010,\u001a\u00020+2\u0008\u0008\u0002\u0010-\u001a\u00020+2\u0008\u0008\u0002\u0010.\u001a\u00020\u00042\u0008\u0008\u0002\u0010/\u001a\u00020+2\u0014\u0008\u0004\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020+0\u0013H\u0087\u0008ø\u0001\u0000J\u0006\u00101\u001a\u00020\u0011J\u0008\u00102\u001a\u00020)H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0018\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000b\u0010\u0002R\u0018\u0010\u000c\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\r\u0010\u0002R\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0008\u0082\u0001\u00013\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u00064", d2 = {"Landroidx/collection/LongSet;", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "metadata", "getMetadata$annotations", "size", "getSize", "all", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "element", "any", "contains", "count", "equals", "other", "findElementIndex", "findElementIndex$collection", "first", "forEach", "", "block", "forEachIndex", "index", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableLongSet;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LongSet {

    public int _capacity;
    public int _size;
    public long[] elements;
    public long[] metadata;
    private LongSet() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = LongSetKt.getEmptyLongArray();
    }

    public LongSet(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static void getElements$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public static String joinToString$default(androidx.collection.LongSet longSet, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, int i7, Object object8) {
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
            return longSet.joinToString(obj2, obj3, obj4, obj5, obj8);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public static String joinToString$default(androidx.collection.LongSet $this, java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1 transform, int i8, Object object9) {
        String separator2;
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
        int i;
        long l;
        int i4;
        long l2;
        int i2;
        int i3;
        Object obj29;
        int obj30;
        int obj32;
        int obj33;
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
            invoke = 0;
            this_$iv = $this;
            final int i18 = 0;
            final String obj26 = prefix2;
            long[] prefix3 = obj2.metadata;
            final int obj27 = i11;
            $i$f$joinToString += -2;
            if (0 <= i12) {
            } else {
                obj32 = $this$maskEmptyOrDeleted$iv$iv$iv;
                obj29 = this_$iv;
                obj30 = j$iv$iv;
                this_$iv = invoke;
                sb.append(postfix2);
            }
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        UnsupportedOperationException separator3 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw separator3;
    }

    public final boolean all(Function1<? super Long, Boolean> predicate) {
        int i$iv$iv;
        int cmp;
        long booleanValue;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i3;
        int i4;
        int i5;
        long slot$iv$iv;
        long cmp2;
        int i;
        long l;
        int i2;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        int i6 = 0;
        final Object obj2 = this;
        final int i7 = 0;
        final int i8 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            i5 = 1;
        }
        return i5;
    }

    public final boolean any() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final boolean any(Function1<? super Long, Boolean> predicate) {
        int i$iv$iv;
        int cmp;
        long booleanValue;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i2;
        int i3;
        int i4;
        long slot$iv$iv;
        long cmp2;
        int i5;
        long l;
        int i;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        int i6 = 0;
        final Object obj2 = this;
        final int i7 = 0;
        final int i8 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            i4 = 0;
        }
        return i4;
    }

    public final boolean contains(long element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex$iv;
        int i;
        int i9;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i3;
        int i4;
        int i7;
        int i13;
        long l;
        int i2;
        int i5;
        int i12;
        int i6;
        int i8;
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
            i11 = 1;
            while (Long.compare(i26, i35) != 0) {
                $this$hasNext$iv$iv = i11;
                i3 = 0;
                i5 = 0;
                int i29 = m$iv;
                i7 = 0;
                m$iv = $this$next$iv$iv;
                i31 = 0;
                i35 = 0;
                i11 = 1;
                $this$hasNext$iv$iv = i10;
            }
            $this$hasNext$iv$iv = i10;
            int i28 = i8;
            i3 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i & _capacity;
            m$iv2 = i12;
            $i$f$hash = i6;
            long[] metadata = obj.metadata;
            $this$next$iv$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            l4 >>>= i33;
            i16 |= i13;
            i3 = 0;
            long l5 = 72340172838076673L;
            i34 ^= i9;
            l = -9187201950435737472L;
            i18 &= l;
            i3 = 0;
            i5 = 0;
            i29 = m$iv;
            i7 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i11;
        }
        if (i9 >= 0) {
            i10 = i11;
        }
        return i10;
    }

    public final int count() {
        return this._size;
    }

    public final int count(Function1<? super Long, Boolean> predicate) {
        int cmp;
        int booleanValue;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i3;
        int i5;
        int $i$f$count;
        int count;
        long l;
        int i4;
        int i;
        int i2;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        booleanValue = 0;
        final Object obj2 = this;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$count = cmp;
            count = booleanValue;
        }
        return count;
    }

    public boolean equals(Object other) {
        int cmp;
        Object contains;
        int i8;
        int i3;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int value$iv$iv$iv;
        int i6;
        int i4;
        Object obj;
        long l;
        int i7;
        int i2;
        int i;
        int i5;
        final Object obj2 = this;
        final Object obj3 = other;
        cmp = 1;
        if (obj3 == obj2) {
            return cmp;
        }
        i8 = 0;
        if (obj3 instanceof LongSet == null) {
            return i8;
        }
        if (obj4._size != obj2._size) {
            return i8;
        }
        contains = this;
        final int i16 = 0;
        final long[] metadata = obj6.metadata;
        length += -2;
        if (0 <= i17) {
        } else {
            i4 = cmp;
            obj = contains;
            i2 = i3;
        }
        return i4;
    }

    public final int findElementIndex$collection(long element) {
        int m;
        int m2;
        int $i$f$hash;
        int $i$f$h1;
        int probeIndex;
        int i12;
        int i8;
        int $this$next$iv;
        int i;
        int i6;
        int i2;
        int i11;
        int i5;
        long l;
        int i9;
        int i13;
        int i4;
        int i7;
        int i10;
        int i14;
        int i3;
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
                i6 = 0;
                i13 = 0;
                i8 = i38 & _capacity;
                int i30 = m2;
                i11 = 0;
                m2 = $this$next$iv;
                i32 = 0;
                i36 = 0;
                i4 = 0;
            }
            i4 = 0;
            int i29 = i14;
            i = 0;
            $i$f$h1 = i12 & _capacity;
            m = i7;
            $i$f$hash = i10;
            long[] metadata = obj.metadata;
            $this$next$iv = 0;
            int i31 = $i$f$h1 >> 3;
            i33 <<= 3;
            l4 >>>= i34;
            i17 |= i5;
            i6 = 0;
            long l5 = 72340172838076673L;
            i35 ^= i8;
            l = -9187201950435737472L;
            i19 &= l;
            i6 = 0;
            i13 = 0;
            i8 = i38 & _capacity;
            i30 = m2;
            i11 = 0;
            m2 = $this$next$iv;
            i4 = 1;
        }
        return i8;
    }

    public final long first() {
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i2;
        int j$iv$iv;
        int i3;
        long l;
        int i;
        final int i4 = 0;
        Object obj = this;
        int i5 = 0;
        final int i6 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i7) {
        } else {
        }
        NoSuchElementException this_$iv = new NoSuchElementException("The LongSet is empty");
        throw this_$iv;
    }

    public final long first(Function1<? super Long, Boolean> predicate) {
        int cmp;
        Object booleanValue;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i3;
        int i5;
        int $i$f$first;
        Object obj;
        long l;
        int i;
        int i2;
        int i4;
        final Object obj2 = predicate;
        Intrinsics.checkNotNullParameter(obj2, "predicate");
        booleanValue = this;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$first = cmp;
            obj = booleanValue;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Could not find a match");
        throw noSuchElementException;
    }

    public final void forEach(Function1<? super Long, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int valueOf;
        int j$iv;
        int i2;
        int i3;
        long l;
        int i4;
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

    public final void forEachIndex(Function1<? super Integer, Unit> block) {
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

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int hash;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        int j$iv$iv;
        int i;
        int i2;
        long l;
        int i3;
        int i5;
        int i6;
        hash = 0;
        final Object obj = this;
        final int i7 = 0;
        final int i8 = 0;
        final long[] metadata = obj2.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
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
        return LongSet.joinToString$default(this, 0, 0, 0, 0, 0, 31, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return LongSet.joinToString$default(this, charSequence, 0, 0, 0, 0, 30, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return LongSet.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 28, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return LongSet.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 24, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return LongSet.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 16, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated) {
        int i9;
        Object obj;
        StringBuilder stringBuilder;
        int index2;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i4;
        int this_$iv;
        int j$iv$iv;
        int i$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i5;
        int i7;
        int i6;
        int i2;
        long l;
        int i3;
        int i;
        StringBuilder index;
        int i8;
        final Object obj2 = separator;
        obj = prefix;
        final Object obj3 = postfix;
        final Object obj4 = truncated;
        Intrinsics.checkNotNullParameter(obj2, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "truncated");
        stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        sb.append(obj);
        i4 = 0;
        this_$iv = this;
        final int i16 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        if (0 <= i17) {
        } else {
            i9 = limit;
            index = stringBuilder;
            i6 = $this$maskEmptyOrDeleted$iv$iv$iv;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = this_$iv;
            i5 = j$iv$iv;
            this_$iv = i4;
            sb.append(obj3);
        }
        String string = index.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super Long, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int $i$f$joinToString;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int index;
        int i2;
        int i5;
        int this_$iv;
        Object index2;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i8;
        int i3;
        int $i$a$BuildStringLongSet$joinToString$2;
        int i7;
        long l;
        int i;
        int i6;
        int i4;
        Object obj = prefix;
        final Object obj2 = postfix;
        final Object obj3 = truncated;
        final Object obj4 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj, "prefix");
        Intrinsics.checkNotNullParameter(obj2, "postfix");
        Intrinsics.checkNotNullParameter(obj3, "truncated");
        Intrinsics.checkNotNullParameter(obj4, "transform");
        StringBuilder stringBuilder = new StringBuilder();
        final StringBuilder sb = stringBuilder;
        sb.append(obj);
        index2 = this;
        final int i17 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        final int i18 = i10;
        if (0 <= i9) {
        } else {
            $i$a$BuildStringLongSet$joinToString$2 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index2;
            i8 = j$iv$iv;
            index = limit;
            this_$iv = invoke;
            sb.append(obj2);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, Function1<? super Long, ? extends java.lang.CharSequence> transform) {
        int invoke;
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i4;
        StringBuilder stringBuilder;
        int i2;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int i;
        int i3;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i7;
        int i6;
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
        final int i14 = 0;
        final int i15 = 0;
        long[] metadata = obj5.metadata;
        final int i16 = i8;
        $i$f$joinToString2 += -2;
        if (0 <= i9) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            i4 = limit;
            sb2.append(obj2);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, Function1<? super Long, ? extends java.lang.CharSequence> transform) {
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
        int i;
        int i5;
        int i4;
        final Object obj = separator;
        Object obj2 = prefix;
        final Object obj3 = postfix;
        final Object obj4 = transform;
        Intrinsics.checkNotNullParameter(obj, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "transform");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj2);
        index$iv = 0;
        final Object obj5 = this;
        final int i13 = 0;
        final int i14 = 0;
        long[] metadata = obj6.metadata;
        final int i15 = i6;
        $i$f$joinToString2 += -2;
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

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, Function1<? super Long, ? extends java.lang.CharSequence> transform) {
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
        int i4;
        int i;
        final Object obj = separator;
        Object obj2 = prefix;
        final Object obj3 = transform;
        Intrinsics.checkNotNullParameter(obj, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "transform");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj2);
        index$iv = 0;
        final Object obj4 = this;
        final int i13 = 0;
        final int i14 = 0;
        long[] metadata = obj5.metadata;
        final int i15 = i6;
        $i$f$joinToString2 += -2;
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

    public final String joinToString(java.lang.CharSequence separator, Function1<? super Long, ? extends java.lang.CharSequence> transform) {
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
        final Object obj = separator;
        final Object obj2 = transform;
        Intrinsics.checkNotNullParameter(obj, "separator");
        Intrinsics.checkNotNullParameter(obj2, "transform");
        final String str3 = "";
        String str4 = str3;
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append((CharSequence)str4);
        index$iv = 0;
        final Object obj3 = this;
        final int i13 = 0;
        final int i14 = 0;
        final int i15 = i6;
        long[] $i$f$joinToString2 = obj4.metadata;
        final String str7 = str4;
        prefix$iv += -2;
        if (0 <= i7) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv;
            sb = stringBuilder;
            $this$maskEmptyOrDeleted$iv$iv$iv$iv2 = j$iv$iv$iv;
            sb2.append((CharSequence)str3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(Function1<? super Long, ? extends java.lang.CharSequence> transform) {
        int m$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
        int stringBuilder;
        int j$iv$iv$iv;
        int index$iv;
        long slot$iv$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv$iv;
        int i;
        int i5;
        int $i$f$joinToString;
        StringBuilder sb;
        long l;
        int i3;
        int i2;
        int i4;
        final Object obj = transform;
        Intrinsics.checkNotNullParameter(obj, "transform");
        final String str3 = "";
        String str4 = str3;
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append((CharSequence)str4);
        index$iv = 0;
        final Object obj2 = this;
        final int i13 = 0;
        final int i14 = 0;
        final int i15 = i6;
        long[] $i$f$joinToString2 = obj3.metadata;
        final String str7 = str4;
        prefix$iv += -2;
        if (0 <= i7) {
        } else {
            $i$f$joinToString = $this$maskEmptyOrDeleted$iv$iv$iv$iv2;
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
        return LongSet.joinToString$default(this, 0, (CharSequence)"[", (CharSequence)"]", 0, 0, 25, 0);
    }
}
