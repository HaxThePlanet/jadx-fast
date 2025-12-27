package app.dogo.com.dogo_android.u.n.r;

import app.dogo.com.dogo_android.util.e0.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.y.p;

/* compiled from: PottyTrackerOverviewViewModel.kt */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/tracker/PottyTrackerOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "()V", "imageResources", "", "", "getImageResources", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public class PottyTrackerOverviewViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<Integer> imageResources;
    public h() {
        super();
        Integer[] arr = new Integer[3];
        this.imageResources = p.j(new Integer[] { 2131231259, 2131231260, 2131231261 });
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<Integer> h() {
        return this.imageResources;
    }
}
