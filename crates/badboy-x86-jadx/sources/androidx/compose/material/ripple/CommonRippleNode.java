package androidx.compose.material.ripple;

import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction.Press;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0002\u0010\rJ*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0008\u0010\u001b\u001a\u00020\u0013H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u000c\u0010\u001d\u001a\u00020\u0013*\u00020\u001eH\u0016R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001f", d2 = {"Landroidx/compose/material/ripple/CommonRippleNode;", "Landroidx/compose/material/ripple/RippleNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "ripples", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "Landroidx/compose/material/ripple/RippleAnimation;", "addRipple", "", "interaction", "size", "Landroidx/compose/ui/geometry/Size;", "targetRadius", "", "addRipple-12SF9DM", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;JF)V", "onDetach", "removeRipple", "drawRipples", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonRippleNode extends androidx.compose.material.ripple.RippleNode {

    public static final int $stable = 8;
    private final MutableScatterMap<PressInteraction.Press, androidx.compose.material.ripple.RippleAnimation> ripples;
    static {
        final int i = 8;
    }

    private CommonRippleNode(InteractionSource interactionSource, boolean bounded, float radius, ColorProducer color, Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        final Object obj = this;
        super(interactionSource, bounded, radius, color, rippleAlpha, 0);
        MutableScatterMap obj8 = new MutableScatterMap(0, 1, 0);
        obj.ripples = obj8;
    }

    public CommonRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer4, Function0 function05, DefaultConstructorMarker defaultConstructorMarker6) {
        super(interactionSource, z2, f3, colorProducer4, function05);
    }

    public static final MutableScatterMap access$getRipples$p(androidx.compose.material.ripple.CommonRippleNode $this) {
        return $this.ripples;
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void addRipple-12SF9DM(PressInteraction.Press interaction, long size, float targetRadius) {
        int ripples;
        int box-impl;
        int i;
        Object[] keys;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i2;
        int i3;
        MutableScatterMap this_$iv;
        int i4;
        long l;
        int i5;
        Object obj;
        final Object obj2 = this;
        final Object obj3 = interaction;
        ripples = obj2.ripples;
        Object[] values = ripples.values;
        int i13 = 0;
        long[] metadata = map.metadata;
        length += -2;
        if (0 <= i15) {
        } else {
            this_$iv = ripples;
            i4 = i;
        }
        int i12 = 0;
        if (obj2.getBounded()) {
            box-impl = Offset.box-impl(obj3.getPressPosition-F1C5BW0());
        } else {
            box-impl = i12;
        }
        RippleAnimation rippleAnimation = new RippleAnimation(box-impl, obj25, obj2.getBounded(), i12);
        obj2.ripples.set(obj3, rippleAnimation);
        CommonRippleNode.addRipple.2 anon = new CommonRippleNode.addRipple.2(rippleAnimation, obj2, obj3, i12);
        BuildersKt.launch$default(obj2.getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
        DrawModifierNodeKt.invalidateDraw((DrawModifierNode)obj2);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void drawRipples(DrawScope $this$drawRipples) {
        int i9;
        Object obj3;
        long[] m$iv$iv;
        int i4;
        DrawScope alpha2;
        float pressedAlpha;
        DrawScope alpha;
        int i$iv$iv;
        int slot$iv$iv2;
        int $this$drawRipples_u24lambda_u242_u24lambda_u241;
        float f;
        int i8;
        int lastIndex$iv$iv;
        int i7;
        int i11;
        MutableScatterMap map2;
        int i13;
        Object[] keys;
        Object[] values;
        MutableScatterMap map;
        int i3;
        int cmp;
        long slot$iv$iv;
        int i;
        int i14;
        Object obj2;
        int i5;
        int i15;
        long[] m$iv$iv2;
        int lastIndex$iv$iv2;
        int i12;
        int i2;
        Object obj;
        int i10;
        int i6;
        pressedAlpha = (RippleAlpha)getRippleAlpha().invoke().getPressedAlpha();
        i9 = Float.compare(pressedAlpha, i16) == 0 ? 1 : 0;
        if (i9 == 0) {
            obj3 = this;
            map2 = ripples;
            i13 = 0;
            i3 = 0;
            m$iv$iv = map.metadata;
            length += -2;
            if (0 <= i4) {
            } else {
                m$iv$iv2 = m$iv$iv;
                lastIndex$iv$iv = i4;
                f = pressedAlpha;
                alpha2 = $this$drawRipples;
            }
        } else {
            obj3 = this;
            f = pressedAlpha;
            alpha2 = $this$drawRipples;
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void onDetach() {
        this.ripples.clear();
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void removeRipple(PressInteraction.Press interaction) {
        Object obj = this.ripples.get(interaction);
        if ((RippleAnimation)obj != null) {
            (RippleAnimation)obj.finish();
        }
    }
}
