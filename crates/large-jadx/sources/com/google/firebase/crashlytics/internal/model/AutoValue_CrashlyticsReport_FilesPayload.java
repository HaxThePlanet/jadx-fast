package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_FilesPayload extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload {

    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File> files;
    private final String orgId;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder {

        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File> files;
        private String orgId;
        private Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload) {
            super();
            this.files = filesPayload.getFiles();
            this.orgId = filesPayload.getOrgId();
        }

        Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload.1 autoValue_CrashlyticsReport_FilesPayload$12) {
            super(filesPayload);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload build() {
            Object stringBuilder;
            String string;
            if (this.files == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" files");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                AutoValue_CrashlyticsReport_FilesPayload autoValue_CrashlyticsReport_FilesPayload = new AutoValue_CrashlyticsReport_FilesPayload(this.files, this.orgId, 0);
                return autoValue_CrashlyticsReport_FilesPayload;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing required properties:");
            stringBuilder2.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder setFiles(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File> immutableList) {
            Objects.requireNonNull(immutableList, "Null files");
            this.files = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder setOrgId(String string) {
            this.orgId = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_FilesPayload(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File> immutableList, String string2) {
        super();
        this.files = immutableList;
        this.orgId = string2;
    }

    AutoValue_CrashlyticsReport_FilesPayload(com.google.firebase.crashlytics.internal.model.ImmutableList immutableList, String string2, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload.1 autoValue_CrashlyticsReport_FilesPayload$13) {
        super(immutableList, string2);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload
    public boolean equals(Object object) {
        int i;
        boolean orgId;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.FilesPayload != null) {
            if (this.files.equals((CrashlyticsReport.FilesPayload)object.getFiles()) != null) {
                orgId = this.orgId;
                if (orgId == null) {
                    if (object.getOrgId() == null) {
                    } else {
                        i = i2;
                    }
                } else {
                    if (orgId.equals(object.getOrgId())) {
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File> getFiles() {
        return this.files;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload
    public String getOrgId() {
        return this.orgId;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload
    public int hashCode() {
        int i;
        int i6 = 1000003;
        String orgId = this.orgId;
        if (orgId == null) {
            i = 0;
        } else {
            i = orgId.hashCode();
        }
        return i4 ^= i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload
    com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.Builder toBuilder() {
        AutoValue_CrashlyticsReport_FilesPayload.Builder builder = new AutoValue_CrashlyticsReport_FilesPayload.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FilesPayload{files=");
        stringBuilder.append(this.files);
        stringBuilder.append(", orgId=");
        stringBuilder.append(this.orgId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
