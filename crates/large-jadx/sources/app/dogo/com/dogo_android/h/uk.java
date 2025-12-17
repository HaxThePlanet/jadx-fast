package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public abstract class uk extends ViewDataBinding {

    public final ConstraintLayout O;
    protected uk(Object object, View view2, int i3, ImageView imageView4, MaterialCardView materialCardView5, ConstraintLayout constraintLayout6, TextView textView7) {
        super(object, view2, i3);
        this.O = constraintLayout6;
    }

    public static app.dogo.com.dogo_android.h.uk T(View view) {
        return uk.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.uk U(View view, Object object2) {
        return (uk)ViewDataBinding.k(object2, view, 2131558779);
    }
}
