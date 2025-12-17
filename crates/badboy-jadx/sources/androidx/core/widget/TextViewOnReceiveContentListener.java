package androidx.core.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* loaded from: classes5.dex */
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {

    private static final String LOG_TAG = "ReceiveContent";
    private static java.lang.CharSequence coerceToText(Context context, ClipData.Item item, int flags) {
        Object string;
        if (flags & 1 != 0) {
            java.lang.CharSequence coerceToText = item.coerceToText(context);
            if (coerceToText instanceof Spanned) {
                string = coerceToText.toString();
            } else {
                string = coerceToText;
            }
            return string;
        }
        return item.coerceToStyledText(context);
    }

    private static void replaceSelection(Editable editable, java.lang.CharSequence replacement) {
        final int selectionStart = Selection.getSelectionStart(editable);
        final int selectionEnd = Selection.getSelectionEnd(editable);
        int i3 = 0;
        int i4 = Math.max(i3, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, i4);
        editable.replace(Math.max(i3, Math.min(selectionStart, selectionEnd)), i4, replacement);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    public ContentInfoCompat onReceiveContent(View view, ContentInfoCompat payload) {
        boolean loggable;
        String str2;
        int didFirst;
        int i;
        java.lang.CharSequence coerceToText;
        int selectionEnd;
        String str;
        String str3 = "ReceiveContent";
        if (Log.isLoggable(str3, 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            Log.d(str3, stringBuilder.append("onReceive: ").append(payload).toString());
        }
        if (payload.getSource() == 2) {
            return payload;
        }
        ClipData clip = payload.getClip();
        final TextView view2 = view;
        final java.lang.CharSequence text = (TextView)view2.getText();
        didFirst = 0;
        i = 0;
        while (i < clip.getItemCount()) {
            coerceToText = TextViewOnReceiveContentListener.coerceToText(view2.getContext(), clip.getItemAt(i), payload.getFlags());
            if (coerceToText != null) {
            }
            i++;
            if (didFirst == 0) {
            } else {
            }
            text.insert(Selection.getSelectionEnd((Editable)text), "\n");
            text.insert(Selection.getSelectionEnd(text), coerceToText);
            TextViewOnReceiveContentListener.replaceSelection(text, coerceToText);
            didFirst = 1;
        }
        return null;
    }
}
