package com.google.android.gms.internal.firebase-auth-api;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.i;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import java.util.List;

/* loaded from: classes2.dex */
final class rm extends LifecycleCallback {

    private final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> a;
    private rm(i i, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list2) {
        super(i);
        this.mLifecycleFragment.q("PhoneAuthActivityStopCallback", this);
        this.a = list2;
    }

    public static void a(Activity activity, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list2) {
        LifecycleCallback rmVar;
        final i obj2 = LifecycleCallback.getFragment(activity);
        if ((rm)obj2.i0("PhoneAuthActivityStopCallback", rm.class) == null) {
            rmVar = new rm(obj2, list2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        final List list = this.a;
        this.a.clear();
        return;
        synchronized (list) {
            list = this.a;
            this.a.clear();
        }
    }
}
