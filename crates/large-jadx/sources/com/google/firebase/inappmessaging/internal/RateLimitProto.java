package com.google.firebase.inappmessaging.internal;

import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.n0;
import com.google.protobuf.q;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RateLimitProto {

    public interface CounterOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract long getStartTimeEpoch();

        @Override // com.google.protobuf.u0
        public abstract long getValue();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface RateLimitOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract boolean containsLimits(String string);

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Deprecated
        public abstract Map<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> getLimits();

        @Override // com.google.protobuf.u0
        public abstract int getLimitsCount();

        public abstract Map<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> getLimitsMap();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.internal.RateLimitProto.Counter getLimitsOrDefault(String string, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter2);

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.internal.RateLimitProto.Counter getLimitsOrThrow(String string);

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public static final class Counter extends z<com.google.firebase.inappmessaging.internal.RateLimitProto.Counter, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter.Builder> implements com.google.firebase.inappmessaging.internal.RateLimitProto.CounterOrBuilder {

        private static final com.google.firebase.inappmessaging.internal.RateLimitProto.Counter DEFAULT_INSTANCE = null;
        private static volatile d1<com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> PARSER = null;
        public static final int START_TIME_EPOCH_FIELD_NUMBER = 2;
        public static final int VALUE_FIELD_NUMBER = 1;
        private long startTimeEpoch_;
        private long value_;
        static {
            RateLimitProto.Counter counter = new RateLimitProto.Counter();
            RateLimitProto.Counter.DEFAULT_INSTANCE = counter;
            z.registerDefaultInstance(RateLimitProto.Counter.class, counter);
        }

        static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter access$300() {
            return RateLimitProto.Counter.DEFAULT_INSTANCE;
        }

        static void access$400(com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter, long l2) {
            counter.setValue(l2);
        }

        static void access$500(com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter) {
            counter.clearValue();
        }

        static void access$600(com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter, long l2) {
            counter.setStartTimeEpoch(l2);
        }

        static void access$700(com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter) {
            counter.clearStartTimeEpoch();
        }

        private void clearStartTimeEpoch() {
            this.startTimeEpoch_ = 0;
        }

        private void clearValue() {
            this.value_ = 0;
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter getDefaultInstance() {
            return RateLimitProto.Counter.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter.Builder newBuilder() {
            return (RateLimitProto.Counter.Builder)RateLimitProto.Counter.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter.Builder newBuilder(com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter) {
            return (RateLimitProto.Counter.Builder)RateLimitProto.Counter.DEFAULT_INSTANCE.createBuilder(counter);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseDelimitedFrom(InputStream inputStream) {
            return (RateLimitProto.Counter)z.parseDelimitedFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseDelimitedFrom(InputStream inputStream, q q2) {
            return (RateLimitProto.Counter)z.parseDelimitedFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(j j) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(j j, q q2) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(k k) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(k k, q q2) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(InputStream inputStream) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(InputStream inputStream, q q2) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(ByteBuffer byteBuffer) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(ByteBuffer byteBuffer, q q2) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(byte[] bArr) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter parseFrom(byte[] bArr, q q2) {
            return (RateLimitProto.Counter)z.parseFrom(RateLimitProto.Counter.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> parser() {
            return RateLimitProto.Counter.DEFAULT_INSTANCE.getParserForType();
        }

        private void setStartTimeEpoch(long l) {
            this.startTimeEpoch_ = l;
        }

        private void setValue(long l) {
            this.value_ = l;
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
                    obj2 = new RateLimitProto.Counter();
                    return obj2;
                case 2:
                    obj2 = new RateLimitProto.Counter.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "startTimeEpoch_";
                    return z.newMessageInfo(RateLimitProto.Counter.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0002", obj2);
                case 4:
                    return RateLimitProto.Counter.DEFAULT_INSTANCE;
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
            obj3 = RateLimitProto.Counter.class;
            synchronized (obj3) {
                obj2 = new z.b(RateLimitProto.Counter.DEFAULT_INSTANCE);
                RateLimitProto.Counter.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public long getStartTimeEpoch() {
            return this.startTimeEpoch_;
        }

        @Override // com.google.protobuf.z
        public long getValue() {
            return this.value_;
        }
    }

    public static final class RateLimit extends z<com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit.Builder> implements com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimitOrBuilder {

        private static final com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit DEFAULT_INSTANCE = null;
        public static final int LIMITS_FIELD_NUMBER = 1;
        private static volatile d1<com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit> PARSER;
        private n0<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> limits_;
        static {
            RateLimitProto.RateLimit rateLimit = new RateLimitProto.RateLimit();
            RateLimitProto.RateLimit.DEFAULT_INSTANCE = rateLimit;
            z.registerDefaultInstance(RateLimitProto.RateLimit.class, rateLimit);
        }

        private RateLimit() {
            super();
            this.limits_ = n0.e();
        }

        static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit access$000() {
            return RateLimitProto.RateLimit.DEFAULT_INSTANCE;
        }

        static Map access$100(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit) {
            return rateLimit.getMutableLimitsMap();
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit getDefaultInstance() {
            return RateLimitProto.RateLimit.DEFAULT_INSTANCE;
        }

        private Map<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> getMutableLimitsMap() {
            return internalGetMutableLimits();
        }

        private n0<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> internalGetLimits() {
            return this.limits_;
        }

        private n0<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> internalGetMutableLimits() {
            boolean z;
            if (!this.limits_.j()) {
                this.limits_ = this.limits_.m();
            }
            return this.limits_;
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit.Builder newBuilder() {
            return (RateLimitProto.RateLimit.Builder)RateLimitProto.RateLimit.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit.Builder newBuilder(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit) {
            return (RateLimitProto.RateLimit.Builder)RateLimitProto.RateLimit.DEFAULT_INSTANCE.createBuilder(rateLimit);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseDelimitedFrom(InputStream inputStream) {
            return (RateLimitProto.RateLimit)z.parseDelimitedFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseDelimitedFrom(InputStream inputStream, q q2) {
            return (RateLimitProto.RateLimit)z.parseDelimitedFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(j j) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(j j, q q2) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(k k) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(k k, q q2) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(InputStream inputStream) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(InputStream inputStream, q q2) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(ByteBuffer byteBuffer) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(ByteBuffer byteBuffer, q q2) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(byte[] bArr) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit parseFrom(byte[] bArr, q q2) {
            return (RateLimitProto.RateLimit)z.parseFrom(RateLimitProto.RateLimit.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit> parser() {
            return RateLimitProto.RateLimit.DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.protobuf.z
        public boolean containsLimits(String string) {
            string.getClass();
            return internalGetLimits().containsKey(string);
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
                    obj2 = new RateLimitProto.RateLimit();
                    return obj2;
                case 2:
                    obj2 = new RateLimitProto.RateLimit.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = RateLimitProto.RateLimit.LimitsDefaultEntryHolder.defaultEntry;
                    return z.newMessageInfo(RateLimitProto.RateLimit.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", obj2);
                case 4:
                    return RateLimitProto.RateLimit.DEFAULT_INSTANCE;
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
            obj3 = RateLimitProto.RateLimit.class;
            synchronized (obj3) {
                obj2 = new z.b(RateLimitProto.RateLimit.DEFAULT_INSTANCE);
                RateLimitProto.RateLimit.PARSER = obj2;
            }
        }

        @Deprecated
        public Map<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> getLimits() {
            return getLimitsMap();
        }

        @Override // com.google.protobuf.z
        public int getLimitsCount() {
            return internalGetLimits().size();
        }

        public Map<String, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter> getLimitsMap() {
            return Collections.unmodifiableMap(internalGetLimits());
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.internal.RateLimitProto.Counter getLimitsOrDefault(String string, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter2) {
            Object obj3;
            Object obj4;
            string.getClass();
            final n0 internalGetLimits = internalGetLimits();
            if (internalGetLimits.containsKey(string)) {
                obj4 = obj3;
            }
            return obj4;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.internal.RateLimitProto.Counter getLimitsOrThrow(String string) {
            string.getClass();
            final n0 internalGetLimits = internalGetLimits();
            if (!internalGetLimits.containsKey(string)) {
            } else {
                return (RateLimitProto.Counter)internalGetLimits.get(string);
            }
            IllegalArgumentException obj3 = new IllegalArgumentException();
            throw obj3;
        }
    }
    static {
    }

    public static void registerAllExtensions(q q) {
    }
}
