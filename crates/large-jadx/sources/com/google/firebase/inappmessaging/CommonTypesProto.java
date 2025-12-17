package com.google.firebase.inappmessaging;

import com.google.protobuf.a;
import com.google.protobuf.c0.c;
import com.google.protobuf.c0.d;
import com.google.protobuf.c0.e;
import com.google.protobuf.c0.j;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import f.c.h.a;
import f.c.h.c;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class CommonTypesProto {

    public static enum CampaignState implements c0.c {

        UNKNOWN_CAMPAIGN_STATE(false),
        DRAFT(true),
        PUBLISHED(2),
        STOPPED(3),
        DELETED(4),
        UNRECOGNIZED(-1);

        private final int value;
        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignState forNumber(int i) {
            if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return CommonTypesProto.CampaignState.DELETED;
                        }
                        return CommonTypesProto.CampaignState.STOPPED;
                    }
                    return CommonTypesProto.CampaignState.PUBLISHED;
                }
                return CommonTypesProto.CampaignState.DRAFT;
            }
            return CommonTypesProto.CampaignState.UNKNOWN_CAMPAIGN_STATE;
        }

        public static c0.d<com.google.firebase.inappmessaging.CommonTypesProto.CampaignState> internalGetValueMap() {
            return CommonTypesProto.CampaignState.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return CommonTypesProto.CampaignState.CampaignStateVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignState valueOf(int i) {
            return CommonTypesProto.CampaignState.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            if (this == CommonTypesProto.CampaignState.UNRECOGNIZED) {
            } else {
                return this.value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
            throw illegalArgumentException;
        }
    }

    public interface CampaignTimeOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract a getDate();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract c getTime();

        @Override // com.google.protobuf.u0
        public abstract String getTimeZone();

        @Override // com.google.protobuf.u0
        public abstract j getTimeZoneBytes();

        @Override // com.google.protobuf.u0
        public abstract boolean hasDate();

        @Override // com.google.protobuf.u0
        public abstract boolean hasTime();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface DailyAnalyticsSummaryOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract int getClicks();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract int getErrors();

        @Override // com.google.protobuf.u0
        public abstract int getImpressions();

        @Override // com.google.protobuf.u0
        public abstract long getStartOfDayMillis();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface DailyConversionSummaryOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract int getConversions();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract long getStartOfDayMillis();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface EventOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract int getCount();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getName();

        @Override // com.google.protobuf.u0
        public abstract j getNameBytes();

        @Override // com.google.protobuf.u0
        public abstract long getPreviousTimestampMillis();

        @Override // com.google.protobuf.u0
        public abstract long getTimestampMillis();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam getTriggerParams(int i);

        @Override // com.google.protobuf.u0
        public abstract int getTriggerParamsCount();

        public abstract List<com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam> getTriggerParamsList();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface ExperimentVariantOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Content getContent();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract int getIndex();

        @Override // com.google.protobuf.u0
        public abstract boolean hasContent();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public static enum ExperimentalCampaignState implements c0.c {

        UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE(false),
        EXPERIMENT_DRAFT(true),
        EXPERIMENT_RUNNING(2),
        EXPERIMENT_STOPPED(3),
        EXPERIMENT_ROLLED_OUT(4),
        UNRECOGNIZED(-1);

        private final int value;
        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentalCampaignState forNumber(int i) {
            if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return null;
                            }
                            return CommonTypesProto.ExperimentalCampaignState.EXPERIMENT_ROLLED_OUT;
                        }
                        return CommonTypesProto.ExperimentalCampaignState.EXPERIMENT_STOPPED;
                    }
                    return CommonTypesProto.ExperimentalCampaignState.EXPERIMENT_RUNNING;
                }
                return CommonTypesProto.ExperimentalCampaignState.EXPERIMENT_DRAFT;
            }
            return CommonTypesProto.ExperimentalCampaignState.UNKNOWN_EXPERIMENTAL_CAMPAIGN_STATE;
        }

        public static c0.d<com.google.firebase.inappmessaging.CommonTypesProto.ExperimentalCampaignState> internalGetValueMap() {
            return CommonTypesProto.ExperimentalCampaignState.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return CommonTypesProto.ExperimentalCampaignState.ExperimentalCampaignStateVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentalCampaignState valueOf(int i) {
            return CommonTypesProto.ExperimentalCampaignState.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            if (this == CommonTypesProto.ExperimentalCampaignState.UNRECOGNIZED) {
            } else {
                return this.value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
            throw illegalArgumentException;
        }
    }

    public interface PriorityOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract int getValue();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface ScionConversionEventOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getName();

        @Override // com.google.protobuf.u0
        public abstract j getNameBytes();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public static enum Trigger implements c0.c {

        UNKNOWN_TRIGGER(false),
        APP_LAUNCH(true),
        ON_FOREGROUND(2),
        UNRECOGNIZED(-1);

        private final int value;
        public static com.google.firebase.inappmessaging.CommonTypesProto.Trigger forNumber(int i) {
            if (i != 0 && i != 1 && i != 2) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return CommonTypesProto.Trigger.ON_FOREGROUND;
                }
                return CommonTypesProto.Trigger.APP_LAUNCH;
            }
            return CommonTypesProto.Trigger.UNKNOWN_TRIGGER;
        }

        public static c0.d<com.google.firebase.inappmessaging.CommonTypesProto.Trigger> internalGetValueMap() {
            return CommonTypesProto.Trigger.internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return CommonTypesProto.Trigger.TriggerVerifier.INSTANCE;
        }

        @Deprecated
        public static com.google.firebase.inappmessaging.CommonTypesProto.Trigger valueOf(int i) {
            return CommonTypesProto.Trigger.forNumber(i);
        }

        @Override // java.lang.Enum
        public final int getNumber() {
            if (this == CommonTypesProto.Trigger.UNRECOGNIZED) {
            } else {
                return this.value;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
            throw illegalArgumentException;
        }
    }

    public interface TriggerParamOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract double getDoubleValue();

        @Override // com.google.protobuf.u0
        public abstract float getFloatValue();

        @Override // com.google.protobuf.u0
        public abstract long getIntValue();

        @Override // com.google.protobuf.u0
        public abstract String getName();

        @Override // com.google.protobuf.u0
        public abstract j getNameBytes();

        @Override // com.google.protobuf.u0
        public abstract String getStringValue();

        @Override // com.google.protobuf.u0
        public abstract j getStringValueBytes();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface TriggeringConditionOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition.ConditionCase getConditionCase();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.CommonTypesProto.Event getEvent();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.CommonTypesProto.Trigger getFiamTrigger();

        @Override // com.google.protobuf.u0
        public abstract int getFiamTriggerValue();

        @Override // com.google.protobuf.u0
        public abstract boolean hasEvent();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public static final class CampaignTime extends z<com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime, com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.CampaignTimeOrBuilder {

        public static final int DATE_FIELD_NUMBER = 1;
        private static final com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime DEFAULT_INSTANCE = null;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime> PARSER = null;
        public static final int TIME_FIELD_NUMBER = 2;
        public static final int TIME_ZONE_FIELD_NUMBER = 3;
        private a date_;
        private String timeZone_;
        private c time_;
        static {
            CommonTypesProto.CampaignTime campaignTime = new CommonTypesProto.CampaignTime();
            CommonTypesProto.CampaignTime.DEFAULT_INSTANCE = campaignTime;
            z.registerDefaultInstance(CommonTypesProto.CampaignTime.class, campaignTime);
        }

        private CampaignTime() {
            super();
            this.timeZone_ = "";
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime access$000() {
            return CommonTypesProto.CampaignTime.DEFAULT_INSTANCE;
        }

        static void access$100(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime, a a2) {
            campaignTime.setDate(a2);
        }

        static void access$200(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime, a a2) {
            campaignTime.mergeDate(a2);
        }

        static void access$300(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime) {
            campaignTime.clearDate();
        }

        static void access$400(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime, c c2) {
            campaignTime.setTime(c2);
        }

        static void access$500(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime, c c2) {
            campaignTime.mergeTime(c2);
        }

        static void access$600(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime) {
            campaignTime.clearTime();
        }

        static void access$700(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime, String string2) {
            campaignTime.setTimeZone(string2);
        }

        static void access$800(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime) {
            campaignTime.clearTimeZone();
        }

        static void access$900(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime, j j2) {
            campaignTime.setTimeZoneBytes(j2);
        }

        private void clearDate() {
            this.date_ = 0;
        }

        private void clearTime() {
            this.time_ = 0;
        }

        private void clearTimeZone() {
            this.timeZone_ = CommonTypesProto.CampaignTime.getDefaultInstance().getTimeZone();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime getDefaultInstance() {
            return CommonTypesProto.CampaignTime.DEFAULT_INSTANCE;
        }

        private void mergeDate(a a) {
            Object date_;
            a aVar;
            z obj3;
            a.getClass();
            date_ = this.date_;
            if (date_ != null && date_ != a.c()) {
                if (date_ != a.c()) {
                    this.date_ = (a)(a.b)a.d(this.date_).mergeFrom(a).buildPartial();
                } else {
                    this.date_ = a;
                }
            } else {
            }
        }

        private void mergeTime(c c) {
            Object time_;
            c cVar;
            z obj3;
            c.getClass();
            time_ = this.time_;
            if (time_ != null && time_ != c.c()) {
                if (time_ != c.c()) {
                    this.time_ = (c)(c.b)c.d(this.time_).mergeFrom(c).buildPartial();
                } else {
                    this.time_ = c;
                }
            } else {
            }
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime.Builder newBuilder() {
            return (CommonTypesProto.CampaignTime.Builder)CommonTypesProto.CampaignTime.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime commonTypesProto$CampaignTime) {
            return (CommonTypesProto.CampaignTime.Builder)CommonTypesProto.CampaignTime.DEFAULT_INSTANCE.createBuilder(campaignTime);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.CampaignTime)z.parseDelimitedFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.CampaignTime)z.parseDelimitedFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(j j) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(j j, q q2) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(k k) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(k k, q q2) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(InputStream inputStream) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(byte[] bArr) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.CampaignTime)z.parseFrom(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.CampaignTime> parser() {
            return CommonTypesProto.CampaignTime.DEFAULT_INSTANCE.getParserForType();
        }

        private void setDate(a a) {
            a.getClass();
            this.date_ = a;
        }

        private void setTime(c c) {
            c.getClass();
            this.time_ = c;
        }

        private void setTimeZone(String string) {
            string.getClass();
            this.timeZone_ = string;
        }

        private void setTimeZoneBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.timeZone_ = j.R();
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
                    obj2 = new CommonTypesProto.CampaignTime();
                    return obj2;
                case 2:
                    obj2 = new CommonTypesProto.CampaignTime.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[3];
                    obj2[obj3] = "time_";
                    obj2[2] = "timeZone_";
                    return z.newMessageInfo(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ", obj2);
                case 4:
                    return CommonTypesProto.CampaignTime.DEFAULT_INSTANCE;
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
            obj3 = CommonTypesProto.CampaignTime.class;
            synchronized (obj3) {
                obj2 = new z.b(CommonTypesProto.CampaignTime.DEFAULT_INSTANCE);
                CommonTypesProto.CampaignTime.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public a getDate() {
            a date_;
            if (this.date_ == null) {
                date_ = a.c();
            }
            return date_;
        }

        @Override // com.google.protobuf.z
        public c getTime() {
            c time_;
            if (this.time_ == null) {
                time_ = c.c();
            }
            return time_;
        }

        @Override // com.google.protobuf.z
        public String getTimeZone() {
            return this.timeZone_;
        }

        @Override // com.google.protobuf.z
        public j getTimeZoneBytes() {
            return j.u(this.timeZone_);
        }

        @Override // com.google.protobuf.z
        public boolean hasDate() {
            int i;
            i = this.date_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasTime() {
            int i;
            i = this.time_ != null ? 1 : 0;
            return i;
        }
    }

    public static final class DailyAnalyticsSummary extends z<com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary, com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummaryOrBuilder {

        public static final int CLICKS_FIELD_NUMBER = 3;
        private static final com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary DEFAULT_INSTANCE = null;
        public static final int ERRORS_FIELD_NUMBER = 4;
        public static final int IMPRESSIONS_FIELD_NUMBER = 2;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int clicks_;
        private int errors_;
        private int impressions_;
        private long startOfDayMillis_;
        static {
            CommonTypesProto.DailyAnalyticsSummary dailyAnalyticsSummary = new CommonTypesProto.DailyAnalyticsSummary();
            CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE = dailyAnalyticsSummary;
            z.registerDefaultInstance(CommonTypesProto.DailyAnalyticsSummary.class, dailyAnalyticsSummary);
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary access$6700() {
            return CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE;
        }

        static void access$6800(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary, long l2) {
            dailyAnalyticsSummary.setStartOfDayMillis(l2);
        }

        static void access$6900(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary) {
            dailyAnalyticsSummary.clearStartOfDayMillis();
        }

        static void access$7000(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary, int i2) {
            dailyAnalyticsSummary.setImpressions(i2);
        }

        static void access$7100(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary) {
            dailyAnalyticsSummary.clearImpressions();
        }

        static void access$7200(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary, int i2) {
            dailyAnalyticsSummary.setClicks(i2);
        }

        static void access$7300(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary) {
            dailyAnalyticsSummary.clearClicks();
        }

        static void access$7400(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary, int i2) {
            dailyAnalyticsSummary.setErrors(i2);
        }

        static void access$7500(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary) {
            dailyAnalyticsSummary.clearErrors();
        }

        private void clearClicks() {
            this.clicks_ = 0;
        }

        private void clearErrors() {
            this.errors_ = 0;
        }

        private void clearImpressions() {
            this.impressions_ = 0;
        }

        private void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary getDefaultInstance() {
            return CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary.Builder newBuilder() {
            return (CommonTypesProto.DailyAnalyticsSummary.Builder)CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary commonTypesProto$DailyAnalyticsSummary) {
            return (CommonTypesProto.DailyAnalyticsSummary.Builder)CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE.createBuilder(dailyAnalyticsSummary);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseDelimitedFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseDelimitedFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(j j) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(j j, q q2) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(k k) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(k k, q q2) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(InputStream inputStream) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(byte[] bArr) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.DailyAnalyticsSummary)z.parseFrom(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.DailyAnalyticsSummary> parser() {
            return CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE.getParserForType();
        }

        private void setClicks(int i) {
            this.clicks_ = i;
        }

        private void setErrors(int i) {
            this.errors_ = i;
        }

        private void setImpressions(int i) {
            this.impressions_ = i;
        }

        private void setStartOfDayMillis(long l) {
            this.startOfDayMillis_ = l;
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
                    obj2 = new CommonTypesProto.DailyAnalyticsSummary();
                    return obj2;
                case 2:
                    obj2 = new CommonTypesProto.DailyAnalyticsSummary.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[4];
                    obj2[obj3] = "impressions_";
                    obj2[2] = "clicks_";
                    obj2[3] = "errors_";
                    return z.newMessageInfo(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0002\u0002\u0004\u0003\u0004\u0004\u0004", obj2);
                case 4:
                    return CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE;
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
            obj3 = CommonTypesProto.DailyAnalyticsSummary.class;
            synchronized (obj3) {
                obj2 = new z.b(CommonTypesProto.DailyAnalyticsSummary.DEFAULT_INSTANCE);
                CommonTypesProto.DailyAnalyticsSummary.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public int getClicks() {
            return this.clicks_;
        }

        @Override // com.google.protobuf.z
        public int getErrors() {
            return this.errors_;
        }

        @Override // com.google.protobuf.z
        public int getImpressions() {
            return this.impressions_;
        }

        @Override // com.google.protobuf.z
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }
    }

    public static final class DailyConversionSummary extends z<com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary, com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummaryOrBuilder {

        public static final int CONVERSIONS_FIELD_NUMBER = 2;
        private static final com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary DEFAULT_INSTANCE = null;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary> PARSER = null;
        public static final int START_OF_DAY_MILLIS_FIELD_NUMBER = 1;
        private int conversions_;
        private long startOfDayMillis_;
        static {
            CommonTypesProto.DailyConversionSummary dailyConversionSummary = new CommonTypesProto.DailyConversionSummary();
            CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE = dailyConversionSummary;
            z.registerDefaultInstance(CommonTypesProto.DailyConversionSummary.class, dailyConversionSummary);
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary access$7700() {
            return CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE;
        }

        static void access$7800(com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary commonTypesProto$DailyConversionSummary, long l2) {
            dailyConversionSummary.setStartOfDayMillis(l2);
        }

        static void access$7900(com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary commonTypesProto$DailyConversionSummary) {
            dailyConversionSummary.clearStartOfDayMillis();
        }

        static void access$8000(com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary commonTypesProto$DailyConversionSummary, int i2) {
            dailyConversionSummary.setConversions(i2);
        }

        static void access$8100(com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary commonTypesProto$DailyConversionSummary) {
            dailyConversionSummary.clearConversions();
        }

        private void clearConversions() {
            this.conversions_ = 0;
        }

        private void clearStartOfDayMillis() {
            this.startOfDayMillis_ = 0;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary getDefaultInstance() {
            return CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary.Builder newBuilder() {
            return (CommonTypesProto.DailyConversionSummary.Builder)CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary commonTypesProto$DailyConversionSummary) {
            return (CommonTypesProto.DailyConversionSummary.Builder)CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE.createBuilder(dailyConversionSummary);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.DailyConversionSummary)z.parseDelimitedFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.DailyConversionSummary)z.parseDelimitedFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(j j) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(j j, q q2) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(k k) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(k k, q q2) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(InputStream inputStream) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(byte[] bArr) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.DailyConversionSummary)z.parseFrom(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.DailyConversionSummary> parser() {
            return CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE.getParserForType();
        }

        private void setConversions(int i) {
            this.conversions_ = i;
        }

        private void setStartOfDayMillis(long l) {
            this.startOfDayMillis_ = l;
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
                    obj2 = new CommonTypesProto.DailyConversionSummary();
                    return obj2;
                case 2:
                    obj2 = new CommonTypesProto.DailyConversionSummary.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "conversions_";
                    return z.newMessageInfo(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", obj2);
                case 4:
                    return CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE;
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
            obj3 = CommonTypesProto.DailyConversionSummary.class;
            synchronized (obj3) {
                obj2 = new z.b(CommonTypesProto.DailyConversionSummary.DEFAULT_INSTANCE);
                CommonTypesProto.DailyConversionSummary.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public int getConversions() {
            return this.conversions_;
        }

        @Override // com.google.protobuf.z
        public long getStartOfDayMillis() {
            return this.startOfDayMillis_;
        }
    }

    public static final class Event extends z<com.google.firebase.inappmessaging.CommonTypesProto.Event, com.google.firebase.inappmessaging.CommonTypesProto.Event.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.EventOrBuilder {

        public static final int COUNT_FIELD_NUMBER = 5;
        private static final com.google.firebase.inappmessaging.CommonTypesProto.Event DEFAULT_INSTANCE = null;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.Event> PARSER = null;
        public static final int PREVIOUS_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
        public static final int TIMESTAMP_MILLIS_FIELD_NUMBER = 3;
        public static final int TRIGGER_PARAMS_FIELD_NUMBER = 1;
        private int count_;
        private String name_;
        private long previousTimestampMillis_;
        private long timestampMillis_;
        private c0.j<com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam> triggerParams_;
        static {
            CommonTypesProto.Event event = new CommonTypesProto.Event();
            CommonTypesProto.Event.DEFAULT_INSTANCE = event;
            z.registerDefaultInstance(CommonTypesProto.Event.class, event);
        }

        private Event() {
            super();
            this.triggerParams_ = z.emptyProtobufList();
            this.name_ = "";
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.Event access$2000() {
            return CommonTypesProto.Event.DEFAULT_INSTANCE;
        }

        static void access$2100(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, int i2, com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam3) {
            event.setTriggerParams(i2, triggerParam3);
        }

        static void access$2200(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam2) {
            event.addTriggerParams(triggerParam2);
        }

        static void access$2300(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, int i2, com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam3) {
            event.addTriggerParams(i2, triggerParam3);
        }

        static void access$2400(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, Iterable iterable2) {
            event.addAllTriggerParams(iterable2);
        }

        static void access$2500(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            event.clearTriggerParams();
        }

        static void access$2600(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, int i2) {
            event.removeTriggerParams(i2);
        }

        static void access$2700(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, String string2) {
            event.setName(string2);
        }

        static void access$2800(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            event.clearName();
        }

        static void access$2900(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, j j2) {
            event.setNameBytes(j2);
        }

        static void access$3000(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, long l2) {
            event.setTimestampMillis(l2);
        }

        static void access$3100(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            event.clearTimestampMillis();
        }

        static void access$3200(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, long l2) {
            event.setPreviousTimestampMillis(l2);
        }

        static void access$3300(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            event.clearPreviousTimestampMillis();
        }

        static void access$3400(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event, int i2) {
            event.setCount(i2);
        }

        static void access$3500(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            event.clearCount();
        }

        private void addAllTriggerParams(Iterable<? extends com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam> iterable) {
            ensureTriggerParamsIsMutable();
            a.addAll(iterable, this.triggerParams_);
        }

        private void addTriggerParams(int i, com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam2) {
            triggerParam2.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(i, triggerParam2);
        }

        private void addTriggerParams(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam) {
            triggerParam.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.add(triggerParam);
        }

        private void clearCount() {
            this.count_ = 0;
        }

        private void clearName() {
            this.name_ = CommonTypesProto.Event.getDefaultInstance().getName();
        }

        private void clearPreviousTimestampMillis() {
            this.previousTimestampMillis_ = 0;
        }

        private void clearTimestampMillis() {
            this.timestampMillis_ = 0;
        }

        private void clearTriggerParams() {
            this.triggerParams_ = z.emptyProtobufList();
        }

        private void ensureTriggerParamsIsMutable() {
            c0.j triggerParams_;
            triggerParams_ = this.triggerParams_;
            if (!triggerParams_.c2()) {
                this.triggerParams_ = z.mutableCopy(triggerParams_);
            }
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event getDefaultInstance() {
            return CommonTypesProto.Event.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event.Builder newBuilder() {
            return (CommonTypesProto.Event.Builder)CommonTypesProto.Event.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            return (CommonTypesProto.Event.Builder)CommonTypesProto.Event.DEFAULT_INSTANCE.createBuilder(event);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.Event)z.parseDelimitedFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.Event)z.parseDelimitedFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(j j) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(j j, q q2) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(k k) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(k k, q q2) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(InputStream inputStream) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(byte[] bArr) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Event parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.Event)z.parseFrom(CommonTypesProto.Event.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.Event> parser() {
            return CommonTypesProto.Event.DEFAULT_INSTANCE.getParserForType();
        }

        private void removeTriggerParams(int i) {
            ensureTriggerParamsIsMutable();
            this.triggerParams_.remove(i);
        }

        private void setCount(int i) {
            this.count_ = i;
        }

        private void setName(String string) {
            string.getClass();
            this.name_ = string;
        }

        private void setNameBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.name_ = j.R();
        }

        private void setPreviousTimestampMillis(long l) {
            this.previousTimestampMillis_ = l;
        }

        private void setTimestampMillis(long l) {
            this.timestampMillis_ = l;
        }

        private void setTriggerParams(int i, com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam2) {
            triggerParam2.getClass();
            ensureTriggerParamsIsMutable();
            this.triggerParams_.set(i, triggerParam2);
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
                    obj2 = new CommonTypesProto.Event();
                    return obj2;
                case 2:
                    obj2 = new CommonTypesProto.Event.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[6];
                    obj2[obj3] = CommonTypesProto.TriggerParam.class;
                    obj2[2] = "name_";
                    obj2[3] = "timestampMillis_";
                    obj2[4] = "previousTimestampMillis_";
                    obj2[5] = "count_";
                    return z.newMessageInfo(CommonTypesProto.Event.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002Ȉ\u0003\u0002\u0004\u0002\u0005\u0004", obj2);
                case 4:
                    return CommonTypesProto.Event.DEFAULT_INSTANCE;
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
            obj3 = CommonTypesProto.Event.class;
            synchronized (obj3) {
                obj2 = new z.b(CommonTypesProto.Event.DEFAULT_INSTANCE);
                CommonTypesProto.Event.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public int getCount() {
            return this.count_;
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
        public long getPreviousTimestampMillis() {
            return this.previousTimestampMillis_;
        }

        @Override // com.google.protobuf.z
        public long getTimestampMillis() {
            return this.timestampMillis_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam getTriggerParams(int i) {
            return (CommonTypesProto.TriggerParam)this.triggerParams_.get(i);
        }

        @Override // com.google.protobuf.z
        public int getTriggerParamsCount() {
            return this.triggerParams_.size();
        }

        public List<com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam> getTriggerParamsList() {
            return this.triggerParams_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder getTriggerParamsOrBuilder(int i) {
            return (CommonTypesProto.TriggerParamOrBuilder)this.triggerParams_.get(i);
        }

        public List<? extends com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder> getTriggerParamsOrBuilderList() {
            return this.triggerParams_;
        }
    }

    public static final class ExperimentVariant extends z<com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant, com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariantOrBuilder {

        public static final int CONTENT_FIELD_NUMBER = 2;
        private static final com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant DEFAULT_INSTANCE = null;
        public static final int INDEX_FIELD_NUMBER = 1;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant> PARSER;
        private com.google.firebase.inappmessaging.MessagesProto.Content content_;
        private int index_;
        static {
            CommonTypesProto.ExperimentVariant experimentVariant = new CommonTypesProto.ExperimentVariant();
            CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE = experimentVariant;
            z.registerDefaultInstance(CommonTypesProto.ExperimentVariant.class, experimentVariant);
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant access$6000() {
            return CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE;
        }

        static void access$6100(com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant commonTypesProto$ExperimentVariant, int i2) {
            experimentVariant.setIndex(i2);
        }

        static void access$6200(com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant commonTypesProto$ExperimentVariant) {
            experimentVariant.clearIndex();
        }

        static void access$6300(com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant commonTypesProto$ExperimentVariant, com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content2) {
            experimentVariant.setContent(content2);
        }

        static void access$6400(com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant commonTypesProto$ExperimentVariant, com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content2) {
            experimentVariant.mergeContent(content2);
        }

        static void access$6500(com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant commonTypesProto$ExperimentVariant) {
            experimentVariant.clearContent();
        }

        private void clearContent() {
            this.content_ = 0;
        }

        private void clearIndex() {
            this.index_ = 0;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant getDefaultInstance() {
            return CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE;
        }

        private void mergeContent(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            Object content_;
            com.google.firebase.inappmessaging.MessagesProto.Content defaultInstance;
            z obj3;
            content.getClass();
            content_ = this.content_;
            if (content_ != null && content_ != MessagesProto.Content.getDefaultInstance()) {
                if (content_ != MessagesProto.Content.getDefaultInstance()) {
                    this.content_ = (MessagesProto.Content)(MessagesProto.Content.Builder)MessagesProto.Content.newBuilder(this.content_).mergeFrom(content).buildPartial();
                } else {
                    this.content_ = content;
                }
            } else {
            }
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant.Builder newBuilder() {
            return (CommonTypesProto.ExperimentVariant.Builder)CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant commonTypesProto$ExperimentVariant) {
            return (CommonTypesProto.ExperimentVariant.Builder)CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE.createBuilder(experimentVariant);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.ExperimentVariant)z.parseDelimitedFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.ExperimentVariant)z.parseDelimitedFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(j j) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(j j, q q2) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(k k) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(k k, q q2) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(InputStream inputStream) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(byte[] bArr) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.ExperimentVariant)z.parseFrom(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.ExperimentVariant> parser() {
            return CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE.getParserForType();
        }

        private void setContent(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            content.getClass();
            this.content_ = content;
        }

        private void setIndex(int i) {
            this.index_ = i;
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
                    obj2 = new CommonTypesProto.ExperimentVariant();
                    return obj2;
                case 2:
                    obj2 = new CommonTypesProto.ExperimentVariant.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "content_";
                    return z.newMessageInfo(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\t", obj2);
                case 4:
                    return CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE;
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
            obj3 = CommonTypesProto.ExperimentVariant.class;
            synchronized (obj3) {
                obj2 = new z.b(CommonTypesProto.ExperimentVariant.DEFAULT_INSTANCE);
                CommonTypesProto.ExperimentVariant.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Content getContent() {
            com.google.firebase.inappmessaging.MessagesProto.Content defaultInstance;
            if (this.content_ == null) {
                defaultInstance = MessagesProto.Content.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public int getIndex() {
            return this.index_;
        }

        @Override // com.google.protobuf.z
        public boolean hasContent() {
            int i;
            i = this.content_ != null ? 1 : 0;
            return i;
        }
    }

    public static final class Priority extends z<com.google.firebase.inappmessaging.CommonTypesProto.Priority, com.google.firebase.inappmessaging.CommonTypesProto.Priority.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.PriorityOrBuilder {

        private static final com.google.firebase.inappmessaging.CommonTypesProto.Priority DEFAULT_INSTANCE = null;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.Priority> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 1;
        private int value_;
        static {
            CommonTypesProto.Priority priority = new CommonTypesProto.Priority();
            CommonTypesProto.Priority.DEFAULT_INSTANCE = priority;
            z.registerDefaultInstance(CommonTypesProto.Priority.class, priority);
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.Priority access$5100() {
            return CommonTypesProto.Priority.DEFAULT_INSTANCE;
        }

        static void access$5200(com.google.firebase.inappmessaging.CommonTypesProto.Priority commonTypesProto$Priority, int i2) {
            priority.setValue(i2);
        }

        static void access$5300(com.google.firebase.inappmessaging.CommonTypesProto.Priority commonTypesProto$Priority) {
            priority.clearValue();
        }

        private void clearValue() {
            this.value_ = 0;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority getDefaultInstance() {
            return CommonTypesProto.Priority.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority.Builder newBuilder() {
            return (CommonTypesProto.Priority.Builder)CommonTypesProto.Priority.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.Priority commonTypesProto$Priority) {
            return (CommonTypesProto.Priority.Builder)CommonTypesProto.Priority.DEFAULT_INSTANCE.createBuilder(priority);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.Priority)z.parseDelimitedFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.Priority)z.parseDelimitedFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(j j) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(j j, q q2) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(k k) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(k k, q q2) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(InputStream inputStream) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(byte[] bArr) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.Priority parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.Priority)z.parseFrom(CommonTypesProto.Priority.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.Priority> parser() {
            return CommonTypesProto.Priority.DEFAULT_INSTANCE.getParserForType();
        }

        private void setValue(int i) {
            this.value_ = i;
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
                    obj1 = new CommonTypesProto.Priority();
                    return obj1;
                case 2:
                    obj1 = new CommonTypesProto.Priority.Builder(obj3);
                    return obj1;
                case 3:
                    obj1 = new Object[obj2];
                    obj1[0] = "value_";
                    return z.newMessageInfo(CommonTypesProto.Priority.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", obj1);
                case 4:
                    return CommonTypesProto.Priority.DEFAULT_INSTANCE;
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
            obj2 = CommonTypesProto.Priority.class;
            synchronized (obj2) {
                obj1 = new z.b(CommonTypesProto.Priority.DEFAULT_INSTANCE);
                CommonTypesProto.Priority.PARSER = obj1;
            }
        }

        @Override // com.google.protobuf.z
        public int getValue() {
            return this.value_;
        }
    }

    public static final class ScionConversionEvent extends z<com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent, com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEventOrBuilder {

        private static final com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent DEFAULT_INSTANCE = null;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent> PARSER;
        private String name_;
        static {
            CommonTypesProto.ScionConversionEvent scionConversionEvent = new CommonTypesProto.ScionConversionEvent();
            CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE = scionConversionEvent;
            z.registerDefaultInstance(CommonTypesProto.ScionConversionEvent.class, scionConversionEvent);
        }

        private ScionConversionEvent() {
            super();
            this.name_ = "";
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent access$5500() {
            return CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE;
        }

        static void access$5600(com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent commonTypesProto$ScionConversionEvent, String string2) {
            scionConversionEvent.setName(string2);
        }

        static void access$5700(com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent commonTypesProto$ScionConversionEvent) {
            scionConversionEvent.clearName();
        }

        static void access$5800(com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent commonTypesProto$ScionConversionEvent, j j2) {
            scionConversionEvent.setNameBytes(j2);
        }

        private void clearName() {
            this.name_ = CommonTypesProto.ScionConversionEvent.getDefaultInstance().getName();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent getDefaultInstance() {
            return CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent.Builder newBuilder() {
            return (CommonTypesProto.ScionConversionEvent.Builder)CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent commonTypesProto$ScionConversionEvent) {
            return (CommonTypesProto.ScionConversionEvent.Builder)CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE.createBuilder(scionConversionEvent);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.ScionConversionEvent)z.parseDelimitedFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.ScionConversionEvent)z.parseDelimitedFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(j j) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(j j, q q2) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(k k) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(k k, q q2) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(InputStream inputStream) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(byte[] bArr) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.ScionConversionEvent)z.parseFrom(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.ScionConversionEvent> parser() {
            return CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE.getParserForType();
        }

        private void setName(String string) {
            string.getClass();
            this.name_ = string;
        }

        private void setNameBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.name_ = j.R();
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
                    obj1 = new CommonTypesProto.ScionConversionEvent();
                    return obj1;
                case 2:
                    obj1 = new CommonTypesProto.ScionConversionEvent.Builder(obj3);
                    return obj1;
                case 3:
                    obj1 = new Object[obj2];
                    obj1[0] = "name_";
                    return z.newMessageInfo(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", obj1);
                case 4:
                    return CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE;
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
            obj2 = CommonTypesProto.ScionConversionEvent.class;
            synchronized (obj2) {
                obj1 = new z.b(CommonTypesProto.ScionConversionEvent.DEFAULT_INSTANCE);
                CommonTypesProto.ScionConversionEvent.PARSER = obj1;
            }
        }

        @Override // com.google.protobuf.z
        public String getName() {
            return this.name_;
        }

        @Override // com.google.protobuf.z
        public j getNameBytes() {
            return j.u(this.name_);
        }
    }

    public static final class TriggerParam extends z<com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam, com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.TriggerParamOrBuilder {

        private static final com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam DEFAULT_INSTANCE = null;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 5;
        public static final int FLOAT_VALUE_FIELD_NUMBER = 4;
        public static final int INT_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam> PARSER = null;
        public static final int STRING_VALUE_FIELD_NUMBER = 2;
        private double doubleValue_;
        private float floatValue_;
        private long intValue_;
        private String name_;
        private String stringValue_;
        static {
            CommonTypesProto.TriggerParam triggerParam = new CommonTypesProto.TriggerParam();
            CommonTypesProto.TriggerParam.DEFAULT_INSTANCE = triggerParam;
            z.registerDefaultInstance(CommonTypesProto.TriggerParam.class, triggerParam);
        }

        private TriggerParam() {
            super();
            final String str = "";
            this.name_ = str;
            this.stringValue_ = str;
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam access$3700() {
            return CommonTypesProto.TriggerParam.DEFAULT_INSTANCE;
        }

        static void access$3800(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam, String string2) {
            triggerParam.setName(string2);
        }

        static void access$3900(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam) {
            triggerParam.clearName();
        }

        static void access$4000(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam, j j2) {
            triggerParam.setNameBytes(j2);
        }

        static void access$4100(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam, String string2) {
            triggerParam.setStringValue(string2);
        }

        static void access$4200(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam) {
            triggerParam.clearStringValue();
        }

        static void access$4300(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam, j j2) {
            triggerParam.setStringValueBytes(j2);
        }

        static void access$4400(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam, long l2) {
            triggerParam.setIntValue(l2);
        }

        static void access$4500(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam) {
            triggerParam.clearIntValue();
        }

        static void access$4600(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam, float f2) {
            triggerParam.setFloatValue(f2);
        }

        static void access$4700(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam) {
            triggerParam.clearFloatValue();
        }

        static void access$4800(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam, double d2) {
            triggerParam.setDoubleValue(d2);
        }

        static void access$4900(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam) {
            triggerParam.clearDoubleValue();
        }

        private void clearDoubleValue() {
            this.doubleValue_ = 0;
        }

        private void clearFloatValue() {
            this.floatValue_ = 0;
        }

        private void clearIntValue() {
            this.intValue_ = 0;
        }

        private void clearName() {
            this.name_ = CommonTypesProto.TriggerParam.getDefaultInstance().getName();
        }

        private void clearStringValue() {
            this.stringValue_ = CommonTypesProto.TriggerParam.getDefaultInstance().getStringValue();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam getDefaultInstance() {
            return CommonTypesProto.TriggerParam.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam.Builder newBuilder() {
            return (CommonTypesProto.TriggerParam.Builder)CommonTypesProto.TriggerParam.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam commonTypesProto$TriggerParam) {
            return (CommonTypesProto.TriggerParam.Builder)CommonTypesProto.TriggerParam.DEFAULT_INSTANCE.createBuilder(triggerParam);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.TriggerParam)z.parseDelimitedFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.TriggerParam)z.parseDelimitedFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(j j) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(j j, q q2) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(k k) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(k k, q q2) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(InputStream inputStream) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(byte[] bArr) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.TriggerParam)z.parseFrom(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.TriggerParam> parser() {
            return CommonTypesProto.TriggerParam.DEFAULT_INSTANCE.getParserForType();
        }

        private void setDoubleValue(double d) {
            this.doubleValue_ = d;
        }

        private void setFloatValue(float f) {
            this.floatValue_ = f;
        }

        private void setIntValue(long l) {
            this.intValue_ = l;
        }

        private void setName(String string) {
            string.getClass();
            this.name_ = string;
        }

        private void setNameBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.name_ = j.R();
        }

        private void setStringValue(String string) {
            string.getClass();
            this.stringValue_ = string;
        }

        private void setStringValueBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.stringValue_ = j.R();
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
                    obj2 = new CommonTypesProto.TriggerParam();
                    return obj2;
                case 2:
                    obj2 = new CommonTypesProto.TriggerParam.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[5];
                    obj2[obj3] = "stringValue_";
                    obj2[2] = "intValue_";
                    obj2[3] = "floatValue_";
                    obj2[4] = "doubleValue_";
                    return z.newMessageInfo(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0001\u0005\u0000", obj2);
                case 4:
                    return CommonTypesProto.TriggerParam.DEFAULT_INSTANCE;
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
            obj3 = CommonTypesProto.TriggerParam.class;
            synchronized (obj3) {
                obj2 = new z.b(CommonTypesProto.TriggerParam.DEFAULT_INSTANCE);
                CommonTypesProto.TriggerParam.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        @Override // com.google.protobuf.z
        public float getFloatValue() {
            return this.floatValue_;
        }

        @Override // com.google.protobuf.z
        public long getIntValue() {
            return this.intValue_;
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
        public String getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.protobuf.z
        public j getStringValueBytes() {
            return j.u(this.stringValue_);
        }
    }

    public static final class TriggeringCondition extends z<com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition, com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition.Builder> implements com.google.firebase.inappmessaging.CommonTypesProto.TriggeringConditionOrBuilder {

        private static final com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition DEFAULT_INSTANCE = null;
        public static final int EVENT_FIELD_NUMBER = 2;
        public static final int FIAM_TRIGGER_FIELD_NUMBER = 1;
        private static volatile d1<com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition> PARSER;
        private int conditionCase_ = 0;
        private Object condition_;
        static {
            CommonTypesProto.TriggeringCondition triggeringCondition = new CommonTypesProto.TriggeringCondition();
            CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE = triggeringCondition;
            z.registerDefaultInstance(CommonTypesProto.TriggeringCondition.class, triggeringCondition);
        }

        private TriggeringCondition() {
            super();
            final int i = 0;
        }

        static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition access$1100() {
            return CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE;
        }

        static void access$1200(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition) {
            triggeringCondition.clearCondition();
        }

        static void access$1300(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition, int i2) {
            triggeringCondition.setFiamTriggerValue(i2);
        }

        static void access$1400(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition, com.google.firebase.inappmessaging.CommonTypesProto.Trigger commonTypesProto$Trigger2) {
            triggeringCondition.setFiamTrigger(trigger2);
        }

        static void access$1500(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition) {
            triggeringCondition.clearFiamTrigger();
        }

        static void access$1600(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition, com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event2) {
            triggeringCondition.setEvent(event2);
        }

        static void access$1700(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition, com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event2) {
            triggeringCondition.mergeEvent(event2);
        }

        static void access$1800(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition) {
            triggeringCondition.clearEvent();
        }

        private void clearCondition() {
            this.conditionCase_ = 0;
            this.condition_ = 0;
        }

        private void clearEvent() {
            int conditionCase_;
            if (this.conditionCase_ == 2) {
                this.conditionCase_ = 0;
                this.condition_ = 0;
            }
        }

        private void clearFiamTrigger() {
            int conditionCase_;
            if (this.conditionCase_ == 1) {
                this.conditionCase_ = 0;
                this.condition_ = 0;
            }
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition getDefaultInstance() {
            return CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE;
        }

        private void mergeEvent(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            int conditionCase_;
            com.google.firebase.inappmessaging.CommonTypesProto.Event defaultInstance;
            z obj4;
            event.getClass();
            final int i = 2;
            if (this.conditionCase_ == i && this.condition_ != CommonTypesProto.Event.getDefaultInstance()) {
                if (this.condition_ != CommonTypesProto.Event.getDefaultInstance()) {
                    this.condition_ = (CommonTypesProto.Event.Builder)CommonTypesProto.Event.newBuilder((CommonTypesProto.Event)this.condition_).mergeFrom(event).buildPartial();
                } else {
                    this.condition_ = event;
                }
            } else {
            }
            this.conditionCase_ = i;
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition.Builder newBuilder() {
            return (CommonTypesProto.TriggeringCondition.Builder)CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition.Builder newBuilder(com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition commonTypesProto$TriggeringCondition) {
            return (CommonTypesProto.TriggeringCondition.Builder)CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE.createBuilder(triggeringCondition);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseDelimitedFrom(InputStream inputStream) {
            return (CommonTypesProto.TriggeringCondition)z.parseDelimitedFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseDelimitedFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.TriggeringCondition)z.parseDelimitedFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(j j) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(j j, q q2) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(k k) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(k k, q q2) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(InputStream inputStream) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(InputStream inputStream, q q2) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(ByteBuffer byteBuffer) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(ByteBuffer byteBuffer, q q2) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(byte[] bArr) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition parseFrom(byte[] bArr, q q2) {
            return (CommonTypesProto.TriggeringCondition)z.parseFrom(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition> parser() {
            return CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE.getParserForType();
        }

        private void setEvent(com.google.firebase.inappmessaging.CommonTypesProto.Event commonTypesProto$Event) {
            event.getClass();
            this.condition_ = event;
            this.conditionCase_ = 2;
        }

        private void setFiamTrigger(com.google.firebase.inappmessaging.CommonTypesProto.Trigger commonTypesProto$Trigger) {
            this.condition_ = Integer.valueOf(trigger.getNumber());
            this.conditionCase_ = 1;
        }

        private void setFiamTriggerValue(int i) {
            this.conditionCase_ = 1;
            this.condition_ = Integer.valueOf(i);
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
                    obj2 = new CommonTypesProto.TriggeringCondition();
                    return obj2;
                case 2:
                    obj2 = new CommonTypesProto.TriggeringCondition.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[3];
                    obj2[obj3] = "conditionCase_";
                    obj2[2] = CommonTypesProto.Event.class;
                    return z.newMessageInfo(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001?\u0000\u0002<\u0000", obj2);
                case 4:
                    return CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE;
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
            obj3 = CommonTypesProto.TriggeringCondition.class;
            synchronized (obj3) {
                obj2 = new z.b(CommonTypesProto.TriggeringCondition.DEFAULT_INSTANCE);
                CommonTypesProto.TriggeringCondition.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.CommonTypesProto.TriggeringCondition.ConditionCase getConditionCase() {
            return CommonTypesProto.TriggeringCondition.ConditionCase.forNumber(this.conditionCase_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.CommonTypesProto.Event getEvent() {
            if (this.conditionCase_ == 2) {
                return (CommonTypesProto.Event)this.condition_;
            }
            return CommonTypesProto.Event.getDefaultInstance();
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.CommonTypesProto.Trigger getFiamTrigger() {
            com.google.firebase.inappmessaging.CommonTypesProto.Trigger uNRECOGNIZED;
            if (this.conditionCase_ == 1 && CommonTypesProto.Trigger.forNumber((Integer)this.condition_.intValue()) == null) {
                if (CommonTypesProto.Trigger.forNumber((Integer)this.condition_.intValue()) == null) {
                    uNRECOGNIZED = CommonTypesProto.Trigger.UNRECOGNIZED;
                }
                return uNRECOGNIZED;
            }
            return CommonTypesProto.Trigger.UNKNOWN_TRIGGER;
        }

        @Override // com.google.protobuf.z
        public int getFiamTriggerValue() {
            if (this.conditionCase_ == 1) {
                return (Integer)this.condition_.intValue();
            }
            return 0;
        }

        @Override // com.google.protobuf.z
        public boolean hasEvent() {
            int i;
            i = this.conditionCase_ == 2 ? 1 : 0;
            return i;
        }
    }
    static {
    }

    public static void registerAllExtensions(q q) {
    }
}
