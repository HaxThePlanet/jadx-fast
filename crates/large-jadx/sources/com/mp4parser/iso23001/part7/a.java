package com.mp4parser.iso23001.part7;

import f.b.a.c;
import java.math.BigInteger;
import java.util.Arrays;

/* compiled from: CencSampleAuxiliaryDataFormat.java */
/* loaded from: classes2.dex */
public class a {

    public byte[] a;
    public a.j[] b = null;

    public interface j {
        long a();

        int clear();
    }

    private abstract class a implements a.j {
        private a() {
            super();
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                if (getClass() == object.getClass()) {
                    if (clear() != object.clear()) {
                        return false;
                    }
                    long l = a();
                    final long l2 = object.a();
                    return l != l2 ? z2 : z;
                }
            }
            return false;
        }

        @Override // java.lang.Object
        public String toString() {
            String str2 = "P(";
            StringBuilder stringBuilder = new StringBuilder(str2);
            int clear = clear();
            String str3 = "|";
            long l = a();
            String str4 = ")";
            str = str2 + clear + str3 + l + str4;
            return str;
        }

        /* synthetic */ a(a.a aVar) {
            this(aVar);
        }
    }

    private class b extends a.a {

        private byte a;
        private byte b;
        public b(int i, long j) {
            super(aVar, null);
            this.a = (byte)i;
            this.b = (byte)(int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class c extends a.a {

        private byte a;
        private int b;
        public c(int i, long j) {
            super(aVar, null);
            this.a = (byte)i;
            this.b = (int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class d extends a.a {

        private byte a;
        private long b;
        public d(int i, long j) {
            super(aVar, null);
            this.a = (byte)i;
            this.b = j;
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

    private class e extends a.a {

        private byte a;
        private short b;
        public e(int i, long j) {
            super(aVar, null);
            this.a = (byte)i;
            this.b = (short)(int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class f extends a.a {

        private int a;
        private byte b;
        public f(int i, long j) {
            super(aVar, null);
            this.a = i;
            this.b = (byte)(int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class g extends a.a {

        private int a;
        private int b;
        public g(int i, long j) {
            super(aVar, null);
            this.a = i;
            this.b = (int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class h extends a.a {

        private int a;
        private long b;
        public h(int i, long j) {
            super(aVar, null);
            this.a = i;
            this.b = j;
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

    private class i extends a.a {

        private int a;
        private short b;
        public i(int i, long j) {
            super(aVar, null);
            this.a = i;
            this.b = (short)(int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class k extends a.a {

        private short a;
        private byte b;
        public k(int i, long j) {
            super(aVar, null);
            this.a = (short)i;
            this.b = (byte)(int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class l extends a.a {

        private short a;
        private int b;
        public l(int i, long j) {
            super(aVar, null);
            this.a = (short)i;
            this.b = (int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }

    private class m extends a.a {

        private short a;
        private long b;
        public m(int i, long j) {
            super(aVar, null);
            this.a = (short)i;
            this.b = j;
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

    private class n extends a.a {

        private short a;
        private short b;
        public n(int i, long j) {
            super(aVar, null);
            this.a = (short)i;
            this.b = (short)(int)j;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public long a() {
            return (long)this.b;
        }

        @Override // com.mp4parser.iso23001.part7.a$a
        public int clear() {
            return this.a;
        }
    }
    public a() {
        super();
        this.a = new byte[0];
    }

    public a.j a(int i, long j) {
        long l = 2147483647L;
        long l2 = 32767L;
        long l3 = 127L;
        if (i <= 127) {
            if (j <= l3) {
                return new a.b(this, i, j, r10);
            }
            if (j <= l2) {
                return new a.e(this, i, j, r10);
            }
            if (j <= l) {
                return new a.c(this, i, j, r10);
            }
            return new a.d(this, i, j, r10);
        }
        if (i <= 32767) {
            if (j <= l3) {
                return new a.k(this, i, j, r10);
            }
            if (j <= l2) {
                return new a.n(this, i, j, r10);
            }
            if (j <= l) {
                return new a.l(this, i, j, r10);
            }
            return new a.m(this, i, j, r10);
        }
        if (j <= l3) {
            return new a.f(this, i, j, r10);
        }
        if (j <= l2) {
            return new a.i(this, i, j, r10);
        }
        if (j <= l) {
            return new a.g(this, i, j, r10);
        }
        return new a.h(this, i, j, r10);
    }

    public int b() {
        int length;
        length = this.a.length;
        if (this.b != null) {
            length2 = objArr.length;
            if (objArr.length > 0) {
                length = (this.a.length + 2) + (objArr.length * 6);
            }
        }
        return length;
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = a.class;
            if (obj == object.getClass()) {
                if (!new BigInteger(this.a).equals(new BigInteger(object.a))) {
                    return false;
                }
                if (this.b != null) {
                    if (!Arrays.equals(this.b, object.b)) {
                        return false;
                    }
                } else {
                    return object.b != null ? z2 : z;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.a != null) {
            i = Arrays.hashCode(this.a);
        } else {
        }
        if (this.b != null) {
            i = Arrays.hashCode(this.b);
        }
        return (i * 31) + i;
    }

    public String toString() {
        String str2 = "Entry{iv=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = c.a(this.a);
        String str4 = ", pairs=";
        String str5 = Arrays.toString(this.b);
        str = str2 + str3 + str4 + str5 + 125;
        return str;
    }
}
