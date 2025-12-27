package f.e.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Util.java */
/* loaded from: classes2.dex */
public final class c {

    static final Charset a;
    static {
        c.a = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
    }

    static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
                return;
            }
        }
    }

    static void b(File file) throws IOException {
        int i = 0;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str2 = "not a readable directory: ";
            file = str2 + file;
            throw new IOException(file);
        } else {
            i = 0;
            while (i < listFiles.length) {
                File file2 = listFiles[i];
                if (file2.delete() == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "failed to delete file: ";
                    r0 = str + file2;
                    throw new IOException(r0);
                }
            }
            return;
        }
    }
}
