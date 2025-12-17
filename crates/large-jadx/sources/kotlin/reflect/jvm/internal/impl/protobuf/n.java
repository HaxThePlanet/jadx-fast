package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
class n extends kotlin.reflect.jvm.internal.impl.protobuf.d {

    protected final byte[] b;
    private int c = 0;

    static class a {
    }

    private class b implements kotlin.reflect.jvm.internal.impl.protobuf.d.a {

        private int a;
        private final int b;
        final kotlin.reflect.jvm.internal.impl.protobuf.n c;
        private b(kotlin.reflect.jvm.internal.impl.protobuf.n n) {
            this.c = n;
            super();
            this.a = 0;
            this.b = n.size();
        }

        b(kotlin.reflect.jvm.internal.impl.protobuf.n n, kotlin.reflect.jvm.internal.impl.protobuf.n.a n$a2) {
            super(n);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public byte a() {
            try {
                final int i = this.a;
                this.a = i + 1;
                return nVar.b[i];
                Throwable message = message.getMessage();
                NoSuchElementException noSuchElementException = new NoSuchElementException(message);
                throw noSuchElementException;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public Byte b() {
            return Byte.valueOf(a());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public boolean hasNext() {
            int i;
            i = this.a < this.b ? 1 : 0;
            return i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public Object next() {
            return b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            throw unsupportedOperationException;
        }
    }
    n(byte[] bArr) {
        super();
        final int i = 0;
        this.b = bArr;
    }

    static int N(int i, byte[] b2Arr2, int i3, int i4) {
        int i2;
        byte b;
        int obj2;
        i2 = i3;
        while (i2 < i3 + i4) {
            obj2 += b;
            i2++;
        }
        return obj2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int A() {
        return this.c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String C(String string) {
        String string2 = new String(this.b, L(), size(), string);
        return string2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void G(OutputStream outputStream, int i2, int i3) {
        outputStream.write(this.b, i += i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public byte I(int i) {
        return this.b[i];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    boolean J(kotlin.reflect.jvm.internal.impl.protobuf.n n, int i2, int i3) {
        byte b;
        int obj5;
        int obj6;
        int obj7;
        if (i3 > n.size()) {
        } else {
            if (i2 + i3 > n.size()) {
            } else {
                obj7 = L();
                obj5 += i2;
                while (obj7 < i5 += i3) {
                    obj7++;
                    obj5++;
                }
                return 1;
            }
            StringBuilder stringBuilder2 = new StringBuilder(59);
            stringBuilder2.append("Ran off end of other: ");
            stringBuilder2.append(i2);
            obj6 = ", ";
            stringBuilder2.append(obj6);
            stringBuilder2.append(i3);
            stringBuilder2.append(obj6);
            stringBuilder2.append(n.size());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("Length too large: ");
        stringBuilder.append(i3);
        stringBuilder.append(size());
        obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int L() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean equals(Object object) {
        int i = 1;
        if (object == this) {
            return i;
        }
        int i2 = 0;
        if (!object instanceof d) {
            return i2;
        }
        if (size() != (d)object.size()) {
            return i2;
        }
        if (size() == 0) {
            return i;
        }
        if (object instanceof n) {
            return J((n)object, i2, size());
        }
        if (!object instanceof s) {
        } else {
            return object.equals(this);
        }
        String obj5 = String.valueOf(String.valueOf(object.getClass()));
        StringBuilder stringBuilder = new StringBuilder(length += 49);
        stringBuilder.append("Has a new type of ByteString been created? Found ");
        stringBuilder.append(obj5);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int hashCode() {
        int i2;
        int i;
        int size = size();
        if (this.c == 0 && y(size, 0, size) == 0) {
            size = size();
            if (y(size, 0, size) == 0) {
                i2 = 1;
            }
            this.c = i2;
        }
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public Iterator iterator() {
        return u();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void p(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.b, i2, bArr, i3, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int q() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean s() {
        return 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return bArr.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean t() {
        int i = L();
        return v.f(this.b, i, size += i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.d.a u() {
        n.b bVar = new n.b(this, 0);
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.e v() {
        return e.h(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int y(int i, int i2, int i3) {
        return n.N(i, this.b, i4 += i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int z(int i, int i2, int i3) {
        i4 += i2;
        return v.g(i, this.b, i5, i3 += i5);
    }
}
