package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class vn {

    private final String a;
    public vn(String string) {
        super();
        r.f(string);
        this.a = string;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appSignatureHash", this.a);
        return jSONObject;
    }
}
