package zendesk.support.request;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import d.n.a.a.b;
import d.n.a.a.c;
import f.g.d.a;
import f.g.d.c;
import f.g.d.d;
import f.g.d.f;
import f.g.d.g;
import f.g.d.h;
import f.g.e.g;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import zendesk.belvedere.e;
import zendesk.belvedere.p;
import zendesk.support.UiUtils;

/* loaded from: classes3.dex */
class ViewMessageComposer extends FrameLayout implements View.OnClickListener, View.OnFocusChangeListener, View.OnLayoutChangeListener, TextView.OnEditorActionListener, TextWatcher {

    private static final String LOG_TAG = "ViewMessageComposer";
    private zendesk.support.request.ViewAttachmentsIndicator attachmentsIndicator;
    private AnimatorSet attachmentsOffCollapseAnimatorSet;
    private AnimatorSet attachmentsOffExpandAnimatorSet;
    private AnimatorSet attachmentsOnCollapseAnimatorSet;
    private AnimatorSet attachmentsOnExpandAnimatorSet;
    private e imageStream;
    private List<zendesk.support.request.ViewMessageComposer.InputListener> inputListenerList;
    private EditText inputTextField;
    private boolean isAttachmentsButtonDisabled = true;
    private boolean isSendButtonDisabled = true;
    private List<View.OnFocusChangeListener> onFocusChangeListenerList;
    private zendesk.support.request.ViewMessageComposer.OnHeightChangeListener onHeightChangeListener;
    private ImageView sendButton;
    private zendesk.support.request.ViewMessageComposer.MessageComposerStateHelper stateHelper;

    interface InputListener {
        public abstract void onAddAttachmentsRequested();

        public abstract void onSendMessageRequested(String string);
    }

    static class MessageComposerState {

        static final int BUTTON_DISABLED = 11;
        static final int BUTTON_ENABLED = 12;
        static final int BUTTON_HIDDEN = 10;
        static final int FIELD_COLLAPSED = 2;
        static final int FIELD_EXPANDED = 1;
        private final int attachmentButtonState;
        private final int fieldState;
        private final int sendButtonState;
        MessageComposerState(int i, int i2, int i3) {
            super();
            this.fieldState = i;
            this.sendButtonState = i2;
            this.attachmentButtonState = i3;
        }

        int getFieldState() {
            return this.fieldState;
        }

        int getSendButtonState() {
            return this.sendButtonState;
        }

        boolean isAttachmentButtonActivated() {
            int i;
            i = this.attachmentButtonState == 12 ? 1 : 0;
            return i;
        }

        boolean isAttachmentButtonEnabled() {
            int i;
            i = this.attachmentButtonState != 10 ? 1 : 0;
            return i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MessageComposerState{fieldState=");
            stringBuilder.append(this.fieldState);
            stringBuilder.append(", sendButtonState=");
            stringBuilder.append(this.sendButtonState);
            stringBuilder.append(", attachmentButtonEnabled=");
            stringBuilder.append(this.attachmentButtonState);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static class MessageComposerStateHelper {
        private boolean hasAttachments(zendesk.support.request.ViewAttachmentsIndicator viewAttachmentsIndicator) {
            int obj1;
            obj1 = viewAttachmentsIndicator.getAttachmentsCount() > 0 ? 1 : 0;
            return obj1;
        }

        private boolean hasLength(String string) {
            int obj1;
            if (string != null && string.length() > 0) {
                obj1 = string.length() > 0 ? 1 : 0;
            } else {
            }
            return obj1;
        }

        private boolean hasValidText(String string) {
            return g.c(string);
        }

        int getAttachmentButtonState(boolean z, boolean z2) {
            if (z) {
                return 10;
            }
            if (z2) {
                return 12;
            }
            return 11;
        }

        int getFieldState(boolean z, boolean z2, boolean z3, boolean z4) {
            if (!z && !z2 && !z4 && !z3) {
                if (!z2) {
                    if (!z4) {
                        if (!z3) {
                            return 2;
                        }
                    }
                }
            }
            return 1;
        }

        int getSendButtonState(boolean z, boolean z2, boolean z3, int i4) {
            if (!z2) {
                if (z3 && !z) {
                    if (!z) {
                    } else {
                        if (i4 == 1) {
                            return 11;
                        }
                    }
                } else {
                }
                return 10;
            }
            return 12;
        }

        zendesk.support.request.ViewMessageComposer.MessageComposerState getState(EditText editText, EditText editText2, zendesk.support.request.ViewAttachmentsIndicator viewAttachmentsIndicator3, boolean z4, boolean z5, boolean z6) {
            String string = editText.getText().toString();
            boolean obj5 = hasAttachments(viewAttachmentsIndicator3);
            int obj3 = getFieldState(editText.hasFocus(), hasLength(string), editText2.hasFocus(), obj5);
            ViewMessageComposer.MessageComposerState obj6 = new ViewMessageComposer.MessageComposerState(obj3, getSendButtonState(z5, hasValidText(string), obj5, obj3), getAttachmentButtonState(z6, z4));
            return obj6;
        }

        zendesk.support.request.ViewMessageComposer.MessageComposerState onAttachmentClicked(boolean z, boolean z2, EditText editText3, EditText editText4, zendesk.support.request.ViewAttachmentsIndicator viewAttachmentsIndicator5) {
            int obj8;
            obj8 = this.getState(editText3, editText4, viewAttachmentsIndicator5, true, z, z2);
            if (obj8.getSendButtonState() == 10) {
                obj8 = 11;
            } else {
                obj8 = obj8.getSendButtonState();
            }
            int obj10 = 1;
            ViewMessageComposer.MessageComposerState obj11 = new ViewMessageComposer.MessageComposerState(obj10, obj8, getAttachmentButtonState(z2, obj10));
            return obj11;
        }
    }

    interface OnHeightChangeListener {
        public abstract void onHeightChange(int i);
    }
    public ViewMessageComposer(Context context) {
        super(context);
        LinkedList linkedList = new LinkedList();
        this.onFocusChangeListenerList = linkedList;
        LinkedList linkedList2 = new LinkedList();
        this.inputListenerList = linkedList2;
        int i = 1;
        viewInit(context);
    }

    public ViewMessageComposer(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        LinkedList obj2 = new LinkedList();
        this.onFocusChangeListenerList = obj2;
        obj2 = new LinkedList();
        this.inputListenerList = obj2;
        obj2 = 1;
        viewInit(context);
    }

    public ViewMessageComposer(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        LinkedList obj2 = new LinkedList();
        this.onFocusChangeListenerList = obj2;
        obj2 = new LinkedList();
        this.inputListenerList = obj2;
        obj2 = 1;
        viewInit(context);
    }

    public ViewMessageComposer(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
        LinkedList obj2 = new LinkedList();
        this.onFocusChangeListenerList = obj2;
        obj2 = new LinkedList();
        this.inputListenerList = obj2;
        obj2 = 1;
        viewInit(context);
    }

    ViewMessageComposer(Context context, zendesk.support.request.ViewAttachmentsIndicator viewAttachmentsIndicator2, EditText editText3, ImageView imageView4, AnimatorSet animatorSet5, AnimatorSet animatorSet6, AnimatorSet animatorSet7, AnimatorSet animatorSet8) {
        super(context);
        LinkedList obj1 = new LinkedList();
        this.onFocusChangeListenerList = obj1;
        obj1 = new LinkedList();
        this.inputListenerList = obj1;
        obj1 = 1;
        this.attachmentsIndicator = viewAttachmentsIndicator2;
        this.inputTextField = editText3;
        this.sendButton = imageView4;
        this.attachmentsOnExpandAnimatorSet = animatorSet5;
        this.attachmentsOffExpandAnimatorSet = animatorSet7;
        this.attachmentsOnCollapseAnimatorSet = animatorSet6;
        this.attachmentsOffCollapseAnimatorSet = animatorSet8;
        obj1 = new ViewMessageComposer.MessageComposerStateHelper();
        this.stateHelper = obj1;
    }

    private void applyState(zendesk.support.request.ViewMessageComposer.MessageComposerState viewMessageComposer$MessageComposerState) {
        AnimatorSet attachmentsOffExpandAnimatorSet;
        int sendButtonState;
        int attachmentsIndicator;
        boolean attachmentButtonEnabled;
        int fieldState;
        int attachmentButtonActivated;
        int i2;
        int i3;
        int i;
        boolean obj5;
        attachmentButtonActivated = 1;
        if (messageComposerState.getFieldState() == attachmentButtonActivated && !isExpanded()) {
            if (!isExpanded()) {
                if (this.isAttachmentsButtonDisabled) {
                    this.attachmentsOffExpandAnimatorSet.start();
                } else {
                    this.attachmentsOnExpandAnimatorSet.start();
                }
            } else {
                if (messageComposerState.getFieldState() == 2 && isExpanded()) {
                    if (isExpanded()) {
                        if (this.isAttachmentsButtonDisabled) {
                            this.attachmentsOffCollapseAnimatorSet.start();
                        } else {
                            this.attachmentsOnCollapseAnimatorSet.start();
                        }
                    }
                }
            }
        } else {
        }
        i = 0;
        if (messageComposerState.getSendButtonState() == 10) {
            updateSendBtn(i, i);
        } else {
            if (messageComposerState.getSendButtonState() == 11) {
                updateSendBtn(attachmentButtonActivated, i);
            } else {
                if (messageComposerState.getSendButtonState() == 12) {
                    updateSendBtn(attachmentButtonActivated, attachmentButtonActivated);
                }
            }
        }
        if (messageComposerState.isAttachmentButtonEnabled()) {
        } else {
            i = 8;
        }
        if (this.attachmentsIndicator.getVisibility() != i) {
            updateAttachmentButtonPosition();
            this.attachmentsIndicator.setVisibility(i);
        }
        if (messageComposerState.isAttachmentButtonEnabled() && this.attachmentsIndicator.getAttachmentsCount() == 0) {
            if (this.attachmentsIndicator.getAttachmentsCount() == 0) {
                this.attachmentsIndicator.enableActiveState(messageComposerState.isAttachmentButtonActivated());
                this.attachmentsIndicator.setBottomBorderVisible(messageComposerState.isAttachmentButtonActivated());
            }
        }
    }

    private void bindViews() {
        this.inputTextField = (EditText)findViewById(f.u);
        this.attachmentsIndicator = (ViewAttachmentsIndicator)findViewById(f.t);
        this.sendButton = (ImageView)findViewById(f.v);
    }

    private void initAnimationsAndAdjustLeftMargin() {
        Resources resources = getResources();
        int integer = resources.getInteger(g.c);
        int dimensionPixelSize = resources.getDimensionPixelSize(d.e);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(d.i);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(d.j);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(d.f);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(d.k);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(d.g);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(d.h);
        AnimatorSet animatorSet = new AnimatorSet();
        this.attachmentsOnExpandAnimatorSet = animatorSet;
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.attachmentsOffExpandAnimatorSet = animatorSet2;
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.attachmentsOnCollapseAnimatorSet = animatorSet3;
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.attachmentsOffCollapseAnimatorSet = animatorSet4;
        c cVar = new c();
        b bVar = new b();
        this.attachmentsOnExpandAnimatorSet.setInterpolator(cVar);
        this.attachmentsOffExpandAnimatorSet.setInterpolator(cVar);
        this.attachmentsOnCollapseAnimatorSet.setInterpolator(bVar);
        this.attachmentsOffCollapseAnimatorSet.setInterpolator(bVar);
        int i9 = 0;
        this.attachmentsOnExpandAnimatorSet.play(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize, dimensionPixelSize2, integer)).with(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize4, dimensionPixelSize3, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize6, dimensionPixelSize5, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, i9, dimensionPixelOffset, integer));
        this.attachmentsOnCollapseAnimatorSet.play(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize3, dimensionPixelSize4, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize5, dimensionPixelSize6, integer)).with(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize2, dimensionPixelSize, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, dimensionPixelOffset, i9, integer));
        this.attachmentsOffExpandAnimatorSet.play(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize, dimensionPixelSize2, integer)).with(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize3, dimensionPixelSize3, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize6, dimensionPixelSize5, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, i9, dimensionPixelOffset, integer));
        this.attachmentsOffCollapseAnimatorSet.play(UtilsAnimation.sideMarginsAnimator(this.inputTextField, dimensionPixelSize3, dimensionPixelSize3, integer)).with(UtilsAnimation.topPaddingAnimator(this.inputTextField, dimensionPixelSize5, dimensionPixelSize6, integer)).with(UtilsAnimation.minHeightAnimator(this.inputTextField, dimensionPixelSize2, dimensionPixelSize, integer)).with(UtilsAnimation.bottomPaddingAnimator(this.inputTextField, dimensionPixelOffset, i9, integer));
        updateAttachmentButtonPosition();
    }

    private void initListener() {
        this.attachmentsIndicator.setOnClickListener(this);
        this.sendButton.setOnClickListener(this);
        this.inputTextField.addTextChangedListener(this);
        this.inputTextField.setOnEditorActionListener(this);
        this.inputTextField.setOnFocusChangeListener(this);
        addOnLayoutChangeListener(this);
    }

    private boolean isExpanded() {
        int i;
        i = this.inputTextField.getHeight() > this.inputTextField.getResources().getDimensionPixelSize(d.e) ? 1 : 0;
        return i;
    }

    private void notifyAddAttachmentsRequested() {
        Object next;
        Iterator iterator = this.inputListenerList.iterator();
        for (ViewMessageComposer.InputListener next : iterator) {
            next.onAddAttachmentsRequested();
        }
    }

    private void notifyOnFocusChangeListeners(View view, boolean z2) {
        Object next;
        Iterator iterator = this.onFocusChangeListenerList.iterator();
        for (View.OnFocusChangeListener next : iterator) {
            next.onFocusChange(view, z2);
        }
    }

    private void notifySendMessageRequested(String string) {
        Object next;
        Iterator iterator = this.inputListenerList.iterator();
        for (ViewMessageComposer.InputListener next : iterator) {
            next.onSendMessageRequested(string);
        }
    }

    private void updateAttachmentButtonPosition() {
        int dimensionPixelSize;
        Resources resources = getResources();
        dimensionPixelSize = resources.getDimensionPixelSize(d.j);
        android.view.ViewGroup.LayoutParams layoutParams = this.inputTextField.getLayoutParams();
        if (this.isAttachmentsButtonDisabled) {
        } else {
            dimensionPixelSize = dimensionPixelSize2;
        }
        layoutParams.leftMargin = dimensionPixelSize;
        this.inputTextField.setLayoutParams((FrameLayout.LayoutParams)layoutParams);
    }

    private void updateSendBtn(boolean z, boolean z2) {
        int themeAttributeToColor;
        int i2;
        int i;
        int i3;
        int obj5;
        Context context = getContext();
        if (z2) {
            themeAttributeToColor = UiUtils.themeAttributeToColor(a.b, context, c.A);
        } else {
            themeAttributeToColor = UiUtils.resolveColor(c.E, context);
        }
        if (z && z2) {
            obj5 = z2 ? 1 : i3;
        } else {
        }
        this.sendButton.setEnabled(obj5);
        if (z) {
        } else {
            i3 = 4;
        }
        this.sendButton.setVisibility(i3);
        UiUtils.setTint(themeAttributeToColor, this.sendButton.getDrawable(), this.sendButton);
    }

    private void viewInit(Context context) {
        FrameLayout.inflate(context, h.u, this);
        if (isInEditMode()) {
        }
        bindViews();
        initListener();
        initAnimationsAndAdjustLeftMargin();
        ViewMessageComposer.MessageComposerStateHelper obj2 = new ViewMessageComposer.MessageComposerStateHelper();
        this.stateHelper = obj2;
    }

    @Override // android.widget.FrameLayout
    public void addListener(zendesk.support.request.ViewMessageComposer.InputListener viewMessageComposer$InputListener) {
        this.inputListenerList.add(inputListener);
    }

    @Override // android.widget.FrameLayout
    public void addOnFocusChangeListener(View.OnFocusChangeListener view$OnFocusChangeListener) {
        this.onFocusChangeListenerList.add(onFocusChangeListener);
    }

    @Override // android.widget.FrameLayout
    public void afterTextChanged(Editable editable) {
        triggerStateUpdate();
    }

    @Override // android.widget.FrameLayout
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
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
    void enableAttachmentsButton(boolean z) {
        this.isAttachmentsButtonDisabled = z ^= 1;
        triggerStateUpdate();
    }

    @Override // android.widget.FrameLayout
    void enableSendButton(boolean z) {
        this.isSendButtonDisabled = z ^= 1;
        triggerStateUpdate();
    }

    @Override // android.widget.FrameLayout
    public String getMessage() {
        return this.inputTextField.getText().toString();
    }

    @Override // android.widget.FrameLayout
    public void hide(boolean z) {
        zendesk.support.request.ViewMessageComposer.OnHeightChangeListener obj2;
        final int i = 0;
        if (z != null) {
            setVisibility(8);
            this.onHeightChangeListener.onHeightChange(i);
        } else {
            setVisibility(i);
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout
    public void init(e e) {
        this.imageStream = e;
        triggerStateUpdate();
    }

    @Override // android.widget.FrameLayout
    public void onClick(View view) {
        int attachmentsIndicator2;
        int str;
        zendesk.support.request.ViewMessageComposer.MessageComposerStateHelper stateHelper;
        boolean isSendButtonDisabled;
        boolean isAttachmentsButtonDisabled;
        EditText inputTextField;
        EditText inputTrap;
        zendesk.support.request.ViewAttachmentsIndicator attachmentsIndicator;
        zendesk.support.request.ViewMessageComposer.MessageComposerState obj9;
        if (view.getId() == this.attachmentsIndicator.getId()) {
            applyState(this.stateHelper.onAttachmentClicked(this.isSendButtonDisabled, this.isAttachmentsButtonDisabled, this.inputTextField, this.imageStream.E1().getInputTrap(), this.attachmentsIndicator));
            notifyAddAttachmentsRequested();
        } else {
            if (view.getId() == this.sendButton.getId()) {
                this.inputTextField.setText("");
                this.attachmentsIndicator.reset();
                triggerStateUpdate();
                notifySendMessageRequested(this.inputTextField.getText().toString().trim());
            }
        }
    }

    @Override // android.widget.FrameLayout
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent3) {
        int obj1;
        if (textView.getId() == this.inputTextField.getId() && i2 == 6) {
            if (i2 == 6) {
                this.inputTextField.clearFocus();
                UiUtils.dismissKeyboard(this.inputTextField);
                triggerStateUpdate();
            }
        }
        return 0;
    }

    @Override // android.widget.FrameLayout
    public void onFocusChange(View view, boolean z2) {
        if (view.getId() == this.inputTextField.getId()) {
            notifyOnFocusChangeListeners(view, z2);
            triggerStateUpdate();
        }
    }

    @Override // android.widget.FrameLayout
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        zendesk.support.request.ViewMessageComposer.OnHeightChangeListener obj1;
        i5 -= i3;
        obj1 = this.onHeightChangeListener;
        if (obj5 != i9 -= i7 && obj1 != null) {
            obj1 = this.onHeightChangeListener;
            if (obj1 != null) {
                obj1.onHeightChange(obj5);
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.widget.FrameLayout
    public void removeAllListener() {
        this.inputListenerList.clear();
    }

    @Override // android.widget.FrameLayout
    public void requestFocusForInput() {
        this.inputTextField.requestFocus();
    }

    @Override // android.widget.FrameLayout
    public void setAttachmentsCount(int i) {
        this.attachmentsIndicator.setAttachmentsCount(i);
        triggerStateUpdate();
    }

    @Override // android.widget.FrameLayout
    public void setOnHeightChangeListener(zendesk.support.request.ViewMessageComposer.OnHeightChangeListener viewMessageComposer$OnHeightChangeListener) {
        this.onHeightChangeListener = onHeightChangeListener;
    }

    @Override // android.widget.FrameLayout
    void triggerStateUpdate() {
        e imageStream = this.imageStream;
        if (imageStream == null) {
        }
        applyState(this.stateHelper.getState(this.inputTextField, imageStream.E1().getInputTrap(), this.attachmentsIndicator, this.imageStream.G1(), this.isSendButtonDisabled, this.isAttachmentsButtonDisabled));
    }
}
