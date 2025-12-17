package com.google.android.gms.common;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.n;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class k extends d {

    private Dialog a;
    private DialogInterface.OnCancelListener b;
    private Dialog c;
    public static com.google.android.gms.common.k B1(Dialog dialog, DialogInterface.OnCancelListener dialogInterface$OnCancelListener2) {
        k kVar = new k();
        r.k(dialog, "Cannot display null dialog");
        int i = 0;
        (Dialog)dialog.setOnCancelListener(i);
        dialog.setOnDismissListener(i);
        kVar.a = dialog;
        if (onCancelListener2 != null) {
            kVar.b = onCancelListener2;
        }
        return kVar;
    }

    @Override // androidx.fragment.app.d
    public void onCancel(DialogInterface dialogInterface) {
        final DialogInterface.OnCancelListener list = this.b;
        if (list != null) {
            list.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        androidx.fragment.app.e activity;
        Object obj2;
        setShowsDialog(false);
        if (this.a == null && this.c == null) {
            setShowsDialog(false);
            if (this.c == null) {
                obj2 = new AlertDialog.Builder(getActivity());
                this.c = obj2.create();
            }
            obj2 = this.c;
        }
        return obj2;
    }

    @Override // androidx.fragment.app.d
    public void show(n n, String string2) {
        super.show(n, string2);
    }
}
