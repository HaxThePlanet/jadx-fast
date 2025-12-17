package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class g0 {

    private final androidx.lifecycle.g0.b a;
    private final androidx.lifecycle.i0 b;

    public interface b {
        public abstract <T extends androidx.lifecycle.e0> T a(Class<T> class);
    }

    static class e {
        void b(androidx.lifecycle.e0 e0) {
        }
    }

    static abstract class c extends androidx.lifecycle.g0.e implements androidx.lifecycle.g0.b {
        public <T extends androidx.lifecycle.e0> T a(Class<T> class) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
            throw obj2;
        }

        public abstract <T extends androidx.lifecycle.e0> T c(String string, Class<T> class2);
    }

    public static class d implements androidx.lifecycle.g0.b {

        private static androidx.lifecycle.g0.d a;
        static androidx.lifecycle.g0.d b() {
            androidx.lifecycle.g0.d dVar;
            if (g0.d.a == null) {
                dVar = new g0.d();
                g0.d.a = dVar;
            }
            return g0.d.a;
        }

        public <T extends androidx.lifecycle.e0> T a(Class<T> class) {
            final String str = "Cannot create an instance of ";
            return (e0)class.newInstance();
        }
    }

    public static class a extends androidx.lifecycle.g0.d {

        private static androidx.lifecycle.g0.a c;
        private Application b;
        public a(Application application) {
            super();
            this.b = application;
        }

        public static androidx.lifecycle.g0.a c(Application application) {
            androidx.lifecycle.g0.a aVar;
            if (g0.a.c == null) {
                aVar = new g0.a(application);
                g0.a.c = aVar;
            }
            return g0.a.c;
        }

        public <T extends androidx.lifecycle.e0> T a(Class<T> class) {
            final String str = "Cannot create an instance of ";
            if (b.class.isAssignableFrom(class)) {
                int i = 1;
                Class[] arr2 = new Class[i];
                final int i2 = 0;
                arr2[i2] = Application.class;
                Object[] arr = new Object[i];
                arr[i2] = this.b;
                return (e0)class.getConstructor(arr2).newInstance(arr);
            }
            return super.a(class);
        }
    }
    public g0(androidx.lifecycle.i0 i0, androidx.lifecycle.g0.b g0$b2) {
        super();
        this.a = b2;
        this.b = i0;
    }

    public g0(androidx.lifecycle.j0 j0) {
        androidx.lifecycle.g0.b obj3;
        if (j0 instanceof i) {
            obj3 = (i)j0.getDefaultViewModelProviderFactory();
        } else {
            obj3 = g0.d.b();
        }
        super(j0.getViewModelStore(), obj3);
    }

    public <T extends androidx.lifecycle.e0> T a(Class<T> class) {
        String canonicalName = class.getCanonicalName();
        if (canonicalName == null) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:");
            stringBuilder.append(canonicalName);
            return b(stringBuilder.toString(), class);
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        throw obj4;
    }

    public <T extends androidx.lifecycle.e0> T b(String string, Class<T> class2) {
        androidx.lifecycle.e0 obj4;
        androidx.lifecycle.e0 e0Var = this.b.b(string);
        final androidx.lifecycle.g0.b obj3 = this.a;
        if (class2.isInstance(e0Var) && obj3 instanceof g0.e) {
            obj3 = this.a;
            if (obj3 instanceof g0.e) {
                (g0.e)obj3.b(e0Var);
            }
            return e0Var;
        }
        androidx.lifecycle.g0.b bVar = this.a;
        if (bVar instanceof g0.c) {
            obj4 = (g0.c)bVar.c(string, class2);
        } else {
            obj4 = bVar.a(class2);
        }
        this.b.d(string, obj4);
        return obj4;
    }
}
