package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.model.ChallengeDetailsTabModel;

/* compiled from: CellChallengeDetailsTabBinding.java */
/* loaded from: classes.dex */
public abstract class o0 extends ViewDataBinding {

    public final TextView O;
    public final LinearLayout P;
    protected ChallengeDetailsTabModel Q;
    protected o0(Object object, View view, int i, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, TextView textView, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        super(object, view, i);
        this.O = textView;
        this.P = linearLayout2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(ChallengeDetailsTabModel challengeDetailsTabModel);
}
