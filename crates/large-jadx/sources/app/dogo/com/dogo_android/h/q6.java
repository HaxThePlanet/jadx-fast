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
public abstract class q6 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final Button Q;
    public final TextView R;
    protected SurveyQuestion S;
    protected q6(Object object, View view2, int i3, Button button4, TextView textView5, Button button6, TextView textView7) {
        super(object, view2, i3);
        this.O = button4;
        this.P = textView5;
        this.Q = button6;
        this.R = textView7;
    }

    public static app.dogo.com.dogo_android.h.q6 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q6.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q6 V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q6)ViewDataBinding.z(layoutInflater, 2131558545, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public SurveyQuestion T() {
        return this.S;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SurveyQuestion surveyQuestion);
}
