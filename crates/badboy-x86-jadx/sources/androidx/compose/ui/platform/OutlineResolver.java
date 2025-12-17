package androidx.compose.ui.platform;

import android.graphics.Outline;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Outline.Rectangle;
import androidx.compose.ui.graphics.Outline.Rounded;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\u00082\u0006\u0010+\u001a\u00020\u001dø\u0001\u0000¢\u0006\u0004\u0008,\u0010-J:\u0010.\u001a\u00020\u00082\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010/\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u00082\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\u00082\u00103J\u0008\u00104\u001a\u00020'H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u000eH\u0002J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020#H\u0002J0\u0010<\u001a\u00020\u0008*\u0004\u0018\u00010#2\u0006\u0010=\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u001e\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0008@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u000bR\u000e\u0010\u0017\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\u00020\u001aX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u001dX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006A", d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "()V", "androidOutline", "Landroid/graphics/Outline;", "getAndroidOutline", "()Landroid/graphics/Outline;", "<set-?>", "", "cacheIsDirty", "getCacheIsDirty$ui_release", "()Z", "cachedOutline", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "update", "alpha", "elevation", "size", "update-S_szKao", "(Landroidx/compose/ui/graphics/Outline;FZFJ)Z", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OutlineResolver {

    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private boolean isSupportedOutline = true;
    private Outline outline;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;
    static {
        final int i = 8;
    }

    public OutlineResolver() {
        super();
        int i = 1;
        Outline outline = new Outline();
        final int i2 = 0;
        outline.setAlpha(1065353216);
        this.cachedOutline = outline;
        this.rectTopLeft = Offset.Companion.getZero-F1C5BW0();
        this.rectSize = Size.Companion.getZero-NH-jbRc();
    }

    private final boolean isSameBounds-4L21HEs(RoundRect $this$isSameBounds_u2d4L21HEs, long offset, long size, float radius) {
        int i2;
        int i;
        boolean simple;
        long topLeftCornerRadius-kKHJgLs;
        float height-impl;
        i2 = 0;
        if ($this$isSameBounds_u2d4L21HEs != null) {
            if (!RoundRectKt.isSimple($this$isSameBounds_u2d4L21HEs)) {
            } else {
                int i3 = 1;
                i = Float.compare(left, x-impl2) == 0 ? i3 : i2;
                if (i != 0) {
                    i = Float.compare(top, topLeftCornerRadius-kKHJgLs) == 0 ? i3 : i2;
                    if (i != 0) {
                        i = Float.compare(right, topLeftCornerRadius-kKHJgLs) == 0 ? i3 : i2;
                        if (i != 0) {
                            height-impl = Size.getHeight-impl(radius);
                            i = Float.compare(bottom, topLeftCornerRadius-kKHJgLs) == 0 ? i3 : i2;
                            if (i != 0) {
                                i = Float.compare(x-impl, obj11) == 0 ? i3 : i2;
                                if (i != 0) {
                                    i2 = i3;
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
            }
            return i2;
        }
        return i2;
    }

    private final void updateCache() {
        int cmp;
        boolean cachedOutline;
        Outline outline;
        boolean outlineNeeded;
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.getZero-F1C5BW0();
            cmp = 0;
            this.roundedCornerRadius = cmp;
            this.outlinePath = 0;
            int i3 = 0;
            this.cacheIsDirty = i3;
            this.usePathForClip = i3;
            outline = this.outline;
            if (outline != null && this.outlineNeeded && Float.compare(width-impl, cmp) > 0 && Float.compare(outlineNeeded, cmp) > 0) {
                if (this.outlineNeeded) {
                    if (Float.compare(width-impl, cmp) > 0) {
                        if (Float.compare(outlineNeeded, cmp) > 0) {
                            this.isSupportedOutline = true;
                            if (outline instanceof Outline.Rectangle) {
                                updateCacheWithRect((Outline.Rectangle)outline.getRect());
                            } else {
                                if (outline instanceof Outline.Rounded) {
                                    updateCacheWithRoundRect((Outline.Rounded)outline.getRoundRect());
                                } else {
                                    if (outline instanceof Outline.Generic) {
                                        updateCacheWithPath((Outline.Generic)outline.getPath());
                                    }
                                }
                            }
                        } else {
                            this.cachedOutline.setEmpty();
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
    }

    private final void updateCacheWithPath(Path composePath) {
        final Object obj = composePath;
        final int i2 = 0;
        if (obj instanceof AndroidPath == null) {
        } else {
            this.cachedOutline.setConvexPath((AndroidPath)obj.getInternalPath());
            this.usePathForClip = clip ^= 1;
            this.outlinePath = composePath;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        final int i4 = 0;
        this.cachedOutline.setRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float cachedRrectPath;
        int i2;
        float height;
        Outline cachedOutline;
        int i;
        int round2;
        int round3;
        int round;
        int round4;
        final float x-impl = CornerRadius.getX-impl(roundRect.getTopLeftCornerRadius-kKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            i2 = 0;
            this.cachedOutline.setRoundRect(Math.round(roundRect.getLeft()), Math.round(roundRect.getTop()), Math.round(roundRect.getRight()), Math.round(roundRect.getBottom()), x-impl);
            this.roundedCornerRadius = x-impl;
        } else {
            if (this.cachedRrectPath == null) {
                i = 0;
                this.cachedRrectPath = AndroidPath_androidKt.Path();
            }
            cachedRrectPath.reset();
            cachedOutline = 0;
            Path.addRoundRect$default(cachedRrectPath, roundRect, cachedOutline, 2, cachedOutline);
            updateCacheWithPath(cachedRrectPath);
        }
    }

    public final void clipToOutline(Canvas canvas) {
        float roundedCornerRadius2;
        RoundRect roundRect;
        boolean sameBounds-4L21HEs;
        long i4;
        long rectSize;
        long i5;
        float roundedCornerRadius;
        Canvas canvas2;
        int i2;
        Path roundRectClipPath;
        Object obj;
        float x-impl;
        float y-impl;
        int i3;
        int i;
        long l;
        roundedCornerRadius2 = this;
        canvas2 = canvas;
        final Path clipPath = roundedCornerRadius2.getClipPath();
        final int i6 = 0;
        final int i7 = 2;
        final int i8 = 0;
        if (clipPath != null) {
            Canvas.clipPath-mtrdD-E$default(canvas2, clipPath, i6, i7, i8);
            obj = roundedCornerRadius2;
        } else {
            i2 = 0;
            int cmp = Float.compare(roundedCornerRadius3, i2);
            if (cmp > 0) {
                roundRectClipPath = roundedCornerRadius2.tmpPath;
                if (roundRectClipPath != null) {
                    obj = roundedCornerRadius2;
                    if (!roundedCornerRadius2.isSameBounds-4L21HEs(roundedCornerRadius2.tmpRoundRect, roundedCornerRadius2.rectTopLeft, obj3, roundedCornerRadius2.rectSize)) {
                        roundRect = RoundRectKt.RoundRect-gG7oq9Y(Offset.getX-impl(obj.rectTopLeft), Offset.getY-impl(obj.rectTopLeft), x-impl2 + width-impl, y-impl2 + sameBounds-4L21HEs, CornerRadiusKt.CornerRadius$default(obj.roundedCornerRadius, i2, i7, i8));
                        if (roundRectClipPath == null) {
                            roundRectClipPath = AndroidPath_androidKt.Path();
                        } else {
                            roundRectClipPath.reset();
                        }
                        Path.addRoundRect$default(roundRectClipPath, roundRect, i8, i7, i8);
                        obj.tmpRoundRect = roundRect;
                        obj.tmpPath = roundRectClipPath;
                    }
                } else {
                    obj = roundedCornerRadius2;
                }
                Canvas.clipPath-mtrdD-E$default(canvas2, roundRectClipPath, i6, i7, i8);
            } else {
                obj = roundedCornerRadius2;
                Canvas.clipRect-N_I0leg$default(canvas, Offset.getX-impl(obj.rectTopLeft), Offset.getY-impl(obj.rectTopLeft), width-impl2 += x-impl3, height-impl += y-impl3, 0, 16, 0);
            }
        }
    }

    public final Outline getAndroidOutline() {
        Outline cachedOutline;
        boolean isSupportedOutline;
        updateCache();
        if (this.outlineNeeded) {
            if (!this.isSupportedOutline) {
                cachedOutline = 0;
            } else {
                cachedOutline = this.cachedOutline;
            }
        } else {
        }
        return cachedOutline;
    }

    public final boolean getCacheIsDirty$ui_release() {
        return this.cacheIsDirty;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean getOutlineClipSupported() {
        return usePathForClip ^= 1;
    }

    public final boolean isInOutline-k-4lQ0M(long position) {
        int i = 1;
        if (!this.outlineNeeded) {
            return i;
        }
        Outline outline = this.outline;
        if (outline == null) {
            return i;
        }
        return ShapeContainingUtilKt.isInOutline(outline, Offset.getX-impl(position), Offset.getY-impl(position), this.tmpTouchPointPath, this.tmpOpPath);
    }

    public final boolean update-S_szKao(Outline outline, float alpha, boolean clipToOutline, float elevation, long size) {
        int i;
        int cmp;
        this.cachedOutline.setAlpha(alpha);
        final int i3 = 1;
        equal ^= i3;
        if (i2 != 0) {
            this.outline = outline;
            this.cacheIsDirty = i3;
        }
        this.rectSize = size;
        if (outline != null) {
            if (!clipToOutline) {
                i = Float.compare(elevation, i4) > 0 ? i3 : 0;
            } else {
            }
        } else {
        }
        if (this.outlineNeeded != i) {
            this.outlineNeeded = i;
            this.cacheIsDirty = i3;
        }
        return i2;
    }
}
