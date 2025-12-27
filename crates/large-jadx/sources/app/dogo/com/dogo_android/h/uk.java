package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.card.MaterialCardView;

/* compiled from: LayoutInviteFriendsBannerBinding.java */
/* loaded from: classes.dex */
public abstract class uk extends ViewDataBinding {

    public final ConstraintLayout O;
    protected uk(Object object, View view, int i, ImageView imageView, MaterialCardView materialCardView, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, i);
        this.O = constraintLayout;
    }

    public static uk T(View view) {
        return uk.U(view, f.e());
    }

    @Deprecated
    public static uk U(View view, Object object) {
        return (uk)ViewDataBinding.k(object, view, 2131558779);
    }
}
