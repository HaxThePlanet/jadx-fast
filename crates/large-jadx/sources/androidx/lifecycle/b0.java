package androidx.lifecycle;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;

/* loaded from: classes.dex */
public class b0 extends Fragment {

    private androidx.lifecycle.b0.a a;

    interface a {
        public abstract void a();

        public abstract void b();

        public abstract void onStart();
    }

    static class b implements Application.ActivityLifecycleCallbacks {
        static void registerIn(Activity activity) {
            b0.b bVar = new b0.b();
            activity.registerActivityLifecycleCallbacks(bVar);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle2) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle2) {
            b0.a(activity, j.b.ON_CREATE);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            b0.a(activity, j.b.ON_RESUME);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            b0.a(activity, j.b.ON_START);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            b0.a(activity, j.b.ON_DESTROY);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            b0.a(activity, j.b.ON_PAUSE);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            b0.a(activity, j.b.ON_STOP);
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application$ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }
    static void a(Activity activity, androidx.lifecycle.j.b j$b2) {
        boolean z;
        Object obj1;
        if (activity instanceof t) {
            (t)activity.getLifecycle().h(b2);
        }
        obj1 = (q)activity.getLifecycle();
        if (activity instanceof q && obj1 instanceof s) {
            obj1 = (q)activity.getLifecycle();
            if (obj1 instanceof s) {
                (s)obj1.h(b2);
            }
        }
    }

    private void b(androidx.lifecycle.j.b j$b) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT < 29) {
            b0.a(getActivity(), b);
        }
    }

    private void c(androidx.lifecycle.b0.a b0$a) {
        if (a != null) {
            a.a();
        }
    }

    private void d(androidx.lifecycle.b0.a b0$a) {
        if (a != null) {
            a.b();
        }
    }

    private void e(androidx.lifecycle.b0.a b0$a) {
        if (a != null) {
            a.onStart();
        }
    }

    static androidx.lifecycle.b0 f(Activity activity) {
        return (b0)activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public static void g(Activity activity) {
        Object str;
        Object beginTransaction;
        androidx.lifecycle.b0 b0Var;
        if (Build.VERSION.SDK_INT >= 29) {
            b0.b.registerIn(activity);
        }
        final FragmentManager obj3 = activity.getFragmentManager();
        str = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
        if (obj3.findFragmentByTag(str) == null) {
            b0Var = new b0();
            obj3.beginTransaction().add(b0Var, str).commit();
            obj3.executePendingTransactions();
        }
    }

    @Override // android.app.Fragment
    void h(androidx.lifecycle.b0.a b0$a) {
        this.a = a;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        c(this.a);
        b(j.b.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        b(j.b.ON_DESTROY);
        this.a = 0;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        b(j.b.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        d(this.a);
        b(j.b.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        e(this.a);
        b(j.b.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        b(j.b.ON_STOP);
    }
}
