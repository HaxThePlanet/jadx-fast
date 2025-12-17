package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class r {

    public static final boolean g = false;
    public static final boolean h = false;
    private static final File i;
    private static volatile com.bumptech.glide.load.resource.bitmap.r j;
    private static volatile int k;
    private final boolean a;
    private final int b;
    private final int c;
    private int d;
    private boolean e = true;
    private final AtomicBoolean f;
    static {
        int sDK_INT = Build.VERSION.SDK_INT;
        final int i4 = 0;
        if (sDK_INT < 29) {
            int i6 = i2;
        }
        int i7 = i4;
        if (sDK_INT >= 26) {
        }
        int i3 = i4;
        File file = new File("/proc/self/fd");
        r.i = file;
        r.k = -1;
    }

    r() {
        int i;
        super();
        int i2 = 1;
        final int i4 = 0;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i4);
        this.f = atomicBoolean;
        this.a = r.f();
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.c = i4;
        } else {
            this.b = 700;
            this.c = 128;
        }
    }

    private boolean a() {
        boolean z;
        int i;
        if (r.g && !this.f.get()) {
            i = !this.f.get() ? 1 : 0;
        } else {
        }
        return i;
    }

    public static com.bumptech.glide.load.resource.bitmap.r b() {
        com.bumptech.glide.load.resource.bitmap.r rVar2;
        com.bumptech.glide.load.resource.bitmap.r rVar;
        rVar2 = r.class;
        if (r.j == null && r.j == null) {
            rVar2 = r.class;
            synchronized (rVar2) {
                rVar = new r();
                r.j = rVar;
            }
        }
        return r.j;
    }

    private int c() {
        int i;
        i = r.k != -1 ? r.k : this.b;
        return i;
    }

    private boolean d() {
        int loggable;
        int string;
        int length;
        long l;
        int cmp;
        i += string;
        this.d = loggable;
        synchronized (this) {
            try {
                loggable = 0;
                this.d = loggable;
                length = list.length;
                l = (long)i2;
                if (Long.compare(l2, l) < 0) {
                } else {
                }
                string = loggable;
                this.e = string;
                if (string == null && Log.isLoggable("Downsampler", 5)) {
                }
                if (Log.isLoggable("Downsampler", 5)) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                stringBuilder.append(length);
                stringBuilder.append(", limit ");
                stringBuilder.append(l);
                Log.w("Downsampler", stringBuilder.toString());
                return this.e;
                throw th;
            }
        }
    }

    private static boolean f() {
        boolean z;
        int i;
        if (!r.g() && !r.h()) {
            i = !r.h() ? 1 : 0;
        } else {
        }
        return i;
    }

    private static boolean g() {
        int startsWith;
        String mODEL;
        final int i2 = 0;
        if (Build.VERSION.SDK_INT != 26) {
            return i2;
        }
        Iterator iterator = Arrays.asList(/* result */).iterator();
        for (String next2 : iterator) {
        }
        return i2;
    }

    private static boolean h() {
        if (Build.VERSION.SDK_INT != 27) {
            return 0;
        }
        return Arrays.asList(/* result */).contains(Build.MODEL);
    }

    public boolean e(int i, int i2, boolean z3, boolean z4) {
        boolean obj4;
        final int i3 = 0;
        final int i4 = 2;
        final String str = "HardwareConfig";
        if (!z3 && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed by caller");
            }
            return i3;
        }
        if (!this.a && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed by device model");
            }
            return i3;
        }
        if (!r.h && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed by sdk");
            }
            return i3;
        }
        if (a() && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed by app state");
            }
            return i3;
        }
        if (z4 && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed because exif orientation is required");
            }
            return i3;
        }
        int obj6 = this.c;
        if (i < obj6 && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed because width is too small");
            }
            return i3;
        }
        if (i2 < obj6 && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed because height is too small");
            }
            return i3;
        }
        if (!d() && Log.isLoggable(str, i4)) {
            if (Log.isLoggable(str, i4)) {
                Log.v(str, "Hardware config disallowed because there are insufficient FDs");
            }
            return i3;
        }
        return 1;
    }

    boolean i(int i, int i2, BitmapFactory.Options bitmapFactory$Options3, boolean z4, boolean z5) {
        int obj2;
        final boolean obj1 = e(i, i2, z4, z5);
        if (obj1 != null) {
            options3.inPreferredConfig = Bitmap.Config.HARDWARE;
            options3.inMutable = false;
        }
        return obj1;
    }
}
