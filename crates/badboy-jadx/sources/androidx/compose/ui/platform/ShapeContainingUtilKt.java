package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Outline.Rectangle;
import androidx.compose.ui.graphics.Outline.Rounded;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.PathOperation.Companion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0000\u001a4\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0002\u001a \u0010\u000c\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a4\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0008H\u0002\u001a:\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a\u000c\u0010\u001a\u001a\u00020\u0001*\u00020\u001bH\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"isInOutline", "", "outline", "Landroidx/compose/ui/graphics/Outline;", "x", "", "y", "tmpTouchPointPath", "Landroidx/compose/ui/graphics/Path;", "tmpOpPath", "isInPath", "path", "isInRectangle", "rect", "Landroidx/compose/ui/geometry/Rect;", "isInRoundedRect", "Landroidx/compose/ui/graphics/Outline$Rounded;", "touchPointPath", "opPath", "isWithinEllipse", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "centerX", "centerY", "isWithinEllipse-VE1yxkc", "(FFJFF)Z", "cornersFit", "Landroidx/compose/ui/geometry/RoundRect;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShapeContainingUtilKt {
    private static final boolean cornersFit(RoundRect $this$cornersFit) {
        int cmp;
        int i;
        float height;
        height = $this$cornersFit.getWidth();
        height = $this$cornersFit.getWidth();
        height = $this$cornersFit.getHeight();
        if (Float.compare(i2, height) <= 0 && Float.compare(i3, height) <= 0 && Float.compare(i4, height) <= 0 && Float.compare(i5, height) <= 0) {
            height = $this$cornersFit.getWidth();
            if (Float.compare(i3, height) <= 0) {
                height = $this$cornersFit.getHeight();
                if (Float.compare(i4, height) <= 0) {
                    i = Float.compare(i5, height) <= 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean isInOutline(Outline outline, float x, float y, Path tmpTouchPointPath, Path tmpOpPath) {
        boolean inRoundedRect;
        if (outline instanceof Outline.Rectangle) {
            inRoundedRect = ShapeContainingUtilKt.isInRectangle((Outline.Rectangle)outline.getRect(), x, y);
            return inRoundedRect;
        } else {
            if (outline instanceof Outline.Rounded) {
                inRoundedRect = ShapeContainingUtilKt.isInRoundedRect((Outline.Rounded)outline, x, y, tmpTouchPointPath, tmpOpPath);
            } else {
                if (!outline instanceof Outline.Generic) {
                } else {
                    inRoundedRect = ShapeContainingUtilKt.isInPath((Outline.Generic)outline.getPath(), x, y, tmpTouchPointPath, tmpOpPath);
                }
            }
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    public static boolean isInOutline$default(Outline outline, float f2, float f3, Path path4, Path path5, int i6, Object object7) {
        int obj4;
        int obj5;
        final int i = 0;
        if (i6 & 8 != 0) {
            obj4 = i;
        }
        if (i6 &= 16 != 0) {
            obj5 = i;
        }
        return ShapeContainingUtilKt.isInOutline(outline, f2, f3, obj4, obj5);
    }

    private static final boolean isInPath(Path path, float x, float y, Path tmpTouchPointPath, Path tmpOpPath) {
        Path path3;
        Path path2;
        int i = 1000593162;
        Rect rect = new Rect(x - i, y - i, x + i, i += y);
        if (tmpTouchPointPath == null) {
            path3 = AndroidPath_androidKt.Path();
        } else {
            path3 = tmpTouchPointPath;
        }
        int i6 = 0;
        Path.addRect$default(path3, rect, i6, 2, i6);
        if (tmpOpPath == null) {
            path2 = AndroidPath_androidKt.Path();
        } else {
            path2 = tmpOpPath;
        }
        path2.op-N5in7k0(path, path3, PathOperation.Companion.getIntersect-b3I0S0c());
        path2.reset();
        path3.reset();
        return empty ^ 1;
    }

    private static final boolean isInRectangle(Rect rect, float x, float y) {
        int cmp;
        int i;
        if (Float.compare(left, x) <= 0 && Float.compare(x, right) < 0 && Float.compare(top, y) <= 0 && Float.compare(y, bottom) < 0) {
            if (Float.compare(x, right) < 0) {
                if (Float.compare(top, y) <= 0) {
                    i = Float.compare(y, bottom) < 0 ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private static final boolean isInRoundedRect(Outline.Rounded outline, float x, float y, Path touchPointPath, Path opPath) {
        float cmp3;
        int cmp2;
        int cmp;
        float f;
        int cmp4;
        Path path2;
        boolean withinEllipse-VE1yxkc;
        int cmp5;
        int topLeftX;
        int topLeftY;
        Path path;
        int topLeftX2;
        int i;
        cmp3 = x;
        f = y;
        final Path path3 = opPath;
        final RoundRect roundRect = outline.getRoundRect();
        if (Float.compare(cmp3, left) >= 0 && Float.compare(cmp3, right) < 0 && Float.compare(f, top) >= 0) {
            if (Float.compare(cmp3, right) < 0) {
                if (Float.compare(f, top) >= 0) {
                    if (Float.compare(f, bottom) >= 0) {
                        path = touchPointPath;
                        return 0;
                    } else {
                        if (!ShapeContainingUtilKt.cornersFit(roundRect)) {
                            if (path3 == null) {
                                path2 = AndroidPath_androidKt.Path();
                            } else {
                                path2 = path3;
                            }
                            int i4 = 0;
                            Path.addRoundRect$default(path2, roundRect, i4, 2, i4);
                            return ShapeContainingUtilKt.isInPath(path2, cmp3, f, touchPointPath, path3);
                        }
                        Path path5 = touchPointPath;
                        int i5 = left2 + x-impl;
                        int i8 = top2 + y-impl;
                        int i11 = right2 - x-impl2;
                        int i12 = top3 + y-impl2;
                        int i13 = right3 - x-impl3;
                        int i14 = bottom2 - y-impl3;
                        int i15 = bottom3 - y-impl4;
                        float x-impl4 = CornerRadius.getX-impl(roundRect.getBottomLeftCornerRadius-kKHJgLs());
                        int i16 = left3 + x-impl4;
                        if (Float.compare(cmp3, i5) < 0 && Float.compare(f, i8) < 0) {
                            if (Float.compare(f, i8) < 0) {
                                withinEllipse-VE1yxkc = ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(cmp3, f, roundRect.getTopLeftCornerRadius-kKHJgLs(), x-impl4, i5);
                                topLeftX2 = i5;
                                i = i8;
                                topLeftX = i13;
                                topLeftY = i14;
                            } else {
                                topLeftX2 = i5;
                                i = i8;
                                if (Float.compare(x, i16) < 0 && Float.compare(y, i15) > 0) {
                                    if (Float.compare(y, i15) > 0) {
                                        withinEllipse-VE1yxkc = ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(x, y, roundRect.getBottomLeftCornerRadius-kKHJgLs(), x-impl4, i16);
                                        topLeftX = i13;
                                        topLeftY = i14;
                                    } else {
                                        if (Float.compare(x, i11) > 0 && Float.compare(y, i12) < 0) {
                                            if (Float.compare(y, i12) < 0) {
                                                withinEllipse-VE1yxkc = ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(x, y, roundRect.getTopRightCornerRadius-kKHJgLs(), x-impl4, i11);
                                                topLeftX = i13;
                                                topLeftY = i14;
                                            } else {
                                                if (Float.compare(x, i13) > 0 && Float.compare(y, i14) > 0) {
                                                    if (Float.compare(y, i14) > 0) {
                                                        withinEllipse-VE1yxkc = ShapeContainingUtilKt.isWithinEllipse-VE1yxkc(x, y, roundRect.getBottomRightCornerRadius-kKHJgLs(), x-impl4, i13);
                                                    } else {
                                                        topLeftX = i13;
                                                        topLeftY = i14;
                                                        withinEllipse-VE1yxkc = 1;
                                                    }
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                    return withinEllipse-VE1yxkc;
                }
            }
        }
        path = touchPointPath;
    }

    private static final boolean isWithinEllipse-VE1yxkc(float x, float y, long cornerRadius, float centerX, float centerY) {
        int i;
        final int i2 = x - centerY;
        final int i3 = y - obj12;
        final float x-impl = CornerRadius.getX-impl(cornerRadius);
        final float y-impl = CornerRadius.getY-impl(cornerRadius);
        i = Float.compare(i6, i10) <= 0 ? 1 : 0;
        return i;
    }
}
