package com.facebook.internal.g0.j;

import com.facebook.internal.g0.f;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0014\u001a\u00020\u0015J\u0011\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000H\u0086\u0002J\u0006\u0010\u0019\u001a\u00020\u0015J\u0008\u0010\u001a\u001a\u00020\u0003H\u0016R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u001c", d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportData;", "", "message", "", "(Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "errorMessage", "filename", "isValid", "", "()Z", "parameters", "Lorg/json/JSONObject;", "getParameters", "()Lorg/json/JSONObject;", "timestamp", "", "Ljava/lang/Long;", "clear", "", "compareTo", "", "data", "save", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private String a;
    private String b;
    private Long c;
    static {
    }

    public a(File file) {
        int i;
        long str;
        String str2;
        Object obj4;
        n.f(file, "file");
        super();
        obj4 = file.getName();
        n.e(obj4, "file.name");
        this.a = obj4;
        obj4 = f.k(obj4, true);
        if (obj4 != null) {
            this.c = Long.valueOf(obj4.optLong("timestamp", 0));
            this.b = obj4.optString("error_message", 0);
        }
    }

    public a(String string) {
        super();
        this.c = Long.valueOf(currentTimeMillis /= l);
        this.b = string;
        StringBuffer obj5 = new StringBuffer();
        obj5.append("error_log_");
        Long num = this.c;
        final String str4 = "null cannot be cast to non-null type kotlin.Long";
        Objects.requireNonNull(num, str4);
        obj5.append(num.longValue());
        obj5.append(".json");
        obj5 = obj5.toString();
        n.e(obj5, "StringBuffer()\n         …)\n            .toString()");
        this.a = obj5;
    }

    public final void a() {
        f.a(this.a);
    }

    public final int b(com.facebook.internal.g0.j.a a) {
        n.f(a, "data");
        Long num = this.c;
        Long obj5 = a.c;
        if (num != null && obj5 != null) {
            obj5 = a.c;
            if (obj5 != null) {
                return Long.compare(longValue2, longValue);
            }
            return 1;
        }
        return -1;
    }

    public final JSONObject c() {
        Long longValue;
        String str;
        JSONObject jSONObject = new JSONObject();
        longValue = this.c;
        if (longValue != null) {
            jSONObject.put("timestamp", longValue.longValue());
        }
        jSONObject.put("error_message", this.b);
        return jSONObject;
    }

    public final boolean d() {
        Object str;
        int i;
        if (this.b != null && this.c != null) {
            i = this.c != null ? 1 : 0;
        } else {
        }
        return i;
    }

    public final void e() {
        boolean z;
        String string;
        if (d()) {
            f.m(this.a, toString());
        }
    }

    public String toString() {
        JSONObject jSONObject = c();
        if (jSONObject != null) {
            String string = jSONObject.toString();
            n.e(string, "params.toString()");
            return string;
        }
        return super.toString();
    }
}
