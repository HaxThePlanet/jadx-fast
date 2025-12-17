package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_FilesPayload_File extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File {

    private final byte[] contents;
    private final String filename;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder {

        private byte[] contents;
        private String filename;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File build() {
            Object stringBuilder2;
            byte[] stringBuilder;
            String string;
            if (this.filename == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" filename");
                string = stringBuilder2.toString();
            }
            if (this.contents == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" contents");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                AutoValue_CrashlyticsReport_FilesPayload_File autoValue_CrashlyticsReport_FilesPayload_File = new AutoValue_CrashlyticsReport_FilesPayload_File(this.filename, this.contents, 0);
                return autoValue_CrashlyticsReport_FilesPayload_File;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder setContents(byte[] bArr) {
            Objects.requireNonNull(bArr, "Null contents");
            this.contents = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File.Builder setFilename(String string) {
            Objects.requireNonNull(string, "Null filename");
            this.filename = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_FilesPayload_File(String string, byte[] b2Arr2) {
        super();
        this.filename = string;
        this.contents = b2Arr2;
    }

    AutoValue_CrashlyticsReport_FilesPayload_File(String string, byte[] b2Arr2, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File.1 autoValue_CrashlyticsReport_FilesPayload_File$13) {
        super(string, b2Arr2);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File
    public boolean equals(Object object) {
        int i;
        boolean contents;
        String filename;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.FilesPayload.File != null) {
            if (this.filename.equals((CrashlyticsReport.FilesPayload.File)object.getFilename()) != null) {
                if (object instanceof AutoValue_CrashlyticsReport_FilesPayload_File != null) {
                    obj5 = object.contents;
                } else {
                    obj5 = (AutoValue_CrashlyticsReport_FilesPayload_File)object.getContents();
                }
                if (Arrays.equals(this.contents, obj5)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File
    public byte[] getContents() {
        return this.contents;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File
    public String getFilename() {
        return this.filename;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$FilesPayload$File
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("File{filename=");
        stringBuilder.append(this.filename);
        stringBuilder.append(", contents=");
        stringBuilder.append(Arrays.toString(this.contents));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
