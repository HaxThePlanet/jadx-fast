package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.platform.InspectionModeKt;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a(\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00082\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0004H\u0001¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"InInspectionModeOnly", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Inspectable", "compositionDataRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "(Landroidx/compose/ui/tooling/CompositionDataRecord;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InspectableKt {
    @Deprecated(message = "This method should not be used in application code and will be removed soon.")
    public static final void InInspectionModeOnly(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Integer valueOf;
        int traceInProgress2;
        int $dirty;
        int i;
        int skipping;
        boolean traceInProgress;
        int str2;
        Object consume;
        String str;
        traceInProgress2 = 484868210;
        final Composer obj7 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj7, "C(InInspectionModeOnly)75@2613L7:Inspectable.android.kt#hevd2p");
        str2 = 2;
        if ($changed & 6 == 0) {
            i = obj7.changedInstance(content) ? 4 : str2;
            $dirty |= i;
        }
        if ($dirty & 3 == str2) {
            if (!obj7.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.ui.tooling.InInspectionModeOnly (Inspectable.android.kt:74)");
                }
                skipping = 0;
                str2 = 0;
                ComposerKt.sourceInformationMarkerStart(obj7, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj7);
                if ((Boolean)obj7.consume((CompositionLocal)InspectionModeKt.getLocalInspectionMode()).booleanValue()) {
                    obj7.startReplaceGroup(-1889599068);
                    ComposerKt.sourceInformation(obj7, "76@2632L9");
                    content.invoke(obj7, Integer.valueOf($dirty & 14));
                    obj7.endReplaceGroup();
                } else {
                    obj7.startReplaceGroup(-1889575043);
                    obj7.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj7.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj7.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new InspectableKt.InInspectionModeOnly.1(content, $changed);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void Inspectable(androidx.compose.ui.tooling.CompositionDataRecord compositionDataRecord, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int store;
        int $dirty;
        boolean changedInstance;
        int i2;
        int i3;
        int traceInProgress2;
        boolean traceInProgress;
        int i4;
        int str;
        int i;
        store = -1669497937;
        final Composer obj8 = $composer.startRestartGroup(store);
        ComposerKt.sourceInformation(obj8, "C(Inspectable)60@2050L146:Inspectable.android.kt#hevd2p");
        i4 = 2;
        if ($changed & 6 == 0) {
            if ($changed & 8 == 0) {
                changedInstance = obj8.changed(compositionDataRecord);
            } else {
                changedInstance = obj8.changedInstance(compositionDataRecord);
            }
            i2 = changedInstance != null ? 4 : i4;
            $dirty |= i2;
        }
        if ($changed & 48 == 0) {
            i3 = obj8.changedInstance(content) ? 32 : 16;
            $dirty |= i3;
        }
        if ($dirty & 19 == 18) {
            if (!obj8.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(store, $dirty, -1, "androidx.compose.ui.tooling.Inspectable (Inspectable.android.kt:56)");
                }
                obj8.collectParameterInformation();
                Intrinsics.checkNotNull(compositionDataRecord, "null cannot be cast to non-null type androidx.compose.ui.tooling.CompositionDataRecordImpl");
                store = (CompositionDataRecordImpl)compositionDataRecord.getStore();
                store.add(obj8.getCompositionData());
                ProvidedValue[] arr = new ProvidedValue[i4];
                int i6 = 1;
                arr[0] = InspectionModeKt.getLocalInspectionMode().provides(Boolean.valueOf(i6));
                arr[i6] = InspectionTablesKt.getLocalInspectionTables().provides(store);
                CompositionLocalKt.CompositionLocalProvider(arr, content, obj8, $stable |= str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj8.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj8.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new InspectableKt.Inspectable.1(compositionDataRecord, content, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
