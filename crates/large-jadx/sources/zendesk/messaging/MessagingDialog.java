package zendesk.messaging;

import android.app.Activity;
import android.app.Dialog;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.y;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import zendesk.messaging.components.DateProvider;

/* loaded from: classes3.dex */
class MessagingDialog implements y<zendesk.messaging.DialogContent> {

    private final d appCompatActivity;
    private final DateProvider dateProvider;
    private final zendesk.messaging.MessagingViewModel messagingViewModel;
    public MessagingDialog(d d, zendesk.messaging.MessagingViewModel messagingViewModel2, DateProvider dateProvider3) {
        super();
        this.appCompatActivity = d;
        this.messagingViewModel = messagingViewModel2;
        this.dateProvider = dateProvider3;
    }

    static DateProvider access$000(zendesk.messaging.MessagingDialog messagingDialog) {
        return messagingDialog.dateProvider;
    }

    static zendesk.messaging.MessagingViewModel access$100(zendesk.messaging.MessagingDialog messagingDialog) {
        return messagingDialog.messagingViewModel;
    }

    static d access$200(zendesk.messaging.MessagingDialog messagingDialog) {
        return messagingDialog.appCompatActivity;
    }

    @Override // androidx.lifecycle.y
    public void onChanged(Object object) {
        onChanged((DialogContent)object);
    }

    @Override // androidx.lifecycle.y
    public void onChanged(zendesk.messaging.DialogContent dialogContent) {
        int anon2;
        int i;
        View viewById;
        Object viewById2;
        Object message;
        View view2;
        Dialog dialog;
        View view;
        zendesk.messaging.MessagingDialog.3 anon;
        if (dialogContent != null) {
            dialog = new Dialog(this.appCompatActivity);
            dialog.setContentView(R.layout.zui_messaging_dialog);
            view = viewById5;
            viewById = dialog.findViewById(R.id.zui_dialog_negative_button);
            view2 = viewById6;
            MessagingDialog.1 anon3 = new MessagingDialog.1(this, dialog, dialogContent);
            (Button)viewById.setOnClickListener(anon3);
            dialog.setTitle(dialogContent.getTitle());
            (TextView)dialog.findViewById(R.id.zui_dialog_message).setText(dialogContent.getMessage());
            (TextView)dialog.findViewById(R.id.zui_dialog_title).setText(dialogContent.getTitle());
            viewById.setText(R.string.zui_button_label_no);
            (Button)view.setText(R.string.zui_button_label_yes);
            anon2 = MessagingDialog.4.$SwitchMap$zendesk$messaging$DialogContent$Config[dialogContent.getConfig().ordinal()];
            if (anon2 != 1) {
                if (anon2 != 2) {
                } else {
                    (TextInputLayout)view2.setVisibility(0);
                    viewById.setText(17039360);
                    view.setText(R.string.zui_label_send);
                    view2.setHint(this.appCompatActivity.getString(R.string.zui_dialog_email_hint));
                    super(this, (TextInputEditText)dialog.findViewById(R.id.zui_dialog_input), dialogContent, dialog, view2);
                    view.setOnClickListener(anon);
                }
            } else {
                anon2 = new MessagingDialog.2(this, dialogContent, dialog);
                view.setOnClickListener(anon2);
            }
            dialog.show();
        }
    }
}
