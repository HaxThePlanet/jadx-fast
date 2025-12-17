package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal {

    private final long address;
    private final String code;
    private final String name;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {

        private Long address;
        private String code;
        private String name;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal build() {
            Object stringBuilder2;
            Object stringBuilder;
            Object stringBuilder3;
            String string;
            if (this.name == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" name");
                string = stringBuilder2.toString();
            }
            if (this.code == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" code");
                string = stringBuilder.toString();
            }
            if (this.address == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" address");
                string = stringBuilder3.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.name, this.code, this.address.longValue(), obj6, 0);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Missing required properties:");
            stringBuilder4.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder4.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long l) {
            this.address = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String string) {
            Objects.requireNonNull(string, "Null code");
            this.code = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String string) {
            Objects.requireNonNull(string, "Null name");
            this.name = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String string, String string2, long l3) {
        super();
        this.name = string;
        this.code = string2;
        this.address = l3;
    }

    AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String string, String string2, long l3, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal$14) {
        super(string, string2, l3, 14);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal
    public boolean equals(Object object) {
        int i;
        boolean equals;
        String address;
        long address2;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal) {
            if (this.name.equals((CrashlyticsReport.Session.Event.Application.Execution.Signal)object.getName()) && this.code.equals(object.getCode()) && Long.compare(address, address2) == 0) {
                if (this.code.equals(object.getCode())) {
                    if (Long.compare(address, address2) == 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal
    public long getAddress() {
        return this.address;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal
    public String getCode() {
        return this.code;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal
    public int hashCode() {
        int i7 = 1000003;
        long address = this.address;
        return i5 ^= i9;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Signal
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Signal{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", address=");
        stringBuilder.append(this.address);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
