package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0006\u001a\u00020\u0007H&JX\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0010\u0008\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000c2\u0010\u0008\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000c2\u0010\u0008\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000c2\u0010\u0008\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000cH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0010À\u0006\u0003", d2 = {"Landroidx/compose/ui/platform/TextToolbar;", "", "status", "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "hide", "", "showMenu", "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TextToolbar {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void showMenu$default(androidx.compose.ui.platform.TextToolbar textToolbar, Rect rect2, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i7, Object object8) {
            TextToolbar.showMenu$default(textToolbar, rect2, function03, function04, function05, function06, i7, object8);
        }
    }
    public static void showMenu$default(androidx.compose.ui.platform.TextToolbar textToolbar, Rect rect2, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i7, Object object8) {
        int obj3;
        int obj4;
        int obj5;
        int obj6;
        if (object8 != null) {
        } else {
            final int i = 0;
            if (i7 & 2 != 0) {
                obj3 = i;
            }
            if (i7 & 4 != 0) {
                obj4 = i;
            }
            if (i7 & 8 != 0) {
                obj5 = i;
            }
            if (i7 &= 16 != 0) {
                obj6 = i;
            }
            textToolbar.showMenu(rect2, obj3, obj4, obj5, obj6);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
        throw obj1;
    }

    public abstract androidx.compose.ui.platform.TextToolbarStatus getStatus();

    public abstract void hide();

    public abstract void showMenu(Rect rect, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05);
}
