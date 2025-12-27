package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.y.d0.n.a;
import java.util.List;

/* compiled from: LayoutProgramTrainingPlanBinding.java */
/* loaded from: classes.dex */
public abstract class mm extends ViewDataBinding {

    public final RecyclerView O;
    protected n.a P;
    protected List<TrickItem> Q;
    protected mm(Object object, View view, int i, TextView textView, TextView textView2, RecyclerView recyclerView, TextView textView3) {
        super(object, view, i);
        this.O = recyclerView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(n.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(List<TrickItem> list);
}
