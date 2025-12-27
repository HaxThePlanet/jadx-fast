package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: CellProgramComingSoonCardBinding.java */
/* loaded from: classes.dex */
public abstract class c4 extends ViewDataBinding {

    public final CardView O;
    public final ImageView P;
    public final TextView Q;
    protected ProgramDescriptionItem R;
    protected c4(Object object, View view, int i, TextView textView, CardView cardView, ImageView imageView, TextView textView2, Guideline guideline) {
        super(object, view, i);
        this.O = cardView;
        this.P = imageView;
        this.Q = textView2;
    }

    public static c4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return c4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static c4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (c4)ViewDataBinding.z(layoutInflater, 2131558512, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}
