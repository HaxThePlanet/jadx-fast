package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;

/* compiled from: CellQuestionaireCardThreeBinding.java */
/* loaded from: classes.dex */
public abstract class o6 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    public final TextView Q;
    public final Button R;
    public final Button S;
    protected SurveyQuestion T;
    protected o6(Object object, View view, int i, Button button, TextView textView, TextView textView2, Button button2, Button button3) {
        super(object, view, i);
        this.O = button;
        this.P = textView;
        this.Q = textView2;
        this.R = button2;
        this.S = button3;
    }

    public static o6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return o6.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static o6 V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (o6)ViewDataBinding.z(layoutInflater, 2131558544, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public SurveyQuestion T() {
        return this.T;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SurveyQuestion surveyQuestion);
}
