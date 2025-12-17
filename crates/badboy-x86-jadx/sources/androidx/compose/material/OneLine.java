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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JT\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\u0008\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0002\u0008\u00132\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\u0008\u0013H\u0007¢\u0006\u0002\u0010\u0016R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0008\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\t\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\n\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u000c\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/material/OneLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OneLine {

    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    public static final androidx.compose.material.OneLine INSTANCE;
    private static final float IconLeftPadding;
    private static final float IconMinPaddedWidth;
    private static final float IconVerticalPadding;
    private static final float MinHeight;
    private static final float MinHeightWithIcon;
    private static final float TrailingRightPadding;
    static {
        OneLine oneLine = new OneLine();
        OneLine.INSTANCE = oneLine;
        int i9 = 0;
        OneLine.MinHeight = Dp.constructor-impl((float)i);
        int i10 = 0;
        OneLine.MinHeightWithIcon = Dp.constructor-impl((float)i2);
        int i11 = 0;
        OneLine.IconMinPaddedWidth = Dp.constructor-impl((float)i3);
        int i12 = 0;
        OneLine.IconLeftPadding = Dp.constructor-impl((float)i4);
        int i13 = 0;
        OneLine.IconVerticalPadding = Dp.constructor-impl((float)i5);
        int i14 = 0;
        OneLine.ContentLeftPadding = Dp.constructor-impl((float)i6);
        int i15 = 0;
        OneLine.ContentRightPadding = Dp.constructor-impl((float)i7);
        int i16 = 0;
        OneLine.TrailingRightPadding = Dp.constructor-impl((float)i8);
    }

    public final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> trailing, Composer $composer, int $changed, int i7) {
        float minHeightWithIcon;
        Integer valueOf;
        boolean traceInProgress2;
        int $dirty2;
        int $dirty;
        boolean traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Integer $this$ListItem_u24lambda_u243;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        int str2;
        Object $this$ListItem_u24lambda_u243_u24lambda_u242;
        Object obj3;
        boolean maybeCachedBoxMeasurePolicy;
        Object $composer$iv;
        boolean currentCompositionLocalMap3;
        int valueOf3;
        Composer composer8;
        int str;
        boolean currentCompositionLocalMap4;
        Object topStart;
        Composer restartGroup;
        Object valueOf2;
        Composer composer9;
        String $composer$iv2;
        boolean currentCompositionLocalMap;
        int i;
        int i2;
        int i22;
        int i9;
        Object obj2;
        Composer composer4;
        Object currentCompositionLocalMap2;
        Composer composer10;
        Object maybeCachedBoxMeasurePolicy2;
        int i8;
        Modifier materializeModifier;
        BoxScopeInstance iNSTANCE;
        Object maybeCachedBoxMeasurePolicy3;
        androidx.compose.foundation.layout.Arrangement.Horizontal start;
        androidx.compose.ui.Alignment.Vertical top;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i4;
        int i13;
        int i10;
        int currentCompositeKeyHash3;
        int i21;
        int i14;
        int i17;
        Modifier modifier4;
        kotlin.jvm.functions.Function0 function02;
        int i3;
        Composer composer;
        int i11;
        int composer5;
        Composer composer2;
        int i23;
        Modifier modifier2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        Object obj;
        RowScopeInstance other$iv;
        int i25;
        int i24;
        int currentCompositeKeyHash2;
        Alignment alignment;
        int currentCompositeKeyHash;
        int i16;
        Composer composer3;
        int i27;
        int i18;
        int i5;
        BoxScopeInstance boxScopeInstance;
        int i26;
        int i19;
        int localMap$iv$iv2;
        Modifier modifier3;
        kotlin.jvm.functions.Function0 function0;
        int trailingRightPadding;
        int i20;
        Composer composer7;
        int i15;
        int measurePolicy$iv;
        int i6;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv3;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer6;
        int i12;
        float obj61;
        int obj65;
        $composer$iv = icon;
        valueOf3 = text;
        final Object obj4 = trailing;
        str = $changed;
        traceInProgress2 = -1884451315;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ListItem)P(1)145@5547L1102:ListItem.kt#jmzs0o");
        $dirty2 = $changed;
        str2 = i7 & 1;
        topStart = 2;
        if (str2 != null) {
            $dirty2 |= 6;
            valueOf2 = modifier;
        } else {
            if (str & 6 == 0) {
                i = restartGroup.changed(modifier) ? 4 : topStart;
                $dirty2 |= i;
            } else {
                valueOf2 = modifier;
            }
        }
        if (i7 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (str & 48 == 0) {
                i2 = restartGroup.changedInstance($composer$iv) ? 32 : 16;
                $dirty2 |= i2;
            }
        }
        if (i7 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (str & 384 == 0) {
                i22 = restartGroup.changedInstance(valueOf3) ? 256 : 128;
                $dirty2 |= i22;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (str & 3072 == 0) {
                i9 = restartGroup.changedInstance(obj4) ? 2048 : 1024;
                $dirty2 |= i9;
            }
        }
        if (i7 & 16 != 0) {
            $dirty2 |= 24576;
            obj2 = this;
        } else {
            if (str & 24576 == 0) {
                i8 = restartGroup.changed(this) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                obj2 = this;
            }
        }
        materializeModifier = $dirty2;
        if (materializeModifier & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (str2 != null) {
                    valueOf2 = $dirty;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, materializeModifier, -1, "androidx.compose.material.OneLine.ListItem (ListItem.kt:143)");
                }
                minHeightWithIcon = $composer$iv == null ? OneLine.MinHeight : OneLine.MinHeightWithIcon;
                Modifier heightIn-VpY3zN4$default = SizeKt.heightIn-VpY3zN4$default(valueOf2, minHeightWithIcon, 0, topStart, 0);
                int i55 = 0;
                iNSTANCE = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i13 = 0;
                obj61 = minHeightWithIcon;
                String minHeight = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, minHeight);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap4 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, heightIn-VpY3zN4$default);
                modifier4 = heightIn-VpY3zN4$default;
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i17 = 0;
                str = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory$iv$iv$iv = function03;
                    restartGroup.useNode();
                }
                function02 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i93 = 0;
                composer2 = restartGroup;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), restartGroup, i86 |= i89), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i94 = 0;
                Composer composer14 = constructor-impl;
                int i95 = 0;
                if (!composer14.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap4;
                    obj = valueOf2;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer9 = composer14;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap4;
                    obj = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = composer2;
                i11 = i36;
                ComposerKt.sourceInformationMarkerStart(composer12, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance iNSTANCE2 = RowScopeInstance.INSTANCE;
                i23 = 0;
                modifier2 = materializeModifier3;
                i27 = i62;
                restartGroup = composer5;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1966472373, "C158@6124L262:ListItem.kt#jmzs0o");
                $this$ListItem_u24lambda_u243_u24lambda_u242 = "C73@3429L9:Box.kt#2w3rfo";
                topStart = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i18 = $composer$iv2;
                i5 = 48;
                if ($composer$iv != null) {
                    restartGroup.startReplaceGroup(-1966471444);
                    ComposerKt.sourceInformation(restartGroup, "147@5637L460");
                    int i98 = 0;
                    other$iv = iNSTANCE2;
                    i19 = iNSTANCE;
                    Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.widthIn-VpY3zN4$default((RowScope)iNSTANCE2.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterVertically()), Dp.constructor-impl(iconLeftPadding + iconMinPaddedWidth), 0, 2, 0), OneLine.IconLeftPadding, OneLine.IconVerticalPadding, 0, OneLine.IconVerticalPadding, 4, 0);
                    Alignment centerStart = Alignment.Companion.getCenterStart();
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, topStart);
                    int i82 = 0;
                    obj65 = i73;
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, i82);
                    currentCompositeKeyHash2 = 0;
                    alignment = centerStart;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, minHeight);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    i16 = i76;
                    modifier3 = padding-qDBjuR0$default3;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    localMap$iv$iv2 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function06);
                    } else {
                        factory$iv$iv$iv2 = function06;
                        restartGroup.useNode();
                    }
                    function0 = factory$iv$iv$iv2;
                    Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                    int i114 = 0;
                    i15 = i82;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i119 = 0;
                    Composer composer17 = constructor-impl3;
                    int i123 = 0;
                    if (!composer17.getInserting()) {
                        localMap$iv$iv3 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy2;
                        if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer10 = composer17;
                        }
                    } else {
                        localMap$iv$iv3 = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy2;
                    }
                    Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier(restartGroup, padding-qDBjuR0$default3), ComposeUiNode.Companion.getSetModifier());
                    Composer composer13 = restartGroup;
                    ComposerKt.sourceInformationMarkerStart(composer13, -2146769399, $this$ListItem_u24lambda_u243_u24lambda_u242);
                    iNSTANCE = BoxScopeInstance.INSTANCE;
                    i116 |= 6;
                    measurePolicy$iv = 0;
                    i6 = i51;
                    i12 = i74;
                    obj2 = composer7;
                    ComposerKt.sourceInformationMarkerStart(obj2, 553846324, "C156@6089L6:ListItem.kt#jmzs0o");
                    $composer$iv.invoke(obj2, Integer.valueOf(i52 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(obj2);
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    other$iv = iNSTANCE2;
                    i26 = materializeModifier;
                    i19 = iNSTANCE;
                    restartGroup.startReplaceGroup(-1965998632);
                    restartGroup.endReplaceGroup();
                }
                valueOf2 = other$iv;
                Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(valueOf2.align(RowScope.weight$default(other$iv, (Modifier)Modifier.Companion, 1065353216, false, 2, 0), Alignment.Companion.getCenterVertically()), OneLine.ContentLeftPadding, 0, OneLine.ContentRightPadding, 0, 10, 0);
                Alignment centerStart2 = Alignment.Companion.getCenterStart();
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, topStart);
                int i78 = 0;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart2, i78);
                i24 = 0;
                obj65 = centerStart2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, minHeight);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                alignment = i75;
                i16 = padding-qDBjuR0$default;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                currentCompositeKeyHash = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function05);
                } else {
                    factory$iv$iv$iv3 = function05;
                    restartGroup.useNode();
                }
                localMap$iv$iv2 = factory$iv$iv$iv3;
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                int i108 = 0;
                i20 = i78;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i111 = 0;
                Composer composer16 = constructor-impl2;
                int i121 = 0;
                if (!composer16.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i6 = currentCompositionLocalMap2;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer16;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i6 = currentCompositionLocalMap2;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(restartGroup, padding-qDBjuR0$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = restartGroup;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, $this$ListItem_u24lambda_u243_u24lambda_u242);
                maybeCachedBoxMeasurePolicy3 = BoxScopeInstance.INSTANCE;
                i110 |= 6;
                composer7 = 0;
                i15 = i40;
                measurePolicy = i72;
                obj2 = trailingRightPadding;
                ComposerKt.sourceInformationMarkerStart(obj2, 554133012, "C163@6378L6:ListItem.kt#jmzs0o");
                valueOf3.invoke(obj2, Integer.valueOf(i41 &= 14));
                ComposerKt.sourceInformationMarkerEnd(obj2);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (obj4 != null) {
                    restartGroup.startReplaceGroup(-1965684354);
                    ComposerKt.sourceInformation(restartGroup, "165@6439L186");
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(valueOf2.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterVertically()), 0, 0, OneLine.TrailingRightPadding, 0, 11, 0);
                    int i56 = i91;
                    obj2 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, topStart);
                    i24 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, minHeight);
                    currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                    i10 = currentCompositeKeyHash4;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, padding-qDBjuR0$default2);
                    currentCompositeKeyHash2 = padding-qDBjuR0$default2;
                    kotlin.jvm.functions.Function0 function04 = constructor;
                    i21 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function04);
                    } else {
                        factory$iv$iv$iv4 = function04;
                        restartGroup.useNode();
                    }
                    Composer constructor-impl4 = Updater.constructor-impl(restartGroup);
                    int i92 = 0;
                    i16 = factory$iv$iv$iv4;
                    Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i103 = 0;
                    Composer composer15 = constructor-impl4;
                    int i106 = 0;
                    if (!composer15.getInserting()) {
                        localMap$iv$iv2 = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(i10))) {
                            composer15.updateRememberedValue(Integer.valueOf(i10));
                            constructor-impl4.apply(Integer.valueOf(i10), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer8 = composer15;
                        }
                    } else {
                        localMap$iv$iv2 = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    $composer$iv = restartGroup;
                    valueOf3 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -2146769399, $this$ListItem_u24lambda_u243_u24lambda_u242);
                    i59 |= 6;
                    composer5 = 0;
                    alignment = materializeModifier2;
                    i5 = i47;
                    boxScopeInstance = iNSTANCE3;
                    $this$ListItem_u24lambda_u243_u24lambda_u242 = composer;
                    ComposerKt.sourceInformationMarkerStart($this$ListItem_u24lambda_u243_u24lambda_u242, 554366256, "C169@6613L10:ListItem.kt#jmzs0o");
                    obj4.invoke($this$ListItem_u24lambda_u243_u24lambda_u242, Integer.valueOf(i29 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($this$ListItem_u24lambda_u243_u24lambda_u242);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-1965474856);
                    restartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                obj3 = valueOf2;
                i26 = materializeModifier;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new OneLine.ListItem.2(this, obj3, icon, text, obj4, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
