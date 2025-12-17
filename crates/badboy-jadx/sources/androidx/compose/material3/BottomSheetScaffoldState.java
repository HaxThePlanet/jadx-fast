package androidx.compose.material3;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/material3/BottomSheetScaffoldState;", "", "bottomSheetState", "Landroidx/compose/material3/SheetState;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;)V", "getBottomSheetState", "()Landroidx/compose/material3/SheetState;", "getSnackbarHostState", "()Landroidx/compose/material3/SnackbarHostState;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomSheetScaffoldState {

    public static final int $stable;
    private final androidx.compose.material3.SheetState bottomSheetState;
    private final androidx.compose.material3.SnackbarHostState snackbarHostState;
    static {
    }

    public BottomSheetScaffoldState(androidx.compose.material3.SheetState bottomSheetState, androidx.compose.material3.SnackbarHostState snackbarHostState) {
        super();
        this.bottomSheetState = bottomSheetState;
        this.snackbarHostState = snackbarHostState;
    }

    public final androidx.compose.material3.SheetState getBottomSheetState() {
        return this.bottomSheetState;
    }

    public final androidx.compose.material3.SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }
}
