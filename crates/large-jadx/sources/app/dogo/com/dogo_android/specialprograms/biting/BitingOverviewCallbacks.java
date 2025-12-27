package app.dogo.com.dogo_android.u.m;

import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;
import app.dogo.com.dogo_android.u.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: BitingOverviewCallbacks.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0008H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0015", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/BitingOverviewCallbacks;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramOverviewCallback;", "onCalendarSelected", "", "action", "", "onCheckmarkButtonSelected", "checkmarked", "", "onCheckmarkCardSelected", "onNewReminderSelection", "onReadHowSelected", "onReminderEnableToggle", "item", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "newState", "onReminderSelected", "onScheduleSelected", "pottyProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "onTrackerSelected", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public interface BitingOverviewCallbacks extends j {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static void a(l lVar, String str) {
            n.f(lVar, "this");
            n.f(str, "action");
            throw new RuntimeException("Not Supported");
        }

        public static void b(l lVar, boolean z) {
            n.f(lVar, "this");
            throw new RuntimeException("Not Supported");
        }

        public static void c(l lVar, String str) {
            n.f(lVar, "this");
            n.f(str, "action");
            throw new RuntimeException("Not Supported");
        }

        public static void d(l lVar) {
            n.f(lVar, "this");
            throw new RuntimeException("Not Supported");
        }

        public static void e(l lVar, String str) {
            n.f(lVar, "this");
            n.f(str, "action");
            throw new RuntimeException("Not Supported");
        }

        public static void f(l lVar, PottyRemindersItem pottyRemindersItem, boolean z) {
            n.f(lVar, "this");
            n.f(pottyRemindersItem, "item");
            throw new RuntimeException("Not Supported");
        }

        public static void g(l lVar, PottyRemindersItem pottyRemindersItem) {
            n.f(lVar, "this");
            n.f(pottyRemindersItem, "item");
            throw new RuntimeException("Not Supported");
        }

        public static void h(l lVar, PottyProgramProgress pottyProgramProgress) {
            n.f(lVar, "this");
            n.f(pottyProgramProgress, "pottyProgress");
            throw new RuntimeException("Not Supported");
        }
    }
}
