package io.grpc.j1;

/* compiled from: AbstractReadableBuffer.java */
/* loaded from: classes3.dex */
public abstract class c implements v1 {
    protected final void a(int i) {
        if (g() < i) {
            throw new IndexOutOfBoundsException();
        }
    }

    public final int readInt() {
        a(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public void c1() {
    }

    public void close() {
    }

    public boolean markSupported() {
        return false;
    }
}
