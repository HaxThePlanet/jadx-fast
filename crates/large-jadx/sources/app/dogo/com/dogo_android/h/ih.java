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

/* loaded from: classes.dex */
public abstract class ih extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    public final RecyclerView Q;
    public final MaterialButton R;
    public final MaterialToolbar S;
    protected t T;
    protected ih(Object object, View view2, int i3, ConstraintLayout constraintLayout4, ImageView imageView5, ImageView imageView6, TextView textView7, RecyclerView recyclerView8, MaterialButton materialButton9, MaterialToolbar materialToolbar10) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = textView7;
        this.Q = recyclerView8;
        this.R = materialButton9;
        this.S = materialToolbar10;
    }

    public static app.dogo.com.dogo_android.h.ih T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ih.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ih U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ih)ViewDataBinding.z(layoutInflater, 2131558724, viewGroup2, z3, object4);
    }
}
