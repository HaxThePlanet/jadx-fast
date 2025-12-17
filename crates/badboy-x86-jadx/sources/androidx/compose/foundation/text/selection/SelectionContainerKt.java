package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0004H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0006\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u000c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0004H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\u000c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u008e\u0002", d2 = {"DisableSelection", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectionContainerKt {
    public static final void DisableSelection(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int $dirty;
        int i;
        int skipping;
        boolean traceInProgress;
        int str;
        traceInProgress2 = 336063542;
        final Composer obj5 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj5, "C(DisableSelection)68@2698L104:SelectionContainer.kt#eksfi3");
        str = 2;
        if ($changed & 6 == 0) {
            i = obj5.changedInstance(content) ? 4 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj5.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:67)");
                }
                CompositionLocalKt.CompositionLocalProvider(SelectionRegistrarKt.getLocalSelectionRegistrar().provides(0), content, obj5, $stable |= str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj5.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj5.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new SelectionContainerKt.DisableSelection.1(content, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void SelectionContainer(Modifier modifier, androidx.compose.foundation.text.selection.Selection selection, Function1<? super androidx.compose.foundation.text.selection.Selection, Unit> onSelectionChange, Function2<? super Composer, ? super Integer, Unit> children, Composer $composer, int $changed, int i7) {
        Object selectionManager;
        int $dirty;
        int $dirty2;
        Object modifier2;
        boolean traceInProgress2;
        int rememberSaveable;
        Object traceInProgress;
        int i5;
        int i6;
        int i2;
        int i4;
        int i3;
        int i8;
        Object rememberedValue;
        int i;
        Object empty2;
        Object empty;
        Object anon;
        final Object obj2 = selection;
        final Object obj3 = onSelectionChange;
        final Object obj4 = children;
        final int i10 = $changed;
        selectionManager = 2078139907;
        final Composer restartGroup = $composer.startRestartGroup(selectionManager);
        ComposerKt.sourceInformation(restartGroup, "C(SelectionContainer)P(1,3,2)91@3403L95,95@3518L44,97@3613L7,98@3674L7,99@3725L7,103@3847L2060,103@3822L2085,149@5939L106,149@5913L132:SelectionContainer.kt#eksfi3");
        $dirty = $changed;
        rememberSaveable = i7 & 1;
        if (rememberSaveable != 0) {
            $dirty |= 6;
            traceInProgress = modifier;
        } else {
            if (i10 & 6 == 0) {
                i5 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i5;
            } else {
                traceInProgress = modifier;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i10 & 48 == 0) {
                i6 = restartGroup.changed(obj2) ? 32 : 16;
                $dirty |= i6;
            }
        }
        if (i7 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i10 & 384 == 0) {
                i2 = restartGroup.changedInstance(obj3) ? 256 : 128;
                $dirty |= i2;
            }
        }
        if (i7 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i10 & 3072 == 0) {
                i4 = restartGroup.changedInstance(obj4) ? 2048 : 1024;
                $dirty |= i4;
            }
        }
        final int i31 = $dirty;
        if (i31 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (rememberSaveable != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = traceInProgress;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(selectionManager, i31, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:90)");
                }
                rememberSaveable = RememberSaveableKt.rememberSaveable(new Object[0], SelectionRegistrarImpl.Companion.getSaver(), 0, (Function0)SelectionContainerKt.SelectionContainer.registrarImpl.1.INSTANCE, restartGroup, 3072, 4);
                String str2 = "CC(remember):SelectionContainer.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 882622186, str2);
                int i13 = 0;
                Composer composer = restartGroup;
                int i23 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i32 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    selectionManager = new SelectionManager((SelectionRegistrarImpl)rememberSaveable);
                    composer.updateRememberedValue(selectionManager);
                } else {
                    selectionManager = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i17 = 0;
                int i24 = 0;
                int i29 = 2023513938;
                empty2 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, empty2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                (SelectionManager)selectionManager.setHapticFeedBack((HapticFeedback)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalHapticFeedback()));
                int i18 = 0;
                int i25 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, empty2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                selectionManager.setClipboardManager((ClipboardManager)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalClipboardManager()));
                int i19 = 0;
                int i26 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i29, empty2);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                selectionManager.setTextToolbar((TextToolbar)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalTextToolbar()));
                selectionManager.setOnSelectionChange(obj3);
                selectionManager.setSelection(obj2);
                SelectionContainerKt.SelectionContainer.3 anon2 = new SelectionContainerKt.SelectionContainer.3(rememberSaveable, modifier2, selectionManager, obj4);
                ContextMenu_androidKt.ContextMenuArea(selectionManager, (Function2)ComposableLambdaKt.rememberComposableLambda(-123806316, true, anon2, restartGroup, 54), restartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 882699720, str2);
                i3 = restartGroup;
                i8 = 0;
                rememberedValue = i3.rememberedValue();
                i = 0;
                if (!restartGroup.changedInstance(selectionManager)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        anon = new SelectionContainerKt.SelectionContainer.4.1(selectionManager);
                        i3.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.DisposableEffect(selectionManager, (Function1)anon, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                modifier2 = traceInProgress;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            selectionManager = new SelectionContainerKt.SelectionContainer.5(modifier2, obj2, obj3, obj4, i10, i7);
            endRestartGroup.updateScope((Function2)selectionManager);
        }
    }

    public static final void SelectionContainer(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i5) {
        int anon;
        int companion;
        int i;
        Object mutableStateOf$default;
        int i3;
        int i2;
        boolean $this$cache$iv;
        Object obj;
        int i6;
        int i4;
        Object empty;
        Object empty2;
        Object anon2;
        Object obj10;
        Object obj11;
        int obj12;
        anon = -1075498320;
        final Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(SelectionContainer)P(1)49@2177L45,53@2335L38,50@2227L180:SelectionContainer.kt#eksfi3");
        obj12 = $changed;
        companion = i5 & 1;
        i = 2;
        if (companion != 0) {
            obj12 |= 6;
        } else {
            if ($changed & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : i;
                obj12 |= i3;
            }
        }
        if (i5 & 2 != 0) {
            obj12 |= 48;
        } else {
            if ($changed & 48 == 0) {
                i2 = restartGroup.changedInstance(content) ? 32 : 16;
                obj12 |= i2;
            }
        }
        if (obj12 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (companion != 0) {
                    obj10 = companion;
                }
                companion = obj10;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, obj12, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:48)");
                }
                String str = "CC(remember):SelectionContainer.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 882579275, str);
                obj10 = 0;
                Composer composer = restartGroup;
                int i11 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i15 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty2 = 0;
                    anon2 = 0;
                    composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(anon2, anon2, i, anon2));
                } else {
                    mutableStateOf$default = rememberedValue;
                }
                obj10 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 882584324, str);
                int i7 = 0;
                Composer composer2 = restartGroup;
                int i12 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i16 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon2 = new SelectionContainerKt.SelectionContainer.1.1(obj10);
                    composer2.updateRememberedValue((Function1)anon2);
                } else {
                    anon2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SelectionContainerKt.SelectionContainer(companion, SelectionContainerKt.SelectionContainer$lambda$1((MutableState)obj10), (Function1)anon2, content, restartGroup, anon | i14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj10 = companion;
            } else {
                restartGroup.skipToGroupEnd();
                obj = content;
            }
        } else {
        }
        obj11 = restartGroup.endRestartGroup();
        if (obj11 != null) {
            anon = new SelectionContainerKt.SelectionContainer.2(obj10, obj, $changed, i5);
            obj11.updateScope((Function2)anon);
        }
    }

    private static final androidx.compose.foundation.text.selection.Selection SelectionContainer$lambda$1(MutableState<androidx.compose.foundation.text.selection.Selection> $selection$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Selection)(State)$selection$delegate.getValue();
    }

    private static final void SelectionContainer$lambda$2(MutableState<androidx.compose.foundation.text.selection.Selection> $selection$delegate, androidx.compose.foundation.text.selection.Selection value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $selection$delegate.setValue(value);
    }

    public static final void access$SelectionContainer$lambda$2(MutableState $selection$delegate, androidx.compose.foundation.text.selection.Selection value) {
        SelectionContainerKt.SelectionContainer$lambda$2($selection$delegate, value);
    }
}
