package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.u.m.t;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentVariationTipsScreenBinding.java */
/* loaded from: classes.dex */
public abstract class ih extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    public final RecyclerView Q;
    public final MaterialButton R;
    public final MaterialToolbar S;
    protected t T;
    protected ih(Object object, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, RecyclerView recyclerView, MaterialButton materialButton, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = textView;
        this.Q = recyclerView;
        this.R = materialButton;
        this.S = materialToolbar;
    }

    public static ih T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ih.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ih U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ih)ViewDataBinding.z(layoutInflater, 2131558724, viewGroup, z, object);
    }
}
