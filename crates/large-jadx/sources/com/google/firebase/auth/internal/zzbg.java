package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.android.gms.internal.firebase-auth-api.zzll;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbg {

    private final Context zza;
    private final String zzb;
    private final SharedPreferences zzc;
    private final a zzd;
    public zzbg(Context context, String string2) {
        super();
        r.j(context);
        r.f(string2);
        this.zzb = string2;
        Context obj3 = context.getApplicationContext();
        this.zza = obj3;
        Object[] arr = new Object[1];
        final int i2 = 0;
        arr[i2] = string2;
        this.zzc = obj3.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", arr), i2);
        obj3 = new a("StorageHelpers", new String[i2]);
        this.zzd = obj3;
    }

    private final com.google.firebase.auth.internal.zzx zzf(JSONObject jSONObject) {
        JSONArray jSONArray;
        Object arrayList;
        int str2;
        boolean phoneMultiFactorInfo;
        com.google.firebase.auth.internal.zzt zzt2;
        boolean empty;
        android.os.Parcelable.Creator jSONObject2;
        String optString8;
        boolean boolean;
        String str5;
        String str;
        int i;
        String str3;
        String str4;
        android.os.Parcelable.Creator cREATOR;
        com.google.firebase.auth.internal.zzt zzt;
        String optString4;
        String optString3;
        String optString;
        String optString6;
        String optString5;
        String optString7;
        boolean optBoolean;
        String optString2;
        jSONArray = jSONObject;
        String str7 = "enrollmentTimestamp";
        arrayList = "userMultiFactorInfo";
        str2 = "userMetadata";
        optString8 = jSONArray.getString("cachedTokenState");
        str5 = "2";
        String string3 = jSONArray.getString("version");
        if (string3 != null) {
            str5 = string3;
        }
        JSONArray jSONArray2 = jSONArray.getJSONArray("userInfos");
        final int length = jSONArray2.length();
        ArrayList arrayList2 = new ArrayList(length);
        i = 0;
        str3 = "displayName";
        str4 = "phoneNumber";
        while (i < length) {
            cREATOR = zzt.CREATOR;
            JSONObject jSONObject4 = new JSONObject(jSONArray2.getString(i));
            super(jSONObject4.optString("userId"), jSONObject4.optString("providerId"), jSONObject4.optString("email"), jSONObject4.optString(str4), jSONObject4.optString(str3), jSONObject4.optString("photoUrl"), jSONObject4.optBoolean("isEmailVerified"), jSONObject4.optString("rawUserInfo"));
            arrayList2.add(zzt2);
            i++;
            str3 = "displayName";
            str4 = "phoneNumber";
        }
        zzx zzx = new zzx(FirebaseApp.getInstance(jSONArray.getString("applicationName")), arrayList2);
        if (!TextUtils.isEmpty(optString8)) {
            zzx.zzh(to.l2(optString8));
        }
        try {
            if (!jSONArray.getBoolean("anonymous")) {
            }
            zzx.zzm();
            zzx.zzl(str5);
            if (jSONArray.has(str2)) {
            }
            JSONObject jSONObject3 = jSONArray.getJSONObject(str2);
            jSONObject2 = zzz.CREATOR;
            if (jSONObject3 == null) {
            } else {
            }
            str2 = 0;
            str2 = new zzz(jSONObject3.getLong("lastSignInTimestamp"), optString8, jSONObject3.getLong("creationTimestamp"), str5);
            if (str2 != null) {
            }
            zzx.zzr(str2);
            jSONArray = jSONArray.getJSONArray(arrayList);
            if (jSONArray.has(arrayList) && jSONArray != null) {
            }
            jSONArray = jSONArray.getJSONArray(arrayList);
            if (jSONArray != null) {
            }
            arrayList = new ArrayList();
            str = 0;
            while (str < jSONArray.length()) {
                jSONObject2 = new JSONObject(jSONArray.getString(str));
                phoneMultiFactorInfo = 0;
                arrayList.add(phoneMultiFactorInfo);
                str++;
                android.os.Parcelable.Creator cREATOR2 = PhoneMultiFactorInfo.CREATOR;
                super(jSONObject2.optString("uid"), jSONObject2.optString(str3), jSONObject2.optLong(str7), optString6, jSONObject2.optString(str4));
            }
            jSONObject2 = new JSONObject(jSONArray.getString(str));
            if ("phone".equals(jSONObject2.optString("factorIdKey"))) {
            } else {
            }
            cREATOR2 = PhoneMultiFactorInfo.CREATOR;
            if (!jSONObject2.has(str7)) {
            } else {
            }
            super(jSONObject2.optString("uid"), jSONObject2.optString(str3), jSONObject2.optLong(str7), optString6, jSONObject2.optString(str4));
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
            throw illegalArgumentException;
            phoneMultiFactorInfo = 0;
            arrayList.add(phoneMultiFactorInfo);
            str++;
            zzx.zzi(arrayList);
            return zzx;
            String str6 = this;
            String str9 = str6.zzd;
            str9.j(th);
            str9 = null;
            return str9;
        } catch (org.json.JSONException jSON) {
        } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBounds1) {
        } catch (java.lang.IllegalArgumentException iae2) {
        } catch (com.google.android.gms.internal.firebase-auth-api.zzll e3) {
        }
    }

    public final FirebaseUser zza() {
        String equalsIgnoreCase;
        boolean str;
        equalsIgnoreCase = "type";
        final int i = 0;
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", i);
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        JSONObject jSONObject = new JSONObject(string);
        if (jSONObject.has(equalsIgnoreCase) && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString(equalsIgnoreCase))) {
            if ("com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString(equalsIgnoreCase))) {
                return zzf(jSONObject);
            }
        }
        return i;
    }

    public final to zzb(FirebaseUser firebaseUser) {
        r.j(firebaseUser);
        Object[] arr = new Object[1];
        int i2 = 0;
        String obj4 = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), i2);
        if (obj4 != null) {
            return to.l2(obj4);
        }
        return i2;
    }

    public final void zzc(String string) {
        this.zzc.edit().remove(string).apply();
    }

    public final void zzd(FirebaseUser firebaseUser) {
        boolean empty;
        int assignableFrom;
        Object jSONArray2;
        Object metadata;
        boolean jSONArray;
        String str;
        Object str2;
        int size2;
        int size;
        Object obj7;
        r.j(firebaseUser);
        JSONObject jSONObject = new JSONObject();
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            assignableFrom = 0;
            jSONObject.put("cachedTokenState", (zzx)firebaseUser.zzf());
            jSONObject.put("applicationName", firebaseUser.zza().getName());
            jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (firebaseUser.zzo() != null) {
                jSONArray2 = new JSONArray();
                List list = firebaseUser.zzo();
                size2 = assignableFrom;
                while (size2 < list.size()) {
                    jSONArray2.put((zzt)list.get(size2).zzb());
                    size2++;
                }
                jSONObject.put("userInfos", jSONArray2);
            }
            jSONObject.put("anonymous", firebaseUser.isAnonymous());
            jSONObject.put("version", "2");
            if (firebaseUser.getMetadata() != null) {
                jSONObject.put("userMetadata", (zzz)firebaseUser.getMetadata().zza());
            }
            zzac zzac = new zzac(firebaseUser);
            obj7 = zzac.getEnrolledFactors();
            if (!obj7.isEmpty()) {
                jSONArray = new JSONArray();
                str2 = assignableFrom;
                while (str2 < obj7.size()) {
                    jSONArray.put((MultiFactorInfo)obj7.get(str2).toJson());
                    str2++;
                }
                jSONObject.put("userMultiFactorInfo", jSONArray);
            }
            obj7 = jSONObject.toString();
        } else {
            obj7 = 0;
        }
        if (!TextUtils.isEmpty(obj7)) {
            this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", obj7).apply();
        }
    }

    public final void zze(FirebaseUser firebaseUser, to to2) {
        r.j(firebaseUser);
        r.j(to2);
        Object[] arr = new Object[1];
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), to2.zzh()).apply();
    }
}
