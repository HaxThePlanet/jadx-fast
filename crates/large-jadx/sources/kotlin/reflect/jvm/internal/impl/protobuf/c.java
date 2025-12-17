package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
class c extends kotlin.reflect.jvm.internal.impl.protobuf.n {

    private final int v;
    private final int w;

    static class a {
    }

    private class b implements kotlin.reflect.jvm.internal.impl.protobuf.d.a {

        private int a;
        private final int b;
        final kotlin.reflect.jvm.internal.impl.protobuf.c c;
        private b(kotlin.reflect.jvm.internal.impl.protobuf.c c) {
            this.c = c;
            super();
            int i = c.L();
            this.a = i;
            this.b = i += obj2;
        }

        b(kotlin.reflect.jvm.internal.impl.protobuf.c c, kotlin.reflect.jvm.internal.impl.protobuf.c.a c$a2) {
            super(c);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public byte a() {
            int i = this.a;
            if (i >= this.b) {
            } else {
                this.a = i + 1;
                return cVar.b[i];
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
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
    c(byte[] bArr, int i2, int i3) {
        super(bArr);
        int i = 29;
        if (i2 < 0) {
        } else {
            if (i3 < 0) {
            } else {
                if (Long.compare(i4, l3) > 0) {
                } else {
                    this.v = i2;
                    this.w = i3;
                }
                StringBuilder stringBuilder = new StringBuilder(48);
                stringBuilder.append("Offset+Length too large: ");
                stringBuilder.append(i2);
                stringBuilder.append("+");
                stringBuilder.append(i3);
                IllegalArgumentException obj5 = new IllegalArgumentException(stringBuilder.toString());
                throw obj5;
            }
            StringBuilder obj7 = new StringBuilder(i);
            obj7.append("Length too small: ");
            obj7.append(i2);
            obj5 = new IllegalArgumentException(obj7.toString());
            throw obj5;
        }
        obj7 = new StringBuilder(i);
        obj7.append("Offset too small: ");
        obj7.append(i2);
        obj5 = new IllegalArgumentException(obj7.toString());
        throw obj5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public byte I(int i) {
        if (i < 0) {
        } else {
            if (i >= size()) {
            } else {
                return this.b[i2 += i];
            }
            StringBuilder stringBuilder2 = new StringBuilder(41);
            stringBuilder2.append("Index too large: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", ");
            stringBuilder2.append(size());
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            throw arrayIndexOutOfBoundsException;
        }
        StringBuilder stringBuilder = new StringBuilder(28);
        stringBuilder.append("Index too small: ");
        stringBuilder.append(i);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException2 = new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        throw arrayIndexOutOfBoundsException2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    protected int L() {
        return this.v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public Iterator iterator() {
        return u();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    protected void p(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.b, i += i2, bArr, i3, i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public int size() {
        return this.w;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public kotlin.reflect.jvm.internal.impl.protobuf.d.a u() {
        c.b bVar = new c.b(this, 0);
        return bVar;
    }
}
