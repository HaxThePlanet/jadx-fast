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

/* compiled from: FragmentDailyWorkoutOverviewBinding.java */
/* loaded from: classes.dex */
public abstract class qa extends ViewDataBinding {

    public final ImageView O;
    public final Button P;
    public final MaterialToolbar Q;
    public final RecyclerView R;
    protected h S;
    protected qa(Object object, View view, int i, Space space, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, Guideline guideline, Guideline guideline2, ImageView imageView2, Button button, TextView textView2, TextView textView3, MaterialToolbar materialToolbar, RecyclerView recyclerView) {
        super(object, view, i);
        this.O = imageView2;
        this.P = button;
        this.Q = materialToolbar;
        this.R = recyclerView;
    }

    public static qa T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qa.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qa U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qa)ViewDataBinding.z(layoutInflater, 2131558636, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h hVar);
}
