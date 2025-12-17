package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;

/* loaded from: classes.dex */
public class i extends d {
    @Override // androidx.fragment.app.d
    public Dialog onCreateDialog(Bundle bundle) {
        h obj3 = new h(getContext(), getTheme());
        return obj3;
    }

    @Override // androidx.fragment.app.d
    public void setupDialog(Dialog dialog, int i2) {
        boolean obj;
        int i3;
        int i;
        Object obj4;
        int obj5;
        if (dialog instanceof h) {
            i3 = 1;
            if (i2 != i3 && i2 != 2) {
                if (i2 != 2) {
                    if (i2 != 3) {
                    } else {
                        dialog.getWindow().addFlags(24);
                        (h)dialog.supportRequestWindowFeature(i3);
                    }
                } else {
                }
            } else {
            }
        } else {
            super.setupDialog(dialog, i2);
        }
    }
}
