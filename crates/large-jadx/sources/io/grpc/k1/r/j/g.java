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

/* compiled from: Http2.java */
/* loaded from: classes3.dex */
public final class g implements j {

    private static final Logger a;
    private static final i b;

    static final class b {

        private static final String[] a;
        private static final String[] b;
        private static final String[] c;
        static {
            int i = 0;
            int[] iArr;
            String str8;
            StringBuilder stringBuilder;
            String[] strArr;
            int i3;
            StringBuilder stringBuilder2;
            char c;
            String str9;
            str = "PRIORITY";
            replaced = "RST_STREAM";
            str3 = "SETTINGS";
            str4 = "PUSH_PROMISE";
            str5 = "GOAWAY";
            str6 = "WINDOW_UPDATE";
            str8 = "CONTINUATION";
            g.b.a = new String[] { "DATA", "HEADERS", str, replaced, str3, str4, "PING", str5, str6, str8 };
            g.b.b = new String[64];
            g.b.c = new String[256];
            i = 0;
            String[] strArr8 = g.b.c;
            char c2 = ' ';
            int i7 = 1;
            while (i < strArr8.length) {
                Object[] arr = new Object[i7];
                arr[i] = Integer.toBinaryString(i);
                g.b.c[i] = String.format("%8s", arr).replace(c2, '0');
                i = i + 1;
                strArr8 = g.b.c;
                c2 = ' ';
                i7 = 1;
            }
            String[] strArr5 = g.b.b;
            strArr5[i] = "";
            strArr5[i7] = "END_STREAM";
            iArr = new int[i7];
            iArr[i] = i7;
            str2 = "PADDED";
            int i8 = 8;
            strArr5[i8] = str2;
            String str16 = "|PADDED";
            while (i < i7) {
                int i10 = iArr[i];
                String[] strArr10 = g.b.b;
                str8 = i10 | 8;
                stringBuilder = new StringBuilder();
                String str5 = strArr10[i10];
                str2 = str5 + str16;
                strArr10[str8] = str2;
                i = i + 1;
                str16 = "|PADDED";
            }
            String[] strArr6 = g.b.b;
            str7 = "END_HEADERS";
            strArr6[4] = str7;
            strArr6[c2] = "PRIORITY";
            strArr6[36] = "END_HEADERS|PRIORITY";
            int i2 = 3;
            while (i < i2) {
                String str7 = new int[] { 4, 32, 36 }[i];
                while (str8 < i7) {
                    int i11 = iArr[str8];
                    strArr = g.b.b;
                    int i12 = i11 | str7;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str25 = strArr[i11];
                    c = '|';
                    str9 = strArr[str7];
                    str24 = str25 + c + str9;
                    strArr[i12] = str24;
                    i3 = i12 | i8;
                    stringBuilder2 = new StringBuilder();
                    String str22 = strArr[i11];
                    String str23 = strArr[str7];
                    obj = str22 + c + str23 + str16;
                    strArr[i3] = obj;
                    str8 = str8 + 1;
                }
                i = i + 1;
                i11 = iArr[str8];
                strArr = g.b.b;
                i12 = i11 | str7;
                stringBuilder3 = new StringBuilder();
                str25 = strArr[i11];
                c = '|';
                str9 = strArr[str7];
                str24 = str25 + c + str9;
                strArr[i12] = str24;
                i3 = i12 | i8;
                stringBuilder2 = new StringBuilder();
                str22 = strArr[i11];
                str23 = strArr[str7];
                obj = str22 + c + str23 + str16;
                strArr[i3] = obj;
                str8 = str8 + 1;
            }
            String[] strArr7 = g.b.b;
            for (String str14 : strArr7) {
                strArr7 = g.b.b;
            }
        }

        b() {
            super();
        }

        static String a(byte b, byte b2) {
            String str;
            String str2;
            if (b2 == 0) {
                return "";
            }
            int i = 2;
            i = 3;
            int i2 = 4;
            i2 = 6;
            if (!(b == 2 || b != 3 || b != 4 || b != 6)) {
                i = 7;
                if (b != 7 && b != 8) {
                    String[] strArr = g.b.b;
                    str = b2 < strArr.length ? strArr[b2] : strArr2[b2];
                    int i3 = 5;
                    if (b == 5 && b2 & 4 != 0) {
                        return str.replace("HEADERS", "PUSH_PROMISE");
                    }
                    if (b == 0) {
                        i4 = b2 & 32;
                        if (b2 & 32 != 0) {
                            return str.replace("PRIORITY", "COMPRESSED");
                        }
                    }
                    return str;
                }
            }
            return g.b.c[b2];
        }

        static String b(boolean z, int i, int i2, byte b, byte b2) {
            String formatted;
            String str;
            String[] strArr = g.b.a;
            length = strArr.length;
            i = 0;
            final int i4 = 1;
            if (b < g.b.a.length) {
                formatted = g.b.a[b];
            } else {
                Object[] arr = new Object[i4];
                formatted = String.format("0x%02x", new Object[] { Byte.valueOf(b) });
            }
            Object[] arr2 = new Object[5];
            z = z ? "<<" : ">>";
            return (z ? "<<" : ">>");
        }
    }

    static final class a implements d0 {

        private final h a;
        int b;
        byte c;
        int v;
        int w;
        short x;
        public a(h hVar) {
            super();
            this.a = hVar;
        }

        private void a() {
            int i3 = g.m(this.a);
            this.w = i3;
            this.b = i3;
            byte b2 = (byte)(this.a.readByte() & 255);
            this.c = (byte)(this.a.readByte() & 255);
            boolean z = true;
            if (g.a.isLoggable(Level.FINE)) {
                g.a.fine(g.b.b(z, this.v, this.b, b2, this.c));
            }
            int i6 = this.a.readInt() & (0x7fffffff /* Unknown resource */);
            this.v = i6;
            int i10 = 0;
            int i11 = 0;
            if (this.a != 9) {
                Object[] arr2 = new Object[z];
                arr2[i11] = Byte.valueOf(b2);
                g.e("%s != TYPE_CONTINUATION", arr2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i10;
            } else {
                if (this.a != this.v) {
                    g.e("TYPE_CONTINUATION streamId changed", new Object[i11]);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i10;
                }
            }
        }

        public long read(f fVar, long j) {
            final long l = -1L;
            while (this.w == 0) {
                this.a.skip((long)this.x);
                this.x = (short) 0;
                if (this.c & 4 != 0) {
                    return l;
                }
            }
            final long read = this.a.read(fVar, Math.min(j, (long)i));
            if (read == l) {
                return l;
            }
            this.w -= i4;
            return read;
        }

        public e0 timeout() {
            return this.a.timeout();
        }

        public void close() {
        }
    }

    static final class c implements b {

        private final h a;
        private final g.a b = new g$a();
        final f.a c = new f$a();
        c(h hVar, int i, boolean z) {
            super();
            this.a = hVar;
            final io.grpc.k1.r.j.f.a aVar = new f.a(i, new g.a(hVar));
        }

        private void a(b.a aVar, int i, byte b, int i2) {
            boolean z;
            short s = 0;
            i = 1;
            s = (short) 0;
            int r0 = b & 1 != 0 ? 1 : s;
            if (b & 32 == 0) {
                i = s;
            }
            if (i != 0) {
                g.e("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[s]);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                i3 = b & 8;
                if (b & 8 != 0) {
                    i3 = this.a.readByte() & 255;
                    s = (short)i3;
                }
                aVar.data(z, i2, this.a, g.l(i, b, s));
                this.a.skip((long)s);
                return;
            }
        }

        private void c(b.a aVar, int i, byte b, int i2) {
            i iVar;
            int i7 = 1;
            int i3 = 8;
            i = 0;
            final int i5 = 0;
            if (i < i3) {
                Object[] arr3 = new Object[i7];
                g.e("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(i) });
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                if (i2 != 0) {
                    g.e("TYPE_GOAWAY streamId != 0", new Object[i5]);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    int _int = this.a.readInt();
                    i -= i3;
                    io.grpc.k1.r.j.a http2 = a.fromHttp2(_int);
                    if (http2 == null) {
                        Object[] arr2 = new Object[i7];
                        g.e("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(_int) });
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        iVar = i.c;
                        if (i6 > 0) {
                            iVar = this.a.B((long)i6);
                        }
                        aVar.q(this.a.readInt(), http2, iVar);
                        return;
                    }
                }
            }
        }

        private List<d> e(int i, short s, byte b, int i2) {
            this.b.w = i;
            this.b.b = i;
            this.b.x = s;
            this.b.c = b;
            this.b.v = i2;
            this.c.l();
            return this.c.e();
        }

        private void f(b.a aVar, int i, byte b, int i2) {
            short s = 0;
            boolean z;
            int i3;
            s = (short) 0;
            if (i2 == 0) {
                g.e("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[s]);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                i = b & 1;
                i = b & 1 != 0 ? i : s;
                if (b & 8 != 0) {
                    s = (short)(this.a.readByte() & 255);
                }
                if (b & 32 != 0) {
                    j(aVar, i2);
                    i3 = i - 5;
                }
                aVar.s(false, z, i2, -1, e(g.l(i3, b, s), s, b, i2), e.HTTP_20_HEADERS);
                return;
            }
        }

        private void i(b.a aVar, int i, byte b, int i2) {
            boolean z = false;
            final int i3 = 0;
            int i5 = 0;
            i = 1;
            if (i != 8) {
                Object[] arr2 = new Object[i];
                g.e("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(i) });
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i3;
            } else {
                if (i2 != 0) {
                    g.e("TYPE_PING streamId != 0", new Object[i5]);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i3;
                } else {
                    if (b & i != 0) {
                    }
                    aVar.ping(z, this.a.readInt(), this.a.readInt());
                    return;
                }
            }
        }

        private void j(b.a aVar, int i) {
            boolean z = false;
            int _int = this.a.readInt();
            i = 1;
            int r1 = -2147483648 & _int != 0 ? i : 0;
            aVar.priority(i, _int & 0x7fffffff /* Unknown resource */, this.a.readByte() & 255 + i, (-2147483648 & _int != 0 ? i : 0));
        }

        private void k(b.a aVar, int i, byte b, int i2) {
            final int i6 = 0;
            i = 0;
            if (i != 5) {
                Object[] arr2 = new Object[1];
                g.e("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(i) });
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i6;
            } else {
                if (i2 == 0) {
                    g.e("TYPE_PRIORITY streamId == 0", new Object[i]);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i6;
                } else {
                    j(aVar, i2);
                    return;
                }
            }
        }

        private void m(b.a aVar, int i, byte b, int i2) {
            short s = 0;
            s = (short) 0;
            if (i2 == 0) {
                g.e("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[(short) 0]);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                if (b & 8 != 0) {
                    s = (short)(this.a.readByte() & 255);
                }
                aVar.pushPromise(i2, this.a.readInt() & (0x7fffffff /* Unknown resource */), e(g.l(i - 4, b, s), s, b, i2));
                return;
            }
        }

        private void n(b.a aVar, int i, byte b, int i2) {
            final int i6 = 1;
            i = 0;
            final int i3 = 0;
            if (i != 4) {
                Object[] arr3 = new Object[i6];
                g.e("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(i) });
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                if (i2 == 0) {
                    g.e("TYPE_RST_STREAM streamId == 0", new Object[i3]);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    int _int = this.a.readInt();
                    io.grpc.k1.r.j.a http2 = a.fromHttp2(_int);
                    if (http2 == null) {
                        Object[] arr2 = new Object[i6];
                        g.e("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(_int) });
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        aVar.p(i2, http2);
                        return;
                    }
                }
            }
        }

        private void o(b.a aVar, int i, byte b, int i2) {
            short _short = 7;
            int i3;
            final int i7 = 0;
            i = 0;
            if (i2 != 0) {
                g.e("TYPE_SETTINGS streamId != 0", new Object[i]);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i7;
            } else {
                final int i10 = 1;
                if (b & i10 != 0) {
                    if (i != 0) {
                        g.e("FRAME_SIZE_ERROR ack frame should be empty!", new Object[i]);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i7;
                    } else {
                        aVar.ackSettings();
                        return;
                    }
                }
                if (i % 6 != 0) {
                    Object[] arr6 = new Object[i10];
                    g.e("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(i) });
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i7;
                } else {
                    io.grpc.k1.r.j.i iVar = new i();
                    while (i < i) {
                        int _int = this.a.readInt();
                        i = i + 6;
                        i3 = 16384;
                        if (this.a < 16384) {
                            Object[] arr5 = new Object[i10];
                            g.e("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(_int) });
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i7;
                        }
                        _short = (short) 7;
                        if (this.a < 0) {
                            g.e("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[i]);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i7;
                        }
                        _short = (short) 4;
                        if (this.a == 0 || this.a == i10) {
                        }
                    }
                    aVar.r(false, iVar);
                    if (iVar.b() >= 0) {
                        this.c.g(iVar.b());
                    }
                    return;
                }
            }
        }

        private void q(b.a aVar, int i, byte b, int i2) {
            final int i8 = 0;
            i = 0;
            if (i != 4) {
                Object[] arr2 = new Object[1];
                g.e("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(i) });
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i8;
            } else {
                long l2 = (long)this.a.readInt() & 2147483647L;
                if (l2 == 0) {
                    g.e("windowSizeIncrement was 0", new Object[i]);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i8;
                } else {
                    aVar.windowUpdate(i2, l2);
                    return;
                }
            }
        }

        public void close() {
            this.a.close();
        }

        public boolean d0(b.a aVar) {
            try {
                this.a.V1(9L);
            } catch (java.io.IOException unused) {
                return b;
            }
            int i4 = g.m(this.a);
            boolean z = true;
            if (i4 < 0) {
                Object[] arr = new Object[z];
                arr[0] = Integer.valueOf(i4);
                g.e("FRAME_SIZE_ERROR: %s", arr);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                int i = 16384;
                if (i4 <= 16384) {
                    b2 = (byte)(this.a.readByte() & 255);
                    byte b3 = (byte)(this.a.readByte() & 255);
                    int i7 = this.a.readInt() & (0x7fffffff /* Unknown resource */);
                    if (g.a.isLoggable(Level.FINE)) {
                        g.a.fine(g.b.b(z, i7, i4, b2, b3));
                    }
                    switch (b2) {
                        case 0:
                            a(aVar, i4, b3, i7);
                            break;
                        case 1:
                            f(aVar, i4, b3, i7);
                            break;
                        case 2:
                            k(aVar, i4, b3, i7);
                            break;
                        case 3:
                            n(aVar, i4, b3, i7);
                            break;
                        case 4:
                            o(aVar, i4, b3, i7);
                            break;
                        case 5:
                            m(aVar, i4, b3, i7);
                            break;
                        case 6:
                            i(aVar, i4, b3, i7);
                            break;
                        case 7:
                            c(aVar, i4, b3, i7);
                            break;
                        case 8:
                            q(aVar, i4, b3, i7);
                            break;
                        default:
                            this.a.skip((long)i4);
                    }
                    return true;
                }
            }
        }
    }

    static final class d implements c {

        private final g a;
        private final boolean b;
        private final f c = new f();
        private final f.b v = new f$b();
        private int w = 16384;
        private boolean x;
        d(g gVar, boolean z) {
            super();
            this.a = gVar;
            this.b = z;
            final io.grpc.k1.r.j.f.b bVar = new f.b(new f());
        }

        private void f(int i, long j) {
            byte b = 0;
            long l = 0L;
            while (j > l) {
                long min = Math.min((long)this.w, j);
                j -= min;
                int r0 = l4 == l ? 4 : 0;
                c(i, (int)min, (byte) 9, (l4 == l ? 4 : 0));
                (l4 == l ? 4 : 0).write(this.c, min);
            }
        }

        public synchronized void R0(i iVar) {
            this.w = iVar.c(this.w);
            final int i3 = 0;
            c(i3, i3, (byte) 4, (byte) 1);
            this.a.flush();
            throw new IOException("closed");
        }

        public synchronized void T1(boolean z, boolean z2, int i, int i2, List<d> list) {
            if (z2) {
                throw new UnsupportedOperationException();
            } else {
                try {
                    e(z, i, list);
                } catch (Throwable unused) {
                }
                try {
                    throw new IOException("closed");
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        public synchronized void Z0(i iVar) {
            int i2 = 3;
            int i;
            int i3;
            i = iVar.f() * 6;
            i2 = 0;
            final byte b = (byte) 4;
            c(i2, i, b, i2);
            while (i2 < 10) {
                if (iVar.d(i2)) {
                    if (i2 == b) {
                        i2 = 3;
                    } else {
                        byte r0 = i2 == 7 ? b : i2;
                    }
                    this.a.I((i2 == 7 ? b : i2));
                    (i2 == 7 ? b : i2).P(iVar.a(i2));
                }
                i2 = i2 + 1;
            }
            this.a.flush();
            throw new IOException("closed");
        }

        void a(int i, byte b, f fVar, int i2) {
            b = (byte) 0;
            c(i, i2, b, b);
            if (i2 > 0) {
                this.a.write(fVar, (long)i2);
            }
        }

        void c(int i, int i2, byte b, byte b2) {
            boolean z = false;
            if (g.a.isLoggable(Level.FINE)) {
                g.a.fine(g.b.b(z, i, i2, b, b2));
            }
            int i6 = 0;
            final int i7 = 1;
            if (i2 > this.w) {
                Object[] arr = new Object[2];
                arr[z] = Integer.valueOf(this.w);
                arr[i7] = Integer.valueOf(i2);
                g.h("FRAME_SIZE_ERROR length > %d: %d", arr);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i6;
            } else {
                if (-2147483648 & i != 0) {
                    Object[] arr2 = new Object[i7];
                    arr2[z] = Integer.valueOf(i);
                    g.h("reserved bit set: %s", arr2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i6;
                } else {
                    g.n(this.a, i2);
                    this.a.c0(b & 255);
                    this.a.c0(b2 & 255);
                    this.a.P(i & (0x7fffffff /* Unknown resource */));
                    return;
                }
            }
        }

        public synchronized void close() {
            this.x = true;
            this.a.close();
        }

        public synchronized void connectionPreface() {
            throw new IOException("closed");
        }

        public synchronized void data(boolean z, int i, f fVar, int i2) {
            byte b = 0;
            b = (byte) 0;
            if (z != null) {
                i = 1;
                b = (byte)i;
            }
            a(i, b, fVar, i2);
            throw new IOException("closed");
        }

        void e(boolean z, int i, List<d> list) throws IOException {
            byte b;
            if (this.x) {
                throw new IOException("closed");
            } else {
                this.v.e(list);
                long size = this.c.size();
                long min = Math.min((long)this.w, size);
                int r5 = size == min ? 4 : 0;
                if (z) {
                    i3 = i | 1;
                    b = (byte)i3;
                }
                c(i, (int)min, (byte) 1, b);
                this.a.write(this.c, min);
                if (size > min) {
                    size = size - min;
                    f(i, size);
                }
                return;
            }
        }

        public synchronized void flush() {
            this.a.flush();
            throw new IOException("closed");
        }

        public synchronized void h2(int i, a aVar, byte[] bArr) {
            final int i5 = 0;
            c(i5, bArr.length + 8, (byte) 7, i5);
            this.a.P(i);
            this.a.P(aVar.httpCode);
            length = bArr.length;
            if (bArr.length > 0) {
                this.a.w1(bArr);
            }
            this.a.flush();
            throw new IOException("closed");
        }

        public int maxDataLength() {
            return this.w;
        }

        public synchronized void p(int i, a aVar) {
            c(i, 4, (byte) 3, (byte) 0);
            this.a.P(aVar.httpCode);
            this.a.flush();
            throw new IOException("closed");
        }

        public synchronized void ping(boolean z, int i, int i2) {
            byte b = 1;
            i = 0;
            z = z != null ? 1 : i;
            c(i, 8, (byte) 6, (z != null ? 1 : i));
            (z != null ? 1 : i).P(i);
            (z != null ? 1 : i).P(i2);
            (z != null ? 1 : i).flush();
            throw new IOException("closed");
        }

        public synchronized void windowUpdate(int i, long j) {
            final byte b = (byte) 0;
            long l = 2147483647L;
            c(i, 4, (byte) 8, b);
            this.a.P((int)j);
            this.a.flush();
            throw new IOException("closed");
        }
    }
    static {
        g.a = Logger.getLogger(g.b.class.getName());
        g.b = i.i("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    }

    static /* synthetic */ i c() {
        return g.b;
    }

    static /* synthetic */ Logger d() {
        return g.a;
    }

    static /* synthetic */ IOException e(String str, Object[] objectArr) {
        g.k(str, objectArr);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    static /* synthetic */ int f(h hVar) {
        return g.m(hVar);
    }

    static /* synthetic */ int g(int i, byte b, short s) {
        return g.l(i, b, s);
    }

    static /* synthetic */ java.lang.IllegalArgumentException h(String str, Object[] objectArr) {
        g.j(str, objectArr);
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    static /* synthetic */ void i(g gVar, int i) {
        g.n(gVar, i);
    }

    private static java.lang.IllegalArgumentException j(String str, Object... objectArr) {
        throw new IllegalArgumentException(String.format(str, objectArr));
    }

    private static IOException k(String str, Object... objectArr) throws IOException {
        throw new IOException(String.format(str, objectArr));
    }

    private static int l(int i, byte b, short s) {
        int i2;
        if (b & 8 != 0) {
            i2 = i - 1;
        }
        if (s > i2) {
            Object[] arr = new Object[2];
            g.k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return (short)(i2 - s);
        }
    }

    private static int m(h hVar) {
        return (hVar.readByte() & 255) | (hVar.readByte() & 255) << 16 | (hVar.readByte() & 255) << 8;
    }

    private static void n(g gVar, int i) {
        gVar.c0((i >>> 16) & 255);
        gVar.c0((i >>> 8) & 255);
        gVar.c0(i & 255);
    }

    public b a(h hVar, boolean z) {
        return new g.c(hVar, 4096, z);
    }

    public c b(g gVar, boolean z) {
        return new g.d(gVar, z);
    }
}
