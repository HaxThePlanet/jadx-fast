package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u001aR\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102 \u0008\u0002\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\u000c2\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000c0\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u000c0\u0013¢\u0006\u0002\u0008\u0015¢\u0006\u0002\u0008\u0016H\u0007¢\u0006\u0002\u0010\u001c\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0008\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\n\u0010\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010!\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u001fX\u008a\u008e\u0002", d2 = {"BadgeOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeOffset", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release", "layoutAbsoluteLeft", "", "layoutAbsoluteTop", "greatGrandParentAbsoluteRight", "greatGrandParentAbsoluteTop"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BadgeKt {

    private static final float BadgeOffset;
    private static final float BadgeWithContentHorizontalOffset;
    private static final float BadgeWithContentHorizontalPadding;
    private static final float BadgeWithContentVerticalOffset;
    static {
        int i5 = 0;
        BadgeKt.BadgeWithContentHorizontalPadding = Dp.constructor-impl((float)i);
        int i6 = 0;
        BadgeKt.BadgeWithContentHorizontalOffset = Dp.constructor-impl((float)i2);
        int i7 = 0;
        BadgeKt.BadgeWithContentVerticalOffset = Dp.constructor-impl((float)i3);
        int i8 = 0;
        BadgeKt.BadgeOffset = Dp.constructor-impl((float)i4);
    }

    public static final void Badge-eopBjH0(Modifier modifier, long containerColor, long contentColor, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        float largeSize-D9Ej5fM;
        Modifier size2;
        Object str2;
        boolean traceInProgress;
        int $dirty2;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        String $changed$iv;
        Object $dirty;
        Object modifier2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        long l4;
        int $i$a$LayoutRowKt$Row$1$iv;
        Object obj3;
        long containerColor2;
        Composer composer2;
        RowScopeInstance $this$Badge_eopBjH0_u24lambda_u2415;
        long l2;
        int i8;
        long l;
        int i11;
        boolean traceInProgress2;
        androidx.compose.ui.graphics.Shape value;
        Object obj2;
        int changed2;
        int i9;
        int str;
        boolean changed;
        long contentColorFor-ek8zF_U;
        Object i5;
        int i12;
        int skipping;
        int defaultsInvalid;
        int i14;
        int i13;
        float currentCompositionLocalMap;
        float size;
        int i2;
        Object obj;
        int i3;
        int i4;
        int i6;
        int i10;
        int i;
        Modifier modifier3;
        kotlin.jvm.functions.Function0 function0;
        int i15;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        long l3;
        Composer composer;
        RowScopeInstance rowScopeInstance;
        Composer obj32;
        androidx.compose.ui.text.TextStyle obj34;
        androidx.compose.runtime.internal.ComposableLambda obj35;
        Composer obj36;
        int obj37;
        int obj38;
        final int i44 = obj39;
        traceInProgress = 1298144073;
        final Composer restartGroup = i7.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Badge)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)180@8028L14,181@8070L31,193@8428L874:Badge.kt#uh7d8r");
        $dirty2 = obj39;
        int i26 = obj40 & 1;
        $i$a$LayoutRowKt$Row$1$iv = 2;
        if (i26 != 0) {
            $dirty2 |= 6;
            obj3 = modifier;
        } else {
            if (i44 & 6 == 0) {
                i8 = restartGroup.changed(modifier) ? 4 : $i$a$LayoutRowKt$Row$1$iv;
                $dirty2 |= i8;
            } else {
                obj3 = modifier;
            }
        }
        if (i44 & 48 == 0) {
            if (obj40 & 2 == 0) {
                changed2 = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                l = containerColor;
            }
            $dirty2 |= changed2;
        } else {
            l = containerColor;
        }
        if (i44 & 384 == 0) {
            if (obj40 & 4 == 0) {
                i9 = restartGroup.changed(content) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = content;
            }
            $dirty2 |= i9;
        } else {
            contentColorFor-ek8zF_U = content;
        }
        str = obj40 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            i5 = $changed;
        } else {
            if (i44 & 3072 == 0) {
                i12 = restartGroup.changedInstance($changed) ? 2048 : 1024;
                $dirty2 |= i12;
            } else {
                i5 = $changed;
            }
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i14 = 6;
                if (i44 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i26 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj3;
                        }
                        if (obj40 & 2 != 0) {
                            containerColor2 = BadgeDefaults.INSTANCE.getContainerColor(restartGroup, i14);
                            $dirty2 &= -113;
                        } else {
                            containerColor2 = l;
                        }
                        if (obj40 & 4 != 0) {
                            contentColorFor-ek8zF_U = ColorSchemeKt.contentColorFor-ek8zF_U(containerColor2, l, restartGroup);
                            $dirty2 &= -897;
                        }
                        if (str != null) {
                            i5 = i11;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj40 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (obj40 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        modifier2 = obj3;
                        containerColor2 = l;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material3.Badge (Badge.kt:183)");
                }
                BadgeTokens iNSTANCE = BadgeTokens.INSTANCE;
                if (i5 != null) {
                    largeSize-D9Ej5fM = iNSTANCE.getLargeSize-D9Ej5fM();
                } else {
                    largeSize-D9Ej5fM = iNSTANCE.getSize-D9Ej5fM();
                }
                if (i5 != null) {
                    restartGroup.startReplaceGroup(-1271801170);
                    ComposerKt.sourceInformation(restartGroup, "187@8325L5");
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getLargeShape(), restartGroup, i14);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-1271743789);
                    ComposerKt.sourceInformation(restartGroup, "189@8378L5");
                    value = ShapesKt.getValue(BadgeTokens.INSTANCE.getShape(), restartGroup, i14);
                    restartGroup.endReplaceGroup();
                }
                if (i5 != null) {
                    obj38 = i14;
                    size = largeSize-D9Ej5fM;
                    size2 = PaddingKt.padding-VpY3zN4$default((Modifier)Modifier.Companion, BadgeKt.BadgeWithContentHorizontalPadding, 0, $i$a$LayoutRowKt$Row$1$iv, 0);
                } else {
                    size = largeSize-D9Ej5fM;
                    obj38 = i14;
                    size2 = Modifier.Companion;
                }
                skipping = 432;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                rowMeasurePolicy = RowKt.rowMeasurePolicy((Arrangement.Horizontal)Arrangement.INSTANCE.getCenter(), Alignment.Companion.getCenterVertically(), restartGroup, i19 |= i48);
                i32 &= 112;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, BackgroundKt.background-bw27NRU(SizeKt.defaultMinSize-VpY3zN4(modifier2, largeSize-D9Ej5fM, largeSize-D9Ej5fM), containerColor2, l).then(size2));
                i4 = currentCompositeKeyHash;
                kotlin.jvm.functions.Function0 function02 = constructor;
                i3 = 0;
                i = i33;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i50 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i51 = 0;
                obj32 = constructor-impl;
                int i52 = 0;
                if (!obj32.getInserting()) {
                    measurePolicy$iv = rowMeasurePolicy;
                    l3 = containerColor2;
                    if (!Intrinsics.areEqual(obj32.rememberedValue(), Integer.valueOf(i4))) {
                        obj32.updateRememberedValue(Integer.valueOf(i4));
                        constructor-impl.apply(Integer.valueOf(i4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = obj32;
                    }
                } else {
                    measurePolicy$iv = rowMeasurePolicy;
                    l3 = containerColor2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                $i$a$LayoutRowKt$Row$1$iv = 0;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                $this$Badge_eopBjH0_u24lambda_u2415 = RowScopeInstance.INSTANCE;
                i39 |= 6;
                obj36 = composer3;
                i6 = 0;
                modifier3 = materializeModifier;
                i15 = i22;
                ComposerKt.sourceInformationMarkerStart(composer3, -1324532516, "C:Badge.kt#uh7d8r");
                composer3.startReplaceGroup(-1705294841);
                ComposerKt.sourceInformation(composer3, "208@9105L5,212@9259L13,209@9123L163");
                if (i5 != null) {
                    BadgeKt.Badge.1.1 anon = new BadgeKt.Badge.1.1(i5, (RowScope)$this$Badge_eopBjH0_u24lambda_u2415);
                    obj34 = value2;
                    obj38 = $i$a$LayoutRowKt$Row$1$iv;
                    rowScopeInstance = $this$Badge_eopBjH0_u24lambda_u2415;
                    ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(contentColorFor-ek8zF_U, containerColor, obj34, (Function2)ComposableLambdaKt.rememberComposableLambda(719214594, true, anon, composer3, 54), composer3);
                    str2 = obj34;
                } else {
                    obj38 = $i$a$LayoutRowKt$Row$1$iv;
                    rowScopeInstance = $this$Badge_eopBjH0_u24lambda_u2415;
                }
                composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj;
                l4 = l3;
                l2 = contentColorFor-ek8zF_U;
                obj2 = i5;
            } else {
                restartGroup.skipToGroupEnd();
                i2 = $dirty2;
                $dirty = obj3;
                l4 = l;
                l2 = contentColorFor-ek8zF_U;
                obj2 = i5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new BadgeKt.Badge.2($dirty, l4, $i$a$LayoutRowKt$Row$1$iv, l2, l, obj2, i44, obj40);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void BadgedBox(Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> badge, Modifier modifier, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv;
        boolean currentCompositionLocalMap2;
        int $dirty;
        Object obj2;
        int $dirty2;
        Object modifier2;
        Object modifier4;
        Object obj3;
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy2;
        int i22;
        Object $i$a$CacheBadgeKt$BadgedBox$2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        Composer composer3;
        int i10;
        int materializeModifier;
        boolean traceInProgress2;
        Object restartGroup;
        Composer composer;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object str;
        Composer composer2;
        Object maybeCachedBoxMeasurePolicy;
        int i7;
        int i23;
        int i11;
        int i21;
        Object invalid$iv;
        int i17;
        Modifier materializeModifier2;
        Object $i$a$CacheBadgeKt$BadgedBox$layoutAbsoluteLeft$2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object mutableFloatStateOf;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        Object empty;
        Object $i$a$CacheBadgeKt$BadgedBox$greatGrandParentAbsoluteRight$2;
        int currentCompositeKeyHash;
        Object $i$a$CacheBadgeKt$BadgedBox$greatGrandParentAbsoluteTop$2;
        Object empty2;
        Object modifier3;
        int i9;
        Object obj4;
        kotlin.jvm.functions.Function0 function02;
        int i19;
        Modifier modifier5;
        int i3;
        int i24;
        int i8;
        int i2;
        int modifier$iv;
        int i4;
        Object measurePolicy$iv;
        Composer composer6;
        int i13;
        Alignment alignment;
        Object obj;
        int i14;
        int i;
        int i12;
        Composer composer5;
        Composer composer4;
        int i15;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv2;
        kotlin.jvm.functions.Function0 function0;
        int i25;
        int i18;
        int i16;
        Object obj5;
        int i20;
        int i5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int obj50;
        Modifier obj52;
        final Object obj6 = badge;
        obj3 = content;
        i22 = $changed;
        traceInProgress = 1404022535;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(BadgedBox)P(!1,2)73@2898L36,74@2964L36,77@3183L57,78@3280L57,90@3679L680,102@4366L2713,80@3343L3736:Badge.kt#uh7d8r");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i22 & 6 == 0) {
                i10 = restartGroup.changedInstance(obj6) ? 4 : 2;
                $dirty |= i10;
            }
        }
        materializeModifier = i6 & 2;
        if (materializeModifier != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i22 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i7;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i22 & 384 == 0) {
                i23 = restartGroup.changedInstance(obj3) ? 256 : 128;
                $dirty |= i23;
            }
        }
        i11 = $dirty;
        if (i11 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (materializeModifier != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i11, -1, "androidx.compose.material3.BadgedBox (Badge.kt:72)");
                }
                String str3 = "CC(remember):Badge.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 437752587, str3);
                int i27 = 0;
                Composer composer9 = restartGroup;
                int i61 = 0;
                Object rememberedValue4 = composer9.rememberedValue();
                int i69 = 0;
                int i79 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    int i78 = 0;
                    composer9.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(i79));
                } else {
                    $i$a$CacheBadgeKt$BadgedBox$layoutAbsoluteLeft$2 = rememberedValue4;
                }
                Object invalid$iv2 = $i$a$CacheBadgeKt$BadgedBox$layoutAbsoluteLeft$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 437754699, str3);
                int i57 = 0;
                Composer composer10 = restartGroup;
                int i66 = 0;
                Object rememberedValue5 = composer10.rememberedValue();
                int i74 = 0;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    composer10.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(i79));
                } else {
                    mutableFloatStateOf = rememberedValue5;
                }
                Object invalid$iv3 = mutableFloatStateOf;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 437761728, str3);
                int i63 = 0;
                Composer composer11 = restartGroup;
                int i70 = 0;
                Object rememberedValue6 = composer11.rememberedValue();
                int i80 = 0;
                if (rememberedValue6 == Composer.Companion.getEmpty()) {
                    int i85 = 0;
                    composer11.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(2139095040));
                } else {
                    $i$a$CacheBadgeKt$BadgedBox$greatGrandParentAbsoluteRight$2 = rememberedValue6;
                }
                Object invalid$iv4 = $i$a$CacheBadgeKt$BadgedBox$greatGrandParentAbsoluteRight$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 437764832, str3);
                int i68 = 0;
                Composer composer12 = restartGroup;
                int i75 = 0;
                Object rememberedValue7 = composer12.rememberedValue();
                int i82 = 0;
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    int i87 = 0;
                    composer12.updateRememberedValue(PrimitiveSnapshotStateKt.mutableFloatStateOf(-8388608));
                } else {
                    $i$a$CacheBadgeKt$BadgedBox$greatGrandParentAbsoluteTop$2 = rememberedValue7;
                }
                invalid$iv = $i$a$CacheBadgeKt$BadgedBox$greatGrandParentAbsoluteTop$2;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 437778223, str3);
                int i72 = 0;
                Composer composer14 = restartGroup;
                int i81 = 0;
                Object rememberedValue9 = composer14.rememberedValue();
                int i86 = 0;
                if (rememberedValue9 == Composer.Companion.getEmpty()) {
                    obj50 = i41;
                    $i$a$CacheBadgeKt$BadgedBox$2 = new BadgeKt.BadgedBox.2.1((MutableFloatState)invalid$iv2, (MutableFloatState)invalid$iv3, (MutableFloatState)invalid$iv4, (MutableFloatState)invalid$iv);
                    composer14.updateRememberedValue((Function1)$i$a$CacheBadgeKt$BadgedBox$2);
                } else {
                    $i$a$CacheBadgeKt$BadgedBox$2 = rememberedValue9;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, (Function1)$i$a$CacheBadgeKt$BadgedBox$2);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 437802240, str3);
                int i42 = 0;
                Composer composer13 = restartGroup;
                int i76 = 0;
                Object rememberedValue8 = composer13.rememberedValue();
                int i83 = 0;
                if (rememberedValue8 == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    modifier3 = modifier2;
                    modifier4 = new BadgeKt.BadgedBox.3.1(invalid$iv3, invalid$iv2, invalid$iv4, invalid$iv);
                    composer13.updateRememberedValue((MeasurePolicy)modifier4);
                } else {
                    modifier3 = modifier2;
                    modifier4 = rememberedValue8;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i43 = 384;
                i17 = 0;
                String str6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str6);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                obj4 = invalid$iv2;
                kotlin.jvm.functions.Function0 function03 = constructor;
                i9 = 0;
                modifier5 = onGloballyPositioned;
                String modifier$iv2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, modifier$iv2);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory$iv$iv = function03;
                    restartGroup.useNode();
                }
                function02 = factory$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i88 = 0;
                i2 = i43;
                Updater.set-impl(constructor-impl, (MeasurePolicy)modifier4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i89 = 0;
                Composer composer15 = constructor-impl;
                int i92 = 0;
                if (!composer15.getInserting()) {
                    measurePolicy$iv = modifier4;
                    composer6 = restartGroup;
                    if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer15.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer15;
                    }
                } else {
                    measurePolicy$iv = modifier4;
                    composer6 = restartGroup;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, onGloballyPositioned), ComposeUiNode.Companion.getSetModifier());
                Composer composer7 = composer6;
                i24 = i31;
                ComposerKt.sourceInformationMarkerStart(composer7, -800356556, "C82@3373L161,87@3547L59:Badge.kt#uh7d8r");
                Alignment center = Alignment.Companion.getCenter();
                int i90 = 0;
                int i93 = i34;
                i13 = i44;
                String $i$a$LayoutBadgeKt$BadgedBox$1 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer7, 733328855, $i$a$LayoutBadgeKt$BadgedBox$1);
                int i35 = 0;
                obj = invalid$iv3;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, i35);
                int i96 = 0;
                int i97 = i35;
                ComposerKt.sourceInformationMarkerStart(composer7, -1323940314, str6);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                currentCompositionLocalMap2 = composer7.getCurrentCompositionLocalMap();
                Alignment alignment2 = center;
                Modifier contentAlignment$iv2 = modifier8;
                Modifier modifier9 = contentAlignment$iv2;
                kotlin.jvm.functions.Function0 function05 = constructor3;
                int i98 = 0;
                ComposerKt.sourceInformationMarkerStart(composer7, -692256719, modifier$iv2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer7.startReusableNode();
                if (composer7.getInserting()) {
                    composer7.createNode(function05);
                } else {
                    factory$iv$iv$iv = function05;
                    composer7.useNode();
                }
                kotlin.jvm.functions.Function0 function06 = factory$iv$iv$iv;
                Composer constructor-impl2 = Updater.constructor-impl(composer7);
                int i99 = 0;
                obj5 = invalid$iv4;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i16 = 0;
                Composer composer16 = constructor-impl2;
                int i102 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer16;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(composer7, contentAlignment$iv2), ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = composer7;
                i18 = i38;
                String $changed$iv2 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $changed$iv2);
                i5 = i58;
                obj3.invoke(BoxScopeInstance.INSTANCE, composer8, Integer.valueOf(i101 |= 6));
                ComposerKt.sourceInformationMarkerEnd(composer8);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "badge");
                i60 |= 6;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(composer7, 733328855, $i$a$LayoutBadgeKt$BadgedBox$1);
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                i4 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(composer7, -1323940314, str6);
                obj50 = currentCompositeKeyHash2;
                obj52 = layoutId2;
                kotlin.jvm.functions.Function0 function04 = constructor2;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(composer7, -692256719, modifier$iv2);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer7.startReusableNode();
                if (composer7.getInserting()) {
                    composer7.createNode(function04);
                } else {
                    factory$iv$iv$iv2 = function04;
                    composer7.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(composer7);
                i3 = 0;
                composer5 = composer7;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, composer7.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i = 0;
                composer4 = constructor-impl3;
                i15 = 0;
                if (!composer4.getInserting()) {
                    measurePolicy$iv2 = maybeCachedBoxMeasurePolicy2;
                    function0 = factory$iv$iv$iv2;
                    if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(obj50))) {
                        composer4.updateRememberedValue(Integer.valueOf(obj50));
                        constructor-impl3.apply(Integer.valueOf(obj50), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer4;
                    }
                } else {
                    measurePolicy$iv2 = maybeCachedBoxMeasurePolicy2;
                    function0 = factory$iv$iv$iv2;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier(composer7, layoutId2), ComposeUiNode.Companion.getSetModifier());
                i39 &= 14;
                obj3 = composer5;
                i22 = 0;
                ComposerKt.sourceInformationMarkerStart(obj3, -2146769399, $changed$iv2);
                obj6.invoke(BoxScopeInstance.INSTANCE, obj3, Integer.valueOf(i53 |= 6));
                ComposerKt.sourceInformationMarkerEnd(obj3);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = modifier3;
            } else {
                restartGroup.skipToGroupEnd();
                composer6 = restartGroup;
                obj2 = str;
                modifier$iv = i11;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer6.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new BadgeKt.BadgedBox.4(obj6, obj2, content, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final float BadgedBox$lambda$1(MutableFloatState $layoutAbsoluteLeft$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (FloatState)$layoutAbsoluteLeft$delegate.getFloatValue();
    }

    private static final float BadgedBox$lambda$10(MutableFloatState $greatGrandParentAbsoluteTop$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (FloatState)$greatGrandParentAbsoluteTop$delegate.getFloatValue();
    }

    private static final void BadgedBox$lambda$11(MutableFloatState $greatGrandParentAbsoluteTop$delegate, float value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $greatGrandParentAbsoluteTop$delegate.setFloatValue(value);
    }

    private static final void BadgedBox$lambda$2(MutableFloatState $layoutAbsoluteLeft$delegate, float value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $layoutAbsoluteLeft$delegate.setFloatValue(value);
    }

    private static final float BadgedBox$lambda$4(MutableFloatState $layoutAbsoluteTop$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (FloatState)$layoutAbsoluteTop$delegate.getFloatValue();
    }

    private static final void BadgedBox$lambda$5(MutableFloatState $layoutAbsoluteTop$delegate, float value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $layoutAbsoluteTop$delegate.setFloatValue(value);
    }

    private static final float BadgedBox$lambda$7(MutableFloatState $greatGrandParentAbsoluteRight$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (FloatState)$greatGrandParentAbsoluteRight$delegate.getFloatValue();
    }

    private static final void BadgedBox$lambda$8(MutableFloatState $greatGrandParentAbsoluteRight$delegate, float value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $greatGrandParentAbsoluteRight$delegate.setFloatValue(value);
    }

    public static final float access$BadgedBox$lambda$1(MutableFloatState $layoutAbsoluteLeft$delegate) {
        return BadgeKt.BadgedBox$lambda$1($layoutAbsoluteLeft$delegate);
    }

    public static final float access$BadgedBox$lambda$10(MutableFloatState $greatGrandParentAbsoluteTop$delegate) {
        return BadgeKt.BadgedBox$lambda$10($greatGrandParentAbsoluteTop$delegate);
    }

    public static final void access$BadgedBox$lambda$11(MutableFloatState $greatGrandParentAbsoluteTop$delegate, float value) {
        BadgeKt.BadgedBox$lambda$11($greatGrandParentAbsoluteTop$delegate, value);
    }

    public static final void access$BadgedBox$lambda$2(MutableFloatState $layoutAbsoluteLeft$delegate, float value) {
        BadgeKt.BadgedBox$lambda$2($layoutAbsoluteLeft$delegate, value);
    }

    public static final float access$BadgedBox$lambda$4(MutableFloatState $layoutAbsoluteTop$delegate) {
        return BadgeKt.BadgedBox$lambda$4($layoutAbsoluteTop$delegate);
    }

    public static final void access$BadgedBox$lambda$5(MutableFloatState $layoutAbsoluteTop$delegate, float value) {
        BadgeKt.BadgedBox$lambda$5($layoutAbsoluteTop$delegate, value);
    }

    public static final float access$BadgedBox$lambda$7(MutableFloatState $greatGrandParentAbsoluteRight$delegate) {
        return BadgeKt.BadgedBox$lambda$7($greatGrandParentAbsoluteRight$delegate);
    }

    public static final void access$BadgedBox$lambda$8(MutableFloatState $greatGrandParentAbsoluteRight$delegate, float value) {
        BadgeKt.BadgedBox$lambda$8($greatGrandParentAbsoluteRight$delegate, value);
    }

    public static final float getBadgeOffset() {
        return BadgeKt.BadgeOffset;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeKt.BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeKt.BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeKt.BadgeWithContentVerticalOffset;
    }
}
