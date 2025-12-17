package app.dogo.com.dogo_android.d.a;

import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.entry_list_item_models.BlankScreenCell;
import app.dogo.com.dogo_android.util.k0.f;
import app.dogo.com.dogo_android.util.n0.d;
import h.a.b.b;
import h.a.b.h.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00020\u0001B/\u0012\u0014\u0010\u0003\u001a\u0010\u0012\n\u0012\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u0002\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0010\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0008\u0010\u0012\u001a\u00020\u000eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/challenge/challengefanlist/ChallengeFanListAdapter;", "Lapp/dogo/com/dogo_android/util/recycle_views/BaseFlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "items", "", "messageBroadcaster", "Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;", "parentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/util/interfaces/MessageBroadcaster;Lapp/dogo/com/dogo_android/enums/TagGlue;)V", "endOfList", "", "loadingCellState", "addLoadingCell", "", "addMoreFans", "fanItems", "markEndOfList", "removeLoadingCell", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k extends d<f<?>> {

    private boolean F0;
    private boolean G0;
    public k(List<? extends f<?>> list, f f2, q q3) {
        super(list, f2, q3);
        g2();
    }

    private final void g2() {
        boolean z;
        int i;
        if (!this.F0 && !this.G0) {
            if (!this.G0) {
                BlankScreenCell blankScreenCell = new BlankScreenCell(0);
                Y(blankScreenCell);
                this.F0 = true;
            }
        }
    }

    private final void j2() {
        boolean z;
        if (this.F0) {
            removeItem(itemCount--);
            this.F0 = false;
        }
    }

    public final void h2(List<? extends f<?>> list) {
        n.f(list, "fanItems");
        Z(itemCount -= f0, list);
    }

    @Override // app.dogo.com.dogo_android.util.n0.d
    public final void i2() {
        this.G0 = true;
        j2();
    }
}
