package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public class DecoderInputBuffer extends com.google.android.exoplayer2.decoder.a {

    public final com.google.android.exoplayer2.decoder.b b;
    public ByteBuffer c;
    public boolean v;
    public long w;
    public ByteBuffer x;
    private final int y;
    private final int z;

    public static final class InsufficientCapacityException extends java.lang.IllegalStateException {

        public final int currentCapacity;
        public final int requiredCapacity;
        public InsufficientCapacityException(int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder(44);
            stringBuilder.append("Buffer too small (");
            stringBuilder.append(i);
            stringBuilder.append(" < ");
            stringBuilder.append(i2);
            stringBuilder.append(")");
            super(stringBuilder.toString());
            this.currentCapacity = i;
            this.requiredCapacity = i2;
        }
    }
    public DecoderInputBuffer(int i) {
        super(i, 0);
    }

    public DecoderInputBuffer(int i, int i2) {
        super();
        b bVar = new b();
        this.b = bVar;
        this.y = i;
        this.z = i2;
    }

    private ByteBuffer s(int i) {
        int capacity;
        int i2 = this.y;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null) {
            capacity = 0;
        } else {
            capacity = byteBuffer.capacity();
        }
        DecoderInputBuffer.InsufficientCapacityException insufficientCapacityException = new DecoderInputBuffer.InsufficientCapacityException(capacity, i);
        throw insufficientCapacityException;
    }

    public static com.google.android.exoplayer2.decoder.DecoderInputBuffer w() {
        DecoderInputBuffer decoderInputBuffer = new DecoderInputBuffer(0);
        return decoderInputBuffer;
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public void j() {
        super.j();
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.x;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.v = false;
    }

    @EnsuresNonNull("data")
    public void t(int i) {
        i += i2;
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null) {
            this.c = s(obj4);
        }
        final int position = byteBuffer.position();
        obj4 += position;
        if (byteBuffer.capacity() >= obj4) {
            this.c = byteBuffer;
        }
        ByteBuffer obj4 = s(obj4);
        obj4.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            obj4.put(byteBuffer);
        }
        this.c = obj4;
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public final void u() {
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.x;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.a
    public final boolean v() {
        return m(1073741824);
    }

    @EnsuresNonNull("supplementalData")
    public void x(int i) {
        int capacity;
        ByteBuffer obj2;
        capacity = this.x;
        if (capacity != null) {
            if (capacity.capacity() < i) {
                this.x = ByteBuffer.allocate(i);
            } else {
                this.x.clear();
            }
        } else {
        }
    }
}
