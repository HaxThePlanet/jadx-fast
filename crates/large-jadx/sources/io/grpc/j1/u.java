package io.grpc.j1;

import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class u extends io.grpc.j1.c {

    private static final io.grpc.j1.u.g<OutputStream> A;
    private static final io.grpc.j1.u.f<Void> w;
    private static final io.grpc.j1.u.f<Void> x;
    private static final io.grpc.j1.u.f<byte[]> y;
    private static final io.grpc.j1.u.f<ByteBuffer> z;
    private final Deque<io.grpc.j1.v1> a;
    private Deque<io.grpc.j1.v1> b;
    private int c;
    private boolean v;

    private interface g {
        public abstract int a(io.grpc.j1.v1 v1, int i2, T t3, int i4);
    }

    class e implements io.grpc.j1.u.g<OutputStream> {
        @Override // io.grpc.j1.u$g
        public int a(io.grpc.j1.v1 v1, int i2, Object object3, int i4) {
            return b(v1, i2, (OutputStream)object3, i4);
        }

        @Override // io.grpc.j1.u$g
        public int b(io.grpc.j1.v1 v1, int i2, OutputStream outputStream3, int i4) {
            v1.D1(outputStream3, i2);
            return 0;
        }
    }

    private interface f extends io.grpc.j1.u.g<T> {
    }

    class a implements io.grpc.j1.u.f<Void> {
        @Override // io.grpc.j1.u$f
        public int a(io.grpc.j1.v1 v1, int i2, Object object3, int i4) {
            return b(v1, i2, (Void)object3, i4);
        }

        @Override // io.grpc.j1.u$f
        public int b(io.grpc.j1.v1 v1, int i2, Void void3, int i4) {
            return v1.readUnsignedByte();
        }
    }

    class b implements io.grpc.j1.u.f<Void> {
        @Override // io.grpc.j1.u$f
        public int a(io.grpc.j1.v1 v1, int i2, Object object3, int i4) {
            return b(v1, i2, (Void)object3, i4);
        }

        @Override // io.grpc.j1.u$f
        public int b(io.grpc.j1.v1 v1, int i2, Void void3, int i4) {
            v1.skipBytes(i2);
            return 0;
        }
    }

    class c implements io.grpc.j1.u.f<byte[]> {
        @Override // io.grpc.j1.u$f
        public int a(io.grpc.j1.v1 v1, int i2, Object object3, int i4) {
            return b(v1, i2, (byte[])object3, i4);
        }

        @Override // io.grpc.j1.u$f
        public int b(io.grpc.j1.v1 v1, int i2, byte[] b3Arr3, int i4) {
            v1.O0(b3Arr3, i4, i2);
            return i4 += i2;
        }
    }

    class d implements io.grpc.j1.u.f<ByteBuffer> {
        @Override // io.grpc.j1.u$f
        public int a(io.grpc.j1.v1 v1, int i2, Object object3, int i4) {
            return b(v1, i2, (ByteBuffer)object3, i4);
        }

        @Override // io.grpc.j1.u$f
        public int b(io.grpc.j1.v1 v1, int i2, ByteBuffer byteBuffer3, int i4) {
            byteBuffer3.limit(position += i2);
            v1.W1(byteBuffer3);
            byteBuffer3.limit(byteBuffer3.limit());
            return 0;
        }
    }
    static {
        u.a aVar = new u.a();
        u.w = aVar;
        u.b bVar = new u.b();
        u.x = bVar;
        u.c cVar = new u.c();
        u.y = cVar;
        u.d dVar = new u.d();
        u.z = dVar;
        u.e eVar = new u.e();
        u.A = eVar;
    }

    public u() {
        super();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.a = arrayDeque;
    }

    public u(int i) {
        super();
        ArrayDeque arrayDeque = new ArrayDeque(i);
        this.a = arrayDeque;
    }

    private void e() {
        Object remove2;
        Object remove;
        if (this.v) {
            this.b.add(this.a.remove());
            remove2 = this.a.peek();
            if ((v1)remove2 != null) {
                (v1)remove2.c1();
            }
        } else {
            (v1)this.a.remove().close();
        }
    }

    private void f() {
        if ((v1)this.a.peek().g() == 0) {
            e();
        }
    }

    private void i(io.grpc.j1.v1 v1) {
        boolean remove;
        Deque queue;
        if (!v1 instanceof u) {
            this.a.add(v1);
            this.c = i += obj3;
        }
        while (!v1.a.isEmpty()) {
            this.a.add((v1)v1.a.remove());
        }
        this.c = i3 += i6;
        v1.c = 0;
        (u)v1.close();
    }

    private <T> int j(io.grpc.j1.u.g<T> u$g, int i2, T t3, int i4) {
        boolean empty;
        int i;
        int obj4;
        int obj6;
        a(i2);
        if (!this.a.isEmpty()) {
            f();
        }
        while (obj4 > 0) {
            if (!this.a.isEmpty()) {
            }
            Object peek = this.a.peek();
            i = Math.min(obj4, (v1)peek.g());
            obj6 = g.a(peek, i, t3, obj6);
            obj4 -= i;
            this.c = i3 -= i;
            f();
        }
        if (obj4 > 0) {
        } else {
            return obj6;
        }
        AssertionError obj3 = new AssertionError("Failed executing read operation");
        throw obj3;
    }

    private <T> int k(io.grpc.j1.u.f<T> u$f, int i2, T t3, int i4) {
        try {
            return j(f, i2, t3, i4);
            i2 = new AssertionError(f);
            throw i2;
        }
    }

    @Override // io.grpc.j1.c
    public void D1(OutputStream outputStream, int i2) {
        j(u.A, i2, outputStream, 0);
    }

    @Override // io.grpc.j1.c
    public void O0(byte[] bArr, int i2, int i3) {
        k(u.y, i3, bArr, i2);
    }

    @Override // io.grpc.j1.c
    public io.grpc.j1.v1 Q(int i) {
        int i2;
        int uVar;
        int i4;
        Object poll;
        int i3;
        boolean z;
        io.grpc.j1.v1 v1Var;
        int obj7;
        if (i <= 0) {
            return w1.a();
        }
        a(i);
        this.c = i5 -= i;
        uVar = i2;
        Object peek = this.a.peek();
        i3 = (v1)peek.g();
        while (i3 > obj7) {
            obj7 = peek.Q(obj7);
            i4 = 0;
            if (i2 == 0) {
            } else {
            }
            if (uVar == 0) {
            }
            uVar.c(obj7);
            if (i4 > 0) {
            }
            obj7 = i4;
            peek = this.a.peek();
            i3 = (v1)peek.g();
            if (this.v) {
            } else {
            }
            poll = this.a.poll();
            i4 = obj7;
            obj7 = v1Var;
            poll = peek.Q(i3);
            e();
            if (i4 == 0) {
            } else {
            }
            i3 = Math.min(size += i3, 16);
            uVar = new u(i3);
            uVar.c(i2);
            i2 = uVar;
            i2 = obj7;
        }
        return i2;
    }

    @Override // io.grpc.j1.c
    public void W1(ByteBuffer byteBuffer) {
        k(u.z, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // io.grpc.j1.c
    public void c(io.grpc.j1.v1 v1) {
        boolean empty;
        int i;
        Object obj2;
        if (this.v && this.a.isEmpty()) {
            i = this.a.isEmpty() ? 1 : 0;
        } else {
        }
        i(v1);
        if (i != 0) {
            (v1)this.a.peek().c1();
        }
    }

    @Override // io.grpc.j1.c
    public void c1() {
        Object arrayDeque;
        int i2;
        int i;
        if (this.b == null) {
            arrayDeque = new ArrayDeque(Math.min(this.a.size(), 16));
            this.b = arrayDeque;
        }
        while (!this.b.isEmpty()) {
            (v1)this.b.remove().close();
        }
        this.v = true;
        Object peek = this.a.peek();
        if ((v1)peek != null) {
            (v1)peek.c1();
        }
    }

    @Override // io.grpc.j1.c
    public void close() {
        Deque remove;
        while (!this.a.isEmpty()) {
            (v1)this.a.remove().close();
        }
        if (this.b != null) {
        }
    }

    @Override // io.grpc.j1.c
    public int g() {
        return this.c;
    }

    @Override // io.grpc.j1.c
    public boolean markSupported() {
        boolean markSupported;
        Iterator iterator = this.a.iterator();
        for (v1 next2 : iterator) {
        }
        return 1;
    }

    @Override // io.grpc.j1.c
    public int readUnsignedByte() {
        return k(u.w, 1, 0, 0);
    }

    @Override // io.grpc.j1.c
    public void reset() {
        Object peek;
        int i2;
        int i;
        if (!this.v) {
        } else {
            peek = this.a.peek();
            if ((v1)peek != null) {
                peek.reset();
                this.c = i5 += peek;
            }
            Object pollLast = this.b.pollLast();
            while ((v1)pollLast != null) {
                (v1)pollLast.reset();
                this.a.addFirst(pollLast);
                this.c = i4 += peek;
                pollLast = this.b.pollLast();
            }
        }
        InvalidMarkException invalidMarkException = new InvalidMarkException();
        throw invalidMarkException;
    }

    @Override // io.grpc.j1.c
    public void skipBytes(int i) {
        k(u.x, i, 0, 0);
    }
}
