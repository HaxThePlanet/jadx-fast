package androidx.compose.animation;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bHÆ\u0003JK\u0010 \u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u000e\u0008\u0002\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u001c\u0008\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bHÆ\u0001J\u0008\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\u00072\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\u0008\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020(HÖ\u0001J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0002H\u0016J\u000c\u0010,\u001a\u00020**\u00020-H\u0016R%\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R \u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b¨\u0006.", d2 = {"Landroidx/compose/animation/RenderInTransitionOverlayNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/animation/RenderInTransitionOverlayNode;", "sharedTransitionScope", "Landroidx/compose/animation/SharedTransitionScopeImpl;", "renderInOverlay", "Lkotlin/Function0;", "", "zIndexInOverlay", "", "clipInOverlay", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/animation/SharedTransitionScopeImpl;Lkotlin/jvm/functions/Function0;FLkotlin/jvm/functions/Function2;)V", "getClipInOverlay", "()Lkotlin/jvm/functions/Function2;", "getRenderInOverlay", "()Lkotlin/jvm/functions/Function0;", "setRenderInOverlay", "(Lkotlin/jvm/functions/Function0;)V", "getSharedTransitionScope", "()Landroidx/compose/animation/SharedTransitionScopeImpl;", "setSharedTransitionScope", "(Landroidx/compose/animation/SharedTransitionScopeImpl;)V", "getZIndexInOverlay", "()F", "component1", "component2", "component3", "component4", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RenderInTransitionOverlayNodeElement extends ModifierNodeElement<androidx.compose.animation.RenderInTransitionOverlayNode> {

    public static final int $stable;
    private final Function2<LayoutDirection, Density, Path> clipInOverlay;
    private Function0<Boolean> renderInOverlay;
    private androidx.compose.animation.SharedTransitionScopeImpl sharedTransitionScope;
    private final float zIndexInOverlay;
    static {
    }

    public RenderInTransitionOverlayNodeElement(androidx.compose.animation.SharedTransitionScopeImpl sharedTransitionScope, Function0<Boolean> renderInOverlay, float zIndexInOverlay, Function2<? super LayoutDirection, ? super Density, ? extends Path> clipInOverlay) {
        super();
        this.sharedTransitionScope = sharedTransitionScope;
        this.renderInOverlay = renderInOverlay;
        this.zIndexInOverlay = zIndexInOverlay;
        this.clipInOverlay = clipInOverlay;
    }

    public static androidx.compose.animation.RenderInTransitionOverlayNodeElement copy$default(androidx.compose.animation.RenderInTransitionOverlayNodeElement renderInTransitionOverlayNodeElement, androidx.compose.animation.SharedTransitionScopeImpl sharedTransitionScopeImpl2, Function0 function03, float f4, Function2 function25, int i6, Object object7) {
        androidx.compose.animation.SharedTransitionScopeImpl obj1;
        Function0 obj2;
        float obj3;
        Function2 obj4;
        if (i6 & 1 != 0) {
            obj1 = renderInTransitionOverlayNodeElement.sharedTransitionScope;
        }
        if (i6 & 2 != 0) {
            obj2 = renderInTransitionOverlayNodeElement.renderInOverlay;
        }
        if (i6 & 4 != 0) {
            obj3 = renderInTransitionOverlayNodeElement.zIndexInOverlay;
        }
        if (i6 &= 8 != 0) {
            obj4 = renderInTransitionOverlayNodeElement.clipInOverlay;
        }
        return renderInTransitionOverlayNodeElement.copy(obj1, obj2, obj3, obj4);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.SharedTransitionScopeImpl component1() {
        return this.sharedTransitionScope;
    }

    public final Function0<Boolean> component2() {
        return this.renderInOverlay;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float component3() {
        return this.zIndexInOverlay;
    }

    public final Function2<LayoutDirection, Density, Path> component4() {
        return this.clipInOverlay;
    }

    public final androidx.compose.animation.RenderInTransitionOverlayNodeElement copy(androidx.compose.animation.SharedTransitionScopeImpl sharedTransitionScopeImpl, Function0<Boolean> function02, float f3, Function2<? super LayoutDirection, ? super Density, ? extends Path> function24) {
        RenderInTransitionOverlayNodeElement renderInTransitionOverlayNodeElement = new RenderInTransitionOverlayNodeElement(sharedTransitionScopeImpl, function02, f3, function24);
        return renderInTransitionOverlayNodeElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.animation.RenderInTransitionOverlayNode create() {
        RenderInTransitionOverlayNode renderInTransitionOverlayNode = new RenderInTransitionOverlayNode(this.sharedTransitionScope, this.renderInOverlay, this.zIndexInOverlay, this.clipInOverlay);
        return renderInTransitionOverlayNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        Function2 renderInOverlay;
        int i;
        int sharedTransitionScope;
        Function2 clipInOverlay;
        i = 0;
        if (other instanceof RenderInTransitionOverlayNodeElement) {
            if (Intrinsics.areEqual(this.sharedTransitionScope, obj.sharedTransitionScope) && this.renderInOverlay == obj2.renderInOverlay) {
                if (this.renderInOverlay == obj2.renderInOverlay) {
                    sharedTransitionScope = 1;
                    renderInOverlay = Float.compare(zIndexInOverlay, zIndexInOverlay2) == 0 ? sharedTransitionScope : i;
                    if (renderInOverlay != 0 && this.clipInOverlay == obj4.clipInOverlay) {
                        if (this.clipInOverlay == obj4.clipInOverlay) {
                            i = sharedTransitionScope;
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
        return i;
    }

    public final Function2<LayoutDirection, Density, Path> getClipInOverlay() {
        return this.clipInOverlay;
    }

    public final Function0<Boolean> getRenderInOverlay() {
        return this.renderInOverlay;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.animation.SharedTransitionScopeImpl getSharedTransitionScope() {
        return this.sharedTransitionScope;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getZIndexInOverlay() {
        return this.zIndexInOverlay;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i6 += i10;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("renderInSharedTransitionOverlay");
        $this$inspectableProperties.getProperties().set("sharedTransitionScope", this.sharedTransitionScope);
        $this$inspectableProperties.getProperties().set("renderInOverlay", this.renderInOverlay);
        $this$inspectableProperties.getProperties().set("zIndexInOverlay", Float.valueOf(this.zIndexInOverlay));
        $this$inspectableProperties.getProperties().set("clipInOverlayDuringTransition", this.clipInOverlay);
    }

    public final void setRenderInOverlay(Function0<Boolean> <set-?>) {
        this.renderInOverlay = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setSharedTransitionScope(androidx.compose.animation.SharedTransitionScopeImpl <set-?>) {
        this.sharedTransitionScope = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("RenderInTransitionOverlayNodeElement(sharedTransitionScope=").append(this.sharedTransitionScope).append(", renderInOverlay=").append(this.renderInOverlay).append(", zIndexInOverlay=").append(this.zIndexInOverlay).append(", clipInOverlay=").append(this.clipInOverlay).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.animation.RenderInTransitionOverlayNode node) {
        node.setSharedScope(this.sharedTransitionScope);
        node.setRenderInOverlay(this.renderInOverlay);
        node.setZIndexInOverlay(this.zIndexInOverlay);
        node.setClipInOverlay(this.clipInOverlay);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((RenderInTransitionOverlayNode)node);
    }
}
