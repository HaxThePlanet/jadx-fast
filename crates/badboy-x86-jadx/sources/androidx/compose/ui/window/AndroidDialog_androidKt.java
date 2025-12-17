package androidx.compose.ui.window;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0007H\u0007¢\u0006\u0002\u0010\u0008\u001a*\u0010\t\u001a\u00020\u00012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0007H\u0003¢\u0006\u0002\u0010\u000c¨\u0006\r²\u0006\u0015\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0007X\u008a\u0084\u0002", d2 = {"Dialog", "", "onDismissRequest", "Lkotlin/Function0;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DialogLayout", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_release", "currentContent"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidDialog_androidKt {
    public static final void Dialog(Function0<Unit> onDismissRequest, androidx.compose.ui.window.DialogProperties properties, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int density;
        int $dirty;
        Object $dirty2;
        int i9;
        int traceInProgress2;
        boolean traceInProgress;
        int view;
        Object anon2;
        Object empty;
        int i5;
        Object properties2;
        Object obj;
        int i4;
        int i12;
        int i3;
        boolean skipping;
        Object rememberSaveable;
        int i;
        int i13;
        int i2;
        Object rememberedValue;
        int i11;
        Object dialogProperties;
        Object anon;
        int layoutDirection;
        int i8;
        int i10;
        Composer.Companion companion;
        Composer.Companion companion2;
        int i7;
        androidx.compose.ui.window.DialogWrapper dialogWrapper;
        Object obj2;
        Object obj24;
        final Object obj3 = onDismissRequest;
        obj = content;
        i4 = $changed;
        density = -2032877254;
        final Composer restartGroup = $composer.startRestartGroup(density);
        ComposerKt.sourceInformation(restartGroup, "C(Dialog)P(1,2)167@7096L7,168@7135L7,169@7190L7,170@7220L28,171@7275L29,172@7324L38,173@7380L616,194@8027L129,194@8002L154,203@8173L182,203@8162L193:AndroidDialog.android.kt#2oxthz");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i4 & 6 == 0) {
                i9 = restartGroup.changedInstance(obj3) ? 4 : 2;
                $dirty |= i9;
            }
        }
        traceInProgress2 = i6 & 2;
        i5 = 32;
        if (traceInProgress2 != 0) {
            $dirty |= 48;
            properties2 = properties;
        } else {
            if (i4 & 48 == 0) {
                i12 = restartGroup.changed(properties) ? i5 : 16;
                $dirty |= i12;
            } else {
                properties2 = properties;
            }
        }
        if (i6 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i4 & 384 == 0) {
                i3 = restartGroup.changedInstance(obj) ? 256 : 128;
                $dirty |= i3;
            }
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (traceInProgress2 != 0) {
                    dialogProperties = new DialogProperties(0, 0, 0, 7, 0);
                    properties2 = dialogProperties;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(density, $dirty, -1, "androidx.compose.ui.window.Dialog (AndroidDialog.android.kt:166)");
                }
                int i15 = 6;
                int i23 = 0;
                int i29 = 2023513938;
                String str2 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object $changed$iv = consume2;
                int i24 = 6;
                int i36 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume3;
                int i37 = 6;
                int i42 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, str2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object obj5 = consume;
                int i25 = 0;
                int i38 = i25;
                i10 = i45;
                String str3 = "CC(remember):AndroidDialog.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -464840651, str3);
                Composer composer2 = restartGroup;
                int i44 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                companion = 0;
                obj24 = rememberSaveable;
                if (changed3 |= changed4 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        companion2 = 0;
                        int i21 = i5;
                        layoutDirection = $dirty;
                        DialogWrapper density2 = new DialogWrapper(obj3, properties2, $changed$iv, (LayoutDirection)obj5, this_$iv, obj24);
                        i7 = 0;
                        AndroidDialog_androidKt.Dialog.dialog.1.1.1 anon3 = new AndroidDialog_androidKt.Dialog.dialog.1.1.1(SnapshotStateKt.rememberUpdatedState(obj, restartGroup, i34 &= 14));
                        obj2 = $changed$iv;
                        density2.setContent(ComposablesKt.rememberCompositionContext(restartGroup, i25), (Function2)ComposableLambdaKt.composableLambdaInstance(488261145, true, anon3));
                        composer2.updateRememberedValue(density2);
                    } else {
                        i5 = this_$iv;
                        obj2 = $changed$iv;
                        density = rememberedValue2;
                        empty = obj5;
                        view = 1;
                        layoutDirection = $dirty;
                        $dirty2 = properties2;
                        properties2 = obj24;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -464820434, str3);
                Composer composer = restartGroup;
                int i39 = 0;
                dialogProperties = composer.rememberedValue();
                int i47 = 0;
                if (!restartGroup.changedInstance((DialogWrapper)density)) {
                    if (dialogProperties == Composer.Companion.getEmpty()) {
                        obj24 = i20;
                        anon2 = new AndroidDialog_androidKt.Dialog.1.1(density);
                        composer.updateRememberedValue((Function1)anon2);
                    } else {
                        anon2 = dialogProperties;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect(density, (Function1)anon2, restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -464815709, str3);
                i = layoutDirection & 14 == 4 ? 1 : 0;
                i13 = layoutDirection & 112 == 32 ? 1 : 0;
                skipping = restartGroup;
                i2 = 0;
                rememberedValue = skipping.rememberedValue();
                int i41 = 0;
                if (i18 |= changed2 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        dialogProperties = 0;
                        anon = new AndroidDialog_androidKt.Dialog.2.1(density, obj3, $dirty2, empty);
                        skipping.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)anon, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                layoutDirection = $dirty;
                $dirty2 = properties2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            density = new AndroidDialog_androidKt.Dialog.3(obj3, $dirty2, content, $changed, i6);
            endRestartGroup.updateScope((Function2)density);
        }
    }

    private static final Function2<Composer, Integer, Unit> Dialog$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> $currentContent$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function2)$currentContent$delegate.getValue();
    }

    private static final void DialogLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i5) {
        int traceInProgress2;
        boolean iNSTANCE;
        int $dirty;
        int setCompositeKeyHash;
        Object modifier2;
        Object obj;
        boolean traceInProgress;
        Integer valueOf;
        Composer composer2;
        int i3;
        int i6;
        boolean skipping;
        int currentCompositeKeyHash;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        Function0 constructor;
        int i8;
        int i4;
        int i2;
        int i7;
        Composer composer;
        int i;
        androidx.compose.ui.window.AndroidDialog_androidKt.DialogLayout.1 measurePolicy$iv;
        int i9;
        Object obj21;
        int obj23;
        final Object obj2 = content;
        final int i10 = $changed;
        final int i11 = i5;
        traceInProgress2 = -1177876616;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DialogLayout)P(1)465@18400L455:AndroidDialog.android.kt#2oxthz");
        $dirty = $changed;
        setCompositeKeyHash = i11 & 1;
        if (setCompositeKeyHash != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i10 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj = modifier;
            }
        }
        if (i11 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i10 & 48 == 0) {
                i6 = restartGroup.changedInstance(obj2) ? 32 : 16;
                $dirty |= i6;
            }
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (setCompositeKeyHash != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.ui.window.DialogLayout (AndroidDialog.android.kt:464)");
                }
                iNSTANCE = AndroidDialog_androidKt.DialogLayout.1.INSTANCE;
                i17 |= i19;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                i4 = 0;
                obj23 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                $dirty = Updater.constructor-impl(restartGroup);
                i2 = 0;
                Updater.set-impl($dirty, (MeasurePolicy)iNSTANCE, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($dirty, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i7 = 0;
                composer = $dirty;
                i = 0;
                if (!composer.getInserting()) {
                    measurePolicy$iv = iNSTANCE;
                    i9 = valueOf;
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        $dirty.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer;
                    }
                } else {
                    measurePolicy$iv = iNSTANCE;
                    i9 = valueOf;
                }
                Updater.set-impl($dirty, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                obj2.invoke(restartGroup, Integer.valueOf(i12 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj21;
            } else {
                restartGroup.skipToGroupEnd();
                obj23 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new AndroidDialog_androidKt.DialogLayout.2(obj, obj2, i10, i11);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final Function2 access$Dialog$lambda$0(State $currentContent$delegate) {
        return AndroidDialog_androidKt.Dialog$lambda$0($currentContent$delegate);
    }

    public static final void access$DialogLayout(Modifier modifier, Function2 content, Composer $composer, int $changed, int $default) {
        AndroidDialog_androidKt.DialogLayout(modifier, content, $composer, $changed, $default);
    }
}
