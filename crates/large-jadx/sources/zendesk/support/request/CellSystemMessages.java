package zendesk.support.request;

import android.widget.TextView;
import f.g.d.f;
import f.g.d.h;
import f.g.d.j;
import java.util.Date;
import zendesk.support.RequestStatus;

/* loaded from: classes3.dex */
class CellSystemMessages {

    static class CellDateMessage extends zendesk.support.request.CellBase {
        CellDateMessage(zendesk.support.request.CellBindHelper cellBindHelper, long l2, Date date3) {
            super(cellBindHelper, h.k, l2, obj4, Integer.MIN_VALUE, obj6, obj12);
        }

        @Override // zendesk.support.request.CellBase
        public boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base) {
            return getTimeStamp().equals(base.getTimeStamp());
        }

        @Override // zendesk.support.request.CellBase
        public void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
            this.utils.bindDate((TextView)requestViewHolder.findCachedView(f.V), getTimeStamp());
        }
    }

    static class CellRequestStatus extends zendesk.support.request.CellBase {

        private final RequestStatus requestStatus;
        CellRequestStatus(zendesk.support.request.CellBindHelper cellBindHelper, RequestStatus requestStatus2) {
            Date date = new Date();
            super(cellBindHelper, h.n, -9223372036854775807L, obj4, Integer.MIN_VALUE, obj6, date);
            this.requestStatus = requestStatus2;
        }

        @Override // zendesk.support.request.CellBase
        public boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base) {
            return base instanceof CellSystemMessages.CellRequestStatus;
        }

        @Override // zendesk.support.request.CellBase
        public void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
            RequestStatus requestStatus;
            if (this.requestStatus == RequestStatus.Closed) {
                (TextView)requestViewHolder.findCachedView(f.w0).setText(j.v);
            }
        }
    }

    static class CellSystemMessage extends zendesk.support.request.CellBase {

        private final String message;
        CellSystemMessage(Date date, String string2) {
            super(0, h.n, Long.MIN_VALUE, obj4, Integer.MIN_VALUE, obj6, date);
            this.message = string2;
        }

        @Override // zendesk.support.request.CellBase
        public boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base) {
            return base instanceof CellSystemMessages.CellSystemMessage;
        }

        @Override // zendesk.support.request.CellBase
        public void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
            (TextView)requestViewHolder.findCachedView(f.w0).setText(this.message);
        }
    }
}
