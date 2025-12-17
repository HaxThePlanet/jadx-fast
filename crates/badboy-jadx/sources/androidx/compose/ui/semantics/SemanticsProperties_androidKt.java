package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\"5\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018G@GX\u0087\u008e\u0002¢\u0006\u0018\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000b*\u0004\u0008\u0006\u0010\u0007¨\u0006\u000c", d2 = {"<set-?>", "", "testTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getTestTagsAsResourceId$annotations", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "getTestTagsAsResourceId$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", "setTestTagsAsResourceId", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Z)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SemanticsProperties_androidKt {

    static final KProperty<Object>[] $$delegatedProperties;
    static {
        int i = 1;
        final KProperty[] arr = new KProperty[i];
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(SemanticsProperties_androidKt.class, "testTagsAsResourceId", "getTestTagsAsResourceId(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", i);
        arr[0] = Reflection.mutableProperty1((MutablePropertyReference1)mutablePropertyReference1Impl);
        SemanticsProperties_androidKt.$$delegatedProperties = arr;
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();
    }

    public static final boolean getTestTagsAsResourceId(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$testTagsAsResourceId) {
        return (Boolean)SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().getValue($this$testTagsAsResourceId, SemanticsProperties_androidKt.$$delegatedProperties[0]).booleanValue();
    }

    public static void getTestTagsAsResourceId$annotations(androidx.compose.ui.semantics.SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    private static Object getTestTagsAsResourceId$delegate(androidx.compose.ui.semantics.SemanticsPropertyReceiver <this>) {
        return SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId();
    }

    public static final void setTestTagsAsResourceId(androidx.compose.ui.semantics.SemanticsPropertyReceiver $this$testTagsAsResourceId, boolean <set-?>) {
        SemanticsPropertiesAndroid.INSTANCE.getTestTagsAsResourceId().setValue($this$testTagsAsResourceId, SemanticsProperties_androidKt.$$delegatedProperties[0], Boolean.valueOf(<set-?>));
    }
}
