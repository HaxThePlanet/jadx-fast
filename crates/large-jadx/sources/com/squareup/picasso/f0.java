package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import l.h;
import l.i;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
final class f0 {

    static final StringBuilder a = new StringBuilder();
    private static final i b;
    private static final i c;

    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000L);
        }
    }

    private static class b extends Thread {
        b(Runnable runnable) {
            super(runnable);
        }

        @Override // java.lang.Thread
        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class c implements ThreadFactory {
        c() {
            super();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new f0.b(runnable);
        }
    }
    static {
        f0.b = i.i("RIFF");
        f0.c = i.i("WEBP");
    }

    static long a(File file) {
        long blockSizeLong;
        long blockCountLong;
        long l;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            blockSize = Build.VERSION.SDK_INT;
            final int i4 = 18;
            if (Build.VERSION.SDK_INT < i4) {
                blockCountLong = (long)statFs.getBlockCount();
            } else {
                blockCountLong = statFs.getBlockCountLong();
            }
            if (Build.VERSION.SDK_INT < i4) {
                blockSizeLong = (long)statFs.getBlockSize();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
            }
            l = (blockCountLong * blockSizeLong) / 50L;
        } catch (java.lang.IllegalArgumentException unused) {
        }
        return Math.max(Math.min(l, 52428800L), 5242880L);
    }

    static int b(Context context) {
        int i = 1;
        int largeMemoryClass;
        Object obj = f0.n(context, "activity");
        context = context.getApplicationInfo().flags & 1048576 != 0 ? 1 : 0;
        if (i != 0) {
            largeMemoryClass = obj.getLargeMemoryClass();
        } else {
            largeMemoryClass = obj.getMemoryClass();
        }
        return (int)(long)largeMemoryClass * 1048576L / 7L;
    }

    static void c() {
        if (!f0.q()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static <T> T d(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    static File e(Context context) throws java.io.IOException {
        final File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static String f(w wVar) {
        final StringBuilder sb = f0.a;
        sb.setLength(0);
        return f0.g(wVar, sb);
    }

    static String g(w wVar, StringBuilder sb) {
        boolean z;
        int i3 = 0;
        String key;
        int i6 = 50;
        if (wVar.f != null) {
            sb.ensureCapacity(wVar.f.length() + i6);
            sb.append(wVar.f);
        } else {
            if (wVar.d != null) {
                String uri = wVar.d.toString();
                i2 = uri.length() + i6;
                sb.ensureCapacity(i2);
                sb.append(uri);
            } else {
                sb.ensureCapacity(i6);
                sb.append(wVar.e);
            }
        }
        char c2 = '\n';
        sb.append(c2);
        char c = 'x';
        if (wVar.n != 0) {
            sb.append("rotation:");
            sb.append(wVar.n);
            if (wVar.q) {
                sb.append('@');
                sb.append(wVar.o);
                sb.append(c);
                sb.append(wVar.p);
            }
            sb.append(c2);
        }
        if (wVar.c()) {
            sb.append("resize:");
            sb.append(wVar.h);
            sb.append(c);
            sb.append(wVar.i);
            sb.append(c2);
        }
        if (wVar.j) {
            sb.append("centerCrop:");
            sb.append(wVar.k);
            sb.append(c2);
        } else {
            if (wVar.l) {
                sb.append("centerInside");
                sb.append(c2);
            }
        }
        if (wVar.g != null) {
            i3 = 0;
            while (i3 < wVar.g.size()) {
                sb.append((e0)wVar.g.get(i3).key());
                sb.append(c2);
                i3 = i3 + 1;
            }
        }
        return sb.toString();
    }

    static void h(Looper looper) {
        final com.squareup.picasso.f0.a aVar = new f0.a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000L);
    }

    static int i(Bitmap bitmap) {
        int allocationByteCount;
        if (Build.VERSION.SDK_INT >= 19) {
            allocationByteCount = bitmap.getAllocationByteCount();
        } else {
            allocationByteCount = bitmap.getByteCount();
        }
        if (Build.VERSION.SDK_INT < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Negative size: ";
            bitmap = str + bitmap;
            throw new IllegalStateException(bitmap);
        } else {
            return allocationByteCount;
        }
    }

    static String j(c cVar) {
        return f0.k(cVar, "");
    }

    static String k(c cVar, String str) {
        int i = 0;
        String str3;
        final StringBuilder stringBuilder = new StringBuilder(str);
        final com.squareup.picasso.a aVar = cVar.h();
        if (aVar != null) {
            stringBuilder.append(aVar.b.d());
        }
        List list = cVar.i();
        if (list != null) {
            i = 0;
            while (aVar.b < list.size()) {
                stringBuilder.append((a)list.get(i).b.d());
                i = i + 1;
            }
        }
        return stringBuilder.toString();
    }

    static int l(Resources resources, w wVar) throws FileNotFoundException {
        int identifier;
        return wVar.e;
    }

    static Resources m(Context context, w wVar) throws FileNotFoundException {
        return context.getResources();
    }

    static <T> T n(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean o(Context context, String str) {
        boolean z = true;
        context = context.checkCallingOrSelfPermission(str) == 0 ? 1 : 0;
        return (context.checkCallingOrSelfPermission(str) == 0 ? 1 : 0);
    }

    static boolean p(Context context) throws android.provider.Settings.SettingNotFoundException {
        boolean z = false;
        android.content.ContentResolver contentResolver = context.getContentResolver();
        int i2 = 0;
        try {
        } catch (java.lang.NullPointerException | java.lang.SecurityException unused) {
            return z2;
        }
        final int i = 1;
        final String str = "airplane_mode_on";
        if (Build.VERSION.SDK_INT < 17 && Settings.System.getInt(contentResolver, str, i2) != 0) {
            return z;
        }
        if (Settings.Global.getInt(contentResolver, str, i2) != 0) {
        }
    }

    static boolean q() {
        boolean z = true;
        int r0 = Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0;
        return (Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0);
    }

    static boolean r(h hVar) {
        boolean z;
        i iVar;
        boolean z3 = false;
        final long l2 = 0L;
        if (hVar.K0(l2, f0.b)) {
            hVar = hVar.K0(8L, f0.c) ? 1 : 0;
        }
        return (hVar.K0(8L, f0.c) ? 1 : 0);
    }

    static void s(String str, String str2, String str3) {
        f0.t(str, str2, str3, "");
    }

    static void t(String str, String str2, String str3, String str4) {
        Object[] arr = new Object[4];
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[] { str, str2, str3, str4 }));
    }
}
