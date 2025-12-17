package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u000e\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0008\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0008\u0010\u001d\u001a\u00020\u0011H\u0007J\u0018\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "()V", "firstFreeHandle", "", "handles", "", "index", "<set-?>", "size", "getSize", "()I", "values", "add", "value", "allocateHandle", "ensure", "", "atLeast", "freeHandle", "handle", "lowestOrDefault", "default", "remove", "shiftDown", "shiftUp", "swap", "a", "b", "validate", "validateHandle", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotDoubleIndexHeap {

    public static final int $stable = 8;
    private int firstFreeHandle;
    private int[] handles;
    private int[] index;
    private int size;
    private int[] values;
    static {
        final int i = 8;
    }

    public SnapshotDoubleIndexHeap() {
        int i2;
        int i;
        super();
        final int i3 = 16;
        this.values = new int[i3];
        this.index = new int[i3];
        int[] iArr3 = new int[i3];
        i2 = 0;
        while (i2 < i3) {
            i = i2 + 1;
            iArr3[i2] = i;
            i2 = i;
        }
        this.handles = iArr3;
    }

    private final int allocateHandle() {
        int firstFreeHandle;
        int[] iArr2;
        int i4;
        int i3;
        int[] handles;
        int[] iArr;
        int i;
        int i5;
        int i6;
        int i7;
        int i2;
        int length = handles2.length;
        if (this.firstFreeHandle >= length) {
            firstFreeHandle = length * 2;
            iArr2 = new int[firstFreeHandle];
            i4 = 0;
            while (i4 < firstFreeHandle) {
                i3 = i4 + 1;
                iArr2[i4] = i3;
                i4 = i3;
            }
            iArr = iArr2;
            ArraysKt.copyInto$default(this.handles, iArr, 0, 0, 0, 14, 0);
            this.handles = iArr;
        }
        this.firstFreeHandle = this.handles[this.firstFreeHandle];
        return this.firstFreeHandle;
    }

    private final void ensure(int atLeast) {
        int length = values.length;
        if (atLeast <= length) {
        }
        final int i = length * 2;
        final int[] iArr = new int[i];
        final int i4 = 0;
        ArraysKt.copyInto$default(this.values, iArr, 0, 0, i4, 14, 0);
        int[] iArr2 = iArr3;
        ArraysKt.copyInto$default(this.index, iArr2, i4, 0, 0, 14, 0);
        this.values = iArr;
        this.index = iArr2;
    }

    private final void freeHandle(int handle) {
        this.handles[handle] = this.firstFreeHandle;
        this.firstFreeHandle = handle;
    }

    public static int lowestOrDefault$default(androidx.compose.runtime.snapshots.SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(obj1);
    }

    private final void shiftDown(int index) {
        int current;
        int i2;
        int i;
        int i3;
        int size;
        int i4;
        final int[] values = this.values;
        current = index;
        while (current < size2 >>= 1) {
            i6 <<= 1;
            i = i2 + -1;
            swap(i, current);
            current = i;
            swap(i2, current);
            current = i2;
        }
    }

    private final void shiftUp(int index) {
        int current;
        int i2;
        int i;
        final int[] values = this.values;
        current = index;
        while (current > 0) {
            i5--;
            if (values[i2] <= values[index]) {
                break;
            } else {
            }
            swap(i2, current);
            current = i2;
        }
    }

    private final void swap(int a, int b) {
        final int[] values = this.values;
        final int[] index = this.index;
        final int[] handles = this.handles;
        values[a] = values[b];
        values[b] = values[a];
        index[a] = index[b];
        index[b] = index[a];
        handles[index[a]] = a;
        handles[index[b]] = b;
    }

    public final int add(int value) {
        ensure(size++);
        int size2 = this.size;
        this.size = size2 + 1;
        int allocateHandle = allocateHandle();
        this.values[size2] = value;
        this.index[size2] = allocateHandle;
        this.handles[allocateHandle] = size2;
        shiftUp(size2);
        return allocateHandle;
    }

    public final int getSize() {
        return this.size;
    }

    public final int lowestOrDefault(int default) {
        int i;
        int i2;
        if (this.size > 0) {
            i = this.values[0];
        } else {
            i = default;
        }
        return i;
    }

    public final void remove(int handle) {
        int i = this.handles[handle];
        swap(i, size--);
        this.size = size2--;
        shiftUp(i);
        shiftDown(i);
        freeHandle(handle);
    }

    public final void validate() {
        int index;
        int i2;
        int i;
        int i3;
        index = 1;
        while (index < this.size) {
            index++;
        }
    }

    public final void validateHandle(int handle, int value) {
        int i = this.handles[handle];
        if (this.index[i] != handle) {
        } else {
            if (this.values[i] != value) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Value for handle ").append(handle).append(" was ").append(this.values[i]).append(" but was supposed to be ").append(value).toString().toString());
            throw illegalStateException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder2.append("Index for handle ").append(handle).append(" is corrupted").toString().toString());
        throw illegalStateException2;
    }
}
