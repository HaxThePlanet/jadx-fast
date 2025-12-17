package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_CustomAttribute extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute {

    private final String key;
    private final String value;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder {

        private String key;
        private String value;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute build() {
            Object stringBuilder2;
            Object stringBuilder;
            String string;
            if (this.key == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" key");
                string = stringBuilder2.toString();
            }
            if (this.value == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" value");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                AutoValue_CrashlyticsReport_CustomAttribute autoValue_CrashlyticsReport_CustomAttribute = new AutoValue_CrashlyticsReport_CustomAttribute(this.key, this.value, 0);
                return autoValue_CrashlyticsReport_CustomAttribute;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder setKey(String string) {
            Objects.requireNonNull(string, "Null key");
            this.key = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder setValue(String string) {
            Objects.requireNonNull(string, "Null value");
            this.value = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_CustomAttribute(String string, String string2) {
        super();
        this.key = string;
        this.value = string2;
    }

    AutoValue_CrashlyticsReport_CustomAttribute(String string, String string2, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute.1 autoValue_CrashlyticsReport_CustomAttribute$13) {
        super(string, string2);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.CustomAttribute) {
            if (this.key.equals((CrashlyticsReport.CustomAttribute)object.getKey()) && this.value.equals(object.getValue())) {
                if (this.value.equals(object.getValue())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute
    public String getKey() {
        return this.key;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute
    public String getValue() {
        return this.value;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomAttribute{key=");
        stringBuilder.append(this.key);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
