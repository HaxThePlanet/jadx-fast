package androidx.compose.runtime.tooling;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import java.util.Set;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u001f\u0010\u0000\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u0006", d2 = {"LocalInspectionTables", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "Landroidx/compose/runtime/tooling/CompositionData;", "getLocalInspectionTables", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InspectionTablesKt {

    private static final ProvidableCompositionLocal<Set<androidx.compose.runtime.tooling.CompositionData>> LocalInspectionTables;
    static {
        InspectionTablesKt.LocalInspectionTables = CompositionLocalKt.staticCompositionLocalOf((Function0)InspectionTablesKt.LocalInspectionTables.1.INSTANCE);
    }

    public static final ProvidableCompositionLocal<Set<androidx.compose.runtime.tooling.CompositionData>> getLocalInspectionTables() {
        return InspectionTablesKt.LocalInspectionTables;
    }
}
