package zendesk.support.requestlist;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.squareup.picasso.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class RequestListAdapter extends RecyclerView.h<zendesk.support.requestlist.RequestListViewHolder> {

    private final zendesk.support.requestlist.RequestListView.OnItemClick itemClickListener;
    private final t picasso;
    private final List<zendesk.support.requestlist.RequestListItem> requestListItems;
    RequestListAdapter(zendesk.support.requestlist.RequestListView.OnItemClick requestListView$OnItemClick, t t2) {
        super();
        ArrayList arrayList = new ArrayList(0);
        this.requestListItems = arrayList;
        this.itemClickListener = onItemClick;
        this.picasso = t2;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.requestListItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public long getItemId(int i) {
        return (RequestListItem)this.requestListItems.get(i).getItemId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        onBindViewHolder((RequestListViewHolder)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(zendesk.support.requestlist.RequestListViewHolder requestListViewHolder, int i2) {
        requestListViewHolder.bind((RequestListItem)this.requestListItems.get(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return onCreateViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public zendesk.support.requestlist.RequestListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return RequestListViewHolder.create(viewGroup.getContext(), viewGroup, this.itemClickListener, this.picasso);
    }

    void swapRequests(List<zendesk.support.requestlist.RequestListItem> list) {
        this.requestListItems.clear();
        this.requestListItems.addAll(list);
        notifyDataSetChanged();
    }
}
