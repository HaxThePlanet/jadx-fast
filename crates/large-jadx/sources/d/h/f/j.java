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

/* loaded from: classes.dex */
class j {

    private ConcurrentHashMap<Long, c.b> a;

    private interface c {
        public abstract int a(T t);

        public abstract boolean b(T t);
    }

    class a implements d.h.f.j.c<f.b> {
        a(d.h.f.j j) {
            super();
        }

        @Override // d.h.f.j$c
        public int a(Object object) {
            return c((f.b)object);
        }

        @Override // d.h.f.j$c
        public boolean b(Object object) {
            return d((f.b)object);
        }

        @Override // d.h.f.j$c
        public int c(f.b f$b) {
            return b.e();
        }

        @Override // d.h.f.j$c
        public boolean d(f.b f$b) {
            return b.f();
        }
    }

    class b implements d.h.f.j.c<c.c> {
        b(d.h.f.j j) {
            super();
        }

        @Override // d.h.f.j$c
        public int a(Object object) {
            return c((c.c)object);
        }

        @Override // d.h.f.j$c
        public boolean b(Object object) {
            return d((c.c)object);
        }

        @Override // d.h.f.j$c
        public int c(c.c c$c) {
            return c.e();
        }

        @Override // d.h.f.j$c
        public boolean d(c.c c$c) {
            return c.f();
        }
    }
    j() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
    }

    private void a(Typeface typeface, c.b c$b2) {
        long valueOf;
        int obj5;
        valueOf = j.j(typeface);
        if (Long.compare(valueOf, i) != 0) {
            this.a.put(Long.valueOf(valueOf), b2);
        }
    }

    private c.c f(c.b c$b, int i2) {
        j.b bVar = new j.b(this);
        return (c.c)j.g(b.a(), i2, bVar);
    }

    private static <T> T g(T[] tArr, int i2, d.h.f.j.c<T> j$c3) {
        int i;
        int i3;
        int i6;
        int i7;
        Object obj;
        int i4;
        int i5;
        int obj11;
        i = i2 & 1 == 0 ? 400 : 700;
        final int i9 = 0;
        final int i10 = 1;
        obj11 = i2 &= 2 != 0 ? i10 : i9;
        i3 = 0;
        i6 = Integer.MAX_VALUE;
        i7 = i9;
        while (i7 < tArr.length) {
            obj = tArr[i7];
            if (c3.b(obj) == obj11) {
            } else {
            }
            i5 = i10;
            i14 += i5;
            if (i3 != 0) {
            } else {
            }
            i3 = obj;
            i6 = i4;
            i7++;
            if (i6 > i4) {
            }
            i5 = i9;
        }
        return i3;
    }

    private static long j(Typeface typeface) {
        String str = "Could not retrieve font from family.";
        final String str2 = "TypefaceCompatBaseImpl";
        if (typeface == null) {
            return 0;
        }
        Field declaredField = Typeface.class.getDeclaredField("native_instance");
        declaredField.setAccessible(true);
        return (Number)declaredField.get(typeface).longValue();
    }

    public Typeface b(Context context, c.b c$b2, Resources resources3, int i4) {
        c.c cVar = f(b2, i4);
        if (cVar == null) {
            return null;
        }
        Typeface obj3 = d.d(context, resources3, cVar.b(), cVar.a(), i4);
        a(obj3, b2);
        return obj3;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal2, f.b[] f$b3Arr3, int i4) {
        if (b3Arr3.length < 1) {
            return null;
        }
        InputStream obj4 = context.getContentResolver().openInputStream(h(b3Arr3, i4).d());
        k.a(obj4);
        return d(context, obj4);
    }

    protected Typeface d(Context context, InputStream inputStream2) {
        final File obj2 = k.e(context);
        final int i = 0;
        if (obj2 == null) {
            return i;
        }
        if (!k.d(obj2, inputStream2)) {
            obj2.delete();
            return i;
        }
        obj2.delete();
        return Typeface.createFromFile(obj2.getPath());
    }

    public Typeface e(Context context, Resources resources2, int i3, String string4, int i5) {
        final File obj1 = k.e(context);
        final int obj4 = 0;
        if (obj1 == null) {
            return obj4;
        }
        if (!k.c(obj1, resources2, i3)) {
            obj1.delete();
            return obj4;
        }
        obj1.delete();
        return Typeface.createFromFile(obj1.getPath());
    }

    protected f.b h(f.b[] f$bArr, int i2) {
        j.a aVar = new j.a(this);
        return (f.b)j.g(bArr, i2, aVar);
    }

    c.b i(Typeface typeface) {
        long l = j.j(typeface);
        if (Long.compare(l, i) == 0) {
            return null;
        }
        return (c.b)this.a.get(Long.valueOf(l));
    }
}
