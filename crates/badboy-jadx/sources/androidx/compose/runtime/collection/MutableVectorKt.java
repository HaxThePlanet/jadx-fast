package androidx.compose.runtime.collection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0008\u0005\u001a!\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u00012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\u0008\u001a@\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0008\u0008\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0008\u0082\u0002\u0008\n\u0006\u0008\u0001\u0012\u0002\u0010\u0002\u001a\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u0001H\u0086\u0008\u001a0\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\u0008\u0000\u0010\u0002\u0018\u00012\u0012\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\n\"\u0002H\u0002H\u0086\u0008¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\u000c\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002\u001a \u0010\u0010\u001a\u00020\r*\u0006\u0012\u0002\u0008\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¨\u0006\u0013", d2 = {"MutableVector", "Landroidx/compose/runtime/collection/MutableVector;", "T", "capacity", "", "size", "init", "Lkotlin/Function1;", "mutableVectorOf", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/collection/MutableVector;", "checkIndex", "", "", "index", "checkSubIndex", "fromIndex", "toIndex", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MutableVectorKt {
    public static final <T> androidx.compose.runtime.collection.MutableVector<T> MutableVector(int capacity) {
        final int i = 0;
        final int i2 = 0;
        Intrinsics.reifiedOperationMarker(i2, "T?");
        MutableVector mutableVector = new MutableVector(new Object[capacity], i2);
        return mutableVector;
    }

    public static final <T> androidx.compose.runtime.collection.MutableVector<T> MutableVector(int size, Function1<? super Integer, ? extends T> init) {
        int i;
        Object invoke;
        final int i2 = 0;
        Intrinsics.reifiedOperationMarker(0, "T");
        Object[] arr = new Object[size];
        while (i < size) {
            arr[i] = init.invoke(Integer.valueOf(i));
            i++;
        }
        MutableVector mutableVector = new MutableVector(arr, size);
        return mutableVector;
    }

    public static androidx.compose.runtime.collection.MutableVector MutableVector$default(int capacity, int i2, Object object3) {
        int obj2;
        if (i2 &= 1 != 0) {
            obj2 = 16;
        }
        int obj3 = 0;
        final int i = 0;
        Intrinsics.reifiedOperationMarker(i, "T?");
        MutableVector obj4 = new MutableVector(new Object[obj2], i);
        return obj4;
    }

    public static final void access$checkIndex(List $receiver, int index) {
        MutableVectorKt.checkIndex($receiver, index);
    }

    public static final void access$checkSubIndex(List $receiver, int fromIndex, int toIndex) {
        MutableVectorKt.checkSubIndex($receiver, fromIndex, toIndex);
    }

    private static final void checkIndex(List<?> $this$checkIndex, int index) {
        final int size = $this$checkIndex.size();
        if (index < 0) {
        } else {
            if (index >= size) {
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Index ").append(index).append(" is out of bounds. The list has ").append(size).append(" elements.").toString());
        throw indexOutOfBoundsException;
    }

    private static final void checkSubIndex(List<?> $this$checkSubIndex, int fromIndex, int toIndex) {
        final int size = $this$checkSubIndex.size();
        if (fromIndex > toIndex) {
        } else {
            if (fromIndex < 0) {
            } else {
                if (toIndex > size) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder2.append("toIndex (").append(toIndex).append(") is more than than the list size (").append(size).append(')').toString());
                throw indexOutOfBoundsException2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("fromIndex (").append(fromIndex).append(") is less than 0.").toString());
            throw indexOutOfBoundsException;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.append("Indices are out of order. fromIndex (").append(fromIndex).append(") is greater than toIndex (").append(toIndex).append(").").toString());
        throw illegalArgumentException;
    }

    public static final <T> androidx.compose.runtime.collection.MutableVector<T> mutableVectorOf() {
        final int i = 0;
        final int i3 = 0;
        final int i4 = 0;
        Intrinsics.reifiedOperationMarker(i4, "T?");
        MutableVector mutableVector = new MutableVector(new Object[16], i4);
        return mutableVector;
    }

    public static final <T> androidx.compose.runtime.collection.MutableVector<T> mutableVectorOf(T... elements) {
        final int i = 0;
        MutableVector mutableVector = new MutableVector(elements, elements.length);
        return mutableVector;
    }
}
