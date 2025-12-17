package zendesk.support.request;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import f.g.d.d;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
class CellUserAttachmentGeneric extends zendesk.support.request.CellBase implements zendesk.support.request.CellType.Attachment, zendesk.support.request.CellType.Stateful {

    private final ResolveInfo appInfo;
    private final List<zendesk.support.request.StateMessage> erroredMessages;
    private final Rect insets;
    private final boolean lastErrorCellOfBlock;
    private final boolean markAsDelivered;
    private final zendesk.support.request.StateMessage message;
    private final zendesk.support.request.StateRequestAttachment requestAttachment;
    private final boolean showError;
    CellUserAttachmentGeneric(zendesk.support.request.CellBindHelper cellBindHelper, zendesk.support.request.StateMessage stateMessage2, zendesk.support.request.StateRequestAttachment stateRequestAttachment3, Date date4, boolean z5, boolean z6, List<zendesk.support.request.StateMessage> list7, boolean z8) {
        final Object obj3 = this;
        final zendesk.support.request.CellBindHelper cellBindHelper3 = cellBindHelper;
        super(cellBindHelper, h.o, stateRequestAttachment3.getId(), obj4, -2147483647, obj6, date4);
        obj3.requestAttachment = stateRequestAttachment3;
        obj3.markAsDelivered = z5;
        obj3.message = stateMessage2;
        obj3.showError = z6;
        obj3.erroredMessages = list7;
        obj3.lastErrorCellOfBlock = z8;
        obj3.appInfo = cellBindHelper.getAppInfo(stateRequestAttachment3.getName());
        int i2 = 0;
        obj3.insets = cellBindHelper.getInsets(i2, i2, i2, d.p);
    }

    private String buildTalkBackString(Context context) {
        java.lang.CharSequence relativeTimeSpanString;
        Object[] arr2;
        int arr;
        String obj7;
        StringBuilder stringBuilder = new StringBuilder();
        arr2 = 1;
        arr = new Object[arr2];
        String name = this.requestAttachment.getName();
        final int i2 = 0;
        arr[i2] = name;
        stringBuilder.append(context.getString(j.b0, arr));
        stringBuilder.append(" ");
        if (this.showError == null) {
            arr2 = new Object[arr2];
            arr2[i2] = DateUtils.getRelativeTimeSpanString(context, this.message.getDate().getTime(), name);
            stringBuilder.append(context.getString(j.d0, arr2));
        } else {
            stringBuilder.append(context.getString(j.a0));
        }
        return stringBuilder.toString();
    }

    @Override // zendesk.support.request.CellBase
    public boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base) {
        int obj3;
        if (this.utils.areAttachmentCellContentsTheSame(this, base) && this.utils.areStatefulCellContentsTheSame(this, base)) {
            obj3 = this.utils.areStatefulCellContentsTheSame(this, base) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    @Override // zendesk.support.request.CellBase
    public void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
        (TextView)requestViewHolder.findCachedView(f.z0).setText(this.requestAttachment.getName());
        this.utils.bindAppInfo(this.appInfo, (TextView)requestViewHolder.findCachedView(f.B0), (ImageView)requestViewHolder.findCachedView(f.y0));
        View cachedView3 = requestViewHolder.findCachedView(f.x0);
        this.utils.addOnClickListenerForFileAttachment((CardView)cachedView3, this.requestAttachment);
        this.utils.bindStatusLabel((TextView)requestViewHolder.findCachedView(f.A0), this.lastErrorCellOfBlock, this.markAsDelivered);
        android.view.View.OnClickListener errorClickListener = this.utils.errorClickListener(this.showError, this.erroredMessages);
        requestViewHolder.itemView.setOnClickListener(errorClickListener);
        cachedView3.setCardBackgroundColor(this.utils.colorForError(this.showError));
        if (errorClickListener != null) {
            cachedView3.setOnClickListener(errorClickListener);
        }
        cachedView3.setContentDescription(buildTalkBackString(cachedView3.getContext()));
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.StateRequestAttachment getAttachment() {
        return this.requestAttachment;
    }

    public List<zendesk.support.request.StateMessage> getErrorGroupMessages() {
        return this.erroredMessages;
    }

    @Override // zendesk.support.request.CellBase
    public Rect getInsets() {
        return this.insets;
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
        super(this.utils, this.message, this.requestAttachment, getTimeStamp(), 1, this.showError, this.erroredMessages, this.lastErrorCellOfBlock);
        return cellUserAttachmentGeneric2;
    }

    public zendesk.support.request.CellType.Stateful markAsErrored(List<zendesk.support.request.StateMessage> list, boolean z2) {
        super(this.utils, this.message, this.requestAttachment, getTimeStamp(), this.markAsDelivered, 1, list, z2);
        return cellUserAttachmentGeneric2;
    }
}
