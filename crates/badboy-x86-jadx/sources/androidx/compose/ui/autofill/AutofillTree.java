package androidx.compose.ui.autofill;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0011", d2 = {"Landroidx/compose/ui/autofill/AutofillTree;", "", "()V", "children", "", "", "Landroidx/compose/ui/autofill/AutofillNode;", "getChildren", "()Ljava/util/Map;", "performAutofill", "", "id", "value", "", "(ILjava/lang/String;)Lkotlin/Unit;", "plusAssign", "autofillNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AutofillTree {

    public static final int $stable = 8;
    private final Map<Integer, androidx.compose.ui.autofill.AutofillNode> children;
    static {
        final int i = 8;
    }

    public AutofillTree() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.children = (Map)linkedHashMap;
    }

    public final Map<Integer, androidx.compose.ui.autofill.AutofillNode> getChildren() {
        return this.children;
    }

    public final Unit performAutofill(int id, String value) {
        Object onFill;
        int iNSTANCE;
        onFill = this.children.get(Integer.valueOf(id));
        onFill = (AutofillNode)onFill.getOnFill();
        if (onFill != null && onFill != null) {
            onFill = onFill.getOnFill();
            iNSTANCE = onFill != null ? Unit.INSTANCE : 0;
        } else {
        }
        return iNSTANCE;
    }

    public final void plusAssign(androidx.compose.ui.autofill.AutofillNode autofillNode) {
        this.children.put(Integer.valueOf(autofillNode.getId()), autofillNode);
    }
}
