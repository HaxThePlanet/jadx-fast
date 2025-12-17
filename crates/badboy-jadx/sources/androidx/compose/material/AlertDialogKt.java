package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a{\u0010\u0008\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\u0008\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u00052\u0015\u0008\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\u0008\u000c2\u0015\u0008\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\u0008\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001a5\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\u0008\u000cH\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\u0008\u000c2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\u0008\u000cH\u0001¢\u0006\u0002\u0010 \"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006!", d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AlertDialogKt {

    private static final long TextBaselineDistanceFromTitle;
    private static final long TextBaselineDistanceFromTop;
    private static final Modifier TextPadding;
    private static final long TitleBaselineDistanceFromTop;
    private static final Modifier TitlePadding;
    static {
        int i6 = 0;
        int i8 = 0;
        final int i16 = 0;
        AlertDialogKt.TitlePadding = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, Dp.constructor-impl((float)i), 0, Dp.constructor-impl((float)$this$dp$iv), 0, 10, i16);
        int i7 = 0;
        int i10 = 0;
        int i11 = 0;
        AlertDialogKt.TextPadding = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, Dp.constructor-impl((float)i2), 0, Dp.constructor-impl((float)$this$dp$iv2), Dp.constructor-impl((float)$this$dp$iv3), 2, i16);
        AlertDialogKt.TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
        AlertDialogKt.TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
        AlertDialogKt.TextBaselineDistanceFromTop = TextUnitKt.getSp(38);
    }

    public static final void AlertDialogBaselineLayout(ColumnScope $this$AlertDialogBaselineLayout, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Composer $composer, int $changed) {
        int traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Integer valueOf;
        Object $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242;
        int $dirty;
        int i11;
        int i17;
        int i15;
        boolean skipping;
        boolean traceInProgress2;
        androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout.2 iNSTANCE;
        int str;
        int valueOf2;
        Composer composer3;
        Composer composer6;
        Object currentCompositionLocalMap3;
        Object maybeCachedBoxMeasurePolicy2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        int i7;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        Object factory$iv$iv;
        int currentCompositeKeyHash3;
        int currentCompositeKeyHash;
        Object maybeCachedBoxMeasurePolicy;
        Composer composer7;
        int currentCompositionLocalMap;
        Modifier materializeModifier;
        int i12;
        Composer composer;
        int i16;
        Modifier modifier;
        Composer composer4;
        int i24;
        int i5;
        int i19;
        int i21;
        int i6;
        androidx.compose.material.AlertDialogKt.AlertDialogBaselineLayout.2 measurePolicy$iv;
        int i13;
        int i25;
        int i14;
        int i9;
        int i18;
        int i20;
        kotlin.jvm.functions.Function0 function0;
        int i26;
        int i;
        int i8;
        Alignment alignment;
        int currentCompositeKeyHash2;
        int i22;
        int i2;
        Object obj;
        Object $composer2;
        int i10;
        int i23;
        Composer composer5;
        androidx.compose.runtime.CompositionLocalMap map;
        int i3;
        int i4;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer2;
        Modifier modifier2;
        final Object obj2 = $this$AlertDialogBaselineLayout;
        final Object obj3 = title;
        final Object obj4 = text;
        final int i27 = $changed;
        traceInProgress = -555573207;
        $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242, "C(AlertDialogBaselineLayout)P(1)98@3653L3487:AlertDialog.kt#jmzs0o");
        if (i27 & 6 == 0) {
            i11 = $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.changed(obj2) ? 4 : 2;
            $dirty |= i11;
        }
        if (i27 & 48 == 0) {
            i17 = $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.changedInstance(obj3) ? 32 : 16;
            $dirty |= i17;
        }
        if (i27 & 384 == 0) {
            i15 = $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.changedInstance(obj4) ? 256 : 128;
            $dirty |= i15;
        }
        if ($dirty & 147 == 146) {
            if (!$this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:97)");
                }
                int i37 = 0;
                Modifier weight = obj2.weight((Modifier)Modifier.Companion, 1065353216, i37);
                iNSTANCE = AlertDialogKt.AlertDialogBaselineLayout.2.INSTANCE;
                maybeCachedBoxMeasurePolicy2 = 384;
                i7 = 0;
                currentCompositeKeyHash3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242, -1323940314, currentCompositeKeyHash3);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242, i37);
                currentCompositionLocalMap = $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.getCurrentCompositionLocalMap();
                i39 |= 6;
                kotlin.jvm.functions.Function0 function02 = constructor;
                i12 = 0;
                modifier = weight;
                String modifier$iv = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242, -692256719, modifier$iv);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.startReusableNode();
                if ($this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.getInserting()) {
                    $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.createNode(function02);
                } else {
                    factory$iv$iv = function02;
                    $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.useNode();
                }
                composer = $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242;
                Composer constructor-impl = Updater.constructor-impl(composer);
                int i60 = 0;
                i19 = $dirty;
                Updater.set-impl(constructor-impl, (MeasurePolicy)iNSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i5 = 0;
                Composer composer9 = constructor-impl;
                i6 = 0;
                if (!composer9.getInserting()) {
                    measurePolicy$iv = iNSTANCE;
                    i13 = valueOf2;
                    if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer9;
                    }
                } else {
                    measurePolicy$iv = iNSTANCE;
                    i13 = valueOf2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242, weight), ComposeUiNode.Companion.getSetModifier());
                $dirty = composer;
                i24 = i32;
                ComposerKt.sourceInformationMarkerStart($dirty, 1310698899, "C:AlertDialog.kt#jmzs0o");
                $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242 = "C73@3429L9:Box.kt#2w3rfo";
                str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i21 = i34;
                if (obj3 == null) {
                    $dirty.startReplaceGroup(1310700478);
                    $dirty.endReplaceGroup();
                    i14 = maybeCachedBoxMeasurePolicy2;
                    i9 = i7;
                    function0 = factory$iv$iv;
                    i26 = currentCompositeKeyHash;
                    map = currentCompositionLocalMap;
                } else {
                    $dirty.startReplaceGroup(1310700479);
                    ComposerKt.sourceInformation($dirty, "*101@3721L106");
                    i25 = 0;
                    i14 = maybeCachedBoxMeasurePolicy2;
                    i9 = i7;
                    Modifier align = obj2.align(LayoutIdKt.layoutId(AlertDialogKt.TitlePadding, "title"), Alignment.Companion.getStart());
                    i18 = 0;
                    i20 = i47;
                    ComposerKt.sourceInformationMarkerStart($dirty, 733328855, str);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    function0 = factory$iv$iv;
                    int factory$iv$iv2 = 0;
                    i26 = currentCompositeKeyHash;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, factory$iv$iv2);
                    i8 = 0;
                    alignment = topStart2;
                    ComposerKt.sourceInformationMarkerStart($dirty, -1323940314, currentCompositeKeyHash3);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($dirty, 0);
                    currentCompositionLocalMap2 = $dirty.getCurrentCompositionLocalMap();
                    i22 = factory$iv$iv2;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($dirty, align);
                    obj = align;
                    kotlin.jvm.functions.Function0 function04 = constructor3;
                    i2 = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, -692256719, modifier$iv);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $dirty.startReusableNode();
                    if ($dirty.getInserting()) {
                        $dirty.createNode(function04);
                    } else {
                        factory$iv$iv$iv2 = function04;
                        $dirty.useNode();
                    }
                    $composer2 = factory$iv$iv$iv2;
                    Composer constructor-impl2 = Updater.constructor-impl($dirty);
                    int i65 = 0;
                    map = currentCompositionLocalMap;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i68 = 0;
                    Composer composer11 = constructor-impl2;
                    int i69 = 0;
                    if (!composer11.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap2;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer7 = composer11;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap2;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    Composer composer8 = $dirty;
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242);
                    currentCompositionLocalMap = BoxScopeInstance.INSTANCE;
                    i67 |= 6;
                    i3 = 0;
                    i4 = i45;
                    modifier2 = materializeModifier2;
                    factory$iv$iv = composer5;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv, -155669870, "C102@3802L7:AlertDialog.kt#jmzs0o");
                    title.invoke(factory$iv$iv, 0);
                    ComposerKt.sourceInformationMarkerEnd(factory$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    $dirty.endNode();
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    $dirty.endReplaceGroup();
                }
                if (obj4 == null) {
                    $dirty.startReplaceGroup(1310868994);
                    $dirty.endReplaceGroup();
                    $composer2 = $dirty;
                } else {
                    $dirty.startReplaceGroup(1310868995);
                    ComposerKt.sourceInformation($dirty, "*106@3890L103");
                    Modifier align2 = obj2.align(LayoutIdKt.layoutId(AlertDialogKt.TextPadding, "text"), Alignment.Companion.getStart());
                    int i56 = 0;
                    currentCompositeKeyHash = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, 733328855, str);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i6 = i46;
                    i18 = 0;
                    i20 = topStart;
                    ComposerKt.sourceInformationMarkerStart($dirty, -1323940314, currentCompositeKeyHash3);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($dirty, 0);
                    currentCompositionLocalMap3 = $dirty.getCurrentCompositionLocalMap();
                    i8 = align2;
                    kotlin.jvm.functions.Function0 function03 = constructor2;
                    i = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, -692256719, modifier$iv);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $dirty.startReusableNode();
                    if ($dirty.getInserting()) {
                        $dirty.createNode(function03);
                    } else {
                        factory$iv$iv$iv = function03;
                        $dirty.useNode();
                    }
                    Composer constructor-impl3 = Updater.constructor-impl($dirty);
                    int i59 = 0;
                    i22 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i63 = 0;
                    Composer composer10 = constructor-impl3;
                    int i64 = 0;
                    if (!composer10.getInserting()) {
                        $composer2 = $dirty;
                        i10 = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer10;
                        }
                    } else {
                        $composer2 = $dirty;
                        i10 = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($dirty, align2), ComposeUiNode.Companion.getSetModifier());
                    $dirty = $composer2;
                    str = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242);
                    i53 |= 6;
                    composer4 = $dirty;
                    i5 = 0;
                    alignment = i29;
                    i2 = iNSTANCE2;
                    ComposerKt.sourceInformationMarkerStart($dirty, -155504237, "C107@3969L6:AlertDialog.kt#jmzs0o");
                    text.invoke($dirty, 0);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242.skipToGroupEnd();
                composer = $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242;
                i19 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242 = new AlertDialogKt.AlertDialogBaselineLayout.3(obj2, obj3, obj4, i27);
            endRestartGroup.updateScope((Function2)$this$AlertDialogBaselineLayout_u24lambda_u244_u24lambda_u243_u24lambda_u242);
        }
    }

    public static final void AlertDialogContent-WMdw5o4(Function2<? super Composer, ? super Integer, Unit> buttons, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> text, Shape shape, long backgroundColor, long contentColor, Composer $composer, int $changed, int i10) {
        boolean traceInProgress;
        int defaultsInvalid;
        int medium;
        int colors;
        int i12;
        int i5;
        boolean traceInProgress2;
        Object $composer2;
        int $dirty4;
        Object $dirty2;
        int i13;
        int i6;
        Object obj3;
        int str;
        Object obj2;
        Object obj;
        int i8;
        long l2;
        int $dirty;
        Object obj5;
        int i7;
        long l;
        Object obj4;
        int i9;
        Object shape2;
        int changed2;
        long backgroundColor2;
        long l3;
        int changed3;
        long contentColorFor-ek8zF_U;
        int i4;
        int changed;
        int $dirty3;
        int i2;
        int i11;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i;
        int i3;
        int obj32;
        final Object obj6 = buttons;
        final int i37 = obj33;
        Composer restartGroup = i10.startRestartGroup(-453679601);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogContent)P(1,3,6,5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color)50@1988L6,51@2046L6,52@2088L32,59@2266L911,54@2130L1047:AlertDialog.kt#jmzs0o");
        $dirty4 = obj33;
        if (obj34 & 1 != 0) {
            $dirty4 |= 6;
        } else {
            if (i37 & 6 == 0) {
                i6 = restartGroup.changedInstance(obj6) ? 4 : 2;
                $dirty4 |= i6;
            }
        }
        str = obj34 & 2;
        if (str != null) {
            $dirty4 |= 48;
            obj2 = modifier;
        } else {
            if (i37 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty4 |= i8;
            } else {
                obj2 = modifier;
            }
        }
        $dirty = obj34 & 4;
        if ($dirty != 0) {
            $dirty4 |= 384;
            obj5 = title;
        } else {
            if (i37 & 384 == 0) {
                i7 = restartGroup.changedInstance(title) ? 256 : 128;
                $dirty4 |= i7;
            } else {
                obj5 = title;
            }
        }
        int i35 = obj34 & 8;
        if (i35 != 0) {
            $dirty4 |= 3072;
            obj4 = text;
        } else {
            if (i37 & 3072 == 0) {
                i9 = restartGroup.changedInstance(text) ? 2048 : 1024;
                $dirty4 |= i9;
            } else {
                obj4 = text;
            }
        }
        if (i37 & 24576 == 0) {
            if (obj34 & 16 == 0) {
                changed2 = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                shape2 = shape;
            }
            $dirty4 |= changed2;
        } else {
            shape2 = shape;
        }
        if (i40 &= i37 == 0) {
            if (obj34 & 32 == 0) {
                changed3 = restartGroup.changed(backgroundColor) ? 131072 : 65536;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty4 |= changed3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        int i43 = 1572864;
        if (i37 & i43 == 0) {
            i4 = obj34 & 64;
            if (i4 == 0) {
                obj32 = i43;
                changed = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                obj32 = i43;
                contentColorFor-ek8zF_U = $composer;
            }
            $dirty4 |= changed;
        } else {
            obj32 = i43;
            contentColorFor-ek8zF_U = $composer;
        }
        $dirty3 = $dirty4;
        if ($dirty4 & i44 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i23 = -3670017;
                int i45 = -458753;
                int i46 = -57345;
                if (i37 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (str != null) {
                            obj2 = defaultsInvalid;
                        }
                        if ($dirty != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (i35 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        str = 6;
                        if (obj34 & 16 != 0) {
                            $dirty = $dirty3 & i46;
                            shape2 = medium;
                        } else {
                            $dirty = $dirty3;
                        }
                        if (obj34 & 32 != 0) {
                            backgroundColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, str).getSurface-0d7_KjU();
                            $dirty &= i45;
                        }
                        if (obj34 & 64 != 0) {
                            i13 = i5;
                            i4 = contentColorFor-ek8zF_U;
                            l3 = backgroundColor2;
                            backgroundColor2 = shape2;
                            shape2 = obj2;
                        } else {
                            i13 = $dirty;
                            i4 = contentColorFor-ek8zF_U;
                            l3 = backgroundColor2;
                            backgroundColor2 = shape2;
                            shape2 = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj34 & 16 != 0) {
                            $dirty3 = i12;
                        }
                        if (obj34 & 32 != 0) {
                            $dirty3 &= i45;
                        }
                        if (obj34 & 64 != 0) {
                            i13 = i5;
                            i4 = contentColorFor-ek8zF_U;
                            l3 = backgroundColor2;
                            backgroundColor2 = shape2;
                            shape2 = obj2;
                        } else {
                            i13 = $dirty3;
                            i4 = contentColorFor-ek8zF_U;
                            l3 = backgroundColor2;
                            backgroundColor2 = shape2;
                            shape2 = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-453679601, i13, -1, "androidx.compose.material.AlertDialogContent (AlertDialog.kt:53)");
                }
                AlertDialogKt.AlertDialogContent.1 anon = new AlertDialogKt.AlertDialogContent.1(obj5, obj4, obj6);
                SurfaceKt.Surface-F-jzlyU(shape2, backgroundColor2, l3, contentColorFor-ek8zF_U, i4, $dirty3, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(629950291, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj4;
                $composer2 = shape2;
                obj = backgroundColor2;
                l = i4;
                $dirty3 = i13;
                $dirty2 = obj5;
                l2 = l3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj2;
                $dirty2 = obj5;
                obj3 = obj4;
                obj = shape2;
                l2 = backgroundColor2;
                l = contentColorFor-ek8zF_U;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new AlertDialogKt.AlertDialogContent.2(obj6, $composer2, $dirty2, obj3, obj, l2, obj5, l, obj4, i37, obj34);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void AlertDialogFlowRow-ixp7dh8(float mainAxisSpacing, float crossAxisSpacing, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int i11;
        Integer invalid$iv;
        int $dirty;
        int i9;
        int i;
        int i8;
        boolean setCompositeKeyHash;
        boolean traceInProgress2;
        int i7;
        int i10;
        Integer valueOf;
        int companion;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object materializeModifier;
        kotlin.jvm.functions.Function0 constructor;
        Object anon;
        int i13;
        int i2;
        int i3;
        int i4;
        int i12;
        Composer composer;
        int i5;
        Object measurePolicy$iv;
        int i6;
        int obj26;
        final float f = mainAxisSpacing;
        final float f2 = crossAxisSpacing;
        final Object obj = content;
        final int i14 = $changed;
        traceInProgress = 73434452;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(AlertDialogFlowRow)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp)194@7414L3565,194@7398L3581:AlertDialog.kt#jmzs0o");
        i10 = 4;
        if (i14 & 6 == 0) {
            i9 = restartGroup.changed(f) ? i10 : 2;
            $dirty |= i9;
        }
        companion = 32;
        if (i14 & 48 == 0) {
            i = restartGroup.changed(f2) ? companion : 16;
            $dirty |= i;
        }
        if (i14 & 384 == 0) {
            i8 = restartGroup.changedInstance(obj) ? 256 : 128;
            $dirty |= i8;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:193)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2008223483, "CC(remember):AlertDialog.kt#9igjgp");
                int i26 = 0;
                i11 = $dirty & 14 == i10 ? i7 : i26;
                if ($dirty & 112 == companion) {
                } else {
                    i7 = i26;
                }
                Composer composer2 = restartGroup;
                int i24 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i27 = 0;
                if (i11 |= i7 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        materializeModifier = 0;
                        anon = new AlertDialogKt.AlertDialogFlowRow.1.1(f, f2);
                        composer2.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                invalid$iv = anon;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i20 &= 14;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i26);
                i2 = 0;
                obj26 = $dirty;
                i3 = i21;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                $dirty = Updater.constructor-impl(restartGroup);
                i12 = i22;
                Updater.set-impl($dirty, (MeasurePolicy)invalid$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($dirty, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i4 = 0;
                composer = $dirty;
                i5 = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv = invalid$iv;
                    i6 = valueOf;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        $dirty.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        i10 = composer;
                    }
                } else {
                    measurePolicy$iv = invalid$iv;
                    i6 = valueOf;
                }
                Updater.set-impl($dirty, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                obj.invoke(restartGroup, Integer.valueOf(i18 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj26 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new AlertDialogKt.AlertDialogFlowRow.2(f, f2, obj, i14);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final long access$getTextBaselineDistanceFromTitle$p() {
        return AlertDialogKt.TextBaselineDistanceFromTitle;
    }

    public static final long access$getTextBaselineDistanceFromTop$p() {
        return AlertDialogKt.TextBaselineDistanceFromTop;
    }

    public static final long access$getTitleBaselineDistanceFromTop$p() {
        return AlertDialogKt.TitleBaselineDistanceFromTop;
    }
}
