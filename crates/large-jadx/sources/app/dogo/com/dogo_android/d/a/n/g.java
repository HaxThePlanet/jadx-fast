package app.dogo.com.dogo_android.d.a.n;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.n0.l;
import h.a.b.b.p;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/EntryFanImagePagerAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/EntryImagePagerAdapter;", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "listener", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;)V", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends l {

    private final b.p g;
    public g(ChallengeEntryModel challengeEntryModel, b.p b$p2) {
        n.f(challengeEntryModel, "entryModel");
        n.f(p2, "listener");
        super(challengeEntryModel, 0, 2, 0);
        this.g = p2;
    }

    private static final void x(app.dogo.com.dogo_android.d.a.n.g g, int i2, View view3) {
        n.f(g, "this$0");
        g.g.x(view3, i2);
    }

    public static void y(app.dogo.com.dogo_android.d.a.n.g g, int i2, View view3) {
        g.x(g, i2, view3);
    }

    @Override // app.dogo.com.dogo_android.util.n0.l
    public Object h(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "container");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558892, 0);
        View viewById = inflate.findViewById(2131362633);
        android.content.res.Resources resources = viewGroup.getResources();
        n.e(resources, "container.resources");
        m.n((ImageView)viewById, t(i2, resources));
        c cVar = new c(this, i2);
        viewById.setOnClickListener(cVar);
        viewGroup.addView(inflate);
        n.e(inflate, "view");
        return inflate;
    }
}
