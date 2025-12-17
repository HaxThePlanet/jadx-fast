package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.c;

/* loaded from: classes.dex */
public abstract class a extends androidx.lifecycle.g0.c {

    private final SavedStateRegistry a;
    private final androidx.lifecycle.j b;
    private final Bundle c;
    public a(c c, Bundle bundle2) {
        super();
        this.a = c.getSavedStateRegistry();
        this.b = c.getLifecycle();
        this.c = bundle2;
    }

    public final <T extends androidx.lifecycle.e0> T a(Class<T> class) {
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
        SavedStateHandleController.e(e0, this.a, this.b);
    }

    public final <T extends androidx.lifecycle.e0> T c(String string, Class<T> class2) {
        androidx.lifecycle.SavedStateHandleController savedStateHandleController = SavedStateHandleController.g(this.a, this.b, string, this.c);
        final androidx.lifecycle.e0 obj4 = d(string, class2, savedStateHandleController.h());
        obj4.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return obj4;
    }

    protected abstract <T extends androidx.lifecycle.e0> T d(String string, Class<T> class2, androidx.lifecycle.c0 c03);
}
