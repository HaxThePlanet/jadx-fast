package zendesk.support.request;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import f.g.d.d;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import java.util.Date;

/* loaded from: classes3.dex */
class CellAgentAttachmentGeneric extends zendesk.support.request.CellBase implements zendesk.support.request.CellType.Attachment, zendesk.support.request.CellType.Agent {

    private final ResolveInfo appInfo;
    private final Rect insets;
    private boolean isAgentNameVisible = false;
    private final zendesk.support.request.StateRequestAttachment requestAttachment;
    private final zendesk.support.request.StateRequestUser user;
    CellAgentAttachmentGeneric(zendesk.support.request.CellBindHelper cellBindHelper, zendesk.support.request.StateRequestAttachment stateRequestAttachment2, zendesk.support.request.StateRequestUser stateRequestUser3, Date date4) {
        super(cellBindHelper, h.e, stateRequestAttachment2.getId(), obj4, stateRequestUser3.getId(), obj6, date4);
        this.requestAttachment = stateRequestAttachment2;
        this.user = stateRequestUser3;
        final int obj11 = 0;
        this.appInfo = cellBindHelper.getAppInfo(stateRequestAttachment2.getName());
        this.insets = cellBindHelper.getInsets(obj11, obj11, obj11, d.m);
    }

    private String buildTalkBackString(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 1;
        Object[] arr = new Object[i2];
        String name2 = this.requestAttachment.getName();
        final int i5 = 0;
        arr[i5] = name2;
        stringBuilder.append(context.getString(j.W, arr));
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
        (TextView)requestViewHolder.findCachedView(f.D).setText(this.requestAttachment.getName());
        this.utils.bindAppInfo(this.appInfo, (TextView)requestViewHolder.findCachedView(f.E), (ImageView)requestViewHolder.findCachedView(f.C));
        View cachedView3 = requestViewHolder.findCachedView(f.B);
        this.utils.addOnClickListenerForFileAttachment(cachedView3, this.requestAttachment);
        this.utils.bindAgentName((TextView)requestViewHolder.findCachedView(f.A), this.isAgentNameVisible, this.user);
        cachedView3.setContentDescription(buildTalkBackString(cachedView3.getContext()));
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.StateRequestUser getAgent() {
        return this.user;
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.StateRequestAttachment getAttachment() {
        return this.requestAttachment;
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
