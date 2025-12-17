package zendesk.messaging.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.h.f;
import androidx.recyclerview.widget.q;

/* loaded from: classes3.dex */
class CellListAdapter extends q<zendesk.messaging.ui.MessagingCell, RecyclerView.e0> {

    static class CellDiffUtil extends h.f<zendesk.messaging.ui.MessagingCell> {
        @Override // androidx.recyclerview.widget.h$f
        public boolean areContentsTheSame(Object object, Object object2) {
            return areContentsTheSame((MessagingCell)object, (MessagingCell)object2);
        }

        @Override // androidx.recyclerview.widget.h$f
        public boolean areContentsTheSame(zendesk.messaging.ui.MessagingCell messagingCell, zendesk.messaging.ui.MessagingCell messagingCell2) {
            return messagingCell.areContentsTheSame(messagingCell2);
        }

        @Override // androidx.recyclerview.widget.h$f
        public boolean areItemsTheSame(Object object, Object object2) {
            return areItemsTheSame((MessagingCell)object, (MessagingCell)object2);
        }

        @Override // androidx.recyclerview.widget.h$f
        public boolean areItemsTheSame(zendesk.messaging.ui.MessagingCell messagingCell, zendesk.messaging.ui.MessagingCell messagingCell2) {
            if (messagingCell.getId().equals(MessagingCellFactory.TYPING_INDICATOR_ID)) {
                return 0;
            }
            return messagingCell.getId().equals(messagingCell2.getId());
        }
    }
    CellListAdapter() {
        CellListAdapter.CellDiffUtil cellDiffUtil = new CellListAdapter.CellDiffUtil();
        super(cellDiffUtil);
    }

    @Override // androidx.recyclerview.widget.q
    public int getItemViewType(int i) {
        return (MessagingCell)getItem(i).getLayoutRes();
    }

    @Override // androidx.recyclerview.widget.q
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        final Object obj3 = getItem(i2);
        final View obj2 = e0.itemView;
        if ((MessagingCell)obj3.getViewClassType().isInstance(obj2)) {
            obj3.bind(obj2);
        }
    }

    @Override // androidx.recyclerview.widget.q
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        CellListAdapter.1 obj4 = new CellListAdapter.1(this, LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
        return obj4;
    }
}
