package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Keep;
import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import java.lang.ref.WeakReference;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class Trace extends AppStateUpdateHandler implements Parcelable, FirebasePerformanceAttributable, SessionAwareObject {

    public static final Parcelable.Creator<com.google.firebase.perf.metrics.Trace> CREATOR;
    static final Parcelable.Creator<com.google.firebase.perf.metrics.Trace> CREATOR_DATAONLY;
    private static final AndroidLogger logger;
    private static final Map<String, com.google.firebase.perf.metrics.Trace> traceNameToTraceMap;
    private final Clock clock;
    private final Map<String, com.google.firebase.perf.metrics.Counter> counterNameToCounterMap;
    private final Map<String, String> customAttributesMap;
    private Timer endTime;
    private final GaugeManager gaugeManager;
    private final String name;
    private final com.google.firebase.perf.metrics.Trace parent;
    private final WeakReference<SessionAwareObject> sessionAwareObject;
    private final List<PerfSession> sessions;
    private Timer startTime;
    private final List<com.google.firebase.perf.metrics.Trace> subtraces;
    private final TransportManager transportManager;
    static {
        Trace.logger = AndroidLogger.getInstance();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Trace.traceNameToTraceMap = concurrentHashMap;
        Trace.1 anon = new Trace.1();
        Trace.CREATOR = anon;
        Trace.2 anon2 = new Trace.2();
        Trace.CREATOR_DATAONLY = anon2;
    }

    private Trace(Parcel parcel, boolean z2) {
        int instance;
        GaugeManager obj4;
        final int i = 0;
        if (z2) {
            instance = i;
        } else {
            instance = AppStateMonitor.getInstance();
        }
        super(instance);
        WeakReference weakReference = new WeakReference(this);
        this.sessionAwareObject = weakReference;
        this.parent = (Trace)parcel.readParcelable(Trace.class.getClassLoader());
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.subtraces = arrayList;
        parcel.readList(arrayList, Trace.class.getClassLoader());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.counterNameToCounterMap = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.customAttributesMap = concurrentHashMap2;
        parcel.readMap(concurrentHashMap, Counter.class.getClassLoader());
        this.startTime = (Timer)parcel.readParcelable(Timer.class.getClassLoader());
        this.endTime = (Timer)parcel.readParcelable(Timer.class.getClassLoader());
        ArrayList arrayList2 = new ArrayList();
        List synchronizedList = Collections.synchronizedList(arrayList2);
        this.sessions = synchronizedList;
        parcel.readList(synchronizedList, PerfSession.class.getClassLoader());
        if (z2) {
            this.transportManager = i;
            this.clock = i;
            this.gaugeManager = i;
        } else {
            this.transportManager = TransportManager.getInstance();
            obj4 = new Clock();
            this.clock = obj4;
            this.gaugeManager = GaugeManager.getInstance();
        }
    }

    Trace(Parcel parcel, boolean z2, com.google.firebase.perf.metrics.Trace.1 trace$13) {
        super(parcel, z2);
    }

    private Trace(com.google.firebase.perf.metrics.Trace trace, String string2, Timer timer3, Timer timer4, List<com.google.firebase.perf.metrics.Trace> list5, Map<String, com.google.firebase.perf.metrics.Counter> map6, Map<String, String> map7) {
        ArrayList obj6;
        ConcurrentHashMap obj7;
        ConcurrentHashMap obj8;
        super();
        WeakReference weakReference = new WeakReference(this);
        this.sessionAwareObject = weakReference;
        this.parent = trace;
        this.name = string2.trim();
        this.startTime = timer3;
        this.endTime = timer4;
        if (list5 != null) {
        } else {
            obj6 = new ArrayList();
        }
        this.subtraces = obj6;
        if (map6 != null) {
        } else {
            obj7 = new ConcurrentHashMap();
        }
        this.counterNameToCounterMap = obj7;
        if (map7 != null) {
        } else {
            obj8 = new ConcurrentHashMap();
        }
        this.customAttributesMap = obj8;
        this.clock = trace.clock;
        this.transportManager = trace.transportManager;
        ArrayList obj3 = new ArrayList();
        this.sessions = Collections.synchronizedList(obj3);
        this.gaugeManager = trace.gaugeManager;
    }

    private Trace(String string) {
        Clock clock = new Clock();
        super(string, TransportManager.getInstance(), clock, AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public Trace(String string, TransportManager transportManager2, Clock clock3, AppStateMonitor appStateMonitor4) {
        super(string, transportManager2, clock3, appStateMonitor4, GaugeManager.getInstance());
    }

    public Trace(String string, TransportManager transportManager2, Clock clock3, AppStateMonitor appStateMonitor4, GaugeManager gaugeManager5) {
        super(appStateMonitor4);
        WeakReference obj4 = new WeakReference(this);
        this.sessionAwareObject = obj4;
        this.parent = 0;
        this.name = string.trim();
        ArrayList obj1 = new ArrayList();
        this.subtraces = obj1;
        obj1 = new ConcurrentHashMap();
        this.counterNameToCounterMap = obj1;
        obj1 = new ConcurrentHashMap();
        this.customAttributesMap = obj1;
        this.clock = clock3;
        this.transportManager = transportManager2;
        obj1 = new ArrayList();
        this.sessions = Collections.synchronizedList(obj1);
        this.gaugeManager = gaugeManager5;
    }

    private void checkAttribute(String string, String string2) {
        boolean size;
        int i;
        int i2 = 0;
        int i3 = 1;
        if (isStopped()) {
        } else {
            if (!this.customAttributesMap.containsKey(string)) {
                i = 5;
                if (this.customAttributesMap.size() >= i) {
                } else {
                }
                Object[] arr = new Object[i3];
                arr[i2] = Integer.valueOf(i);
                IllegalArgumentException obj5 = new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", arr));
                throw obj5;
            }
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(string, string2);
            obj5 = PerfMetricValidator.validateAttribute(simpleEntry);
            if (obj5 != null) {
            } else {
            }
            IllegalArgumentException obj6 = new IllegalArgumentException(obj5);
            throw obj6;
        }
        Object[] arr2 = new Object[i3];
        arr2[i2] = this.name;
        obj5 = new IllegalArgumentException(String.format(Locale.ENGLISH, "Trace '%s' has been stopped", arr2));
        throw obj5;
    }

    public static com.google.firebase.perf.metrics.Trace create(String string) {
        Trace trace = new Trace(string);
        return trace;
    }

    static com.google.firebase.perf.metrics.Trace getTrace(String string) {
        Object trace;
        final Class<com.google.firebase.perf.metrics.Trace> obj = Trace.class;
        final Map traceNameToTraceMap = Trace.traceNameToTraceMap;
        synchronized (obj) {
            trace = new Trace(string);
            traceNameToTraceMap.put(string, trace);
            return trace;
        }
    }

    static com.google.firebase.perf.metrics.Trace getTrace(String string, TransportManager transportManager2, Clock clock3, AppStateMonitor appStateMonitor4) {
        Object trace;
        com.google.firebase.perf.metrics.Trace trace2;
        Object obj;
        TransportManager transportManager;
        Clock clock;
        AppStateMonitor appStateMonitor;
        GaugeManager instance;
        final Class<com.google.firebase.perf.metrics.Trace> obj2 = Trace.class;
        final Map traceNameToTraceMap = Trace.traceNameToTraceMap;
        synchronized (obj2) {
            super(string, transportManager2, clock3, appStateMonitor4, GaugeManager.getInstance());
            traceNameToTraceMap.put(string, trace);
            return trace;
        }
    }

    private com.google.firebase.perf.metrics.Counter obtainOrCreateCounterByName(String string) {
        Object counter;
        Map counterNameToCounterMap;
        if ((Counter)this.counterNameToCounterMap.get(string) == null) {
            counter = new Counter(string);
            this.counterNameToCounterMap.put(string, counter);
        }
        return counter;
    }

    private void setEndTimeOfLastStage(Timer timer) {
        if (this.subtraces.isEmpty()) {
        }
        Object obj = this.subtraces.get(size--);
        if (obj.endTime == null) {
            obj.endTime = timer;
        }
    }

    static com.google.firebase.perf.metrics.Trace startTrace(String string) {
        final Object obj1 = Trace.traceNameToTraceMap.get(string);
        if ((Trace)obj1 != null) {
            (Trace)obj1.start();
        }
        return obj1;
    }

    static com.google.firebase.perf.metrics.Trace stopTrace(String string) {
        final Map traceNameToTraceMap = Trace.traceNameToTraceMap;
        final Object obj = traceNameToTraceMap.get(string);
        if ((Trace)obj != null) {
            (Trace)obj.stop();
            traceNameToTraceMap.remove(string);
        }
        return obj;
    }

    public int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    protected void finalize() {
        boolean active;
        String str;
        int i2;
        Object[] arr;
        int i;
        String name;
        try {
            if (isActive()) {
            }
            i2 = 1;
            arr = new Object[i2];
            arr[0] = this.name;
            Trace.logger.warn("Trace '%s' is started but not stopped when it is destructed!", arr);
            incrementTsnsCount(i2);
            super.finalize();
            super.finalize();
            throw th;
        }
    }

    public String getAttribute(String string) {
        return (String)this.customAttributesMap.get(string);
    }

    public Map<String, String> getAttributes() {
        HashMap hashMap = new HashMap(this.customAttributesMap);
        return hashMap;
    }

    Map<String, com.google.firebase.perf.metrics.Counter> getCounters() {
        return this.counterNameToCounterMap;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    Timer getEndTime() {
        return this.endTime;
    }

    public long getLongMetric(String string) {
        Map counterNameToCounterMap;
        Object obj3;
        if (string != null) {
            obj3 = this.counterNameToCounterMap.get(string.trim());
        } else {
            obj3 = 0;
        }
        if (obj3 == null) {
            return 0;
        }
        return obj3.getCount();
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    String getName() {
        return this.name;
    }

    List<PerfSession> getSessions() {
        Object next;
        final List sessions = this.sessions;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.sessions.iterator();
        synchronized (sessions) {
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((PerfSession)next != null) {
                }
                arrayList.add((PerfSession)next);
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    Timer getStartTime() {
        return this.startTime;
    }

    List<com.google.firebase.perf.metrics.Trace> getSubtraces() {
        return this.subtraces;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    boolean hasStarted() {
        int i;
        i = this.startTime != null ? 1 : 0;
        return i;
    }

    public void incrementMetric(String string, long l2) {
        String validateMetricName = PerfMetricValidator.validateMetricName(string);
        final int i = 1;
        final int i2 = 0;
        final int i3 = 2;
        if (validateMetricName != null) {
            Object[] obj9 = new Object[i3];
            obj9[i2] = string;
            obj9[i] = validateMetricName;
            Trace.logger.error("Cannot increment metric '%s'. Metric name is invalid.(%s)", obj9);
        }
        if (!hasStarted()) {
            obj9 = new Object[i3];
            obj9[i2] = string;
            obj9[i] = this.name;
            Trace.logger.warn("Cannot increment metric '%s' for trace '%s' because it's not started", obj9);
        }
        if (isStopped()) {
            obj9 = new Object[i3];
            obj9[i2] = string;
            obj9[i] = this.name;
            Trace.logger.warn("Cannot increment metric '%s' for trace '%s' because it's been stopped", obj9);
        }
        com.google.firebase.perf.metrics.Counter orCreateCounterByName = obtainOrCreateCounterByName(string.trim());
        orCreateCounterByName.increment(l2);
        obj9 = new Object[3];
        obj9[i2] = string;
        obj9[i] = Long.valueOf(orCreateCounterByName.getCount());
        obj9[i3] = this.name;
        Trace.logger.debug("Incrementing metric '%s' to %d on trace '%s'", obj9);
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    boolean isActive() {
        boolean started;
        int i;
        if (hasStarted() && !isStopped()) {
            i = !isStopped() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    boolean isStopped() {
        int i;
        i = this.endTime != null ? 1 : 0;
        return i;
    }

    public void putAttribute(String string, String string2) {
        int customAttributesMap;
        int i2;
        int i;
        AndroidLogger logger;
        String str;
        i = 1;
        final String obj9 = string.trim();
        final String obj10 = string2.trim();
        checkAttribute(obj9, obj10);
        final Object[] arr2 = new Object[3];
        arr2[i] = obj10;
        arr2[2] = this.name;
        Trace.logger.debug("Setting attribute '%s' to '%s' on trace '%s'", arr2);
        if (i != 0) {
            this.customAttributesMap.put(obj9, obj10);
        }
        try {
        }
    }

    public void putMetric(String string, long l2) {
        String validateMetricName = PerfMetricValidator.validateMetricName(string);
        final int i = 1;
        final int i2 = 0;
        final int i3 = 2;
        if (validateMetricName != null) {
            Object[] obj8 = new Object[i3];
            obj8[i2] = string;
            obj8[i] = validateMetricName;
            Trace.logger.error("Cannot set value for metric '%s'. Metric name is invalid.(%s)", obj8);
        }
        if (!hasStarted()) {
            obj8 = new Object[i3];
            obj8[i2] = string;
            obj8[i] = this.name;
            Trace.logger.warn("Cannot set value for metric '%s' for trace '%s' because it's not started", obj8);
        }
        if (isStopped()) {
            obj8 = new Object[i3];
            obj8[i2] = string;
            obj8[i] = this.name;
            Trace.logger.warn("Cannot set value for metric '%s' for trace '%s' because it's been stopped", obj8);
        }
        obtainOrCreateCounterByName(string.trim()).setCount(l2);
        Object[] arr = new Object[3];
        arr[i2] = string;
        arr[i] = Long.valueOf(l2);
        arr[i3] = this.name;
        Trace.logger.debug("Setting metric '%s' to '%s' on trace '%s'", arr);
    }

    public void removeAttribute(String string) {
        if (isStopped()) {
            Trace.logger.error("Can't remove a attribute from a Trace that's stopped.");
        }
        this.customAttributesMap.remove(string);
    }

    public void start() {
        Object perfSession;
        boolean gaugeAndEventCollectionEnabled;
        if (!ConfigResolver.getInstance().isPerformanceMonitoringEnabled()) {
            Trace.logger.debug("Trace feature is disabled.");
        }
        String validateTraceName = PerfMetricValidator.validateTraceName(this.name);
        int i = 1;
        int i2 = 0;
        if (validateTraceName != null) {
            Object[] arr2 = new Object[2];
            arr2[i2] = this.name;
            arr2[i] = validateTraceName;
            Trace.logger.error("Cannot start trace '%s'. Trace name is invalid.(%s)", arr2);
        }
        if (this.startTime != null) {
            Object[] arr = new Object[i];
            arr[i2] = this.name;
            Trace.logger.error("Trace '%s' has already started, should not start again!", arr);
        }
        this.startTime = this.clock.getTime();
        registerForAppState();
        perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.sessionAwareObject);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    void startStage(String string) {
        final Timer time = this.clock.getTime();
        setEndTimeOfLastStage(time);
        super(this, string, time, 0, 0, 0, 0);
        this.subtraces.add(trace2);
    }

    public void stop() {
        Timer gaugeAndEventCollectionEnabled;
        Object parent;
        int appState;
        int i = 0;
        appState = 1;
        if (!hasStarted()) {
            Object[] arr2 = new Object[appState];
            arr2[i] = this.name;
            Trace.logger.error("Trace '%s' has not been started so unable to stop!", arr2);
        }
        if (isStopped()) {
            Object[] arr = new Object[appState];
            arr[i] = this.name;
            Trace.logger.error("Trace '%s' has already stopped, should not stop again!", arr);
        }
        SessionManager.getInstance().unregisterForSessionUpdates(this.sessionAwareObject);
        unregisterForAppState();
        gaugeAndEventCollectionEnabled = this.clock.getTime();
        this.endTime = gaugeAndEventCollectionEnabled;
        if (this.parent == null) {
            setEndTimeOfLastStage(gaugeAndEventCollectionEnabled);
            if (!this.name.isEmpty()) {
                TraceMetricBuilder traceMetricBuilder = new TraceMetricBuilder(this);
                this.transportManager.log(traceMetricBuilder.build(), getAppState());
                if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
                    this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
                }
            } else {
                Trace.logger.error("Trace name is empty, no log is sent to server");
            }
        }
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    void stopStage() {
        setEndTimeOfLastStage(this.clock.getTime());
    }

    @Override // com.google.firebase.perf.application.AppStateUpdateHandler
    public void updateSession(PerfSession perfSession) {
        boolean sessions;
        if (perfSession == null) {
            Trace.logger.warn("Unable to add new SessionId to the Trace. Continuing without it.");
        }
        if (hasStarted() && !isStopped()) {
            if (!isStopped()) {
                this.sessions.add(perfSession);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i = 0;
        parcel.writeParcelable(this.parent, i);
        parcel.writeString(this.name);
        parcel.writeList(this.subtraces);
        parcel.writeMap(this.counterNameToCounterMap);
        parcel.writeParcelable(this.startTime, i);
        parcel.writeParcelable(this.endTime, i);
        List obj3 = this.sessions;
        parcel.writeList(this.sessions);
        return;
        synchronized (obj3) {
            i = 0;
            parcel.writeParcelable(this.parent, i);
            parcel.writeString(this.name);
            parcel.writeList(this.subtraces);
            parcel.writeMap(this.counterNameToCounterMap);
            parcel.writeParcelable(this.startTime, i);
            parcel.writeParcelable(this.endTime, i);
            obj3 = this.sessions;
            parcel.writeList(this.sessions);
        }
    }
}
