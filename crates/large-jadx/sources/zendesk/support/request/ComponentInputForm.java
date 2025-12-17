package zendesk.support.request;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.google.android.material.textfield.TextInputLayout;
import d.h.k.e;
import f.g.d.f;
import f.g.d.g;
import f.g.d.j;
import f.g.e.a;
import f.g.e.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.b.f;
import o.b.k;
import o.b.o;
import o.b.p;
import zendesk.belvedere.p.c;

/* loaded from: classes3.dex */
class ComponentInputForm implements k<zendesk.support.request.ComponentInputForm.InputFormModel>, zendesk.support.request.RequestViewConversationsDisabled.MenuItemsDelegate, p.c {

    private final zendesk.support.request.ActionFactory actionFactory;
    private final zendesk.support.request.AttachmentHelper attachmentHelper;
    private final f dispatcher;
    private final EditText emailField;
    private final TextInputLayout emailLayout;
    private final zendesk.support.request.ComponentInputForm.Validator<String> emailValidator;
    private boolean inlineValidation = false;
    private final View logo;
    private final EditText messageField;
    private final TextInputLayout messageLayout;
    private final EditText nameField;
    private final TextInputLayout nameLayout;
    private MenuItem sendButton;

    private static class EditTextTextWatcher implements TextWatcher {

        private final zendesk.support.request.ComponentInputForm componentInputForm;
        private EditTextTextWatcher(zendesk.support.request.ComponentInputForm componentInputForm) {
            super();
            this.componentInputForm = componentInputForm;
        }

        static void install(zendesk.support.request.ComponentInputForm componentInputForm, EditText... editText2Arr2) {
            int i;
            Object obj;
            zendesk.support.request.ComponentInputForm.EditTextTextWatcher editTextTextWatcher;
            i = 0;
            while (i < editText2Arr2.length) {
                editTextTextWatcher = new ComponentInputForm.EditTextTextWatcher(componentInputForm);
                editText2Arr2[i].addTextChangedListener(editTextTextWatcher);
                i++;
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
            boolean obj1;
            if (ComponentInputForm.access$300(this.componentInputForm)) {
                ComponentInputForm.access$100(this.componentInputForm);
            }
            ComponentInputForm.access$200(this.componentInputForm);
        }
    }

    private static class EmailFieldFocusListener implements View.OnFocusChangeListener {

        private final zendesk.support.request.ComponentInputForm componentInputForm;
        private final EditText editText;
        private EmailFieldFocusListener(zendesk.support.request.ComponentInputForm componentInputForm, EditText editText2) {
            super();
            this.componentInputForm = componentInputForm;
            this.editText = editText2;
        }

        static void install(zendesk.support.request.ComponentInputForm componentInputForm, EditText editText2) {
            ComponentInputForm.EmailFieldFocusListener emailFieldFocusListener = new ComponentInputForm.EmailFieldFocusListener(componentInputForm, editText2);
            editText2.setOnFocusChangeListener(emailFieldFocusListener);
        }

        @Override // android.view.View$OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            boolean obj1;
            if (!z2 && g.c(this.editText.getText().toString())) {
                if (g.c(this.editText.getText().toString())) {
                    ComponentInputForm.access$100(this.componentInputForm);
                    ComponentInputForm.access$200(this.componentInputForm);
                }
            }
        }
    }

    static class InputFormModel {

        private final boolean hasIdentityEmailAddress;
        private final boolean hasIdentityName;
        private final boolean isLoading;
        private final boolean neverRequestEmail;
        private final String referrerUrl;
        private final boolean showZendeskLogo;
        InputFormModel(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String string6) {
            super();
            this.neverRequestEmail = z;
            this.hasIdentityEmailAddress = z2;
            this.hasIdentityName = z3;
            this.isLoading = z4;
            this.showZendeskLogo = z5;
            this.referrerUrl = string6;
        }

        private boolean isEmailFieldEnabled() {
            boolean hasIdentityEmailAddress;
            int i;
            if (!this.hasIdentityEmailAddress && !this.neverRequestEmail) {
                i = !this.neverRequestEmail ? 1 : 0;
            } else {
            }
            return i;
        }

        private boolean isNameFieldEnabled() {
            return hasIdentityName ^= 1;
        }

        int getEmailFieldVisibility() {
            int i;
            i = isEmailFieldEnabled() ? 0 : 8;
            return i;
        }

        int getLogoVisibility() {
            int i;
            i = isLogoEnabled() ? 0 : 8;
            return i;
        }

        int getMessageFieldVisibility() {
            return 0;
        }

        int getNameFieldVisibility() {
            int i;
            i = isNameFieldEnabled() ? 0 : 8;
            return i;
        }

        String getReferrerUrl() {
            return this.referrerUrl;
        }

        public boolean isLoading() {
            return this.isLoading;
        }

        boolean isLogoEnabled() {
            return this.showZendeskLogo;
        }
    }

    interface Validator {
        public abstract boolean isValid(T t);
    }

    static class InputFormSelector implements p<zendesk.support.request.ComponentInputForm.InputFormModel> {
        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        @Override // o.b.p
        public zendesk.support.request.ComponentInputForm.InputFormModel selectData(o o) {
            int obj9;
            zendesk.support.request.StateSettings settings = StateConfig.fromState(o).getSettings();
            obj9 = StateProgress.fomState(o).getRunningRequests() > 0 ? 1 : 0;
            super(settings.isNeverRequestEmailOn(), settings.hasIdentityEmailAddress(), settings.hasIdentityName(), obj9, settings.isShowZendeskLogo(), settings.getReferrerUrl());
            return obj9;
        }
    }
    ComponentInputForm(View view, EditText editText2, TextInputLayout textInputLayout3, EditText editText4, TextInputLayout textInputLayout5, zendesk.support.request.ComponentInputForm.Validator<String> componentInputForm$Validator6, EditText editText7, TextInputLayout textInputLayout8, f f9, zendesk.support.request.ActionFactory actionFactory10, zendesk.support.request.AttachmentHelper attachmentHelper11) {
        super();
        this.logo = view;
        this.nameField = editText2;
        this.emailField = editText4;
        this.messageField = editText7;
        this.nameLayout = textInputLayout3;
        this.emailLayout = textInputLayout5;
        this.messageLayout = textInputLayout8;
        this.emailValidator = validator6;
        this.dispatcher = f9;
        this.actionFactory = actionFactory10;
        this.attachmentHelper = attachmentHelper11;
        EditText[] obj2 = new EditText[3];
        ComponentInputForm.EditTextTextWatcher.install(this, editText2, editText4, editText7);
        ComponentInputForm.EmailFieldFocusListener.install(this, editText4);
    }

    static View access$000(zendesk.support.request.ComponentInputForm componentInputForm) {
        return componentInputForm.logo;
    }

    static void access$100(zendesk.support.request.ComponentInputForm componentInputForm) {
        componentInputForm.updateEmailValidation();
    }

    static void access$200(zendesk.support.request.ComponentInputForm componentInputForm) {
        componentInputForm.updateSendButton();
    }

    static boolean access$300(zendesk.support.request.ComponentInputForm componentInputForm) {
        return componentInputForm.inlineValidation;
    }

    static zendesk.support.request.ComponentInputForm create(View view, f f2, zendesk.support.request.ActionFactory actionFactory3, zendesk.support.request.AttachmentHelper attachmentHelper4) {
        ComponentInputForm.1 anon = new ComponentInputForm.1();
        super(view.findViewById(f.I0), (EditText)view.findViewById(f.u0), (TextInputLayout)view.findViewById(f.v0), (EditText)view.findViewById(f.Y), (TextInputLayout)view.findViewById(f.Z), anon, (EditText)view.findViewById(f.s0), (TextInputLayout)view.findViewById(f.t0), f2, actionFactory3, attachmentHelper4);
        return obj12;
    }

    private boolean doFieldsContainText() {
        String string;
        int i;
        String string2;
        int i3;
        int i2;
        i2 = 0;
        final int i4 = 1;
        if (isNameFieldVisible()) {
            if (g.c(this.nameField.getText().toString())) {
                i = i4;
            } else {
                i = i2;
            }
        } else {
        }
        if (isEmailFieldVisible()) {
            if (g.c(this.emailField.getText().toString())) {
                i3 = i4;
            } else {
                i3 = i2;
            }
        } else {
        }
        if (i != 0 && i3 != 0 && g.c(this.messageField.getText().toString())) {
            if (i3 != 0) {
                if (g.c(this.messageField.getText().toString())) {
                    i2 = i4;
                }
            }
        }
        return i2;
    }

    private boolean isEmailFieldVisible() {
        int i;
        i = this.emailLayout.getVisibility() == 0 ? 1 : 0;
        return i;
    }

    private boolean isEmailInputValid() {
        int i;
        boolean emailFieldVisible;
        if (isEmailFieldVisible()) {
            if (this.emailValidator.isValid(this.emailField.getText().toString())) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean isNameFieldVisible() {
        int i;
        i = this.nameLayout.getVisibility() == 0 ? 1 : 0;
        return i;
    }

    private void setSendButtonEnabled(boolean z) {
        int i;
        MenuItem sendButton;
        int icon;
        int i2;
        if (this.sendButton != null) {
            if (z) {
            } else {
                i = icon / 100;
            }
            this.sendButton.getIcon().setAlpha(i);
            this.sendButton.setEnabled(z);
        }
    }

    private void updateEmailValidation() {
        TextInputLayout emailLayout;
        int string;
        int i;
        if (isEmailInputValid()) {
            this.emailLayout.setError(0);
        } else {
            this.inlineValidation = true;
            this.emailLayout.setError(this.emailField.getContext().getString(j.b));
        }
    }

    private void updateSendButton() {
        boolean doFieldsContainText;
        boolean doFieldsContainText2;
        if (this.inlineValidation) {
            if (doFieldsContainText() && isEmailInputValid()) {
                doFieldsContainText2 = isEmailInputValid() ? 1 : 0;
            } else {
            }
        } else {
            doFieldsContainText2 = doFieldsContainText();
        }
        setSendButtonEnabled(doFieldsContainText2);
    }

    p<zendesk.support.request.ComponentInputForm.InputFormModel> getSelector() {
        ComponentInputForm.InputFormSelector inputFormSelector = new ComponentInputForm.InputFormSelector();
        return inputFormSelector;
    }

    @Override // o.b.k
    boolean hasUnsavedInput() {
        String string;
        boolean enabled;
        boolean z;
        int i;
        i = 1;
        if (this.nameField.isEnabled() && g.c(this.nameField.getText().toString())) {
            if (g.c(string)) {
                return i;
            }
        }
        if (this.emailField.isEnabled() && g.c(this.emailField.getText().toString())) {
            if (g.c(string2)) {
                return i;
            }
        }
        if (!g.c(this.messageField.getText().toString())) {
            if (a.i(this.attachmentHelper.getSelectedAttachments())) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // o.b.k
    public void onKeyboardDismissed() {
        int visibility;
        int anon;
        if (this.logo.getVisibility() != 8) {
            anon = new ComponentInputForm.3(this);
            this.logo.post(anon);
        }
    }

    @Override // o.b.k
    public void onKeyboardVisible() {
        int visibility;
        int i;
        if (this.logo.getVisibility() != 8) {
            this.logo.setVisibility(4);
        }
    }

    @Override // o.b.k
    public void onMenuItemsClicked(MenuItem menuItem) {
        if (menuItem.getItemId() == f.T) {
            onSendMessageRequested();
        }
    }

    @Override // o.b.k
    public void onMenuItemsInflated(MenuItem menuItem, MenuItem menuItem2) {
        this.sendButton = menuItem;
        updateSendButton();
    }

    @Override // o.b.k
    void onSendMessageRequested() {
        boolean doFieldsContainText;
        boolean emailFieldVisible;
        Object string;
        f dispatcher;
        zendesk.support.request.ActionFactory actionFactory;
        if (doFieldsContainText() && isEmailInputValid()) {
            if (isEmailInputValid()) {
                if (!isNameFieldVisible()) {
                    if (isEmailFieldVisible()) {
                        this.dispatcher.c(this.actionFactory.updateNameEmailAsync(this.nameField.getText().toString(), this.emailField.getText().toString()));
                    }
                } else {
                }
                this.dispatcher.c(this.actionFactory.clearMessages());
                this.dispatcher.c(this.actionFactory.createCommentAsync(this.messageField.getText().toString(), a.e(this.attachmentHelper.getSelectedAttachments())));
            } else {
                updateEmailValidation();
                updateSendButton();
            }
        } else {
        }
    }

    @Override // o.b.k
    public void update(Object object) {
        update((ComponentInputForm.InputFormModel)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.ComponentInputForm.InputFormModel componentInputForm$InputFormModel) {
        boolean loading;
        int logoEnabled;
        int obj3;
        this.logo.setVisibility(inputFormModel.getLogoVisibility());
        this.nameLayout.setVisibility(inputFormModel.getNameFieldVisibility());
        this.emailLayout.setVisibility(inputFormModel.getEmailFieldVisibility());
        this.messageLayout.setVisibility(inputFormModel.getMessageFieldVisibility());
        this.nameLayout.setEnabled(loading2 ^= 1);
        this.emailLayout.setEnabled(loading3 ^= 1);
        this.messageLayout.setEnabled(loading4 ^= 1);
        if (inputFormModel.isLoading()) {
            setSendButtonEnabled(false);
        } else {
            loading = 0;
            if (inputFormModel.isLogoEnabled() && g.c(inputFormModel.getReferrerUrl())) {
                if (g.c(inputFormModel.getReferrerUrl())) {
                    loading = new ComponentInputForm.2(this, inputFormModel);
                }
            }
            this.logo.setOnClickListener(loading);
            updateSendButton();
        }
    }
}
