package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {

    private final String file;
    private final int importance;
    private final long offset;
    private final long pc;
    private final String symbol;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {

        private String file;
        private Integer importance;
        private Long offset;
        private Long pc;
        private String symbol;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build() {
            Object stringBuilder;
            Object stringBuilder2;
            Object stringBuilder4;
            Object stringBuilder3;
            String string;
            if (this.pc == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" pc");
                string = stringBuilder.toString();
            }
            if (this.symbol == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" symbol");
                string = stringBuilder2.toString();
            }
            if (this.offset == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" offset");
                string = stringBuilder4.toString();
            }
            if (this.importance == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" importance");
                string = stringBuilder3.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.pc.longValue(), obj4, this.symbol, this.file, this.offset.longValue(), obj8, this.importance.intValue(), 0);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Missing required properties:");
            stringBuilder5.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder5.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String string) {
            this.file = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long l) {
            this.offset = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long l) {
            this.pc = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String string) {
            Objects.requireNonNull(string, "Null symbol");
            this.symbol = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long l, String string2, String string3, long l4, int i5) {
        super();
        this.pc = l;
        this.symbol = string3;
        this.file = l4;
        this.offset = i5;
        this.importance = obj7;
    }

    AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long l, String string2, String string3, long l4, int i5, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$16) {
        super(l, string2, string3, l4, i5, 16, obj7);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public boolean equals(Object object) {
        int i;
        int importance;
        long symbol;
        long offset;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) {
            if (Long.compare(symbol, offset) == 0 && this.symbol.equals(object.getSymbol())) {
                if (this.symbol.equals(object.getSymbol())) {
                    String file = this.file;
                    if (file == null) {
                        if (object.getFile() == null) {
                            if (Long.compare(symbol, offset) == 0) {
                                if (this.importance == object.getImportance()) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                        if (file.equals(object.getFile()) != null && Long.compare(symbol, offset) == 0 && this.importance == object.getImportance()) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public String getFile() {
        return this.file;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public int getImportance() {
        return this.importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public long getOffset() {
        return this.offset;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public long getPc() {
        return this.pc;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public String getSymbol() {
        return this.symbol;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public int hashCode() {
        int i;
        long l = this.pc;
        int i14 = 32;
        int i13 = 1000003;
        String file = this.file;
        if (file == null) {
            i = 0;
        } else {
            i = file.hashCode();
        }
        long offset = this.offset;
        return i11 ^= importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Frame{pc=");
        stringBuilder.append(this.pc);
        stringBuilder.append(", symbol=");
        stringBuilder.append(this.symbol);
        stringBuilder.append(", file=");
        stringBuilder.append(this.file);
        stringBuilder.append(", offset=");
        stringBuilder.append(this.offset);
        stringBuilder.append(", importance=");
        stringBuilder.append(this.importance);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
