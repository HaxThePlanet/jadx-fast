package com.google.firebase.perf.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.PerfSession;
import com.google.firebase.perf.v1.PerfSession.Builder;
import com.google.firebase.perf.v1.SessionVerbosity;
import com.google.protobuf.z.a;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PerfSession implements Parcelable {

    public static final Parcelable.Creator<com.google.firebase.perf.session.PerfSession> CREATOR;
    private final Timer creationTime;
    private boolean isGaugeAndEventCollectionEnabled;
    private final String sessionId;
    static {
        PerfSession.1 anon = new PerfSession.1();
        PerfSession.CREATOR = anon;
    }

    private PerfSession(Parcel parcel) {
        int i;
        super();
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = parcel.readString();
        i = parcel.readByte() != 0 ? 1 : i;
        this.isGaugeAndEventCollectionEnabled = i;
        this.creationTime = (Timer)parcel.readParcelable(Timer.class.getClassLoader());
    }

    PerfSession(Parcel parcel, com.google.firebase.perf.session.PerfSession.1 perfSession$12) {
        super(parcel);
    }

    public PerfSession(String string, Clock clock2) {
        super();
        this.isGaugeAndEventCollectionEnabled = false;
        this.sessionId = string;
        this.creationTime = clock2.getTime();
    }

    public static PerfSession[] buildAndSort(List<com.google.firebase.perf.session.PerfSession> list) {
        int i2;
        int i;
        PerfSession build;
        boolean verbose;
        if (list.isEmpty()) {
            return null;
        }
        PerfSession[] arr = new PerfSession[list.size()];
        final int i3 = 0;
        PerfSession build2 = (PerfSession)list.get(i3).build();
        final int i4 = 1;
        i = i3;
        i2 = i4;
        while (i2 < list.size()) {
            build = (PerfSession)list.get(i2).build();
            if (i == 0 && (PerfSession)list.get(i2).isVerbose()) {
            } else {
            }
            arr[i2] = build;
            i2++;
            if ((PerfSession)list.get(i2).isVerbose()) {
            } else {
            }
            arr[i3] = build;
            arr[i2] = build2;
            i = i4;
        }
        if (i == 0) {
            arr[i3] = build2;
        }
        return arr;
    }

    public static com.google.firebase.perf.session.PerfSession create() {
        Clock clock = new Clock();
        PerfSession perfSession = new PerfSession(UUID.randomUUID().toString().replaceAll("\\-", ""), clock);
        perfSession.setGaugeAndEventCollectionEnabled(PerfSession.shouldCollectGaugesAndEvents());
        return perfSession;
    }

    static boolean isVerbose(PerfSession perfSession) {
        Object next;
        SessionVerbosity gAUGES_AND_SYSTEM_EVENTS;
        Iterator obj2 = perfSession.getSessionVerbosityList().iterator();
        for (SessionVerbosity next : obj2) {
        }
        return 0;
    }

    public static boolean shouldCollectGaugesAndEvents() {
        ConfigResolver instance;
        int i;
        boolean performanceMonitoringEnabled;
        double d;
        instance = ConfigResolver.getInstance();
        if (instance.isPerformanceMonitoringEnabled() && Double.compare(performanceMonitoringEnabled, d) < 0) {
            i = Double.compare(performanceMonitoringEnabled, d) < 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public PerfSession build() {
        boolean isGaugeAndEventCollectionEnabled;
        PerfSession.Builder sessionId = PerfSession.newBuilder().setSessionId(this.sessionId);
        if (this.isGaugeAndEventCollectionEnabled) {
            sessionId.addSessionVerbosity(SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (PerfSession)sessionId.build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public Timer getTimer() {
        return this.creationTime;
    }

    @Override // android.os.Parcelable
    public boolean isExpired() {
        int i;
        i = Long.compare(minutes, sessionsMaxDurationMinutes) > 0 ? 1 : 0;
        return i;
    }

    @Override // android.os.Parcelable
    public boolean isGaugeAndEventCollectionEnabled() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    @Override // android.os.Parcelable
    public boolean isVerbose() {
        return this.isGaugeAndEventCollectionEnabled;
    }

    @Override // android.os.Parcelable
    public String sessionId() {
        return this.sessionId;
    }

    @Override // android.os.Parcelable
    public void setGaugeAndEventCollectionEnabled(boolean z) {
        this.isGaugeAndEventCollectionEnabled = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.sessionId);
        parcel.writeByte((byte)obj3);
        parcel.writeParcelable(this.creationTime, 0);
    }
}
