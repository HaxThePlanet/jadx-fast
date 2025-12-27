package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final /* synthetic */ v a;
    public final /* synthetic */ ProfilePreview b;
    public /* synthetic */ k(v vVar, ProfilePreview profilePreview) {
        super();
        this.a = vVar;
        this.b = profilePreview;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogProfileBindingAdapters.F(this.a, this.b, view);
    }
}
