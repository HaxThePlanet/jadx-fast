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

/* compiled from: HardwareConfigState.java */
/* loaded from: classes.dex */
public final class r {

    public static final boolean g = false;
    public static final boolean h = false;
    private static final File i = new File("/proc/self/fd");
    private static volatile r j;
    private static volatile int k;
    private final boolean a;
    private final int b;
    private final int c;
    private int d;
    private boolean e = true;
    private final AtomicBoolean f = new AtomicBoolean(0);
    static {
        int sDK_INT2 = Build.VERSION.SDK_INT;
        r.k = -1;
    }

    r() {
        super();
        final boolean z2 = false;
        AtomicBoolean atomicBoolean = new AtomicBoolean(z2);
        this.a = r.f();
        if (Build.VERSION.SDK_INT >= 28) {
            int i = 20000;
            this.b = i;
            this.c = z2;
        } else {
            this.b = 700;
            i = 128;
            this.c = i;
        }
    }

    private boolean a() {
        boolean z2 = false;
        if (r.g) {
            int r0 = !this.f.get() ? 1 : 0;
        }
        return (!this.f.get() ? 1 : 0);
    }

    public static r b() {
        com.bumptech.glide.load.resource.bitmap.r rVar2;
        if (r.j == null) {
            rVar = r.class;
            synchronized (rVar) {
                try {
                    if (r.j == null) {
                        r.j = new r();
                    }
                } catch (Throwable th) {
                }
            }
        }
        return r.j;
    }

    private int c() {
        int i;
        int r0 = r.k != -1 ? r.k : this.b;
        return (r.k != -1 ? r.k : this.b);
    }

    private synchronized boolean d() {
        int i = 1;
        i = 1;
        this.d += i;
        int length = 50;
        if (this.d >= 50) {
            i = 0;
            this.d = i;
            length = r.i.list().length;
            l = (long)c();
            long l2 = (long)length;
            if (l2 >= l) {
            }
            this.e = i;
            if (i == 0 && Log.isLoggable("Downsampler", 5)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ";
                String str4 = ", limit ";
                str3 = str5 + length + str4 + l;
                Log.w("Downsampler", str3);
            }
        }
        return this.e;
    }

    private static boolean f() {
        boolean z2 = false;
        int r0 = !r.g() && !r.h() ? 1 : 0;
        return (!r.g() && !r.h() ? 1 : 0);
    }

    private static boolean g() {
        final boolean z = false;
        int i = 26;
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        str = "SC-04J";
        Iterator it = Arrays.asList(new String[] { str, "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play" }).iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String)it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean h() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList(new String[] { "LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM" }).contains(Build.MODEL);
    }

    public boolean e(int i, int i2, boolean z, boolean z2) {
        z = false;
        final int i3 = 2;
        final String str = "HardwareConfig";
        if (!z && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed by caller");
            return false;
        }
        if (!this.a && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed by device model");
            return false;
        }
        if (!r.h && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed by sdk");
            return false;
        }
        if (a() && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed by app state");
            return false;
        }
        if (z2 && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed because exif orientation is required");
            return false;
        }
        if (i < this.c && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed because width is too small");
            return false;
        }
        if (i2 < this.c && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed because height is too small");
            return false;
        }
        if (!d() && Log.isLoggable(str, i3)) {
            Log.v(str, "Hardware config disallowed because there are insufficient FDs");
            return false;
        }
        return true;
    }

    boolean i(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        z2 = e(i, i2, z, z2);
        if (z2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            z = false;
            options.inMutable = z;
        }
        return this.e(i, i2, z, z2);
    }
}
