package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007Je\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0014\u0008\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u001b\u0008\u0002\u0010$\u001a\u0015\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%¢\u0006\u0002\u0008(2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\u0008(H\u0096\u0001JH\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\u0014\u0008\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00190\"2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\u0008(H\u0096\u0001J(\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0016ø\u0001\u0000¢\u0006\u0004\u0008/\u00100J\u0017\u00101\u001a\u00020\u0019*\u000202H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00083\u00104J\u0017\u00101\u001a\u00020\u0019*\u000205H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u00086\u00107J\u0016\u00108\u001a\u000202*\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\u00089\u0010:J\u0019\u00108\u001a\u000202*\u00020\tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J\u0019\u00108\u001a\u000202*\u00020\u0019H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008;\u0010=J\u0016\u0010>\u001a\u00020?*\u00020@H\u0016ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJ\u0017\u0010C\u001a\u00020\t*\u000202H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008D\u0010<J\u0017\u0010C\u001a\u00020\t*\u000205H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\u0008E\u0010:J\r\u0010F\u001a\u00020G*\u00020HH\u0097\u0001J\u0016\u0010I\u001a\u00020@*\u00020?H\u0016ø\u0001\u0000¢\u0006\u0004\u0008J\u0010BJ\u0016\u0010K\u001a\u000205*\u000202H\u0016ø\u0001\u0000¢\u0006\u0004\u0008L\u0010MJ\u0019\u0010K\u001a\u000205*\u00020\tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008N\u0010MJ\u0019\u0010K\u001a\u000205*\u00020\u0019H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008N\u0010OR\u0014\u0010\u0008\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u000c\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u0018j\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a`\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006P", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "placeablesCache", "Ljava/util/HashMap;", "", "", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/collections/HashMap;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutMeasureScopeImpl implements androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, MeasureScope {

    public static final int $stable;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory itemContentFactory;
    private final androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider itemProvider;
    private final HashMap<Integer, List<Placeable>> placeablesCache;
    private final SubcomposeMeasureScope subcomposeMeasureScope;
    static {
    }

    public LazyLayoutMeasureScopeImpl(androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory itemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        super();
        this.itemContentFactory = itemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.itemProvider = (LazyLayoutItemProvider)this.itemContentFactory.getItemProvider().invoke();
        HashMap hashMap = new HashMap();
        this.placeablesCache = hashMap;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map3, Function1<? super Placeable.PlacementScope, Unit> function14) {
        return this.subcomposeMeasureScope.layout(i, i2, map3, function14);
    }

    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map3, Function1<? super RulerScope, Unit> function14, Function1<? super Placeable.PlacementScope, Unit> function15) {
        return this.subcomposeMeasureScope.layout(i, i2, map3, function14, function15);
    }

    public List<Placeable> measure-0kLqBqw(int index, long constraints) {
        Object valueOf;
        Object contentType;
        kotlin.jvm.functions.Function2 content;
        List subcompose;
        ArrayList list;
        Object arrayList;
        int i2;
        int i;
        Integer i3;
        HashMap placeablesCache;
        Object obj;
        Object obj2 = this.placeablesCache.get(Integer.valueOf(index));
        if ((List)obj2 != null) {
            arrayList = obj2;
        } else {
            valueOf = this.itemProvider.getKey(index);
            subcompose = this.subcomposeMeasureScope.subcompose(valueOf, this.itemContentFactory.getContent(index, valueOf, this.itemProvider.getContentType(index)));
            int size = subcompose.size();
            arrayList = new ArrayList(size);
            i = 0;
            while (i < size) {
                placeablesCache = 0;
                arrayList.add((Measurable)subcompose.get(i).measure-BRTryo0(constraints));
                i++;
            }
            i2 = 0;
            (Map)this.placeablesCache.put(Integer.valueOf(index), (List)arrayList);
        }
        return arrayList;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public int roundToPx--R2X_6o(long l) {
        return this.subcomposeMeasureScope.roundToPx--R2X_6o(l);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public int roundToPx-0680j_4(float f) {
        return this.subcomposeMeasureScope.roundToPx-0680j_4(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public float toDp-GaN1DYA(long $this$toDp_u2dGaN1DYA) {
        final int i = 0;
        return this.subcomposeMeasureScope.toDp-GaN1DYA($this$toDp_u2dGaN1DYA);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public float toDp-u2uoSUM(float $this$toDp_u2du2uoSUM) {
        final int i = 0;
        return this.subcomposeMeasureScope.toDp-u2uoSUM($this$toDp_u2du2uoSUM);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public float toDp-u2uoSUM(int $this$toDp_u2du2uoSUM) {
        final int i = 0;
        return this.subcomposeMeasureScope.toDp-u2uoSUM($this$toDp_u2du2uoSUM);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public long toDpSize-k-rfVVM(long $this$toDpSize_u2dk_u2drfVVM) {
        final int i = 0;
        return this.subcomposeMeasureScope.toDpSize-k-rfVVM($this$toDpSize_u2dk_u2drfVVM);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public float toPx--R2X_6o(long l) {
        return this.subcomposeMeasureScope.toPx--R2X_6o(l);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public float toPx-0680j_4(float f) {
        return this.subcomposeMeasureScope.toPx-0680j_4(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public Rect toRect(DpRect dpRect) {
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public long toSize-XkaWNTQ(long $this$toSize_u2dXkaWNTQ) {
        final int i = 0;
        return this.subcomposeMeasureScope.toSize-XkaWNTQ($this$toSize_u2dXkaWNTQ);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public long toSp-0xMU5do(float $this$toSp_u2d0xMU5do) {
        final int i = 0;
        return this.subcomposeMeasureScope.toSp-0xMU5do($this$toSp_u2d0xMU5do);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public long toSp-kPz2Gy4(float $this$toSp_u2dkPz2Gy4) {
        final int i = 0;
        return this.subcomposeMeasureScope.toSp-kPz2Gy4($this$toSp_u2dkPz2Gy4);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    public long toSp-kPz2Gy4(int $this$toSp_u2dkPz2Gy4) {
        final int i = 0;
        return this.subcomposeMeasureScope.toSp-kPz2Gy4($this$toSp_u2dkPz2Gy4);
    }
}
