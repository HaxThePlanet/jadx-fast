package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.k0.d;

/* compiled from: LayoutCommentInputBinding.java */
/* loaded from: classes.dex */
public abstract class ci extends ViewDataBinding {

    public final FrameLayout O;
    public final TextView P;
    public final EditText Q;
    public final ImageView R;
    public final ConstraintLayout S;
    public final FrameLayout T;
    protected d U;
    protected ci(Object object, View view, int i, FrameLayout frameLayout, TextView textView, EditText editText, ImageView imageView, ConstraintLayout constraintLayout, FrameLayout frameLayout2) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = textView;
        this.Q = editText;
        this.R = imageView;
        this.S = constraintLayout;
        this.T = frameLayout2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public d T() {
        return this.U;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(d dVar);
}
