package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ&\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R&\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006(", d2 = {"Landroidx/compose/material3/TabIndicatorOffsetNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "tabPositionsState", "Landroidx/compose/runtime/State;", "", "Landroidx/compose/material3/TabPosition;", "selectedTabIndex", "", "followContentSize", "", "(Landroidx/compose/runtime/State;IZ)V", "getFollowContentSize", "()Z", "setFollowContentSize", "(Z)V", "initialOffset", "Landroidx/compose/ui/unit/Dp;", "initialWidth", "offsetAnimatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getSelectedTabIndex", "()I", "setSelectedTabIndex", "(I)V", "getTabPositionsState", "()Landroidx/compose/runtime/State;", "setTabPositionsState", "(Landroidx/compose/runtime/State;)V", "widthAnimatable", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TabIndicatorOffsetNode extends Modifier.Node implements LayoutModifierNode {

    public static final int $stable = 8;
    private boolean followContentSize;
    private Dp initialOffset;
    private Dp initialWidth;
    private Animatable<Dp, AnimationVector1D> offsetAnimatable;
    private int selectedTabIndex;
    private State<? extends List<androidx.compose.material3.TabPosition>> tabPositionsState;
    private Animatable<Dp, AnimationVector1D> widthAnimatable;
    static {
        final int i = 8;
    }

    public TabIndicatorOffsetNode(State<? extends List<androidx.compose.material3.TabPosition>> tabPositionsState, int selectedTabIndex, boolean followContentSize) {
        super();
        this.tabPositionsState = tabPositionsState;
        this.selectedTabIndex = selectedTabIndex;
        this.followContentSize = followContentSize;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final boolean getFollowContentSize() {
        return this.followContentSize;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final State<List<androidx.compose.material3.TabPosition>> getTabPositionsState() {
        return this.tabPositionsState;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        float contentWidth-D9Ej5fM;
        Object widthAnimatable;
        Object offsetAnimatable;
        float unbox-impl2;
        float unbox-impl;
        int selectedTabIndex;
        boolean anon;
        boolean selectedTabIndex2;
        Object coroutineScope2;
        Dp coroutineScope;
        androidx.compose.animation.core.TwoWayConverter vectorConverter;
        int vectorConverter2;
        int i3;
        int i;
        int i2;
        int i4;
        final Object obj = this;
        if ((List)obj.tabPositionsState.getValue().isEmpty()) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, 0, 0, 0, (Function1)TabIndicatorOffsetNode.measure.1.INSTANCE, 4, 0);
        }
        MeasureScope measureScope2 = $this$measure_u2d3p2s80s;
        if (obj.followContentSize) {
            contentWidth-D9Ej5fM = (TabPosition)(List)obj.tabPositionsState.getValue().get(obj.selectedTabIndex).getContentWidth-D9Ej5fM();
        } else {
            contentWidth-D9Ej5fM = (TabPosition)(List)obj.tabPositionsState.getValue().get(obj.selectedTabIndex).getWidth-D9Ej5fM();
        }
        final float f = contentWidth-D9Ej5fM;
        int i7 = 0;
        if (obj.initialWidth != null) {
            if (obj.widthAnimatable == null) {
                coroutineScope = obj.initialWidth;
                Intrinsics.checkNotNull(coroutineScope);
                coroutineScope2 = new Animatable(coroutineScope, VectorConvertersKt.getVectorConverter(Dp.Companion), 0, 0, 12, 0);
                anon = 0;
                obj.widthAnimatable = coroutineScope2;
            }
            if (!Dp.equals-impl0(f, (Dp)widthAnimatable.getTargetValue().unbox-impl())) {
                anon = new TabIndicatorOffsetNode.measure.2(widthAnimatable, f, i7);
                BuildersKt.launch$default(obj.getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
            }
        } else {
            obj.initialWidth = Dp.box-impl(f);
        }
        float left-D9Ej5fM = (TabPosition)(List)obj.tabPositionsState.getValue().get(obj.selectedTabIndex).getLeft-D9Ej5fM();
        if (obj.initialOffset != null) {
            if (obj.offsetAnimatable == null) {
                vectorConverter = obj.initialOffset;
                Intrinsics.checkNotNull(vectorConverter);
                coroutineScope = new Animatable(vectorConverter, VectorConvertersKt.getVectorConverter(Dp.Companion), 0, 0, 12, 0);
                selectedTabIndex2 = 0;
                obj.offsetAnimatable = coroutineScope;
            }
            if (!Dp.equals-impl0(left-D9Ej5fM, (Dp)offsetAnimatable.getTargetValue().unbox-impl())) {
                selectedTabIndex2 = new TabIndicatorOffsetNode.measure.3(offsetAnimatable, left-D9Ej5fM, i7);
                BuildersKt.launch$default(obj.getCoroutineScope(), 0, 0, (Function2)selectedTabIndex2, 3, 0);
            }
        } else {
            obj.initialOffset = Dp.box-impl(left-D9Ej5fM);
        }
        Animatable offsetAnimatable2 = obj.offsetAnimatable;
        if (offsetAnimatable2 != null) {
            unbox-impl2 = (Dp)offsetAnimatable2.getValue().unbox-impl();
        } else {
            unbox-impl2 = left-D9Ej5fM;
        }
        Animatable widthAnimatable2 = obj.widthAnimatable;
        if (widthAnimatable2 != null) {
            unbox-impl = (Dp)widthAnimatable2.getValue().unbox-impl();
        } else {
            unbox-impl = f;
        }
        float f3 = unbox-impl;
        Placeable placeable = measure-BRTryo0;
        TabIndicatorOffsetNode.measure.4 anon2 = new TabIndicatorOffsetNode.measure.4(placeable, measureScope2, unbox-impl2);
        return MeasureScope.layout$default(measureScope2, placeable.getWidth(), placeable.getHeight(), 0, (Function1)anon2, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setFollowContentSize(boolean <set-?>) {
        this.followContentSize = <set-?>;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setSelectedTabIndex(int <set-?>) {
        this.selectedTabIndex = <set-?>;
    }

    public final void setTabPositionsState(State<? extends List<androidx.compose.material3.TabPosition>> <set-?>) {
        this.tabPositionsState = <set-?>;
    }
}
