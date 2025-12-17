package zendesk.messaging.ui;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.i0;
import androidx.appcompat.widget.i0.d;
import java.util.Set;
import zendesk.messaging.R.id;
import zendesk.messaging.R.menu;

/* loaded from: classes3.dex */
class MessagePopUpHelper {

    static enum Option {

        COPY,
        RETRY,
        DELETE;
    }
    private static i0.d createOnMenuItemClickListener(zendesk.messaging.ui.MessageActionListener messageActionListener, String string2) {
        if (messageActionListener == null) {
            return null;
        }
        MessagePopUpHelper.1 anon = new MessagePopUpHelper.1(messageActionListener, string2);
        return anon;
    }

    private static i0 createPopUpMenu(View view, int i2, i0.d i0$d3) {
        i0 i0Var = new i0(view.getContext(), view);
        i0Var.c(i2);
        i0Var.e(d3);
        i0Var.d(8388613);
        return i0Var;
    }

    static void showPopUpMenu(View view, Set<zendesk.messaging.ui.MessagePopUpHelper.Option> set2, zendesk.messaging.ui.MessageActionListener messageActionListener3, String string4) {
        final i0 obj0 = MessagePopUpHelper.createPopUpMenu(view, R.menu.zui_message_options_copy_retry_delete, MessagePopUpHelper.createOnMenuItemClickListener(messageActionListener3, string4));
        obj0.a().getItem(0).setVisible(set2.contains(MessagePopUpHelper.Option.COPY));
        obj0.a().getItem(1).setVisible(set2.contains(MessagePopUpHelper.Option.RETRY));
        obj0.a().getItem(2).setVisible(set2.contains(MessagePopUpHelper.Option.DELETE));
        obj0.f();
    }
}
