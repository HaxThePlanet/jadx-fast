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

/* loaded from: classes2.dex */
public final class b {

    private final f.c.a.f.a.d.f a;
    public b(f.c.a.f.a.d.f f) {
        super();
        this.a = f;
    }

    public static final int c(AssetManager assetManager, File file2) {
        int obj3 = (Integer)w0.d(assetManager, "addAssetPath", Integer.class, String.class, file2.getPath()).intValue();
        StringBuilder obj4 = new StringBuilder(39);
        obj4.append("addAssetPath completed with ");
        obj4.append(obj3);
        Log.d("SplitCompat", obj4.toString());
        return obj3;
    }

    public final void a(Context context, Set<File> set2) {
        Object next;
        final Iterator obj3 = set2.iterator();
        synchronized (this) {
            try {
                for (File next : obj3) {
                    b.c(context.getAssets(), next);
                }
                b.c(obj2, (File)obj3.next());
                throw context;
            }
        }
    }

    final boolean b(Context context, Set<String> set2) {
        android.os.StrictMode.ThreadPolicy threadPolicy;
        Throwable str3;
        HashSet hashSet;
        String str;
        String str2;
        int obj5;
        Iterator obj6;
        threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.allowThreadDiskReads();
        StrictMode.allowThreadDiskWrites();
        synchronized (this) {
            try {
                hashSet = new HashSet();
                obj6 = set2.iterator();
                for (String next2 : obj6) {
                    hashSet.add(this.a.g(next2));
                }
                hashSet.add(this.a.g((String)obj6.next()));
                a(context, hashSet);
                if (threadPolicy != null) {
                }
                StrictMode.setThreadPolicy(threadPolicy);
                obj5 = 1;
            }
            return obj5;
        }
    }
}
