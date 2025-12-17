package zendesk.support.request;

import android.content.Context;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.view.View;
import f.g.d.d;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import java.util.Date;

/* loaded from: classes3.dex */
class CellAgentAttachmentImage extends zendesk.support.request.CellBase implements zendesk.support.request.CellType.Attachment, zendesk.support.request.CellType.Agent {

    private final zendesk.support.request.StateRequestAttachment attachment;
    private final Rect insets;
    private boolean isAgentNameVisible = false;
    private final zendesk.support.request.StateRequestUser user;
    CellAgentAttachmentImage(zendesk.support.request.CellBindHelper cellBindHelper, zendesk.support.request.StateRequestAttachment stateRequestAttachment2, zendesk.support.request.StateRequestUser stateRequestUser3, Date date4) {
        super(cellBindHelper, h.f, stateRequestAttachment2.getId(), obj4, stateRequestUser3.getId(), obj6, date4);
        this.user = stateRequestUser3;
        this.attachment = stateRequestAttachment2;
        final int obj10 = 0;
        this.insets = cellBindHelper.getInsets(obj10, obj10, obj10, d.m);
    }

    private String buildTalkBackString(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 1;
        Object[] arr = new Object[i2];
        String name2 = this.attachment.getName();
        final int i5 = 0;
        arr[i5] = name2;
        stringBuilder.append(context.getString(j.X, arr));
        stringBuilder.append(" ");
        Object[] arr2 = new Object[2];
        arr2[i5] = DateUtils.getRelativeTimeSpanString(context, getTimeStamp().getTime(), name2);
        arr2[i2] = this.user.getName();
        stringBuilder.append(context.getString(j.Y, arr2));
        return stringBuilder.toString();
    }

    @Override // zendesk.support.request.CellBase
    public boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base) {
        int obj3;
        if (this.utils.areAttachmentCellContentsTheSame(this, base) && this.utils.areAgentCellContentsTheSame(this, base)) {
            obj3 = this.utils.areAgentCellContentsTheSame(this, base) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    @Override // zendesk.support.request.CellBase
    public void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
        View cachedView = requestViewHolder.findCachedView(f.G);
        this.utils.bindImage((ImageView)cachedView, this.attachment);
        this.utils.addOnClickListenerForImageAttachment(cachedView, this.attachment);
        this.utils.bindAgentName((TextView)requestViewHolder.findCachedView(f.F), this.isAgentNameVisible, this.user);
        final View obj5 = requestViewHolder.findCachedView(f.z);
        obj5.setContentDescription(buildTalkBackString(obj5.getContext()));
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.StateRequestUser getAgent() {
        return this.user;
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.StateRequestAttachment getAttachment() {
        return this.attachment;
    }

    @Override // zendesk.support.request.CellBase
    public Rect getInsets() {
        return this.insets;
    }

    @Override // zendesk.support.request.CellBase
    public boolean isAgentNameVisible() {
        return this.isAgentNameVisible;
    }

    @Override // zendesk.support.request.CellBase
    public void showAgentName(boolean z) {
        this.isAgentNameVisible = z;
    }
}
