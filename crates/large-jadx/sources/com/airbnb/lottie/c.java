package com.airbnb.lottie;

import android.content.Context;
import androidx.core.os.i;
import com.airbnb.lottie.w.b;
import com.airbnb.lottie.w.e;
import com.airbnb.lottie.w.f;
import com.airbnb.lottie.w.g;
import com.airbnb.lottie.w.h;
import java.io.File;

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

        final Context a;
        a(Context context) {
            this.a = context;
            super();
        }

        @Override // com.airbnb.lottie.w.e
        public File a() {
            File file = new File(this.a.getCacheDir(), "lottie_network_cache");
            return file;
        }
    }
    static {
    }

    public static void a(String string) {
        if (!c.b) {
        }
        int i = c.e;
        if (i == 20) {
            c.f = obj4++;
        }
        c.c[i] = string;
        c.d[i] = System.nanoTime();
        i.a(string);
        c.e = obj4++;
    }

    public static float b(String string) {
        int i = c.f;
        int i7 = 0;
        if (i > 0) {
            c.f = i--;
            return i7;
        }
        if (!c.b) {
            return i7;
        }
        i2--;
        c.e = i3;
        if (i3 == -1) {
        } else {
            if (!string.equals(c.c[i3])) {
            } else {
                i.b();
                return obj4 /= i5;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unbalanced trace call ");
            stringBuilder.append(string);
            stringBuilder.append(". Expected ");
            stringBuilder.append(c.c[c.e]);
            stringBuilder.append(".");
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        IllegalStateException obj4 = new IllegalStateException("Can't end trace section. There are none.");
        throw obj4;
    }

    public static g c(Context context) {
        g gVar;
        Class<g> obj;
        e aVar;
        obj = g.class;
        if (c.j == null && c.j == null) {
            obj = g.class;
            synchronized (obj) {
                if (c.h != null) {
                } else {
                    aVar = new c.a(context);
                }
                gVar = new g(aVar);
                c.j = gVar;
            }
        }
        return gVar;
    }

    public static h d(Context context) {
        h hVar;
        Class<h> obj;
        f bVar;
        Object obj3;
        obj = h.class;
        if (c.i == null && c.i == null) {
            obj = h.class;
            synchronized (obj) {
                if (c.g != null) {
                } else {
                    bVar = new b();
                }
                hVar = new h(c.c(context), bVar);
                c.i = hVar;
            }
        }
        return hVar;
    }
}
