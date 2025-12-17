package com.google.android.gms.common;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class c extends DialogFragment {

    private Dialog a;
    private DialogInterface.OnCancelListener b;
    private Dialog c;
    public static com.google.android.gms.common.c a(Dialog dialog, DialogInterface.OnCancelListener dialogInterface$OnCancelListener2) {
        c cVar = new c();
        r.k(dialog, "Cannot display null dialog");
        int i = 0;
        (Dialog)dialog.setOnCancelListener(i);
        dialog.setOnDismissListener(i);
        cVar.a = dialog;
        if (onCancelListener2 != null) {
            cVar.b = onCancelListener2;
        }
        return cVar;
    }

    @Override // android.app.DialogFragment
    public void onCancel(DialogInterface dialogInterface) {
        final DialogInterface.OnCancelListener list = this.b;
        if (list != null) {
            list.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        android.app.Activity activity;
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

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String string2) {
        super.show(fragmentManager, string2);
    }
}
