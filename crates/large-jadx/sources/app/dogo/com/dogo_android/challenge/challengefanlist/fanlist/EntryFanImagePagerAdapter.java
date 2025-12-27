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

/* compiled from: EntryFanImagePagerAdapter.kt */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/fanlist/EntryFanImagePagerAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/EntryImagePagerAdapter;", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "listener", "Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Leu/davidea/flexibleadapter/FlexibleAdapter$OnItemClickListener;)V", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class EntryFanImagePagerAdapter extends l {

    /* renamed from: g, reason: from kotlin metadata */
    private final b.p listener;
    public g(ChallengeEntryModel challengeEntryModel, b.p pVar) {
        n.f(challengeEntryModel, "entryModel");
        n.f(pVar, "listener");
        super(challengeEntryModel, false, 2, null);
        this.listener = pVar;
    }

    private static final void x(g gVar, int i, View view) {
        n.f(gVar, "this$0");
        gVar.listener.x(view, i);
    }

    @Override // app.dogo.com.dogo_android.util.n0.l
    /* renamed from: h, reason: from kotlin metadata */
    public Object instantiateItem(ViewGroup container, int position) {
        n.f(container, "container");
        View inflate = LayoutInflater.from(container.getContext()).inflate(2131558892, null);
        View viewById = inflate.findViewById(2131362633);
        android.content.res.Resources resources = container.getResources();
        n.e(resources, "container.resources");
        app.dogo.com.dogo_android.util.binding.m.n(viewById, t(position, resources));
        viewById.setOnClickListener(new app.dogo.com.dogo_android.challenge.challengefanlist.fanlist.c(this, position));
        container.addView(inflate);
        n.e(inflate, "view");
        return inflate;
    }

    public static /* synthetic */ void y(g gVar, int i, View view) {
        EntryFanImagePagerAdapter.x(gVar, i, view);
    }
}
