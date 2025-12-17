package androidx.compose.ui.semantics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertiesAndroid;", "", "()V", "TestTagsAsResourceId", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "getTestTagsAsResourceId$annotations", "getTestTagsAsResourceId", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsPropertiesAndroid {

    public static final int $stable = 8;
    public static final androidx.compose.ui.semantics.SemanticsPropertiesAndroid INSTANCE;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> TestTagsAsResourceId;
    static {
        SemanticsPropertiesAndroid semanticsPropertiesAndroid = new SemanticsPropertiesAndroid();
        SemanticsPropertiesAndroid.INSTANCE = semanticsPropertiesAndroid;
        SemanticsPropertyKey semanticsPropertyKey = new SemanticsPropertyKey("TestTagsAsResourceId", 0, (Function2)SemanticsPropertiesAndroid.TestTagsAsResourceId.1.INSTANCE);
        SemanticsPropertiesAndroid.TestTagsAsResourceId = semanticsPropertyKey;
        int i = 8;
    }

    public static void getTestTagsAsResourceId$annotations() {
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> getTestTagsAsResourceId() {
        return SemanticsPropertiesAndroid.TestTagsAsResourceId;
    }
}
