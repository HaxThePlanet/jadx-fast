package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0019\u001a \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a@\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001c2\u0008\u0008\u0002\u0010 \u001a\u00020\u001c2\u0008\u0008\u0002\u0010!\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a8\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0000¢\u0006\u0004\u0008+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001c\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u00083\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000b\"\u0015\u0010\u000c\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00065", d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RoundRectKt {
    public static final androidx.compose.ui.geometry.RoundRect RoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY) {
        final long l = CornerRadiusKt.CornerRadius(radiusX, radiusY);
        RoundRect roundRect = new RoundRect(left, top, right, bottom, l, obj6, l, obj8, l, obj10, l, obj12, 0);
        return roundRect;
    }

    public static final androidx.compose.ui.geometry.RoundRect RoundRect(androidx.compose.ui.geometry.Rect rect, float radiusX, float radiusY) {
        return RoundRectKt.RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), radiusX, radiusY);
    }

    public static final androidx.compose.ui.geometry.RoundRect RoundRect-ZAM2FJo(androidx.compose.ui.geometry.Rect rect, long topLeft, long topRight, long bottomRight, long bottomLeft) {
        RoundRect roundRect = new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), topLeft, obj6, bottomRight, obj8, obj19, obj10, obj21, obj12, 0);
        return roundRect;
    }

    public static androidx.compose.ui.geometry.RoundRect RoundRect-ZAM2FJo$default(androidx.compose.ui.geometry.Rect rect, long l2, long l3, long l4, long l5, int i6, Object object7) {
        long zero-kKHJgLs3;
        long zero-kKHJgLs2;
        long zero-kKHJgLs4;
        long zero-kKHJgLs;
        if (obj17 & 2 != 0) {
            zero-kKHJgLs3 = CornerRadius.Companion.getZero-kKHJgLs();
        } else {
            zero-kKHJgLs3 = l2;
        }
        if (obj17 & 4 != 0) {
            zero-kKHJgLs2 = CornerRadius.Companion.getZero-kKHJgLs();
        } else {
            zero-kKHJgLs2 = l4;
        }
        if (obj17 & 8 != 0) {
            zero-kKHJgLs4 = CornerRadius.Companion.getZero-kKHJgLs();
        } else {
            zero-kKHJgLs4 = i6;
        }
        if (obj17 & 16 != 0) {
            zero-kKHJgLs = CornerRadius.Companion.getZero-kKHJgLs();
        } else {
            zero-kKHJgLs = obj15;
        }
        return RoundRectKt.RoundRect-ZAM2FJo(rect, zero-kKHJgLs3, l4, zero-kKHJgLs2, i6);
    }

    public static final androidx.compose.ui.geometry.RoundRect RoundRect-gG7oq9Y(float left, float top, float right, float bottom, long cornerRadius) {
        return RoundRectKt.RoundRect(left, top, right, bottom, CornerRadius.getX-impl(cornerRadius), CornerRadius.getY-impl(cornerRadius));
    }

    public static final androidx.compose.ui.geometry.RoundRect RoundRect-sniSvfs(androidx.compose.ui.geometry.Rect rect, long cornerRadius) {
        return RoundRectKt.RoundRect(rect, CornerRadius.getX-impl(cornerRadius), CornerRadius.getY-impl(cornerRadius));
    }

    public static final androidx.compose.ui.geometry.Rect getBoundingRect(androidx.compose.ui.geometry.RoundRect $this$boundingRect) {
        Rect rect = new Rect($this$boundingRect.getLeft(), $this$boundingRect.getTop(), $this$boundingRect.getRight(), $this$boundingRect.getBottom());
        return rect;
    }

    public static final long getCenter(androidx.compose.ui.geometry.RoundRect $this$center) {
        final int i4 = 1073741824;
        return OffsetKt.Offset(left += i2, top += i5);
    }

    public static final float getMaxDimension(androidx.compose.ui.geometry.RoundRect $this$maxDimension) {
        return Math.max(Math.abs($this$maxDimension.getWidth()), Math.abs($this$maxDimension.getHeight()));
    }

    public static final float getMinDimension(androidx.compose.ui.geometry.RoundRect $this$minDimension) {
        return Math.min(Math.abs($this$minDimension.getWidth()), Math.abs($this$minDimension.getHeight()));
    }

    public static final androidx.compose.ui.geometry.Rect getSafeInnerRect(androidx.compose.ui.geometry.RoundRect $this$safeInnerRect) {
        final int i = 1050015258;
        Rect rect = new Rect(left += i3, top += i5, right -= i7, bottom -= i9);
        return rect;
    }

    public static final boolean isCircle(androidx.compose.ui.geometry.RoundRect $this$isCircle) {
        int ellipse;
        int i;
        final int i2 = 0;
        ellipse = Float.compare(width, height) == 0 ? i : i2;
        if (ellipse != 0 && RoundRectKt.isEllipse($this$isCircle)) {
            if (RoundRectKt.isEllipse($this$isCircle)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    public static final boolean isEllipse(androidx.compose.ui.geometry.RoundRect $this$isEllipse) {
        int cmp;
        int i;
        float y-impl;
        int i2;
        long l;
        i = 1;
        final int i3 = 0;
        cmp = Float.compare(x-impl, x-impl5) == 0 ? i : i3;
        if (cmp != 0) {
            cmp = Float.compare(y-impl2, y-impl) == 0 ? i : i3;
            if (cmp != 0) {
                cmp = Float.compare(x-impl2, y-impl) == 0 ? i : i3;
                if (cmp != 0) {
                    cmp = Float.compare(y-impl3, y-impl) == 0 ? i : i3;
                    if (cmp != 0) {
                        cmp = Float.compare(x-impl3, y-impl) == 0 ? i : i3;
                        if (cmp != 0) {
                            cmp = Float.compare(y-impl4, y-impl) == 0 ? i : i3;
                            l = 4611686018427387904L;
                            if (cmp != 0 && Double.compare(y-impl, i2) <= 0 && Double.compare(y-impl, i2) <= 0) {
                                l = 4611686018427387904L;
                                if (Double.compare(y-impl, i2) <= 0) {
                                    if (Double.compare(y-impl, i2) <= 0) {
                                    } else {
                                        i = i3;
                                    }
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
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean isEmpty(androidx.compose.ui.geometry.RoundRect $this$isEmpty) {
        int i;
        int cmp;
        float bottom;
        if (Float.compare(left, bottom) < 0) {
            if (Float.compare(top, bottom) >= 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static final boolean isFinite(androidx.compose.ui.geometry.RoundRect $this$isFinite) {
        float naN3;
        int i2;
        float naN2;
        float naN4;
        float naN;
        boolean infinite;
        int i;
        naN3 = $this$isFinite.getLeft();
        i = 1;
        final int i3 = 0;
        if (!Float.isInfinite(naN3) && !Float.isNaN(naN3)) {
            i2 = !Float.isNaN(naN3) ? i : i3;
        } else {
        }
        if (i2 != 0) {
            naN = $this$isFinite.getTop();
            if (!Float.isInfinite(naN) && !Float.isNaN(naN)) {
                i2 = !Float.isNaN(naN) ? i : i3;
            } else {
            }
            if (i2 != 0) {
                naN4 = $this$isFinite.getRight();
                if (!Float.isInfinite(naN4) && !Float.isNaN(naN4)) {
                    i2 = !Float.isNaN(naN4) ? i : i3;
                } else {
                }
                if (i2 != 0) {
                    naN2 = $this$isFinite.getBottom();
                    if (!Float.isInfinite(naN2) && !Float.isNaN(naN2)) {
                        i2 = !Float.isNaN(naN2) ? i : i3;
                    } else {
                    }
                    if (i2 != 0) {
                    } else {
                        i = i3;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean isRect(androidx.compose.ui.geometry.RoundRect $this$isRect) {
        int i;
        int i2;
        long topRightCornerRadius-kKHJgLs;
        final int i3 = 0;
        i2 = 1;
        final int i4 = 0;
        i = Float.compare(x-impl, i3) == 0 ? i2 : i4;
        if (i == 0) {
            i = Float.compare(y-impl4, i3) == 0 ? i2 : i4;
            if (i != 0) {
                i = Float.compare(x-impl2, i3) == 0 ? i2 : i4;
                if (i == 0) {
                    i = Float.compare(y-impl, i3) == 0 ? i2 : i4;
                    if (i != 0) {
                        i = Float.compare(x-impl3, i3) == 0 ? i2 : i4;
                        if (i == 0) {
                            i = Float.compare(y-impl3, i3) == 0 ? i2 : i4;
                            if (i != 0) {
                                i = Float.compare(x-impl4, i3) == 0 ? i2 : i4;
                                if (i == 0) {
                                    i = Float.compare(y-impl2, i3) == 0 ? i2 : i4;
                                    if (i != 0) {
                                    } else {
                                        i2 = i4;
                                    }
                                }
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
        } else {
        }
        return i2;
    }

    public static final boolean isSimple(androidx.compose.ui.geometry.RoundRect $this$isSimple) {
        int i2;
        int i;
        float x-impl;
        i = 1;
        final int i3 = 0;
        i2 = Float.compare(x-impl2, y-impl) == 0 ? i : i3;
        if (i2 != 0) {
            i2 = Float.compare(x-impl3, x-impl) == 0 ? i : i3;
            if (i2 != 0) {
                i2 = Float.compare(x-impl4, x-impl) == 0 ? i : i3;
                if (i2 != 0) {
                    i2 = Float.compare(x-impl5, x-impl) == 0 ? i : i3;
                    if (i2 != 0) {
                        i2 = Float.compare(x-impl6, x-impl) == 0 ? i : i3;
                        if (i2 != 0) {
                            i2 = Float.compare(x-impl7, x-impl) == 0 ? i : i3;
                            if (i2 != 0) {
                                i2 = Float.compare(x-impl8, x-impl) == 0 ? i : i3;
                                if (i2 != 0) {
                                } else {
                                    i = i3;
                                }
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
        } else {
        }
        return i;
    }

    public static final androidx.compose.ui.geometry.RoundRect lerp(androidx.compose.ui.geometry.RoundRect start, androidx.compose.ui.geometry.RoundRect stop, float fraction) {
        final float f = fraction;
        RoundRect roundRect = new RoundRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), f), MathHelpersKt.lerp(start.getTop(), stop.getTop(), f), MathHelpersKt.lerp(start.getRight(), stop.getRight(), f), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), f), CornerRadiusKt.lerp-3Ry4LBc(start.getTopLeftCornerRadius-kKHJgLs(), obj7, stop.getTopLeftCornerRadius-kKHJgLs()), obj7, CornerRadiusKt.lerp-3Ry4LBc(start.getTopRightCornerRadius-kKHJgLs(), obj9, stop.getTopRightCornerRadius-kKHJgLs()), obj9, CornerRadiusKt.lerp-3Ry4LBc(start.getBottomRightCornerRadius-kKHJgLs(), obj11, stop.getBottomRightCornerRadius-kKHJgLs()), obj11, CornerRadiusKt.lerp-3Ry4LBc(start.getBottomLeftCornerRadius-kKHJgLs(), obj13, stop.getBottomLeftCornerRadius-kKHJgLs()), obj13, 0);
        return roundRect;
    }

    public static final androidx.compose.ui.geometry.RoundRect translate-Uv8p0NA(androidx.compose.ui.geometry.RoundRect $this$translate_u2dUv8p0NA, long offset) {
        RoundRect roundRect = new RoundRect(left += x-impl, top += y-impl, right += x-impl2, bottom += y-impl2, $this$translate_u2dUv8p0NA.getTopLeftCornerRadius-kKHJgLs(), obj6, $this$translate_u2dUv8p0NA.getTopRightCornerRadius-kKHJgLs(), obj8, $this$translate_u2dUv8p0NA.getBottomRightCornerRadius-kKHJgLs(), obj10, $this$translate_u2dUv8p0NA.getBottomLeftCornerRadius-kKHJgLs(), obj12, 0);
        return roundRect;
    }
}
