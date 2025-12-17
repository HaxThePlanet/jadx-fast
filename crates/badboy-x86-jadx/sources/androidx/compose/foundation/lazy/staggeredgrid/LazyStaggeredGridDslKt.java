package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a\u0083\u0001\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0008\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0008\u001a\u00020\tH\u0003¢\u0006\u0002\u0010$\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010&*\u00020\u00152\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H&0'2%\u0008\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\u0008\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\u0008\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\u0008\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\u00083¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u00104\u001aÐ\u0001\u0010%\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010&*\u00020\u00152\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H&052%\u0008\n\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020,\u0018\u00010\u00142%\u0008\u0006\u0010-\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0006\u0012\u0004\u0018\u00010,0\u00142%\u0008\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020/\u0018\u00010\u001423\u0008\u0004\u00100\u001a-\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u000101¢\u0006\u0002\u00083¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u00106\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010&*\u00020\u00152\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H&0'2:\u0008\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\u0008\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\u0008\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\u0008\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\u00083¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u0010;\u001a¤\u0002\u00107\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010&*\u00020\u00152\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H&052:\u0008\n\u0010(\u001a4\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020,\u0018\u0001012:\u0008\u0006\u0010-\u001a4\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0006\u0012\u0004\u0018\u00010,012:\u0008\n\u0010.\u001a4\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020/\u0018\u0001012H\u0008\u0004\u00100\u001aB\u0012\u0004\u0012\u000202\u0012\u0013\u0012\u001108¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(9\u0012\u0013\u0012\u0011H&¢\u0006\u000c\u0008)\u0012\u0008\u0008*\u0012\u0004\u0008\u0008(+\u0012\u0004\u0012\u00020\u00010:¢\u0006\u0002\u00083¢\u0006\u0002\u0008\u0016H\u0086\u0008¢\u0006\u0002\u0010<\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006=", d2 = {"LazyHorizontalStaggeredGrid", "", "rows", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyVerticalStaggeredGrid", "columns", "verticalItemSpacing", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyStaggeredGridDslKt {
    public static final void LazyHorizontalStaggeredGrid-cJHQLPU(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells rows, Modifier modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, float horizontalItemSpacing, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, Unit> content, Composer $composer, int $changed, int i13) {
        float f2;
        Object obj6;
        boolean z2;
        Object obj4;
        int horizontalItemSpacing2;
        int defaultsInvalid;
        int rememberLazyStaggeredGridState;
        float horizontalItemSpacing3;
        Object $composer2;
        int $dirty;
        Object $dirty2;
        int i7;
        int flingBehavior2;
        boolean traceInProgress;
        Object obj7;
        Object obj2;
        boolean z;
        int i17;
        Object str;
        Object obj5;
        int changedInstance;
        int i16;
        float f3;
        Object obj;
        FlingBehavior flingBehavior3;
        int i;
        int i15;
        int i8;
        boolean z3;
        int i9;
        Object obj3;
        int state2;
        Object horizontal;
        int i10;
        androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider rememberRowSlots;
        int i5;
        int i6;
        int changed;
        int i4;
        int i2;
        int i11;
        boolean i18;
        Object obj8;
        int i14;
        float f;
        float spacing-D9Ej5fM;
        Function1 function1;
        Composer composer;
        int i19;
        int i3;
        int i12;
        int obj38;
        final Object obj9 = rows;
        final int i73 = $changed;
        final int i74 = i13;
        Composer restartGroup = $composer.startRestartGroup(-8666074);
        ComposerKt.sourceInformation(restartGroup, "C(LazyHorizontalStaggeredGrid)P(6,4,7,1,5,9,3:c#ui.unit.Dp,2,8)154@6993L32,159@7288L15,173@7803L59,163@7399L496:LazyStaggeredGridDsl.kt#fzvcnm");
        $dirty = $changed;
        if (i74 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i73 & 6 == 0) {
                i7 = restartGroup.changed(obj9) ? 4 : 2;
                $dirty |= i7;
            }
        }
        int i31 = i74 & 2;
        if (i31 != 0) {
            $dirty |= 48;
            obj2 = modifier;
        } else {
            if (i73 & 48 == 0) {
                i17 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i17;
            } else {
                obj2 = modifier;
            }
        }
        if (i73 & 384 == 0) {
            if (i74 & 4 == 0) {
                changedInstance = restartGroup.changedInstance(state) ? 256 : 128;
            } else {
                str = state;
            }
            $dirty |= changedInstance;
        } else {
            str = state;
        }
        i16 = i74 & 8;
        if (i16 != 0) {
            $dirty |= 3072;
            obj = contentPadding;
        } else {
            if (i73 & 3072 == 0) {
                i = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty |= i;
            } else {
                obj = contentPadding;
            }
        }
        i15 = i74 & 16;
        if (i15 != 0) {
            $dirty |= 24576;
            z3 = reverseLayout;
        } else {
            if (i73 & 24576 == 0) {
                i9 = restartGroup.changed(reverseLayout) ? 16384 : 8192;
                $dirty |= i9;
            } else {
                z3 = reverseLayout;
            }
        }
        int i75 = i74 & 32;
        int i76 = 196608;
        if (i75 != 0) {
            $dirty |= i76;
            horizontal = verticalArrangement;
        } else {
            if (i76 &= i73 == 0) {
                i10 = restartGroup.changed(verticalArrangement) ? 131072 : 65536;
                $dirty |= i10;
            } else {
                horizontal = verticalArrangement;
            }
        }
        rememberRowSlots = i74 & 64;
        i5 = 1572864;
        if (rememberRowSlots != 0) {
            $dirty |= i5;
            f2 = horizontalItemSpacing;
        } else {
            if (i73 & i5 == 0) {
                i6 = restartGroup.changed(horizontalItemSpacing) ? 1048576 : 524288;
                $dirty |= i6;
            } else {
                f2 = horizontalItemSpacing;
            }
        }
        if (i73 & i78 == 0) {
            if (i74 & 128 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj6 = flingBehavior;
            }
            $dirty |= changed;
        } else {
            obj6 = flingBehavior;
        }
        int i22 = i74 & 256;
        int i79 = 100663296;
        if (i22 != 0) {
            $dirty |= i79;
            i4 = i22;
            z2 = userScrollEnabled;
        } else {
            if (i73 & i79 == 0) {
                i4 = i22;
                i2 = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty |= i2;
            } else {
                i4 = i22;
                z2 = userScrollEnabled;
            }
        }
        i11 = 805306368;
        if (i74 & 512 != 0) {
            $dirty |= i11;
            obj4 = content;
        } else {
            if (i73 & i11 == 0) {
                i11 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty |= i11;
            } else {
                obj4 = content;
            }
        }
        if ($dirty & i18 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                flingBehavior2 = -29360129;
                if (i73 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i74 & 4 != 0) {
                            int i30 = 0;
                            obj38 = flingBehavior2;
                            $dirty &= -897;
                            str = rememberLazyStaggeredGridState;
                        } else {
                            obj38 = flingBehavior2;
                        }
                        if (i16 != 0) {
                            flingBehavior2 = 0;
                            obj = rememberLazyStaggeredGridState;
                        }
                        if (i15 != 0) {
                            z3 = rememberLazyStaggeredGridState;
                        }
                        if (i75 != 0) {
                            i16 = 0;
                            horizontal = rememberLazyStaggeredGridState;
                        }
                        if (rememberRowSlots != 0) {
                            flingBehavior2 = 0;
                            horizontalItemSpacing3 = Dp.constructor-impl((float)i28);
                        } else {
                            horizontalItemSpacing3 = horizontalItemSpacing;
                        }
                        if (i74 & 128 != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(restartGroup, 6);
                            $dirty &= obj38;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i4 != 0) {
                            f = horizontalItemSpacing3;
                            obj8 = flingBehavior2;
                            obj3 = str;
                            i14 = i16;
                            i18 = z3;
                            horizontalItemSpacing2 = horizontal;
                        } else {
                            i14 = userScrollEnabled;
                            f = horizontalItemSpacing3;
                            obj8 = flingBehavior2;
                            obj3 = str;
                            i18 = z3;
                            horizontalItemSpacing2 = horizontal;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i74 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i74 & 128 != 0) {
                            f = horizontalItemSpacing;
                            obj8 = flingBehavior;
                            i14 = userScrollEnabled;
                            $dirty = i27;
                            obj3 = str;
                            i18 = z3;
                            horizontalItemSpacing2 = horizontal;
                        } else {
                            f = horizontalItemSpacing;
                            obj8 = flingBehavior;
                            i14 = userScrollEnabled;
                            obj3 = str;
                            i18 = z3;
                            horizontalItemSpacing2 = horizontal;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-8666074, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:162)");
                }
                i5 = obj2;
                i4 = obj;
                LazyStaggeredGridKt.LazyStaggeredGrid-LJWHXA8(obj3, Orientation.Horizontal, LazyStaggeredGridDslKt.rememberRowSlots(obj9, horizontalItemSpacing2, obj, restartGroup, i34 |= i52), i5, i4, i18, obj8, i14, f, horizontalItemSpacing2.getSpacing-D9Ej5fM(), content, restartGroup, i43 | i64, i44 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                state2 = $dirty;
                $dirty2 = obj11;
                obj5 = horizontalItemSpacing2;
                $composer2 = i5;
                obj7 = i4;
                z = i18;
                flingBehavior3 = obj8;
                i8 = i14;
                f3 = f;
            } else {
                restartGroup.skipToGroupEnd();
                f3 = horizontalItemSpacing;
                i8 = userScrollEnabled;
                composer = restartGroup;
                state2 = $dirty;
                $composer2 = obj2;
                $dirty2 = str;
                obj7 = obj;
                z = z3;
                obj5 = horizontal;
                flingBehavior3 = flingBehavior;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            horizontalItemSpacing2 = new LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid.1(obj9, $composer2, $dirty2, obj7, z, obj5, f3, flingBehavior3, i8, content, i73, i74);
            endRestartGroup.updateScope((Function2)horizontalItemSpacing2);
        }
    }

    public static final void LazyVerticalStaggeredGrid-zadm560(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells columns, Modifier modifier, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState state, PaddingValues contentPadding, boolean reverseLayout, float verticalItemSpacing, Arrangement.Horizontal horizontalArrangement, FlingBehavior flingBehavior, boolean userScrollEnabled, Function1<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope, Unit> content, Composer $composer, int $changed, int i13) {
        Object obj5;
        Object obj2;
        boolean z;
        Object obj6;
        int $dirty3;
        int defaultsInvalid;
        int $this$dp$iv;
        Object $composer2;
        int $dirty2;
        Object $dirty;
        int i3;
        int flingBehavior2;
        boolean traceInProgress;
        Object obj;
        Object obj3;
        boolean z2;
        int i9;
        Object str;
        float f;
        int changedInstance;
        int i;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical;
        Object obj7;
        FlingBehavior flingBehavior3;
        int i19;
        int i16;
        int i4;
        boolean z3;
        int i18;
        Object obj4;
        int state2;
        float vertical;
        int i2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider rememberColumnSlots;
        int i15;
        int i5;
        int changed;
        int i12;
        int i6;
        int i8;
        boolean i7;
        Object obj8;
        int i14;
        float f2;
        float spacing-D9Ej5fM;
        Function1 function1;
        Composer composer;
        int i17;
        int i10;
        int i11;
        int obj38;
        final Object obj9 = columns;
        final int i73 = $changed;
        final int i74 = i13;
        Composer restartGroup = $composer.startRestartGroup(1695323794);
        ComposerKt.sourceInformation(restartGroup, "C(LazyVerticalStaggeredGrid)P(!1,5,7,2,6,9:c#ui.unit.Dp,4,3,8)64@3068L32,69@3365L15,83@3878L67,73@3476L502:LazyStaggeredGridDsl.kt#fzvcnm");
        $dirty2 = $changed;
        if (i74 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i73 & 6 == 0) {
                i3 = restartGroup.changed(obj9) ? 4 : 2;
                $dirty2 |= i3;
            }
        }
        int i31 = i74 & 2;
        if (i31 != 0) {
            $dirty2 |= 48;
            obj3 = modifier;
        } else {
            if (i73 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj3 = modifier;
            }
        }
        if (i73 & 384 == 0) {
            if (i74 & 4 == 0) {
                changedInstance = restartGroup.changedInstance(state) ? 256 : 128;
            } else {
                str = state;
            }
            $dirty2 |= changedInstance;
        } else {
            str = state;
        }
        i = i74 & 8;
        if (i != 0) {
            $dirty2 |= 3072;
            obj7 = contentPadding;
        } else {
            if (i73 & 3072 == 0) {
                i19 = restartGroup.changed(contentPadding) ? 2048 : 1024;
                $dirty2 |= i19;
            } else {
                obj7 = contentPadding;
            }
        }
        i16 = i74 & 16;
        if (i16 != 0) {
            $dirty2 |= 24576;
            z3 = reverseLayout;
        } else {
            if (i73 & 24576 == 0) {
                i18 = restartGroup.changed(reverseLayout) ? 16384 : 8192;
                $dirty2 |= i18;
            } else {
                z3 = reverseLayout;
            }
        }
        int i75 = i74 & 32;
        int i76 = 196608;
        if (i75 != 0) {
            $dirty2 |= i76;
            vertical = verticalItemSpacing;
        } else {
            if (i76 &= i73 == 0) {
                i2 = restartGroup.changed(verticalItemSpacing) ? 131072 : 65536;
                $dirty2 |= i2;
            } else {
                vertical = verticalItemSpacing;
            }
        }
        rememberColumnSlots = i74 & 64;
        i15 = 1572864;
        if (rememberColumnSlots != 0) {
            $dirty2 |= i15;
            obj5 = horizontalArrangement;
        } else {
            if (i73 & i15 == 0) {
                i5 = restartGroup.changed(horizontalArrangement) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                obj5 = horizontalArrangement;
            }
        }
        if (i73 & i78 == 0) {
            if (i74 & 128 == 0) {
                changed = restartGroup.changed(flingBehavior) ? 8388608 : 4194304;
            } else {
                obj2 = flingBehavior;
            }
            $dirty2 |= changed;
        } else {
            obj2 = flingBehavior;
        }
        int i22 = i74 & 256;
        int i79 = 100663296;
        if (i22 != 0) {
            $dirty2 |= i79;
            i12 = i22;
            z = userScrollEnabled;
        } else {
            if (i73 & i79 == 0) {
                i12 = i22;
                i6 = restartGroup.changed(userScrollEnabled) ? 67108864 : 33554432;
                $dirty2 |= i6;
            } else {
                i12 = i22;
                z = userScrollEnabled;
            }
        }
        i8 = 805306368;
        if (i74 & 512 != 0) {
            $dirty2 |= i8;
            obj6 = content;
        } else {
            if (i73 & i8 == 0) {
                i8 = restartGroup.changedInstance(content) ? 536870912 : 268435456;
                $dirty2 |= i8;
            } else {
                obj6 = content;
            }
        }
        if ($dirty2 & i7 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                flingBehavior2 = -29360129;
                if (i73 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i74 & 4 != 0) {
                            int i30 = 0;
                            obj38 = flingBehavior2;
                            $dirty2 &= -897;
                            str = $this$dp$iv;
                        } else {
                            obj38 = flingBehavior2;
                        }
                        if (i != 0) {
                            flingBehavior2 = 0;
                            obj7 = $this$dp$iv;
                        }
                        if (i16 != 0) {
                            z3 = $this$dp$iv;
                        }
                        if (i75 != 0) {
                            flingBehavior2 = 0;
                            vertical = $this$dp$iv;
                        }
                        if (rememberColumnSlots != 0) {
                            i = 0;
                            $dirty3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)i46));
                        } else {
                            $dirty3 = horizontalArrangement;
                        }
                        if (i74 & 128 != 0) {
                            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(restartGroup, 6);
                            $dirty2 &= obj38;
                        } else {
                            flingBehavior2 = flingBehavior;
                        }
                        if (i12 != 0) {
                            obj8 = flingBehavior2;
                            obj4 = str;
                            i14 = i;
                            i7 = z3;
                            f2 = vertical;
                        } else {
                            i14 = userScrollEnabled;
                            obj8 = flingBehavior2;
                            obj4 = str;
                            i7 = z3;
                            f2 = vertical;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i74 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (i74 & 128 != 0) {
                            obj8 = flingBehavior;
                            i14 = userScrollEnabled;
                            $dirty2 = i27;
                            obj4 = str;
                            i7 = z3;
                            f2 = vertical;
                            $dirty3 = horizontalArrangement;
                        } else {
                            $dirty3 = horizontalArrangement;
                            obj8 = flingBehavior;
                            i14 = userScrollEnabled;
                            obj4 = str;
                            i7 = z3;
                            f2 = vertical;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1695323794, $dirty2, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:72)");
                }
                i15 = obj3;
                i12 = obj7;
                LazyStaggeredGridKt.LazyStaggeredGrid-LJWHXA8(obj4, Orientation.Vertical, LazyStaggeredGridDslKt.rememberColumnSlots(obj9, $dirty3, obj7, restartGroup, i34 |= i52), i15, i12, i7, obj8, i14, f2, $dirty3.getSpacing-D9Ej5fM(), content, restartGroup, i43 | i64, i44 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                state2 = $dirty2;
                $dirty = obj11;
                horizontalOrVertical = $dirty3;
                $composer2 = i15;
                obj = i12;
                z2 = i7;
                flingBehavior3 = obj8;
                i4 = i14;
                f = f2;
            } else {
                restartGroup.skipToGroupEnd();
                horizontalOrVertical = horizontalArrangement;
                i4 = userScrollEnabled;
                composer = restartGroup;
                state2 = $dirty2;
                $composer2 = obj3;
                $dirty = str;
                obj = obj7;
                z2 = z3;
                f = vertical;
                flingBehavior3 = flingBehavior;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = new LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid.1(obj9, $composer2, $dirty, obj, z2, f, horizontalOrVertical, flingBehavior3, i4, content, i73, i74);
            endRestartGroup.updateScope((Function2)$dirty3);
        }
    }

    public static final <T> void items(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$items, List<? extends T> items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function1<? super T, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan> span, Function4<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int it2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.2.1 it;
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.2.1 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.4.1 anon2;
        final int i2 = 0;
        if (key != null) {
            Function1 function12 = key;
            i = 0;
            anon = new LazyStaggeredGridDslKt.items.2.1(key, items);
            it = anon;
        } else {
            it = it2;
        }
        LazyStaggeredGridDslKt.items.3 anon4 = new LazyStaggeredGridDslKt.items.3(contentType, items);
        if (span != null) {
            Function1 function1 = span;
            anon = 0;
            anon2 = new LazyStaggeredGridDslKt.items.4.1(span, items);
            it2 = anon2;
        }
        LazyStaggeredGridDslKt.items.5 anon3 = new LazyStaggeredGridDslKt.items.5(itemContent, items);
        $this$items.items(items.size(), it, (Function1)anon4, it2, (Function4)ComposableLambdaKt.composableLambdaInstance(-886456479, true, anon3));
    }

    public static final <T> void items(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$items, T[] items, Function1<? super T, ? extends Object> key, Function1<? super T, ? extends Object> contentType, Function1<? super T, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan> span, Function4<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int it2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.7.1 it;
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.7.1 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.9.1 anon2;
        final int i2 = 0;
        if (key != null) {
            Function1 function12 = key;
            i = 0;
            anon = new LazyStaggeredGridDslKt.items.7.1(key, items);
            it = anon;
        } else {
            it = it2;
        }
        LazyStaggeredGridDslKt.items.8 anon4 = new LazyStaggeredGridDslKt.items.8(contentType, items);
        if (span != null) {
            Function1 function1 = span;
            anon = 0;
            anon2 = new LazyStaggeredGridDslKt.items.9.1(span, items);
            it2 = anon2;
        }
        LazyStaggeredGridDslKt.items.10 anon3 = new LazyStaggeredGridDslKt.items.10(itemContent, items);
        $this$items.items(items.length, it, (Function1)anon4, it2, (Function4)ComposableLambdaKt.composableLambdaInstance(2101296000, true, anon3));
    }

    public static void items$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$items_u24default, List items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i7, Object object8) {
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.3 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.2.1 anon2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.2.1 anon3;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.4.1 anon4;
        int obj8;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.1 obj9;
        int obj10;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = obj13;
        }
        if (i7 &= 8 != 0) {
            obj10 = 0;
        }
        int obj12 = 0;
        if (obj8 != null) {
            i = obj8;
            int i3 = 0;
            anon3 = new LazyStaggeredGridDslKt.items.2.1(obj8, items);
            anon2 = anon3;
        } else {
            anon2 = obj13;
        }
        anon = new LazyStaggeredGridDslKt.items.3(obj9, items);
        if (obj10 != null) {
            obj13 = obj10;
            anon = 0;
            anon4 = new LazyStaggeredGridDslKt.items.4.1(obj10, items);
            obj13 = anon4;
        }
        obj13 = new LazyStaggeredGridDslKt.items.5(itemContent, items);
        $this$items_u24default.items(items.size(), anon2, (Function1)anon, obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(-886456479, true, obj13));
    }

    public static void items$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$items_u24default, Object[] items, Function1 key, Function1 contentType, Function1 span, Function4 itemContent, int i7, Object object8) {
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.8 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.7.1 anon2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.7.1 anon4;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.9.1 anon3;
        int obj8;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.items.6 obj9;
        int obj10;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = obj13;
        }
        if (i7 &= 8 != 0) {
            obj10 = 0;
        }
        int obj12 = 0;
        if (obj8 != null) {
            i = obj8;
            int i3 = 0;
            anon4 = new LazyStaggeredGridDslKt.items.7.1(obj8, items);
            anon2 = anon4;
        } else {
            anon2 = obj13;
        }
        anon = new LazyStaggeredGridDslKt.items.8(obj9, items);
        if (obj10 != null) {
            obj13 = obj10;
            anon = 0;
            anon3 = new LazyStaggeredGridDslKt.items.9.1(obj10, items);
            obj13 = anon3;
        }
        obj13 = new LazyStaggeredGridDslKt.items.10(itemContent, items);
        $this$items_u24default.items(items.length, anon2, (Function1)anon, obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(2101296000, true, obj13));
    }

    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$itemsIndexed, List<? extends T> items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function2<? super Integer, ? super T, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan> span, Function5<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int it;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.2.1 it2;
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.2.1 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.4.1 anon2;
        final int i2 = 0;
        if (key != null) {
            Function2 function22 = key;
            i = 0;
            anon = new LazyStaggeredGridDslKt.itemsIndexed.2.1(key, items);
            it2 = anon;
        } else {
            it2 = it;
        }
        LazyStaggeredGridDslKt.itemsIndexed.3 anon4 = new LazyStaggeredGridDslKt.itemsIndexed.3(contentType, items);
        if (span != null) {
            Function2 function2 = span;
            anon = 0;
            anon2 = new LazyStaggeredGridDslKt.itemsIndexed.4.1(span, items);
            it = anon2;
        }
        LazyStaggeredGridDslKt.itemsIndexed.5 anon3 = new LazyStaggeredGridDslKt.itemsIndexed.5(itemContent, items);
        $this$itemsIndexed.items(items.size(), it2, (Function1)anon4, it, (Function4)ComposableLambdaKt.composableLambdaInstance(284833944, true, anon3));
    }

    public static final <T> void itemsIndexed(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$itemsIndexed, T[] items, Function2<? super Integer, ? super T, ? extends Object> key, Function2<? super Integer, ? super T, ? extends Object> contentType, Function2<? super Integer, ? super T, androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan> span, Function5<? super androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> itemContent) {
        int it2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.7.1 it;
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.7.1 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.9.1 anon2;
        final int i2 = 0;
        if (key != null) {
            Function2 function22 = key;
            i = 0;
            anon = new LazyStaggeredGridDslKt.itemsIndexed.7.1(key, items);
            it = anon;
        } else {
            it = it2;
        }
        LazyStaggeredGridDslKt.itemsIndexed.8 anon4 = new LazyStaggeredGridDslKt.itemsIndexed.8(contentType, items);
        if (span != null) {
            Function2 function2 = span;
            anon = 0;
            anon2 = new LazyStaggeredGridDslKt.itemsIndexed.9.1(span, items);
            it2 = anon2;
        }
        LazyStaggeredGridDslKt.itemsIndexed.10 anon3 = new LazyStaggeredGridDslKt.itemsIndexed.10(itemContent, items);
        $this$itemsIndexed.items(items.length, it, (Function1)anon4, it2, (Function4)ComposableLambdaKt.composableLambdaInstance(-804487775, true, anon3));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$itemsIndexed_u24default, List items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i7, Object object8) {
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.3 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.2.1 anon4;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.2.1 anon2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.4.1 anon3;
        int obj8;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.1 obj9;
        int obj10;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = obj13;
        }
        if (i7 &= 8 != 0) {
            obj10 = 0;
        }
        int obj12 = 0;
        if (obj8 != null) {
            i = obj8;
            int i3 = 0;
            anon2 = new LazyStaggeredGridDslKt.itemsIndexed.2.1(obj8, items);
            anon4 = anon2;
        } else {
            anon4 = obj13;
        }
        anon = new LazyStaggeredGridDslKt.itemsIndexed.3(obj9, items);
        if (obj10 != null) {
            obj13 = obj10;
            anon = 0;
            anon3 = new LazyStaggeredGridDslKt.itemsIndexed.4.1(obj10, items);
            obj13 = anon3;
        }
        obj13 = new LazyStaggeredGridDslKt.itemsIndexed.5(itemContent, items);
        $this$itemsIndexed_u24default.items(items.size(), anon4, (Function1)anon, obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(284833944, true, obj13));
    }

    public static void itemsIndexed$default(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope $this$itemsIndexed_u24default, Object[] items, Function2 key, Function2 contentType, Function2 span, Function5 itemContent, int i7, Object object8) {
        int i;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.8 anon4;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.7.1 anon2;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.7.1 anon;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.9.1 anon3;
        int obj8;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.itemsIndexed.6 obj9;
        int obj10;
        int obj13;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = obj13;
        }
        if (i7 &= 8 != 0) {
            obj10 = 0;
        }
        int obj12 = 0;
        if (obj8 != null) {
            i = obj8;
            int i3 = 0;
            anon = new LazyStaggeredGridDslKt.itemsIndexed.7.1(obj8, items);
            anon2 = anon;
        } else {
            anon2 = obj13;
        }
        anon4 = new LazyStaggeredGridDslKt.itemsIndexed.8(obj9, items);
        if (obj10 != null) {
            obj13 = obj10;
            anon4 = 0;
            anon3 = new LazyStaggeredGridDslKt.itemsIndexed.9.1(obj10, items);
            obj13 = anon3;
        }
        obj13 = new LazyStaggeredGridDslKt.itemsIndexed.10(itemContent, items);
        $this$itemsIndexed_u24default.items(items.length, anon2, (Function1)anon4, obj13, (Function4)ComposableLambdaKt.composableLambdaInstance(-804487775, true, obj13));
    }

    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider rememberColumnSlots(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells columns, Arrangement.Horizontal horizontalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        int changed3;
        int i;
        boolean traceInProgress;
        int changed2;
        int i2;
        int changed;
        String str;
        int i3;
        Object empty;
        Object lazyStaggeredGridSlotCache;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.rememberColumnSlots.1.1 anon;
        int i4 = -1267076841;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(rememberColumnSlots)P(!1,2)94@4216L1114:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:94)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 463564400, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        int i9 = 4;
        i3 = 0;
        int i13 = 1;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed(columns)) {
                i = $changed & 6 == i9 ? i13 : i3;
            } else {
            }
        } else {
        }
        int i14 = 32;
        if (i10 ^= 48 > i14) {
            if (!$composer.changed(horizontalArrangement)) {
                i2 = $changed & 48 == i14 ? i13 : i3;
            } else {
            }
        } else {
        }
        int i15 = 256;
        if (i11 ^= 384 > i15) {
            if (!$composer.changed(contentPadding)) {
                if ($changed & 384 == i15) {
                    i3 = i13;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i12 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i16 = 0;
        if (i7 |= i3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new LazyStaggeredGridDslKt.rememberColumnSlots.1.1(contentPadding, columns, horizontalArrangement);
                lazyStaggeredGridSlotCache = new LazyStaggeredGridSlotCache((Function2)anon);
                composer.updateRememberedValue((LazyGridStaggeredGridSlotsProvider)lazyStaggeredGridSlotCache);
            } else {
                lazyStaggeredGridSlotCache = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyGridStaggeredGridSlotsProvider)lazyStaggeredGridSlotCache;
    }

    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider rememberRowSlots(androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells rows, Arrangement.Vertical verticalArrangement, PaddingValues contentPadding, Composer $composer, int $changed) {
        int changed3;
        int i3;
        boolean traceInProgress;
        int changed;
        int i2;
        int changed2;
        String str;
        int i;
        Object empty;
        Object lazyStaggeredGridSlotCache;
        androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt.rememberRowSlots.1.1 anon;
        int i4 = -1532383053;
        ComposerKt.sourceInformationMarkerStart($composer, i4, "C(rememberRowSlots)P(1,2)184@8120L940:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:184)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1011137904, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        int i9 = 4;
        i = 0;
        int i13 = 1;
        if (i6 ^= 6 > i9) {
            if (!$composer.changed(rows)) {
                i3 = $changed & 6 == i9 ? i13 : i;
            } else {
            }
        } else {
        }
        int i14 = 32;
        if (i10 ^= 48 > i14) {
            if (!$composer.changed(verticalArrangement)) {
                i2 = $changed & 48 == i14 ? i13 : i;
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
                anon = new LazyStaggeredGridDslKt.rememberRowSlots.1.1(contentPadding, rows, verticalArrangement);
                lazyStaggeredGridSlotCache = new LazyStaggeredGridSlotCache((Function2)anon);
                composer.updateRememberedValue((LazyGridStaggeredGridSlotsProvider)lazyStaggeredGridSlotCache);
            } else {
                lazyStaggeredGridSlotCache = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (LazyGridStaggeredGridSlotsProvider)lazyStaggeredGridSlotCache;
    }
}
