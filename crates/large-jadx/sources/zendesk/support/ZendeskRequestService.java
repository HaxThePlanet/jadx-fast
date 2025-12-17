package zendesk.support;

import com.zendesk.service.d;
import com.zendesk.service.d.b;
import com.zendesk.service.f;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import retrofit2.Call;

/* loaded from: classes3.dex */
class ZendeskRequestService {

    private static final String LOG_TAG = "ZendeskRequestService";
    private static final String ROLE_AGENT = "agent";
    private static final String ROLE_USER = "end_user";
    private static final String TICKET_FIELDS_INCLUDE = "ticket_fields";
    private final DateFormat iso8601;
    private final d.b<zendesk.support.RequestResponse, zendesk.support.Request> requestExtractor;
    private final zendesk.support.RequestService requestService;
    private final d.b<zendesk.support.RequestsResponse, List<zendesk.support.Request>> requestsExtractor;
    ZendeskRequestService(zendesk.support.RequestService requestService) {
        super();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        this.iso8601 = simpleDateFormat;
        ZendeskRequestService.3 anon = new ZendeskRequestService.3(this);
        this.requestsExtractor = anon;
        ZendeskRequestService.4 anon2 = new ZendeskRequestService.4(this);
        this.requestExtractor = anon2;
        this.requestService = requestService;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    static Map access$000(List list) {
        return ZendeskRequestService.getAgentMap(list);
    }

    static zendesk.support.Request access$100(zendesk.support.Request request, Map map2) {
        return ZendeskRequestService.updateLastCommentingAgents(request, map2);
    }

    private static Map<Long, zendesk.support.User> getAgentMap(List<zendesk.support.User> list) {
        int size;
        zendesk.support.User user2;
        Long num;
        String name;
        zendesk.support.Attachment photo;
        int i2;
        Long valueOf;
        long l;
        int i;
        zendesk.support.User user;
        HashMap hashMap = new HashMap(list.size());
        final Iterator obj11 = list.iterator();
        for (User next2 : obj11) {
            super(next2.getId(), next2.getName(), next2.getPhoto(), 1, Long.valueOf(-1), 0, 0);
            hashMap.put(next2.getId(), user);
        }
        return hashMap;
    }

    private static zendesk.support.Request updateLastCommentingAgents(zendesk.support.Request request, Map<Long, zendesk.support.User> map2) {
        Object obj;
        ArrayList arrayList = new ArrayList(request.getLastCommentingAgentsIds().size());
        Iterator iterator = request.getLastCommentingAgentsIds().iterator();
        for (Long next2 : iterator) {
            arrayList.add(map2.get(next2));
        }
        request.setLastCommentingAgents(arrayList);
        return request;
    }

    void addComment(String string, zendesk.support.EndUserComment endUserComment2, f<zendesk.support.Request> f3) {
        UpdateRequestWrapper updateRequestWrapper = new UpdateRequestWrapper();
        Request request = new Request();
        request.setComment(endUserComment2);
        updateRequestWrapper.setRequest(request);
        ZendeskRequestService.2 anon = new ZendeskRequestService.2(this);
        d obj4 = new d(f3, anon);
        this.requestService.addComment(string, updateRequestWrapper).enqueue(obj4);
    }

    public void createRequest(String string, zendesk.support.CreateRequest createRequest2, f<zendesk.support.Request> f3) {
        CreateRequestWrapper createRequestWrapper = new CreateRequestWrapper(createRequest2);
        ZendeskRequestService.1 anon = new ZendeskRequestService.1(this);
        d obj3 = new d(f3, anon);
        this.requestService.createRequest(string, createRequestWrapper).enqueue(obj3);
    }

    void getAllRequests(String string, String string2, f<List<zendesk.support.Request>> f3) {
        d obj3 = new d(f3, this.requestsExtractor);
        this.requestService.getAllRequests(string, string2).enqueue(obj3);
    }

    void getAllRequests(String string, String string2, String string3, f<List<zendesk.support.Request>> f4) {
        d obj3 = new d(f4, this.requestsExtractor);
        this.requestService.getManyRequests(string, string2, string3).enqueue(obj3);
    }

    void getComments(String string, f<zendesk.support.CommentsResponse> f2) {
        d dVar = new d(f2);
        this.requestService.getComments(string).enqueue(dVar);
    }

    void getCommentsSince(String string, Date date2, boolean z3, f<zendesk.support.CommentsResponse> f4) {
        String obj4;
        obj4 = z3 ? "agent" : 0;
        d obj3 = new d(f4);
        this.requestService.getCommentsSince(string, this.iso8601.format(date2), obj4).enqueue(obj3);
    }

    void getRequest(String string, String string2, f<zendesk.support.Request> f3) {
        d obj3 = new d(f3, this.requestExtractor);
        this.requestService.getRequest(string, string2).enqueue(obj3);
    }

    void getTicketFormsById(String string, f<zendesk.support.RawTicketFormResponse> f2) {
        d dVar = new d(f2);
        this.requestService.getTicketFormsById(string, "ticket_fields").enqueue(dVar);
    }
}
