package zendesk.support.request;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.h.e;
import androidx.recyclerview.widget.r;
import d.h.l.f0.b;
import f.g.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.b.k;
import o.b.o;
import o.b.p;

/* loaded from: classes3.dex */
class ComponentRequestAdapter implements k<List<zendesk.support.request.CellType.Base>> {

    private static final long UPDATE_TIME_WINDOW = 200L;
    private final r listUpdateCallback;
    private final RecyclerView recyclerView;
    private final zendesk.support.request.ComponentRequestAdapter.RequestAdapterSelector requestAdapterSelector;
    private final List<zendesk.support.request.CellType.Base> requestMessageList;
    private Runnable updateRunnable = null;

    private static class DiffCalculator extends h.b {

        private final List<zendesk.support.request.CellType.Base> newList;
        private final List<zendesk.support.request.CellType.Base> oldList;
        private DiffCalculator(List<zendesk.support.request.CellType.Base> list, List<zendesk.support.request.CellType.Base> list2) {
            super();
            this.oldList = list;
            this.newList = list2;
        }

        DiffCalculator(List list, List list2, zendesk.support.request.ComponentRequestAdapter.1 componentRequestAdapter$13) {
            super(list, list2);
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areContentsTheSame(int i, int i2) {
            return (CellType.Base)this.oldList.get(i).areContentsTheSame((CellType.Base)this.newList.get(i2));
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areItemsTheSame(int i, int i2) {
            int obj3;
            obj3 = Long.compare(uniqueId, obj3) == 0 ? 1 : 0;
            return obj3;
        }

        @Override // androidx.recyclerview.widget.h$b
        public int getNewListSize() {
            return this.newList.size();
        }

        @Override // androidx.recyclerview.widget.h$b
        public int getOldListSize() {
            return this.oldList.size();
        }
    }

    static class RequestAdapter extends RecyclerView.h<zendesk.support.request.ComponentRequestAdapter.RequestViewHolder> {

        private final zendesk.support.request.ComponentRequestAdapter dataSource;
        private int lastPosition = -1;
        RequestAdapter(zendesk.support.request.ComponentRequestAdapter componentRequestAdapter) {
            super();
            int i = -1;
            setHasStableIds(true);
            this.dataSource = componentRequestAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public int getItemCount() {
            return this.dataSource.getMessageCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public long getItemId(int i) {
            return this.dataSource.getMessageForPos(i).getUniqueId();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public int getItemViewType(int i) {
            return this.dataSource.getMessageForPos(i).getLayoutId();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
            onBindViewHolder((ComponentRequestAdapter.RequestViewHolder)e0, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public void onBindViewHolder(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder, int i2) {
            this.dataSource.getMessageForPos(i2).bind(requestViewHolder);
            int lastPosition = this.lastPosition;
            final int i = -1;
            if (i2 > lastPosition && lastPosition != i) {
                if (lastPosition != i) {
                    this.lastPosition = i2;
                    requestViewHolder.startAnimation();
                }
            }
            if (this.lastPosition == i) {
                this.lastPosition = i2;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return onCreateViewHolder(viewGroup, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public zendesk.support.request.ComponentRequestAdapter.RequestViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            ComponentRequestAdapter.RequestViewHolder obj4 = new ComponentRequestAdapter.RequestViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
            return obj4;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public void onViewDetachedFromWindow(RecyclerView.e0 recyclerView$e0) {
            onViewDetachedFromWindow((ComponentRequestAdapter.RequestViewHolder)e0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$h
        public void onViewDetachedFromWindow(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder) {
            super.onViewDetachedFromWindow(requestViewHolder);
            requestViewHolder.clearAnimation();
        }
    }

    static class RequestAdapterSelector implements p<List<zendesk.support.request.CellType.Base>> {

        private final zendesk.support.request.CellFactory messageFactory;
        RequestAdapterSelector(zendesk.support.request.CellFactory cellFactory) {
            super();
            this.messageFactory = cellFactory;
        }

        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        public List<zendesk.support.request.CellType.Base> selectData(o o) {
            zendesk.support.request.StateConversation state = StateConversation.fromState(o);
            return this.messageFactory.generateCells(state.getMessages(), state.getUsers(), state.getStatus(), StateConfig.fromState(o).getSettings().getSystemMessage());
        }
    }

    static class RequestViewHolder extends RecyclerView.e0 {

        private static final long ANIMATION_DURATION = 250L;
        private static final float ANIMATION_HEIGHT_RATIO = 0.6666667f;
        private static final TimeInterpolator TIME_INTERPOLATOR;
        private ValueAnimator animation;
        private final Map<Integer, View> viewCache;
        static {
            ComponentRequestAdapter.RequestViewHolder.TIME_INTERPOLATOR = b.a(1045220557, 0, 1053609165, 1065353216);
        }

        RequestViewHolder(View view) {
            super(view);
            HashMap obj1 = new HashMap();
            this.viewCache = obj1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        void clearAnimation() {
            Object itemView;
            int i;
            itemView = this.animation;
            if (itemView != null) {
                itemView.cancel();
                this.itemView.setTranslationY(0);
            }
        }

        <E extends View> E findCachedView(int i) {
            Object viewCache;
            Object viewCache2;
            Object obj4;
            final Map viewCache3 = this.viewCache;
            synchronized (viewCache3) {
                obj4 = this.viewCache.get(Integer.valueOf(i));
                try {
                    return obj4;
                    throw i;
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        void startAnimation() {
            int measuredHeight;
            int i3 = 0;
            if (this.itemView.getMeasuredHeight() == 0) {
                this.itemView.measure(i3, i3);
                measuredHeight = this.itemView.getMeasuredHeight();
            }
            float[] fArr = new float[2];
            fArr[i3] = f *= i7;
            fArr[1] = 0;
            ValueAnimator float = ValueAnimator.ofFloat(fArr);
            this.animation = float;
            float.setInterpolator(ComponentRequestAdapter.RequestViewHolder.TIME_INTERPOLATOR);
            this.animation.setDuration(250);
            ComponentRequestAdapter.RequestViewHolder.1 anon = new ComponentRequestAdapter.RequestViewHolder.1(this);
            this.animation.addUpdateListener(anon);
            this.animation.start();
        }
    }
    ComponentRequestAdapter(r r, zendesk.support.request.CellFactory cellFactory2, RecyclerView recyclerView3) {
        super();
        final int i = 0;
        this.listUpdateCallback = r;
        this.recyclerView = recyclerView3;
        ArrayList obj2 = new ArrayList();
        this.requestMessageList = obj2;
        obj2 = new ComponentRequestAdapter.RequestAdapterSelector(cellFactory2);
        this.requestAdapterSelector = obj2;
    }

    ComponentRequestAdapter(List<zendesk.support.request.CellType.Base> list, r r2, zendesk.support.request.ComponentRequestAdapter.RequestAdapterSelector componentRequestAdapter$RequestAdapterSelector3, RecyclerView recyclerView4) {
        super();
        final int i = 0;
        this.requestMessageList = list;
        this.listUpdateCallback = r2;
        this.requestAdapterSelector = requestAdapterSelector3;
        this.recyclerView = recyclerView4;
    }

    static List access$000(zendesk.support.request.ComponentRequestAdapter componentRequestAdapter) {
        return componentRequestAdapter.requestMessageList;
    }

    static void access$100(zendesk.support.request.ComponentRequestAdapter componentRequestAdapter, List list2, List list3) {
        componentRequestAdapter.updateDataSet(list2, list3);
    }

    private void updateDataSet(List<zendesk.support.request.CellType.Base> list, List<zendesk.support.request.CellType.Base> list2) {
        ComponentRequestAdapter.DiffCalculator diffCalculator = new ComponentRequestAdapter.DiffCalculator(list, list2, 0);
        this.requestMessageList.clear();
        this.requestMessageList.addAll(list2);
        h.c(diffCalculator, true).b(this.listUpdateCallback);
    }

    @Override // o.b.k
    int getMessageCount() {
        return this.requestMessageList.size();
    }

    @Override // o.b.k
    zendesk.support.request.CellType.Base getMessageForPos(int i) {
        return (CellType.Base)this.requestMessageList.get(i);
    }

    p<List<zendesk.support.request.CellType.Base>> getSelector() {
        return this.requestAdapterSelector;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((List)object);
    }

    public void update(List<zendesk.support.request.CellType.Base> list) {
        this.recyclerView.removeCallbacks(this.updateRunnable);
        ComponentRequestAdapter.1 anon = new ComponentRequestAdapter.1(this, list);
        this.updateRunnable = anon;
        this.recyclerView.postDelayed(anon, 200);
    }
}
