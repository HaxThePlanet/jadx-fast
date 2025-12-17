package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.i;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;

/* loaded from: classes2.dex */
public class b extends i {

    private boolean a;

    static class a {
    }

    private class b extends com.google.android.material.bottomsheet.BottomSheetBehavior.f {

        final com.google.android.material.bottomsheet.b a;
        private b(com.google.android.material.bottomsheet.b b) {
            this.a = b;
            super();
        }

        b(com.google.android.material.bottomsheet.b b, com.google.android.material.bottomsheet.b.a b$a2) {
            super(b);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onSlide(View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$f
        public void onStateChanged(View view, int i2) {
            int obj1;
            if (i2 == 5) {
                b.B1(this.a);
            }
        }
    }
    static void B1(com.google.android.material.bottomsheet.b b) {
        b.C1();
    }

    private void C1() {
        if (this.a) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void D1(com.google.android.material.bottomsheet.BottomSheetBehavior<?> bottomSheetBehavior, boolean z2) {
        int i;
        int obj4;
        this.a = z2;
        final int i2 = 5;
        if (bottomSheetBehavior.D() == i2) {
            C1();
        } else {
            if (obj4 instanceof a) {
                (a)getDialog().removeDefaultCallback();
            }
            obj4 = new b.b(this, 0);
            bottomSheetBehavior.o(obj4);
            bottomSheetBehavior.Z(i2);
        }
    }

    private boolean E1(boolean z) {
        Dialog dismissWithAnimation;
        boolean behavior;
        boolean z2;
        dismissWithAnimation = getDialog();
        behavior = (a)dismissWithAnimation.getBehavior();
        if (dismissWithAnimation instanceof a && behavior.G() && dismissWithAnimation.getDismissWithAnimation()) {
            behavior = (a)dismissWithAnimation.getBehavior();
            if (behavior.G()) {
                if (dismissWithAnimation.getDismissWithAnimation()) {
                    D1(behavior, z);
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // androidx.appcompat.app.i
    public void dismiss() {
        if (!E1(false)) {
            super.dismiss();
        }
    }

    @Override // androidx.appcompat.app.i
    public void dismissAllowingStateLoss() {
        if (!E1(true)) {
            super.dismissAllowingStateLoss();
        }
    }

    @Override // androidx.appcompat.app.i
    public Dialog onCreateDialog(Bundle bundle) {
        a obj3 = new a(getContext(), getTheme());
        return obj3;
    }
}
