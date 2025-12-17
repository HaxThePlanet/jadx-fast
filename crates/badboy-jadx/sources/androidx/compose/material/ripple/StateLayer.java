package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction.Cancel;
import androidx.compose.foundation.interaction.DragInteraction.Stop;
import androidx.compose.foundation.interaction.FocusInteraction.Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction.Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008\u0015J$\u0010\u0016\u001a\u00020\u0011*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/material/ripple/StateLayer;", "", "bounded", "", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(ZLkotlin/jvm/functions/Function0;)V", "animatedAlpha", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "currentInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "", "handleInteraction", "", "interaction", "scope", "Lkotlinx/coroutines/CoroutineScope;", "handleInteraction$material_ripple_release", "drawStateLayer", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "radius", "color", "Landroidx/compose/ui/graphics/Color;", "drawStateLayer-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJ)V", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StateLayer {

    private final Animatable<Float, AnimationVector1D> animatedAlpha;
    private final boolean bounded;
    private Interaction currentInteraction;
    private final List<Interaction> interactions;
    private final Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha;
    public StateLayer(boolean bounded, Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        super();
        this.bounded = bounded;
        this.rippleAlpha = rippleAlpha;
        final int i3 = 0;
        this.animatedAlpha = AnimatableKt.Animatable$default(i3, i3, 2, 0);
        ArrayList arrayList = new ArrayList();
        this.interactions = (List)arrayList;
    }

    public static final Animatable access$getAnimatedAlpha$p(androidx.compose.material.ripple.StateLayer $this) {
        return $this.animatedAlpha;
    }

    public final void drawStateLayer-mxwnekA(DrawScope $this$drawStateLayer_u2dmxwnekA, float radius, long color) {
        Object obj;
        int bounded;
        int i7;
        long l2;
        int $this$clipRect_rOu3jXo_u24lambda_u244$iv;
        int i5;
        int i6;
        int width-impl;
        int height-impl;
        DrawContext i4;
        long copy-wmQWz5c$default;
        float $this$withTransform_u24lambda_u246$iv$iv;
        int previousSize$iv$iv2;
        int previousSize$iv$iv3;
        int previousSize$iv$iv5;
        int previousSize$iv$iv4;
        int i9;
        int i10;
        int i3;
        int i2;
        int i;
        int i8;
        int previousSize$iv$iv;
        DrawContext context;
        long l;
        obj = this;
        final float floatValue = (Number)obj.animatedAlpha.getValue().floatValue();
        if (Float.compare(floatValue, i11) > 0) {
            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(color, obj3, floatValue, 0, 0, 0, 14);
            if (obj.bounded) {
                bounded = $this$drawStateLayer_u2dmxwnekA;
                int intersect-rtfAjoo = ClipOp.Companion.getIntersect-rtfAjoo();
                i7 = 0;
                l2 = bounded;
                i2 = 0;
                DrawContext drawContext = l2.getDrawContext();
                i = 0;
                drawContext.getCanvas().save();
                int i12 = 0;
                drawContext.getTransform().clipRect-N_I0leg(0, 0, Size.getWidth-impl(bounded.getSize-NH-jbRc()), Size.getHeight-impl(bounded.getSize-NH-jbRc()), intersect-rtfAjoo);
                $this$clipRect_rOu3jXo_u24lambda_u244$iv = intersect-rtfAjoo;
                i8 = 0;
                previousSize$iv$iv = bounded;
                context = drawContext;
                DrawScope.drawCircle-VaOC9Bg$default(l2, copy-wmQWz5c$default, obj12, radius, 0, obj15, 0, 0, 0, 0);
                context.getCanvas().restore();
                context.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
            } else {
                DrawScope.drawCircle-VaOC9Bg$default($this$drawStateLayer_u2dmxwnekA, copy-wmQWz5c$default, obj12, radius, 0, obj15, 0, 0, 0, 0);
            }
        }
    }

    public final void handleInteraction$material_ripple_release(Interaction interaction, CoroutineScope scope) {
        List interactions;
        Object enter;
        boolean equal;
        Object invoke;
        androidx.compose.material.ripple.StateLayer.handleInteraction.2 hoveredAlpha;
        androidx.compose.animation.core.AnimationSpec animationSpec;
        androidx.compose.material.ripple.StateLayer.handleInteraction.1 anon3;
        CoroutineScope coroutineScope;
        int i2;
        int i5;
        androidx.compose.material.ripple.StateLayer.handleInteraction.1 anon;
        int i;
        int i3;
        CoroutineScope coroutineScope2;
        int i4;
        int i7;
        androidx.compose.material.ripple.StateLayer.handleInteraction.2 anon2;
        int i6;
        int i8;
        final Object obj = this;
        final Object obj2 = interaction;
        if (obj2 instanceof HoverInteraction.Enter) {
            obj.interactions.add(obj2);
            Object lastOrNull = CollectionsKt.lastOrNull(obj.interactions);
            if (!Intrinsics.areEqual(obj.currentInteraction, (Interaction)lastOrNull)) {
                equal = 0;
                if (lastOrNull != null) {
                    invoke = obj.rippleAlpha.invoke();
                    if (obj2 instanceof HoverInteraction.Enter) {
                        hoveredAlpha = (RippleAlpha)invoke.getHoveredAlpha();
                    } else {
                        if (obj2 instanceof FocusInteraction.Focus) {
                            hoveredAlpha = invoke.getFocusedAlpha();
                        } else {
                            if (obj2 instanceof DragInteraction.Start) {
                                hoveredAlpha = invoke.getDraggedAlpha();
                            } else {
                                hoveredAlpha = 0;
                            }
                        }
                    }
                    anon3 = new StateLayer.handleInteraction.1(obj, hoveredAlpha, RippleKt.access$incomingStateLayerAnimationSpecFor(lastOrNull), equal);
                    BuildersKt.launch$default(scope, 0, 0, (Function2)anon3, 3, 0);
                } else {
                    hoveredAlpha = new StateLayer.handleInteraction.2(obj, RippleKt.access$outgoingStateLayerAnimationSpecFor(obj.currentInteraction), equal);
                    BuildersKt.launch$default(scope, 0, 0, (Function2)hoveredAlpha, 3, 0);
                }
                obj.currentInteraction = lastOrNull;
            }
        } else {
            if (obj2 instanceof HoverInteraction.Exit) {
                obj.interactions.remove((HoverInteraction.Exit)obj2.getEnter());
            } else {
                if (obj2 instanceof FocusInteraction.Focus) {
                    obj.interactions.add(obj2);
                } else {
                    if (obj2 instanceof FocusInteraction.Unfocus) {
                        obj.interactions.remove((FocusInteraction.Unfocus)obj2.getFocus());
                    } else {
                        if (obj2 instanceof DragInteraction.Start) {
                            obj.interactions.add(obj2);
                        } else {
                            if (obj2 instanceof DragInteraction.Stop) {
                                obj.interactions.remove((DragInteraction.Stop)obj2.getStart());
                            } else {
                                if (obj2 instanceof DragInteraction.Cancel) {
                                    obj.interactions.remove((DragInteraction.Cancel)obj2.getStart());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
