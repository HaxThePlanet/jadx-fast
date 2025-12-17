package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import d.e.a;
import f.c.a.d.b.g.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class v1 extends Fragment implements com.google.android.gms.common.api.internal.i {

    private static final WeakHashMap<Activity, WeakReference<com.google.android.gms.common.api.internal.v1>> v;
    private final Map<String, com.google.android.gms.common.api.internal.LifecycleCallback> a;
    private int b = 0;
    private Bundle c;
    static {
        WeakHashMap weakHashMap = new WeakHashMap();
        v1.v = weakHashMap;
    }

    public v1() {
        super();
        a aVar = new a();
        this.a = Collections.synchronizedMap(aVar);
        int i = 0;
    }

    public static com.google.android.gms.common.api.internal.v1 a(Activity activity) {
        Object str;
        Object obj;
        Fragment fragmentByTag;
        FragmentTransaction beginTransaction;
        str = "LifecycleFragmentImpl";
        final WeakHashMap map = v1.v;
        obj = map.get(activity);
        obj = (WeakReference)obj.get();
        if (obj != null && (v1)obj == null) {
            obj = obj.get();
            if ((v1)(v1)obj == null) {
            }
            return (v1)(v1)obj;
        }
        fragmentByTag = activity.getFragmentManager().findFragmentByTag(str);
        if ((v1)fragmentByTag != null) {
            if ((v1)fragmentByTag.isRemoving()) {
                fragmentByTag = new v1();
                activity.getFragmentManager().beginTransaction().add(fragmentByTag, str).commitAllowingStateLoss();
            }
        } else {
        }
        WeakReference weakReference = new WeakReference(fragmentByTag);
        map.put(activity, weakReference);
        return fragmentByTag;
    }

    static int b(com.google.android.gms.common.api.internal.v1 v1) {
        return v1.b;
    }

    static Bundle c(com.google.android.gms.common.api.internal.v1 v1) {
        return v1.c;
    }

    @Override // android.app.Fragment
    public final void dump(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        Object next;
        super.dump(string, fileDescriptor2, printWriter3, string4Arr4);
        Iterator iterator = this.a.values().iterator();
        for (LifecycleCallback next : iterator) {
            next.dump(string, fileDescriptor2, printWriter3, string4Arr4);
        }
    }

    public final <T extends com.google.android.gms.common.api.internal.LifecycleCallback> T i0(String string, Class<T> class2) {
        return (LifecycleCallback)class2.cast(this.a.get(string));
    }

    @Override // android.app.Fragment
    public final Activity j0() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent3) {
        Object next;
        super.onActivityResult(i, i2, intent3);
        Iterator iterator = this.a.values().iterator();
        for (LifecycleCallback next : iterator) {
            next.onActivityResult(i, i2, intent3);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle bundle2;
        Object value;
        super.onCreate(bundle);
        this.b = 1;
        this.c = bundle;
        Iterator iterator = this.a.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (bundle != null) {
            } else {
            }
            bundle2 = 0;
            (LifecycleCallback)(Map.Entry)next2.getValue().onCreate(bundle2);
            bundle2 = bundle.getBundle((String)next2.getKey());
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        Object next;
        super.onDestroy();
        this.b = 5;
        Iterator iterator = this.a.values().iterator();
        for (LifecycleCallback next : iterator) {
            next.onDestroy();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        Object next;
        super.onResume();
        this.b = 3;
        Iterator iterator = this.a.values().iterator();
        for (LifecycleCallback next : iterator) {
            next.onResume();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        Object key;
        Bundle bundle2;
        Object value;
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
        }
        Iterator iterator = this.a.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            bundle2 = new Bundle();
            (LifecycleCallback)next2.getValue().onSaveInstanceState(bundle2);
            bundle.putBundle((String)next2.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        Object next;
        super.onStart();
        this.b = 2;
        Iterator iterator = this.a.values().iterator();
        for (LifecycleCallback next : iterator) {
            next.onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        Object next;
        super.onStop();
        this.b = 4;
        Iterator iterator = this.a.values().iterator();
        for (LifecycleCallback next : iterator) {
            next.onStop();
        }
    }

    @Override // android.app.Fragment
    public final void q(String string, com.google.android.gms.common.api.internal.LifecycleCallback lifecycleCallback2) {
        int hVar;
        com.google.android.gms.common.api.internal.u1 u1Var;
        if (this.a.containsKey(string)) {
        } else {
            this.a.put(string, lifecycleCallback2);
            if (this.b > 0) {
                hVar = new h(Looper.getMainLooper());
                u1Var = new u1(this, lifecycleCallback2, string);
                hVar.post(u1Var);
            }
        }
        StringBuilder stringBuilder = new StringBuilder(length += 59);
        stringBuilder.append("LifecycleCallback with tag ");
        stringBuilder.append(string);
        stringBuilder.append(" already added to this fragment.");
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }
}
