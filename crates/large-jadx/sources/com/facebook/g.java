package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.c0;
import com.facebook.internal.i0.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u000f\u0008\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008B\u000f\u0008\u0010\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\u0008\u0010\u001f\u001a\u00020\u001aH\u0016J(\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002J\r\u0010%\u001a\u00020\nH\u0000¢\u0006\u0002\u0008&J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u001aH\u0016R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0011¨\u0006,", d2 = {"Lcom/facebook/AuthenticationToken;", "Landroid/os/Parcelable;", "token", "", "expectedNonce", "(Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "claims", "Lcom/facebook/AuthenticationTokenClaims;", "getClaims", "()Lcom/facebook/AuthenticationTokenClaims;", "getExpectedNonce", "()Ljava/lang/String;", "header", "Lcom/facebook/AuthenticationTokenHeader;", "getHeader", "()Lcom/facebook/AuthenticationTokenHeader;", "signature", "getSignature", "getToken", "describeContents", "", "equals", "", "other", "", "hashCode", "isValidSignature", "headerString", "claimsString", "sigString", "kid", "toJSONObject", "toJSONObject$facebook_core_release", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class g implements Parcelable {

    public static final Parcelable.Creator<com.facebook.g> CREATOR;
    public static final com.facebook.g.b x;
    private final String a;
    private final String b;
    private final com.facebook.j c;
    private final com.facebook.i v;
    private final String w;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/AuthenticationToken$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationToken;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/AuthenticationToken;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.g> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.g a(Parcel parcel) {
            n.f(parcel, "source");
            g gVar = new g(parcel);
            return gVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.g[] b(int i) {
            return new g[i];
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

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\u0008H\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0008H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/AuthenticationToken$Companion;", "", "()V", "AUTHENTICATION_TOKEN_KEY", "", "CLAIMS_KEY", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationToken;", "EXPECTED_NONCE_KEY", "HEADER_KEY", "SIGNATURE_KEY", "TOKEN_STRING_KEY", "getCurrentAuthenticationToken", "setCurrentAuthenticationToken", "", "authenticationToken", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        public final void a(com.facebook.g g) {
            AuthenticationTokenManager.e.a().e(g);
        }
    }
    static {
        g.b bVar = new g.b(0);
        g.x = bVar;
        g.a aVar = new g.a();
        g.CREATOR = aVar;
    }

    public g(Parcel parcel) {
        n.f(parcel, "parcel");
        super();
        String string = parcel.readString();
        c0.k(string, "token");
        this.a = string;
        String string2 = parcel.readString();
        c0.k(string2, "expectedNonce");
        this.b = string2;
        Parcelable parcelable = parcel.readParcelable(j.class.getClassLoader());
        String str5 = "Required value was null.";
        if (parcelable == null) {
        } else {
            this.c = (j)parcelable;
            Parcelable parcelable2 = parcel.readParcelable(i.class.getClassLoader());
            if (parcelable2 == null) {
            } else {
                this.v = (i)parcelable2;
                String obj3 = parcel.readString();
                c0.k(obj3, "signature");
                this.w = obj3;
            }
            obj3 = new IllegalStateException(str5.toString());
            throw obj3;
        }
        obj3 = new IllegalStateException(str5.toString());
        throw obj3;
    }

    public g(String string, String string2) {
        int i;
        String str = "token";
        n.f(string, str);
        String str3 = "expectedNonce";
        n.f(string2, str3);
        super();
        c0.g(string, str);
        c0.g(string2, str3);
        int i3 = 0;
        List list = l.E0(string, /* result */, i3, 0, 6, 0);
        int i2 = 1;
        i = list.size() == 3 ? i2 : i3;
        if (i == 0) {
        } else {
            Object obj3 = list.get(i3);
            Object obj4 = list.get(i2);
            Object obj = list.get(2);
            this.a = string;
            this.b = string2;
            j obj8 = new j((String)obj3);
            this.c = obj8;
            i iVar = new i((String)obj4, string2);
            this.v = iVar;
            if (!a(obj3, obj4, (String)obj, obj8.a())) {
            } else {
                this.w = obj;
            }
            obj8 = new IllegalArgumentException("Invalid Signature".toString());
            throw obj8;
        }
        obj8 = new IllegalArgumentException("Invalid IdToken string".toString());
        throw obj8;
    }

    private final boolean a(String string, String string2, String string3, String string4) {
        String obj6 = b.b(string4);
        if (obj6 != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append('.');
                stringBuilder.append(string2);
                return b.c(b.a(obj6), stringBuilder.toString(), string3);
                return 0;
            }
        }
    }

    public static final void b(com.facebook.g g) {
        g.x.a(g);
    }

    @Override // android.os.Parcelable
    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token_string", this.a);
        jSONObject.put("expected_nonce", this.b);
        jSONObject.put("header", this.c.c());
        jSONObject.put("claims", this.v.b());
        jSONObject.put("signature", this.w);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object str;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof g) {
            return i2;
        }
        if (n.b(this.a, object.a) && n.b(this.b, object.b) && n.b(this.c, object.c) && n.b(this.v, object.v) && n.b(this.w, object.w)) {
            if (n.b(this.b, object.b)) {
                if (n.b(this.c, object.c)) {
                    if (n.b(this.v, object.v)) {
                        if (n.b(this.w, object.w)) {
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
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i14 += i5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i2);
        parcel.writeParcelable(this.v, i2);
        parcel.writeString(this.w);
    }
}
