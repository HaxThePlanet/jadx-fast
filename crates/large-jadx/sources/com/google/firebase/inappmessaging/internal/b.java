package com.google.firebase.inappmessaging.internal;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.firebase.inappmessaging.internal.AbtIntegrationHelper a;
    public final ArrayList b;
    public b(com.google.firebase.inappmessaging.internal.AbtIntegrationHelper abtIntegrationHelper, ArrayList arrayList2) {
        super();
        this.a = abtIntegrationHelper;
        this.b = arrayList2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b);
    }
}
