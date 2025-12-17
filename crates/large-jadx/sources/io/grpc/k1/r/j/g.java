package io.grpc.k1.r.j;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import l.b0;
import l.d0;
import l.e0;
import l.f;
import l.g;
import l.h;
import l.i;

/* loaded from: classes3.dex */
public final class g implements io.grpc.k1.r.j.j {

    private static final Logger a;
    private static final i b;

    static final class b {

        private static final String[] a;
        private static final String[] b;
        private static final String[] c;
        static {
            int i2;
            int i;
            int i5;
            int i7;
            String str2;
            int[] iArr;
            String replace;
            String string;
            String str6;
            String str4;
            String str7;
            int i3;
            String str;
            String str5;
            String str8;
            StringBuilder stringBuilder;
            String[] strArr;
            int i4;
            StringBuilder stringBuilder2;
            int i6;
            String str3;
            g.b.a = /* result */;
            g.b.b = new String[64];
            g.b.c = new String[256];
            i2 = 0;
            i = i2;
            str2 = g.b.c;
            str6 = 32;
            int i11 = 1;
            while (i < str2.length) {
                Object[] arr = new Object[i11];
                arr[i2] = Integer.toBinaryString(i);
                str2[i] = String.format("%8s", arr).replace(str6, '0');
                i++;
                str2 = g.b.c;
                str6 = 32;
                i11 = 1;
            }
            String[] strArr5 = g.b.b;
            strArr5[i2] = "";
            strArr5[i11] = "END_STREAM";
            iArr = new int[i11];
            iArr[i2] = i11;
            int i12 = 8;
            strArr5[i12] = "PADDED";
            i5 = i2;
            String str13 = "|PADDED";
            while (i5 < i11) {
                int i14 = iArr[i5];
                str = g.b.b;
                stringBuilder = new StringBuilder();
                stringBuilder.append(str[i14]);
                stringBuilder.append(str13);
                str[i14 | 8] = stringBuilder.toString();
                i5++;
                str13 = "|PADDED";
            }
            String[] strArr6 = g.b.b;
            strArr6[4] = "END_HEADERS";
            strArr6[str6] = "PRIORITY";
            strArr6[36] = "END_HEADERS|PRIORITY";
            i7 = 3;
            int[] iArr2 = new int[i7];
            iArr2 = new int[]{4, 32, 36};
            i3 = i2;
            while (i3 < i7) {
                str5 = iArr2[i3];
                str8 = i2;
                while (str8 < i11) {
                    int i15 = iArr[str8];
                    strArr = g.b.b;
                    int i16 = i15 | str5;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(strArr[i15]);
                    i6 = 124;
                    stringBuilder3.append(i6);
                    stringBuilder3.append(strArr[str5]);
                    strArr[i16] = stringBuilder3.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(strArr[i15]);
                    stringBuilder2.append(i6);
                    stringBuilder2.append(strArr[str5]);
                    stringBuilder2.append(str13);
                    strArr[i16 |= i12] = stringBuilder2.toString();
                    str8++;
                }
                i3++;
                i15 = iArr[str8];
                strArr = g.b.b;
                i16 = i15 | str5;
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(strArr[i15]);
                i6 = 124;
                stringBuilder3.append(i6);
                stringBuilder3.append(strArr[str5]);
                strArr[i16] = stringBuilder3.toString();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(strArr[i15]);
                stringBuilder2.append(i6);
                stringBuilder2.append(strArr[str5]);
                stringBuilder2.append(str13);
                strArr[i16 |= i12] = stringBuilder2.toString();
                str8++;
            }
            i7 = g.b.b;
            while (i2 < i7.length) {
                if (i7[i2] == null) {
                }
                i2++;
                i7 = g.b.b;
                i7[i2] = g.b.c[i2];
            }
        }

        static String a(byte b, byte b2) {
            int i;
            int i2;
            String str;
            int i3;
            String obj2;
            if (b2 == 0) {
                return "";
            }
            if (b != 2 && b != 3) {
                if (b != 3) {
                    if (b != 4 && b != 6) {
                        if (b != 6) {
                            if (b != 7 && b != 8) {
                                if (b != 8) {
                                    String[] strArr = g.b.b;
                                    str = b2 < strArr.length ? strArr[b2] : strArr2[b2];
                                    if (b == 5 && b2 & 4 != 0) {
                                        if (b2 & 4 != 0) {
                                            return str.replace("HEADERS", "PUSH_PROMISE");
                                        }
                                    }
                                    if (b == 0 && b2 & 32 != 0) {
                                        if (b2 & 32 != 0) {
                                            return str.replace("PRIORITY", "COMPRESSED");
                                        }
                                    }
                                    return str;
                                }
                            }
                        } else {
                            obj2 = b2 == 1 ? "ACK" : obj2[b2];
                        }
                    } else {
                    }
                    return obj2;
                }
            }
            return g.b.c[b2];
        }

        static String b(boolean z, int i2, int i3, byte b4, byte b5) {
            String format;
            int length;
            String obj4;
            String[] strArr = g.b.a;
            final int i = 0;
            final int i4 = 1;
            if (b4 < strArr.length) {
                format = strArr[b4];
            } else {
                Object[] arr = new Object[i4];
                arr[i] = Byte.valueOf(b4);
                format = String.format("0x%02x", arr);
            }
            Object[] obj8 = new Object[5];
            obj4 = z ? "<<" : ">>";
            obj8[i] = obj4;
            obj8[i4] = Integer.valueOf(i2);
            obj8[2] = Integer.valueOf(i3);
            obj8[3] = format;
            obj8[4] = g.b.a(b4, b5);
            return String.format("%s 0x%08x %5d %-13s %s", obj8);
        }
    }

    static final class a implements d0 {

        private final h a;
        int b;
        byte c;
        int v;
        int w;
        short x;
        public a(h h) {
            super();
            this.a = h;
        }

        private void a() {
            boolean loggable;
            String str;
            int i;
            byte b;
            int i3 = g.f(this.a);
            this.w = i3;
            this.b = i3;
            byte b2 = (byte)i4;
            this.c = (byte)i5;
            int i7 = 1;
            if (g.d().isLoggable(Level.FINE)) {
                g.d().fine(g.b.b(i7, this.v, this.b, b2, this.c));
            }
            int &= i9;
            this.v = i6;
            int i11 = 0;
            int i12 = 0;
            if (b2 != 9) {
            } else {
                if (i6 != this.v) {
                } else {
                }
                g.e("TYPE_CONTINUATION streamId changed", new Object[i12]);
                throw i11;
            }
            Object[] arr2 = new Object[i7];
            arr2[i12] = Byte.valueOf(b2);
            g.e("%s != TYPE_CONTINUATION", arr2);
            throw i11;
        }

        @Override // l.d0
        public void close() {
        }

        @Override // l.d0
        public long read(f f, long l2) {
            int i = this.w;
            final int i5 = -1;
            while (i == 0) {
                this.a.skip((long)s);
                this.x = 0;
                a();
                i = this.w;
                i5 = -1;
            }
            final long obj7 = this.a.read(f, Math.min(l2, obj9));
            if (Long.compare(obj7, i5) == 0) {
                return i5;
            }
            this.w = obj9 -= i4;
            return obj7;
        }

        @Override // l.d0
        public e0 timeout() {
            return this.a.timeout();
        }
    }

    static final class c implements io.grpc.k1.r.j.b {

        private final h a;
        private final io.grpc.k1.r.j.g.a b;
        final io.grpc.k1.r.j.f.a c;
        c(h h, int i2, boolean z3) {
            super();
            this.a = h;
            g.a obj3 = new g.a(h);
            this.b = obj3;
            f.a obj1 = new f.a(i2, obj3);
            this.c = obj1;
        }

        private void a(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            int i;
            int i6;
            int i5;
            int i3;
            i3 = 0;
            i = b3 & 1 != 0 ? i6 : i3;
            if (b3 & 32 != 0) {
            } else {
                i6 = i3;
            }
            if (i6 != 0) {
            } else {
                if (b3 & 8 != 0) {
                    i3 = (short)i5;
                }
                final h obj7 = this.a;
                a.data(i, i4, obj7, g.g(i2, b3, i3));
                this.a.skip((long)i3);
            }
            g.e("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[i3]);
            throw 0;
        }

        private void c(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            int i;
            i obj7;
            obj7 = 1;
            int i3 = 8;
            i = 0;
            final int i5 = 0;
            if (i2 < i3) {
            } else {
                if (i4 != 0) {
                } else {
                    int int = this.a.readInt();
                    i2 -= i3;
                    io.grpc.k1.r.j.a http2 = a.fromHttp2(int);
                    if (http2 == null) {
                    } else {
                        obj7 = i.c;
                        if (obj6 > 0) {
                            obj7 = this.a.B((long)obj6);
                        }
                        a.q(this.a.readInt(), http2, obj7);
                    }
                    Object[] obj5 = new Object[obj7];
                    obj5[i5] = Integer.valueOf(int);
                    g.e("TYPE_GOAWAY unexpected error code: %d", obj5);
                    throw i;
                }
                g.e("TYPE_GOAWAY streamId != 0", new Object[i5]);
                throw i;
            }
            obj5 = new Object[obj7];
            obj5[i5] = Integer.valueOf(i2);
            g.e("TYPE_GOAWAY length < 8: %s", obj5);
            throw i;
        }

        private List<io.grpc.k1.r.j.d> e(int i, short s2, byte b3, int i4) {
            final io.grpc.k1.r.j.g.a aVar = this.b;
            aVar.w = i;
            aVar.b = i;
            aVar.x = s2;
            aVar.c = b3;
            aVar.v = i4;
            this.c.l();
            return this.c.e();
        }

        private void f(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            int i3;
            int i;
            int i5;
            int obj11;
            i3 = 0;
            if (i4 == 0) {
            } else {
                i5 = b3 & 1 != 0 ? i : i3;
                if (b3 & 8 != 0) {
                    i3 = (short)i6;
                }
                if (b3 & 32 != 0) {
                    j(a, i4);
                    i2 += -5;
                }
                a.s(false, i5, i4, -1, e(g.g(obj11, b3, i3), i3, b3, i4), e.HTTP_20_HEADERS);
            }
            g.e("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[i3]);
            throw 0;
        }

        private void i(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            int i;
            final int i3 = 0;
            i = 0;
            final int i5 = 1;
            if (i2 != 8) {
            } else {
                if (i4 != 0) {
                } else {
                    if (b3 &= i5 != 0) {
                        i = i5;
                    }
                    a.ping(i, this.a.readInt(), this.a.readInt());
                }
                g.e("TYPE_PING streamId != 0", new Object[i]);
                throw i3;
            }
            Object[] obj5 = new Object[i5];
            obj5[i] = Integer.valueOf(i2);
            g.e("TYPE_PING length != 8: %s", obj5);
            throw i3;
        }

        private void j(io.grpc.k1.r.j.b.a b$a, int i2) {
            int i;
            int int = this.a.readInt();
            final int i6 = 1;
            i = i4 &= int != 0 ? i6 : 0;
            a.priority(i2, int &= i7, i8 += i6, i);
        }

        private void k(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            final int obj5 = 0;
            final int i = 0;
            if (i2 != 5) {
            } else {
                if (i4 == 0) {
                } else {
                    j(a, i4);
                }
                g.e("TYPE_PRIORITY streamId == 0", new Object[i]);
                throw obj5;
            }
            Object[] obj3 = new Object[1];
            obj3[i] = Integer.valueOf(i2);
            g.e("TYPE_PRIORITY length: %d != 5", obj3);
            throw obj5;
        }

        private void m(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            int i;
            if (i4 == 0) {
            } else {
                if (b3 & 8 != 0) {
                    i = (short)i3;
                }
                a.pushPromise(i4, int &= i7, e(g.g(i2 += -4, b3, i), i, b3, i4));
            }
            g.e("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw 0;
        }

        private void n(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            final int obj6 = 1;
            final int i = 0;
            final int i3 = 0;
            if (i2 != 4) {
            } else {
                if (i4 == 0) {
                } else {
                    int obj5 = this.a.readInt();
                    io.grpc.k1.r.j.a http2 = a.fromHttp2(obj5);
                    if (http2 == null) {
                    } else {
                        a.p(i4, http2);
                    }
                    Object[] obj4 = new Object[obj6];
                    obj4[i3] = Integer.valueOf(obj5);
                    g.e("TYPE_RST_STREAM unexpected error code: %d", obj4);
                    throw i;
                }
                g.e("TYPE_RST_STREAM streamId == 0", new Object[i3]);
                throw i;
            }
            obj4 = new Object[obj6];
            obj4[i3] = Integer.valueOf(i2);
            g.e("TYPE_RST_STREAM length: %d != 4", obj4);
            throw i;
        }

        private void o(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            Class<byte> obj;
            int i;
            short short;
            int int;
            int i3;
            int obj7;
            int obj8;
            final int i5 = 0;
            final int i6 = 0;
            if (i4 != 0) {
            } else {
                final int obj10 = 1;
                if (b3 &= obj10 != 0) {
                    if (i2 != 0) {
                    } else {
                        a.ackSettings();
                    }
                    g.e("FRAME_SIZE_ERROR ack frame should be empty!", new Object[i6]);
                    throw i5;
                }
                if (i2 % 6 != 0) {
                } else {
                    i obj9 = new i();
                    i = i6;
                    while (i < i2) {
                        int = this.a.readInt();
                        i += 6;
                        obj9.e(short, i6, int);
                        short = 7;
                        short = 4;
                    }
                    a.r(i6, obj9);
                    if (obj9.b() >= 0) {
                        this.c.g(obj9.b());
                    }
                }
                obj7 = new Object[obj10];
                obj7[i6] = Integer.valueOf(i2);
                g.e("TYPE_SETTINGS length %% 6 != 0: %s", obj7);
                throw i5;
            }
            g.e("TYPE_SETTINGS streamId != 0", new Object[i6]);
            throw i5;
        }

        private void q(io.grpc.k1.r.j.b.a b$a, int i2, byte b3, int i4) {
            final int obj8 = 0;
            final int i = 0;
            if (i2 != 4) {
            } else {
                l &= i6;
                if (Long.compare(i5, i7) == 0) {
                } else {
                    a.windowUpdate(i4, i5);
                }
                g.e("windowSizeIncrement was 0", new Object[i]);
                throw obj8;
            }
            Object[] obj6 = new Object[1];
            obj6[i] = Integer.valueOf(i2);
            g.e("TYPE_WINDOW_UPDATE length !=4: %s", obj6);
            throw obj8;
        }

        @Override // io.grpc.k1.r.j.b
        public void close() {
            this.a.close();
        }

        @Override // io.grpc.k1.r.j.b
        public boolean d0(io.grpc.k1.r.j.b.a b$a) {
            byte b;
            int i;
            boolean loggable;
            Object fINE;
            Object obj8;
            this.a.V1(9);
            int i4 = g.f(this.a);
            int i6 = 1;
            if (i4 < 0) {
            } else {
                try {
                    b = (byte)i3;
                    byte b3 = (byte)i7;
                    int &= i9;
                    if (g.d().isLoggable(Level.FINE)) {
                    }
                    g.d().fine(g.b.b(i6, i8, i4, b, b3));
                    this.a.skip((long)i4);
                    q(a, i4, b3, i8);
                    c(a, i4, b3, i8);
                }
            }
            obj8 = new Object[i6];
            obj8[0] = Integer.valueOf(i4);
            g.e("FRAME_SIZE_ERROR: %s", obj8);
            throw 0;
        }
    }

    static final class d implements io.grpc.k1.r.j.c {

        private final g a;
        private final boolean b;
        private final f c;
        private final io.grpc.k1.r.j.f.b v;
        private int w = 16384;
        private boolean x;
        d(g g, boolean z2) {
            super();
            this.a = g;
            this.b = z2;
            f obj1 = new f();
            this.c = obj1;
            f.b obj2 = new f.b(obj1);
            this.v = obj2;
            obj1 = 16384;
        }

        private void f(int i, long l2) {
            int i2;
            int i3 = 0;
            while (Long.compare(l2, i3) > 0) {
                int i5 = (int)l3;
                final long l4 = (long)i5;
                if (Long.compare(obj8, i3) == 0) {
                } else {
                }
                i2 = 0;
                c(i, i5, 9, i2);
                this.a.write(this.c, l4);
                i3 = 0;
                i2 = 4;
            }
        }

        @Override // io.grpc.k1.r.j.c
        public void R0(io.grpc.k1.r.j.i i) {
            synchronized (this) {
                try {
                    this.w = i.c(this.w);
                    final int i4 = 0;
                    c(i4, i4, 4, 1);
                    this.a.flush();
                    IOException obj3 = new IOException("closed");
                    throw obj3;
                    throw i;
                }
            }
        }

        public void T1(boolean z, boolean z2, int i3, int i4, List<io.grpc.k1.r.j.d> list5) {
            synchronized (this) {
                if (this.x) {
                } else {
                    e(z, i3, list5);
                }
                try {
                    IOException obj1 = new IOException("closed");
                    throw obj1;
                    obj1 = new UnsupportedOperationException();
                    throw obj1;
                    throw z;
                }
            }
        }

        @Override // io.grpc.k1.r.j.c
        public void Z0(io.grpc.k1.r.j.i i) {
            int i5;
            int i3;
            int i4;
            int i2;
            synchronized (this) {
                try {
                    i4 = 0;
                    final int i9 = 4;
                    c(i4, i6 *= 6, i9, i4);
                    while (i4 < 10) {
                        if (!i.d(i4)) {
                        } else {
                        }
                        if (i4 == i9) {
                        } else {
                        }
                        if (i4 == 7) {
                        } else {
                        }
                        i3 = i4;
                        this.a.I(i3);
                        this.a.P(i.a(i4));
                        i4++;
                        i3 = i9;
                        i3 = 3;
                    }
                    if (!i.d(i4)) {
                    } else {
                    }
                    if (i4 == i9) {
                    } else {
                    }
                    i3 = 3;
                    if (i4 == 7) {
                    } else {
                    }
                    i3 = i9;
                    i3 = i4;
                    this.a.I(i3);
                    this.a.P(i.a(i4));
                    i4++;
                    this.a.flush();
                    IOException obj5 = new IOException("closed");
                    throw obj5;
                    throw i;
                }
            }
        }

        @Override // io.grpc.k1.r.j.c
        void a(int i, byte b2, f f3, int i4) {
            int i2;
            int obj3;
            c(i, i4, 0, b2);
            if (i4 > 0) {
                this.a.write(f3, (long)i4);
            }
        }

        @Override // io.grpc.k1.r.j.c
        void c(int i, int i2, byte b3, byte b4) {
            boolean loggable;
            String str;
            int i6 = 0;
            if (g.d().isLoggable(Level.FINE)) {
                g.d().fine(g.b.b(i6, i, i2, b3, b4));
            }
            int i3 = this.w;
            int i7 = 0;
            final int i8 = 1;
            if (i2 > i3) {
            } else {
                if (i4 &= i != 0) {
                } else {
                    g.i(this.a, i2);
                    this.a.c0(b3 &= 255);
                    this.a.c0(b4 & 255);
                    this.a.P(i &= obj7);
                }
                Object[] obj6 = new Object[i8];
                obj6[i6] = Integer.valueOf(i);
                g.h("reserved bit set: %s", obj6);
                throw i7;
            }
            Object[] obj5 = new Object[2];
            obj5[i6] = Integer.valueOf(i3);
            obj5[i8] = Integer.valueOf(i2);
            g.h("FRAME_SIZE_ERROR length > %d: %d", obj5);
            throw i7;
        }

        @Override // io.grpc.k1.r.j.c
        public void close() {
            this.x = true;
            this.a.close();
            return;
            synchronized (this) {
                this.x = true;
                this.a.close();
            }
        }

        @Override // io.grpc.k1.r.j.c
        public void connectionPreface() {
            boolean loggable;
            Object fINE;
            Object[] arr;
            int i;
            String str;
            synchronized (this) {
                try {
                    if (!this.b) {
                    }
                    if (g.d().isLoggable(Level.FINE)) {
                    }
                    arr = new Object[1];
                    g.d().fine(String.format(">> CONNECTION %s", g.c().p()));
                    this.a.w1(g.c().D());
                    this.a.flush();
                    IOException iOException = new IOException("closed");
                    throw iOException;
                }
            }
        }

        @Override // io.grpc.k1.r.j.c
        public void data(boolean z, int i2, f f3, int i4) {
            int i;
            int obj2;
            synchronized (this) {
                try {
                    i = 0;
                    if (z != null) {
                    }
                    i = (byte)obj2;
                    a(i2, i, f3, i4);
                    obj2 = new IOException("closed");
                    throw obj2;
                    throw z;
                }
            }
        }

        void e(boolean z, int i2, List<io.grpc.k1.r.j.d> list3) {
            long size;
            int i;
            int obj7;
            if (this.x) {
            } else {
                this.v.e(list3);
                size = this.c.size();
                int obj9 = (int)l2;
                long l3 = (long)obj9;
                final int cmp = Long.compare(size, l3);
                i = cmp == 0 ? 4 : 0;
                if (z != 0) {
                    i = (byte)obj7;
                }
                c(i2, obj9, 1, i);
                this.a.write(this.c, l3);
                if (cmp > 0) {
                    f(i2, size -= l3);
                }
            }
            obj7 = new IOException("closed");
            throw obj7;
        }

        @Override // io.grpc.k1.r.j.c
        public void flush() {
            synchronized (this) {
                try {
                    this.a.flush();
                    IOException iOException = new IOException("closed");
                    throw iOException;
                    throw th;
                }
            }
        }

        @Override // io.grpc.k1.r.j.c
        public void h2(int i, io.grpc.k1.r.j.a a2, byte[] b3Arr3) {
            int obj4;
            synchronized (this) {
                try {
                    final int i5 = 0;
                    if (a2.httpCode == -1) {
                    } else {
                    }
                    c(i5, length += 8, 7, i5);
                    this.a.P(i);
                    this.a.P(a2.httpCode);
                    if (b3Arr3.length > 0) {
                    }
                    this.a.w1(b3Arr3);
                    this.a.flush();
                    g.h("errorCode.httpCode == -1", new Object[i5]);
                    throw 0;
                    obj4 = new IOException("closed");
                    throw obj4;
                    throw i;
                }
            }
        }

        @Override // io.grpc.k1.r.j.c
        public int maxDataLength() {
            return this.w;
        }

        @Override // io.grpc.k1.r.j.c
        public void p(int i, io.grpc.k1.r.j.a a2) {
            synchronized (this) {
                try {
                    if (a2.httpCode == -1) {
                    } else {
                    }
                    c(i, 4, 3, 0);
                    this.a.P(a2.httpCode);
                    this.a.flush();
                    IllegalArgumentException obj4 = new IllegalArgumentException();
                    throw obj4;
                    obj4 = new IOException("closed");
                    throw obj4;
                    throw i;
                }
            }
        }

        @Override // io.grpc.k1.r.j.c
        public void ping(boolean z, int i2, int i3) {
            int obj4;
            synchronized (this) {
                try {
                    final int i5 = 0;
                    if (z != null) {
                    } else {
                    }
                    obj4 = 1;
                    obj4 = i5;
                    c(i5, 8, 6, obj4);
                    this.a.P(i2);
                    this.a.P(i3);
                    this.a.flush();
                    obj4 = new IOException("closed");
                    throw obj4;
                    throw z;
                }
            }
        }

        @Override // io.grpc.k1.r.j.c
        public void windowUpdate(int i, long l2) {
            int cmp;
            int i2;
            synchronized (this) {
                try {
                    final int i6 = 0;
                    if (Long.compare(l2, i3) == 0) {
                    } else {
                    }
                    if (Long.compare(l2, i2) > 0) {
                    } else {
                    }
                    c(i, 4, 8, i6);
                    this.a.P((int)l2);
                    this.a.flush();
                    Object[] arr = new Object[1];
                    arr[i6] = Long.valueOf(l2);
                    g.h("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arr);
                    throw 0;
                    IOException obj5 = new IOException("closed");
                    throw obj5;
                    throw i;
                }
            }
        }
    }
    static {
        g.a = Logger.getLogger(g.b.class.getName());
        g.b = i.i("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }

    static i c() {
        return g.b;
    }

    static Logger d() {
        return g.a;
    }

    static IOException e(String string, Object[] object2Arr2) {
        g.k(string, object2Arr2);
        throw 0;
    }

    static int f(h h) {
        return g.m(h);
    }

    static int g(int i, byte b2, short s3) {
        return g.l(i, b2, s3);
    }

    static java.lang.IllegalArgumentException h(String string, Object[] object2Arr2) {
        g.j(string, object2Arr2);
        throw 0;
    }

    static void i(g g, int i2) {
        g.n(g, i2);
    }

    private static java.lang.IllegalArgumentException j(String string, Object... object2Arr2) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format(string, object2Arr2));
        throw illegalArgumentException;
    }

    private static IOException k(String string, Object... object2Arr2) {
        IOException iOException = new IOException(String.format(string, object2Arr2));
        throw iOException;
    }

    private static int l(int i, byte b2, short s3) {
        int obj1;
        if (b2 &= 8 != 0) {
            i--;
        }
        if (s3 > obj1) {
        } else {
            return (short)obj1;
        }
        Object[] obj2 = new Object[2];
        g.k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s3), Integer.valueOf(obj1));
        throw 0;
    }

    private static int m(h h) {
        return obj2 |= i3;
    }

    private static void n(g g, int i2) {
        g.c0(i &= 255);
        g.c0(i4 &= 255);
        g.c0(i2 &= 255);
    }

    @Override // io.grpc.k1.r.j.j
    public io.grpc.k1.r.j.b a(h h, boolean z2) {
        g.c cVar = new g.c(h, 4096, z2);
        return cVar;
    }

    @Override // io.grpc.k1.r.j.j
    public io.grpc.k1.r.j.c b(g g, boolean z2) {
        g.d dVar = new g.d(g, z2);
        return dVar;
    }
}
