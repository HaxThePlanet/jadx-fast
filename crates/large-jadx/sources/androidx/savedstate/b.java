package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.j.c;
import androidx.lifecycle.q;

/* loaded from: classes.dex */
public final class b {

    private final androidx.savedstate.c a;
    private final androidx.savedstate.SavedStateRegistry b;
    private b(androidx.savedstate.c c) {
        super();
        this.a = c;
        SavedStateRegistry obj1 = new SavedStateRegistry();
        this.b = obj1;
    }

    public static androidx.savedstate.b a(androidx.savedstate.c c) {
        b bVar = new b(c);
        return bVar;
    }

    public androidx.savedstate.SavedStateRegistry b() {
        return this.b;
    }

    public void c(Bundle bundle) {
        j lifecycle = this.a.getLifecycle();
        if (lifecycle.b() != j.c.INITIALIZED) {
        } else {
            Recreator recreator = new Recreator(this.a);
            lifecycle.a(recreator);
            this.b.b(lifecycle, bundle);
        }
        IllegalStateException obj4 = new IllegalStateException("Restarter must be created only during owner's initialization stage");
        throw obj4;
    }

    public void d(Bundle bundle) {
        this.b.c(bundle);
    }
}
