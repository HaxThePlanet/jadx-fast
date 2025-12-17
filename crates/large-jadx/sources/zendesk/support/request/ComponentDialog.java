package zendesk.support.request;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.util.Iterator;
import java.util.List;
import o.b.f;
import o.b.k;
import zendesk.support.UiUtils;

/* loaded from: classes3.dex */
class ComponentDialog implements k<zendesk.support.request.StateUi> {

    private final Activity activity;
    private final zendesk.support.request.ActionFactory af;
    private Dialog dialog;
    private final f dispatcher;

    static class OnDismissedListener implements DialogInterface.OnDismissListener {

        private final zendesk.support.request.ActionFactory af;
        private final f dispatcher;
        OnDismissedListener(zendesk.support.request.ActionFactory actionFactory, f f2) {
            super();
            this.af = actionFactory;
            this.dispatcher = f2;
        }

        @Override // android.content.DialogInterface$OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.dispatcher.c(this.af.onDialogDismissed());
        }
    }

    static class RetryDialogListener implements zendesk.support.request.RetryDialog.Listener {

        private final zendesk.support.request.ActionFactory af;
        private final f dispatcher;
        RetryDialogListener(zendesk.support.request.ActionFactory actionFactory, f f2) {
            super();
            this.af = actionFactory;
            this.dispatcher = f2;
        }

        public void onDeleteMessage(List<zendesk.support.request.StateMessage> list) {
            o.b.a message;
            f dispatcher;
            zendesk.support.request.ActionFactory factory;
            final Iterator obj4 = list.iterator();
            for (StateMessage next2 : obj4) {
                this.dispatcher.c(this.af.deleteMessage(next2));
            }
        }

        public void onRetryMessage(List<zendesk.support.request.StateMessage> list) {
            f dispatcher;
            o.b.a commentsAsync;
            zendesk.support.request.ActionFactory factory;
            onDeleteMessage(list);
            final Iterator obj4 = list.iterator();
            for (StateMessage next2 : obj4) {
                this.dispatcher.c(this.af.resendCommentAsync(next2));
                this.dispatcher.c(this.af.updateCommentsAsync());
            }
        }
    }
    ComponentDialog(Activity activity, zendesk.support.request.ActionFactory actionFactory2, f f3) {
        super();
        this.activity = activity;
        this.af = actionFactory2;
        this.dispatcher = f3;
    }

    private Dialog getDialogForState(zendesk.support.request.StateUi.DialogState stateUi$DialogState) {
        zendesk.support.request.RetryDialog retryDialog;
        zendesk.support.request.ActionFactory factory;
        f dispatcher;
        Object obj4;
        if (dialogState instanceof StateRetryDialog) {
            retryDialog = new RetryDialog(this.activity, (StateRetryDialog)dialogState.getMessage());
            obj4 = new ComponentDialog.RetryDialogListener(this.af, this.dispatcher);
            retryDialog.setListener(obj4);
        } else {
            retryDialog = 0;
        }
        return retryDialog;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((StateUi)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.StateUi stateUi) {
        Dialog onDismissedListener;
        zendesk.support.request.ActionFactory factory;
        f dispatcher;
        Object obj4;
        obj4 = stateUi.getDialogState();
        if (obj4 != null) {
            onDismissedListener = this.dialog;
            if (onDismissedListener != null) {
                if (!onDismissedListener.isShowing()) {
                    UiUtils.dismissKeyboard(this.activity);
                    obj4 = getDialogForState(obj4);
                    this.dialog = obj4;
                    onDismissedListener = new ComponentDialog.OnDismissedListener(this.af, this.dispatcher);
                    obj4.setOnDismissListener(onDismissedListener);
                    this.dialog.show();
                }
            } else {
            }
        }
    }
}
