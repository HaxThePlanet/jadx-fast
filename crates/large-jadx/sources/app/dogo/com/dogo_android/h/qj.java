package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import com.google.android.material.card.MaterialCardView;

/* compiled from: LayoutDashboardScheduleCardBinding.java */
/* loaded from: classes.dex */
public abstract class qj extends ViewDataBinding {

    public final TextView O;
    public final MaterialCardView P;
    protected PottyProgramProgress Q;
    protected a0 R;
    protected qj(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, MaterialCardView materialCardView, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = textView;
        this.P = materialCardView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(PottyProgramProgress pottyProgramProgress);
}
