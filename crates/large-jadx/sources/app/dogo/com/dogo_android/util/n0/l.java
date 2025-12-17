package app.dogo.com.dogo_android.util.n0;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.a;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u00020\u0001B\u0019\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0008H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0008J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0008H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/util/recycle_views/EntryImagePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "entryModel", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "firstSlotReserved", "", "(Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;Z)V", "entriesImageCount", "", "getEntryModel", "()Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "inflatedViews", "", "Landroid/widget/ImageView;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "view", "", "getCount", "getImageAt", "", "resources", "Landroid/content/res/Resources;", "getImageViewAt", "instantiateItem", "isViewFromObject", "Landroid/view/View;", "object", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class l extends a {

    private final boolean c;
    private final ChallengeEntryModel d;
    private final List<ImageView> e;
    private final int f;
    public l(ChallengeEntryModel challengeEntryModel) {
        n.f(challengeEntryModel, "entryModel");
        super(challengeEntryModel, 0, 2, 0);
    }

    public l(ChallengeEntryModel challengeEntryModel, boolean z2) {
        n.f(challengeEntryModel, "entryModel");
        super();
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        this.d = challengeEntryModel;
        this.c = z2;
        this.f = obj2 += z2;
    }

    public l(ChallengeEntryModel challengeEntryModel, boolean z2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(challengeEntryModel, obj2);
    }

    private static final void v(ViewGroup viewGroup, View view2) {
        n.f(viewGroup, "$container");
        viewGroup.callOnClick();
    }

    public static void w(ViewGroup viewGroup, View view2) {
        l.v(viewGroup, view2);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i2, Object object3) {
        n.f(viewGroup, "container");
        n.f(object3, "view");
        viewGroup.removeView((View)object3);
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.f;
    }

    @Override // androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i2) {
        int i;
        n.f(viewGroup, "container");
        i = this.c ? i2 + -1 : i2;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558892, 0);
        View viewById = inflate.findViewById(2131362633);
        n.e((ImageView)viewById, "imageView");
        this.e.add(viewById);
        String str4 = "view";
        if (this.c && i2 == 0) {
            if (i2 == 0) {
                n.w(viewById, "");
                viewGroup.addView(inflate);
                n.e(inflate, str4);
                return inflate;
            }
        }
        Resources obj7 = viewGroup.getResources();
        n.e(obj7, "container.resources");
        n.w(viewById, t(i, obj7));
        obj7 = new c(viewGroup);
        viewById.setOnClickListener(obj7);
        viewGroup.addView(inflate);
        n.e(inflate, str4);
        return inflate;
    }

    @Override // androidx.viewpager.widget.a
    public boolean i(View view, Object object2) {
        int obj2;
        n.f(view, "view");
        n.f(object2, "object");
        obj2 = object2 == view ? 1 : 0;
        return obj2;
    }

    @Override // androidx.viewpager.widget.a
    protected final String t(int i, Resources resources2) {
        String str;
        int obj3;
        n.f(resources2, "resources");
        ChallengeEntryModel challengeEntryModel = this.d;
        str = "";
        if (challengeEntryModel != null) {
            obj3 = challengeEntryModel.getImageAt(resources2, i);
            if (obj3 == null) {
            } else {
                str = obj3;
            }
        }
        return str;
    }

    @Override // androidx.viewpager.widget.a
    public final ImageView u(int i) {
        return (ImageView)this.e.get(i);
    }
}
