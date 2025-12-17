package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u000cX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0010", d2 = {"Landroidx/compose/ui/draw/EmptyBuildDrawCacheParams;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "()V", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EmptyBuildDrawCacheParams implements androidx.compose.ui.draw.BuildDrawCacheParams {

    public static final androidx.compose.ui.draw.EmptyBuildDrawCacheParams INSTANCE;
    private static final Density density;
    private static final LayoutDirection layoutDirection;
    private static final long size;
    static {
        EmptyBuildDrawCacheParams emptyBuildDrawCacheParams = new EmptyBuildDrawCacheParams();
        EmptyBuildDrawCacheParams.INSTANCE = emptyBuildDrawCacheParams;
        EmptyBuildDrawCacheParams.size = Size.Companion.getUnspecified-NH-jbRc();
        EmptyBuildDrawCacheParams.layoutDirection = LayoutDirection.Ltr;
        int i = 1065353216;
        EmptyBuildDrawCacheParams.density = DensityKt.Density(i, i);
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public Density getDensity() {
        return EmptyBuildDrawCacheParams.density;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public LayoutDirection getLayoutDirection() {
        return EmptyBuildDrawCacheParams.layoutDirection;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    public long getSize-NH-jbRc() {
        return EmptyBuildDrawCacheParams.size;
    }
}
