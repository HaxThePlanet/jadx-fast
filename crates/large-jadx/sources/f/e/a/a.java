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

/* loaded from: classes2.dex */
public final class a implements Closeable {

    static final Pattern G;
    private static final OutputStream H;
    private Writer A;
    private final LinkedHashMap<String, f.e.a.a.d> B;
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

        final f.e.a.a a;
        a(f.e.a.a a) {
            this.a = a;
            super();
        }

        @Override // java.util.concurrent.Callable
        public Void a() {
            boolean z;
            int i;
            final f.e.a.a aVar = this.a;
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

    static class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    public final class c {

        private final f.e.a.a.d a;
        private final boolean[] b;
        private boolean c;
        final f.e.a.a d;
        private c(f.e.a.a a, f.e.a.a.d a$d2) {
            int obj1;
            this.d = a;
            super();
            this.a = d2;
            if (a.d.e(d2)) {
                obj1 = 0;
            } else {
                obj1 = new boolean[a.e(a)];
            }
            this.b = obj1;
        }

        c(f.e.a.a a, f.e.a.a.d a$d2, f.e.a.a.a a$a3) {
            super(a, d2);
        }

        static f.e.a.a.d b(f.e.a.a.c a$c) {
            return c.a;
        }

        static boolean[] c(f.e.a.a.c a$c) {
            return c.b;
        }

        static boolean d(f.e.a.a.c a$c, boolean z2) {
            c.c = z2;
            return z2;
        }

        public void a() {
            a.k(this.d, this, false);
        }

        public void e() {
            f.e.a.a aVar;
            String str;
            if (this.c) {
                a.k(this.d, this, false);
                this.d.V(a.d.b(this.a));
            } else {
                a.k(this.d, this, true);
            }
        }

        public OutputStream f(int i) {
            boolean z;
            FileOutputStream fileOutputStream;
            int i2;
            final f.e.a.a aVar = this.d;
            synchronized (aVar) {
                if (!a.d.e(this.a)) {
                    this.b[i] = 1;
                }
                try {
                    fileOutputStream = new FileOutputStream(this.a.k(i));
                    f.e.a.a fileOutputStream2 = this.d;
                    fileOutputStream2 = a.f(fileOutputStream2);
                    fileOutputStream2.mkdirs();
                    fileOutputStream2 = new FileOutputStream(i);
                    a.c.a obj4 = new a.c.a(this, fileOutputStream, 0);
                    return obj4;
                    i = a.j();
                    return i;
                    obj4 = new IllegalStateException();
                    throw obj4;
                    throw i;
                } catch (java.io.FileNotFoundException fileNotFound) {
                } catch (Throwable th1) {
                }
            }
        }
    }

    private final class d {

        private final String a;
        private final long[] b;
        private boolean c;
        private f.e.a.a.c d;
        private long e;
        final f.e.a.a f;
        private d(f.e.a.a a, String string2) {
            this.f = a;
            super();
            this.a = string2;
            this.b = new long[a.e(a)];
        }

        d(f.e.a.a a, String string2, f.e.a.a.a a$a3) {
            super(a, string2);
        }

        static long[] a(f.e.a.a.d a$d) {
            return d.b;
        }

        static String b(f.e.a.a.d a$d) {
            return d.a;
        }

        static long c(f.e.a.a.d a$d) {
            return d.e;
        }

        static long d(f.e.a.a.d a$d, long l2) {
            d.e = l2;
            return l2;
        }

        static boolean e(f.e.a.a.d a$d) {
            return d.c;
        }

        static boolean f(f.e.a.a.d a$d, boolean z2) {
            d.c = z2;
            return z2;
        }

        static f.e.a.a.c g(f.e.a.a.d a$d) {
            return d.d;
        }

        static f.e.a.a.c h(f.e.a.a.d a$d, f.e.a.a.c a$c2) {
            d.d = c2;
            return c2;
        }

        static void i(f.e.a.a.d a$d, String[] string2Arr2) {
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
            int i2;
            int i;
            long long;
            if (stringArr.length != a.e(this.f)) {
            } else {
                i2 = 0;
                for (Object obj : stringArr) {
                    this.b[i2] = Long.parseLong(obj);
                }
            }
            m(stringArr);
            throw 0;
        }

        public File j(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".");
            stringBuilder.append(i);
            File file = new File(a.f(this.f), stringBuilder.toString());
            return file;
        }

        public File k(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(".");
            stringBuilder.append(i);
            stringBuilder.append(".tmp");
            File file = new File(a.f(this.f), stringBuilder.toString());
            return file;
        }

        public String l() {
            int i;
            long l;
            int i2;
            StringBuilder stringBuilder = new StringBuilder();
            final long[] lArr = this.b;
            i = 0;
            while (i < lArr.length) {
                stringBuilder.append(' ');
                stringBuilder.append(lArr[i]);
                i++;
            }
            return stringBuilder.toString();
        }
    }

    public final class e implements Closeable {

        private final InputStream[] a;
        private final long[] b;
        private e(f.e.a.a a, String string2, long l3, InputStream[] inputStream4Arr4, long[] l5Arr5) {
            super();
            this.a = l5Arr5;
            this.b = obj6;
        }

        e(f.e.a.a a, String string2, long l3, InputStream[] inputStream4Arr4, long[] l5Arr5, f.e.a.a.a a$a6) {
            super(a, string2, l3, inputStream4Arr4, l5Arr5, a6);
        }

        @Override // java.io.Closeable
        public InputStream a(int i) {
            return this.a[i];
        }

        @Override // java.io.Closeable
        public long c(int i) {
            return this.b[i];
        }

        @Override // java.io.Closeable
        public void close() {
            int i;
            InputStream inputStream;
            final InputStream[] objArr = this.a;
            i = 0;
            while (i < objArr.length) {
                c.a(objArr[i]);
                i++;
            }
        }
    }
    static {
        a.G = Pattern.compile("[a-z0-9_-]{1,64}");
        a.b bVar = new a.b();
        a.H = bVar;
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
        super(0, 1, 60, obj12, TimeUnit.SECONDS, linkedBlockingQueue);
        obj.E = threadPoolExecutor;
        a.a aVar = new a.a(this);
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

    private f.e.a.a.c E(String string, long l2) {
        Object dVar;
        long l;
        int obj7;
        o();
        g0(string);
        dVar = this.B.get(string);
        final int i2 = 0;
        synchronized (this) {
            try {
                if ((a.d)dVar != null) {
                }
                if (Long.compare(l, l2) != 0) {
                }
                return i2;
                if (dVar == null) {
                } else {
                }
                dVar = new a.d(this, string, i2);
                this.B.put(string, dVar);
                if (a.d.g(dVar) != null) {
                }
                return i2;
                obj7 = new a.c(this, dVar, i2);
                a.d.h(dVar, obj7);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("DIRTY ");
                stringBuilder.append(string);
                stringBuilder.append('\n');
                this.A.write(stringBuilder.toString());
                this.A.flush();
                return obj7;
                throw string;
            }
        }
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

    public static f.e.a.a K(File file, int i2, int i3, long l4) {
        boolean exists;
        boolean exists2;
        int exists3;
        f.e.a.a aVar;
        File file2;
        if (Long.compare(l4, i) <= 0) {
        } else {
            if (i3 <= 0) {
            } else {
                File file3 = new File(file, "journal.bkp");
                if (file3.exists() != null) {
                    exists = new File(file, "journal");
                    if (exists.exists()) {
                        file3.delete();
                    } else {
                        a.Y(file3, exists, false);
                    }
                }
                super(file, i2, i3, l4, obj8);
                if (aVar2.b.exists()) {
                    aVar2.M();
                    aVar2.L();
                    FileOutputStream fileOutputStream = new FileOutputStream(aVar2.b, 1);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, c.a);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                    aVar2.A = bufferedWriter;
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
        f.e.a.a.c cVar;
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
        String str;
        String equals2;
        boolean equals;
        String str2 = ", ";
        FileInputStream fileInputStream = new FileInputStream(this.b);
        b bVar = new b(fileInputStream, c.a);
        str = bVar.e();
        String str4 = bVar.e();
        final String str6 = bVar.e();
        final String str7 = bVar.e();
        if (!"libcore.io.DiskLruCache".equals(str)) {
        } else {
            if (!"1".equals(str4)) {
            } else {
                if (!Integer.toString(this.w).equals(bVar.e())) {
                } else {
                    if (!Integer.toString(this.y).equals(str6)) {
                    } else {
                        if (!"".equals(str7)) {
                        } else {
                            i = 0;
                            while (true) {
                                T(bVar.e());
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
        int startsWith;
        int indexOf;
        String substring;
        int startsWith2;
        int startsWith4;
        Object dVar;
        LinkedHashMap startsWith3;
        String[] obj9;
        int i = 32;
        indexOf = string.indexOf(i);
        final String str2 = "unexpected journal line: ";
        final int i3 = -1;
        if (indexOf == i3) {
        } else {
            int i4 = indexOf + 1;
            startsWith = string.indexOf(i, i4);
            if (startsWith == i3) {
                if (indexOf == 6 && string.startsWith("REMOVE")) {
                    if (string.startsWith("REMOVE")) {
                        this.B.remove(string.substring(i4));
                    }
                }
            } else {
                substring = string.substring(i4, startsWith);
            }
            final int i5 = 0;
            if ((a.d)this.B.get(substring) == null) {
                dVar = new a.d(this, substring, i5);
                this.B.put(substring, dVar);
            }
            startsWith2 = 5;
            if (startsWith != i3 && indexOf == startsWith2 && string.startsWith("CLEAN")) {
                if (indexOf == startsWith2) {
                    if (string.startsWith("CLEAN")) {
                        indexOf = 1;
                        a.d.f(dVar, indexOf);
                        a.d.h(dVar, i5);
                        a.d.i(dVar, string.substring(startsWith += indexOf).split(" "));
                    } else {
                        if (startsWith == i3 && indexOf == startsWith2 && string.startsWith("DIRTY")) {
                            if (indexOf == startsWith2) {
                                if (string.startsWith("DIRTY")) {
                                    obj9 = new a.c(this, dVar, i5);
                                    a.d.h(dVar, obj9);
                                } else {
                                    if (startsWith != i3) {
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
        Writer writer = this.A;
        synchronized (this) {
            try {
                writer.close();
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
                bufferedWriter.close();
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
                th.close();
                throw th2;
                throw th;
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

    static Writer a(f.e.a.a a) {
        return a.A;
    }

    static void c(f.e.a.a a) {
        a.e0();
    }

    static int e(f.e.a.a a) {
        return a.y;
    }

    private void e0() {
        while (Long.compare(l, l2) > 0) {
            V((String)(Map.Entry)this.B.entrySet().iterator().next().getKey());
        }
    }

    static File f(f.e.a.a a) {
        return a.a;
    }

    private void g0(String string) {
        if (!a.G.matcher(string).matches()) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("keys must match regex [a-z0-9_-]{1,64}: \"");
        stringBuilder.append(string);
        stringBuilder.append("\"");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    static boolean i(f.e.a.a a) {
        return a.J();
    }

    static OutputStream j() {
        return a.H;
    }

    static void k(f.e.a.a a, f.e.a.a.c a$c2, boolean z3) {
        a.q(c2, z3);
    }

    static void m(f.e.a.a a) {
        a.U();
    }

    static int n(f.e.a.a a, int i2) {
        a.C = i2;
        return i2;
    }

    private void o() {
        if (this.A == null) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("cache is closed");
        throw illegalStateException;
    }

    private void q(f.e.a.a.c a$c, boolean z2) {
        Object dVar;
        int i2;
        String string;
        boolean exists;
        int exists2;
        long length;
        int i;
        f.e.a.a.c obj10;
        long obj11;
        dVar = a.c.b(c);
        synchronized (this) {
            try {
                if (z2 != 0 && !a.d.e(dVar)) {
                }
                if (!a.d.e(dVar)) {
                }
                exists = i2;
                while (exists < this.y) {
                    exists++;
                }
                if (!a.c.c(c)[exists]) {
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
                while (i2 < this.y) {
                    obj10 = dVar.k(i2);
                    if (z2 != 0) {
                    } else {
                    }
                    a.w(obj10);
                    i2++;
                    if (obj10.exists()) {
                    }
                    exists = dVar.j(i2);
                    obj10.renameTo(exists);
                    length = exists.length();
                    a.d.a(dVar)[i2] = length;
                    this.z = i6 += length;
                }
                obj10 = dVar.k(i2);
                if (z2 != 0) {
                } else {
                }
                if (obj10.exists()) {
                }
                exists = dVar.j(i2);
                obj10.renameTo(exists);
                length = exists.length();
                a.d.a(dVar)[i2] = length;
                this.z = i6 += length;
                a.w(obj10);
                i2++;
                int i3 = 1;
                this.C = obj10 += i3;
                a.d.h(dVar, 0);
                int i5 = 10;
                if (obj10 |= z2 != 0) {
                } else {
                }
                a.d.f(dVar, i3);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CLEAN ");
                stringBuilder.append(a.d.b(dVar));
                stringBuilder.append(dVar.l());
                stringBuilder.append(i5);
                this.A.write(stringBuilder.toString());
                if (z2 != 0) {
                }
                obj10 = this.D;
                this.D = i4 += obj10;
                a.d.d(dVar, obj10);
                this.B.remove(a.d.b(dVar));
                obj11 = new StringBuilder();
                obj11.append("REMOVE ");
                obj11.append(a.d.b(dVar));
                obj11.append(i5);
                this.A.write(obj11.toString());
                this.A.flush();
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
    public f.e.a.a.e F(String string) {
        boolean z;
        Object string2;
        int i;
        FileInputStream fileInputStream;
        File file;
        o();
        g0(string);
        Object obj = this.B.get(string);
        int i2 = 0;
        synchronized (this) {
            try {
                return i2;
                if (!a.d.e((a.d)obj)) {
                }
                return i2;
                final InputStream[] arr = new InputStream[this.y];
                i = i6;
                while (i < this.y) {
                    fileInputStream = new FileInputStream(obj.j(i));
                    arr[i] = fileInputStream;
                    i++;
                }
                fileInputStream = new FileInputStream(obj.j(i));
                arr[i] = fileInputStream;
                i++;
                this.C = i3++;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("READ ");
                stringBuilder.append(string);
                stringBuilder.append('\n');
                this.A.append(stringBuilder.toString());
                if (J()) {
                }
                this.E.submit(this.F);
                super(this, string, a.d.c(obj), obj7, arr, a.d.a(obj), 0);
                return eVar;
                string = this.y;
                string = obj8[str];
                if (str < string && string != null) {
                }
                string = obj8[str];
                if (string != null) {
                }
                string = obj8[str];
                c.a(string);
                str++;
                return obj1;
                throw string;
            } catch (java.io.FileNotFoundException fileNotFound) {
            } catch (Throwable th1) {
            }
        }
    }

    @Override // java.io.Closeable
    public File H() {
        return this.a;
    }

    @Override // java.io.Closeable
    public boolean V(String string) {
        Object map;
        int i;
        f.e.a.a.c cVar;
        int i2;
        boolean exists;
        long[] lArr;
        long l;
        boolean obj8;
        o();
        g0(string);
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
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("REMOVE ");
                stringBuilder2.append(string);
                stringBuilder2.append('\n');
                this.A.append(stringBuilder2.toString());
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
        f.e.a.a.c cVar;
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
            this.A.close();
            this.A = 0;
        }
    }

    @Override // java.io.Closeable
    public void r() {
        close();
        c.b(this.a);
    }

    @Override // java.io.Closeable
    public f.e.a.a.c x(String string) {
        return E(string, -1);
    }
}
