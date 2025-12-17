package app.dogo.com.dogo_android.service;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.util.l;
import app.dogo.com.dogo_android.util.l.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00060\u0004R\u00020\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/service/StateManager;", "", "()V", "challengeState", "Lapp/dogo/com/dogo_android/service/StateManager$ChallengeState;", "ChallengeState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s2 {

    public app.dogo.com.dogo_android.service.s2.a a;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0018J\u0010\u0010\u0019\u001a\u00020\u00062\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/service/StateManager$ChallengeState;", "", "(Lapp/dogo/com/dogo_android/service/StateManager;)V", "challengeEntryViews", "", "", "", "entryStateDataHolder", "Lapp/dogo/com/dogo_android/util/EntryStateDataHolder;", "getEntryStateDataHolder", "()Lapp/dogo/com/dogo_android/util/EntryStateDataHolder;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "getModel", "()Lapp/dogo/com/dogo_android/model/ChallengeModel;", "setModel", "(Lapp/dogo/com/dogo_android/model/ChallengeModel;)V", "onEntryStateDataChangeCallback", "Landroidx/lifecycle/MutableLiveData;", "", "getEntryStateDataFor", "Lapp/dogo/com/dogo_android/util/EntryStateDataHolder$EntryStateData;", "entryId", "getOnEntryStateDataChangeCallback", "Landroidx/lifecycle/LiveData;", "getViewedEntriesCount", "challengeId", "incrementViewedEntriesCounter", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a {

        private final Map<String, Integer> a;
        private final x<Boolean> b;
        private final l c;
        public a(app.dogo.com.dogo_android.service.s2 s2) {
            n.f(s2, "this$0");
            super();
            HashMap obj2 = new HashMap();
            this.a = obj2;
            obj2 = new x();
            this.b = obj2;
            p1 p1Var = new p1(this);
            obj2 = new l(p1Var);
            this.c = obj2;
        }

        private static final void a(app.dogo.com.dogo_android.service.s2.a s2$a) {
            n.f(a, "this$0");
            a.b.setValue(Boolean.TRUE);
        }

        public static void g(app.dogo.com.dogo_android.service.s2.a s2$a) {
            s2.a.a(a);
        }

        public final l.a b(String string) {
            n.d(string);
            return this.c.b(string);
        }

        public final l c() {
            return this.c;
        }

        public final LiveData<Boolean> d() {
            return this.b;
        }

        public final int e(String string) {
            int obj2;
            obj2 = this.a.get(string);
            if ((Integer)obj2 == null) {
                obj2 = 0;
            } else {
                obj2 = (Integer)obj2.intValue();
            }
            return obj2;
        }

        public final int f(String string) {
            n.f(string, "challengeId");
            i++;
            this.a.put(string, Integer.valueOf(i2));
            return i2;
        }
    }
    public s2() {
        super();
        s2.a aVar = new s2.a(this);
        this.a = aVar;
    }
}
