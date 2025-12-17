package androidx.compose.ui.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0003", d2 = {"Landroidx/compose/ui/layout/GraphicLayerInfo;", "", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GraphicLayerInfo {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static long getOwnerViewId(androidx.compose.ui.layout.GraphicLayerInfo $this) {
            return GraphicLayerInfo.access$getOwnerViewId$jd($this);
        }
    }
    public static long access$getOwnerViewId$jd(androidx.compose.ui.layout.GraphicLayerInfo $this) {
        return super.getOwnerViewId();
    }

    public abstract long getLayerId();

    public long getOwnerViewId() {
        return 0;
    }
}
