package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellProgramQuestionAnswerItemBinding.java */
/* loaded from: classes.dex */
public abstract class a6 extends ViewDataBinding {

    public final TextView O;
    public final CardView P;
    protected a6(Object object, View view, int i, TextView textView, CardView cardView) {
        super(object, view, i);
        this.O = textView;
        this.P = cardView;
    }

    public static a6 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return a6.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static a6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (a6)ViewDataBinding.z(layoutInflater, 2131558537, viewGroup, z, object);
    }
}
