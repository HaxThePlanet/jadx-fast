package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BN\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0010\u000fJ\u0008\u0010!\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\u00020\t2\u0008\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\u0008\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u000c\u0010)\u001a\u00020\r*\u00020\u000cH\u0016R\"\u0010\u0007\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0011\"\u0004\u0008\u0016\u0010\u0013R\"\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\u0008\u001d\u0010\u0011\"\u0004\u0008\u001e\u0010\u0013R\"\u0010\u0005\u001a\u00020\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\u0008\u001f\u0010\u0011\"\u0004\u0008 \u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006*", d2 = {"Landroidx/compose/foundation/layout/PaddingElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/PaddingNode;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "setBottom-0680j_4", "(F)V", "F", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "getStart-D9Ej5fM", "setStart-0680j_4", "getTop-D9Ej5fM", "setTop-0680j_4", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PaddingElement extends ModifierNodeElement<androidx.compose.foundation.layout.PaddingNode> {

    private float bottom;
    private float end;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private boolean rtlAware;
    private float start;
    private float top;
    private PaddingElement(float start, float top, float end, float bottom, boolean rtlAware, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        int i;
        int cmp;
        int unspecified-D9Ej5fM2;
        float unspecified-D9Ej5fM;
        super();
        this.start = start;
        this.top = top;
        this.end = end;
        this.bottom = bottom;
        this.rtlAware = rtlAware;
        this.inspectorInfo = inspectorInfo;
        unspecified-D9Ej5fM2 = 0;
        if (Float.compare(start2, unspecified-D9Ej5fM2) < 0) {
            if (Dp.equals-impl0(this.start, Dp.Companion.getUnspecified-D9Ej5fM())) {
                if (Float.compare(top2, unspecified-D9Ej5fM2) < 0) {
                    if (Dp.equals-impl0(this.top, Dp.Companion.getUnspecified-D9Ej5fM())) {
                        if (Float.compare(end2, unspecified-D9Ej5fM2) < 0) {
                            if (Dp.equals-impl0(this.end, Dp.Companion.getUnspecified-D9Ej5fM())) {
                                if (Float.compare(bottom2, unspecified-D9Ej5fM2) < 0) {
                                    if (Dp.equals-impl0(this.bottom, Dp.Companion.getUnspecified-D9Ej5fM())) {
                                        i = 1;
                                    } else {
                                        i = 0;
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
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException $i$a$RequirePaddingElement$1 = new IllegalArgumentException("Padding must be non-negative".toString());
        throw $i$a$RequirePaddingElement$1;
    }

    public PaddingElement(float f, float f2, float f3, float f4, boolean z5, Function1 function16, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int i;
        float f6;
        float f8;
        float f7;
        float f5;
        float obj9;
        float obj10;
        float obj11;
        float obj12;
        if (i7 & 1 != 0) {
            i = 0;
            f6 = obj9;
        } else {
            f6 = f;
        }
        if (i7 & 2 != 0) {
            obj10 = 0;
            f8 = obj10;
        } else {
            f8 = f2;
        }
        if (i7 & 4 != 0) {
            obj10 = 0;
            f7 = obj11;
        } else {
            f7 = f3;
        }
        if (i7 & 8 != 0) {
            obj10 = 0;
            f5 = obj12;
        } else {
            f5 = f4;
        }
        super(f6, f8, f7, f5, z5, function16, 0);
    }

    public PaddingElement(float f, float f2, float f3, float f4, boolean z5, Function1 function16, DefaultConstructorMarker defaultConstructorMarker7) {
        super(f, f2, f3, f4, z5, function16);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.PaddingNode create() {
        PaddingNode paddingNode = new PaddingNode(this.start, this.top, this.end, this.bottom, this.rtlAware, 0);
        return paddingNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i2;
        int i;
        boolean rtlAware;
        float rtlAware2;
        if (other instanceof PaddingElement) {
            i2 = other;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            return 0;
        }
        if (Dp.equals-impl0(this.start, i2.start) && Dp.equals-impl0(this.top, i2.top) && Dp.equals-impl0(this.end, i2.end) && Dp.equals-impl0(this.bottom, i2.bottom) && this.rtlAware == i2.rtlAware) {
            if (Dp.equals-impl0(this.top, i2.top)) {
                if (Dp.equals-impl0(this.end, i2.end)) {
                    if (Dp.equals-impl0(this.bottom, i2.bottom)) {
                        if (this.rtlAware == i2.rtlAware) {
                            i = 1;
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

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getBottom-D9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getEnd-D9Ej5fM() {
        return this.end;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getStart-D9Ej5fM() {
        return this.start;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getTop-D9Ej5fM() {
        return this.top;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return result2 += i10;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setBottom-0680j_4(float <set-?>) {
        this.bottom = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setEnd-0680j_4(float <set-?>) {
        this.end = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setRtlAware(boolean <set-?>) {
        this.rtlAware = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setStart-0680j_4(float <set-?>) {
        this.start = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void setTop-0680j_4(float <set-?>) {
        this.top = <set-?>;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.PaddingNode node) {
        node.setStart-0680j_4(this.start);
        node.setTop-0680j_4(this.top);
        node.setEnd-0680j_4(this.end);
        node.setBottom-0680j_4(this.bottom);
        node.setRtlAware(this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((PaddingNode)node);
    }
}
