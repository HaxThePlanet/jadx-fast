package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.e0;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ f a;
    public final /* synthetic */ RecyclerView.e0 b;
    public /* synthetic */ a(f fVar, RecyclerView.e0 e0Var) {
        super();
        this.a = fVar;
        this.b = e0Var;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.e2(this.b, view);
    }
}
