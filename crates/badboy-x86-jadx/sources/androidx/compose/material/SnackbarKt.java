package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001a3\u0010\u000b\u001a\u00020\u000c2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000c0\u000e¢\u0006\u0002\u0008\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u000c0\u000e¢\u0006\u0002\u0008\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\u000c2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000c0\u000e¢\u0006\u0002\u0008\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u000c0\u000e¢\u0006\u0002\u0008\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a`\u0010\u0013\u001a\u00020\u000c2\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001d2\u0008\u0008\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001ax\u0010\u0013\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0015\u0008\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u000e¢\u0006\u0002\u0008\u000f2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001d2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001d2\u0008\u0008\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u000c0\u000e¢\u0006\u0002\u0008\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008$\u0010%\u001a \u0010&\u001a\u00020\u000c2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\u000c0\u000e¢\u0006\u0002\u0008\u000fH\u0003¢\u0006\u0002\u0010'\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0008\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnackbarKt {

    private static final float HeightToFirstLine;
    private static final float HorizontalSpacing;
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset;
    private static final float SeparateButtonExtraY;
    private static final float SnackbarMinHeightOneLine;
    private static final float SnackbarMinHeightTwoLines;
    private static final float SnackbarVerticalPadding;
    private static final float TextEndExtraSpacing;
    static {
        int i10 = 0;
        SnackbarKt.HeightToFirstLine = Dp.constructor-impl((float)i);
        int i11 = 0;
        SnackbarKt.HorizontalSpacing = Dp.constructor-impl((float)i2);
        int i12 = 0;
        SnackbarKt.HorizontalSpacingButtonSide = Dp.constructor-impl((float)i3);
        int i13 = 0;
        SnackbarKt.SeparateButtonExtraY = Dp.constructor-impl((float)i4);
        int i14 = 0;
        SnackbarKt.SnackbarVerticalPadding = Dp.constructor-impl((float)i5);
        int i15 = 0;
        SnackbarKt.TextEndExtraSpacing = Dp.constructor-impl((float)i6);
        int i16 = 0;
        SnackbarKt.LongButtonVerticalOffset = Dp.constructor-impl((float)i7);
        int i17 = 0;
        SnackbarKt.SnackbarMinHeightOneLine = Dp.constructor-impl((float)i8);
        int i18 = 0;
        SnackbarKt.SnackbarMinHeightTwoLines = Dp.constructor-impl((float)i9);
    }

    private static final void NewLineButtonSnackbar(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Composer $composer, int $changed) {
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        boolean maybeCachedBoxMeasurePolicy;
        int traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Object $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243;
        int $dirty;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int i25;
        int i14;
        int skipping;
        boolean traceInProgress2;
        boolean currentCompositionLocalMap2;
        boolean currentCompositionLocalMap;
        int str;
        Composer composer;
        Composer composer5;
        Object $changed2;
        Integer valueOf;
        Modifier materializeModifier2;
        int i16;
        Object maybeCachedBoxMeasurePolicy2;
        Composer composer6;
        int i9;
        int i2;
        int i;
        int i3;
        Modifier materializeModifier;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        int currentCompositeKeyHash;
        int i23;
        int i22;
        int i10;
        Modifier modifier2;
        kotlin.jvm.functions.Function0 function02;
        int i18;
        int i11;
        int i4;
        int i24;
        int i26;
        Composer composer7;
        int i19;
        Composer composer8;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i15;
        int i5;
        int i20;
        ColumnScopeInstance columnScopeInstance;
        int i8;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        int i13;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        Alignment alignment;
        Modifier modifier3;
        int i7;
        int i17;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        Composer composer9;
        int i12;
        BoxScopeInstance iNSTANCE;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i21;
        Composer composer3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i6;
        Composer composer4;
        Modifier modifier;
        Composer obj60;
        final Object obj = text;
        final Object obj2 = action;
        final int i27 = $changed;
        traceInProgress = -1229075900;
        $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, "C(NewLineButtonSnackbar)P(1)294@12001L476:Snackbar.kt#jmzs0o");
        if (i27 & 6 == 0) {
            i25 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.changedInstance(obj) ? 4 : 2;
            $dirty |= i25;
        }
        if (i27 & 48 == 0) {
            i14 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.changedInstance(obj2) ? 32 : 16;
            $dirty |= i14;
        }
        if ($dirty & 19 == 18) {
            if (!$this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:293)");
                }
                Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, 1, 0), SnackbarKt.HorizontalSpacing, 0, SnackbarKt.HorizontalSpacingButtonSide, SnackbarKt.SeparateButtonExtraY, 2, 0);
                int i41 = 6;
                valueOf = i41;
                ComposerKt.sourceInformationMarkerStart($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                androidx.compose.foundation.layout.Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                androidx.compose.ui.layout.MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, start, $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, i65 |= i71);
                i3 = 0;
                String str4 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, -1323940314, str4);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, 0);
                currentCompositionLocalMap2 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.getCurrentCompositionLocalMap();
                modifier2 = padding-qDBjuR0$default;
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i10 = 0;
                i11 = $dirty;
                String $dirty2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, -692256719, $dirty2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.startReusableNode();
                if ($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.getInserting()) {
                    $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.createNode(function03);
                } else {
                    factory$iv$iv$iv2 = function03;
                    $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.useNode();
                }
                function02 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243);
                int i77 = 0;
                composer7 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i78 = 0;
                Composer composer14 = constructor-impl;
                int i79 = 0;
                if (!composer14.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    i15 = valueOf;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer14;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    i15 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, padding-qDBjuR0$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = composer7;
                i24 = i31;
                ComposerKt.sourceInformationMarkerStart(composer11, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance iNSTANCE2 = ColumnScopeInstance.INSTANCE;
                i19 = 0;
                i5 = i43;
                i20 = i53;
                $changed2 = composer13;
                ComposerKt.sourceInformationMarkerStart($changed2, -322444484, "C302@12244L171,306@12424L47:Snackbar.kt#jmzs0o");
                i26 = i58;
                Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(AlignmentLineKt.paddingFromBaseline-VpY3zN4((Modifier)Modifier.Companion, SnackbarKt.HeightToFirstLine, SnackbarKt.LongButtonVerticalOffset), 0, 0, SnackbarKt.HorizontalSpacingButtonSide, 0, 11, 0);
                int i80 = i44;
                int i82 = i59;
                String $i$f$Box = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($changed2, 733328855, $i$f$Box);
                Alignment topStart = Alignment.Companion.getTopStart();
                vertical = top;
                int verticalArrangement$iv = 0;
                horizontal = start;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, verticalArrangement$iv);
                int i90 = 0;
                Alignment alignment2 = topStart;
                ComposerKt.sourceInformationMarkerStart($changed2, -1323940314, str4);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($changed2, 0);
                currentCompositionLocalMap = $changed2.getCurrentCompositionLocalMap();
                int i92 = verticalArrangement$iv;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($changed2, padding-qDBjuR0$default2);
                Modifier modifier4 = padding-qDBjuR0$default2;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                int i93 = 0;
                ComposerKt.sourceInformationMarkerStart($changed2, -692256719, $dirty2);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $changed2.startReusableNode();
                if ($changed2.getInserting()) {
                    $changed2.createNode(function05);
                } else {
                    factory$iv$iv$iv3 = function05;
                    $changed2.useNode();
                }
                kotlin.jvm.functions.Function0 function06 = factory$iv$iv$iv3;
                Composer constructor-impl2 = Updater.constructor-impl($changed2);
                int i96 = 0;
                measurePolicy = columnMeasurePolicy;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i97 = 0;
                Composer composer16 = constructor-impl2;
                int i100 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer16;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = $changed2;
                int i62 = 0;
                i12 = i39;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv3);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i99 |= 6;
                i6 = 0;
                modifier = materializeModifier3;
                Composer materialized$iv$iv = composer3;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -559692806, "C305@12407L6:Snackbar.kt#jmzs0o");
                obj.invoke(materialized$iv$iv, Integer.valueOf(i11 & 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                $changed2.endNode();
                ComposerKt.sourceInformationMarkerEnd($changed2);
                ComposerKt.sourceInformationMarkerEnd($changed2);
                ComposerKt.sourceInformationMarkerEnd($changed2);
                Modifier align = (ColumnScope)iNSTANCE2.align((Modifier)Modifier.Companion, Alignment.Companion.getEnd());
                i16 = 0;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart($changed2, 733328855, $i$f$Box);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                columnScopeInstance = iNSTANCE2;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false);
                i13 = 0;
                alignment = topStart2;
                ComposerKt.sourceInformationMarkerStart($changed2, -1323940314, str4);
                i23 = currentCompositeKeyHash2;
                modifier3 = align;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i22 = 0;
                ComposerKt.sourceInformationMarkerStart($changed2, -692256719, $dirty2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $changed2.startReusableNode();
                if ($changed2.getInserting()) {
                    $changed2.createNode(function04);
                } else {
                    factory$iv$iv$iv = function04;
                    $changed2.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl($changed2);
                int i76 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, $changed2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i91 = 0;
                Composer composer15 = constructor-impl3;
                int i94 = 0;
                if (!composer15.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    composer9 = $changed2;
                    if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(i23))) {
                        composer15.updateRememberedValue(Integer.valueOf(i23));
                        constructor-impl3.apply(Integer.valueOf(i23), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer15;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    composer9 = $changed2;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($changed2, align), ComposeUiNode.Companion.getSetModifier());
                $dirty = composer9;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, $changed$iv3);
                i56 |= 6;
                obj60 = $dirty;
                i4 = 0;
                i7 = i33;
                boxScopeInstance = iNSTANCE3;
                ComposerKt.sourceInformationMarkerStart($dirty, -559639176, "C306@12461L8:Snackbar.kt#jmzs0o");
                obj2.invoke($dirty, Integer.valueOf(i34 &= 14));
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                composer9.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.skipToGroupEnd();
                composer7 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243;
                i11 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer7.endRestartGroup();
        if (endRestartGroup != null) {
            $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243 = new SnackbarKt.NewLineButtonSnackbar.2(obj, obj2, i27);
            endRestartGroup.updateScope((Function2)$this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243);
        }
    }

    private static final void OneRowSnackbar(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Composer $composer, int $changed) {
        int traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object $changed$iv2;
        boolean currentCompositionLocalMap2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int $dirty;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        boolean valueOf;
        int i11;
        int i6;
        boolean skipping;
        boolean traceInProgress2;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy2;
        int str;
        Modifier materializeModifier;
        boolean valueOf2;
        Composer composer5;
        Object maybeCachedBoxMeasurePolicy;
        int i5;
        Composer composer7;
        Integer valueOf3;
        Alignment topStart;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        int i;
        int currentCompositeKeyHash;
        Object empty;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i12;
        int i8;
        Composer composer8;
        int i20;
        Modifier modifier3;
        Composer composer4;
        int i14;
        String str2;
        kotlin.jvm.functions.Function0 function0;
        int i18;
        int i13;
        int $changed$iv;
        int i10;
        String str3;
        int i2;
        int i7;
        int i19;
        Modifier modifier;
        int i9;
        int i3;
        kotlin.jvm.functions.Function0 function02;
        BoxScopeInstance boxScopeInstance;
        int i16;
        Composer $composer2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Composer composer3;
        BoxScopeInstance iNSTANCE;
        Modifier modifier2;
        int i15;
        Composer composer2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i17;
        Composer composer6;
        int i4;
        int obj53;
        final Object obj = text;
        final Object obj2 = action;
        final int i21 = $changed;
        traceInProgress = -534813202;
        $changed$iv2 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($changed$iv2, "C(OneRowSnackbar)P(1)326@12977L2198,317@12652L2523:Snackbar.kt#jmzs0o");
        if (i21 & 6 == 0) {
            i11 = $changed$iv2.changedInstance(obj) ? 4 : 2;
            $dirty |= i11;
        }
        if (i21 & 48 == 0) {
            i6 = $changed$iv2.changedInstance(obj2) ? 32 : 16;
            $dirty |= i6;
        }
        if ($dirty & 19 == 18) {
            if (!$changed$iv2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:314)");
                }
                String str4 = "text";
                String str6 = "action";
                Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, SnackbarKt.HorizontalSpacing, 0, SnackbarKt.HorizontalSpacingButtonSide, 0, 10, 0);
                ComposerKt.sourceInformationMarkerStart($changed$iv2, -1075355883, "CC(remember):Snackbar.kt#9igjgp");
                int i42 = 0;
                Composer composer10 = $changed$iv2;
                int i51 = 0;
                Object rememberedValue4 = composer10.rememberedValue();
                int i57 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = new SnackbarKt.OneRowSnackbar.2.1(str6, str4);
                    composer10.updateRememberedValue((MeasurePolicy)anon);
                } else {
                    anon = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd($changed$iv2);
                valueOf2 = 432;
                valueOf3 = 0;
                String str9 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($changed$iv2, -1323940314, str9);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($changed$iv2, 0);
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($changed$iv2, padding-qDBjuR0$default);
                i54 |= 6;
                kotlin.jvm.functions.Function0 function03 = constructor;
                i12 = 0;
                i20 = $dirty;
                modifier3 = padding-qDBjuR0$default;
                String modifier$iv3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($changed$iv2, -692256719, modifier$iv3);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $changed$iv2.startReusableNode();
                if ($changed$iv2.getInserting()) {
                    $changed$iv2.createNode(function03);
                } else {
                    factory$iv$iv = function03;
                    $changed$iv2.useNode();
                }
                composer8 = $changed$iv2;
                Composer constructor-impl2 = Updater.constructor-impl(composer8);
                int i65 = 0;
                function0 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, $changed$iv2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i66 = 0;
                Composer composer11 = constructor-impl2;
                int i67 = 0;
                if (!composer11.getInserting()) {
                    $changed$iv = valueOf2;
                    i10 = valueOf3;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer11;
                    }
                } else {
                    $changed$iv = valueOf2;
                    i10 = valueOf3;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                valueOf = composer8;
                i14 = i30;
                ComposerKt.sourceInformationMarkerStart(valueOf, -16000972, "C319@12682L86,320@12781L46:Snackbar.kt#jmzs0o");
                str2 = str4;
                i18 = i43;
                i13 = i55;
                Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, str4), 0, SnackbarKt.SnackbarVerticalPadding, 1, 0);
                String str8 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, str8);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                int i68 = i31;
                int $changed$iv4 = 0;
                int i70 = i44;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, $changed$iv4);
                int i73 = 0;
                int i74 = $changed$iv4;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, str9);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf, 0);
                currentCompositionLocalMap2 = valueOf.getCurrentCompositionLocalMap();
                Alignment alignment = topStart2;
                Modifier modifier4 = padding-VpY3zN4$default;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                int i76 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, modifier$iv3);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf.startReusableNode();
                if (valueOf.getInserting()) {
                    valueOf.createNode(function05);
                } else {
                    factory$iv$iv$iv2 = function05;
                    valueOf.useNode();
                }
                kotlin.jvm.functions.Function0 function06 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(valueOf);
                int i79 = 0;
                modifier2 = materializeModifier3;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i81 = 0;
                Composer composer13 = constructor-impl;
                int i84 = 0;
                if (!composer13.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer13;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = valueOf;
                int i80 = i25;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv3);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i83 |= 6;
                i17 = 0;
                i4 = i45;
                Composer $i$a$LayoutBoxKt$Box$1$iv = composer2;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -1078382464, "C319@12760L6:Snackbar.kt#jmzs0o");
                obj.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i20 & 14));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                valueOf.endNode();
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, str6);
                int i46 = 6;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, str8);
                str3 = str6;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, str9);
                obj53 = currentCompositeKeyHash2;
                modifier = layoutId2;
                kotlin.jvm.functions.Function0 function04 = constructor2;
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, modifier$iv3);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf.startReusableNode();
                if (valueOf.getInserting()) {
                    valueOf.createNode(function04);
                } else {
                    factory$iv$iv$iv = function04;
                    valueOf.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(valueOf);
                int i64 = 0;
                function02 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, valueOf.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i75 = 0;
                Composer composer12 = constructor-impl3;
                int i77 = 0;
                if (!composer12.getInserting()) {
                    $composer2 = valueOf;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(obj53))) {
                        composer12.updateRememberedValue(Integer.valueOf(obj53));
                        constructor-impl3.apply(Integer.valueOf(obj53), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer12;
                    }
                } else {
                    $composer2 = valueOf;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier(valueOf, layoutId2), ComposeUiNode.Companion.getSetModifier());
                $dirty = $composer2;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, $changed$iv3);
                i40 |= 6;
                composer4 = $dirty;
                i9 = 0;
                boxScopeInstance = iNSTANCE2;
                i16 = i37;
                ComposerKt.sourceInformationMarkerStart($dirty, -1078325858, "C320@12817L8:Snackbar.kt#jmzs0o");
                obj2.invoke($dirty, Integer.valueOf(i26 &= 14));
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                composer8.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $changed$iv2.skipToGroupEnd();
                composer8 = $changed$iv2;
                i20 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer8.endRestartGroup();
        if (endRestartGroup != null) {
            $changed$iv2 = new SnackbarKt.OneRowSnackbar.3(obj, obj2, i21);
            endRestartGroup.updateScope((Function2)$changed$iv2);
        }
    }

    public static final void Snackbar-7zSek6w(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> action, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, float elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        float f2;
        int i2;
        int elevation2;
        int defaultsInvalid;
        int small;
        int shape2;
        androidx.compose.material.Colors colors;
        Object $composer2;
        int $dirty2;
        long $dirty4;
        int $i$f$getDp;
        Object obj4;
        int i3;
        boolean z;
        Object obj6;
        boolean traceInProgress;
        Object obj3;
        int i7;
        int str;
        long l;
        Object obj;
        int i6;
        long l2;
        boolean z2;
        int i8;
        Object obj5;
        float f3;
        int changed2;
        long backgroundColor2;
        Object obj2;
        int changed;
        int $dirty3;
        long $dirty5;
        int $dirty;
        int changed3;
        long i9;
        int i10;
        int i5;
        int contentColor2;
        float f;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i;
        int i4;
        int obj35;
        final Object obj8 = $changed;
        final int i46 = obj36;
        final int i47 = obj37;
        Composer restartGroup = i11.startRestartGroup(-558258760);
        ComposerKt.sourceInformation(restartGroup, "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)87@4085L6,88@4145L15,89@4202L6,99@4455L464,93@4288L631:Snackbar.kt#jmzs0o");
        $dirty2 = obj36;
        int i25 = i47 & 1;
        if (i25 != 0) {
            $dirty2 |= 6;
            obj6 = modifier;
        } else {
            if (i46 & 6 == 0) {
                i7 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                obj6 = modifier;
            }
        }
        str = i47 & 2;
        if (str != null) {
            $dirty2 |= 48;
            obj = action;
        } else {
            if (i46 & 48 == 0) {
                i6 = restartGroup.changedInstance(action) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                obj = action;
            }
        }
        int i41 = i47 & 4;
        if (i41 != 0) {
            $dirty2 |= 384;
            z2 = actionOnNewLine;
        } else {
            if (i46 & 384 == 0) {
                i8 = restartGroup.changed(actionOnNewLine) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                z2 = actionOnNewLine;
            }
        }
        if (i46 & 3072 == 0) {
            if (i47 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj5 = shape;
            }
            $dirty2 |= changed2;
        } else {
            obj5 = shape;
        }
        if (i46 & 24576 == 0) {
            if (i47 & 16 == 0) {
                changed = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= changed;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (i50 &= i46 == 0) {
            if (i47 & 32 == 0) {
                $dirty = $dirty2;
                obj35 = i25;
                changed3 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                $dirty = $dirty2;
                obj35 = i25;
                $dirty4 = elevation;
            }
            $dirty |= changed3;
        } else {
            $dirty3 = $dirty2;
            obj35 = i25;
            $dirty4 = elevation;
        }
        int i53 = i47 & 64;
        i9 = 1572864;
        if (i53 != 0) {
            $dirty3 |= i9;
            f2 = $composer;
        } else {
            if (i46 & i9 == 0) {
                i5 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty3 |= i5;
            } else {
                f2 = $composer;
            }
        }
        contentColor2 = 12582912;
        if (i47 & 128 != 0) {
            $dirty3 |= contentColor2;
        } else {
            if (i46 & contentColor2 == 0) {
                i2 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty3 |= i2;
            }
        }
        if (i13 &= $dirty3 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i19 = -458753;
                int i26 = -57345;
                if (i46 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj35 != null) {
                            obj6 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj = defaultsInvalid;
                        }
                        if (i41 != 0) {
                            z2 = defaultsInvalid;
                        }
                        str = 6;
                        if (i47 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj5 = small;
                        }
                        if (i47 & 16 != 0) {
                            backgroundColor2 = SnackbarDefaults.INSTANCE.getBackgroundColor(restartGroup, str);
                            $dirty3 &= i26;
                        }
                        if (i47 & 32 != 0) {
                            contentColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, str).getSurface-0d7_KjU();
                            $dirty3 &= i19;
                        } else {
                            contentColor2 = elevation;
                        }
                        if (i53 != 0) {
                            int i24 = 0;
                            $i$f$getDp = i9;
                            i9 = contentColor2;
                            i3 = -558258760;
                            f = $this$dp$iv;
                            elevation2 = $dirty3;
                            $dirty5 = backgroundColor2;
                            backgroundColor2 = obj6;
                            obj2 = obj5;
                        } else {
                            elevation2 = $dirty3;
                            $i$f$getDp = i9;
                            i9 = contentColor2;
                            i3 = -558258760;
                            f = $composer;
                            $dirty5 = backgroundColor2;
                            backgroundColor2 = obj6;
                            obj2 = obj5;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i47 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i47 & 16 != 0) {
                            $dirty3 &= i26;
                        }
                        if (i47 & 32 != 0) {
                            elevation2 = $dirty3 & i19;
                            f = $composer;
                            $dirty5 = backgroundColor2;
                            $i$f$getDp = i9;
                            i3 = -558258760;
                            i9 = elevation;
                            backgroundColor2 = obj6;
                            obj2 = obj5;
                        } else {
                            f = $composer;
                            elevation2 = $dirty3;
                            $i$f$getDp = i9;
                            i3 = -558258760;
                            i9 = elevation;
                            $dirty5 = backgroundColor2;
                            backgroundColor2 = obj6;
                            obj2 = obj5;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i3, elevation2, -1, "androidx.compose.material.Snackbar (Snackbar.kt:92)");
                }
                SnackbarKt.Snackbar.1 anon = new SnackbarKt.Snackbar.1(obj, obj8, z2);
                SurfaceKt.Surface-F-jzlyU(backgroundColor2, obj2, $dirty5, i53, i9, i10, 0, f, (Function2)ComposableLambdaKt.rememberComposableLambda(-2084221700, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj;
                z = z2;
                $composer2 = backgroundColor2;
                obj3 = obj2;
                l = $dirty5;
                l2 = i9;
                f3 = f;
                $dirty3 = elevation2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj6;
                obj4 = obj;
                z = z2;
                obj3 = obj5;
                l = backgroundColor2;
                l2 = elevation;
                f3 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            elevation2 = new SnackbarKt.Snackbar.2($composer2, obj4, z, obj3, l, obj, l2, z2, f3, obj8, i46, i47);
            endRestartGroup.updateScope((Function2)elevation2);
        }
    }

    public static final void Snackbar-sPrSdHI(androidx.compose.material.SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, long actionColor, float elevation, Composer $composer, int $changed, int i11) {
        long l;
        float f;
        boolean $dirty3;
        int defaultsInvalid;
        int small;
        int shape2;
        int colors;
        int iNSTANCE;
        int obj;
        int i5;
        Object $composer2;
        int $dirty2;
        boolean $dirty;
        int i2;
        Object obj3;
        int i8;
        boolean changedInstance;
        Object obj5;
        long modifier2;
        int i9;
        int actionLabel;
        boolean traceInProgress;
        boolean str;
        long l4;
        int i7;
        Object obj4;
        int changed;
        long backgroundColor2;
        long l5;
        int rememberComposableLambda;
        Object obj2;
        int changed3;
        int i14;
        int i10;
        float f2;
        int i12;
        boolean changed4;
        long surface-0d7_KjU;
        int i6;
        int i;
        int changed2;
        int i3;
        int actionColor2;
        long actionColor3;
        long l2;
        long l6;
        float f3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i13;
        int i4;
        long l3;
        obj = snackbarData;
        final int i53 = obj41;
        final int i54 = obj42;
        Composer restartGroup = obj40.startRestartGroup(258660814);
        ComposerKt.sourceInformation(restartGroup, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)158@7262L6,159@7322L15,160@7379L6,161@7437L18,178@7986L30,176@7914L320:Snackbar.kt#jmzs0o");
        $dirty2 = obj41;
        if (i54 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i53 & 6 == 0) {
                if (i53 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj);
                } else {
                    changedInstance = restartGroup.changedInstance(obj);
                }
                i2 = changedInstance != null ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        int i23 = i54 & 2;
        if (i23 != 0) {
            $dirty2 |= 48;
            obj5 = modifier;
        } else {
            if (i53 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i9;
            } else {
                obj5 = modifier;
            }
        }
        actionLabel = i54 & 4;
        if (actionLabel != 0) {
            $dirty2 |= 384;
            str = actionOnNewLine;
        } else {
            if (i53 & 384 == 0) {
                i7 = restartGroup.changed(actionOnNewLine) ? 256 : 128;
                $dirty2 |= i7;
            } else {
                str = actionOnNewLine;
            }
        }
        if (i53 & 3072 == 0) {
            if (i54 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj4 = shape;
            }
            $dirty2 |= changed;
        } else {
            obj4 = shape;
        }
        if (i53 & 24576 == 0) {
            if (i54 & 16 == 0) {
                changed3 = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty2 |= changed3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (i49 &= i53 == 0) {
            if (i54 & 32 == 0) {
                i14 = restartGroup.changed(actionColor) ? 131072 : 65536;
            } else {
                surface-0d7_KjU = actionColor;
            }
            $dirty2 |= i14;
        } else {
            surface-0d7_KjU = actionColor;
        }
        if (i50 &= i53 == 0) {
            if (i54 & 64 == 0) {
                changed2 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                l = $composer;
            }
            $dirty2 |= changed2;
        } else {
            l = $composer;
        }
        i12 = i54 & 128;
        i3 = 12582912;
        if (i12 != 0) {
            $dirty2 |= i3;
            f = i11;
        } else {
            if (i53 & i3 == 0) {
                obj = restartGroup.changed(i11) ? 8388608 : 4194304;
                $dirty2 |= obj;
            } else {
                f = i11;
            }
        }
        if (i22 &= $dirty2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i5 = -3670017;
                int i55 = -458753;
                int i56 = -57345;
                if (i53 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i23 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (actionLabel != 0) {
                            str = defaultsInvalid;
                        }
                        int i28 = 6;
                        if (i54 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj4 = small;
                        }
                        if (i54 & 16 != 0) {
                            backgroundColor2 = SnackbarDefaults.INSTANCE.getBackgroundColor(restartGroup, i28);
                            $dirty2 &= i56;
                        }
                        if (i54 & 32 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors(restartGroup, i28).getSurface-0d7_KjU();
                            $dirty2 &= i55;
                        }
                        if (i54 & 64 != 0) {
                            actionColor3 = SnackbarDefaults.INSTANCE.getPrimaryActionColor(restartGroup, i28);
                            $dirty2 &= i5;
                        } else {
                            actionColor3 = $composer;
                        }
                        if (i12 != 0) {
                            i5 = 0;
                            f3 = $this$dp$iv;
                            l6 = surface-0d7_KjU;
                            i8 = i3;
                            $dirty3 = actionColor3;
                            i3 = str;
                            actionColor2 = obj4;
                            l2 = backgroundColor2;
                        } else {
                            f3 = i11;
                            l6 = surface-0d7_KjU;
                            i8 = i3;
                            $dirty3 = actionColor3;
                            i3 = str;
                            actionColor2 = obj4;
                            l2 = backgroundColor2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i54 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (i54 & 16 != 0) {
                            $dirty2 &= i56;
                        }
                        if (i54 & 32 != 0) {
                            $dirty2 &= i55;
                        }
                        if (i54 & 64 != 0) {
                            f3 = i11;
                            $dirty2 = i20;
                            actionColor2 = obj4;
                            l2 = backgroundColor2;
                            l6 = surface-0d7_KjU;
                            i8 = i3;
                            $dirty3 = $composer;
                            i3 = str;
                        } else {
                            $dirty3 = $composer;
                            f3 = i11;
                            actionColor2 = obj4;
                            l2 = backgroundColor2;
                            l6 = surface-0d7_KjU;
                            i8 = i3;
                            i3 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, $dirty2, -1, "androidx.compose.material.Snackbar (Snackbar.kt:163)");
                }
                actionLabel = snackbarData.getActionLabel();
                int i32 = 54;
                int i42 = 1;
                if (actionLabel != null) {
                    restartGroup.startReplaceGroup(1609178760);
                    ComposerKt.sourceInformation(restartGroup, "166@7634L243");
                    SnackbarKt.Snackbar.actionComposable.1 anon2 = new SnackbarKt.Snackbar.actionComposable.1($dirty3, i5, snackbarData, actionLabel);
                    restartGroup.endReplaceGroup();
                    i = rememberComposableLambda;
                } else {
                    obj2 = snackbarData;
                    restartGroup.startReplaceGroup(1609445763);
                    restartGroup.endReplaceGroup();
                    i = rememberComposableLambda;
                }
                int i51 = 0;
                SnackbarKt.Snackbar.3 anon = new SnackbarKt.Snackbar.3(obj2);
                SnackbarKt.Snackbar-7zSek6w(PaddingKt.padding-3ABfNKs(obj5, Dp.constructor-impl((float)i45)), i, i3, actionColor2, l2, obj19, l6, obj21, f3, (Function2)ComposableLambdaKt.rememberComposableLambda(-261845785, i42, anon, restartGroup, i32), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l5 = $dirty3;
                i6 = $dirty2;
                $composer2 = obj5;
                $dirty = i3;
                obj3 = actionColor2;
                modifier2 = l2;
                l4 = l6;
                f2 = f3;
            } else {
                restartGroup.skipToGroupEnd();
                f2 = i11;
                composer = restartGroup;
                $composer2 = obj5;
                obj3 = obj4;
                modifier2 = backgroundColor2;
                l5 = $composer;
                i6 = $dirty2;
                $dirty = str;
                l4 = l3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = new SnackbarKt.Snackbar.4(snackbarData, $composer2, $dirty, obj3, modifier2, actionLabel, l4, obj4, l5, obj2, f2, i53, i54);
            endRestartGroup.updateScope((Function2)$dirty3);
        }
    }

    private static final void TextOnlySnackbar(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Integer iNSTANCE;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int traceInProgress2;
        boolean valueOf2;
        Object $composer$iv;
        int materialized$iv$iv;
        Composer composer;
        int i4;
        int skipping;
        boolean traceInProgress;
        Composer composer2;
        Integer valueOf;
        int maybeCachedBoxMeasurePolicy;
        int i18;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        androidx.compose.ui.Modifier.Companion companion;
        int i;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        kotlin.jvm.functions.Function0 constructor;
        int i7;
        Composer composer4;
        int i14;
        int i13;
        int i9;
        int i17;
        int i15;
        Composer composer5;
        int i6;
        int i8;
        androidx.compose.material.SnackbarKt.TextOnlySnackbar.2 measurePolicy$iv;
        int i5;
        int i12;
        int i10;
        int i16;
        Alignment alignment;
        Modifier modifier2;
        int i3;
        int i2;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer3;
        Composer $composer2;
        int i11;
        Modifier modifier;
        int obj41;
        final Object obj = content;
        final int i19 = $changed;
        traceInProgress2 = 917397959;
        $composer$iv = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation($composer$iv, "C(TextOnlySnackbar)239@10057L1816:Snackbar.kt#jmzs0o");
        maybeCachedBoxMeasurePolicy = 2;
        if (i19 & 6 == 0) {
            i4 = $composer$iv.changedInstance(obj) ? 4 : maybeCachedBoxMeasurePolicy;
            materialized$iv$iv |= i4;
        }
        if (materialized$iv$iv & 3 == maybeCachedBoxMeasurePolicy) {
            if (!$composer$iv.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, materialized$iv$iv, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:238)");
                }
                iNSTANCE = SnackbarKt.TextOnlySnackbar.2.INSTANCE;
                int i31 = 384;
                String str3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1323940314, str3);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer$iv, 0);
                i14 = 0;
                String str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer$iv, -692256719, str2);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    $composer$iv.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    $composer$iv.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl($composer$iv);
                int i44 = 0;
                composer5 = $composer$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)iNSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, $composer$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i45 = 0;
                Composer composer7 = constructor-impl2;
                int i46 = 0;
                if (!composer7.getInserting()) {
                    measurePolicy$iv = iNSTANCE;
                    i5 = materialized$iv$iv;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer7;
                    }
                } else {
                    measurePolicy$iv = iNSTANCE;
                    i5 = materialized$iv$iv;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier($composer$iv, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                valueOf2 = composer5;
                i17 = i21;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 1169284118, "C240@10074L202:Snackbar.kt#jmzs0o");
                i15 = i28;
                Modifier padding-VpY3zN4 = PaddingKt.padding-VpY3zN4((Modifier)Modifier.Companion, SnackbarKt.HorizontalSpacing, SnackbarKt.SnackbarVerticalPadding);
                i = 0;
                i6 = i29;
                i8 = i31;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                valueOf = 0;
                i12 = i32;
                i16 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str3);
                obj41 = currentCompositeKeyHash2;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(valueOf2, padding-VpY3zN4);
                modifier2 = padding-VpY3zN4;
                kotlin.jvm.functions.Function0 function02 = constructor2;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, str2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf2.startReusableNode();
                if (valueOf2.getInserting()) {
                    valueOf2.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    valueOf2.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(valueOf2);
                int i43 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(topStart, valueOf), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, valueOf2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i48 = 0;
                Composer composer8 = constructor-impl;
                int i49 = 0;
                if (!composer8.getInserting()) {
                    $composer2 = valueOf2;
                    i11 = valueOf;
                    if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(obj41))) {
                        composer8.updateRememberedValue(Integer.valueOf(obj41));
                        constructor-impl.apply(Integer.valueOf(obj41), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer8;
                    }
                } else {
                    $composer2 = valueOf2;
                    i11 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer6 = $composer2;
                skipping = 0;
                i9 = i25;
                ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i36 |= 6;
                i3 = 0;
                boxScopeInstance = iNSTANCE2;
                modifier = materializeModifier2;
                materialized$iv$iv = composer4;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 2052531256, "C246@10257L9:Snackbar.kt#jmzs0o");
                obj.invoke(materialized$iv$iv, Integer.valueOf(i5 & 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer$iv.skipToGroupEnd();
                composer5 = $composer$iv;
                i5 = materialized$iv$iv;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            $composer$iv = new SnackbarKt.TextOnlySnackbar.3(obj, i19);
            endRestartGroup.updateScope((Function2)$composer$iv);
        }
    }

    public static final void access$NewLineButtonSnackbar(Function2 text, Function2 action, Composer $composer, int $changed) {
        SnackbarKt.NewLineButtonSnackbar(text, action, $composer, $changed);
    }

    public static final void access$OneRowSnackbar(Function2 text, Function2 action, Composer $composer, int $changed) {
        SnackbarKt.OneRowSnackbar(text, action, $composer, $changed);
    }

    public static final void access$TextOnlySnackbar(Function2 content, Composer $composer, int $changed) {
        SnackbarKt.TextOnlySnackbar(content, $composer, $changed);
    }

    public static final float access$getHeightToFirstLine$p() {
        return SnackbarKt.HeightToFirstLine;
    }

    public static final float access$getSnackbarMinHeightOneLine$p() {
        return SnackbarKt.SnackbarMinHeightOneLine;
    }

    public static final float access$getSnackbarMinHeightTwoLines$p() {
        return SnackbarKt.SnackbarMinHeightTwoLines;
    }

    public static final float access$getTextEndExtraSpacing$p() {
        return SnackbarKt.TextEndExtraSpacing;
    }
}
