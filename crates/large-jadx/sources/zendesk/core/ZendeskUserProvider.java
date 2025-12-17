package zendesk.core;

import com.zendesk.service.d;
import com.zendesk.service.d.b;
import com.zendesk.service.f;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import retrofit2.Call;

/* loaded from: classes3.dex */
class ZendeskUserProvider implements zendesk.core.UserProvider {

    private static final d.b<zendesk.core.UserFieldResponse, List<zendesk.core.UserField>> FIELDS_EXTRACTOR;
    private static final d.b<zendesk.core.UserResponse, Map<String, String>> FIELDS_MAP_EXTRACTOR;
    private static final d.b<zendesk.core.UserResponse, List<String>> TAGS_EXTRACTOR;
    private static final d.b<zendesk.core.UserResponse, zendesk.core.User> USER_EXTRACTOR;
    private final zendesk.core.UserService userService;
    static {
        ZendeskUserProvider.6 anon = new ZendeskUserProvider.6();
        ZendeskUserProvider.USER_EXTRACTOR = anon;
        ZendeskUserProvider.7 anon2 = new ZendeskUserProvider.7();
        ZendeskUserProvider.FIELDS_EXTRACTOR = anon2;
        ZendeskUserProvider.8 anon3 = new ZendeskUserProvider.8();
        ZendeskUserProvider.FIELDS_MAP_EXTRACTOR = anon3;
        ZendeskUserProvider.9 anon4 = new ZendeskUserProvider.9();
        ZendeskUserProvider.TAGS_EXTRACTOR = anon4;
    }

    ZendeskUserProvider(zendesk.core.UserService userService) {
        super();
        this.userService = userService;
    }

    public void addTags(List<String> list, f<List<String>> f2) {
        UserTagRequest userTagRequest = new UserTagRequest(a.e(list));
        ZendeskUserProvider.1 anon = new ZendeskUserProvider.1(this, f2, f2);
        d dVar = new d(anon, ZendeskUserProvider.TAGS_EXTRACTOR);
        this.userService.addTags(userTagRequest).enqueue(dVar);
    }

    public void deleteTags(List<String> list, f<List<String>> f2) {
        ZendeskUserProvider.2 anon = new ZendeskUserProvider.2(this, f2, f2);
        d dVar = new d(anon, ZendeskUserProvider.TAGS_EXTRACTOR);
        this.userService.deleteTags(g.g(a.e(list))).enqueue(dVar);
    }

    public void getUser(f<zendesk.core.User> f) {
        ZendeskUserProvider.5 anon = new ZendeskUserProvider.5(this, f, f);
        d dVar = new d(anon, ZendeskUserProvider.USER_EXTRACTOR);
        this.userService.getUser().enqueue(dVar);
    }

    public void getUserFields(f<List<zendesk.core.UserField>> f) {
        ZendeskUserProvider.3 anon = new ZendeskUserProvider.3(this, f, f);
        d dVar = new d(anon, ZendeskUserProvider.FIELDS_EXTRACTOR);
        this.userService.getUserFields().enqueue(dVar);
    }

    public void setUserFields(Map<String, String> map, f<Map<String, String>> f2) {
        UserFieldRequest userFieldRequest = new UserFieldRequest(map);
        ZendeskUserProvider.4 anon = new ZendeskUserProvider.4(this, f2, f2);
        d dVar = new d(anon, ZendeskUserProvider.FIELDS_MAP_EXTRACTOR);
        this.userService.setUserFields(userFieldRequest).enqueue(dVar);
    }
}
