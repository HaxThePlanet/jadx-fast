package com.google.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class j implements Iterable<Byte>, Serializable {

    public static final com.google.protobuf.j a;
    private static final com.google.protobuf.j.e b;
    private int hash = 0;

    private interface e {
        public abstract byte[] a(byte[] bArr, int i2, int i3);
    }

    public interface f extends Iterator<Byte> {
        @Override // java.util.Iterator
        public abstract byte a();
    }

    static final class g {

        private final com.google.protobuf.CodedOutputStream a;
        private final byte[] b;
        private g(int i) {
            super();
            byte[] obj1 = new byte[i];
            this.b = obj1;
            this.a = CodedOutputStream.h0(obj1);
        }

        g(int i, com.google.protobuf.j.a j$a2) {
            super(i);
        }

        public com.google.protobuf.j a() {
            this.a.d();
            j.i iVar = new j.i(this.b);
            return iVar;
        }

        public com.google.protobuf.CodedOutputStream b() {
            return this.a;
        }
    }

    static abstract class b implements com.google.protobuf.j.f {
        @Override // com.google.protobuf.j$f
        public final Byte b() {
            return Byte.valueOf(a());
        }

        @Override // com.google.protobuf.j$f
        public Object next() {
            return b();
        }

        @Override // com.google.protobuf.j$f
        public final void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }

    private static final class c implements com.google.protobuf.j.e {
        c(com.google.protobuf.j.a j$a) {
            super();
        }

        @Override // com.google.protobuf.j$e
        public byte[] a(byte[] bArr, int i2, int i3) {
            return Arrays.copyOfRange(bArr, i2, i3 += i2);
        }
    }

    static abstract class h extends com.google.protobuf.j {
        @Override // com.google.protobuf.j
        protected final boolean A() {
            return 1;
        }

        @Override // com.google.protobuf.j
        abstract boolean Z(com.google.protobuf.j j, int i2, int i3);

        @Override // com.google.protobuf.j
        public Iterator iterator() {
            return super.C();
        }

        @Override // com.google.protobuf.j
        protected final int y() {
            return 0;
        }
    }

    private static final class j implements com.google.protobuf.j.e {
        j(com.google.protobuf.j.a j$a) {
            super();
        }

        @Override // com.google.protobuf.j$e
        public byte[] a(byte[] bArr, int i2, int i3) {
            final byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
    }

    class a extends com.google.protobuf.j.b {

        private int a = 0;
        private final int b;
        final com.google.protobuf.j c;
        a(com.google.protobuf.j j) {
            this.c = j;
            super();
            final int i = 0;
            this.b = j.size();
        }

        @Override // com.google.protobuf.j$b
        public byte a() {
            int i = this.a;
            if (i >= this.b) {
            } else {
                this.a = i + 1;
                return this.c.z(i);
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }

        @Override // com.google.protobuf.j$b
        public boolean hasNext() {
            int i;
            i = this.a < this.b ? 1 : 0;
            return i;
        }
    }

    private static class i extends com.google.protobuf.j.h {

        private static final long serialVersionUID = 1L;
        protected final byte[] bytes;
        i(byte[] bArr) {
            super();
            Objects.requireNonNull(bArr);
            this.bytes = bArr;
        }

        @Override // com.google.protobuf.j$h
        public final boolean B() {
            int i = a0();
            return x1.t(this.bytes, i, size += i);
        }

        @Override // com.google.protobuf.j$h
        public final com.google.protobuf.k E() {
            return k.m(this.bytes, a0(), size(), true);
        }

        @Override // com.google.protobuf.j$h
        protected final int G(int i, int i2, int i3) {
            return c0.i(i, this.bytes, i4 += i2, i3);
        }

        @Override // com.google.protobuf.j$h
        protected final int I(int i, int i2, int i3) {
            i4 += i2;
            return x1.v(i, this.bytes, i5, i3 += i5);
        }

        @Override // com.google.protobuf.j$h
        public final com.google.protobuf.j N(int i, int i2) {
            final int obj5 = j.i(i, i2, size());
            if (obj5 == null) {
                return j.a;
            }
            j.d dVar = new j.d(this.bytes, i3 += i, obj5);
            return dVar;
        }

        @Override // com.google.protobuf.j$h
        protected final String Q(Charset charset) {
            String string = new String(this.bytes, a0(), size(), charset);
            return string;
        }

        @Override // com.google.protobuf.j$h
        final void Y(com.google.protobuf.i i) {
            i.b(this.bytes, a0(), size());
        }

        @Override // com.google.protobuf.j$h
        final boolean Z(com.google.protobuf.j j, int i2, int i3) {
            byte b;
            int obj6;
            int obj7;
            int obj8;
            if (i3 > j.size()) {
            } else {
                int i = i2 + i3;
                if (i > j.size()) {
                } else {
                    int i4 = 0;
                    if (j instanceof j.i) {
                        obj8 = a0();
                        obj6 += i2;
                        while (obj8 < i5 += i3) {
                            obj8++;
                            obj6++;
                        }
                        return 1;
                    }
                    return j.N(i2, i).equals(N(i4, i3));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Ran off end of other: ");
                stringBuilder.append(i2);
                obj7 = ", ";
                stringBuilder.append(obj7);
                stringBuilder.append(i3);
                stringBuilder.append(obj7);
                stringBuilder.append(j.size());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            obj7 = new StringBuilder();
            obj7.append("Length too large: ");
            obj7.append(i3);
            obj7.append(size());
            obj6 = new IllegalArgumentException(obj7.toString());
            throw obj6;
        }

        @Override // com.google.protobuf.j$h
        protected int a0() {
            return 0;
        }

        @Override // com.google.protobuf.j$h
        public final ByteBuffer b() {
            return ByteBuffer.wrap(this.bytes, a0(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.j$h
        public final boolean equals(Object object) {
            int i = 1;
            if (object == this) {
                return i;
            }
            final int i4 = 0;
            if (!object instanceof j) {
                return i4;
            }
            if (size() != (j)object.size()) {
                return i4;
            }
            if (size() == 0) {
                return i;
            }
            int i2 = J();
            int i3 = (j.i)object.J();
            if (object instanceof j.i && i2 != 0 && i3 != 0 && i2 != i3) {
                i2 = J();
                i3 = (j.i)object.J();
                if (i2 != 0) {
                    if (i3 != 0) {
                        if (i2 != i3) {
                            return i4;
                        }
                    }
                }
                return Z(object, i4, size());
            }
            return object.equals(this);
        }

        @Override // com.google.protobuf.j$h
        public byte g(int i) {
            return this.bytes[i];
        }

        @Override // com.google.protobuf.j$h
        public int size() {
            return bytes.length;
        }

        @Override // com.google.protobuf.j$h
        protected void w(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.bytes, i2, bArr, i3, i4);
        }

        @Override // com.google.protobuf.j$h
        byte z(int i) {
            return this.bytes[i];
        }
    }

    private static final class d extends com.google.protobuf.j.i {

        private static final long serialVersionUID = 1L;
        private final int bytesLength;
        private final int bytesOffset;
        d(byte[] bArr, int i2, int i3) {
            super(bArr);
            j.i(i2, i2 + i3, bArr.length);
            this.bytesOffset = i2;
            this.bytesLength = i3;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            InvalidObjectException obj2 = new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
            throw obj2;
        }

        @Override // com.google.protobuf.j$i
        protected int a0() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.j$i
        public byte g(int i) {
            j.h(i, size());
            return this.bytes[bytesOffset += i];
        }

        @Override // com.google.protobuf.j$i
        public int size() {
            return this.bytesLength;
        }

        @Override // com.google.protobuf.j$i
        protected void w(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.bytes, i += i2, bArr, i3, i4);
        }

        @Override // com.google.protobuf.j$i
        Object writeReplace() {
            return j.W(O());
        }

        @Override // com.google.protobuf.j$i
        byte z(int i) {
            return this.bytes[bytesOffset += i];
        }
    }
    static {
        Object jVar;
        j.i iVar = new j.i(c0.b);
        j.a = iVar;
        int i = 0;
        if (d.c()) {
            jVar = new j.j(i);
        } else {
            jVar = new j.c(i);
        }
        j.b = jVar;
    }

    j() {
        super();
        final int i = 0;
    }

    static com.google.protobuf.j.g D(int i) {
        j.g gVar = new j.g(i, 0);
        return gVar;
    }

    private String S() {
        String string;
        int str;
        int i;
        if (size() <= 50) {
            string = q1.a(this);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(q1.a(N(0, 47)));
            stringBuilder.append("...");
            string = stringBuilder.toString();
        }
        return string;
    }

    static com.google.protobuf.j U(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return j.X(byteBuffer.array(), arrayOffset += position, byteBuffer.remaining());
        }
        b1 b1Var = new b1(byteBuffer);
        return b1Var;
    }

    static com.google.protobuf.j W(byte[] bArr) {
        j.i iVar = new j.i(bArr);
        return iVar;
    }

    static com.google.protobuf.j X(byte[] bArr, int i2, int i3) {
        j.d dVar = new j.d(bArr, i2, i3);
        return dVar;
    }

    private static com.google.protobuf.j d(Iterator<com.google.protobuf.j> iterator, int i2) {
        int i;
        com.google.protobuf.j jVar;
        Object obj2;
        int obj3;
        i = 1;
        if (i2 < i) {
        } else {
            if (i2 == i) {
                obj2 = iterator.next();
            } else {
                i = i2 >>> 1;
                obj2 = j.d(iterator, i).l(j.d(iterator, i2 -= i));
            }
            return obj2;
        }
        Object[] arr = new Object[i];
        arr[0] = Integer.valueOf(i2);
        obj2 = new IllegalArgumentException(String.format("length (%s) must be >= 1", arr));
        throw obj2;
    }

    static void h(int i, int i2) {
        if (i4 |= i < 0 && i < 0) {
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Index < 0: ");
                stringBuilder.append(i);
                ArrayIndexOutOfBoundsException obj4 = new ArrayIndexOutOfBoundsException(stringBuilder.toString());
                throw obj4;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Index > length: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(i2);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            throw arrayIndexOutOfBoundsException;
        }
    }

    static int i(int i, int i2, int i3) {
        int i4 = i2 - i;
        if (i6 |= i8 < 0) {
            if (i < 0) {
            } else {
                if (i2 < i) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Beginning index larger than ending index: ");
                    stringBuilder.append(i);
                    stringBuilder.append(", ");
                    stringBuilder.append(i2);
                    IndexOutOfBoundsException obj5 = new IndexOutOfBoundsException(stringBuilder.toString());
                    throw obj5;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("End index: ");
                stringBuilder2.append(i2);
                stringBuilder2.append(" >= ");
                stringBuilder2.append(i3);
                IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException(stringBuilder2.toString());
                throw obj3;
            }
            obj5 = new StringBuilder();
            obj5.append("Beginning index: ");
            obj5.append(i);
            obj5.append(" < 0");
            IndexOutOfBoundsException obj4 = new IndexOutOfBoundsException(obj5.toString());
            throw obj4;
        }
        return i4;
    }

    public static com.google.protobuf.j m(Iterable<com.google.protobuf.j> iterable) {
        int size;
        Iterator iterator;
        boolean next;
        if (iterable instanceof Collection == null) {
            size = 0;
            iterator = iterable.iterator();
            for (Object item : iterator) {
                size++;
            }
        } else {
            size = (Collection)iterable.size();
        }
        if (size == 0) {
            return j.a;
        }
        return j.d(iterable.iterator(), size);
    }

    public static com.google.protobuf.j p(ByteBuffer byteBuffer) {
        return j.q(byteBuffer, byteBuffer.remaining());
    }

    public static com.google.protobuf.j q(ByteBuffer byteBuffer, int i2) {
        j.i(0, i2, byteBuffer.remaining());
        final byte[] obj3 = new byte[i2];
        byteBuffer.get(obj3);
        j.i obj2 = new j.i(obj3);
        return obj2;
    }

    public static com.google.protobuf.j s(byte[] bArr) {
        return j.t(bArr, 0, bArr.length);
    }

    public static com.google.protobuf.j t(byte[] bArr, int i2, int i3) {
        j.i(i2, i2 + i3, bArr.length);
        j.i iVar = new j.i(j.b.a(bArr, i2, i3));
        return iVar;
    }

    public static com.google.protobuf.j u(String string) {
        j.i iVar = new j.i(string.getBytes(c0.a));
        return iVar;
    }

    @Override // java.lang.Iterable
    protected abstract boolean A();

    @Override // java.lang.Iterable
    public abstract boolean B();

    @Override // java.lang.Iterable
    public com.google.protobuf.j.f C() {
        j.a aVar = new j.a(this);
        return aVar;
    }

    @Override // java.lang.Iterable
    public abstract com.google.protobuf.k E();

    @Override // java.lang.Iterable
    protected abstract int G(int i, int i2, int i3);

    @Override // java.lang.Iterable
    protected abstract int I(int i, int i2, int i3);

    @Override // java.lang.Iterable
    protected final int J() {
        return this.hash;
    }

    @Override // java.lang.Iterable
    public final com.google.protobuf.j L(int i) {
        return N(i, size());
    }

    @Override // java.lang.Iterable
    public abstract com.google.protobuf.j N(int i, int i2);

    @Override // java.lang.Iterable
    public final byte[] O() {
        int size = size();
        if (size == 0) {
            return c0.b;
        }
        final byte[] bArr2 = new byte[size];
        final int i = 0;
        w(bArr2, i, i, size);
        return bArr2;
    }

    @Override // java.lang.Iterable
    public final String P(Charset charset) {
        String obj2;
        if (size() == 0) {
            obj2 = "";
        } else {
            obj2 = Q(charset);
        }
        return obj2;
    }

    @Override // java.lang.Iterable
    protected abstract String Q(Charset charset);

    @Override // java.lang.Iterable
    public final String R() {
        return P(c0.a);
    }

    @Override // java.lang.Iterable
    abstract void Y(com.google.protobuf.i i);

    @Override // java.lang.Iterable
    public abstract ByteBuffer b();

    @Override // java.lang.Iterable
    public abstract boolean equals(Object object);

    @Override // java.lang.Iterable
    public abstract byte g(int i);

    @Override // java.lang.Iterable
    public final int hashCode() {
        int hash;
        int i;
        int size = size();
        if (this.hash == 0 && G(size, 0, size) == 0) {
            size = size();
            if (G(size, 0, size) == 0) {
                hash = 1;
            }
            this.hash = hash;
        }
        return hash;
    }

    @Override // java.lang.Iterable
    public final boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return C();
    }

    @Override // java.lang.Iterable
    public final com.google.protobuf.j l(com.google.protobuf.j j) {
        if (i -= size < j.size()) {
        } else {
            return k1.c0(this, j);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ByteString would be too long: ");
        stringBuilder.append(size());
        stringBuilder.append("+");
        stringBuilder.append(j.size());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // java.lang.Iterable
    public abstract int size();

    @Override // java.lang.Iterable
    public final String toString() {
        Object[] arr = new Object[3];
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), S());
    }

    @Deprecated
    public final void v(byte[] bArr, int i2, int i3, int i4) {
        j.i(i2, i2 + i4, size());
        j.i(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            w(bArr, i2, i3, i4);
        }
    }

    @Override // java.lang.Iterable
    protected abstract void w(byte[] bArr, int i2, int i3, int i4);

    @Override // java.lang.Iterable
    protected abstract int y();

    @Override // java.lang.Iterable
    abstract byte z(int i);
}
