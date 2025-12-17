package zendesk.support.request;

import android.content.Context;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import f.g.d.d;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import java.util.Date;
import java.util.List;
import zendesk.support.UiUtils;

/* loaded from: classes3.dex */
class CellUserMessage extends zendesk.support.request.CellBase implements zendesk.support.request.CellType.Message, zendesk.support.request.CellType.Stateful {

    private final List<zendesk.support.request.StateMessage> erroredMessages;
    private final Rect insets;
    private final boolean lastErrorCellOfBlock;
    private final boolean markAsDelivered;
    private final zendesk.support.request.StateMessage message;
    private final boolean showError;
    private final java.lang.CharSequence textMessage;
    CellUserMessage(zendesk.support.request.CellBindHelper cellBindHelper, zendesk.support.request.StateMessage stateMessage2, boolean z3, boolean z4, java.lang.CharSequence charSequence5, List<zendesk.support.request.StateMessage> list6, boolean z7) {
        super(cellBindHelper, h.q, stateMessage2.getId(), obj4, -2147483647, obj6, stateMessage2.getDate());
        this.textMessage = charSequence5;
        this.message = stateMessage2;
        this.markAsDelivered = z3;
        this.showError = z4;
        final int obj11 = 0;
        this.insets = cellBindHelper.getInsets(obj11, obj11, obj11, d.p);
        this.erroredMessages = list6;
        this.lastErrorCellOfBlock = z7;
    }

    private String buildTalkBackString(Context context) {
        java.lang.CharSequence relativeTimeSpanString;
        Object[] arr2;
        int arr;
        String obj7;
        StringBuilder stringBuilder = new StringBuilder();
        arr2 = 1;
        arr = new Object[arr2];
        final java.lang.CharSequence textMessage = this.textMessage;
        final int i2 = 0;
        arr[i2] = textMessage;
        stringBuilder.append(context.getString(j.e0, arr));
        stringBuilder.append(" ");
        if (this.showError == null) {
            arr2 = new Object[arr2];
            arr2[i2] = DateUtils.getRelativeTimeSpanString(context, this.message.getDate().getTime(), textMessage);
            stringBuilder.append(context.getString(j.d0, arr2));
        } else {
            stringBuilder.append(context.getString(j.a0));
        }
        return stringBuilder.toString();
    }

    @Override // zendesk.support.request.CellBase
    public boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base) {
        int obj3;
        if (this.utils.areMessageContentsTheSame(this, base) && this.utils.areStatefulCellContentsTheSame(this, base)) {
            obj3 = this.utils.areStatefulCellContentsTheSame(this, base) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    @Override // zendesk.support.request.CellBase
    public void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
        View cachedView = requestViewHolder.findCachedView(f.H0);
        (ViewRequestText)cachedView.setText(this.textMessage);
        View cachedView2 = requestViewHolder.findCachedView(f.G0);
        this.utils.bindStatusLabel((TextView)cachedView2, this.lastErrorCellOfBlock, this.markAsDelivered);
        View cachedView3 = requestViewHolder.findCachedView(f.F0);
        android.view.View.OnClickListener errorClickListener = this.utils.errorClickListener(this.showError, this.erroredMessages);
        UiUtils.setTint(this.utils.colorForError(isErrorShown()), cachedView3.getBackground(), cachedView3);
        requestViewHolder.itemView.setOnClickListener(errorClickListener);
        cachedView3.setOnClickListener(errorClickListener);
        cachedView.setOnClickListener(errorClickListener);
        cachedView2.setOnClickListener(errorClickListener);
        cachedView3.setContentDescription(buildTalkBackString(cachedView3.getContext()));
    }

    public List<zendesk.support.request.StateMessage> getErrorGroupMessages() {
        return this.erroredMessages;
    }

    @Override // zendesk.support.request.CellBase
    public Rect getInsets() {
        return this.insets;
    }

    @Override // zendesk.support.request.CellBase
    public java.lang.CharSequence getMessage() {
        return getMessage();
    }

    @Override // zendesk.support.request.CellBase
    public String getMessage() {
        return this.message.getBody();
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.StateMessage getStateMessage() {
        return this.message;
    }

    @Override // zendesk.support.request.CellBase
    public boolean isErrorShown() {
        return this.showError;
    }

    @Override // zendesk.support.request.CellBase
    public boolean isLastErrorCellOfBlock() {
        return this.lastErrorCellOfBlock;
    }

    @Override // zendesk.support.request.CellBase
    public boolean isMarkedAsDelivered() {
        return this.markAsDelivered;
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.CellType.Stateful markAsDelivered() {
        super(this.utils, this.message, 1, this.showError, this.textMessage, this.erroredMessages, this.lastErrorCellOfBlock);
        cellUserMessage2.setPositionType(getPositionType());
        return cellUserMessage2;
    }

    public zendesk.support.request.CellType.Stateful markAsErrored(List<zendesk.support.request.StateMessage> list, boolean z2) {
        super(this.utils, this.message, this.markAsDelivered, 1, this.textMessage, list, z2);
        cellUserMessage2.setPositionType(getPositionType());
        return cellUserMessage2;
    }
}
