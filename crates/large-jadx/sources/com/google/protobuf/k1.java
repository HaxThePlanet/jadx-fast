package com.google.protobuf;

import android.accounts.Account;
import com.google.firebase.crashlytics.internal.common.MetaDataStore.1;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
final class k1 extends com.google.protobuf.j {

    static final int[] c = null;
    private static final long serialVersionUID = 1L;
    private final com.google.protobuf.j left;
    private final int leftLength;
    private final com.google.protobuf.j right;
    private final int totalLength;
    private final int treeDepth;

    private static class b {

        private final ArrayDeque<com.google.protobuf.j> a;
        private b() {
            super();
            ArrayDeque arrayDeque = new ArrayDeque();
            this.a = arrayDeque;
        }

        b(com.google.protobuf.k1.a k1$a) {
            super();
        }

        static com.google.protobuf.j a(com.google.protobuf.k1.b k1$b, com.google.protobuf.j j2, com.google.protobuf.j j3) {
            return b.b(j2, j3);
        }

        private com.google.protobuf.j b(com.google.protobuf.j j, com.google.protobuf.j j2) {
            com.google.protobuf.k1 k1Var;
            int i;
            Object obj3;
            com.google.protobuf.j obj4;
            c(j);
            c(j2);
            obj3 = this.a.pop();
            while (!this.a.isEmpty()) {
                k1Var = new k1((j)this.a.pop(), obj3, 0);
                obj3 = k1Var;
            }
            return obj3;
        }

        private void c(com.google.protobuf.j j) {
            boolean z;
            com.google.protobuf.j obj4;
            if (j.A()) {
                e(j);
            } else {
                if (!j instanceof k1) {
                } else {
                    c(k1.Z((k1)j));
                    c(k1.a0(j));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Has a new type of ByteString been created? Found ");
            stringBuilder.append(j.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        private int d(int i) {
            int obj2;
            obj2 = Arrays.binarySearch(k1.c, i);
            if (obj2 < 0) {
                obj2--;
            }
            return obj2;
        }

        private void e(com.google.protobuf.j j) {
            Object k1Var2;
            Object k1Var;
            boolean empty;
            int i;
            com.google.protobuf.k1 k1Var3;
            Object obj6;
            int i2 = d(j.size());
            if (!this.a.isEmpty()) {
                if ((j)this.a.peek().size() >= k1.f0(i2 + 1)) {
                    this.a.push(j);
                } else {
                    k1Var = this.a.pop();
                    i = 0;
                    while (!this.a.isEmpty()) {
                        if ((j)this.a.peek().size() < k1.f0(i2)) {
                        }
                        k1Var3 = new k1((j)this.a.pop(), k1Var, i);
                        k1Var = k1Var3;
                        i = 0;
                    }
                    k1Var2 = new k1(k1Var, j, i);
                    while (!this.a.isEmpty()) {
                        if ((j)this.a.peek().size() < k1.f0(obj6++)) {
                        }
                        k1Var = new k1((j)this.a.pop(), k1Var2, i);
                        k1Var2 = k1Var;
                    }
                    this.a.push(k1Var2);
                }
            } else {
            }
        }
    }

    private static final class c implements Iterator<com.google.protobuf.j.h> {

        private final ArrayDeque<com.google.protobuf.k1> a;
        private com.google.protobuf.j.h b;
        private c(com.google.protobuf.j j) {
            ArrayDeque arrayDeque;
            int i;
            Object obj3;
            super();
            if (j instanceof k1) {
                arrayDeque = new ArrayDeque((k1)j.y());
                this.a = arrayDeque;
                arrayDeque.push(j);
                this.b = b(k1.Z(j));
            } else {
                this.a = 0;
                this.b = (j.h)j;
            }
        }

        c(com.google.protobuf.j j, com.google.protobuf.k1.a k1$a2) {
            super(j);
        }

        private com.google.protobuf.j.h b(com.google.protobuf.j j) {
            while (j instanceof k1) {
                this.a.push((k1)j);
                final com.google.protobuf.j obj2 = k1.Z(j);
            }
            return (j.h)j;
        }

        private com.google.protobuf.j.h c() {
            ArrayDeque empty;
            empty = this.a;
            while (empty != null) {
                com.google.protobuf.j.h hVar = b(k1.a0((k1)this.a.pop()));
                empty = this.a;
            }
            return null;
        }

        @Override // java.util.Iterator
        public com.google.protobuf.j.h d() {
            com.google.protobuf.j.h hVar = this.b;
            if (hVar == null) {
            } else {
                this.b = c();
                return hVar;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i;
            i = this.b != null ? 1 : 0;
            return i;
        }

        @Override // java.util.Iterator
        public Object next() {
            return d();
        }

        @Override // java.util.Iterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }

    class a extends com.google.protobuf.j.b {

        final com.google.protobuf.k1.c a;
        com.google.protobuf.j.f b;
        final com.google.protobuf.k1 c;
        a(com.google.protobuf.k1 k1) {
            this.c = k1;
            super();
            k1.c cVar = new k1.c(k1, 0);
            this.a = cVar;
            this.b = c();
        }

        private com.google.protobuf.j.f c() {
            com.google.protobuf.j.f fVar;
            if (this.a.hasNext()) {
                fVar = this.a.d().C();
            } else {
                fVar = 0;
            }
            return fVar;
        }

        @Override // com.google.protobuf.j$b
        public byte a() {
            boolean next;
            com.google.protobuf.j.f fVar = this.b;
            if (fVar == null) {
            } else {
                if (!this.b.hasNext()) {
                    this.b = c();
                }
                return fVar.a();
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // com.google.protobuf.j$b
        public boolean hasNext() {
            int i;
            i = this.b != null ? 1 : 0;
            return i;
        }
    }
    static {
        int[] iArr = new int[47];
        iArr = new int[]{
            1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
            89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765,
            10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040,
            1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155,
            165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, 2147483647
        };
        k1.c = iArr;
    }

    private k1(com.google.protobuf.j j, com.google.protobuf.j j2) {
        super();
        this.left = j;
        this.right = j2;
        int size = j.size();
        this.leftLength = size;
        this.totalLength = size += size2;
        this.treeDepth = obj3++;
    }

    k1(com.google.protobuf.j j, com.google.protobuf.j j2, com.google.protobuf.k1.a k1$a3) {
        super(j, j2);
    }

    static com.google.protobuf.j Z(com.google.protobuf.k1 k1) {
        return k1.left;
    }

    static com.google.protobuf.j a0(com.google.protobuf.k1 k1) {
        return k1.right;
    }

    static com.google.protobuf.j c0(com.google.protobuf.j j, com.google.protobuf.j j2) {
        int i2;
        boolean z;
        int i;
        int size;
        if (j2.size() == 0) {
            return j;
        }
        if (j.size() == 0) {
            return j2;
        }
        size4 += size5;
        i2 = 128;
        if (i3 < i2) {
            return k1.d0(j, j2);
        }
        z = j;
        if (j instanceof k1 && size6 += size < i2) {
            z = j;
            if (size6 += size < i2) {
                k1 obj6 = new k1(z.left, k1.d0(z.right, j2));
                return obj6;
            }
            if (z.left.y() > z.right.y() && (k1)(k1)z.y() > j2.y()) {
                if (z.y() > j2.y()) {
                    k1 obj5 = new k1(z.right, j2);
                    obj6 = new k1(z.left, obj5);
                    return obj6;
                }
            }
        }
        if (i3 >= k1.f0(i5++)) {
            k1 k1Var = new k1(j, j2);
            return k1Var;
        }
        k1.b bVar = new k1.b(0);
        return k1.b.a(bVar, j, j2);
    }

    private static com.google.protobuf.j d0(com.google.protobuf.j j, com.google.protobuf.j j2) {
        final int size = j.size();
        final int size2 = j2.size();
        byte[] bArr = new byte[size + size2];
        final int i2 = 0;
        j.v(bArr, i2, i2, size);
        j2.v(bArr, i2, size, size2);
        return j.W(bArr);
    }

    private boolean e0(com.google.protobuf.j j) {
        Object next;
        int i2;
        int i6;
        int i5;
        int i3;
        int i;
        int i4;
        int totalLength;
        boolean z;
        Object obj12;
        int i7 = 0;
        k1.c cVar = new k1.c(this, i7);
        next = cVar.next();
        k1.c cVar2 = new k1.c(j, i7);
        obj12 = cVar2.next();
        int i8 = 0;
        i5 = i6;
        size -= i2;
        size2 -= i6;
        i4 = Math.min(i3, i);
        while (i2 == 0) {
            z = next.Z(obj12, i6, i4);
            i5 += i4;
            totalLength = this.totalLength;
            if (i4 == i3) {
            } else {
            }
            i2 += i4;
            if (i4 == i) {
            } else {
            }
            i6 += i4;
            size -= i2;
            size2 -= i6;
            i4 = Math.min(i3, i);
            z = obj12.Z(next, i2, i4);
            obj12 = cVar2.next();
            i6 = i8;
            next = cVar.next();
            i2 = i8;
        }
        return i8;
    }

    static int f0(int i) {
        final int[] iArr = k1.c;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
        throw obj2;
    }

    @Override // com.google.protobuf.j
    protected boolean A() {
        int i;
        i = this.totalLength >= k1.f0(this.treeDepth) ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.j
    public boolean B() {
        int i;
        i = 0;
        com.google.protobuf.j right = this.right;
        if (right.I(this.left.I(i, i, this.leftLength), i, right.size()) == 0) {
            i = 1;
        }
        return i;
    }

    @Override // com.google.protobuf.j
    public com.google.protobuf.j.f C() {
        k1.a aVar = new k1.a(this);
        return aVar;
    }

    @Override // com.google.protobuf.j
    public com.google.protobuf.k E() {
        return k.h(b0(), true);
    }

    @Override // com.google.protobuf.j
    protected int G(int i, int i2, int i3) {
        int leftLength = this.leftLength;
        if (i2 + i3 <= leftLength) {
            return this.left.G(i, i2, i3);
        }
        if (i2 >= leftLength) {
            return this.right.G(i, i2 -= leftLength, i3);
        }
        leftLength -= i2;
        return this.right.G(this.left.G(i, i2, i6), 0, i3 -= i6);
    }

    @Override // com.google.protobuf.j
    protected int I(int i, int i2, int i3) {
        int leftLength = this.leftLength;
        if (i2 + i3 <= leftLength) {
            return this.left.I(i, i2, i3);
        }
        if (i2 >= leftLength) {
            return this.right.I(i, i2 -= leftLength, i3);
        }
        leftLength -= i2;
        return this.right.I(this.left.I(i, i2, i6), 0, i3 -= i6);
    }

    @Override // com.google.protobuf.j
    public com.google.protobuf.j N(int i, int i2) {
        int i3 = j.i(i, i2, this.totalLength);
        if (i3 == 0) {
            return j.a;
        }
        if (i3 == this.totalLength) {
            return this;
        }
        int leftLength = this.leftLength;
        if (i2 <= leftLength) {
            return this.left.N(i, i2);
        }
        if (i >= leftLength) {
            return this.right.N(i -= leftLength, i2 -= leftLength);
        }
        k1 k1Var = new k1(this.left.L(i), this.right.N(0, i2 -= leftLength2));
        return k1Var;
    }

    @Override // com.google.protobuf.j
    protected String Q(Charset charset) {
        String string = new String(O(), charset);
        return string;
    }

    @Override // com.google.protobuf.j
    void Y(com.google.protobuf.i i) {
        this.left.Y(i);
        this.right.Y(i);
    }

    @Override // com.google.protobuf.j
    public ByteBuffer b() {
        return ByteBuffer.wrap(O()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> b0() {
        int i;
        ArrayList arrayList = new ArrayList();
        k1.c cVar = new k1.c(this, 0);
        while (cVar.hasNext()) {
            arrayList.add(cVar.d().b());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.j
    public boolean equals(Object object) {
        int i = 1;
        if (object == this) {
            return i;
        }
        final int i4 = 0;
        if (!object instanceof j) {
            return i4;
        }
        if (this.totalLength != (j)object.size()) {
            return i4;
        }
        if (this.totalLength == 0) {
            return i;
        }
        int i2 = J();
        int i3 = object.J();
        if (i2 != 0 && i3 != 0 && i2 != i3) {
            if (i3 != 0) {
                if (i2 != i3) {
                    return i4;
                }
            }
        }
        return e0(object);
    }

    @Override // com.google.protobuf.j
    public byte g(int i) {
        j.h(i, this.totalLength);
        return z(i);
    }

    @Override // com.google.protobuf.j
    public Iterator iterator() {
        return C();
    }

    @Override // com.google.protobuf.j
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.j
    protected void w(byte[] bArr, int i2, int i3, int i4) {
        com.google.protobuf.j right;
        int leftLength;
        int obj4;
        int obj5;
        int obj6;
        leftLength = this.leftLength;
        if (i2 + i4 <= leftLength) {
            this.left.w(bArr, i2, i3, i4);
        } else {
            if (i2 >= leftLength) {
                this.right.w(bArr, i2 -= leftLength, i3, i4);
            } else {
                leftLength -= i2;
                this.left.w(bArr, i2, i3, leftLength);
                this.right.w(bArr, 0, i3 += leftLength, i4 -= leftLength);
            }
        }
    }

    @Override // com.google.protobuf.j
    Object writeReplace() {
        return j.W(O());
    }

    @Override // com.google.protobuf.j
    protected int y() {
        return this.treeDepth;
    }

    @Override // com.google.protobuf.j
    byte z(int i) {
        int leftLength = this.leftLength;
        if (i < leftLength) {
            return this.left.z(i);
        }
        return this.right.z(i -= leftLength);
    }
}
