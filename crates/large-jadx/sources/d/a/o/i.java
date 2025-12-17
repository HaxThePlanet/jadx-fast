package d.a.o;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* loaded from: classes.dex */
public class i implements Window.Callback {

    final Window.Callback a;
    public i(Window.Callback window$Callback) {
        super();
        if (callback == null) {
        } else {
            this.a = callback;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Window callback may not be null");
        throw obj2;
    }

    @Override // android.view.Window$Callback
    public final Window.Callback a() {
        return this.a;
    }

    @Override // android.view.Window$Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window$Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.a.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.Window$Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.a.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.view.Window$Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window$Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window$Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window$Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window$Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window$Callback
    public void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    @Override // android.view.Window$Callback
    public void onContentChanged() {
        this.a.onContentChanged();
    }

    @Override // android.view.Window$Callback
    public boolean onCreatePanelMenu(int i, Menu menu2) {
        return this.a.onCreatePanelMenu(i, menu2);
    }

    @Override // android.view.Window$Callback
    public View onCreatePanelView(int i) {
        return this.a.onCreatePanelView(i);
    }

    @Override // android.view.Window$Callback
    public void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    @Override // android.view.Window$Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem2) {
        return this.a.onMenuItemSelected(i, menuItem2);
    }

    @Override // android.view.Window$Callback
    public boolean onMenuOpened(int i, Menu menu2) {
        return this.a.onMenuOpened(i, menu2);
    }

    @Override // android.view.Window$Callback
    public void onPanelClosed(int i, Menu menu2) {
        this.a.onPanelClosed(i, menu2);
    }

    @Override // android.view.Window$Callback
    public void onPointerCaptureChanged(boolean z) {
        this.a.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window$Callback
    public boolean onPreparePanel(int i, View view2, Menu menu3) {
        return this.a.onPreparePanel(i, view2, menu3);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu2, int i3) {
        this.a.onProvideKeyboardShortcuts(list, menu2, i3);
    }

    @Override // android.view.Window$Callback
    public boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    @Override // android.view.Window$Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window$Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams windowManager$LayoutParams) {
        this.a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window$Callback
    public void onWindowFocusChanged(boolean z) {
        this.a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window$Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback) {
        return this.a.onWindowStartingActionMode(callback);
    }

    @Override // android.view.Window$Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback, int i2) {
        return this.a.onWindowStartingActionMode(callback, i2);
    }
}
