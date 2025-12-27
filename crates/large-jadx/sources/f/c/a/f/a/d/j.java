package f.c.a.f.a.d;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class j implements l {

    final /* synthetic */ Set a;
    final /* synthetic */ t b;
    final /* synthetic */ ZipFile c;
    public final void a(m mVar, File file, boolean z) {
        this.a.add(file);
        if (!z) {
            Object[] arr = new Object[5];
            int i = 0;
            arr[i] = this.b.b();
            arr[1] = mVar.a;
            arr[2] = this.b.a().getAbsolutePath();
            arr[3] = mVar.b.getName();
            arr[4] = file.getAbsolutePath();
            Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", arr));
            byte[] bArr = new byte[4096];
            if (file.exists()) {
                file.delete();
            }
            InputStream inputStream = this.c.getInputStream(mVar.b);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
            }
            try {
                f.m(th);
                int bytesRead = inputStream.read(bArr);
                fileOutputStream.write(bArr, i, bytesRead);
            } finally {
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
            try {
                fileOutputStream.close();
            } catch (Throwable th) {
            }
            if (mVar.b != null) {
                inputStream.close();
                return;
            }
        }
    }

    j(n nVar, Set set, t tVar, ZipFile zipFile) {
        this.a = set;
        this.b = tVar;
        this.c = zipFile;
        super();
    }
}
