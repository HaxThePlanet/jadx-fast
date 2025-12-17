package app.dogo.com.dogo_android.util.n0;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView.e0;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.util.n0.f a;
    public final RecyclerView.e0 b;
    public a(app.dogo.com.dogo_android.util.n0.f f, RecyclerView.e0 recyclerView$e02) {
        super();
        this.a = f;
        this.b = e02;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.a.e2(this.b, view);
    }
}
