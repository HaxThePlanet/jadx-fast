package androidx.compose.material;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/material/ScaffoldState;", "", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;)V", "getDrawerState", "()Landroidx/compose/material/DrawerState;", "getSnackbarHostState", "()Landroidx/compose/material/SnackbarHostState;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScaffoldState {

    public static final int $stable;
    private final androidx.compose.material.DrawerState drawerState;
    private final androidx.compose.material.SnackbarHostState snackbarHostState;
    static {
    }

    public ScaffoldState(androidx.compose.material.DrawerState drawerState, androidx.compose.material.SnackbarHostState snackbarHostState) {
        super();
        this.drawerState = drawerState;
        this.snackbarHostState = snackbarHostState;
    }

    public final androidx.compose.material.DrawerState getDrawerState() {
        return this.drawerState;
    }

    public final androidx.compose.material.SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }
}
