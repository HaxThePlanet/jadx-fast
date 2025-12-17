package androidx.compose.foundation.lazy;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008f\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0012\u0010\t\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0004R\u0012\u0010\u000b\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u0008R\u0012\u0010\r\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000fÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/LazyListItemInfo;", "", "contentType", "getContentType", "()Ljava/lang/Object;", "index", "", "getIndex", "()I", "key", "getKey", "offset", "getOffset", "size", "getSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LazyListItemInfo {
    public Object getContentType() {
        return null;
    }

    public abstract int getIndex();

    public abstract Object getKey();

    public abstract int getOffset();

    public abstract int getSize();
}
