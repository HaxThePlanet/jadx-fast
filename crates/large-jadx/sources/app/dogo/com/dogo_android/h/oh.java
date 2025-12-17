package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public abstract class oh extends ViewDataBinding {

    public final ConstraintLayout O;
    public final MaterialCardView P;
    protected oh(Object object, View view2, int i3, ConstraintLayout constraintLayout4, ImageView imageView5, MaterialCardView materialCardView6, ImageView imageView7, TextView textView8) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = materialCardView6;
    }

    public static app.dogo.com.dogo_android.h.oh T(View view) {
        return oh.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.oh U(View view, Object object2) {
        return (oh)ViewDataBinding.k(object2, view, 2131558736);
    }
}
