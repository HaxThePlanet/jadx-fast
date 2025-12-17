package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a0\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\u000c¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0008\u000f¢\u0006\u0002\u0008\u0008H\u0007¢\u0006\u0002\u0010\u0010\u001a \u0001\u0010\u0011\u001a\u00020\u0012*\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0015\u0012\u0004\u0012\u00020\u00070\u000c2.\u0008\u0002\u0010\u0016\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\u0008\u00082A\u0010\u0017\u001a=\u0012\u0004\u0012\u00020\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u001d\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\u0002\u0008\u0008\u001a6\u0010\u001f\u001a\u00020 *\u00020\r2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\"4\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\u0004\u0012\u0008\u0008\u0005\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\u0008\u0008X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006'", d2 = {"defaultPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Lkotlin/ParameterName;", "name", "lookaheadCoordinates", "", "Lkotlin/ExtensionFunctionType;", "LookaheadScope", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "approachLayout", "Landroidx/compose/ui/Modifier;", "isMeasurementApproachInProgress", "Landroidx/compose/ui/unit/IntSize;", "lookaheadSize", "isPlacementApproachInProgress", "approachMeasure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "coordinates", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-Fgt4K4Q", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LookaheadScopeKt {

    private static final Function2<androidx.compose.ui.layout.Placeable.PlacementScope, androidx.compose.ui.layout.LayoutCoordinates, Boolean> defaultPlacementApproachInProgress;
    static {
        LookaheadScopeKt.defaultPlacementApproachInProgress = (Function2)LookaheadScopeKt.defaultPlacementApproachInProgress.1.INSTANCE;
    }

    public static final void LookaheadScope(Function3<? super androidx.compose.ui.layout.LookaheadScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int invalid$iv;
        int $dirty;
        int i3;
        int traceInProgress;
        boolean traceInProgress2;
        int str;
        int i;
        int i2;
        int empty;
        Composer composer;
        Object lookaheadScopeImpl;
        int i4;
        int valueOf;
        int str2;
        invalid$iv = -1078066484;
        final Composer obj11 = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(obj11, "C(LookaheadScope)51@2069L33,52@2107L484:LookaheadScope.kt#80mrfh");
        str = 2;
        if ($changed & 6 == 0) {
            i3 = obj11.changedInstance(content) ? 4 : str;
            $dirty |= i3;
        }
        if ($dirty & 3 == str) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty, -1, "androidx.compose.ui.layout.LookaheadScope (LookaheadScope.kt:50)");
                }
                ComposerKt.sourceInformationMarkerStart(obj11, 2062858814, "CC(remember):LookaheadScope.kt#9igjgp");
                int i6 = 0;
                Composer composer2 = obj11;
                int i7 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i8 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    str2 = 0;
                    lookaheadScopeImpl = new LookaheadScopeImpl(str2, 1, str2);
                    composer2.updateRememberedValue(lookaheadScopeImpl);
                } else {
                    lookaheadScopeImpl = rememberedValue;
                }
                invalid$iv = lookaheadScopeImpl;
                ComposerKt.sourceInformationMarkerEnd(obj11);
                i = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                obj11.startReusableNode();
                if (obj11.getInserting()) {
                    obj11.createNode((Function0)LookaheadScopeKt.LookaheadScope.1.INSTANCE);
                } else {
                    obj11.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(obj11);
                int i11 = 0;
                Updater.init-impl(constructor-impl, (Function1)LookaheadScopeKt.LookaheadScope.2.1.INSTANCE);
                Updater.set-impl(constructor-impl, (LookaheadScopeImpl)invalid$iv, (Function2)LookaheadScopeKt.LookaheadScope.2.2.INSTANCE);
                i10 &= 14;
                composer = obj11;
                i4 = 0;
                ComposerKt.sourceInformationMarkerStart(composer, 1405016920, "C64@2566L9:LookaheadScope.kt#80mrfh");
                content.invoke(invalid$iv, composer, Integer.valueOf(i13 &= 112));
                ComposerKt.sourceInformationMarkerEnd(composer);
                obj11.endNode();
                ComposerKt.sourceInformationMarkerEnd(obj11);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new LookaheadScopeKt.LookaheadScope.4(content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final Function2 access$getDefaultPlacementApproachInProgress$p() {
        return LookaheadScopeKt.defaultPlacementApproachInProgress;
    }

    public static final Modifier approachLayout(Modifier $this$approachLayout, Function1<? super IntSize, Boolean> isMeasurementApproachInProgress, Function2<? super androidx.compose.ui.layout.Placeable.PlacementScope, ? super androidx.compose.ui.layout.LayoutCoordinates, Boolean> isPlacementApproachInProgress, Function3<? super androidx.compose.ui.layout.ApproachMeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> approachMeasure) {
        ApproachLayoutElement approachLayoutElement = new ApproachLayoutElement(approachMeasure, isMeasurementApproachInProgress, isPlacementApproachInProgress);
        return $this$approachLayout.then((Modifier)approachLayoutElement);
    }

    public static Modifier approachLayout$default(Modifier modifier, Function1 function12, Function2 function23, Function3 function34, int i5, Object object6) {
        Function2 obj2;
        if (i5 &= 2 != 0) {
            obj2 = LookaheadScopeKt.defaultPlacementApproachInProgress;
        }
        return LookaheadScopeKt.approachLayout(modifier, function12, obj2, function34);
    }

    public static final long localLookaheadPositionOf-Fgt4K4Q(androidx.compose.ui.layout.LookaheadScope $this$localLookaheadPositionOf_u2dFgt4K4Q, androidx.compose.ui.layout.LayoutCoordinates coordinates, androidx.compose.ui.layout.LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
        long localPositionOf-S_NoaFU;
        final androidx.compose.ui.layout.LayoutCoordinates lookaheadCoordinates = $this$localLookaheadPositionOf_u2dFgt4K4Q.toLookaheadCoordinates(coordinates);
        final androidx.compose.ui.layout.LayoutCoordinates lookaheadCoordinates2 = $this$localLookaheadPositionOf_u2dFgt4K4Q.toLookaheadCoordinates(sourceCoordinates);
        if (lookaheadCoordinates instanceof LookaheadLayoutCoordinates) {
            localPositionOf-S_NoaFU = lookaheadCoordinates.localPositionOf-S_NoaFU(lookaheadCoordinates2, relativeToSource, includeMotionFrameOfReference);
        } else {
            if (lookaheadCoordinates2 instanceof LookaheadLayoutCoordinates) {
                localPositionOf-S_NoaFU = Offset.unaryMinus-F1C5BW0(lookaheadCoordinates2.localPositionOf-S_NoaFU(lookaheadCoordinates, relativeToSource, includeMotionFrameOfReference));
            } else {
                localPositionOf-S_NoaFU = lookaheadCoordinates.localPositionOf-S_NoaFU(lookaheadCoordinates, relativeToSource, includeMotionFrameOfReference);
            }
        }
        return localPositionOf-S_NoaFU;
    }
}
