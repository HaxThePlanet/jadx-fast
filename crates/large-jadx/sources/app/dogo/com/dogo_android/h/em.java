package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;

/* loaded from: classes.dex */
public abstract class em extends ViewDataBinding {

    public final ProgressBar O;
    public final TextView P;
    protected ModuleCompletionSummary Q;
    protected em(Object object, View view2, int i3, ProgressBar progressBar4, TextView textView5) {
        super(object, view2, i3);
        this.O = progressBar4;
        this.P = textView5;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(ModuleCompletionSummary moduleCompletionSummary);
}
