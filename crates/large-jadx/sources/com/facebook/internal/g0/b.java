package com.facebook.internal.g0;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.internal.b0;
import java.io.File;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008\u0007\u0018\u0000 -2\u00020\u0001:\u0003,-.B\u000f\u0008\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0008\u0012\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tB\u001b\u0008\u0012\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\rB\u000f\u0008\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010%\u001a\u00020&J\u0011\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0000H\u0086\u0002J\u0006\u0010*\u001a\u00020&J\u0008\u0010+\u001a\u00020\u000bH\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0014R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001dR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0014R\u0010\u0010 \u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/", d2 = {"Lcom/facebook/internal/instrument/InstrumentData;", "", "features", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)V", "e", "", "t", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "(Ljava/lang/Throwable;Lcom/facebook/internal/instrument/InstrumentData$Type;)V", "anrCause", "", "st", "(Ljava/lang/String;Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "analysisReportParameters", "Lorg/json/JSONObject;", "getAnalysisReportParameters", "()Lorg/json/JSONObject;", "appVersion", "cause", "exceptionReportParameters", "getExceptionReportParameters", "featureNames", "filename", "isValid", "", "()Z", "parameters", "getParameters", "stackTrace", "timestamp", "", "Ljava/lang/Long;", "type", "clear", "", "compareTo", "", "data", "save", "toString", "Builder", "Companion", "Type", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    public static final com.facebook.internal.g0.b.b h;
    private String a;
    private com.facebook.internal.g0.b.c b;
    private JSONArray c;
    private String d;
    private String e;
    private String f;
    private Long g;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¨\u0006\u0011", d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Builder;", "", "()V", "build", "Lcom/facebook/internal/instrument/InstrumentData;", "anrCause", "", "st", "e", "", "t", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "features", "Lorg/json/JSONArray;", "load", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        static {
        }

        public static final com.facebook.internal.g0.b a(String string, String string2) {
            b bVar = new b(string, string2, 0);
            return bVar;
        }

        public static final com.facebook.internal.g0.b b(Throwable throwable, com.facebook.internal.g0.b.c b$c2) {
            n.f(c2, "t");
            b bVar = new b(throwable, c2, 0);
            return bVar;
        }

        public static final com.facebook.internal.g0.b c(JSONArray jSONArray) {
            n.f(jSONArray, "features");
            b bVar = new b(jSONArray, 0);
            return bVar;
        }

        public static final com.facebook.internal.g0.b d(File file) {
            n.f(file, "file");
            b bVar = new b(file, 0);
            return bVar;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Companion;", "", "()V", "PARAM_APP_VERSION", "", "PARAM_CALLSTACK", "PARAM_DEVICE_MODEL", "PARAM_DEVICE_OS", "PARAM_FEATURE_NAMES", "PARAM_REASON", "PARAM_TIMESTAMP", "PARAM_TYPE", "UNKNOWN", "getType", "Lcom/facebook/internal/instrument/InstrumentData$Type;", "filename", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        public static final com.facebook.internal.g0.b.c a(com.facebook.internal.g0.b.b b$b, String string2) {
            return b.b(string2);
        }

        private final com.facebook.internal.g0.b.c b(String string) {
            final int i = 0;
            final int i2 = 2;
            final int i3 = 0;
            if (l.M(string, "crash_log_", i, i2, i3)) {
                return b.c.CrashReport;
            }
            if (l.M(string, "shield_log_", i, i2, i3)) {
                return b.c.CrashShield;
            }
            if (l.M(string, "thread_check_log_", i, i2, i3)) {
                return b.c.ThreadCheck;
            }
            if (l.M(string, "analysis_log_", i, i2, i3)) {
                return b.c.Analysis;
            }
            if (l.M(string, "anr_log_", i, i2, i3)) {
                return b.c.AnrReport;
            }
            return b.c.Unknown;
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\r¨\u0006\u000e", d2 = {"Lcom/facebook/internal/instrument/InstrumentData$Type;", "", "(Ljava/lang/String;I)V", "logPrefix", "", "getLogPrefix", "()Ljava/lang/String;", "toString", "Unknown", "Analysis", "AnrReport", "CrashReport", "CrashShield", "ThreadCheck", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static enum c {

        Unknown,
        Analysis,
        AnrReport,
        CrashReport,
        CrashShield,
        ThreadCheck;
        @Override // java.lang.Enum
        public final String getLogPrefix() {
            String str;
            int i;
            int i2 = c.b[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            str = i2 != 5 ? "Unknown" : "thread_check_log_";
                        } else {
                            str = "shield_log_";
                        }
                    } else {
                        str = "crash_log_";
                    }
                } else {
                    str = "anr_log_";
                }
            } else {
                str = "analysis_log_";
            }
            return str;
        }

        @Override // java.lang.Enum
        public String toString() {
            String str;
            int i;
            int i2 = c.a[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            str = i2 != 5 ? "Unknown" : "ThreadCheck";
                        } else {
                            str = "CrashShield";
                        }
                    } else {
                        str = "CrashReport";
                    }
                } else {
                    str = "AnrReport";
                }
            } else {
                str = "Analysis";
            }
            return str;
        }
    }
    static {
        b.b bVar = new b.b(0);
        b.h = bVar;
    }

    private b(File file) {
        int str2;
        long l;
        String str;
        Object obj4;
        super();
        obj4 = file.getName();
        n.e(obj4, "file.name");
        this.a = obj4;
        this.b = b.b.a(b.h, obj4);
        obj4 = f.k(this.a, true);
        if (obj4 != null) {
            this.g = Long.valueOf(obj4.optLong("timestamp", 0));
            l = 0;
            this.d = obj4.optString("app_version", l);
            this.e = obj4.optString("reason", l);
            this.f = obj4.optString("callstack", l);
            this.c = obj4.optJSONArray("feature_names");
        }
    }

    public b(File file, g g2) {
        super(file);
    }

    private b(String string, String string2) {
        super();
        this.b = b.c.AnrReport;
        this.d = b0.u();
        this.e = string;
        this.f = string2;
        this.g = Long.valueOf(obj3 /= l);
        StringBuffer obj3 = new StringBuffer();
        obj3.append("anr_log_");
        obj3.append(String.valueOf(this.g));
        obj3.append(".json");
        obj3 = obj3.toString();
        n.e(obj3, "StringBuffer()\n         …)\n            .toString()");
        this.a = obj3;
    }

    public b(String string, String string2, g g3) {
        super(string, string2);
    }

    private b(Throwable throwable, com.facebook.internal.g0.b.c b$c2) {
        super();
        this.b = c2;
        this.d = b0.u();
        this.e = f.b(throwable);
        this.f = f.e(throwable);
        this.g = Long.valueOf(currentTimeMillis /= l);
        StringBuffer obj5 = new StringBuffer();
        obj5.append(c2.getLogPrefix());
        obj5.append(String.valueOf(this.g));
        obj5.append(".json");
        obj5 = obj5.toString();
        n.e(obj5, "StringBuffer().append(t.…ppend(\".json\").toString()");
        this.a = obj5;
    }

    public b(Throwable throwable, com.facebook.internal.g0.b.c b$c2, g g3) {
        super(throwable, c2);
    }

    private b(JSONArray jSONArray) {
        super();
        this.b = b.c.Analysis;
        this.g = Long.valueOf(currentTimeMillis /= l);
        this.c = jSONArray;
        StringBuffer obj5 = new StringBuffer();
        obj5.append("analysis_log_");
        obj5.append(String.valueOf(this.g));
        obj5.append(".json");
        obj5 = obj5.toString();
        n.e(obj5, "StringBuffer()\n         …)\n            .toString()");
        this.a = obj5;
    }

    public b(JSONArray jSONArray, g g2) {
        super(jSONArray);
    }

    private final JSONObject c() {
        String str;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = this.c;
        if (jSONArray != null) {
            jSONObject.put("feature_names", jSONArray);
        }
        Long num = this.g;
        if (num != null) {
            jSONObject.put("timestamp", num);
        }
        return jSONObject;
    }

    private final JSONObject d() {
        String mODEL;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_os_version", Build.VERSION.RELEASE);
        jSONObject.put("device_model", Build.MODEL);
        String str3 = this.d;
        if (str3 != null) {
            jSONObject.put("app_version", str3);
        }
        Long num = this.g;
        if (num != null) {
            jSONObject.put("timestamp", num);
        }
        String str4 = this.e;
        if (str4 != null) {
            try {
                jSONObject.put("reason", str4);
                String str5 = this.f;
                if (str5 != null) {
                }
                jSONObject.put("callstack", str5);
                com.facebook.internal.g0.b.c cVar = this.b;
                if (cVar != null) {
                }
                jSONObject.put("type", cVar);
                return jSONObject;
                return null;
            }
        }
    }

    private final JSONObject e() {
        int cVar;
        int i;
        int i2;
        cVar = this.b;
        if (cVar == null) {
            i = 0;
        } else {
            cVar = d.b[cVar.ordinal()];
            if (cVar != 1) {
                if (cVar != 2 && cVar != 3 && cVar != 4 && cVar != 5) {
                    if (cVar != 3) {
                        if (cVar != 4) {
                            if (cVar != 5) {
                            } else {
                                i = d();
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
                i = c();
            }
        }
        return i;
    }

    public final void a() {
        f.a(this.a);
    }

    public final int b(com.facebook.internal.g0.b b) {
        n.f(b, "data");
        Long num = this.g;
        Long obj5 = b.g;
        if (num != null && obj5 != null) {
            obj5 = b.g;
            if (obj5 != null) {
                return Long.compare(longValue2, longValue);
            }
            return 1;
        }
        return -1;
    }

    public final boolean f() {
        com.facebook.internal.g0.b.c cVar;
        int i2;
        int i;
        cVar = this.b;
        i2 = 0;
        final int i3 = 1;
        if (cVar == null) {
        } else {
            cVar = d.a[cVar.ordinal()];
            if (cVar != i3) {
                if (cVar != 2) {
                    if (cVar != 3 && cVar != 4 && cVar != 5) {
                        if (cVar != 4) {
                            if (cVar != 5) {
                            } else {
                                if (this.f != null && this.g != null) {
                                    if (this.g != null) {
                                        i2 = i3;
                                    }
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    if (this.f != null && this.e != null && this.g != null) {
                        if (this.e != null) {
                            if (this.g != null) {
                            }
                        }
                    }
                }
            } else {
                if (this.c != null && this.g != null) {
                    if (this.g != null) {
                    }
                }
            }
        }
        return i2;
    }

    public final void g() {
        if (!f()) {
        }
        f.m(this.a, toString());
    }

    public String toString() {
        JSONObject jSONObject = e();
        if (jSONObject != null) {
            String string = jSONObject.toString();
            n.e(string, "params.toString()");
            return string;
        }
        JSONObject jSONObject2 = new JSONObject();
        String string2 = jSONObject2.toString();
        n.e(string2, "JSONObject().toString()");
        return string2;
    }
}
