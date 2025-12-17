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
        Integer valueOf2;
        boolean traceInProgress;
        int $dirty2;
        int $dirty;
        boolean traceInProgress2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Integer $this$ListItem_u24lambda_u243;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv4;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv3;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int str;
        Object $this$ListItem_u24lambda_u243_u24lambda_u242;
        Object obj;
        boolean maybeCachedBoxMeasurePolicy;
        Object $composer$iv;
        boolean currentCompositionLocalMap3;
        int valueOf3;
        Composer composer8;
        int str2;
        boolean currentCompositionLocalMap4;
        Object topStart;
        Composer $i$a$LayoutRowKt$Row$1$iv;
        Object valueOf;
        Composer composer7;
        String $composer$iv2;
        boolean currentCompositionLocalMap2;
        int i25;
        int i17;
        int i5;
        int i11;
        Object $i$a$LayoutBoxKt$Box$1$iv;
        Composer composer5;
        Object currentCompositionLocalMap;
        Composer composer4;
        Object maybeCachedBoxMeasurePolicy3;
        int i14;
        Modifier materializeModifier;
        BoxScopeInstance iNSTANCE;
        Object maybeCachedBoxMeasurePolicy2;
        androidx.compose.foundation.layout.Arrangement.Horizontal start;
        androidx.compose.ui.Alignment.Vertical top;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int i24;
        int i19;
        int i3;
        int currentCompositeKeyHash;
        int i23;
        int i2;
        int i12;
        Modifier modifier3;
        kotlin.jvm.functions.Function0 function02;
        int i6;
        Composer composer9;
        int i18;
        int composer10;
        Composer composer6;
        int i16;
        Modifier modifier2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        Object obj2;
        RowScopeInstance other$iv;
        int i20;
        int i;
        int currentCompositeKeyHash2;
        Alignment alignment;
        int currentCompositeKeyHash3;
        int i27;
        Composer composer2;
        int i13;
        int i26;
        int i10;
        BoxScopeInstance boxScopeInstance;
        int i4;
        int i15;
        int localMap$iv$iv;
        Modifier modifier4;
        kotlin.jvm.functions.Function0 function0;
        int trailingRightPadding;
        int i22;
        Composer composer3;
        int i21;
        int measurePolicy$iv;
        int i8;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv3;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer;
        int i9;
        float obj61;
        int obj65;
        $composer$iv = icon;
        valueOf3 = text;
        final Object obj3 = trailing;
        str2 = $changed;
        traceInProgress = -1884451315;
        $i$a$LayoutRowKt$Row$1$iv = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($i$a$LayoutRowKt$Row$1$iv, "C(ListItem)P(1)145@5547L1102:ListItem.kt#jmzs0o");
        $dirty2 = $changed;
        str = i7 & 1;
        topStart = 2;
        if (str != null) {
            $dirty2 |= 6;
            valueOf = modifier;
        } else {
            if (str2 & 6 == 0) {
                i25 = $i$a$LayoutRowKt$Row$1$iv.changed(modifier) ? 4 : topStart;
                $dirty2 |= i25;
            } else {
                valueOf = modifier;
            }
        }
        if (i7 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (str2 & 48 == 0) {
                i17 = $i$a$LayoutRowKt$Row$1$iv.changedInstance($composer$iv) ? 32 : 16;
                $dirty2 |= i17;
            }
        }
        if (i7 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (str2 & 384 == 0) {
                i5 = $i$a$LayoutRowKt$Row$1$iv.changedInstance(valueOf3) ? 256 : 128;
                $dirty2 |= i5;
            }
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (str2 & 3072 == 0) {
                i11 = $i$a$LayoutRowKt$Row$1$iv.changedInstance(obj3) ? 2048 : 1024;
                $dirty2 |= i11;
            }
        }
        if (i7 & 16 != 0) {
            $dirty2 |= 24576;
            $i$a$LayoutBoxKt$Box$1$iv = this;
        } else {
            if (str2 & 24576 == 0) {
                i14 = $i$a$LayoutRowKt$Row$1$iv.changed(this) ? 16384 : 8192;
                $dirty2 |= i14;
            } else {
                $i$a$LayoutBoxKt$Box$1$iv = this;
            }
        }
        materializeModifier = $dirty2;
        if (materializeModifier & 9363 == 9362) {
            if (!$i$a$LayoutRowKt$Row$1$iv.getSkipping()) {
                if (str != null) {
                    valueOf = $dirty;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, materializeModifier, -1, "androidx.compose.material.OneLine.ListItem (ListItem.kt:143)");
                }
                minHeightWithIcon = $composer$iv == null ? OneLine.MinHeight : OneLine.MinHeightWithIcon;
                Modifier heightIn-VpY3zN4$default = SizeKt.heightIn-VpY3zN4$default(valueOf, minHeightWithIcon, 0, topStart, 0);
                int i55 = 0;
                iNSTANCE = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i19 = 0;
                obj61 = minHeightWithIcon;
                String minHeight = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -1323940314, minHeight);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($i$a$LayoutRowKt$Row$1$iv, 0);
                currentCompositionLocalMap4 = $i$a$LayoutRowKt$Row$1$iv.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($i$a$LayoutRowKt$Row$1$iv, heightIn-VpY3zN4$default);
                modifier3 = heightIn-VpY3zN4$default;
                kotlin.jvm.functions.Function0 function03 = constructor2;
                i12 = 0;
                str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -692256719, str2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $i$a$LayoutRowKt$Row$1$iv.startReusableNode();
                if ($i$a$LayoutRowKt$Row$1$iv.getInserting()) {
                    $i$a$LayoutRowKt$Row$1$iv.createNode(function03);
                } else {
                    factory$iv$iv$iv2 = function03;
                    $i$a$LayoutRowKt$Row$1$iv.useNode();
                }
                function02 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl($i$a$LayoutRowKt$Row$1$iv);
                int i93 = 0;
                composer6 = $i$a$LayoutRowKt$Row$1$iv;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), $i$a$LayoutRowKt$Row$1$iv, i86 |= i89), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i94 = 0;
                Composer composer14 = constructor-impl;
                int i95 = 0;
                if (!composer14.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap4;
                    obj2 = valueOf;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer14;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap4;
                    obj2 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = composer6;
                i18 = i36;
                ComposerKt.sourceInformationMarkerStart(composer12, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScopeInstance iNSTANCE2 = RowScopeInstance.INSTANCE;
                i16 = 0;
                modifier2 = materializeModifier3;
                i13 = i62;
                $i$a$LayoutRowKt$Row$1$iv = composer10;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -1966472373, "C158@6124L262:ListItem.kt#jmzs0o");
                $this$ListItem_u24lambda_u243_u24lambda_u242 = "C73@3429L9:Box.kt#2w3rfo";
                topStart = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i26 = $composer$iv2;
                i10 = 48;
                if ($composer$iv != null) {
                    $i$a$LayoutRowKt$Row$1$iv.startReplaceGroup(-1966471444);
                    ComposerKt.sourceInformation($i$a$LayoutRowKt$Row$1$iv, "147@5637L460");
                    int i98 = 0;
                    other$iv = iNSTANCE2;
                    i15 = iNSTANCE;
                    Modifier padding-qDBjuR0$default3 = PaddingKt.padding-qDBjuR0$default(SizeKt.widthIn-VpY3zN4$default((RowScope)iNSTANCE2.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterVertically()), Dp.constructor-impl(iconLeftPadding + iconMinPaddedWidth), 0, 2, 0), OneLine.IconLeftPadding, OneLine.IconVerticalPadding, 0, OneLine.IconVerticalPadding, 4, 0);
                    Alignment centerStart = Alignment.Companion.getCenterStart();
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, 733328855, topStart);
                    int i82 = 0;
                    obj65 = i73;
                    maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, i82);
                    currentCompositeKeyHash2 = 0;
                    alignment = centerStart;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -1323940314, minHeight);
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($i$a$LayoutRowKt$Row$1$iv, 0);
                    currentCompositionLocalMap2 = $i$a$LayoutRowKt$Row$1$iv.getCurrentCompositionLocalMap();
                    i27 = i76;
                    modifier4 = padding-qDBjuR0$default3;
                    kotlin.jvm.functions.Function0 function06 = constructor4;
                    localMap$iv$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -692256719, str2);
                    if (!applier4 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $i$a$LayoutRowKt$Row$1$iv.startReusableNode();
                    if ($i$a$LayoutRowKt$Row$1$iv.getInserting()) {
                        $i$a$LayoutRowKt$Row$1$iv.createNode(function06);
                    } else {
                        factory$iv$iv$iv = function06;
                        $i$a$LayoutRowKt$Row$1$iv.useNode();
                    }
                    function0 = factory$iv$iv$iv;
                    Composer constructor-impl3 = Updater.constructor-impl($i$a$LayoutRowKt$Row$1$iv);
                    int i114 = 0;
                    i21 = i82;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i119 = 0;
                    Composer composer17 = constructor-impl3;
                    int i123 = 0;
                    if (!composer17.getInserting()) {
                        localMap$iv$iv3 = currentCompositionLocalMap2;
                        measurePolicy = maybeCachedBoxMeasurePolicy3;
                        if (!Intrinsics.areEqual(composer17.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composer17.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer17;
                        }
                    } else {
                        localMap$iv$iv3 = currentCompositionLocalMap2;
                        measurePolicy = maybeCachedBoxMeasurePolicy3;
                    }
                    Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($i$a$LayoutRowKt$Row$1$iv, padding-qDBjuR0$default3), ComposeUiNode.Companion.getSetModifier());
                    Composer composer13 = $i$a$LayoutRowKt$Row$1$iv;
                    ComposerKt.sourceInformationMarkerStart(composer13, -2146769399, $this$ListItem_u24lambda_u243_u24lambda_u242);
                    iNSTANCE = BoxScopeInstance.INSTANCE;
                    i116 |= 6;
                    measurePolicy$iv = 0;
                    i8 = i51;
                    i9 = i74;
                    $i$a$LayoutBoxKt$Box$1$iv = composer3;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 553846324, "C156@6089L6:ListItem.kt#jmzs0o");
                    $composer$iv.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i52 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer13);
                    $i$a$LayoutRowKt$Row$1$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                    $i$a$LayoutRowKt$Row$1$iv.endReplaceGroup();
                } else {
                    other$iv = iNSTANCE2;
                    i4 = materializeModifier;
                    i15 = iNSTANCE;
                    $i$a$LayoutRowKt$Row$1$iv.startReplaceGroup(-1965998632);
                    $i$a$LayoutRowKt$Row$1$iv.endReplaceGroup();
                }
                valueOf = other$iv;
                Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(valueOf.align(RowScope.weight$default(other$iv, (Modifier)Modifier.Companion, 1065353216, false, 2, 0), Alignment.Companion.getCenterVertically()), OneLine.ContentLeftPadding, 0, OneLine.ContentRightPadding, 0, 10, 0);
                Alignment centerStart2 = Alignment.Companion.getCenterStart();
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, 733328855, topStart);
                int i78 = 0;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart2, i78);
                i = 0;
                obj65 = centerStart2;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -1323940314, minHeight);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($i$a$LayoutRowKt$Row$1$iv, 0);
                currentCompositionLocalMap = $i$a$LayoutRowKt$Row$1$iv.getCurrentCompositionLocalMap();
                alignment = i75;
                i27 = padding-qDBjuR0$default;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                currentCompositeKeyHash3 = 0;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -692256719, str2);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $i$a$LayoutRowKt$Row$1$iv.startReusableNode();
                if ($i$a$LayoutRowKt$Row$1$iv.getInserting()) {
                    $i$a$LayoutRowKt$Row$1$iv.createNode(function05);
                } else {
                    factory$iv$iv$iv4 = function05;
                    $i$a$LayoutRowKt$Row$1$iv.useNode();
                }
                localMap$iv$iv = factory$iv$iv$iv4;
                Composer constructor-impl2 = Updater.constructor-impl($i$a$LayoutRowKt$Row$1$iv);
                int i108 = 0;
                i22 = i78;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i111 = 0;
                Composer composer16 = constructor-impl2;
                int i121 = 0;
                if (!composer16.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i8 = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer16;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    i8 = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier($i$a$LayoutRowKt$Row$1$iv, padding-qDBjuR0$default), ComposeUiNode.Companion.getSetModifier());
                Composer composer11 = $i$a$LayoutRowKt$Row$1$iv;
                ComposerKt.sourceInformationMarkerStart(composer11, -2146769399, $this$ListItem_u24lambda_u243_u24lambda_u242);
                maybeCachedBoxMeasurePolicy2 = BoxScopeInstance.INSTANCE;
                i110 |= 6;
                composer3 = 0;
                i21 = i40;
                measurePolicy = i72;
                $i$a$LayoutBoxKt$Box$1$iv = trailingRightPadding;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 554133012, "C163@6378L6:ListItem.kt#jmzs0o");
                valueOf3.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i41 &= 14));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer11);
                $i$a$LayoutRowKt$Row$1$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                if (obj3 != null) {
                    $i$a$LayoutRowKt$Row$1$iv.startReplaceGroup(-1965684354);
                    ComposerKt.sourceInformation($i$a$LayoutRowKt$Row$1$iv, "165@6439L186");
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default(valueOf.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterVertically()), 0, 0, OneLine.TrailingRightPadding, 0, 11, 0);
                    int i56 = i91;
                    $i$a$LayoutBoxKt$Box$1$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, 733328855, topStart);
                    i = 0;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -1323940314, minHeight);
                    currentCompositionLocalMap3 = $i$a$LayoutRowKt$Row$1$iv.getCurrentCompositionLocalMap();
                    i3 = currentCompositeKeyHash4;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($i$a$LayoutRowKt$Row$1$iv, padding-qDBjuR0$default2);
                    currentCompositeKeyHash2 = padding-qDBjuR0$default2;
                    kotlin.jvm.functions.Function0 function04 = constructor;
                    i23 = 0;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -692256719, str2);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $i$a$LayoutRowKt$Row$1$iv.startReusableNode();
                    if ($i$a$LayoutRowKt$Row$1$iv.getInserting()) {
                        $i$a$LayoutRowKt$Row$1$iv.createNode(function04);
                    } else {
                        factory$iv$iv$iv3 = function04;
                        $i$a$LayoutRowKt$Row$1$iv.useNode();
                    }
                    Composer constructor-impl4 = Updater.constructor-impl($i$a$LayoutRowKt$Row$1$iv);
                    int i92 = 0;
                    i27 = factory$iv$iv$iv3;
                    Updater.set-impl(constructor-impl4, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i103 = 0;
                    Composer composer15 = constructor-impl4;
                    int i106 = 0;
                    if (!composer15.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(i3))) {
                            composer15.updateRememberedValue(Integer.valueOf(i3));
                            constructor-impl4.apply(Integer.valueOf(i3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer8 = composer15;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl4, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    $composer$iv = $i$a$LayoutRowKt$Row$1$iv;
                    valueOf3 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -2146769399, $this$ListItem_u24lambda_u243_u24lambda_u242);
                    i59 |= 6;
                    composer10 = 0;
                    alignment = materializeModifier2;
                    i10 = i47;
                    boxScopeInstance = iNSTANCE3;
                    $this$ListItem_u24lambda_u243_u24lambda_u242 = composer9;
                    ComposerKt.sourceInformationMarkerStart($this$ListItem_u24lambda_u243_u24lambda_u242, 554366256, "C169@6613L10:ListItem.kt#jmzs0o");
                    obj3.invoke($this$ListItem_u24lambda_u243_u24lambda_u242, Integer.valueOf(i29 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($this$ListItem_u24lambda_u243_u24lambda_u242);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $i$a$LayoutRowKt$Row$1$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                    $i$a$LayoutRowKt$Row$1$iv.endReplaceGroup();
                } else {
                    $i$a$LayoutRowKt$Row$1$iv.startReplaceGroup(-1965474856);
                    $i$a$LayoutRowKt$Row$1$iv.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj2;
            } else {
                $i$a$LayoutRowKt$Row$1$iv.skipToGroupEnd();
                composer6 = $i$a$LayoutRowKt$Row$1$iv;
                obj = valueOf;
                i4 = materializeModifier;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer6.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new OneLine.ListItem.2(this, obj, icon, text, obj3, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
