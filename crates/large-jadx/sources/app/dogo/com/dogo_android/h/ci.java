package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.k0.d;

/* loaded from: classes.dex */
public abstract class ci extends ViewDataBinding {

    public final FrameLayout O;
    public final TextView P;
    public final EditText Q;
    public final ImageView R;
    public final ConstraintLayout S;
    public final FrameLayout T;
    protected d U;
    protected ci(Object object, View view2, int i3, FrameLayout frameLayout4, TextView textView5, EditText editText6, ImageView imageView7, ConstraintLayout constraintLayout8, FrameLayout frameLayout9) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = textView5;
        this.Q = editText6;
        this.R = imageView7;
        this.S = constraintLayout8;
        this.T = frameLayout9;
    }

    @Override // androidx.databinding.ViewDataBinding
    public d T() {
        return this.U;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(d d);
}
