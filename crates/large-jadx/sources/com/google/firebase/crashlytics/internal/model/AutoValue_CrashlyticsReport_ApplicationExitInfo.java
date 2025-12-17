package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo {

    private final int importance;
    private final int pid;
    private final String processName;
    private final long pss;
    private final int reasonCode;
    private final long rss;
    private final long timestamp;
    private final String traceFile;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder {

        private Integer importance;
        private Integer pid;
        private String processName;
        private Long pss;
        private Integer reasonCode;
        private Long rss;
        private Long timestamp;
        private String traceFile;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo build() {
            Object stringBuilder4;
            Object stringBuilder5;
            Object stringBuilder7;
            Object stringBuilder;
            Object stringBuilder6;
            Object stringBuilder3;
            Object stringBuilder2;
            String string;
            if (this.pid == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append("");
                stringBuilder4.append(" pid");
                string = stringBuilder4.toString();
            }
            if (this.processName == null) {
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string);
                stringBuilder5.append(" processName");
                string = stringBuilder5.toString();
            }
            if (this.reasonCode == null) {
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(string);
                stringBuilder7.append(" reasonCode");
                string = stringBuilder7.toString();
            }
            if (this.importance == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" importance");
                string = stringBuilder.toString();
            }
            if (this.pss == null) {
                stringBuilder6 = new StringBuilder();
                stringBuilder6.append(string);
                stringBuilder6.append(" pss");
                string = stringBuilder6.toString();
            }
            if (this.rss == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" rss");
                string = stringBuilder3.toString();
            }
            if (this.timestamp == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" timestamp");
                string = stringBuilder2.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.pid.intValue(), this.processName, this.reasonCode.intValue(), this.importance.intValue(), this.pss.longValue(), obj8, this.rss.longValue(), obj10, this.timestamp.longValue(), obj12, this.traceFile, 0);
                return autoValue_CrashlyticsReport_ApplicationExitInfo;
            }
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append("Missing required properties:");
            stringBuilder8.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder8.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i) {
            this.pid = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String string) {
            Objects.requireNonNull(string, "Null processName");
            this.processName = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setPss(long l) {
            this.pss = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i) {
            this.reasonCode = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setRss(long l) {
            this.rss = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long l) {
            this.timestamp = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(String string) {
            this.traceFile = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_ApplicationExitInfo(int i, String string2, int i3, int i4, long l5, long l6, long l7, String string8) {
        super();
        this.pid = i;
        this.processName = string2;
        this.reasonCode = i3;
        this.importance = i4;
        this.pss = l5;
        this.rss = l7;
        this.timestamp = obj9;
        this.traceFile = obj11;
    }

    AutoValue_CrashlyticsReport_ApplicationExitInfo(int i, String string2, int i3, int i4, long l5, long l6, long l7, String string8, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo.1 autoValue_CrashlyticsReport_ApplicationExitInfo$19) {
        super(i, string2, i3, i4, l5, l6, l7, string8, 19, obj10, obj11);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public boolean equals(Object object) {
        int i;
        int reasonCode;
        int processName;
        long timestamp;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.ApplicationExitInfo) {
            if (this.pid == (CrashlyticsReport.ApplicationExitInfo)object.getPid() && this.processName.equals(object.getProcessName()) && this.reasonCode == object.getReasonCode() && this.importance == object.getImportance() && Long.compare(processName, timestamp) == 0 && Long.compare(processName, timestamp) == 0 && Long.compare(processName, timestamp) == 0) {
                if (this.processName.equals(object.getProcessName())) {
                    if (this.reasonCode == object.getReasonCode()) {
                        if (this.importance == object.getImportance()) {
                            if (Long.compare(processName, timestamp) == 0) {
                                if (Long.compare(processName, timestamp) == 0) {
                                    if (Long.compare(processName, timestamp) == 0) {
                                        reasonCode = this.traceFile;
                                        if (reasonCode == null) {
                                            if (object.getTraceFile() == null) {
                                            } else {
                                                i = i2;
                                            }
                                        } else {
                                            if (reasonCode.equals(object.getTraceFile()) != null) {
                                            } else {
                                            }
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
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

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public int getImportance() {
        return this.importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public int getPid() {
        return this.pid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public String getProcessName() {
        return this.processName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public long getPss() {
        return this.pss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public int getReasonCode() {
        return this.reasonCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public long getRss() {
        return this.rss;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public String getTraceFile() {
        return this.traceFile;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public int hashCode() {
        int i;
        int i17 = 1000003;
        long pss = this.pss;
        int i25 = 32;
        long rss = this.rss;
        long timestamp = this.timestamp;
        String traceFile = this.traceFile;
        if (traceFile == null) {
            i = 0;
        } else {
            i = traceFile.hashCode();
        }
        return i15 ^= i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$ApplicationExitInfo
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApplicationExitInfo{pid=");
        stringBuilder.append(this.pid);
        stringBuilder.append(", processName=");
        stringBuilder.append(this.processName);
        stringBuilder.append(", reasonCode=");
        stringBuilder.append(this.reasonCode);
        stringBuilder.append(", importance=");
        stringBuilder.append(this.importance);
        stringBuilder.append(", pss=");
        stringBuilder.append(this.pss);
        stringBuilder.append(", rss=");
        stringBuilder.append(this.rss);
        stringBuilder.append(", timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", traceFile=");
        stringBuilder.append(this.traceFile);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
