package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class m {

    private static AtomicBoolean a;

    static class a extends androidx.lifecycle.f {
        @Override // androidx.lifecycle.f
        public void onActivityCreated(Activity activity, Bundle bundle2) {
            b0.g(activity);
        }

        @Override // androidx.lifecycle.f
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
        }

        @Override // androidx.lifecycle.f
        public void onActivityStopped(Activity activity) {
        }
    }
    static {
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        m.a = atomicBoolean;
    }

    static void a(Context context) {
        if (m.a.getAndSet(true)) {
        }
        m.a aVar = new m.a();
        (Application)context.getApplicationContext().registerActivityLifecycleCallbacks(aVar);
    }
}
