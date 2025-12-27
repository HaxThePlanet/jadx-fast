package io.grpc;

import com.google.common.base.d;
import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.t;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* compiled from: Status.java */
/* loaded from: classes2.dex */
public final class d1 {

    private static final boolean d = false;
    private static final List<d1> e;
    public static final d1 f;
    public static final d1 g;
    public static final d1 h;
    public static final d1 i;
    public static final d1 j;
    public static final d1 k;
    public static final d1 l;
    public static final d1 m;
    public static final d1 n;
    static final t0.f<d1> o;
    private static final t0.i<String> p = new d1$d<>(0);
    static final t0.f<String> q;
    private final d1.b a;
    private final String b;
    private final Throwable c;

    static class a {
    }

    public enum b {

        ABORTED,
        ALREADY_EXISTS,
        CANCELLED,
        DATA_LOSS,
        DEADLINE_EXCEEDED,
        FAILED_PRECONDITION,
        INTERNAL,
        INVALID_ARGUMENT,
        NOT_FOUND,
        OK,
        OUT_OF_RANGE,
        PERMISSION_DENIED,
        RESOURCE_EXHAUSTED,
        UNAUTHENTICATED,
        UNAVAILABLE,
        UNIMPLEMENTED,
        UNKNOWN;

        private final int value;
        private final byte[] valueAscii;
        static /* synthetic */ byte[] access$300(d1.b bVar) {
            return bVar.valueAscii();
        }

        private byte[] valueAscii() {
            return this.valueAscii;
        }

        @Override // java.lang.Enum
        public d1 toStatus() {
            return (d1)d1.e.get(this.value);
        }

        @Override // java.lang.Enum
        public int value() {
            return this.value;
        }
    }

    private static final class c implements t0.i<d1> {
        private c() {
            super();
        }

        public d1 c(byte[] bArr) {
            return d1.j(bArr);
        }

        public byte[] d(d1 d1Var) {
            return d1Var.n().valueAscii();
        }

        /* synthetic */ c(d1.a aVar) {
            this();
        }
    }

    private static final class d implements t0.i<String> {

        private static final byte[] a;
        static {
            d1.d.a = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
        }

        private d() {
            super();
        }

        private static String e(byte[] bArr) throws java.io.UnsupportedEncodingException {
            int i;
            java.nio.charset.Charset charset;
            int i2 = 2;
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            i = 0;
            for (byte b2 : bArr) {
            }
            return new String(allocate.array(), i, allocate.position(), d.c);
        }

        private static byte[] g(byte[] bArr, int i) {
            int i22;
            byte b;
            byte[] bArr2;
            byte b2;
            int i3;
            byte[] bArr3 = new byte[(bArr.length - i) * 3 + i];
            if (i != 0) {
                i = 0;
                System.arraycopy(bArr, i, bArr3, i, i);
            }
            i22 = i;
            for (byte b : bArr) {
            }
            return Arrays.copyOf(bArr3, i22);
        }

        public String d(byte[] bArr) throws java.io.UnsupportedEncodingException {
            int i;
            byte b;
            byte b2 = 37;
            i = 0;
            while (i < bArr.length) {
                b = bArr[i];
                byte b3 = (byte) 32;
                b3 = (byte) 126;
                b2 = (byte) 37;
                if (bArr.length == (byte) 37) {
                }
            }
            return new String(bArr, i);
        }

        public byte[] f(String str) throws java.io.UnsupportedEncodingException {
            int i = 0;
            byte[] bytes = str.getBytes(d.c);
            i = 0;
            while (d.c < bytes.length) {
                if (d1.d.c(bytes[i])) {
                    return d1.d.g(bytes, i);
                }
            }
            return bytes;
        }

        /* synthetic */ d(d1.a aVar) {
            this();
        }

        private static boolean c(byte b) {
            int i = 32;
            boolean z = false;
            i = 32;
            if (b < 32 || !(b >= 126 && b != 37)) {
                int i3 = 1;
            }
            return z;
        }
    }
    static {
        d1.d = Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));
        d1.e = d1.g();
        d1.f = d1.b.OK.toStatus();
        d1.g = d1.b.CANCELLED.toStatus();
        d1.h = d1.b.UNKNOWN.toStatus();
        d1.b.INVALID_ARGUMENT.toStatus();
        d1.i = d1.b.DEADLINE_EXCEEDED.toStatus();
        d1.b.NOT_FOUND.toStatus();
        d1.b.ALREADY_EXISTS.toStatus();
        d1.j = d1.b.PERMISSION_DENIED.toStatus();
        d1.k = d1.b.UNAUTHENTICATED.toStatus();
        d1.l = d1.b.RESOURCE_EXHAUSTED.toStatus();
        d1.b.FAILED_PRECONDITION.toStatus();
        d1.b.ABORTED.toStatus();
        d1.b.OUT_OF_RANGE.toStatus();
        d1.b.UNIMPLEMENTED.toStatus();
        d1.m = d1.b.INTERNAL.toStatus();
        d1.n = d1.b.UNAVAILABLE.toStatus();
        d1.b.DATA_LOSS.toStatus();
        final boolean z = false;
        io.grpc.t0.f fVar = t0.f.g("grpc-status", z, new d1.c(null));
        d1.o = fVar;
        d1.q = t0.f.g("grpc-message", z, fVar);
    }

    private d1(d1.b bVar) {
        final String str = null;
        this(bVar, str, str);
    }

    static /* synthetic */ List a() {
        return d1.e;
    }

    static /* synthetic */ d1 b(byte[] bArr) {
        return d1.j(bArr);
    }

    private static List<d1> g() {
        int i = 0;
        TreeMap treeMap = new TreeMap();
        io.grpc.d1.b[] values2 = d1.b.values();
        i = 0;
        for (io.grpc.d1.b bVar : values2) {
            Object obj = treeMap.put(Integer.valueOf(bVar.value()), new d1(bVar));
            if (obj != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Code value duplication between ";
                String name = obj.n().name();
                String str2 = " & ";
                String name2 = bVar.name();
                r1 = str + name + str2 + name2;
                throw new IllegalStateException(r1);
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    static String h(d1 d1Var) {
        if (d1Var.b == null) {
            return d1Var.a.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = ": ";
        str4 = d1Var.a + str2 + d1Var.b;
        return str4;
    }

    public static d1 i(int i) {
        if (i >= 0) {
            list = d1.e;
            return (d1)d1.e.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "Unknown code ";
        str2 = str + i;
        return d1.h.r(str2);
    }

    private static d1 j(byte[] bArr) {
        length = bArr.length;
        int i = 1;
        if (bArr.length == 1) {
            if (bArr[0] == (byte) 48) {
                return d1.f;
            }
        }
        return d1.k(bArr);
    }

    private static d1 k(byte[] bArr) throws java.io.UnsupportedEncodingException {
        int i = 1;
        int i2 = 2;
        int length = bArr.length;
        byte b2 = (byte) 57;
        i = 1;
        i = 0;
        final byte b5 = (byte) 48;
        if (length != 1) {
            i2 = 2;
            if (length == 2) {
                if (bArr[i] >= b5) {
                    if (bArr[i] <= b2) {
                        length = (bArr[i] - b5) * 10;
                        i = i + length;
                        if (bArr[i] >= b5) {
                            if (bArr[i] <= b2) {
                                i = i + (bArr[i] - b5);
                                List list = d1.e;
                                if (i < list.size()) {
                                    return (d1)d1.e.get(i);
                                }
                            }
                        }
                    }
                }
            }
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Unknown code ";
        String string = new String(bArr, d.a);
        str2 = str + string;
        return d1.h.r(str2);
    }

    public static d1 l(Throwable th) {
        Object th2;
        n.p(th, "t");
        th2 = th;
        while (th2 != null) {
            z = th2 instanceof StatusRuntimeException;
            if (th2 instanceof StatusRuntimeException) {
                return th2.a();
            }
        }
        return d1.h.q(th);
    }

    public StatusException c() {
        return new StatusException(this);
    }

    public StatusRuntimeException d() {
        return new StatusRuntimeException(this);
    }

    public StatusRuntimeException e(t0 t0Var) {
        return new StatusRuntimeException(this, t0Var);
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public d1 f(String str) {
        if (str == null) {
            return this;
        }
        if (this.b == null) {
            return new d1(this.a, str, this.c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = "\n";
        str = this.b + str4 + str;
        return new d1(this.a, str, this.c);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable m() {
        return this.c;
    }

    public d1.b n() {
        return this.a;
    }

    public String o() {
        return this.b;
    }

    public boolean p() {
        boolean z = true;
        int r0 = d1.b.OK == this.a ? 1 : 0;
        return (d1.b.OK == this.a ? 1 : 0);
    }

    public d1 q(Throwable th) {
        if (k.a(this.c, th)) {
            return this;
        }
        return new d1(this.a, this.b, th);
    }

    public d1 r(String str) {
        if (k.a(this.b, str)) {
            return this;
        }
        return new d1(this.a, str, this.c);
    }

    public String toString() {
        Throwable th;
        j.b bVar = j.c(this);
        bVar.d("code", this.a.name());
        bVar.d("description", this.b);
        if (this.c != null) {
            String str2 = t.e(this.c);
        }
        bVar.d("cause", th);
        return bVar.toString();
    }

    private d1(d1.b bVar, String str, Throwable th) {
        super();
        n.p(bVar, "code");
        this.a = bVar;
        this.b = str;
        this.c = th;
    }
}
