package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ô\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0015\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u001ag\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001ag\u0010\u0019\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u001b2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u0017H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010!\u001a5\u0010\"\u001a\u00020#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a\u0095\u0001\u0010'\u001a\u00020(2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\u0008\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\u0008\u00172\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00102\u001a[\u0010'\u001a\u00020(2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020+0*2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002¢\u0006\u0002\u00106\u001aS\u00107\u001a\u00020\u000f2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\u0008\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002\u001a\u0090\u0001\u00109\u001a\u00020\u000f2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020+0*2#\u0010,\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\u0008\u00172#\u0010.\u001a\u001f\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-¢\u0006\u0002\u0008\u00172\u0006\u00108\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0002\u001a%\u0010:\u001a\u00020\u001f2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010;\u001a5\u0010<\u001a\u00020#2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010=\u001a\\\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\u000c\u0010C\u001a\u0008\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020%H\u0000ø\u0001\u0000¢\u0006\u0004\u0008K\u0010L\u001a\u001c\u0010M\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010,\u001a\u00020\u000fH\u0000\u001a\u001c\u0010P\u001a\u00020\u000f*\u00020+2\u0006\u0010N\u001a\u00020O2\u0006\u0010.\u001a\u00020\u000fH\u0000\u001a<\u0010Q\u001a\u00020(*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020R2\u0014\u0010S\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010T\u0012\u0004\u0012\u00020\u00070\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\u0008U\u0010V\u001aT\u0010W\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u000c\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020?0[2\u0006\u0010\\\u001a\u00020B2\u0006\u0010]\u001a\u000204H\u0000ø\u0001\u0000¢\u0006\u0004\u0008^\u0010_\u001a\u001e\u0010`\u001a\u0004\u0018\u00010E*\u0008\u0012\u0004\u0012\u00020E0D2\u0008\u0010a\u001a\u0004\u0018\u00010bH\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006c", d2 = {"CROSS_AXIS_ALIGNMENT_START", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_START", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "getCROSS_AXIS_ALIGNMENT_TOP", "FlowColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "maxItemsInEachColumn", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowRowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "mainAxisSizes", "", "crossAxisSizes", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "crossAxisMin", "isHorizontal", "", "mainAxisMin", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", "items", "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FlowLayoutKt {

    private static final androidx.compose.foundation.layout.CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START;
    private static final androidx.compose.foundation.layout.CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP;
    static {
        FlowLayoutKt.CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.Companion.vertical$foundation_layout_release(Alignment.Companion.getTop());
        FlowLayoutKt.CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(Alignment.Companion.getStart());
    }

    public static final void FlowColumn(Modifier modifier, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, int maxItemsInEachColumn, int maxLines, androidx.compose.foundation.layout.FlowColumnOverflow overflow, Function3<? super androidx.compose.foundation.layout.FlowColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        Object modifier2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int $dirty2;
        Object $dirty3;
        Object obj6;
        int changed;
        Object obj4;
        Object verticalArrangement2;
        int i4;
        androidx.compose.runtime.internal.ComposableLambda composableLambdaInstance;
        Object start;
        Object obj5;
        Object overflow2;
        Object measurePolicy;
        int i23;
        int i24;
        boolean traceInProgress2;
        int i11;
        Composer composer;
        int valueOf;
        Object str;
        int i12;
        int $i$f$cache;
        int i3;
        Object obj3;
        int i5;
        int i18;
        int it$iv;
        int i6;
        Object empty;
        Object overflowState$foundation_layout_release;
        Object obj;
        int i16;
        int i13;
        int obj2;
        int i;
        androidx.compose.foundation.layout.FlowLayoutOverflowState i9;
        int columnMeasurementMultiContentHelper;
        int i14;
        int i15;
        int i7;
        int i8;
        int i22;
        Object i2;
        int arrayList;
        int $dirty;
        int i17;
        int i19;
        Composer composer2;
        int i20;
        MeasurePolicy measurePolicy$iv$iv;
        int i21;
        ArrayList obj26;
        int obj27;
        int obj28;
        Object obj29;
        int obj30;
        kotlin.jvm.functions.Function0 obj31;
        int obj33;
        final Object obj7 = content;
        final int i60 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(-1704849416);
        ComposerKt.sourceInformation(restartGroup, "C(FlowColumn)P(4,6,1,2,3,5)157@6483L65,160@6573L172,167@6791L264,173@7060L105:FlowLayout.kt#2w3rfo");
        $dirty2 = $changed;
        int i34 = i10 & 1;
        if (i34 != 0) {
            $dirty2 |= 6;
            start = modifier;
        } else {
            if (i60 & 6 == 0) {
                i23 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i23;
            } else {
                start = modifier;
            }
        }
        int i42 = i10 & 2;
        if (i42 != 0) {
            $dirty2 |= 48;
            str = verticalArrangement;
        } else {
            if (i60 & 48 == 0) {
                i3 = restartGroup.changed(verticalArrangement) ? 32 : 16;
                $dirty2 |= i3;
            } else {
                str = verticalArrangement;
            }
        }
        i5 = i10 & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            obj = horizontalArrangement;
        } else {
            if (i60 & 384 == 0) {
                i16 = restartGroup.changed(horizontalArrangement) ? 256 : 128;
                $dirty2 |= i16;
            } else {
                obj = horizontalArrangement;
            }
        }
        i13 = i10 & 8;
        if (i13 != 0) {
            $dirty2 |= 3072;
            obj2 = maxItemsInEachColumn;
        } else {
            if (i60 & 3072 == 0) {
                i = restartGroup.changed(maxItemsInEachColumn) ? 2048 : 1024;
                $dirty2 |= i;
            } else {
                obj2 = maxItemsInEachColumn;
            }
        }
        i9 = i10 & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            columnMeasurementMultiContentHelper = maxLines;
        } else {
            if (i60 & 24576 == 0) {
                i14 = restartGroup.changed(maxLines) ? 16384 : 8192;
                $dirty2 |= i14;
            } else {
                columnMeasurementMultiContentHelper = maxLines;
            }
        }
        i15 = i10 & 32;
        i8 = 196608;
        if (i15 != 0) {
            $dirty2 |= i8;
            empty = overflow;
        } else {
            if (i60 & i8 == 0) {
                i8 = restartGroup.changed(overflow) ? 131072 : 65536;
                $dirty2 |= i8;
            } else {
                empty = overflow;
            }
        }
        i17 = 1572864;
        if (i10 & 64 != 0) {
            $dirty2 |= i17;
        } else {
            if (i60 & i17 == 0) {
                i22 = restartGroup.changedInstance(obj7) ? 1048576 : 524288;
                $dirty2 |= i22;
            }
        }
        if ($dirty2 & i75 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (i34 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = start;
                }
                if (i42 != 0) {
                    verticalArrangement2 = Arrangement.INSTANCE.getTop();
                } else {
                    verticalArrangement2 = str;
                }
                if (i5 != 0) {
                    obj = start;
                }
                i13 = i13 != 0 ? start : obj2;
                obj2 = i9 != 0 ? start : columnMeasurementMultiContentHelper;
                if (i15 != 0) {
                    overflow2 = FlowColumnOverflow.Companion.getClip();
                } else {
                    overflow2 = empty;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1704849416, $dirty2, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:156)");
                }
                String str3 = "CC(remember):FlowLayout.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1515615249, str3);
                int i44 = 458752;
                int i70 = 1;
                i18 = $dirty2 & i44 == 131072 ? i70 : 0;
                Composer composer5 = restartGroup;
                int i74 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                int i76 = 0;
                if (i18 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        int i67 = 0;
                        composer5.updateRememberedValue(overflow2.createOverflowState$foundation_layout_release());
                    } else {
                        overflowState$foundation_layout_release = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                empty = verticalArrangement2;
                int i56 = i70;
                int verticalArrangement3 = 0;
                i9 = flowLayoutOverflowState;
                int overflowState = 256;
                columnMeasurementMultiContentHelper = FlowLayoutKt.columnMeasurementMultiContentHelper(empty, obj, i13, obj2, i9, restartGroup, i55 | i66);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1515605194, str3);
                i4 = $dirty2 & obj26 == 131072 ? i56 : 0;
                i11 = i48 &= $dirty2 == 1048576 ? i56 : 0;
                i4 |= i11;
                Composer composer4 = restartGroup;
                $i$f$cache = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i77 = 0;
                if (composableLambdaInstance == null) {
                    $dirty = $dirty2;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        arrayList = new ArrayList();
                        obj26 = $dirty4;
                        obj6 = arrayList;
                        obj28 = composableLambdaInstance;
                        FlowLayoutKt.FlowColumn.list.1.1 invalid$iv = new FlowLayoutKt.FlowColumn.list.1.1(obj7);
                        obj29 = $i$f$cache;
                        obj30 = rememberedValue4;
                        (List)obj6.add(ComposableLambdaKt.composableLambdaInstance(985886665, true, invalid$iv));
                        overflow2.addOverflowComposables$foundation_layout_release(i9, obj6);
                        composer4.updateRememberedValue(obj6);
                    } else {
                        obj28 = composableLambdaInstance;
                        obj29 = $i$f$cache;
                        obj6 = obj30;
                        it$iv = 1;
                    }
                } else {
                    $dirty = $dirty2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i38 &= 112;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                obj26 = obj6;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -290761997, "CC(remember):Layout.kt#9igjgp");
                if (i31 ^= 384 > 256) {
                    if (!restartGroup.changed(columnMeasurementMultiContentHelper)) {
                        i7 = i39 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer3 = restartGroup;
                int i58 = 0;
                Object rememberedValue = composer3.rememberedValue();
                int i78 = 0;
                if (i7 == 0) {
                    obj29 = overflow2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int overflow3 = 0;
                        composer3.updateRememberedValue(MultiContentMeasurePolicyKt.createMeasurePolicy(columnMeasurementMultiContentHelper));
                    } else {
                        measurePolicy = rememberedValue;
                    }
                } else {
                    obj29 = overflow2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj27 = currentCompositeKeyHash;
                obj31 = constructor;
                i15 = 0;
                arrayList = i40;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj31);
                } else {
                    factory$iv$iv$iv = obj31;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                i17 = 0;
                obj31 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i19 = 0;
                composer2 = constructor-impl;
                i20 = 0;
                if (!composer2.getInserting()) {
                    measurePolicy$iv$iv = measurePolicy;
                    i21 = valueOf;
                    if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(obj27))) {
                        composer2.updateRememberedValue(Integer.valueOf(obj27));
                        constructor-impl.apply(Integer.valueOf(obj27), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer2;
                    }
                } else {
                    measurePolicy$iv$iv = measurePolicy;
                    i21 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                LayoutKt.combineAsVirtualLayouts((List)obj6).invoke(restartGroup, Integer.valueOf(i28 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj29;
                obj4 = empty;
                i24 = i13;
                i12 = obj2;
                $dirty3 = i2;
                obj5 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                $dirty = $dirty2;
                $dirty3 = start;
                obj4 = str;
                obj3 = empty;
                i24 = obj2;
                i12 = columnMeasurementMultiContentHelper;
                obj5 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new FlowLayoutKt.FlowColumn.1($dirty3, obj4, obj5, i24, i12, obj3, obj7, i60, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void FlowRow(Modifier modifier, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, int maxItemsInEachRow, int maxLines, androidx.compose.foundation.layout.FlowRowOverflow overflow, Function3<? super androidx.compose.foundation.layout.FlowRowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        Object modifier2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int $dirty3;
        Object $dirty;
        Object obj6;
        int changed;
        Object obj3;
        Object horizontalArrangement2;
        int i20;
        androidx.compose.runtime.internal.ComposableLambda composableLambdaInstance;
        Object top;
        Object obj;
        Object overflow2;
        Object measurePolicy;
        int i4;
        int i21;
        boolean traceInProgress2;
        int i;
        Composer composer2;
        int valueOf;
        Object str;
        int i8;
        int $i$f$cache;
        int i22;
        Object obj5;
        int i13;
        int i9;
        int it$iv;
        int i16;
        Object empty;
        Object overflowState$foundation_layout_release;
        Object obj2;
        int i23;
        int i2;
        int obj4;
        int i14;
        androidx.compose.foundation.layout.FlowLayoutOverflowState i7;
        int rowMeasurementMultiContentHelper;
        int i3;
        int i6;
        int i11;
        int i12;
        int i18;
        Object i24;
        int arrayList;
        int $dirty2;
        int i17;
        int i19;
        Composer composer;
        int i5;
        MeasurePolicy measurePolicy$iv$iv;
        int i15;
        ArrayList obj26;
        int obj27;
        int obj28;
        Object obj29;
        int obj30;
        kotlin.jvm.functions.Function0 obj31;
        int obj33;
        final Object obj7 = content;
        final int i60 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(437853230);
        ComposerKt.sourceInformation(restartGroup, "C(FlowRow)P(4,1,6,2,3,5)93@4089L65,96@4179L166,103@4391L261,110@4658L105:FlowLayout.kt#2w3rfo");
        $dirty3 = $changed;
        int i34 = i10 & 1;
        if (i34 != 0) {
            $dirty3 |= 6;
            top = modifier;
        } else {
            if (i60 & 6 == 0) {
                i4 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i4;
            } else {
                top = modifier;
            }
        }
        int i42 = i10 & 2;
        if (i42 != 0) {
            $dirty3 |= 48;
            str = horizontalArrangement;
        } else {
            if (i60 & 48 == 0) {
                i22 = restartGroup.changed(horizontalArrangement) ? 32 : 16;
                $dirty3 |= i22;
            } else {
                str = horizontalArrangement;
            }
        }
        i13 = i10 & 4;
        if (i13 != 0) {
            $dirty3 |= 384;
            obj2 = verticalArrangement;
        } else {
            if (i60 & 384 == 0) {
                i23 = restartGroup.changed(verticalArrangement) ? 256 : 128;
                $dirty3 |= i23;
            } else {
                obj2 = verticalArrangement;
            }
        }
        i2 = i10 & 8;
        if (i2 != 0) {
            $dirty3 |= 3072;
            obj4 = maxItemsInEachRow;
        } else {
            if (i60 & 3072 == 0) {
                i14 = restartGroup.changed(maxItemsInEachRow) ? 2048 : 1024;
                $dirty3 |= i14;
            } else {
                obj4 = maxItemsInEachRow;
            }
        }
        i7 = i10 & 16;
        if (i7 != 0) {
            $dirty3 |= 24576;
            rowMeasurementMultiContentHelper = maxLines;
        } else {
            if (i60 & 24576 == 0) {
                i3 = restartGroup.changed(maxLines) ? 16384 : 8192;
                $dirty3 |= i3;
            } else {
                rowMeasurementMultiContentHelper = maxLines;
            }
        }
        i6 = i10 & 32;
        i12 = 196608;
        if (i6 != 0) {
            $dirty3 |= i12;
            empty = overflow;
        } else {
            if (i60 & i12 == 0) {
                i12 = restartGroup.changed(overflow) ? 131072 : 65536;
                $dirty3 |= i12;
            } else {
                empty = overflow;
            }
        }
        i17 = 1572864;
        if (i10 & 64 != 0) {
            $dirty3 |= i17;
        } else {
            if (i60 & i17 == 0) {
                i18 = restartGroup.changedInstance(obj7) ? 1048576 : 524288;
                $dirty3 |= i18;
            }
        }
        if ($dirty3 & i75 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (i34 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = top;
                }
                if (i42 != 0) {
                    horizontalArrangement2 = Arrangement.INSTANCE.getStart();
                } else {
                    horizontalArrangement2 = str;
                }
                if (i13 != 0) {
                    obj2 = top;
                }
                i2 = i2 != 0 ? top : obj4;
                obj4 = i7 != 0 ? top : rowMeasurementMultiContentHelper;
                if (i6 != 0) {
                    overflow2 = FlowRowOverflow.Companion.getClip();
                } else {
                    overflow2 = empty;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(437853230, $dirty3, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:92)");
                }
                String str3 = "CC(remember):FlowLayout.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 454955587, str3);
                int i44 = 458752;
                int i70 = 1;
                i9 = $dirty3 & i44 == 131072 ? i70 : 0;
                Composer composer5 = restartGroup;
                int i74 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                int i76 = 0;
                if (i9 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        int i67 = 0;
                        composer5.updateRememberedValue(overflow2.createOverflowState$foundation_layout_release());
                    } else {
                        overflowState$foundation_layout_release = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                empty = horizontalArrangement2;
                int i56 = i70;
                int horizontalArrangement3 = 0;
                i7 = flowLayoutOverflowState;
                int overflowState = 256;
                rowMeasurementMultiContentHelper = FlowLayoutKt.rowMeasurementMultiContentHelper(empty, obj2, i2, obj4, i7, restartGroup, i55 | i66);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 454965447, str3);
                i20 = $dirty3 & obj26 == 131072 ? i56 : 0;
                i = i48 &= $dirty3 == 1048576 ? i56 : 0;
                i20 |= i;
                Composer composer4 = restartGroup;
                $i$f$cache = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i77 = 0;
                if (composableLambdaInstance == null) {
                    $dirty2 = $dirty3;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        arrayList = new ArrayList();
                        obj26 = $dirty4;
                        obj6 = arrayList;
                        obj28 = composableLambdaInstance;
                        FlowLayoutKt.FlowRow.list.1.1 invalid$iv = new FlowLayoutKt.FlowRow.list.1.1(obj7);
                        obj29 = $i$f$cache;
                        obj30 = rememberedValue4;
                        (List)obj6.add(ComposableLambdaKt.composableLambdaInstance(-139531073, true, invalid$iv));
                        overflow2.addOverflowComposables$foundation_layout_release(i7, obj6);
                        composer4.updateRememberedValue(obj6);
                    } else {
                        obj28 = composableLambdaInstance;
                        obj29 = $i$f$cache;
                        obj6 = obj30;
                        it$iv = 1;
                    }
                } else {
                    $dirty2 = $dirty3;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i38 &= 112;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
                obj26 = obj6;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -290761997, "CC(remember):Layout.kt#9igjgp");
                if (i31 ^= 384 > 256) {
                    if (!restartGroup.changed(rowMeasurementMultiContentHelper)) {
                        i11 = i39 & 384 == 256 ? 1 : 0;
                    } else {
                    }
                } else {
                }
                Composer composer3 = restartGroup;
                int i58 = 0;
                Object rememberedValue = composer3.rememberedValue();
                int i78 = 0;
                if (i11 == 0) {
                    obj29 = overflow2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int overflow3 = 0;
                        composer3.updateRememberedValue(MultiContentMeasurePolicyKt.createMeasurePolicy(rowMeasurementMultiContentHelper));
                    } else {
                        measurePolicy = rememberedValue;
                    }
                } else {
                    obj29 = overflow2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj27 = currentCompositeKeyHash;
                obj31 = constructor;
                i6 = 0;
                arrayList = i40;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj31);
                } else {
                    factory$iv$iv$iv = obj31;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                i17 = 0;
                obj31 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i19 = 0;
                composer = constructor-impl;
                i5 = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv$iv = measurePolicy;
                    i15 = valueOf;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(obj27))) {
                        composer.updateRememberedValue(Integer.valueOf(obj27));
                        constructor-impl.apply(Integer.valueOf(obj27), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer;
                    }
                } else {
                    measurePolicy$iv$iv = measurePolicy;
                    i15 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                LayoutKt.combineAsVirtualLayouts((List)obj6).invoke(restartGroup, Integer.valueOf(i28 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj29;
                obj3 = empty;
                i21 = i2;
                i8 = obj4;
                $dirty = i24;
                obj = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                $dirty2 = $dirty3;
                $dirty = top;
                obj3 = str;
                obj5 = empty;
                i21 = obj4;
                i8 = rowMeasurementMultiContentHelper;
                obj = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new FlowLayoutKt.FlowRow.1($dirty, obj3, obj, i21, i8, obj5, obj7, i60, i10);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final long access$intrinsicCrossAxisSize(List children, Function3 mainAxisSize, Function3 crossAxisSize, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        return FlowLayoutKt.intrinsicCrossAxisSize(children, mainAxisSize, crossAxisSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    public static final int access$maxIntrinsicMainAxisSize(List children, Function3 mainAxisSize, int crossAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        return FlowLayoutKt.maxIntrinsicMainAxisSize(children, mainAxisSize, crossAxisAvailable, mainAxisSpacing, maxItemsInMainAxis);
    }

    public static final int access$minIntrinsicMainAxisSize(List children, Function3 mainAxisSize, Function3 crossAxisSize, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        return FlowLayoutKt.minIntrinsicMainAxisSize(children, mainAxisSize, crossAxisSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    public static final MeasureResult breakDownItems-di9J0FM(MeasureScope $this$breakDownItems_u2ddi9J0FM, androidx.compose.foundation.layout.FlowLineMeasurePolicy measurePolicy, Iterator<? extends Measurable> measurablesIterator, float mainAxisSpacingDp, float crossAxisSpacingDp, long constraints, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        int crossAxisSizes;
        int i12;
        int valueOf;
        MutableIntList nextMainAxisSize2;
        MutableIntList mainAxisMax2;
        int i;
        int leftOverCrossAxis2;
        int valueOf2;
        int i6;
        int crossAxisTotalSize;
        MutableIntObjectMap placeables;
        Measurable safeNext;
        MutableIntList mainAxisMax;
        int endBreakLineList2;
        int i15;
        int box-impl;
        int valueOf3;
        MutableIntList endBreakLineList;
        int nextIndexInLine;
        int dp-u2uoSUM;
        int intValue;
        int currentLineMainAxisSize2;
        MutableIntObjectMap map2;
        int mainAxisSize;
        int i9;
        Ref.ObjectRef spacing;
        int i7;
        int[] iArr;
        int crossAxisSize;
        int i5;
        int leftOver2;
        int mainAxisTotalSize2;
        int i22;
        MutableIntList startIndex;
        MeasureScope items;
        ArrayList list2;
        Measurable measurable;
        Measurable measurable2;
        Placeable[] crossAxisOffsets2;
        int ellipsisWrapInfo2;
        int ellipsisWrapInfo;
        long spacing2;
        long crossAxisOffsets3;
        androidx.compose.foundation.layout.LayoutOrientation horizontal;
        int wrapInfo;
        int i$iv2;
        int unbox-impl;
        int valueOf4;
        int crossAxisTotalSize2;
        int flowLineInfo;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo currentLineMainAxisSize;
        int nextMainAxisSize;
        int i17;
        int dp-u2uoSUM2;
        Measurable measureAndCache-rqJ1uqs;
        boolean lastItemInContainer;
        int dp-u2uoSUM3;
        int valueOf5;
        int i$iv;
        int i2;
        int currentLineCrossAxisSize;
        int i11;
        int nextCrossAxisSize;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo wrapInfo-OpUlnko;
        int i19;
        Measurable measureAndCache-rqJ1uqs2;
        int i8;
        Ref.ObjectRef placeableItem;
        int ellipsisSize-OO21N7I;
        int crossAxisTotalSize3;
        int leftOver;
        int i16;
        int mainAxisTotalSize;
        int leftOverCrossAxis;
        int crossAxisOffsets;
        MutableIntList list;
        int i13;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks flowLayoutBuildingBlocks2;
        boolean index;
        int i14;
        MutableIntObjectMap map;
        long constructor-impl;
        int nextSize;
        int i18;
        MutableIntList list3;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks flowLayoutBuildingBlocks;
        boolean next;
        int nextIndexInLine2;
        long constructor-impl2;
        IntIntPair intIntPair;
        int lineIndex;
        int i3;
        int i10;
        int i4;
        int i20;
        int i21;
        items = $this$breakDownItems_u2ddi9J0FM;
        Measurable measurable4 = measurePolicy;
        Object obj = measurablesIterator;
        int i23 = 0;
        int i32 = 0;
        int i41 = 0;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], i41);
        int i24 = 0;
        crossAxisSizes = Constraints.getMaxWidth-impl(constraints);
        int i27 = 0;
        int i28 = 0;
        int maxHeight-impl = Constraints.getMaxHeight-impl(constraints);
        placeables = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        list2 = arrayList;
        int i39 = (int)f2;
        long constructor-impl3 = OrientationIndependentConstraints.constructor-impl(i41, crossAxisSizes, i41, maxHeight-impl);
        final long l2 = constructor-impl3;
        horizontal = measurable4.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical;
        spacing2 = OrientationIndependentConstraints.toBoxConstraints-OenEA2s(OrientationIndependentConstraints.copy-yUG9Ft0$default(constructor-impl3, obj18, 0, 0, 0, 0, 14), obj11);
        unbox-impl = 0;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = objectRef;
        int i64 = 0;
        int i57 = 0;
        int i76 = crossAxisSizes;
        int i78 = maxHeight-impl;
        if (obj instanceof ContextualFlowItemIterator) {
            flowLineInfo = new FlowLineInfo(i64, 0, items.toDp-u2uoSUM(i76), items.toDp-u2uoSUM(i78), 0);
            leftOverCrossAxis = i64;
        } else {
            leftOver2 = i76;
            i = i78;
            leftOverCrossAxis = i64;
            flowLineInfo = 0;
        }
        int i58 = 0;
        int i68 = 0;
        final MutableVector mutableVector5 = mutableVector4;
        int items2 = i80;
        if (!obj.hasNext()) {
            measureAndCache-rqJ1uqs = 0;
        } else {
            measureAndCache-rqJ1uqs = FlowLayoutKt.safeNext(obj, items2);
        }
        Measurable measurable6 = measureAndCache-rqJ1uqs;
        if (measurable6 != null) {
            currentLineCrossAxisSize = i39;
            FlowLayoutKt.breakDownItems.nextSize.1.1 anon2 = new FlowLayoutKt.breakDownItems.nextSize.1.1(objectRef2);
            box-impl = IntIntPair.box-impl(FlowLayoutKt.measureAndCache-rqJ1uqs(measurable6, measurable4, spacing2, obj11));
        } else {
            currentLineCrossAxisSize = i39;
            spacing = objectRef2;
            measurable = measurable6;
            box-impl = 0;
        }
        nextSize = box-impl;
        if (nextSize != 0) {
            valueOf3 = Integer.valueOf(IntIntPair.getFirst-impl(nextSize.unbox-impl()));
        } else {
            valueOf3 = 0;
        }
        if (nextSize != 0) {
            valueOf4 = Integer.valueOf(IntIntPair.getSecond-impl(nextSize.unbox-impl()));
        } else {
            valueOf4 = 0;
        }
        nextCrossAxisSize = valueOf4;
        i13 = 0;
        int i52 = 0;
        i18 = valueOf3;
        int measurable3 = 1;
        int i74 = i48;
        int crossAxisSpacing = 0;
        int index2 = 0;
        MutableIntList nextMainAxisSize3 = new MutableIntList(index2, measurable3, crossAxisSpacing);
        int i53 = 0;
        list3 = nextMainAxisSize3;
        endBreakLineList = new MutableIntList(index2, measurable3, crossAxisSpacing);
        super(maxLines, obj78, constraints, measureAndCache-rqJ1uqs, overflow, currentLineCrossAxisSize, i74, 0);
        final androidx.compose.foundation.layout.FlowLayoutBuildingBlocks flowLayoutBuildingBlocks4 = flowLayoutBuildingBlocks2;
        ellipsisWrapInfo2 = 0;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo wrapInfo-OpUlnko2 = flowLayoutBuildingBlocks2.getWrapInfo-OpUlnko(obj.hasNext(), 0, IntIntPair.constructor-impl(leftOver2, i), obj46, nextSize, 0, 0, false, false);
        wrapInfo-OpUlnko = wrapInfo-OpUlnko2;
        int i54 = 0;
        if (wrapInfo-OpUlnko.isLastItemInContainer()) {
            i8 = nextSize != 0 ? measurable3 : 0;
            ellipsisWrapInfo2 = flowLayoutBuildingBlocks4.getWrapEllipsisInfo(wrapInfo-OpUlnko, i8, -1, 0, leftOver2, 0);
        } else {
            leftOver = leftOver2;
        }
        int i42 = 0;
        mainAxisTotalSize2 = i51;
        int i69 = measurable3;
        i3 = i55;
        lineIndex = leftOverCrossAxis;
        measurable2 = measurable7;
        crossAxisTotalSize2 = ellipsisWrapInfo2;
        ellipsisWrapInfo = i65;
        nextMainAxisSize = i60;
        currentLineMainAxisSize = wrapInfo-OpUlnko2;
        wrapInfo = i;
        leftOverCrossAxis2 = i91;
        while (!currentLineMainAxisSize.isLastItemInContainer()) {
            if (measurable2 != null) {
            }
            Intrinsics.checkNotNull(i18);
            measureAndCache-rqJ1uqs = i18.intValue();
            Intrinsics.checkNotNull(nextCrossAxisSize);
            valueOf5 = endBreakLineList;
            int intValue3 = nextCrossAxisSize.intValue();
            i11 = crossAxisSizes;
            int i92 = Math.max(ellipsisWrapInfo, intValue3);
            int currentLineCrossAxisSize3 = leftOver - measureAndCache-rqJ1uqs;
            leftOverCrossAxis = intValue3;
            int i66 = mainAxisMax3;
            obj78.setItemShown$foundation_layout_release(leftOverCrossAxis2 + 1);
            (List)list2.add(measurable2);
            placeables.set(leftOverCrossAxis2, spacing.element);
            i35 -= i13;
            if (dp-u2uoSUM < maxLines) {
            } else {
            }
            i19 = 0;
            flowLayoutBuildingBlocks2 = i19;
            if (items2 != 0) {
            } else {
            }
            index = leftOverCrossAxis2;
            i14 = placeables;
            nextIndexInLine2 = dp-u2uoSUM;
            measureAndCache-rqJ1uqs2 = measurable2;
            if (!obj.hasNext()) {
            } else {
            }
            safeNext = FlowLayoutKt.safeNext(obj, items2);
            measurable2 = safeNext;
            int i33 = 0;
            spacing.element = i33;
            if (measurable2 != null) {
            } else {
            }
            intValue = i33;
            nextSize = intValue;
            if (nextSize != 0) {
            } else {
            }
            valueOf = i33;
            if (nextSize != 0) {
            } else {
            }
            valueOf2 = i33;
            nextCrossAxisSize = valueOf2;
            if (nextSize == 0) {
            } else {
            }
            Intrinsics.checkNotNull(valueOf);
            Intrinsics.checkNotNull(nextCrossAxisSize);
            intIntPair = valueOf2;
            wrapInfo-OpUlnko = flowLayoutBuildingBlocks4.getWrapInfo-OpUlnko(obj.hasNext(), nextIndexInLine2, IntIntPair.constructor-impl(currentLineCrossAxisSize3, wrapInfo), obj61, intIntPair, lineIndex, i3, i92, false);
            i6 = i92;
            if (wrapInfo-OpUlnko.isLastItemInLine()) {
            } else {
            }
            leftOver = currentLineCrossAxisSize3;
            mainAxisMax = list3;
            nextMainAxisSize2 = valueOf5;
            i18 = currentLineMainAxisSize4;
            ellipsisWrapInfo = i10;
            nextMainAxisSize = currentLineMainAxisSize2;
            leftOverCrossAxis2 = index + 1;
            endBreakLineList = nextMainAxisSize2;
            list3 = mainAxisMax;
            crossAxisSizes = i11;
            currentLineMainAxisSize = wrapInfo-OpUlnko;
            placeables = i14;
            int i34 = i11;
            mainAxisTotalSize2 = Math.min(Math.max(mainAxisTotalSize2, i66), i34);
            int i75 = i3 + i6;
            if (nextSize != 0) {
            } else {
            }
            i8 = 0;
            int i67 = valueOf;
            valueOf5.add(i6);
            i10 = i6;
            i11 = i34;
            list3.add(index + 1);
            if (i67 != 0) {
            } else {
            }
            valueOf5 = 0;
            lineIndex++;
            nextMainAxisSize = i6;
            i13 = leftOverCrossAxis3;
            leftOver = i56;
            wrapInfo = currentLineMainAxisSize;
            i18 = valueOf5;
            i3 = crossAxisTotalSize3;
            crossAxisTotalSize2 = wrapEllipsisInfo;
            ellipsisWrapInfo = currentLineMainAxisSize2;
            valueOf5 = Integer.valueOf(intValue4 -= currentLineCrossAxisSize);
            i8 = i69;
            intIntPair = i33;
            valueOf2 = Integer.valueOf(IntIntPair.getSecond-impl(nextSize.unbox-impl()));
            valueOf = Integer.valueOf(first-impl += currentLineCrossAxisSize);
            FlowLayoutKt.breakDownItems.1.1 anon = new FlowLayoutKt.breakDownItems.1.1(spacing);
            intValue = IntIntPair.box-impl(FlowLayoutKt.measureAndCache-rqJ1uqs(measurable2, measurable4, spacing2, obj11));
            safeNext = 0;
            if (flowLayoutBuildingBlocks2 != null) {
            } else {
            }
            i12 = i19;
            index = leftOverCrossAxis2;
            if (flowLayoutBuildingBlocks2 != null) {
            } else {
            }
            leftOverCrossAxis2 = 0;
            if (flowLayoutBuildingBlocks2 != null) {
            } else {
            }
            nextIndexInLine2 = dp-u2uoSUM;
            measureAndCache-rqJ1uqs2 = measurable2;
            nextIndexInLine = i11;
            if (flowLayoutBuildingBlocks2 != null) {
            } else {
            }
            i14 = placeables;
            measurable2 = RangesKt.coerceAtLeast(i45 -= i74, 0);
            items2.update-4j6BHR0$foundation_layout_release(i12, leftOverCrossAxis2, items.toDp-u2uoSUM(nextIndexInLine), items.toDp-u2uoSUM(measurable2));
            i14 = placeables;
            measurable2 = wrapInfo;
            nextIndexInLine2 = dp-u2uoSUM;
            measureAndCache-rqJ1uqs2 = measurable2;
            nextIndexInLine = RangesKt.coerceAtLeast(currentLineCrossAxisSize3 - currentLineCrossAxisSize, 0);
            leftOverCrossAxis2 = dp-u2uoSUM;
            i12 = lineIndex;
            i19 = i69;
        }
        int mainAxisMax4 = crossAxisSizes;
        int i83 = leftOverCrossAxis2;
        map = placeables;
        mainAxisMax2 = endBreakLineList;
        Measurable measurable5 = measurable2;
        MutableIntList placeables2 = list3;
        if (crossAxisTotalSize2 != 0) {
            int i30 = crossAxisTotalSize2;
            list2.add(i30.getEllipsis());
            lastItemInContainer = i30;
            valueOf5 = i37;
            map.set(size5--, lastItemInContainer.getPlaceable());
            measurable2 = 0;
            placeableItem = spacing;
            placeableItem2--;
            if (lastItemInContainer.getPlaceEllipsisOnLastContentLine()) {
                mainAxisTotalSize = mainAxisTotalSize2;
                mainAxisMax2.set(spacing, Math.max(mainAxisMax2.get(spacing), IntIntPair.getSecond-impl(lastItemInContainer.getEllipsisSize-OO21N7I())));
                placeables2.set(size--, last2++);
            } else {
                mainAxisTotalSize = mainAxisTotalSize2;
                mainAxisMax2.add(IntIntPair.getSecond-impl(lastItemInContainer.getEllipsisSize-OO21N7I()));
                placeables2.add(last++);
            }
            lineIndex = spacing;
        } else {
            placeableItem = spacing;
            mainAxisTotalSize = mainAxisTotalSize2;
            map2 = map;
        }
        int size2 = list2.size();
        i7 = 0;
        while (i7 < size2) {
            new Placeable[size2][i7] = map2.get(i7);
            i7++;
        }
        int size3 = placeables2.getSize();
        i22 = 0;
        while (i22 < size3) {
            new int[size3][i22] = 0;
            i22++;
        }
        int size4 = placeables2.getSize();
        int[] iArr3 = new int[size4];
        endBreakLineList2 = 0;
        while (endBreakLineList2 < size4) {
            iArr3[endBreakLineList2] = 0;
            endBreakLineList2++;
        }
        int[] iArr5 = iArr3;
        i15 = 0;
        startIndex = list6;
        int i70 = 0;
        i$iv2 = i72;
        i$iv = i31;
        crossAxisTotalSize = mainAxisTotalSize;
        while (i$iv2 < startIndex._size) {
            int measureConstraints = startIndex.content[i$iv2];
            int i49 = i$iv2;
            crossAxisTotalSize3 = 0;
            int i81 = 0;
            int i84 = 0;
            int currentLineCrossAxisSize4 = i15;
            int leftOverCrossAxis4 = i49;
            int[] currentLineIndex = iArr7;
            int this_$iv = currentLineCrossAxisSize;
            MeasureResult measure = RowColumnMeasurePolicyKt.measure((RowColumnMeasurePolicy)measurePolicy, crossAxisTotalSize, Constraints.getMinHeight-impl(l2), Constraints.getMaxWidth-impl(l2), mainAxisMax2.get(i49), this_$iv, items, list2, crossAxisOffsets2, currentLineCrossAxisSize4, measureConstraints, currentLineIndex, leftOverCrossAxis4);
            constructor-impl = currentLineCrossAxisSize4;
            int i38 = 0;
            if (measurePolicy.isHorizontal()) {
            } else {
            }
            mainAxisSize = measure.getHeight();
            crossAxisSize = measure.getWidth();
            iArr5[leftOverCrossAxis4] = crossAxisSize;
            i$iv += crossAxisSize;
            crossAxisTotalSize = Math.max(crossAxisTotalSize, mainAxisSize);
            mutableVector5.add(measure);
            int i44 = i15;
            i$iv2++;
            iArr = arrayOfPlaceables;
            list2 = startIndex3;
            crossAxisOffsets2 = crossAxisOffsets3;
            ellipsisWrapInfo = spacing3;
            startIndex = crossAxisOffsets;
            mainAxisMax2 = list;
            wrapInfo = flowLayoutBuildingBlocks2;
            map2 = map;
            items = $this$breakDownItems_u2ddi9J0FM;
            currentLineCrossAxisSize = endIndex;
            spacing2 = mainAxisTotalSize;
            mainAxisSize = measure.getWidth();
            crossAxisSize = measure.getHeight();
        }
        MutableIntList crossAxisSizes3 = mainAxisMax2;
        int i85 = i15;
        MutableIntObjectMap map3 = map2;
        MutableIntList list5 = startIndex;
        long l3 = spacing2;
        int i82 = wrapInfo;
        int measureConstraints2 = currentLineCrossAxisSize;
        MutableVector mutableVector3 = mutableVector5;
        Placeable[] objArr = crossAxisOffsets2;
        int spacing4 = ellipsisWrapInfo;
        ArrayList currentLineCrossAxisSize5 = list2;
        if (mutableVector3.isEmpty()) {
            i9 = crossAxisTotalSize;
            i5 = i$iv;
        } else {
            i9 = crossAxisTotalSize;
            i5 = i$iv;
        }
        return FlowLayoutKt.placeHelper-BmaY500($this$breakDownItems_u2ddi9J0FM, constraints, i15, i9, i5, iArr5, mutableVector3, measurePolicy);
    }

    public static final MeasurePolicy columnMeasurementHelper(androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        boolean changed2;
        int i4;
        boolean traceInProgress;
        boolean changed;
        int i3;
        boolean changed3;
        String str;
        int i;
        Object flowMeasurePolicy;
        Object anon;
        Object obj2;
        Object obj;
        float spacing-D9Ej5fM;
        androidx.compose.foundation.layout.CrossAxisAlignment cROSS_AXIS_ALIGNMENT_START;
        float spacing-D9Ej5fM2;
        int i2;
        int i7;
        androidx.compose.foundation.layout.FlowLayoutOverflowState overflowState$foundation_layout_release;
        int i6;
        int i5;
        final Composer composer = $composer;
        final int i8 = $changed;
        int i9 = -2013098357;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(columnMeasurementHelper)P(2)443@15212L856:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i8, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:442)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1837869538, "CC(remember):FlowLayout.kt#9igjgp");
        int i14 = 4;
        i = 0;
        int i18 = 1;
        if (i11 ^= 6 > i14) {
            if (!composer.changed(verticalArrangement)) {
                i4 = i8 & 6 == i14 ? i18 : i;
            } else {
            }
        } else {
            obj = verticalArrangement;
        }
        int i19 = 32;
        if (i15 ^= 48 > i19) {
            if (!composer.changed(horizontalArrangement)) {
                i3 = i8 & 48 == i19 ? i18 : i;
            } else {
            }
        } else {
            obj2 = horizontalArrangement;
        }
        flowMeasurePolicy = 256;
        if (i16 ^= 384 > flowMeasurePolicy) {
            if (!composer.changed(maxItemsInMainAxis)) {
                if (i8 & 384 == flowMeasurePolicy) {
                    i = i18;
                }
            } else {
            }
        } else {
            i2 = maxItemsInMainAxis;
        }
        Composer composer2 = $composer;
        int i17 = 0;
        Object rememberedValue = composer2.rememberedValue();
        final int i21 = 0;
        if (i12 |= i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = 0;
                flowMeasurePolicy = new FlowMeasurePolicy(0, obj2, obj, obj.getSpacing-D9Ej5fM(), FlowLayoutKt.CROSS_AXIS_ALIGNMENT_START, obj2.getSpacing-D9Ej5fM(), i2, Integer.MAX_VALUE, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout_release(), 0);
                anon = new FlowLayoutKt.columnMeasurementHelper.1.1(flowMeasurePolicy);
                composer2.updateRememberedValue((MeasurePolicy)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (MeasurePolicy)anon;
    }

    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflowState, Composer $composer, int $changed) {
        boolean changed2;
        int i;
        boolean traceInProgress;
        boolean changed3;
        int i2;
        boolean changed4;
        int i4;
        boolean changed;
        String str;
        int i5;
        Object flowMeasurePolicy;
        int empty;
        int i9;
        Object obj;
        Object obj2;
        float spacing-D9Ej5fM2;
        androidx.compose.foundation.layout.CrossAxisAlignment cROSS_AXIS_ALIGNMENT_START;
        float spacing-D9Ej5fM;
        int i3;
        int i6;
        int i7;
        int i8;
        final Composer composer = $composer;
        final int i10 = $changed;
        int i11 = 748776953;
        ComposerKt.sourceInformationMarkerStart(composer, i11, "C(columnMeasurementMultiContentHelper)P(4)475@16365L652:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i10, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:474)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 287541334, "CC(remember):FlowLayout.kt#9igjgp");
        int i18 = 4;
        i5 = 0;
        int i23 = 1;
        if (i13 ^= 6 > i18) {
            if (!composer.changed(verticalArrangement)) {
                i = i10 & 6 == i18 ? i23 : i5;
            } else {
            }
        } else {
            obj2 = verticalArrangement;
        }
        int i24 = 32;
        if (i19 ^= 48 > i24) {
            if (!composer.changed(horizontalArrangement)) {
                i2 = i10 & 48 == i24 ? i23 : i5;
            } else {
            }
        } else {
            obj = horizontalArrangement;
        }
        int i25 = 256;
        if (i20 ^= 384 > i25) {
            if (!composer.changed(maxItemsInMainAxis)) {
                i4 = i10 & 384 == i25 ? i23 : i5;
            } else {
            }
        } else {
            i3 = maxItemsInMainAxis;
        }
        empty = 2048;
        if (i21 ^= 3072 > empty) {
            if (!composer.changed(maxLines)) {
                if (i10 & 3072 == empty) {
                    i5 = i23;
                }
            } else {
            }
        } else {
            i6 = maxLines;
        }
        final Object obj3 = overflowState;
        Composer composer2 = $composer;
        int i22 = 0;
        Object rememberedValue = composer2.rememberedValue();
        final int i26 = 0;
        if (i16 |= changed5 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i8 = 0;
                flowMeasurePolicy = new FlowMeasurePolicy(0, obj, obj2, obj2.getSpacing-D9Ej5fM(), FlowLayoutKt.CROSS_AXIS_ALIGNMENT_START, obj.getSpacing-D9Ej5fM(), i3, i6, obj3, 0);
                composer2.updateRememberedValue(flowMeasurePolicy);
            } else {
                flowMeasurePolicy = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (MultiContentMeasurePolicy)(FlowMeasurePolicy)flowMeasurePolicy;
    }

    public static final int crossAxisMin(IntrinsicMeasurable $this$crossAxisMin, boolean isHorizontal, int mainAxisSize) {
        int minIntrinsicHeight;
        if (isHorizontal) {
            minIntrinsicHeight = $this$crossAxisMin.minIntrinsicHeight(mainAxisSize);
        } else {
            minIntrinsicHeight = $this$crossAxisMin.minIntrinsicWidth(mainAxisSize);
        }
        return minIntrinsicHeight;
    }

    public static final androidx.compose.foundation.layout.CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return FlowLayoutKt.CROSS_AXIS_ALIGNMENT_START;
    }

    public static final androidx.compose.foundation.layout.CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return FlowLayoutKt.CROSS_AXIS_ALIGNMENT_TOP;
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> crossAxisSize, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        List nextCrossAxisSize;
        int i9;
        IntIntPair ellipsisSize-F35zm-w$foundation_layout_release;
        int wrapEllipsisInfo;
        int second-impl;
        int nextMainAxisSize;
        Object valueOf;
        int i6;
        int currentCrossAxisSize;
        Object nextChild;
        int intValue;
        int wrapInfo;
        int i;
        Integer constructor-impl3;
        int remaining;
        int i10;
        int i5;
        int i8;
        int placeEllipsisOnLastContentLine;
        int i4;
        int totalCrossAxisSize;
        int size;
        int lineIndex;
        int ellipsisSize-OO21N7I;
        int i3;
        int index;
        int box-impl;
        int childCrossAxisSize;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo lastBreak2;
        long constructor-impl;
        int noOfItemsShown;
        int lastBreak;
        int i7;
        IntIntPair box-impl2;
        int i2;
        long constructor-impl2;
        long l;
        nextCrossAxisSize = children;
        final Object obj = crossAxisSize;
        second-impl = 0;
        Integer valueOf4 = Integer.valueOf(second-impl);
        if (nextCrossAxisSize.isEmpty()) {
            return IntIntPair.constructor-impl(second-impl, second-impl);
        }
        wrapEllipsisInfo = Integer.MAX_VALUE;
        final int i20 = mainAxisAvailable;
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(maxItemsInMainAxis, overflow, OrientationIndependentConstraints.constructor-impl(second-impl, i20, second-impl, wrapEllipsisInfo), obj11, maxLines, mainAxisSpacing, crossAxisSpacing, 0);
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks flowLayoutBuildingBlocks2 = flowLayoutBuildingBlocks;
        nextChild = CollectionsKt.getOrNull(nextCrossAxisSize, second-impl);
        if ((IntrinsicMeasurable)nextChild != null) {
            intValue = (Number)obj.invoke((IntrinsicMeasurable)nextChild, valueOf4, Integer.valueOf(i20)).intValue();
        } else {
            intValue = second-impl;
        }
        if (nextChild != null) {
            currentCrossAxisSize = (Number)mainAxisSize.invoke(nextChild, valueOf4, Integer.valueOf(intValue)).intValue();
        } else {
            currentCrossAxisSize = second-impl;
        }
        int i22 = mainAxisAvailable;
        i3 = 0;
        int i26 = 1;
        i5 = nextCrossAxisSize.size() > i26 ? i26 : second-impl;
        final int i37 = 0;
        if (nextChild == null) {
            box-impl = i37;
        } else {
            box-impl = IntIntPair.box-impl(IntIntPair.constructor-impl(currentCrossAxisSize, intValue));
        }
        noOfItemsShown = i22;
        final int i38 = i33;
        androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo wrapInfo-OpUlnko = flowLayoutBuildingBlocks2.getWrapInfo-OpUlnko(i5, 0, IntIntPair.constructor-impl(i22, wrapEllipsisInfo), i26, box-impl, 0, 0, i3, false);
        if (wrapInfo-OpUlnko.isLastItemInContainer()) {
            i4 = nextChild != null ? i38 : second-impl;
            ellipsisSize-F35zm-w$foundation_layout_release = overflow.ellipsisSize-F35zm-w$foundation_layout_release(i4, second-impl, second-impl);
            if (ellipsisSize-F35zm-w$foundation_layout_release != null) {
                second-impl = IntIntPair.getSecond-impl(ellipsisSize-F35zm-w$foundation_layout_release.unbox-impl());
            }
            return IntIntPair.constructor-impl(second-impl, 0);
        }
        remaining = overflow;
        i8 = 0;
        totalCrossAxisSize = 0;
        size = nextCrossAxisSize.size();
        nextMainAxisSize = i3;
        lastBreak = i36;
        lastBreak2 = wrapInfo-OpUlnko;
        wrapInfo = i39;
        while (totalCrossAxisSize < size) {
            wrapEllipsisInfo = noOfItemsShown - i2;
            int remaining3 = totalCrossAxisSize + 1;
            int noOfItemsShown2 = i40;
            i3 = Math.max(nextMainAxisSize, noOfItemsShown2);
            nextChild = valueOf;
            if ((IntrinsicMeasurable)nextChild != null) {
            } else {
            }
            nextCrossAxisSize = 0;
            if ((IntrinsicMeasurable)nextChild != null) {
            } else {
            }
            i6 = 0;
            if (totalCrossAxisSize + 2 < children.size()) {
            } else {
            }
            i = 0;
            i9 = Integer.MAX_VALUE;
            if ((IntrinsicMeasurable)nextChild == null) {
            } else {
            }
            box-impl2 = IntIntPair.box-impl(IntIntPair.constructor-impl(i6, nextCrossAxisSize));
            constructor-impl2 = i34;
            l = i35;
            androidx.compose.foundation.layout.FlowLayoutBuildingBlocks.WrapInfo wrapInfo-OpUlnko2 = flowLayoutBuildingBlocks2.getWrapInfo-OpUlnko(i, i15 -= lastBreak, IntIntPair.constructor-impl(wrapEllipsisInfo, i9), totalCrossAxisSize, box-impl2, lineIndex, ellipsisSize-OO21N7I, i3, false);
            placeEllipsisOnLastContentLine = lineIndex;
            lineIndex = placeEllipsisOnLastContentLine;
            currentCrossAxisSize = i6;
            remaining = size;
            nextMainAxisSize = i3;
            totalCrossAxisSize = constructor-impl2 + 1;
            wrapEllipsisInfo = i9;
            lastBreak2 = wrapInfo-OpUlnko2;
            i8 = remaining3;
            size = i7;
            i9 = mainAxisSize;
            wrapInfo = nextCrossAxisSize;
            noOfItemsShown = remaining;
            nextCrossAxisSize = children;
            remaining = overflow;
            totalCrossAxisSize = ellipsisSize-OO21N7I + i17;
            if ((IntrinsicMeasurable)nextChild != null) {
            } else {
            }
            i10 = 0;
            wrapEllipsisInfo = flowLayoutBuildingBlocks2.getWrapEllipsisInfo(wrapInfo-OpUlnko2, i10, placeEllipsisOnLastContentLine, totalCrossAxisSize, wrapEllipsisInfo, i18 - lastBreak);
            int i19 = 0;
            lastBreak = constructor-impl2 + 1;
            i6 -= mainAxisSpacing;
            i31++;
            currentCrossAxisSize = nextMainAxisSize2;
            nextMainAxisSize = totalCrossAxisSize3;
            ellipsisSize-OO21N7I = totalCrossAxisSize;
            i10 = i38;
            box-impl2 = i37;
            i = i38;
            intValue2 += mainAxisSpacing;
            nextCrossAxisSize = (Number)obj.invoke(nextChild, Integer.valueOf(totalCrossAxisSize + 1), Integer.valueOf(i20)).intValue();
        }
        constructor-impl2 = totalCrossAxisSize;
        return IntIntPair.constructor-impl(ellipsisSize-OO21N7I -= crossAxisSpacing, i8);
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, int[] mainAxisSizes, int[] crossAxisSizes, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        FlowLayoutKt.intrinsicCrossAxisSize.1 anon = new FlowLayoutKt.intrinsicCrossAxisSize.1(mainAxisSizes);
        FlowLayoutKt.intrinsicCrossAxisSize.2 anon2 = new FlowLayoutKt.intrinsicCrossAxisSize.2(crossAxisSizes);
        return FlowLayoutKt.intrinsicCrossAxisSize(children, (Function3)anon, (Function3)anon2, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    public static final int mainAxisMin(IntrinsicMeasurable $this$mainAxisMin, boolean isHorizontal, int crossAxisSize) {
        int minIntrinsicHeight;
        if (isHorizontal) {
            minIntrinsicHeight = $this$mainAxisMin.minIntrinsicWidth(crossAxisSize);
        } else {
            minIntrinsicHeight = $this$mainAxisMin.minIntrinsicHeight(crossAxisSize);
        }
        return minIntrinsicHeight;
    }

    private static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, int crossAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        int fixedSpace;
        int currentFixedSpace;
        int lastBreak;
        int index$iv;
        Object obj2;
        Object obj;
        int i3;
        int i;
        int i2;
        int i4;
        Object obj4;
        int i5;
        int size;
        fixedSpace = 0;
        currentFixedSpace = 0;
        lastBreak = 0;
        final Object obj3 = children;
        final int i6 = 0;
        index$iv = 0;
        while (index$iv < obj3.size()) {
            i3 = index$iv;
            i = 0;
            intValue += mainAxisSpacing;
            if (i7 -= lastBreak != maxItemsInMainAxis) {
            } else {
            }
            lastBreak = i3;
            fixedSpace = Math.max(fixedSpace, currentFixedSpace2 -= mainAxisSpacing);
            currentFixedSpace = 0;
            index$iv++;
            if (i3 + 1 == children.size()) {
            } else {
            }
            currentFixedSpace += i2;
        }
        Object obj5 = mainAxisSize;
        int i8 = maxItemsInMainAxis;
        return fixedSpace;
    }

    public static final long measureAndCache-rqJ1uqs(Measurable $this$measureAndCache_u2drqJ1uqs, androidx.compose.foundation.layout.FlowLineMeasurePolicy measurePolicy, long constraints, Function1<? super Placeable, Unit> storePlaceable) {
        int valueOf;
        int mainAxisMin;
        Object rowColumnParentData;
        long crossAxis;
        long constructor-impl;
        int mainAxisSize;
        int crossAxisSize;
        valueOf = Float.compare(weight, i) == 0 ? 1 : 0;
        if (valueOf != 0) {
            rowColumnParentData = RowColumnImplKt.getRowColumnParentData((IntrinsicMeasurable)$this$measureAndCache_u2drqJ1uqs);
            rowColumnParentData = rowColumnParentData.getFlowLayoutData();
            if (rowColumnParentData != null && rowColumnParentData != null) {
                rowColumnParentData = rowColumnParentData.getFlowLayoutData();
                if (rowColumnParentData != null) {
                    valueOf = Float.valueOf(rowColumnParentData.getFillCrossAxisFraction());
                } else {
                    valueOf = 0;
                }
            } else {
            }
            if (valueOf == 0) {
                mainAxisMin = $this$measureAndCache_u2drqJ1uqs.measure-BRTryo0(constraints);
                obj9.invoke(mainAxisMin);
                Object obj = measurePolicy;
                constructor-impl = 0;
                crossAxis = IntIntPair.constructor-impl(obj.mainAxisSize(mainAxisMin), obj.crossAxisSize(mainAxisMin));
            } else {
                mainAxisMin = FlowLayoutKt.mainAxisMin((IntrinsicMeasurable)$this$measureAndCache_u2drqJ1uqs, measurePolicy.isHorizontal(), Integer.MAX_VALUE);
                crossAxis = constructor-impl;
            }
        } else {
        }
        return crossAxis;
    }

    private static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> crossAxisSize, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflow) {
        int index;
        int i2;
        int itemShown;
        int i9;
        int i12;
        int mainAxisSizes;
        int[] crossAxisSizes;
        int i;
        int[] mainAxisUsed;
        int i10;
        int i4;
        int i15;
        int i3;
        int first-impl;
        androidx.compose.foundation.layout.FlowLayoutOverflow.OverflowType type$foundation_layout_release;
        int minLinesToShowCollapse$foundation_layout_release;
        List list;
        List low;
        int i16;
        int i5;
        Object obj;
        int i6;
        boolean high;
        int expandOrCollapseIndicator;
        int high2;
        int intValue;
        Object obj2;
        Integer valueOf;
        Object obj4;
        IntRange intRange;
        IntRange intRange2;
        int i13;
        int i8;
        int i11;
        int i7;
        int i14;
        long intrinsicCrossAxisSize;
        final int i17 = crossAxisAvailable;
        i16 = maxItemsInMainAxis;
        i5 = maxLines;
        int i19 = 0;
        if (children.isEmpty()) {
            return i19;
        }
        int size = children.size();
        crossAxisSizes = new int[size];
        i = i19;
        while (i < size) {
            crossAxisSizes[i] = i19;
            i++;
        }
        int size2 = children.size();
        mainAxisUsed = new int[size2];
        i10 = i19;
        while (i10 < size2) {
            mainAxisUsed[i10] = i19;
            i10++;
        }
        index = 0;
        while (index < children.size()) {
            obj = children.get(index);
            expandOrCollapseIndicator = (Number)mainAxisSize.invoke((IntrinsicMeasurable)obj, Integer.valueOf(index), Integer.valueOf(i17)).intValue();
            crossAxisSizes[index] = expandOrCollapseIndicator;
            mainAxisUsed[index] = (Number)crossAxisSize.invoke(obj, Integer.valueOf(index), Integer.valueOf(expandOrCollapseIndicator)).intValue();
            index++;
        }
        low = children;
        Object obj3 = mainAxisSize;
        Object obj5 = crossAxisSize;
        i2 = Integer.MAX_VALUE;
        if (i5 != i2 && i16 != i2) {
            if (i16 != i2) {
                i2 = i16 * i5;
            } else {
            }
        } else {
        }
        i6 = 1;
        if (i2 < low.size()) {
            if (overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.ExpandIndicator) {
                if (overflow.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator) {
                    i4 = i6;
                } else {
                    if (i2 >= low.size() && i5 >= overflow.getMinLinesToShowCollapse$foundation_layout_release() && overflow.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator) {
                        if (i5 >= overflow.getMinLinesToShowCollapse$foundation_layout_release()) {
                            i4 = overflow.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator ? i6 : i19;
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        i15 = i4 != 0 ? i6 : i19;
        int i20 = 0;
        i28 += i18;
        int $this$minIntrinsicMainAxisSize_u24lambda_u249 = i29;
        i3 = mainAxisUsed.length == 0 ? i6 : i19;
        if (i3 != 0) {
        } else {
            first-impl = mainAxisUsed[i19];
            int i30 = 0;
            int i33 = i19;
            intRange = new IntRange(i6, ArraysKt.getLastIndex(mainAxisUsed));
            IntIterator iterator2 = intRange.iterator();
            while (iterator2.hasNext()) {
                intRange = mainAxisUsed[iterator2.nextInt()];
                i8 = 0;
                if (first-impl < intRange) {
                }
                first-impl = intRange;
            }
            i9 = crossAxisSizes.length == 0 ? i6 : i33;
            if (i9 != 0) {
            } else {
                i12 = crossAxisSizes[i33];
                int i31 = 0;
                i13 = $this$minIntrinsicMainAxisSize_u24lambda_u249;
                intRange2 = new IntRange(i6, ArraysKt.getLastIndex(crossAxisSizes));
                IntIterator iterator = intRange2.iterator();
                while (iterator.hasNext()) {
                    i6 = crossAxisSizes[iterator.nextInt()];
                    intRange2 = null;
                    if (i12 < i6) {
                    }
                    i12 = i6;
                }
                itemShown = i32;
                mainAxisSizes = i29;
                while (itemShown <= mainAxisSizes) {
                    i8 = i24 / 2;
                    int[] high3 = crossAxisSizes;
                    int[] mainAxisSizes2 = mainAxisUsed;
                    int crossAxisSizes2 = i8;
                    i14 = first-impl;
                    i7 = high2;
                    int mustHaveEllipsis = i25;
                    intrinsicCrossAxisSize = FlowLayoutKt.intrinsicCrossAxisSize(low, high3, mainAxisSizes2, crossAxisSizes2, mainAxisSpacing, crossAxisSpacing, i16, i5, overflow);
                    first-impl = IntIntPair.getFirst-impl(intrinsicCrossAxisSize);
                    int i23 = i8 + 1;
                    i16 = maxItemsInMainAxis;
                    i5 = maxLines;
                    i13 = crossAxisSizes2;
                    itemShown = i23;
                    low = children;
                    mainAxisUsed = mainAxisSizes2;
                    crossAxisSizes = high3;
                    mainAxisSizes = mustHaveEllipsis;
                    high2 = i7;
                    i16 = maxItemsInMainAxis;
                    i5 = maxLines;
                    i13 = crossAxisSizes2;
                    itemShown = i11;
                    high2 = i7;
                    mainAxisUsed = mainAxisSizes2;
                    crossAxisSizes = high3;
                    mainAxisSizes = i22;
                    low = children;
                }
                return i13;
            }
            int mainAxisUsed4 = $this$minIntrinsicMainAxisSize_u24lambda_u249;
            NoSuchElementException mainAxisUsed2 = new NoSuchElementException();
            throw mainAxisUsed2;
        }
        int mainAxisUsed5 = $this$minIntrinsicMainAxisSize_u24lambda_u249;
        NoSuchElementException mainAxisUsed3 = new NoSuchElementException();
        throw mainAxisUsed3;
    }

    public static final MeasureResult placeHelper-BmaY500(MeasureScope $this$placeHelper_u2dBmaY500, long constraints, int mainAxisTotalSize, int crossAxisTotalSize, int[] crossAxisSizes, MutableVector<MeasureResult> items, androidx.compose.foundation.layout.FlowLineMeasurePolicy measureHelper, int[] outPosition) {
        int totalCrossAxisSize;
        int layoutWidth;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        int layoutHeight;
        int i;
        int minHeight-impl;
        androidx.compose.ui.unit.Density maxHeight-impl2;
        int maxHeight-impl;
        androidx.compose.foundation.layout.Arrangement.Horizontal horizontal;
        androidx.compose.ui.unit.Density density;
        int coerceIn;
        int[] iArr;
        androidx.compose.ui.unit.LayoutDirection layoutDirection;
        int[] iArr2;
        MeasureScope measureScope = $this$placeHelper_u2dBmaY500;
        final boolean horizontal2 = outPosition.isHorizontal();
        final androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement = outPosition.getVerticalArrangement();
        final androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement = outPosition.getHorizontalArrangement();
        int i3 = 0;
        int totalCrossAxisSize2 = crossAxisSizes;
        if (horizontal2) {
            if (verticalArrangement == null) {
            } else {
                vertical = verticalArrangement;
                i = 0;
                int i14 = 0;
                int i17 = 0;
                totalCrossAxisSize = RangesKt.coerceIn(totalCrossAxisSize2 += minHeight-impl, Constraints.getMinHeight-impl(constraints), Constraints.getMaxHeight-impl(constraints));
                vertical.arrange((Density)measureScope, totalCrossAxisSize, items, obj24);
                coerceIn = totalCrossAxisSize;
                int i4 = 0;
                int i6 = 0;
                int coerceIn2 = RangesKt.coerceIn(crossAxisTotalSize, Constraints.getMinWidth-impl(constraints), Constraints.getMaxWidth-impl(constraints));
                int i5 = 0;
                int i7 = 0;
                layoutHeight = horizontal2 ? coerceIn : coerceIn2;
                FlowLayoutKt.placeHelper.5 anon = new FlowLayoutKt.placeHelper.5(measureHelper);
                return MeasureScope.layout$default(measureScope, layoutWidth, layoutHeight, 0, (Function1)anon, 4, 0);
            }
            int[] iArr3 = items;
            int[] iArr4 = obj24;
            int i8 = 0;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("null verticalArrangement".toString());
            throw illegalArgumentException2;
        }
        if (horizontalArrangement == null) {
        } else {
            horizontal = horizontalArrangement;
            vertical = 0;
            int i11 = 0;
            int i15 = 0;
            horizontal.arrange((Density)measureScope, RangesKt.coerceIn(totalCrossAxisSize2 += i, Constraints.getMinHeight-impl(constraints), Constraints.getMaxHeight-impl(constraints)), items, measureScope.getLayoutDirection(), obj24);
        }
        int i19 = crossAxisTotalSize;
        MutableVector mutableVector2 = measureHelper;
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("null horizontalArrangement".toString());
        throw illegalArgumentException;
    }

    public static final MeasurePolicy rowMeasurementHelper(androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, Composer $composer, int $changed) {
        boolean changed2;
        int i2;
        boolean traceInProgress;
        boolean changed;
        int i7;
        boolean changed3;
        String str;
        int i6;
        Object flowMeasurePolicy;
        Object anon;
        Object obj;
        Object obj2;
        float spacing-D9Ej5fM2;
        androidx.compose.foundation.layout.CrossAxisAlignment cROSS_AXIS_ALIGNMENT_TOP;
        float spacing-D9Ej5fM;
        int i5;
        int i4;
        androidx.compose.foundation.layout.FlowLayoutOverflowState overflowState$foundation_layout_release;
        int i;
        int i3;
        final Composer composer = $composer;
        final int i8 = $changed;
        int i9 = 1479255111;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(rowMeasurementHelper)P(!1,2)380@13086L883:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i8, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:379)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -75342195, "CC(remember):FlowLayout.kt#9igjgp");
        int i14 = 4;
        i6 = 0;
        int i18 = 1;
        if (i11 ^= 6 > i14) {
            if (!composer.changed(horizontalArrangement)) {
                i2 = i8 & 6 == i14 ? i18 : i6;
            } else {
            }
        } else {
            obj = horizontalArrangement;
        }
        int i19 = 32;
        if (i15 ^= 48 > i19) {
            if (!composer.changed(verticalArrangement)) {
                i7 = i8 & 48 == i19 ? i18 : i6;
            } else {
            }
        } else {
            obj2 = verticalArrangement;
        }
        flowMeasurePolicy = 256;
        if (i16 ^= 384 > flowMeasurePolicy) {
            if (!composer.changed(maxItemsInMainAxis)) {
                if (i8 & 384 == flowMeasurePolicy) {
                    i6 = i18;
                }
            } else {
            }
        } else {
            i5 = maxItemsInMainAxis;
        }
        Composer composer2 = $composer;
        int i17 = 0;
        Object rememberedValue = composer2.rememberedValue();
        final int i21 = 0;
        if (i12 |= i6 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i3 = 0;
                flowMeasurePolicy = new FlowMeasurePolicy(1, obj, obj2, obj.getSpacing-D9Ej5fM(), FlowLayoutKt.CROSS_AXIS_ALIGNMENT_TOP, obj2.getSpacing-D9Ej5fM(), i5, Integer.MAX_VALUE, FlowRowOverflow.Companion.getVisible().createOverflowState$foundation_layout_release(), 0);
                anon = new FlowLayoutKt.rowMeasurementHelper.1.1((MultiContentMeasurePolicy)flowMeasurePolicy);
                composer2.updateRememberedValue((MeasurePolicy)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (MeasurePolicy)anon;
    }

    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement, androidx.compose.foundation.layout.Arrangement.Vertical verticalArrangement, int maxItemsInMainAxis, int maxLines, androidx.compose.foundation.layout.FlowLayoutOverflowState overflowState, Composer $composer, int $changed) {
        boolean changed;
        int i7;
        boolean traceInProgress;
        boolean changed2;
        int i2;
        boolean changed4;
        int i;
        boolean changed3;
        String str;
        int i8;
        Object flowMeasurePolicy;
        int empty;
        int i9;
        Object obj2;
        Object obj;
        float spacing-D9Ej5fM2;
        androidx.compose.foundation.layout.CrossAxisAlignment cROSS_AXIS_ALIGNMENT_TOP;
        float spacing-D9Ej5fM;
        int i4;
        int i3;
        int i6;
        int i5;
        final Composer composer = $composer;
        final int i10 = $changed;
        int i11 = -2134502475;
        ComposerKt.sourceInformationMarkerStart(composer, i11, "C(rowMeasurementMultiContentHelper)P(!1,4)414@14301L649:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i11, i10, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:413)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 744443043, "CC(remember):FlowLayout.kt#9igjgp");
        int i18 = 4;
        i8 = 0;
        int i23 = 1;
        if (i13 ^= 6 > i18) {
            if (!composer.changed(horizontalArrangement)) {
                i7 = i10 & 6 == i18 ? i23 : i8;
            } else {
            }
        } else {
            obj2 = horizontalArrangement;
        }
        int i24 = 32;
        if (i19 ^= 48 > i24) {
            if (!composer.changed(verticalArrangement)) {
                i2 = i10 & 48 == i24 ? i23 : i8;
            } else {
            }
        } else {
            obj = verticalArrangement;
        }
        int i25 = 256;
        if (i20 ^= 384 > i25) {
            if (!composer.changed(maxItemsInMainAxis)) {
                i = i10 & 384 == i25 ? i23 : i8;
            } else {
            }
        } else {
            i4 = maxItemsInMainAxis;
        }
        empty = 2048;
        if (i21 ^= 3072 > empty) {
            if (!composer.changed(maxLines)) {
                if (i10 & 3072 == empty) {
                    i8 = i23;
                }
            } else {
            }
        } else {
            i3 = maxLines;
        }
        final Object obj3 = overflowState;
        Composer composer2 = $composer;
        int i22 = 0;
        Object rememberedValue = composer2.rememberedValue();
        final int i26 = 0;
        if (i16 |= changed5 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = 0;
                flowMeasurePolicy = new FlowMeasurePolicy(1, obj2, obj, obj2.getSpacing-D9Ej5fM(), FlowLayoutKt.CROSS_AXIS_ALIGNMENT_TOP, obj.getSpacing-D9Ej5fM(), i4, i3, obj3, 0);
                composer2.updateRememberedValue(flowMeasurePolicy);
            } else {
                flowMeasurePolicy = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (MultiContentMeasurePolicy)(FlowMeasurePolicy)flowMeasurePolicy;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> $this$safeNext, androidx.compose.foundation.layout.FlowLineInfo info) {
        Object next$foundation_layout_release;
        int i;
        if ($this$safeNext instanceof ContextualFlowItemIterator) {
            try {
                Intrinsics.checkNotNull(info);
                next$foundation_layout_release = (ContextualFlowItemIterator)$this$safeNext.getNext$foundation_layout_release(info);
                next$foundation_layout_release = $this$safeNext.next();
                Throwable e = i;
                return next$foundation_layout_release;
            }
        } else {
        }
    }
}
