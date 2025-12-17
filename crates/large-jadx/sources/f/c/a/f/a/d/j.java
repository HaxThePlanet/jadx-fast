package f.c.a.f.a.d;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
final class j implements f.c.a.f.a.d.l {

    final Set a;
    final f.c.a.f.a.d.t b;
    final ZipFile c;
    j(f.c.a.f.a.d.n n, Set set2, f.c.a.f.a.d.t t3, ZipFile zipFile4) {
        this.a = set2;
        this.b = t3;
        this.c = zipFile4;
        super();
    }

    @Override // f.c.a.f.a.d.l
    public final void a(f.c.a.f.a.d.m m, File file2, boolean z3) {
        Set bArr;
        int i;
        boolean exists;
        Object obj4;
        Object obj5;
        FileOutputStream obj6;
        this.a.add(file2);
        obj6 = new Object[5];
        i = 0;
        obj6[i] = this.b.b();
        obj6[1] = m.a;
        obj6[2] = this.b.a().getAbsolutePath();
        obj6[3] = m.b.getName();
        obj6[4] = file2.getAbsolutePath();
        Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", obj6));
        bArr = new byte[4096];
        if (z3 == null && file2.exists() != null) {
            obj6 = new Object[5];
            i = 0;
            obj6[i] = this.b.b();
            obj6[1] = m.a;
            obj6[2] = this.b.a().getAbsolutePath();
            obj6[3] = m.b.getName();
            obj6[4] = file2.getAbsolutePath();
            Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", obj6));
            bArr = new byte[4096];
            if (file2.exists() != null) {
                file2.delete();
            }
            obj4 = this.c.getInputStream(m.b);
            obj6 = new FileOutputStream(file2);
            f.m(file2);
            obj5 = obj4.read(bArr);
            while (obj5 > 0) {
                obj6.write(bArr, i, obj5);
                obj5 = obj4.read(bArr);
            }
            obj6.close();
            if (obj4 != null) {
                obj4.close();
            }
        }
    }
}
