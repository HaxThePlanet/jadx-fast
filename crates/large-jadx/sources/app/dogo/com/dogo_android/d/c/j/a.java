package app.dogo.com.dogo_android.d.c.j;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.c1;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.util.e0.b0;
import com.google.firebase.Timestamp;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import h.a.c.b;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 ,2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0003:\u0002+,B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J>\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00140\u00132\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J&\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0010\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00140\u0013H\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010 \u001a\u00020!H\u0016J\u0008\u0010\"\u001a\u00020\u000fH\u0016J\u0006\u0010#\u001a\u00020$J\u0008\u0010%\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0000H\u0002J\u0008\u0010(\u001a\u00020\u000fH\u0016J\u0014\u0010)\u001a\u00020\u001e2\n\u0010'\u001a\u0006\u0012\u0002\u0008\u00030\u0003H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem;", "Leu/davidea/flexibleadapter/items/AbstractFlexibleItem;", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem$ChallengeNotificationItemViewHolder;", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "itemModel", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "(Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;)V", "creationDate", "", "getCreationDate", "()J", "getItemModel", "()Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "setItemModel", "priority", "", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "holder", "position", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getId", "", "getLayoutRes", "getNotificationModel", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "getSortingPriority", "hasViewElementsChanged", "newItem", "hashCode", "isContentSame", "setSortingPriority", "ChallengeNotificationItemViewHolder", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a extends a<app.dogo.com.dogo_android.d.c.j.a.a> implements b0<app.dogo.com.dogo_android.d.c.j.a.a> {

    public static final app.dogo.com.dogo_android.d.c.j.a.b Companion;
    private app.dogo.com.dogo_android.d.c.j.b a;
    private int b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem$Companion;", "", "()V", "ENTRY_IMAGE_VIEW_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\u0003H\u0016J\u0008\u0010\n\u001a\u00020\u0003H\u0016J\u000e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem$ChallengeNotificationItemViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "(Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem;Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "binding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeNotificationItemBinding;", "getFrontView", "getRearRightView", "setModel", "", "model", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends b {

        private final c1 a;
        public a(app.dogo.com.dogo_android.d.c.j.a a, View view2, b b3) {
            n.f(a, "this$0");
            n.f(view2, "view");
            n.f(b3, "adapter");
            super(view2, b3);
            c1 obj2 = c1.T(view2);
            n.e(obj2, "bind(view)");
            this.a = obj2;
            obj2.T.setOnClickListener(this);
        }

        @Override // h.a.c.b
        public final void a(app.dogo.com.dogo_android.d.c.j.b b) {
            n.f(b, "model");
            this.a.V(b);
        }

        @Override // h.a.c.b
        public View getFrontView() {
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout = c1Var.U;
            n.e(constraintLayout, "binding.frontView");
            return constraintLayout;
        }

        @Override // h.a.c.b
        public View getRearRightView() {
            android.widget.RelativeLayout relativeLayout = c1Var.Z;
            n.e(relativeLayout, "binding.rearRight");
            return relativeLayout;
        }
    }
    static {
        a.b bVar = new a.b(0);
        a.Companion = bVar;
    }

    public a(app.dogo.com.dogo_android.d.c.j.b b) {
        n.f(b, "itemModel");
        super();
        this.a = b;
    }

    private final boolean j(app.dogo.com.dogo_android.d.c.j.a a) {
        int valueOf;
        int i;
        int valueOf2;
        long seconds;
        int i2;
        int obj5;
        Timestamp sortingDate = this.a.f().getSortingDate();
        if (sortingDate == null) {
            valueOf = valueOf2;
        } else {
            valueOf = Long.valueOf(sortingDate.getSeconds());
        }
        Timestamp sortingDate2 = a.a.f().getSortingDate();
        if (sortingDate2 == null) {
        } else {
            valueOf2 = Long.valueOf(sortingDate2.getSeconds());
        }
        i2 = 1;
        final int i3 = 0;
        i = valueOf == valueOf2 ? i2 : i3;
        obj5 = this.a.f().isActive() == a.a.f().isActive() ? i2 : i3;
        if (i != 0 && obj5 != null) {
            if (obj5 != null) {
            } else {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }

    @Override // h.a.b.h.a
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        e(b, (a.a)e02, i3, list4);
    }

    @Override // h.a.b.h.a
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return f(view, b2);
    }

    public void e(b<f<?>> b, app.dogo.com.dogo_android.d.c.j.a.a a$a2, int i3, List<? extends Object> list4) {
        String obj1;
        String obj3;
        n.f(b, "adapter");
        n.f(a2, "holder");
        obj1 = 0;
        if (list4 != null && obj1 ^= 1 != 0 && obj3 instanceof a) {
            if (obj1 ^= 1 != 0) {
                obj1 = 0;
                if (obj3 instanceof a) {
                    this.a = obj1.a;
                }
            }
        }
        a2.a(this.a);
    }

    @Override // h.a.b.h.a
    public boolean equals(Object object) {
        if (object instanceof a) {
            return n.b(this.a.f().getEntryId(), object.a.f().getEntryId());
        }
        return 0;
    }

    public app.dogo.com.dogo_android.d.c.j.a.a f(View view, b<f<?>> b2) {
        n.f(view, "view");
        n.f(b2, "adapter");
        a.a aVar = new a.a(this, view, b2);
        return aVar;
    }

    @Override // h.a.b.h.a
    public final long g() {
        int seconds;
        Timestamp sortingDate = this.a.f().getSortingDate();
        if (sortingDate == null) {
            seconds = 0;
        } else {
            seconds = sortingDate.getSeconds();
        }
        return seconds;
    }

    @Override // h.a.b.h.a
    public String getId() {
        return this.a.f().getEntryId();
    }

    @Override // h.a.b.h.a
    public int getLayoutRes() {
        return 2131558472;
    }

    @Override // h.a.b.h.a
    public int getSortingPriority() {
        return this.b;
    }

    @Override // h.a.b.h.a
    public final app.dogo.com.dogo_android.d.c.j.b h() {
        return this.a;
    }

    @Override // h.a.b.h.a
    public int hashCode() {
        return i2 += i4;
    }

    @Override // h.a.b.h.a
    public final ChallengeNotificationModel i() {
        return this.a.f();
    }

    public boolean isContentSame(b0<?> b0) {
        boolean obj2;
        n.f(b0, "newItem");
        if (b0 instanceof a) {
            obj2 = j((a)b0);
        } else {
            obj2 = 1;
        }
        return obj2;
    }
}
