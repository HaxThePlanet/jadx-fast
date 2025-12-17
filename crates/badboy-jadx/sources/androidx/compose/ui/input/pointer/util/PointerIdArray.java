package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.input.pointer.PointerId;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000f\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u000e\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0011J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0013J\u001e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0006H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\rJ\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010\u0011J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0006J#\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u0019\u0010!\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006$", d2 = {"Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "", "()V", "internalArray", "", "lastIndex", "", "getLastIndex", "()I", "<set-?>", "size", "getSize", "add", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "add-0FcD4WY", "(J)Z", "value", "", "clear", "", "contains", "contains-0FcD4WY", "pointerIdValue", "get", "index", "get-_I2yYro", "(I)J", "isEmpty", "remove", "remove-0FcD4WY", "removeAt", "set", "set-DmW0f2w", "(IJ)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerIdArray {

    public static final int $stable = 8;
    private long[] internalArray;
    private int size;
    static {
        final int i = 8;
    }

    public PointerIdArray() {
        super();
        this.internalArray = new long[2];
    }

    public final boolean add(long value) {
        if (!contains(value)) {
            set(this.size, value);
            return 1;
        }
        return 0;
    }

    public final boolean add-0FcD4WY(long pointerId) {
        return add(pointerId);
    }

    public final void clear() {
        this.size = 0;
    }

    public final boolean contains(long pointerIdValue) {
        int i;
        int cmp;
        i = 0;
        while (i < this.size) {
            i++;
        }
        return 0;
    }

    public final boolean contains-0FcD4WY(long pointerId) {
        return contains(pointerId);
    }

    public final long get-_I2yYro(int index) {
        return PointerId.constructor-impl(this.internalArray[index]);
    }

    public final int getLastIndex() {
        final int i = 0;
        return size--;
    }

    public final int getSize() {
        return this.size;
    }

    public final boolean isEmpty() {
        int i;
        i = this.size == 0 ? 1 : 0;
        return i;
    }

    public final boolean remove(long pointerIdValue) {
        int i;
        int cmp;
        i = 0;
        while (i < this.size) {
            i++;
        }
        return 0;
    }

    public final boolean remove-0FcD4WY(long pointerId) {
        return remove(pointerId);
    }

    public final boolean removeAt(int index) {
        int i;
        long[] internalArray;
        long l;
        int i2;
        if (index < this.size) {
            i = index;
            final int i7 = 1;
            while (i < size2 -= i7) {
                this.internalArray[i] = this.internalArray[i + 1];
                i++;
            }
            this.size = i4--;
            return i7;
        }
        return 0;
    }

    public final void set(int index, long value) {
        int copyOf;
        int size;
        String str;
        int i;
        if (index >= internalArray.length) {
            copyOf = Arrays.copyOf(this.internalArray, Math.max(index + 1, length *= 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.internalArray = copyOf;
        }
        this.internalArray[index] = value;
        if (index >= this.size) {
            this.size = index + 1;
        }
    }

    public final void set-DmW0f2w(int index, long pointerId) {
        set(index, pointerId);
    }
}
