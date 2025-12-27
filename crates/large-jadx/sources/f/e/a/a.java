package f.e.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache.java */
/* loaded from: classes2.dex */
public final class a implements Closeable {

    static final Pattern G;
    private static final OutputStream H = new a$b();
    private Writer A;
    private final LinkedHashMap<String, a.d> B;
    private int C;
    private long D;
    final ThreadPoolExecutor E;
    private final Callable<Void> F;
    private final File a;
    private final File b;
    private final File c;
    private final File v;
    private final int w;
    private long x;
    private final int y;
    private long z;

    class a implements Callable<Void> {

        final /* synthetic */ a a;
        a() {
            this.a = aVar;
            super();
        }

        public Void a() {
            synchronized (aVar) {
                try {
                    final int i2 = 0;
                    if (this.a.A == null) {
                        return null;
                    }
                    this.a.e0();
                    if (this.a.J()) {
                        this.a.U();
                        int i = 0;
                        this.a.C = i;
                    }
                    return i2;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
    }

    static class b extends OutputStream {
        b() {
            super();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    public final class c {

        private final a.d a;
        private final boolean[] b;
        private boolean c;
        final /* synthetic */ a d;
        /* synthetic */ c(a.d dVar, a.a aVar) {
            this(aVar, dVar);
        }

        static /* synthetic */ a.d b(a.c cVar) {
            return cVar.a;
        }

        static /* synthetic */ boolean[] c(a.c cVar) {
            return cVar.b;
        }

        static /* synthetic */ boolean d(a.c cVar, boolean z) {
            cVar.c = z;
            return z;
        }

        public void a() {
            this.d.q(this, 0);
        }

        public void e() {
            if (this.c) {
                this.d.q(this, 0);
                this.d.V(this.a.a);
            } else {
                this.d.q(this, true);
            }
        }

        public OutputStream f(int i) {
            Object obj2;
            synchronized (aVar) {
                try {
                    if (!this.a.c) {
                        boolean z2 = true;
                        this.b[i] = z2;
                    }
                } catch (java.io.FileNotFoundException unused) {
                } catch (Throwable unused) {
                }
                throw new IllegalStateException();
            }
        }

        private c(a.d dVar) {
            int i = 0;
            this.d = aVar;
            super();
            this.a = dVar;
            i = dVar.c ? 0 : new boolean[i2];
            this.b = i;
        }
    }

    private final class d {

        private final String a;
        private final long[] b;
        private boolean c;
        private a.c d;
        private long e;
        final /* synthetic */ a f;
        /* synthetic */ d(String str, a.a aVar) {
            this(aVar, str);
        }

        static /* synthetic */ long[] a(a.d dVar) {
            return dVar.b;
        }

        static /* synthetic */ String b(a.d dVar) {
            return dVar.a;
        }

        static /* synthetic */ long c(a.d dVar) {
            return dVar.e;
        }

        static /* synthetic */ long d(a.d dVar, long j) {
            dVar.e = j;
            return j;
        }

        static /* synthetic */ boolean e(a.d dVar) {
            return dVar.c;
        }

        static /* synthetic */ boolean f(a.d dVar, boolean z) {
            dVar.c = z;
            return z;
        }

        static /* synthetic */ a.c g(a.d dVar) {
            return dVar.d;
        }

        static /* synthetic */ a.c h(a.d dVar, a.c cVar) {
            dVar.d = cVar;
            return cVar;
        }

        static /* synthetic */ void i(a.d dVar, String[] strArr) {
            dVar.n(strArr);
        }

        private IOException m(String[] strArr) throws IOException {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "unexpected journal line: ";
            String str2 = Arrays.toString(strArr);
            strArr = str + str2;
            throw new IOException(strArr);
        }

        private void n(String[] strArr) {
            int i = 0;
            if (strArr.length != this.f.y) {
                m(strArr);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            } else {
                i = 0;
                while (strArr.length < strArr.length) {
                    this.b[i] = Long.parseLong(strArr[i]);
                    i = i + 1;
                    try {
                        this.b[i] = Long.parseLong(strArr[i]);
                    } catch (java.lang.NumberFormatException unused) {
                        m(strArr);
                        throw obj;
                    }
                }
                return;
            }
        }

        public File j(int i) {
            final StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".";
            i = this.a + str2 + i;
            return new File(this.f.a, i);
        }

        public File k(int i) {
            final StringBuilder stringBuilder = new StringBuilder();
            String str2 = ".";
            String str3 = ".tmp";
            i = this.a + str2 + i + str3;
            return new File(this.f.a, i);
        }

        public String l() {
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            for (long l : lArr) {
                char c = ' ';
                stringBuilder.append(c);
                stringBuilder.append(l);
            }
            return stringBuilder.toString();
        }

        private d(String str) {
            this.f = aVar;
            super();
            this.a = str;
            this.b = new long[aVar.y];
        }
    }

    public final class e implements Closeable {

        private final InputStream[] a;
        private final long[] b;
        /* synthetic */ e(String str, long j, InputStream[] inputStreamArr, long[] jArr, a.a aVar) {
            this(aVar, str, j, r4, inputStreamArr, jArr);
        }

        public InputStream a(int i) {
            return this.a[i];
        }

        public long c(int i) {
            return this.b[i];
        }

        @Override // java.io.Closeable
        public void close() {
            int i = 0;
            i = 0;
            for (InputStream inputStream : objArr) {
                c.a(inputStream);
            }
        }

        private e(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            super();
            this.a = inputStreamArr;
            this.b = jArr;
        }
    }
    static {
        a.G = Pattern.compile("[a-z0-9_-]{1,64}");
    }

    private a(File file, int i, int i2, long j) {
        final f.e.a.a file3 = this;
        File file2 = file;
        super();
        long l = 0L;
        file3.z = l;
        file3.B = new LinkedHashMap(0, 0.75f, true);
        file3.D = l;
        super(0, 1, 60L, timeUnit, TimeUnit.SECONDS, new LinkedBlockingQueue());
        file3.E = threadPoolExecutor;
        file3.F = new a.a(this);
        file3.a = file2;
        file3.w = i;
        file3.b = new File(file2, "journal");
        file3.c = new File(file2, "journal.tmp");
        file3.v = new File(file2, "journal.bkp");
        file3.y = i2;
        file3.x = j;
    }

    private synchronized a.c E(String str, long j) {
        f.e.a.a.d dVar;
        o();
        g0(str);
        Object value = this.B.get(str);
        final f.e.a.a.a aVar = null;
        long l = value.e;
        if (value == null) {
            this.B.put(str, new a.d(this, str, aVar));
        }
        f.e.a.a.c cVar = new a.c(this, dVar, aVar);
        dVar.d = cVar;
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DIRTY ";
        str3 = str2 + str + 10;
        this.A.write(str3);
        this.A.flush();
        return cVar;
    }

    private boolean J() {
        boolean z = false;
        int size = 2000;
        size = 2000;
        if (this.C >= 2000) {
            int r0 = this.C >= this.B.size() ? 1 : 0;
        }
        return (this.C >= this.B.size() ? 1 : 0);
    }

    public static a K(File file, int i, int i2, long j) throws java.io.UnsupportedEncodingException, FileNotFoundException {
        boolean exists3 = false;
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            } else {
                File file3 = new File(file, "journal.bkp");
                if (file3.exists()) {
                    File file4 = new File(file, "journal");
                    if (file4.exists()) {
                        file3.delete();
                    } else {
                        exists3 = false;
                        a.Y(file3, file4, exists3);
                    }
                }
                a aVar = new a(file, i, i2, j, obj2);
                if (aVar.b.exists()) {
                    try {
                        aVar.M();
                        aVar.L();
                        aVar.A = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.b, true), c.a));
                    } catch (java.io.IOException ioException) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str4 = "DiskLruCache ";
                        str4 = " is corrupt: ";
                        Throwable ioException2 = ioException.getMessage();
                        ioException2 = ", removing";
                        ioException2 = str4 + file + str4 + ioException2 + ioException2;
                        System.out.println(ioException2);
                        obj.r();
                    }
                    return aVar;
                }
                file.mkdirs();
                a aVar2 = new a(file, i, i2, j, obj2);
                aVar2 = new a();
                return aVar2;
            }
        }
    }

    private void L() {
        int i2 = 0;
        long l;
        long l2;
        a.w(this.c);
        Iterator it = this.B.values().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            i2 = 0;
        }
    }

    private void M() {
        int i = 0;
        String str3 = ", ";
        final f.e.a.b bVar = new b(new FileInputStream(this.b), c.a);
        try {
            String str = bVar.e();
            String str5 = bVar.e();
            final String str7 = bVar.e();
            final String str8 = bVar.e();
        } catch (java.io.EOFException unused) {
        } finally {
            c.a(closeable);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            final String str11 = "unexpected journal header: [";
            String str4 = "]";
            r0 = str11 + str + str3 + str5 + str3 + str7 + str3 + str8 + str4;
            throw new IOException(r0);
        } catch (java.io.EOFException unused) {
        } finally {
            c.a(closeable);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        }
    }

    private void T(String str) throws IOException {
        String substring;
        int i = 5;
        f.e.a.a.d dVar;
        LinkedHashMap map;
        int i3 = 32;
        int indexOf2 = str.indexOf(i3);
        final String str4 = "unexpected journal line: ";
        final int i5 = -1;
        if (indexOf2 == i5) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str = str4 + str;
            throw new IOException(str);
        } else {
            int i6 = indexOf2 + 1;
            int indexOf = str.indexOf(i3, i6);
            if (indexOf == i5) {
                int i2 = 6;
                if (indexOf2 == 6) {
                    if (str.startsWith("REMOVE")) {
                        this.B.remove(str.substring(i6));
                        return;
                    }
                }
            } else {
                substring = str.substring(i6, indexOf);
            }
            final f.e.a.a.a aVar = null;
            if ((a.d)this.B.get(substring) == null) {
                this.B.put(substring, new a.d(this, substring, aVar));
            }
            i = 5;
            if (indexOf != i5 && indexOf2 == i) {
                if (str.startsWith("CLEAN")) {
                    indexOf2 = 1;
                    str2 = " ";
                    dVar.c = indexOf2;
                    dVar.d = aVar;
                    dVar.n(str.substring(indexOf + indexOf2).split(str2));
                    return;
                } else {
                    if (indexOf == i5 && indexOf2 == i) {
                        if (str.startsWith("DIRTY")) {
                            dVar.d = new a.c(this, dVar, aVar);
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            str = str4 + str;
            throw new IOException(str);
        }
    }

    private synchronized void U() {
        try {
            if (this.A != null) {
                this.A.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), c.a));
        } catch (Throwable th) {
        }
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.w));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.y));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            Iterator it = this.B.values().iterator();
            Object item = it.next();
            char c = '\n';
            Object stringBuilder = new StringBuilder();
            str = "DIRTY ";
            String str9 = item.a;
            obj = str + str9 + c;
            bufferedWriter.write(obj);
            Object stringBuilder2 = new StringBuilder();
            String str11 = "CLEAN ";
            String str = item.a;
            String str10 = item.l();
            obj2 = str11 + str + str10 + c;
            bufferedWriter.write(obj2);
        } catch (Throwable th) {
        }
        try {
            bufferedWriter.close();
            boolean z = true;
            if (this.b.exists()) {
                a.Y(this.b, this.v, z);
            }
        } catch (Throwable th) {
        }
    }

    private static void Y(File file, File file2, boolean z) throws IOException {
        if (z) {
            a.w(file2);
        }
        if (file.renameTo(file2) == null) {
            throw new IOException();
        }
    }

    static /* synthetic */ Writer a(a aVar) {
        return aVar.A;
    }

    static /* synthetic */ void c(a aVar) {
        aVar.e0();
    }

    static /* synthetic */ int e(a aVar) {
        return aVar.y;
    }

    private void e0() {
        while (this.z > this.x) {
            V((String)(Map.Entry)this.B.entrySet().iterator().next().getKey());
        }
    }

    static /* synthetic */ File f(a aVar) {
        return aVar.a;
    }

    private void g0(String str) {
        if (!a.G.matcher(str).matches()) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "keys must match regex [a-z0-9_-]{1,64}: \"";
            String str3 = "\"";
            str = str2 + str + str3;
            throw new IllegalArgumentException(str);
        }
    }

    static /* synthetic */ boolean i(a aVar) {
        return aVar.J();
    }

    static /* synthetic */ OutputStream j() {
        return a.H;
    }

    static /* synthetic */ void k(a aVar, a.c cVar, boolean z) {
        aVar.q(cVar, z);
    }

    static /* synthetic */ void m(a aVar) {
        aVar.U();
    }

    static /* synthetic */ int n(a aVar, int i) {
        aVar.C = i;
        return i;
    }

    private void o() {
        if (this.A == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private synchronized void q(a.c cVar, boolean z) {
        int i = 0;
        boolean exists;
        int i2;
        long length;
        long l;
        File file;
        String str3;
        f.e.a.a.d dVar = cVar.a;
        i = 0;
        cVar.a();
        throw new IllegalStateException();
    }

    private static void w(File file) throws IOException {
    }

    public synchronized a.e F(String str) {
        int i;
        try {
            o();
            g0(str);
            Object value = this.B.get(str);
        } catch (java.io.FileNotFoundException unused) {
        }
        int i2 = 0;
        if (value == null) {
            return null;
        }
        try {
        } catch (java.io.FileNotFoundException unused) {
        }
        if (!value.c) {
            return i2;
        }
        try {
            final InputStream[] arr = new InputStream[this.y];
        } catch (java.io.FileNotFoundException unused) {
        }
        i = 0;
        while (i < this.y) {
            arr[i] = new FileInputStream(value.j(i));
            i = i + 1;
            try {
                arr[i] = new FileInputStream(value.j(i));
            } catch (java.io.FileNotFoundException unused) {
            }
        }
        try {
            this.C++;
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "READ ";
            str2 = str5 + str + 10;
            this.A.append(str2);
            if (J()) {
                this.E.submit(this.F);
            }
        } catch (java.io.FileNotFoundException unused) {
        }
        return eVar;
    }

    public File H() {
        return this.a;
    }

    public synchronized boolean V(String str) {
        int i = 0;
        o();
        g0(str);
        Object value = this.B.get(str);
        i = 0;
        while (i < this.y) {
            File file = value.j(i);
            if (!(!file.exists() || file.delete() != null)) {
                this.z -= l2;
                long l = 0L;
                value.b[i] = l;
                i = i + 1;
                while (i < this.y) {
                    file = value.j(i);
                    if (!file.exists() || file.delete() != null) {
                    }
                }
                int i4 = 1;
                this.C += i4;
                StringBuilder stringBuilder2 = new StringBuilder();
                String str4 = "REMOVE ";
                str3 = str4 + str + 10;
                this.A.append(str3);
                this.B.remove(str);
                if (J()) {
                    this.E.submit(this.F);
                }
                return true;
            } else {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "failed to delete ";
        r0 = str2 + file;
        throw new IOException(r0);
        return false;
    }

    @Override // java.io.Closeable
    public synchronized void close() {
        if (this.A == null) {
            return;
        }
        Iterator it = new ArrayList(this.B.values()).iterator();
        while (it.hasNext()) {
            Collection values = it.next();
            if (values.d != null) {
                values.d.a();
            }
        }
        e0();
        this.A.close();
        this.A = null;
    }

    public void r() {
        close();
        c.b(this.a);
    }

    public a.c x(String str) {
        return E(str, -1L);
    }
}
