package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class id extends ViewDataBinding {

    public final MaterialToolbar O;
    protected id(Object object, View view2, int i3, FrameLayout frameLayout4, TextView textView5, ImageView imageView6, TextView textView7, MaterialToolbar materialToolbar8) {
        super(object, view2, i3);
        this.O = materialToolbar8;
    }

    public static app.dogo.com.dogo_android.h.id T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return id.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.id U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (id)ViewDataBinding.z(layoutInflater, 2131558671, viewGroup2, z3, object4);
    }
}
