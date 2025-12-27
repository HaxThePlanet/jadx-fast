package app.dogo.com.dogo_android.q.q;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ f a;
    public final /* synthetic */ f.b b;
    public /* synthetic */ a(f fVar, f.b bVar) {
        super();
        this.a = fVar;
        this.b = bVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogSelectAdapter_Holder.a(this.a, this.b, view);
    }
}
