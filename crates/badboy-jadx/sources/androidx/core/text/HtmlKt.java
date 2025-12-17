package androidx.core.text;

import android.text.Html.ImageGetter;
import android.text.Html.TagHandler;
import android.text.Spanned;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0086\u0008\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0004H\u0086\u0008¨\u0006\u000b", d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HtmlKt {
    public static final Spanned parseAsHtml(String $this$parseAsHtml, int flags, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        final int i = 0;
        return HtmlCompat.fromHtml($this$parseAsHtml, flags, imageGetter, tagHandler);
    }

    public static Spanned parseAsHtml$default(String $this$parseAsHtml_u24default, int flags, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i5, Object object6) {
        int obj1;
        int obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = 0;
        }
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        int obj4 = 0;
        return HtmlCompat.fromHtml($this$parseAsHtml_u24default, obj1, obj2, obj3);
    }

    public static final String toHtml(Spanned $this$toHtml, int option) {
        final int i = 0;
        return HtmlCompat.toHtml($this$toHtml, option);
    }

    public static String toHtml$default(Spanned $this$toHtml_u24default, int option, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        int obj2 = 0;
        return HtmlCompat.toHtml($this$toHtml_u24default, obj1);
    }
}
