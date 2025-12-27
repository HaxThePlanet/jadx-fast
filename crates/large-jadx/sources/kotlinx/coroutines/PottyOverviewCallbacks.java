package app.dogo.com.dogo_android.u.n;

import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.u.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: PottyOverviewCallbacks.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\rH\u0016¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyOverviewCallbacks;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;", "onCoreTrickSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onHelpCardSelected", "userPremium", "", "onLockedTrickSelected", "onVariationTrickSelected", "programDescriptionClicked", "description", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public interface PottyOverviewCallbacks extends j {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static void a(k kVar, TrickItem trickItem) {
            n.f(kVar, "this");
            n.f(trickItem, "item");
            throw new RuntimeException("Not Supported");
        }

        public static void b(k kVar, boolean z) {
            n.f(kVar, "this");
            throw new RuntimeException("Not Supported");
        }

        public static void c(k kVar) {
            n.f(kVar, "this");
            throw new RuntimeException("Not Supported");
        }

        public static void d(k kVar, TrickItem trickItem) {
            n.f(kVar, "this");
            n.f(trickItem, "item");
            throw new RuntimeException("Not Supported");
        }

        public static void e(k kVar, String str) {
            n.f(kVar, "this");
            n.f(str, "description");
            throw new RuntimeException("Not Supported");
        }
    }
}
