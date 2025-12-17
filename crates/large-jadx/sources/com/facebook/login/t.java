package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.fragment.app.Fragment;
import com.facebook.f;
import com.facebook.internal.b0;
import com.facebook.internal.z;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class t extends com.facebook.login.q {
    t(Parcel parcel) {
        super(parcel);
    }

    t(com.facebook.login.l l) {
        super(l);
    }

    private void p(com.facebook.login.l.e l$e) {
        com.facebook.login.l lVar;
        Object obj2;
        if (e != null) {
            f().g(e);
        } else {
            f().D();
        }
    }

    @Override // com.facebook.login.q
    public boolean k(int i, int i2, Intent intent3) {
        String str2;
        Object str;
        int string;
        String string2;
        boolean z;
        Object obj6;
        String obj7;
        Object obj8;
        obj6 = f().q();
        final int i3 = 1;
        if (intent3 == null) {
            p(l.e.a(obj6, "Operation canceled"));
        } else {
            if (i2 == 0) {
                t(obj6, intent3);
            } else {
                string = 0;
                if (i2 != -1) {
                    p(l.e.c(obj6, "Unexpected resultCode from authorization.", string));
                } else {
                    obj7 = intent3.getExtras();
                    if (obj7 == null) {
                        p(l.e.c(obj6, "Unexpected null from returned authorization data.", string));
                        return i3;
                    }
                    obj8 = q(obj7);
                    str = "error_code";
                    if (obj7.get(str) != null) {
                        string = obj7.get(str).toString();
                    }
                    str2 = r(obj7);
                    string2 = obj7.getString("e2e");
                    if (!b0.W(string2)) {
                        i(string2);
                    }
                    if (obj8 == null && string == null && str2 == null) {
                        if (string == null) {
                            if (str2 == null) {
                                v(obj6, obj7);
                            } else {
                                u(obj6, obj8, str2, string);
                            }
                        } else {
                        }
                    } else {
                    }
                }
            }
        }
        return i3;
    }

    @Override // com.facebook.login.q
    protected String q(Bundle bundle) {
        String string;
        if (bundle == null) {
            return null;
        }
        if (bundle.getString("error") == null) {
            string = bundle.getString("error_type");
        }
        return string;
    }

    @Override // com.facebook.login.q
    protected String r(Bundle bundle) {
        String string;
        if (bundle == null) {
            return null;
        }
        if (bundle.getString("error_message") == null) {
            string = bundle.getString("error_description");
        }
        return string;
    }

    @Override // com.facebook.login.q
    public f s() {
        return f.FACEBOOK_APPLICATION_WEB;
    }

    @Override // com.facebook.login.q
    protected void t(com.facebook.login.l.d l$d, Intent intent2) {
        String string;
        Object obj5;
        obj5 = intent2.getExtras();
        final String str = q(obj5);
        String str2 = "error_code";
        if (obj5.get(str2) != null) {
            string = obj5.get(str2).toString();
        } else {
            string = 0;
        }
        if (z.c().equals(string)) {
            p(l.e.d(d, str, r(obj5), string));
        }
        p(l.e.a(d, str));
    }

    @Override // com.facebook.login.q
    protected void u(com.facebook.login.l.d l$d, String string2, String string3, String string4) {
        boolean contains;
        com.facebook.login.l.e obj3;
        final int i = 0;
        if (string2 != null && string2.equals("logged_out")) {
            if (string2.equals("logged_out")) {
                a.z = true;
                p(i);
            } else {
                if (z.d().contains(string2)) {
                    p(i);
                } else {
                    if (z.e().contains(string2)) {
                        p(l.e.a(d, i));
                    } else {
                        p(l.e.d(d, string2, string3, string4));
                    }
                }
            }
        } else {
        }
    }

    @Override // com.facebook.login.q
    protected void v(com.facebook.login.l.d l$d, Bundle bundle2) {
        com.facebook.a aVar;
        com.facebook.login.l.d obj4;
        com.facebook.login.l.e obj5;
        try {
            p(l.e.b(d, q.c(d.k(), bundle2, s(), d.a()), q.d(bundle2, d.j())));
            bundle2 = bundle2.getMessage();
            d = l.e.c(d, 0, bundle2);
            p(d);
        }
    }

    @Override // com.facebook.login.q
    protected boolean x(Intent intent, int i2) {
        if (intent == null) {
            return 0;
        }
        f().l().startActivityForResult(intent, i2);
        return 1;
    }
}
