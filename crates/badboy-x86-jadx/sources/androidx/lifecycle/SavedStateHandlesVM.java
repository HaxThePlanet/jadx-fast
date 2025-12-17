package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Landroidx/lifecycle/SavedStateHandlesVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "handles", "", "", "Landroidx/lifecycle/SavedStateHandle;", "getHandles", "()Ljava/util/Map;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandlesVM extends androidx.lifecycle.ViewModel {

    private final Map<String, androidx.lifecycle.SavedStateHandle> handles;
    public SavedStateHandlesVM() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.handles = (Map)linkedHashMap;
    }

    public final Map<String, androidx.lifecycle.SavedStateHandle> getHandles() {
        return this.handles;
    }
}
