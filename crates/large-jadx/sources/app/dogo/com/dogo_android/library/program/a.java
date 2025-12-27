package app.dogo.com.dogo_android.n.l;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ b.b a;
    public final /* synthetic */ b b;
    public /* synthetic */ a(b.b bVar, b bVar2) {
        super();
        this.a = bVar;
        this.b = bVar2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ProgramListCardAdapter_SliderViewHolder.a(this.a, this.b, view);
    }
}
