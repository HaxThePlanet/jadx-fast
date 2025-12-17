package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.a;
import androidx.savedstate.c;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class SavedStateHandleController implements androidx.lifecycle.n {

    private final String a;
    private boolean b = false;
    private final androidx.lifecycle.c0 c;

    static final class a implements SavedStateRegistry.a {
        @Override // androidx.savedstate.SavedStateRegistry$a
        public void a(c c) {
            androidx.lifecycle.e0 e0Var;
            androidx.lifecycle.j lifecycle;
            boolean obj6;
            if (!c instanceof j0) {
            } else {
                androidx.lifecycle.i0 viewModelStore = (j0)c.getViewModelStore();
                final SavedStateRegistry savedStateRegistry = c.getSavedStateRegistry();
                Iterator iterator = viewModelStore.c().iterator();
                for (String next2 : iterator) {
                    SavedStateHandleController.e(viewModelStore.b(next2), savedStateRegistry, c.getLifecycle());
                }
                if (!viewModelStore.c().isEmpty()) {
                    savedStateRegistry.e(SavedStateHandleController.a.class);
                }
            }
            obj6 = new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            throw obj6;
        }
    }
    SavedStateHandleController(String string, androidx.lifecycle.c0 c02) {
        super();
        final int i = 0;
        this.a = string;
        this.c = c02;
    }

    static void e(androidx.lifecycle.e0 e0, SavedStateRegistry savedStateRegistry2, androidx.lifecycle.j j3) {
        String str;
        final Object obj1 = e0.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (obj1 != null && !(SavedStateHandleController)obj1.i()) {
            if (!obj1.i()) {
                obj1.f(savedStateRegistry2, j3);
                SavedStateHandleController.j(savedStateRegistry2, j3);
            }
        }
    }

    static androidx.lifecycle.SavedStateHandleController g(SavedStateRegistry savedStateRegistry, androidx.lifecycle.j j2, String string3, Bundle bundle4) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(string3, c0.a(savedStateRegistry.a(string3), bundle4));
        savedStateHandleController.f(savedStateRegistry, j2);
        SavedStateHandleController.j(savedStateRegistry, j2);
        return savedStateHandleController;
    }

    private static void j(SavedStateRegistry savedStateRegistry, androidx.lifecycle.j j2) {
        Object atLeast;
        androidx.lifecycle.j.c iNITIALIZED;
        androidx.lifecycle.j obj3;
        atLeast = j2.b();
        if (atLeast != j.c.INITIALIZED) {
            if (atLeast.isAtLeast(j.c.STARTED)) {
                savedStateRegistry.e(SavedStateHandleController.a.class);
            } else {
                atLeast = new SavedStateHandleController.1(j2, savedStateRegistry);
                j2.a(atLeast);
            }
        } else {
        }
    }

    @Override // androidx.lifecycle.n
    public void c(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2) {
        androidx.lifecycle.j obj2;
        androidx.lifecycle.j.b obj3;
        if (b2 == j.b.ON_DESTROY) {
            this.b = false;
            q.getLifecycle().c(this);
        }
    }

    @Override // androidx.lifecycle.n
    void f(SavedStateRegistry savedStateRegistry, androidx.lifecycle.j j2) {
        if (this.b) {
        } else {
            this.b = true;
            j2.a(this);
            savedStateRegistry.d(this.a, this.c.b());
        }
        IllegalStateException obj2 = new IllegalStateException("Already attached to lifecycleOwner");
        throw obj2;
    }

    @Override // androidx.lifecycle.n
    androidx.lifecycle.c0 h() {
        return this.c;
    }

    @Override // androidx.lifecycle.n
    boolean i() {
        return this.b;
    }
}
