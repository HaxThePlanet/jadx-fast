package androidx.compose.ui.node;

import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a1\u0010\u0005\u001a\u0002H\u0006\"\u0008\u0008\u0000\u0010\u0006*\u00020\u0007*\u00020\u00082\u0006\u0010\t\u001a\u00020\u00012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u000bH\u0007¢\u0006\u0002\u0010\u000c\u001a\u000c\u0010\r\u001a\u00020\u000e*\u00020\u0008H\u0000\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u0008H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"viewAdaptersKey", "", "tagKey", "key", "", "getOrAddAdapter", "T", "Landroidx/compose/ui/node/ViewAdapter;", "Landroid/view/View;", "id", "factory", "Lkotlin/Function0;", "(Landroid/view/View;ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "getViewAdapter", "Landroidx/compose/ui/node/MergedViewAdapter;", "getViewAdapterIfExists", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewInterop_androidKt {

    private static final int viewAdaptersKey;
    static {
        ViewInterop_androidKt.viewAdaptersKey = ViewInterop_androidKt.tagKey("ViewAdapter");
    }

    public static final <T extends androidx.compose.ui.node.ViewAdapter> T getOrAddAdapter(View $this$getOrAddAdapter, int id, Function0<? extends T> factory) {
        boolean $this$fastFirstOrNull$iv$iv;
        int adapters;
        int index$iv$iv$iv;
        int existing$iv;
        Object obj;
        Object obj3;
        int i2;
        Object obj2;
        int i3;
        int i4;
        int i;
        final androidx.compose.ui.node.MergedViewAdapter viewAdapter = ViewInterop_androidKt.getViewAdapter($this$getOrAddAdapter);
        final int i5 = 0;
        adapters = 0;
        final List list = adapters2;
        final int i6 = 0;
        index$iv$iv$iv = 0;
        while (index$iv$iv$iv < list.size()) {
            i2 = 0;
            i3 = 0;
            if ((ViewAdapter)list.get(index$iv$iv$iv).getId() == id) {
            } else {
            }
            i4 = 0;
            index$iv$iv$iv++;
            i4 = 1;
        }
        i = id;
        obj3 = existing$iv;
        if (obj3 instanceof ViewAdapter != null) {
            existing$iv = obj3;
        }
        if (existing$iv == 0) {
            $this$fastFirstOrNull$iv$iv = factory.invoke();
            viewAdapter.getAdapters().add((ViewAdapter)$this$fastFirstOrNull$iv$iv);
            existing$iv = $this$fastFirstOrNull$iv$iv;
        }
        return existing$iv;
    }

    public static final androidx.compose.ui.node.MergedViewAdapter getViewAdapter(View $this$getViewAdapter) {
        Object adapter;
        boolean viewAdaptersKey;
        if (adapter instanceof MergedViewAdapter != null) {
        } else {
            adapter = 0;
        }
        if (adapter == null) {
            MergedViewAdapter mergedViewAdapter = new MergedViewAdapter();
            $this$getViewAdapter.setTag(ViewInterop_androidKt.viewAdaptersKey, mergedViewAdapter);
        }
        return adapter;
    }

    public static final androidx.compose.ui.node.MergedViewAdapter getViewAdapterIfExists(View $this$getViewAdapterIfExists) {
        Object tag;
        if (tag instanceof MergedViewAdapter != null) {
        } else {
            tag = 0;
        }
        return tag;
    }

    public static final int tagKey(String key) {
        return i |= i3;
    }
}
