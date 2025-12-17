package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/text/input/internal/EditorInfoApi34;", "", "()V", "setHandwritingGestures", "", "editorInfo", "Landroid/view/inputmethod/EditorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class EditorInfoApi34 {

    public static final androidx.compose.foundation.text.input.internal.EditorInfoApi34 INSTANCE;
    static {
        EditorInfoApi34 editorInfoApi34 = new EditorInfoApi34();
        EditorInfoApi34.INSTANCE = editorInfoApi34;
    }

    public final void setHandwritingGestures(EditorInfo editorInfo) {
        Class[] arr = new Class[7];
        final int i4 = 0;
        arr[i4] = SelectGesture.class;
        final int i5 = 1;
        arr[i5] = DeleteGesture.class;
        final int i6 = 2;
        arr[i6] = SelectRangeGesture.class;
        final int i7 = 3;
        arr[i7] = DeleteRangeGesture.class;
        final int i8 = 4;
        arr[i8] = JoinOrSplitGesture.class;
        arr[5] = InsertGesture.class;
        arr[6] = RemoveSpaceGesture.class;
        editorInfo.setSupportedHandwritingGestures(CollectionsKt.listOf(arr));
        Class[] arr2 = new Class[i8];
        arr2[i4] = SelectGesture.class;
        arr2[i5] = DeleteGesture.class;
        arr2[i6] = SelectRangeGesture.class;
        arr2[i7] = DeleteRangeGesture.class;
        editorInfo.setSupportedHandwritingGesturePreviews(SetsKt.setOf(arr2));
    }
}
