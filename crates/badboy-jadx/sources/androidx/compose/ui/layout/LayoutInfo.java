package androidx.compose.ui.layout;

import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u000e\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020$0#H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0010R\u0012\u0010\u0012\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\rR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006%À\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/LayoutInfo;", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "height", "", "getHeight", "()I", "isAttached", "", "()Z", "isDeactivated", "isPlaced", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "semanticsId", "getSemanticsId", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "width", "getWidth", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface LayoutInfo {
    public abstract androidx.compose.ui.layout.LayoutCoordinates getCoordinates();

    public abstract Density getDensity();

    public abstract int getHeight();

    public abstract LayoutDirection getLayoutDirection();

    public abstract List<androidx.compose.ui.layout.ModifierInfo> getModifierInfo();

    public abstract androidx.compose.ui.layout.LayoutInfo getParentInfo();

    public abstract int getSemanticsId();

    public abstract ViewConfiguration getViewConfiguration();

    public abstract int getWidth();

    public abstract boolean isAttached();

    public boolean isDeactivated() {
        return 0;
    }

    public abstract boolean isPlaced();
}
