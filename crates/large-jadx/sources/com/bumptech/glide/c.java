package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.a;
import com.bumptech.glide.load.m.a.b;
import com.bumptech.glide.load.m.a.c;
import com.bumptech.glide.load.m.b.d;
import com.bumptech.glide.load.m.e.c;
import com.bumptech.glide.load.m.f.b;
import com.bumptech.glide.load.m.f.e;
import com.bumptech.glide.load.m.s.a;
import com.bumptech.glide.load.m.s.b;
import com.bumptech.glide.load.m.s.c;
import com.bumptech.glide.load.m.s.d;
import com.bumptech.glide.load.m.u.a;
import com.bumptech.glide.load.m.u.b;
import com.bumptech.glide.load.m.u.c;
import com.bumptech.glide.load.m.v.a;
import com.bumptech.glide.load.m.w.a;
import com.bumptech.glide.load.m.w.b;
import com.bumptech.glide.load.m.w.d;
import com.bumptech.glide.load.m.x.a;
import com.bumptech.glide.load.m.y.c.a;
import com.bumptech.glide.load.m.y.d.c;
import com.bumptech.glide.load.m.y.e.a;
import com.bumptech.glide.load.n.g.j;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.b0;
import com.bumptech.glide.load.resource.bitmap.c0;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.v;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.z;
import com.bumptech.glide.t.l;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    private static volatile c A;
    private static volatile boolean B;
    private final com.bumptech.glide.load.engine.z.e a;
    private final com.bumptech.glide.load.engine.a0.h b;
    private final e c;
    private final Registry v;
    private final com.bumptech.glide.load.engine.z.b w;
    private final com.bumptech.glide.o.p x;
    private final com.bumptech.glide.o.d y;
    private final List<k> z;

    public interface a {
        com.bumptech.glide.r.g build();
    }
    c(Context context, com.bumptech.glide.load.engine.k kVar, com.bumptech.glide.load.engine.a0.h hVar, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar, com.bumptech.glide.o.p pVar, com.bumptech.glide.o.d dVar, int i, c.a aVar, Map<Class<?>, l<?, ?>> map, List<com.bumptech.glide.r.f<Object>> list, f fVar) {
        com.bumptech.glide.load.resource.bitmap.h hVar2;
        int i3 = 28;
        com.bumptech.glide.load.resource.bitmap.t tVar;
        Class<String> cls;
        Class<com.bumptech.glide.n.a> vVar;
        int hVar32;
        Object context3 = this;
        Context context2 = context;
        eVar42 = eVar;
        com.bumptech.glide.load.engine.z.b bVar52 = bVar;
        fVar122 = fVar;
        vVar = a.class;
        cls = String.class;
        super();
        context3.z = new ArrayList();
        context3.a = eVar42;
        context3.w = bVar52;
        context3.b = hVar;
        context3.x = pVar;
        context3.y = dVar;
        Resources resources = context.getResources();
        com.bumptech.glide.Registry registry = new Registry();
        context3.v = registry;
        registry.o(new DefaultImageHeaderParser());
        hVar32 = Build.VERSION.SDK_INT;
        int i4 = 27;
        if (Build.VERSION.SDK_INT >= 27) {
            registry.o(new p());
        }
        List list2 = registry.g();
        final com.bumptech.glide.load.n.g.a aVar25 = new a(context2, list2, eVar42, bVar52);
        final com.bumptech.glide.load.j jVar6 = c0.h(eVar);
        final m mVar = new m(registry.g(), resources.getDisplayMetrics(), eVar42, bVar52);
        if (Build.VERSION.SDK_INT >= 28) {
            if (fVar122.a(d.c.class)) {
                tVar = new t();
                hVar2 = new h();
            } else {
            }
        }
        String str2 = "Animation";
        i3 = 28;
        if (Build.VERSION.SDK_INT >= 28) {
            if (fVar122.a(d.b.class)) {
                registry.e(str2, InputStream.class, Drawable.class, a.f(list2, bVar52));
                fVar122 = Drawable.class;
                registry.e(str2, ByteBuffer.class, fVar122, a.a(list2, bVar52));
            } else {
            }
        }
        com.bumptech.glide.load.resource.bitmap.c cVar9 = new c(bVar52);
        registry.a(ByteBuffer.class, new c());
        registry.a(InputStream.class, new t(bVar52));
        String str3 = "Bitmap";
        registry.e(str3, ByteBuffer.class, Bitmap.class, hVar2);
        obj3 = Bitmap.class;
        registry.e(str3, InputStream.class, obj3, tVar);
        if (ParcelFileDescriptorRewinder.c() != null) {
            obj = ParcelFileDescriptor.class;
            obj3 = Bitmap.class;
            registry.e(str3, obj, obj3, new v(mVar));
        } else {
        }
        registry.e(str3, ParcelFileDescriptor.class, Bitmap.class, jVar6);
        registry.e(str3, AssetFileDescriptor.class, Bitmap.class, c0.c(eVar));
        registry.d(Bitmap.class, Bitmap.class, v.a.a());
        registry.e(str3, Bitmap.class, Bitmap.class, new b0());
        registry.b(Bitmap.class, cVar9);
        String str = "BitmapDrawable";
        registry.e(str, ByteBuffer.class, BitmapDrawable.class, new a(resources, hVar2));
        registry.e(str, InputStream.class, BitmapDrawable.class, new a(resources, tVar));
        registry.e(str, ParcelFileDescriptor.class, BitmapDrawable.class, new a(resources, jVar6));
        registry.b(BitmapDrawable.class, new b(eVar42, cVar9));
        registry.e(str2, InputStream.class, c.class, new j(list2, aVar25, bVar52));
        registry.e(str2, ByteBuffer.class, c.class, aVar25);
        registry.b(c.class, new d());
        registry.d(vVar, vVar, v.a.a());
        registry.e(str3, vVar, Bitmap.class, new h(eVar42));
        registry.c(Uri.class, Drawable.class, fVar2);
        registry.c(Uri.class, Bitmap.class, new x(fVar2, eVar42));
        registry.p(new a.a());
        registry.d(File.class, ByteBuffer.class, new d.b());
        registry.d(File.class, InputStream.class, new f.e());
        registry.c(File.class, File.class, new a());
        registry.d(File.class, ParcelFileDescriptor.class, new f.b());
        registry.d(File.class, File.class, v.a.a());
        registry.p(new k.a(bVar52));
        if (ParcelFileDescriptorRewinder.c() != null) {
            registry.p(new ParcelFileDescriptorRewinder.a());
        }
        Class tYPE2 = Integer.TYPE;
        registry.d(tYPE2, InputStream.class, cVar);
        registry.d(tYPE2, ParcelFileDescriptor.class, bVar);
        registry.d(obj2, InputStream.class, cVar);
        registry.d(obj2, ParcelFileDescriptor.class, bVar);
        registry.d(obj2, Uri.class, pVar62);
        registry.d(tYPE2, AssetFileDescriptor.class, dVar72);
        registry.d(obj2, AssetFileDescriptor.class, dVar72);
        registry.d(tYPE2, Uri.class, pVar62);
        registry.d(cls, InputStream.class, new e.c());
        registry.d(Uri.class, InputStream.class, new e.c());
        registry.d(cls, InputStream.class, new u.c());
        registry.d(cls, ParcelFileDescriptor.class, new u.b());
        registry.d(cls, AssetFileDescriptor.class, new u.a());
        registry.d(Uri.class, InputStream.class, new a.c(context.getAssets()));
        registry.d(Uri.class, AssetFileDescriptor.class, new a.b(context.getAssets()));
        context2 = context;
        registry.d(Uri.class, InputStream.class, new b.a(context2));
        registry.d(Uri.class, InputStream.class, new c.a(context2));
        i = 29;
        if (Bitmap.class >= 29) {
            registry.d(Uri.class, InputStream.class, new d.c(context2));
            aVar2 = ParcelFileDescriptor.class;
            registry.d(Uri.class, aVar2, new d.b(context2));
        }
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver));
        registry.d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver));
        registry.d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver));
        registry.d(Uri.class, InputStream.class, new x.a());
        registry.d(URL.class, InputStream.class, new e.a());
        registry.d(Uri.class, File.class, new k.a(context2));
        registry.d(g.class, InputStream.class, new a.a());
        registry.d(cls2, ByteBuffer.class, new b.a());
        registry.d(cls2, InputStream.class, new b.d());
        registry.d(Uri.class, Uri.class, v.a.a());
        registry.d(Drawable.class, Drawable.class, v.a.a());
        registry.c(Drawable.class, Drawable.class, new g());
        registry.q(Bitmap.class, BitmapDrawable.class, new b(resources));
        aVar2 = new a();
        registry.q(Bitmap.class, cls2, aVar2);
        registry.q(Drawable.class, cls2, new c(eVar42, aVar2, dVar));
        registry.q(c.class, cls2, dVar);
        int i2 = 23;
        if (Bitmap.class >= 23) {
            com.bumptech.glide.load.j jVar = c0.d(eVar);
            registry.c(ByteBuffer.class, Bitmap.class, jVar);
            eVar42 = ByteBuffer.class;
            registry.c(eVar42, BitmapDrawable.class, new a(resources, jVar));
        }
        super(context, bVar, registry, fVar, aVar, map, list, kVar, fVar, i);
        this.c = eVar;
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (c.B) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        } else {
            c.B = true;
            c.m(context, generatedAppGlideModule);
            c.B = false;
            return;
        }
    }

    public static c c(Context context) {
        if (c.A == null) {
            obj = c.class;
            synchronized (obj) {
                try {
                    if (c.A == null) {
                        c.a(context, c.d(context.getApplicationContext()));
                    }
                } catch (Throwable th) {
                }
            }
        }
        return c.A;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            int i2 = 1;
            final Class[] arr2 = new Class[i2];
            final int i3 = 0;
            arr2[i3] = Context.class;
            Object[] arr = new Object[i2];
            arr[i3] = context.getApplicationContext();
        } catch (java.lang.reflect.InvocationTargetException invocationTarget) {
            c.q(invocationTarget);
            throw obj;
        } catch (java.lang.NoSuchMethodException noSuchMethod1) {
            c.q(noSuchMethod1);
            throw obj;
        } catch (java.lang.IllegalAccessException illegalAccess2) {
            c.q(illegalAccess2);
            throw obj;
        } catch (java.lang.InstantiationException instantiation3) {
            c.q(instantiation3);
            throw obj;
        } catch (java.lang.ClassNotFoundException unused) {
            instantiation3 = 5;
            String str = "Glide";
            instantiation3 = Log.isLoggable(str, instantiation3);
        }
        return context2;
    }

    private static com.bumptech.glide.o.p l(Context context) {
        k.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c.c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        c.n(context, new d(), generatedAppGlideModule);
    }

    private static void n(Context context, d dVar, GeneratedAppGlideModule generatedAppGlideModule) {
        List emptyList;
        com.bumptech.glide.o.p.b bVar = null;
        boolean z;
        boolean hasNext2;
        Iterator it2;
        boolean hasNext3;
        Object item3;
        boolean contains;
        String str;
        final Context applicationContext = context.getApplicationContext();
        emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new d(applicationContext).a();
        }
        int i = 3;
        item2 = "Glide";
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            it2 = emptyList.iterator();
            while (it2.hasNext()) {
                item3 = it2.next();
            }
        }
        if (Log.isLoggable(item2, i)) {
            Iterator it3 = emptyList.iterator();
            while (it3.hasNext()) {
                Object stringBuilder = new StringBuilder();
                String str3 = "Discovered GlideModule from manifest: ";
                Class cls = (b)it3.next().getClass();
                str2 = str3 + cls;
                Log.d(item2, str2);
            }
        }
        if (generatedAppGlideModule != null) {
            bVar = generatedAppGlideModule.e();
        } else {
            int i2 = 0;
        }
        dVar.c(bVar);
        Iterator item = emptyList.iterator();
        while (item.hasNext()) {
            (b)item.next().a(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, dVar);
        }
        final com.bumptech.glide.c cVar = dVar.a(applicationContext);
        Iterator it = emptyList.iterator();
        while (it.hasNext()) {
            try {
                (b)it.next().b(applicationContext, cVar, cVar.v);
            } catch (java.lang.AbstractMethodError e) {
                generatedAppGlideModule = new StringBuilder();
                String name = "Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ";
                generatedAppGlideModule.append(name);
                name = obj.getClass();
                name = name.getName();
                generatedAppGlideModule.append(name);
                generatedAppGlideModule = generatedAppGlideModule.toString();
                dVar = new IllegalStateException(generatedAppGlideModule, e);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) dVar;
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, cVar, cVar.v);
        }
        applicationContext.registerComponentCallbacks(cVar);
        c.A = cVar;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static k t(Context context) {
        return c.l(context).l(context);
    }

    public static k u(View view) {
        return c.l(view.getContext()).m(view);
    }

    public static k v(androidx.fragment.app.e eVar) {
        return c.l(eVar).o(eVar);
    }

    public void b() {
        l.a();
        this.b.b();
        this.a.b();
        this.w.b();
    }

    public com.bumptech.glide.load.engine.z.b e() {
        return this.w;
    }

    public com.bumptech.glide.load.engine.z.e f() {
        return this.a;
    }

    com.bumptech.glide.o.d g() {
        return this.y;
    }

    public Context h() {
        return this.c.getBaseContext();
    }

    e i() {
        return this.c;
    }

    public Registry j() {
        return this.v;
    }

    public com.bumptech.glide.o.p k() {
        return this.x;
    }

    void o(k kVar) {
        synchronized (list) {
            try {
                if (this.z.contains(kVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                } else {
                    this.z.add(kVar);
                    return;
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void onLowMemory() {
        b();
    }

    public void onTrimMemory(int i) {
        r(i);
    }

    boolean p(com.bumptech.glide.r.k.h<?> hVar) {
        synchronized (list) {
            try {
                Iterator it = this.z.iterator();
                while (it.hasNext()) {
                    if ((k)it.next().t(hVar)) {
                        return true;
                    }
                }
                return true;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void r(int i) {
        l.a();
        synchronized (list) {
            try {
                Iterator it = this.z.iterator();
                while (it.hasNext()) {
                    (k)it.next().onTrimMemory(i);
                }
            } catch (Throwable th) {
            }
        }
        this.b.a(th);
        this.a.a(th);
        this.w.a(th);
    }

    void s(k kVar) {
        synchronized (list) {
            try {
                if (!this.z.contains(kVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                } else {
                    this.z.remove(kVar);
                    return;
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }
}
