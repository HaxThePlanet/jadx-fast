package androidx.lifecycle;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\"\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0013\u0010\u000c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0087\u0002J\u000e\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u000eH\u0007J\u0006\u0010\u000f\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Landroidx/lifecycle/ViewModelStore;", "", "<init>", "()V", "map", "", "", "Landroidx/lifecycle/ViewModel;", "put", "", "key", "viewModel", "get", "keys", "", "clear", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ViewModelStore {

    private final Map<String, androidx.lifecycle.ViewModel> map;
    public ViewModelStore() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.map = (Map)linkedHashMap;
    }

    public final void clear() {
        Object next;
        Iterator iterator = this.map.values().iterator();
        for (ViewModel next : iterator) {
            next.clear$lifecycle_viewmodel_release();
        }
        this.map.clear();
    }

    public final androidx.lifecycle.ViewModel get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (ViewModel)this.map.get(key);
    }

    public final Set<String> keys() {
        HashSet hashSet = new HashSet((Collection)this.map.keySet());
        return (Set)hashSet;
    }

    public final void put(String key, androidx.lifecycle.ViewModel viewModel) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Object obj = this.map.put(key, viewModel);
        if ((ViewModel)obj != null) {
            (ViewModel)obj.clear$lifecycle_viewmodel_release();
        }
    }
}
