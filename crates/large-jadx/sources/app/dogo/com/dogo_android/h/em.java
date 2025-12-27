package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;

/* compiled from: LayoutProgramModuleProgressBarBinding.java */
/* loaded from: classes.dex */
public abstract class em extends ViewDataBinding {

    public final ProgressBar O;
    public final TextView P;
    protected ModuleCompletionSummary Q;
    protected em(Object object, View view, int i, ProgressBar progressBar, TextView textView) {
        super(object, view, i);
        this.O = progressBar;
        this.P = textView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(ModuleCompletionSummary moduleCompletionSummary);
}
