package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u001ae\u0010\n\u001a\u00020\u000b2\u0011\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017\u001ag\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\u000c\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u0017\u001aj\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\u00142\u0008\u0008\u0002\u0010&\u001a\u00020\u00142\u0008\u0008\u0002\u0010'\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)\u001a\u0099\u0001\u0010\u001c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0015\u0008\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u000e2\u0015\u0008\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\u0008\u000e2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\u00142\u0008\u0008\u0002\u0010&\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0008\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0008\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006-", d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnackbarKt {

    private static final float ContainerMaxWidth;
    private static final float HeightToFirstLine;
    private static final float HorizontalSpacing;
    private static final float HorizontalSpacingButtonSide;
    private static final float LongButtonVerticalOffset;
    private static final float SeparateButtonExtraY;
    private static final float SnackbarVerticalPadding;
    private static final float TextEndExtraSpacing;
    static {
        int i9 = 0;
        SnackbarKt.ContainerMaxWidth = Dp.constructor-impl((float)i);
        int i10 = 0;
        SnackbarKt.HeightToFirstLine = Dp.constructor-impl((float)i2);
        int i11 = 0;
        SnackbarKt.HorizontalSpacing = Dp.constructor-impl((float)i3);
        int i12 = 0;
        SnackbarKt.HorizontalSpacingButtonSide = Dp.constructor-impl((float)i4);
        int i13 = 0;
        SnackbarKt.SeparateButtonExtraY = Dp.constructor-impl((float)i5);
        int i14 = 0;
        SnackbarKt.SnackbarVerticalPadding = Dp.constructor-impl((float)i6);
        int i15 = 0;
        SnackbarKt.TextEndExtraSpacing = Dp.constructor-impl((float)i7);
        int i16 = 0;
        SnackbarKt.LongButtonVerticalOffset = Dp.constructor-impl((float)i8);
    }

    private static final void NewLineButtonSnackbar-kKq0p4A(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Function2<? super Composer, ? super Integer, Unit> dismissAction, TextStyle actionTextStyle, long actionContentColor, long dismissActionContentColor, Composer $composer, int $changed) {
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        boolean currentCompositionLocalMap;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Object provides;
        boolean traceInProgress2;
        boolean currentCompositionLocalMap4;
        int obj;
        int $dirty;
        int skipping;
        boolean traceInProgress;
        boolean currentCompositionLocalMap2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int horizontalSpacingButtonSide;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Composer composer;
        Object valueOf;
        int i21;
        int i37;
        int i15;
        int i26;
        int i9;
        int i36;
        int str;
        Composer composer7;
        boolean currentCompositionLocalMap3;
        int end;
        Object columnMeasurePolicy;
        int currentCompositeKeyHash3;
        Composer composer9;
        Object materialized$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i32;
        Object restartGroup;
        long l;
        float materializeModifier;
        Composer composer6;
        Object maybeCachedBoxMeasurePolicy2;
        int i16;
        long maybeCachedBoxMeasurePolicy;
        int i11;
        Composer composer4;
        int i34;
        int i2;
        int i17;
        int i18;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        int i14;
        androidx.compose.ui.Alignment.Vertical vertical2;
        int currentCompositeKeyHash2;
        int i38;
        androidx.compose.ui.Alignment.Horizontal horizontal2;
        int i12;
        Modifier modifier2;
        kotlin.jvm.functions.Function0 function02;
        int i7;
        int i4;
        int i29;
        int i;
        Composer composer8;
        int i3;
        Composer composer3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i5;
        Modifier modifier;
        int i10;
        int i30;
        ColumnScopeInstance columnScopeInstance;
        int currentCompositeKeyHash;
        int i31;
        Modifier modifier4;
        kotlin.jvm.functions.Function0 function0;
        float f;
        int i8;
        int i23;
        int i24;
        int i13;
        int i27;
        Modifier modifier3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv3;
        Composer composer2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        Composer composer10;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i33;
        int i22;
        int i20;
        int i6;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.foundation.layout.Arrangement.Horizontal horizontal;
        int i25;
        androidx.compose.ui.Modifier.Companion companion;
        int i19;
        int i35;
        kotlin.jvm.functions.Function0 function03;
        RowScopeInstance rowScopeInstance;
        Composer composer5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv4;
        Composer composer11;
        int i28;
        Modifier obj81;
        obj = text;
        final Object obj2 = action;
        final Object obj3 = dismissAction;
        final Object obj4 = actionTextStyle;
        i32 = obj82;
        traceInProgress2 = -1332496681;
        restartGroup = obj81.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)264@11690L1175:Snackbar.kt#uh7d8r");
        if (i32 & 6 == 0) {
            i21 = restartGroup.changedInstance(obj) ? 4 : 2;
            $dirty |= i21;
        }
        if (i32 & 48 == 0) {
            i37 = restartGroup.changedInstance(obj2) ? 32 : 16;
            $dirty |= i37;
        }
        if (i32 & 384 == 0) {
            i15 = restartGroup.changedInstance(obj3) ? 256 : 128;
            $dirty |= i15;
        }
        if (i32 & 3072 == 0) {
            i26 = restartGroup.changed(obj4) ? 2048 : 1024;
            $dirty |= i26;
        }
        if (i32 & 24576 == 0) {
            i9 = restartGroup.changed(actionContentColor) ? 16384 : 8192;
            $dirty |= i9;
        } else {
            l = actionContentColor;
        }
        if (i66 &= i32 == 0) {
            i36 = restartGroup.changed($composer) ? 131072 : 65536;
            $dirty |= i36;
        } else {
            maybeCachedBoxMeasurePolicy = $composer;
        }
        final int i95 = $dirty;
        if ($dirty2 &= i95 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i95, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:263)");
                }
                int i67 = 0;
                int i77 = 1;
                int i75 = 0;
                Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.widthIn-VpY3zN4$default((Modifier)Modifier.Companion, i67, SnackbarKt.ContainerMaxWidth, i77, i75), i67, i77, i75), SnackbarKt.HorizontalSpacing, 0, 0, SnackbarKt.SeparateButtonExtraY, 6, 0);
                int i55 = 6;
                int i68 = i55;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                androidx.compose.foundation.layout.Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start2 = Alignment.Companion.getStart();
                i18 = i68;
                columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, start2, restartGroup, i99 | i103);
                i17 = 0;
                vertical = top;
                i14 = i76;
                String $i$f$Column = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $i$f$Column);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                horizontal2 = start2;
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(restartGroup, padding-qDBjuR0$default);
                modifier2 = padding-qDBjuR0$default;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i12 = 0;
                String str5 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str5);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function04);
                } else {
                    factory$iv$iv$iv4 = function04;
                    restartGroup.useNode();
                }
                function02 = factory$iv$iv$iv4;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i108 = 0;
                composer8 = restartGroup;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i109 = 0;
                Composer composer16 = constructor-impl;
                int i110 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = columnMeasurePolicy;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer16;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap2;
                    measurePolicy = columnMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier4, ComposeUiNode.Companion.getSetModifier());
                Composer composer13 = composer8;
                i29 = i42;
                ComposerKt.sourceInformationMarkerStart(composer13, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                ColumnScopeInstance iNSTANCE = ColumnScopeInstance.INSTANCE;
                i3 = 0;
                i5 = i69;
                modifier = materializeModifier4;
                materialized$iv$iv = composer15;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -376152340, "C272@11979L191,279@12180L679:Snackbar.kt#uh7d8r");
                i = i85;
                Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(AlignmentLineKt.paddingFromBaseline-VpY3zN4((Modifier)Modifier.Companion, SnackbarKt.HeightToFirstLine, SnackbarKt.LongButtonVerticalOffset), 0, 0, SnackbarKt.HorizontalSpacingButtonSide, 0, 11, 0);
                int i111 = i70;
                int i114 = i86;
                String $i$f$Box = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 733328855, $i$f$Box);
                Alignment topStart = Alignment.Companion.getTopStart();
                int i87 = 0;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i87);
                int i119 = 0;
                Alignment alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -1323940314, $i$f$Column);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(materialized$iv$iv, 0);
                currentCompositionLocalMap3 = materialized$iv$iv.getCurrentCompositionLocalMap();
                int i124 = i87;
                Modifier modifier6 = padding-qDBjuR0$default2;
                kotlin.jvm.functions.Function0 function06 = constructor3;
                int i125 = 0;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -692256719, str5);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                materialized$iv$iv.startReusableNode();
                if (materialized$iv$iv.getInserting()) {
                    materialized$iv$iv.createNode(function06);
                } else {
                    factory$iv$iv$iv = function06;
                    materialized$iv$iv.useNode();
                }
                kotlin.jvm.functions.Function0 function07 = factory$iv$iv$iv;
                Composer constructor-impl2 = Updater.constructor-impl(materialized$iv$iv);
                int i132 = 0;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i92 = 0;
                Composer composer19 = constructor-impl2;
                int i137 = 0;
                if (!composer19.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer19.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer19.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer19;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(materialized$iv$iv, padding-qDBjuR0$default2), ComposeUiNode.Companion.getSetModifier());
                Composer composer14 = materialized$iv$iv;
                int i88 = 0;
                String str6 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer14, -2146769399, str6);
                BoxScopeInstance iNSTANCE6 = BoxScopeInstance.INSTANCE;
                i135 |= 6;
                Composer composer20 = composer14;
                int i138 = 0;
                int i142 = i61;
                ComposerKt.sourceInformationMarkerStart(composer14, -1482962025, "C276@12154L6:Snackbar.kt#uh7d8r");
                obj.invoke(composer14, Integer.valueOf(i95 & 14));
                ComposerKt.sourceInformationMarkerEnd(composer14);
                ComposerKt.sourceInformationMarkerEnd(composer14);
                materialized$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                if (obj3 == null) {
                    f = horizontalSpacingButtonSide;
                } else {
                    end = 0;
                    f = materializeModifier;
                }
                Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default((ColumnScope)iNSTANCE.align((Modifier)Modifier.Companion, Alignment.Companion.getEnd()), 0, 0, f, 0, 11, 0);
                int i72 = i106;
                l = 0;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 733328855, $i$f$Box);
                i30 = 0;
                columnScopeInstance = iNSTANCE;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -1323940314, $i$f$Column);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(materialized$iv$iv, 0);
                currentCompositionLocalMap = materialized$iv$iv.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(materialized$iv$iv, padding-qDBjuR0$default3);
                modifier4 = padding-qDBjuR0$default3;
                kotlin.jvm.functions.Function0 function05 = constructor2;
                i31 = 0;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -692256719, str5);
                if (!applier4 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                materialized$iv$iv.startReusableNode();
                if (materialized$iv$iv.getInserting()) {
                    materialized$iv$iv.createNode(function05);
                } else {
                    factory$iv$iv$iv3 = function05;
                    materialized$iv$iv.useNode();
                }
                function0 = factory$iv$iv$iv3;
                Composer constructor-impl3 = Updater.constructor-impl(materialized$iv$iv);
                int i127 = 0;
                Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i129 = 0;
                Composer composer18 = constructor-impl3;
                int i133 = 0;
                if (!composer18.getInserting()) {
                    localMap$iv$iv3 = currentCompositionLocalMap;
                    composer2 = materialized$iv$iv;
                    if (!Intrinsics.areEqual(composer18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer9 = composer18;
                    }
                } else {
                    localMap$iv$iv3 = currentCompositionLocalMap;
                    composer2 = materialized$iv$iv;
                }
                Updater.set-impl(constructor-impl3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                valueOf = composer2;
                ComposerKt.sourceInformationMarkerStart(valueOf, -2146769399, str6);
                i94 |= 6;
                Composer composer17 = valueOf;
                i24 = 0;
                i27 = i45;
                modifier3 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1482754232, "C283@12348L501:Snackbar.kt#uh7d8r");
                i23 = i46;
                i33 = i53;
                ComposerKt.sourceInformationMarkerStart(valueOf, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                androidx.compose.ui.Modifier.Companion companion4 = Modifier.Companion;
                androidx.compose.foundation.layout.Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                i20 = i73;
                androidx.compose.ui.Alignment.Vertical top2 = Alignment.Companion.getTop();
                boxScopeInstance = iNSTANCE5;
                i6 = 0;
                horizontal = start;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, $i$f$Column);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf, 0);
                currentCompositionLocalMap4 = valueOf.getCurrentCompositionLocalMap();
                vertical2 = top2;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(valueOf, (Modifier)companion4);
                companion = companion4;
                kotlin.jvm.functions.Function0 function08 = constructor4;
                i25 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, str5);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf.startReusableNode();
                if (valueOf.getInserting()) {
                    valueOf.createNode(function08);
                } else {
                    factory$iv$iv$iv2 = function08;
                    valueOf.useNode();
                }
                Composer constructor-impl4 = Updater.constructor-impl(valueOf);
                int i107 = 0;
                function03 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl4, RowKt.rowMeasurePolicy(start, top2, valueOf, i140 | i144), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i145 = 0;
                Composer composer22 = constructor-impl4;
                int i146 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv$iv4 = currentCompositionLocalMap4;
                    composer11 = valueOf;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer22;
                    }
                } else {
                    localMap$iv$iv4 = currentCompositionLocalMap4;
                    composer11 = valueOf;
                }
                Updater.set-impl(constructor-impl4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = composer11;
                i4 = i50;
                ComposerKt.sourceInformationMarkerStart(composer12, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i81 |= 6;
                i19 = 0;
                rowScopeInstance = iNSTANCE2;
                i28 = i65;
                skipping = composer4;
                ComposerKt.sourceInformationMarkerStart(skipping, 1996615437, "C284@12370L208:Snackbar.kt#uh7d8r");
                ProvidedValue[] arr = new ProvidedValue[2];
                obj81 = materializeModifier3;
                arr[i77] = TextKt.getLocalTextStyle().provides(obj4);
                CompositionLocalKt.CompositionLocalProvider(arr, obj2, skipping, $stable |= str);
                skipping.startReplaceGroup(618603253);
                ComposerKt.sourceInformation(skipping, "290@12644L173");
                if (obj3 != null) {
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl($composer)), obj3, skipping, $stable2 |= str);
                }
                skipping.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(skipping);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer11.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer13);
                composer8.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer8 = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer8.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SnackbarKt.NewLineButtonSnackbar.2(text, obj2, obj3, obj4, actionContentColor, str, $composer, rowMeasurePolicy, obj82);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void OneRowSnackbar-kKq0p4A(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Function2<? super Composer, ? super Integer, Unit> dismissAction, TextStyle actionTextStyle, long actionTextColor, long dismissActionColor, Composer $composer, int $changed) {
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        Object $changed$iv;
        boolean traceInProgress;
        ProvidedValue[] str;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        boolean currentCompositionLocalMap;
        Object materialized$iv$iv;
        boolean valueOf;
        int $dirty;
        int skipping;
        boolean traceInProgress2;
        Composer composer3;
        Integer valueOf2;
        Composer composer2;
        Object maybeCachedBoxMeasurePolicy;
        int i21;
        int i10;
        int i2;
        int i4;
        int i13;
        int i8;
        int str4;
        float constructor-impl;
        Object it$iv2;
        boolean currentCompositionLocalMap2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        int horizontalSpacingButtonSide;
        Composer composer4;
        Object empty;
        Composer composer8;
        int topStart;
        Object maybeCachedBoxMeasurePolicy3;
        String restartGroup;
        long currentCompositionLocalMap3;
        Composer composer5;
        Object maybeCachedBoxMeasurePolicy2;
        Object currentCompositionLocalMap4;
        long str2;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        Alignment topStart2;
        int i19;
        int i22;
        int currentCompositeKeyHash2;
        float f;
        int i20;
        Object it$iv;
        int i6;
        Modifier modifier;
        kotlin.jvm.functions.Function0 function02;
        int i14;
        int i3;
        String str3;
        Composer composer;
        Modifier modifier3;
        int i;
        Object measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int i18;
        String actionTag;
        int i24;
        int i7;
        int i9;
        int i11;
        int currentCompositeKeyHash;
        int $changed$iv2;
        int alignment;
        Modifier i15;
        Object modifier2;
        int function0;
        int i12;
        Composer i17;
        int iNSTANCE;
        kotlin.jvm.functions.Function0 function03;
        int i5;
        int composer6;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer i23;
        int composer7;
        int i16;
        Modifier obj63;
        str = text;
        materialized$iv$iv = action;
        final Object obj = dismissAction;
        valueOf = actionTextStyle;
        topStart = obj64;
        traceInProgress = -903235475;
        restartGroup = obj63.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)338@14229L3580,312@13223L4586:Snackbar.kt#uh7d8r");
        if (topStart & 6 == 0) {
            i21 = restartGroup.changedInstance(str) ? 4 : 2;
            $dirty |= i21;
        }
        if (topStart & 48 == 0) {
            i10 = restartGroup.changedInstance(materialized$iv$iv) ? 32 : 16;
            $dirty |= i10;
        }
        if (topStart & 384 == 0) {
            i2 = restartGroup.changedInstance(obj) ? 256 : 128;
            $dirty |= i2;
        }
        if (topStart & 3072 == 0) {
            i4 = restartGroup.changed(valueOf) ? 2048 : 1024;
            $dirty |= i4;
        }
        if (topStart & 24576 == 0) {
            i13 = restartGroup.changed(actionTextColor) ? 16384 : 8192;
            $dirty |= i13;
        } else {
            currentCompositionLocalMap3 = actionTextColor;
        }
        if (i41 &= topStart == 0) {
            i8 = restartGroup.changed($composer) ? 131072 : 65536;
            $dirty |= i8;
        } else {
            str2 = $composer;
        }
        final int i73 = $dirty;
        if ($dirty2 &= i73 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i73, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:308)");
                }
                String str5 = "text";
                skipping = "action";
                str4 = "dismissAction";
                if (obj == null) {
                    f = horizontalSpacingButtonSide;
                } else {
                    currentCompositeKeyHash2 = 0;
                    f = constructor-impl;
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1386942712, "CC(remember):Snackbar.kt#9igjgp");
                Composer composer11 = restartGroup;
                int i74 = 0;
                int i76 = i42;
                it$iv2 = composer11.rememberedValue();
                i20 = 0;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    it$iv = it$iv2;
                    it$iv2 = new SnackbarKt.OneRowSnackbar.2.1(skipping, str4, str5);
                    composer11.updateRememberedValue((MeasurePolicy)it$iv2);
                } else {
                    it$iv = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Modifier modifier5 = modifier6;
                i19 = 0;
                currentCompositionLocalMap3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap3);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap4 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, modifier5);
                modifier = modifier5;
                function02 = constructor2;
                i6 = 0;
                str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str2);
                if (!applier4 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl4 = Updater.constructor-impl(restartGroup);
                int i82 = 0;
                composer = restartGroup;
                Updater.set-impl(constructor-impl4, (MeasurePolicy)it$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i83 = 0;
                Composer composer13 = constructor-impl4;
                int i84 = 0;
                if (!composer13.getInserting()) {
                    measurePolicy$iv = it$iv2;
                    map = currentCompositionLocalMap4;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer13;
                    }
                } else {
                    measurePolicy$iv = it$iv2;
                    map = currentCompositionLocalMap4;
                }
                Updater.set-impl(constructor-impl4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                composer4 = composer;
                i3 = i44;
                ComposerKt.sourceInformationMarkerStart(composer4, 2016566027, "C314@13253L86:Snackbar.kt#uh7d8r");
                str3 = str5;
                modifier3 = materializeModifier2;
                i = i59;
                int i60 = 1;
                Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, str5), 0, SnackbarKt.SnackbarVerticalPadding, i60, 0);
                restartGroup = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, restartGroup);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                int i85 = i45;
                int $changed$iv5 = 0;
                i7 = i56;
                maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, $changed$iv5);
                i11 = 0;
                currentCompositeKeyHash = $changed$iv5;
                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, currentCompositionLocalMap3);
                $changed$iv2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                alignment = topStart3;
                modifier2 = padding-VpY3zN4$default;
                kotlin.jvm.functions.Function0 function06 = constructor4;
                i15 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, str2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(function06);
                } else {
                    factory$iv$iv$iv3 = function06;
                    composer4.useNode();
                }
                function0 = factory$iv$iv$iv3;
                Composer constructor-impl2 = Updater.constructor-impl(composer4);
                int i93 = 0;
                function03 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i95 = 0;
                Composer composer15 = constructor-impl2;
                int i98 = 0;
                if (!composer15.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                    if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf($changed$iv2))) {
                        composer15.updateRememberedValue(Integer.valueOf($changed$iv2));
                        constructor-impl2.apply(Integer.valueOf($changed$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer15;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy3;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(composer4, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer10 = composer4;
                i17 = i28;
                $changed$iv = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, $changed$iv);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i97 |= 6;
                i23 = 0;
                i16 = i57;
                topStart = composer6;
                ComposerKt.sourceInformationMarkerStart(topStart, 1308937155, "C314@13331L6:Snackbar.kt#uh7d8r");
                str.invoke(topStart, Integer.valueOf(i73 & 14));
                ComposerKt.sourceInformationMarkerEnd(topStart);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer4.startReplaceGroup(-904778058);
                ComposerKt.sourceInformation(composer4, "316@13390L295");
                if (materialized$iv$iv != null) {
                    Modifier layoutId3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, skipping);
                    int i58 = 6;
                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, restartGroup);
                    int i34 = 0;
                    actionTag = skipping;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), i34);
                    i9 = 0;
                    i11 = i34;
                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, currentCompositionLocalMap3);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                    currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer4, layoutId3);
                    i15 = layoutId3;
                    kotlin.jvm.functions.Function0 function05 = constructor3;
                    alignment = 0;
                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, str2);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(function05);
                    } else {
                        factory$iv$iv$iv2 = function05;
                        composer4.useNode();
                    }
                    modifier2 = factory$iv$iv$iv2;
                    Composer constructor-impl3 = Updater.constructor-impl(composer4);
                    int i90 = 0;
                    iNSTANCE = i64;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i94 = 0;
                    Composer composer16 = constructor-impl3;
                    int i99 = 0;
                    if (!composer16.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = composer16;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = composer4;
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv);
                    maybeCachedBoxMeasurePolicy2 = BoxScopeInstance.INSTANCE;
                    i92 |= 6;
                    i5 = 0;
                    composer6 = i37;
                    composer7 = i51;
                    constructor-impl = i17;
                    ComposerKt.sourceInformationMarkerStart(constructor-impl, 1309057900, "C317@13446L221:Snackbar.kt#uh7d8r");
                    str = new ProvidedValue[2];
                    obj63 = materializeModifier3;
                    str[i60] = TextKt.getLocalTextStyle().provides(valueOf);
                    CompositionLocalKt.CompositionLocalProvider(str, materialized$iv$iv, constructor-impl, $stable2 |= topStart);
                    ComposerKt.sourceInformationMarkerEnd(constructor-impl);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                } else {
                    actionTag = skipping;
                }
                composer4.endReplaceGroup();
                composer4.startReplaceGroup(-904766579);
                ComposerKt.sourceInformation(composer4, "325@13757L247");
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, str4);
                valueOf2 = 6;
                constructor-impl = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, restartGroup);
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, currentCompositionLocalMap3);
                obj63 = currentCompositeKeyHash3;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer4, layoutId);
                it$iv = layoutId;
                kotlin.jvm.functions.Function0 function04 = constructor;
                i20 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, str2);
                if (obj != null && !applier2 instanceof Applier) {
                    layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, str4);
                    valueOf2 = 6;
                    constructor-impl = 0;
                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, restartGroup);
                    i18 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, currentCompositionLocalMap3);
                    obj63 = currentCompositeKeyHash3;
                    materializeModifier = ComposedModifierKt.materializeModifier(composer4, layoutId);
                    it$iv = layoutId;
                    function04 = constructor;
                    i20 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer4, -692256719, str2);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    composer4.startReusableNode();
                    if (composer4.getInserting()) {
                        composer4.createNode(function04);
                    } else {
                        factory$iv$iv$iv = function04;
                        composer4.useNode();
                    }
                    Composer constructor-impl5 = Updater.constructor-impl(composer4);
                    int i80 = 0;
                    i9 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl5, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl5, composer4.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i86 = 0;
                    Composer composer14 = constructor-impl5;
                    int i89 = 0;
                    if (!composer14.getInserting()) {
                        $changed$iv2 = valueOf2;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(obj63))) {
                            composer14.updateRememberedValue(Integer.valueOf(obj63));
                            constructor-impl5.apply(Integer.valueOf(obj63), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer14;
                        }
                    } else {
                        $changed$iv2 = valueOf2;
                    }
                    Updater.set-impl(constructor-impl5, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    valueOf = composer4;
                    skipping = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf, -2146769399, $changed$iv);
                    i68 |= 6;
                    i24 = 0;
                    i11 = iNSTANCE2;
                    currentCompositeKeyHash = i33;
                    alignment = materializeModifier;
                    materialized$iv$iv = composer12;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1309427203, "C326@13820L166:Snackbar.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl($composer)), obj, materialized$iv$iv, $stable |= function02);
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(valueOf);
                    composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                }
                composer4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SnackbarKt.OneRowSnackbar.3(text, action, obj, actionTextStyle, actionTextColor, str4, $composer, composer4, obj64);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Snackbar-eQBnUkQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> action, Function2<? super Composer, ? super Integer, Unit> dismissAction, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionContentColor, long dismissActionContentColor, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        boolean traceInProgress;
        Object endRestartGroup;
        int i8;
        int changed5;
        int i9;
        Object obj5;
        int skipping;
        Object modifier2;
        int defaultsInvalid;
        Object obj;
        int changed;
        Object $composer2;
        int $dirty5;
        long $dirty3;
        long l3;
        long l2;
        int i;
        Object $dirty2;
        int iNSTANCE2;
        boolean traceInProgress2;
        boolean z;
        Object obj2;
        Object action2;
        Object obj6;
        int i2;
        Object dismissAction2;
        long dismissAction3;
        Object obj3;
        boolean actionOnNewLine2;
        int i3;
        Object shape3;
        long shape2;
        Object str;
        int i5;
        long containerColor3;
        long containerColor2;
        boolean function2;
        int i6;
        Object obj4;
        long contentColor2;
        long contentColor3;
        boolean changed4;
        long l;
        int iNSTANCE;
        int changed3;
        int $dirty4;
        int $dirty;
        int changed2;
        Composer composer;
        int i7;
        long actionContentColor3;
        int actionContentColor2;
        int i4;
        long dismissActionContentColor2;
        ScopeUpdateScope scopeUpdateScope;
        long l4;
        Object obj25;
        Object obj26;
        long obj27;
        Function2 obj28;
        long obj29;
        long obj30;
        int obj31;
        float obj32;
        int obj33;
        androidx.compose.runtime.internal.ComposableLambda obj34;
        Composer obj35;
        int obj36;
        int obj37;
        int obj39;
        final int i53 = obj40;
        traceInProgress = obj41;
        Composer restartGroup = obj39.startRestartGroup(-1235788955);
        ComposerKt.sourceInformation(restartGroup, "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)107@5066L5,108@5118L5,109@5168L12,110@5231L18,111@5307L25,120@5574L1123,114@5378L1319:Snackbar.kt#uh7d8r");
        $dirty5 = obj40;
        int i28 = traceInProgress & 1;
        if (i28 != 0) {
            $dirty5 |= 6;
            obj2 = modifier;
        } else {
            if (i53 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty5 |= i2;
            } else {
                obj2 = modifier;
            }
        }
        int i38 = traceInProgress & 2;
        if (i38 != 0) {
            $dirty5 |= 48;
            obj3 = action;
        } else {
            if (i53 & 48 == 0) {
                i3 = restartGroup.changedInstance(action) ? 32 : 16;
                $dirty5 |= i3;
            } else {
                obj3 = action;
            }
        }
        int i40 = traceInProgress & 4;
        if (i40 != 0) {
            $dirty5 |= 384;
            str = dismissAction;
        } else {
            if (i53 & 384 == 0) {
                i5 = restartGroup.changedInstance(dismissAction) ? 256 : 128;
                $dirty5 |= i5;
            } else {
                str = dismissAction;
            }
        }
        int i43 = traceInProgress & 8;
        if (i43 != 0) {
            $dirty5 |= 3072;
            function2 = actionOnNewLine;
        } else {
            if (i53 & 3072 == 0) {
                i6 = restartGroup.changed(actionOnNewLine) ? 2048 : 1024;
                $dirty5 |= i6;
            } else {
                function2 = actionOnNewLine;
            }
        }
        if (i53 & 24576 == 0) {
            if (traceInProgress & 16 == 0) {
                changed4 = restartGroup.changed(shape) ? 16384 : 8192;
            } else {
                obj4 = shape;
            }
            $dirty5 |= changed4;
        } else {
            obj4 = shape;
        }
        if (i49 &= i53 == 0) {
            if (traceInProgress & 32 == 0) {
                changed3 = restartGroup.changed(containerColor) ? 131072 : 65536;
            } else {
                l = containerColor;
            }
            $dirty5 |= changed3;
        } else {
            l = containerColor;
        }
        if (i53 & i54 == 0) {
            if (traceInProgress & 64 == 0) {
                $dirty4 = $dirty5;
                obj39 = i28;
                changed2 = restartGroup.changed(actionContentColor) ? 1048576 : 524288;
            } else {
                $dirty4 = $dirty5;
                obj39 = i28;
                $dirty3 = actionContentColor;
            }
            $dirty4 |= changed2;
        } else {
            $dirty = $dirty5;
            obj39 = i28;
            $dirty3 = actionContentColor;
        }
        if (i53 & i57 == 0) {
            if (traceInProgress & 128 == 0) {
                i8 = restartGroup.changed(content) ? 8388608 : 4194304;
            } else {
                l3 = content;
            }
            $dirty |= i8;
        } else {
            l3 = content;
        }
        if (i11 &= i53 == 0) {
            if (traceInProgress & 256 == 0) {
                i9 = restartGroup.changed($changed) ? 67108864 : 33554432;
            } else {
                l2 = $changed;
            }
            $dirty |= i9;
        } else {
            l2 = $changed;
        }
        i7 = 805306368;
        if (traceInProgress & 512 != 0) {
            $dirty |= i7;
            obj5 = obj38;
        } else {
            if (i53 & i7 == 0) {
                i7 = restartGroup.changedInstance(obj38) ? 536870912 : 268435456;
                $dirty |= i7;
            } else {
                obj5 = obj38;
            }
        }
        if ($dirty & i59 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i27 = -234881025;
                iNSTANCE2 = -29360129;
                int i60 = -3670017;
                i4 = -458753;
                int i61 = -57345;
                if (i53 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj39 != null) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        action2 = i38 != 0 ? 0 : obj3;
                        dismissAction2 = i40 != 0 ? 0 : str;
                        actionOnNewLine2 = i43 != 0 ? 0 : function2;
                        str = 6;
                        if (traceInProgress & 16 != 0) {
                            shape3 = SnackbarDefaults.INSTANCE.getShape(restartGroup, str);
                            $dirty &= i61;
                        } else {
                            shape3 = obj4;
                        }
                        if (traceInProgress & 32 != 0) {
                            containerColor3 = SnackbarDefaults.INSTANCE.getColor(restartGroup, str);
                            $dirty &= i4;
                        } else {
                            containerColor3 = l;
                        }
                        if (traceInProgress & 64 != 0) {
                            contentColor2 = SnackbarDefaults.INSTANCE.getContentColor(restartGroup, str);
                            $dirty &= i60;
                        } else {
                            contentColor2 = actionContentColor;
                        }
                        if (traceInProgress & 128 != 0) {
                            actionContentColor3 = SnackbarDefaults.INSTANCE.getActionContentColor(restartGroup, str);
                            $dirty &= iNSTANCE2;
                        } else {
                            actionContentColor3 = content;
                        }
                        if (traceInProgress & 256 != 0) {
                            dismissActionContentColor2 = SnackbarDefaults.INSTANCE.getDismissActionContentColor(restartGroup, str);
                            i = $dirty & i27;
                        } else {
                            dismissActionContentColor2 = $changed;
                            i = $dirty;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (traceInProgress & 16 != 0) {
                            $dirty &= i61;
                        }
                        if (traceInProgress & 32 != 0) {
                            $dirty &= i4;
                        }
                        if (traceInProgress & 64 != 0) {
                            $dirty &= i60;
                        }
                        if (traceInProgress & 128 != 0) {
                            $dirty &= iNSTANCE2;
                        }
                        if (traceInProgress & 256 != 0) {
                            actionContentColor3 = content;
                            dismissActionContentColor2 = $changed;
                            i = i25;
                            modifier2 = obj2;
                            action2 = obj3;
                            dismissAction2 = str;
                            actionOnNewLine2 = function2;
                            shape3 = obj4;
                            containerColor3 = l;
                            contentColor2 = actionContentColor;
                        } else {
                            actionContentColor3 = content;
                            dismissActionContentColor2 = $changed;
                            modifier2 = obj2;
                            action2 = obj3;
                            dismissAction2 = str;
                            actionOnNewLine2 = function2;
                            shape3 = obj4;
                            containerColor3 = l;
                            i = $dirty;
                            contentColor2 = actionContentColor;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1235788955, i, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:113)");
                }
                obj28 = obj38;
                obj27 = action2;
                obj26 = actionOnNewLine2;
                obj25 = anon2;
                obj30 = actionContentColor3;
                super(obj26, obj27, obj28, dismissAction2, obj30, contentColor, dismissActionContentColor2, dismissActionContentColor);
                obj25 = modifier2;
                obj35 = restartGroup;
                SurfaceKt.Surface-T9BRK9s(obj25, shape3, containerColor3, obj28, contentColor2, obj30, 0, SnackbarTokens.INSTANCE.getContainerElevation-D9Ej5fM(), 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1829663446, true, obj25, restartGroup, 54), obj35);
                obj = obj25;
                composer = obj35;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj3;
                obj6 = shape3;
                z = str;
                shape2 = contentColor2;
                contentColor3 = dismissActionContentColor2;
                actionContentColor2 = i;
                $dirty2 = dismissAction2;
                dismissAction3 = containerColor3;
                containerColor2 = l4;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                obj = obj2;
                $composer2 = obj3;
                $dirty2 = str;
                z = function2;
                obj6 = obj4;
                dismissAction3 = l;
                actionContentColor2 = $dirty;
                shape2 = actionContentColor;
                containerColor2 = content;
                contentColor3 = $changed;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SnackbarKt.Snackbar.2(obj, $composer2, $dirty2, z, obj6, dismissAction3, obj3, shape2, str, containerColor2, function2, contentColor3, l, obj38, i53, obj41);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void Snackbar-sDKtq54(androidx.compose.material3.SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionColor, long actionContentColor, long dismissActionContentColor, Composer $composer, int $changed, int i12) {
        Object endRestartGroup;
        Object obj;
        int i4;
        int changed6;
        int i2;
        int skipping;
        int defaultsInvalid;
        Object modifier2;
        int changed2;
        boolean $composer2;
        int $dirty;
        long $dirty4;
        long l3;
        long l2;
        long l7;
        Object actionColor3;
        int i8;
        androidx.compose.material3.SnackbarDefaults iNSTANCE3;
        long l12;
        Object actionOnNewLine2;
        boolean traceInProgress;
        int i3;
        Object shape2;
        int rememberComposableLambda2;
        long l10;
        boolean z;
        int i;
        Object containerColor2;
        long l4;
        int changed;
        long rememberComposableLambda;
        boolean withDismissAction;
        long contentColor2;
        long l8;
        int changed4;
        long l5;
        int iNSTANCE;
        int iNSTANCE2;
        long l13;
        int changed5;
        int $dirty2;
        int $dirty3;
        int changed3;
        Modifier padding-3ABfNKs;
        int i7;
        int i10;
        long actionColor2;
        int i5;
        boolean z2;
        long actionContentColor3;
        Object actionContentColor2;
        long l9;
        long dismissActionContentColor2;
        long l11;
        long l;
        long l6;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i9;
        int i6;
        ScopeUpdateScope scopeUpdateScope;
        int obj48;
        obj = snackbarData;
        final int i67 = obj49;
        int i11 = obj50;
        Composer restartGroup = obj48.startRestartGroup(274621471);
        ComposerKt.sourceInformation(restartGroup, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)205@9602L5,206@9654L5,207@9704L12,208@9760L11,209@9822L18,210@9898L25,251@11371L38,241@10959L456:Snackbar.kt#uh7d8r");
        $dirty = obj49;
        if (i11 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i67 & 6 == 0) {
                i8 = restartGroup.changed(obj) ? 4 : 2;
                $dirty |= i8;
            }
        }
        int i25 = i11 & 2;
        if (i25 != 0) {
            $dirty |= 48;
            actionOnNewLine2 = modifier;
        } else {
            if (i67 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                actionOnNewLine2 = modifier;
            }
        }
        shape2 = i11 & 4;
        if (shape2 != 0) {
            $dirty |= 384;
            z = actionOnNewLine;
        } else {
            if (i67 & 384 == 0) {
                i = restartGroup.changed(actionOnNewLine) ? 256 : 128;
                $dirty |= i;
            } else {
                z = actionOnNewLine;
            }
        }
        if (i67 & 3072 == 0) {
            if (i11 & 8 == 0) {
                changed = restartGroup.changed(shape) ? 2048 : 1024;
            } else {
                containerColor2 = shape;
            }
            $dirty |= changed;
        } else {
            containerColor2 = shape;
        }
        if (i67 & 24576 == 0) {
            if (i11 & 16 == 0) {
                changed4 = restartGroup.changed(containerColor) ? 16384 : 8192;
            } else {
                rememberComposableLambda = containerColor;
            }
            $dirty |= changed4;
        } else {
            rememberComposableLambda = containerColor;
        }
        if (i61 &= i67 == 0) {
            if (i11 & 32 == 0) {
                changed5 = restartGroup.changed(actionColor) ? 131072 : 65536;
            } else {
                l5 = actionColor;
            }
            $dirty |= changed5;
        } else {
            l5 = actionColor;
        }
        if (i64 &= i67 == 0) {
            if (i11 & 64 == 0) {
                $dirty2 = $dirty;
                obj48 = i25;
                changed3 = restartGroup.changed(dismissActionContentColor) ? 1048576 : 524288;
            } else {
                $dirty2 = $dirty;
                obj48 = i25;
                $dirty4 = dismissActionContentColor;
            }
            $dirty2 |= changed3;
        } else {
            $dirty3 = $dirty;
            obj48 = i25;
            $dirty4 = dismissActionContentColor;
        }
        if (i67 & i68 == 0) {
            if (i11 & 128 == 0) {
                i4 = restartGroup.changed($changed) ? 8388608 : 4194304;
            } else {
                l3 = $changed;
            }
            $dirty3 |= i4;
        } else {
            l3 = $changed;
        }
        if (i13 &= i67 == 0) {
            if (i11 & 256 == 0) {
                i2 = restartGroup.changed(obj46) ? 67108864 : 33554432;
            } else {
                l2 = obj46;
            }
            $dirty3 |= i2;
        } else {
            l2 = obj46;
        }
        if (i14 &= $dirty3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i23 = -234881025;
                iNSTANCE3 = -29360129;
                int i69 = -3670017;
                actionColor2 = -458753;
                int i70 = -57345;
                if (i67 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj48 != null) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = actionOnNewLine2;
                        }
                        actionOnNewLine2 = shape2 != 0 ? 0 : z;
                        z = 6;
                        if (i11 & 8 != 0) {
                            shape2 = SnackbarDefaults.INSTANCE.getShape(restartGroup, z);
                            $dirty3 &= -7169;
                        } else {
                            shape2 = containerColor2;
                        }
                        if (i11 & 16 != 0) {
                            containerColor2 = SnackbarDefaults.INSTANCE.getColor(restartGroup, z);
                            $dirty3 &= i70;
                        } else {
                            containerColor2 = rememberComposableLambda;
                        }
                        if (i11 & 32 != 0) {
                            contentColor2 = SnackbarDefaults.INSTANCE.getContentColor(restartGroup, z);
                            $dirty3 &= actionColor2;
                        } else {
                            contentColor2 = l5;
                        }
                        if (i11 & 64 != 0) {
                            actionColor2 = SnackbarDefaults.INSTANCE.getActionColor(restartGroup, z);
                            $dirty3 &= i69;
                        } else {
                            actionColor2 = dismissActionContentColor;
                        }
                        if (i11 & 128 != 0) {
                            actionContentColor3 = SnackbarDefaults.INSTANCE.getActionContentColor(restartGroup, z);
                            $dirty3 &= iNSTANCE3;
                        } else {
                            actionContentColor3 = $changed;
                        }
                        if (i11 & 256 != 0) {
                            $dirty3 = i24;
                            l7 = actionColor2;
                            l = actionContentColor3;
                            l6 = dismissActionContentColor2;
                            z2 = actionOnNewLine2;
                            actionContentColor2 = shape2;
                            l9 = containerColor2;
                            l11 = contentColor2;
                        } else {
                            l6 = obj46;
                            l11 = contentColor2;
                            l7 = actionColor2;
                            l = actionContentColor3;
                            z2 = actionOnNewLine2;
                            actionContentColor2 = shape2;
                            l9 = containerColor2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i11 & 8 != 0) {
                            $dirty3 &= -7169;
                        }
                        if (i11 & 16 != 0) {
                            $dirty3 &= i70;
                        }
                        if (i11 & 32 != 0) {
                            $dirty3 &= actionColor2;
                        }
                        if (i11 & 64 != 0) {
                            $dirty3 &= i69;
                        }
                        if (i11 & 128 != 0) {
                            $dirty3 &= iNSTANCE3;
                        }
                        if (i11 & 256 != 0) {
                            l7 = dismissActionContentColor;
                            l = $changed;
                            l6 = obj46;
                            $dirty3 = i21;
                            modifier2 = actionOnNewLine2;
                            z2 = z;
                            actionContentColor2 = containerColor2;
                            l9 = rememberComposableLambda;
                            l11 = l5;
                        } else {
                            l7 = dismissActionContentColor;
                            l = $changed;
                            l6 = obj46;
                            modifier2 = actionOnNewLine2;
                            z2 = z;
                            actionContentColor2 = containerColor2;
                            l9 = rememberComposableLambda;
                            l11 = l5;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(274621471, $dirty3, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:211)");
                }
                actionOnNewLine2 = obj.getVisuals().getActionLabel();
                restartGroup.startReplaceGroup(1561344786);
                ComposerKt.sourceInformation(restartGroup, "215@10097L267");
                rememberComposableLambda2 = 0;
                int i37 = 54;
                int i52 = 1;
                if (actionOnNewLine2 != null) {
                    SnackbarKt.Snackbar.actionComposable.1 anon3 = new SnackbarKt.Snackbar.actionComposable.1(l7, iNSTANCE3, obj, actionOnNewLine2);
                    i7 = rememberComposableLambda;
                } else {
                    i7 = rememberComposableLambda2;
                }
                restartGroup.endReplaceGroup();
                restartGroup.startReplaceGroup(1561358724);
                ComposerKt.sourceInformation(restartGroup, "227@10548L362");
                if (obj.getVisuals().getWithDismissAction()) {
                    SnackbarKt.Snackbar.dismissActionComposable.1 anon2 = new SnackbarKt.Snackbar.dismissActionComposable.1(obj);
                    i5 = rememberComposableLambda2;
                } else {
                    i5 = rememberComposableLambda2;
                }
                restartGroup.endReplaceGroup();
                int i59 = 0;
                SnackbarKt.Snackbar.3 anon = new SnackbarKt.Snackbar.3(obj);
                SnackbarKt.Snackbar-eQBnUkQ(PaddingKt.padding-3ABfNKs(modifier2, Dp.constructor-impl((float)i29)), i7, i5, z2, actionContentColor2, l9, dismissActionContentColor2, l11, obj24, l, obj26, l6, obj28);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l4 = l7;
                i10 = $dirty3;
                $composer2 = z2;
                actionColor3 = actionContentColor2;
                l12 = l9;
                l10 = l11;
                l8 = l;
                l13 = l6;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                modifier2 = actionOnNewLine2;
                $composer2 = z;
                actionColor3 = containerColor2;
                l12 = rememberComposableLambda;
                l10 = l5;
                i10 = $dirty3;
                l4 = dismissActionContentColor;
                l8 = $changed;
                l13 = obj46;
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SnackbarKt.Snackbar.4(obj, modifier2, $composer2, actionColor3, l12, actionOnNewLine2, l10, z, l4, rememberComposableLambda, l8, l5, l13, $dirty3, i67, obj50);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void access$NewLineButtonSnackbar-kKq0p4A(Function2 text, Function2 action, Function2 dismissAction, TextStyle actionTextStyle, long actionContentColor, long dismissActionContentColor, Composer $composer, int $changed) {
        SnackbarKt.NewLineButtonSnackbar-kKq0p4A(text, action, dismissAction, actionTextStyle, actionContentColor, dismissActionContentColor, $composer, $changed);
    }

    public static final void access$OneRowSnackbar-kKq0p4A(Function2 text, Function2 action, Function2 dismissAction, TextStyle actionTextStyle, long actionTextColor, long dismissActionColor, Composer $composer, int $changed) {
        SnackbarKt.OneRowSnackbar-kKq0p4A(text, action, dismissAction, actionTextStyle, actionTextColor, dismissActionColor, $composer, $changed);
    }

    public static final float access$getContainerMaxWidth$p() {
        return SnackbarKt.ContainerMaxWidth;
    }

    public static final float access$getHeightToFirstLine$p() {
        return SnackbarKt.HeightToFirstLine;
    }

    public static final float access$getTextEndExtraSpacing$p() {
        return SnackbarKt.TextEndExtraSpacing;
    }
}
