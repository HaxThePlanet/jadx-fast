package com.google.firebase.perf;

import com.google.firebase.perf.application.AppStateMonitor.AppColdStartCallback;

/* loaded from: classes2.dex */
public final class FirebasePerformanceInitializer implements AppStateMonitor.AppColdStartCallback {
    @Override // com.google.firebase.perf.application.AppStateMonitor$AppColdStartCallback
    public void onAppColdStart() {
        FirebasePerformance.getInstance();
    }
}
