package androidx.activity.compose;

import androidx.activity.FullyDrawnReporterOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a+\u0010\u0003\u001a\u00020\u00012\u001c\u0010\u0004\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0007¢\u0006\u0002\u0010\u0008\u001a\u001b\u0010\t\u001a\u00020\u00012\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"ReportDrawn", "", "(Landroidx/compose/runtime/Composer;I)V", "ReportDrawnAfter", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReportDrawnWhen", "predicate", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ReportDrawnKt {
    public static final void ReportDrawn(Composer $composer, int $changed) {
        int traceInProgress;
        boolean skipping;
        boolean traceInProgress2;
        String str;
        traceInProgress = -1357012904;
        final Composer obj3 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj3, "C(ReportDrawn)135@4981L24:ReportDrawn.kt#q1dkbc");
        if ($changed == 0) {
            if (!obj3.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $changed, -1, "androidx.activity.compose.ReportDrawn (ReportDrawn.kt:135)");
                }
                ReportDrawnKt.ReportDrawnWhen((Function0)ReportDrawnKt.ReportDrawn.1.INSTANCE, obj3, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj3.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj3.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new ReportDrawnKt.ReportDrawn.2($changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void ReportDrawnAfter(Function1<? super Continuation<? super Unit>, ? extends Object> block, Composer $composer, int $changed) {
        Object fullyDrawnReporter;
        int $dirty;
        int i2;
        int traceInProgress;
        boolean traceInProgress2;
        int anon2;
        int str;
        int i;
        Object rememberedValue;
        int i4;
        Object empty;
        Object anon;
        int i3;
        fullyDrawnReporter = 945311272;
        final Composer obj11 = $composer.startRestartGroup(fullyDrawnReporter);
        ComposerKt.sourceInformation(obj11, "C(ReportDrawnAfter)149@5495L7,150@5579L48,150@5537L90:ReportDrawn.kt#q1dkbc");
        str = 2;
        if ($changed & 6 == 0) {
            i2 = obj11.changedInstance(block) ? 4 : str;
            $dirty |= i2;
        }
        if ($dirty & 3 == str) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(fullyDrawnReporter, $dirty, -1, "androidx.activity.compose.ReportDrawnAfter (ReportDrawn.kt:148)");
                }
                fullyDrawnReporter = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(obj11, 6);
                if (fullyDrawnReporter != null) {
                    fullyDrawnReporter = fullyDrawnReporter.getFullyDrawnReporter();
                    if (fullyDrawnReporter == null) {
                    } else {
                        ComposerKt.sourceInformationMarkerStart(obj11, 1169985900, "CC(remember):ReportDrawn.kt#9igjgp");
                        str = obj11;
                        i = 0;
                        rememberedValue = str.rememberedValue();
                        i4 = 0;
                        if (changedInstance |= changedInstance3 == 0) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon = new ReportDrawnKt.ReportDrawnAfter.1.1(fullyDrawnReporter, block, 0);
                                str.updateRememberedValue((Function2)anon);
                            } else {
                                anon = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(obj11);
                        EffectsKt.LaunchedEffect(block, fullyDrawnReporter, (Function2)anon, obj11, $dirty & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup2 = obj11.endRestartGroup();
                        if (endRestartGroup2 != null) {
                            traceInProgress = new ReportDrawnKt.ReportDrawnAfter.2(block, $changed);
                            endRestartGroup2.updateScope((Function2)traceInProgress);
                        }
                    }
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            anon2 = new ReportDrawnKt.ReportDrawnAfter.fullyDrawnReporter.1(block, $changed);
            endRestartGroup.updateScope((Function2)anon2);
        }
    }

    public static final void ReportDrawnWhen(Function0<Boolean> predicate, Composer $composer, int $changed) {
        Object fullyDrawnReporter;
        int $dirty;
        int i;
        int traceInProgress;
        boolean traceInProgress2;
        int anon2;
        int i4;
        int i2;
        int str;
        Object rememberedValue;
        int i3;
        Object empty;
        Object anon;
        fullyDrawnReporter = -2047119994;
        final Composer obj10 = $composer.startRestartGroup(fullyDrawnReporter);
        ComposerKt.sourceInformation(obj10, "C(ReportDrawnWhen)117@4373L7,118@4463L263,118@4415L311:ReportDrawn.kt#q1dkbc");
        i2 = 4;
        str = 2;
        if ($changed & 6 == 0) {
            i = obj10.changedInstance(predicate) ? i2 : str;
            $dirty |= i;
        }
        if ($dirty & 3 == str) {
            if (!obj10.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(fullyDrawnReporter, $dirty, -1, "androidx.activity.compose.ReportDrawnWhen (ReportDrawn.kt:116)");
                }
                fullyDrawnReporter = LocalFullyDrawnReporterOwner.INSTANCE.getCurrent(obj10, 6);
                if (fullyDrawnReporter != null) {
                    fullyDrawnReporter = fullyDrawnReporter.getFullyDrawnReporter();
                    if (fullyDrawnReporter == null) {
                    } else {
                        ComposerKt.sourceInformationMarkerStart(obj10, 530578081, "CC(remember):ReportDrawn.kt#9igjgp");
                        i4 = $dirty & 14 == i2 ? 1 : 0;
                        i2 = obj10;
                        str = 0;
                        rememberedValue = i2.rememberedValue();
                        i3 = 0;
                        if (changedInstance |= i4 == 0) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty = 0;
                                anon = new ReportDrawnKt.ReportDrawnWhen.1.1(fullyDrawnReporter, predicate);
                                i2.updateRememberedValue((Function1)anon);
                            } else {
                                anon = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(obj10);
                        EffectsKt.DisposableEffect(fullyDrawnReporter, predicate, (Function1)anon, obj10, i7 &= 112);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup2 = obj10.endRestartGroup();
                        if (endRestartGroup2 != null) {
                            traceInProgress = new ReportDrawnKt.ReportDrawnWhen.2(predicate, $changed);
                            endRestartGroup2.updateScope((Function2)traceInProgress);
                        }
                    }
                }
            } else {
                obj10.skipToGroupEnd();
            }
        } else {
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = obj10.endRestartGroup();
        if (endRestartGroup != null) {
            anon2 = new ReportDrawnKt.ReportDrawnWhen.fullyDrawnReporter.1(predicate, $changed);
            endRestartGroup.updateScope((Function2)anon2);
        }
    }
}
