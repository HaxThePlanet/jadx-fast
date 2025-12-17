package zendesk.support.request;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.squareup.picasso.t;
import d.h.k.d;
import d.u.d;
import d.u.q;
import f.g.d.f;
import f.g.d.j;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.b.k;
import o.b.o;
import o.b.p;

/* loaded from: classes3.dex */
class ComponentToolbar implements k<zendesk.support.request.ComponentToolbar.ToolbarModel> {

    private final zendesk.support.request.ViewToolbarAvatar avatarContainer;
    private final View container;
    private final Context context;
    private final d fadeTransition;
    private final t picasso;
    private final zendesk.support.request.ViewAlmostRealProgressBar progressBar;
    private final TextView subTitle;
    private final TextView title;
    private final Toolbar toolbar;
    private zendesk.support.request.ComponentToolbar.ToolbarModel toolbarModel;
    private final zendesk.support.request.ComponentToolbar.ToolbarSelector toolbarSelector;

    static class ToolbarModel {

        static int STATE_AGENT_INFO = 3;
        static int STATE_LOADING = 1;
        static int STATE_TITLE = 2;
        private final List<zendesk.support.request.StateRequestUser> agent;
        private final boolean isProgressEnabled;
        private final Date lastReply;
        private final int toolbarContentState;
        static {
        }

        ToolbarModel(boolean z, int i2, List<zendesk.support.request.StateRequestUser> list3, Date date4) {
            super();
            this.isProgressEnabled = z;
            this.toolbarContentState = i2;
            this.agent = list3;
            this.lastReply = date4;
        }

        public boolean equals(Object object) {
            boolean equals;
            List equals2;
            Class class2;
            int toolbarContentState;
            Class class;
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (object != null) {
                if (getClass() != object.getClass()) {
                } else {
                    if (this.isProgressEnabled != object.isProgressEnabled) {
                        return i;
                    }
                    if (this.toolbarContentState != object.toolbarContentState) {
                        return i;
                    }
                    List agent = this.agent;
                    if (agent != null) {
                        if (!agent.equals(object.agent)) {
                            return i;
                        }
                    } else {
                        if (object.agent != null) {
                        }
                    }
                    Date lastReply = this.lastReply;
                    final Date obj5 = object.lastReply;
                    if (lastReply != null) {
                        equals = lastReply.equals(obj5);
                    } else {
                        if (obj5 == null) {
                        } else {
                            equals = i;
                        }
                    }
                }
                return equals;
            }
            return i;
        }

        List<zendesk.support.request.StateRequestUser> getAgents() {
            return this.agent;
        }

        List<d<String, String>> getAvatarUrls() {
            d dVar;
            String avatar;
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.agent.iterator();
            for (StateRequestUser next2 : iterator) {
                arrayList.add(d.a(next2.getAvatar(), next2.getName()));
            }
            return arrayList;
        }

        Date getLastReply() {
            return this.lastReply;
        }

        String getNameOfFirstAgent() {
            if (a.i(this.agent)) {
                return (StateRequestUser)this.agent.get(0).getName();
            }
            return "";
        }

        int getToolbarContentState() {
            return this.toolbarContentState;
        }

        public int hashCode() {
            int i;
            int i2;
            List agent = this.agent;
            if (agent != null) {
                i = agent.hashCode();
            } else {
                i = i2;
            }
            Date lastReply = this.lastReply;
            if (lastReply != null) {
                i2 = lastReply.hashCode();
            }
            return i7 += i2;
        }

        boolean isProgressEnabled() {
            return this.isProgressEnabled;
        }
    }

    static class ToolbarSelector implements p<zendesk.support.request.ComponentToolbar.ToolbarModel> {
        private zendesk.support.request.StateMessage findLastAgentReply(List<zendesk.support.request.StateMessage> list, Map<Long, zendesk.support.request.StateRequestUser> map2) {
            int i;
            Object obj;
            boolean key;
            size--;
            while (i >= 0) {
                obj = list.get(i);
                i--;
            }
            return null;
        }

        private List<zendesk.support.request.StateRequestUser> getInvolvedAgents(List<zendesk.support.request.StateMessage> list, Map<Long, zendesk.support.request.StateRequestUser> map2) {
            int i;
            Object obj;
            boolean key;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            size--;
            while (i >= 0) {
                obj = list.get(i);
                key = map2.containsKey(Long.valueOf((StateMessage)obj.getUserId()));
                if (key != null) {
                }
                i--;
                linkedHashSet.add(map2.get(Long.valueOf(obj.getUserId())));
            }
            ArrayList obj6 = new ArrayList(linkedHashSet);
            return obj6;
        }

        private boolean isProgressEnabled(o o) {
            int obj1;
            obj1 = StateProgress.fomState(o).getRunningRequests() > 0 ? 1 : 0;
            return obj1;
        }

        private Map<Long, zendesk.support.request.StateRequestUser> mapAgents(List<zendesk.support.request.StateRequestUser> list) {
            Object next;
            boolean valueOf;
            HashMap hashMap = new HashMap();
            final Iterator obj5 = list.iterator();
            while (obj5.hasNext()) {
                next = obj5.next();
                if ((StateRequestUser)next.isAgent()) {
                }
                hashMap.put(Long.valueOf(next.getId()), next);
            }
            return hashMap;
        }

        @Override // o.b.p
        public Object selectData(o o) {
            return selectData(o);
        }

        @Override // o.b.p
        public zendesk.support.request.ComponentToolbar.ToolbarModel selectData(o o) {
            boolean sTATE_AGENT_INFO;
            int date;
            zendesk.support.request.StateMessage lastAgentReply;
            int obj7;
            obj7 = StateConversation.fromState(o);
            Map mapAgents = mapAgents(obj7.getUsers());
            ArrayList arrayList = new ArrayList();
            date = 0;
            if (!g.c(obj7.getLocalId()) && !g.c(obj7.getRemoteId())) {
                if (!g.c(obj7.getRemoteId())) {
                    obj7 = ComponentToolbar.ToolbarModel.STATE_LOADING;
                } else {
                    if (obj7.hasAgentReplies() && mapAgents.size() == 0) {
                        if (mapAgents.size() == 0) {
                            obj7 = ComponentToolbar.ToolbarModel.STATE_LOADING;
                        } else {
                            if (obj7.hasAgentReplies() && mapAgents.size() > 0) {
                                if (mapAgents.size() > 0) {
                                    lastAgentReply = findLastAgentReply(obj7.getMessages(), mapAgents);
                                    if (lastAgentReply != null) {
                                        date = lastAgentReply.getDate();
                                    }
                                    arrayList.addAll(getInvolvedAgents(obj7.getMessages(), mapAgents));
                                    obj7 = sTATE_AGENT_INFO;
                                } else {
                                    obj7 = ComponentToolbar.ToolbarModel.STATE_TITLE;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
            ComponentToolbar.ToolbarModel toolbarModel = new ComponentToolbar.ToolbarModel(isProgressEnabled(o), obj7, arrayList, date);
            return toolbarModel;
        }
    }
    ComponentToolbar(t t, Toolbar toolbar2, zendesk.support.request.ViewAlmostRealProgressBar viewAlmostRealProgressBar3) {
        super();
        d dVar = new d();
        this.fadeTransition = dVar;
        this.picasso = t;
        this.progressBar = viewAlmostRealProgressBar3;
        this.toolbar = toolbar2;
        this.context = toolbar2.getContext();
        ComponentToolbar.ToolbarSelector obj2 = new ComponentToolbar.ToolbarSelector();
        this.toolbarSelector = obj2;
        this.container = toolbar2.findViewById(f.m);
        this.title = (TextView)toolbar2.findViewById(f.o);
        this.subTitle = (TextView)toolbar2.findViewById(f.n);
        this.avatarContainer = (ViewToolbarAvatar)toolbar2.findViewById(f.l);
    }

    private void updateProgressBar(boolean z) {
        List dONT_STOP_MOVING;
        zendesk.support.request.ViewAlmostRealProgressBar obj3;
        if (z) {
            this.progressBar.start(ViewAlmostRealProgressBar.DONT_STOP_MOVING);
        } else {
            this.progressBar.stop(300);
        }
    }

    private void updateToolbar(zendesk.support.request.ComponentToolbar.ToolbarModel componentToolbar$ToolbarModel) {
        int toolbarContentState;
        int sTATE_AGENT_INFO;
        Object context;
        int i3;
        long arr2;
        int i;
        Object[] arr;
        int i2;
        Toolbar obj9;
        context = "";
        i3 = 8;
        if (toolbarModel.getToolbarContentState() == ComponentToolbar.ToolbarModel.STATE_LOADING) {
            this.container.setVisibility(i3);
            this.toolbar.setTitle(context);
        } else {
            if (toolbarModel.getToolbarContentState() == ComponentToolbar.ToolbarModel.STATE_AGENT_INFO) {
                this.title.setText(toolbarModel.getNameOfFirstAgent());
                sTATE_AGENT_INFO = 1;
                java.lang.CharSequence relativeTimeSpanString = DateUtils.getRelativeTimeSpanString(this.context, toolbarModel.getLastReply().getTime(), obj4);
                arr = new Object[sTATE_AGENT_INFO];
                i2 = 0;
                arr[i2] = relativeTimeSpanString;
                this.subTitle.setText(this.context.getString(j.w, arr));
                this.toolbar.setTitle(context);
                this.avatarContainer.setImageUrls(this.picasso, toolbarModel.getAvatarUrls());
                q.a(this.toolbar, this.fadeTransition);
                this.container.setVisibility(i2);
                arr2 = new Object[2];
                arr2[i2] = toolbarModel.getNameOfFirstAgent();
                arr2[sTATE_AGENT_INFO] = relativeTimeSpanString;
                this.container.setContentDescription(this.container.getContext().getString(j.f0, arr2));
            } else {
                if (toolbarModel.getToolbarContentState() == ComponentToolbar.ToolbarModel.STATE_TITLE) {
                    this.container.setVisibility(i3);
                    this.toolbar.setTitle(j.c);
                }
            }
        }
    }

    @Override // o.b.k
    zendesk.support.request.ComponentToolbar.ToolbarSelector getToolbarSelector() {
        return this.toolbarSelector;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((ComponentToolbar.ToolbarModel)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.ComponentToolbar.ToolbarModel componentToolbar$ToolbarModel) {
        boolean progressEnabled;
        if (!toolbarModel.equals(this.toolbarModel)) {
            this.toolbarModel = toolbarModel;
            updateProgressBar(toolbarModel.isProgressEnabled());
            updateToolbar(toolbarModel);
        }
    }
}
