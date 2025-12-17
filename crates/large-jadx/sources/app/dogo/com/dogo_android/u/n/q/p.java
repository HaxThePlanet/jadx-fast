package app.dogo.com.dogo_android.u.n.q;

import app.dogo.com.dogo_android.util.e0.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/reminders/ReminderIntervalViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "intervalList", "", "", "(Ljava/util/List;)V", "getIntervalList", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends s {

    private final List<Long> a;
    public p(List<Long> list) {
        n.f(list, "intervalList");
        super();
        this.a = list;
    }

    public final List<Long> h() {
        return this.a;
    }
}
