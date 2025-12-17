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

/* loaded from: classes2.dex */
public final class d1 {

    private static final boolean d;
    private static final List<io.grpc.d1> e;
    public static final io.grpc.d1 f;
    public static final io.grpc.d1 g;
    public static final io.grpc.d1 h;
    public static final io.grpc.d1 i;
    public static final io.grpc.d1 j;
    public static final io.grpc.d1 k;
    public static final io.grpc.d1 l;
    public static final io.grpc.d1 m;
    public static final io.grpc.d1 n;
    static final io.grpc.t0.f<io.grpc.d1> o;
    private static final io.grpc.t0.i<String> p;
    static final io.grpc.t0.f<String> q;
    private final io.grpc.d1.b a;
    private final String b;
    private final Throwable c;

    static class a {
    }

    public static enum b {

        OK(false),
        CANCELLED(true),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(6),
        RESOURCE_EXHAUSTED(5),
        FAILED_PRECONDITION(4),
        ABORTED(3),
        OUT_OF_RANGE(2),
        UNIMPLEMENTED(true),
        INTERNAL(false),
        UNAVAILABLE(2),
        DATA_LOSS(true),
        UNAUTHENTICATED(false);

        private final int value;
        private final byte[] valueAscii;
        static byte[] access$300(io.grpc.d1.b d1$b) {
            return b.valueAscii();
        }

        private byte[] valueAscii() {
            return this.valueAscii;
        }

        @Override // java.lang.Enum
        public io.grpc.d1 toStatus() {
            return (d1)d1.a().get(this.value);
        }

        @Override // java.lang.Enum
        public int value() {
            return this.value;
        }
    }

    private static final class c implements io.grpc.t0.i<io.grpc.d1> {
        c(io.grpc.d1.a d1$a) {
            super();
        }

        @Override // io.grpc.t0$i
        public byte[] a(Object object) {
            return d((d1)object);
        }

        @Override // io.grpc.t0$i
        public Object b(byte[] bArr) {
            return c(bArr);
        }

        @Override // io.grpc.t0$i
        public io.grpc.d1 c(byte[] bArr) {
            return d1.b(bArr);
        }

        @Override // io.grpc.t0$i
        public byte[] d(io.grpc.d1 d1) {
            return d1.b.access$300(d1.n());
        }
    }

    private static final class d implements io.grpc.t0.i<String> {

        private static final byte[] a;
        static {
            byte[] bArr = new byte[16];
            bArr = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
            d1.d.a = bArr;
        }

        d(io.grpc.d1.a d1$a) {
            super();
        }

        private static boolean c(byte b) {
            int i;
            int obj1;
            if (b >= 32 && b < 126) {
                if (b < 126) {
                    if (b == 37) {
                        obj1 = 1;
                    } else {
                        obj1 = 0;
                    }
                } else {
                }
            } else {
            }
            return obj1;
        }

        private static String e(byte[] bArr) {
            int i2;
            byte b2;
            byte b;
            int length;
            java.nio.charset.Charset charset;
            int i;
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            final int i3 = 0;
            i2 = i3;
            for (byte b2 : bArr) {
                if (bArr[i2] == 37 && i2 + 2 < bArr.length) {
                } else {
                }
                allocate.put(b2);
                if (i2 + 2 < bArr.length) {
                } else {
                }
                String string = new String(bArr, i2 + 1, 2, d.a);
                allocate.put((byte)int);
                i2 += 3;
            }
            String obj7 = new String(allocate.array(), i3, allocate.position(), d.c);
            return obj7;
        }

        private static byte[] g(byte[] bArr, int i2) {
            int i4;
            int i;
            byte b2;
            int i3;
            byte[] bArr2;
            byte b;
            int obj7;
            byte[] bArr3 = new byte[i6 += i2];
            if (i2 != 0) {
                i4 = 0;
                System.arraycopy(bArr, i4, bArr3, i4, i2);
            }
            i = i2;
            while (obj7 < bArr.length) {
                b2 = bArr[obj7];
                if (d1.d.c(b2)) {
                } else {
                }
                bArr3[i] = b2;
                i = i3;
                obj7++;
                bArr3[i] = 37;
                bArr2 = d1.d.a;
                bArr3[i + 1] = bArr2[i11 &= 15];
                bArr3[i + 2] = bArr2[b2 &= 15];
                i += 3;
            }
            return Arrays.copyOf(bArr3, i);
        }

        @Override // io.grpc.t0$i
        public byte[] a(Object object) {
            return f((String)object);
        }

        @Override // io.grpc.t0$i
        public Object b(byte[] bArr) {
            return d(bArr);
        }

        @Override // io.grpc.t0$i
        public String d(byte[] bArr) {
            int i;
            byte b;
            int length;
            final int i2 = 0;
            i = i2;
            for (byte b : bArr) {
            }
            String string = new String(bArr, i2);
            return string;
        }

        @Override // io.grpc.t0$i
        public byte[] f(String string) {
            int i;
            boolean z;
            byte[] obj3 = string.getBytes(d.c);
            i = 0;
            for (byte b : string) {
            }
            return obj3;
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
        int i = 0;
        d1.c cVar = new d1.c(i);
        final int i2 = 0;
        d1.o = t0.f.g("grpc-status", i2, cVar);
        d1.d dVar = new d1.d(i);
        d1.p = dVar;
        d1.q = t0.f.g("grpc-message", i2, dVar);
    }

    private d1(io.grpc.d1.b d1$b) {
        final int i = 0;
        super(b, i, i);
    }

    private d1(io.grpc.d1.b d1$b, String string2, Throwable throwable3) {
        super();
        n.p(b, "code");
        this.a = (d1.b)b;
        this.b = string2;
        this.c = throwable3;
    }

    static List a() {
        return d1.e;
    }

    static io.grpc.d1 b(byte[] bArr) {
        return d1.j(bArr);
    }

    private static List<io.grpc.d1> g() {
        int i;
        io.grpc.d1.b bVar;
        Object obj;
        io.grpc.d1 d1Var;
        TreeMap treeMap = new TreeMap();
        io.grpc.d1.b[] values2 = d1.b.values();
        i = 0;
        while (i < values2.length) {
            bVar = values2[i];
            d1Var = new d1(bVar);
            obj = treeMap.put(Integer.valueOf(bVar.value()), d1Var);
            i++;
        }
        ArrayList arrayList = new ArrayList(treeMap.values());
        return Collections.unmodifiableList(arrayList);
    }

    static String h(io.grpc.d1 d1) {
        if (d1.b == null) {
            return d1.a.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d1.a);
        stringBuilder.append(": ");
        stringBuilder.append(d1.b);
        return stringBuilder.toString();
    }

    public static io.grpc.d1 i(int i) {
        List list;
        int size;
        list = d1.e;
        if (i >= 0 && i > list.size()) {
            list = d1.e;
            if (i > list.size()) {
            }
            return (d1)list.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown code ");
        stringBuilder.append(i);
        return d1.h.r(stringBuilder.toString());
    }

    private static io.grpc.d1 j(byte[] bArr) {
        int length;
        int i;
        if (bArr.length == 1 && bArr[0] == 48) {
            if (bArr[0] == 48) {
                return d1.f;
            }
        }
        return d1.k(bArr);
    }

    private static io.grpc.d1 k(byte[] bArr) {
        byte length;
        int size;
        int i3;
        int i;
        int i2;
        length = bArr.length;
        size = 57;
        i = 0;
        final int i6 = 48;
        if (length != 1) {
            if (length != 2) {
            } else {
                if (bArr[i] >= i6) {
                    if (bArr[i] > size) {
                    } else {
                        i += length;
                        if (bArr[i3] >= i6) {
                            if (bArr[i3] > size) {
                            } else {
                                i += i5;
                                length = d1.e;
                                if (i < length.size()) {
                                    return (d1)length.get(i);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            i3 = i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown code ");
        String string = new String(bArr, d.a);
        stringBuilder.append(string);
        return d1.h.r(stringBuilder.toString());
    }

    public static io.grpc.d1 l(Throwable throwable) {
        Object cause;
        boolean z;
        n.p(throwable, "t");
        cause = throwable;
        while (cause != null) {
            cause = cause.getCause();
        }
        return d1.h.q(throwable);
    }

    public io.grpc.StatusException c() {
        StatusException statusException = new StatusException(this);
        return statusException;
    }

    public io.grpc.StatusRuntimeException d() {
        StatusRuntimeException statusRuntimeException = new StatusRuntimeException(this);
        return statusRuntimeException;
    }

    public io.grpc.StatusRuntimeException e(io.grpc.t0 t0) {
        StatusRuntimeException statusRuntimeException = new StatusRuntimeException(this, t0);
        return statusRuntimeException;
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public io.grpc.d1 f(String string) {
        if (string == null) {
            return this;
        }
        if (this.b == null) {
            d1 d1Var = new d1(this.a, string, this.c);
            return d1Var;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append("\n");
        stringBuilder.append(string);
        d1 d1Var2 = new d1(this.a, stringBuilder.toString(), this.c);
        return d1Var2;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable m() {
        return this.c;
    }

    public io.grpc.d1.b n() {
        return this.a;
    }

    public String o() {
        return this.b;
    }

    public boolean p() {
        int i;
        i = d1.b.OK == this.a ? 1 : 0;
        return i;
    }

    public io.grpc.d1 q(Throwable throwable) {
        if (k.a(this.c, throwable)) {
            return this;
        }
        d1 d1Var = new d1(this.a, this.b, throwable);
        return d1Var;
    }

    public io.grpc.d1 r(String string) {
        if (k.a(this.b, string)) {
            return this;
        }
        d1 d1Var = new d1(this.a, string, this.c);
        return d1Var;
    }

    public String toString() {
        Object th;
        j.b bVar = j.c(this);
        bVar.d("code", this.a.name());
        bVar.d("description", this.b);
        th = this.c;
        if (th != null) {
            th = t.e(th);
        }
        bVar.d("cause", th);
        return bVar.toString();
    }
}
