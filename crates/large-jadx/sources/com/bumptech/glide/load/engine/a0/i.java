package com.bumptech.glide.load.engine.a0;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

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
        com.bumptech.glide.load.engine.a0.i.c c;
        float d = 2f;
        float e;
        float f = 0.4f;
        float g = 0.33f;
        int h = 4194304;
        static {
            if (Build.VERSION.SDK_INT < 26) {
                int i = 4;
            }
            int i2 = 1;
        }

        public a(Context context) {
            int obj2;
            super();
            int i = 1073741824;
            this.e = (float)i2;
            int i3 = 1053609165;
            int i4 = 1051260355;
            int i5 = 4194304;
            this.a = context;
            this.b = (ActivityManager)context.getSystemService("activity");
            i.b bVar = new i.b(context.getResources().getDisplayMetrics());
            this.c = bVar;
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.b)) {
                if (i.e(this.b)) {
                    this.e = 0;
                }
            }
        }

        public com.bumptech.glide.load.engine.a0.i a() {
            i iVar = new i(this);
            return iVar;
        }
    }

    interface c {
        public abstract int a();

        public abstract int b();
    }

    private static final class b implements com.bumptech.glide.load.engine.a0.i.c {

        private final DisplayMetrics a;
        b(DisplayMetrics displayMetrics) {
            super();
            this.a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.a0.i$c
        public int a() {
            return displayMetrics.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.a0.i$c
        public int b() {
            return displayMetrics.widthPixels;
        }
    }
    i(com.bumptech.glide.load.engine.a0.i.a i$a) {
        int str;
        int i;
        int round2;
        boolean stringBuilder;
        float round;
        int str2;
        Object obj7;
        super();
        this.c = a.a;
        str = i.e(a.b) ? i2 / 2 : a.h;
        this.d = str;
        int i3 = i.c(a.b, a.f, a.g);
        float f2 = (float)i6;
        round = Math.round(f5 *= f2);
        round2 = Math.round(f2 *= f7);
        str2 = i3 - str;
        final int i16 = round2 + round;
        if (i16 <= str2) {
            this.b = round2;
            this.a = round;
        } else {
            float f8 = a.d;
            f3 /= i13;
            this.b = Math.round(f8 *= i9);
            this.a = Math.round(i9 *= round);
        }
        String str8 = "MemorySizeCalculator";
        if (Log.isLoggable(str8, 3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Calculation complete, Calculated memory cache size: ");
            stringBuilder.append(f(this.b));
            stringBuilder.append(", pool size: ");
            stringBuilder.append(f(this.a));
            stringBuilder.append(", byte array size: ");
            stringBuilder.append(f(str));
            stringBuilder.append(", memory class limited? ");
            i = i16 > i3 ? 1 : 0;
            stringBuilder.append(i);
            stringBuilder.append(", max size: ");
            stringBuilder.append(f(i3));
            stringBuilder.append(", memoryClass: ");
            stringBuilder.append(a.b.getMemoryClass());
            stringBuilder.append(", isLowMemoryDevice: ");
            stringBuilder.append(i.e(a.b));
            Log.d(str8, stringBuilder.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        int obj2;
        if (i.e(activityManager)) {
            obj2 = f3;
        }
        return Math.round(f *= obj2);
    }

    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return 1;
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
