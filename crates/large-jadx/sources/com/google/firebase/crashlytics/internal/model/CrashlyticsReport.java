package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.annotations.Encodable.Field;
import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
@Encodable
public abstract class CrashlyticsReport {

    public static final String DEVELOPMENT_PLATFORM_UNITY = "Unity";
    private static final Charset UTF_8;

    public static abstract class ApplicationExitInfo {
        public static com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder builder() {
            AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder builder = new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
            return builder;
        }

        public abstract int getImportance();

        public abstract int getPid();

        public abstract String getProcessName();

        public abstract long getPss();

        public abstract int getReasonCode();

        public abstract long getRss();

        public abstract long getTimestamp();

        public abstract String getTraceFile();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Architecture {

        public static final int ARM64 = 9;
        public static final int ARMV6 = 5;
        public static final int ARMV7 = 6;
        public static final int UNKNOWN = 7;
        public static final int X86_32 = 0;
        public static final int X86_64 = 1;
    }

    public static abstract class Builder {
        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport build();

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setBuildVersion(String string);

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setDisplayVersion(String string);

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setGmpAppId(String string);

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setInstallationUuid(String string);

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setNdkPayload(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload);

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setPlatform(int i);

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setSdkVersion(String string);

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setSession(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session crashlyticsReport$Session);
    }

    public static abstract class CustomAttribute {
        public static com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder builder() {
            AutoValue_CrashlyticsReport_CustomAttribute.Builder builder = new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
            return builder;
        }

        public abstract String getKey();

        public abstract String getValue();
    }

    public static abstract class FilesPayload {
        public static com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder builder() {
            AutoValue_CrashlyticsReport_FilesPayload.Builder builder = new AutoValue_CrashlyticsReport_FilesPayload.Builder();
            return builder;
        }

        public abstract com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File> getFiles();

        public abstract String getOrgId();

        abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder toBuilder();
    }

    public static abstract class Session {
        public static com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder builder() {
            AutoValue_CrashlyticsReport_Session.Builder builder = new AutoValue_CrashlyticsReport_Session.Builder();
            return builder.setCrashed(false);
        }

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application getApp();

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device getDevice();

        public abstract Long getEndedAt();

        public abstract com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> getEvents();

        public abstract String getGenerator();

        public abstract int getGeneratorType();

        @Encodable$Ignore
        public abstract String getIdentifier();

        @Encodable$Field(name = "identifier")
        public byte[] getIdentifierUtf8Bytes() {
            return getIdentifier().getBytes(CrashlyticsReport.access$000());
        }

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem getOs();

        public abstract long getStartedAt();

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User getUser();

        public abstract boolean isCrashed();

        public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder toBuilder();

        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session withEvents(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> immutableList) {
            return toBuilder().setEvents(immutableList).build();
        }

        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session withOrganizationId(String string) {
            return toBuilder().setApp(getApp().withOrganizationId(string)).build();
        }

        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session withSessionEndFields(long l, boolean z2, String string3) {
            Object obj2;
            final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder builder = toBuilder();
            builder.setEndedAt(Long.valueOf(l));
            builder.setCrashed(string3);
            if (obj5 != null) {
                builder.setUser(CrashlyticsReport.Session.User.builder().setIdentifier(obj5).build()).build();
            }
            return builder.build();
        }
    }

    public static enum Type {

        INCOMPLETE,
        JAVA,
        NATIVE;
    }
    static {
        CrashlyticsReport.UTF_8 = Charset.forName("UTF-8");
    }

    static Charset access$000() {
        return CrashlyticsReport.UTF_8;
    }

    public static com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder builder() {
        AutoValue_CrashlyticsReport.Builder builder = new AutoValue_CrashlyticsReport.Builder();
        return builder;
    }

    public abstract String getBuildVersion();

    public abstract String getDisplayVersion();

    public abstract String getGmpAppId();

    public abstract String getInstallationUuid();

    public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload getNdkPayload();

    public abstract int getPlatform();

    public abstract String getSdkVersion();

    public abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session getSession();

    @Encodable$Ignore
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Type getType() {
        if (getSession() != null) {
            return CrashlyticsReport.Type.JAVA;
        }
        if (getNdkPayload() != null) {
            return CrashlyticsReport.Type.NATIVE;
        }
        return CrashlyticsReport.Type.INCOMPLETE;
    }

    protected abstract com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder toBuilder();

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport withEvents(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> immutableList) {
        if (getSession() == null) {
        } else {
            return toBuilder().setSession(getSession().withEvents(immutableList)).build();
        }
        IllegalStateException obj3 = new IllegalStateException("Reports without sessions cannot have events added to them.");
        throw obj3;
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport withNdkPayload(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload) {
        return toBuilder().setSession(0).setNdkPayload(filesPayload).build();
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport withOrganizationId(String string) {
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload ndkPayload;
        Object obj3;
        final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder builder = toBuilder();
        ndkPayload = getNdkPayload();
        if (ndkPayload != null) {
            builder.setNdkPayload(ndkPayload.toBuilder().setOrgId(string).build());
        }
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session session = getSession();
        if (session != null) {
            builder.setSession(session.withOrganizationId(string));
        }
        return builder.build();
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport withSessionEndFields(long l, boolean z2, String string3) {
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session session;
        long obj3;
        final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder builder = toBuilder();
        if (getSession() != null) {
            builder.setSession(getSession().withSessionEndFields(l, z2, string3));
        }
        return builder.build();
    }
}
