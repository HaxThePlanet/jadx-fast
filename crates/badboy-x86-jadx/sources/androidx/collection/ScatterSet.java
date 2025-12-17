package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\"\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002:\u0001<B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J:\u0010\u0013\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u001a\u001a\u00020\u0014J:\u0010\u001a\u001a\u00020\u00142!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cJ\u0016\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001eJ\u0008\u0010\u001f\u001a\u00020\u0005H\u0007J:\u0010\u001f\u001a\u00020\u00052!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0087\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0013\u0010 \u001a\u00020\u00142\u0008\u0010!\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00028\u0000H\u0080\u0008¢\u0006\u0004\u0008#\u0010$J\u000e\u0010%\u001a\u00028\u0000H\u0086\u0008¢\u0006\u0002\u0010&J?\u0010%\u001a\u00028\u00002!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010'JA\u0010(\u001a\u0004\u0018\u00018\u00002!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010'J:\u0010)\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(\u0019\u0012\u0004\u0012\u00020*0\u0016H\u0086\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J:\u0010,\u001a\u00020*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0017\u0012\u0008\u0008\u0018\u0012\u0004\u0008\u0008(-\u0012\u0004\u0012\u00020*0\u0016H\u0081\u0008ø\u0001\u0000\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0001J\u0008\u0010.\u001a\u00020\u0005H\u0016J\u0006\u0010/\u001a\u00020\u0014J\u0006\u00100\u001a\u00020\u0014JR\u00101\u001a\u0002022\u0008\u0008\u0002\u00103\u001a\u0002042\u0008\u0008\u0002\u00105\u001a\u0002042\u0008\u0008\u0002\u00106\u001a\u0002042\u0008\u0008\u0002\u00107\u001a\u00020\u00052\u0008\u0008\u0002\u00108\u001a\u0002042\u0016\u0008\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u000204\u0018\u00010\u0016H\u0007J\u0006\u0010:\u001a\u00020\u0014J\u0008\u0010;\u001a\u000202H\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\"\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\n\n\u0002\u0010\r\u0012\u0004\u0008\u000c\u0010\u0003R\u0018\u0010\u000e\u001a\u00020\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0003R\u0011\u0010\u0011\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\t\u0082\u0001\u0001=\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006>", d2 = {"Landroidx/collection/ScatterSet;", "E", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "[Ljava/lang/Object;", "metadata", "", "getMetadata$annotations", "size", "getSize", "all", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "any", "asSet", "", "contains", "(Ljava/lang/Object;)Z", "count", "equals", "other", "findElementIndex", "findElementIndex$collection", "(Ljava/lang/Object;)I", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "forEach", "", "block", "forEachIndex", "index", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "SetWrapper", "Landroidx/collection/MutableScatterSet;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ScatterSet<E>  {

    public int _capacity;
    public int _size;
    public Object[] elements;
    public long[] metadata;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0000\u0008\u0090\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00082\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0008\u0010\u000e\u001a\u00020\u0008H\u0016J\u000f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/collection/ScatterSet$SetWrapper;", "", "(Landroidx/collection/ScatterSet;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "isEmpty", "iterator", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public class SetWrapper implements Set<E>, KMappedMarker {

        final androidx.collection.ScatterSet<E> this$0;
        public SetWrapper(androidx.collection.ScatterSet this$0) {
            this.this$0 = this$0;
            super();
        }

        public boolean add(E e) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public boolean addAll(Collection<? extends E> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Set
        public void clear() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Set
        public boolean contains(Object element) {
            return this.this$0.contains(element);
        }

        public boolean containsAll(Collection<? extends Object> elements) {
            Object next;
            Object obj;
            int i;
            boolean contains;
            Intrinsics.checkNotNullParameter(elements, "elements");
            final int i3 = 0;
            final Iterator iterator = (Iterable)elements.iterator();
            for (Object next : iterator) {
                i = 0;
            }
            return 1;
        }

        @Override // java.util.Set
        public int getSize() {
            return this$0._size;
        }

        @Override // java.util.Set
        public boolean isEmpty() {
            return this.this$0.isEmpty();
        }

        public Iterator<E> iterator() {
            ScatterSet.SetWrapper.iterator.1 anon = new ScatterSet.SetWrapper.iterator.1(this.this$0, 0);
            return SequencesKt.iterator((Function2)anon);
        }

        @Override // java.util.Set
        public boolean remove(Object object) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Set
        public final int size() {
            return getSize();
        }

        @Override // java.util.Set
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection)this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray((Collection)this, tArr);
        }
    }
    private ScatterSet() {
        super();
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    public ScatterSet(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public static void getElements$annotations() {
    }

    public static void getMetadata$annotations() {
    }

    public static String joinToString$default(androidx.collection.ScatterSet scatterSet, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, java.lang.CharSequence charSequence4, int i5, java.lang.CharSequence charSequence6, Function1 function17, int i8, Object object9) {
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
            obj9 = i8 &= 32 != 0 ? obj7 : function17;
            return scatterSet.joinToString(obj2, obj3, obj4, obj5, obj6, obj9);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        throw obj1;
    }

    public final boolean all(Function1<? super E, Boolean> predicate) {
        int i$iv$iv;
        int cmp;
        long l2;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i;
        int i5;
        int i4;
        long slot$iv$iv;
        long l;
        int i3;
        int i2;
        boolean booleanValue;
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
            i4 = 1;
        }
        return i4;
    }

    public final boolean any() {
        int i;
        i = this._size != 0 ? 1 : 0;
        return i;
    }

    public final boolean any(Function1<? super E, Boolean> predicate) {
        int i$iv$iv;
        int cmp;
        long l;
        int j$iv$iv;
        long value$iv$iv$iv;
        int i;
        int i5;
        int i4;
        long slot$iv$iv;
        long l2;
        int i2;
        int i3;
        boolean booleanValue;
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

    public final Set<E> asSet() {
        ScatterSet.SetWrapper setWrapper = new ScatterSet.SetWrapper(this);
        return (Set)setWrapper;
    }

    public final boolean contains(E element) {
        int m$iv2;
        int m$iv;
        int $i$f$hash;
        int i3;
        int i13;
        int i8;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex$iv;
        int i14;
        int i5;
        int $this$hasNext$iv$iv;
        int $this$next$iv$iv;
        int i9;
        int i4;
        int i10;
        int i6;
        long l;
        int i;
        int i11;
        int i2;
        int i7;
        int i12;
        int numberOfTrailingZeros;
        final Object obj = element;
        final Object obj2 = this;
        m$iv2 = 0;
        int i16 = 0;
        if (obj != null) {
            i8 = obj.hashCode();
        } else {
            i8 = 0;
        }
        i8 *= i22;
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
            i12 = 1;
            while (Long.compare(i25, i35) != 0) {
                $this$hasNext$iv$iv = i12;
                i9 = 0;
                i7 = 0;
                int i28 = m$iv;
                i6 = 0;
                m$iv = $this$next$iv$iv;
                i30 = 0;
                i35 = 0;
                i12 = 1;
                $this$hasNext$iv$iv = 0;
            }
            $this$hasNext$iv$iv = 0;
            int i27 = i3;
            i9 = 0;
            if (Long.compare($this$maskEmpty$iv$iv, numberOfTrailingZeros) != 0) {
                break;
            } else {
            }
            $i$f$h1 = i14 & _capacity;
            $i$f$h2 = i4;
            m$iv2 = i11;
            $i$f$hash = i2;
            long[] metadata = obj2.metadata;
            $this$next$iv$iv = 0;
            int i29 = $i$f$h1 >> 3;
            i31 <<= 3;
            i19 |= i33;
            i9 = 0;
            i4 = i42;
            long l6 = 72340172838076673L;
            i34 ^= i5;
            l = -9187201950435737472L;
            i15 &= l;
            i9 = 0;
            i7 = 0;
            i28 = m$iv;
            i6 = 0;
            m$iv = $this$next$iv$iv;
            $this$hasNext$iv$iv = i12;
        }
        i13 = i5 >= 0 ? i12 : 0;
        return i13;
    }

    public final int count() {
        return getSize();
    }

    public final int count(Function1<? super E, Boolean> predicate) {
        int cmp;
        int i4;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i2;
        int i5;
        int $i$f$count;
        int count;
        long l;
        int i3;
        int i;
        int i6;
        boolean booleanValue;
        final Object obj = predicate;
        Intrinsics.checkNotNullParameter(obj, "predicate");
        i4 = 0;
        final Object obj2 = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj3.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$count = cmp;
            count = i4;
        }
        return count;
    }

    public boolean equals(Object other) {
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i2;
        int j$iv$iv;
        Object $i$f$isFull;
        int i$iv$iv;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        Object obj;
        int cmp;
        int i4;
        long l;
        int i3;
        int i;
        boolean contains;
        final Object obj2 = other;
        $this$maskEmptyOrDeleted$iv$iv$iv = 1;
        i2 = this;
        if (obj2 == i2) {
            return $this$maskEmptyOrDeleted$iv$iv$iv;
        }
        j$iv$iv = 0;
        if (obj2 instanceof ScatterSet == null) {
            return j$iv$iv;
        }
        if ((ScatterSet)obj2.getSize() != i2.getSize()) {
            return j$iv$iv;
        }
        $i$f$isFull = this;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj5.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            i4 = $this$maskEmptyOrDeleted$iv$iv$iv;
            obj = $i$f$isFull;
        }
        return i4;
    }

    public final int findElementIndex$collection(E element) {
        int m;
        int m2;
        int $i$f$hash;
        int i12;
        int i7;
        int $i$f$h2;
        int $i$f$h1;
        int probeIndex;
        int i14;
        int i6;
        int $this$next$iv;
        int i3;
        int i10;
        int i5;
        int i;
        int i2;
        long l;
        int i15;
        int i13;
        int i8;
        int i4;
        int i11;
        int numberOfTrailingZeros;
        int i9;
        final Object obj = this;
        final Object obj2 = element;
        m = 0;
        int i17 = 0;
        if (obj2 != null) {
            i7 = obj2.hashCode();
        } else {
            i7 = 0;
        }
        i7 *= i23;
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
                i11 = 1;
                i10 = 0;
                int i46 = 0;
                i6 = i38 & _capacity;
                int i29 = m2;
                i2 = 0;
                m2 = $this$next$iv;
                i31 = 0;
                i36 = 0;
                i11 = 0;
            }
            i11 = 0;
            int i28 = i12;
            i3 = 0;
            $i$f$h1 = i14 & _capacity;
            $i$f$h2 = i5;
            m = i13;
            $i$f$hash = i8;
            long[] metadata = obj.metadata;
            $this$next$iv = 0;
            int i30 = $i$f$h1 >> 3;
            i32 <<= 3;
            i20 |= i34;
            i10 = 0;
            i5 = i44;
            long l6 = 72340172838076673L;
            i35 ^= i6;
            l = -9187201950435737472L;
            i16 &= l;
            i10 = 0;
            i46 = 0;
            i6 = i38 & _capacity;
            i29 = m2;
            i2 = 0;
            m2 = $this$next$iv;
            i11 = 1;
        }
        return i6;
    }

    public final E first() {
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
        NoSuchElementException this_$iv = new NoSuchElementException("The ScatterSet is empty");
        throw this_$iv;
    }

    public final E first(Function1<? super E, Boolean> predicate) {
        int cmp;
        Object obj2;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i;
        int i2;
        int $i$f$first;
        Object obj;
        long l;
        int i3;
        int i4;
        int i5;
        boolean booleanValue;
        final Object obj3 = predicate;
        Intrinsics.checkNotNullParameter(obj3, "predicate");
        obj2 = this;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            $i$f$first = cmp;
            obj = obj2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Could not find a match");
        throw noSuchElementException;
    }

    public final E firstOrNull(Function1<? super E, Boolean> predicate) {
        int cmp;
        Object obj;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i3;
        int i;
        int $i$f$firstOrNull;
        Object obj2;
        long l;
        int i4;
        int i2;
        int i5;
        boolean booleanValue;
        final Object obj3 = predicate;
        Intrinsics.checkNotNullParameter(obj3, "predicate");
        obj = this;
        final int i13 = 0;
        final int i14 = 0;
        final long[] metadata = obj4.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            $i$f$firstOrNull = cmp;
            obj2 = obj;
        }
        return 0;
    }

    public final void forEach(Function1<? super E, Unit> block) {
        int i$iv;
        long slot$iv;
        int $this$maskEmptyOrDeleted$iv$iv;
        int i5;
        int j$iv;
        int i4;
        int i3;
        long l;
        int i2;
        int i;
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

    public final void forEachIndex(Function1<? super Integer, Unit> block) {
        int i4;
        long slot;
        int $this$maskEmptyOrDeleted$iv;
        int i;
        int j;
        int i2;
        Integer valueOf;
        long l;
        int i3;
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
        int i2;
        int j$iv$iv;
        int i5;
        int i6;
        long l;
        int i3;
        int i4;
        int i;
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
        return ScatterSet.joinToString$default(this, 0, 0, 0, 0, 0, 0, 63, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return ScatterSet.joinToString$default(this, charSequence, 0, 0, 0, 0, 0, 62, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return ScatterSet.joinToString$default(this, charSequence, charSequence2, 0, 0, 0, 0, 60, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ScatterSet.joinToString$default(this, charSequence, charSequence2, charSequence3, 0, 0, 0, 56, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return ScatterSet.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, 0, 0, 48, 0);
    }

    public final String joinToString(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, java.lang.CharSequence charSequence3, int i4, java.lang.CharSequence charSequence5) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence5, "truncated");
        return ScatterSet.joinToString$default(this, charSequence, charSequence2, charSequence3, i4, charSequence5, 0, 32, 0);
    }

    public final String joinToString(java.lang.CharSequence separator, java.lang.CharSequence prefix, java.lang.CharSequence postfix, int limit, java.lang.CharSequence truncated, Function1<? super E, ? extends java.lang.CharSequence> transform) {
        int obj;
        int i$iv$iv;
        int i2;
        StringBuilder stringBuilder;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        int i;
        int index;
        int j$iv$iv;
        long slot$iv$iv;
        Object $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        int i7;
        int i8;
        int i9;
        long l;
        int i6;
        int i4;
        int i5;
        StringBuilder sb;
        Object invoke;
        Object obj2 = prefix;
        final Object obj3 = postfix;
        final Object obj4 = truncated;
        final Object obj5 = transform;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(obj2, "prefix");
        Intrinsics.checkNotNullParameter(obj3, "postfix");
        Intrinsics.checkNotNullParameter(obj4, "truncated");
        stringBuilder = new StringBuilder();
        final StringBuilder sb2 = stringBuilder;
        sb2.append(obj2);
        i = 0;
        index = this;
        final int i15 = 0;
        final long[] metadata = obj6.metadata;
        length += -2;
        if (0 <= i16) {
        } else {
            sb = stringBuilder;
            i8 = $this$maskEmptyOrDeleted$iv$iv$iv2;
            $this$maskEmptyOrDeleted$iv$iv$iv = index;
            i3 = j$iv$iv;
            i2 = limit;
            index = i;
            sb2.append(obj3);
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
        ScatterSet.toString.1 anon = new ScatterSet.toString.1(this);
        return ScatterSet.joinToString$default(this, 0, (CharSequence)"[", (CharSequence)"]", 0, 0, (Function1)anon, 25, 0);
    }
}
