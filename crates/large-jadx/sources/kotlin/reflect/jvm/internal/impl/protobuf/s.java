package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

/* loaded from: classes3.dex */
class s extends kotlin.reflect.jvm.internal.impl.protobuf.d {

    private static final int[] z;
    private final int b;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d c;
    private final kotlin.reflect.jvm.internal.impl.protobuf.d v;
    private final int w;
    private final int x;
    private int y;

    static class a {
    }

    private static class b {

        private final Stack<kotlin.reflect.jvm.internal.impl.protobuf.d> a;
        private b() {
            super();
            Stack stack = new Stack();
            this.a = stack;
        }

        b(kotlin.reflect.jvm.internal.impl.protobuf.s.a s$a) {
            super();
        }

        static kotlin.reflect.jvm.internal.impl.protobuf.d a(kotlin.reflect.jvm.internal.impl.protobuf.s.b s$b, kotlin.reflect.jvm.internal.impl.protobuf.d d2, kotlin.reflect.jvm.internal.impl.protobuf.d d3) {
            return b.b(d2, d3);
        }

        private kotlin.reflect.jvm.internal.impl.protobuf.d b(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.d d2) {
            kotlin.reflect.jvm.internal.impl.protobuf.s sVar;
            int i;
            Object obj3;
            kotlin.reflect.jvm.internal.impl.protobuf.d obj4;
            c(d);
            c(d2);
            obj3 = this.a.pop();
            while (!this.a.isEmpty()) {
                sVar = new s((d)this.a.pop(), obj3, 0);
                obj3 = sVar;
            }
            return obj3;
        }

        private void c(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
            boolean z;
            kotlin.reflect.jvm.internal.impl.protobuf.d obj4;
            if (d.s()) {
                e(d);
            } else {
                if (!d instanceof s) {
                } else {
                    c(s.I((s)d));
                    c(s.J(d));
                }
            }
            obj4 = String.valueOf(String.valueOf(d.getClass()));
            StringBuilder stringBuilder = new StringBuilder(length += 49);
            stringBuilder.append("Has a new type of ByteString been created? Found ");
            stringBuilder.append(obj4);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        private int d(int i) {
            int obj2;
            obj2 = Arrays.binarySearch(s.L(), i);
            if (obj2 < 0) {
                obj2--;
            }
            return obj2;
        }

        private void e(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
            Object sVar;
            Object sVar2;
            boolean empty;
            int i;
            kotlin.reflect.jvm.internal.impl.protobuf.s sVar3;
            Object obj6;
            int i2 = d(d.size());
            if (!this.a.isEmpty()) {
                if ((d)this.a.peek().size() >= s.L()[i2 + 1]) {
                    this.a.push(d);
                } else {
                    sVar2 = this.a.pop();
                    i = 0;
                    while (!this.a.isEmpty()) {
                        if ((d)this.a.peek().size() < s.L()[i2]) {
                        }
                        sVar3 = new s((d)this.a.pop(), sVar2, i);
                        sVar2 = sVar3;
                        i = 0;
                    }
                    sVar = new s(sVar2, d, i);
                    while (!this.a.isEmpty()) {
                        if ((d)this.a.peek().size() < s.L()[obj6++]) {
                        }
                        sVar2 = new s((d)this.a.pop(), sVar, i);
                        sVar = sVar2;
                    }
                    this.a.push(sVar);
                }
            } else {
            }
        }
    }

    private static class c implements Iterator<kotlin.reflect.jvm.internal.impl.protobuf.n> {

        private final Stack<kotlin.reflect.jvm.internal.impl.protobuf.s> a;
        private kotlin.reflect.jvm.internal.impl.protobuf.n b;
        private c(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
            super();
            Stack stack = new Stack();
            this.a = stack;
            this.b = b(d);
        }

        c(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.s.a s$a2) {
            super(d);
        }

        private kotlin.reflect.jvm.internal.impl.protobuf.n b(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
            while (d instanceof s) {
                this.a.push((s)d);
                final kotlin.reflect.jvm.internal.impl.protobuf.d obj2 = s.I(d);
            }
            return (n)d;
        }

        private kotlin.reflect.jvm.internal.impl.protobuf.n c() {
            while (this.a.isEmpty()) {
                kotlin.reflect.jvm.internal.impl.protobuf.n nVar = b(s.J((s)this.a.pop()));
            }
            return null;
        }

        @Override // java.util.Iterator
        public kotlin.reflect.jvm.internal.impl.protobuf.n d() {
            kotlin.reflect.jvm.internal.impl.protobuf.n nVar = this.b;
            if (nVar == null) {
            } else {
                this.b = c();
                return nVar;
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

    private class e extends InputStream {

        private kotlin.reflect.jvm.internal.impl.protobuf.s.c a;
        private kotlin.reflect.jvm.internal.impl.protobuf.n b;
        private int c;
        private int v;
        private int w;
        private int x;
        final kotlin.reflect.jvm.internal.impl.protobuf.s y;
        public e(kotlin.reflect.jvm.internal.impl.protobuf.s s) {
            this.y = s;
            super();
            c();
        }

        private void a() {
            kotlin.reflect.jvm.internal.impl.protobuf.n size;
            int next;
            next = this.c;
            if (this.b != null && this.v == next) {
                next = this.c;
                if (this.v == next) {
                    this.w = i += next;
                    size = 0;
                    this.v = size;
                    if (this.a.hasNext()) {
                        kotlin.reflect.jvm.internal.impl.protobuf.n nVar = this.a.d();
                        this.b = nVar;
                        this.c = nVar.size();
                    } else {
                        this.b = 0;
                        this.c = size;
                    }
                }
            }
        }

        private void c() {
            s.c cVar = new s.c(this.y, 0);
            this.a = cVar;
            kotlin.reflect.jvm.internal.impl.protobuf.n nVar = cVar.d();
            this.b = nVar;
            this.c = nVar.size();
            int i = 0;
            this.v = i;
            this.w = i;
        }

        private int e(byte[] bArr, int i2, int i3) {
            int i6;
            int i5;
            int i4;
            int i7;
            int i;
            int obj6;
            i6 = i3;
            while (i6 > 0) {
                a();
                i5 = Math.min(i8 -= i7, i6);
                if (bArr != null) {
                }
                this.v = i10 += i5;
                i6 -= i5;
                this.b.m(bArr, this.v, obj6, i5);
                obj6 += i5;
            }
            return i3 -= i6;
        }

        @Override // java.io.InputStream
        public int available() {
            return size -= i2;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            this.x = obj2 += i2;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return 1;
        }

        @Override // java.io.InputStream
        public int read() {
            a();
            kotlin.reflect.jvm.internal.impl.protobuf.n nVar = this.b;
            if (nVar == null) {
                return -1;
            }
            final int i3 = this.v;
            this.v = i3 + 1;
            return b &= 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int i;
            Objects.requireNonNull(bArr);
            if (i2 < 0) {
            } else {
                if (i3 < 0) {
                } else {
                    if (i3 > length -= i2) {
                    } else {
                        return e(bArr, i2, i3);
                    }
                }
            }
            IndexOutOfBoundsException obj2 = new IndexOutOfBoundsException();
            throw obj2;
        }

        @Override // java.io.InputStream
        public void reset() {
            c();
            e(0, 0, this.x);
            return;
            synchronized (this) {
                c();
                e(0, 0, this.x);
            }
        }

        @Override // java.io.InputStream
        public long skip(long l) {
            int obj4;
            if (Long.compare(l, i) < 0) {
            } else {
                int i2 = Integer.MAX_VALUE;
                if (Long.compare(l, i2) > 0) {
                    obj4 = i2;
                }
                return (long)obj4;
            }
            obj4 = new IndexOutOfBoundsException();
            throw obj4;
        }
    }

    private class d implements kotlin.reflect.jvm.internal.impl.protobuf.d.a {

        private final kotlin.reflect.jvm.internal.impl.protobuf.s.c a;
        private kotlin.reflect.jvm.internal.impl.protobuf.d.a b;
        int c;
        private d(kotlin.reflect.jvm.internal.impl.protobuf.s s) {
            super();
            s.c cVar = new s.c(s, 0);
            this.a = cVar;
            this.b = cVar.d().u();
            this.c = s.size();
        }

        d(kotlin.reflect.jvm.internal.impl.protobuf.s s, kotlin.reflect.jvm.internal.impl.protobuf.s.a s$a2) {
            super(s);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public byte a() {
            boolean next;
            if (!this.b.hasNext()) {
                this.b = this.a.d().u();
            }
            this.c = i--;
            return this.b.a();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public Byte b() {
            return Byte.valueOf(a());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d$a
        public boolean hasNext() {
            int i;
            i = this.c > 0 ? 1 : 0;
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
    static {
        int i2;
        int i3;
        int i;
        Integer intValue;
        int i4;
        ArrayList arrayList = new ArrayList();
        i = i2;
        while (i2 > 0) {
            arrayList.add(Integer.valueOf(i2));
            i = i2;
            i2 = i4;
        }
        arrayList.add(Integer.valueOf(Integer.MAX_VALUE));
        s.z = new int[arrayList.size()];
        i3 = 0;
        i = s.z;
        while (i3 < i.length) {
            i[i3] = (Integer)arrayList.get(i3).intValue();
            i3++;
            i = s.z;
        }
    }

    private s(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.d d2) {
        super();
        this.y = 0;
        this.c = d;
        this.v = d2;
        int size = d.size();
        this.w = size;
        this.b = size += size2;
        this.x = obj3++;
    }

    s(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.d d2, kotlin.reflect.jvm.internal.impl.protobuf.s.a s$a3) {
        super(d, d2);
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.d I(kotlin.reflect.jvm.internal.impl.protobuf.s s) {
        return s.c;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.d J(kotlin.reflect.jvm.internal.impl.protobuf.s s) {
        return s.v;
    }

    static int[] L() {
        return s.z;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.d N(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.d d2) {
        Object sVar;
        int i;
        int size;
        int i2;
        int i3;
        int size2;
        Object obj6;
        kotlin.reflect.jvm.internal.impl.protobuf.d obj7;
        i = 0;
        if (d instanceof s) {
            sVar = d;
        } else {
            sVar = i;
        }
        if (d2.size() == 0) {
        } else {
            if (d.size() == 0) {
                obj6 = obj7;
            } else {
            }
        }
        return obj6;
    }

    private static kotlin.reflect.jvm.internal.impl.protobuf.n O(kotlin.reflect.jvm.internal.impl.protobuf.d d, kotlin.reflect.jvm.internal.impl.protobuf.d d2) {
        final int size = d.size();
        final int size2 = d2.size();
        byte[] bArr = new byte[size + size2];
        final int i2 = 0;
        d.m(bArr, i2, i2, size);
        d2.m(bArr, i2, size, size2);
        n obj4 = new n(bArr);
        return obj4;
    }

    private boolean P(kotlin.reflect.jvm.internal.impl.protobuf.d d) {
        Object next;
        int i4;
        int i7;
        int i2;
        int i3;
        int i6;
        int i;
        int i5;
        boolean z;
        Object obj12;
        int i8 = 0;
        s.c cVar = new s.c(this, i8);
        next = cVar.next();
        s.c cVar2 = new s.c(d, i8);
        obj12 = cVar2.next();
        int i9 = 0;
        i2 = i7;
        size -= i4;
        size2 -= i7;
        i = Math.min(i3, i6);
        while (i4 == 0) {
            z = next.J(obj12, i7, i);
            i2 += i;
            i5 = this.b;
            if (i == i3) {
            } else {
            }
            i4 += i;
            if (i == i6) {
            } else {
            }
            i7 += i;
            size -= i4;
            size2 -= i7;
            i = Math.min(i3, i6);
            z = obj12.J(next, i4, i);
            obj12 = cVar2.next();
            i7 = i9;
            next = cVar.next();
            i4 = i9;
        }
        return i9;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int A() {
        return this.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String C(String string) {
        String string2 = new String(B(), string);
        return string2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void G(OutputStream outputStream, int i2, int i3) {
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar;
        int i;
        int obj4;
        int obj5;
        i = this.w;
        if (i2 + i3 <= i) {
            this.c.G(outputStream, i2, i3);
        } else {
            if (i2 >= i) {
                this.v.G(outputStream, i2 -= i, i3);
            } else {
                i -= i2;
                this.c.G(outputStream, i2, i);
                this.v.G(outputStream, 0, i3 -= i);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean equals(Object object) {
        int i;
        int i2;
        int i3 = 1;
        if (object == this) {
            return i3;
        }
        final int i5 = 0;
        if (!object instanceof d) {
            return i5;
        }
        if (this.b != (d)object.size()) {
            return i5;
        }
        if (this.b == 0) {
            return i3;
        }
        i = object.A();
        if (this.y != 0 && i != 0 && this.y != i) {
            i = object.A();
            if (i != 0) {
                if (this.y != i) {
                    return i5;
                }
            }
        }
        return P(object);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int hashCode() {
        int i2;
        int i;
        int i3 = this.b;
        if (this.y == 0 && y(i3, 0, i3) == 0) {
            i3 = this.b;
            if (y(i3, 0, i3) == 0) {
                i2 = 1;
            }
            this.y = i2;
        }
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public Iterator iterator() {
        return u();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void p(byte[] bArr, int i2, int i3, int i4) {
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar;
        int i;
        int obj4;
        int obj5;
        int obj6;
        i = this.w;
        if (i2 + i4 <= i) {
            this.c.p(bArr, i2, i3, i4);
        } else {
            if (i2 >= i) {
                this.v.p(bArr, i2 -= i, i3, i4);
            } else {
                i -= i2;
                this.c.p(bArr, i2, i3, i);
                this.v.p(bArr, 0, i3 += i, i4 -= i);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int q() {
        return this.x;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean s() {
        int i;
        i = this.b >= s.z[this.x] ? 1 : 0;
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean t() {
        int i;
        i = 0;
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar2 = this.v;
        if (dVar2.z(this.c.z(i, i, this.w), i, dVar2.size()) == 0) {
            i = 1;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.d.a u() {
        s.d dVar = new s.d(this, 0);
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.e v() {
        s.e eVar = new s.e(this);
        return e.g(eVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int y(int i, int i2, int i3) {
        int i6 = this.w;
        if (i2 + i3 <= i6) {
            return this.c.y(i, i2, i3);
        }
        if (i2 >= i6) {
            return this.v.y(i, i2 -= i6, i3);
        }
        i6 -= i2;
        return this.v.y(this.c.y(i, i2, i7), 0, i3 -= i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int z(int i, int i2, int i3) {
        int i6 = this.w;
        if (i2 + i3 <= i6) {
            return this.c.z(i, i2, i3);
        }
        if (i2 >= i6) {
            return this.v.z(i, i2 -= i6, i3);
        }
        i6 -= i2;
        return this.v.z(this.c.z(i, i2, i7), 0, i3 -= i7);
    }
}
