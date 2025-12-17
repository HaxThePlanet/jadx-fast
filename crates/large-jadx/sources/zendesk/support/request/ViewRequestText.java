package zendesk.support.request;

import android.content.Context;
import android.text.Selection;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
class ViewRequestText extends AppCompatTextView {
    public ViewRequestText(Context context) {
        super(context);
        init();
    }

    public ViewRequestText(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    public ViewRequestText(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        init();
    }

    private void init() {
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        java.lang.CharSequence selectionStart;
        int selectionEnd;
        selectionStart = getSelectionStart();
        selectionEnd = getSelectionEnd();
        if (selectionStart >= 0) {
            if (selectionEnd < 0) {
                Selection.setSelection((Spannable)getText(), getText().length());
            } else {
                if (selectionStart != selectionEnd && motionEvent.getActionMasked() == 0) {
                    if (motionEvent.getActionMasked() == 0) {
                        setText(0);
                        setText(getText());
                    }
                }
            }
        } else {
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
