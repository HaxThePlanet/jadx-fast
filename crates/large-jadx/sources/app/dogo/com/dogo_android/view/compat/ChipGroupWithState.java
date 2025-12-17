package app.dogo.com.dogo_android.view.compat;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.p;
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
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u000f\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008B!\u0008\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0016\u0010\u0013\u001a\u00020\u000f2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0006\u0010\u0014\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00162\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u000f2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0014J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0012H\u0014J\u0016\u0010\u001c\u001a\u00020\u000f2\u000c\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0018H\u0002J\u0006\u0010\u001f\u001a\u00020\u000fJ\u0014\u0010 \u001a\u00020\u000f2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0018R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/view/compat/ChipGroupWithState;", "Lcom/google/android/material/chip/ChipGroup;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastSelectedTag", "", "dispatchRestoreInstanceState", "", "container", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "getLastSelectedId", "hasGroupTagsChanged", "", "list", "", "onRestoreInstanceState", "state", "onSaveInstanceState", "refreshGroupViews", "newData", "Landroid/view/View;", "saveLastSelectedTag", "updateViewSet", "items", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChipGroupWithState extends ChipGroup implements p {

    public static final app.dogo.com.dogo_android.view.compat.ChipGroupWithState.a Companion;
    private String G;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/view/compat/ChipGroupWithState$Companion;", "", "()V", "SPARSE_SELECTED_KEY", "", "SUPER_STATE_KEY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }
    static {
        ChipGroupWithState.a aVar = new ChipGroupWithState.a(0);
        ChipGroupWithState.Companion = aVar;
    }

    public ChipGroupWithState(Context context, AttributeSet attributeSet2) {
        n.f(context, "context");
        super(context, attributeSet2);
        this.G = "";
    }

    private final boolean w(List<String> list) {
        int i2;
        int next;
        int i3;
        int i;
        boolean iterator;
        boolean next2;
        Object tag;
        Iterator iterator2 = x.b(this).iterator();
        i3 = 0;
        i = 1;
        while (iterator2.hasNext()) {
            if (list instanceof Collection != null && list.isEmpty()) {
            } else {
            }
            iterator = list.iterator();
            for (String next4 : iterator) {
            }
            next = i;
            i3 = 0;
            i = 1;
            if (n.b(next3.getTag(), (String)iterator.next())) {
            } else {
            }
            next = i3;
            if (list.isEmpty()) {
            } else {
            }
        }
        i2 = i3;
        if (getChildCount() == list.size()) {
            if (i2 != 0) {
                i3 = i;
            }
        } else {
        }
        return i3;
    }

    private final void x(List<? extends View> list) {
        Object next;
        removeAllViews();
        final Iterator obj2 = list.iterator();
        for (View next : obj2) {
            addView(next);
        }
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        n.f(sparseArray, "container");
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        n.f(sparseArray, "container");
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // com.google.android.material.chip.ChipGroup
    public final int getLastSelectedId() {
        int i;
        Object next;
        boolean z;
        String str;
        Iterator iterator = x.b(this).iterator();
        for (Object next : iterator) {
        }
        next = 0;
        if ((View)next == null) {
            i = 0;
        } else {
            i = (View)next.getId();
        }
        return i;
    }

    @Override // com.google.android.material.chip.ChipGroup
    protected void onRestoreInstanceState(Parcelable parcelable) {
        boolean str2;
        String str;
        Object obj3;
        if (parcelable instanceof Bundle != null) {
            String string = (Bundle)parcelable.getString("SELECTED_KEY", "");
            n.e(string, "newState.getString(SPARSE_SELECTED_KEY, \"\")");
            this.G = string;
            obj3 = parcelable.getParcelable("SUPER_STATE_KEY");
        }
        super.onRestoreInstanceState(obj3);
    }

    @Override // com.google.android.material.chip.ChipGroup
    protected Parcelable onSaveInstanceState() {
        String next;
        int tag;
        int i;
        int checkedChipId;
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE_KEY", super.onSaveInstanceState());
        Iterator iterator = x.b(this).iterator();
        while (iterator.hasNext()) {
            if ((View)iterator.next().getId() == getCheckedChipId()) {
            } else {
            }
            i = 0;
            i = 1;
        }
        next = tag;
        if ((View)next == 0) {
        } else {
            tag = (View)next.getTag();
        }
        bundle.putString("SELECTED_KEY", String.valueOf(tag));
        return bundle;
    }

    @Override // com.google.android.material.chip.ChipGroup
    public final void y() {
        Object next;
        int tag;
        int i;
        int checkedChipId;
        Iterator iterator = x.b(this).iterator();
        while (iterator.hasNext()) {
            if ((View)iterator.next().getId() == getCheckedChipId()) {
            } else {
            }
            i = 0;
            i = 1;
        }
        next = tag;
        if ((View)next == 0) {
        } else {
            tag = (View)next.getTag();
        }
        this.G = String.valueOf(tag);
    }

    public final void z(List<? extends View> list) {
        Object tag;
        boolean z;
        n.f(list, "items");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (tag instanceof String != null) {
            } else {
            }
            tag = 0;
            if (tag == null) {
            }
            arrayList.add(tag);
            tag = "";
        }
        if (w(arrayList)) {
            x(list);
        }
    }
}
