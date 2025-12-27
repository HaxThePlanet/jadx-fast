package f.c.a.f.a.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.play.core.internal.w0;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
public final class b {

    private final f a;
    public static final int c(AssetManager assetManager, File file) {
        int value = (Integer)w0.d(assetManager, "addAssetPath", Integer.class, String.class, file.getPath()).intValue();
        StringBuilder stringBuilder = new StringBuilder(39);
        String str = "addAssetPath completed with ";
        str4 = 39 + str + value;
        Log.d("SplitCompat", str4);
        return value;
    }

    public final synchronized void a(Context context, Set<File> set) {
        final Iterator it = set.iterator();
        b.c(context.getAssets(), (File)it.next());
    }

    final synchronized boolean b(Context context, Set<String> set) {
        android.os.StrictMode.ThreadPolicy threadPolicy;
        Throwable str;
        File file;
        f.c.a.f.a.d.f fVar;
        boolean z = true;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
        try {
            StrictMode.allowThreadDiskReads();
            StrictMode.allowThreadDiskWrites();
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
        try {
            HashSet hashSet = new HashSet();
            final Iterator it = set.iterator();
            while (it.hasNext()) {
                hashSet.add(this.a.g((String)it.next()));
            }
            a(th1, hashSet);
        } catch (Throwable th) {
        } catch (Exception e1) {
        }
        if (threadPolicy != null) {
            try {
                StrictMode.setThreadPolicy(threadPolicy);
            } catch (Throwable th) {
            }
            throw th;
        }
        int i = 1;
        return z;
    }

    public b(f fVar) {
        super();
        this.a = fVar;
    }
}
