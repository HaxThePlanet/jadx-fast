package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u001a2\u0010 \u001a\u00020!*\u00020\u00022#\u0008\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020!0#H\u0086\u0008\u001a2\u0010'\u001a\u00020!*\u00020\u00022#\u0008\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020!0#H\u0086\u0008\u001a2\u0010(\u001a\u00020!*\u00020\u00022#\u0008\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020!0#H\u0086\u0008\u001a2\u0010)\u001a\u00020!*\u00020\u00022#\u0008\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020!0#H\u0086\u0008\u001a2\u0010*\u001a\u00020+*\u00020\u00022#\u0008\u0004\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008$\u0012\u0008\u0008%\u0012\u0004\u0008\u0008(&\u0012\u0004\u0012\u00020!0#H\u0086\u0008\u001a\u0014\u0010,\u001a\u00020-*\u00020\u00022\u0008\u0008\u0002\u0010.\u001a\u00020/\u001a%\u00100\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000e\u0008\u0004\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020!04H\u0086\u0008\u001a \u00105\u001a\u000201*\u00020\u00022\u0006\u00102\u001a\u0002032\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020!04\u001a\u0017\u00106\u001a\u00020!*\u00020\u00022\u0008\u0008\u0001\u00107\u001a\u00020\u0013H\u0086\u0008\u001a7\u00108\u001a\u00020!\"\n\u0008\u0000\u00109\u0018\u0001*\u00020:*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\u0008<H\u0087\u0008¢\u0006\u0002\u0008=\u001a&\u00108\u001a\u00020!*\u00020\u00022\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\u0008<H\u0086\u0008\u001a5\u0010>\u001a\u00020!*\u00020\u00022\u0008\u0008\u0003\u0010?\u001a\u00020\u00132\u0008\u0008\u0003\u0010@\u001a\u00020\u00132\u0008\u0008\u0003\u0010A\u001a\u00020\u00132\u0008\u0008\u0003\u0010B\u001a\u00020\u0013H\u0086\u0008\u001a5\u0010C\u001a\u00020!*\u00020\u00022\u0008\u0008\u0003\u0010D\u001a\u00020\u00132\u0008\u0008\u0003\u0010@\u001a\u00020\u00132\u0008\u0008\u0003\u0010E\u001a\u00020\u00132\u0008\u0008\u0003\u0010B\u001a\u00020\u0013H\u0086\u0008\"\u001b\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004\"\u001b\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0004\"*\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r\"*\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u000b\"\u0004\u0008\u000f\u0010\r\"*\u0010\u0010\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t8Æ\u0002@Æ\u0002X\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\u000b\"\u0004\u0008\u0011\u0010\r\"\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015\"\u0016\u0010\u0016\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0015\"\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0015\"\u0016\u0010\u001a\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0015\"\u0016\u0010\u001c\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0015\"\u0016\u0010\u001e\u001a\u00020\u0013*\u00020\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\u0015¨\u0006F", d2 = {"allViews", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "getAllViews", "(Landroid/view/View;)Lkotlin/sequences/Sequence;", "ancestors", "Landroid/view/ViewParent;", "getAncestors", "value", "", "isGone", "(Landroid/view/View;)Z", "setGone", "(Landroid/view/View;Z)V", "isInvisible", "setInvisible", "isVisible", "setVisible", "marginBottom", "", "getMarginBottom", "(Landroid/view/View;)I", "marginEnd", "getMarginEnd", "marginLeft", "getMarginLeft", "marginRight", "getMarginRight", "marginStart", "getMarginStart", "marginTop", "getMarginTop", "doOnAttach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnDetach", "doOnLayout", "doOnNextLayout", "doOnPreDraw", "Landroidx/core/view/OneShotPreDrawListener;", "drawToBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "postDelayed", "Ljava/lang/Runnable;", "delayInMillis", "", "Lkotlin/Function0;", "postOnAnimationDelayed", "setPadding", "size", "updateLayoutParams", "T", "Landroid/view/ViewGroup$LayoutParams;", "block", "Lkotlin/ExtensionFunctionType;", "updateLayoutParamsTyped", "updatePadding", "left", "top", "right", "bottom", "updatePaddingRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewKt {
    public static void $r8$lambda$dpsg06okbB847jib5cr-d0X1meI(Function0 function0) {
        ViewKt.postOnAnimationDelayed$lambda$1(function0);
    }

    public static final void doOnAttach(View $this$doOnAttach, Function1<? super View, Unit> action) {
        boolean attachedToWindow;
        final int i = 0;
        if ($this$doOnAttach.isAttachedToWindow()) {
            action.invoke($this$doOnAttach);
        } else {
            attachedToWindow = new ViewKt.doOnAttach.1($this$doOnAttach, action);
            $this$doOnAttach.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)attachedToWindow);
        }
    }

    public static final void doOnDetach(View $this$doOnDetach, Function1<? super View, Unit> action) {
        boolean attachedToWindow;
        final int i = 0;
        if (!$this$doOnDetach.isAttachedToWindow()) {
            action.invoke($this$doOnDetach);
        } else {
            attachedToWindow = new ViewKt.doOnDetach.1($this$doOnDetach, action);
            $this$doOnDetach.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)attachedToWindow);
        }
    }

    public static final void doOnLayout(View $this$doOnLayout, Function1<? super View, Unit> action) {
        boolean layoutRequested;
        int i;
        androidx.core.view.ViewKt.doOnLayout$$inlined.doOnNextLayout.1 anon;
        final int i2 = 0;
        if ($this$doOnLayout.isLaidOut() && !$this$doOnLayout.isLayoutRequested()) {
            if (!$this$doOnLayout.isLayoutRequested()) {
                action.invoke($this$doOnLayout);
            } else {
                i = 0;
                anon = new ViewKt.doOnLayout$$inlined.doOnNextLayout.1(action);
                $this$doOnLayout.addOnLayoutChangeListener((View.OnLayoutChangeListener)anon);
            }
        } else {
        }
    }

    public static final void doOnNextLayout(View $this$doOnNextLayout, Function1<? super View, Unit> action) {
        final int i = 0;
        ViewKt.doOnNextLayout.1 anon = new ViewKt.doOnNextLayout.1(action);
        $this$doOnNextLayout.addOnLayoutChangeListener((View.OnLayoutChangeListener)anon);
    }

    public static final androidx.core.view.OneShotPreDrawListener doOnPreDraw(View $this$doOnPreDraw, Function1<? super View, Unit> action) {
        final int i = 0;
        ViewKt.doOnPreDraw.1 anon = new ViewKt.doOnPreDraw.1(action, $this$doOnPreDraw);
        return OneShotPreDrawListener.add($this$doOnPreDraw, (Runnable)anon);
    }

    public static final Bitmap drawToBitmap(View $this$drawToBitmap, Bitmap.Config config) {
        if (!$this$drawToBitmap.isLaidOut()) {
        } else {
            Bitmap bitmap = Bitmap.createBitmap($this$drawToBitmap.getWidth(), $this$drawToBitmap.getHeight(), config);
            int i = 0;
            Canvas canvas = new Canvas(bitmap);
            final Canvas canvas2 = canvas;
            final int i2 = 0;
            canvas2.translate(-f, -f2);
            $this$drawToBitmap.draw(canvas2);
            return bitmap;
        }
        IllegalStateException illegalStateException = new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
        throw illegalStateException;
    }

    public static Bitmap drawToBitmap$default(View view, Bitmap.Config bitmap$Config2, int i3, Object object4) {
        Bitmap.Config obj1;
        if (i3 &= 1 != 0) {
            obj1 = Bitmap.Config.ARGB_8888;
        }
        return ViewKt.drawToBitmap(view, obj1);
    }

    public static final Sequence<View> getAllViews(View $this$allViews) {
        ViewKt.allViews.1 anon = new ViewKt.allViews.1($this$allViews, 0);
        return SequencesKt.sequence((Function2)anon);
    }

    public static final Sequence<ViewParent> getAncestors(View $this$ancestors) {
        return SequencesKt.generateSequence($this$ancestors.getParent(), (Function1)ViewKt.ancestors.1.INSTANCE);
    }

    public static final int getMarginBottom(View $this$marginBottom) {
        ViewGroup.LayoutParams layoutParams;
        int bottomMargin;
        final int i = 0;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        } else {
            layoutParams = 0;
        }
        bottomMargin = layoutParams != null ? layoutParams.bottomMargin : 0;
        return bottomMargin;
    }

    public static final int getMarginEnd(View $this$marginEnd) {
        int marginEnd;
        final int i = 0;
        final ViewGroup.LayoutParams layoutParams = $this$marginEnd.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginEnd = (ViewGroup.MarginLayoutParams)layoutParams.getMarginEnd();
        } else {
            marginEnd = 0;
        }
        return marginEnd;
    }

    public static final int getMarginLeft(View $this$marginLeft) {
        ViewGroup.LayoutParams layoutParams;
        int leftMargin;
        final int i = 0;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        } else {
            layoutParams = 0;
        }
        leftMargin = layoutParams != null ? layoutParams.leftMargin : 0;
        return leftMargin;
    }

    public static final int getMarginRight(View $this$marginRight) {
        ViewGroup.LayoutParams layoutParams;
        int rightMargin;
        final int i = 0;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        } else {
            layoutParams = 0;
        }
        rightMargin = layoutParams != null ? layoutParams.rightMargin : 0;
        return rightMargin;
    }

    public static final int getMarginStart(View $this$marginStart) {
        int marginStart;
        final int i = 0;
        final ViewGroup.LayoutParams layoutParams = $this$marginStart.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginStart = (ViewGroup.MarginLayoutParams)layoutParams.getMarginStart();
        } else {
            marginStart = 0;
        }
        return marginStart;
    }

    public static final int getMarginTop(View $this$marginTop) {
        ViewGroup.LayoutParams layoutParams;
        int topMargin;
        final int i = 0;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
        } else {
            layoutParams = 0;
        }
        topMargin = layoutParams != null ? layoutParams.topMargin : 0;
        return topMargin;
    }

    public static final boolean isGone(View $this$isGone) {
        int i;
        final int i2 = 0;
        i = $this$isGone.getVisibility() == 8 ? 1 : 0;
        return i;
    }

    public static final boolean isInvisible(View $this$isInvisible) {
        int i;
        final int i2 = 0;
        i = $this$isInvisible.getVisibility() == 4 ? 1 : 0;
        return i;
    }

    public static final boolean isVisible(View $this$isVisible) {
        int i;
        final int i2 = 0;
        i = $this$isVisible.getVisibility() == 0 ? 1 : 0;
        return i;
    }

    public static final Runnable postDelayed(View $this$postDelayed, long delayInMillis, Function0<Unit> action) {
        final int i = 0;
        ViewKt.postDelayed.runnable.1 anon = new ViewKt.postDelayed.runnable.1(obj5);
        $this$postDelayed.postDelayed((Runnable)anon, delayInMillis);
        return anon;
    }

    public static final Runnable postOnAnimationDelayed(View $this$postOnAnimationDelayed, long delayInMillis, Function0<Unit> action) {
        ViewKt$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ViewKt$$ExternalSyntheticLambda0(obj4);
        $this$postOnAnimationDelayed.postOnAnimationDelayed(externalSyntheticLambda0, delayInMillis);
        return externalSyntheticLambda0;
    }

    private static final void postOnAnimationDelayed$lambda$1(Function0 $action) {
        $action.invoke();
    }

    public static final void setGone(View $this$isGone, boolean value) {
        int i;
        final int i2 = 0;
        i = value != null ? 8 : 0;
        $this$isGone.setVisibility(i);
    }

    public static final void setInvisible(View $this$isInvisible, boolean value) {
        int i;
        final int i2 = 0;
        i = value != null ? 4 : 0;
        $this$isInvisible.setVisibility(i);
    }

    public static final void setPadding(View $this$setPadding, int size) {
        final int i = 0;
        $this$setPadding.setPadding(size, size, size, size);
    }

    public static final void setVisible(View $this$isVisible, boolean value) {
        int i;
        final int i2 = 0;
        i = value != null ? 0 : 8;
        $this$isVisible.setVisibility(i);
    }

    public static final void updateLayoutParams(View $this$updateLayoutParams, Function1<? super ViewGroup.LayoutParams, Unit> block) {
        final int i = 0;
        final Object obj = $this$updateLayoutParams;
        final int i2 = 0;
        ViewGroup.LayoutParams layoutParams = obj.getLayoutParams();
        if (layoutParams == null) {
        } else {
            block.invoke(layoutParams);
            obj.setLayoutParams(layoutParams);
        }
        NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        throw nullPointerException;
    }

    public static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View $this$updateLayoutParams, Function1<? super T, Unit> block) {
        final int i = 0;
        final ViewGroup.LayoutParams layoutParams = $this$updateLayoutParams.getLayoutParams();
        Intrinsics.reifiedOperationMarker(1, "T");
        block.invoke((ViewGroup.LayoutParams)layoutParams);
        $this$updateLayoutParams.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View $this$updatePadding, int left, int top, int right, int bottom) {
        final int i = 0;
        $this$updatePadding.setPadding(left, top, right, bottom);
    }

    public static void updatePadding$default(View $this$updatePadding_u24default, int left, int top, int right, int bottom, int i6, Object object7) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = $this$updatePadding_u24default.getPaddingLeft();
        }
        if (i6 & 2 != 0) {
            obj2 = $this$updatePadding_u24default.getPaddingTop();
        }
        if (i6 & 4 != 0) {
            obj3 = $this$updatePadding_u24default.getPaddingRight();
        }
        if (i6 &= 8 != 0) {
            obj4 = $this$updatePadding_u24default.getPaddingBottom();
        }
        int obj5 = 0;
        $this$updatePadding_u24default.setPadding(obj1, obj2, obj3, obj4);
    }

    public static final void updatePaddingRelative(View $this$updatePaddingRelative, int start, int top, int end, int bottom) {
        final int i = 0;
        $this$updatePaddingRelative.setPaddingRelative(start, top, end, bottom);
    }

    public static void updatePaddingRelative$default(View $this$updatePaddingRelative_u24default, int start, int top, int end, int bottom, int i6, Object object7) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        if (i6 & 1 != 0) {
            obj1 = $this$updatePaddingRelative_u24default.getPaddingStart();
        }
        if (i6 & 2 != 0) {
            obj2 = $this$updatePaddingRelative_u24default.getPaddingTop();
        }
        if (i6 & 4 != 0) {
            obj3 = $this$updatePaddingRelative_u24default.getPaddingEnd();
        }
        if (i6 &= 8 != 0) {
            obj4 = $this$updatePaddingRelative_u24default.getPaddingBottom();
        }
        int obj5 = 0;
        $this$updatePaddingRelative_u24default.setPaddingRelative(obj1, obj2, obj3, obj4);
    }
}
