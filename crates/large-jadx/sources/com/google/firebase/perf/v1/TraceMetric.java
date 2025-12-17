package com.google.firebase.perf.v1;

import com.google.protobuf.a;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.m0;
import com.google.protobuf.n0;
import com.google.protobuf.q;
import com.google.protobuf.y1.b;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class TraceMetric extends z<com.google.firebase.perf.v1.TraceMetric, com.google.firebase.perf.v1.TraceMetric.Builder> implements com.google.firebase.perf.v1.TraceMetricOrBuilder {

    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 4;
    public static final int COUNTERS_FIELD_NUMBER = 6;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 8;
    private static final com.google.firebase.perf.v1.TraceMetric DEFAULT_INSTANCE = null;
    public static final int DURATION_US_FIELD_NUMBER = 5;
    public static final int IS_AUTO_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.perf.v1.TraceMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 9;
    public static final int SUBTRACES_FIELD_NUMBER = 7;
    private int bitField0_;
    private long clientStartTimeUs_;
    private n0<String, Long> counters_;
    private n0<String, String> customAttributes_;
    private long durationUs_;
    private boolean isAuto_;
    private String name_;
    private c0.j<com.google.firebase.perf.v1.PerfSession> perfSessions_;
    private c0.j<com.google.firebase.perf.v1.TraceMetric> subtraces_;

    private static final class CountersDefaultEntryHolder {

        static final m0<String, Long> defaultEntry;
        static {
            TraceMetric.CountersDefaultEntryHolder.defaultEntry = m0.d(y1.b.STRING, "", y1.b.INT64, Long.valueOf(0));
        }
    }

    private static final class CustomAttributesDefaultEntryHolder {

        static final m0<String, String> defaultEntry;
        static {
            y1.b sTRING = y1.b.STRING;
            final String str = "";
            TraceMetric.CustomAttributesDefaultEntryHolder.defaultEntry = m0.d(sTRING, str, sTRING, str);
        }
    }

    public static final class Builder extends z.a<com.google.firebase.perf.v1.TraceMetric, com.google.firebase.perf.v1.TraceMetric.Builder> implements com.google.firebase.perf.v1.TraceMetricOrBuilder {
        private Builder() {
            super(TraceMetric.access$000());
        }

        Builder(com.google.firebase.perf.v1.TraceMetric.1 traceMetric$1) {
            super();
        }

        public com.google.firebase.perf.v1.TraceMetric.Builder addAllPerfSessions(Iterable<? extends com.google.firebase.perf.v1.PerfSession> iterable) {
            copyOnWrite();
            TraceMetric.access$2100((TraceMetric)this.instance, iterable);
            return this;
        }

        public com.google.firebase.perf.v1.TraceMetric.Builder addAllSubtraces(Iterable<? extends com.google.firebase.perf.v1.TraceMetric> iterable) {
            copyOnWrite();
            TraceMetric.access$1400((TraceMetric)this.instance, iterable);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addPerfSessions(int i, com.google.firebase.perf.v1.PerfSession.Builder perfSession$Builder2) {
            copyOnWrite();
            TraceMetric.access$2000((TraceMetric)this.instance, i, (PerfSession)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
            copyOnWrite();
            TraceMetric.access$2000((TraceMetric)this.instance, i, perfSession2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addPerfSessions(com.google.firebase.perf.v1.PerfSession.Builder perfSession$Builder) {
            copyOnWrite();
            TraceMetric.access$1900((TraceMetric)this.instance, (PerfSession)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addPerfSessions(com.google.firebase.perf.v1.PerfSession perfSession) {
            copyOnWrite();
            TraceMetric.access$1900((TraceMetric)this.instance, perfSession);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addSubtraces(int i, com.google.firebase.perf.v1.TraceMetric.Builder traceMetric$Builder2) {
            copyOnWrite();
            TraceMetric.access$1300((TraceMetric)this.instance, i, (TraceMetric)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addSubtraces(int i, com.google.firebase.perf.v1.TraceMetric traceMetric2) {
            copyOnWrite();
            TraceMetric.access$1300((TraceMetric)this.instance, i, traceMetric2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addSubtraces(com.google.firebase.perf.v1.TraceMetric.Builder traceMetric$Builder) {
            copyOnWrite();
            TraceMetric.access$1200((TraceMetric)this.instance, (TraceMetric)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder addSubtraces(com.google.firebase.perf.v1.TraceMetric traceMetric) {
            copyOnWrite();
            TraceMetric.access$1200((TraceMetric)this.instance, traceMetric);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearClientStartTimeUs() {
            copyOnWrite();
            TraceMetric.access$700((TraceMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearCounters() {
            copyOnWrite();
            TraceMetric.access$1000((TraceMetric)this.instance).clear();
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearCustomAttributes() {
            copyOnWrite();
            TraceMetric.access$1700((TraceMetric)this.instance).clear();
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearDurationUs() {
            copyOnWrite();
            TraceMetric.access$900((TraceMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearIsAuto() {
            copyOnWrite();
            TraceMetric.access$500((TraceMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearName() {
            copyOnWrite();
            TraceMetric.access$200((TraceMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearPerfSessions() {
            copyOnWrite();
            TraceMetric.access$2200((TraceMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder clearSubtraces() {
            copyOnWrite();
            TraceMetric.access$1500((TraceMetric)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public boolean containsCounters(String string) {
            string.getClass();
            return (TraceMetric)this.instance.getCountersMap().containsKey(string);
        }

        @Override // com.google.protobuf.z$a
        public boolean containsCustomAttributes(String string) {
            string.getClass();
            return (TraceMetric)this.instance.getCustomAttributesMap().containsKey(string);
        }

        @Override // com.google.protobuf.z$a
        public long getClientStartTimeUs() {
            return (TraceMetric)this.instance.getClientStartTimeUs();
        }

        @Deprecated
        public Map<String, Long> getCounters() {
            return getCountersMap();
        }

        @Override // com.google.protobuf.z$a
        public int getCountersCount() {
            return (TraceMetric)this.instance.getCountersMap().size();
        }

        public Map<String, Long> getCountersMap() {
            return Collections.unmodifiableMap((TraceMetric)this.instance.getCountersMap());
        }

        @Override // com.google.protobuf.z$a
        public long getCountersOrDefault(String string, long l2) {
            Object obj3;
            long obj4;
            string.getClass();
            Map countersMap = (TraceMetric)this.instance.getCountersMap();
            if (countersMap.containsKey(string)) {
                obj4 = (Long)countersMap.get(string).longValue();
            }
            return obj4;
        }

        @Override // com.google.protobuf.z$a
        public long getCountersOrThrow(String string) {
            string.getClass();
            Map countersMap = (TraceMetric)this.instance.getCountersMap();
            if (!countersMap.containsKey(string)) {
            } else {
                return (Long)countersMap.get(string).longValue();
            }
            IllegalArgumentException obj3 = new IllegalArgumentException();
            throw obj3;
        }

        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.google.protobuf.z$a
        public int getCustomAttributesCount() {
            return (TraceMetric)this.instance.getCustomAttributesMap().size();
        }

        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap((TraceMetric)this.instance.getCustomAttributesMap());
        }

        @Override // com.google.protobuf.z$a
        public String getCustomAttributesOrDefault(String string, String string2) {
            Object obj3;
            Object obj4;
            string.getClass();
            Map customAttributesMap = (TraceMetric)this.instance.getCustomAttributesMap();
            if (customAttributesMap.containsKey(string)) {
                obj4 = obj3;
            }
            return obj4;
        }

        @Override // com.google.protobuf.z$a
        public String getCustomAttributesOrThrow(String string) {
            string.getClass();
            Map customAttributesMap = (TraceMetric)this.instance.getCustomAttributesMap();
            if (!customAttributesMap.containsKey(string)) {
            } else {
                return (String)customAttributesMap.get(string);
            }
            IllegalArgumentException obj3 = new IllegalArgumentException();
            throw obj3;
        }

        @Override // com.google.protobuf.z$a
        public long getDurationUs() {
            return (TraceMetric)this.instance.getDurationUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean getIsAuto() {
            return (TraceMetric)this.instance.getIsAuto();
        }

        @Override // com.google.protobuf.z$a
        public String getName() {
            return (TraceMetric)this.instance.getName();
        }

        @Override // com.google.protobuf.z$a
        public j getNameBytes() {
            return (TraceMetric)this.instance.getNameBytes();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.PerfSession getPerfSessions(int i) {
            return (TraceMetric)this.instance.getPerfSessions(i);
        }

        @Override // com.google.protobuf.z$a
        public int getPerfSessionsCount() {
            return (TraceMetric)this.instance.getPerfSessionsCount();
        }

        public List<com.google.firebase.perf.v1.PerfSession> getPerfSessionsList() {
            return Collections.unmodifiableList((TraceMetric)this.instance.getPerfSessionsList());
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric getSubtraces(int i) {
            return (TraceMetric)this.instance.getSubtraces(i);
        }

        @Override // com.google.protobuf.z$a
        public int getSubtracesCount() {
            return (TraceMetric)this.instance.getSubtracesCount();
        }

        public List<com.google.firebase.perf.v1.TraceMetric> getSubtracesList() {
            return Collections.unmodifiableList((TraceMetric)this.instance.getSubtracesList());
        }

        @Override // com.google.protobuf.z$a
        public boolean hasClientStartTimeUs() {
            return (TraceMetric)this.instance.hasClientStartTimeUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasDurationUs() {
            return (TraceMetric)this.instance.hasDurationUs();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasIsAuto() {
            return (TraceMetric)this.instance.hasIsAuto();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasName() {
            return (TraceMetric)this.instance.hasName();
        }

        public com.google.firebase.perf.v1.TraceMetric.Builder putAllCounters(Map<String, Long> map) {
            copyOnWrite();
            TraceMetric.access$1000((TraceMetric)this.instance).putAll(map);
            return this;
        }

        public com.google.firebase.perf.v1.TraceMetric.Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            TraceMetric.access$1700((TraceMetric)this.instance).putAll(map);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder putCounters(String string, long l2) {
            string.getClass();
            copyOnWrite();
            TraceMetric.access$1000((TraceMetric)this.instance).put(string, Long.valueOf(l2));
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder putCustomAttributes(String string, String string2) {
            string.getClass();
            string2.getClass();
            copyOnWrite();
            TraceMetric.access$1700((TraceMetric)this.instance).put(string, string2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder removeCounters(String string) {
            string.getClass();
            copyOnWrite();
            TraceMetric.access$1000((TraceMetric)this.instance).remove(string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder removeCustomAttributes(String string) {
            string.getClass();
            copyOnWrite();
            TraceMetric.access$1700((TraceMetric)this.instance).remove(string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder removePerfSessions(int i) {
            copyOnWrite();
            TraceMetric.access$2300((TraceMetric)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder removeSubtraces(int i) {
            copyOnWrite();
            TraceMetric.access$1600((TraceMetric)this.instance, i);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setClientStartTimeUs(long l) {
            copyOnWrite();
            TraceMetric.access$600((TraceMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setDurationUs(long l) {
            copyOnWrite();
            TraceMetric.access$800((TraceMetric)this.instance, l);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setIsAuto(boolean z) {
            copyOnWrite();
            TraceMetric.access$400((TraceMetric)this.instance, z);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setName(String string) {
            copyOnWrite();
            TraceMetric.access$100((TraceMetric)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setNameBytes(j j) {
            copyOnWrite();
            TraceMetric.access$300((TraceMetric)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setPerfSessions(int i, com.google.firebase.perf.v1.PerfSession.Builder perfSession$Builder2) {
            copyOnWrite();
            TraceMetric.access$1800((TraceMetric)this.instance, i, (PerfSession)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
            copyOnWrite();
            TraceMetric.access$1800((TraceMetric)this.instance, i, perfSession2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setSubtraces(int i, com.google.firebase.perf.v1.TraceMetric.Builder traceMetric$Builder2) {
            copyOnWrite();
            TraceMetric.access$1100((TraceMetric)this.instance, i, (TraceMetric)builder2.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.TraceMetric.Builder setSubtraces(int i, com.google.firebase.perf.v1.TraceMetric traceMetric2) {
            copyOnWrite();
            TraceMetric.access$1100((TraceMetric)this.instance, i, traceMetric2);
            return this;
        }
    }
    static {
        TraceMetric traceMetric = new TraceMetric();
        TraceMetric.DEFAULT_INSTANCE = traceMetric;
        z.registerDefaultInstance(TraceMetric.class, traceMetric);
    }

    private TraceMetric() {
        super();
        this.counters_ = n0.e();
        this.customAttributes_ = n0.e();
        this.name_ = "";
        this.subtraces_ = z.emptyProtobufList();
        this.perfSessions_ = z.emptyProtobufList();
    }

    static com.google.firebase.perf.v1.TraceMetric access$000() {
        return TraceMetric.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.TraceMetric traceMetric, String string2) {
        traceMetric.setName(string2);
    }

    static Map access$1000(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        return traceMetric.getMutableCountersMap();
    }

    static void access$1100(com.google.firebase.perf.v1.TraceMetric traceMetric, int i2, com.google.firebase.perf.v1.TraceMetric traceMetric3) {
        traceMetric.setSubtraces(i2, traceMetric3);
    }

    static void access$1200(com.google.firebase.perf.v1.TraceMetric traceMetric, com.google.firebase.perf.v1.TraceMetric traceMetric2) {
        traceMetric.addSubtraces(traceMetric2);
    }

    static void access$1300(com.google.firebase.perf.v1.TraceMetric traceMetric, int i2, com.google.firebase.perf.v1.TraceMetric traceMetric3) {
        traceMetric.addSubtraces(i2, traceMetric3);
    }

    static void access$1400(com.google.firebase.perf.v1.TraceMetric traceMetric, Iterable iterable2) {
        traceMetric.addAllSubtraces(iterable2);
    }

    static void access$1500(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.clearSubtraces();
    }

    static void access$1600(com.google.firebase.perf.v1.TraceMetric traceMetric, int i2) {
        traceMetric.removeSubtraces(i2);
    }

    static Map access$1700(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        return traceMetric.getMutableCustomAttributesMap();
    }

    static void access$1800(com.google.firebase.perf.v1.TraceMetric traceMetric, int i2, com.google.firebase.perf.v1.PerfSession perfSession3) {
        traceMetric.setPerfSessions(i2, perfSession3);
    }

    static void access$1900(com.google.firebase.perf.v1.TraceMetric traceMetric, com.google.firebase.perf.v1.PerfSession perfSession2) {
        traceMetric.addPerfSessions(perfSession2);
    }

    static void access$200(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.clearName();
    }

    static void access$2000(com.google.firebase.perf.v1.TraceMetric traceMetric, int i2, com.google.firebase.perf.v1.PerfSession perfSession3) {
        traceMetric.addPerfSessions(i2, perfSession3);
    }

    static void access$2100(com.google.firebase.perf.v1.TraceMetric traceMetric, Iterable iterable2) {
        traceMetric.addAllPerfSessions(iterable2);
    }

    static void access$2200(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.clearPerfSessions();
    }

    static void access$2300(com.google.firebase.perf.v1.TraceMetric traceMetric, int i2) {
        traceMetric.removePerfSessions(i2);
    }

    static void access$300(com.google.firebase.perf.v1.TraceMetric traceMetric, j j2) {
        traceMetric.setNameBytes(j2);
    }

    static void access$400(com.google.firebase.perf.v1.TraceMetric traceMetric, boolean z2) {
        traceMetric.setIsAuto(z2);
    }

    static void access$500(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.clearIsAuto();
    }

    static void access$600(com.google.firebase.perf.v1.TraceMetric traceMetric, long l2) {
        traceMetric.setClientStartTimeUs(l2);
    }

    static void access$700(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.clearClientStartTimeUs();
    }

    static void access$800(com.google.firebase.perf.v1.TraceMetric traceMetric, long l2) {
        traceMetric.setDurationUs(l2);
    }

    static void access$900(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.clearDurationUs();
    }

    private void addAllPerfSessions(Iterable<? extends com.google.firebase.perf.v1.PerfSession> iterable) {
        ensurePerfSessionsIsMutable();
        a.addAll(iterable, this.perfSessions_);
    }

    private void addAllSubtraces(Iterable<? extends com.google.firebase.perf.v1.TraceMetric> iterable) {
        ensureSubtracesIsMutable();
        a.addAll(iterable, this.subtraces_);
    }

    private void addPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
        perfSession2.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(i, perfSession2);
    }

    private void addPerfSessions(com.google.firebase.perf.v1.PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    private void addSubtraces(int i, com.google.firebase.perf.v1.TraceMetric traceMetric2) {
        traceMetric2.getClass();
        ensureSubtracesIsMutable();
        this.subtraces_.add(i, traceMetric2);
    }

    private void addSubtraces(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        traceMetric.getClass();
        ensureSubtracesIsMutable();
        this.subtraces_.add(traceMetric);
    }

    private void clearClientStartTimeUs() {
        this.bitField0_ = bitField0_ &= -5;
        this.clientStartTimeUs_ = 0;
    }

    private void clearDurationUs() {
        this.bitField0_ = bitField0_ &= -9;
        this.durationUs_ = 0;
    }

    private void clearIsAuto() {
        this.bitField0_ = bitField0_ &= -3;
        this.isAuto_ = false;
    }

    private void clearName() {
        this.bitField0_ = bitField0_ &= -2;
        this.name_ = TraceMetric.getDefaultInstance().getName();
    }

    private void clearPerfSessions() {
        this.perfSessions_ = z.emptyProtobufList();
    }

    private void clearSubtraces() {
        this.subtraces_ = z.emptyProtobufList();
    }

    private void ensurePerfSessionsIsMutable() {
        c0.j perfSessions_;
        perfSessions_ = this.perfSessions_;
        if (!perfSessions_.c2()) {
            this.perfSessions_ = z.mutableCopy(perfSessions_);
        }
    }

    private void ensureSubtracesIsMutable() {
        c0.j mutableCopy;
        mutableCopy = this.subtraces_;
        if (!mutableCopy.c2()) {
            this.subtraces_ = z.mutableCopy(mutableCopy);
        }
    }

    public static com.google.firebase.perf.v1.TraceMetric getDefaultInstance() {
        return TraceMetric.DEFAULT_INSTANCE;
    }

    private Map<String, Long> getMutableCountersMap() {
        return internalGetMutableCounters();
    }

    private Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    private n0<String, Long> internalGetCounters() {
        return this.counters_;
    }

    private n0<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private n0<String, Long> internalGetMutableCounters() {
        boolean z;
        if (!this.counters_.j()) {
            this.counters_ = this.counters_.m();
        }
        return this.counters_;
    }

    private n0<String, String> internalGetMutableCustomAttributes() {
        boolean z;
        if (!this.customAttributes_.j()) {
            this.customAttributes_ = this.customAttributes_.m();
        }
        return this.customAttributes_;
    }

    public static com.google.firebase.perf.v1.TraceMetric.Builder newBuilder() {
        return (TraceMetric.Builder)TraceMetric.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.TraceMetric.Builder newBuilder(com.google.firebase.perf.v1.TraceMetric traceMetric) {
        return (TraceMetric.Builder)TraceMetric.DEFAULT_INSTANCE.createBuilder(traceMetric);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseDelimitedFrom(InputStream inputStream) {
        return (TraceMetric)z.parseDelimitedFrom(TraceMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseDelimitedFrom(InputStream inputStream, q q2) {
        return (TraceMetric)z.parseDelimitedFrom(TraceMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(j j) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(j j, q q2) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(k k) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(k k, q q2) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(InputStream inputStream) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(InputStream inputStream, q q2) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(ByteBuffer byteBuffer) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(ByteBuffer byteBuffer, q q2) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(byte[] bArr) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.TraceMetric parseFrom(byte[] bArr, q q2) {
        return (TraceMetric)z.parseFrom(TraceMetric.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.TraceMetric> parser() {
        return TraceMetric.DEFAULT_INSTANCE.getParserForType();
    }

    private void removePerfSessions(int i) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.remove(i);
    }

    private void removeSubtraces(int i) {
        ensureSubtracesIsMutable();
        this.subtraces_.remove(i);
    }

    private void setClientStartTimeUs(long l) {
        this.bitField0_ = bitField0_ |= 4;
        this.clientStartTimeUs_ = l;
    }

    private void setDurationUs(long l) {
        this.bitField0_ = bitField0_ |= 8;
        this.durationUs_ = l;
    }

    private void setIsAuto(boolean z) {
        this.bitField0_ = bitField0_ |= 2;
        this.isAuto_ = z;
    }

    private void setName(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.name_ = string;
    }

    private void setNameBytes(j j) {
        this.name_ = j.R();
        this.bitField0_ = obj1 |= 1;
    }

    private void setPerfSessions(int i, com.google.firebase.perf.v1.PerfSession perfSession2) {
        perfSession2.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.set(i, perfSession2);
    }

    private void setSubtraces(int i, com.google.firebase.perf.v1.TraceMetric traceMetric2) {
        traceMetric2.getClass();
        ensureSubtracesIsMutable();
        this.subtraces_.set(i, traceMetric2);
    }

    @Override // com.google.protobuf.z
    public boolean containsCounters(String string) {
        string.getClass();
        return internalGetCounters().containsKey(string);
    }

    @Override // com.google.protobuf.z
    public boolean containsCustomAttributes(String string) {
        string.getClass();
        return internalGetCustomAttributes().containsKey(string);
    }

    @Override // com.google.protobuf.z
    protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
        d1 obj3;
        int obj5;
        Class<com.google.firebase.perf.v1.TraceMetric> obj4 = TraceMetric.class;
        obj5 = 1;
        int i2 = 0;
        switch (obj3) {
            case 1:
                obj3 = new TraceMetric();
                return obj3;
            case 2:
                obj3 = new TraceMetric.Builder(i2);
                return obj3;
            case 3:
                obj3 = new Object[13];
                obj3[obj5] = "name_";
                obj3[2] = "isAuto_";
                obj3[3] = "clientStartTimeUs_";
                obj3[4] = "durationUs_";
                obj3[5] = "counters_";
                obj3[6] = TraceMetric.CountersDefaultEntryHolder.defaultEntry;
                obj3[7] = "subtraces_";
                obj3[8] = obj4;
                obj3[9] = "customAttributes_";
                obj3[10] = TraceMetric.CustomAttributesDefaultEntryHolder.defaultEntry;
                obj3[11] = "perfSessions_";
                obj3[12] = PerfSession.class;
                return z.newMessageInfo(TraceMetric.DEFAULT_INSTANCE, "\u0001\u0008\u0000\u0001\u0001\t\u0008\u0002\u0002\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u00062\u0007\u001b\u00082\t\u001b", obj3);
            case 4:
                return TraceMetric.DEFAULT_INSTANCE;
            case 5:
                return obj3;
            case 6:
                return Byte.valueOf(obj5);
            case 7:
                return i2;
            default:
                obj3 = new UnsupportedOperationException();
                throw obj3;
        }
        synchronized (obj4) {
            obj3 = new z.b(TraceMetric.DEFAULT_INSTANCE);
            TraceMetric.PARSER = obj3;
        }
    }

    @Override // com.google.protobuf.z
    public long getClientStartTimeUs() {
        return this.clientStartTimeUs_;
    }

    @Deprecated
    public Map<String, Long> getCounters() {
        return getCountersMap();
    }

    @Override // com.google.protobuf.z
    public int getCountersCount() {
        return internalGetCounters().size();
    }

    public Map<String, Long> getCountersMap() {
        return Collections.unmodifiableMap(internalGetCounters());
    }

    @Override // com.google.protobuf.z
    public long getCountersOrDefault(String string, long l2) {
        Object obj3;
        long obj4;
        string.getClass();
        final n0 internalGetCounters = internalGetCounters();
        if (internalGetCounters.containsKey(string)) {
            obj4 = (Long)internalGetCounters.get(string).longValue();
        }
        return obj4;
    }

    @Override // com.google.protobuf.z
    public long getCountersOrThrow(String string) {
        string.getClass();
        n0 internalGetCounters = internalGetCounters();
        if (!internalGetCounters.containsKey(string)) {
        } else {
            return (Long)internalGetCounters.get(string).longValue();
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Deprecated
    public Map<String, String> getCustomAttributes() {
        return getCustomAttributesMap();
    }

    @Override // com.google.protobuf.z
    public int getCustomAttributesCount() {
        return internalGetCustomAttributes().size();
    }

    public Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    @Override // com.google.protobuf.z
    public String getCustomAttributesOrDefault(String string, String string2) {
        Object obj3;
        Object obj4;
        string.getClass();
        final n0 internalGetCustomAttributes = internalGetCustomAttributes();
        if (internalGetCustomAttributes.containsKey(string)) {
            obj4 = obj3;
        }
        return obj4;
    }

    @Override // com.google.protobuf.z
    public String getCustomAttributesOrThrow(String string) {
        string.getClass();
        final n0 internalGetCustomAttributes = internalGetCustomAttributes();
        if (!internalGetCustomAttributes.containsKey(string)) {
        } else {
            return (String)internalGetCustomAttributes.get(string);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException();
        throw obj3;
    }

    @Override // com.google.protobuf.z
    public long getDurationUs() {
        return this.durationUs_;
    }

    @Override // com.google.protobuf.z
    public boolean getIsAuto() {
        return this.isAuto_;
    }

    @Override // com.google.protobuf.z
    public String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.z
    public j getNameBytes() {
        return j.u(this.name_);
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.PerfSession getPerfSessions(int i) {
        return (PerfSession)this.perfSessions_.get(i);
    }

    @Override // com.google.protobuf.z
    public int getPerfSessionsCount() {
        return this.perfSessions_.size();
    }

    public List<com.google.firebase.perf.v1.PerfSession> getPerfSessionsList() {
        return this.perfSessions_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.PerfSessionOrBuilder getPerfSessionsOrBuilder(int i) {
        return (PerfSessionOrBuilder)this.perfSessions_.get(i);
    }

    public List<? extends com.google.firebase.perf.v1.PerfSessionOrBuilder> getPerfSessionsOrBuilderList() {
        return this.perfSessions_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.TraceMetric getSubtraces(int i) {
        return (TraceMetric)this.subtraces_.get(i);
    }

    @Override // com.google.protobuf.z
    public int getSubtracesCount() {
        return this.subtraces_.size();
    }

    public List<com.google.firebase.perf.v1.TraceMetric> getSubtracesList() {
        return this.subtraces_;
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.TraceMetricOrBuilder getSubtracesOrBuilder(int i) {
        return (TraceMetricOrBuilder)this.subtraces_.get(i);
    }

    public List<? extends com.google.firebase.perf.v1.TraceMetricOrBuilder> getSubtracesOrBuilderList() {
        return this.subtraces_;
    }

    @Override // com.google.protobuf.z
    public boolean hasClientStartTimeUs() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasDurationUs() {
        int i;
        i = bitField0_ &= 8 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasIsAuto() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasName() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
