package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.model.ChallengeDetailsTabModel;

/* loaded from: classes.dex */
public abstract class o0 extends ViewDataBinding {

    public final TextView O;
    public final LinearLayout P;
    protected ChallengeDetailsTabModel Q;
    protected o0(Object object, View view2, int i3, LinearLayout linearLayout4, ImageView imageView5, ImageView imageView6, TextView textView7, LinearLayout linearLayout8, RelativeLayout relativeLayout9) {
        super(object, view2, i3);
        this.O = textView7;
        this.P = linearLayout8;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(ChallengeDetailsTabModel challengeDetailsTabModel);
}
