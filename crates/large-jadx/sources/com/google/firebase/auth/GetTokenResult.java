package com.google.firebase.auth;

import java.util.Map;

/* loaded from: classes2.dex */
public class GetTokenResult {

    private String zza;
    private Map<String, Object> zzb;
    public GetTokenResult(String string, Map<String, Object> map2) {
        super();
        this.zza = string;
        this.zzb = map2;
    }

    private final long zza(String string) {
        final Object obj3 = this.zzb.get(string);
        if ((Integer)obj3 == null) {
            return 0;
        }
        return (Integer)obj3.longValue();
    }

    public long getAuthTimestamp() {
        return zza("auth_time");
    }

    public Map<String, Object> getClaims() {
        return this.zzb;
    }

    public long getExpirationTimestamp() {
        return zza("exp");
    }

    public long getIssuedAtTimestamp() {
        return zza("iat");
    }

    public String getSignInProvider() {
        Object obj = this.zzb.get("firebase");
        if ((Map)obj != null) {
            return (String)(Map)obj.get("sign_in_provider");
        }
        return null;
    }

    public String getSignInSecondFactor() {
        Object obj = this.zzb.get("firebase");
        if ((Map)obj != null) {
            return (String)(Map)obj.get("sign_in_second_factor");
        }
        return null;
    }

    public String getToken() {
        return this.zza;
    }
}
