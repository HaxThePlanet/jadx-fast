package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.f;
import com.facebook.internal.b0;
import com.facebook.internal.b0.a;
import com.facebook.internal.x;
import com.facebook.internal.x.b;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import kotlin.y.q0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0008\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0016\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001b", d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "loginClient", "Lcom/facebook/login/LoginClient;", "(Lcom/facebook/login/LoginClient;)V", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getTokenClient", "Lcom/facebook/login/GetTokenClient;", "nameForLogging", "", "getNameForLogging", "()Ljava/lang/String;", "cancel", "", "complete", "request", "Lcom/facebook/login/LoginClient$Request;", "result", "Landroid/os/Bundle;", "describeContents", "", "getTokenCompleted", "onComplete", "tryAuthorize", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class h extends com.facebook.login.q {

    public static final Parcelable.Creator<com.facebook.login.h> CREATOR;
    private com.facebook.login.g v;
    private final String w;

    @Metadata(d1 = "\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"com/facebook/login/GetTokenLoginMethodHandler$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/GetTokenLoginMethodHandler;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/login/GetTokenLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements Parcelable.Creator<com.facebook.login.h> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.login.h a(Parcel parcel) {
            n.f(parcel, "source");
            h hVar = new h(parcel);
            return hVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.login.h[] b(int i) {
            return new h[i];
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

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0016¨\u0006\t", d2 = {"com/facebook/login/GetTokenLoginMethodHandler$complete$1", "Lcom/facebook/internal/Utility$GraphMeRequestWithCacheCallback;", "onFailure", "", "error", "Lcom/facebook/FacebookException;", "onSuccess", "userInfo", "Lorg/json/JSONObject;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements b0.a {

        final com.facebook.login.h a;
        final Bundle b;
        final com.facebook.login.l.d c;
        b(com.facebook.login.h h, Bundle bundle2, com.facebook.login.l.d l$d3) {
            this.a = h;
            this.b = bundle2;
            this.c = d3;
            super();
        }

        @Override // com.facebook.internal.b0$a
        public void a(JSONObject jSONObject) {
            com.facebook.login.l.d dVar;
            Bundle bundle;
            String str;
            String obj4;
            try {
                if (jSONObject != null) {
                } else {
                }
                obj4 = jSONObject.getString("id");
                obj4 = 0;
                this.b.putString("com.facebook.platform.extra.USER_ID", obj4);
                this.a.r(this.c, this.b);
                com.facebook.login.h hVar = this.a;
                hVar = hVar.f();
                com.facebook.login.h hVar2 = this.a;
                hVar2 = hVar2.f();
                hVar2 = hVar2.q();
                jSONObject = jSONObject.getMessage();
                jSONObject = l.e.c(hVar2, "Caught exception", jSONObject);
                hVar.f(jSONObject);
            }
        }

        @Override // com.facebook.internal.b0$a
        public void b(FacebookException facebookException) {
            String obj4;
            if (facebookException != null) {
                obj4 = facebookException.getMessage();
            } else {
                obj4 = 0;
            }
            this.a.f().f(l.e.c(this.a.f().q(), "Caught exception", obj4));
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "result", "Landroid/os/Bundle;", "completed"}, k = 3, mv = {1, 5, 1})
    static final class c implements x.b {

        final com.facebook.login.h a;
        final com.facebook.login.l.d b;
        c(com.facebook.login.h h, com.facebook.login.l.d l$d2) {
            this.a = h;
            this.b = d2;
            super();
        }

        @Override // com.facebook.internal.x$b
        public final void a(Bundle bundle) {
            this.a.q(this.b, bundle);
        }
    }
    static {
        h.a aVar = new h.a();
        h.CREATOR = aVar;
    }

    public h(Parcel parcel) {
        n.f(parcel, "source");
        super(parcel);
        this.w = "get_token";
    }

    public h(com.facebook.login.l l) {
        n.f(l, "loginClient");
        super(l);
        this.w = "get_token";
    }

    @Override // com.facebook.login.q
    public void b() {
        int i;
        final com.facebook.login.g gVar = this.v;
        if (gVar != null) {
            gVar.b();
            i = 0;
            gVar.f(i);
            this.v = i;
        }
    }

    @Override // com.facebook.login.q
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.q
    public String h() {
        return this.w;
    }

    @Override // com.facebook.login.q
    public int o(com.facebook.login.l.d l$d) {
        com.facebook.login.g gVar;
        n.f(d, "request");
        androidx.fragment.app.e eVar = f().i();
        n.e(eVar, "loginClient.activity");
        gVar = new g(eVar, d);
        this.v = gVar;
        if (gVar != null && !gVar.g()) {
            if (!gVar.g()) {
                return 0;
            }
        }
        f().t();
        h.c cVar = new h.c(this, d);
        com.facebook.login.g obj4 = this.v;
        if (obj4 != null) {
            obj4.f(cVar);
        }
        return 1;
    }

    @Override // com.facebook.login.q
    public final void p(com.facebook.login.l.d l$d, Bundle bundle2) {
        int string2;
        String string;
        com.facebook.login.h.b bVar;
        n.f(d, "request");
        n.f(bundle2, "result");
        string = bundle2.getString("com.facebook.platform.extra.USER_ID");
        if (string != null) {
            if (string.length() == 0) {
                string2 = 1;
            } else {
                string2 = 0;
            }
        } else {
        }
        if (string2 != null) {
            f().t();
            string2 = bundle2.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            if (string2 == null) {
            } else {
                bVar = new h.b(this, bundle2, d);
                b0.C(string2, bVar);
            }
            IllegalStateException obj3 = new IllegalStateException("Required value was null.".toString());
            throw obj3;
        }
        r(d, bundle2);
    }

    @Override // com.facebook.login.q
    public final void q(com.facebook.login.l.d l$d, Bundle bundle2) {
        Object stringArrayList;
        int join;
        Set set;
        Object iterator;
        String string;
        boolean next;
        boolean next2;
        boolean contains;
        int i;
        Object obj7;
        n.f(d, "request");
        com.facebook.login.g gVar = this.v;
        iterator = 0;
        if (gVar != null) {
            gVar.f(iterator);
        }
        this.v = iterator;
        f().u();
        if (bundle2 != null) {
            if (bundle2.getStringArrayList("com.facebook.platform.extra.PERMISSIONS") != null) {
            } else {
                stringArrayList = p.g();
            }
            if (d.k() != null) {
            } else {
                set = q0.b();
            }
            string = bundle2.getString("com.facebook.platform.extra.ID_TOKEN");
            i = 1;
            if (set.contains("openid")) {
                if (string != null) {
                    if (string.length() == 0) {
                        string = i;
                    } else {
                        string = 0;
                    }
                } else {
                }
                if (string != null) {
                    f().D();
                }
            }
            if (stringArrayList.containsAll(set)) {
                p(d, bundle2);
            }
            obj7 = new HashSet();
            iterator = set.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (!stringArrayList.contains((String)next)) {
                }
                obj7.add(next);
            }
            if (empty ^= i != 0) {
                a("new_permissions", TextUtils.join(",", obj7));
            }
            d.s(obj7);
        }
        f().D();
    }

    @Override // com.facebook.login.q
    public final void r(com.facebook.login.l.d l$d, Bundle bundle2) {
        com.facebook.login.q.a aVar;
        com.facebook.login.l.e obj5;
        com.facebook.g obj6;
        n.f(d, "request");
        n.f(bundle2, "result");
        aVar = q.c;
        String str3 = d.a();
        n.e(str3, "request.applicationId");
        obj5 = l.e.b(d, aVar.a(bundle2, f.FACEBOOK_APPLICATION_SERVICE, str3), aVar.c(bundle2, d.j()));
        f().g(obj5);
    }
}
