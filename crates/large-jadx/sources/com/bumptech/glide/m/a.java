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

/* loaded from: classes.dex */
public final class a implements Closeable {

    private Writer A;
    private final LinkedHashMap<String, com.bumptech.glide.m.a.d> B;
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

        final com.bumptech.glide.m.a a;
        a(com.bumptech.glide.m.a a) {
            this.a = a;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            boolean z;
            int i;
            final com.bumptech.glide.m.a aVar = this.a;
            final int i2 = 0;
            synchronized (aVar) {
                return i2;
            }
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    private static final class b implements ThreadFactory {
        b(com.bumptech.glide.m.a.a a$a) {
            super();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
            synchronized (this) {
                thread = new Thread(runnable, "glide-disk-lru-cache-thread");
                thread.setPriority(1);
                return thread;
            }
        }
    }

    public final class c {

        private final com.bumptech.glide.m.a.d a;
        private final boolean[] b;
        private boolean c;
        final com.bumptech.glide.m.a d;
        private c(com.bumptech.glide.m.a a, com.bumptech.glide.m.a.d a$d2) {
            int obj1;
            this.d = a;
            super();
            this.a = d2;
            if (a.d.e(d2)) {
                obj1 = 0;
            } else {
                obj1 = new boolean[a.c(a)];
            }
            this.b = obj1;
        }

        c(com.bumptech.glide.m.a a, com.bumptech.glide.m.a.d a$d2, com.bumptech.glide.m.a.a a$a3) {
            super(a, d2);
        }

        static com.bumptech.glide.m.a.d c(com.bumptech.glide.m.a.c a$c) {
            return c.a;
        }

        static boolean[] d(com.bumptech.glide.m.a.c a$c) {
            return c.b;
        }

        public void a() {
            a.i(this.d, this, false);
        }

        public void b() {
            if (!this.c) {
                a();
            }
        }

        public void e() {
            final int i = 1;
            a.i(this.d, this, i);
            this.c = i;
        }

        public File f(int i) {
            boolean z;
            int i2;
            final com.bumptech.glide.m.a aVar = this.d;
            synchronized (aVar) {
                if (!a.d.e(this.a)) {
                    this.b[i] = 1;
                }
                try {
                    a.f(this.d).mkdirs();
                    return this.a.k(i);
                    IllegalStateException obj4 = new IllegalStateException();
                    throw obj4;
                    throw i;
                }
            }
        }
    }

    private final class d {

        private final String a;
        private final long[] b;
        File[] c;
        File[] d;
        private boolean e;
        private com.bumptech.glide.m.a.c f;
        private long g;
        final com.bumptech.glide.m.a h;
        private d(com.bumptech.glide.m.a a, String string2) {
            int i;
            File[] objArr;
            File file2;
            File file;
            String string;
            this.h = a;
            super();
            this.a = string2;
            this.b = new long[a.c(a)];
            this.c = new File[a.c(a)];
            this.d = new File[a.c(a)];
            StringBuilder stringBuilder = new StringBuilder(string2);
            stringBuilder.append('.');
            i = 0;
            while (i < a.c(a)) {
                stringBuilder.append(i);
                File file3 = new File(a.f(a), stringBuilder.toString());
                this.c[i] = file3;
                stringBuilder.append(".tmp");
                file2 = new File(a.f(a), stringBuilder.toString());
                this.d[i] = file2;
                stringBuilder.setLength(stringBuilder.length());
                i++;
            }
        }

        d(com.bumptech.glide.m.a a, String string2, com.bumptech.glide.m.a.a a$a3) {
            super(a, string2);
        }

        static long[] a(com.bumptech.glide.m.a.d a$d) {
            return d.b;
        }

        static String b(com.bumptech.glide.m.a.d a$d) {
            return d.a;
        }

        static long c(com.bumptech.glide.m.a.d a$d) {
            return d.g;
        }

        static long d(com.bumptech.glide.m.a.d a$d, long l2) {
            d.g = l2;
            return l2;
        }

        static boolean e(com.bumptech.glide.m.a.d a$d) {
            return d.e;
        }

        static boolean f(com.bumptech.glide.m.a.d a$d, boolean z2) {
            d.e = z2;
            return z2;
        }

        static com.bumptech.glide.m.a.c g(com.bumptech.glide.m.a.d a$d) {
            return d.f;
        }

        static com.bumptech.glide.m.a.c h(com.bumptech.glide.m.a.d a$d, com.bumptech.glide.m.a.c a$c2) {
            d.f = c2;
            return c2;
        }

        static void i(com.bumptech.glide.m.a.d a$d, String[] string2Arr2) {
            d.n(string2Arr2);
        }

        private IOException m(String[] stringArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(Arrays.toString(stringArr));
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }

        private void n(String[] stringArr) {
            int i;
            int i2;
            long long;
            if (stringArr.length != a.c(this.h)) {
            } else {
                i = 0;
                for (Object obj : stringArr) {
                    this.b[i] = Long.parseLong(obj);
                }
            }
            m(stringArr);
            throw 0;
        }

        public File j(int i) {
            return this.c[i];
        }

        public File k(int i) {
            return this.d[i];
        }

        public String l() {
            int i2;
            long l;
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            final long[] lArr = this.b;
            i2 = 0;
            while (i2 < lArr.length) {
                stringBuilder.append(' ');
                stringBuilder.append(lArr[i2]);
                i2++;
            }
            return stringBuilder.toString();
        }
    }

    public final class e {

        private final File[] a;
        private e(com.bumptech.glide.m.a a, String string2, long l3, File[] file4Arr4, long[] l5Arr5) {
            super();
            this.a = l5Arr5;
        }

        e(com.bumptech.glide.m.a a, String string2, long l3, File[] file4Arr4, long[] l5Arr5, com.bumptech.glide.m.a.a a$a6) {
            super(a, string2, l3, file4Arr4, l5Arr5, a6);
        }

        public File a(int i) {
            return this.a[i];
        }
    }
    private a(File file, int i2, int i3, long l4) {
        final Object obj = this;
        File file2 = file;
        super();
        int i4 = 0;
        obj.z = i4;
        LinkedHashMap linkedHashMap = new LinkedHashMap(0, 1061158912, 1);
        obj.B = linkedHashMap;
        obj.D = i4;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        a.b bVar = new a.b(0);
        super(0, 1, 60, obj12, TimeUnit.SECONDS, linkedBlockingQueue, bVar);
        obj.E = threadPoolExecutor;
        a.a aVar = new a.a(obj);
        obj.F = aVar;
        obj.a = file2;
        obj.w = i2;
        File file3 = new File(file2, "journal");
        obj.b = file3;
        File file4 = new File(file2, "journal.tmp");
        obj.c = file4;
        File file5 = new File(file2, "journal.bkp");
        obj.v = file5;
        obj.y = i3;
        obj.x = l4;
    }

    private com.bumptech.glide.m.a.c E(String string, long l2) {
        Object dVar;
        long l;
        int obj7;
        n();
        dVar = this.B.get(string);
        final int i3 = 0;
        synchronized (this) {
            try {
                if ((a.d)dVar != null) {
                }
                if (Long.compare(l, l2) != 0) {
                }
                return i3;
                if (dVar == null) {
                } else {
                }
                dVar = new a.d(this, string, i3);
                this.B.put(string, dVar);
                if (a.d.g(dVar) != null) {
                }
                return i3;
                obj7 = new a.c(this, dVar, i3);
                a.d.h(dVar, obj7);
                this.A.append("DIRTY");
                this.A.append(' ');
                this.A.append(string);
                this.A.append('\n');
                a.F(this.A);
                return obj7;
                throw string;
            }
        }
    }

    private static void F(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
        }
        android.os.StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
        StrictMode.setThreadPolicy(builder.permitUnbufferedIo().build());
        writer.flush();
        StrictMode.setThreadPolicy(threadPolicy);
    }

    private boolean J() {
        int i;
        int size;
        int i2 = this.C;
        if (i2 >= 2000 && i2 >= this.B.size()) {
            i = i2 >= this.B.size() ? 1 : 0;
        } else {
        }
        return i;
    }

    public static com.bumptech.glide.m.a K(File file, int i2, int i3, long l4) {
        boolean exists2;
        boolean exists;
        int exists3;
        com.bumptech.glide.m.a aVar;
        File file2;
        if (Long.compare(l4, i) <= 0) {
        } else {
            if (i3 <= 0) {
            } else {
                File file3 = new File(file, "journal.bkp");
                if (file3.exists() != null) {
                    exists2 = new File(file, "journal");
                    if (exists2.exists()) {
                        file3.delete();
                    } else {
                        a.Y(file3, exists2, false);
                    }
                }
                super(file, i2, i3, l4, obj8);
                if (aVar2.b.exists()) {
                    aVar2.M();
                    aVar2.L();
                    return aVar2;
                }
                file.mkdirs();
                super(file, i2, i3, l4, obj8);
                aVar3.U();
                return aVar3;
            }
            IllegalArgumentException obj9 = new IllegalArgumentException("valueCount <= 0");
            throw obj9;
        }
        obj9 = new IllegalArgumentException("maxSize <= 0");
        throw obj9;
    }

    private void L() {
        Object next;
        int i4;
        com.bumptech.glide.m.a.c cVar;
        int i;
        int i2;
        int i3;
        long l;
        a.w(this.c);
        Iterator iterator = this.B.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            i2 = 0;
            if (a.d.g((a.d)next) == null) {
            } else {
            }
            a.d.h(next, 0);
            while (i2 < this.y) {
                a.w(next.j(i2));
                a.w(next.k(i2));
                i2++;
            }
            iterator.remove();
            a.w(next.j(i2));
            a.w(next.k(i2));
            i2++;
            while (i2 < this.y) {
                this.z = l2 += l;
                i2++;
            }
            this.z = l2 += l;
            i2++;
        }
    }

    private void M() {
        int i;
        LinkedHashMap outputStreamWriter;
        String str;
        FileOutputStream fileOutputStream;
        File file;
        String equals2;
        int i2;
        boolean equals;
        String str2 = ", ";
        FileInputStream fileInputStream = new FileInputStream(this.b);
        b bVar = new b(fileInputStream, c.a);
        str = bVar.f();
        String str4 = bVar.f();
        final String str6 = bVar.f();
        final String str7 = bVar.f();
        if (!"libcore.io.DiskLruCache".equals(str)) {
        } else {
            if (!"1".equals(str4)) {
            } else {
                if (!Integer.toString(this.w).equals(bVar.f())) {
                } else {
                    if (!Integer.toString(this.y).equals(str6)) {
                    } else {
                        if (!"".equals(str7)) {
                        } else {
                            i = 0;
                            while (true) {
                                T(bVar.f());
                                i++;
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected journal header: [");
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append(str4);
        stringBuilder.append(str2);
        stringBuilder.append(str6);
        stringBuilder.append(str2);
        stringBuilder.append(str7);
        stringBuilder.append("]");
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    private void T(String string) {
        int startsWith4;
        int indexOf;
        String substring;
        int startsWith2;
        int startsWith3;
        Object dVar;
        LinkedHashMap startsWith;
        String[] obj9;
        int i = 32;
        indexOf = string.indexOf(i);
        final String str2 = "unexpected journal line: ";
        final int i3 = -1;
        if (indexOf == i3) {
        } else {
            int i4 = indexOf + 1;
            startsWith4 = string.indexOf(i, i4);
            if (startsWith4 == i3) {
                if (indexOf == 6 && string.startsWith("REMOVE")) {
                    if (string.startsWith("REMOVE")) {
                        this.B.remove(string.substring(i4));
                    }
                }
            } else {
                substring = string.substring(i4, startsWith4);
            }
            final int i5 = 0;
            if ((a.d)this.B.get(substring) == null) {
                dVar = new a.d(this, substring, i5);
                this.B.put(substring, dVar);
            }
            startsWith2 = 5;
            if (startsWith4 != i3 && indexOf == startsWith2 && string.startsWith("CLEAN")) {
                if (indexOf == startsWith2) {
                    if (string.startsWith("CLEAN")) {
                        indexOf = 1;
                        a.d.f(dVar, indexOf);
                        a.d.h(dVar, i5);
                        a.d.i(dVar, string.substring(startsWith4 += indexOf).split(" "));
                    } else {
                        if (startsWith4 == i3 && indexOf == startsWith2 && string.startsWith("DIRTY")) {
                            if (indexOf == startsWith2) {
                                if (string.startsWith("DIRTY")) {
                                    obj9 = new a.c(this, dVar, i5);
                                    a.d.h(dVar, obj9);
                                } else {
                                    if (startsWith4 != i3) {
                                    } else {
                                        if (indexOf != 4) {
                                        } else {
                                            if (!string.startsWith("READ")) {
                                            } else {
                                            }
                                        }
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(string);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(string);
        IOException iOException2 = new IOException(stringBuilder2.toString());
        throw iOException2;
    }

    private void U() {
        boolean exists;
        FileOutputStream fileOutputStream;
        boolean next;
        java.nio.charset.Charset stringBuilder;
        int i;
        String str;
        Writer writer2 = this.A;
        synchronized (this) {
            try {
                a.o(writer2);
                fileOutputStream = new FileOutputStream(this.c);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, c.a);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.w));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.y));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                Iterator iterator = this.B.values().iterator();
                while (iterator.hasNext()) {
                    Object next2 = iterator.next();
                    i = 10;
                    if (a.d.g((a.d)next2) != null) {
                    } else {
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("CLEAN ");
                    stringBuilder.append(a.d.b(next2));
                    stringBuilder.append(next2.l());
                    stringBuilder.append(i);
                    bufferedWriter.write(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("DIRTY ");
                    stringBuilder.append(a.d.b(next2));
                    stringBuilder.append(i);
                    bufferedWriter.write(stringBuilder.toString());
                }
                next2 = iterator.next();
                i = 10;
                if (a.d.g((a.d)next2) != null) {
                } else {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("DIRTY ");
                stringBuilder.append(a.d.b(next2));
                stringBuilder.append(i);
                bufferedWriter.write(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append("CLEAN ");
                stringBuilder.append(a.d.b(next2));
                stringBuilder.append(next2.l());
                stringBuilder.append(i);
                bufferedWriter.write(stringBuilder.toString());
                a.o(bufferedWriter);
                int i4 = 1;
                if (this.b.exists()) {
                }
                a.Y(this.b, this.v, i4);
                a.Y(this.c, this.b, false);
                this.v.delete();
                FileOutputStream fileOutputStream2 = new FileOutputStream(this.b, i4);
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(fileOutputStream2, c.a);
                BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter2);
                this.A = bufferedWriter2;
                a.o(writer);
                throw th;
                throw writer;
            } catch (Throwable th) {
            }
        }
    }

    private static void Y(File file, File file2, boolean z3) {
        if (z3) {
            a.w(file2);
        }
        if (file.renameTo(file2) == null) {
        } else {
        }
        IOException obj0 = new IOException();
        throw obj0;
    }

    static Writer a(com.bumptech.glide.m.a a) {
        return a.A;
    }

    static int c(com.bumptech.glide.m.a a) {
        return a.y;
    }

    static void e(com.bumptech.glide.m.a a) {
        a.e0();
    }

    private void e0() {
        while (Long.compare(l, l2) > 0) {
            V((String)(Map.Entry)this.B.entrySet().iterator().next().getKey());
        }
    }

    static File f(com.bumptech.glide.m.a a) {
        return a.a;
    }

    static void i(com.bumptech.glide.m.a a, com.bumptech.glide.m.a.c a$c2, boolean z3) {
        a.q(c2, z3);
    }

    static boolean j(com.bumptech.glide.m.a a) {
        return a.J();
    }

    static void k(com.bumptech.glide.m.a a) {
        a.U();
    }

    static int m(com.bumptech.glide.m.a a, int i2) {
        a.C = i2;
        return i2;
    }

    private void n() {
        if (this.A == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("cache is closed");
        throw illegalStateException;
    }

    private static void o(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
        }
        android.os.StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
        StrictMode.setThreadPolicy(builder.permitUnbufferedIo().build());
        writer.close();
        StrictMode.setThreadPolicy(threadPolicy);
    }

    private void q(com.bumptech.glide.m.a.c a$c, boolean z2) {
        int i;
        String i2;
        boolean exists;
        int exists2;
        long length;
        int i3;
        com.bumptech.glide.m.a.c obj10;
        long obj11;
        com.bumptech.glide.m.a.d dVar = a.c.c(c);
        synchronized (this) {
            try {
                if (z2 != 0 && !a.d.e(dVar)) {
                }
                if (!a.d.e(dVar)) {
                }
                exists = i;
                while (exists < this.y) {
                    exists++;
                }
                if (!a.c.d(c)[exists]) {
                } else {
                }
                if (!dVar.k(exists).exists()) {
                } else {
                }
                c.a();
                exists++;
                c.a();
                obj11 = new StringBuilder();
                obj11.append("Newly created entry didn't create value for index ");
                obj11.append(exists);
                obj10 = new IllegalStateException(obj11.toString());
                throw obj10;
                while (i < this.y) {
                    obj10 = dVar.k(i);
                    if (z2 != 0) {
                    } else {
                    }
                    a.w(obj10);
                    i++;
                    if (obj10.exists()) {
                    }
                    exists = dVar.j(i);
                    obj10.renameTo(exists);
                    length = exists.length();
                    a.d.a(dVar)[i] = length;
                    this.z = i7 += length;
                }
                obj10 = dVar.k(i);
                if (z2 != 0) {
                } else {
                }
                if (obj10.exists()) {
                }
                exists = dVar.j(i);
                obj10.renameTo(exists);
                length = exists.length();
                a.d.a(dVar)[i] = length;
                this.z = i7 += length;
                a.w(obj10);
                i++;
                i2 = 1;
                this.C = obj10 += i2;
                a.d.h(dVar, 0);
                int i5 = 10;
                int i6 = 32;
                if (obj10 |= z2 != 0) {
                } else {
                }
                a.d.f(dVar, i2);
                this.A.append("CLEAN");
                this.A.append(i6);
                this.A.append(a.d.b(dVar));
                this.A.append(dVar.l());
                this.A.append(i5);
                if (z2 != 0) {
                }
                obj10 = this.D;
                this.D = i4 += obj10;
                a.d.d(dVar, obj10);
                this.B.remove(a.d.b(dVar));
                this.A.append("REMOVE");
                this.A.append(i6);
                this.A.append(a.d.b(dVar));
                this.A.append(i5);
                a.F(this.A);
                if (Long.compare(obj10, l) <= 0) {
                } else {
                }
                if (J()) {
                }
                this.E.submit(this.F);
                obj10 = new IllegalStateException();
                throw obj10;
                throw c;
            }
        }
    }

    private static void w(File file) {
        boolean obj1;
        if (file.exists() != null) {
            if (file.delete() == null) {
            } else {
            }
            obj1 = new IOException();
            throw obj1;
        }
    }

    @Override // java.io.Closeable
    public com.bumptech.glide.m.a.e H(String string) {
        boolean z;
        int i;
        int i2;
        boolean exists;
        n();
        Object obj = this.B.get(string);
        int i3 = 0;
        synchronized (this) {
            try {
                return i3;
                if (!a.d.e((a.d)obj)) {
                }
                return i3;
                File[] objArr = obj.c;
                i2 = 0;
                while (i2 < objArr.length) {
                    i2++;
                }
                if (!objArr[i2].exists()) {
                } else {
                }
                return i3;
                i2++;
                this.C = i4++;
                this.A.append("READ");
                this.A.append(' ');
                this.A.append(string);
                this.A.append('\n');
                if (J()) {
                }
                this.E.submit(this.F);
                super(this, string, a.d.c(obj), i2, obj.c, a.d.a(obj), 0);
                return eVar2;
            }
        }
    }

    @Override // java.io.Closeable
    public boolean V(String string) {
        Object map;
        int i;
        com.bumptech.glide.m.a.c cVar;
        int i2;
        boolean exists;
        long[] lArr;
        long l;
        boolean obj8;
        n();
        Object obj = this.B.get(string);
        synchronized (this) {
            try {
                if (a.d.g((a.d)obj) != null) {
                }
                while (i < this.y) {
                    File file = obj.j(i);
                    this.z = l2 -= l;
                    a.d.a(obj)[i] = 0;
                    i++;
                }
                file = obj.j(i);
                if (file.exists() != null) {
                } else {
                }
                if (file.delete() == null) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to delete ");
                stringBuilder.append(file);
                obj8 = new IOException(stringBuilder.toString());
                throw obj8;
                this.z = l2 -= l;
                a.d.a(obj)[i] = 0;
                i++;
                int i5 = 1;
                this.C = i3 += i5;
                this.A.append("REMOVE");
                this.A.append(' ');
                this.A.append(string);
                this.A.append('\n');
                this.B.remove(string);
                if (J()) {
                }
                this.E.submit(this.F);
                return i5;
                return 0;
                throw string;
            }
        }
    }

    @Override // java.io.Closeable
    public void close() {
        Collection values;
        com.bumptech.glide.m.a.c cVar;
        synchronized (this) {
            try {
                ArrayList arrayList = new ArrayList(this.B.values());
                Iterator iterator = arrayList.iterator();
            }
            while (iterator.hasNext()) {
                values = iterator.next();
                if (a.d.g((a.d)values) != null) {
                }
                a.d.g(values).a();
            }
            e0();
            a.o(this.A);
            this.A = 0;
        }
    }

    @Override // java.io.Closeable
    public void r() {
        close();
        c.b(this.a);
    }

    @Override // java.io.Closeable
    public com.bumptech.glide.m.a.c x(String string) {
        return E(string, -1);
    }
}
