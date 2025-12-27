package com.airbnb.lottie;

import android.content.Context;
import androidx.core.os.i;
import com.airbnb.lottie.w.b;
import com.airbnb.lottie.w.e;
import com.airbnb.lottie.w.f;
import com.airbnb.lottie.w.g;
import com.airbnb.lottie.w.h;
import java.io.File;

/* compiled from: L.java */
/* loaded from: classes.dex */
public class c {

    public static boolean a = false;
    private static boolean b = false;
    private static String[] c;
    private static long[] d;
    private static int e;
    private static int f;
    private static f g;
    private static e h;
    private static volatile h i;
    private static volatile g j;

    class a implements e {

        final /* synthetic */ Context a;
        a(Context context) {
            this.a = context;
            super();
        }

        public File a() throws java.io.IOException {
            return new File(this.a.getCacheDir(), "lottie_network_cache");
        }
    }
    public static void a(String str) {
        if (!c.b) {
            return;
        }
        int i = c.e;
        if (c.e == 20) {
            c.f++;
            return;
        }
        c.c[c.e] = str;
        c.d[c.e] = System.nanoTime();
        i.a(str);
        c.e++;
    }

    public static float b(String str) {
        int i = c.f;
        float f = 0.0f;
        if (c.f > 0) {
            c.f--;
            return 0.0f;
        }
        if (!c.b) {
            return 0.0f;
        }
        c.e--;
        if (c.b == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            if (!str.equals(c.c[i3])) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Unbalanced trace call ";
                String str5 = ". Expected ";
                String str6 = c.c[c.e];
                String str7 = ".";
                str = str4 + str + str5 + str6 + str7;
                throw new IllegalStateException(str);
            } else {
                i.b();
                return (float)(System.nanoTime() - c.d[c.e]) / 1000000f;
            }
        }
    }

    public static g c(Context context) {
        g gVar;
        com.airbnb.lottie.c.a aVar;
        if (c.j == null) {
            obj = g.class;
            synchronized (obj) {
                try {
                    if (c.j == null) {
                        if (c.h == null) {
                            aVar = new c.a(context);
                        }
                        gVar = new g(aVar);
                        c.j = gVar;
                    }
                } catch (Throwable th) {
                }
            }
        }
        return gVar;
    }

    public static h d(Context context) {
        h hVar;
        b bVar;
        g gVar;
        if (c.i == null) {
            obj = h.class;
            synchronized (obj) {
                try {
                    if (c.i == null) {
                        if (c.g == null) {
                            bVar = new b();
                        }
                        hVar = new h(c.c(context), bVar);
                        c.i = hVar;
                    }
                } catch (Throwable th) {
                }
            }
        }
        return hVar;
    }

}
