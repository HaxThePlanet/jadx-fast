package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.DogProfile;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class m implements View.OnClickListener {

    public final /* synthetic */ v a;
    public final /* synthetic */ DogProfile b;
    public /* synthetic */ m(v vVar, DogProfile dogProfile) {
        super();
        this.a = vVar;
        this.b = dogProfile;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogProfileBindingAdapters.U(this.a, this.b, view);
    }
}
