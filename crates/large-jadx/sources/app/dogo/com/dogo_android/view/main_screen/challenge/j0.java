package app.dogo.com.dogo_android.view.main_screen.j;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import app.dogo.com.dogo_android.a0.g.f.f0;
import app.dogo.com.dogo_android.h.m8;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.u;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;

/* compiled from: ChallengeFilterDialog.java */
/* loaded from: classes.dex */
public class j0 extends u {

    private m8 w;
    private f0 x;
    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return DialogTags.CHALLENGE_FILTER_DIALOG_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return S.dashboard;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public Class<? extends r> J1() {
        return app.dogo.com.dogo_android.viewmodel.main_screen.challenge.f0.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.x = (app.dogo.com.dogo_android.viewmodel.main_screen.challenge.f0)I1();
        getDialog().getWindow().setBackgroundDrawableResource(2131230939);
        boolean z3 = false;
        m8 m8Var = m8.T(layoutInflater, viewGroup, z3);
        this.w = m8Var;
        m8Var.W(this.x);
        this.w.V(G1());
        this.x.C(getArguments());
        if (this.x.x()) {
            this.w.Q.setVisibility(z3);
        }
        if (this.x.A()) {
            this.w.R.setVisibility(z3);
        }
        return this.w.w();
    }
}
