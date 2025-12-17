package androidx.compose.material.ripple;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"IsRunningInPreview", "", "createAndAttachRippleContainerIfNeeded", "Landroidx/compose/material/ripple/RippleContainer;", "view", "Landroid/view/ViewGroup;", "createPlatformRippleNode", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "createPlatformRippleNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/DelegatableNode;", "findNearestViewGroup", "initialView", "Landroid/view/View;", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Ripple_androidKt {

    private static final boolean IsRunningInPreview;
    static {
        Ripple_androidKt.IsRunningInPreview = Intrinsics.areEqual(Build.DEVICE, "layoutlib");
    }

    public static final androidx.compose.material.ripple.RippleContainer access$createAndAttachRippleContainerIfNeeded(ViewGroup view) {
        return Ripple_androidKt.createAndAttachRippleContainerIfNeeded(view);
    }

    public static final ViewGroup access$findNearestViewGroup(View initialView) {
        return Ripple_androidKt.findNearestViewGroup(initialView);
    }

    private static final androidx.compose.material.ripple.RippleContainer createAndAttachRippleContainerIfNeeded(ViewGroup view) {
        int index;
        View childAt;
        boolean z;
        index = 0;
        while (index < view.getChildCount()) {
            childAt = view.getChildAt(index);
            index++;
        }
        RippleContainer index2 = new RippleContainer(view.getContext());
        int i = 0;
        view.addView((View)index2);
        return index2;
    }

    public static final DelegatableNode createPlatformRippleNode-TDGSqEk(InteractionSource interactionSource, boolean bounded, float radius, ColorProducer color, Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        androidx.compose.material.ripple.RippleNode commonRippleNode;
        InteractionSource interactionSource3;
        boolean z;
        float f;
        ColorProducer colorProducer;
        Function0 function0;
        int i2;
        androidx.compose.material.ripple.AndroidRippleNode androidRippleNode;
        InteractionSource interactionSource2;
        boolean z2;
        float f2;
        ColorProducer colorProducer2;
        Function0 function02;
        int i;
        if (Ripple_androidKt.IsRunningInPreview != null) {
            commonRippleNode = new CommonRippleNode(interactionSource, bounded, radius, color, rippleAlpha, 0);
        } else {
            androidRippleNode = new AndroidRippleNode(interactionSource, bounded, radius, color, rippleAlpha, 0);
            commonRippleNode = androidRippleNode;
        }
        return commonRippleNode;
    }

    private static final ViewGroup findNearestViewGroup(View initialView) {
        Object view;
        android.view.ViewParent parent;
        boolean z;
        int i = 0;
        view = initialView;
        while (!view instanceof ViewGroup) {
            parent = (View)view.getParent();
            view = parent;
        }
        return (ViewGroup)view;
    }
}
