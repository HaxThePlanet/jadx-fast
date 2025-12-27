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

/* compiled from: FragmentExamExplanationBinding.java */
/* loaded from: classes.dex */
public abstract class uc extends ViewDataBinding {

    public final TextView O;
    public final Button P;
    protected uc(Object object, View view, int i, TextView textView, Button button, ImageView imageView, ImageView imageView2, Guideline guideline, ImageView imageView3, Guideline guideline2, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = textView;
        this.P = button;
    }

    public static uc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return uc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static uc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (uc)ViewDataBinding.z(layoutInflater, 2131558664, viewGroup, z, object);
    }
}
