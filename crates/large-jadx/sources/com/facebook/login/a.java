package com.facebook.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookServiceException;
import com.facebook.f;
import com.facebook.internal.b0;
import com.facebook.internal.e;
import com.facebook.internal.f;
import com.facebook.n;
import com.facebook.o;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends com.facebook.login.x {

    public static final Parcelable.Creator<com.facebook.login.a> CREATOR = null;
    public static boolean z = false;
    private String w;
    private String x;
    private String y;

    static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable$Creator
        public com.facebook.login.a a(Parcel parcel) {
            a aVar = new a(parcel);
            return aVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.facebook.login.a[] b(int i) {
            return new a[i];
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
        a.a aVar = new a.a();
        a.CREATOR = aVar;
    }

    a(Parcel parcel) {
        super(parcel);
        this.y = "";
        this.x = parcel.readString();
    }

    a(com.facebook.login.l l) {
        super(l);
        this.y = "";
        this.x = b0.r(20);
        a.z = false;
        this.y = f.c(z());
    }

    private void A(String string, com.facebook.login.l.d l$d2) {
        Bundle startsWith;
        int i;
        String string2;
        int int;
        boolean z;
        int i2;
        Object obj7;
        if (string != null) {
            if (!string.startsWith("fbconnect://cct.")) {
                obj7 = Uri.parse(string);
                startsWith = b0.i0(obj7.getQuery());
                startsWith.putAll(b0.i0(obj7.getFragment()));
                i = 0;
                if (string.startsWith(super.r()) && !B(startsWith)) {
                    obj7 = Uri.parse(string);
                    startsWith = b0.i0(obj7.getQuery());
                    startsWith.putAll(b0.i0(obj7.getFragment()));
                    i = 0;
                    if (!B(startsWith)) {
                        obj7 = new FacebookException("Invalid state parameter");
                        super.v(d2, i, obj7);
                    }
                    if (startsWith.getString("error") == null) {
                        obj7 = startsWith.getString("error_type");
                    }
                    if (startsWith.getString("error_msg") == null) {
                        string2 = startsWith.getString("error_message");
                    }
                    if (string2 == null) {
                        string2 = startsWith.getString("error_description");
                    }
                    String string3 = startsWith.getString("error_code");
                    i2 = -1;
                    if (!b0.W(string3)) {
                        int = Integer.parseInt(string3);
                    } else {
                        int = i2;
                    }
                    if (b0.W(obj7) && b0.W(string2) && int == i2) {
                        if (b0.W(string2)) {
                            if (int == i2) {
                                super.v(d2, startsWith, i);
                            } else {
                                if (obj7 != null) {
                                    if (!obj7.equals("access_denied")) {
                                        if (obj7.equals("OAuthAccessDeniedException")) {
                                            obj7 = new FacebookOperationCanceledException();
                                            super.v(d2, i, obj7);
                                        } else {
                                            if (int == 4201) {
                                                obj7 = new FacebookOperationCanceledException();
                                                super.v(d2, i, obj7);
                                            } else {
                                                startsWith = new n(int, obj7, string2);
                                                obj7 = new FacebookServiceException(startsWith, string2);
                                                super.v(d2, i, obj7);
                                            }
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        }
    }

    private boolean B(Bundle bundle) {
        String obj3 = bundle.getString("state");
        if (obj3 == null) {
            try {
                return 0;
                JSONObject jSONObject = new JSONObject(obj3);
                return jSONObject.getString("7_challenge").equals(this.x);
                return obj0;
            }
        }
    }

    private String y() {
        String str = this.w;
        if (str != null) {
            return str;
        }
        String str2 = f.a();
        this.w = str2;
        return str2;
    }

    private String z() {
        return super.r();
    }

    @Override // com.facebook.login.x
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.x
    public String h() {
        return "custom_tab";
    }

    @Override // com.facebook.login.x
    public boolean k(int i, int i2, Intent intent3) {
        boolean booleanExtra;
        int stringExtra;
        int obj6;
        final int i3 = 0;
        if (intent3 != null && intent3.getBooleanExtra(CustomTabMainActivity.A, i3)) {
            if (intent3.getBooleanExtra(CustomTabMainActivity.A, i3)) {
                return super.k(i, i2, intent3);
            }
        }
        int i4 = 1;
        if (i != i4) {
            return super.k(i, i2, intent3);
        }
        com.facebook.login.l.d obj5 = f().q();
        if (i2 == -1 && intent3 != null) {
            if (intent3 != null) {
                stringExtra = intent3.getStringExtra(CustomTabMainActivity.x);
            }
            A(stringExtra, obj5);
            return i4;
        }
        obj6 = new FacebookOperationCanceledException();
        super.v(obj5, 0, obj6);
        return i3;
    }

    @Override // com.facebook.login.x
    public void l(JSONObject jSONObject) {
        jSONObject.put("7_challenge", this.x);
    }

    @Override // com.facebook.login.x
    public int o(com.facebook.login.l.d l$d) {
        boolean str;
        boolean z;
        String str2;
        com.facebook.login.l lVar = f();
        if (r().isEmpty()) {
            return 0;
        }
        Bundle bundle = q(d);
        p(bundle, d);
        if (a.z) {
            bundle.putString("cct_over_app_switch", "1");
        }
        String str9 = "oauth";
        if (o.o) {
            if (d.o()) {
                b.f(e.a(str9, bundle));
            } else {
                b.f(e.a(str9, bundle));
            }
        }
        Intent intent = new Intent(lVar.i(), CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.c, str9);
        intent.putExtra(CustomTabMainActivity.v, bundle);
        intent.putExtra(CustomTabMainActivity.w, y());
        intent.putExtra(CustomTabMainActivity.y, d.h().toString());
        int i = 1;
        lVar.l().startActivityForResult(intent, i);
        return i;
    }

    @Override // com.facebook.login.x
    protected String r() {
        return this.y;
    }

    @Override // com.facebook.login.x
    protected String s() {
        return "chrome_custom_tab";
    }

    @Override // com.facebook.login.x
    f t() {
        return f.CHROME_CUSTOM_TAB;
    }

    @Override // com.facebook.login.x
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.x);
    }
}
