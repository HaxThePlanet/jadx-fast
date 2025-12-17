package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage {

    private final long baseAddress;
    private final String name;
    private final long size;
    private final String uuid;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {

        private Long baseAddress;
        private String name;
        private Long size;
        private String uuid;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage build() {
            Object stringBuilder;
            Object stringBuilder3;
            Object stringBuilder2;
            String string;
            if (this.baseAddress == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" baseAddress");
                string = stringBuilder.toString();
            }
            if (this.size == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" size");
                string = stringBuilder3.toString();
            }
            if (this.name == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" name");
                string = stringBuilder2.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.baseAddress.longValue(), obj4, this.size.longValue(), obj6, this.name, this.uuid, 0);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Missing required properties:");
            stringBuilder4.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder4.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long l) {
            this.baseAddress = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String string) {
            Objects.requireNonNull(string, "Null name");
            this.name = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long l) {
            this.size = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(String string) {
            this.uuid = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long l, long l2, String string3, String string4) {
        super();
        this.baseAddress = l;
        this.size = string3;
        this.name = obj5;
        this.uuid = obj6;
    }

    AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long l, long l2, String string3, String string4, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage$15) {
        super(l, l2, string3, string4, 15, obj6);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage
    public boolean equals(Object object) {
        int i;
        int equals;
        long baseAddress2;
        long baseAddress;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Application.Execution.BinaryImage) {
            if (Long.compare(baseAddress2, baseAddress) == 0 && Long.compare(baseAddress2, baseAddress) == 0 && this.name.equals(object.getName())) {
                if (Long.compare(baseAddress2, baseAddress) == 0) {
                    if (this.name.equals(object.getName())) {
                        equals = this.uuid;
                        if (equals == null) {
                            if (object.getUuid() == null) {
                            } else {
                                i = i2;
                            }
                        } else {
                            if (equals.equals(object.getUuid())) {
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage
    public long getBaseAddress() {
        return this.baseAddress;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage
    public long getSize() {
        return this.size;
    }

    @Encodable$Ignore
    public String getUuid() {
        return this.uuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage
    public int hashCode() {
        int i;
        long baseAddress = this.baseAddress;
        int i12 = 32;
        int i11 = 1000003;
        long size = this.size;
        String uuid = this.uuid;
        if (uuid == null) {
            i = 0;
        } else {
            i = uuid.hashCode();
        }
        return i9 ^= i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$BinaryImage
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BinaryImage{baseAddress=");
        stringBuilder.append(this.baseAddress);
        stringBuilder.append(", size=");
        stringBuilder.append(this.size);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", uuid=");
        stringBuilder.append(this.uuid);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
