package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.facebook.internal.c0;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.d;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0008\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\u0008\u0010\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001f\u0008\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0008\u0010\u001c\u001a\u00020\u0003H\u0007J\r\u0010\u001d\u001a\u00020\tH\u0000¢\u0006\u0002\u0008\u001eJ\u0008\u0010\u001f\u001a\u00020\u0003H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0014H\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010¨\u0006%", d2 = {"Lcom/facebook/AuthenticationTokenHeader;", "Landroid/os/Parcelable;", "encodedHeaderString", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "alg", "typ", "kid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlg", "()Ljava/lang/String;", "getKid", "getTyp", "describeContents", "", "equals", "", "other", "", "hashCode", "isValidHeader", "headerString", "toEnCodedString", "toJSONObject", "toJSONObject$facebook_core_release", "toString", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class j implements Parcelable {

    public static final Parcelable.Creator<com.facebook.j> CREATOR;
    private final String a;
    private final String b;
    private final String c;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/AuthenticationTokenHeader$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/AuthenticationTokenHeader;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/AuthenticationTokenHeader;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.j> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.j a(Parcel parcel) {
            n.f(parcel, "source");
            j jVar = new j(parcel);
            return jVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.j[] b(int i) {
            return new j[i];
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
    static {
        j.a aVar = new j.a();
        j.CREATOR = aVar;
    }

    public j(Parcel parcel) {
        n.f(parcel, "parcel");
        super();
        String string = parcel.readString();
        c0.k(string, "alg");
        this.a = string;
        String string2 = parcel.readString();
        c0.k(string2, "typ");
        this.b = string2;
        final String obj3 = parcel.readString();
        c0.k(obj3, "kid");
        this.c = obj3;
    }

    public j(String string) {
        n.f(string, "encodedHeaderString");
        super();
        if (!b(string)) {
        } else {
            byte[] obj3 = Base64.decode(string, 0);
            n.e(obj3, "decodedBytes");
            String string2 = new String(obj3, d.a);
            obj3 = new JSONObject(string2);
            String string3 = obj3.getString("alg");
            n.e(string3, "jsonObj.getString(\"alg\")");
            this.a = string3;
            String string4 = obj3.getString("typ");
            n.e(string4, "jsonObj.getString(\"typ\")");
            this.b = string4;
            obj3 = obj3.getString("kid");
            n.e(obj3, "jsonObj.getString(\"kid\")");
            this.c = obj3;
        }
        obj3 = new IllegalArgumentException("Invalid Header".toString());
        throw obj3;
    }

    private final boolean b(String string) {
        int i2;
        int i3;
        int i;
        int i4;
        int obj6;
        String str = "alg";
        c0.g(string, "encodedHeaderString");
        i = 0;
        obj6 = Base64.decode(string, i);
        n.e(obj6, "decodedBytes");
        String string2 = new String(obj6, d.a);
        obj6 = new JSONObject(string2);
        String optString = obj6.optString(str);
        n.e(optString, str);
        int i5 = 1;
        i2 = optString.length() > 0 ? i5 : i;
        if (i2 != 0 && n.b(optString, "RS256")) {
            i3 = n.b(optString, "RS256") ? i5 : i;
        } else {
        }
        String optString2 = obj6.optString("kid");
        n.e(optString2, "jsonObj.optString(\"kid\")");
        i4 = optString2.length() > 0 ? i5 : i;
        obj6 = obj6.optString("typ");
        n.e(obj6, "jsonObj.optString(\"typ\")");
        obj6 = obj6.length() > 0 ? i5 : i;
        if (i3 != 0 && i4 != 0 && obj6 != null) {
            if (i4 != 0) {
                if (obj6 != null) {
                    i = i5;
                }
            }
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.a);
        jSONObject.put("typ", this.b);
        jSONObject.put("kid", this.c);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i;
        String z;
        String str;
        boolean obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof j) {
            return i2;
        }
        if (n.b(this.a, object.a) && n.b(this.b, object.b) && n.b(this.c, object.c)) {
            if (n.b(this.b, object.b)) {
                if (n.b(this.c, object.c)) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i8 += i3;
    }

    @Override // android.os.Parcelable
    public String toString() {
        String string = c().toString();
        n.e(string, "headerJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
