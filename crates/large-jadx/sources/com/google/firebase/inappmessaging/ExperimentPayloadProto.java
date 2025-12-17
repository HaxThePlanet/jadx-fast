package com.google.firebase.inappmessaging;

import com.google.protobuf.a;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class ExperimentPayloadProto {

    public interface ExperimentLiteOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getExperimentId();

        @Override // com.google.protobuf.u0
        public abstract j getExperimentIdBytes();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface ExperimentPayloadOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract String getActivateEventToLog();

        @Override // com.google.protobuf.u0
        public abstract j getActivateEventToLogBytes();

        @Override // com.google.protobuf.u0
        public abstract String getClearEventToLog();

        @Override // com.google.protobuf.u0
        public abstract j getClearEventToLogBytes();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getExperimentId();

        @Override // com.google.protobuf.u0
        public abstract j getExperimentIdBytes();

        @Override // com.google.protobuf.u0
        public abstract long getExperimentStartTimeMillis();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite getOngoingExperiments(int i);

        @Override // com.google.protobuf.u0
        public abstract int getOngoingExperimentsCount();

        public abstract List<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite> getOngoingExperimentsList();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy();

        @Override // com.google.protobuf.u0
        public abstract int getOverflowPolicyValue();

        @Override // com.google.protobuf.u0
        public abstract String getSetEventToLog();

        @Override // com.google.protobuf.u0
        public abstract j getSetEventToLogBytes();

        @Override // com.google.protobuf.u0
        public abstract long getTimeToLiveMillis();

        @Override // com.google.protobuf.u0
        public abstract String getTimeoutEventToLog();

        @Override // com.google.protobuf.u0
        public abstract j getTimeoutEventToLogBytes();

        @Override // com.google.protobuf.u0
        public abstract String getTriggerEvent();

        @Override // com.google.protobuf.u0
        public abstract j getTriggerEventBytes();

        @Override // com.google.protobuf.u0
        public abstract long getTriggerTimeoutMillis();

        @Override // com.google.protobuf.u0
        public abstract String getTtlExpiryEventToLog();

        @Override // com.google.protobuf.u0
        public abstract j getTtlExpiryEventToLogBytes();

        @Override // com.google.protobuf.u0
        public abstract String getVariantId();

        @Override // com.google.protobuf.u0
        public abstract j getVariantIdBytes();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public static final class ExperimentLite extends z<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite.Builder> implements com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLiteOrBuilder {

        private static final com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite DEFAULT_INSTANCE = null;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        private static volatile d1<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite> PARSER;
        private String experimentId_;
        static {
            ExperimentPayloadProto.ExperimentLite experimentLite = new ExperimentPayloadProto.ExperimentLite();
            ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE = experimentLite;
            z.registerDefaultInstance(ExperimentPayloadProto.ExperimentLite.class, experimentLite);
        }

        private ExperimentLite() {
            super();
            this.experimentId_ = "";
        }

        static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite access$000() {
            return ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE;
        }

        static void access$100(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite, String string2) {
            experimentLite.setExperimentId(string2);
        }

        static void access$200(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite) {
            experimentLite.clearExperimentId();
        }

        static void access$300(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite, j j2) {
            experimentLite.setExperimentIdBytes(j2);
        }

        private void clearExperimentId() {
            this.experimentId_ = ExperimentPayloadProto.ExperimentLite.getDefaultInstance().getExperimentId();
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite getDefaultInstance() {
            return ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite.Builder newBuilder() {
            return (ExperimentPayloadProto.ExperimentLite.Builder)ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite.Builder newBuilder(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite) {
            return (ExperimentPayloadProto.ExperimentLite.Builder)ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE.createBuilder(experimentLite);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseDelimitedFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseDelimitedFrom(InputStream inputStream, q q2) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseDelimitedFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(j j) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(j j, q q2) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(k k) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(k k, q q2) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(InputStream inputStream) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(InputStream inputStream, q q2) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(ByteBuffer byteBuffer, q q2) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(byte[] bArr) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite parseFrom(byte[] bArr, q q2) {
            return (ExperimentPayloadProto.ExperimentLite)z.parseFrom(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite> parser() {
            return ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE.getParserForType();
        }

        private void setExperimentId(String string) {
            string.getClass();
            this.experimentId_ = string;
        }

        private void setExperimentIdBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.experimentId_ = j.R();
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj1;
            int obj2;
            int obj3;
            obj2 = 1;
            obj3 = 0;
            switch (obj1) {
                case 1:
                    obj1 = new ExperimentPayloadProto.ExperimentLite();
                    return obj1;
                case 2:
                    obj1 = new ExperimentPayloadProto.ExperimentLite.Builder(obj3);
                    return obj1;
                case 3:
                    obj1 = new Object[obj2];
                    obj1[0] = "experimentId_";
                    return z.newMessageInfo(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", obj1);
                case 4:
                    return ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE;
                case 5:
                    return obj1;
                case 6:
                    return Byte.valueOf(obj2);
                case 7:
                    return obj3;
                default:
                    obj1 = new UnsupportedOperationException();
                    throw obj1;
            }
            obj2 = ExperimentPayloadProto.ExperimentLite.class;
            synchronized (obj2) {
                obj1 = new z.b(ExperimentPayloadProto.ExperimentLite.DEFAULT_INSTANCE);
                ExperimentPayloadProto.ExperimentLite.PARSER = obj1;
            }
        }

        @Override // com.google.protobuf.z
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // com.google.protobuf.z
        public j getExperimentIdBytes() {
            return j.u(this.experimentId_);
        }
    }

    public static final class ExperimentPayload extends z<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.Builder> implements com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayloadOrBuilder {

        public static final int ACTIVATE_EVENT_TO_LOG_FIELD_NUMBER = 8;
        public static final int CLEAR_EVENT_TO_LOG_FIELD_NUMBER = 9;
        private static final com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload DEFAULT_INSTANCE = null;
        public static final int EXPERIMENT_ID_FIELD_NUMBER = 1;
        public static final int EXPERIMENT_START_TIME_MILLIS_FIELD_NUMBER = 3;
        public static final int ONGOING_EXPERIMENTS_FIELD_NUMBER = 13;
        public static final int OVERFLOW_POLICY_FIELD_NUMBER = 12;
        private static volatile d1<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload> PARSER = null;
        public static final int SET_EVENT_TO_LOG_FIELD_NUMBER = 7;
        public static final int TIMEOUT_EVENT_TO_LOG_FIELD_NUMBER = 10;
        public static final int TIME_TO_LIVE_MILLIS_FIELD_NUMBER = 6;
        public static final int TRIGGER_EVENT_FIELD_NUMBER = 4;
        public static final int TRIGGER_TIMEOUT_MILLIS_FIELD_NUMBER = 5;
        public static final int TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER = 11;
        public static final int VARIANT_ID_FIELD_NUMBER = 2;
        private String activateEventToLog_;
        private String clearEventToLog_;
        private String experimentId_;
        private long experimentStartTimeMillis_;
        private c0.j<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite> ongoingExperiments_;
        private int overflowPolicy_;
        private String setEventToLog_;
        private long timeToLiveMillis_;
        private String timeoutEventToLog_;
        private String triggerEvent_;
        private long triggerTimeoutMillis_;
        private String ttlExpiryEventToLog_;
        private String variantId_;
        static {
            ExperimentPayloadProto.ExperimentPayload experimentPayload = new ExperimentPayloadProto.ExperimentPayload();
            ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE = experimentPayload;
            z.registerDefaultInstance(ExperimentPayloadProto.ExperimentPayload.class, experimentPayload);
        }

        private ExperimentPayload() {
            super();
            String str = "";
            this.experimentId_ = str;
            this.variantId_ = str;
            this.triggerEvent_ = str;
            this.setEventToLog_ = str;
            this.activateEventToLog_ = str;
            this.clearEventToLog_ = str;
            this.timeoutEventToLog_ = str;
            this.ttlExpiryEventToLog_ = str;
            this.ongoingExperiments_ = z.emptyProtobufList();
        }

        static void access$1000(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearVariantId();
        }

        static void access$1100(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setVariantIdBytes(j2);
        }

        static void access$1200(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, long l2) {
            experimentPayload.setExperimentStartTimeMillis(l2);
        }

        static void access$1300(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearExperimentStartTimeMillis();
        }

        static void access$1400(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setTriggerEvent(string2);
        }

        static void access$1500(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearTriggerEvent();
        }

        static void access$1600(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setTriggerEventBytes(j2);
        }

        static void access$1700(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, long l2) {
            experimentPayload.setTriggerTimeoutMillis(l2);
        }

        static void access$1800(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearTriggerTimeoutMillis();
        }

        static void access$1900(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, long l2) {
            experimentPayload.setTimeToLiveMillis(l2);
        }

        static void access$2000(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearTimeToLiveMillis();
        }

        static void access$2100(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setSetEventToLog(string2);
        }

        static void access$2200(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearSetEventToLog();
        }

        static void access$2300(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setSetEventToLogBytes(j2);
        }

        static void access$2400(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setActivateEventToLog(string2);
        }

        static void access$2500(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearActivateEventToLog();
        }

        static void access$2600(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setActivateEventToLogBytes(j2);
        }

        static void access$2700(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setClearEventToLog(string2);
        }

        static void access$2800(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearClearEventToLog();
        }

        static void access$2900(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setClearEventToLogBytes(j2);
        }

        static void access$3000(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setTimeoutEventToLog(string2);
        }

        static void access$3100(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearTimeoutEventToLog();
        }

        static void access$3200(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setTimeoutEventToLogBytes(j2);
        }

        static void access$3300(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setTtlExpiryEventToLog(string2);
        }

        static void access$3400(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearTtlExpiryEventToLog();
        }

        static void access$3500(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setTtlExpiryEventToLogBytes(j2);
        }

        static void access$3600(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, int i2) {
            experimentPayload.setOverflowPolicyValue(i2);
        }

        static void access$3700(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy experimentPayloadProto$ExperimentPayload$ExperimentOverflowPolicy2) {
            experimentPayload.setOverflowPolicy(experimentOverflowPolicy2);
        }

        static void access$3800(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearOverflowPolicy();
        }

        static void access$3900(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, int i2, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite3) {
            experimentPayload.setOngoingExperiments(i2, experimentLite3);
        }

        static void access$4000(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite2) {
            experimentPayload.addOngoingExperiments(experimentLite2);
        }

        static void access$4100(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, int i2, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite3) {
            experimentPayload.addOngoingExperiments(i2, experimentLite3);
        }

        static void access$4200(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, Iterable iterable2) {
            experimentPayload.addAllOngoingExperiments(iterable2);
        }

        static void access$4300(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearOngoingExperiments();
        }

        static void access$4400(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, int i2) {
            experimentPayload.removeOngoingExperiments(i2);
        }

        static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload access$500() {
            return ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE;
        }

        static void access$600(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setExperimentId(string2);
        }

        static void access$700(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            experimentPayload.clearExperimentId();
        }

        static void access$800(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, j j2) {
            experimentPayload.setExperimentIdBytes(j2);
        }

        static void access$900(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload, String string2) {
            experimentPayload.setVariantId(string2);
        }

        private void addAllOngoingExperiments(Iterable<? extends com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite> iterable) {
            ensureOngoingExperimentsIsMutable();
            a.addAll(iterable, this.ongoingExperiments_);
        }

        private void addOngoingExperiments(int i, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite2) {
            experimentLite2.getClass();
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(i, experimentLite2);
        }

        private void addOngoingExperiments(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite) {
            experimentLite.getClass();
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.add(experimentLite);
        }

        private void clearActivateEventToLog() {
            this.activateEventToLog_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getActivateEventToLog();
        }

        private void clearClearEventToLog() {
            this.clearEventToLog_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getClearEventToLog();
        }

        private void clearExperimentId() {
            this.experimentId_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getExperimentId();
        }

        private void clearExperimentStartTimeMillis() {
            this.experimentStartTimeMillis_ = 0;
        }

        private void clearOngoingExperiments() {
            this.ongoingExperiments_ = z.emptyProtobufList();
        }

        private void clearOverflowPolicy() {
            this.overflowPolicy_ = 0;
        }

        private void clearSetEventToLog() {
            this.setEventToLog_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getSetEventToLog();
        }

        private void clearTimeToLiveMillis() {
            this.timeToLiveMillis_ = 0;
        }

        private void clearTimeoutEventToLog() {
            this.timeoutEventToLog_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getTimeoutEventToLog();
        }

        private void clearTriggerEvent() {
            this.triggerEvent_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getTriggerEvent();
        }

        private void clearTriggerTimeoutMillis() {
            this.triggerTimeoutMillis_ = 0;
        }

        private void clearTtlExpiryEventToLog() {
            this.ttlExpiryEventToLog_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getTtlExpiryEventToLog();
        }

        private void clearVariantId() {
            this.variantId_ = ExperimentPayloadProto.ExperimentPayload.getDefaultInstance().getVariantId();
        }

        private void ensureOngoingExperimentsIsMutable() {
            c0.j ongoingExperiments_;
            ongoingExperiments_ = this.ongoingExperiments_;
            if (!ongoingExperiments_.c2()) {
                this.ongoingExperiments_ = z.mutableCopy(ongoingExperiments_);
            }
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload getDefaultInstance() {
            return ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.Builder newBuilder() {
            return (ExperimentPayloadProto.ExperimentPayload.Builder)ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.Builder newBuilder(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload experimentPayloadProto$ExperimentPayload) {
            return (ExperimentPayloadProto.ExperimentPayload.Builder)ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE.createBuilder(experimentPayload);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseDelimitedFrom(InputStream inputStream) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseDelimitedFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseDelimitedFrom(InputStream inputStream, q q2) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseDelimitedFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(j j) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(j j, q q2) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(k k) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(k k, q q2) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(InputStream inputStream) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(InputStream inputStream, q q2) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(ByteBuffer byteBuffer) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(ByteBuffer byteBuffer, q q2) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(byte[] bArr) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload parseFrom(byte[] bArr, q q2) {
            return (ExperimentPayloadProto.ExperimentPayload)z.parseFrom(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload> parser() {
            return ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE.getParserForType();
        }

        private void removeOngoingExperiments(int i) {
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.remove(i);
        }

        private void setActivateEventToLog(String string) {
            string.getClass();
            this.activateEventToLog_ = string;
        }

        private void setActivateEventToLogBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.activateEventToLog_ = j.R();
        }

        private void setClearEventToLog(String string) {
            string.getClass();
            this.clearEventToLog_ = string;
        }

        private void setClearEventToLogBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.clearEventToLog_ = j.R();
        }

        private void setExperimentId(String string) {
            string.getClass();
            this.experimentId_ = string;
        }

        private void setExperimentIdBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.experimentId_ = j.R();
        }

        private void setExperimentStartTimeMillis(long l) {
            this.experimentStartTimeMillis_ = l;
        }

        private void setOngoingExperiments(int i, com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite experimentPayloadProto$ExperimentLite2) {
            experimentLite2.getClass();
            ensureOngoingExperimentsIsMutable();
            this.ongoingExperiments_.set(i, experimentLite2);
        }

        private void setOverflowPolicy(com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy experimentPayloadProto$ExperimentPayload$ExperimentOverflowPolicy) {
            this.overflowPolicy_ = experimentOverflowPolicy.getNumber();
        }

        private void setOverflowPolicyValue(int i) {
            this.overflowPolicy_ = i;
        }

        private void setSetEventToLog(String string) {
            string.getClass();
            this.setEventToLog_ = string;
        }

        private void setSetEventToLogBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.setEventToLog_ = j.R();
        }

        private void setTimeToLiveMillis(long l) {
            this.timeToLiveMillis_ = l;
        }

        private void setTimeoutEventToLog(String string) {
            string.getClass();
            this.timeoutEventToLog_ = string;
        }

        private void setTimeoutEventToLogBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.timeoutEventToLog_ = j.R();
        }

        private void setTriggerEvent(String string) {
            string.getClass();
            this.triggerEvent_ = string;
        }

        private void setTriggerEventBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.triggerEvent_ = j.R();
        }

        private void setTriggerTimeoutMillis(long l) {
            this.triggerTimeoutMillis_ = l;
        }

        private void setTtlExpiryEventToLog(String string) {
            string.getClass();
            this.ttlExpiryEventToLog_ = string;
        }

        private void setTtlExpiryEventToLogBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.ttlExpiryEventToLog_ = j.R();
        }

        private void setVariantId(String string) {
            string.getClass();
            this.variantId_ = string;
        }

        private void setVariantIdBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.variantId_ = j.R();
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new ExperimentPayloadProto.ExperimentPayload();
                    return obj2;
                case 2:
                    obj2 = new ExperimentPayloadProto.ExperimentPayload.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[14];
                    obj2[obj3] = "variantId_";
                    obj2[2] = "experimentStartTimeMillis_";
                    obj2[3] = "triggerEvent_";
                    obj2[4] = "triggerTimeoutMillis_";
                    obj2[5] = "timeToLiveMillis_";
                    obj2[6] = "setEventToLog_";
                    obj2[7] = "activateEventToLog_";
                    obj2[8] = "clearEventToLog_";
                    obj2[9] = "timeoutEventToLog_";
                    obj2[10] = "ttlExpiryEventToLog_";
                    obj2[11] = "overflowPolicy_";
                    obj2[12] = "ongoingExperiments_";
                    obj2[13] = ExperimentPayloadProto.ExperimentLite.class;
                    return z.newMessageInfo(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\u0008Ȉ\tȈ\nȈ\u000bȈ\u000c\u000c\r\u001b", obj2);
                case 4:
                    return ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = ExperimentPayloadProto.ExperimentPayload.class;
            synchronized (obj3) {
                obj2 = new z.b(ExperimentPayloadProto.ExperimentPayload.DEFAULT_INSTANCE);
                ExperimentPayloadProto.ExperimentPayload.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public String getActivateEventToLog() {
            return this.activateEventToLog_;
        }

        @Override // com.google.protobuf.z
        public j getActivateEventToLogBytes() {
            return j.u(this.activateEventToLog_);
        }

        @Override // com.google.protobuf.z
        public String getClearEventToLog() {
            return this.clearEventToLog_;
        }

        @Override // com.google.protobuf.z
        public j getClearEventToLogBytes() {
            return j.u(this.clearEventToLog_);
        }

        @Override // com.google.protobuf.z
        public String getExperimentId() {
            return this.experimentId_;
        }

        @Override // com.google.protobuf.z
        public j getExperimentIdBytes() {
            return j.u(this.experimentId_);
        }

        @Override // com.google.protobuf.z
        public long getExperimentStartTimeMillis() {
            return this.experimentStartTimeMillis_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite getOngoingExperiments(int i) {
            return (ExperimentPayloadProto.ExperimentLite)this.ongoingExperiments_.get(i);
        }

        @Override // com.google.protobuf.z
        public int getOngoingExperimentsCount() {
            return this.ongoingExperiments_.size();
        }

        public List<com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLite> getOngoingExperimentsList() {
            return this.ongoingExperiments_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLiteOrBuilder getOngoingExperimentsOrBuilder(int i) {
            return (ExperimentPayloadProto.ExperimentLiteOrBuilder)this.ongoingExperiments_.get(i);
        }

        public List<? extends com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentLiteOrBuilder> getOngoingExperimentsOrBuilderList() {
            return this.ongoingExperiments_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy getOverflowPolicy() {
            com.google.firebase.inappmessaging.ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy uNRECOGNIZED;
            if (ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy.forNumber(this.overflowPolicy_) == null) {
                uNRECOGNIZED = ExperimentPayloadProto.ExperimentPayload.ExperimentOverflowPolicy.UNRECOGNIZED;
            }
            return uNRECOGNIZED;
        }

        @Override // com.google.protobuf.z
        public int getOverflowPolicyValue() {
            return this.overflowPolicy_;
        }

        @Override // com.google.protobuf.z
        public String getSetEventToLog() {
            return this.setEventToLog_;
        }

        @Override // com.google.protobuf.z
        public j getSetEventToLogBytes() {
            return j.u(this.setEventToLog_);
        }

        @Override // com.google.protobuf.z
        public long getTimeToLiveMillis() {
            return this.timeToLiveMillis_;
        }

        @Override // com.google.protobuf.z
        public String getTimeoutEventToLog() {
            return this.timeoutEventToLog_;
        }

        @Override // com.google.protobuf.z
        public j getTimeoutEventToLogBytes() {
            return j.u(this.timeoutEventToLog_);
        }

        @Override // com.google.protobuf.z
        public String getTriggerEvent() {
            return this.triggerEvent_;
        }

        @Override // com.google.protobuf.z
        public j getTriggerEventBytes() {
            return j.u(this.triggerEvent_);
        }

        @Override // com.google.protobuf.z
        public long getTriggerTimeoutMillis() {
            return this.triggerTimeoutMillis_;
        }

        @Override // com.google.protobuf.z
        public String getTtlExpiryEventToLog() {
            return this.ttlExpiryEventToLog_;
        }

        @Override // com.google.protobuf.z
        public j getTtlExpiryEventToLogBytes() {
            return j.u(this.ttlExpiryEventToLog_);
        }

        @Override // com.google.protobuf.z
        public String getVariantId() {
            return this.variantId_;
        }

        @Override // com.google.protobuf.z
        public j getVariantIdBytes() {
            return j.u(this.variantId_);
        }
    }
    static {
    }

    public static void registerAllExtensions(q q) {
    }
}
