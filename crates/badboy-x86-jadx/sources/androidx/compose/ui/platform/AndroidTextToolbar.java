package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016JP\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00082\u0006\u0010\u0007\u001a\u00020\u0008@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/ui/platform/AndroidTextToolbar;", "Landroidx/compose/ui/platform/TextToolbar;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "actionMode", "Landroid/view/ActionMode;", "<set-?>", "Landroidx/compose/ui/platform/TextToolbarStatus;", "status", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "textActionModeCallback", "Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidTextToolbar implements androidx.compose.ui.platform.TextToolbar {

    public static final int $stable = 8;
    private ActionMode actionMode;
    private androidx.compose.ui.platform.TextToolbarStatus status;
    private final TextActionModeCallback textActionModeCallback;
    private final View view;
    static {
        final int i = 8;
    }

    public AndroidTextToolbar(View view) {
        super();
        this.view = view;
        AndroidTextToolbar.textActionModeCallback.1 anon = new AndroidTextToolbar.textActionModeCallback.1(this);
        TextActionModeCallback textActionModeCallback = new TextActionModeCallback((Function0)anon, 0, 0, 0, 0, 0, 62, 0);
        this.textActionModeCallback = textActionModeCallback;
        this.status = TextToolbarStatus.Hidden;
    }

    public static final void access$setActionMode$p(androidx.compose.ui.platform.AndroidTextToolbar $this, ActionMode <set-?>) {
        $this.actionMode = <set-?>;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public androidx.compose.ui.platform.TextToolbarStatus getStatus() {
        return this.status;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = 0;
    }

    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
        ActionMode actionMode;
        View view;
        FloatingTextActionModeCallback floatingTextActionModeCallback;
        int i;
        this.textActionModeCallback.setRect(rect);
        this.textActionModeCallback.setOnCopyRequested(onCopyRequested);
        this.textActionModeCallback.setOnCutRequested(onCutRequested);
        this.textActionModeCallback.setOnPasteRequested(onPasteRequested);
        this.textActionModeCallback.setOnSelectAllRequested(onSelectAllRequested);
        if (this.actionMode == null) {
            this.status = TextToolbarStatus.Shown;
            floatingTextActionModeCallback = new FloatingTextActionModeCallback(this.textActionModeCallback);
            this.actionMode = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, (ActionMode.Callback)floatingTextActionModeCallback, 1);
        } else {
            actionMode = this.actionMode;
            if (actionMode != null) {
                actionMode.invalidate();
            }
        }
    }
}
