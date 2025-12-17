package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class w extends com.google.android.gms.common.api.internal.LifecycleCallback {

    private List<Runnable> a;
    private w(com.google.android.gms.common.api.internal.i i) {
        super(i);
        ArrayList obj2 = new ArrayList();
        this.a = obj2;
        this.mLifecycleFragment.q("LifecycleObserverOnStop", this);
    }

    static com.google.android.gms.common.api.internal.w a(Activity activity) {
        com.google.android.gms.common.api.internal.LifecycleCallback wVar;
        final com.google.android.gms.common.api.internal.i fragment = LifecycleCallback.getFragment(activity);
        synchronized (activity) {
            try {
                wVar = new w(fragment);
                return wVar;
                throw th;
            }
        }
    }

    static void b(com.google.android.gms.common.api.internal.w w, Runnable runnable2) {
        w.c(runnable2);
    }

    private final void c(Runnable runnable) {
        this.a.add(runnable);
        return;
        synchronized (this) {
            this.a.add(runnable);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        this.a = arrayList;
        Iterator iterator = this.a.iterator();
        synchronized (this) {
            arrayList = new ArrayList();
            this.a = arrayList;
            iterator = this.a.iterator();
        }
        try {
            for (Runnable arrayList : iterator) {
                arrayList.run();
            }
            (Runnable)iterator.next().run();
            throw th;
        }
    }
}
