package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.util.n;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fp extends a implements com.google.android.gms.internal.firebase-auth-api.mm<com.google.android.gms.internal.firebase-auth-api.fp> {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.fp> CREATOR;
    private static final String w;
    private String a;
    private String b;
    private String c;
    private com.google.android.gms.internal.firebase-auth-api.xo v;
    static {
        fp.w = fp.class.getSimpleName();
        gp gpVar = new gp();
        fp.CREATOR = gpVar;
    }

    fp(String string, String string2, String string3, com.google.android.gms.internal.firebase-auth-api.xo xo4) {
        super();
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.v = xo4;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.xo j2() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean k2() {
        if (this.a != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i7 = 0;
        b.o(parcel, 2, this.a, i7);
        b.o(parcel, 3, this.b, i7);
        b.o(parcel, 4, this.c, i7);
        b.n(parcel, 5, this.v, i2, i7);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mm zza(String string) {
        Object str;
        String str2;
        boolean optString;
        int i2;
        int i;
        String equals;
        int i4;
        int i3;
        int i5;
        final Object obj = this;
        str = "mfaInfo";
        JSONObject jSONObject = new JSONObject(string);
        obj.a = n.a(jSONObject.optString("email"));
        obj.b = n.a(jSONObject.optString("newEmail"));
        int optInt = jSONObject.optInt("reqType");
        equals = "REVERT_SECOND_FACTOR_ADDITION";
        final String str11 = "VERIFY_AND_CHANGE_EMAIL";
        final String str12 = "EMAIL_SIGNIN";
        final String str13 = "RECOVER_EMAIL";
        final String str14 = "VERIFY_EMAIL";
        final String str15 = "PASSWORD_RESET";
        final int i8 = 1;
        if (optInt != i8) {
            switch (optInt) {
                case 4:
                    str2 = str14;
                    break;
                case 5:
                    str2 = str13;
                    break;
                case 6:
                    str2 = str12;
                    break;
                case 7:
                    str2 = str11;
                    break;
                case 8:
                    str2 = equals;
                    break;
                default:
                    str2 = 0;
            }
        } else {
            str2 = str15;
        }
        obj.c = str2;
        if (TextUtils.isEmpty(str2)) {
            optString = jSONObject.optString("requestType");
            i5 = 4;
            i = 3;
            i3 = 2;
            switch (optString) {
                case "REVERT_SECOND_FACTOR_ADDITION":
                    equals = 5;
                    equals = -1;
                    break;
                case "PASSWORD_RESET":
                    equals = i8;
                    equals = -1;
                    break;
                case "VERIFY_EMAIL":
                    equals = 0;
                    equals = -1;
                    break;
                case "VERIFY_AND_CHANGE_EMAIL":
                    equals = i;
                    equals = -1;
                    break;
                case "EMAIL_SIGNIN":
                    equals = i3;
                    equals = -1;
                    break;
                case "RECOVER_EMAIL":
                    equals = i5;
                    equals = -1;
                    break;
                default:
                    equals = -1;
            }
            if (equals != 0 && equals != i8 && equals != i3 && equals != i && equals != i5 && equals != 5) {
                if (equals != i8) {
                    if (equals != i3) {
                        if (equals != i) {
                            if (equals != i5) {
                                i2 = equals != 5 ? 0 : optString;
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
            obj.c = i2;
        }
        if (jSONObject.has(str)) {
            obj.v = xo.k2(jSONObject.optJSONObject(str));
        }
        return obj;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zze() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzg() {
        if (this.v != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzh() {
        if (this.b != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzi() {
        if (this.c != null) {
            return 1;
        }
        return 0;
    }
}
