package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public abstract class cj extends ViewDataBinding {

    public final MaterialCardView O;
    public final ImageView P;
    public final Button Q;
    protected a0 R;
    protected String S;
    protected cj(Object object, View view2, int i3, ImageView imageView4, MaterialCardView materialCardView5, ImageView imageView6, Button button7, TextView textView8) {
        super(object, view2, i3);
        this.O = materialCardView5;
        this.P = imageView6;
        this.Q = button7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PottyProgramProgress pottyProgramProgress);
}
