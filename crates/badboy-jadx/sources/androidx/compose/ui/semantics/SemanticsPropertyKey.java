package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0017\u0008\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B5\u0008\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001c\u0010\u0008\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t¢\u0006\u0002\u0010\nB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\u0008\u0002\u0010\u0008\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t¢\u0006\u0002\u0010\u000bJ\"\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u0017H\u0086\u0002¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00018\u00002\u0008\u0010\u001a\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ*\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u00172\u0006\u0010\u001f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010 J\u0008\u0010!\u001a\u00020\u0004H\u0016R\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0006@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR*\u0010\u0008\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\"", d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "", "name", "", "isImportantForAccessibility", "", "(Ljava/lang/String;Z)V", "mergePolicy", "Lkotlin/Function2;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "<set-?>", "isImportantForAccessibility$ui_release", "()Z", "getMergePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "getName", "()Ljava/lang/String;", "getValue", "thisRef", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "merge", "parentValue", "childValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsPropertyKey<T>  {

    public static final int $stable = 8;
    private boolean isImportantForAccessibility;
    private final Function2<T, T, T> mergePolicy;
    private final String name;
    static {
        final int i = 8;
    }

    public SemanticsPropertyKey(String name, Function2<? super T, ? super T, ? extends T> mergePolicy) {
        super();
        this.name = name;
        this.mergePolicy = mergePolicy;
    }

    public SemanticsPropertyKey(String string, Function2 function22, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.ui.semantics.SemanticsPropertyKey.1 obj2;
        if (i3 &= 2 != 0) {
            obj2 = SemanticsPropertyKey.1.INSTANCE;
        }
        super(string, obj2);
    }

    public SemanticsPropertyKey(String name, boolean isImportantForAccessibility) {
        final int i = 0;
        super(name, i, 2, i);
        this.isImportantForAccessibility = isImportantForAccessibility;
    }

    public SemanticsPropertyKey(String name, boolean isImportantForAccessibility, Function2<? super T, ? super T, ? extends T> mergePolicy) {
        super(name, mergePolicy);
        this.isImportantForAccessibility = isImportantForAccessibility;
    }

    public final Function2<T, T, T> getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    public final String getName() {
        return this.name;
    }

    public final T getValue(androidx.compose.ui.semantics.SemanticsPropertyReceiver thisRef, KProperty<?> property) {
        return SemanticsPropertiesKt.access$throwSemanticsGetNotSupported();
    }

    public final boolean isImportantForAccessibility$ui_release() {
        return this.isImportantForAccessibility;
    }

    public final T merge(T parentValue, T childValue) {
        return this.mergePolicy.invoke(parentValue, childValue);
    }

    public final void setValue(androidx.compose.ui.semantics.SemanticsPropertyReceiver thisRef, KProperty<?> property, T value) {
        thisRef.set(this, value);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AccessibilityKey: ").append(this.name).toString();
    }
}
