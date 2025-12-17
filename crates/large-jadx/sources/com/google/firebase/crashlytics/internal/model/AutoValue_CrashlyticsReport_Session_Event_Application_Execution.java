package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution {

    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo appExitInfo;
    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder {

        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo appExitInfo;
        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> binaries;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception exception;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal signal;
        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread> threads;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution build() {
            Object stringBuilder2;
            Object stringBuilder;
            String string;
            if (this.signal == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" signal");
                string = stringBuilder2.toString();
            }
            if (this.binaries == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" binaries");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.threads, this.exception, this.appExitInfo, this.signal, this.binaries, 0);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setAppExitInfo(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo) {
            this.appExitInfo = applicationExitInfo;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList) {
            Objects.requireNonNull(immutableList, "Null binaries");
            this.binaries = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setException(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception crashlyticsReport$Session$Event$Application$Execution$Exception) {
            this.exception = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal crashlyticsReport$Session$Event$Application$Execution$Signal) {
            Objects.requireNonNull(signal, "Null signal");
            this.signal = signal;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList) {
            this.threads = immutableList;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception crashlyticsReport$Session$Event$Application$Execution$Exception2, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal crashlyticsReport$Session$Event$Application$Execution$Signal4, com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList5) {
        super();
        this.threads = immutableList;
        this.exception = exception2;
        this.appExitInfo = applicationExitInfo3;
        this.signal = signal4;
        this.binaries = immutableList5;
    }

    AutoValue_CrashlyticsReport_Session_Event_Application_Execution(com.google.firebase.crashlytics.internal.model.ImmutableList immutableList, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception crashlyticsReport$Session$Event$Application$Execution$Exception2, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo crashlyticsReport$ApplicationExitInfo3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal crashlyticsReport$Session$Event$Application$Execution$Signal4, com.google.firebase.crashlytics.internal.model.ImmutableList immutableList5, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution.1 autoValue_CrashlyticsReport_Session_Event_Application_Execution$16) {
        super(immutableList, exception2, applicationExitInfo3, signal4, immutableList5);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution
    public boolean equals(Object object) {
        int i;
        boolean appExitInfo;
        com.google.firebase.crashlytics.internal.model.ImmutableList appExitInfo2;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Application.Execution) {
            com.google.firebase.crashlytics.internal.model.ImmutableList threads = this.threads;
            if (threads == null) {
                if ((CrashlyticsReport.Session.Event.Application.Execution)object.getThreads() == null) {
                    com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.exception;
                    if (exception == null) {
                        if (object.getException() == null) {
                            com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo appExitInfo3 = this.appExitInfo;
                            if (appExitInfo3 == null) {
                                if (object.getAppExitInfo() == null) {
                                    if (this.signal.equals(object.getSignal())) {
                                        if (this.binaries.equals(object.getBinaries())) {
                                        } else {
                                            i = i2;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                                if (appExitInfo3.equals(object.getAppExitInfo()) && this.signal.equals(object.getSignal()) && this.binaries.equals(object.getBinaries())) {
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                        if (exception.equals(object.getException())) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
                if (threads.equals(object.getThreads())) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo getAppExitInfo() {
        return this.appExitInfo;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries() {
        return this.binaries;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception getException() {
        return this.exception;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal() {
        return this.signal;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads() {
        return this.threads;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution
    public int hashCode() {
        int i3;
        int i;
        int i2;
        com.google.firebase.crashlytics.internal.model.ImmutableList threads = this.threads;
        i = 0;
        if (threads == null) {
            i3 = i;
        } else {
            i3 = threads.hashCode();
        }
        final int i15 = 1000003;
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.exception;
        if (exception == null) {
            i2 = i;
        } else {
            i2 = exception.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo appExitInfo = this.appExitInfo;
        if (appExitInfo == null) {
        } else {
            i = appExitInfo.hashCode();
        }
        return i11 ^= i14;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Execution{threads=");
        stringBuilder.append(this.threads);
        stringBuilder.append(", exception=");
        stringBuilder.append(this.exception);
        stringBuilder.append(", appExitInfo=");
        stringBuilder.append(this.appExitInfo);
        stringBuilder.append(", signal=");
        stringBuilder.append(this.signal);
        stringBuilder.append(", binaries=");
        stringBuilder.append(this.binaries);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
