package com.mp4parser.iso23001.part7;

import f.b.a.c;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class a {

    public byte[] a;
    public com.mp4parser.iso23001.part7.a.j[] b = null;

    public interface j {
        public abstract long a();

        public abstract int clear();
    }

    private abstract class a implements com.mp4parser.iso23001.part7.a.j {
        private a(com.mp4parser.iso23001.part7.a a) {
            super();
        }

        a(com.mp4parser.iso23001.part7.a a, com.mp4parser.iso23001.part7.a.a a$a2) {
            super(a);
        }

        @Override // com.mp4parser.iso23001.part7.a$j
        public boolean equals(Object object) {
            Class class2;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (getClass() != object.getClass()) {
                } else {
                    if (clear() != (a.j)object.clear()) {
                        return i2;
                    }
                    if (Long.compare(l, l2) != 0) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        @Override // com.mp4parser.iso23001.part7.a$j
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("P(");
            stringBuilder.append(clear());
            stringBuilder.append("|");
            stringBuilder.append(a());
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private class b extends com.mp4parser.iso23001.part7.a.a {

        private byte a;
        private byte b;
        public b(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (byte)i2;
            this.b = (byte)obj2;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class c extends com.mp4parser.iso23001.part7.a.a {

        private byte a;
        private int b;
        public c(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (byte)i2;
            this.b = (int)l3;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)i;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class d extends com.mp4parser.iso23001.part7.a.a {

        private byte a;
        private long b;
        public d(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (byte)i2;
            this.b = l3;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class e extends com.mp4parser.iso23001.part7.a.a {

        private byte a;
        private short b;
        public e(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (byte)i2;
            this.b = (short)obj2;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)s;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class f extends com.mp4parser.iso23001.part7.a.a {

        private int a;
        private byte b;
        public f(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = i2;
            this.b = (byte)obj2;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class g extends com.mp4parser.iso23001.part7.a.a {

        private int a;
        private int b;
        public g(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = i2;
            this.b = (int)l3;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)i;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class h extends com.mp4parser.iso23001.part7.a.a {

        private int a;
        private long b;
        public h(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = i2;
            this.b = l3;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class i extends com.mp4parser.iso23001.part7.a.a {

        private int a;
        private short b;
        public i(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = i2;
            this.b = (short)obj2;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)s;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class k extends com.mp4parser.iso23001.part7.a.a {

        private short a;
        private byte b;
        public k(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (short)i2;
            this.b = (byte)obj2;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class l extends com.mp4parser.iso23001.part7.a.a {

        private short a;
        private int b;
        public l(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (short)i2;
            this.b = (int)l3;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)i;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class m extends com.mp4parser.iso23001.part7.a.a {

        private short a;
        private long b;
        public m(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (short)i2;
            this.b = l3;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class n extends com.mp4parser.iso23001.part7.a.a {

        private short a;
        private short b;
        public n(com.mp4parser.iso23001.part7.a a, int i2, long l3) {
            super(a, 0);
            this.a = (short)i2;
            this.b = (short)obj2;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)s;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }
    public a() {
        super();
        this.a = new byte[0];
        int i2 = 0;
    }

    public com.mp4parser.iso23001.part7.a.j a(int i, long l2) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 32767;
        int i4 = 127;
        if (i <= 127 && Long.compare(l2, i4) <= 0) {
            if (Long.compare(l2, i4) <= 0) {
                a.b bVar = new a.b(this, i, l2, obj10);
                return bVar;
            }
            if (Long.compare(l2, i3) <= 0) {
                a.e eVar = new a.e(this, i, l2, obj10);
                return eVar;
            }
            if (Long.compare(l2, i2) <= 0) {
                a.c cVar = new a.c(this, i, l2, obj10);
                return cVar;
            }
            a.d dVar = new a.d(this, i, l2, obj10);
            return dVar;
        }
        if (i <= 32767 && Long.compare(l2, i4) <= 0) {
            if (Long.compare(l2, i4) <= 0) {
                a.k kVar = new a.k(this, i, l2, obj10);
                return kVar;
            }
            if (Long.compare(l2, i3) <= 0) {
                a.n nVar = new a.n(this, i, l2, obj10);
                return nVar;
            }
            if (Long.compare(l2, i2) <= 0) {
                a.l lVar = new a.l(this, i, l2, obj10);
                return lVar;
            }
            a.m mVar = new a.m(this, i, l2, obj10);
            return mVar;
        }
        if (Long.compare(l2, i4) <= 0) {
            a.f fVar = new a.f(this, i, l2, obj10);
            return fVar;
        }
        if (Long.compare(l2, i3) <= 0) {
            a.i iVar = new a.i(this, i, l2, obj10);
            return iVar;
        }
        if (Long.compare(l2, i2) <= 0) {
            a.g gVar = new a.g(this, i, l2, obj10);
            return gVar;
        }
        a.h hVar = new a.h(this, i, l2, obj10);
        return hVar;
    }

    public int b() {
        int length2;
        com.mp4parser.iso23001.part7.a.j[] objArr;
        int length;
        objArr = this.b;
        if (objArr != null && objArr.length > 0) {
            if (objArr.length > 0) {
                i += objArr;
            }
        }
        return length2;
    }

    public boolean equals(Object object) {
        Class<com.mp4parser.iso23001.part7.a> obj;
        Class class;
        com.mp4parser.iso23001.part7.a.j[] obj6;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (a.class != object.getClass()) {
            } else {
                BigInteger bigInteger = new BigInteger(this.a);
                BigInteger bigInteger2 = new BigInteger(object.a);
                if (!bigInteger.equals(bigInteger2)) {
                    return i2;
                }
                com.mp4parser.iso23001.part7.a.j[] objArr = this.b;
                obj6 = object.b;
                if (objArr != null) {
                    if (!Arrays.equals(objArr, obj6)) {
                        return i2;
                    }
                } else {
                    if (obj6 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        int i;
        int i2;
        byte[] bArr = this.a;
        if (bArr != null) {
            i = Arrays.hashCode(bArr);
        } else {
            i = i2;
        }
        final com.mp4parser.iso23001.part7.a.j[] objArr = this.b;
        if (objArr != null) {
            i2 = Arrays.hashCode(objArr);
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Entry{iv=");
        stringBuilder.append(c.a(this.a));
        stringBuilder.append(", pairs=");
        stringBuilder.append(Arrays.toString(this.b));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
