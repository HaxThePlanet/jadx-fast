package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import d.b.a.b.b;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes.dex */
public final class SavedStateRegistry {

    private b<String, androidx.savedstate.SavedStateRegistry.b> a;
    private Bundle b;
    private boolean c;
    private androidx.savedstate.Recreator.a d;
    boolean e = true;

    public interface a {
        public abstract void a(androidx.savedstate.c c);
    }

    public interface b {
        public abstract Bundle a();
    }
    SavedStateRegistry() {
        super();
        b bVar = new b();
        this.a = bVar;
        int i = 1;
    }

    public Bundle a(String string) {
        if (!this.c) {
        } else {
            Bundle bundle = this.b;
            final int i = 0;
            this.b.remove(string);
            if (bundle != null && this.b.isEmpty()) {
                this.b.remove(string);
                if (this.b.isEmpty()) {
                    this.b = i;
                }
                return bundle.getBundle(string);
            }
            return i;
        }
        IllegalStateException obj4 = new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        throw obj4;
    }

    void b(j j, Bundle bundle2) {
        boolean str;
        Bundle obj3;
        if (this.c) {
        } else {
            if (bundle2 != null) {
                this.b = bundle2.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            obj3 = new SavedStateRegistry.1(this);
            j.a(obj3);
            this.c = true;
        }
        IllegalStateException obj2 = new IllegalStateException("SavedStateRegistry was already restored.");
        throw obj2;
    }

    void c(Bundle bundle) {
        Bundle bundle2;
        Object key;
        Bundle bundle3 = new Bundle();
        Bundle bundle4 = this.b;
        if (bundle4 != null) {
            bundle3.putAll(bundle4);
        }
        d.b.a.b.b.d dVar = this.a.g();
        for (Map.Entry next2 : dVar) {
            bundle3.putBundle((String)next2.getKey(), (SavedStateRegistry.b)next2.getValue().a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle3);
    }

    public void d(String string, androidx.savedstate.SavedStateRegistry.b savedStateRegistry$b2) {
        if ((SavedStateRegistry.b)this.a.l(string, b2) != null) {
        } else {
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        throw obj2;
    }

    public void e(Class<? extends androidx.savedstate.SavedStateRegistry.a> class) {
        androidx.savedstate.Recreator.a aVar;
        if (!this.e) {
        } else {
            if (this.d == null) {
                aVar = new Recreator.a(this);
                this.d = aVar;
            }
            class.getDeclaredConstructor(new Class[0]);
            this.d.b(class.getName());
        }
        IllegalStateException obj5 = new IllegalStateException("Can not perform this action after onSaveInstanceState");
        throw obj5;
    }
}
