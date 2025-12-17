package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.m;
import kotlin.d0.d.n;
import kotlin.k0.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0010\"\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 L2\u00020\u0001:\u0001LB\u0017\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0085\u0002\u0008\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0008\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\u0016\u0008\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\u0016\u0008\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018\u0012\n\u0008\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001eB\u000f\u0008\u0010\u0012\u0006\u0010\u001f\u001a\u00020 ¢\u0006\u0002\u0010!J\u0008\u0010;\u001a\u00020\u0019H\u0016J\u0013\u0010<\u001a\u00020=2\u0008\u0010>\u001a\u0004\u0018\u00010?H\u0096\u0002J\u0008\u0010@\u001a\u00020\u0019H\u0016J\u0018\u0010A\u001a\u00020=2\u0006\u0010B\u001a\u00020C2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0008\u0010D\u001a\u00020\u0003H\u0007J\r\u0010E\u001a\u00020CH\u0001¢\u0006\u0002\u0008FJ\u0008\u0010G\u001a\u00020\u0003H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020\u0019H\u0016R\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010#R\u0011\u0010\u000c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010&R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010#R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010#R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010#R\u001f\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010#R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u000104¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u00106R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010#R\u001f\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u00088\u00102R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010#R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u00102¨\u0006M", d2 = {"Lcom/facebook/AuthenticationTokenClaims;", "Landroid/os/Parcelable;", "encodedClaims", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "jti", "iss", "aud", "nonce", "exp", "", "iat", "sub", "name", "givenName", "middleName", "familyName", "email", "picture", "userFriends", "", "userBirthday", "userAgeRange", "", "", "userHometown", "userLocation", "userGender", "userLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAud", "()Ljava/lang/String;", "getEmail", "getExp", "()J", "getFamilyName", "getGivenName", "getIat", "getIss", "getJti", "getMiddleName", "getName", "getNonce", "getPicture", "getSub", "getUserAgeRange", "()Ljava/util/Map;", "getUserBirthday", "", "getUserFriends", "()Ljava/util/Set;", "getUserGender", "getUserHometown", "getUserLink", "getUserLocation", "describeContents", "equals", "", "other", "", "hashCode", "isValidClaims", "claimsJson", "Lorg/json/JSONObject;", "toEnCodedString", "toJSONObject", "toJSONObject$facebook_core_release", "toString", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class i implements Parcelable {

    public static final Parcelable.Creator<com.facebook.i> CREATOR;
    public static final com.facebook.i.b M;
    private final String A;
    private final String B;
    private final String C;
    private final String D;
    private final String E;
    private final Set<String> F;
    private final String G;
    private final Map<String, Integer> H;
    private final Map<String, String> I;
    private final Map<String, String> J;
    private final String K;
    private final String L;
    private final String a;
    private final String b;
    private final String c;
    private final String v;
    private final long w;
    private final long x;
    private final String y;
    private final String z;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/AuthenticationTokenClaims$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenClaims;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/AuthenticationTokenClaims;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.i> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.i a(Parcel parcel) {
            n.f(parcel, "source");
            i iVar = new i(parcel);
            return iVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.i[] b(int i) {
            return new i[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0014\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\u0008 J\u001b\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0008#R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0086T¢\u0006\u0002\n\u0000¨\u0006$", d2 = {"Lcom/facebook/AuthenticationTokenClaims$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenClaims;", "JSON_KEY_AUD", "", "JSON_KEY_EMAIL", "JSON_KEY_EXP", "JSON_KEY_FAMILY_NAME", "JSON_KEY_GIVEN_NAME", "JSON_KEY_IAT", "JSON_KEY_ISS", "JSON_KEY_JIT", "JSON_KEY_MIDDLE_NAME", "JSON_KEY_NAME", "JSON_KEY_NONCE", "JSON_KEY_PICTURE", "JSON_KEY_SUB", "JSON_KEY_USER_AGE_RANGE", "JSON_KEY_USER_BIRTHDAY", "JSON_KEY_USER_FRIENDS", "JSON_KEY_USER_GENDER", "JSON_KEY_USER_HOMETOWN", "JSON_KEY_USER_LINK", "JSON_KEY_USER_LOCATION", "MAX_TIME_SINCE_TOKEN_ISSUED", "", "createFromJSONObject", "jsonObject", "Lorg/json/JSONObject;", "createFromJSONObject$facebook_core_release", "getNullableString", "name", "getNullableString$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        public final String a(JSONObject jSONObject, String string2) {
            n.f(jSONObject, "$this$getNullableString");
            n.f(string2, "name");
            if (jSONObject.has(string2)) {
                return jSONObject.getString(string2);
            }
            return null;
        }
    }
    static {
        i.b bVar = new i.b(0);
        i.M = bVar;
        i.a aVar = new i.a();
        i.CREATOR = aVar;
    }

    public i(Parcel parcel) {
        Set unmodifiableSet;
        java.util.HashMap hashMap3;
        Map unmodifiableMap3;
        java.util.HashMap hashMap;
        int unmodifiableMap2;
        HashSet hashSet;
        java.util.HashMap hashMap2;
        Map unmodifiableMap;
        n.f(parcel, "parcel");
        super();
        String string = parcel.readString();
        c0.k(string, "jti");
        this.a = string;
        String string2 = parcel.readString();
        c0.k(string2, "iss");
        this.b = string2;
        String string3 = parcel.readString();
        c0.k(string3, "aud");
        this.c = string3;
        String string4 = parcel.readString();
        c0.k(string4, "nonce");
        this.v = string4;
        this.w = parcel.readLong();
        this.x = parcel.readLong();
        String string5 = parcel.readString();
        c0.k(string5, "sub");
        this.y = string5;
        this.z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        ArrayList stringArrayList = parcel.createStringArrayList();
        unmodifiableMap2 = 0;
        if (stringArrayList != null) {
            hashSet = new HashSet(stringArrayList);
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
        } else {
            unmodifiableSet = unmodifiableMap2;
        }
        this.F = unmodifiableSet;
        this.G = parcel.readString();
        hashMap3 = hashMap3 instanceof HashMap == null ? unmodifiableMap2 : hashMap3;
        if (hashMap3 != null) {
            unmodifiableMap3 = Collections.unmodifiableMap(hashMap3);
        } else {
            unmodifiableMap3 = unmodifiableMap2;
        }
        this.H = unmodifiableMap3;
        f0 f0Var = f0.a;
        hashMap2 = hashMap2 instanceof HashMap == null ? unmodifiableMap2 : hashMap2;
        if (hashMap2 != null) {
            unmodifiableMap = Collections.unmodifiableMap(hashMap2);
        } else {
            unmodifiableMap = unmodifiableMap2;
        }
        this.I = unmodifiableMap;
        hashMap = hashMap instanceof HashMap == null ? unmodifiableMap2 : hashMap;
        if (hashMap != null) {
            unmodifiableMap2 = Collections.unmodifiableMap(hashMap);
        }
        this.J = unmodifiableMap2;
        this.K = parcel.readString();
        this.L = parcel.readString();
    }

    public i(String string, String string2) {
        Set unmodifiableSet;
        Map unmodifiableMap;
        Map unmodifiableMap2;
        Object optJSONObject;
        int unmodifiableMap3;
        String str = "encodedClaims";
        n.f(string, str);
        n.f(string2, "expectedNonce");
        super();
        c0.g(string, str);
        byte[] obj3 = Base64.decode(string, 8);
        n.e(obj3, "decodedBytes");
        String string3 = new String(obj3, d.a);
        obj3 = new JSONObject(string3);
        if (!a(obj3, string2)) {
        } else {
            String obj4 = obj3.getString("jti");
            n.e(obj4, "jsonObj.getString(JSON_KEY_JIT)");
            this.a = obj4;
            obj4 = obj3.getString("iss");
            n.e(obj4, "jsonObj.getString(JSON_KEY_ISS)");
            this.b = obj4;
            obj4 = obj3.getString("aud");
            n.e(obj4, "jsonObj.getString(JSON_KEY_AUD)");
            this.c = obj4;
            obj4 = obj3.getString("nonce");
            n.e(obj4, "jsonObj.getString(JSON_KEY_NONCE)");
            this.v = obj4;
            this.w = obj3.getLong("exp");
            this.x = obj3.getLong("iat");
            obj4 = obj3.getString("sub");
            n.e(obj4, "jsonObj.getString(JSON_KEY_SUB)");
            this.y = obj4;
            obj4 = i.M;
            this.z = obj4.a(obj3, "name");
            this.A = obj4.a(obj3, "given_name");
            this.B = obj4.a(obj3, "middle_name");
            this.C = obj4.a(obj3, "family_name");
            this.D = obj4.a(obj3, "email");
            this.E = obj4.a(obj3, "picture");
            JSONArray optJSONArray = obj3.optJSONArray("user_friends");
            unmodifiableMap3 = 0;
            if (optJSONArray == null) {
                unmodifiableSet = unmodifiableMap3;
            } else {
                unmodifiableSet = Collections.unmodifiableSet(b0.Z(optJSONArray));
            }
            this.F = unmodifiableSet;
            this.G = obj4.a(obj3, "user_birthday");
            JSONObject optJSONObject2 = obj3.optJSONObject("user_age_range");
            if (optJSONObject2 == null) {
                unmodifiableMap = unmodifiableMap3;
            } else {
                unmodifiableMap = Collections.unmodifiableMap(b0.m(optJSONObject2));
            }
            this.H = unmodifiableMap;
            JSONObject optJSONObject3 = obj3.optJSONObject("user_hometown");
            if (optJSONObject3 == null) {
                unmodifiableMap2 = unmodifiableMap3;
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(b0.n(optJSONObject3));
            }
            this.I = unmodifiableMap2;
            optJSONObject = obj3.optJSONObject("user_location");
            if (optJSONObject == null) {
            } else {
                unmodifiableMap3 = Collections.unmodifiableMap(b0.n(optJSONObject));
            }
            this.J = unmodifiableMap3;
            this.K = obj4.a(obj3, "user_gender");
            this.L = obj4.a(obj3, "user_link");
        }
        obj3 = new IllegalArgumentException("Invalid claims".toString());
        throw obj3;
    }

    private final boolean a(JSONObject jSONObject, String string2) {
        int i4;
        int i3;
        int i;
        String optString;
        String str;
        int i2;
        String obj9;
        String str2 = "iss";
        final int i5 = 0;
        if (jSONObject == null) {
            return i5;
        }
        String str8 = "jti";
        String optString2 = jSONObject.optString(str8);
        n.e(optString2, str8);
        int i7 = 1;
        i = optString2.length() == 0 ? i7 : i5;
        if (i != 0) {
            return i5;
        }
        optString = jSONObject.optString(str2);
        n.e(optString, str2);
        i4 = optString.length() == 0 ? i7 : i5;
        if (i4 == 0) {
            URL url = new URL(optString);
            URL url2 = new URL(optString);
            if (z ^= i7 != 0 && z2 ^= i7 != 0) {
                url2 = new URL(optString);
                if (z2 ^= i7 != 0) {
                } else {
                    String str3 = "aud";
                    optString = jSONObject.optString(str3);
                    n.e(optString, str3);
                    i4 = optString.length() == 0 ? i7 : i5;
                    if (i4 == 0) {
                        if (z3 ^= i7 != 0) {
                        } else {
                            long l = (long)i6;
                            Date date = new Date(optLong *= l, obj5);
                            Date date3 = new Date();
                            if (date3.after(date)) {
                                return i5;
                            }
                            Date date2 = new Date(i9 += i2, obj5);
                            Date date4 = new Date();
                            if (date4.after(date2)) {
                                return i5;
                            }
                            String str6 = "sub";
                            optString = jSONObject.optString(str6);
                            n.e(optString, str6);
                            i3 = optString.length() == 0 ? i7 : i5;
                            if (i3 != 0) {
                                try {
                                    return i5;
                                    String str7 = "nonce";
                                    obj9 = jSONObject.optString(str7);
                                    n.e(obj9, str7);
                                    if (obj9.length() == 0) {
                                    } else {
                                    }
                                    i4 = i7;
                                    i4 = i5;
                                    if (i4 == 0 && obj9 ^= i7 != 0) {
                                    }
                                    if (obj9 ^= i7 != 0) {
                                    }
                                    return i7;
                                    return i5;
                                }
                            }
                        }
                    }
                }
            } else {
            }
        }
    }

    @Override // android.os.Parcelable
    public final JSONObject b() {
        Object jSONArray;
        Object jSONObject2;
        Object jSONObject;
        Object jSONObject3;
        String str;
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("jti", this.a);
        jSONObject4.put("iss", this.b);
        jSONObject4.put("aud", this.c);
        str = "nonce";
        jSONObject4.put(str, this.v);
        jSONObject4.put("exp", this.w);
        jSONObject4.put("iat", this.x);
        String str6 = this.y;
        if (str6 != null) {
            jSONObject4.put("sub", str6);
        }
        String str7 = this.z;
        if (str7 != null) {
            jSONObject4.put("name", str7);
        }
        String str8 = this.A;
        if (str8 != null) {
            jSONObject4.put("given_name", str8);
        }
        String str9 = this.B;
        if (str9 != null) {
            jSONObject4.put("middle_name", str9);
        }
        String str10 = this.C;
        if (str10 != null) {
            jSONObject4.put("family_name", str10);
        }
        String str11 = this.D;
        if (str11 != null) {
            jSONObject4.put("email", str11);
        }
        String str12 = this.E;
        if (str12 != null) {
            jSONObject4.put("picture", str12);
        }
        if (this.F != null) {
            jSONArray = new JSONArray(this.F);
            jSONObject4.put("user_friends", jSONArray);
        }
        String str13 = this.G;
        if (str13 != null) {
            jSONObject4.put("user_birthday", str13);
        }
        if (this.H != null) {
            jSONObject2 = new JSONObject(this.H);
            jSONObject4.put("user_age_range", jSONObject2);
        }
        if (this.I != null) {
            jSONObject = new JSONObject(this.I);
            jSONObject4.put("user_hometown", jSONObject);
        }
        if (this.J != null) {
            jSONObject3 = new JSONObject(this.J);
            jSONObject4.put("user_location", jSONObject3);
        }
        String str14 = this.K;
        if (str14 != null) {
            jSONObject4.put("user_gender", str14);
        }
        String str15 = this.L;
        if (str15 != null) {
            jSONObject4.put("user_link", str15);
        }
        return jSONObject4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i;
        boolean cmp;
        String str;
        long l;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof i) {
            return i2;
        }
        if (n.b(this.a, object.a) && n.b(this.b, object.b) && n.b(this.c, object.c) && n.b(this.v, object.v) && Long.compare(str, l) == 0 && Long.compare(str, l) == 0 && n.b(this.y, object.y) && n.b(this.z, object.z) && n.b(this.A, object.A) && n.b(this.B, object.B) && n.b(this.C, object.C) && n.b(this.D, object.D) && n.b(this.E, object.E) && n.b(this.F, object.F) && n.b(this.G, object.G) && n.b(this.H, object.H) && n.b(this.I, object.I) && n.b(this.J, object.J) && n.b(this.K, object.K) && n.b(this.L, object.L)) {
            if (n.b(this.b, object.b)) {
                if (n.b(this.c, object.c)) {
                    if (n.b(this.v, object.v)) {
                        if (Long.compare(str, l) == 0) {
                            if (Long.compare(str, l) == 0) {
                                if (n.b(this.y, object.y)) {
                                    if (n.b(this.z, object.z)) {
                                        if (n.b(this.A, object.A)) {
                                            if (n.b(this.B, object.B)) {
                                                if (n.b(this.C, object.C)) {
                                                    if (n.b(this.D, object.D)) {
                                                        if (n.b(this.E, object.E)) {
                                                            if (n.b(this.F, object.F)) {
                                                                if (n.b(this.G, object.G)) {
                                                                    if (n.b(this.H, object.H)) {
                                                                        if (n.b(this.I, object.I)) {
                                                                            if (n.b(this.J, object.J)) {
                                                                                if (n.b(this.K, object.K)) {
                                                                                    if (n.b(this.L, object.L)) {
                                                                                    } else {
                                                                                        i = i2;
                                                                                    }
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
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i8;
        int i11;
        int i9;
        int i12;
        int i10;
        int i6;
        int i5;
        int i13;
        int i2;
        int i;
        int i4;
        int i3;
        int i7;
        String str6 = this.z;
        i7 = 0;
        if (str6 != null) {
            i8 = str6.hashCode();
        } else {
            i8 = i7;
        }
        String str7 = this.A;
        if (str7 != null) {
            i11 = str7.hashCode();
        } else {
            i11 = i7;
        }
        String str8 = this.B;
        if (str8 != null) {
            i9 = str8.hashCode();
        } else {
            i9 = i7;
        }
        String str9 = this.C;
        if (str9 != null) {
            i12 = str9.hashCode();
        } else {
            i12 = i7;
        }
        String str10 = this.D;
        if (str10 != null) {
            i10 = str10.hashCode();
        } else {
            i10 = i7;
        }
        String str11 = this.E;
        if (str11 != null) {
            i6 = str11.hashCode();
        } else {
            i6 = i7;
        }
        Set set = this.F;
        if (set != null) {
            i5 = set.hashCode();
        } else {
            i5 = i7;
        }
        String str12 = this.G;
        if (str12 != null) {
            i13 = str12.hashCode();
        } else {
            i13 = i7;
        }
        Map map = this.H;
        if (map != null) {
            i2 = map.hashCode();
        } else {
            i2 = i7;
        }
        Map map2 = this.I;
        if (map2 != null) {
            i = map2.hashCode();
        } else {
            i = i7;
        }
        Map map3 = this.J;
        if (map3 != null) {
            i4 = map3.hashCode();
        } else {
            i4 = i7;
        }
        String str13 = this.K;
        if (str13 != null) {
            i3 = str13.hashCode();
        } else {
            i3 = i7;
        }
        String str14 = this.L;
        if (str14 != null) {
            i7 = str14.hashCode();
        }
        return i59 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        String string = b().toString();
        n.e(string, "claimsJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        long l;
        int obj4;
        n.f(parcel, "dest");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
        parcel.writeLong(this.w);
        parcel.writeLong(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        if (this.F == null) {
            parcel.writeStringList(0);
        } else {
            obj4 = new ArrayList(this.F);
            parcel.writeStringList(obj4);
        }
        parcel.writeString(this.G);
        parcel.writeMap(this.H);
        parcel.writeMap(this.I);
        parcel.writeMap(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
    }
}
