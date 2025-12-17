package androidx.compose.ui.layout;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode.Companion;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a8\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0008\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0008¢\u0006\u0002\u0010\u000c\u001a \u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0008¢\u0006\u0002\u0010\r\u001a>\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0008\u00070\u000f2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\u0008¢\u0006\u0002\u0010\u0011\u001a7\u0010\u0012\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0008\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001a;\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0008\u00072\u001c\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0008\u00070\u000fH\u0001¢\u0006\u0002\u0010\u0015\u001a3\u0010\u0016\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0008\u001a2\u0006\u0010\u0008\u001a\u00020\tH\u0001¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a3\u0010\u001d\u001a\u001e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0008\u001a2\u0006\u0010\u0008\u001a\u00020\tH\u0001¢\u0006\u0004\u0008\u0016\u0010\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"LargeDimension", "", "Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "modifierMaterializerOf", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "materializerOfWithCompositionLocalInjection", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutKt {

    public static final int LargeDimension = 32767;
    public static final void Layout(Modifier modifier, androidx.compose.ui.layout.MeasurePolicy measurePolicy, Composer $composer, int $changed, int i5) {
        boolean valueOf;
        Integer valueOf2;
        androidx.compose.ui.Modifier.Companion modifier2;
        int $i$f$Layout;
        valueOf = $composer;
        valueOf2 = 0;
        ComposerKt.sourceInformationMarkerStart(valueOf, 544976794, "CC(Layout)P(1)124@4836L23,127@4987L385:Layout.kt#80mrfh");
        if (i5 & 1 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf, 0);
        final int i4 = 6;
        final int i6 = 0;
        ComposerKt.sourceInformationMarkerStart(valueOf, 1405779621, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        valueOf.startReusableNode();
        if (valueOf.getInserting()) {
            valueOf.createNode(ComposeUiNode.Companion.getConstructor());
        } else {
            valueOf.useNode();
        }
        Composer constructor-impl = Updater.constructor-impl(valueOf);
        int i8 = 0;
        Updater.set-impl(constructor-impl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, valueOf.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf, modifier2), ComposeUiNode.Companion.getSetModifier());
        final int i9 = 0;
        final Composer composer = constructor-impl;
        final int i10 = 0;
        if (!composer.getInserting()) {
            $i$f$Layout = valueOf2;
            if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            }
        } else {
            $i$f$Layout = valueOf2;
        }
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void Layout(List<? extends Function2<? super Composer, ? super Integer, Unit>> contents, Modifier modifier, androidx.compose.ui.layout.MultiContentMeasurePolicy measurePolicy, Composer $composer, int $changed, int i6) {
        androidx.compose.ui.Modifier.Companion modifier2;
        Object valueOf;
        Composer composer;
        int i;
        boolean changed;
        Object empty;
        Object $i$a$CacheLayoutKt$Layout$3;
        androidx.compose.ui.Modifier.Companion modifier3;
        final Composer composer2 = $composer;
        int i2 = $changed;
        ComposerKt.sourceInformationMarkerStart(composer2, 1399185516, "CC(Layout)P(!1,2)173@6976L62,170@6862L182:Layout.kt#80mrfh");
        if (i6 & 2 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt.sourceInformationMarkerStart(composer2, -290761997, "CC(remember):Layout.kt#9igjgp");
        int i12 = 0;
        int i13 = 256;
        if (i10 ^= 384 > i13) {
            if (!composer2.changed(measurePolicy)) {
                i = i2 & 384 == i13 ? 1 : i12;
            } else {
            }
        } else {
            valueOf = measurePolicy;
        }
        Composer composer3 = $composer;
        int i16 = 0;
        Object rememberedValue2 = composer3.rememberedValue();
        int i18 = 0;
        if (i == 0) {
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                int i19 = 0;
                composer3.updateRememberedValue(MultiContentMeasurePolicyKt.createMeasurePolicy(valueOf));
            } else {
                $i$a$CacheLayoutKt$Layout$3 = rememberedValue2;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        int i15 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, i12);
        final int i23 = 0;
        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(ComposeUiNode.Companion.getConstructor());
        } else {
            composer2.useNode();
        }
        Composer constructor-impl = Updater.constructor-impl(composer2);
        int i25 = 0;
        final int i27 = i5;
        Updater.set-impl(constructor-impl, (MeasurePolicy)$i$a$CacheLayoutKt$Layout$3, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, composer2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        int i26 = 0;
        final Composer obj21 = constructor-impl;
        final int i28 = 0;
        if (!obj21.getInserting()) {
            modifier3 = modifier2;
            if (!Intrinsics.areEqual(obj21.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                obj21.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            } else {
                composer = obj21;
            }
        } else {
            modifier3 = modifier2;
        }
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer2, modifier2), ComposeUiNode.Companion.getSetModifier());
        LayoutKt.combineAsVirtualLayouts(contents).invoke(composer2, Integer.valueOf(i3 &= 14));
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
    }

    public static final void Layout(Function2<? super Composer, ? super Integer, Unit> content, Modifier modifier, androidx.compose.ui.layout.MeasurePolicy measurePolicy, Composer $composer, int $changed, int i6) {
        boolean valueOf;
        androidx.compose.ui.Modifier.Companion modifier2;
        int $i$f$Layout;
        androidx.compose.ui.Modifier.Companion obj18;
        final Composer composer = $composer;
        valueOf = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
        if (i6 & 2 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        final int i10 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
        if (!applier instanceof Applier) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(ComposeUiNode.Companion.getConstructor());
        } else {
            composer.useNode();
        }
        Composer constructor-impl = Updater.constructor-impl(composer);
        int i12 = 0;
        Updater.set-impl(constructor-impl, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl(constructor-impl, composer.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        final int i13 = 0;
        final Composer composer2 = constructor-impl;
        final int i14 = 0;
        if (!composer2.getInserting()) {
            $i$f$Layout = valueOf;
            obj18 = modifier2;
            if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
            }
        } else {
            $i$f$Layout = valueOf;
            obj18 = modifier2;
        }
        Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer, modifier2), ComposeUiNode.Companion.getSetModifier());
        content.invoke(composer, Integer.valueOf(i &= 14));
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    @Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    public static final void MultiMeasureLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, androidx.compose.ui.layout.MeasurePolicy measurePolicy, Composer $composer, int $changed, int i6) {
        int traceInProgress;
        boolean currentCompositeKeyHash;
        int $dirty2;
        Object obj2;
        int $dirty;
        Object modifier2;
        Composer composer;
        int materializeModifier;
        boolean traceInProgress2;
        Object currentCompositionLocalMap;
        int i3;
        int i7;
        int i8;
        int constructor$ui_release;
        int i2;
        int i9;
        Composer constructor-impl;
        int i;
        Function2 setCompositeKeyHash;
        int i4;
        int i5;
        Object obj;
        Object obj18;
        int obj21;
        final Object obj3 = content;
        final Object obj4 = measurePolicy;
        final int i14 = $changed;
        traceInProgress = 1949933075;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(MultiMeasureLayout)P(2)248@9618L23,252@9770L491:Layout.kt#80mrfh");
        $dirty2 = $changed;
        materializeModifier = i6 & 1;
        if (materializeModifier != 0) {
            $dirty2 |= 6;
            currentCompositionLocalMap = modifier;
        } else {
            if (i14 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                currentCompositionLocalMap = modifier;
            }
        }
        if (i6 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i14 & 48 == 0) {
                i7 = restartGroup.changedInstance(obj3) ? 32 : 16;
                $dirty2 |= i7;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i14 & 384 == 0) {
                i8 = restartGroup.changed(obj4) ? 256 : 128;
                $dirty2 |= i8;
            }
        }
        int i16 = $dirty2;
        if (i16 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (materializeModifier != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = currentCompositionLocalMap;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i16, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:247)");
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(LayoutNode.Companion.getConstructor$ui_release());
                } else {
                    restartGroup.useNode();
                }
                constructor-impl = Updater.constructor-impl(restartGroup);
                i = 0;
                Updater.set-impl(constructor-impl, obj4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(constructor-impl, (Function1)LayoutKt.MultiMeasureLayout.1.1.INSTANCE);
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                i4 = 0;
                obj18 = constructor-impl;
                i5 = 0;
                if (!obj18.getInserting()) {
                    obj = modifier2;
                    if (!Intrinsics.areEqual(obj18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj18.updateRememberedValue(Integer.valueOf(obj21));
                        constructor-impl.apply(Integer.valueOf(obj21), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj18;
                    }
                } else {
                    obj21 = currentCompositeKeyHash;
                    obj = modifier2;
                }
                obj3.invoke(restartGroup, Integer.valueOf(i11 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = currentCompositionLocalMap;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new LayoutKt.MultiMeasureLayout.2(obj2, obj3, obj4, i14, i6);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(List<? extends Function2<? super Composer, ? super Integer, Unit>> contents) {
        LayoutKt.combineAsVirtualLayouts.1 anon = new LayoutKt.combineAsVirtualLayouts.1(contents);
        return (Function2)ComposableLambdaKt.composableLambdaInstance(-1953651383, true, anon);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Needed only for backwards compatibility. Do not use.")
    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(Modifier modifier) {
        LayoutKt.materializerOfWithCompositionLocalInjection.1 anon = new LayoutKt.materializerOfWithCompositionLocalInjection.1(modifier);
        return (Function3)ComposableLambdaKt.composableLambdaInstance(-55743822, true, anon);
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf(Modifier modifier) {
        LayoutKt.materializerOf.1 anon = new LayoutKt.materializerOf.1(modifier);
        return (Function3)ComposableLambdaKt.composableLambdaInstance(-1586257396, true, anon);
    }
}
