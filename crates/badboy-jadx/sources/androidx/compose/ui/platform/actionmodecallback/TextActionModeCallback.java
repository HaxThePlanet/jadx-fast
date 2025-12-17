package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001Bi\u0012\u0010\u0008\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\u0008\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\u0008\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0000¢\u0006\u0002\u0008 J(\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010\u001e\u001a\u0004\u0018\u00010'J\u001a\u0010(\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010)\u001a\u00020\u0004J\u001a\u0010*\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0008,R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\r\"\u0004\u0008\u000f\u0010\u0010R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\r\"\u0004\u0008\u0012\u0010\u0010R\"\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\r\"\u0004\u0008\u0014\u0010\u0010R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\r\"\u0004\u0008\u0016\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006-", d2 = {"Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", "", "onActionModeDestroy", "Lkotlin/Function0;", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnActionModeDestroy", "()Lkotlin/jvm/functions/Function0;", "getOnCopyRequested", "setOnCopyRequested", "(Lkotlin/jvm/functions/Function0;)V", "getOnCutRequested", "setOnCutRequested", "getOnPasteRequested", "setOnPasteRequested", "getOnSelectAllRequested", "setOnSelectAllRequested", "getRect", "()Landroidx/compose/ui/geometry/Rect;", "setRect", "(Landroidx/compose/ui/geometry/Rect;)V", "addMenuItem", "menu", "Landroid/view/Menu;", "item", "Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "addMenuItem$ui_release", "addOrRemoveMenuItem", "callback", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "Landroid/view/MenuItem;", "onCreateActionMode", "onDestroyActionMode", "onPrepareActionMode", "updateMenuItems", "updateMenuItems$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextActionModeCallback {

    public static final int $stable = 8;
    private final Function0<Unit> onActionModeDestroy;
    private Function0<Unit> onCopyRequested;
    private Function0<Unit> onCutRequested;
    private Function0<Unit> onPasteRequested;
    private Function0<Unit> onSelectAllRequested;
    private Rect rect;
    static {
        final int i = 8;
    }

    public TextActionModeCallback() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public TextActionModeCallback(Function0<Unit> onActionModeDestroy, Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
        super();
        this.onActionModeDestroy = onActionModeDestroy;
        this.rect = rect;
        this.onCopyRequested = onCopyRequested;
        this.onPasteRequested = onPasteRequested;
        this.onCutRequested = onCutRequested;
        this.onSelectAllRequested = onSelectAllRequested;
    }

    public TextActionModeCallback(Function0 function0, Rect rect2, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        int obj2;
        Rect obj3;
        int obj4;
        int obj5;
        int obj6;
        int obj8;
        final int i = 0;
        obj2 = i7 & 1 != 0 ? i : obj2;
        if (i7 & 2 != 0) {
            obj3 = Rect.Companion.getZero();
        }
        obj4 = i7 & 4 != 0 ? i : obj4;
        obj5 = i7 & 8 != 0 ? i : obj5;
        obj6 = i7 & 16 != 0 ? i : obj6;
        obj8 = i7 &= 32 != 0 ? i : function06;
        super(obj2, obj3, obj4, obj5, obj6, obj8);
    }

    private final void addOrRemoveMenuItem(Menu menu, androidx.compose.ui.platform.actionmodecallback.MenuItemOption item, Function0<Unit> callback) {
        MenuItem item2;
        if (callback != null && menu.findItem(item.getId()) == null) {
            if (menu.findItem(item.getId()) == null) {
                addMenuItem$ui_release(menu, item);
            } else {
                if (callback == null && menu.findItem(item.getId()) != null) {
                    if (menu.findItem(item.getId()) != null) {
                        menu.removeItem(item.getId());
                    }
                }
            }
        } else {
        }
    }

    public final void addMenuItem$ui_release(Menu menu, androidx.compose.ui.platform.actionmodecallback.MenuItemOption item) {
        menu.add(0, item.getId(), item.getOrder(), item.getTitleResource()).setShowAsAction(1);
    }

    public final Function0<Unit> getOnActionModeDestroy() {
        return this.onActionModeDestroy;
    }

    public final Function0<Unit> getOnCopyRequested() {
        return this.onCopyRequested;
    }

    public final Function0<Unit> getOnCutRequested() {
        return this.onCutRequested;
    }

    public final Function0<Unit> getOnPasteRequested() {
        return this.onPasteRequested;
    }

    public final Function0<Unit> getOnSelectAllRequested() {
        return this.onSelectAllRequested;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Function0 onSelectAllRequested;
        int i;
        Intrinsics.checkNotNull(item);
        int itemId = item.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            onSelectAllRequested = this.onCopyRequested;
            if (onSelectAllRequested != null) {
                onSelectAllRequested.invoke();
            }
            if (mode != null) {
                mode.finish();
            }
            return 1;
        } else {
            if (itemId == MenuItemOption.Paste.getId()) {
                onSelectAllRequested = this.onPasteRequested;
                if (onSelectAllRequested != null) {
                    onSelectAllRequested.invoke();
                }
            } else {
                if (itemId == MenuItemOption.Cut.getId()) {
                    onSelectAllRequested = this.onCutRequested;
                    if (onSelectAllRequested != null) {
                        onSelectAllRequested.invoke();
                    }
                } else {
                    onSelectAllRequested = this.onSelectAllRequested;
                    if (itemId == MenuItemOption.SelectAll.getId() && onSelectAllRequested != null) {
                        onSelectAllRequested = this.onSelectAllRequested;
                        if (onSelectAllRequested != null) {
                            onSelectAllRequested.invoke();
                        }
                    }
                }
            }
        }
        return 0;
    }

    public final boolean onCreateActionMode(ActionMode mode, Menu menu) {
        int i;
        androidx.compose.ui.platform.actionmodecallback.MenuItemOption selectAll;
        if (menu == null) {
        } else {
            if (mode == null) {
            } else {
                if (this.onCopyRequested != null) {
                    i = 0;
                    addMenuItem$ui_release(menu, MenuItemOption.Copy);
                }
                if (this.onPasteRequested != null) {
                    i = 0;
                    addMenuItem$ui_release(menu, MenuItemOption.Paste);
                }
                if (this.onCutRequested != null) {
                    i = 0;
                    addMenuItem$ui_release(menu, MenuItemOption.Cut);
                }
                if (this.onSelectAllRequested != null) {
                    i = 0;
                    addMenuItem$ui_release(menu, MenuItemOption.SelectAll);
                }
                return 1;
            }
            int i2 = 0;
            IllegalArgumentException $i$a$RequireNotNullTextActionModeCallback$onCreateActionMode$2 = new IllegalArgumentException("onCreateActionMode requires a non-null mode".toString());
            throw $i$a$RequireNotNullTextActionModeCallback$onCreateActionMode$2;
        }
        int i4 = 0;
        IllegalArgumentException $i$a$RequireNotNullTextActionModeCallback$onCreateActionMode$1 = new IllegalArgumentException("onCreateActionMode requires a non-null menu".toString());
        throw $i$a$RequireNotNullTextActionModeCallback$onCreateActionMode$1;
    }

    public final void onDestroyActionMode() {
        final Function0 onActionModeDestroy = this.onActionModeDestroy;
        if (onActionModeDestroy != null) {
            onActionModeDestroy.invoke();
        }
    }

    public final boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        if (mode != null && menu == null) {
            if (menu == null) {
            }
            updateMenuItems$ui_release(menu);
            return 1;
        }
        return 0;
    }

    public final void setOnCopyRequested(Function0<Unit> <set-?>) {
        this.onCopyRequested = <set-?>;
    }

    public final void setOnCutRequested(Function0<Unit> <set-?>) {
        this.onCutRequested = <set-?>;
    }

    public final void setOnPasteRequested(Function0<Unit> <set-?>) {
        this.onPasteRequested = <set-?>;
    }

    public final void setOnSelectAllRequested(Function0<Unit> <set-?>) {
        this.onSelectAllRequested = <set-?>;
    }

    public final void setRect(Rect <set-?>) {
        this.rect = <set-?>;
    }

    public final void updateMenuItems$ui_release(Menu menu) {
        addOrRemoveMenuItem(menu, MenuItemOption.Copy, this.onCopyRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Paste, this.onPasteRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Cut, this.onCutRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.SelectAll, this.onSelectAllRequested);
    }
}
