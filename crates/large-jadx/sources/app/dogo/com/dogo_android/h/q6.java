package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;

/* compiled from: CellQuestionaireCardTwoBinding.java */
/* loaded from: classes.dex */
public abstract class q6 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final Button Q;
    public final TextView R;
    protected SurveyQuestion S;
    protected q6(Object object, View view, int i, Button button, TextView textView, Button button2, TextView textView2) {
        super(object, view, i);
        this.O = button;
        this.P = textView;
        this.Q = button2;
        this.R = textView2;
    }

    public static q6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q6.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q6 V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q6)ViewDataBinding.z(layoutInflater, 2131558545, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public SurveyQuestion T() {
        return this.S;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SurveyQuestion surveyQuestion);
}
