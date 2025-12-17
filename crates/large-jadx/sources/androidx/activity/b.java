package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry.b;

/* loaded from: classes.dex */
public final class b implements SavedStateRegistry.b {

    public final androidx.activity.ComponentActivity a;
    public b(androidx.activity.ComponentActivity componentActivity) {
        super();
        this.a = componentActivity;
    }

    @Override // androidx.savedstate.SavedStateRegistry$b
    public final Bundle a() {
        return this.a.f();
    }
}
