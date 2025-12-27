package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.card.MaterialCardView;

/* compiled from: LayoutBecomePremiumBannerBinding.java */
/* loaded from: classes.dex */
public abstract class oh extends ViewDataBinding {

    public final ConstraintLayout O;
    public final MaterialCardView P;
    protected oh(Object object, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, MaterialCardView materialCardView, ImageView imageView2, TextView textView) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = materialCardView;
    }

    public static oh T(View view) {
        return oh.U(view, f.e());
    }

    @Deprecated
    public static oh U(View view, Object object) {
        return (oh)ViewDataBinding.k(object, view, 2131558736);
    }
}
