package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006\u001a#\u0010\u0007\u001a\u00020\u0008*\u00020\u00082\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\u0008\u0006\u001a#\u0010\u000c\u001a\u00020\u0008*\u00020\u00082\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006\u001a#\u0010\r\u001a\u00020\u0008*\u00020\u00082\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\u0002\u0008\u0006¨\u0006\u000f", d2 = {"CacheDrawModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "onBuildDrawCache", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "drawBehind", "Landroidx/compose/ui/Modifier;", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "drawWithCache", "drawWithContent", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawModifierKt {
    public static final androidx.compose.ui.draw.CacheDrawModifierNode CacheDrawModifierNode(Function1<? super androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.draw.DrawResult> onBuildDrawCache) {
        CacheDrawScope cacheDrawScope = new CacheDrawScope();
        CacheDrawModifierNodeImpl cacheDrawModifierNodeImpl = new CacheDrawModifierNodeImpl(cacheDrawScope, onBuildDrawCache);
        return (CacheDrawModifierNode)cacheDrawModifierNodeImpl;
    }

    public static final Modifier drawBehind(Modifier $this$drawBehind, Function1<? super DrawScope, Unit> onDraw) {
        DrawBehindElement drawBehindElement = new DrawBehindElement(onDraw);
        return $this$drawBehind.then((Modifier)drawBehindElement);
    }

    public static final Modifier drawWithCache(Modifier $this$drawWithCache, Function1<? super androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.draw.DrawResult> onBuildDrawCache) {
        DrawWithCacheElement drawWithCacheElement = new DrawWithCacheElement(onBuildDrawCache);
        return $this$drawWithCache.then((Modifier)drawWithCacheElement);
    }

    public static final Modifier drawWithContent(Modifier $this$drawWithContent, Function1<? super ContentDrawScope, Unit> onDraw) {
        DrawWithContentElement drawWithContentElement = new DrawWithContentElement(onDraw);
        return $this$drawWithContent.then((Modifier)drawWithContentElement);
    }
}
