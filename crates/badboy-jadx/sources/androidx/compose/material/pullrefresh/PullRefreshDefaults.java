package androidx.compose.material.pullrefresh;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\n", d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshDefaults;", "", "()V", "RefreshThreshold", "Landroidx/compose/ui/unit/Dp;", "getRefreshThreshold-D9Ej5fM", "()F", "F", "RefreshingOffset", "getRefreshingOffset-D9Ej5fM", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PullRefreshDefaults {

    public static final int $stable;
    public static final androidx.compose.material.pullrefresh.PullRefreshDefaults INSTANCE;
    private static final float RefreshThreshold;
    private static final float RefreshingOffset;
    static {
        PullRefreshDefaults pullRefreshDefaults = new PullRefreshDefaults();
        PullRefreshDefaults.INSTANCE = pullRefreshDefaults;
        int i3 = 0;
        PullRefreshDefaults.RefreshThreshold = Dp.constructor-impl((float)i);
        int i4 = 0;
        PullRefreshDefaults.RefreshingOffset = Dp.constructor-impl((float)i2);
    }

    public final float getRefreshThreshold-D9Ej5fM() {
        return PullRefreshDefaults.RefreshThreshold;
    }

    public final float getRefreshingOffset-D9Ej5fM() {
        return PullRefreshDefaults.RefreshingOffset;
    }
}
