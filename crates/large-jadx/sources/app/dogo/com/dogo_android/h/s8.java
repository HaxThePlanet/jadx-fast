package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: DialogChallengeShareBinding.java */
/* loaded from: classes.dex */
public abstract class s8 extends ViewDataBinding {

    public final Button O;
    public final RelativeLayout P;
    public final RelativeLayout Q;
    protected s8(Object object, View view, int i, Button button, ImageView imageView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = relativeLayout;
        this.Q = relativeLayout2;
    }

    public static s8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s8)ViewDataBinding.z(layoutInflater, 2131558597, viewGroup, z, object);
    }
}
