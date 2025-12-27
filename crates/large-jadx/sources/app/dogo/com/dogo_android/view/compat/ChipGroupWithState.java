package app.dogo.com.dogo_android.view.compat;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import d.h.l.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.j0.h;

/* compiled from: ChipGroupWithState.kt */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008B!\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0016\u0010\u0013\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0006\u0010\u0014\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00162\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u000f2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0014J\u0016\u0010\u001c\u001a\u00020\u000f2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0018H\u0002J\u0006\u0010\u001f\u001a\u00020\u000fJ\u0014\u0010 \u001a\u00020\u000f2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0018R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/view/compat/ChipGroupWithState;", "Lcom/google/android/material/chip/ChipGroup;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastSelectedTag", "", "dispatchRestoreInstanceState", "", "container", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "getLastSelectedId", "hasGroupTagsChanged", "", "list", "", "onRestoreInstanceState", "state", "onSaveInstanceState", "refreshGroupViews", "newData", "Landroid/view/View;", "saveLastSelectedTag", "updateViewSet", "items", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ChipGroupWithState extends ChipGroup implements androidx.lifecycle.p {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ChipGroupWithState.a INSTANCE = new ChipGroupWithState$a(0);
    /* renamed from: G, reason: from kotlin metadata */
    private String lastSelectedTag = "";

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/view/compat/ChipGroupWithState$Companion;", "", "()V", "SPARSE_SELECTED_KEY", "", "SUPER_STATE_KEY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
    public ChipGroupWithState(Context context, AttributeSet set) {
        n.f(context, "context");
        super(context, set);
    }

    /* renamed from: w, reason: from kotlin metadata */
    private final boolean dispatchRestoreInstanceState(List<String> container) {
        int i;
        boolean z = false;
        boolean empty;
        boolean hasNext2;
        Object tag;
        Iterator it = x.b(this).iterator();
        i = 0;
        i = 1;
        while (it.hasNext()) {
            empty = container instanceof Collection;
            int r1 = i;
            if (i != 0) {
                break;
            }
        }
        int r2 = i;
        return i;
    }

    /* renamed from: x, reason: from kotlin metadata */
    private final void dispatchSaveInstanceState(List<? extends View> container) {
        removeAllViews();
        final Iterator it = container.iterator();
        while (it.hasNext()) {
            addView((View)it.next());
        }
    }

    @Override // com.google.android.material.chip.ChipGroup
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        n.f(sparseArray, "container");
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // com.google.android.material.chip.ChipGroup
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        n.f(sparseArray, "container");
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // com.google.android.material.chip.ChipGroup
    public final int getLastSelectedId() {
        int i = 0;
        Object item = null;
        boolean z;
        String lastSelectedTag2;
        Iterator it = x.b(this).iterator();
        while (it.hasNext()) {
            if (n.b((View)item.getTag(), this.lastSelectedTag)) {
                break;
            }
        }
        int i2 = 0;
        if (item == null) {
            i = 0;
        } else {
            i = item.getId();
        }
        return i;
    }

    @Override // com.google.android.material.chip.ChipGroup
    protected void onRestoreInstanceState(Parcelable state) {
        Parcelable parcelable;
        z = state instanceof Bundle;
        if (state instanceof Bundle) {
            String string = state.getString("SELECTED_KEY", "");
            str = "newState.getString(SPARSE_SELECTED_KEY, \"\")";
            n.e(string, str);
            this.lastSelectedTag = string;
            parcelable = state.getParcelable("SUPER_STATE_KEY");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // com.google.android.material.chip.ChipGroup
    protected Parcelable onSaveInstanceState() {
        int i;
        Object tag = null;
        int i2;
        int checkedChipId;
        final Bundle bundle = new Bundle();
        item = "SUPER_STATE_KEY";
        bundle.putParcelable(item, super.onSaveInstanceState());
        Iterator it = x.b(this).iterator();
        while (it.hasNext()) {
            int r4 = (View)item.getId() == getCheckedChipId() ? 1 : 0;
            if (i2 != 0) {
                break;
            }
        }
        if (i != 0) {
            tag = i.getTag();
        }
        bundle.putString("SELECTED_KEY", String.valueOf(tag));
        return bundle;
    }

    @Override // com.google.android.material.chip.ChipGroup
    /* renamed from: y, reason: from kotlin metadata */
    public final void saveLastSelectedTag() {
        int i;
        Object tag = null;
        int i2;
        int checkedChipId;
        Iterator it = x.b(this).iterator();
        while (it.hasNext()) {
            int r3 = (View)item.getId() == getCheckedChipId() ? 1 : 0;
            if (i2 != 0) {
                break;
            }
        }
        if (i != 0) {
            tag = i.getTag();
        }
        this.lastSelectedTag = String.valueOf(tag);
    }

    @Override // com.google.android.material.chip.ChipGroup
    /* renamed from: z, reason: from kotlin metadata */
    public final void hasGroupTagsChanged(List<? extends View> list) {
        Object tag = null;
        n.f(list, "items");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            z = (View)it.next().getTag() instanceof String;
            String r2 = it.next().getTag() instanceof String ? (String)it.next().getTag() : 0;
            arrayList.add(tag);
        }
        if (dispatchRestoreInstanceState(arrayList)) {
            dispatchSaveInstanceState(list);
        }
    }

}
