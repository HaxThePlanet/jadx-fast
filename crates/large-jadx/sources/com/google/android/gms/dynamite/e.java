package com.google.android.gms.dynamite;

import android.content.Context;

/* loaded from: classes2.dex */
final class e implements com.google.android.gms.dynamite.DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule$a
    public final com.google.android.gms.dynamite.i a(Context context, String string2, com.google.android.gms.dynamite.h h3) {
        int i;
        int obj5;
        i iVar = new i();
        final int i2 = h3.b(context, string2);
        iVar.a = i2;
        final int i3 = 1;
        i = 0;
        if (i2 != 0) {
            iVar.b = h3.a(context, string2, i);
        } else {
            iVar.b = h3.a(context, string2, i3);
        }
        final int obj6 = iVar.a;
        if (obj6 == null) {
            if (obj5 == null) {
                iVar.c = i;
            } else {
                if (i >= obj5) {
                    iVar.c = -1;
                } else {
                    iVar.c = i3;
                }
            }
        } else {
            i = obj6;
        }
        return iVar;
    }
}
