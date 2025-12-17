package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u0006H\u0000¨\u0006\t", d2 = {"toCharArray", "", "", "destination", "", "destinationOffset", "", "startIndex", "endIndex", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ToCharArray_androidKt {
    public static final void toCharArray(java.lang.CharSequence $this$toCharArray, char[] destination, int destinationOffset, int startIndex, int endIndex) {
        Object obj;
        int srcIndex;
        int i;
        char charAt;
        if ($this$toCharArray instanceof TextFieldCharSequence) {
            (TextFieldCharSequence)$this$toCharArray.toCharArray(destination, destinationOffset, startIndex, endIndex);
        } else {
            obj = destinationOffset;
            srcIndex = startIndex;
            while (srcIndex < endIndex) {
                destination[obj] = $this$toCharArray.charAt(srcIndex);
                srcIndex++;
                obj = i;
            }
        }
    }
}
