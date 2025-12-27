package app.dogo.com.dogo_android.d.c.j;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.e0;
import app.dogo.com.dogo_android.h.c1;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.util.e0.b0;
import com.google.firebase.Timestamp;
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeNotificationItem.kt */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 ,2\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0003:\u0002+,B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J>\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00140\u00132\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000f2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018H\u0016J&\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0010\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00140\u0013H\u0016J\u0013\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010 \u001a\u00020!H\u0016J\u0008\u0010\"\u001a\u00020\u000fH\u0016J\u0006\u0010#\u001a\u00020$J\u0008\u0010%\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0000H\u0002J\u0008\u0010(\u001a\u00020\u000fH\u0016J\u0014\u0010)\u001a\u00020\u001e2\n\u0010'\u001a\u0006\u0012\u0002\u0008\u00030\u0003H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem;", "Leu/davidea/flexibleadapter/items/AbstractFlexibleItem;", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem$ChallengeNotificationItemViewHolder;", "Lapp/dogo/com/dogo_android/util/base_classes/SortableIFlexible;", "itemModel", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "(Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;)V", "creationDate", "", "getCreationDate", "()J", "getItemModel", "()Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "setItemModel", "priority", "", "bindViewHolder", "", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "Leu/davidea/flexibleadapter/items/IFlexible;", "holder", "position", "payloads", "", "", "createViewHolder", "view", "Landroid/view/View;", "equals", "", "other", "getId", "", "getLayoutRes", "getNotificationModel", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "getSortingPriority", "hasViewElementsChanged", "newItem", "hashCode", "isContentSame", "setSortingPriority", "ChallengeNotificationItemViewHolder", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class ChallengeNotificationItem extends a<a.a> implements b0<a.a> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final a.b INSTANCE = new a$b(0);
    private b a;
    private int b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem$Companion;", "", "()V", "ENTRY_IMAGE_VIEW_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        private b() {
            super();
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\t\u001a\u00020\u0003H\u0016J\u0008\u0010\n\u001a\u00020\u0003H\u0016J\u000e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem$ChallengeNotificationItemViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "view", "Landroid/view/View;", "adapter", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "(Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItem;Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "binding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeNotificationItemBinding;", "getFrontView", "getRearRightView", "setModel", "", "model", "Lapp/dogo/com/dogo_android/challenge/notificationcenter/notificationlist/ChallengeNotificationItemModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends h.a.c.b {

        /* renamed from: a, reason: from kotlin metadata */
        private final c1 binding;
        public a(View view, h.a.b.b bVar) {
            n.f(aVar, "this$0");
            n.f(view, "view");
            n.f(bVar, "adapter");
            super(view, bVar);
            c1 c1Var = c1.T(view);
            n.e(c1Var, "bind(view)");
            this.binding = c1Var;
            c1Var.T.setOnClickListener(this);
        }

        @Override // h.a.c.b
        /* renamed from: a, reason: from kotlin metadata */
        public final void setModel(b model) {
            n.f(model, "model");
            this.binding.V(model);
        }

        @Override // h.a.c.b
        public View getFrontView() {
            n.e(this.binding.U, "binding.frontView");
            return this.binding.U;
        }

        @Override // h.a.c.b
        public View getRearRightView() {
            n.e(this.binding.Z, "binding.rearRight");
            return this.binding.Z;
        }
    }
    public a(b bVar) {
        n.f(bVar, "itemModel");
        super();
        this.a = bVar;
    }

    /* renamed from: j, reason: from kotlin metadata */
    /* operator */ private final boolean equals(a other) {
        int i;
        int i2;
        boolean z = true;
        Timestamp sortingDate = this.a.f().getSortingDate();
        i = 0;
        if (sortingDate == null) {
        } else {
            Long num = Long.valueOf(sortingDate.getSeconds());
        }
        Timestamp sortingDate2 = other.a.f().getSortingDate();
        if (sortingDate2 != null) {
            Long num2 = Long.valueOf(sortingDate2.getSeconds());
        }
        i2 = 1;
        i2 = 0;
        int r0 = i2;
        other = i2;
        if (this.a == 0 || other.a == 0) {
        }
        return z;
    }

    @Override // h.a.b.h.a
    public void e(h.a.b.b<f<?>> bVar, a.a aVar, int i, List<? extends Object> list) {
        str2 = "adapter";
        n.f(bVar, str2);
        str = "holder";
        n.f(aVar, str);
        if (list != null) {
            if (!list.isEmpty()) {
                int i2 = 0;
                if (list.get(i2) instanceof ChallengeNotificationItem) {
                    this.a = (ChallengeNotificationItem)list.get(i2).a;
                }
            }
        }
        aVar.setModel(this.a);
    }

    @Override // h.a.b.h.a
    public boolean equals(Object object) {
        if (object instanceof ChallengeNotificationItem) {
            return n.b(this.a.f().getEntryId(), object.a.f().getEntryId());
        }
        return false;
    }

    @Override // h.a.b.h.a
    public a.a f(View view, h.a.b.b<f<?>> bVar) {
        n.f(view, "view");
        n.f(bVar, "adapter");
        return new ChallengeNotificationItem_ChallengeNotificationItemViewHolder(this, view, bVar);
    }

    @Override // h.a.b.h.a
    /* renamed from: g, reason: from kotlin metadata */
    public final long getId() {
        int i = 0;
        Timestamp sortingDate = this.a.f().getSortingDate();
        if (sortingDate == null) {
            i = 0;
        } else {
            long seconds = sortingDate.getSeconds();
        }
        return i;
    }

    @Override // h.a.b.h.a
    public String getId() {
        return this.a.f().getEntryId();
    }

    @Override // h.a.b.h.a
    public int getSortingPriority() {
        return this.b;
    }

    @Override // h.a.b.h.a
    public final b h() {
        return this.a;
    }

    @Override // h.a.b.h.a
    public int hashCode() {
        return (this.a.f().hashCode() * 31) + this.b;
    }

    @Override // h.a.b.h.a
    public final ChallengeNotificationModel i() {
        return this.a.f();
    }

    @Override // h.a.b.h.a
    public boolean isContentSame(b0<?> newItem) {
        boolean equals = true;
        n.f(newItem, "newItem");
        if (newItem instanceof ChallengeNotificationItem) {
            equals = equals(newItem);
        } else {
            int i = 1;
        }
        return equals;
    }


    @Override // h.a.b.h.a
    public int getLayoutRes() {
        return R.layout.cell_challenge_notification_item;
    }
}
