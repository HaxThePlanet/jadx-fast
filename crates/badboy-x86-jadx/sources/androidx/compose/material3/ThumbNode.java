package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Constraints.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006&", d2 = {"Landroidx/compose/material3/ThumbNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "getChecked", "()Z", "setChecked", "(Z)V", "initialOffset", "", "initialSize", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isPressed", "offsetAnim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "sizeAnim", "onAttach", "", "update", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {

    private boolean checked;
    private float initialOffset = NaNf;
    private float initialSize = NaNf;
    private InteractionSource interactionSource;
    private boolean isPressed;
    private Animatable<Float, AnimationVector1D> offsetAnim;
    private Animatable<Float, AnimationVector1D> sizeAnim;
    public ThumbNode(InteractionSource interactionSource, boolean checked) {
        super();
        this.interactionSource = interactionSource;
        this.checked = checked;
        final int i = 2143289344;
    }

    public static final Animatable access$getOffsetAnim$p(androidx.compose.material3.ThumbNode $this) {
        return $this.offsetAnim;
    }

    public static final Animatable access$getSizeAnim$p(androidx.compose.material3.ThumbNode $this) {
        return $this.sizeAnim;
    }

    public static final boolean access$isPressed$p(androidx.compose.material3.ThumbNode $this) {
        return $this.isPressed;
    }

    public static final void access$setPressed$p(androidx.compose.material3.ThumbNode $this, boolean <set-?>) {
        $this.isPressed = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getChecked() {
        return this.checked;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean getShouldAutoInvalidate() {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int maxIntrinsicHeight;
        int i5;
        boolean isPressed;
        float uncheckedThumbDiameter;
        float floatValue;
        boolean isPressed3;
        boolean isPressed2;
        int px-0680j_4;
        int targetValue2;
        boolean equal;
        int targetValue;
        boolean equal2;
        boolean naN;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i3;
        int i4;
        androidx.compose.material3.ThumbNode.measure.1 anon;
        int i;
        int i2;
        final Object obj = this;
        final MeasureScope measureScope = $this$measure_u2d3p2s80s;
        final Object obj2 = measurable;
        if (obj2.maxIntrinsicHeight(Constraints.getMaxWidth-impl(constraints)) != 0 && obj2.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraints)) != 0) {
            i5 = obj2.maxIntrinsicWidth(Constraints.getMaxHeight-impl(constraints)) != 0 ? 1 : 0;
        } else {
        }
        if (obj.isPressed) {
            uncheckedThumbDiameter = SwitchTokens.INSTANCE.getPressedHandleWidth-D9Ej5fM();
        } else {
            if (i5 == 0) {
                if (obj.checked) {
                    uncheckedThumbDiameter = SwitchKt.getThumbDiameter();
                } else {
                    uncheckedThumbDiameter = SwitchKt.getUncheckedThumbDiameter();
                }
            } else {
            }
        }
        final float f4 = px-0680j_42;
        Animatable sizeAnim = obj.sizeAnim;
        if (sizeAnim != null) {
            floatValue = (Number)sizeAnim.getValue().floatValue();
        } else {
            floatValue = f4;
        }
        int i6 = (int)floatValue;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        final float px-0680j_45 = measureScope.toPx-0680j_4(Dp.constructor-impl(arg0$iv3 - f3));
        if (obj.isPressed && obj.checked) {
            if (obj.checked) {
                px-0680j_4 = px-0680j_45 - px-0680j_43;
            } else {
                if (obj.isPressed && !obj.checked) {
                    if (!obj.checked) {
                        px-0680j_4 = measureScope.toPx-0680j_4(SwitchTokens.INSTANCE.getTrackOutlineWidth-D9Ej5fM());
                    } else {
                        px-0680j_4 = obj.checked ? px-0680j_45 : px-0680j_44;
                    }
                } else {
                }
            }
        } else {
        }
        Animatable sizeAnim2 = obj.sizeAnim;
        int i12 = 0;
        if (sizeAnim2 != null) {
            targetValue2 = sizeAnim2.getTargetValue();
        } else {
            targetValue2 = i12;
        }
        if (!Intrinsics.areEqual(targetValue2, f4)) {
            equal = new ThumbNode.measure.1(obj, f4, i12);
            BuildersKt.launch$default(obj.getCoroutineScope(), 0, 0, (Function2)equal, 3, 0);
        }
        Animatable offsetAnim = obj.offsetAnim;
        if (offsetAnim != null) {
            targetValue = offsetAnim.getTargetValue();
        } else {
            targetValue = i12;
        }
        if (!Intrinsics.areEqual(targetValue, px-0680j_4)) {
            equal2 = new ThumbNode.measure.2(obj, px-0680j_4, i12);
            BuildersKt.launch$default(obj.getCoroutineScope(), 0, 0, (Function2)equal2, 3, 0);
        }
        if (Float.isNaN(obj.initialSize) && Float.isNaN(obj.initialOffset)) {
            if (Float.isNaN(obj.initialOffset)) {
                obj.initialSize = f4;
                obj.initialOffset = px-0680j_4;
            }
        }
        ThumbNode.measure.3 anon2 = new ThumbNode.measure.3(obj2.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo(i6, i6)), obj, px-0680j_4);
        int i20 = px-0680j_4;
        return MeasureScope.layout$default(measureScope, i6, i6, 0, (Function1)anon2, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        final int i2 = 0;
        ThumbNode.onAttach.1 anon = new ThumbNode.onAttach.1(this, i2);
        BuildersKt.launch$default(getCoroutineScope(), 0, i2, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setChecked(boolean <set-?>) {
        this.checked = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setInteractionSource(InteractionSource <set-?>) {
        this.interactionSource = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void update() {
        Animatable sizeAnim;
        Animatable offsetAnim;
        final int i = 0;
        final int i2 = 2;
        final int i3 = 0;
        if (this.sizeAnim == null && !Float.isNaN(this.initialSize)) {
            if (!Float.isNaN(this.initialSize)) {
                this.sizeAnim = AnimatableKt.Animatable$default(this.initialSize, i3, i2, i);
            }
        }
        if (this.offsetAnim == null && !Float.isNaN(this.initialOffset)) {
            if (!Float.isNaN(this.initialOffset)) {
                this.offsetAnim = AnimatableKt.Animatable$default(this.initialOffset, i3, i2, i);
            }
        }
    }
}
