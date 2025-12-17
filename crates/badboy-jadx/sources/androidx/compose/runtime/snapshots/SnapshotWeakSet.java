package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\"J\r\u0010#\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0008$J\u001d\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00190(H\u0086\u0008R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR*\u0010\u0010\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00120\u0011X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016¨\u0006)", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "T", "", "()V", "hashes", "", "getHashes$runtime_release", "()[I", "setHashes$runtime_release", "([I)V", "size", "", "getSize$runtime_release", "()I", "setSize$runtime_release", "(I)V", "values", "", "Landroidx/compose/runtime/WeakReference;", "getValues$runtime_release", "()[Landroidx/compose/runtime/WeakReference;", "setValues$runtime_release", "([Landroidx/compose/runtime/WeakReference;)V", "[Landroidx/compose/runtime/WeakReference;", "add", "", "value", "(Ljava/lang/Object;)Z", "find", "hash", "(Ljava/lang/Object;I)I", "findExactIndex", "midIndex", "valueHash", "(ILjava/lang/Object;I)I", "isValid", "isValid$runtime_release", "removeIf", "", "block", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotWeakSet<T>  {

    public static final int $stable = 8;
    private int[] hashes;
    private int size;
    private WeakReference<T>[] values;
    static {
        final int i = 8;
    }

    public SnapshotWeakSet() {
        super();
        int i = 16;
        this.hashes = new int[i];
        this.values = new WeakReference[i];
    }

    private final int find(T value, int hash) {
        int low;
        int high;
        int i2;
        int i;
        Object obj;
        low = 0;
        size--;
        while (low <= high) {
            i3 >>>= 1;
            i = this.hashes[i2];
            high = i2 + -1;
            low = i2 + 1;
        }
        return -mid;
    }

    private final int findExactIndex(int midIndex, T value, int valueHash) {
        int i4;
        int i3;
        int i;
        WeakReference weakReference;
        int i2;
        Object obj;
        i4 = midIndex + -1;
        while (-1 < i4) {
            weakReference = this.values[i4];
            if (weakReference != null) {
            }
            i4--;
            i = weakReference.get();
        }
        i3 = midIndex + 1;
        while (i3 < this.size) {
            WeakReference weakReference2 = this.values[i3];
            if (weakReference2 != null) {
            } else {
            }
            obj = i;
            i3++;
            obj = weakReference2.get();
        }
        return -i6;
    }

    public final boolean add(T value) {
        int index;
        int[] hashes;
        int[] hashes2;
        int i4;
        int i;
        int i2;
        int i3;
        int i5;
        int[] iArr;
        WeakReference[] objArr;
        int i6 = 0;
        final int size = this.size;
        final int identityHashCode = ActualJvm_jvmKt.identityHashCode(value);
        if (size > 0) {
            if (find(value, identityHashCode) >= 0) {
                return 0;
            }
        } else {
            index = -1;
        }
        final int i14 = -i8;
        int length = values.length;
        if (size == length) {
            i5 = length * 2;
            WeakReference[] arr = new WeakReference[i5];
            iArr = new int[i5];
            ArraysKt.copyInto(this.values, arr, i14 + 1, i14, size);
            i2 = 6;
            i3 = 0;
            i4 = 0;
            i = 0;
            ArraysKt.copyInto$default(this.values, arr, i4, i, i14, i2, i3);
            ArraysKt.copyInto(this.hashes, iArr, i14 + 1, i14, size);
            hashes2 = iArr;
            ArraysKt.copyInto$default(this.hashes, hashes2, i4, i, i14, i2, i3);
            this.values = arr;
            this.hashes = hashes2;
        } else {
            ArraysKt.copyInto(this.values, this.values, i14 + 1, i14, size);
            ArraysKt.copyInto(this.hashes, this.hashes, i14 + 1, i14, size);
        }
        WeakReference weakReference = new WeakReference(value);
        this.values[i14] = weakReference;
        this.hashes[i14] = identityHashCode;
        int i10 = 1;
        this.size = size2 += i10;
        return i10;
    }

    public final int[] getHashes$runtime_release() {
        return this.hashes;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final boolean isValid$runtime_release() {
        int previous;
        int i;
        int i3;
        int i2;
        WeakReference weakReference;
        Object obj;
        int identityHashCode;
        final int size = this.size;
        final WeakReference[] values = this.values;
        final int[] hashes = this.hashes;
        final int length = values.length;
        int i4 = 0;
        if (size > length) {
            return i4;
        }
        previous = Integer.MIN_VALUE;
        i = 0;
        while (i < size) {
            i2 = hashes[i];
            weakReference = values[i];
            obj = weakReference.get();
            previous = i2;
            i++;
        }
        i3 = size;
        while (i3 < length) {
            i3++;
        }
        return 1;
    }

    public final void removeIf(Function1<? super T, Boolean> block) {
        int currentUsed;
        int i;
        int i3;
        int i2;
        WeakReference hashes$runtime_release;
        boolean hashes$runtime_release2;
        int i4;
        final int i5 = 0;
        final int size$runtime_release = getSize$runtime_release();
        currentUsed = 0;
        i = 0;
        while (i < size$runtime_release) {
            hashes$runtime_release = getValues$runtime_release()[i];
            if (hashes$runtime_release != null) {
            }
            if (i2 != 0 && !(Boolean)block.invoke(i2).booleanValue() && currentUsed != i) {
            }
            i++;
            if (!(Boolean)block.invoke(i2).booleanValue()) {
            }
            if (currentUsed != i) {
            }
            currentUsed++;
            getValues$runtime_release()[currentUsed] = hashes$runtime_release;
            getHashes$runtime_release()[currentUsed] = getHashes$runtime_release()[i];
            i2 = hashes$runtime_release.get();
        }
        i3 = currentUsed;
        while (i3 < size$runtime_release) {
            getValues$runtime_release()[i3] = 0;
            getHashes$runtime_release()[i3] = 0;
            i3++;
        }
        if (currentUsed != size$runtime_release) {
            setSize$runtime_release(currentUsed);
        }
    }

    public final void setHashes$runtime_release(int[] <set-?>) {
        this.hashes = <set-?>;
    }

    public final void setSize$runtime_release(int <set-?>) {
        this.size = <set-?>;
    }

    public final void setValues$runtime_release(WeakReference<T>[] <set-?>) {
        this.values = <set-?>;
    }
}
