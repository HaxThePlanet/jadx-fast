package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import com.facebook.FacebookException;
import com.facebook.f;
import com.facebook.internal.b0;
import com.facebook.internal.d0;
import com.facebook.internal.d0.a;
import com.facebook.internal.d0.e;
import com.facebook.internal.g;

/* loaded from: classes.dex */
class y extends com.facebook.login.x {

    public static final Parcelable.Creator<com.facebook.login.y> CREATOR;
    private d0 w;
    private String x;

    static class b implements Parcelable.Creator<com.facebook.login.y> {
        @Override // android.os.Parcelable$Creator
        public com.facebook.login.y a(Parcel parcel) {
            y yVar = new y(parcel);
            return yVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.login.y[] b(int i) {
            return new y[i];
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

    class a implements d0.e {

        final com.facebook.login.l.d a;
        final com.facebook.login.y b;
        a(com.facebook.login.y y, com.facebook.login.l.d l$d2) {
            this.b = y;
            this.a = d2;
            super();
        }

        @Override // com.facebook.internal.d0$e
        public void a(Bundle bundle, FacebookException facebookException2) {
            this.b.y(this.a, bundle, facebookException2);
        }
    }

    static class c extends d0.a {

        private String h;
        private String i;
        private String j;
        private com.facebook.login.k k;
        private com.facebook.login.s l;
        private boolean m = false;
        private boolean n = false;
        public c(Context context, String string2, Bundle bundle3) {
            super(context, string2, "oauth", bundle3);
            this.j = "fbconnect://success";
            this.k = k.NATIVE_WITH_FALLBACK;
            this.l = s.FACEBOOK;
            int obj2 = 0;
        }

        @Override // com.facebook.internal.d0$a
        public d0 a() {
            String str3;
            boolean string;
            boolean str2;
            String str;
            final Bundle bundle = f();
            bundle.putString("redirect_uri", this.j);
            bundle.putString("client_id", c());
            bundle.putString("e2e", this.h);
            str3 = this.l == s.INSTAGRAM ? "token,signed_request,graph_domain,granted_scopes" : "token,signed_request,graph_domain";
            bundle.putString("response_type", str3);
            String str13 = "true";
            bundle.putString("return_scopes", str13);
            bundle.putString("auth_type", this.i);
            bundle.putString("login_behavior", this.k.name());
            if (this.m) {
                bundle.putString("fx_app", this.l.toString());
            }
            if (this.n) {
                bundle.putString("skip_dedupe", str13);
            }
            return d0.q(d(), "oauth", bundle, g(), this.l, e());
        }

        @Override // com.facebook.internal.d0$a
        public com.facebook.login.y.c i(String string) {
            this.i = string;
            return this;
        }

        @Override // com.facebook.internal.d0$a
        public com.facebook.login.y.c j(String string) {
            this.h = string;
            return this;
        }

        @Override // com.facebook.internal.d0$a
        public com.facebook.login.y.c k(boolean z) {
            this.m = z;
            return this;
        }

        @Override // com.facebook.internal.d0$a
        public com.facebook.login.y.c l(boolean z) {
            String obj1;
            obj1 = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            this.j = obj1;
            return this;
        }

        @Override // com.facebook.internal.d0$a
        public com.facebook.login.y.c m(com.facebook.login.k k) {
            this.k = k;
            return this;
        }

        @Override // com.facebook.internal.d0$a
        public com.facebook.login.y.c n(com.facebook.login.s s) {
            this.l = s;
            return this;
        }

        @Override // com.facebook.internal.d0$a
        public com.facebook.login.y.c o(boolean z) {
            this.n = z;
            return this;
        }
    }
    static {
        y.b bVar = new y.b();
        y.CREATOR = bVar;
    }

    y(Parcel parcel) {
        super(parcel);
        this.x = parcel.readString();
    }

    y(com.facebook.login.l l) {
        super(l);
    }

    @Override // com.facebook.login.x
    public void b() {
        d0 d0Var;
        d0Var = this.w;
        if (d0Var != null) {
            d0Var.cancel();
            this.w = 0;
        }
    }

    @Override // com.facebook.login.x
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.x
    public String h() {
        return "web_view";
    }

    @Override // com.facebook.login.x
    public boolean j() {
        return 1;
    }

    @Override // com.facebook.login.x
    public int o(com.facebook.login.l.d l$d) {
        y.a aVar = new y.a(this, d);
        String str3 = l.k();
        this.x = str3;
        a("e2e", str3);
        e eVar = f().i();
        y.c cVar = new y.c(eVar, d.a(), q(d));
        cVar.j(this.x);
        cVar.l(b0.Q(eVar));
        cVar.i(d.c());
        cVar.m(d.g());
        cVar.n(d.h());
        cVar.k(d.n());
        cVar.o(d.x());
        cVar.h(aVar);
        this.w = cVar.a();
        g obj7 = new g();
        int i = 1;
        obj7.setRetainInstance(i);
        obj7.G1(this.w);
        obj7.show(eVar.getSupportFragmentManager(), "FacebookDialogFragment");
        return i;
    }

    @Override // com.facebook.login.x
    f t() {
        return f.WEB_VIEW;
    }

    @Override // com.facebook.login.x
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.x);
    }

    @Override // com.facebook.login.x
    void y(com.facebook.login.l.d l$d, Bundle bundle2, FacebookException facebookException3) {
        super.v(d, bundle2, facebookException3);
    }
}
