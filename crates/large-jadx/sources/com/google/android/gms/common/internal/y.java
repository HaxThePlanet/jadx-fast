package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.a.d;

/* loaded from: classes2.dex */
public class y implements a.d {

    public static final com.google.android.gms.common.internal.y b;
    private final String a;

    public static class a {

        private String a;
        a(com.google.android.gms.common.internal.b0 b0) {
            super();
        }

        public com.google.android.gms.common.internal.y a() {
            y yVar = new y(this.a, 0);
            return yVar;
        }
    }
    static {
        y.b = y.a().a();
    }

    y(String string, com.google.android.gms.common.internal.b0 b02) {
        super();
        this.a = string;
    }

    public static com.google.android.gms.common.internal.y.a a() {
        y.a aVar = new y.a(0);
        return aVar;
    }

    public final Bundle b() {
        String str;
        Bundle bundle = new Bundle();
        final String str2 = this.a;
        if (str2 != null) {
            bundle.putString("api", str2);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.api.a$d
    public final boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (!object instanceof y) {
            return 0;
        }
        return p.a(this.a, object.a);
    }

    @Override // com.google.android.gms.common.api.a$d
    public final int hashCode() {
        Object[] arr = new Object[1];
        return p.b(this.a);
    }
}
