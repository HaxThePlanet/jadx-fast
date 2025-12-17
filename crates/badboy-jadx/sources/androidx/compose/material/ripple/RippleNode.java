package androidx.compose.material.ripple;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.interaction.PressInteraction.Cancel;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.foundation.interaction.PressInteraction.Release;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008 \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J*\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H&ø\u0001\u0000¢\u0006\u0004\u0008.\u0010/J\u0010\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0008\u00102\u001a\u00020*H\u0016J\u001a\u00103\u001a\u00020*2\u0006\u0010-\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\u00085\u00106J\u0010\u00107\u001a\u00020*2\u0006\u0010+\u001a\u00020,H&J\u0018\u00108\u001a\u00020*2\u0006\u0010+\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u000c\u0010<\u001a\u00020**\u00020=H\u0016J\u000c\u0010>\u001a\u00020**\u00020?H&R\u0014\u0010\u0007\u001a\u00020\u0008X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017R\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eX\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\u00020\u001b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u001dR&\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008!\u0010\u001dR\u0014\u0010#\u001a\u00020\u0008X\u0086D¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0012R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006@", d2 = {"Landroidx/compose/material/ripple/RippleNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBounded", "()Z", "hasValidSize", "pendingInteractions", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/foundation/interaction/PressInteraction;", "F", "getRippleAlpha", "()Lkotlin/jvm/functions/Function0;", "rippleColor", "Landroidx/compose/ui/graphics/Color;", "getRippleColor-0d7_KjU", "()J", "<set-?>", "Landroidx/compose/ui/geometry/Size;", "rippleSize", "getRippleSize-NH-jbRc", "J", "shouldAutoInvalidate", "getShouldAutoInvalidate", "stateLayer", "Landroidx/compose/material/ripple/StateLayer;", "targetRadius", "", "addRipple", "", "interaction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "size", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "handlePressInteraction", "pressInteraction", "onAttach", "onRemeasured", "Landroidx/compose/ui/unit/IntSize;", "onRemeasured-ozmzZPI", "(J)V", "removeRipple", "updateStateLayer", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class RippleNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, DrawModifierNode, LayoutAwareModifierNode {

    public static final int $stable = 8;
    private final boolean bounded;
    private final ColorProducer color;
    private boolean hasValidSize;
    private final InteractionSource interactionSource;
    private final MutableObjectList<PressInteraction> pendingInteractions;
    private final float radius;
    private final Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha;
    private long rippleSize;
    private final boolean shouldAutoInvalidate;
    private androidx.compose.material.ripple.StateLayer stateLayer;
    private float targetRadius;
    static {
        final int i = 8;
    }

    private RippleNode(InteractionSource interactionSource, boolean bounded, float radius, ColorProducer color, Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        super();
        this.interactionSource = interactionSource;
        this.bounded = bounded;
        this.radius = radius;
        this.color = color;
        this.rippleAlpha = rippleAlpha;
        this.rippleSize = Size.Companion.getZero-NH-jbRc();
        int i = 0;
        MutableObjectList mutableObjectList = new MutableObjectList(0, 1, 0);
        this.pendingInteractions = mutableObjectList;
    }

    public RippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer4, Function0 function05, DefaultConstructorMarker defaultConstructorMarker6) {
        super(interactionSource, z2, f3, colorProducer4, function05);
    }

    public static final boolean access$getHasValidSize$p(androidx.compose.material.ripple.RippleNode $this) {
        return $this.hasValidSize;
    }

    public static final InteractionSource access$getInteractionSource$p(androidx.compose.material.ripple.RippleNode $this) {
        return $this.interactionSource;
    }

    public static final MutableObjectList access$getPendingInteractions$p(androidx.compose.material.ripple.RippleNode $this) {
        return $this.pendingInteractions;
    }

    public static final void access$handlePressInteraction(androidx.compose.material.ripple.RippleNode $this, PressInteraction pressInteraction) {
        $this.handlePressInteraction(pressInteraction);
    }

    public static final void access$updateStateLayer(androidx.compose.material.ripple.RippleNode $this, Interaction interaction, CoroutineScope scope) {
        $this.updateStateLayer(interaction, scope);
    }

    private final void handlePressInteraction(PressInteraction pressInteraction) {
        Object press;
        long rippleSize;
        float targetRadius;
        if (pressInteraction instanceof PressInteraction.Press) {
            addRipple-12SF9DM((PressInteraction.Press)pressInteraction, this.rippleSize, obj2);
        } else {
            if (pressInteraction instanceof PressInteraction.Release) {
                removeRipple((PressInteraction.Release)pressInteraction.getPress());
            } else {
                if (pressInteraction instanceof PressInteraction.Cancel) {
                    removeRipple((PressInteraction.Cancel)pressInteraction.getPress());
                }
            }
        }
    }

    private final void updateStateLayer(Interaction interaction, CoroutineScope scope) {
        androidx.compose.material.ripple.StateLayer stateLayer;
        androidx.compose.material.ripple.StateLayer stateLayer2;
        int i;
        Object obj;
        if (this.stateLayer == null) {
            stateLayer = new StateLayer(this.bounded, this.rippleAlpha);
            i = 0;
            DrawModifierNodeKt.invalidateDraw((DrawModifierNode)this);
            this.stateLayer = stateLayer;
        }
        stateLayer.handleInteraction$material_ripple_release(interaction, scope);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public abstract void addRipple-12SF9DM(PressInteraction.Press pressInteraction$Press, long l2, float f3);

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        int i;
        DrawScope drawScope;
        float targetRadius;
        long rippleColor-0d7_KjU;
        $this$draw.drawContent();
        androidx.compose.material.ripple.StateLayer stateLayer = this.stateLayer;
        if (stateLayer != null) {
            i = 0;
            stateLayer.drawStateLayer-mxwnekA((DrawScope)$this$draw, this.targetRadius, getRippleColor-0d7_KjU());
        }
        drawRipples((DrawScope)$this$draw);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public abstract void drawRipples(DrawScope drawScope);

    @Override // androidx.compose.ui.Modifier$Node
    protected final boolean getBounded() {
        return this.bounded;
    }

    protected final Function0<androidx.compose.material.ripple.RippleAlpha> getRippleAlpha() {
        return this.rippleAlpha;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final long getRippleColor-0d7_KjU() {
        return this.color.invoke-0d7_KjU();
    }

    @Override // androidx.compose.ui.Modifier$Node
    protected final long getRippleSize-NH-jbRc() {
        return this.rippleSize;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        final int i2 = 0;
        RippleNode.onAttach.1 anon = new RippleNode.onAttach.1(this, i2);
        BuildersKt.launch$default(getCoroutineScope(), 0, i2, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onRemeasured-ozmzZPI(long size) {
        float rippleEndRadius-cSwnlzA;
        long rippleSize;
        int i$iv;
        Object obj;
        int i;
        this.hasValidSize = true;
        this.rippleSize = IntSizeKt.toSize-ozmzZPI(size);
        Density density = requireDensity;
        int i3 = 0;
        rippleSize = 0;
        boolean naN = Float.isNaN(this.radius);
        if (naN) {
            rippleEndRadius-cSwnlzA = RippleAnimationKt.getRippleEndRadius-cSwnlzA(density, this.bounded, this.rippleSize);
        } else {
            rippleEndRadius-cSwnlzA = density.toPx-0680j_4(this.radius);
        }
        this.targetRadius = rippleEndRadius-cSwnlzA;
        MutableObjectList pendingInteractions = this.pendingInteractions;
        int i4 = 0;
        i$iv = 0;
        while (i$iv < pendingInteractions._size) {
            i = 0;
            handlePressInteraction((PressInteraction)pendingInteractions.content[i$iv]);
            i$iv++;
        }
        this.pendingInteractions.clear();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public abstract void removeRipple(PressInteraction.Press pressInteraction$Press);
}
