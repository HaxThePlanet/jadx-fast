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

/* loaded from: classes.dex */
public class j0 extends u {

    private m8 w;
    private f0 x;
    @Override // app.dogo.com.dogo_android.util.e0.u
    public c E1() {
        return c.CHALLENGE_FILTER_DIALOG_FRAGMENT;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public k3 H1() {
        return j3.P;
    }

    public Class<? extends r> J1() {
        return f0.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.u
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        boolean obj2;
        this.x = (f0)I1();
        getDialog().getWindow().setBackgroundDrawableResource(2131230939);
        int obj4 = 0;
        obj2 = m8.T(layoutInflater, viewGroup2, obj4);
        this.w = obj2;
        obj2.W(this.x);
        this.w.V(G1());
        this.x.C(getArguments());
        if (this.x.x()) {
            obj2.Q.setVisibility(obj4);
        }
        if (this.x.A()) {
            obj2.R.setVisibility(obj4);
        }
        return this.w.w();
    }
}
