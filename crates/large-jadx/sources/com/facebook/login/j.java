package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.f;
import com.facebook.internal.w;
import com.facebook.o;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0008\u0016\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0011\u0008\u0016\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0008\u001a\u00020\tX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0014", d2 = {"Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "Lcom/facebook/login/NativeAppLoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "describeContents", "", "shouldKeepTrackOfMultipleIntents", "", "tryAuthorize", "request", "Lcom/facebook/login/LoginClient$Request;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class j extends com.facebook.login.t {

    public static final Parcelable.Creator<com.facebook.login.j> CREATOR;
    private final String v;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/login/KatanaProxyLoginMethodHandler$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/login/KatanaProxyLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.login.j> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.login.j a(Parcel parcel) {
            n.f(parcel, "source");
            j jVar = new j(parcel);
            return jVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.login.j[] b(int i) {
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
        super(parcel);
        this.v = "katana_proxy_auth";
    }

    public j(com.facebook.login.l l) {
        super(l);
        this.v = "katana_proxy_auth";
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
    public boolean n() {
        return 1;
    }

    @Override // com.facebook.login.t
    public int o(com.facebook.login.l.d l$d) {
        boolean allowsCustomTabAuth;
        int i2;
        String z;
        String str;
        androidx.fragment.app.e eVar;
        int i;
        final Object obj = this;
        n.f(d, "request");
        final int i4 = 1;
        final int i5 = 0;
        if (o.p && f.a() != null && d.g().allowsCustomTabAuth()) {
            if (f.a() != null) {
                i = allowsCustomTabAuth.allowsCustomTabAuth() ? i4 : i5;
            } else {
            }
        } else {
        }
        String str3 = l.k();
        final String str6 = d.a();
        n.e(str6, "request.applicationId");
        final java.util.Set set = d.k();
        n.e(set, "request.permissions");
        str = "e2e";
        n.e(str3, str);
        final com.facebook.login.c cVar = d.d();
        n.e(cVar, "request.defaultAudience");
        String str8 = d.b();
        n.e(str8, "request.authId");
        final String str13 = d.c();
        n.e(str13, "request.authType");
        obj.a(str, str3);
        Iterator iterator = w.p(f().i(), str6, set, str3, d.p(), d.m(), cVar, obj.e(str8), str13, i, d.i(), d.l(), d.n(), d.x(), d.j()).iterator();
        i2 = i5;
        for (Intent next2 : iterator) {
            i2++;
        }
        return i5;
    }
}
