package androidx.compose.material;

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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aR\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00152 \u0008\u0002\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001aS\u0010\u001e\u001a\u00020\u00112\u001c\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001b2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0002\u0008\u001a¢\u0006\u0002\u0008\u001bH\u0007¢\u0006\u0002\u0010!\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006\"\u0016\u0010\u0008\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\"\u0016\u0010\n\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\"\u0016\u0010\u000c\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006\"\u0016\u0010\u000e\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\"", d2 = {"BadgeContentFontSize", "Landroidx/compose/ui/unit/TextUnit;", "J", "BadgeHorizontalOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeHorizontalOffset", "()F", "F", "BadgeRadius", "getBadgeRadius", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentRadius", "getBadgeWithContentRadius", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BadgeKt {

    private static final long BadgeContentFontSize;
    private static final float BadgeHorizontalOffset;
    private static final float BadgeRadius;
    private static final float BadgeWithContentHorizontalOffset;
    private static final float BadgeWithContentHorizontalPadding;
    private static final float BadgeWithContentRadius;
    static {
        int i7 = 0;
        BadgeKt.BadgeRadius = Dp.constructor-impl((float)i);
        int i8 = 0;
        BadgeKt.BadgeWithContentRadius = Dp.constructor-impl((float)i2);
        BadgeKt.BadgeContentFontSize = TextUnitKt.getSp(10);
        int i9 = 0;
        BadgeKt.BadgeWithContentHorizontalPadding = Dp.constructor-impl((float)i4);
        int i10 = 0;
        int i11 = 0;
        BadgeKt.BadgeWithContentHorizontalOffset = Dp.constructor-impl(-$this$dp$iv4);
        int i12 = 0;
        int i13 = 0;
        BadgeKt.BadgeHorizontalOffset = Dp.constructor-impl(-$this$dp$iv5);
    }

    public static final void Badge-eopBjH0(Modifier modifier, long backgroundColor, long contentColor, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i7) {
        float badgeWithContentRadius;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        int provides;
        boolean traceInProgress;
        int $dirty2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object $composer$iv;
        Object $dirty;
        Object modifier2;
        long l2;
        Modifier materializeModifier;
        Object obj;
        long backgroundColor2;
        Composer composer;
        RowScopeInstance $this$Badge_eopBjH0_u24lambda_u241;
        long l4;
        int i11;
        long $changed2;
        int i8;
        boolean traceInProgress2;
        Object obj2;
        int changed2;
        int i9;
        int str;
        boolean changed;
        long contentColorFor-ek8zF_U;
        int contentColor2;
        Object i10;
        int i2;
        int currentCompositionLocalMap;
        int defaultsInvalid;
        int i;
        int i3;
        int i13;
        Object obj3;
        int i6;
        int i12;
        Composer composer2;
        int i5;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        long l3;
        RowScopeInstance rowScopeInstance;
        int i4;
        long l;
        float obj29;
        int obj30;
        int obj31;
        int obj32;
        kotlin.jvm.functions.Function0 obj33;
        int obj34;
        Modifier obj35;
        final int i39 = obj36;
        traceInProgress = 1133484502;
        final Composer restartGroup = i7.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Badge)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)132@5219L6,133@5259L32,140@5508L857:Badge.kt#jmzs0o");
        $dirty2 = obj36;
        int i27 = obj37 & 1;
        materializeModifier = 2;
        if (i27 != 0) {
            $dirty2 |= 6;
            obj = modifier;
        } else {
            if (i39 & 6 == 0) {
                i11 = restartGroup.changed(modifier) ? 4 : materializeModifier;
                $dirty2 |= i11;
            } else {
                obj = modifier;
            }
        }
        if (i39 & 48 == 0) {
            if (obj37 & 2 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 32 : 16;
            } else {
                $changed2 = backgroundColor;
            }
            $dirty2 |= changed2;
        } else {
            $changed2 = backgroundColor;
        }
        if (i39 & 384 == 0) {
            if (obj37 & 4 == 0) {
                i9 = restartGroup.changed(content) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = content;
            }
            $dirty2 |= i9;
        } else {
            contentColorFor-ek8zF_U = content;
        }
        str = obj37 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            i10 = $changed;
        } else {
            if (i39 & 3072 == 0) {
                i2 = restartGroup.changedInstance($changed) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                i10 = $changed;
            }
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i44 = 6;
                if (i39 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i27 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (obj37 & 2 != 0) {
                            backgroundColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, i44).getError-0d7_KjU();
                            $dirty2 &= -113;
                        } else {
                            backgroundColor2 = $changed2;
                        }
                        if (obj37 & 4 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(backgroundColor2, $changed2, restartGroup);
                            $dirty2 &= -897;
                        }
                        if (str != null) {
                            i10 = i8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj37 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (obj37 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        modifier2 = obj;
                        backgroundColor2 = $changed2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.Badge (Badge.kt:135)");
                }
                badgeWithContentRadius = i10 != null ? BadgeKt.BadgeWithContentRadius : BadgeKt.BadgeRadius;
                androidx.compose.foundation.shape.RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(badgeWithContentRadius);
                int i42 = 0;
                int i48 = 0;
                obj35 = i44;
                i = 432;
                i3 = 0;
                obj29 = badgeWithContentRadius;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                rowMeasurePolicy = RowKt.rowMeasurePolicy((Arrangement.Horizontal)Arrangement.INSTANCE.getCenter(), Alignment.Companion.getCenterVertically(), restartGroup, i15 |= i21);
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, PaddingKt.padding-VpY3zN4$default(ClipKt.clip(BackgroundKt.background-bw27NRU(SizeKt.defaultMinSize-VpY3zN4(modifier2, Dp.constructor-impl(f2 *= badgeWithContentRadius), Dp.constructor-impl(f *= badgeWithContentRadius)), backgroundColor2, $changed2), (Shape)roundedCornerShape), BadgeKt.BadgeWithContentHorizontalPadding, 0, materializeModifier, 0));
                obj32 = currentCompositeKeyHash;
                obj33 = constructor;
                i13 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj33);
                } else {
                    factory$iv$iv$iv = obj33;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i50 = 0;
                obj33 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i51 = 0;
                Composer composer4 = constructor-impl;
                int i52 = 0;
                if (!composer4.getInserting()) {
                    measurePolicy$iv = rowMeasurePolicy;
                    l3 = backgroundColor2;
                    if (!Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(obj32))) {
                        composer4.updateRememberedValue(Integer.valueOf(obj32));
                        constructor-impl.apply(Integer.valueOf(obj32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer4;
                    }
                } else {
                    measurePolicy$iv = rowMeasurePolicy;
                    l3 = backgroundColor2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                $this$Badge_eopBjH0_u24lambda_u241 = RowScopeInstance.INSTANCE;
                i36 |= 6;
                i6 = 0;
                i12 = i18;
                i5 = i30;
                Composer $i$a$LayoutRowKt$Row$1$iv = obj35;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, 1448059046, "C:Badge.kt#jmzs0o");
                if (i10 != null) {
                    $i$a$LayoutRowKt$Row$1$iv.startReplaceGroup(1448079226);
                    ComposerKt.sourceInformation($i$a$LayoutRowKt$Row$1$iv, "157@6105L244,155@6009L340");
                    BadgeKt.Badge.1.1 anon = new BadgeKt.Badge.1.1(i10, (RowScope)$this$Badge_eopBjH0_u24lambda_u241);
                    obj35 = materializeModifier;
                    rowScopeInstance = $this$Badge_eopBjH0_u24lambda_u241;
                    i4 = $changed2;
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(contentColorFor-ek8zF_U)), (Function2)ComposableLambdaKt.rememberComposableLambda(1784526485, true, anon, $i$a$LayoutRowKt$Row$1$iv, 54), $i$a$LayoutRowKt$Row$1$iv, $stable |= 48);
                    $i$a$LayoutRowKt$Row$1$iv.endReplaceGroup();
                } else {
                    obj35 = materializeModifier;
                    rowScopeInstance = $this$Badge_eopBjH0_u24lambda_u241;
                    i4 = $changed2;
                    $i$a$LayoutRowKt$Row$1$iv.startReplaceGroup(1448429030);
                    $i$a$LayoutRowKt$Row$1$iv.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutRowKt$Row$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l4 = contentColorFor-ek8zF_U;
                $dirty = obj3;
                l2 = l3;
                contentColor2 = obj30;
                obj2 = i10;
            } else {
                restartGroup.skipToGroupEnd();
                l2 = $changed2;
                contentColor2 = $dirty2;
                $dirty = obj;
                l4 = l;
                obj2 = i10;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new BadgeKt.Badge.2($dirty, l2, materializeModifier, l4, $changed2, obj2, i39, obj37);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void BadgedBox(Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> badge, Modifier modifier, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        boolean iNSTANCE;
        boolean currentCompositionLocalMap2;
        int $dirty;
        Object obj;
        int $dirty2;
        Object modifier2;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object obj2;
        boolean maybeCachedBoxMeasurePolicy2;
        int i18;
        Composer composer3;
        Object valueOf;
        int i5;
        int materializeModifier2;
        boolean traceInProgress;
        Composer composer4;
        Integer valueOf2;
        Object restartGroup;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy;
        Object str;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv2;
        int i21;
        int i11;
        int i24;
        int i13;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        int i20;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        kotlin.jvm.functions.Function0 constructor;
        int i16;
        Object obj3;
        int i19;
        int i3;
        int i9;
        int modifier$iv;
        int i22;
        androidx.compose.material.BadgeKt.BadgedBox.2 measurePolicy$iv;
        int i2;
        int i23;
        Alignment alignment;
        Composer composer6;
        int i4;
        int i10;
        int i7;
        kotlin.jvm.functions.Function0 function0;
        int i12;
        Composer composer5;
        int i15;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv2;
        Composer composer2;
        int i14;
        int i;
        Alignment alignment2;
        int i8;
        int i17;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int obj45;
        Modifier obj47;
        final Object obj4 = badge;
        obj2 = content;
        i18 = $changed;
        traceInProgress2 = 859805272;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(BadgedBox)P(!1,2)64@2555L1979:Badge.kt#jmzs0o");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i18 & 6 == 0) {
                i5 = restartGroup.changedInstance(obj4) ? 4 : 2;
                $dirty |= i5;
            }
        }
        materializeModifier2 = i6 & 2;
        if (materializeModifier2 != 0) {
            $dirty |= 48;
            str = modifier;
        } else {
            if (i18 & 48 == 0) {
                i21 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i21;
            } else {
                str = modifier;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i18 & 384 == 0) {
                i11 = restartGroup.changedInstance(obj2) ? 256 : 128;
                $dirty |= i11;
            }
        }
        i24 = $dirty;
        if (i24 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (materializeModifier2 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i24, -1, "androidx.compose.material.BadgedBox (Badge.kt:63)");
                }
                iNSTANCE = BadgeKt.BadgedBox.2.INSTANCE;
                i36 |= 384;
                String str5 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str5);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i16 = 0;
                String modifier4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, modifier4);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                int i60 = 0;
                Updater.set-impl(constructor-impl3, (MeasurePolicy)iNSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i61 = 0;
                Composer composer8 = constructor-impl3;
                int i64 = 0;
                if (!composer8.getInserting()) {
                    measurePolicy$iv = iNSTANCE;
                    i2 = valueOf2;
                    if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer8;
                    }
                } else {
                    measurePolicy$iv = iNSTANCE;
                    i2 = valueOf2;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                valueOf = restartGroup;
                i3 = i26;
                ComposerKt.sourceInformationMarkerStart(valueOf, 643423305, "C66@2585L161,71@2759L105:Badge.kt#jmzs0o");
                Alignment center = Alignment.Companion.getCenter();
                int i62 = 0;
                int i65 = i29;
                i23 = i37;
                String $i$a$LayoutBadgeKt$BadgedBox$1 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, $i$a$LayoutBadgeKt$BadgedBox$1);
                int i30 = 0;
                composer6 = restartGroup;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, i30);
                int i68 = 0;
                int i69 = i30;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, str5);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf, 0);
                currentCompositionLocalMap2 = valueOf.getCurrentCompositionLocalMap();
                i12 = i46;
                Modifier $i$f$Layout = modifier6;
                Modifier modifier7 = $i$f$Layout;
                kotlin.jvm.functions.Function0 function03 = constructor3;
                int i70 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, modifier4);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf.startReusableNode();
                if (valueOf.getInserting()) {
                    valueOf.createNode(function03);
                } else {
                    factory$iv$iv$iv2 = function03;
                    valueOf.useNode();
                }
                kotlin.jvm.functions.Function0 function04 = factory$iv$iv$iv2;
                Composer constructor-impl2 = Updater.constructor-impl(valueOf);
                int i72 = 0;
                alignment2 = center;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i = 0;
                Composer composer9 = constructor-impl2;
                int i75 = 0;
                if (!composer9.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer9;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(valueOf, $i$f$Layout), ComposeUiNode.Companion.getSetModifier());
                Composer composer7 = valueOf;
                i14 = i33;
                String $changed$iv2 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer7, -2146769399, $changed$iv2);
                i17 = i49;
                obj2.invoke(BoxScopeInstance.INSTANCE, composer7, Integer.valueOf(i74 |= 6));
                ComposerKt.sourceInformationMarkerEnd(composer7);
                valueOf.endNode();
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "badge");
                i51 |= 6;
                i24 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, $i$a$LayoutBadgeKt$BadgedBox$1);
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                i22 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, str5);
                obj45 = currentCompositeKeyHash2;
                obj47 = layoutId2;
                kotlin.jvm.functions.Function0 function02 = constructor2;
                i4 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, modifier4);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf.startReusableNode();
                if (valueOf.getInserting()) {
                    valueOf.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    valueOf.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(valueOf);
                i19 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, valueOf.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i10 = 0;
                composer5 = constructor-impl;
                i15 = 0;
                if (!composer5.getInserting()) {
                    measurePolicy$iv2 = maybeCachedBoxMeasurePolicy2;
                    composer2 = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(obj45))) {
                        composer5.updateRememberedValue(Integer.valueOf(obj45));
                        constructor-impl.apply(Integer.valueOf(obj45), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer5;
                    }
                } else {
                    measurePolicy$iv2 = maybeCachedBoxMeasurePolicy2;
                    composer2 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf, layoutId2), ComposeUiNode.Companion.getSetModifier());
                i34 &= 14;
                obj2 = composer2;
                i18 = 0;
                ComposerKt.sourceInformationMarkerStart(obj2, -2146769399, $changed$iv2);
                obj4.invoke(BoxScopeInstance.INSTANCE, obj2, Integer.valueOf(i43 |= 6));
                ComposerKt.sourceInformationMarkerEnd(obj2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                composer6 = restartGroup;
                obj = str;
                modifier$iv = i24;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer6.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new BadgeKt.BadgedBox.3(obj4, obj, content, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final long access$getBadgeContentFontSize$p() {
        return BadgeKt.BadgeContentFontSize;
    }

    public static final float getBadgeHorizontalOffset() {
        return BadgeKt.BadgeHorizontalOffset;
    }

    public static final float getBadgeRadius() {
        return BadgeKt.BadgeRadius;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeKt.BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeKt.BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentRadius() {
        return BadgeKt.BadgeWithContentRadius;
    }
}
