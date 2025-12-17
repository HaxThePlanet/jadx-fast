package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.j;

/* loaded from: classes2.dex */
public class u {

    private final Resources a;
    private final String b;
    public u(Context context) {
        super();
        r.j(context);
        Resources obj2 = context.getResources();
        this.a = obj2;
        this.b = obj2.getResourcePackageName(j.a);
    }

    public String a(String string) {
        int obj4 = this.a.getIdentifier(string, "string", this.b);
        if (obj4 == null) {
            return null;
        }
        return this.a.getString(obj4);
    }
}
