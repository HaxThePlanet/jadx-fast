package com.google.android.gms.dynamite;

import android.content.Context;

/* loaded from: classes2.dex */
final class d implements com.google.android.gms.dynamite.DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule$a
    public final com.google.android.gms.dynamite.i a(Context context, String string2, com.google.android.gms.dynamite.h h3) {
        int obj3;
        int obj4;
        i iVar = new i();
        iVar.a = h3.b(context, string2);
        int i2 = 1;
        obj3 = h3.a(context, string2, i2);
        iVar.b = obj3;
        final int obj5 = 0;
        if (iVar.a == 0) {
            if (obj3 == null) {
                iVar.c = obj5;
            } else {
                obj4 = obj5;
                if (obj4 >= obj3) {
                    iVar.c = -1;
                } else {
                    iVar.c = i2;
                }
            }
        } else {
        }
        return iVar;
    }
}
