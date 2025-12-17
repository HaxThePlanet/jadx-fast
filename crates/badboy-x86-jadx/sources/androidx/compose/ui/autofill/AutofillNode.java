package androidx.compose.ui.autofill;

import androidx.compose.ui.geometry.Rect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB7\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0008¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u001b\u001a\u00020\u0013H\u0016R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006\u001d", d2 = {"Landroidx/compose/ui/autofill/AutofillNode;", "", "autofillTypes", "", "Landroidx/compose/ui/autofill/AutofillType;", "boundingBox", "Landroidx/compose/ui/geometry/Rect;", "onFill", "Lkotlin/Function1;", "", "", "(Ljava/util/List;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)V", "getAutofillTypes", "()Ljava/util/List;", "getBoundingBox", "()Landroidx/compose/ui/geometry/Rect;", "setBoundingBox", "(Landroidx/compose/ui/geometry/Rect;)V", "id", "", "getId", "()I", "getOnFill", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AutofillNode {

    public static final int $stable = 8;
    public static final androidx.compose.ui.autofill.AutofillNode.Companion Companion;
    private static int previousId;
    private final List<androidx.compose.ui.autofill.AutofillType> autofillTypes;
    private Rect boundingBox;
    private final int id;
    private final Function1<String, Unit> onFill;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0005\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/compose/ui/autofill/AutofillNode$Companion;", "", "()V", "previousId", "", "generateId", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static final int access$generateId(androidx.compose.ui.autofill.AutofillNode.Companion $this) {
            return $this.generateId();
        }

        private final int generateId() {
            final int i = 0;
            final int i2 = 0;
            androidx.compose.ui.autofill.AutofillNode.Companion companion = AutofillNode.Companion;
            AutofillNode.access$setPreviousId$cp(i3++);
            return AutofillNode.access$getPreviousId$cp();
            synchronized (this) {
                i = 0;
                i2 = 0;
                companion = AutofillNode.Companion;
                AutofillNode.access$setPreviousId$cp(i3++);
                return AutofillNode.access$getPreviousId$cp();
            }
        }
    }
    static {
        AutofillNode.Companion companion = new AutofillNode.Companion(0);
        AutofillNode.Companion = companion;
        int i = 8;
    }

    public AutofillNode(List<? extends androidx.compose.ui.autofill.AutofillType> autofillTypes, Rect boundingBox, Function1<? super String, Unit> onFill) {
        super();
        this.autofillTypes = autofillTypes;
        this.boundingBox = boundingBox;
        this.onFill = onFill;
        this.id = AutofillNode.Companion.access$generateId(AutofillNode.Companion);
    }

    public AutofillNode(List list, Rect rect2, Function1 function13, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        List obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = CollectionsKt.emptyList();
        }
        obj2 = i4 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2, function13);
    }

    public static final int access$getPreviousId$cp() {
        return AutofillNode.previousId;
    }

    public static final void access$setPreviousId$cp(int <set-?>) {
        AutofillNode.previousId = <set-?>;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof AutofillNode) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.autofillTypes, obj.autofillTypes)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.boundingBox, obj2.boundingBox)) {
            return i2;
        }
        if (this.onFill != obj3.onFill) {
            return i2;
        }
        return i;
    }

    public final List<androidx.compose.ui.autofill.AutofillType> getAutofillTypes() {
        return this.autofillTypes;
    }

    public final Rect getBoundingBox() {
        return this.boundingBox;
    }

    public final int getId() {
        return this.id;
    }

    public final Function1<String, Unit> getOnFill() {
        return this.onFill;
    }

    public int hashCode() {
        int i2;
        int i;
        Rect boundingBox = this.boundingBox;
        if (boundingBox != null) {
            i2 = boundingBox.hashCode();
        } else {
            i2 = i;
        }
        Function1 onFill = this.onFill;
        if (onFill != null) {
            i = onFill.hashCode();
        }
        return result += i;
    }

    public final void setBoundingBox(Rect <set-?>) {
        this.boundingBox = <set-?>;
    }
}
