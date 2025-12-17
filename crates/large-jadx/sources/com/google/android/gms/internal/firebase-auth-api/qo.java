package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.internal.r;
import com.google.firebase.auth.ActionCodeSettings;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class qo implements com.google.android.gms.internal.firebase-auth-api.lm {

    private final String a;
    private String b;
    private String c;
    private String v;
    private ActionCodeSettings w;
    private String x;
    public qo(int i) {
        int i2;
        String obj2;
        super();
        if (i != 1) {
            if (i != 4) {
                if (i != 6) {
                    obj2 = i != 7 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_AND_CHANGE_EMAIL";
                } else {
                    obj2 = "EMAIL_SIGNIN";
                }
            } else {
                obj2 = "VERIFY_EMAIL";
            }
        } else {
            obj2 = "PASSWORD_RESET";
        }
        this.a = obj2;
    }

    private qo(int i, ActionCodeSettings actionCodeSettings2, String string3, String string4, String string5, String string6) {
        super();
        this.a = "VERIFY_AND_CHANGE_EMAIL";
        r.j(actionCodeSettings2);
        this.w = (ActionCodeSettings)actionCodeSettings2;
        int obj1 = 0;
        this.b = obj1;
        this.c = string4;
        this.v = string5;
        this.x = obj1;
    }

    public static com.google.android.gms.internal.firebase-auth-api.qo b(ActionCodeSettings actionCodeSettings, String string2, String string3) {
        r.f(string2);
        r.f(string3);
        r.j(actionCodeSettings);
        super(7, actionCodeSettings, 0, string3, string2, 0);
        return qoVar2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final ActionCodeSettings a() {
        return this.w;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.qo c(ActionCodeSettings actionCodeSettings) {
        r.j(actionCodeSettings);
        this.w = (ActionCodeSettings)actionCodeSettings;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.qo d(String string) {
        r.f(string);
        this.b = string;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.qo e(String string) {
        this.x = string;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final com.google.android.gms.internal.firebase-auth-api.qo f(String string) {
        r.f(string);
        this.v = string;
        return this;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.lm
    public final String zza() {
        int i2;
        String url;
        String iOSBundle;
        String str2;
        String androidPackageName;
        String androidMinimumVersion;
        Object set;
        boolean equals;
        String str;
        int i;
        JSONObject jSONObject = new JSONObject();
        equals = this.a;
        final int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        switch (equals) {
            case "PASSWORD_RESET":
                i2 = i;
                i2 = -1;
                break;
            case "VERIFY_EMAIL":
                i2 = i5;
                i2 = -1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                i2 = i3;
                i2 = -1;
                break;
            case "EMAIL_SIGNIN":
                i2 = i4;
                i2 = -1;
                break;
            default:
                i2 = -1;
        }
        if (i2 != 0) {
            if (i2 != i5) {
                if (i2 != i4) {
                    if (i2 != i3) {
                    } else {
                        i = 7;
                    }
                } else {
                    i = 6;
                }
            } else {
                i = 4;
            }
        } else {
            i = i5;
        }
        jSONObject.put("requestType", i);
        String str4 = this.b;
        if (str4 != null) {
            jSONObject.put("email", str4);
        }
        String str5 = this.c;
        if (str5 != null) {
            jSONObject.put("newEmail", str5);
        }
        String str6 = this.v;
        if (str6 != null) {
            jSONObject.put("idToken", str6);
        }
        set = this.w;
        jSONObject.put("androidInstallApp", set.getAndroidInstallApp());
        jSONObject.put("canHandleCodeInApp", this.w.canHandleCodeInApp());
        if (set != null && this.w.getUrl() != null) {
            jSONObject.put("androidInstallApp", set.getAndroidInstallApp());
            jSONObject.put("canHandleCodeInApp", this.w.canHandleCodeInApp());
            if (this.w.getUrl() != null) {
                jSONObject.put("continueUrl", this.w.getUrl());
            }
            if (this.w.getIOSBundle() != null) {
                jSONObject.put("iosBundleId", this.w.getIOSBundle());
            }
            if (this.w.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.w.zzd());
            }
            if (this.w.getAndroidPackageName() != null) {
                jSONObject.put("androidPackageName", this.w.getAndroidPackageName());
            }
            if (this.w.getAndroidMinimumVersion() != null) {
                jSONObject.put("androidMinimumVersion", this.w.getAndroidMinimumVersion());
            }
            if (this.w.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.w.zzc());
            }
        }
        String str7 = this.x;
        if (str7 != null) {
            jSONObject.put("tenantId", str7);
        }
        return jSONObject.toString();
    }
}
