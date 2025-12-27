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

/* compiled from: FragmentPottyReminderScreenBinding.java */
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
    protected cf(Object object, View view, int i, AppBarLayout appBarLayout, LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3, MaterialButton materialButton, TextView textView4, MaterialButton materialButton2, MaterialButton materialButton3, NestedScrollView nestedScrollView, TextView textView5, MaterialButton materialButton4, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, MaterialToolbar materialToolbar) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = linearLayout;
        object2.P = textView;
        object2.Q = materialButton;
        object2.R = materialButton2;
        object2.S = materialButton3;
        object2.T = materialButton4;
        object2.U = checkBox;
        object2.V = checkBox2;
        object2.W = checkBox3;
        object2.X = checkBox4;
        object2.Y = checkBox5;
        object2.Z = checkBox6;
        object2.a0 = checkBox7;
        object2.b0 = materialToolbar;
    }

    public static cf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return cf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static cf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (cf)ViewDataBinding.z(layoutInflater, 2131558695, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l lVar);
}
