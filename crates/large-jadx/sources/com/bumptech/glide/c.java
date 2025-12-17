package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.e;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.a;
import com.bumptech.glide.load.data.k.a;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.m.a.b;
import com.bumptech.glide.load.m.a.c;
import com.bumptech.glide.load.m.b.a;
import com.bumptech.glide.load.m.b.d;
import com.bumptech.glide.load.m.c;
import com.bumptech.glide.load.m.d.b;
import com.bumptech.glide.load.m.e.c;
import com.bumptech.glide.load.m.f.b;
import com.bumptech.glide.load.m.f.e;
import com.bumptech.glide.load.m.k.a;
import com.bumptech.glide.load.m.s.a;
import com.bumptech.glide.load.m.s.b;
import com.bumptech.glide.load.m.s.c;
import com.bumptech.glide.load.m.s.d;
import com.bumptech.glide.load.m.t;
import com.bumptech.glide.load.m.u.a;
import com.bumptech.glide.load.m.u.b;
import com.bumptech.glide.load.m.u.c;
import com.bumptech.glide.load.m.v.a;
import com.bumptech.glide.load.m.w.a;
import com.bumptech.glide.load.m.w.b;
import com.bumptech.glide.load.m.w.d;
import com.bumptech.glide.load.m.x.a;
import com.bumptech.glide.load.m.y.a.a;
import com.bumptech.glide.load.m.y.b.a;
import com.bumptech.glide.load.m.y.c.a;
import com.bumptech.glide.load.m.y.d.b;
import com.bumptech.glide.load.m.y.d.c;
import com.bumptech.glide.load.m.y.e.a;
import com.bumptech.glide.load.n.d.a.a;
import com.bumptech.glide.load.n.e.a;
import com.bumptech.glide.load.n.e.f;
import com.bumptech.glide.load.n.e.g;
import com.bumptech.glide.load.n.f.a;
import com.bumptech.glide.load.n.g.a;
import com.bumptech.glide.load.n.g.d;
import com.bumptech.glide.load.n.g.h;
import com.bumptech.glide.load.n.g.j;
import com.bumptech.glide.load.n.h.a;
import com.bumptech.glide.load.n.h.b;
import com.bumptech.glide.load.n.h.c;
import com.bumptech.glide.load.n.h.d;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.a;
import com.bumptech.glide.load.resource.bitmap.b;
import com.bumptech.glide.load.resource.bitmap.b0;
import com.bumptech.glide.load.resource.bitmap.c;
import com.bumptech.glide.load.resource.bitmap.c0;
import com.bumptech.glide.load.resource.bitmap.g;
import com.bumptech.glide.load.resource.bitmap.h;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.p;
import com.bumptech.glide.load.resource.bitmap.t;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.z;
import com.bumptech.glide.o.d;
import com.bumptech.glide.o.p;
import com.bumptech.glide.p.a;
import com.bumptech.glide.p.b;
import com.bumptech.glide.p.c;
import com.bumptech.glide.p.d;
import com.bumptech.glide.r.f;
import com.bumptech.glide.r.g;
import com.bumptech.glide.r.k.f;
import com.bumptech.glide.r.k.h;
import com.bumptech.glide.t.k;
import com.bumptech.glide.t.l;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    private static volatile com.bumptech.glide.c A;
    private static volatile boolean B;
    private final e a;
    private final h b;
    private final com.bumptech.glide.e c;
    private final com.bumptech.glide.Registry v;
    private final b w;
    private final p x;
    private final d y;
    private final List<com.bumptech.glide.k> z;

    public interface a {
        public abstract g build();
    }
    c(Context context, k k2, h h3, e e4, b b5, p p6, d d7, int i8, com.bumptech.glide.c.a c$a9, Map<Class<?>, com.bumptech.glide.l<?, ?>> map10, List<f<Object>> list11, com.bumptech.glide.f f12) {
        Object hVar;
        boolean aVar3;
        int i2;
        int i3;
        e eVar;
        Class<android.os.ParcelFileDescriptor> z;
        int i;
        v vVar;
        c.a aVar2;
        Object aVar;
        int i4;
        Class<Integer> bVar;
        Object tVar;
        android.util.DisplayMetrics displayMetrics;
        Class<android.graphics.drawable.Drawable> obj;
        Class<android.graphics.Bitmap> obj3;
        int sDK_INT;
        int pVar;
        Class<String> obj4;
        Class<com.bumptech.glide.n.a> obj2;
        g gVar;
        int obj30;
        Object obj5 = this;
        Context context2 = context;
        eVar = e4;
        b bVar5 = b5;
        obj = f12;
        vVar = a.class;
        Class<String> obj102 = String.class;
        super();
        ArrayList arrayList = new ArrayList();
        obj5.z = arrayList;
        com.bumptech.glide.g nORMAL = g.NORMAL;
        obj5.a = eVar;
        obj5.w = bVar5;
        obj5.b = h3;
        obj5.x = p6;
        obj5.y = d7;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        obj5.v = registry2;
        DefaultImageHeaderParser defaultImageHeaderParser = new DefaultImageHeaderParser();
        registry2.o(defaultImageHeaderParser);
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 27) {
            pVar = new p();
            registry2.o(pVar);
        }
        List list3 = registry2.g();
        a aVar27 = new a(context2, list3, eVar, bVar5);
        final com.bumptech.glide.load.j jVar4 = c0.h(e4);
        m mVar = new m(registry2.g(), resources.getDisplayMetrics(), eVar, bVar5);
        if (sDK_INT >= 28 && obj.a(d.c.class)) {
            if (obj.a(d.c.class)) {
                tVar = new t();
                h hVar4 = new h();
                hVar = hVar4;
                obj4 = obj102;
            } else {
                g gVar3 = new g(mVar);
                z zVar = new z(mVar, bVar5);
                obj4 = obj102;
                tVar = zVar;
                hVar = gVar;
            }
        } else {
        }
        String str2 = "Animation";
        if (sDK_INT >= 28 && obj.a(d.b.class)) {
            if (obj.a(d.b.class)) {
                obj30 = sDK_INT;
                registry2.e(str2, InputStream.class, Drawable.class, a.f(list3, bVar5));
                registry2.e(str2, ByteBuffer.class, Drawable.class, a.a(list3, bVar5));
            } else {
                obj30 = sDK_INT;
            }
        } else {
        }
        f fVar4 = new f(context2);
        s.c cVar8 = new s.c(resources);
        s.d dVar8 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar26 = new s.a(resources);
        c cVar10 = new c(bVar5);
        a aVar7 = new a();
        d dVar = new d();
        c cVar9 = new c();
        registry2.a(ByteBuffer.class, cVar9);
        t tVar2 = new t(bVar5);
        registry2.a(InputStream.class, tVar2);
        String str3 = "Bitmap";
        registry2.e(str3, ByteBuffer.class, Bitmap.class, hVar);
        registry2.e(str3, InputStream.class, Bitmap.class, tVar);
        if (ParcelFileDescriptorRewinder.c() != null) {
            obj2 = vVar;
            vVar = new v(mVar);
            registry2.e(str3, ParcelFileDescriptor.class, Bitmap.class, vVar);
        } else {
            obj2 = vVar;
        }
        registry2.e(str3, ParcelFileDescriptor.class, Bitmap.class, jVar4);
        registry2.e(str3, AssetFileDescriptor.class, Bitmap.class, c0.c(e4));
        registry2.d(Bitmap.class, Bitmap.class, v.a.a());
        b0 b0Var = new b0();
        registry2.e(str3, Bitmap.class, Bitmap.class, b0Var);
        registry2.b(Bitmap.class, cVar10);
        a aVar24 = new a(resources, hVar);
        String str = "BitmapDrawable";
        registry2.e(str, ByteBuffer.class, BitmapDrawable.class, aVar24);
        a aVar25 = new a(resources, tVar);
        registry2.e(str, InputStream.class, BitmapDrawable.class, aVar25);
        a aVar20 = new a(resources, jVar4);
        registry2.e(str, ParcelFileDescriptor.class, BitmapDrawable.class, aVar20);
        b bVar3 = new b(eVar, cVar10);
        registry2.b(BitmapDrawable.class, bVar3);
        j jVar = new j(list3, aVar27, bVar5);
        registry2.e(str2, InputStream.class, c.class, jVar);
        registry2.e(str2, ByteBuffer.class, c.class, aVar27);
        d dVar2 = new d();
        registry2.b(c.class, dVar2);
        Class<com.bumptech.glide.n.a> obj60 = obj2;
        registry2.d(obj60, obj60, v.a.a());
        h hVar2 = new h(eVar);
        registry2.e(str3, obj60, Bitmap.class, hVar2);
        f fVar2 = fVar6;
        registry2.c(Uri.class, Drawable.class, fVar2);
        x xVar = new x(fVar2, eVar);
        registry2.c(Uri.class, Bitmap.class, xVar);
        a.a aVar5 = new a.a();
        registry2.p(aVar5);
        d.b bVar7 = new d.b();
        registry2.d(File.class, ByteBuffer.class, bVar7);
        f.e eVar3 = new f.e();
        registry2.d(File.class, InputStream.class, eVar3);
        a aVar9 = new a();
        registry2.c(File.class, File.class, aVar9);
        f.b bVar8 = new f.b();
        registry2.d(File.class, ParcelFileDescriptor.class, bVar8);
        registry2.d(File.class, File.class, v.a.a());
        k.a aVar6 = new k.a(bVar5);
        registry2.p(aVar6);
        if (ParcelFileDescriptorRewinder.c() != null) {
            aVar3 = new ParcelFileDescriptorRewinder.a();
            registry2.p(aVar3);
        }
        Class tYPE = Integer.TYPE;
        s.c cVar3 = cVar11;
        registry2.d(tYPE, InputStream.class, cVar3);
        s.b bVar10 = bVar13;
        registry2.d(tYPE, ParcelFileDescriptor.class, bVar10);
        bVar = obj112;
        registry2.d(bVar, InputStream.class, cVar3);
        registry2.d(bVar, ParcelFileDescriptor.class, bVar10);
        s.d dVar3 = obj33;
        registry2.d(bVar, Uri.class, dVar3);
        s.a aVar13 = obj34;
        registry2.d(tYPE, AssetFileDescriptor.class, aVar13);
        registry2.d(bVar, AssetFileDescriptor.class, aVar13);
        registry2.d(tYPE, Uri.class, dVar3);
        e.c cVar = new e.c();
        Class<String> obj89 = obj4;
        registry2.d(obj89, InputStream.class, cVar);
        e.c cVar5 = new e.c();
        registry2.d(Uri.class, InputStream.class, cVar5);
        u.c cVar2 = new u.c();
        registry2.d(obj89, InputStream.class, cVar2);
        u.b bVar4 = new u.b();
        registry2.d(obj89, ParcelFileDescriptor.class, bVar4);
        u.a aVar8 = new u.a();
        registry2.d(obj89, AssetFileDescriptor.class, aVar8);
        a.c cVar4 = new a.c(context.getAssets());
        registry2.d(Uri.class, InputStream.class, cVar4);
        a.b bVar9 = new a.b(context.getAssets());
        registry2.d(Uri.class, AssetFileDescriptor.class, bVar9);
        Context context4 = context;
        b.a aVar11 = new b.a(context4);
        registry2.d(Uri.class, InputStream.class, aVar11);
        aVar2 = new c.a(context4);
        registry2.d(Uri.class, InputStream.class, aVar2);
        i = obj30;
        if (i >= 29) {
            d.c cVar6 = new d.c(context4);
            registry2.d(Uri.class, InputStream.class, cVar6);
            bVar = new d.b(context4);
            registry2.d(Uri.class, ParcelFileDescriptor.class, bVar);
        }
        android.content.ContentResolver contentResolver2 = contentResolver3;
        w.d dVar5 = new w.d(contentResolver2);
        registry2.d(Uri.class, InputStream.class, dVar5);
        w.b bVar11 = new w.b(contentResolver2);
        registry2.d(Uri.class, ParcelFileDescriptor.class, bVar11);
        w.a aVar14 = new w.a(contentResolver2);
        registry2.d(Uri.class, AssetFileDescriptor.class, aVar14);
        x.a aVar15 = new x.a();
        registry2.d(Uri.class, InputStream.class, aVar15);
        e.a aVar16 = new e.a();
        registry2.d(URL.class, InputStream.class, aVar16);
        k.a aVar17 = new k.a(context4);
        registry2.d(Uri.class, File.class, aVar17);
        a.a aVar18 = new a.a();
        registry2.d(g.class, InputStream.class, aVar18);
        b.a aVar12 = new b.a();
        Class<byte[]> obj106 = obj111;
        registry2.d(obj106, ByteBuffer.class, aVar12);
        b.d dVar4 = new b.d();
        registry2.d(obj106, InputStream.class, dVar4);
        registry2.d(Uri.class, Uri.class, v.a.a());
        registry2.d(Drawable.class, Drawable.class, v.a.a());
        g gVar2 = new g();
        registry2.c(Drawable.class, Drawable.class, gVar2);
        b bVar12 = new b(resources);
        registry2.q(Bitmap.class, BitmapDrawable.class, bVar12);
        aVar = aVar28;
        registry2.q(Bitmap.class, obj106, aVar);
        d dVar7 = dVar9;
        c cVar7 = new c(eVar, aVar, dVar7);
        registry2.q(Drawable.class, obj106, cVar7);
        registry2.q(c.class, obj106, dVar7);
        if (i >= 23) {
            i3 = c0.d(e4);
            registry2.c(ByteBuffer.class, Bitmap.class, i3);
            aVar = new a(resources, i3);
            registry2.c(ByteBuffer.class, BitmapDrawable.class, aVar);
        }
        f fVar = new f();
        super(context, b5, registry2, fVar, a9, map10, list11, k2, f12, i8);
        obj43.c = eVar4;
    }

    private static void a(Context context, com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule2) {
        if (c.B) {
        } else {
            c.B = true;
            c.m(context, generatedAppGlideModule2);
            c.B = false;
        }
        IllegalStateException obj1 = new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        throw obj1;
    }

    public static com.bumptech.glide.c c(Context context) {
        Object cVar;
        Class<com.bumptech.glide.c> obj;
        com.bumptech.glide.c cVar2;
        obj = c.class;
        if (c.A == null && c.A == null) {
            obj = c.class;
            synchronized (obj) {
                c.a(context, c.d(context.getApplicationContext()));
            }
        }
        return c.A;
    }

    private static com.bumptech.glide.GeneratedAppGlideModule d(Context context) {
        Constructor declaredConstructor;
        Object obj6;
        int i = 0;
        int i2 = 1;
        final Class[] arr2 = new Class[i2];
        final int i3 = 0;
        arr2[i3] = Context.class;
        Object[] arr = new Object[i2];
        arr[i3] = context.getApplicationContext();
        return (GeneratedAppGlideModule)Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(arr2).newInstance(arr);
    }

    private static p l(Context context) {
        k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c.c(context).k();
    }

    private static void m(Context context, com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule2) {
        d dVar = new d();
        c.n(context, dVar, generatedAppGlideModule2);
    }

    private static void n(Context context, com.bumptech.glide.d d2, com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule3) {
        List emptyList;
        Object iterator;
        boolean z;
        boolean loggable;
        int i;
        Iterator iterator2;
        String next;
        boolean next2;
        boolean string;
        Iterator stringBuilder;
        boolean string2;
        boolean stringBuilder2;
        String str;
        final Context obj8 = context.getApplicationContext();
        emptyList = Collections.emptyList();
        if (generatedAppGlideModule3 != null) {
            if (generatedAppGlideModule3.c()) {
                d dVar = new d(obj8);
                emptyList = dVar.a();
            }
        } else {
        }
        int i2 = 3;
        next = "Glide";
        if (generatedAppGlideModule3 != null && !generatedAppGlideModule3.d().isEmpty()) {
            if (!generatedAppGlideModule3.d().isEmpty()) {
                stringBuilder = emptyList.iterator();
                while (stringBuilder.hasNext()) {
                    string2 = stringBuilder.next();
                    if (!generatedAppGlideModule3.d().contains((b)string2.getClass())) {
                    } else {
                    }
                    if (Log.isLoggable(next, i2)) {
                    }
                    stringBuilder.remove();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("AppGlideModule excludes manifest GlideModule: ");
                    stringBuilder2.append(string2);
                    Log.d(next, stringBuilder2.toString());
                }
            }
        }
        if (Log.isLoggable(next, i2)) {
            loggable = emptyList.iterator();
            for (b next4 : loggable) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Discovered GlideModule from manifest: ");
                stringBuilder.append(next4.getClass());
                Log.d(next, stringBuilder.toString());
            }
        }
        if (generatedAppGlideModule3 != null) {
            i = generatedAppGlideModule3.e();
        } else {
            i = 0;
        }
        d2.c(i);
        iterator2 = emptyList.iterator();
        for (b next : iterator2) {
            next.a(obj8, d2);
        }
        if (generatedAppGlideModule3 != null) {
            generatedAppGlideModule3.b(obj8, d2);
        }
        final com.bumptech.glide.c obj9 = d2.a(obj8);
        iterator = emptyList.iterator();
        for (b iterator2 : iterator) {
            iterator2.b(obj8, obj9, obj9.v);
        }
        if (generatedAppGlideModule3 != null) {
            generatedAppGlideModule3.a(obj8, obj9, obj9.v);
        }
        obj8.registerComponentCallbacks(obj9);
        c.A = obj9;
    }

    private static void q(Exception exception) {
        IllegalStateException illegalStateException = new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exception);
        throw illegalStateException;
    }

    public static com.bumptech.glide.k t(Context context) {
        return c.l(context).l(context);
    }

    public static com.bumptech.glide.k u(View view) {
        return c.l(view.getContext()).m(view);
    }

    public static com.bumptech.glide.k v(e e) {
        return c.l(e).o(e);
    }

    @Override // android.content.ComponentCallbacks2
    public void b() {
        l.a();
        this.b.b();
        this.a.b();
        this.w.b();
    }

    @Override // android.content.ComponentCallbacks2
    public b e() {
        return this.w;
    }

    @Override // android.content.ComponentCallbacks2
    public e f() {
        return this.a;
    }

    @Override // android.content.ComponentCallbacks2
    d g() {
        return this.y;
    }

    @Override // android.content.ComponentCallbacks2
    public Context h() {
        return this.c.getBaseContext();
    }

    @Override // android.content.ComponentCallbacks2
    com.bumptech.glide.e i() {
        return this.c;
    }

    @Override // android.content.ComponentCallbacks2
    public com.bumptech.glide.Registry j() {
        return this.v;
    }

    @Override // android.content.ComponentCallbacks2
    public p k() {
        return this.x;
    }

    @Override // android.content.ComponentCallbacks2
    void o(com.bumptech.glide.k k) {
        final List list = this.z;
        synchronized (list) {
            this.z.add(k);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        r(i);
    }

    boolean p(h<?> h) {
        boolean z;
        final List list = this.z;
        Iterator iterator = this.z.iterator();
        synchronized (list) {
            for (k next2 : iterator) {
            }
            return 0;
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void r(int i) {
        Object next;
        l.a();
        List list = this.z;
        Iterator iterator = this.z.iterator();
        synchronized (list) {
            for (k next : iterator) {
                next.onTrimMemory(i);
            }
            this.b.a(i);
            this.a.a(i);
            this.w.a(i);
        }
    }

    @Override // android.content.ComponentCallbacks2
    void s(com.bumptech.glide.k k) {
        final List list = this.z;
        synchronized (list) {
            this.z.remove(k);
        }
    }
}
