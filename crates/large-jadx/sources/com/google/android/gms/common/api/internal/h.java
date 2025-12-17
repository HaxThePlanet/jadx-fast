package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class h {

    private final Object a;
    public h(Activity activity) {
        super();
        r.k(activity, "Activity must not be null");
        this.a = activity;
    }

    public Activity a() {
        return (Activity)this.a;
    }

    public e b() {
        return (e)this.a;
    }

    public boolean c() {
        return obj instanceof e;
    }

    public final boolean d() {
        return obj instanceof Activity;
    }
}
