package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application {

    private final Boolean background;
    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> customAttributes;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution execution;
    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> internalKeys;
    private final int uiOrientation;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder {

        private Boolean background;
        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> customAttributes;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution execution;
        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> internalKeys;
        private Integer uiOrientation;
        private Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application crashlyticsReport$Session$Event$Application) {
            super();
            this.execution = application.getExecution();
            this.customAttributes = application.getCustomAttributes();
            this.internalKeys = application.getInternalKeys();
            this.background = application.getBackground();
            this.uiOrientation = Integer.valueOf(application.getUiOrientation());
        }

        Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application crashlyticsReport$Session$Event$Application, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application.1 autoValue_CrashlyticsReport_Session_Event_Application$12) {
            super(application);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application build() {
            Object stringBuilder;
            Object uiOrientation;
            String string;
            if (this.execution == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" execution");
                string = stringBuilder.toString();
            }
            if (this.uiOrientation == null) {
                uiOrientation = new StringBuilder();
                uiOrientation.append(string);
                uiOrientation.append(" uiOrientation");
                string = uiOrientation.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.execution, this.customAttributes, this.internalKeys, this.background, this.uiOrientation.intValue(), 0);
                return autoValue_CrashlyticsReport_Session_Event_Application;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing required properties:");
            stringBuilder2.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setBackground(Boolean boolean) {
            this.background = boolean;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> immutableList) {
            this.customAttributes = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setExecution(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution crashlyticsReport$Session$Event$Application$Execution) {
            Objects.requireNonNull(execution, "Null execution");
            this.execution = execution;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setInternalKeys(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> immutableList) {
            this.internalKeys = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int i) {
            this.uiOrientation = Integer.valueOf(i);
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Application(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution crashlyticsReport$Session$Event$Application$Execution, com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> immutableList2, com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> immutableList3, Boolean boolean4, int i5) {
        super();
        this.execution = execution;
        this.customAttributes = immutableList2;
        this.internalKeys = immutableList3;
        this.background = boolean4;
        this.uiOrientation = i5;
    }

    AutoValue_CrashlyticsReport_Session_Event_Application(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution crashlyticsReport$Session$Event$Application$Execution, com.google.firebase.crashlytics.internal.model.ImmutableList immutableList2, com.google.firebase.crashlytics.internal.model.ImmutableList immutableList3, Boolean boolean4, int i5, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application.1 autoValue_CrashlyticsReport_Session_Event_Application$16) {
        super(execution, immutableList2, immutableList3, boolean4, i5);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application
    public boolean equals(Object object) {
        int i;
        boolean customAttributes2;
        Object customAttributes;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Application) {
            if (this.execution.equals((CrashlyticsReport.Session.Event.Application)object.getExecution())) {
                com.google.firebase.crashlytics.internal.model.ImmutableList customAttributes3 = this.customAttributes;
                if (customAttributes3 == null) {
                    if (object.getCustomAttributes() == null) {
                        com.google.firebase.crashlytics.internal.model.ImmutableList internalKeys = this.internalKeys;
                        if (internalKeys == null) {
                            if (object.getInternalKeys() == null) {
                                Boolean background = this.background;
                                if (background == null) {
                                    if (object.getBackground() == null) {
                                        if (this.uiOrientation == object.getUiOrientation()) {
                                        } else {
                                            i = i2;
                                        }
                                    } else {
                                    }
                                } else {
                                    if (background.equals(object.getBackground()) && this.uiOrientation == object.getUiOrientation()) {
                                    } else {
                                    }
                                }
                            } else {
                            }
                        } else {
                            if (internalKeys.equals(object.getInternalKeys())) {
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                    if (customAttributes3.equals(object.getCustomAttributes())) {
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application
    public Boolean getBackground() {
        return this.background;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> getCustomAttributes() {
        return this.customAttributes;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution getExecution() {
        return this.execution;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute> getInternalKeys() {
        return this.internalKeys;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application
    public int getUiOrientation() {
        return this.uiOrientation;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application
    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i14 = 1000003;
        com.google.firebase.crashlytics.internal.model.ImmutableList customAttributes = this.customAttributes;
        i3 = 0;
        if (customAttributes == null) {
            i = i3;
        } else {
            i = customAttributes.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.ImmutableList internalKeys = this.internalKeys;
        if (internalKeys == null) {
            i2 = i3;
        } else {
            i2 = internalKeys.hashCode();
        }
        Boolean background = this.background;
        if (background == null) {
        } else {
            i3 = background.hashCode();
        }
        return i12 ^= uiOrientation;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Event_Application.Builder builder = new AutoValue_CrashlyticsReport_Session_Event_Application.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Application{execution=");
        stringBuilder.append(this.execution);
        stringBuilder.append(", customAttributes=");
        stringBuilder.append(this.customAttributes);
        stringBuilder.append(", internalKeys=");
        stringBuilder.append(this.internalKeys);
        stringBuilder.append(", background=");
        stringBuilder.append(this.background);
        stringBuilder.append(", uiOrientation=");
        stringBuilder.append(this.uiOrientation);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
