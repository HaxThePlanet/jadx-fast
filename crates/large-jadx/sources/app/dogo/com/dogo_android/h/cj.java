package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import com.google.android.material.card.MaterialCardView;

/* compiled from: LayoutDashboardPottyProgramCardV2Binding.java */
/* loaded from: classes.dex */
public abstract class cj extends ViewDataBinding {

    public final MaterialCardView O;
    public final ImageView P;
    public final Button Q;
    protected a0 R;
    protected String S;
    protected cj(Object object, View view, int i, ImageView imageView, MaterialCardView materialCardView, ImageView imageView2, Button button, TextView textView) {
        super(object, view, i);
        this.O = materialCardView;
        this.P = imageView2;
        this.Q = button;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PottyProgramProgress pottyProgramProgress);
}
