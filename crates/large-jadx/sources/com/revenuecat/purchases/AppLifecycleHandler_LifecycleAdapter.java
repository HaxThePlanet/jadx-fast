package com.revenuecat.purchases;

import androidx.lifecycle.h;
import androidx.lifecycle.j.b;
import androidx.lifecycle.q;
import androidx.lifecycle.w;

/* loaded from: classes2.dex */
public class AppLifecycleHandler_LifecycleAdapter implements h {

    final com.revenuecat.purchases.AppLifecycleHandler mReceiver;
    AppLifecycleHandler_LifecycleAdapter(com.revenuecat.purchases.AppLifecycleHandler appLifecycleHandler) {
        super();
        this.mReceiver = appLifecycleHandler;
    }

    @Override // androidx.lifecycle.h
    public void callMethods(q q, j.b j$b2, boolean z3, w w4) {
        int i;
        boolean obj2;
        Object obj3;
        obj2 = 1;
        i = w4 != null ? obj2 : 0;
        if (z3) {
        }
        if (b2 == j.b.ON_START) {
            if (i != 0) {
                if (w4.a("onMoveToForeground", obj2)) {
                    this.mReceiver.onMoveToForeground();
                }
            } else {
            }
        }
        if (b2 == j.b.ON_STOP) {
            if (i != 0) {
                if (w4.a("onMoveToBackground", obj2)) {
                    this.mReceiver.onMoveToBackground();
                }
            } else {
            }
        }
    }
}
