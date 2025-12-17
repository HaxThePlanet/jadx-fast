package com.google.firebase.perf.application;

import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class AppStateUpdateHandler implements com.google.firebase.perf.application.AppStateMonitor.AppStateCallback {

    private final WeakReference<com.google.firebase.perf.application.AppStateMonitor.AppStateCallback> appStateCallback;
    private final com.google.firebase.perf.application.AppStateMonitor appStateMonitor;
    private ApplicationProcessState currentAppState;
    private boolean isRegisteredForAppState;
    protected AppStateUpdateHandler() {
        super(AppStateMonitor.getInstance());
    }

    protected AppStateUpdateHandler(com.google.firebase.perf.application.AppStateMonitor appStateMonitor) {
        super();
        this.isRegisteredForAppState = false;
        this.currentAppState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.appStateMonitor = appStateMonitor;
        WeakReference obj2 = new WeakReference(this);
        this.appStateCallback = obj2;
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    protected void incrementTsnsCount(int i) {
        this.appStateMonitor.incrementTsnsCount(i);
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState obj3;
        final ApplicationProcessState currentAppState = this.currentAppState;
        final ApplicationProcessState aPPLICATION_PROCESS_STATE_UNKNOWN = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        if (currentAppState == aPPLICATION_PROCESS_STATE_UNKNOWN) {
            this.currentAppState = applicationProcessState;
        } else {
            if (currentAppState != applicationProcessState && applicationProcessState != aPPLICATION_PROCESS_STATE_UNKNOWN) {
                if (applicationProcessState != aPPLICATION_PROCESS_STATE_UNKNOWN) {
                    this.currentAppState = ApplicationProcessState.FOREGROUND_BACKGROUND;
                }
            }
        }
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    protected void registerForAppState() {
        if (this.isRegisteredForAppState) {
        }
        this.currentAppState = this.appStateMonitor.getAppState();
        this.appStateMonitor.registerForAppState(this.appStateCallback);
        this.isRegisteredForAppState = true;
    }

    @Override // com.google.firebase.perf.application.AppStateMonitor$AppStateCallback
    protected void unregisterForAppState() {
        if (!this.isRegisteredForAppState) {
        }
        this.appStateMonitor.unregisterForAppState(this.appStateCallback);
        this.isRegisteredForAppState = false;
    }
}
