package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class Recreator implements n {

    private final androidx.savedstate.c a;

    static final class a implements androidx.savedstate.SavedStateRegistry.b {

        final Set<String> a;
        a(androidx.savedstate.SavedStateRegistry savedStateRegistry) {
            super();
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            savedStateRegistry.d("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry$b
        public Bundle a() {
            Bundle bundle = new Bundle();
            ArrayList arrayList = new ArrayList(this.a);
            bundle.putStringArrayList("classes_to_restore", arrayList);
            return bundle;
        }

        @Override // androidx.savedstate.SavedStateRegistry$b
        void b(String string) {
            this.a.add(string);
        }
    }
    Recreator(androidx.savedstate.c c) {
        super();
        this.a = c;
    }

    private void e(String string) {
        try {
            int i = 0;
            Constructor declaredConstructor = Class.forName(string, i, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class).getDeclaredConstructor(new Class[i]);
            declaredConstructor.setAccessible(true);
            (SavedStateRegistry.a)declaredConstructor.newInstance(new Object[i]).a(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Failed to instantiate ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException(string, th);
            throw runtimeException;
            stringBuilder = new StringBuilder();
            str = "Class";
            stringBuilder.append(str);
            Throwable th = th.getSimpleName();
            stringBuilder.append(th);
            th = " must have default constructor in order to be automatically recreated";
            stringBuilder.append(th);
            th = stringBuilder.toString();
            runtimeException = new IllegalStateException(th, string);
            throw runtimeException;
            stringBuilder = new StringBuilder();
            str = "Class ";
            stringBuilder.append(str);
            stringBuilder.append(string);
            string = " wasn't found";
            stringBuilder.append(string);
            string = stringBuilder.toString();
            runtimeException = new RuntimeException(string, th);
            throw runtimeException;
        } catch (java.lang.NoSuchMethodException noSuchMethod) {
        }
    }

    @Override // androidx.lifecycle.n
    public void c(q q, j.b j$b2) {
        String obj3;
        if (b2 != j.b.ON_CREATE) {
        } else {
            q.getLifecycle().c(this);
            Bundle obj2 = this.a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (obj2 == null) {
            }
            obj2 = obj2.getStringArrayList("classes_to_restore");
            if (obj2 == null) {
            } else {
                obj2 = obj2.iterator();
                for (String obj3 : obj2) {
                    e(obj3);
                }
            }
            obj2 = new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            throw obj2;
        }
        obj2 = new AssertionError("Next event must be ON_CREATE");
        throw obj2;
    }
}
