package androidx.compose.runtime;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\n\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016¨\u0006\r", d2 = {"Landroidx/compose/runtime/AtomicInt;", "Ljava/util/concurrent/atomic/AtomicInteger;", "value", "", "(I)V", "add", "amount", "toByte", "", "toChar", "", "toShort", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AtomicInt extends AtomicInteger {

    public static final int $stable;
    static {
    }

    public AtomicInt(int value) {
        super(value);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final int add(int amount) {
        return addAndGet(amount);
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final byte byteValue() {
        return toByte();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final double doubleValue() {
        return toDouble();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final float floatValue() {
        return toFloat();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final int intValue() {
        return toInt();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final long longValue() {
        return toLong();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public final short shortValue() {
        return toShort();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public byte toByte() {
        return (byte)intValue;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public char toChar() {
        return (char)intValue;
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public double toDouble() {
        return super.doubleValue();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public float toFloat() {
        return super.floatValue();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public int toInt() {
        return super.intValue();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public long toLong() {
        return super.longValue();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public short toShort() {
        return (short)intValue;
    }
}
