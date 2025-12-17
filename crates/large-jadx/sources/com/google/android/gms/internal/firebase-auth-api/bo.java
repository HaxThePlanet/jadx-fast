package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.firebase.auth.ActionCodeUrl;
import com.google.firebase.auth.EmailAuthCredential;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bo implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private final String b;
    private final String c;
    static {
        a aVar = new a(bo.class.getSimpleName(), new String[0]);
    }

    public bo(EmailAuthCredential emailAuthCredential, String string2) {
        super();
        final String str = emailAuthCredential.zzd();
        r.f(str);
        this.a = str;
        final String obj2 = emailAuthCredential.zzf();
        r.f(obj2);
        this.b = obj2;
        this.c = string2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        int i;
        int code;
        String str;
        ActionCodeUrl link = ActionCodeUrl.parseLink(this.b);
        if (link != null) {
            code = link.getCode();
        } else {
            code = i;
        }
        if (link != null) {
            i = link.zza();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("email", this.a);
        if (code != 0) {
            jSONObject.put("oobCode", code);
        }
        if (i != 0) {
            jSONObject.put("tenantId", i);
        }
        String str3 = this.c;
        if (str3 != null) {
            jSONObject.put("idToken", str3);
        }
        return jSONObject.toString();
    }
}
