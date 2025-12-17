package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0019\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000e\u001a\u00020\u00032\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0006H\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0013", d2 = {"Landroidx/compose/ui/semantics/AccessibilityAction;", "T", "Lkotlin/Function;", "", "", "label", "", "action", "(Ljava/lang/String;Lkotlin/Function;)V", "getAction", "()Lkotlin/Function;", "Lkotlin/Function;", "getLabel", "()Ljava/lang/String;", "equals", "other", "hashCode", "", "toString", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AccessibilityAction<T extends kotlin.Function<? extends Boolean>>  {

    public static final int $stable;
    private final T action;
    private final String label;
    static {
    }

    public AccessibilityAction(String label, T action) {
        super();
        this.label = label;
        this.action = action;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof AccessibilityAction) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.label, obj.label)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.action, obj2.action)) {
            return i2;
        }
        return i;
    }

    public final T getAction() {
        return this.action;
    }

    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        int i;
        int i2;
        String label = this.label;
        if (label != null) {
            i = label.hashCode();
        } else {
            i = i2;
        }
        final kotlin.Function action = this.action;
        if (action != null) {
            i2 = action.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AccessibilityAction(label=").append(this.label).append(", action=").append(this.action).append(')').toString();
    }
}
