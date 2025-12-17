package androidx.compose.material3.carousel;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH'¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\tH'¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0008\u001a\u00020\tH'¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005\u0082\u0001\u0001\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0013À\u0006\u0001", d2 = {"Landroidx/compose/material3/carousel/CarouselItemScope;", "", "carouselItemInfo", "Landroidx/compose/material3/carousel/CarouselItemInfo;", "getCarouselItemInfo", "()Landroidx/compose/material3/carousel/CarouselItemInfo;", "rememberMaskShape", "Landroidx/compose/foundation/shape/GenericShape;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/GenericShape;", "maskBorder", "Landroidx/compose/ui/Modifier;", "border", "Landroidx/compose/foundation/BorderStroke;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "maskClip", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "Landroidx/compose/material3/carousel/CarouselItemScopeImpl;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CarouselItemScope {
    public abstract androidx.compose.material3.carousel.CarouselItemInfo getCarouselItemInfo();

    public abstract Modifier maskBorder(Modifier modifier, BorderStroke borderStroke2, Shape shape3, Composer composer4, int i5);

    public abstract Modifier maskClip(Modifier modifier, Shape shape2, Composer composer3, int i4);

    public abstract GenericShape rememberMaskShape(Shape shape, Composer composer2, int i3);
}
