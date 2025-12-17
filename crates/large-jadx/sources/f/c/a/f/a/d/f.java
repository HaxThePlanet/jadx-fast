package f.c.a.f.a.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.internal.i1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class f {

    private final long a;
    private final Context b;
    private File c;
    public f(Context context) {
        super();
        this.b = context;
        this.a = (long)obj3;
    }

    public static void l(File file) {
        boolean listFiles;
        boolean exists;
        int length;
        int i;
        File file2;
        final int i2 = 0;
        listFiles = file.listFiles();
        if (file.isDirectory() != null && listFiles != null) {
            listFiles = file.listFiles();
            if (listFiles != null) {
                i = i2;
                while (i < listFiles.length) {
                    f.l(listFiles[i]);
                    i++;
                }
            }
        }
        if (file.exists() != null) {
            if (file.delete() == null) {
            } else {
            }
            Object[] arr = new Object[1];
            arr[i2] = file.getAbsolutePath();
            IOException iOException = new IOException(String.format("Failed to delete '%s'", arr));
            throw iOException;
        }
    }

    public static void m(File file) {
        final int i = 0;
        file.setWritable(i, true);
        file.setWritable(i, i);
    }

    public static boolean p(File file) {
        if (file.canWrite() == null) {
            return 1;
        }
        return 0;
    }

    private static File q(File file, String string2) {
        File file2 = new File(file, string2);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath()) == null) {
        } else {
            return file2;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("split ID cannot be placed in target directory");
        throw obj1;
    }

    private final File r() {
        File file = new File(w(), "native-libraries");
        f.u(file);
        return file;
    }

    private final File s(String string) {
        final File obj2 = f.q(r(), string);
        f.u(obj2);
        return obj2;
    }

    private final File t() {
        File file = new File(w(), "verified-splits");
        f.u(file);
        return file;
    }

    private static File u(File file) {
        String obj3;
        if (file.exists() != null) {
            if (file.isDirectory() == null) {
            } else {
                return file;
            }
            obj3 = new IllegalArgumentException("File input must be directory when it exists.");
            throw obj3;
        }
        file.mkdirs();
        if (file.isDirectory() == null) {
            obj3 = String.valueOf(file.getAbsolutePath());
            final String str2 = "Unable to create directory: ";
            if (obj3.length() != 0) {
                obj3 = str2.concat(obj3);
            } else {
                obj3 = new String(str2);
            }
            IOException iOException = new IOException(obj3);
            throw iOException;
        }
        return file;
    }

    private final File v() {
        File filesDir;
        if (this.c == null) {
            Context context = this.b;
            if (context == null) {
            } else {
                this.c = context.getFilesDir();
            }
            IllegalStateException illegalStateException = new IllegalStateException("context must be non-null to populate null filesDir");
            throw illegalStateException;
        }
        File file = new File(this.c, "splitcompat");
        f.u(file);
        return file;
    }

    private final File w() {
        File file = new File(v(), Long.toString(this.a));
        f.u(file);
        return file;
    }

    private static String x(String string) {
        return String.valueOf(string).concat(".apk");
    }

    public final File a(String string) {
        File file = new File(w(), "dex");
        f.u(file);
        final File obj4 = f.q(file, string);
        f.u(obj4);
        return obj4;
    }

    public final File b() {
        File file = new File(w(), "unverified-splits");
        f.u(file);
        return file;
    }

    public final File c(String string, String string2) {
        return f.q(s(string), string2);
    }

    public final File d() {
        File file = new File(w(), "lock.tmp");
        return file;
    }

    public final File e(String string) {
        return f.q(b(), f.x(string));
    }

    public final File f(File file) {
        return f.q(t(), file.getName());
    }

    public final File g(String string) {
        return f.q(t(), f.x(string));
    }

    final List<String> h() {
        int length;
        int i;
        File name;
        boolean directory;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = r().listFiles();
        if (listFiles != null) {
            i = 0;
            while (i < listFiles.length) {
                name = listFiles[i];
                if (name.isDirectory() != null) {
                }
                i++;
                arrayList.add(name.getName());
            }
        }
        return arrayList;
    }

    final Set<File> i(String string) {
        int length;
        int i;
        File file;
        boolean file2;
        HashSet hashSet = new HashSet();
        File[] obj6 = s(string).listFiles();
        if (obj6 != null) {
            i = 0;
            while (i < obj6.length) {
                file = obj6[i];
                if (file.isFile() != null) {
                }
                i++;
                hashSet.add(file);
            }
        }
        return hashSet;
    }

    final Set<f.c.a.f.a.d.t> j() {
        int length;
        int i2;
        int i;
        File file;
        boolean endsWith;
        String cVar;
        HashSet hashSet = new HashSet();
        File[] listFiles = t().listFiles();
        if (listFiles != null) {
            i2 = 0;
            i = i2;
            while (i < listFiles.length) {
                file = listFiles[i];
                if (file.isFile() != null && file.getName().endsWith(".apk") != null && f.p(file) != null) {
                }
                i++;
                if (file.getName().endsWith(".apk") != null) {
                }
                if (f.p(file) != null) {
                }
                String name2 = file.getName();
                cVar = new c(file, name2.substring(i2, length2 += -4));
                hashSet.add(cVar);
            }
        }
        return hashSet;
    }

    public final void k() {
        int length;
        int i;
        String string;
        boolean equals;
        long str2;
        String str;
        StringBuilder stringBuilder;
        final File file = v();
        final String[] list = file.list();
        if (list != null) {
            i = 0;
            while (i < list.length) {
                string = list[i];
                if (!string.equals(Long.toString(this.a))) {
                }
                i++;
                equals = new File(file, string);
                String valueOf = String.valueOf(equals);
                stringBuilder = new StringBuilder(length2 += 118);
                stringBuilder.append("FileStorage: removing directory for different version code (directory = ");
                stringBuilder.append(valueOf);
                stringBuilder.append(", current version code = ");
                stringBuilder.append(this.a);
                stringBuilder.append(")");
                Log.d("SplitCompat", stringBuilder.toString());
                f.l(equals);
            }
        }
    }

    final void n(String string) {
        f.l(s(string));
    }

    final void o(File file) {
        i1.b(file.getParentFile().getParentFile().equals(r()), "File to remove is not a native library");
        f.l(file);
    }
}
