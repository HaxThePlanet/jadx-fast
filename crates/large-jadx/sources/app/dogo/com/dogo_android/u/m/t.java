package app.dogo.com.dogo_android.u.m;

import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.s;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/VariationTipsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "variation", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "pausedTimeSeconds", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;J)V", "getPausedTimeSeconds", "()J", "getVariation", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t extends s {

    private final TrickItem a;
    private final long b;
    public t(TrickItem trickItem, long l2) {
        n.f(trickItem, "variation");
        super();
        this.a = trickItem;
        this.b = l2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final long h() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem i() {
        return this.a;
    }
}
