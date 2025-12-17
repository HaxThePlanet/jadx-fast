package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.f;
import com.facebook.internal.w;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0014\u0010\u0008\u001a\u00020\tX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0018", d2 = {"Lcom/facebook/login/InstagramAppLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "describeContents", "", "getTokenSource", "Lcom/facebook/AccessTokenSource;", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "writeToParcel", "", "dest", "flags", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class i extends com.facebook.login.t {

    public static final Parcelable.Creator<com.facebook.login.i> CREATOR;
    private final String v;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/login/InstagramAppLoginMethodHandler$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/InstagramAppLoginMethodHandler;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/login/InstagramAppLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.login.i> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.login.i a(Parcel parcel) {
            n.f(parcel, "source");
            i iVar = new i(parcel);
            return iVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.login.i[] b(int i) {
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
    static {
        i.a aVar = new i.a();
        i.CREATOR = aVar;
    }

    public i(Parcel parcel) {
        n.f(parcel, "source");
        super(parcel);
        this.v = "instagram_login";
    }

    public i(com.facebook.login.l l) {
        n.f(l, "loginClient");
        super(l);
        this.v = "instagram_login";
    }

    @Override // com.facebook.login.t
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.t
    public String h() {
        return this.v;
    }

    @Override // com.facebook.login.t
    public int o(com.facebook.login.l.d l$d) {
        final Object obj = this;
        n.f(d, "request");
        String str2 = l.k();
        androidx.fragment.app.e eVar2 = f().i();
        n.e(eVar2, "loginClient.activity");
        String str5 = d.a();
        n.e(str5, "request.applicationId");
        java.util.Set set2 = d.k();
        n.e(set2, "request.permissions");
        final String str16 = "e2e";
        n.e(str2, str16);
        final com.facebook.login.c cVar = d.d();
        n.e(cVar, "request.defaultAudience");
        String str10 = d.b();
        n.e(str10, "request.authId");
        String str13 = d.c();
        n.e(str13, "request.authType");
        obj.a(str16, str2);
        return obj.x(w.l(eVar2, str5, set2, str2, d.p(), d.m(), cVar, obj.e(str10), str13, d.i(), d.l(), d.n(), d.x()), l.p());
    }

    @Override // com.facebook.login.t
    public f s() {
        return f.INSTAGRAM_APPLICATION_WEB;
    }

    @Override // com.facebook.login.t
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        super.writeToParcel(parcel, i2);
    }
}
