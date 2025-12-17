package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0008\u001aN\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0003\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015\u001aN\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0003\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u009f\u0001\u0010\u001a\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042,\u0010\u001b\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008( \u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\u0008!2,\u0010\"\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110#¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\u0008!2,\u0010%\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008\u001e\u0012\u0008\u0008\u001f\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\u0008!H\u0082\u0008\u001a\u000c\u0010'\u001a\u00020(*\u00020#H\u0002\u001a\u0011\u0010)\u001a\u00020**\u00020\u001dH\u0002¢\u0006\u0002\u0010+\u001a\u0011\u0010)\u001a\u00020**\u00020#H\u0002¢\u0006\u0002\u0010,\u001a\u0011\u0010-\u001a\u00020.*\u00020\u001dH\u0002¢\u0006\u0002\u0010+\u001a\u0011\u0010-\u001a\u00020.*\u00020#H\u0002¢\u0006\u0002\u0010,\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006/", d2 = {"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "Landroidx/compose/ui/geometry/RoundRect;", "rrect", "drawPathBlock", "path", "hasSameCornerRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/geometry/Rect;)J", "(Landroidx/compose/ui/geometry/RoundRect;)J", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class OutlineKt {
    public static final void addOutline(androidx.compose.ui.graphics.Path $this$addOutline, androidx.compose.ui.graphics.Outline outline) {
        Object roundRect;
        androidx.compose.ui.graphics.Path path2;
        int path;
        int i;
        int i2;
        int i3;
        int i4 = 2;
        path = 0;
        if (outline instanceof Outline.Rectangle) {
            Path.addRect$default($this$addOutline, (Outline.Rectangle)outline.getRect(), path, i4, path);
            path2 = $this$addOutline;
        } else {
            if (outline instanceof Outline.Rounded) {
                Path.addRoundRect$default($this$addOutline, (Outline.Rounded)outline.getRoundRect(), path, i4, path);
                path2 = $this$addOutline;
            } else {
                if (!outline instanceof Outline.Generic) {
                } else {
                    Path.addPath-Uv8p0NA$default($this$addOutline, (Outline.Generic)outline.getPath(), 0, obj4, 2);
                }
            }
        }
        androidx.compose.ui.graphics.Path $this$addOutline2 = $this$addOutline;
        NoWhenBranchMatchedException obj7 = new NoWhenBranchMatchedException();
        throw obj7;
    }

    public static final void drawOutline(androidx.compose.ui.graphics.Canvas $this$drawOutline, androidx.compose.ui.graphics.Outline outline, androidx.compose.ui.graphics.Paint paint) {
        androidx.compose.ui.graphics.Path roundRectPath$ui_graphics_release;
        long bottomLeftCornerRadius-kKHJgLs;
        androidx.compose.ui.graphics.Path $this$drawOutline2;
        float left;
        float top;
        float right;
        float bottom;
        float x-impl;
        float y-impl;
        androidx.compose.ui.graphics.Paint paint2;
        androidx.compose.ui.graphics.Path obj10;
        if (outline instanceof Outline.Rectangle) {
            $this$drawOutline.drawRect((Outline.Rectangle)outline.getRect(), paint);
            $this$drawOutline2 = $this$drawOutline;
            paint2 = paint;
        } else {
            if (outline instanceof Outline.Rounded) {
                roundRectPath$ui_graphics_release = (Outline.Rounded)outline.getRoundRectPath$ui_graphics_release();
                if (roundRectPath$ui_graphics_release != null) {
                    $this$drawOutline.drawPath(roundRectPath$ui_graphics_release, paint);
                    $this$drawOutline2 = $this$drawOutline;
                    paint2 = paint;
                } else {
                    $this$drawOutline.drawRoundRect((Outline.Rounded)outline.getRoundRect().getLeft(), (Outline.Rounded)outline.getRoundRect().getTop(), (Outline.Rounded)outline.getRoundRect().getRight(), (Outline.Rounded)outline.getRoundRect().getBottom(), CornerRadius.getX-impl((Outline.Rounded)outline.getRoundRect().getBottomLeftCornerRadius-kKHJgLs()), CornerRadius.getY-impl((Outline.Rounded)outline.getRoundRect().getBottomLeftCornerRadius-kKHJgLs()), paint);
                }
            } else {
                if (!outline instanceof Outline.Generic) {
                } else {
                    $this$drawOutline.drawPath((Outline.Generic)outline.getPath(), paint);
                }
            }
        }
        obj10 = new NoWhenBranchMatchedException();
        throw obj10;
    }

    public static final void drawOutline-hn5TExg(DrawScope $this$drawOutline_u2dhn5TExg, androidx.compose.ui.graphics.Outline outline, androidx.compose.ui.graphics.Brush brush, float alpha, DrawStyle style, androidx.compose.ui.graphics.ColorFilter colorFilter, int blendMode) {
        androidx.compose.ui.graphics.Path roundRectPath$ui_graphics_release;
        RoundRect roundRect;
        int i2;
        float topLeft;
        int i9;
        int size;
        int i7;
        androidx.compose.ui.graphics.ColorFilter colorFilter5;
        int i5;
        androidx.compose.ui.graphics.ColorFilter colorFilter4;
        int i3;
        int i6;
        RoundRect roundRect2;
        Object path;
        long topLeft2;
        long f;
        long size2;
        float colorFilter2;
        long l;
        int i;
        int i8;
        androidx.compose.ui.graphics.ColorFilter colorFilter3;
        int i4;
        final Object obj = outline;
        final RoundRect roundRect3 = $this$drawOutline_u2dhn5TExg;
        final int i10 = 0;
        if (obj instanceof Outline.Rectangle) {
            roundRectPath$ui_graphics_release = (Outline.Rectangle)obj.getRect();
            i6 = 0;
            roundRect3.drawRect-AsUm42w(brush, OutlineKt.topLeft(roundRectPath$ui_graphics_release), obj7, OutlineKt.size(roundRectPath$ui_graphics_release), obj9, alpha, style);
        } else {
            if (obj instanceof Outline.Rounded) {
                roundRectPath$ui_graphics_release = (Outline.Rounded)obj.getRoundRectPath$ui_graphics_release();
                if (roundRectPath$ui_graphics_release != null) {
                    roundRect = 0;
                    roundRect3.drawPath-GBMwjPU(roundRectPath$ui_graphics_release, brush, alpha, style, colorFilter, blendMode);
                } else {
                    roundRect = (Outline.Rounded)obj.getRoundRect();
                    i2 = 0;
                    roundRect3.drawRoundRect-ZuiqVtQ(brush, OutlineKt.topLeft(roundRect), obj18, OutlineKt.size(roundRect), obj20, CornerRadiusKt.CornerRadius$default(CornerRadius.getX-impl(roundRect.getBottomLeftCornerRadius-kKHJgLs()), 0, 2, 0), obj22, alpha);
                }
            } else {
                if (!obj instanceof Outline.Generic) {
                } else {
                    roundRectPath$ui_graphics_release = 0;
                    roundRect3.drawPath-GBMwjPU((Outline.Generic)obj.getPath(), brush, alpha, style, colorFilter, blendMode);
                }
            }
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    public static void drawOutline-hn5TExg$default(DrawScope drawScope, androidx.compose.ui.graphics.Outline outline2, androidx.compose.ui.graphics.Brush brush3, float f4, DrawStyle drawStyle5, androidx.compose.ui.graphics.ColorFilter colorFilter6, int i7, int i8, Object object9) {
        int i;
        Fill fill;
        int i2;
        int i3;
        int obj10;
        Fill obj11;
        int obj12;
        int obj13;
        i = i8 & 4 != 0 ? obj10 : f4;
        if (i8 & 8 != 0) {
            fill = obj11;
        } else {
            fill = drawStyle5;
        }
        i2 = i8 & 16 != 0 ? obj12 : colorFilter6;
        if (i8 & 32 != 0) {
            i3 = obj13;
        } else {
            i3 = i7;
        }
        OutlineKt.drawOutline-hn5TExg(drawScope, outline2, brush3, i, fill, i2, i3);
    }

    public static final void drawOutline-wDX37Ww(DrawScope $this$drawOutline_u2dwDX37Ww, androidx.compose.ui.graphics.Outline outline, long color, float alpha, DrawStyle style, androidx.compose.ui.graphics.ColorFilter colorFilter, int blendMode) {
        androidx.compose.ui.graphics.Path roundRectPath$ui_graphics_release;
        RoundRect roundRect;
        int i2;
        float x-impl;
        int topLeft;
        int i3;
        int size2;
        int i4;
        androidx.compose.ui.graphics.ColorFilter colorFilter2;
        int i;
        long l3;
        int i6;
        RoundRect roundRect2;
        long path;
        long l2;
        long topLeft2;
        long drawStyle;
        long size;
        float i7;
        long l4;
        androidx.compose.ui.graphics.ColorFilter colorFilter3;
        int i8;
        int i5;
        long l;
        final Object obj = outline;
        final RoundRect roundRect3 = $this$drawOutline_u2dwDX37Ww;
        final int i9 = 0;
        if (obj instanceof Outline.Rectangle) {
            roundRectPath$ui_graphics_release = (Outline.Rectangle)obj.getRect();
            i6 = 0;
            roundRect3.drawRect-n-J9OG0(color, obj6, OutlineKt.topLeft(roundRectPath$ui_graphics_release), obj8, OutlineKt.size(roundRectPath$ui_graphics_release), obj10, style);
        } else {
            if (obj instanceof Outline.Rounded) {
                roundRectPath$ui_graphics_release = (Outline.Rounded)obj.getRoundRectPath$ui_graphics_release();
                if (roundRectPath$ui_graphics_release != null) {
                    roundRect = 0;
                    roundRect3.drawPath-LG529CI(roundRectPath$ui_graphics_release, color, obj19, style, colorFilter, blendMode);
                } else {
                    roundRect = (Outline.Rounded)obj.getRoundRect();
                    i2 = 0;
                    roundRect3.drawRoundRect-u-Aw5IA(color, obj18, OutlineKt.topLeft(roundRect), obj20, OutlineKt.size(roundRect), obj22, CornerRadiusKt.CornerRadius$default(CornerRadius.getX-impl(roundRect.getBottomLeftCornerRadius-kKHJgLs()), 0, 2, 0), obj24);
                }
            } else {
                if (!obj instanceof Outline.Generic) {
                } else {
                    roundRectPath$ui_graphics_release = 0;
                    roundRect3.drawPath-LG529CI((Outline.Generic)obj.getPath(), color, obj19, style, colorFilter, blendMode);
                }
            }
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    public static void drawOutline-wDX37Ww$default(DrawScope drawScope, androidx.compose.ui.graphics.Outline outline2, long l3, float f4, DrawStyle drawStyle5, androidx.compose.ui.graphics.ColorFilter colorFilter6, int i7, int i8, Object object9) {
        int i;
        Fill fill;
        int i2;
        int i3;
        int obj12;
        Fill obj13;
        int obj14;
        i = object9 & 4 != 0 ? obj12 : drawStyle5;
        if (object9 & 8 != 0) {
            fill = obj13;
        } else {
            fill = colorFilter6;
        }
        i2 = object9 & 16 != 0 ? obj14 : i7;
        if (object9 & 32 != 0) {
            i3 = obj12;
        } else {
            i3 = i8;
        }
        OutlineKt.drawOutline-wDX37Ww(drawScope, outline2, l3, obj3, i, fill, i2);
    }

    private static final void drawOutlineHelper(DrawScope $this$drawOutlineHelper, androidx.compose.ui.graphics.Outline outline, Function2<? super DrawScope, ? super Rect, Unit> drawRectBlock, Function2<? super DrawScope, ? super RoundRect, Unit> drawRoundedRectBlock, Function2<? super DrawScope, ? super androidx.compose.ui.graphics.Path, Unit> drawPathBlock) {
        Object roundRectPath$ui_graphics_release;
        RoundRect roundRect;
        final int i = 0;
        if (outline instanceof Outline.Rectangle) {
            drawRectBlock.invoke($this$drawOutlineHelper, (Outline.Rectangle)outline.getRect());
        } else {
            if (outline instanceof Outline.Rounded) {
                roundRectPath$ui_graphics_release = (Outline.Rounded)outline.getRoundRectPath$ui_graphics_release();
                if (roundRectPath$ui_graphics_release != null) {
                    drawPathBlock.invoke($this$drawOutlineHelper, roundRectPath$ui_graphics_release);
                } else {
                    drawRoundedRectBlock.invoke($this$drawOutlineHelper, (Outline.Rounded)outline.getRoundRect());
                }
            } else {
                if (!outline instanceof Outline.Generic) {
                } else {
                    drawPathBlock.invoke($this$drawOutlineHelper, (Outline.Generic)outline.getPath());
                }
            }
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    private static final boolean hasSameCornerRadius(RoundRect $this$hasSameCornerRadius) {
        int i3;
        int i;
        int i2;
        float x-impl;
        int i5;
        int i4;
        float y-impl;
        i2 = 1;
        final int i6 = 0;
        i3 = Float.compare(x-impl2, x-impl5) == 0 ? i2 : i6;
        if (i3 != 0) {
            i3 = Float.compare(x-impl3, x-impl) == 0 ? i2 : i6;
            if (i3 != 0) {
                i3 = Float.compare(x-impl4, x-impl) == 0 ? i2 : i6;
                i = i3 != 0 ? i2 : i6;
            } else {
            }
        } else {
        }
        y-impl = CornerRadius.getY-impl($this$hasSameCornerRadius.getBottomRightCornerRadius-kKHJgLs());
        i5 = Float.compare(y-impl2, y-impl) == 0 ? i2 : i6;
        if (i5 != 0) {
            y-impl = CornerRadius.getY-impl($this$hasSameCornerRadius.getTopRightCornerRadius-kKHJgLs());
            i5 = Float.compare(y-impl3, y-impl) == 0 ? i2 : i6;
            if (i5 != 0) {
                i5 = Float.compare(y-impl4, y-impl) == 0 ? i2 : i6;
                i4 = i5 != 0 ? i2 : i6;
            } else {
            }
        } else {
        }
        if (i != 0 && i4 != 0) {
            if (i4 != 0) {
            } else {
                i2 = i6;
            }
        } else {
        }
        return i2;
    }

    private static final long size(Rect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final long size(RoundRect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final long topLeft(Rect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final long topLeft(RoundRect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }
}
