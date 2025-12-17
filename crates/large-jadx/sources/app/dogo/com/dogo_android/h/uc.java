package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class uc extends ViewDataBinding {

    public final TextView O;
    public final Button P;
    protected uc(Object object, View view2, int i3, TextView textView4, Button button5, ImageView imageView6, ImageView imageView7, Guideline guideline8, ImageView imageView9, Guideline guideline10, TextView textView11, TextView textView12) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = button5;
    }

    public static app.dogo.com.dogo_android.h.uc T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return uc.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.uc U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (uc)ViewDataBinding.z(layoutInflater, 2131558664, viewGroup2, z3, object4);
    }
}
