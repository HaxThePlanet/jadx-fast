package com.bumptech.glide.m;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

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

    private static final class b implements ThreadFactory {
        private b() {
            super();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            final Thread thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(a.a aVar) {
            this();
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

        static /* synthetic */ a.d c(a.c cVar) {
            return cVar.a;
        }

        static /* synthetic */ boolean[] d(a.c cVar) {
            return cVar.b;
        }

        public void a() {
            this.d.q(this, 0);
        }

        public void b() {
            if (!this.c) {
                try {
                    a();
                } catch (java.io.IOException unused) {
                    return;
                }
            }
        }

        public void e() {
            final boolean z = true;
            this.d.q(this, z);
            this.c = z;
        }

        public File f(int i) {
            synchronized (aVar) {
                try {
                    if (this.a.f != this) {
                        throw new IllegalStateException();
                    } else {
                        if (!this.a.e) {
                            boolean z2 = true;
                            this.b[i] = z2;
                        }
                        this.d.a.mkdirs();
                        return this.a.k(i);
                    }
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        private c(a.d dVar) {
            int i = 0;
            this.d = aVar;
            super();
            this.a = dVar;
            i = dVar.e ? 0 : new boolean[i2];
            this.b = i;
        }
    }

    private final class d {

        private final String a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private a.c f;
        private long g;
        final /* synthetic */ a h;
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
            return dVar.g;
        }

        static /* synthetic */ long d(a.d dVar, long j) {
            dVar.g = j;
            return j;
        }

        static /* synthetic */ boolean e(a.d dVar) {
            return dVar.e;
        }

        static /* synthetic */ boolean f(a.d dVar, boolean z) {
            dVar.e = z;
            return z;
        }

        static /* synthetic */ a.c g(a.d dVar) {
            return dVar.f;
        }

        static /* synthetic */ a.c h(a.d dVar, a.c cVar) {
            dVar.f = cVar;
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
            if (strArr.length != this.h.y) {
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
            return this.c[i];
        }

        public File k(int i) {
            return this.d[i];
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
            int i = 0;
            this.h = aVar;
            super();
            this.a = str;
            this.b = new long[aVar.y];
            this.c = new File[aVar.y];
            this.d = new File[aVar.y];
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append('.');
            i = 0;
            while (i < aVar.y) {
                stringBuilder.append(i);
                this.c[i] = new File(aVar.a, stringBuilder.toString());
                stringBuilder.append(".tmp");
                this.d[i] = new File(aVar.a, stringBuilder.toString());
                stringBuilder.setLength(stringBuilder.length());
                i = i + 1;
            }
        }
    }

    public final class e {

        private final File[] a;
        /* synthetic */ e(String str, long j, File[] fileArr, long[] jArr, a.a aVar) {
            this(aVar, str, j, r4, fileArr, jArr);
        }

        public File a(int i) {
            return this.a[i];
        }

        private e(String str, long j, File[] fileArr, long[] jArr) {
            super();
            this.a = fileArr;
        }
    }
    private a(File file, int i, int i2, long j) {
        final Object file3 = this;
        File file2 = file;
        super();
        long l = 0L;
        file3.z = l;
        file3.B = new LinkedHashMap(0, 0.75f, true);
        file3.D = l;
        super(0, 1, 60L, timeUnit, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a.b(null));
        file3.E = threadPoolExecutor;
        file3.F = new a.a(file3);
        file3.a = file2;
        file3.w = i;
        file3.b = new File(file2, "journal");
        file3.c = new File(file2, "journal.tmp");
        file3.v = new File(file2, "journal.bkp");
        file3.y = i2;
        file3.x = j;
    }

    private synchronized a.c E(String str, long j) {
        com.bumptech.glide.m.a.d dVar;
        n();
        Object value = this.B.get(str);
        final com.bumptech.glide.m.a.a aVar = null;
        long l = value.g;
        if (value == null) {
            this.B.put(str, new a.d(this, str, aVar));
        }
        com.bumptech.glide.m.a.c cVar = new a.c(this, dVar, aVar);
        dVar.f = cVar;
        this.A.append("DIRTY");
        this.A.append(' ');
        this.A.append(str);
        this.A.append('\n');
        a.F(this.A);
        return cVar;
    }

    private static void F(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        android.os.StrictMode.ThreadPolicy threadPolicy2 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy2).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
            throw writer;
        }
        StrictMode.setThreadPolicy(threadPolicy2);
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

    public static a K(File file, int i, int i2, long j) {
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
        LinkedHashMap outputStreamWriter;
        FileOutputStream fileOutputStream;
        File file2;
        String str3 = ", ";
        final com.bumptech.glide.m.b bVar = new b(new FileInputStream(this.b), c.a);
        try {
            String str = bVar.f();
            String str5 = bVar.f();
            final String str7 = bVar.f();
            final String str8 = bVar.f();
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
        com.bumptech.glide.m.a.d dVar;
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
            final com.bumptech.glide.m.a.a aVar = null;
            if ((a.d)this.B.get(substring) == null) {
                this.B.put(substring, new a.d(this, substring, aVar));
            }
            i = 5;
            if (indexOf != i5 && indexOf2 == i) {
                if (str.startsWith("CLEAN")) {
                    indexOf2 = 1;
                    str2 = " ";
                    dVar.e = indexOf2;
                    dVar.f = aVar;
                    dVar.n(str.substring(indexOf + indexOf2).split(str2));
                    return;
                } else {
                    if (indexOf == i5 && indexOf2 == i) {
                        if (str.startsWith("DIRTY")) {
                            dVar.f = new a.c(this, dVar, aVar);
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
                a.o(this.A);
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
            a.o(bufferedWriter);
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

    static /* synthetic */ int c(a aVar) {
        return aVar.y;
    }

    static /* synthetic */ void e(a aVar) {
        aVar.e0();
    }

    private void e0() {
        while (this.z > this.x) {
            V((String)(Map.Entry)this.B.entrySet().iterator().next().getKey());
        }
    }

    static /* synthetic */ File f(a aVar) {
        return aVar.a;
    }

    static /* synthetic */ void i(a aVar, a.c cVar, boolean z) {
        aVar.q(cVar, z);
    }

    static /* synthetic */ boolean j(a aVar) {
        return aVar.J();
    }

    static /* synthetic */ void k(a aVar) {
        aVar.U();
    }

    static /* synthetic */ int m(a aVar, int i) {
        aVar.C = i;
        return i;
    }

    private void n() {
        if (this.A == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void o(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        android.os.StrictMode.ThreadPolicy threadPolicy2 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy2).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
            throw writer;
        }
        StrictMode.setThreadPolicy(threadPolicy2);
    }

    private synchronized void q(a.c cVar, boolean z) {
        int i = 0;
        boolean exists;
        int i3;
        long length;
        long l;
        File file;
        String str;
        com.bumptech.glide.m.a.d dVar = cVar.a;
        i = 0;
        cVar.a();
        throw new IllegalStateException();
    }

    private static void w(File file) throws IOException {
    }

    public synchronized a.e H(String str) {
        int i = 0;
        n();
        Object value = this.B.get(str);
        int i2 = 0;
        if (value == null) {
            return null;
        }
        if (!value.e) {
            return i2;
        }
        i = 0;
        this.C++;
        this.A.append("READ");
        this.A.append(' ');
        this.A.append(str);
        char c = '\n';
        this.A.append(c);
        if (J()) {
            this.E.submit(this.F);
        }
        return eVar;
    }

    public synchronized boolean V(String str) {
        int i = 0;
        n();
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
                this.A.append("REMOVE");
                this.A.append(' ');
                this.A.append(str);
                this.A.append('\n');
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
            if (values.f != null) {
                values.f.a();
            }
        }
        e0();
        a.o(this.A);
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
