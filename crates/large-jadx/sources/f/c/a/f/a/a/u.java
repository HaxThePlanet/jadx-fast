package f.c.a.f.a.a;

import android.content.Context;
import java.io.File;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class u {

    private final Context a;
    private static long b(File file) {
        int i = 0;
        int i2 = 0;
        long l;
        if (!file.isDirectory()) {
            return file.length();
        }
        final File[] listFiles = file.listFiles();
        i = 0;
        if (listFiles != null) {
            length = listFiles.length;
            i2 = 0;
            for (File file2 : listFiles) {
                i = i + u.b(file2);
            }
        }
        return i;
    }

    final long a() throws java.io.IOException {
        return u.b(new File(this.a.getFilesDir(), "assetpacks"));
    }

    u(Context context) {
        super();
        this.a = context;
    }
}
