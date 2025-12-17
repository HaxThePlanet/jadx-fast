package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0086\u0002J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tJ\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0086\u0002J\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tJ\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/BitVector;", "", "()V", "first", "", "others", "", "second", "size", "", "getSize", "()I", "get", "", "index", "nextClear", "nextSet", "set", "", "value", "setRange", "start", "end", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BitVector {

    public static final int $stable = 8;
    private long first;
    private long[] others;
    private long second;
    static {
        final int i = 8;
    }

    public final boolean get(int index) {
        int size;
        int i;
        if (index < 0) {
        } else {
            if (index >= getSize()) {
            } else {
                i = 1;
                int i2 = 0;
                int i3 = 1;
                final int i13 = 0;
                if (index < 64) {
                    if (Long.compare(i5, i2) != 0) {
                    } else {
                        i = i13;
                    }
                    return i;
                }
                if (index < 128) {
                    if (Long.compare(i9, i2) != 0) {
                    } else {
                        i = i13;
                    }
                    return i;
                }
                long[] others = this.others;
                if (others == null) {
                    return i13;
                }
                i14 += -2;
                if (i15 >= others.length) {
                    return i13;
                }
                if (Long.compare(i7, i2) != 0) {
                } else {
                    i = i13;
                }
                return i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Index ").append(index).append(" out of bound").toString().toString());
        throw illegalStateException;
    }

    public final int getSize() {
        int i;
        final long[] others = this.others;
        final int i2 = 0;
        if (others != null) {
            i3 *= 64;
        } else {
            i = 128;
        }
        return i;
    }

    public final int nextClear(int index) {
        int bit;
        boolean z;
        bit = index;
        while (bit < getSize()) {
            bit++;
        }
        return Integer.MAX_VALUE;
    }

    public final int nextSet(int index) {
        int bit;
        boolean z;
        bit = index;
        while (bit < getSize()) {
            bit++;
        }
        return Integer.MAX_VALUE;
    }

    public final void set(int index, boolean value) {
        int i3;
        int i;
        long[] $this$set_u24lambda_u241;
        int i2;
        int copyOf;
        long[] lArr;
        int i4;
        int i10 = 1;
        if (index < 64) {
            int i6 = i10 << index;
            long first = this.first;
            i3 = value != null ? first | i6 : first & i2;
            this.first = i3;
        }
        if (index < 128) {
            int i8 = i10 << i7;
            long second = this.second;
            i = value != null ? second | i8 : second & i2;
            this.second = i;
        }
        mask2 += -2;
        i10 <<= i12;
        if (this.others == null) {
            i2 = 0;
            lArr = new long[i9 + 1];
            obj.others = lArr;
            $this$set_u24lambda_u241 = lArr;
        }
        if (i9 >= $this$set_u24lambda_u241.length) {
            copyOf = Arrays.copyOf($this$set_u24lambda_u241, i9 + 1);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.others = copyOf;
        }
        long l = $this$set_u24lambda_u241[i9];
        i4 = value != null ? l | i11 : i15 & l;
        $this$set_u24lambda_u241[i9] = i4;
    }

    public final void setRange(int start, int end) {
        int bit;
        int i;
        bit = start;
        while (bit < end) {
            set(bit, true);
            bit++;
        }
    }

    public String toString() {
        int first;
        int i;
        boolean str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i2 = 0;
        first = 1;
        sb.append("BitVector [");
        i = 0;
        while (i < getSize()) {
            if (get(i) && first == 0) {
            }
            i++;
            if (first == 0) {
            }
            first = 0;
            sb.append(i);
            sb.append(", ");
        }
        sb.append(']');
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
