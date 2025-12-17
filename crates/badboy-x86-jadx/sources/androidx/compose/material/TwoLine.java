package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J~\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\u0008\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u00192\u0013\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\u0008\u0019H\u0007¢\u0006\u0002\u0010\u001eR\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0008\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000c\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0010\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0011\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0012\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/material/TwoLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "OverlineBaselineOffset", "OverlineToPrimaryBaselineOffset", "PrimaryBaselineOffsetNoIcon", "PrimaryBaselineOffsetWithIcon", "PrimaryToSecondaryBaselineOffsetNoIcon", "PrimaryToSecondaryBaselineOffsetWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TwoLine {

    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    public static final androidx.compose.material.TwoLine INSTANCE;
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth;
    private static final float IconVerticalPadding;
    private static final float MinHeight;
    private static final float MinHeightWithIcon;
    private static final float OverlineBaselineOffset;
    private static final float OverlineToPrimaryBaselineOffset;
    private static final float PrimaryBaselineOffsetNoIcon;
    private static final float PrimaryBaselineOffsetWithIcon;
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon;
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon;
    private static final float TrailingRightPadding;
    static {
        TwoLine twoLine = new TwoLine();
        TwoLine.INSTANCE = twoLine;
        int i15 = 0;
        TwoLine.MinHeight = Dp.constructor-impl((float)i);
        int i16 = 0;
        TwoLine.MinHeightWithIcon = Dp.constructor-impl((float)i2);
        int i17 = 0;
        TwoLine.IconMinPaddedWidth = Dp.constructor-impl((float)i3);
        int i18 = 0;
        TwoLine.IconLeftPadding = Dp.constructor-impl((float)i4);
        int i19 = 0;
        TwoLine.IconVerticalPadding = Dp.constructor-impl((float)i5);
        int i20 = 0;
        TwoLine.ContentLeftPadding = Dp.constructor-impl((float)i6);
        int i21 = 0;
        TwoLine.ContentRightPadding = Dp.constructor-impl((float)i7);
        int i22 = 0;
        TwoLine.OverlineBaselineOffset = Dp.constructor-impl((float)i8);
        int i23 = 0;
        TwoLine.OverlineToPrimaryBaselineOffset = Dp.constructor-impl((float)i9);
        int i24 = 0;
        TwoLine.PrimaryBaselineOffsetNoIcon = Dp.constructor-impl((float)i10);
        int i25 = 0;
        TwoLine.PrimaryBaselineOffsetWithIcon = Dp.constructor-impl((float)i11);
        int i26 = 0;
        TwoLine.PrimaryToSecondaryBaselineOffsetNoIcon = Dp.constructor-impl((float)i12);
        int i27 = 0;
        TwoLine.PrimaryToSecondaryBaselineOffsetWithIcon = Dp.constructor-impl((float)i13);
        int i28 = 0;
        TwoLine.TrailingRightPadding = Dp.constructor-impl((float)i14);
    }

    public static final float access$getTrailingRightPadding$p() {
        return TwoLine.TrailingRightPadding;
    }

    public final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> secondaryText, Function2<? super Composer, ? super Integer, Unit> overlineText, Function2<? super Composer, ? super Integer, Unit> trailing, Composer $composer, int $changed, int i9) {
        float minHeightWithIcon;
        boolean currentCompositionLocalMap2;
        boolean traceInProgress;
        int $dirty;
        int rememberComposableLambda;
        boolean traceInProgress2;
        Integer valueOf;
        boolean currentCompositionLocalMap;
        int str;
        String $changed$iv;
        Object obj;
        Object materialized$iv$iv;
        Modifier i23;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Composer composer3;
        int i26;
        int anon;
        float primaryBaselineOffsetNoIcon2;
        float primaryBaselineOffsetNoIcon;
        float primaryToSecondaryBaselineOffsetNoIcon;
        Composer composer6;
        Object maybeCachedBoxMeasurePolicy;
        Object rowMeasurePolicy;
        int restartGroup;
        Object factory$iv$iv$iv2;
        int i22;
        int i18;
        int i24;
        int i11;
        int i8;
        int i16;
        Object obj2;
        int i13;
        float horizontalArrangement$iv;
        Object padding-qDBjuR0$default;
        int f;
        int contentAlignment$iv;
        int i17;
        androidx.compose.foundation.layout.Arrangement.Horizontal horizontal;
        androidx.compose.ui.Alignment.Vertical vertical;
        int i14;
        int i15;
        int i7;
        int i12;
        int currentCompositeKeyHash;
        int i25;
        Modifier modifier4;
        int function0;
        int i5;
        int i3;
        Object obj3;
        Composer composer5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        int i19;
        RowScopeInstance rowScopeInstance;
        int companion;
        java.util.List listOf;
        int padding-qDBjuR0$default2;
        int i27;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i;
        Composer composer;
        int i10;
        int i6;
        Alignment alignment;
        int i2;
        Composer composer2;
        Modifier modifier3;
        Object weight$default;
        int contentLeftPadding;
        int i20;
        kotlin.jvm.functions.Function0 contentRightPadding;
        int i4;
        BoxScopeInstance i21;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Modifier modifier2;
        Composer composer4;
        androidx.compose.ui.Alignment.Vertical vertical2;
        int obj58;
        final Object obj5 = icon;
        final Object obj6 = text;
        final Object obj7 = secondaryText;
        final Object obj8 = overlineText;
        final Object obj9 = trailing;
        i23 = $changed;
        traceInProgress = -1340612993;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ListItem)P(1!1,4,3)208@7880L2468:ListItem.kt#jmzs0o");
        $dirty = $changed;
        str = i9 & 1;
        anon = 2;
        if (str != null) {
            $dirty |= 6;
            factory$iv$iv$iv2 = modifier;
        } else {
            if (i23 & 6 == 0) {
                i22 = restartGroup.changed(modifier) ? 4 : anon;
                $dirty |= i22;
            } else {
                factory$iv$iv$iv2 = modifier;
            }
        }
        if (i9 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i23 & 48 == 0) {
                i18 = restartGroup.changedInstance(obj5) ? 32 : 16;
                $dirty |= i18;
            }
        }
        if (i9 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i23 & 384 == 0) {
                i24 = restartGroup.changedInstance(obj6) ? 256 : 128;
                $dirty |= i24;
            }
        }
        if (i9 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i23 & 3072 == 0) {
                i11 = restartGroup.changedInstance(obj7) ? 2048 : 1024;
                $dirty |= i11;
            }
        }
        if (i9 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (i23 & 24576 == 0) {
                i8 = restartGroup.changedInstance(obj8) ? 16384 : 8192;
                $dirty |= i8;
            }
        }
        int i62 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i62;
        } else {
            if (i23 & i62 == 0) {
                i16 = restartGroup.changedInstance(obj9) ? 131072 : 65536;
                $dirty |= i16;
            }
        }
        i13 = 1572864;
        if (i9 & 64 != 0) {
            $dirty |= i13;
            obj2 = this;
        } else {
            if (i23 & i13 == 0) {
                i13 = restartGroup.changed(this) ? 1048576 : 524288;
                $dirty |= i13;
            } else {
                obj2 = this;
            }
        }
        int i63 = $dirty;
        if ($dirty2 &= i63 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    factory$iv$iv$iv2 = rememberComposableLambda;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i63, -1, "androidx.compose.material.TwoLine.ListItem (ListItem.kt:206)");
                }
                minHeightWithIcon = obj5 == null ? TwoLine.MinHeight : TwoLine.MinHeightWithIcon;
                Modifier heightIn-VpY3zN4$default = SizeKt.heightIn-VpY3zN4$default(factory$iv$iv$iv2, minHeightWithIcon, 0, anon, 0);
                int i43 = 0;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                androidx.compose.foundation.layout.Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                padding-qDBjuR0$default = Alignment.Companion.getTop();
                rowMeasurePolicy = RowKt.rowMeasurePolicy(start, padding-qDBjuR0$default, restartGroup, i66 | i70);
                i7 = 0;
                f = minHeightWithIcon;
                $changed$iv = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, $changed$iv);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, heightIn-VpY3zN4$default);
                modifier4 = heightIn-VpY3zN4$default;
                function0 = constructor;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function0);
                } else {
                    factory$iv$iv$iv2 = function0;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i71 = 0;
                composer5 = restartGroup;
                Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i17 = 0;
                Composer composer9 = constructor-impl;
                int i77 = 0;
                if (!composer9.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = rowMeasurePolicy;
                    if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer9;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy2 = rowMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = composer5;
                i26 = 0;
                i19 = i30;
                ComposerKt.sourceInformationMarkerStart(composer8, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i55 |= 6;
                Composer composer7 = composer8;
                i2 = 0;
                modifier3 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(composer7, -1767188485, "C:ListItem.kt#jmzs0o");
                padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(RowScope.weight$default((RowScope)RowScopeInstance.INSTANCE, (Modifier)Modifier.Companion, 1065353216, false, 2, 0), TwoLine.ContentLeftPadding, 0, TwoLine.ContentRightPadding, 0, 10, 0);
                if (obj5 != null) {
                    composer7.startReplaceGroup(-1767094742);
                    ComposerKt.sourceInformation(composer7, "213@8104L532");
                    int i73 = 0;
                    horizontalArrangement$iv = f;
                    f = 48;
                    i17 = 0;
                    horizontal = horizontal2;
                    vertical = vertical3;
                    ComposerKt.sourceInformationMarkerStart(composer7, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    int i36 = 0;
                    Alignment alignment2 = alignment3;
                    contentAlignment$iv = i26;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment2, i36);
                    i27 = 0;
                    i = i36;
                    ComposerKt.sourceInformationMarkerStart(composer7, -1323940314, $changed$iv);
                    currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                    i12 = currentCompositeKeyHash2;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer7, PaddingKt.padding-qDBjuR0$default(SizeKt.sizeIn-qDBjuR0$default((Modifier)Modifier.Companion, Dp.constructor-impl(iconLeftPadding + iconMinPaddedWidth), f, 0, 0, 12, 0), TwoLine.IconLeftPadding, TwoLine.IconVerticalPadding, 0, TwoLine.IconVerticalPadding, 4, 0));
                    alignment = alignment2;
                    kotlin.jvm.functions.Function0 function02 = constructor2;
                    i10 = 0;
                    i20 = restartGroup;
                    ComposerKt.sourceInformationMarkerStart(composer7, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    composer7.startReusableNode();
                    if (composer7.getInserting()) {
                        composer7.createNode(function02);
                    } else {
                        factory$iv$iv$iv = function02;
                        composer7.useNode();
                    }
                    Composer constructor-impl2 = Updater.constructor-impl(composer7);
                    int i79 = 0;
                    contentRightPadding = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i82 = 0;
                    Composer composer10 = constructor-impl2;
                    int i86 = 0;
                    if (!composer10.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(i12))) {
                            composer10.updateRememberedValue(Integer.valueOf(i12));
                            constructor-impl2.apply(Integer.valueOf(i12), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer10;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    materialized$iv$iv = composer7;
                    i26 = 0;
                    function0 = i39;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i58 |= 6;
                    weight$default = materialized$iv$iv;
                    i4 = 0;
                    i21 = iNSTANCE2;
                    modifier2 = materializeModifier;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 1547774650, "C225@8628L6:ListItem.kt#jmzs0o");
                    obj5.invoke(materialized$iv$iv, Integer.valueOf(i40 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    composer7.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    composer7.endReplaceGroup();
                } else {
                    contentAlignment$iv = i26;
                    i20 = restartGroup;
                    horizontal = start;
                    vertical = padding-qDBjuR0$default;
                    horizontalArrangement$iv = f;
                    composer7.startReplaceGroup(-1766552738);
                    composer7.endReplaceGroup();
                }
                int i34 = 54;
                int i44 = 1;
                if (obj8 != null) {
                    composer7.startReplaceGroup(-1766504564);
                    ComposerKt.sourceInformation(composer7, "232@8869L81,229@8708L242");
                    Dp[] arr = new Dp[2];
                    arr[i44] = Dp.box-impl(TwoLine.OverlineToPrimaryBaselineOffset);
                    TwoLine.ListItem.1.2 anon2 = new TwoLine.ListItem.1.2(obj8, obj6);
                    ListItemKt.access$BaselinesOffsetColumn(CollectionsKt.listOf(arr), padding-qDBjuR0$default2, (Function2)ComposableLambdaKt.rememberComposableLambda(-1675021441, i44, anon2, composer7, i34), composer7, 390, 0);
                    composer7.endReplaceGroup();
                    i23 = padding-qDBjuR0$default2;
                } else {
                    composer7.startReplaceGroup(-1766213598);
                    ComposerKt.sourceInformation(composer7, "251@9572L84,237@8988L668");
                    Dp[] arr2 = new Dp[2];
                    primaryBaselineOffsetNoIcon = obj5 != null ? TwoLine.PrimaryBaselineOffsetWithIcon : TwoLine.PrimaryBaselineOffsetNoIcon;
                    primaryToSecondaryBaselineOffsetNoIcon = obj5 != null ? TwoLine.PrimaryToSecondaryBaselineOffsetWithIcon : TwoLine.PrimaryToSecondaryBaselineOffsetNoIcon;
                    arr2[i44] = Dp.box-impl(primaryToSecondaryBaselineOffsetNoIcon);
                    TwoLine.ListItem.1.3 anon3 = new TwoLine.ListItem.1.3(obj6, obj7);
                    ListItemKt.access$BaselinesOffsetColumn(CollectionsKt.listOf(arr2), padding-qDBjuR0$default2, (Function2)ComposableLambdaKt.rememberComposableLambda(993836488, i44, anon3, composer7, i34), composer7, 384, 0);
                    i23 = padding-qDBjuR0$default2;
                    composer7.endReplaceGroup();
                }
                if (obj9 != null) {
                    composer7.startReplaceGroup(-1765486555);
                    ComposerKt.sourceInformation(composer7, "263@9964L360,257@9723L601");
                    listOf = obj5 != null ? primaryBaselineOffsetNoIcon2 : primaryBaselineOffsetNoIcon2;
                    anon = new TwoLine.ListItem.1.4(horizontalArrangement$iv, obj9);
                    ListItemKt.access$OffsetToBaselineOrCenter-Kz89ssw(listOf, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1696992176, i44, anon, composer7, i34), composer7, 384, 2);
                    composer7.endReplaceGroup();
                } else {
                    composer7.startReplaceGroup(-1764878242);
                    composer7.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                composer5 = restartGroup;
                obj = factory$iv$iv$iv2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TwoLine.ListItem.2(obj2, obj, obj5, obj6, obj7, obj8, obj9, $changed, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
