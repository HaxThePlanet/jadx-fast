package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008g\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0001H'¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0008\u001a\u00020\u0003H\u0016J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0001H\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000eÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "", "itemCount", "", "getItemCount", "()I", "Item", "", "index", "key", "(ILjava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "getContentType", "getIndex", "getKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyLayoutItemProvider {
    public abstract void Item(int i, Object object2, Composer composer3, int i4);

    public Object getContentType(int index) {
        return null;
    }

    public int getIndex(Object key) {
        return -1;
    }

    public abstract int getItemCount();

    public Object getKey(int index) {
        return Lazy_androidKt.getDefaultLazyLayoutKey(index);
    }
}
