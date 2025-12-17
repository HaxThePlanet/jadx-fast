package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0000¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0010", d2 = {"Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;", "", "resolveResult", "Landroidx/compose/runtime/State;", "next", "(Landroidx/compose/runtime/State;Landroidx/compose/ui/text/platform/TypefaceDirtyTrackerLinkedList;)V", "initial", "getInitial", "()Ljava/lang/Object;", "isStaleResolvedFont", "", "()Z", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class TypefaceDirtyTrackerLinkedList {

    private final Object initial;
    private final androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList next;
    private final State<Object> resolveResult;
    public TypefaceDirtyTrackerLinkedList(State<? extends Object> resolveResult, androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList next) {
        super();
        this.resolveResult = resolveResult;
        this.next = next;
        this.initial = this.resolveResult.getValue();
    }

    public TypefaceDirtyTrackerLinkedList(State state, androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(state, obj2);
    }

    public final Object getInitial() {
        return this.initial;
    }

    public final Typeface getTypeface() {
        final Object initial = this.initial;
        Intrinsics.checkNotNull(initial, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface)initial;
    }

    public final boolean isStaleResolvedFont() {
        androidx.compose.ui.text.platform.TypefaceDirtyTrackerLinkedList staleResolvedFont;
        int i;
        if (this.resolveResult.getValue() == this.initial) {
            if (this.next != null && this.next.isStaleResolvedFont()) {
                if (this.next.isStaleResolvedFont()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
