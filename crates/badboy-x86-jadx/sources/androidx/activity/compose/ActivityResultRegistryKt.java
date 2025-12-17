package androidx.activity.compose;

import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001aM\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\u0008\u0000\u0010\u0002\"\u0004\u0008\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00080\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"rememberLauncherForActivityResult", "Landroidx/activity/compose/ManagedActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "onResult", "Lkotlin/Function1;", "", "(Landroidx/activity/result/contract/ActivityResultContract;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/activity/compose/ManagedActivityResultLauncher;", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultRegistryKt {
    public static final <I, O> androidx.activity.compose.ManagedActivityResultLauncher<I, O> rememberLauncherForActivityResult(ActivityResultContract<I, O> contract, Function1<? super O, Unit> onResult, Composer $composer, int $changed) {
        androidx.activity.result.ActivityResultRegistry currentOnResult;
        boolean traceInProgress;
        Object realLauncher;
        Object activityResultRegistry2;
        String str;
        Object activityResultRegistry;
        Object invalid$iv;
        Object empty2;
        Object invalid$iv3;
        int empty;
        Object activityResultLauncherHolder;
        int empty3;
        int invalid$iv2;
        androidx.compose.runtime.State state;
        androidx.activity.compose.ActivityResultLauncherHolder activity2;
        androidx.activity.result.ActivityResultRegistry activity;
        Object obj = contract;
        Composer composer = $composer;
        final int i23 = $changed;
        int i = -1408504823;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(rememberLauncherForActivityResult)84@3541L30,85@3598L30,89@3767L49,*92@3905L7,96@4088L46,97@4162L73,101@4418L176,101@4362L232:ActivityResultRegistry.kt#q1dkbc");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, i23, -1, "androidx.activity.compose.rememberLauncherForActivityResult (ActivityResultRegistry.kt:82)");
        }
        androidx.compose.runtime.State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onResult, composer, i3 &= 14);
        final Composer composer4 = $composer;
        realLauncher = RememberSaveableKt.rememberSaveable(new Object[0], 0, 0, (Function0)ActivityResultRegistryKt.rememberLauncherForActivityResult.key.1.INSTANCE, composer4, 3072, 6);
        ActivityResultRegistryOwner current = LocalActivityResultRegistryOwner.INSTANCE.getCurrent(composer4, 6);
        if (current == null) {
        } else {
            activityResultRegistry = current.getActivityResultRegistry();
            String str4 = "CC(remember):ActivityResultRegistry.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer4, -316131648, str4);
            int i10 = 0;
            Composer composer3 = $composer;
            int i18 = 0;
            Object rememberedValue = composer3.rememberedValue();
            int i24 = 0;
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                activityResultLauncherHolder = new ActivityResultLauncherHolder();
                composer3.updateRememberedValue(activityResultLauncherHolder);
            } else {
                activityResultLauncherHolder = rememberedValue;
            }
            invalid$iv = activityResultLauncherHolder;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, -316129253, str4);
            int i16 = 0;
            Composer composer5 = $composer;
            int i22 = 0;
            Object rememberedValue2 = composer5.rememberedValue();
            int i26 = 0;
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty3 = 0;
                invalid$iv2 = i16;
                invalid$iv3 = new ManagedActivityResultLauncher((ActivityResultLauncherHolder)invalid$iv, SnapshotStateKt.rememberUpdatedState(obj, composer, i23 & 14));
                composer5.updateRememberedValue(invalid$iv3);
            } else {
                invalid$iv2 = i16;
                invalid$iv3 = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, -316120958, str4);
            Composer composer6 = $composer;
            int i25 = 0;
            Object rememberedValue3 = composer6.rememberedValue();
            int i27 = 0;
            if (changed2 |= empty2 == 0) {
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    invalid$iv2 = 0;
                    empty2 = rememberUpdatedState;
                    activityResultRegistry = realLauncher;
                    androidx.activity.compose.ActivityResultLauncherHolder key = invalid$iv;
                    androidx.activity.result.ActivityResultRegistry activity3 = activity;
                    ActivityResultRegistryKt.rememberLauncherForActivityResult.1.1 currentOnResult2 = new ActivityResultRegistryKt.rememberLauncherForActivityResult.1.1(key, activity3, activityResultRegistry, obj, empty2);
                    currentOnResult = activity5;
                    activity2 = key;
                    realLauncher = activityResultRegistry;
                    state = empty2;
                    composer6.updateRememberedValue((Function1)currentOnResult2);
                } else {
                    state = rememberUpdatedState;
                    currentOnResult = activityResultRegistry;
                    activity2 = invalid$iv;
                    activityResultRegistry2 = rememberedValue3;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            EffectsKt.DisposableEffect(currentOnResult, realLauncher, contract, (Function1)activityResultRegistry2, composer4, i6 & 896);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            return (ManagedActivityResultLauncher)invalid$iv3;
        }
        androidx.compose.runtime.State currentOnResult4 = rememberUpdatedState;
        int currentOnResult3 = 0;
        IllegalStateException $i$a$CheckNotNullActivityResultRegistryKt$rememberLauncherForActivityResult$activityResultRegistry$1 = new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner".toString());
        throw $i$a$CheckNotNullActivityResultRegistryKt$rememberLauncherForActivityResult$activityResultRegistry$1;
    }
}
