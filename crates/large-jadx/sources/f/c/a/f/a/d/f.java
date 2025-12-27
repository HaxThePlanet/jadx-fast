package f.c.a.f.a.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.internal.i1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public final class f {

    private final long a;
    private final Context b;
    private File c;
    public f(Context context) throws android.content.pm.PackageManager.NameNotFoundException {
        super();
        this.b = context;
        this.a = (long)(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
    }

    public static void l(File file) throws IOException {
        int i;
        File file2;
        i = 0;
        if (file.isDirectory() && listFiles != null) {
            length = listFiles.length;
            for (File file2 : listFiles) {
                f.l(file2);
            }
        }
    }

    public static void m(File file) {
        final boolean z = false;
        file.setWritable(z, true);
        file.setWritable(z, z);
    }

    public static boolean p(File file) {
        if (!file.canWrite()) {
            return true;
        }
        return false;
    }

    private static File q(File file, String str) throws IOException {
        final File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath()) == null) {
            throw new IllegalArgumentException("split ID cannot be placed in target directory");
        } else {
            return file2;
        }
    }

    private final File r() {
        final File file = new File(w(), "native-libraries");
        f.u(file);
        return file;
    }

    private final File s(String str) {
        final File file2 = f.q(r(), str);
        f.u(file2);
        return file2;
    }

    private final File t() {
        final File file = new File(w(), "verified-splits");
        f.u(file);
        return file;
    }

    private static File u(File file) throws java.io.UnsupportedEncodingException, IOException {
        String concatenated;
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("File input must be directory when it exists.");
            } else {
                return file;
            }
        }
        file.mkdirs();
        if (!file.isDirectory()) {
            String str3 = String.valueOf(file.getAbsolutePath());
            final String str2 = "Unable to create directory: ";
            if (str3.length() != 0) {
                concatenated = str2.concat(str3);
            } else {
                concatenated = new String(str2);
            }
            IOException iOException = new IOException(concatenated);
            throw iOException;
        }
        return file;
    }

    private final File v() throws IOException {
        if (this.c == null && this.b != null) {
            this.c = this.b.getFilesDir();
        }
        File file = new File(this.c, "splitcompat");
        f.u(file);
        return file;
    }

    private final File w() {
        final File file = new File(v(), Long.toString(this.a));
        f.u(file);
        return file;
    }

    private static String x(String str) {
        return String.valueOf(str).concat(".apk");
    }

    public final File a(String str) {
        final File file = new File(w(), "dex");
        f.u(file);
        final File file3 = f.q(file, str);
        f.u(file3);
        return file3;
    }

    public final File b() {
        final File file = new File(w(), "unverified-splits");
        f.u(file);
        return file;
    }

    public final File c(String str, String str2) {
        return f.q(s(str), str2);
    }

    public final File d() {
        return new File(w(), "lock.tmp");
    }

    public final File e(String str) {
        return f.q(b(), f.x(str));
    }

    public final File f(File file) {
        return f.q(t(), file.getName());
    }

    public final File g(String str) {
        return f.q(t(), f.x(str));
    }

    final List<String> h() {
        int i = 0;
        File file;
        boolean directory;
        final ArrayList arrayList = new ArrayList();
        File[] listFiles = r().listFiles();
        if (listFiles != null) {
            length = listFiles.length;
            i = 0;
            for (File file : listFiles) {
            }
        }
        return arrayList;
    }

    final Set<File> i(String str) {
        int i = 0;
        Object obj;
        boolean file;
        final HashSet hashSet = new HashSet();
        File[] listFiles = s(str).listFiles();
        if (listFiles != null) {
            length = listFiles.length;
            i = 0;
            for (File file2 : listFiles) {
            }
        }
        return hashSet;
    }

    final Set<t> j() {
        int i;
        File file;
        boolean endsWith;
        String str;
        final HashSet hashSet = new HashSet();
        File[] listFiles = t().listFiles();
        if (listFiles != null) {
            length = listFiles.length;
            i = 0;
            for (File file : listFiles) {
            }
        }
        return hashSet;
    }

    public final void k() {
        int i = 0;
        String str;
        boolean equals;
        long l;
        String str2;
        StringBuilder stringBuilder;
        final File file = v();
        final String[] list = file.list();
        if (list != null) {
            length = list.length;
            i = 0;
            for (String str : list) {
            }
        }
    }

    final void n(String str) {
        f.l(s(str));
    }

    final void o(File file) {
        i1.b(file.getParentFile().getParentFile().equals(r()), "File to remove is not a native library");
        f.l(file);
    }
}
