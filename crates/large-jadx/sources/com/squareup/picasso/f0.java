package com.squareup.picasso;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
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

/* loaded from: classes2.dex */
final class f0 {

    static final StringBuilder a;
    private static final i b;
    private static final i c;

    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000);
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
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            f0.b bVar = new f0.b(runnable);
            return bVar;
        }
    }
    static {
        StringBuilder stringBuilder = new StringBuilder();
        f0.a = stringBuilder;
        f0.b = i.i("RIFF");
        f0.c = i.i("WEBP");
    }

    static long a(File file) {
        long blockSizeLong;
        long blockCountLong;
        int i;
        int obj6;
        StatFs statFs = new StatFs(file.getAbsolutePath());
        obj6 = Build.VERSION.SDK_INT;
        final int i5 = 18;
        if (obj6 < i5) {
            blockCountLong = (long)blockCount;
        } else {
            blockCountLong = statFs.getBlockCountLong();
        }
        try {
            if (obj6 < i5) {
            } else {
            }
            blockSizeLong = (long)obj6;
            blockSizeLong = statFs.getBlockSizeLong();
            i6 /= i3;
            Object obj = obj0;
            return Math.max(Math.min(i, obj5), i5);
        }
    }

    static int b(Context context) {
        int obj4;
        Object obj = f0.n(context, "activity");
        obj4 = obj4 &= i3 != 0 ? 1 : 0;
        if (obj4 != null) {
            obj4 = (ActivityManager)obj.getLargeMemoryClass();
        } else {
            obj4 = obj.getMemoryClass();
        }
        return (int)i5;
    }

    static void c() {
        if (!f0.q()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Method call should happen from the main thread.");
        throw illegalStateException;
    }

    static <T> T d(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }

    static File e(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    static String f(com.squareup.picasso.w w) {
        final StringBuilder sb = f0.a;
        sb.setLength(0);
        return f0.g(w, sb);
    }

    static String g(com.squareup.picasso.w w, StringBuilder stringBuilder2) {
        String string;
        boolean cmp;
        boolean z;
        int str;
        List size;
        int i2;
        int i;
        String str2;
        String str3 = w.f;
        int i5 = 50;
        if (str3 != null) {
            stringBuilder2.ensureCapacity(length += i5);
            stringBuilder2.append(w.f);
        } else {
            Uri uri = w.d;
            if (uri != null) {
                string = uri.toString();
                stringBuilder2.ensureCapacity(length2 += i5);
                stringBuilder2.append(string);
            } else {
                stringBuilder2.ensureCapacity(i5);
                stringBuilder2.append(w.e);
            }
        }
        int i4 = 10;
        stringBuilder2.append(i4);
        i = 120;
        stringBuilder2.append("rotation:");
        stringBuilder2.append(w.n);
        if (Float.compare(f, i8) != 0 && w.q) {
            stringBuilder2.append("rotation:");
            stringBuilder2.append(w.n);
            if (w.q) {
                stringBuilder2.append('@');
                stringBuilder2.append(w.o);
                stringBuilder2.append(i);
                stringBuilder2.append(w.p);
            }
            stringBuilder2.append(i4);
        }
        if (w.c()) {
            stringBuilder2.append("resize:");
            stringBuilder2.append(w.h);
            stringBuilder2.append(i);
            stringBuilder2.append(w.i);
            stringBuilder2.append(i4);
        }
        if (w.j) {
            stringBuilder2.append("centerCrop:");
            stringBuilder2.append(w.k);
            stringBuilder2.append(i4);
        } else {
            if (w.l) {
                stringBuilder2.append("centerInside");
                stringBuilder2.append(i4);
            }
        }
        size = w.g;
        if (size != null) {
            i = 0;
            while (i < size.size()) {
                stringBuilder2.append((e0)w.g.get(i).key());
                stringBuilder2.append(i4);
                i++;
            }
        }
        return stringBuilder2.toString();
    }

    static void h(Looper looper) {
        f0.a aVar = new f0.a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000);
    }

    static int i(Bitmap bitmap) {
        int allocationByteCount;
        if (Build.VERSION.SDK_INT >= 19) {
            allocationByteCount = bitmap.getAllocationByteCount();
        } else {
            allocationByteCount = bitmap.getByteCount();
        }
        if (allocationByteCount < 0) {
        } else {
            return allocationByteCount;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(bitmap);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    static String j(com.squareup.picasso.c c) {
        return f0.k(c, "");
    }

    static String k(com.squareup.picasso.c c, String string2) {
        String str2;
        int size;
        String str;
        StringBuilder stringBuilder = new StringBuilder(string2);
        final com.squareup.picasso.a obj5 = c.h();
        if (obj5 != null) {
            stringBuilder.append(obj5.b.d());
        }
        List obj4 = c.i();
        if (obj4 != null) {
            str2 = 0;
            while (str2 < obj4.size()) {
                if (str2 <= 0) {
                } else {
                }
                stringBuilder.append(", ");
                stringBuilder.append(obj.b.d());
                str2++;
                if (obj5 != null) {
                }
            }
        }
        return stringBuilder.toString();
    }

    static int l(Resources resources, com.squareup.picasso.w w2) {
        Object pathSegments;
        Object str;
        boolean empty;
        int size;
        int i;
        int obj6;
        Object obj7;
        int i2 = w2.e;
        if (i2 == 0) {
            str = w2.d;
            if (str == null) {
            } else {
                String authority = str.getAuthority();
                if (authority == null) {
                } else {
                    pathSegments = w2.d.getPathSegments();
                    if (pathSegments == null) {
                    } else {
                        if (pathSegments.isEmpty()) {
                        } else {
                            final int i3 = 0;
                            final int i4 = 1;
                            if (pathSegments.size() == i4) {
                                obj6 = Integer.parseInt((String)pathSegments.get(i3));
                                return obj6;
                            } else {
                                if (pathSegments.size() != 2) {
                                } else {
                                    obj6 = resources.getIdentifier((String)pathSegments.get(i4), (String)pathSegments.get(i3), authority);
                                }
                            }
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("More than two path segments: ");
                            stringBuilder4.append(w2.d);
                            obj6 = new FileNotFoundException(stringBuilder4.toString());
                            throw obj6;
                        }
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("No path segments: ");
                    stringBuilder3.append(w2.d);
                    obj6 = new FileNotFoundException(stringBuilder3.toString());
                    throw obj6;
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("No package provided: ");
            stringBuilder2.append(w2.d);
            obj6 = new FileNotFoundException(stringBuilder2.toString());
            throw obj6;
        }
        return i2;
    }

    static Resources m(Context context, com.squareup.picasso.w w2) {
        int i;
        if (w2.e == 0) {
            i = w2.d;
            if (i == null) {
            } else {
                String authority = i.getAuthority();
                if (authority == null) {
                } else {
                    return context.getPackageManager().getResourcesForApplication(authority);
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("No package provided: ");
            stringBuilder2.append(w2.d);
            FileNotFoundException obj2 = new FileNotFoundException(stringBuilder2.toString());
            throw obj2;
        }
        return context.getResources();
    }

    static <T> T n(Context context, String string2) {
        return context.getSystemService(string2);
    }

    static boolean o(Context context, String string2) {
        int obj0;
        obj0 = context.checkCallingOrSelfPermission(string2) == 0 ? 1 : 0;
        return obj0;
    }

    static boolean p(Context context) {
        int i;
        android.content.ContentResolver obj5 = context.getContentResolver();
        i = 0;
        final int i3 = 1;
        final String str = "airplane_mode_on";
        if (Build.VERSION.SDK_INT < 17 && Settings.System.getInt(obj5, str, i) != 0) {
            if (Settings.System.getInt(obj5, str, i) != 0) {
                i = i3;
            }
            return i;
        }
        if (Settings.Global.getInt(obj5, str, i) != 0) {
            try {
                i = i3;
                return i;
            }
        }
    }

    static boolean q() {
        int i;
        i = Looper.getMainLooper().getThread() == Thread.currentThread() ? 1 : 0;
        return i;
    }

    static boolean r(h h) {
        boolean z;
        i iVar;
        boolean obj3;
        final int i = 0;
        if (h.K0(i, obj2) && h.K0(8, i)) {
            obj3 = h.K0(8, i) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    static void s(String string, String string2, String string3) {
        f0.t(string, string2, string3, "");
    }

    static void t(String string, String string2, String string3, String string4) {
        Object[] arr = new Object[4];
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", string, string2, string3, string4));
    }
}
