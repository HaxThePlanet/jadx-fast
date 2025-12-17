package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement.Horizontal;
import androidx.compose.foundation.layout.Arrangement.Vertical;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a~\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u001a\u001a&\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001dH\u0002\u001a%\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\tH\u0003¢\u0006\u0002\u0010#\u001a%\u0010$\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0008\u001a\u00020\tH\u0003¢\u0006\u0002\u0010%\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010'*\u00020\u00152\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H'0(2%\u0008\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\u0008\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\u0008\u00162%\u0008\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\u0008\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\u00085¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u00106\u001aÛ\u0001\u0010&\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010'*\u00020\u00152\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H'0\u001c2%\u0008\n\u0010)\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020-\u0018\u00010\u001420\u0008\n\u0010.\u001a*\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u000201\u0018\u00010/¢\u0006\u0002\u0008\u00162%\u0008\n\u00102\u001a\u001f\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0006\u0012\u0004\u0018\u00010-0\u001423\u0008\u0004\u00103\u001a-\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020\u00010/¢\u0006\u0002\u00085¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u00107\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010'*\u00020\u00152\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H'0(2:\u0008\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\u0008\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\u0008\u00162:\u0008\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\u0008\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\u00085¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u0010;\u001a¯\u0002\u00108\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010'*\u00020\u00152\u000c\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H'0\u001c2:\u0008\n\u0010)\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020-\u0018\u00010/2E\u0008\n\u0010.\u001a?\u0012\u0004\u0012\u000200\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u000201\u0018\u00010:¢\u0006\u0002\u0008\u00162:\u0008\u0006\u00102\u001a4\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0006\u0012\u0004\u0018\u00010-0/2H\u0008\u0004\u00103\u001aB\u0012\u0004\u0012\u000204\u0012\u0013\u0012\u00110\u001d¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H'¢\u0006\u000c\u0008*\u0012\u0008\u0008+\u0012\u0004\u0008\u0008(,\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\u00085¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u0010<¨\u0006=", d2 = {"LazyHorizontalGrid", "", "rows", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalGrid", "columns", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyGridDslKt {
    public static final void LazyHorizontalGrid(androidx.compose.foundation.lazy.grid.GridCells rows, Modifier modifier, androidx.compose.foundation.lazy.grid.LazyGridState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj9;
        boolean z2;
        Object obj6;
        int traceInProgress;
        int defaultsInvalid;
        int rememberLazyGridState;
        int start;
        Object flingBehavior4;
        Object flingBehavior3;
        Object $composer2;
        int $dirty2;
        Object $dirty;
        int i11;
        int i9;
        boolean traceInProgress2;
        Object obj8;
        Object str;
        boolean z;
        int i5;
        Object obj4;
        Object obj;
        int changed2;
        int i14;
        Object obj2;
        Object obj5;
        FlingBehavior flingBehavior2;
        int i7;
        int i3;
        boolean z4;
        int i8;
        Object obj7;
        Object verticalArrangement2;
        int modifier2;
        Object horizontalArrangement2;
        int changed3;
        androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider rememberRowHeightSums;
        int i17;
        Object i12;
        int changed;
        int i10;
        int i2;
        int i15;
        int i;
        Object obj11;
        int z3;
        Object obj10;
        Object obj3;
        Function1 function1;
        Composer composer;
        int i6;
        int i16;
        int i4;
        int obj38;
        final Object obj12 = rows;
        final int i72 = $changed;
        final int i73 = i13;
        Composer restartGroup = $composer.startRestartGroup(2123608858);
        ComposerKt.sourceInformation(restartGroup, "C(LazyHorizontalGrid)P(6,4,7,1,5,3,9,2,8)117@5477L23,123@5834L15,128@5962L64,127@5936L475:LazyGridDsl.kt#7791vq");
        $dirty2 = $changed;
        if (i73 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i72 & 6 == 0) {
                i11 = restartGroup.changed(obj12) ? 4 : 2;
                $dirty2 |= i11;
            }
        }
        int i30 = i73 & 2;
        if (i30 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i72 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                str = modifier;
            }
        }
        if (i72 & 384 == 0) {
            if (i73 & 4 == 0) {
                changed2 = restartGroup.changed(state) ? 256 : 128;
            } else {
                obj4 = state;
            }
            $dirty2 |= changed2;
        } else {
            obj4 = state;
        }
        i14 = i73 & 8;
        if (i14 != 0) {
            $dirty2 |= 3072;
            obj5 = contentPadding;
        } else {
            if (i72 & 3072 == 0) {
                i7 = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty2 |= i7;
            } else {
                obj5 = contentPadding;
            }
        }
        int i70 = i73 & 16;
        if (i70 != 0) {
            $dirty2 |= 24576;
            z4 = reverseLayout;
        } else {
            if (i72 & 24576 == 0) {
                i8 = restartGroup.changed(reverseLayout) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                z4 = reverseLayout;
            }
        }
        int i74 = 196608;
        if (i72 & i74 == 0) {
            if (i73 & 32 == 0) {
                changed3 = restartGroup.changed(horizontalArrangement) ? 131072 : 65536;
            } else {
                horizontalArrangement2 = horizontalArrangement;
            }
            $dirty2 |= changed3;
        } else {
            horizontalArrangement2 = horizontalArrangement;
        }
        rememberRowHeightSums = i73 & 64;
        i17 = 1572864;
        if (rememberRowHeightSums != 0) {
            $dirty2 |= i17;
            obj38 = i74;
            obj7 = verticalArrangement;
        } else {
            if (i72 & i17 == 0) {
                obj38 = i74;
                i17 = restartGroup.changed(verticalArrangement) ? 1048576 : 524288;
                $dirty2 |= i17;
            } else {
                obj38 = i74;
                obj7 = verticalArrangement;
            }
        }
        if (i72 & i77 == 0) {
            if (i73 & 128 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj9 = flingBehavior;
            }
            $dirty2 |= changed;
        } else {
            obj9 = flingBehavior;
        }
        int i20 = i73 & 256;
        int i78 = 100663296;
        if (i20 != 0) {
            $dirty2 |= i78;
            i10 = i20;
            z2 = userScrollEnabled;
        } else {
            if (i72 & i78 == 0) {
                i10 = i20;
                i2 = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty2 |= i2;
            } else {
                i10 = i20;
                z2 = userScrollEnabled;
            }
        }
        i15 = 805306368;
        if (i73 & 512 != 0) {
            $dirty2 |= i15;
            obj6 = content;
        } else {
            if (i72 & i15 == 0) {
                i15 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= i15;
            } else {
                obj6 = content;
            }
        }
        if ($dirty2 & i80 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i9 = -29360129;
                int i81 = -458753;
                if (i72 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i73 & 4 != 0) {
                            int i29 = 0;
                            i = i9;
                            $dirty2 &= -897;
                            obj4 = rememberLazyGridState;
                        } else {
                            i = i9;
                        }
                        if (i14 != 0) {
                            i9 = 0;
                            obj5 = rememberLazyGridState;
                        }
                        if (i70 != 0) {
                            z4 = rememberLazyGridState;
                        }
                        if (i73 & 32 != 0) {
                            Arrangement iNSTANCE3 = Arrangement.INSTANCE;
                            if (!z4) {
                                start = iNSTANCE3.getStart();
                            } else {
                                start = iNSTANCE3.getEnd();
                            }
                            $dirty2 &= i81;
                            horizontalArrangement2 = start;
                        }
                        if (rememberRowHeightSums != 0) {
                            obj7 = start;
                        }
                        if (i73 & 128 != 0) {
                            flingBehavior4 = ScrollableDefaults.INSTANCE.flingBehavior(restartGroup, 6);
                            $dirty2 &= i;
                        } else {
                            flingBehavior4 = flingBehavior;
                        }
                        if (i10 != 0) {
                            obj11 = flingBehavior4;
                            z3 = i9;
                            i10 = z4;
                            flingBehavior3 = obj7;
                            obj3 = horizontalArrangement2;
                            verticalArrangement2 = str;
                            horizontalArrangement2 = obj4;
                        } else {
                            z3 = userScrollEnabled;
                            obj11 = flingBehavior4;
                            i10 = z4;
                            flingBehavior3 = obj7;
                            obj3 = horizontalArrangement2;
                            verticalArrangement2 = str;
                            horizontalArrangement2 = obj4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i73 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i73 & 32 != 0) {
                            $dirty2 &= i81;
                        }
                        if (i73 & 128 != 0) {
                            obj11 = flingBehavior;
                            z3 = userScrollEnabled;
                            $dirty2 = i26;
                            i10 = z4;
                            flingBehavior3 = obj7;
                            obj3 = horizontalArrangement2;
                            verticalArrangement2 = str;
                            horizontalArrangement2 = obj4;
                        } else {
                            obj11 = flingBehavior;
                            z3 = userScrollEnabled;
                            i10 = z4;
                            flingBehavior3 = obj7;
                            obj3 = horizontalArrangement2;
                            verticalArrangement2 = str;
                            horizontalArrangement2 = obj4;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2123608858, $dirty2, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:126)");
                }
                obj10 = flingBehavior3;
                i12 = obj5;
                LazyGridKt.LazyGrid(verticalArrangement2, horizontalArrangement2, LazyGridDslKt.rememberRowHeightSums(obj12, flingBehavior3, obj5, restartGroup, i33 |= i49), i12, i10, false, obj11, z3, obj10, obj3, content, restartGroup, i43 | i62, i44 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = verticalArrangement2;
                obj8 = i12;
                z = i10;
                flingBehavior2 = obj11;
                i3 = z3;
                obj2 = obj10;
                obj = obj3;
                modifier2 = $dirty2;
                $dirty = horizontalArrangement2;
            } else {
                restartGroup.skipToGroupEnd();
                i3 = userScrollEnabled;
                composer = restartGroup;
                $composer2 = str;
                obj8 = obj5;
                z = z4;
                obj2 = obj7;
                flingBehavior2 = flingBehavior;
                modifier2 = $dirty2;
                $dirty = obj4;
                obj = horizontalArrangement2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new LazyGridDslKt.LazyHorizontalGrid.1(obj12, $composer2, $dirty, obj8, z, obj, obj2, flingBehavior2, i3, content, i72, i73);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void LazyVerticalGrid(androidx.compose.foundation.lazy.grid.GridCells columns, Modifier modifier, androidx.compose.foundation.lazy.grid.LazyGridState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj8;
        boolean z3;
        Object obj9;
        int traceInProgress2;
        int defaultsInvalid;
        int rememberLazyGridState;
        int bottom;
        Object flingBehavior2;
        Object flingBehavior4;
        Object $composer2;
        int $dirty2;
        Object $dirty;
        int i14;
        int i2;
        boolean traceInProgress;
        Object obj11;
        Object str;
        boolean z4;
        int i17;
        Object obj;
        Object obj6;
        int changed2;
        int i3;
        Object obj10;
        Object obj5;
        FlingBehavior flingBehavior3;
        int i5;
        int i6;
        boolean z2;
        int i4;
        Object obj7;
        Object horizontalArrangement2;
        int modifier2;
        Object verticalArrangement2;
        int changed3;
        androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider rememberColumnWidthSums;
        int i9;
        Object i15;
        int changed;
        int i8;
        int i11;
        int i16;
        int i10;
        Object obj2;
        int z;
        Object obj4;
        Object obj3;
        Function1 function1;
        Composer composer;
        int i;
        int i7;
        int i12;
        int obj38;
        final Object obj12 = columns;
        final int i72 = $changed;
        final int i73 = i13;
        Composer restartGroup = $composer.startRestartGroup(1485410512);
        ComposerKt.sourceInformation(restartGroup, "C(LazyVerticalGrid)P(!1,5,7,2,6,9,4,3,8)64@2980L23,70@3340L15,75@3468L71,74@3442L481:LazyGridDsl.kt#7791vq");
        $dirty2 = $changed;
        if (i73 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i72 & 6 == 0) {
                i14 = restartGroup.changed(obj12) ? 4 : 2;
                $dirty2 |= i14;
            }
        }
        int i30 = i73 & 2;
        if (i30 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i72 & 48 == 0) {
                i17 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i17;
            } else {
                str = modifier;
            }
        }
        if (i72 & 384 == 0) {
            if (i73 & 4 == 0) {
                changed2 = restartGroup.changed(state) ? 256 : 128;
            } else {
                obj = state;
            }
            $dirty2 |= changed2;
        } else {
            obj = state;
        }
        i3 = i73 & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            obj5 = contentPadding;
        } else {
            if (i72 & 3072 == 0) {
                i5 = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty2 |= i5;
            } else {
                obj5 = contentPadding;
            }
        }
        int i70 = i73 & 16;
        if (i70 != 0) {
            $dirty2 |= 24576;
            z2 = reverseLayout;
        } else {
            if (i72 & 24576 == 0) {
                i4 = restartGroup.changed(reverseLayout) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                z2 = reverseLayout;
            }
        }
        int i74 = 196608;
        if (i72 & i74 == 0) {
            if (i73 & 32 == 0) {
                changed3 = restartGroup.changed(verticalArrangement) ? 131072 : 65536;
            } else {
                verticalArrangement2 = verticalArrangement;
            }
            $dirty2 |= changed3;
        } else {
            verticalArrangement2 = verticalArrangement;
        }
        rememberColumnWidthSums = i73 & 64;
        i9 = 1572864;
        if (rememberColumnWidthSums != 0) {
            $dirty2 |= i9;
            obj38 = i74;
            obj7 = horizontalArrangement;
        } else {
            if (i72 & i9 == 0) {
                obj38 = i74;
                i9 = restartGroup.changed(horizontalArrangement) ? 1048576 : 524288;
                $dirty2 |= i9;
            } else {
                obj38 = i74;
                obj7 = horizontalArrangement;
            }
        }
        if (i72 & i77 == 0) {
            if (i73 & 128 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj8 = flingBehavior;
            }
            $dirty2 |= changed;
        } else {
            obj8 = flingBehavior;
        }
        int i20 = i73 & 256;
        int i78 = 100663296;
        if (i20 != 0) {
            $dirty2 |= i78;
            i8 = i20;
            z3 = userScrollEnabled;
        } else {
            if (i72 & i78 == 0) {
                i8 = i20;
                i11 = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty2 |= i11;
            } else {
                i8 = i20;
                z3 = userScrollEnabled;
            }
        }
        i16 = 805306368;
        if (i73 & 512 != 0) {
            $dirty2 |= i16;
            obj9 = content;
        } else {
            if (i72 & i16 == 0) {
                i16 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= i16;
            } else {
                obj9 = content;
            }
        }
        if ($dirty2 & i80 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i2 = -29360129;
                int i81 = -458753;
                if (i72 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i73 & 4 != 0) {
                            int i29 = 0;
                            i10 = i2;
                            $dirty2 &= -897;
                            obj = rememberLazyGridState;
                        } else {
                            i10 = i2;
                        }
                        if (i3 != 0) {
                            i2 = 0;
                            obj5 = rememberLazyGridState;
                        }
                        if (i70 != 0) {
                            z2 = rememberLazyGridState;
                        }
                        if (i73 & 32 != 0) {
                            Arrangement iNSTANCE3 = Arrangement.INSTANCE;
                            if (!z2) {
                                bottom = iNSTANCE3.getTop();
                            } else {
                                bottom = iNSTANCE3.getBottom();
                            }
                            $dirty2 &= i81;
                            verticalArrangement2 = bottom;
                        }
                        if (rememberColumnWidthSums != 0) {
                            obj7 = bottom;
                        }
                        if (i73 & 128 != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(restartGroup, 6);
                            $dirty2 &= i10;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i8 != 0) {
                            obj2 = flingBehavior2;
                            z = i2;
                            i8 = z2;
                            flingBehavior4 = obj7;
                            obj4 = verticalArrangement2;
                            horizontalArrangement2 = str;
                            verticalArrangement2 = obj;
                        } else {
                            z = userScrollEnabled;
                            obj2 = flingBehavior2;
                            i8 = z2;
                            flingBehavior4 = obj7;
                            obj4 = verticalArrangement2;
                            horizontalArrangement2 = str;
                            verticalArrangement2 = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i73 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i73 & 32 != 0) {
                            $dirty2 &= i81;
                        }
                        if (i73 & 128 != 0) {
                            obj2 = flingBehavior;
                            z = userScrollEnabled;
                            $dirty2 = i26;
                            i8 = z2;
                            flingBehavior4 = obj7;
                            obj4 = verticalArrangement2;
                            horizontalArrangement2 = str;
                            verticalArrangement2 = obj;
                        } else {
                            obj2 = flingBehavior;
                            z = userScrollEnabled;
                            i8 = z2;
                            flingBehavior4 = obj7;
                            obj4 = verticalArrangement2;
                            horizontalArrangement2 = str;
                            verticalArrangement2 = obj;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1485410512, $dirty2, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:73)");
                }
                obj3 = flingBehavior4;
                i15 = obj5;
                LazyGridKt.LazyGrid(horizontalArrangement2, verticalArrangement2, LazyGridDslKt.rememberColumnWidthSums(obj12, flingBehavior4, obj5, restartGroup, i33 |= i49), i15, i8, true, obj2, z, obj4, obj3, content, restartGroup, i43 | i62, i44 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = horizontalArrangement2;
                obj11 = i15;
                z4 = i8;
                flingBehavior3 = obj2;
                i6 = z;
                obj6 = obj4;
                obj10 = obj3;
                modifier2 = $dirty2;
                $dirty = verticalArrangement2;
            } else {
                restartGroup.skipToGroupEnd();
                i6 = userScrollEnabled;
                composer = restartGroup;
                $composer2 = str;
                obj11 = obj5;
                z4 = z2;
                obj10 = obj7;
                flingBehavior3 = flingBehavior;
                modifier2 = $dirty2;
                $dirty = obj;
                obj6 = verticalArrangement2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new LazyGridDslKt.LazyVerticalGrid.1(obj12, $composer2, $dirty, obj11, z4, obj6, obj10, flingBehavior3, i6, content, i72, i73);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final List access$calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        return LazyGridDslKt.calculateCellsCrossAxisSizeImpl(gridSize, slotCount, spacing);
    }

    private static final List<Integer> calculateCellsCrossAxisSizeImpl(int gridSize, int slotCount, int spacing) {
        int i;
        Integer valueOf;
        int i4;
        int i2;
        int i3;
        int i7 = gridSize - i6;
        ArrayList arrayList = new ArrayList(slotCount);
        final int i10 = 0;
        i = i10;
        while (i < slotCount) {
            i4 = 0;
            if (i < i7 % slotCount) {
            } else {
            }
            i3 = i10;
            arrayList.add(Integer.valueOf(i3 += i8));
            i++;
            i3 = 1;
        }
        return (List)arrayList;
    }

    public static final <T> void items(androidx.compose.foundation.lazy.grid.LazyGridScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function2<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, ? super T, androidx.compose.foundation.lazy.grid.GridItemSpan> span, Function1<? super T, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int anon2;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.2 anon;
        int i;
        final int i2 = 0;
        anon2 = 0;
        if (key != null) {
            anon = new LazyGridDslKt.items.2(key, items);
        } else {
            anon = anon2;
        }
        if (span != null) {
            anon2 = new LazyGridDslKt.items.3(span, items);
            i = anon2;
        } else {
            i = anon2;
        }
        LazyGridDslKt.items.4 anon3 = new LazyGridDslKt.items.4(contentType, items);
        LazyGridDslKt.items.5 anon4 = new LazyGridDslKt.items.5(itemContent, items);
        $this$items.items(items.size(), anon, i, (Function1)anon3, (Function4)ComposableLambdaKt.composableLambdaInstance(699646206, true, anon4));
    }

    public static final <T> void items(androidx.compose.foundation.lazy.grid.LazyGridScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function2<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, ? super T, androidx.compose.foundation.lazy.grid.GridItemSpan> span, Function1<? super T, ? extends Object> contentType, Function4<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int anon2;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.7 anon;
        int i;
        final int i2 = 0;
        anon2 = 0;
        if (key != null) {
            anon = new LazyGridDslKt.items.7(key, items);
        } else {
            anon = anon2;
        }
        if (span != null) {
            anon2 = new LazyGridDslKt.items.8(span, items);
            i = anon2;
        } else {
            i = anon2;
        }
        LazyGridDslKt.items.9 anon3 = new LazyGridDslKt.items.9(contentType, items);
        LazyGridDslKt.items.10 anon4 = new LazyGridDslKt.items.10(itemContent, items);
        $this$items.items(items.length, anon, i, (Function1)anon3, (Function4)ComposableLambdaKt.composableLambdaInstance(407562193, true, anon4));
    }

    public static void items$default(androidx.compose.foundation.lazy.grid.LazyGridScope $this$items_u24default, List items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i7, Object object8) {
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.2 anon2;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.2 anon;
        int i;
        int obj8;
        int obj9;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.1 obj10;
        int obj12;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = 0;
        }
        if (i7 &= 8 != 0) {
            obj10 = obj12;
        }
        obj12 = 0;
        obj13 = 0;
        if (obj8 != null) {
            anon2 = new LazyGridDslKt.items.2(obj8, items);
            anon = anon2;
        } else {
            anon = obj13;
        }
        if (obj9 != null) {
            obj13 = new LazyGridDslKt.items.3(obj9, items);
            i = obj13;
        } else {
            i = obj13;
        }
        obj13 = new LazyGridDslKt.items.4(obj10, items);
        obj13 = new LazyGridDslKt.items.5(itemContent, items);
        $this$items_u24default.items(items.size(), anon, i, (Function1)obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(699646206, true, obj13));
    }

    public static void items$default(androidx.compose.foundation.lazy.grid.LazyGridScope $this$items_u24default, Object[] items, Function1 key, Function2 span, Function1 contentType, Function4 itemContent, int i7, Object object8) {
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.7 anon2;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.7 anon;
        int i;
        int obj8;
        int obj9;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.items.6 obj10;
        int obj12;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = 0;
        }
        if (i7 &= 8 != 0) {
            obj10 = obj12;
        }
        obj12 = 0;
        obj13 = 0;
        if (obj8 != null) {
            anon2 = new LazyGridDslKt.items.7(obj8, items);
            anon = anon2;
        } else {
            anon = obj13;
        }
        if (obj9 != null) {
            obj13 = new LazyGridDslKt.items.8(obj9, items);
            i = obj13;
        } else {
            i = obj13;
        }
        obj13 = new LazyGridDslKt.items.9(obj10, items);
        obj13 = new LazyGridDslKt.items.10(itemContent, items);
        $this$items_u24default.items(items.length, anon, i, (Function1)obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(407562193, true, obj13));
    }

    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.grid.LazyGridScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function3<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, ? super Integer, ? super T, androidx.compose.foundation.lazy.grid.GridItemSpan> span, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int anon;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.2 anon2;
        int i;
        final int i2 = 0;
        anon = 0;
        if (key != null) {
            anon2 = new LazyGridDslKt.itemsIndexed.2(key, items);
        } else {
            anon2 = anon;
        }
        if (span != null) {
            anon = new LazyGridDslKt.itemsIndexed.3(span, items);
            i = anon;
        } else {
            i = anon;
        }
        LazyGridDslKt.itemsIndexed.4 anon3 = new LazyGridDslKt.itemsIndexed.4(contentType, items);
        LazyGridDslKt.itemsIndexed.5 anon4 = new LazyGridDslKt.itemsIndexed.5(itemContent, items);
        $this$itemsIndexed.items(items.size(), anon2, i, (Function1)anon3, (Function4)ComposableLambdaKt.composableLambdaInstance(1229287273, true, anon4));
    }

    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.grid.LazyGridScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function3<? super androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope, ? super Integer, ? super T, androidx.compose.foundation.lazy.grid.GridItemSpan> span, Function2<? super Integer, ? super T, ? extends Object> contentType, Function5<? super androidx.compose.foundation.lazy.grid.LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int anon;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.7 anon2;
        int i;
        final int i2 = 0;
        anon = 0;
        if (key != null) {
            anon2 = new LazyGridDslKt.itemsIndexed.7(key, items);
        } else {
            anon2 = anon;
        }
        if (span != null) {
            anon = new LazyGridDslKt.itemsIndexed.8(span, items);
            i = anon;
        } else {
            i = anon;
        }
        LazyGridDslKt.itemsIndexed.9 anon3 = new LazyGridDslKt.itemsIndexed.9(contentType, items);
        LazyGridDslKt.itemsIndexed.10 anon4 = new LazyGridDslKt.itemsIndexed.10(itemContent, items);
        $this$itemsIndexed.items(items.length, anon2, i, (Function1)anon3, (Function4)ComposableLambdaKt.composableLambdaInstance(-911455938, true, anon4));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.grid.LazyGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i7, Object object8) {
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.2 anon;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.2 anon2;
        int i;
        int obj8;
        int obj9;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.1 obj10;
        int obj12;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = 0;
        }
        if (i7 &= 8 != 0) {
            obj10 = obj12;
        }
        obj12 = 0;
        obj13 = 0;
        if (obj8 != null) {
            anon = new LazyGridDslKt.itemsIndexed.2(obj8, items);
            anon2 = anon;
        } else {
            anon2 = obj13;
        }
        if (obj9 != null) {
            obj13 = new LazyGridDslKt.itemsIndexed.3(obj9, items);
            i = obj13;
        } else {
            i = obj13;
        }
        obj13 = new LazyGridDslKt.itemsIndexed.4(obj10, items);
        obj13 = new LazyGridDslKt.itemsIndexed.5(itemContent, items);
        $this$itemsIndexed_u24default.items(items.size(), anon2, i, (Function1)obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(1229287273, true, obj13));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.grid.LazyGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function3 span, Function2 contentType, Function5 itemContent, int i7, Object object8) {
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.7 anon2;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.7 anon;
        int i;
        int obj8;
        int obj9;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.itemsIndexed.6 obj10;
        int obj12;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = 0;
        }
        if (i7 &= 8 != 0) {
            obj10 = obj12;
        }
        obj12 = 0;
        obj13 = 0;
        if (obj8 != null) {
            anon2 = new LazyGridDslKt.itemsIndexed.7(obj8, items);
            anon = anon2;
        } else {
            anon = obj13;
        }
        if (obj9 != null) {
            obj13 = new LazyGridDslKt.itemsIndexed.8(obj9, items);
            i = obj13;
        } else {
            i = obj13;
        }
        obj13 = new LazyGridDslKt.itemsIndexed.9(obj10, items);
        obj13 = new LazyGridDslKt.itemsIndexed.10(itemContent, items);
        $this$itemsIndexed_u24default.items(items.length, anon, i, (Function1)obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(-911455938, true, obj13));
    }

    private static final androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider rememberColumnWidthSums(androidx.compose.foundation.lazy.grid.GridCells columns, Arrangement.Horizontal horizontalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        int changed;
        int i2;
        boolean traceInProgress;
        int changed3;
        int i3;
        int changed2;
        String str;
        int i;
        Object empty;
        Object gridSlotCache;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.rememberColumnWidthSums.1.1 anon;
        int i4 = 1632454918;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(rememberColumnWidthSums)P(!1,2)148@6622L975:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:148)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -2103044334, "CC(remember):LazyGridDsl.kt#9igjgp");
        int i9 = 4;
        i = 0;
        int i13 = 1;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed(columns)) {
                i2 = $changed & 6 == i9 ? i13 : i;
            } else {
            }
        } else {
        }
        int i14 = 32;
        if (i10 ^= 48 > i14) {
            if (!$composer.changed(horizontalArrangement)) {
                i3 = $changed & 48 == i14 ? i13 : i;
            } else {
            }
        } else {
        }
        int i15 = 256;
        if (i11 ^= 384 > i15) {
            if (!$composer.changed(contentPadding)) {
                if ($changed & 384 == i15) {
                    i = i13;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i12 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i16 = 0;
        if (i7 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new LazyGridDslKt.rememberColumnWidthSums.1.1(contentPadding, columns, horizontalArrangement);
                gridSlotCache = new GridSlotCache((Function2)anon);
                composer.updateRememberedValue((LazyGridSlotsProvider)gridSlotCache);
            } else {
                gridSlotCache = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyGridSlotsProvider)gridSlotCache;
    }

    private static final androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider rememberRowHeightSums(androidx.compose.foundation.lazy.grid.GridCells rows, Arrangement.Vertical verticalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        int changed3;
        int i2;
        boolean traceInProgress;
        int changed;
        int i3;
        int changed2;
        String str;
        int i;
        Object empty;
        Object gridSlotCache;
        androidx.compose.foundation.lazy.grid.LazyGridDslKt.rememberRowHeightSums.1.1 anon;
        int i4 = -741512409;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(rememberRowHeightSums)P(1,2)181@7795L909:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:181)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -380187903, "CC(remember):LazyGridDsl.kt#9igjgp");
        int i9 = 4;
        i = 0;
        int i13 = 1;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed(rows)) {
                i2 = $changed & 6 == i9 ? i13 : i;
            } else {
            }
        } else {
        }
        int i14 = 32;
        if (i10 ^= 48 > i14) {
            if (!$composer.changed(verticalArrangement)) {
                i3 = $changed & 48 == i14 ? i13 : i;
            } else {
            }
        } else {
        }
        int i15 = 256;
        if (i11 ^= 384 > i15) {
            if (!$composer.changed(contentPadding)) {
                if ($changed & 384 == i15) {
                    i = i13;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i12 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i16 = 0;
        if (i7 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new LazyGridDslKt.rememberRowHeightSums.1.1(contentPadding, rows, verticalArrangement);
                gridSlotCache = new GridSlotCache((Function2)anon);
                composer.updateRememberedValue((LazyGridSlotsProvider)gridSlotCache);
            } else {
                gridSlotCache = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyGridSlotsProvider)gridSlotCache;
    }
}
