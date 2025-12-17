package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.commonui.c;
import zendesk.commonui.d;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class InputBox extends FrameLayout {

    private zendesk.messaging.ui.AttachmentsIndicator attachmentsIndicator;
    private View.OnClickListener attachmentsIndicatorClickListener;
    private FrameLayout inputBox;
    private zendesk.messaging.ui.InputBox.InputTextConsumer inputTextConsumer;
    private EditText inputTextField;
    private TextWatcher inputTextWatcher;
    private ImageView sendButton;
    private final List<View.OnClickListener> sendButtonClickListeners;

    public interface InputTextConsumer {
        public abstract boolean onConsumeText(String string);
    }
    public InputBox(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        ArrayList obj2 = new ArrayList();
        this.sendButtonClickListeners = obj2;
        viewInit(context);
    }

    static EditText access$000(zendesk.messaging.ui.InputBox inputBox) {
        return inputBox.inputTextField;
    }

    static View.OnClickListener access$100(zendesk.messaging.ui.InputBox inputBox) {
        return inputBox.attachmentsIndicatorClickListener;
    }

    static zendesk.messaging.ui.InputBox.InputTextConsumer access$200(zendesk.messaging.ui.InputBox inputBox) {
        return inputBox.inputTextConsumer;
    }

    static zendesk.messaging.ui.AttachmentsIndicator access$300(zendesk.messaging.ui.InputBox inputBox) {
        return inputBox.attachmentsIndicator;
    }

    static List access$400(zendesk.messaging.ui.InputBox inputBox) {
        return inputBox.sendButtonClickListeners;
    }

    static void access$500(zendesk.messaging.ui.InputBox inputBox, boolean z2) {
        inputBox.updateSendBtn(z2);
    }

    static TextWatcher access$600(zendesk.messaging.ui.InputBox inputBox) {
        return inputBox.inputTextWatcher;
    }

    static FrameLayout access$700(zendesk.messaging.ui.InputBox inputBox) {
        return inputBox.inputBox;
    }

    private void bindViews() {
        this.inputBox = (FrameLayout)findViewById(R.id.zui_view_input_box);
        this.inputTextField = (EditText)findViewById(R.id.input_box_input_text);
        this.attachmentsIndicator = (AttachmentsIndicator)findViewById(R.id.input_box_attachments_indicator);
        this.sendButton = (ImageView)findViewById(R.id.input_box_send_btn);
    }

    private void initListeners() {
        InputBox.1 anon = new InputBox.1(this);
        this.inputBox.setOnClickListener(anon);
        InputBox.2 anon2 = new InputBox.2(this);
        this.attachmentsIndicator.setOnClickListener(anon2);
        InputBox.3 anon3 = new InputBox.3(this);
        this.sendButton.setOnClickListener(anon3);
        InputBox.4 anon4 = new InputBox.4(this);
        this.inputTextField.addTextChangedListener(anon4);
        InputBox.5 anon5 = new InputBox.5(this);
        this.inputTextField.setOnFocusChangeListener(anon5);
    }

    private void showAttachmentsIndicator(boolean z) {
        int i;
        zendesk.messaging.ui.AttachmentsIndicator obj3;
        final int i2 = 0;
        if (z) {
            i = 1;
            this.attachmentsIndicator.setEnabled(i);
            this.attachmentsIndicator.setVisibility(i2);
            updateInputFieldPosition(i);
        } else {
            this.attachmentsIndicator.setEnabled(i2);
            this.attachmentsIndicator.setVisibility(8);
            updateInputFieldPosition(i2);
        }
    }

    private void updateInputFieldPosition(boolean z) {
        int dimensionPixelSize;
        Resources resources = getResources();
        dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.zui_input_box_expanded_side_margin);
        android.view.ViewGroup.LayoutParams layoutParams = this.inputTextField.getLayoutParams();
        if (z) {
            dimensionPixelSize = dimensionPixelSize2;
        }
        layoutParams.leftMargin = dimensionPixelSize;
        this.inputTextField.setLayoutParams((FrameLayout.LayoutParams)layoutParams);
    }

    private void updateSendBtn(boolean z) {
        int i;
        int zui_color_disabled;
        int zui_color_primary;
        Context context = getContext();
        if (z) {
            i = d.e(R.attr.colorPrimary, context, R.color.zui_color_primary);
        } else {
            i = d.b(R.color.zui_color_disabled, context);
        }
        this.sendButton.setEnabled(z);
        d.c(i, this.sendButton.getDrawable(), this.sendButton);
    }

    private void viewInit(Context context) {
        FrameLayout.inflate(context, R.layout.zui_view_input_box, this);
        if (isInEditMode()) {
        }
        bindViews();
        initListeners();
        int obj2 = 0;
        showAttachmentsIndicator(obj2);
        updateSendBtn(obj2);
    }

    @Override // android.widget.FrameLayout
    public boolean addSendButtonClickListener(View.OnClickListener view$OnClickListener) {
        return this.sendButtonClickListeners.add(onClickListener);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        int inputTextField;
        if (keyEvent.getKeyCode() == 4) {
            this.inputTextField.clearFocus();
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.widget.FrameLayout
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int obj2;
        if (isEnabled()) {
            if (super.dispatchTouchEvent(motionEvent)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // android.widget.FrameLayout
    public boolean requestFocus(int i, Rect rect2) {
        return this.inputTextField.requestFocus();
    }

    @Override // android.widget.FrameLayout
    public void setAttachmentsCount(int i) {
        int i3;
        int i2;
        this.attachmentsIndicator.setAttachmentsCount(i);
        final int i4 = 0;
        i3 = this.attachmentsIndicator.getAttachmentsCount() > 0 ? i2 : i4;
        if (!g.c(this.inputTextField.getText().toString())) {
            if (i3 != 0) {
            } else {
                i2 = i4;
            }
        }
        updateSendBtn(i2);
    }

    @Override // android.widget.FrameLayout
    public void setAttachmentsIndicatorClickListener(View.OnClickListener view$OnClickListener) {
        int obj1;
        this.attachmentsIndicatorClickListener = onClickListener;
        obj1 = onClickListener != null ? 1 : 0;
        showAttachmentsIndicator(obj1);
    }

    @Override // android.widget.FrameLayout
    public void setEnabled(boolean z) {
        EditText inputTextField;
        int i;
        int i2;
        super.setEnabled(z);
        this.inputTextField.setEnabled(z);
        if (!z) {
            this.inputTextField.clearFocus();
        }
        this.inputBox.setEnabled(z);
        final int i3 = 1045220557;
        i2 = z ? i : i3;
        this.sendButton.setAlpha(i2);
        if (z) {
        } else {
            i = i3;
        }
        this.attachmentsIndicator.setAlpha(i);
    }

    @Override // android.widget.FrameLayout
    public void setHint(String string) {
        this.inputTextField.setHint(string);
    }

    @Override // android.widget.FrameLayout
    public void setInputTextConsumer(zendesk.messaging.ui.InputBox.InputTextConsumer inputBox$InputTextConsumer) {
        this.inputTextConsumer = inputTextConsumer;
    }

    @Override // android.widget.FrameLayout
    public void setInputTextWatcher(TextWatcher textWatcher) {
        this.inputTextWatcher = textWatcher;
    }

    @Override // android.widget.FrameLayout
    public void setInputType(Integer integer) {
        this.inputTextField.setInputType(integer.intValue());
    }
}
