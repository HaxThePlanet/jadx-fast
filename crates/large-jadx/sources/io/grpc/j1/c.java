package io.grpc.j1;

/* loaded from: classes3.dex */
public abstract class c implements io.grpc.j1.v1 {
    @Override // io.grpc.j1.v1
    protected final void a(int i) {
        if (g() < i) {
        } else {
        }
        IndexOutOfBoundsException obj2 = new IndexOutOfBoundsException();
        throw obj2;
    }

    @Override // io.grpc.j1.v1
    public void c1() {
    }

    @Override // io.grpc.j1.v1
    public void close() {
    }

    @Override // io.grpc.j1.v1
    public boolean markSupported() {
        return 0;
    }

    @Override // io.grpc.j1.v1
    public final int readInt() {
        a(4);
        return i4 |= unsignedByte4;
    }

    @Override // io.grpc.j1.v1
    public void reset() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}
