package zendesk.support.request;

import android.graphics.Rect;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
interface CellType {

    public interface Base {
        public abstract boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base);

        public abstract void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder);

        public abstract long getGroupId();

        public abstract Rect getInsets();

        public abstract int getLayoutId();

        public abstract int getPositionType();

        public abstract Date getTimeStamp();

        public abstract long getUniqueId();

        public abstract void setPositionType(int i);
    }

    public interface Agent extends zendesk.support.request.CellType.Base {
        @Override // zendesk.support.request.CellType$Base
        public abstract zendesk.support.request.StateRequestUser getAgent();

        @Override // zendesk.support.request.CellType$Base
        public abstract boolean isAgentNameVisible();

        @Override // zendesk.support.request.CellType$Base
        public abstract void showAgentName(boolean z);
    }

    public interface Attachment extends zendesk.support.request.CellType.Base {
        @Override // zendesk.support.request.CellType$Base
        public abstract zendesk.support.request.StateRequestAttachment getAttachment();
    }

    public interface Message extends zendesk.support.request.CellType.Base {
        @Override // zendesk.support.request.CellType$Base
        public abstract java.lang.CharSequence getMessage();
    }

    public interface Stateful extends zendesk.support.request.CellType.Base {
        public abstract List<zendesk.support.request.StateMessage> getErrorGroupMessages();

        @Override // zendesk.support.request.CellType$Base
        public abstract zendesk.support.request.StateMessage getStateMessage();

        @Override // zendesk.support.request.CellType$Base
        public abstract boolean isErrorShown();

        @Override // zendesk.support.request.CellType$Base
        public abstract boolean isLastErrorCellOfBlock();

        @Override // zendesk.support.request.CellType$Base
        public abstract boolean isMarkedAsDelivered();

        @Override // zendesk.support.request.CellType$Base
        public abstract zendesk.support.request.CellType.Stateful markAsDelivered();

        public abstract zendesk.support.request.CellType.Stateful markAsErrored(List<zendesk.support.request.StateMessage> list, boolean z2);
    }
}
