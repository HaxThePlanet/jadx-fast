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

/* loaded from: classes3.dex */
class CellAgentMessage extends zendesk.support.request.CellBase implements zendesk.support.request.CellType.Message, zendesk.support.request.CellType.Agent {

    private final Rect insets;
    private final zendesk.support.request.StateMessage message;
    private boolean showAgentName = false;
    private final java.lang.CharSequence textMessage;
    private final zendesk.support.request.StateRequestUser user;
    CellAgentMessage(zendesk.support.request.CellBindHelper cellBindHelper, zendesk.support.request.StateMessage stateMessage2, java.lang.CharSequence charSequence3, zendesk.support.request.StateRequestUser stateRequestUser4) {
        super(cellBindHelper, h.g, stateMessage2.getId(), obj4, stateMessage2.getUserId(), obj6, stateMessage2.getDate());
        this.textMessage = charSequence3;
        this.message = stateMessage2;
        this.user = stateRequestUser4;
        final int obj12 = 0;
        this.insets = cellBindHelper.getInsets(obj12, d.o, obj12, d.n);
    }

    private String buildTalkBackString(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        final int i2 = 1;
        Object[] arr = new Object[i2];
        java.lang.CharSequence textMessage = this.textMessage;
        final int i5 = 0;
        arr[i5] = textMessage;
        stringBuilder.append(context.getString(j.Z, arr));
        stringBuilder.append(" ");
        Object[] arr2 = new Object[2];
        arr2[i5] = DateUtils.getRelativeTimeSpanString(context, this.message.getDate().getTime(), textMessage);
        arr2[i2] = this.user.getName();
        stringBuilder.append(context.getString(j.Y, arr2));
        return stringBuilder.toString();
    }

    @Override // zendesk.support.request.CellBase
    public boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base) {
        int obj3;
        if (this.utils.areMessageContentsTheSame(this, base) && this.utils.areAgentCellContentsTheSame(this, base)) {
            obj3 = this.utils.areAgentCellContentsTheSame(this, base) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    @Override // zendesk.support.request.CellBase
    public void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
        View cachedView = requestViewHolder.findCachedView(f.I);
        (ViewRequestText)cachedView.setText(this.textMessage);
        this.utils.bindAgentName((TextView)requestViewHolder.findCachedView(f.J), this.showAgentName, this.user);
        final View obj6 = requestViewHolder.findCachedView(f.H);
        obj6.setContentDescription(buildTalkBackString(obj6.getContext()));
        cachedView.requestLayout();
    }

    @Override // zendesk.support.request.CellBase
    public zendesk.support.request.StateRequestUser getAgent() {
        return this.user;
    }

    @Override // zendesk.support.request.CellBase
    public Rect getInsets() {
        return this.insets;
    }

    @Override // zendesk.support.request.CellBase
    public java.lang.CharSequence getMessage() {
        return this.message.getBody();
    }

    @Override // zendesk.support.request.CellBase
    public boolean isAgentNameVisible() {
        return this.showAgentName;
    }

    @Override // zendesk.support.request.CellBase
    public void showAgentName(boolean z) {
        this.showAgentName = z;
    }
}
