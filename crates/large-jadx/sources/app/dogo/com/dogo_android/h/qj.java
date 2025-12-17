package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public abstract class qj extends ViewDataBinding {

    public final TextView O;
    public final MaterialCardView P;
    protected PottyProgramProgress Q;
    protected a0 R;
    protected qj(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, MaterialCardView materialCardView8, TextView textView9, TextView textView10) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = materialCardView8;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(PottyProgramProgress pottyProgramProgress);
}
