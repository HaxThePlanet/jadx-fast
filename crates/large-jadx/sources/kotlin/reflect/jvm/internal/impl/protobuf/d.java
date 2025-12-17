package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class d implements Iterable<Byte> {

    public static final kotlin.reflect.jvm.internal.impl.protobuf.d a;

    public interface a extends Iterator<Byte> {
        @Override // java.util.Iterator
        public abstract byte a();
    }

    public static final class b extends OutputStream {

        private static final byte[] x;
        private final int a;
        private final ArrayList<kotlin.reflect.jvm.internal.impl.protobuf.d> b;
        private int c;
        private byte[] v;
        private int w;
        static {
            d.b.x = new byte[0];
        }

        b(int i) {
            super();
            if (i < 0) {
            } else {
                this.a = i;
                ArrayList arrayList = new ArrayList();
                this.b = arrayList;
                this.v = new byte[i];
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Buffer size < 0");
            throw obj2;
        }

        private byte[] a(byte[] bArr, int i2) {
            final byte[] bArr2 = new byte[i2];
            int i = 0;
            System.arraycopy(bArr, i, bArr2, i, Math.min(bArr.length, i2));
            return bArr2;
        }

        private void c(int i) {
            n nVar = new n(this.v);
            this.b.add(nVar);
            i2 += length;
            this.c = i3;
            this.v = new byte[Math.max(this.a, Math.max(i, i3 >>>= 1))];
            this.w = 0;
        }

        private void e() {
            byte[] i;
            Object nVar;
            byte[] nVar2;
            i = this.w;
            nVar = this.v;
            if (i < nVar.length) {
                if (i > 0) {
                    nVar2 = new n(a(nVar, i));
                    this.b.add(nVar2);
                }
            } else {
                nVar = new n(this.v);
                this.b.add(nVar);
                this.v = d.b.x;
            }
            this.c = i2 += i5;
            this.w = 0;
        }

        @Override // java.io.OutputStream
        public int f() {
            return i += i3;
            synchronized (this) {
                return i += i3;
            }
        }

        @Override // java.io.OutputStream
        public kotlin.reflect.jvm.internal.impl.protobuf.d i() {
            e();
            return d.g(this.b);
            synchronized (this) {
                e();
                return d.g(this.b);
            }
        }

        @Override // java.io.OutputStream
        public String toString() {
            Object[] arr = new Object[2];
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(f()));
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            int i2;
            synchronized (this) {
                try {
                    c(1);
                    int i3 = this.w;
                    this.w = i3 + 1;
                    this.v[i3] = (byte)i;
                    throw i;
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            byte[] bArr2;
            int i;
            int obj4;
            int obj5;
            int obj6;
            bArr2 = this.v;
            final int i5 = this.w;
            synchronized (this) {
                try {
                    System.arraycopy(bArr, i2, bArr2, i5, i3);
                    this.w = obj4 += i3;
                    length2 -= i5;
                    System.arraycopy(bArr, i2, bArr2, i5, i4);
                    i3 -= i4;
                    c(obj6);
                    System.arraycopy(bArr, i2 += i4, this.v, 0, obj6);
                    this.w = obj6;
                    throw bArr;
                }
            }
        }
    }
    static {
        Class<kotlin.reflect.jvm.internal.impl.protobuf.d> obj = d.class;
        n nVar = new n(new byte[0]);
        d.a = nVar;
    }

    private static kotlin.reflect.jvm.internal.impl.protobuf.d b(Iterator<kotlin.reflect.jvm.internal.impl.protobuf.d> iterator, int i2) {
        int i;
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar;
        Object obj2;
        int obj3;
        if (i2 == 1) {
            obj2 = iterator.next();
        } else {
            i = i2 >>> 1;
            obj2 = d.b(iterator, i).d(d.b(iterator, i2 -= i));
        }
        return obj2;
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.d g(Iterable<kotlin.reflect.jvm.internal.impl.protobuf.d> iterable) {
        Object arrayList;
        boolean next;
        Object obj2;
        if (iterable instanceof Collection == null) {
            arrayList = new ArrayList();
            obj2 = iterable.iterator();
            for (d next : obj2) {
                arrayList.add(next);
            }
        } else {
            arrayList = iterable;
        }
        if (arrayList.isEmpty()) {
            obj2 = d.a;
        } else {
            obj2 = d.b(arrayList.iterator(), arrayList.size());
        }
        return obj2;
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.d h(byte[] bArr) {
        return d.i(bArr, 0, bArr.length);
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.d i(byte[] bArr, int i2, int i3) {
        final byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        n obj2 = new n(bArr2);
        return obj2;
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.d l(String string) {
        try {
            n nVar = new n(string.getBytes("UTF-8"));
            return nVar;
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", string);
            throw runtimeException;
        }
    }

    public static kotlin.reflect.jvm.internal.impl.protobuf.d.b w() {
        d.b bVar = new d.b(128);
        return bVar;
    }

    @Override // java.lang.Iterable
    protected abstract int A();

    @Override // java.lang.Iterable
    public byte[] B() {
        int size = size();
        if (size == 0) {
            return i.a;
        }
        final byte[] bArr2 = new byte[size];
        final int i = 0;
        p(bArr2, i, i, size);
        return bArr2;
    }

    @Override // java.lang.Iterable
    public abstract String C(String string);

    @Override // java.lang.Iterable
    public String D() {
        try {
            return C("UTF-8");
            RuntimeException runtimeException = new RuntimeException("UTF-8 not supported?", th);
            throw runtimeException;
        }
    }

    @Override // java.lang.Iterable
    void E(OutputStream outputStream, int i2, int i3) {
        if (i2 < 0) {
        } else {
            if (i3 < 0) {
            } else {
                int i4 = i2 + i3;
                if (i4 > size()) {
                } else {
                    if (i3 > 0) {
                        G(outputStream, i2, i3);
                    }
                }
                StringBuilder obj4 = new StringBuilder(39);
                obj4.append("Source end offset exceeded: ");
                obj4.append(i4);
                IndexOutOfBoundsException obj3 = new IndexOutOfBoundsException(obj4.toString());
                throw obj3;
            }
            obj4 = new StringBuilder(23);
            obj4.append("Length < 0: ");
            obj4.append(i3);
            obj3 = new IndexOutOfBoundsException(obj4.toString());
            throw obj3;
        }
        StringBuilder obj5 = new StringBuilder(30);
        obj5.append("Source offset < 0: ");
        obj5.append(i2);
        obj3 = new IndexOutOfBoundsException(obj5.toString());
        throw obj3;
    }

    @Override // java.lang.Iterable
    abstract void G(OutputStream outputStream, int i2, int i3);

    @Override // java.lang.Iterable
    public kotlin.reflect.jvm.internal.impl.protobuf.d d(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
        int size = size();
        final int size2 = d.size();
        if (Long.compare(i, i3) >= 0) {
        } else {
            return s.N(this, d);
        }
        StringBuilder stringBuilder = new StringBuilder(53);
        stringBuilder.append("ByteString would be too long: ");
        stringBuilder.append(size);
        stringBuilder.append("+");
        stringBuilder.append(size2);
        IllegalArgumentException obj7 = new IllegalArgumentException(stringBuilder.toString());
        throw obj7;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return u();
    }

    @Override // java.lang.Iterable
    public void m(byte[] bArr, int i2, int i3, int i4) {
        int i = 30;
        if (i2 < 0) {
        } else {
            if (i3 < 0) {
            } else {
                if (i4 < 0) {
                } else {
                    int i5 = i2 + i4;
                    final int i7 = 34;
                    if (i5 > size()) {
                    } else {
                        int i6 = i3 + i4;
                        if (i6 > bArr.length) {
                        } else {
                            if (i4 > 0) {
                                p(bArr, i2, i3, i4);
                            }
                        }
                        StringBuilder obj5 = new StringBuilder(i7);
                        obj5.append("Target end offset < 0: ");
                        obj5.append(i6);
                        IndexOutOfBoundsException obj4 = new IndexOutOfBoundsException(obj5.toString());
                        throw obj4;
                    }
                    obj5 = new StringBuilder(i7);
                    obj5.append("Source end offset < 0: ");
                    obj5.append(i5);
                    obj4 = new IndexOutOfBoundsException(obj5.toString());
                    throw obj4;
                }
                obj5 = new StringBuilder(23);
                obj5.append("Length < 0: ");
                obj5.append(i4);
                obj4 = new IndexOutOfBoundsException(obj5.toString());
                throw obj4;
            }
            obj5 = new StringBuilder(i);
            obj5.append("Target offset < 0: ");
            obj5.append(i3);
            obj4 = new IndexOutOfBoundsException(obj5.toString());
            throw obj4;
        }
        StringBuilder obj6 = new StringBuilder(i);
        obj6.append("Source offset < 0: ");
        obj6.append(i2);
        obj4 = new IndexOutOfBoundsException(obj6.toString());
        throw obj4;
    }

    @Override // java.lang.Iterable
    protected abstract void p(byte[] bArr, int i2, int i3, int i4);

    @Override // java.lang.Iterable
    protected abstract int q();

    @Override // java.lang.Iterable
    protected abstract boolean s();

    @Override // java.lang.Iterable
    public abstract int size();

    @Override // java.lang.Iterable
    public abstract boolean t();

    @Override // java.lang.Iterable
    public String toString() {
        Object[] arr = new Object[2];
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.lang.Iterable
    public abstract kotlin.reflect.jvm.internal.impl.protobuf.d.a u();

    @Override // java.lang.Iterable
    public abstract kotlin.reflect.jvm.internal.impl.protobuf.e v();

    @Override // java.lang.Iterable
    protected abstract int y(int i, int i2, int i3);

    @Override // java.lang.Iterable
    protected abstract int z(int i, int i2, int i3);
}
