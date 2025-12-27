package io.grpc;

import com.google.common.base.d;
import com.google.common.base.n;
import com.google.common.io.BaseEncoding;
import com.google.common.io.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: Metadata.java */
/* loaded from: classes2.dex */
public final class t0 {

    public static final t0.d<String> c = new t0$b<>();
    static final BaseEncoding d;
    private Object[] a;
    private int b;

    class a {
    }

    public interface d<T> {
        String a(T t);

        T b(String str);
    }

    public interface e<T> {
        InputStream a(T t);

        T b(InputStream inputStream);
    }

    public static abstract class f<T> {

        private static final BitSet e;
        private final String a;
        private final String b;
        private final byte[] c;
        private final Object d;
        static {
            t0.f.e = t0.f.b();
        }

        /* synthetic */ f(String str, boolean z, Object object, t0.a aVar) {
            this(str, z, object);
        }

        private static BitSet b() {
            int i = 48;
            int i2 = 97;
            final BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            i = 48;
            int i3 = 57;
            while (i <= 57) {
                bitSet.set(i);
                i = (char)(i + 1);
                i3 = 57;
            }
            i2 = 97;
            i3 = 122;
            while (i2 <= 122) {
                bitSet.set(i2);
                i2 = (char)(i2 + 1);
                i3 = 122;
            }
            return bitSet;
        }

        public static <T> t0.f<T> e(String str, t0.d<T> dVar) {
            return t0.f.f(str, false, dVar);
        }

        static <T> t0.f<T> f(String str, boolean z, t0.d<T> dVar) {
            return new t0.c(str, z, dVar, null);
        }

        static <T> t0.f<T> g(String str, boolean z, t0.i<T> iVar) {
            return new t0.h(str, z, iVar, null);
        }

        private static String k(String str, boolean z) {
            int i = 0;
            char c;
            String str3;
            n.p(str, "name");
            str2 = "token must have at least 1 tchar";
            n.e(!str.isEmpty(), str2);
            i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                i = i + 1;
            }
            return str;
        }

        byte[] a() {
            return this.c;
        }

        final <M> M c(Class<M> cls) {
            if (cls.isInstance(this.d)) {
                return cls.cast(this.d);
            }
            return null;
        }

        public final String d() {
            return this.b;
        }

        public final boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object != null) {
                return this.b.equals(object.b);
            }
            return false;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Key{name='";
            String str4 = "'}";
            str = str2 + this.b + str4;
            return str;
        }

        private f(String str, boolean z, Object object) throws java.io.UnsupportedEncodingException {
            super();
            n.p(str, "name");
            this.a = str;
            String str3 = str.toLowerCase(Locale.ROOT);
            t0.f.k(str3, z);
            this.b = str3;
            this.c = str3.getBytes(d.a);
            this.d = object;
        }

        abstract T h(byte[] bArr);

        boolean i() {
            return false;
        }

        abstract byte[] j(T t);
    }

    static final class g<T> {

        private final t0.e<T> a;
        private final T b;
        private volatile byte[] c;
        g(t0.e<T> eVar, T t) {
            super();
            this.a = eVar;
            this.b = t;
        }

        static <T> t0.g<T> a(t0.f<T> fVar, T t) {
            final io.grpc.t0.e eVar = t0.g.b(fVar);
            n.o(eVar);
            return new t0.g(eVar, t);
        }

        private static <T> t0.e<T> b(t0.f<T> fVar) {
            return (t0.e)fVar.c(t0.e.class);
        }

        byte[] c() {
            byte[] bArr;
            if (this.c == null) {
                synchronized (this) {
                    try {
                        if (this.c == null) {
                            this.c = t0.q(e());
                        }
                    } catch (Throwable th) {
                    }
                }
            }
            return this.c;
        }

        <T2> T2 d(t0.f<T2> fVar) {
            if (fVar.i() && eVar != null) {
                return eVar.b(e());
            }
            return fVar.h(c());
        }

        InputStream e() {
            return this.a.a(this.b);
        }
    }

    interface i<T> {
        byte[] a(T t);

        T b(byte[] bArr);
    }

    class b implements t0.d<String> {
        b() {
            super();
        }

        public String c(String str) {
            return str;
        }

        public String d(String str) {
            return str;
        }
    }

    private static class c<T> extends t0.f<T> {

        private final t0.d<T> f;
        /* synthetic */ c(String str, boolean z, t0.d dVar, t0.a aVar) {
            this(str, z, dVar);
        }

        @Override // io.grpc.t0$f
        T h(byte[] bArr) throws java.io.UnsupportedEncodingException {
            return this.f.b(new String(bArr, d.a));
        }

        @Override // io.grpc.t0$f
        byte[] j(T t) throws java.io.UnsupportedEncodingException {
            return this.f.a(t).getBytes(d.a);
        }

        private c(String str, boolean z, t0.d<T> dVar) {
            super(str, z, dVar, null);
            final String str4 = "-bin";
            n.l(!str.endsWith(str4), "ASCII header is named %s.  Only binary headers may end with %s", str, str4);
            n.p(dVar, "marshaller");
            this.f = dVar;
        }
    }

    private static final class h<T> extends t0.f<T> {

        private final t0.i<T> f;
        /* synthetic */ h(String str, boolean z, t0.i iVar, t0.a aVar) {
            this(str, z, iVar);
        }

        @Override // io.grpc.t0$f
        T h(byte[] bArr) {
            return this.f.b(bArr);
        }

        @Override // io.grpc.t0$f
        byte[] j(T t) {
            return this.f.a(t);
        }

        private h(String str, boolean z, t0.i<T> iVar) {
            super(str, z, iVar, null);
            final String str4 = "-bin";
            n.l(!str.endsWith(str4), "ASCII header is named %s.  Only binary headers may end with %s", str, str4);
            n.p(iVar, "marshaller");
            this.f = iVar;
        }
    }
    static {
        t0.d = BaseEncoding.b().l();
    }

    t0(byte[]... bArrArr) {
        this(bArrArr.length / 2, bArrArr);
    }

    static /* synthetic */ byte[] a(InputStream inputStream) {
        return t0.q(inputStream);
    }

    private boolean b(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private int c() {
        int length = 0;
        int r0 = this.a != null ? objArr.length : 0;
        return (this.a != null ? objArr.length : 0);
    }

    private void e(int i) {
        final Object[] arr = new Object[i];
        if (!h()) {
            int i3 = 0;
            System.arraycopy(this.a, i3, arr, i3, j());
        }
        this.a = arr;
    }

    private boolean h() {
        boolean z = true;
        int r0 = this.b == 0 ? 1 : 0;
        return (this.b == 0 ? 1 : 0);
    }

    private int j() {
        return this.b * 2;
    }

    private void k() {
        if (j() != 0) {
            if (j() == c()) {
                int i = 8;
                e(Math.max(j() * 2, i));
            }
        }
    }

    private void m(int i, byte[] bArr) {
        this.a[i * 2] = bArr;
    }

    private byte[] n(int i) {
        return (byte[])this.a[i * 2];
    }

    private static byte[] q(InputStream inputStream) {
        try {
        } catch (java.io.IOException ioException) {
            throw new RuntimeException("failure reading serialized stream", ioException);
        }
        return a.d(inputStream);
    }

    private Object r(int i) {
        return this.a[(i * 2) + 1];
    }

    private void s(int i, Object object) {
        z = this.a instanceof byte[][];
        if (this.a instanceof byte[][]) {
            e(c());
        }
        this.a[(i * 2) + 1] = object;
    }

    private void t(int i, byte[] bArr) {
        this.a[(i * 2) + 1] = bArr;
    }

    private byte[] u(int i) {
        Object obj = r(i);
        if (obj instanceof byte[]) {
            return obj;
        }
        return obj.c();
    }

    private <T> T v(int i, t0.f<T> fVar) {
        Object obj = r(i);
        if (obj instanceof byte[]) {
            return fVar.h(obj);
        }
        return obj.d(fVar);
    }

    public <T> void d(t0.f<T> fVar) {
        int i = 0;
        Object obj;
        if (h()) {
            return;
        }
        i = 0;
        while (i < this.b) {
            i = i + 1;
        }
        Arrays.fill(this.a, i * 2, j(), null);
        this.b = i;
    }

    public <T> T f(t0.f<T> fVar) {
        int i;
        i = this.b - 1;
        while (i >= 0) {
            if (b(fVar.a(), n(i))) {
                return v(i, fVar);
            }
        }
        return null;
    }

    int g() {
        return this.b;
    }

    public Set<String> i() throws java.io.UnsupportedEncodingException {
        int i;
        if (h()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.b);
        i = 0;
        while (i < this.b) {
            hashSet.add(new String(n(i), i));
            i = i + 1;
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void l(t0 t0Var) {
        if (t0Var.h()) {
            return;
        }
        i = c() - j();
        if (h() || this.c() - this.j() < t0Var.j()) {
            i = j() + t0Var.j();
            e(i);
        }
        System.arraycopy(t0Var.a, 0, this.a, j(), t0Var.j());
        this.b += i11;
    }

    public <T> void o(t0.f<T> fVar, T t) {
        n.p(fVar, "key");
        n.p(t, "value");
        k();
        m(this.b, fVar.a());
        if (fVar.i()) {
            s(this.b, t0.g.a(fVar, t));
        } else {
            t(this.b, fVar.j(t));
        }
        this.b++;
    }

    byte[][] p() {
        boolean z;
        int i2 = 0;
        byte[][] bArr = new byte[j()];
        z = objArr instanceof byte[][];
        i2 = 0;
        if (objArr instanceof byte[][]) {
            System.arraycopy(this.a, i2, bArr, i2, j());
        } else {
            while (i2 < this.b) {
                int i5 = i2 * 2;
                bArr[i5] = n(i2);
                objArr = i5 + 1;
                bArr[objArr] = u(i2);
                i2 = i2 + 1;
            }
        }
        return bArr;
    }

    public String toString() throws java.io.UnsupportedEncodingException {
        int i = 0;
        String string;
        byte[] bArr;
        StringBuilder stringBuilder = new StringBuilder("Metadata(");
        i = 0;
        while (i < this.b) {
            stringBuilder.append(t0.d.f(u(i)));
            stringBuilder.append(new String(u(i), charset));
            i = i + 1;
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    t0(int i, byte[]... bArrArr) {
        this(i, bArrArr);
    }

    t0(int i, Object[] objectArr) {
        super();
        this.b = i;
        this.a = objectArr;
    }
}
