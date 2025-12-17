package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class l0 extends LifecycleCallback {

    private final List<WeakReference<com.google.android.gms.tasks.g0<?>>> a;
    private l0(i i) {
        super(i);
        ArrayList obj2 = new ArrayList();
        this.a = obj2;
        this.mLifecycleFragment.q("TaskOnStopCallback", this);
    }

    public static com.google.android.gms.tasks.l0 a(Activity activity) {
        LifecycleCallback l0Var;
        final i obj2 = LifecycleCallback.getFragment(activity);
        if ((l0)obj2.i0("TaskOnStopCallback", l0.class) == null) {
            l0Var = new l0(obj2);
        }
        return l0Var;
    }

    public final <T> void b(com.google.android.gms.tasks.g0<T> g0) {
        final List list = this.a;
        WeakReference weakReference = new WeakReference(g0);
        this.a.add(weakReference);
        return;
        synchronized (list) {
            list = this.a;
            weakReference = new WeakReference(g0);
            this.a.add(weakReference);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        Object obj;
        final List list = this.a;
        Iterator iterator = this.a.iterator();
        synchronized (list) {
            while (iterator.hasNext()) {
                obj = (WeakReference)iterator.next().get();
                if ((g0)obj != null) {
                }
                (g0)obj.zzb();
            }
            this.a.clear();
        }
    }
}
