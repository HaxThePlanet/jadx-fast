package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;

/* loaded from: classes.dex */
public abstract class o6 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final TextView Q;
    public final Button R;
    public final Button S;
    protected SurveyQuestion T;
    protected o6(Object object, View view2, int i3, Button button4, TextView textView5, TextView textView6, Button button7, Button button8) {
        super(object, view2, i3);
        this.O = button4;
        this.P = textView5;
        this.Q = textView6;
        this.R = button7;
        this.S = button8;
    }

    public static app.dogo.com.dogo_android.h.o6 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return o6.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.o6 V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (o6)ViewDataBinding.z(layoutInflater, 2131558544, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public SurveyQuestion T() {
        return this.T;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SurveyQuestion surveyQuestion);
}
