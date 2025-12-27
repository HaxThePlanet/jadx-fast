package d.h.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.e.c.b;
import androidx.core.content.e.c.c;
import d.h.i.f.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl.java */
/* loaded from: classes.dex */
class j {

    private ConcurrentHashMap<Long, c.b> a = new ConcurrentHashMap<>();

    private interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    class a implements j.c<f.b> {
        a() {
            super();
        }

        public int c(f.b bVar) {
            return bVar.e();
        }

        public boolean d(f.b bVar) {
            return bVar.f();
        }
    }

    class b implements j.c<c.c> {
        b() {
            super();
        }

        public int c(c.c cVar) {
            return cVar.e();
        }

        public boolean d(c.c cVar) {
            return cVar.f();
        }
    }
    j() {
        super();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }

    private void a(Typeface typeface, c.b bVar) {
        long l = j.j(typeface);
        if (l != 0) {
            this.a.put(Long.valueOf(l), bVar);
        }
    }

    private c.c f(c.b bVar, int i) {
        return (c.c)j.g(bVar.a(), i, new j.b(this));
    }

    private static <T> T g(T[] tArr, int i, j.c<T> cVar) {
        int i4 = 0;
        int i5 = 2147483647;
        int i3;
        int r0 = i & 1 == 0 ? 400 : 700;
        i3 = 0;
        i3 = 1;
        i = i3;
        i4 = 0;
        i5 = Integer.MAX_VALUE;
        while (i3 < tArr.length) {
            Object obj = tArr[i3];
            int r9 = i3;
            i5 = (Math.abs(cVar.a(obj) - i)) * 2 + i3;
            i3 = i3 + 1;
        }
        return i4;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
        } catch (java.lang.IllegalAccessException illegalAccess) {
            Log.e(str3, str, illegalAccess);
            return l;
        } catch (java.lang.NoSuchFieldException noSuchField1) {
            Log.e(str3, str, noSuchField1);
            return l;
        }
        return (Number)declaredField.get(typeface).longValue();
    }

    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        c.c cVar = f(bVar, i);
        if (cVar == null) {
            return null;
        }
        Typeface typeface = d.d(context, resources, cVar.b(), cVar.a(), i);
        a(typeface, bVar);
        return typeface;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            InputStream inputStream = context.getContentResolver().openInputStream(h(bVarArr, i).d());
        } catch (Throwable th) {
            java.io.Closeable cancellationSignal22 = cancellationSignal;
        } catch (java.io.IOException unused) {
            k.a(cancellationSignal);
            return cancellationSignal22;
        }
        try {
        } catch (Throwable th) {
            cancellationSignal22 = cancellationSignal;
        } catch (java.io.IOException unused) {
            k.a(cancellationSignal);
            return cancellationSignal22;
        }
        k.a(inputStream);
        return d(th, inputStream);
    }

    protected Typeface d(Context context, InputStream inputStream) {
        final File file = k.e(context);
        final int i = 0;
        if (file == null) {
            return null;
        }
        try {
        } catch (RuntimeException unused) {
            context.delete();
            return obj;
        } finally {
            context.delete();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) inputStream;
        }
        if (k.d(file, inputStream) == null) {
            file.delete();
            return i;
        }
        try {
        } catch (RuntimeException unused) {
            context.delete();
            return obj;
        } finally {
            context.delete();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) inputStream;
        }
        file.delete();
        return Typeface.createFromFile(file.getPath());
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        final File file = k.e(context);
        i = 0;
        if (file == null) {
            return null;
        }
        try {
        } catch (RuntimeException unused) {
            context.delete();
            return str;
        } finally {
            context.delete();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) resources;
        }
        if (k.c(file, resources, i) == null) {
            file.delete();
            return i;
        }
        try {
        } catch (RuntimeException unused) {
            context.delete();
            return str;
        } finally {
            context.delete();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) resources;
        }
        file.delete();
        return Typeface.createFromFile(file.getPath());
    }

    protected f.b h(f.b[] bVarArr, int i) {
        return (f.b)j.g(bVarArr, i, new j.a(this));
    }

    c.b i(Typeface typeface) {
        long l = j.j(typeface);
        if (l == 0) {
            return null;
        }
        return (c.b)this.a.get(Long.valueOf(l));
    }
}
