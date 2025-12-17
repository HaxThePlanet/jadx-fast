package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J-\u0010\u0008\u001a\u00020\t*\u00020\t2\u001f\u0010\n\u001a\u001b\u0012\u0004\u0012\u00020\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000f", d2 = {"Landroidx/compose/material3/TooltipScopeImpl;", "Landroidx/compose/material3/TooltipScope;", "getAnchorBounds", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function0;)V", "getGetAnchorBounds", "()Lkotlin/jvm/functions/Function0;", "drawCaret", "Landroidx/compose/ui/Modifier;", "draw", "Lkotlin/Function2;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TooltipScopeImpl implements androidx.compose.material3.TooltipScope {

    public static final int $stable;
    private final Function0<LayoutCoordinates> getAnchorBounds;
    static {
    }

    public TooltipScopeImpl(Function0<? extends LayoutCoordinates> getAnchorBounds) {
        super();
        this.getAnchorBounds = getAnchorBounds;
    }

    public Modifier drawCaret(Modifier $this$drawCaret, Function2<? super CacheDrawScope, ? super LayoutCoordinates, DrawResult> draw) {
        TooltipScopeImpl.drawCaret.1 anon = new TooltipScopeImpl.drawCaret.1(draw, this);
        return DrawModifierKt.drawWithCache($this$drawCaret, (Function1)anon);
    }

    public final Function0<LayoutCoordinates> getGetAnchorBounds() {
        return this.getAnchorBounds;
    }
}
