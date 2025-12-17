package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.r;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class ActionCodeUrl {

    private static final Map<String, Integer> zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    static {
        zzc zzc = new zzc();
        ActionCodeUrl.zza = zzc;
    }

    private ActionCodeUrl(String string) {
        super();
        String str = "apiKey";
        String str8 = ActionCodeUrl.zzb(string, str);
        final String str9 = "oobCode";
        String str10 = ActionCodeUrl.zzb(string, str9);
        final String str11 = "mode";
        final String str12 = ActionCodeUrl.zzb(string, str11);
        if (str8 == null) {
        } else {
            if (str10 == null) {
            } else {
                if (str12 == null) {
                } else {
                    r.f(str8);
                    this.zzb = str8;
                    r.f(str10);
                    this.zzc = str10;
                    r.f(str12);
                    this.zzd = str12;
                    this.zze = ActionCodeUrl.zzb(string, "continueUrl");
                    this.zzf = ActionCodeUrl.zzb(string, "languageCode");
                    this.zzg = ActionCodeUrl.zzb(string, "tenantId");
                }
            }
        }
        Object[] arr = new Object[3];
        IllegalArgumentException obj7 = new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", str, str9, str11));
        throw obj7;
    }

    public static com.google.firebase.auth.ActionCodeUrl parseLink(String string) {
        r.f(string);
        ActionCodeUrl actionCodeUrl = new ActionCodeUrl(string);
        return actionCodeUrl;
    }

    private static String zzb(String string, String string2) {
        final String str = "link";
        Uri obj3 = Uri.parse(string);
        Set queryParameterNames = obj3.getQueryParameterNames();
        if (queryParameterNames.contains(string2)) {
            return obj3.getQueryParameter(string2);
        }
        if (queryParameterNames.contains(str)) {
            obj3 = obj3.getQueryParameter(str);
            r.f(obj3);
            return Uri.parse(obj3).getQueryParameter(string2);
        }
        return null;
    }

    public String getApiKey() {
        return this.zzb;
    }

    public String getCode() {
        return this.zzc;
    }

    public String getContinueUrl() {
        return this.zze;
    }

    public String getLanguageCode() {
        return this.zzf;
    }

    public int getOperation() {
        Map zza = ActionCodeUrl.zza;
        if (zza.containsKey(this.zzd)) {
            return (Integer)zza.get(this.zzd).intValue();
        }
        return 3;
    }

    public final String zza() {
        return this.zzg;
    }
}
