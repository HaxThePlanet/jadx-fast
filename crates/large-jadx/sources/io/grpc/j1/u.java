package io.grpc.j1;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* compiled from: CompositeReadableBuffer.java */
/* loaded from: classes3.dex */
public class u extends c {

    private static final u.g<OutputStream> A = new u$e<>();
    private static final u.f<Void> w = new u$a<>();
    private static final u.f<Void> x = new u$b<>();
    private static final u.f<byte[]> y = new u$c<>();
    private static final u.f<ByteBuffer> z = new u$d<>();
    private final Deque<v1> a = new ArrayDeque<>();
    private Deque<v1> b;
    private int c;
    private boolean v;

    private interface g<T> {
        int a(v1 v1Var, int i, T t, int i2);
    }

    class e implements u.g<OutputStream> {
        e() {
            super();
        }

        public int b(v1 v1Var, int i, OutputStream outputStream, int i2) {
            v1Var.D1(outputStream, i);
            return 0;
        }
    }

    private interface f<T> extends u.g<T> {
    }

    class a implements u.f<Void> {
        a() {
            super();
        }

        public int b(v1 v1Var, int i, Void void, int i2) {
            return v1Var.readUnsignedByte();
        }
    }

    class b implements u.f<Void> {
        b() {
            super();
        }

        public int b(v1 v1Var, int i, Void void, int i2) {
            v1Var.skipBytes(i);
            return 0;
        }
    }

    class c implements u.f<byte[]> {
        c() {
            super();
        }

        public int b(v1 v1Var, int i, byte[] bArr, int i2) {
            v1Var.O0(bArr, i2, i);
            return i2 + i;
        }
    }

    class d implements u.f<ByteBuffer> {
        d() {
            super();
        }

        public int b(v1 v1Var, int i, ByteBuffer byteBuffer, int i2) {
            byteBuffer.limit(byteBuffer.position() + i);
            v1Var.W1(byteBuffer);
            byteBuffer.limit(byteBuffer.limit());
            return 0;
        }
    }

    public u(int i) {
        super();
        final ArrayDeque arrayDeque = new ArrayDeque(i);
    }

    private void e() {
        if (!this.v) {
            (v1)this.a.remove().close();
        } else {
            this.b.add(this.a.remove());
            Object remove = this.a.peek();
            if (remove != null) {
                remove.c1();
            }
        }
    }

    private void f() {
        if ((v1)this.a.peek().g() == 0) {
            e();
        }
    }

    private void i(v1 v1Var) {
        z = v1Var instanceof u;
        if (!(v1Var instanceof u)) {
            this.a.add(v1Var);
            this.c += i7;
            return;
        }
        while (!v1Var.a.isEmpty()) {
            this.a.add((v1)v1Var.a.remove());
        }
        this.c += i6;
        v1Var.c = 0;
        v1Var.close();
    }

    private <T> int j(u.g<T> gVar, int i, T t, int i2) {
        boolean empty;
        int i3;
        a(i);
        if (!this.a.isEmpty()) {
            f();
        }
        while (i > 0) {
        }
        if (i > 0) {
            throw new AssertionError("Failed executing read operation");
        } else {
            return i3;
        }
    }

    private <T> int k(u.f<T> fVar, int i, T t, int i2) {
        try {
        } catch (java.io.IOException ioException) {
            i = new AssertionError(ioException);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
        return j(fVar, i, t, i2);
    }

    @Override // io.grpc.j1.c
    public void D1(OutputStream outputStream, int i) {
        j(u.A, i, outputStream, 0);
    }

    @Override // io.grpc.j1.c
    public void O0(byte[] bArr, int i, int i2) {
        k(u.y, i2, bArr, i);
    }

    @Override // io.grpc.j1.c
    public v1 Q(int i) {
        io.grpc.j1.v1 i3 = null;
        int i2;
        int i4 = 0;
        int min = 2;
        boolean z;
        int i5;
        if (i <= 0) {
            return w1.a();
        }
        a(i);
        this.c -= i;
        Object peek = this.a.peek();
        min = peek.g();
        while (min > i4) {
            i3 = peek.Q(i4);
            i4 = 0;
            if (this.a <= 0) {
                return i3;
            }
        }
        return i3;
    }

    @Override // io.grpc.j1.c
    public void W1(ByteBuffer byteBuffer) {
        k(u.z, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // io.grpc.j1.c
    public void c(v1 v1Var) {
        int i = 0;
        if (this.v) {
            int r0 = this.a.isEmpty() ? 1 : 0;
        }
        i(v1Var);
        if (this.a != 0) {
            (v1)this.a.peek().c1();
        }
    }

    @Override // io.grpc.j1.c
    public void c1() {
        int min;
        int i = 16;
        if (this.b == null) {
            i = 16;
            this.b = new ArrayDeque(Math.min(this.a.size(), i));
        }
        while (!this.b.isEmpty()) {
            (v1)this.b.remove().close();
        }
        this.v = true;
        Object peek = this.a.peek();
        if (peek != null) {
            peek.c1();
        }
    }

    @Override // io.grpc.j1.c
    public void close() {
        while (!this.a.isEmpty()) {
            (v1)this.a.remove().close();
        }
        if (this.b != null) {
            while (!this.b.isEmpty()) {
                (v1)this.b.remove().close();
            }
        }
    }

    @Override // io.grpc.j1.c
    public int g() {
        return this.c;
    }

    @Override // io.grpc.j1.c
    public boolean markSupported() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            if (!(v1)it.next().markSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.j1.c
    public int readUnsignedByte() {
        return k(u.w, 1, null, 0);
    }

    @Override // io.grpc.j1.c
    public void reset() throws InvalidMarkException {
        int i2;
        if (!this.v) {
            throw new InvalidMarkException();
        } else {
            Object peek = this.a.peek();
            if (peek != null) {
                peek.reset();
                this.c += i5;
            }
            Object pollLast = this.b.pollLast();
            while (pollLast != null) {
                pollLast.reset();
                this.a.addFirst(pollLast);
                this.c += i3;
                pollLast = this.b.pollLast();
            }
            return;
        }
    }

    @Override // io.grpc.j1.c
    public void skipBytes(int i) {
        k(u.x, i, null, 0);
    }

    public u() {
        super();
        final ArrayDeque arrayDeque = new ArrayDeque();
    }
}
