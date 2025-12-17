package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.f.k.h;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class qa extends ViewDataBinding {

    public final ImageView O;
    public final Button P;
    public final MaterialToolbar Q;
    public final RecyclerView R;
    protected h S;
    protected qa(Object object, View view2, int i3, Space space4, ConstraintLayout constraintLayout5, TextView textView6, ImageView imageView7, Guideline guideline8, Guideline guideline9, ImageView imageView10, Button button11, TextView textView12, TextView textView13, MaterialToolbar materialToolbar14, RecyclerView recyclerView15) {
        super(object, view2, i3);
        this.O = imageView10;
        this.P = button11;
        this.Q = materialToolbar14;
        this.R = recyclerView15;
    }

    public static app.dogo.com.dogo_android.h.qa T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qa.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qa U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qa)ViewDataBinding.z(layoutInflater, 2131558636, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h h);
}
