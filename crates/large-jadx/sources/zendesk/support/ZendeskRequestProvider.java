package zendesk.support;

import com.zendesk.service.a;
import com.zendesk.service.b;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zendesk.core.AnonymousIdentity;
import zendesk.core.AuthenticationProvider;
import zendesk.core.AuthenticationType;
import zendesk.core.Identity;

/* loaded from: classes3.dex */
final class ZendeskRequestProvider implements zendesk.support.RequestProvider {

    private static final String ALL_REQUEST_STATUSES = "new,open,pending,hold,solved,closed";
    private static final String GET_REQUESTS_SIDE_LOAD = "public_updated_at,last_commenting_agents,last_comment,first_comment";
    private static final String LOG_TAG = "ZendeskRequestProvider";
    private static final int MAX_TICKET_FIELDS = 5;
    private final AuthenticationProvider authenticationProvider;
    private final zendesk.support.SupportBlipsProvider blipsProvider;
    private final zendesk.support.SupportSdkMetadata metadata;
    private final zendesk.support.ZendeskRequestService requestService;
    private final zendesk.support.RequestSessionCache requestSessionCache;
    private final zendesk.support.RequestStorage requestStorage;
    private final zendesk.support.SupportSettingsProvider settingsProvider;
    private final zendesk.support.ZendeskTracker zendeskTracker;
    ZendeskRequestProvider(zendesk.support.SupportSettingsProvider supportSettingsProvider, zendesk.support.ZendeskRequestService zendeskRequestService2, AuthenticationProvider authenticationProvider3, zendesk.support.RequestStorage requestStorage4, zendesk.support.RequestSessionCache requestSessionCache5, zendesk.support.ZendeskTracker zendeskTracker6, zendesk.support.SupportSdkMetadata supportSdkMetadata7, zendesk.support.SupportBlipsProvider supportBlipsProvider8) {
        super();
        this.settingsProvider = supportSettingsProvider;
        this.requestService = zendeskRequestService2;
        this.authenticationProvider = authenticationProvider3;
        this.requestStorage = requestStorage4;
        this.requestSessionCache = requestSessionCache5;
        this.zendeskTracker = zendeskTracker6;
        this.metadata = supportSdkMetadata7;
        this.blipsProvider = supportBlipsProvider8;
    }

    static zendesk.support.SupportSdkMetadata access$000(zendesk.support.ZendeskRequestProvider zendeskRequestProvider) {
        return zendeskRequestProvider.metadata;
    }

    static void access$100(zendesk.support.ZendeskRequestProvider zendeskRequestProvider, zendesk.support.CreateRequest createRequest2, zendesk.support.SupportSdkSettings supportSdkSettings3) {
        zendeskRequestProvider.addServerTags(createRequest2, supportSdkSettings3);
    }

    static zendesk.support.ZendeskRequestService access$1000(zendesk.support.ZendeskRequestProvider zendeskRequestProvider) {
        return zendeskRequestProvider.requestService;
    }

    static void access$1100(zendesk.support.ZendeskRequestProvider zendeskRequestProvider, String string2, zendesk.support.EndUserComment endUserComment3, f f4) {
        zendeskRequestProvider.addCommentInternal(string2, endUserComment3, f4);
    }

    static List access$1200(List list, List list2) {
        return ZendeskRequestProvider.convertTicketFormResponse(list, list2);
    }

    static zendesk.support.RequestSessionCache access$1300(zendesk.support.ZendeskRequestProvider zendeskRequestProvider) {
        return zendeskRequestProvider.requestSessionCache;
    }

    static zendesk.support.RequestUpdates access$1400(List list) {
        return ZendeskRequestProvider.calcRequestUpdates(list);
    }

    static AuthenticationProvider access$200(zendesk.support.ZendeskRequestProvider zendeskRequestProvider) {
        return zendeskRequestProvider.authenticationProvider;
    }

    static void access$300(zendesk.support.ZendeskRequestProvider zendeskRequestProvider, zendesk.support.CreateRequest createRequest2, AuthenticationType authenticationType3, Identity identity4, f f5) {
        zendeskRequestProvider.internalCreateRequest(createRequest2, authenticationType3, identity4, f5);
    }

    static zendesk.support.ZendeskTracker access$400(zendesk.support.ZendeskRequestProvider zendeskRequestProvider) {
        return zendeskRequestProvider.zendeskTracker;
    }

    static zendesk.support.SupportBlipsProvider access$500(zendesk.support.ZendeskRequestProvider zendeskRequestProvider) {
        return zendeskRequestProvider.blipsProvider;
    }

    static zendesk.support.RequestStorage access$600(zendesk.support.ZendeskRequestProvider zendeskRequestProvider) {
        return zendeskRequestProvider.requestStorage;
    }

    static boolean access$700(zendesk.support.SupportSdkSettings supportSdkSettings) {
        return ZendeskRequestProvider.areConversationsEnabled(supportSdkSettings);
    }

    static void access$800(zendesk.support.ZendeskRequestProvider zendeskRequestProvider, String string2, AuthenticationType authenticationType3, f f4) {
        zendeskRequestProvider.getAllRequestsInternal(string2, authenticationType3, f4);
    }

    static void access$900(f f) {
        ZendeskRequestProvider.answerCallbackOnConversationsDisabled(f);
    }

    private void addCommentInternal(String string, zendesk.support.EndUserComment endUserComment2, f<zendesk.support.Comment> f3) {
        ZendeskRequestProvider.7 anon = new ZendeskRequestProvider.7(this, f3, string, f3);
        this.requestService.addComment(string, endUserComment2, anon);
    }

    private void addServerTags(zendesk.support.CreateRequest createRequest, zendesk.support.SupportSdkSettings supportSdkSettings2) {
        boolean arr;
        int str2;
        int str;
        List[] arr2 = new List[2];
        str = 0;
        arr2[str] = createRequest.getTags();
        arr2[1] = supportSdkSettings2.getContactZendeskTags();
        List obj5 = a.b(arr2);
        if (a.i(obj5)) {
            a.b("ZendeskRequestProvider", "Adding tags to feedback...", new Object[str]);
            createRequest.setTags(obj5);
        }
    }

    private static void answerCallbackOnConversationsDisabled(f f) {
        Object[] bVar;
        String str;
        a.b("ZendeskRequestProvider", "Conversations disabled, this feature is not available on your plan or was disabled.", new Object[0]);
        if (f != null) {
            bVar = new b("Access Denied");
            f.onError(bVar);
        }
    }

    private static boolean areConversationsEnabled(zendesk.support.SupportSdkSettings supportSdkSettings) {
        int obj0;
        if (supportSdkSettings == null) {
            obj0 = 0;
        } else {
            obj0 = supportSdkSettings.isConversationsEnabled();
        }
        return obj0;
    }

    private static zendesk.support.RequestUpdates calcRequestUpdates(List<zendesk.support.RequestData> list) {
        int size;
        int unreadComments;
        HashMap hashMap = new HashMap(list.size());
        Iterator obj3 = list.iterator();
        while (obj3.hasNext()) {
            size = obj3.next();
            unreadComments = (RequestData)size.unreadComments();
            if (unreadComments != 0) {
            }
            hashMap.put(size.getId(), Integer.valueOf(unreadComments));
        }
        obj3 = new RequestUpdates(hashMap);
        return obj3;
    }

    private static List<zendesk.support.TicketForm> convertTicketFormResponse(List<zendesk.support.RawTicketForm> list, List<zendesk.support.RawTicketField> list2) {
        zendesk.support.TicketForm ticketFormFromResponse;
        ArrayList arrayList = new ArrayList();
        final Iterator obj2 = list.iterator();
        for (RawTicketForm next2 : obj2) {
            arrayList.add(ZendeskRequestProvider.createTicketFormFromResponse(next2, ZendeskRequestProvider.createTicketFieldMap(list2)));
        }
        return arrayList;
    }

    private static Map<Long, zendesk.support.TicketField> createTicketFieldMap(List<zendesk.support.RawTicketField> list) {
        int create;
        Long valueOf;
        HashMap hashMap = new HashMap(list.size());
        final Iterator obj4 = list.iterator();
        for (RawTicketField next2 : obj4) {
            hashMap.put(Long.valueOf(next2.getId()), TicketField.create(next2));
        }
        return hashMap;
    }

    private static zendesk.support.TicketForm createTicketFormFromResponse(zendesk.support.RawTicketForm rawTicketForm, Map<Long, zendesk.support.TicketField> map2) {
        Object next;
        Object obj;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = rawTicketForm.getTicketFieldIds().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next != null && map2.get((Long)next) != null) {
            }
            if (map2.get(next) != null) {
            }
            arrayList.add(map2.get(next));
        }
        return RawTicketForm.create(rawTicketForm, arrayList);
    }

    private void getAllRequestsInternal(String string, AuthenticationType authenticationType2, f<List<zendesk.support.Request>> f3) {
        Object anon;
        Object aNONYMOUS;
        int size;
        boolean next;
        String obj5;
        Object obj6;
        Object obj7;
        if (g.e(string)) {
            obj5 = "new,open,pending,hold,solved,closed";
        }
        anon = new ZendeskRequestProvider.3(this, f3, f3);
        final String str = "public_updated_at,last_commenting_agents,last_comment,first_comment";
        if (authenticationType2 == AuthenticationType.ANONYMOUS) {
            obj6 = this.requestStorage.getRequestData();
            aNONYMOUS = new ArrayList(obj6.size());
            obj6 = obj6.iterator();
            for (RequestData next2 : obj6) {
                aNONYMOUS.add(next2.getId());
            }
            if (a.g(aNONYMOUS)) {
                a.k("ZendeskRequestProvider", "getAllRequestsInternal: There are no requests to fetch", new Object[0]);
                if (f3 != null) {
                    obj5 = new ArrayList();
                    f3.onSuccess(obj5);
                }
            } else {
                this.requestService.getAllRequests(g.g(aNONYMOUS), obj5, str, anon);
            }
        } else {
            this.requestService.getAllRequests(obj5, str, anon);
        }
    }

    private void internalCreateRequest(zendesk.support.CreateRequest createRequest, AuthenticationType authenticationType2, Identity identity3, f<zendesk.support.Request> f4) {
        Object obj3;
        zendesk.support.ZendeskRequestService obj4;
        ZendeskRequestProvider.2 anon = new ZendeskRequestProvider.2(this, f4, f4);
        if (authenticationType2 == AuthenticationType.ANONYMOUS && identity3 != null && identity3 instanceof AnonymousIdentity) {
            if (identity3 != null) {
                if (identity3 instanceof AnonymousIdentity) {
                    this.requestService.createRequest((AnonymousIdentity)identity3.getSdkGuid(), createRequest, anon);
                } else {
                    this.requestService.createRequest(0, createRequest, anon);
                }
            } else {
            }
        } else {
        }
    }

    public void addComment(String string, zendesk.support.EndUserComment endUserComment2, f<zendesk.support.Comment> f3) {
        super(this, f3, string, endUserComment2, f3);
        this.settingsProvider.getSettings(anon);
    }

    public void createRequest(zendesk.support.CreateRequest createRequest, f<zendesk.support.Request> f2) {
        int i;
        Object[] obj3;
        int i2 = 0;
        i = createRequest == null ? i2 : 1;
        String str2 = "configuration is invalid: request null";
        a.e("ZendeskRequestProvider", str2, new Object[i2]);
        if (i == 0 && f2 != null) {
            str2 = "configuration is invalid: request null";
            a.e("ZendeskRequestProvider", str2, new Object[i2]);
            if (f2 != null) {
                obj3 = new b(str2);
                f2.onError(obj3);
            }
        }
        ZendeskRequestProvider.1 anon = new ZendeskRequestProvider.1(this, f2, createRequest, f2);
        this.settingsProvider.getSettings(anon);
    }

    public void getAllRequests(f<List<zendesk.support.Request>> f) {
        getRequests(0, f);
    }

    public void getComments(String string, f<zendesk.support.CommentsResponse> f2) {
        ZendeskRequestProvider.5 anon = new ZendeskRequestProvider.5(this, f2, string, f2);
        this.settingsProvider.getSettings(anon);
    }

    public void getCommentsSince(String string, Date date2, boolean z3, f<zendesk.support.CommentsResponse> f4) {
        super(this, f4, string, date2, z3, f4);
        this.settingsProvider.getSettings(anon);
    }

    public void getRequest(String string, f<zendesk.support.Request> f2) {
        ZendeskRequestProvider.9 anon = new ZendeskRequestProvider.9(this, f2, string, f2);
        this.settingsProvider.getSettings(anon);
    }

    public void getRequests(String string, f<List<zendesk.support.Request>> f2) {
        ZendeskRequestProvider.4 anon = new ZendeskRequestProvider.4(this, f2, string, f2);
        this.settingsProvider.getSettings(anon);
    }

    public void getTicketFormsById(List<Long> list, f<List<zendesk.support.TicketForm>> f2) {
        boolean str2;
        int size;
        int str;
        Object obj4;
        if (a.g(list) && f2 != null) {
            if (f2 != null) {
                obj4 = new b("Ticket forms must at least contain 1 Id");
                f2.onError(obj4);
            }
        }
        ArrayList arrayList = new ArrayList();
        str = 5;
        if (list.size() > str) {
            int i = 0;
            arrayList.addAll(list.subList(i, str));
            obj4 = new Object[1];
            obj4[i] = Integer.valueOf(str);
            a.b("ZendeskRequestProvider", "Maximum number of allowed ticket fields: %d.", obj4);
        } else {
            arrayList.addAll(list);
        }
        if (this.requestSessionCache.containsAllTicketForms(arrayList)) {
            if (f2 != null) {
                f2.onSuccess(this.requestSessionCache.getTicketFormsById(arrayList));
            }
        } else {
            size = new ZendeskRequestProvider.10(this, f2, arrayList, f2);
            this.settingsProvider.getSettings(size);
        }
    }

    public void getUpdatesForDevice(f<zendesk.support.RequestUpdates> f) {
        Object calcRequestUpdates;
        zendesk.support.ZendeskRequestProvider.11 anon;
        if (this.requestStorage.isRequestDataExpired() == null) {
            f.onSuccess(ZendeskRequestProvider.calcRequestUpdates(this.requestStorage.getRequestData()));
        } else {
            anon = new ZendeskRequestProvider.11(this, f);
            this.settingsProvider.getSettings(anon);
        }
    }

    @Override // zendesk.support.RequestProvider
    public void markRequestAsRead(String string, int i2) {
        this.requestStorage.markRequestAsRead(string, i2);
    }

    @Override // zendesk.support.RequestProvider
    public void markRequestAsUnread(String string) {
        this.requestStorage.markRequestAsUnread(string);
    }
}
