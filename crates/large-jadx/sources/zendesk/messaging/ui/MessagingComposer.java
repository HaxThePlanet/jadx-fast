package zendesk.messaging.ui;

import android.app.Activity;
import android.text.Editable;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.d;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import f.g.e.g;
import java.util.List;
import zendesk.belvedere.e;
import zendesk.belvedere.e.b;
import zendesk.belvedere.p;
import zendesk.belvedere.s;
import zendesk.commonui.c;
import zendesk.messaging.AttachmentSettings;
import zendesk.messaging.BelvedereMediaHolder;
import zendesk.messaging.MessagingViewModel;
import zendesk.messaging.R.string;
import zendesk.messaging.TypingEventDispatcher;

/* loaded from: classes3.dex */
public class MessagingComposer {

    static final int DEFAULT_HINT;
    private final d activity;
    private final BelvedereMediaHolder belvedereMediaHolder;
    private zendesk.messaging.ui.MessagingComposer.BelvedereMediaPickerListener belvedereMediaPickerListener;
    private final e imageStream;
    private final zendesk.messaging.ui.InputBoxAttachmentClickListener inputBoxAttachmentClickListener;
    private final zendesk.messaging.ui.InputBoxConsumer inputBoxConsumer;
    private final TypingEventDispatcher typingEventDispatcher;
    private final MessagingViewModel viewModel;

    static final class BelvedereMediaPickerListener implements e.b {

        private final BelvedereMediaHolder belvedereMediaHolder;
        private final e imageStream;
        private final zendesk.messaging.ui.InputBox inputBox;
        BelvedereMediaPickerListener(BelvedereMediaHolder belvedereMediaHolder, zendesk.messaging.ui.InputBox inputBox2, e e3) {
            super();
            this.belvedereMediaHolder = belvedereMediaHolder;
            this.inputBox = inputBox2;
            this.imageStream = e3;
        }

        @Override // zendesk.belvedere.e$b
        public void onDismissed() {
            boolean inputBox;
            if (this.imageStream.E1().getInputTrap().hasFocus()) {
                this.inputBox.requestFocus();
            }
        }

        public void onMediaDeselected(List<s> list) {
            this.belvedereMediaHolder.removeAll(list);
            this.inputBox.setAttachmentsCount(this.belvedereMediaHolder.getSelectedMediaCount());
        }

        public void onMediaSelected(List<s> list) {
            this.belvedereMediaHolder.addAll(list);
            this.inputBox.setAttachmentsCount(this.belvedereMediaHolder.getSelectedMediaCount());
        }

        @Override // zendesk.belvedere.e$b
        public void onVisible() {
        }
    }
    static {
        MessagingComposer.DEFAULT_HINT = R.string.zui_hint_type_message;
    }

    public MessagingComposer(d d, MessagingViewModel messagingViewModel2, e e3, BelvedereMediaHolder belvedereMediaHolder4, zendesk.messaging.ui.InputBoxConsumer inputBoxConsumer5, zendesk.messaging.ui.InputBoxAttachmentClickListener inputBoxAttachmentClickListener6, TypingEventDispatcher typingEventDispatcher7) {
        super();
        this.activity = d;
        this.viewModel = messagingViewModel2;
        this.imageStream = e3;
        this.belvedereMediaHolder = belvedereMediaHolder4;
        this.inputBoxConsumer = inputBoxConsumer5;
        this.inputBoxAttachmentClickListener = inputBoxAttachmentClickListener6;
        this.typingEventDispatcher = typingEventDispatcher7;
    }

    static TypingEventDispatcher access$000(zendesk.messaging.ui.MessagingComposer messagingComposer) {
        return messagingComposer.typingEventDispatcher;
    }

    public void bind(zendesk.messaging.ui.InputBox inputBox) {
        inputBox.setInputTextConsumer(this.inputBoxConsumer);
        MessagingComposer.1 anon = new MessagingComposer.1(this);
        inputBox.setInputTextWatcher(anon);
        e imageStream = this.imageStream;
        MessagingComposer.BelvedereMediaPickerListener belvedereMediaPickerListener = new MessagingComposer.BelvedereMediaPickerListener(this.belvedereMediaHolder, inputBox, imageStream);
        this.belvedereMediaPickerListener = belvedereMediaPickerListener;
        imageStream.C1(belvedereMediaPickerListener);
        MessagingComposer.2 anon2 = new MessagingComposer.2(this, inputBox);
        this.viewModel.getLiveMessagingState().observe(this.activity, anon2);
    }

    void renderState(zendesk.messaging.ui.MessagingState messagingState, zendesk.messaging.ui.InputBox inputBox2) {
        String string;
        Integer valueOf;
        int dEFAULT_HINT;
        AttachmentSettings obj3;
        if (messagingState != null) {
            if (g.c(messagingState.hint)) {
                string = messagingState.hint;
            } else {
                string = this.activity.getString(MessagingComposer.DEFAULT_HINT);
            }
            inputBox2.setHint(string);
            inputBox2.setEnabled(messagingState.enabled);
            inputBox2.setInputType(Integer.valueOf(messagingState.keyboardInputType));
            obj3 = messagingState.attachmentSettings;
            if (obj3 != null && obj3.isSendingEnabled()) {
                if (obj3.isSendingEnabled()) {
                    inputBox2.setAttachmentsIndicatorClickListener(this.inputBoxAttachmentClickListener);
                    inputBox2.setAttachmentsCount(this.belvedereMediaHolder.getSelectedMediaCount());
                } else {
                    inputBox2.setAttachmentsIndicatorClickListener(0);
                }
            } else {
            }
        }
    }
}
