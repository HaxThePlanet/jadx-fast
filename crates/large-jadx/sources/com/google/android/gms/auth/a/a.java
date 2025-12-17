package com.google.android.gms.auth.a;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.h;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.a.g;
import com.google.android.gms.common.internal.p;
import f.c.a.d.b.c.e;

/* loaded from: classes2.dex */
public final class a {

    public static final a<GoogleSignInOptions> a;
    public static final a.g<e> b;
    public static final a.g<h> c;
    private static final a.a<e, com.google.android.gms.auth.a.a.a> d;
    private static final a.a<h, GoogleSignInOptions> e;

    @Deprecated
    public static class a implements a.d {

        public static final com.google.android.gms.auth.a.a.a v;
        private final String a = null;
        private final boolean b;
        private final String c;
        static {
            a.a.a aVar = new a.a.a();
            a.a aVar2 = new a.a(aVar);
            a.a.v = aVar2;
        }

        public a(com.google.android.gms.auth.a.a.a.a a$a$a) {
            super();
            int i = 0;
            this.b = a.a.booleanValue();
            this.c = a.b;
        }

        static String b(com.google.android.gms.auth.a.a.a a$a) {
            String obj0 = a.a;
            return null;
        }

        static String c(com.google.android.gms.auth.a.a.a a$a) {
            return a.c;
        }

        static boolean d(com.google.android.gms.auth.a.a.a a$a) {
            return a.b;
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", 0);
            bundle.putBoolean("force_save_dialog", this.b);
            bundle.putString("log_session_id", this.c);
            return bundle;
        }

        @Override // com.google.android.gms.common.api.a$d
        public boolean equals(Object object) {
            boolean z;
            boolean z2;
            Object obj5;
            final int i = 1;
            if (object == this) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof a.a) {
                return i3;
            }
            String str = object.a;
            int i2 = 0;
            if (p.a(i2, i2) && this.b == object.b && p.a(this.c, object.c)) {
                if (this.b == object.b) {
                    if (p.a(this.c, object.c)) {
                        return i;
                    }
                }
            }
            return i3;
        }

        @Override // com.google.android.gms.common.api.a$d
        public int hashCode() {
            Object[] arr = new Object[3];
            return p.b(0, Boolean.valueOf(this.b), this.c);
        }
    }
    static {
        a.g gVar = new a.g();
        a.b = gVar;
        a.g gVar2 = new a.g();
        a.c = gVar2;
        f fVar = new f();
        a.d = fVar;
        g gVar3 = new g();
        a.e = gVar3;
        a aVar3 = b.c;
        a aVar4 = new a("Auth.CREDENTIALS_API", fVar, gVar);
        a aVar = new a("Auth.GOOGLE_SIGN_IN_API", gVar3, gVar2);
        a.a = aVar;
        com.google.android.gms.auth.a.e.a aVar2 = b.d;
    }
}
