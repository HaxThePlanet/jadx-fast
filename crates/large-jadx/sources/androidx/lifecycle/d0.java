package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class d0 extends androidx.lifecycle.g0.c {

    private static final Class<?>[] f;
    private static final Class<?>[] g;
    private final Application a;
    private final androidx.lifecycle.g0.b b;
    private final Bundle c;
    private final androidx.lifecycle.j d;
    private final SavedStateRegistry e;
    static {
        final Class<androidx.lifecycle.c0> obj = c0.class;
        Class[] arr = new Class[2];
        final int i3 = 0;
        arr[i3] = Application.class;
        int i2 = 1;
        arr[i2] = obj;
        d0.f = arr;
        Class[] arr2 = new Class[i2];
        arr2[i3] = obj;
        d0.g = arr2;
    }

    public d0(Application application, c c2, Bundle bundle3) {
        androidx.lifecycle.g0.d obj2;
        super();
        this.e = c2.getSavedStateRegistry();
        this.d = c2.getLifecycle();
        this.c = bundle3;
        this.a = application;
        if (application != null) {
            obj2 = g0.a.c(application);
        } else {
            obj2 = g0.d.b();
        }
        this.b = obj2;
    }

    private static <T> Constructor<T> d(Class<T> class, Class<?>[] class2Arr2) {
        int i;
        Constructor constructor;
        boolean equals;
        Constructor[] obj4 = class.getConstructors();
        i = 0;
        while (i < obj4.length) {
            constructor = obj4[i];
            i++;
        }
        return 0;
    }

    public <T extends androidx.lifecycle.e0> T a(Class<T> class) {
        String canonicalName = class.getCanonicalName();
        if (canonicalName == null) {
        } else {
            return c(canonicalName, class);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        throw obj2;
    }

    @Override // androidx.lifecycle.g0$c
    void b(androidx.lifecycle.e0 e0) {
        SavedStateHandleController.e(e0, this.e, this.d);
    }

    public <T extends androidx.lifecycle.e0> T c(String string, Class<T> class2) {
        Object instance;
        boolean assignableFrom;
        Object stringBuilder;
        Constructor constructor;
        int i;
        Object[] arr;
        assignableFrom = b.class.isAssignableFrom(class2);
        if (assignableFrom && this.a != null) {
            if (this.a != null) {
                constructor = d0.d(class2, d0.f);
            } else {
                constructor = d0.d(class2, d0.g);
            }
        } else {
        }
        if (constructor == null) {
            return this.b.a(class2);
        }
        androidx.lifecycle.SavedStateHandleController obj6 = SavedStateHandleController.g(this.e, this.d, string, this.c);
        int i2 = 0;
        i = 1;
        assignableFrom = this.a;
        if (assignableFrom && assignableFrom != null) {
            assignableFrom = this.a;
            if (assignableFrom != null) {
                arr = new Object[2];
                arr[i2] = assignableFrom;
                arr[i] = obj6.h();
                instance = constructor.newInstance(arr);
            } else {
                Object[] arr2 = new Object[i];
                arr2[i2] = obj6.h();
                instance = constructor.newInstance(arr2);
            }
        } else {
        }
        instance.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", obj6);
        return instance;
    }
}
