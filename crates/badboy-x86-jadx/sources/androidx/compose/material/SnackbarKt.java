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
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        boolean maybeCachedBoxMeasurePolicy;
        int traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243;
        int $dirty;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        int i9;
        int i4;
        int skipping;
        boolean traceInProgress2;
        boolean currentCompositionLocalMap2;
        boolean currentCompositionLocalMap3;
        int str;
        Composer composer5;
        Composer composer8;
        Object $changed2;
        Integer valueOf;
        Modifier materializeModifier2;
        int i22;
        Object maybeCachedBoxMeasurePolicy2;
        Composer composer9;
        int i17;
        int i26;
        int i24;
        int i6;
        Modifier materializeModifier;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int currentCompositeKeyHash;
        int i16;
        int i18;
        int i8;
        Modifier modifier3;
        kotlin.jvm.functions.Function0 function02;
        int i11;
        int i3;
        int i15;
        int i13;
        int i2;
        Composer composer4;
        int i20;
        Composer composer7;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        int i21;
        int i25;
        int i12;
        ColumnScopeInstance columnScopeInstance;
        int i14;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        int i;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        Alignment alignment;
        Modifier modifier2;
        int i7;
        int i19;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        Composer composer;
        int i10;
        BoxScopeInstance iNSTANCE;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i5;
        Composer composer6;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i23;
        Composer composer3;
        Modifier modifier;
        Composer obj60;
        final Object obj = text;
        final Object obj2 = action;
        final int i27 = $changed;
        traceInProgress = -1229075900;
        $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, "C(NewLineButtonSnackbar)P(1)294@12001L476:Snackbar.kt#jmzs0o");
        if (i27 & 6 == 0) {
            i9 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.changedInstance(obj) ? 4 : 2;
            $dirty |= i9;
        }
        if (i27 & 48 == 0) {
            i4 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.changedInstance(obj2) ? 32 : 16;
            $dirty |= i4;
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
                i6 = 0;
                String str5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, -1323940314, str5);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, 0);
                currentCompositionLocalMap2 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.getCurrentCompositionLocalMap();
                modifier3 = padding-qDBjuR0$default;
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i8 = 0;
                i3 = $dirty;
                String $dirty2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, -692256719, $dirty2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.startReusableNode();
                if ($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.getInserting()) {
                    $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.createNode(function03);
                } else {
                    factory$iv$iv$iv = function03;
                    $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.useNode();
                }
                function02 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243);
                int i77 = 0;
                composer4 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i78 = 0;
                Composer composer14 = constructor-impl;
                int i79 = 0;
                if (!composer14.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    i21 = valueOf;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer14;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    i21 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243, padding-qDBjuR0$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = composer4;
                i13 = i31;
                ComposerKt.sourceInformationMarkerStart(composer11, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance iNSTANCE2 = ColumnScopeInstance.INSTANCE;
                i20 = 0;
                i25 = i43;
                i12 = i53;
                $changed2 = composer13;
                ComposerKt.sourceInformationMarkerStart($changed2, -322444484, "C302@12244L171,306@12424L47:Snackbar.kt#jmzs0o");
                i2 = i58;
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
                ComposerKt.sourceInformationMarkerStart($changed2, -1323940314, str5);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($changed2, 0);
                currentCompositionLocalMap3 = $changed2.getCurrentCompositionLocalMap();
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
                    factory$iv$iv$iv2 = function05;
                    $changed2.useNode();
                }
                kotlin.jvm.functions.Function0 function06 = factory$iv$iv$iv2;
                Composer constructor-impl2 = Updater.constructor-impl($changed2);
                int i96 = 0;
                measurePolicy = columnMeasurePolicy;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i97 = 0;
                Composer composer16 = constructor-impl2;
                int i100 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer9 = composer16;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = $changed2;
                int i62 = 0;
                i10 = i39;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv3);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i99 |= 6;
                i23 = 0;
                modifier = materializeModifier3;
                Composer materialized$iv$iv = composer6;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -559692806, "C305@12407L6:Snackbar.kt#jmzs0o");
                obj.invoke(materialized$iv$iv, Integer.valueOf(i3 & 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                $changed2.endNode();
                ComposerKt.sourceInformationMarkerEnd($changed2);
                ComposerKt.sourceInformationMarkerEnd($changed2);
                ComposerKt.sourceInformationMarkerEnd($changed2);
                Modifier align = (ColumnScope)iNSTANCE2.align((Modifier)Modifier.Companion, Alignment.Companion.getEnd());
                i22 = 0;
                i17 = 0;
                ComposerKt.sourceInformationMarkerStart($changed2, 733328855, $i$f$Box);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                columnScopeInstance = iNSTANCE2;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false);
                i = 0;
                alignment = topStart2;
                ComposerKt.sourceInformationMarkerStart($changed2, -1323940314, str5);
                i16 = currentCompositeKeyHash2;
                modifier2 = align;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart($changed2, -692256719, $dirty2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $changed2.startReusableNode();
                if ($changed2.getInserting()) {
                    $changed2.createNode(function04);
                } else {
                    factory$iv$iv$iv3 = function04;
                    $changed2.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl($changed2);
                int i76 = 0;
                function0 = factory$iv$iv$iv3;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, $changed2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i91 = 0;
                Composer composer15 = constructor-impl3;
                int i94 = 0;
                if (!composer15.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    composer = $changed2;
                    if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(i16))) {
                        composer15.updateRememberedValue(Integer.valueOf(i16));
                        constructor-impl3.apply(Integer.valueOf(i16), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer15;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    composer = $changed2;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($changed2, align), ComposeUiNode.Companion.getSetModifier());
                $dirty = composer;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, $changed$iv3);
                i56 |= 6;
                obj60 = $dirty;
                i15 = 0;
                i7 = i33;
                boxScopeInstance = iNSTANCE3;
                ComposerKt.sourceInformationMarkerStart($dirty, -559639176, "C306@12461L8:Snackbar.kt#jmzs0o");
                obj2.invoke($dirty, Integer.valueOf(i34 &= 14));
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243.skipToGroupEnd();
                composer4 = $this$NewLineButtonSnackbar_u24lambda_u244_u24lambda_u243;
                i3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
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
        int i10;
        int i11;
        boolean skipping;
        boolean traceInProgress2;
        Composer composer3;
        Object maybeCachedBoxMeasurePolicy;
        int str;
        Modifier materializeModifier;
        boolean valueOf3;
        Composer composer7;
        Object maybeCachedBoxMeasurePolicy2;
        int i19;
        Composer composer8;
        Integer valueOf2;
        Alignment topStart;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        int i14;
        int currentCompositeKeyHash;
        Object empty;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int i4;
        int i;
        Composer composer;
        int i12;
        Modifier modifier3;
        Composer composer5;
        int i15;
        String str2;
        kotlin.jvm.functions.Function0 function02;
        int i6;
        int i3;
        int $changed$iv;
        int i18;
        String str3;
        int i5;
        int i9;
        int i20;
        Modifier modifier;
        int i7;
        int i8;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        int i2;
        Composer $composer2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer6;
        BoxScopeInstance iNSTANCE;
        Modifier modifier2;
        int i17;
        Composer composer4;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i13;
        Composer composer2;
        int i16;
        int obj53;
        final Object obj = text;
        final Object obj2 = action;
        final int i21 = $changed;
        traceInProgress = -534813202;
        $changed$iv2 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($changed$iv2, "C(OneRowSnackbar)P(1)326@12977L2198,317@12652L2523:Snackbar.kt#jmzs0o");
        if (i21 & 6 == 0) {
            i10 = $changed$iv2.changedInstance(obj) ? 4 : 2;
            $dirty |= i10;
        }
        if (i21 & 48 == 0) {
            i11 = $changed$iv2.changedInstance(obj2) ? 32 : 16;
            $dirty |= i11;
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
                Composer composer11 = $changed$iv2;
                int i52 = 0;
                Object rememberedValue4 = composer11.rememberedValue();
                int i58 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = new SnackbarKt.OneRowSnackbar.2.1(str6, str4);
                    composer11.updateRememberedValue((MeasurePolicy)anon);
                } else {
                    anon = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd($changed$iv2);
                valueOf3 = 432;
                valueOf2 = 0;
                String str9 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($changed$iv2, -1323940314, str9);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($changed$iv2, 0);
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($changed$iv2, padding-qDBjuR0$default);
                i55 |= 6;
                kotlin.jvm.functions.Function0 function03 = constructor;
                i4 = 0;
                i12 = $dirty;
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
                composer = $changed$iv2;
                Composer constructor-impl2 = Updater.constructor-impl(composer);
                int i66 = 0;
                function02 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, $changed$iv2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i67 = 0;
                Composer composer12 = constructor-impl2;
                int i68 = 0;
                if (!composer12.getInserting()) {
                    $changed$iv = valueOf3;
                    i18 = valueOf2;
                    if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer12;
                    }
                } else {
                    $changed$iv = valueOf3;
                    i18 = valueOf2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                valueOf = composer;
                i15 = i30;
                ComposerKt.sourceInformationMarkerStart(valueOf, -16000972, "C319@12682L86,320@12781L46:Snackbar.kt#jmzs0o");
                str2 = str4;
                i6 = i43;
                i3 = i56;
                Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, str4), 0, SnackbarKt.SnackbarVerticalPadding, 1, 0);
                String str8 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, str8);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                int i69 = i31;
                int $changed$iv4 = 0;
                int i71 = i45;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, $changed$iv4);
                int i74 = 0;
                int i75 = $changed$iv4;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, str9);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf, 0);
                currentCompositionLocalMap2 = valueOf.getCurrentCompositionLocalMap();
                Alignment alignment = topStart2;
                Modifier modifier4 = padding-VpY3zN4$default;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                int i77 = 0;
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
                int i80 = 0;
                modifier2 = materializeModifier3;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i82 = 0;
                Composer composer14 = constructor-impl;
                int i85 = 0;
                if (!composer14.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer14;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer9 = valueOf;
                int i81 = i25;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv3);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i84 |= 6;
                i13 = 0;
                i16 = i46;
                Composer composer10 = composer4;
                ComposerKt.sourceInformationMarkerStart(composer10, -1078382464, "C319@12760L6:Snackbar.kt#jmzs0o");
                obj.invoke(composer10, Integer.valueOf(i12 & 14));
                ComposerKt.sourceInformationMarkerEnd(composer10);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                valueOf.endNode();
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, str6);
                int i47 = 6;
                i19 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, str8);
                str3 = str6;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, str9);
                obj53 = currentCompositeKeyHash2;
                modifier = layoutId2;
                kotlin.jvm.functions.Function0 function04 = constructor2;
                i = 0;
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
                int i65 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, valueOf.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i76 = 0;
                Composer composer13 = constructor-impl3;
                int i78 = 0;
                if (!composer13.getInserting()) {
                    $composer2 = valueOf;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(obj53))) {
                        composer13.updateRememberedValue(Integer.valueOf(obj53));
                        constructor-impl3.apply(Integer.valueOf(obj53), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer13;
                    }
                } else {
                    $composer2 = valueOf;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier(valueOf, layoutId2), ComposeUiNode.Companion.getSetModifier());
                $dirty = $composer2;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, $changed$iv3);
                i40 |= 6;
                composer5 = $dirty;
                i7 = 0;
                boxScopeInstance = iNSTANCE2;
                i2 = i37;
                ComposerKt.sourceInformationMarkerStart($dirty, -1078325858, "C320@12817L8:Snackbar.kt#jmzs0o");
                obj2.invoke($dirty, Integer.valueOf(i26 &= 14));
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $changed$iv2.skipToGroupEnd();
                composer = $changed$iv2;
                i12 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $changed$iv2 = new SnackbarKt.OneRowSnackbar.3(obj, obj2, i21);
            endRestartGroup.updateScope((Function2)$changed$iv2);
        }
    }

    public static final void Snackbar-7zSek6w(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> action, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, float elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        float f3;
        int i3;
        int elevation2;
        int defaultsInvalid;
        int small;
        int shape2;
        androidx.compose.material.Colors colors;
        Object $composer2;
        int $dirty3;
        long $dirty2;
        int $i$f$getDp;
        Object obj4;
        int i10;
        boolean z2;
        Object obj3;
        boolean traceInProgress;
        Object obj6;
        int i;
        int str;
        long l;
        Object obj5;
        int i4;
        long l2;
        boolean z;
        int i9;
        Object obj2;
        float f;
        int changed;
        long backgroundColor2;
        Object obj;
        int changed2;
        int $dirty4;
        long $dirty;
        int $dirty5;
        int changed3;
        long i8;
        int i7;
        int i5;
        int contentColor2;
        float f2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i2;
        int i6;
        int obj35;
        final Object obj8 = $changed;
        final int i46 = obj36;
        final int i47 = obj37;
        Composer restartGroup = i11.startRestartGroup(-558258760);
        ComposerKt.sourceInformation(restartGroup, "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)87@4085L6,88@4145L15,89@4202L6,99@4455L464,93@4288L631:Snackbar.kt#jmzs0o");
        $dirty3 = obj36;
        int i25 = i47 & 1;
        if (i25 != 0) {
            $dirty3 |= 6;
            obj3 = modifier;
        } else {
            if (i46 & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : 2;
                $dirty3 |= i;
            } else {
                obj3 = modifier;
            }
        }
        str = i47 & 2;
        if (str != null) {
            $dirty3 |= 48;
            obj5 = action;
        } else {
            if (i46 & 48 == 0) {
                i4 = restartGroup.changedInstance(action) ? 32 : 16;
                $dirty3 |= i4;
            } else {
                obj5 = action;
            }
        }
        int i41 = i47 & 4;
        if (i41 != 0) {
            $dirty3 |= 384;
            z = actionOnNewLine;
        } else {
            if (i46 & 384 == 0) {
                i9 = restartGroup.changed(actionOnNewLine) ? 256 : 128;
                $dirty3 |= i9;
            } else {
                z = actionOnNewLine;
            }
        }
        if (i46 & 3072 == 0) {
            if (i47 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj2 = shape;
            }
            $dirty3 |= changed;
        } else {
            obj2 = shape;
        }
        if (i46 & 24576 == 0) {
            if (i47 & 16 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty3 |= changed2;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (i50 &= i46 == 0) {
            if (i47 & 32 == 0) {
                $dirty5 = $dirty3;
                obj35 = i25;
                changed3 = restartGroup.changed(elevation) ? 131072 : 65536;
            } else {
                $dirty5 = $dirty3;
                obj35 = i25;
                $dirty2 = elevation;
            }
            $dirty5 |= changed3;
        } else {
            $dirty4 = $dirty3;
            obj35 = i25;
            $dirty2 = elevation;
        }
        int i53 = i47 & 64;
        i8 = 1572864;
        if (i53 != 0) {
            $dirty4 |= i8;
            f3 = $composer;
        } else {
            if (i46 & i8 == 0) {
                i5 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty4 |= i5;
            } else {
                f3 = $composer;
            }
        }
        contentColor2 = 12582912;
        if (i47 & 128 != 0) {
            $dirty4 |= contentColor2;
        } else {
            if (i46 & contentColor2 == 0) {
                i3 = restartGroup.changedInstance(obj8) ? 8388608 : 4194304;
                $dirty4 |= i3;
            }
        }
        if (i13 &= $dirty4 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i19 = -458753;
                int i26 = -57345;
                if (i46 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj35 != null) {
                            obj3 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj5 = defaultsInvalid;
                        }
                        if (i41 != 0) {
                            z = defaultsInvalid;
                        }
                        str = 6;
                        if (i47 & 8 != 0) {
                            $dirty4 &= -7169;
                            obj2 = small;
                        }
                        if (i47 & 16 != 0) {
                            backgroundColor2 = SnackbarDefaults.INSTANCE.getBackgroundColor(restartGroup, str);
                            $dirty4 &= i26;
                        }
                        if (i47 & 32 != 0) {
                            contentColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, str).getSurface-0d7_KjU();
                            $dirty4 &= i19;
                        } else {
                            contentColor2 = elevation;
                        }
                        if (i53 != 0) {
                            int i24 = 0;
                            $i$f$getDp = i8;
                            i8 = contentColor2;
                            i10 = -558258760;
                            f2 = $this$dp$iv;
                            elevation2 = $dirty4;
                            $dirty = backgroundColor2;
                            backgroundColor2 = obj3;
                            obj = obj2;
                        } else {
                            elevation2 = $dirty4;
                            $i$f$getDp = i8;
                            i8 = contentColor2;
                            i10 = -558258760;
                            f2 = $composer;
                            $dirty = backgroundColor2;
                            backgroundColor2 = obj3;
                            obj = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i47 & 8 != 0) {
                            $dirty4 &= -7169;
                        }
                        if (i47 & 16 != 0) {
                            $dirty4 &= i26;
                        }
                        if (i47 & 32 != 0) {
                            elevation2 = $dirty4 & i19;
                            f2 = $composer;
                            $dirty = backgroundColor2;
                            $i$f$getDp = i8;
                            i10 = -558258760;
                            i8 = elevation;
                            backgroundColor2 = obj3;
                            obj = obj2;
                        } else {
                            f2 = $composer;
                            elevation2 = $dirty4;
                            $i$f$getDp = i8;
                            i10 = -558258760;
                            i8 = elevation;
                            $dirty = backgroundColor2;
                            backgroundColor2 = obj3;
                            obj = obj2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i10, elevation2, -1, "androidx.compose.material.Snackbar (Snackbar.kt:92)");
                }
                SnackbarKt.Snackbar.1 anon = new SnackbarKt.Snackbar.1(obj5, obj8, z);
                SurfaceKt.Surface-F-jzlyU(backgroundColor2, obj, $dirty, i53, i8, i7, 0, f2, (Function2)ComposableLambdaKt.rememberComposableLambda(-2084221700, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj5;
                z2 = z;
                $composer2 = backgroundColor2;
                obj6 = obj;
                l = $dirty;
                l2 = i8;
                f = f2;
                $dirty4 = elevation2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj3;
                obj4 = obj5;
                z2 = z;
                obj6 = obj2;
                l = backgroundColor2;
                l2 = elevation;
                f = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            elevation2 = new SnackbarKt.Snackbar.2($composer2, obj4, z2, obj6, l, obj5, l2, z, f, obj8, i46, i47);
            endRestartGroup.updateScope((Function2)elevation2);
        }
    }

    public static final void Snackbar-sPrSdHI(androidx.compose.material.SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, long actionColor, float elevation, Composer $composer, int $changed, int i11) {
        long l2;
        float f3;
        boolean $dirty;
        int defaultsInvalid;
        int small;
        int shape2;
        int colors;
        int iNSTANCE;
        int obj;
        int i6;
        Object $composer2;
        int $dirty3;
        boolean $dirty2;
        int i10;
        Object obj3;
        int i;
        boolean changedInstance;
        Object obj2;
        long modifier2;
        int i9;
        int actionLabel;
        boolean traceInProgress;
        boolean str;
        long l;
        int i2;
        Object obj4;
        int changed2;
        long backgroundColor2;
        long l6;
        int rememberComposableLambda;
        Object obj5;
        int changed3;
        int i12;
        int i5;
        float f2;
        int i3;
        boolean changed;
        long surface-0d7_KjU;
        int i4;
        int i13;
        int changed4;
        int i14;
        int actionColor3;
        long actionColor2;
        long l3;
        long l4;
        float f;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i7;
        int i8;
        long l5;
        obj = snackbarData;
        final int i53 = obj41;
        final int i54 = obj42;
        Composer restartGroup = obj40.startRestartGroup(258660814);
        ComposerKt.sourceInformation(restartGroup, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)158@7262L6,159@7322L15,160@7379L6,161@7437L18,178@7986L30,176@7914L320:Snackbar.kt#jmzs0o");
        $dirty3 = obj41;
        if (i54 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i53 & 6 == 0) {
                if (i53 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj);
                } else {
                    changedInstance = restartGroup.changedInstance(obj);
                }
                i10 = changedInstance != null ? 4 : 2;
                $dirty3 |= i10;
            }
        }
        int i23 = i54 & 2;
        if (i23 != 0) {
            $dirty3 |= 48;
            obj2 = modifier;
        } else {
            if (i53 & 48 == 0) {
                i9 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i9;
            } else {
                obj2 = modifier;
            }
        }
        actionLabel = i54 & 4;
        if (actionLabel != 0) {
            $dirty3 |= 384;
            str = actionOnNewLine;
        } else {
            if (i53 & 384 == 0) {
                i2 = restartGroup.changed(actionOnNewLine) ? 256 : 128;
                $dirty3 |= i2;
            } else {
                str = actionOnNewLine;
            }
        }
        if (i53 & 3072 == 0) {
            if (i54 & 8 == 0) {
                changed2 = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                obj4 = shape;
            }
            $dirty3 |= changed2;
        } else {
            obj4 = shape;
        }
        if (i53 & 24576 == 0) {
            if (i54 & 16 == 0) {
                changed3 = restartGroup.changed(backgroundColor) ? 16384 : 8192;
            } else {
                backgroundColor2 = backgroundColor;
            }
            $dirty3 |= changed3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (i49 &= i53 == 0) {
            if (i54 & 32 == 0) {
                i12 = restartGroup.changed(actionColor) ? 131072 : 65536;
            } else {
                surface-0d7_KjU = actionColor;
            }
            $dirty3 |= i12;
        } else {
            surface-0d7_KjU = actionColor;
        }
        if (i50 &= i53 == 0) {
            if (i54 & 64 == 0) {
                changed4 = restartGroup.changed($composer) ? 1048576 : 524288;
            } else {
                l2 = $composer;
            }
            $dirty3 |= changed4;
        } else {
            l2 = $composer;
        }
        i3 = i54 & 128;
        i14 = 12582912;
        if (i3 != 0) {
            $dirty3 |= i14;
            f3 = i11;
        } else {
            if (i53 & i14 == 0) {
                obj = restartGroup.changed(i11) ? 8388608 : 4194304;
                $dirty3 |= obj;
            } else {
                f3 = i11;
            }
        }
        if (i22 &= $dirty3 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i6 = -3670017;
                int i55 = -458753;
                int i56 = -57345;
                if (i53 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i23 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (actionLabel != 0) {
                            str = defaultsInvalid;
                        }
                        int i28 = 6;
                        if (i54 & 8 != 0) {
                            $dirty3 &= -7169;
                            obj4 = small;
                        }
                        if (i54 & 16 != 0) {
                            backgroundColor2 = SnackbarDefaults.INSTANCE.getBackgroundColor(restartGroup, i28);
                            $dirty3 &= i56;
                        }
                        if (i54 & 32 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors(restartGroup, i28).getSurface-0d7_KjU();
                            $dirty3 &= i55;
                        }
                        if (i54 & 64 != 0) {
                            actionColor2 = SnackbarDefaults.INSTANCE.getPrimaryActionColor(restartGroup, i28);
                            $dirty3 &= i6;
                        } else {
                            actionColor2 = $composer;
                        }
                        if (i3 != 0) {
                            i6 = 0;
                            f = $this$dp$iv;
                            l4 = surface-0d7_KjU;
                            i = i14;
                            $dirty = actionColor2;
                            i14 = str;
                            actionColor3 = obj4;
                            l3 = backgroundColor2;
                        } else {
                            f = i11;
                            l4 = surface-0d7_KjU;
                            i = i14;
                            $dirty = actionColor2;
                            i14 = str;
                            actionColor3 = obj4;
                            l3 = backgroundColor2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i54 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i54 & 16 != 0) {
                            $dirty3 &= i56;
                        }
                        if (i54 & 32 != 0) {
                            $dirty3 &= i55;
                        }
                        if (i54 & 64 != 0) {
                            f = i11;
                            $dirty3 = i20;
                            actionColor3 = obj4;
                            l3 = backgroundColor2;
                            l4 = surface-0d7_KjU;
                            i = i14;
                            $dirty = $composer;
                            i14 = str;
                        } else {
                            $dirty = $composer;
                            f = i11;
                            actionColor3 = obj4;
                            l3 = backgroundColor2;
                            l4 = surface-0d7_KjU;
                            i = i14;
                            i14 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(258660814, $dirty3, -1, "androidx.compose.material.Snackbar (Snackbar.kt:163)");
                }
                actionLabel = snackbarData.getActionLabel();
                int i32 = 54;
                int i42 = 1;
                if (actionLabel != null) {
                    restartGroup.startReplaceGroup(1609178760);
                    ComposerKt.sourceInformation(restartGroup, "166@7634L243");
                    SnackbarKt.Snackbar.actionComposable.1 anon2 = new SnackbarKt.Snackbar.actionComposable.1($dirty, i6, snackbarData, actionLabel);
                    restartGroup.endReplaceGroup();
                    i13 = rememberComposableLambda;
                } else {
                    obj5 = snackbarData;
                    restartGroup.startReplaceGroup(1609445763);
                    restartGroup.endReplaceGroup();
                    i13 = rememberComposableLambda;
                }
                int i51 = 0;
                SnackbarKt.Snackbar.3 anon = new SnackbarKt.Snackbar.3(obj5);
                SnackbarKt.Snackbar-7zSek6w(PaddingKt.padding-3ABfNKs(obj2, Dp.constructor-impl((float)i45)), i13, i14, actionColor3, l3, obj19, l4, obj21, f, (Function2)ComposableLambdaKt.rememberComposableLambda(-261845785, i42, anon, restartGroup, i32), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l6 = $dirty;
                i4 = $dirty3;
                $composer2 = obj2;
                $dirty2 = i14;
                obj3 = actionColor3;
                modifier2 = l3;
                l = l4;
                f2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                f2 = i11;
                composer = restartGroup;
                $composer2 = obj2;
                obj3 = obj4;
                modifier2 = backgroundColor2;
                l6 = $composer;
                i4 = $dirty3;
                $dirty2 = str;
                l = l5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new SnackbarKt.Snackbar.4(snackbarData, $composer2, $dirty2, obj3, modifier2, actionLabel, l, obj4, l6, obj5, f2, i53, i54);
            endRestartGroup.updateScope((Function2)$dirty);
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
        int i12;
        int skipping;
        boolean traceInProgress;
        Composer composer3;
        Integer valueOf;
        int maybeCachedBoxMeasurePolicy;
        int i11;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        androidx.compose.ui.Modifier.Companion companion;
        int i7;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        kotlin.jvm.functions.Function0 constructor;
        int i9;
        Composer composer4;
        int i5;
        int i2;
        int i;
        int i17;
        int i6;
        Composer composer5;
        int i15;
        int i10;
        androidx.compose.material.SnackbarKt.TextOnlySnackbar.2 measurePolicy$iv;
        int i16;
        int i13;
        int i14;
        int i8;
        Alignment alignment;
        Modifier modifier2;
        int i4;
        int i18;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        Composer $composer2;
        int i3;
        Modifier modifier;
        int obj41;
        final Object obj = content;
        final int i19 = $changed;
        traceInProgress2 = 917397959;
        $composer$iv = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation($composer$iv, "C(TextOnlySnackbar)239@10057L1816:Snackbar.kt#jmzs0o");
        maybeCachedBoxMeasurePolicy = 2;
        if (i19 & 6 == 0) {
            i12 = $composer$iv.changedInstance(obj) ? 4 : maybeCachedBoxMeasurePolicy;
            materialized$iv$iv |= i12;
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
                i5 = 0;
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
                    i16 = materialized$iv$iv;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer7;
                    }
                } else {
                    measurePolicy$iv = iNSTANCE;
                    i16 = materialized$iv$iv;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier($composer$iv, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                valueOf2 = composer5;
                i17 = i21;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 1169284118, "C240@10074L202:Snackbar.kt#jmzs0o");
                i6 = i28;
                Modifier padding-VpY3zN4 = PaddingKt.padding-VpY3zN4((Modifier)Modifier.Companion, SnackbarKt.HorizontalSpacing, SnackbarKt.SnackbarVerticalPadding);
                i7 = 0;
                i15 = i29;
                i10 = i31;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                valueOf = 0;
                i13 = i32;
                i8 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str3);
                obj41 = currentCompositeKeyHash2;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(valueOf2, padding-VpY3zN4);
                modifier2 = padding-VpY3zN4;
                kotlin.jvm.functions.Function0 function02 = constructor2;
                i2 = 0;
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
                    i3 = valueOf;
                    if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(obj41))) {
                        composer8.updateRememberedValue(Integer.valueOf(obj41));
                        constructor-impl.apply(Integer.valueOf(obj41), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer8;
                    }
                } else {
                    $composer2 = valueOf2;
                    i3 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer6 = $composer2;
                skipping = 0;
                i = i25;
                ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i36 |= 6;
                i4 = 0;
                boxScopeInstance = iNSTANCE2;
                modifier = materializeModifier2;
                materialized$iv$iv = composer4;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 2052531256, "C246@10257L9:Snackbar.kt#jmzs0o");
                obj.invoke(materialized$iv$iv, Integer.valueOf(i16 & 14));
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
                i16 = materialized$iv$iv;
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
