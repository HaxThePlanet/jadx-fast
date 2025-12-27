package app.dogo.com.dogo_android.util.n0;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.a;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;

/* compiled from: EntryImagePagerAdapter.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u00020\u0001B\u0019\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0008H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0008J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0008H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/EntryImagePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "firstSlotReserved", "", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Z)V", "entriesImageCount", "", "getEntryModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "inflatedViews", "", "Landroid/widget/ImageView;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getImageAt", "", "resources", "Landroid/content/res/Resources;", "getImageViewAt", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "object", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public class EntryImagePagerAdapter extends a {

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean entriesImageCount;
    /* renamed from: d, reason: from kotlin metadata */
    private final ChallengeEntryModel entryModel;
    /* renamed from: e, reason: from kotlin metadata */
    private final List<ImageView> firstSlotReserved;
    /* renamed from: f, reason: from kotlin metadata */
    private final int inflatedViews;
    public l(ChallengeEntryModel challengeEntryModel, boolean z) {
        n.f(challengeEntryModel, "entryModel");
        super();
        this.firstSlotReserved = new ArrayList();
        this.entryModel = challengeEntryModel;
        this.entriesImageCount = z;
        this.inflatedViews = challengeEntryModel.getImageCount() + z;
    }

    /* renamed from: v, reason: from kotlin metadata */
    private static final void getImageAt(ViewGroup position, View resources) {
        n.f(position, "$container");
        position.callOnClick();
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: a, reason: from kotlin metadata */
    public void destroyItem(ViewGroup container, int position, Object view) {
        n.f(container, "container");
        n.f(view, "view");
        container.removeView(view);
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: d, reason: from kotlin metadata */
    public int getCount() {
        return this.inflatedViews;
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: h, reason: from kotlin metadata */
    public Object isViewFromObject(ViewGroup view, int object) {
        int object2;
        n.f(view, "container");
        int r0 = this.entriesImageCount ? object - 1 : object;
        View inflate = LayoutInflater.from(view.getContext()).inflate(2131558892, null);
        View viewById = inflate.findViewById(2131362633);
        n.e(viewById, "imageView");
        this.firstSlotReserved.add(viewById);
        String str4 = "view";
        if (this.entriesImageCount && object == null) {
            BindingAdapters.w(viewById, "");
            view.addView(inflate);
            n.e(inflate, str4);
            return inflate;
        }
        Resources resources = view.getResources();
        n.e(resources, "container.resources");
        BindingAdapters.w(viewById, t(object2, resources));
        viewById.setOnClickListener(new app.dogo.com.dogo_android.util.recycle_views.c(view));
        view.addView(inflate);
        n.e(inflate, str4);
        return inflate;
    }

    @Override // androidx.viewpager.widget.a
    protected final String t(int i, Resources resources) {
        String i2;
        n.f(resources, "resources");
        i2 = "";
        return i2;
    }

    @Override // androidx.viewpager.widget.a
    /* renamed from: u, reason: from kotlin metadata */
    public final ImageView getImageViewAt(int position) {
        return (ImageView)this.firstSlotReserved.get(position);
    }

    public /* synthetic */ l(ChallengeEntryModel challengeEntryModel, boolean z, int i, g gVar) {
        i = i & 2 != 0 ? 0 : i;
        this(challengeEntryModel, z);
    }

    public l(ChallengeEntryModel challengeEntryModel) {
        n.f(challengeEntryModel, "entryModel");
        this(challengeEntryModel, false, 2, null);
    }

    /* renamed from: w, reason: from kotlin metadata */
    public static /* synthetic */ void instantiateItem(ViewGroup container, View position) {
        EntryImagePagerAdapter.getImageAt(container, position);
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object object) {
        boolean z = true;
        n.f(view, "view");
        n.f(object, "object");
        view = object == view ? 1 : 0;
        return (object == view ? 1 : 0);
    }
}
