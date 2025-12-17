package com.google.firebase.perf.v1;

import android.accounts.Account;
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
import java.util.Map;

/* loaded from: classes2.dex */
public final class ApplicationInfo extends z<com.google.firebase.perf.v1.ApplicationInfo, com.google.firebase.perf.v1.ApplicationInfo.Builder> implements com.google.firebase.perf.v1.ApplicationInfoOrBuilder {

    public static final int ANDROID_APP_INFO_FIELD_NUMBER = 3;
    public static final int APPLICATION_PROCESS_STATE_FIELD_NUMBER = 5;
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 6;
    private static final com.google.firebase.perf.v1.ApplicationInfo DEFAULT_INSTANCE = null;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile d1<com.google.firebase.perf.v1.ApplicationInfo> PARSER;
    private com.google.firebase.perf.v1.AndroidApplicationInfo androidAppInfo_;
    private String appInstanceId_;
    private int applicationProcessState_;
    private int bitField0_;
    private n0<String, String> customAttributes_;
    private String googleAppId_;

    private static final class CustomAttributesDefaultEntryHolder {

        static final m0<String, String> defaultEntry;
        static {
            y1.b sTRING = y1.b.STRING;
            final String str = "";
            ApplicationInfo.CustomAttributesDefaultEntryHolder.defaultEntry = m0.d(sTRING, str, sTRING, str);
        }
    }

    public static final class Builder extends z.a<com.google.firebase.perf.v1.ApplicationInfo, com.google.firebase.perf.v1.ApplicationInfo.Builder> implements com.google.firebase.perf.v1.ApplicationInfoOrBuilder {
        private Builder() {
            super(ApplicationInfo.access$000());
        }

        Builder(com.google.firebase.perf.v1.ApplicationInfo.1 applicationInfo$1) {
            super();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder clearAndroidAppInfo() {
            copyOnWrite();
            ApplicationInfo.access$900((ApplicationInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder clearAppInstanceId() {
            copyOnWrite();
            ApplicationInfo.access$500((ApplicationInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder clearApplicationProcessState() {
            copyOnWrite();
            ApplicationInfo.access$1100((ApplicationInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder clearCustomAttributes() {
            copyOnWrite();
            ApplicationInfo.access$1200((ApplicationInfo)this.instance).clear();
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder clearGoogleAppId() {
            copyOnWrite();
            ApplicationInfo.access$200((ApplicationInfo)this.instance);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public boolean containsCustomAttributes(String string) {
            string.getClass();
            return (ApplicationInfo)this.instance.getCustomAttributesMap().containsKey(string);
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.AndroidApplicationInfo getAndroidAppInfo() {
            return (ApplicationInfo)this.instance.getAndroidAppInfo();
        }

        @Override // com.google.protobuf.z$a
        public String getAppInstanceId() {
            return (ApplicationInfo)this.instance.getAppInstanceId();
        }

        @Override // com.google.protobuf.z$a
        public j getAppInstanceIdBytes() {
            return (ApplicationInfo)this.instance.getAppInstanceIdBytes();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationProcessState getApplicationProcessState() {
            return (ApplicationInfo)this.instance.getApplicationProcessState();
        }

        @Deprecated
        public Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.google.protobuf.z$a
        public int getCustomAttributesCount() {
            return (ApplicationInfo)this.instance.getCustomAttributesMap().size();
        }

        public Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap((ApplicationInfo)this.instance.getCustomAttributesMap());
        }

        @Override // com.google.protobuf.z$a
        public String getCustomAttributesOrDefault(String string, String string2) {
            Object obj3;
            Object obj4;
            string.getClass();
            Map customAttributesMap = (ApplicationInfo)this.instance.getCustomAttributesMap();
            if (customAttributesMap.containsKey(string)) {
                obj4 = obj3;
            }
            return obj4;
        }

        @Override // com.google.protobuf.z$a
        public String getCustomAttributesOrThrow(String string) {
            string.getClass();
            Map customAttributesMap = (ApplicationInfo)this.instance.getCustomAttributesMap();
            if (!customAttributesMap.containsKey(string)) {
            } else {
                return (String)customAttributesMap.get(string);
            }
            IllegalArgumentException obj3 = new IllegalArgumentException();
            throw obj3;
        }

        @Override // com.google.protobuf.z$a
        public String getGoogleAppId() {
            return (ApplicationInfo)this.instance.getGoogleAppId();
        }

        @Override // com.google.protobuf.z$a
        public j getGoogleAppIdBytes() {
            return (ApplicationInfo)this.instance.getGoogleAppIdBytes();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasAndroidAppInfo() {
            return (ApplicationInfo)this.instance.hasAndroidAppInfo();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasAppInstanceId() {
            return (ApplicationInfo)this.instance.hasAppInstanceId();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasApplicationProcessState() {
            return (ApplicationInfo)this.instance.hasApplicationProcessState();
        }

        @Override // com.google.protobuf.z$a
        public boolean hasGoogleAppId() {
            return (ApplicationInfo)this.instance.hasGoogleAppId();
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder mergeAndroidAppInfo(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
            copyOnWrite();
            ApplicationInfo.access$800((ApplicationInfo)this.instance, androidApplicationInfo);
            return this;
        }

        public com.google.firebase.perf.v1.ApplicationInfo.Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            ApplicationInfo.access$1200((ApplicationInfo)this.instance).putAll(map);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder putCustomAttributes(String string, String string2) {
            string.getClass();
            string2.getClass();
            copyOnWrite();
            ApplicationInfo.access$1200((ApplicationInfo)this.instance).put(string, string2);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder removeCustomAttributes(String string) {
            string.getClass();
            copyOnWrite();
            ApplicationInfo.access$1200((ApplicationInfo)this.instance).remove(string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder setAndroidAppInfo(com.google.firebase.perf.v1.AndroidApplicationInfo.Builder androidApplicationInfo$Builder) {
            copyOnWrite();
            ApplicationInfo.access$700((ApplicationInfo)this.instance, (AndroidApplicationInfo)builder.build());
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder setAndroidAppInfo(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
            copyOnWrite();
            ApplicationInfo.access$700((ApplicationInfo)this.instance, androidApplicationInfo);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder setAppInstanceId(String string) {
            copyOnWrite();
            ApplicationInfo.access$400((ApplicationInfo)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder setAppInstanceIdBytes(j j) {
            copyOnWrite();
            ApplicationInfo.access$600((ApplicationInfo)this.instance, j);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder setApplicationProcessState(com.google.firebase.perf.v1.ApplicationProcessState applicationProcessState) {
            copyOnWrite();
            ApplicationInfo.access$1000((ApplicationInfo)this.instance, applicationProcessState);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder setGoogleAppId(String string) {
            copyOnWrite();
            ApplicationInfo.access$100((ApplicationInfo)this.instance, string);
            return this;
        }

        @Override // com.google.protobuf.z$a
        public com.google.firebase.perf.v1.ApplicationInfo.Builder setGoogleAppIdBytes(j j) {
            copyOnWrite();
            ApplicationInfo.access$300((ApplicationInfo)this.instance, j);
            return this;
        }
    }
    static {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        ApplicationInfo.DEFAULT_INSTANCE = applicationInfo;
        z.registerDefaultInstance(ApplicationInfo.class, applicationInfo);
    }

    private ApplicationInfo() {
        super();
        this.customAttributes_ = n0.e();
        String str = "";
        this.googleAppId_ = str;
        this.appInstanceId_ = str;
    }

    static com.google.firebase.perf.v1.ApplicationInfo access$000() {
        return ApplicationInfo.DEFAULT_INSTANCE;
    }

    static void access$100(com.google.firebase.perf.v1.ApplicationInfo applicationInfo, String string2) {
        applicationInfo.setGoogleAppId(string2);
    }

    static void access$1000(com.google.firebase.perf.v1.ApplicationInfo applicationInfo, com.google.firebase.perf.v1.ApplicationProcessState applicationProcessState2) {
        applicationInfo.setApplicationProcessState(applicationProcessState2);
    }

    static void access$1100(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        applicationInfo.clearApplicationProcessState();
    }

    static Map access$1200(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        return applicationInfo.getMutableCustomAttributesMap();
    }

    static void access$200(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        applicationInfo.clearGoogleAppId();
    }

    static void access$300(com.google.firebase.perf.v1.ApplicationInfo applicationInfo, j j2) {
        applicationInfo.setGoogleAppIdBytes(j2);
    }

    static void access$400(com.google.firebase.perf.v1.ApplicationInfo applicationInfo, String string2) {
        applicationInfo.setAppInstanceId(string2);
    }

    static void access$500(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        applicationInfo.clearAppInstanceId();
    }

    static void access$600(com.google.firebase.perf.v1.ApplicationInfo applicationInfo, j j2) {
        applicationInfo.setAppInstanceIdBytes(j2);
    }

    static void access$700(com.google.firebase.perf.v1.ApplicationInfo applicationInfo, com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo2) {
        applicationInfo.setAndroidAppInfo(androidApplicationInfo2);
    }

    static void access$800(com.google.firebase.perf.v1.ApplicationInfo applicationInfo, com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo2) {
        applicationInfo.mergeAndroidAppInfo(androidApplicationInfo2);
    }

    static void access$900(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        applicationInfo.clearAndroidAppInfo();
    }

    private void clearAndroidAppInfo() {
        this.androidAppInfo_ = 0;
        this.bitField0_ = bitField0_ &= -5;
    }

    private void clearAppInstanceId() {
        this.bitField0_ = bitField0_ &= -3;
        this.appInstanceId_ = ApplicationInfo.getDefaultInstance().getAppInstanceId();
    }

    private void clearApplicationProcessState() {
        this.bitField0_ = bitField0_ &= -9;
        this.applicationProcessState_ = 0;
    }

    private void clearGoogleAppId() {
        this.bitField0_ = bitField0_ &= -2;
        this.googleAppId_ = ApplicationInfo.getDefaultInstance().getGoogleAppId();
    }

    public static com.google.firebase.perf.v1.ApplicationInfo getDefaultInstance() {
        return ApplicationInfo.DEFAULT_INSTANCE;
    }

    private Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    private n0<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private n0<String, String> internalGetMutableCustomAttributes() {
        boolean z;
        if (!this.customAttributes_.j()) {
            this.customAttributes_ = this.customAttributes_.m();
        }
        return this.customAttributes_;
    }

    private void mergeAndroidAppInfo(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
        Object androidAppInfo_;
        com.google.firebase.perf.v1.AndroidApplicationInfo defaultInstance;
        z obj3;
        androidApplicationInfo.getClass();
        androidAppInfo_ = this.androidAppInfo_;
        if (androidAppInfo_ != null && androidAppInfo_ != AndroidApplicationInfo.getDefaultInstance()) {
            if (androidAppInfo_ != AndroidApplicationInfo.getDefaultInstance()) {
                this.androidAppInfo_ = (AndroidApplicationInfo)(AndroidApplicationInfo.Builder)AndroidApplicationInfo.newBuilder(this.androidAppInfo_).mergeFrom(androidApplicationInfo).buildPartial();
            } else {
                this.androidAppInfo_ = androidApplicationInfo;
            }
        } else {
        }
        this.bitField0_ = obj3 |= 4;
    }

    public static com.google.firebase.perf.v1.ApplicationInfo.Builder newBuilder() {
        return (ApplicationInfo.Builder)ApplicationInfo.DEFAULT_INSTANCE.createBuilder();
    }

    public static com.google.firebase.perf.v1.ApplicationInfo.Builder newBuilder(com.google.firebase.perf.v1.ApplicationInfo applicationInfo) {
        return (ApplicationInfo.Builder)ApplicationInfo.DEFAULT_INSTANCE.createBuilder(applicationInfo);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseDelimitedFrom(InputStream inputStream) {
        return (ApplicationInfo)z.parseDelimitedFrom(ApplicationInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseDelimitedFrom(InputStream inputStream, q q2) {
        return (ApplicationInfo)z.parseDelimitedFrom(ApplicationInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(j j) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, j);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(j j, q q2) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, j, q2);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(k k) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, k);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(k k, q q2) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, k, q2);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(InputStream inputStream) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, inputStream);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(InputStream inputStream, q q2) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, inputStream, q2);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(ByteBuffer byteBuffer) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, byteBuffer);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(ByteBuffer byteBuffer, q q2) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, byteBuffer, q2);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(byte[] bArr) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, bArr);
    }

    public static com.google.firebase.perf.v1.ApplicationInfo parseFrom(byte[] bArr, q q2) {
        return (ApplicationInfo)z.parseFrom(ApplicationInfo.DEFAULT_INSTANCE, bArr, q2);
    }

    public static d1<com.google.firebase.perf.v1.ApplicationInfo> parser() {
        return ApplicationInfo.DEFAULT_INSTANCE.getParserForType();
    }

    private void setAndroidAppInfo(com.google.firebase.perf.v1.AndroidApplicationInfo androidApplicationInfo) {
        androidApplicationInfo.getClass();
        this.androidAppInfo_ = androidApplicationInfo;
        this.bitField0_ = obj1 |= 4;
    }

    private void setAppInstanceId(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 2;
        this.appInstanceId_ = string;
    }

    private void setAppInstanceIdBytes(j j) {
        this.appInstanceId_ = j.R();
        this.bitField0_ = obj1 |= 2;
    }

    private void setApplicationProcessState(com.google.firebase.perf.v1.ApplicationProcessState applicationProcessState) {
        this.applicationProcessState_ = applicationProcessState.getNumber();
        this.bitField0_ = obj1 |= 8;
    }

    private void setGoogleAppId(String string) {
        string.getClass();
        this.bitField0_ = bitField0_ |= 1;
        this.googleAppId_ = string;
    }

    private void setGoogleAppIdBytes(j j) {
        this.googleAppId_ = j.R();
        this.bitField0_ = obj1 |= 1;
    }

    @Override // com.google.protobuf.z
    public boolean containsCustomAttributes(String string) {
        string.getClass();
        return internalGetCustomAttributes().containsKey(string);
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
                obj2 = new ApplicationInfo();
                return obj2;
            case 2:
                obj2 = new ApplicationInfo.Builder(obj4);
                return obj2;
            case 3:
                obj2 = new Object[8];
                obj2[obj3] = "googleAppId_";
                obj2[2] = "appInstanceId_";
                obj2[3] = "androidAppInfo_";
                obj2[4] = "applicationProcessState_";
                obj2[5] = ApplicationProcessState.internalGetVerifier();
                obj2[6] = "customAttributes_";
                obj2[7] = ApplicationInfo.CustomAttributesDefaultEntryHolder.defaultEntry;
                return z.newMessageInfo(ApplicationInfo.DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0001\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0005ဌ\u0003\u00062", obj2);
            case 4:
                return ApplicationInfo.DEFAULT_INSTANCE;
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
        obj3 = ApplicationInfo.class;
        synchronized (obj3) {
            obj2 = new z.b(ApplicationInfo.DEFAULT_INSTANCE);
            ApplicationInfo.PARSER = obj2;
        }
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.AndroidApplicationInfo getAndroidAppInfo() {
        com.google.firebase.perf.v1.AndroidApplicationInfo androidAppInfo_;
        if (this.androidAppInfo_ == null) {
            androidAppInfo_ = AndroidApplicationInfo.getDefaultInstance();
        }
        return androidAppInfo_;
    }

    @Override // com.google.protobuf.z
    public String getAppInstanceId() {
        return this.appInstanceId_;
    }

    @Override // com.google.protobuf.z
    public j getAppInstanceIdBytes() {
        return j.u(this.appInstanceId_);
    }

    @Override // com.google.protobuf.z
    public com.google.firebase.perf.v1.ApplicationProcessState getApplicationProcessState() {
        com.google.firebase.perf.v1.ApplicationProcessState aPPLICATION_PROCESS_STATE_UNKNOWN;
        if (ApplicationProcessState.forNumber(this.applicationProcessState_) == null) {
            aPPLICATION_PROCESS_STATE_UNKNOWN = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
        return aPPLICATION_PROCESS_STATE_UNKNOWN;
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
    public String getGoogleAppId() {
        return this.googleAppId_;
    }

    @Override // com.google.protobuf.z
    public j getGoogleAppIdBytes() {
        return j.u(this.googleAppId_);
    }

    @Override // com.google.protobuf.z
    public boolean hasAndroidAppInfo() {
        int i;
        i = bitField0_ &= 4 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasAppInstanceId() {
        int i;
        i = bitField0_ &= 2 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasApplicationProcessState() {
        int i;
        i = bitField0_ &= 8 != 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.z
    public boolean hasGoogleAppId() {
        int i;
        if (bitField0_ &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
