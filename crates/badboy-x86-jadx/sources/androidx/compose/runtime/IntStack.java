package androidx.compose.runtime;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0015\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/runtime/IntStack;", "", "()V", "size", "", "getSize", "()I", "slots", "", "tos", "clear", "", "indexOf", "value", "isEmpty", "", "isNotEmpty", "peek", "index", "peek2", "peekOr", "default", "pop", "push", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntStack {

    public static final int $stable = 8;
    private int[] slots;
    private int tos;
    static {
        final int i = 8;
    }

    public IntStack() {
        super();
        this.slots = new int[10];
    }

    public final void clear() {
        this.tos = 0;
    }

    public final int getSize() {
        return this.tos;
    }

    public final int indexOf(int value) {
        int i;
        int i2;
        i = 0;
        while (i < this.tos) {
            i++;
        }
        return -1;
    }

    public final boolean isEmpty() {
        int i;
        i = this.tos == 0 ? 1 : 0;
        return i;
    }

    public final boolean isNotEmpty() {
        int i;
        i = this.tos != 0 ? 1 : 0;
        return i;
    }

    public final int peek() {
        return this.slots[tos--];
    }

    public final int peek(int index) {
        return this.slots[index];
    }

    public final int peek2() {
        return this.slots[tos += -2];
    }

    public final int peekOr(int default) {
        int peek;
        if (this.tos > 0) {
            peek = peek();
        } else {
            peek = default;
        }
        return peek;
    }

    public final int pop() {
        this.tos = tos--;
        return this.slots[this.tos];
    }

    public final void push(int value) {
        int copyOf;
        int length;
        if (this.tos >= slots3.length) {
            copyOf = Arrays.copyOf(this.slots, length2 *= 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.slots = copyOf;
        }
        int tos = this.tos;
        this.tos = tos + 1;
        this.slots[tos] = value;
    }
}
