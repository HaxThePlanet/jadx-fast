package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class ke extends ViewDataBinding {

    public final MaterialButton O;
    public final MaterialToolbar P;
    protected ke(Object object, View view2, int i3, TextView textView4, AppCompatImageView appCompatImageView5, MaterialButton materialButton6, TextView textView7, MaterialToolbar materialToolbar8) {
        super(object, view2, i3);
        this.O = materialButton6;
        this.P = materialToolbar8;
    }

    public static app.dogo.com.dogo_android.h.ke T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ke.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ke U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ke)ViewDataBinding.z(layoutInflater, 2131558686, viewGroup2, z3, object4);
    }
}
