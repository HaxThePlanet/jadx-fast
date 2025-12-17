package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.internal.i;

/* loaded from: classes2.dex */
public abstract class g0 implements DialogInterface.OnClickListener {
    public static com.google.android.gms.common.internal.g0 b(Activity activity, Intent intent2, int i3) {
        e0 e0Var = new e0(intent2, activity, i3);
        return e0Var;
    }

    public static com.google.android.gms.common.internal.g0 c(i i, Intent intent2, int i3) {
        f0 obj3 = new f0(intent2, i, 2);
        return obj3;
    }

    @Override // android.content.DialogInterface$OnClickListener
    protected abstract void a();

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        String str2;
        String str;
        try {
            a();
            dialogInterface.dismiss();
            str2 = Build.FINGERPRINT;
            str = "generic";
            str2 = str2.contains(str);
            str = 1;
        } catch (Throwable th) {
        }
        dialogInterface.dismiss();
        throw i2;
    }
}
