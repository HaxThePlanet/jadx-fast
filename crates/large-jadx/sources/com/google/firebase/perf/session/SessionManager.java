package com.google.firebase.perf.session;

import androidx.annotation.Keep;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class SessionManager extends AppStateUpdateHandler {

    private static final com.google.firebase.perf.session.SessionManager instance;
    private final AppStateMonitor appStateMonitor;
    private final Set<WeakReference<com.google.firebase.perf.session.SessionAwareObject>> clients;
    private final GaugeManager gaugeManager;
    private com.google.firebase.perf.session.PerfSession perfSession;
    static {
        SessionManager sessionManager = new SessionManager();
        SessionManager.instance = sessionManager;
    }

    private SessionManager() {
        super(GaugeManager.getInstance(), PerfSession.create(), AppStateMonitor.getInstance());
    }

    public SessionManager(GaugeManager gaugeManager, com.google.firebase.perf.session.PerfSession perfSession2, AppStateMonitor appStateMonitor3) {
        super();
        HashSet hashSet = new HashSet();
        this.clients = hashSet;
        this.gaugeManager = gaugeManager;
        this.perfSession = perfSession2;
        this.appStateMonitor = appStateMonitor3;
        registerForAppState();
    }

    public static com.google.firebase.perf.session.SessionManager getInstance() {
        return SessionManager.instance;
    }

    private void logGaugeMetadataIfCollectionEnabled(ApplicationProcessState applicationProcessState) {
        boolean gaugeAndEventCollectionEnabled;
        String sessionId;
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(this.perfSession.sessionId(), applicationProcessState);
        }
    }

    private void startOrStopCollectingGauges(ApplicationProcessState applicationProcessState) {
        GaugeManager gaugeAndEventCollectionEnabled;
        com.google.firebase.perf.session.PerfSession perfSession;
        Object obj3;
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.startCollectingGauges(this.perfSession, applicationProcessState);
        } else {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        ApplicationProcessState perfSessionIfExpired;
        super.onUpdateAppState(applicationProcessState);
        if (this.appStateMonitor.isColdStart()) {
        }
        if (applicationProcessState == ApplicationProcessState.FOREGROUND) {
            updatePerfSession(applicationProcessState);
        } else {
            if (!updatePerfSessionIfExpired()) {
                startOrStopCollectingGauges(applicationProcessState);
            }
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public final com.google.firebase.perf.session.PerfSession perfSession() {
        return this.perfSession;
    }

    public void registerForSessionUpdates(WeakReference<com.google.firebase.perf.session.SessionAwareObject> weakReference) {
        final Set clients = this.clients;
        this.clients.add(weakReference);
        return;
        synchronized (clients) {
            clients = this.clients;
            this.clients.add(weakReference);
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public void setPerfSession(com.google.firebase.perf.session.PerfSession perfSession) {
        this.perfSession = perfSession;
    }

    public void unregisterForSessionUpdates(WeakReference<com.google.firebase.perf.session.SessionAwareObject> weakReference) {
        final Set clients = this.clients;
        this.clients.remove(weakReference);
        return;
        synchronized (clients) {
            clients = this.clients;
            this.clients.remove(weakReference);
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public void updatePerfSession(ApplicationProcessState applicationProcessState) {
        Object obj;
        com.google.firebase.perf.session.PerfSession perfSession;
        final Set clients = this.clients;
        this.perfSession = PerfSession.create();
        Iterator iterator = this.clients.iterator();
        synchronized (clients) {
            while (iterator.hasNext()) {
                obj = (WeakReference)iterator.next().get();
                if ((SessionAwareObject)obj != null) {
                } else {
                }
                iterator.remove();
                (SessionAwareObject)obj.updateSession(this.perfSession);
            }
            logGaugeMetadataIfCollectionEnabled(applicationProcessState);
            startOrStopCollectingGauges(applicationProcessState);
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public boolean updatePerfSessionIfExpired() {
        if (this.perfSession.isExpired()) {
            updatePerfSession(this.appStateMonitor.getAppState());
            return 1;
        }
        return 0;
    }
}
