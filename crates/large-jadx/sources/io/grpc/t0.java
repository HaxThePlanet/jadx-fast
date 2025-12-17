package io.grpc;

import com.google.common.base.d;
import com.google.common.base.n;
import com.google.common.io.BaseEncoding;
import com.google.common.io.a;
import java.io.InputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes2.dex */
public final class t0 {

    public static final io.grpc.t0.d<String> c;
    static final BaseEncoding d;
    private Object[] a;
    private int b;

    class a {
    }

    public interface d {
        public abstract String a(T t);

        public abstract T b(String string);
    }

    public interface e {
        public abstract InputStream a(T t);

        public abstract T b(InputStream inputStream);
    }

    public static abstract class f {

        private static final BitSet e;
        private final String a;
        private final String b;
        private final byte[] c;
        private final Object d;
        static {
            t0.f.e = t0.f.b();
        }

        private f(String string, boolean z2, Object object3) {
            super();
            n.p(string, "name");
            this.a = (String)string;
            String obj2 = string.toLowerCase(Locale.ROOT);
            t0.f.k(obj2, z2);
            this.b = obj2;
            this.c = obj2.getBytes(d.a);
            this.d = object3;
        }

        f(String string, boolean z2, Object object3, io.grpc.t0.a t0$a4) {
            super(string, z2, object3);
        }

        private static BitSet b() {
            int i;
            int i3;
            int i2;
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            i = 48;
            while (i <= 57) {
                bitSet.set(i);
                i = (char)i9;
            }
            i3 = 97;
            while (i3 <= 122) {
                bitSet.set(i3);
                i3 = (char)i8;
            }
            return bitSet;
        }

        public static <T> io.grpc.t0.f<T> e(String string, io.grpc.t0.d<T> t0$d2) {
            return t0.f.f(string, false, d2);
        }

        static <T> io.grpc.t0.f<T> f(String string, boolean z2, io.grpc.t0.d<T> t0$d3) {
            t0.c cVar = new t0.c(string, z2, d3, 0);
            return cVar;
        }

        static <T> io.grpc.t0.f<T> g(String string, boolean z2, io.grpc.t0.i<T> t0$i3) {
            t0.h hVar = new t0.h(string, z2, i3, 0);
            return hVar;
        }

        private static String k(String string, boolean z2) {
            int i;
            String charAt;
            int i2;
            String str;
            n.p(string, "name");
            n.e(empty ^= 1, "token must have at least 1 tchar");
            i = 0;
            while (i < string.length()) {
                charAt = string.charAt(i);
                if (z2 && charAt == 58 && i == 0) {
                } else {
                }
                n.g(t0.f.e.get(charAt), "Invalid character '%s' in key name '%s'", charAt, string);
                i++;
                if (charAt == 58) {
                } else {
                }
                if (i == 0) {
                } else {
                }
            }
            return string;
        }

        byte[] a() {
            return this.c;
        }

        final <M> M c(Class<M> class) {
            if (class.isInstance(this.d)) {
                return class.cast(this.d);
            }
            return 0;
        }

        public final String d() {
            return this.b;
        }

        public final boolean equals(Object object) {
            Class class2;
            Class class;
            if (this == object) {
                return 1;
            }
            if (object != null && getClass() != object.getClass()) {
                if (getClass() != object.getClass()) {
                }
                return this.b.equals(object.b);
            }
            return 0;
        }

        abstract T h(byte[] bArr);

        public final int hashCode() {
            return this.b.hashCode();
        }

        boolean i() {
            return 0;
        }

        abstract byte[] j(T t);

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Key{name='");
            stringBuilder.append(this.b);
            stringBuilder.append("'}");
            return stringBuilder.toString();
        }
    }

    static final class g {

        private final io.grpc.t0.e<T> a;
        private final T b;
        private volatile byte[] c;
        g(io.grpc.t0.e<T> t0$e, T t2) {
            super();
            this.a = e;
            this.b = t2;
        }

        static <T> io.grpc.t0.g<T> a(io.grpc.t0.f<T> t0$f, T t2) {
            final io.grpc.t0.e obj1 = t0.g.b(f);
            n.o(obj1);
            t0.g gVar = new t0.g((t0.e)obj1, t2);
            return gVar;
        }

        private static <T> io.grpc.t0.e<T> b(io.grpc.t0.f<T> t0$f) {
            return (t0.e)f.c(t0.e.class);
        }

        byte[] c() {
            byte[] bArr;
            if (this.c == null && this.c == null) {
                synchronized (this) {
                    this.c = t0.a(e());
                }
            }
            try {
                return this.c;
            }
        }

        <T2> T2 d(io.grpc.t0.f<T2> t0$f) {
            boolean z;
            z = t0.g.b(f);
            if (f.i() && z != null) {
                z = t0.g.b(f);
                if (z != null) {
                    return z.b(e());
                }
            }
            return f.h(c());
        }

        InputStream e() {
            return this.a.a(this.b);
        }
    }

    interface i {
        public abstract byte[] a(T t);

        public abstract T b(byte[] bArr);
    }

    class b implements io.grpc.t0.d<String> {
        @Override // io.grpc.t0$d
        public String a(Object object) {
            d((String)object);
            return object;
        }

        @Override // io.grpc.t0$d
        public Object b(String string) {
            c(string);
            return string;
        }

        @Override // io.grpc.t0$d
        public String c(String string) {
            return string;
        }

        @Override // io.grpc.t0$d
        public String d(String string) {
            return string;
        }
    }

    private static class c extends io.grpc.t0.f<T> {

        private final io.grpc.t0.d<T> f;
        private c(String string, boolean z2, io.grpc.t0.d<T> t0$d3) {
            super(string, z2, d3, 0);
            final String obj4 = "-bin";
            n.l(endsWith ^= 1, "ASCII header is named %s.  Only binary headers may end with %s", string, obj4);
            n.p(d3, "marshaller");
            this.f = d3;
        }

        c(String string, boolean z2, io.grpc.t0.d t0$d3, io.grpc.t0.a t0$a4) {
            super(string, z2, d3);
        }

        T h(byte[] bArr) {
            String string = new String(bArr, d.a);
            return this.f.b(string);
        }

        byte[] j(T t) {
            return this.f.a(t).getBytes(d.a);
        }
    }

    private static final class h extends io.grpc.t0.f<T> {

        private final io.grpc.t0.i<T> f;
        private h(String string, boolean z2, io.grpc.t0.i<T> t0$i3) {
            super(string, z2, i3, 0);
            final String obj4 = "-bin";
            n.l(endsWith ^= 1, "ASCII header is named %s.  Only binary headers may end with %s", string, obj4);
            n.p(i3, "marshaller");
            this.f = i3;
        }

        h(String string, boolean z2, io.grpc.t0.i t0$i3, io.grpc.t0.a t0$a4) {
            super(string, z2, i3);
        }

        T h(byte[] bArr) {
            return this.f.b(bArr);
        }

        byte[] j(T t) {
            return this.f.a(t);
        }
    }
    static {
        t0.b bVar = new t0.b();
        t0.c = bVar;
        t0.d = BaseEncoding.b().l();
    }

    t0(int i, Object[] object2Arr2) {
        super();
        this.b = i;
        this.a = object2Arr2;
    }

    t0(int i, byte[]... b2Arr2Arr2) {
        super(i, b2Arr2Arr2);
    }

    t0(byte[]... bArrArr) {
        super(length /= 2, bArrArr);
    }

    static byte[] a(InputStream inputStream) {
        return t0.q(inputStream);
    }

    private boolean b(byte[] bArr, byte[] b2Arr2) {
        return Arrays.equals(bArr, b2Arr2);
    }

    private int c() {
        int length;
        Object[] objArr = this.a;
        length = objArr != null ? objArr.length : 0;
        return length;
    }

    private void e(int i) {
        boolean z;
        int i2;
        int i3;
        final Object[] obj4 = new Object[i];
        if (!h()) {
            i3 = 0;
            System.arraycopy(this.a, i3, obj4, i3, j());
        }
        this.a = obj4;
    }

    private boolean h() {
        int i;
        i = this.b == 0 ? 1 : 0;
        return i;
    }

    private int j() {
        return i *= 2;
    }

    private void k() {
        int i2;
        int i;
        if (j() != 0) {
            if (j() == c()) {
                e(Math.max(i3 *= 2, 8));
            }
        } else {
        }
    }

    private void m(int i, byte[] b2Arr2) {
        this.a[i *= 2] = b2Arr2;
    }

    private byte[] n(int i) {
        return (byte[])this.a[i *= 2];
    }

    private static byte[] q(InputStream inputStream) {
        try {
            return a.d(inputStream);
            RuntimeException runtimeException = new RuntimeException("failure reading serialized stream", inputStream);
            throw runtimeException;
        }
    }

    private Object r(int i) {
        return this.a[obj2++];
    }

    private void s(int i, Object object2) {
        boolean z;
        if (objArr instanceof byte[][]) {
            e(c());
        }
        this.a[obj2++] = object2;
    }

    private void t(int i, byte[] b2Arr2) {
        this.a[obj2++] = b2Arr2;
    }

    private byte[] u(int i) {
        Object obj2 = r(i);
        if (obj2 instanceof byte[]) {
            return (byte[])obj2;
        }
        return (t0.g)obj2.c();
    }

    private <T> T v(int i, io.grpc.t0.f<T> t0$f2) {
        Object obj2 = r(i);
        if (obj2 instanceof byte[]) {
            return f2.h((byte[])obj2);
        }
        return (t0.g)obj2.d(f2);
    }

    public <T> void d(io.grpc.t0.f<T> t0$f) {
        int i;
        int i2;
        Object obj;
        byte[] bArr;
        if (h()) {
        }
        i2 = i;
        while (i < this.b) {
            if (b(f.a(), n(i))) {
            } else {
            }
            m(i2, n(i));
            s(i2, r(i));
            i2++;
            i++;
        }
        Arrays.fill(this.a, i2 * 2, j(), 0);
        this.b = i2;
    }

    public <T> T f(io.grpc.t0.f<T> t0$f) {
        int i;
        boolean z;
        byte[] bArr;
        i2--;
        while (i >= 0) {
            i--;
        }
        return 0;
    }

    int g() {
        return this.b;
    }

    public Set<String> i() {
        int i;
        String string;
        byte[] bArr;
        if (h()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.b);
        int i3 = 0;
        i = i3;
        while (i < this.b) {
            string = new String(n(i), i3);
            hashSet.add(string);
            i++;
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void l(io.grpc.t0 t0) {
        int i;
        int z;
        if (t0.h()) {
        }
        if (!h()) {
            if (i2 -= i6 < t0.j()) {
                e(i5 += z);
            }
        } else {
        }
        System.arraycopy(t0.a, 0, this.a, j(), t0.j());
        this.b = i3 += obj6;
    }

    public <T> void o(io.grpc.t0.f<T> t0$f, T t2) {
        int i;
        io.grpc.t0.g obj3;
        n.p(f, "key");
        n.p(t2, "value");
        k();
        m(this.b, f.a());
        if (f.i()) {
            s(this.b, t0.g.a(f, t2));
        } else {
            t(this.b, f.j(t2));
        }
        this.b = obj3++;
    }

    byte[][] p() {
        Object[] objArr;
        int i2;
        int i;
        byte[][] bArr = new byte[j()];
        objArr = this.a;
        i = 0;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, i, bArr, i, j());
        }
        return bArr;
    }

    public String toString() {
        int i2;
        String string;
        int i;
        byte[] bArr;
        java.nio.charset.Charset charset;
        StringBuilder stringBuilder = new StringBuilder("Metadata(");
        i2 = 0;
        while (i2 < this.b) {
            if (i2 != 0) {
            }
            charset = d.a;
            String string3 = new String(n(i2), charset);
            stringBuilder.append(string3);
            stringBuilder.append('=');
            if (string3.endsWith("-bin")) {
            } else {
            }
            string = new String(u(i2), charset);
            stringBuilder.append(string);
            i2++;
            stringBuilder.append(t0.d.f(u(i2)));
            stringBuilder.append(',');
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
