package zendesk.core;

import com.zendesk.service.f;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface UserProvider {
    public abstract void addTags(List<String> list, f<List<String>> f2);

    public abstract void deleteTags(List<String> list, f<List<String>> f2);

    public abstract void getUser(f<zendesk.core.User> f);

    public abstract void getUserFields(f<List<zendesk.core.UserField>> f);

    public abstract void setUserFields(Map<String, String> map, f<Map<String, String>> f2);
}
