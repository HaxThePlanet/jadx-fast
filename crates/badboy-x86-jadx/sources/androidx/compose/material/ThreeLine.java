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
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J|\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0013\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\u0008\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\u0008\u00162\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00110\u0015¢\u0006\u0002\u0008\u00162\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\u0008\u00162\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u001bR\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0008\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000c\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\r\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000f\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/material/ThreeLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconThreeLineVerticalPadding", "MinHeight", "ThreeLineBaselineFirstOffset", "ThreeLineBaselineSecondOffset", "ThreeLineBaselineThirdOffset", "ThreeLineTrailingTopPadding", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "secondaryText", "overlineText", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ThreeLine {

    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    public static final androidx.compose.material.ThreeLine INSTANCE;
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth;
    private static final float IconThreeLineVerticalPadding;
    private static final float MinHeight;
    private static final float ThreeLineBaselineFirstOffset;
    private static final float ThreeLineBaselineSecondOffset;
    private static final float ThreeLineBaselineThirdOffset;
    private static final float ThreeLineTrailingTopPadding;
    private static final float TrailingRightPadding;
    static {
        ThreeLine threeLine = new ThreeLine();
        ThreeLine.INSTANCE = threeLine;
        int i12 = 0;
        ThreeLine.MinHeight = Dp.constructor-impl((float)i);
        int i13 = 0;
        ThreeLine.IconMinPaddedWidth = Dp.constructor-impl((float)i2);
        int i14 = 0;
        ThreeLine.IconLeftPadding = Dp.constructor-impl((float)i3);
        int i15 = 0;
        ThreeLine.IconThreeLineVerticalPadding = Dp.constructor-impl((float)i4);
        int i16 = 0;
        ThreeLine.ContentLeftPadding = Dp.constructor-impl((float)i5);
        int i17 = 0;
        ThreeLine.ContentRightPadding = Dp.constructor-impl((float)i6);
        int i18 = 0;
        ThreeLine.ThreeLineBaselineFirstOffset = Dp.constructor-impl((float)i7);
        int i19 = 0;
        ThreeLine.ThreeLineBaselineSecondOffset = Dp.constructor-impl((float)i8);
        int i20 = 0;
        ThreeLine.ThreeLineBaselineThirdOffset = Dp.constructor-impl((float)i9);
        int i21 = 0;
        ThreeLine.ThreeLineTrailingTopPadding = Dp.constructor-impl((float)i10);
        int i22 = 0;
        ThreeLine.TrailingRightPadding = Dp.constructor-impl((float)i11);
    }

    public final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> secondaryText, Function2<? super Composer, ? super Integer, Unit> overlineText, Function2<? super Composer, ? super Integer, Unit> trailing, Composer $composer, int $changed, int i9) {
        Integer valueOf;
        androidx.compose.ui.Alignment.Vertical verticalAlignment$iv2;
        boolean currentCompositionLocalMap;
        boolean traceInProgress2;
        String materialized$iv$iv;
        RowScopeInstance i19;
        int $dirty;
        int skipping;
        Object modifier5;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Composer composer;
        androidx.compose.ui.layout.MeasurePolicy $composer2;
        Composer composer3;
        Object maybeCachedBoxMeasurePolicy;
        Object companion;
        boolean other$iv;
        int i2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        boolean traceInProgress;
        Composer composer5;
        Object padding-qDBjuR0$default;
        Object valueOf2;
        int str;
        int localMap$iv$iv;
        Object verticalAlignment$iv;
        int i12;
        int i6;
        int i14;
        int i3;
        int i10;
        int i26;
        int i13;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        Object obj;
        int i15;
        int i22;
        int i23;
        int i4;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap map;
        int i21;
        Modifier modifier3;
        int function02;
        int i25;
        androidx.compose.ui.Modifier.Companion companion2;
        int i11;
        int i17;
        kotlin.jvm.functions.Function0 function03;
        int i;
        Modifier modifier2;
        androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement$iv;
        java.util.List list;
        int padding-qDBjuR0$default2;
        float f;
        int i24;
        int i20;
        int i18;
        int i8;
        int $changed$iv;
        Composer composer2;
        int weight$default;
        Alignment contentLeftPadding;
        int threeLineTrailingTopPadding;
        Composer trailingRightPadding;
        int i16;
        int i7;
        kotlin.jvm.functions.Function0 function0;
        int i5;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv3;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Modifier modifier4;
        Composer composer4;
        Modifier obj56;
        int obj62;
        final Object obj2 = icon;
        final Object obj3 = text;
        final Object obj4 = secondaryText;
        final Object obj5 = overlineText;
        traceInProgress2 = $changed;
        i19 = 1749738797;
        final Composer restartGroup = $composer.startRestartGroup(i19);
        ComposerKt.sourceInformation(restartGroup, "C(ListItem)P(1!1,4,3)305@11347L1431:ListItem.kt#jmzs0o");
        $dirty = $changed;
        padding-qDBjuR0$default = i9 & 1;
        localMap$iv$iv = 2;
        if (padding-qDBjuR0$default != 0) {
            $dirty |= 6;
            verticalAlignment$iv = modifier;
        } else {
            if (traceInProgress2 & 6 == 0) {
                i12 = restartGroup.changed(modifier) ? 4 : localMap$iv$iv;
                $dirty |= i12;
            } else {
                verticalAlignment$iv = modifier;
            }
        }
        if (i9 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (traceInProgress2 & 48 == 0) {
                i6 = restartGroup.changedInstance(obj2) ? 32 : 16;
                $dirty |= i6;
            }
        }
        if (i9 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (traceInProgress2 & 384 == 0) {
                i14 = restartGroup.changedInstance(obj3) ? 256 : 128;
                $dirty |= i14;
            }
        }
        if (i9 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (traceInProgress2 & 3072 == 0) {
                i3 = restartGroup.changedInstance(obj4) ? 2048 : 1024;
                $dirty |= i3;
            }
        }
        if (i9 & 16 != 0) {
            $dirty |= 24576;
        } else {
            if (traceInProgress2 & 24576 == 0) {
                i10 = restartGroup.changedInstance(obj5) ? 16384 : 8192;
                $dirty |= i10;
            }
        }
        int i64 = 196608;
        if (i9 & 32 != 0) {
            $dirty |= i64;
        } else {
            if (traceInProgress2 & i64 == 0) {
                i26 = restartGroup.changedInstance(trailing) ? 131072 : 65536;
                $dirty |= i26;
            }
        }
        localMap$iv$iv2 = 1572864;
        if (i9 & 64 != 0) {
            $dirty |= localMap$iv$iv2;
            obj = this;
        } else {
            if (traceInProgress2 & localMap$iv$iv2 == 0) {
                i13 = restartGroup.changed(this) ? 1048576 : 524288;
                $dirty |= i13;
            } else {
                obj = this;
            }
        }
        final int i71 = $dirty;
        if ($dirty2 &= i71 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (padding-qDBjuR0$default != 0) {
                    modifier5 = Modifier.Companion;
                } else {
                    modifier5 = verticalAlignment$iv;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i19, i71, -1, "androidx.compose.material.ThreeLine.ListItem (ListItem.kt:304)");
                }
                Modifier heightIn-VpY3zN4$default = SizeKt.heightIn-VpY3zN4$default(modifier5, ThreeLine.MinHeight, 0, localMap$iv$iv, 0);
                i15 = 0;
                i22 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                valueOf2 = Arrangement.INSTANCE.getStart();
                androidx.compose.ui.Alignment.Vertical top = Alignment.Companion.getTop();
                measurePolicy$iv = RowKt.rowMeasurePolicy(valueOf2, top, restartGroup, i62 |= i66);
                i4 = 0;
                str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                localMap$iv$iv2 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, heightIn-VpY3zN4$default);
                modifier3 = heightIn-VpY3zN4$default;
                function02 = constructor;
                i21 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv2 = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i74 = 0;
                function03 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i75 = 0;
                Composer composer7 = constructor-impl;
                int i76 = 0;
                if (!composer7.getInserting()) {
                    horizontalArrangement$iv = valueOf2;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer7;
                    }
                } else {
                    horizontalArrangement$iv = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i43 &= 14;
                composer = restartGroup;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(composer, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i17 = i53 | 6;
                padding-qDBjuR0$default = composer;
                RowScopeInstance rowScopeInstance = iNSTANCE2;
                i = 0;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(padding-qDBjuR0$default, 1135409882, "C327@12321L127,319@11971L477:ListItem.kt#jmzs0o");
                if (obj2 != null) {
                    padding-qDBjuR0$default.startReplaceGroup(1135402069);
                    ComposerKt.sourceInformation(padding-qDBjuR0$default, "308@11504L440");
                    int i78 = 0;
                    f = arg0$iv2;
                    Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.sizeIn-qDBjuR0$default((Modifier)Modifier.Companion, f, f, 0, 0, 12, 0), ThreeLine.IconLeftPadding, ThreeLine.IconThreeLineVerticalPadding, 0, ThreeLine.IconThreeLineVerticalPadding, 4, 0);
                    padding-qDBjuR0$default2 = i27;
                    i20 = 0;
                    $changed$iv = materialized$iv$iv;
                    ComposerKt.sourceInformationMarkerStart(padding-qDBjuR0$default, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    int i35 = 0;
                    composer2 = composer;
                    Alignment alignment = alignment2;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, i35);
                    i18 = 0;
                    weight$default = i35;
                    ComposerKt.sourceInformationMarkerStart(padding-qDBjuR0$default, -1323940314, str);
                    currentCompositionLocalMap = padding-qDBjuR0$default.getCurrentCompositionLocalMap();
                    contentLeftPadding = alignment;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(padding-qDBjuR0$default, padding-qDBjuR0$default3);
                    obj56 = padding-qDBjuR0$default3;
                    kotlin.jvm.functions.Function0 function04 = constructor2;
                    threeLineTrailingTopPadding = 0;
                    i7 = currentCompositeKeyHash2;
                    ComposerKt.sourceInformationMarkerStart(padding-qDBjuR0$default, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    padding-qDBjuR0$default.startReusableNode();
                    if (padding-qDBjuR0$default.getInserting()) {
                        padding-qDBjuR0$default.createNode(function04);
                    } else {
                        factory$iv$iv$iv = function04;
                        padding-qDBjuR0$default.useNode();
                    }
                    Composer constructor-impl2 = Updater.constructor-impl(padding-qDBjuR0$default);
                    int i73 = 0;
                    function0 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i88 = 0;
                    Composer composer8 = constructor-impl2;
                    int i91 = 0;
                    if (!composer8.getInserting()) {
                        localMap$iv$iv3 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                        if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(i7))) {
                            composer8.updateRememberedValue(Integer.valueOf(i7));
                            constructor-impl2.apply(Integer.valueOf(i7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer8;
                        }
                    } else {
                        localMap$iv$iv3 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    composer = padding-qDBjuR0$default;
                    i2 = 0;
                    function02 = i38;
                    ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i58 |= 6;
                    trailingRightPadding = composer;
                    i5 = 0;
                    boxScopeInstance = iNSTANCE;
                    modifier4 = materializeModifier2;
                    ComposerKt.sourceInformationMarkerStart(composer, -609404916, "C317@11936L6:ListItem.kt#jmzs0o");
                    obj2.invoke(composer, Integer.valueOf(i39 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    padding-qDBjuR0$default.endNode();
                    ComposerKt.sourceInformationMarkerEnd(padding-qDBjuR0$default);
                    ComposerKt.sourceInformationMarkerEnd(padding-qDBjuR0$default);
                    ComposerKt.sourceInformationMarkerEnd(padding-qDBjuR0$default);
                    padding-qDBjuR0$default.endReplaceGroup();
                } else {
                    $changed$iv = materialized$iv$iv;
                    composer2 = composer;
                    padding-qDBjuR0$default.startReplaceGroup(1135920048);
                    padding-qDBjuR0$default.endReplaceGroup();
                }
                Dp[] arr = new Dp[3];
                int i45 = 1;
                arr[i45] = Dp.box-impl(ThreeLine.ThreeLineBaselineSecondOffset);
                arr[localMap$iv$iv] = Dp.box-impl(ThreeLine.ThreeLineBaselineThirdOffset);
                i19 = rowScopeInstance;
                ThreeLine.ListItem.1.2 anon = new ThreeLine.ListItem.1.2(obj5, obj3, obj4);
                i24 = padding-qDBjuR0$default;
                ListItemKt.access$BaselinesOffsetColumn(CollectionsKt.listOf(arr), PaddingKt.padding-qDBjuR0$default(RowScope.weight$default(rowScopeInstance, (Modifier)Modifier.Companion, 1065353216, false, 2, 0), ThreeLine.ContentLeftPadding, 0, ThreeLine.ContentRightPadding, 0, 10, 0), (Function2)ComposableLambdaKt.rememberComposableLambda(-318094245, i45, anon, padding-qDBjuR0$default, 54), i24, 390, 0);
                Composer composer6 = i24;
                if (trailing != null) {
                    composer6.startReplaceGroup(1136449683);
                    ComposerKt.sourceInformation(composer6, "333@12501L253");
                    int i54 = 0;
                    i8 = 54;
                    verticalAlignment$iv2 = top;
                    verticalAlignment$iv = composer6;
                    $composer2 = measurePolicy2;
                    map = map2;
                    ListItemKt.access$OffsetToBaselineOrCenter-Kz89ssw(Dp.constructor-impl(threeLineBaselineFirstOffset - threeLineTrailingTopPadding2), PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, 0, ThreeLine.ThreeLineTrailingTopPadding, ThreeLine.TrailingRightPadding, 0, 9, 0), trailing, verticalAlignment$iv, i32 |= 54, 0);
                    verticalAlignment$iv.endReplaceGroup();
                } else {
                    verticalAlignment$iv2 = top;
                    map = localMap$iv$iv2;
                    verticalAlignment$iv = composer6;
                    $composer2 = measurePolicy$iv;
                    verticalAlignment$iv.startReplaceGroup(1136723568);
                    verticalAlignment$iv.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(verticalAlignment$iv);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                companion = companion2;
            } else {
                restartGroup.skipToGroupEnd();
                companion = verticalAlignment$iv;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ThreeLine.ListItem.2(obj, companion, obj2, obj3, obj4, obj5, trailing, $changed, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
