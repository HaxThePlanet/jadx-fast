package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0001\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\u0008¢\u0006\u0002\u0010\u0008\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\u0008¨\u0006\u000b", d2 = {"getSpans", "", "T", "", "Landroid/text/Spanned;", "start", "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpannedStringKt {
    public static final <T> T[] getSpans(Spanned $this$getSpans, int start, int end) {
        final int i = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> obj = Object.class;
        Class<Object> obj2 = obj;
        return $this$getSpans.getSpans(start, end, obj);
    }

    public static Object[] getSpans$default(Spanned $this$getSpans_u24default, int start, int end, int i4, Object object5) {
        int obj2;
        int obj3;
        if (i4 & 1 != 0) {
            obj2 = 0;
        }
        if (i4 &= 2 != 0) {
            obj3 = $this$getSpans_u24default.length();
        }
        int obj4 = 0;
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> obj5 = Object.class;
        Class<Object> obj = obj5;
        return $this$getSpans_u24default.getSpans(obj2, obj3, obj5);
    }

    public static final Spanned toSpanned(java.lang.CharSequence $this$toSpanned) {
        final int i = 0;
        return (Spanned)SpannedString.valueOf($this$toSpanned);
    }
}
