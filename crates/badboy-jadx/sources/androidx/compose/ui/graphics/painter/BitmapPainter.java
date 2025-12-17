package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.FilterQuality.Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u001c\u001a\u00020\u001b2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0014J\u0013\u0010\u001d\u001a\u00020\u001b2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\u0008\u0010 \u001a\u00020!H\u0016J\u0008\u0010\"\u001a\u00020#H\u0016J\"\u0010$\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&J\u000c\u0010'\u001a\u00020(*\u00020)H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u00020\u000eX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006*", d2 = {"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$ui_graphics_release", "()I", "setFilterQuality-vDHp3xo$ui_graphics_release", "(I)V", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "size", "J", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "validateSize", "validateSize-N5eqBDc", "(JJ)J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BitmapPainter extends androidx.compose.ui.graphics.painter.Painter {

    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;
    private BitmapPainter(ImageBitmap image, long srcOffset, long srcSize) {
        super();
        this.image = image;
        this.srcOffset = srcOffset;
        this.srcSize = obj8;
        this.filterQuality = FilterQuality.Companion.getLow-f-v9h1I();
        this.size = validateSize-N5eqBDc(this.srcOffset, obj1);
        this.alpha = 1065353216;
    }

    public BitmapPainter(ImageBitmap imageBitmap, long l2, long l3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        long l4;
        long l;
        long obj9;
        int obj10;
        long obj11;
        if (obj13 & 2 != 0) {
            l4 = obj9;
        } else {
            l4 = l2;
        }
        if (obj13 & 4 != 0) {
            l = obj11;
        } else {
            l = i4;
        }
        super(imageBitmap, l4, obj3, l, obj5, 0);
    }

    public BitmapPainter(ImageBitmap imageBitmap, long l2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(imageBitmap, l2, l3, defaultConstructorMarker4, obj5);
    }

    private final long validateSize-N5eqBDc(long srcOffset, long srcSize) {
        int height-impl;
        int i;
        int height;
        if (IntOffset.getX-impl(srcOffset) >= 0 && IntOffset.getY-impl(srcOffset) >= 0 && IntSize.getWidth-impl(obj5) >= 0 && IntSize.getHeight-impl(obj5) >= 0 && IntSize.getWidth-impl(obj5) <= this.image.getWidth() && IntSize.getHeight-impl(obj5) <= this.image.getHeight()) {
            if (IntOffset.getY-impl(srcOffset) >= 0) {
                if (IntSize.getWidth-impl(obj5) >= 0) {
                    if (IntSize.getHeight-impl(obj5) >= 0) {
                        if (IntSize.getWidth-impl(obj5) <= this.image.getWidth()) {
                            i = IntSize.getHeight-impl(obj5) <= this.image.getHeight() ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i == 0) {
        } else {
            return obj5;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        this.alpha = alpha;
        return 1;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return 1;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof BitmapPainter) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.image, obj3.image)) {
            return i2;
        }
        if (!IntOffset.equals-impl0(this.srcOffset, obj4)) {
            return i2;
        }
        if (!IntSize.equals-impl0(this.srcSize, obj4)) {
            return i2;
        }
        if (!FilterQuality.equals-impl0(this.filterQuality, obj4.filterQuality)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final int getFilterQuality-f-v9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long getIntrinsicSize-NH-jbRc() {
        return IntSizeKt.toSize-ozmzZPI(this.size);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public int hashCode() {
        return result2 += i8;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void onDraw(DrawScope $this$onDraw) {
        final Object obj = this;
        int i = 0;
        DrawScope.drawImage-AZ2fEMs$default($this$onDraw, obj.image, obj.srcOffset, obj4, obj.srcSize, obj6, 0, 0, IntSizeKt.IntSize(Math.round(Size.getWidth-impl($this$onDraw.getSize-NH-jbRc())), Math.round(Size.getHeight-impl($this$onDraw.getSize-NH-jbRc()))), obj10, obj.alpha, 0, obj.colorFilter);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void setFilterQuality-vDHp3xo$ui_graphics_release(int <set-?>) {
        this.filterQuality = <set-?>;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BitmapPainter(image=").append(this.image).append(", srcOffset=").append(IntOffset.toString-impl(this.srcOffset)).append(", srcSize=").append(IntSize.toString-impl(this.srcSize)).append(", filterQuality=").append(FilterQuality.toString-impl(this.filterQuality)).append(')').toString();
    }
}
