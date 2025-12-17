package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 *2\u00020\u0001:\u0001*BO\u0008\u0017\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bB\u000f\u0008\u0010\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eB\u000f\u0008\u0012\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cJ\u0008\u0010$\u001a\u00020\u001cH\u0016J\u0008\u0010%\u001a\u0004\u0018\u00010\rJ\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u001cH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0013R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0017¨\u0006+", d2 = {"Lcom/facebook/Profile;", "Landroid/os/Parcelable;", "id", "", "firstName", "middleName", "lastName", "name", "linkUri", "Landroid/net/Uri;", "pictureUri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;)V", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getFirstName", "()Ljava/lang/String;", "getId", "getLastName", "getLinkUri", "()Landroid/net/Uri;", "getMiddleName", "getName", "getPictureUri", "describeContents", "", "equals", "", "other", "", "getProfilePictureUri", "width", "height", "hashCode", "toJSONObject", "writeToParcel", "", "dest", "flags", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class w implements Parcelable {

    public static final com.facebook.w.b A;
    public static final Parcelable.Creator<com.facebook.w> CREATOR;
    private static final String z;
    private final String a;
    private final String b;
    private final String c;
    private final String v;
    private final String w;
    private final Uri x;
    private final Uri y;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/Profile$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/Profile;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/Profile;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.w> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.w a(Parcel parcel) {
            n.f(parcel, "source");
            w wVar = new w(parcel, 0);
            return wVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.w[] b(int i) {
            return new w[i];
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

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0012\u001a\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0007R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lcom/facebook/Profile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/Profile;", "FIRST_NAME_KEY", "", "ID_KEY", "LAST_NAME_KEY", "LINK_URI_KEY", "MIDDLE_NAME_KEY", "NAME_KEY", "PICTURE_URI_KEY", "TAG", "fetchProfileForCurrentAccessToken", "", "getCurrentProfile", "setCurrentProfile", "profile", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        public final void a() {
            Object cVar;
            Object aVar;
            cVar = a.H;
            aVar = cVar.e();
            if (aVar != null && !cVar.g()) {
                if (!cVar.g()) {
                    c(0);
                }
                aVar = new w.b.a();
                b0.C(aVar.m(), aVar);
            }
        }

        public final com.facebook.w b() {
            return y.e.a().c();
        }

        public final void c(com.facebook.w w) {
            y.e.a().f(w);
        }
    }
    static {
        w.b bVar = new w.b(0);
        w.A = bVar;
        String simpleName = w.class.getSimpleName();
        n.e(simpleName, "Profile::class.java.simpleName");
        w.z = simpleName;
        w.a aVar = new w.a();
        w.CREATOR = aVar;
    }

    private w(Parcel parcel) {
        int parse2;
        Uri parse;
        super();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        String string6 = parcel.readString();
        if (string6 == null) {
            parse2 = parse;
        } else {
            parse2 = Uri.parse(string6);
        }
        this.x = parse2;
        final String obj3 = parcel.readString();
        if (obj3 == null) {
        } else {
            parse = Uri.parse(obj3);
        }
        this.y = parse;
    }

    public w(Parcel parcel, g g2) {
        super(parcel);
    }

    public w(String string, String string2, String string3, String string4, String string5, Uri uri6, Uri uri7) {
        super();
        c0.k(string, "id");
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.v = string4;
        this.w = string5;
        this.x = uri6;
        this.y = uri7;
    }

    public w(JSONObject jSONObject) {
        int parse;
        Uri parse2;
        n.f(jSONObject, "jsonObject");
        super();
        parse2 = 0;
        this.a = jSONObject.optString("id", parse2);
        this.b = jSONObject.optString("first_name", parse2);
        this.c = jSONObject.optString("middle_name", parse2);
        this.v = jSONObject.optString("last_name", parse2);
        this.w = jSONObject.optString("name", parse2);
        String optString6 = jSONObject.optString("link_uri", parse2);
        if (optString6 == null) {
            parse = parse2;
        } else {
            parse = Uri.parse(optString6);
        }
        this.x = parse;
        final String obj3 = jSONObject.optString("picture_uri", parse2);
        if (obj3 == null) {
        } else {
            parse2 = Uri.parse(obj3);
        }
        this.y = parse2;
    }

    public static final String a() {
        return w.z;
    }

    public static final void b() {
        w.A.a();
    }

    @Override // android.os.Parcelable
    public final JSONObject c() {
        Object string;
        Object string2;
        String str;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.a);
        jSONObject.put("first_name", this.b);
        jSONObject.put("middle_name", this.c);
        jSONObject.put("last_name", this.v);
        jSONObject.put("name", this.w);
        string = this.x;
        if (string != null) {
            jSONObject.put("link_uri", string.toString());
        }
        string2 = this.y;
        if (string2 != null) {
            jSONObject.put("picture_uri", string2.toString());
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        int i;
        boolean str;
        String str2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (!object instanceof w) {
            return i2;
        }
        str = this.a;
        if (str == null) {
            if (obj13.a != null) {
                if (n.b(str, obj.a)) {
                    str = this.b;
                    if (str == null) {
                        if (obj12.b != null) {
                            if (n.b(str, obj2.b)) {
                                str = this.c;
                                if (str == null) {
                                    if (obj3.c != null) {
                                        if (n.b(str, obj4.c)) {
                                            str = this.v;
                                            if (str == null) {
                                                if (obj5.v != null) {
                                                    if (n.b(str, obj6.v)) {
                                                        str = this.w;
                                                        if (str == null) {
                                                            if (obj7.w != null) {
                                                                if (n.b(str, obj8.w)) {
                                                                    str = this.x;
                                                                    if (str == null) {
                                                                        if (obj10.x != null) {
                                                                            if (n.b(str, obj11.x)) {
                                                                                str = this.y;
                                                                                if (str == null) {
                                                                                    if (obj9.y != null) {
                                                                                        if (n.b(str, object.y)) {
                                                                                        } else {
                                                                                            i = i2;
                                                                                        }
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
        int i2;
        String str2;
        String str;
        String str4;
        String str3;
        Uri uri2;
        Uri uri;
        int i;
        String str5 = this.a;
        if (str5 != null) {
            i2 = str5.hashCode();
        } else {
            i2 = 0;
        }
        str2 = this.b;
        if (str2 != null) {
            i4 += str2;
        }
        str = this.c;
        if (str != null) {
            i5 += str;
        }
        str4 = this.v;
        if (str4 != null) {
            i9 += str4;
        }
        str3 = this.w;
        if (str3 != null) {
            i8 += str3;
        }
        uri2 = this.x;
        if (uri2 != null) {
            i6 += uri2;
        }
        uri = this.y;
        if (uri != null) {
            i7 += uri;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int string;
        String obj3;
        n.f(parcel, "dest");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        obj3 = this.x;
        if (obj3 != null) {
            obj3 = obj3.toString();
        } else {
            obj3 = string;
        }
        parcel.writeString(obj3);
        obj3 = this.y;
        if (obj3 != null) {
            string = obj3.toString();
        }
        parcel.writeString(string);
    }
}
