package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u001e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010*\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 (*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J#\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e2\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\"\u0010\"\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%0$H\u0016J\u0016\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J#\u0010'\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006)", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "buffer", "", "", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize", "()I", "add", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "c", "", "elements", "bufferOfSize", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "set", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SmallPersistentVector<E>  extends androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList<E> implements ImmutableList<E> {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector.Companion Companion;
    private static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector EMPTY;
    private final Object[] buffer;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "", "getEMPTY", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector getEMPTY() {
            return SmallPersistentVector.access$getEMPTY$cp();
        }
    }
    static {
        SmallPersistentVector.Companion companion = new SmallPersistentVector.Companion(0);
        SmallPersistentVector.Companion = companion;
        int i = 8;
        int i3 = 0;
        SmallPersistentVector smallPersistentVector = new SmallPersistentVector(new Object[0]);
        SmallPersistentVector.EMPTY = smallPersistentVector;
    }

    public SmallPersistentVector(Object[] buffer) {
        int i;
        super();
        this.buffer = buffer;
        i = buffer2.length <= 32 ? 1 : 0;
        CommonFunctionsKt.assert(i);
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector access$getEMPTY$cp() {
        return SmallPersistentVector.EMPTY;
    }

    private final Object[] bufferOfSize(int size) {
        return new Object[size];
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentCollection add(Object element) {
        return (PersistentCollection)add(element);
    }

    public PersistentList<E> add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return add(element);
        }
        if (size() < 32) {
            Object[] bufferOfSize = bufferOfSize(size4++);
            int i11 = index;
            ArraysKt.copyInto$default(this.buffer, bufferOfSize, 0, 0, i11, 6, 0);
            ArraysKt.copyInto(this.buffer, bufferOfSize, i11 + 1, i11, size());
            bufferOfSize[i11] = element;
            SmallPersistentVector obj9 = new SmallPersistentVector(bufferOfSize);
            return (PersistentList)obj9;
        }
        int index2 = index;
        obj9 = this.buffer;
        obj9 = Arrays.copyOf(obj9, obj9.length);
        Intrinsics.checkNotNullExpressionValue(obj9, "copyOf(this, size)");
        ArraysKt.copyInto(this.buffer, obj9, index2 + 1, index2, size6--);
        obj9[index2] = element;
        PersistentVector persistentVector = new PersistentVector(obj9, UtilsKt.presizedBufferWith(this.buffer[31]), size7++, 0);
        return (PersistentList)persistentVector;
    }

    public PersistentList<E> add(E element) {
        if (size() < 32) {
            Object[] copyOf = Arrays.copyOf(this.buffer, size2++);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[size()] = element;
            SmallPersistentVector smallPersistentVector = new SmallPersistentVector(copyOf);
            return (PersistentList)smallPersistentVector;
        }
        PersistentVector persistentVector = new PersistentVector(this.buffer, UtilsKt.presizedBufferWith(element), size4++, 0);
        return (PersistentList)persistentVector;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentCollection addAll(Collection elements) {
        return (PersistentCollection)addAll(elements);
    }

    public PersistentList<E> addAll(int index, Collection<? extends E> c) {
        int size;
        int i;
        int obj9;
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (size3 += size6 <= 32) {
            Object[] bufferOfSize = bufferOfSize(size4 += size7);
            int i9 = index;
            ArraysKt.copyInto$default(this.buffer, bufferOfSize, 0, 0, i9, 6, 0);
            ArraysKt.copyInto(this.buffer, bufferOfSize, size5 += i9, i9, size());
            obj9 = i9;
            Iterator iterator = c.iterator();
            for (Object size : iterator) {
                bufferOfSize[obj9] = size;
                obj9 = i;
            }
            SmallPersistentVector smallPersistentVector = new SmallPersistentVector(bufferOfSize);
            return (PersistentList)smallPersistentVector;
        }
        int i3 = 0;
        PersistentList.Builder builder = (PersistentList)this.builder();
        int i7 = 0;
        (List)builder.addAll(index, c);
        return builder.build();
    }

    public PersistentList<E> addAll(Collection<? extends E> elements) {
        int size;
        Object next;
        int i;
        if (size2 += size3 <= 32) {
            Object[] copyOf = Arrays.copyOf(this.buffer, size4 += size5);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            size = size();
            Iterator iterator = elements.iterator();
            for (Object next : iterator) {
                copyOf[size] = next;
                size = i;
            }
            SmallPersistentVector smallPersistentVector = new SmallPersistentVector(copyOf);
            return (PersistentList)smallPersistentVector;
        }
        int i4 = 0;
        PersistentList.Builder builder = (PersistentList)this.builder();
        int i6 = 0;
        (List)builder.addAll(elements);
        return builder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentCollection.Builder builder() {
        return (PersistentCollection.Builder)builder();
    }

    public PersistentList.Builder<E> builder() {
        PersistentVectorBuilder persistentVectorBuilder = new PersistentVectorBuilder((PersistentList)this, 0, this.buffer, 0);
        return (PersistentList.Builder)persistentVectorBuilder;
    }

    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return this.buffer[index];
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public int getSize() {
        return buffer.length;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public int indexOf(Object element) {
        return ArraysKt.indexOf(this.buffer, element);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public int lastIndexOf(Object element) {
        return ArraysKt.lastIndexOf(this.buffer, element);
    }

    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        BufferIterator bufferIterator = new BufferIterator(this.buffer, index, size());
        return (ListIterator)bufferIterator;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public PersistentCollection removeAll(Function1 predicate) {
        return (PersistentCollection)removeAll(predicate);
    }

    public PersistentList<E> removeAll(Function1<? super E, Boolean> predicate) {
        Object[] newSize;
        int size;
        int anyRemoved;
        int index;
        Object smallPersistentVector;
        int copyOfRange;
        Object obj;
        boolean booleanValue;
        String str;
        newSize = this.buffer;
        size = size();
        anyRemoved = 0;
        index = 0;
        while (index < size()) {
            obj = this.buffer[index];
            if ((Boolean)predicate.invoke(obj).booleanValue()) {
            } else {
            }
            if (anyRemoved != 0) {
            }
            index++;
            newSize[size] = obj;
            size = booleanValue;
            if (anyRemoved == 0) {
            }
            Object[] buffer2 = this.buffer;
            booleanValue = Arrays.copyOf(buffer2, buffer2.length);
            Intrinsics.checkNotNullExpressionValue(booleanValue, "copyOf(this, size)");
            anyRemoved = newSize2;
            size = newBuffer;
            newSize = booleanValue;
        }
        if (size == size()) {
            smallPersistentVector = this;
        } else {
            if (size == 0) {
                smallPersistentVector = SmallPersistentVector.EMPTY;
            } else {
                smallPersistentVector = new SmallPersistentVector(ArraysKt.copyOfRange(newSize, 0, size));
            }
        }
        return smallPersistentVector;
    }

    public PersistentList<E> removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        int i = 1;
        if (size() == i) {
            return (PersistentList)SmallPersistentVector.EMPTY;
        }
        Object[] copyOf = Arrays.copyOf(this.buffer, size3 -= i);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        ArraysKt.copyInto(this.buffer, copyOf, index, index + 1, size());
        SmallPersistentVector smallPersistentVector = new SmallPersistentVector(copyOf);
        return (PersistentList)smallPersistentVector;
    }

    public PersistentList<E> set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        Object[] buffer = this.buffer;
        Object[] copyOf = Arrays.copyOf(buffer, buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[index] = element;
        SmallPersistentVector smallPersistentVector = new SmallPersistentVector(copyOf);
        return (PersistentList)smallPersistentVector;
    }
}
