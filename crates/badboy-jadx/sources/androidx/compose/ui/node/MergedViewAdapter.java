package androidx.compose.ui.node;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0012\u001a\u0002H\u0013\"\u0008\u0008\u0000\u0010\u0013*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00082\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u0015H\u0086\u0008¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0018", d2 = {"Landroidx/compose/ui/node/MergedViewAdapter;", "Landroidx/compose/ui/node/ViewAdapter;", "()V", "adapters", "", "getAdapters", "()Ljava/util/List;", "id", "", "getId", "()I", "didInsert", "", "view", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "didUpdate", "get", "T", "factory", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "willInsert", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MergedViewAdapter implements androidx.compose.ui.node.ViewAdapter {

    public static final int $stable = 8;
    private final List<androidx.compose.ui.node.ViewAdapter> adapters;
    private final int id;
    static {
        final int i = 8;
    }

    public MergedViewAdapter() {
        super();
        ArrayList arrayList = new ArrayList();
        this.adapters = (List)arrayList;
    }

    @Override // androidx.compose.ui.node.ViewAdapter
    public void didInsert(View view, ViewGroup parent) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        final List adapters = this.adapters;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < adapters.size()) {
            i = 0;
            (ViewAdapter)adapters.get(index$iv).didInsert(view, parent);
            index$iv++;
        }
    }

    @Override // androidx.compose.ui.node.ViewAdapter
    public void didUpdate(View view, ViewGroup parent) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        final List adapters = this.adapters;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < adapters.size()) {
            i = 0;
            (ViewAdapter)adapters.get(index$iv).didUpdate(view, parent);
            index$iv++;
        }
    }

    public final <T extends androidx.compose.ui.node.ViewAdapter> T get(int id, Function0<? extends T> factory) {
        int index$iv$iv;
        int i;
        Object obj;
        Object obj3;
        int i2;
        Object obj2;
        int i4;
        int i3;
        int i5;
        final int i6 = 0;
        int i7 = 0;
        final List list = adapters;
        final int i8 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < list.size()) {
            i2 = 0;
            i4 = 0;
            if ((ViewAdapter)list.get(index$iv$iv).getId() == id) {
            } else {
            }
            i3 = 0;
            index$iv$iv++;
            i3 = 1;
        }
        i5 = id;
        obj3 = i;
        if (obj3 instanceof ViewAdapter != null) {
            i = obj3;
        }
        if (i != 0) {
            return i;
        }
        Object invoke = factory.invoke();
        getAdapters().add((ViewAdapter)invoke);
        return invoke;
    }

    public final List<androidx.compose.ui.node.ViewAdapter> getAdapters() {
        return this.adapters;
    }

    @Override // androidx.compose.ui.node.ViewAdapter
    public int getId() {
        return this.id;
    }

    @Override // androidx.compose.ui.node.ViewAdapter
    public void willInsert(View view, ViewGroup parent) {
        int index$iv;
        Object obj;
        Object obj2;
        int i;
        final List adapters = this.adapters;
        final int i2 = 0;
        index$iv = 0;
        while (index$iv < adapters.size()) {
            i = 0;
            (ViewAdapter)adapters.get(index$iv).willInsert(view, parent);
            index$iv++;
        }
    }
}
