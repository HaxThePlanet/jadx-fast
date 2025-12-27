package com.bumptech.glide.load.engine.a0;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class i {

    private final int a;
    private final int b;
    private final Context c;
    private final int d;

    public static final class a {

        static final int i = 1;
        final Context a;
        ActivityManager b;
        i.c c = new i$b();
        float d = 2f;
        float e = 0f;
        float f = 0.4f;
        float g = 0.33f;
        int h = 4194304;
        static {
            int r0 = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            super();
            this.e = (float)i.a.i;
            this.a = context;
            this.b = (ActivityManager)context.getSystemService("activity");
            com.bumptech.glide.load.engine.a0.i.b bVar = new i.b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26) {
                int sDK_INT2 = i.e(this.b) ? 0 : sDK_INT2;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    interface c {
        int a();

        int b();
    }

    private static final class b implements i.c {

        private final DisplayMetrics a;
        b(DisplayMetrics displayMetrics) {
            super();
            this.a = displayMetrics;
        }

        public int a() {
            return this.a.heightPixels;
        }

        public int b() {
            return this.a.widthPixels;
        }
    }
    i(i.a aVar) {
        int i;
        boolean z2 = false;
        float f2;
        super();
        this.c = aVar.a;
        i = i.e(aVar.b) ? i4 / 2 : aVar.h;
        this.d = i;
        int i5 = i.c(aVar.b, aVar.f, aVar.g);
        float f4 = (float)(aVar.c.b() * aVar.c.a()) * 4;
        int rounded2 = Math.round(aVar.e * f4);
        int rounded = Math.round(f4 * aVar.d);
        int i11 = i5 - i;
        final int i14 = rounded + rounded2;
        if (i14 <= aVar.d) {
            this.b = rounded;
            this.a = rounded2;
        } else {
            float f7 = (float)i11 / (aVar.e + f15);
            f2 = f15 * f7;
            this.b = Math.round(f2);
            this.a = Math.round(f7 * aVar.e);
        }
        String str8 = "MemorySizeCalculator";
        if (Log.isLoggable(str8, 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Calculation complete, Calculated memory cache size: ");
            stringBuilder.append(f(this.b));
            stringBuilder.append(", pool size: ");
            stringBuilder.append(f(this.a));
            stringBuilder.append(", byte array size: ");
            stringBuilder.append(f(i));
            stringBuilder.append(", memory class limited? ");
            int r0 = i14 > i5 ? 1 : 0;
            stringBuilder.append((i14 > i5 ? 1 : 0));
            stringBuilder.append((i14 > i5 ? 1 : 0));
            stringBuilder.append((i14 > i5 ? 1 : 0));
            stringBuilder.append((i14 > i5 ? 1 : 0));
            stringBuilder.append((i14 > i5 ? 1 : 0));
            stringBuilder.append((i14 > i5 ? 1 : 0));
            stringBuilder.append(i.e(aVar.b));
            Log.d(str8, f7 * aVar.e.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f, float f2) {
        float f32;
        if (i.e(activityManager)) {
            f32 = f2;
        }
        return Math.round((float)(activityManager.getMemoryClass() * 1024) * 1024 * f32);
    }

    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i) {
        return Formatter.formatFileSize(this.c, (long)i);
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}
