package f.c.a.f.a.a;

import android.content.Context;
import java.io.File;

/* loaded from: classes2.dex */
final class u {

    private final Context a;
    u(Context context) {
        super();
        this.a = context;
    }

    private static long b(File file) {
        int i;
        int length;
        int i2;
        long l;
        if (file.isDirectory() == null) {
            return file.length();
        }
        final File[] obj6 = file.listFiles();
        i = 0;
        if (obj6 != null) {
            i2 = 0;
            while (i2 < obj6.length) {
                i += l;
                i2++;
            }
        }
        return i;
    }

    final long a() {
        File file = new File(this.a.getFilesDir(), "assetpacks");
        return u.b(file);
    }
}
