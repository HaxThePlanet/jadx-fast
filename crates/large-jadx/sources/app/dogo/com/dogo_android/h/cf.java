package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.u.n.q.l;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class cf extends ViewDataBinding {

    public final LinearLayout O;
    public final TextView P;
    public final MaterialButton Q;
    public final MaterialButton R;
    public final MaterialButton S;
    public final MaterialButton T;
    public final CheckBox U;
    public final CheckBox V;
    public final CheckBox W;
    public final CheckBox X;
    public final CheckBox Y;
    public final CheckBox Z;
    public final CheckBox a0;
    public final MaterialToolbar b0;
    protected l c0;
    protected cf(Object object, View view2, int i3, AppBarLayout appBarLayout4, LinearLayout linearLayout5, TextView textView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, AppCompatImageView appCompatImageView10, TextView textView11, TextView textView12, MaterialButton materialButton13, TextView textView14, MaterialButton materialButton15, MaterialButton materialButton16, NestedScrollView nestedScrollView17, TextView textView18, MaterialButton materialButton19, CheckBox checkBox20, CheckBox checkBox21, CheckBox checkBox22, CheckBox checkBox23, CheckBox checkBox24, CheckBox checkBox25, CheckBox checkBox26, MaterialToolbar materialToolbar27) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = linearLayout5;
        obj.P = textView6;
        obj.Q = materialButton13;
        obj.R = materialButton15;
        obj.S = materialButton16;
        obj.T = materialButton19;
        obj.U = checkBox20;
        obj.V = checkBox21;
        obj.W = checkBox22;
        obj.X = checkBox23;
        obj.Y = checkBox24;
        obj.Z = checkBox25;
        obj.a0 = checkBox26;
        obj.b0 = materialToolbar27;
    }

    public static app.dogo.com.dogo_android.h.cf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return cf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.cf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (cf)ViewDataBinding.z(layoutInflater, 2131558695, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l l);
}
