package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\u000c\u0010\u0007\u001a\u00020\u0008*\u00020\tH\u0000\u001a%\u0010\n\u001a\u00020\u000b*\u00020\t2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u00032\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0013", d2 = {"toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateBoundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "requestInteropFocus", "", "direction", "rect", "Landroid/graphics/Rect;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusInteropUtils_androidKt {
    public static final Rect calculateBoundingRect(View $this$calculateBoundingRect) {
        int[] tempCoordinates = FocusInteropUtils.Companion.getTempCoordinates();
        int i = 0;
        $this$calculateBoundingRect.getLocationInWindow(tempCoordinates);
        int i2 = 0;
        int i6 = 1;
        Rect it = new Rect((float)i5, (float)i9, f += f5, f3 += f6);
        return it;
    }

    public static final boolean requestInteropFocus(View $this$requestInteropFocus, Integer direction, Rect rect) {
        boolean focusedView;
        boolean focusable;
        int focus;
        Object requestFocus;
        int intValue;
        int intValue2;
        if (direction == null) {
            focusedView = $this$requestInteropFocus.requestFocus();
        } else {
            if (!$this$requestInteropFocus instanceof ViewGroup) {
                focusedView = $this$requestInteropFocus.requestFocus(direction.intValue(), rect);
            } else {
                if ((ViewGroup)$this$requestInteropFocus.isFocused()) {
                    focusedView = 1;
                } else {
                    if ((ViewGroup)$this$requestInteropFocus.isFocusable() && !$this$requestInteropFocus.hasFocus()) {
                        if (!$this$requestInteropFocus.hasFocus()) {
                            focusedView = $this$requestInteropFocus.requestFocus(direction.intValue(), rect);
                        } else {
                            if ($this$requestInteropFocus instanceof AndroidComposeView != null) {
                                focusedView = $this$requestInteropFocus.requestFocus(direction.intValue(), rect);
                            } else {
                                if (rect != null) {
                                    View nextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect((ViewGroup)$this$requestInteropFocus, rect, direction.intValue());
                                    if (nextFocusFromRect != null) {
                                        focusedView = nextFocusFromRect.requestFocus(direction.intValue(), rect);
                                    } else {
                                        focusedView = $this$requestInteropFocus.requestFocus(direction.intValue(), rect);
                                    }
                                } else {
                                    if ($this$requestInteropFocus.hasFocus()) {
                                        focus = $this$requestInteropFocus.findFocus();
                                    } else {
                                        focus = 0;
                                    }
                                    View nextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup)$this$requestInteropFocus, focus, direction.intValue());
                                    if (nextFocus != null) {
                                        focusedView = requestFocus;
                                    } else {
                                        focusedView = requestFocus;
                                    }
                                }
                            }
                        }
                    } else {
                    }
                }
            }
        }
        return focusedView;
    }

    public static final Integer toAndroidFocusDirection-3ESFkO8(int $this$toAndroidFocusDirection_u2d3ESFkO8) {
        Integer valueOf;
        if (FocusDirection.equals-impl0($this$toAndroidFocusDirection_u2d3ESFkO8, FocusDirection.Companion.getUp-dhqQ-8s())) {
            valueOf = 33;
        } else {
            if (FocusDirection.equals-impl0($this$toAndroidFocusDirection_u2d3ESFkO8, FocusDirection.Companion.getDown-dhqQ-8s())) {
                valueOf = 130;
            } else {
                if (FocusDirection.equals-impl0($this$toAndroidFocusDirection_u2d3ESFkO8, FocusDirection.Companion.getLeft-dhqQ-8s())) {
                    valueOf = 17;
                } else {
                    if (FocusDirection.equals-impl0($this$toAndroidFocusDirection_u2d3ESFkO8, FocusDirection.Companion.getRight-dhqQ-8s())) {
                        valueOf = 66;
                    } else {
                        if (FocusDirection.equals-impl0($this$toAndroidFocusDirection_u2d3ESFkO8, FocusDirection.Companion.getNext-dhqQ-8s())) {
                            valueOf = 2;
                        } else {
                            if (FocusDirection.equals-impl0($this$toAndroidFocusDirection_u2d3ESFkO8, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
                                valueOf = 1;
                            } else {
                                valueOf = 0;
                            }
                        }
                    }
                }
            }
        }
        return valueOf;
    }

    public static final androidx.compose.ui.focus.FocusDirection toFocusDirection(int androidDirection) {
        androidx.compose.ui.focus.FocusDirection box-impl;
        switch (androidDirection) {
            case 1:
                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getPrevious-dhqQ-8s());
                break;
            case 2:
                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getNext-dhqQ-8s());
                break;
            case 17:
                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getLeft-dhqQ-8s());
                break;
            case 33:
                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getUp-dhqQ-8s());
                break;
            case 66:
                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getRight-dhqQ-8s());
                break;
            case 130:
                box-impl = FocusDirection.box-impl(FocusDirection.Companion.getDown-dhqQ-8s());
                break;
            default:
                box-impl = 0;
        }
        return box-impl;
    }

    public static final LayoutDirection toLayoutDirection(int androidLayoutDirection) {
        LayoutDirection ltr;
        switch (androidLayoutDirection) {
            case 0:
                ltr = LayoutDirection.Ltr;
                break;
            case 1:
                ltr = LayoutDirection.Rtl;
                break;
            default:
                ltr = 0;
        }
        return ltr;
    }
}
