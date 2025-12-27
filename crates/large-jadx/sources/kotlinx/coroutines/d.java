package app.dogo.com.dogo_android.n.k;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final /* synthetic */ n a;
    public final /* synthetic */ n.a b;
    public /* synthetic */ d(n nVar, n.a aVar) {
        super();
        this.a = nVar;
        this.b = aVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ArticleListAdapter_ArticleItem.b(this.a, this.b, view);
    }
}
