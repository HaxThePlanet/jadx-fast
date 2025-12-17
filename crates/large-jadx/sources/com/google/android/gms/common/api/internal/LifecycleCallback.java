package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class LifecycleCallback {

    protected final com.google.android.gms.common.api.internal.i mLifecycleFragment;
    protected LifecycleCallback(com.google.android.gms.common.api.internal.i i) {
        super();
        this.mLifecycleFragment = i;
    }

    private static com.google.android.gms.common.api.internal.i getChimeraLifecycleFragmentImpl(com.google.android.gms.common.api.internal.h h) {
        IllegalStateException obj1 = new IllegalStateException("Method not available in SDK.");
        throw obj1;
    }

    public static com.google.android.gms.common.api.internal.i getFragment(Activity activity) {
        h hVar = new h(activity);
        return LifecycleCallback.getFragment(hVar);
    }

    public static com.google.android.gms.common.api.internal.i getFragment(ContextWrapper contextWrapper) {
        UnsupportedOperationException obj0 = new UnsupportedOperationException();
        throw obj0;
    }

    protected static com.google.android.gms.common.api.internal.i getFragment(com.google.android.gms.common.api.internal.h h) {
        if (h.c()) {
            return x1.B1(h.b());
        }
        if (!h.d()) {
        } else {
            return v1.a(h.a());
        }
        IllegalArgumentException obj1 = new IllegalArgumentException("Can't get fragment for unexpected activity.");
        throw obj1;
    }

    public void dump(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
    }

    public Activity getActivity() {
        return this.mLifecycleFragment.j0();
    }

    public void onActivityResult(int i, int i2, Intent intent3) {
    }

    public void onCreate(Bundle bundle) {
    }

    public void onDestroy() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
