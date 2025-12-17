package zendesk.support;

import f.g.c.a;
import f.g.e.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import zendesk.core.BaseStorage;
import zendesk.core.MemoryCache;

/* loaded from: classes3.dex */
class ZendeskRequestStorage implements zendesk.support.RequestStorage {

    private static final SimpleDateFormat HOURS_MINUTES_FORMAT = null;
    private static final long HOUR_IN_MILLIS = 0L;
    private static final String LOG_TAG = "ZendeskRequestStorage";
    private static final String MEMORY_CACHE_MIGRATED_KEY = "zendesk_request_storage_memory_cache_migrated_flag";
    private static final String REQUESTS_DATA_KEY = "zendesk_request_storage_request_data_list";
    private static final String TIMESTAMP_KEY = "zendesk_request_storage_requests_data_cache_time";
    private final Object lock;
    private final MemoryCache memoryCache;
    private final zendesk.support.RequestMigrator requestMigrator;
    private final BaseStorage storage;
    static {
        final String str = "mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        ZendeskRequestStorage.HOURS_MINUTES_FORMAT = simpleDateFormat;
        ZendeskRequestStorage.HOUR_IN_MILLIS = TimeUnit.HOURS.toMillis(1);
    }

    ZendeskRequestStorage(BaseStorage baseStorage, zendesk.support.RequestMigrator requestMigrator2, MemoryCache memoryCache3) {
        super();
        Object object = new Object();
        this.lock = object;
        this.storage = baseStorage;
        this.requestMigrator = requestMigrator2;
        this.memoryCache = memoryCache3;
    }

    private void checkForAndMigrateLegacyRequestData() {
        boolean legacyRequests;
        Boolean fALSE;
        final String str = "zendesk_request_storage_memory_cache_migrated_flag";
        legacyRequests = this.requestMigrator.getLegacyRequests();
        if (!(Boolean)this.memoryCache.getOrDefault(str, Boolean.FALSE).booleanValue() && a.i(legacyRequests)) {
            legacyRequests = this.requestMigrator.getLegacyRequests();
            if (a.i(legacyRequests)) {
                storeRequestData(legacyRequests);
                this.requestMigrator.clearLegacyRequestStorage();
                this.memoryCache.put(str, Boolean.TRUE);
            }
        }
    }

    private static List<zendesk.support.RequestData> updateRequests(List<zendesk.support.RequestData> list, List<zendesk.support.Request> list2) {
        int next;
        boolean readCommentCount;
        int size;
        String str;
        zendesk.support.RequestData obj5;
        HashMap hashMap = new HashMap(size2 += size);
        Iterator obj4 = list.iterator();
        for (RequestData next : obj4) {
            hashMap.put(next.getId(), next);
        }
        obj4 = list2.iterator();
        while (obj4.hasNext()) {
            obj5 = obj4.next();
            if (hashMap.containsKey((Request)obj5.getId())) {
            } else {
            }
            hashMap.put(obj5.getId(), RequestData.create(obj5));
            Object obj = hashMap.get(obj5.getId());
            hashMap.put((RequestData)obj.getId(), RequestData.create(obj.getId(), obj5.getCommentCount().intValue(), obj.getReadCommentCount()));
        }
        obj4 = new ArrayList(hashMap.values());
        return obj4;
    }

    public List<zendesk.support.RequestData> getRequestData() {
        Object requestDataList;
        Object obj;
        checkForAndMigrateLegacyRequestData();
        Object lock = this.lock;
        obj = this.storage.get("zendesk_request_storage_request_data_list", RequestDataList.class);
        synchronized (lock) {
            checkForAndMigrateLegacyRequestData();
            lock = this.lock;
            obj = this.storage.get("zendesk_request_storage_request_data_list", RequestDataList.class);
        }
        requestDataList = obj.requestDataList;
        return requestDataList;
    }

    @Override // zendesk.support.RequestStorage
    public boolean isRequestDataExpired() {
        long format;
        int i;
        int arr;
        String str2;
        String str;
        SimpleDateFormat hOURS_MINUTES_FORMAT;
        Object lock = this.lock;
        String str3 = this.storage.get("zendesk_request_storage_requests_data_cache_time");
        synchronized (lock) {
            lock = this.lock;
            str3 = this.storage.get("zendesk_request_storage_requests_data_cache_time");
        }
        format = 0;
        try {
            arr = 1;
            int i3 = 0;
            if (Long.compare(l, hOUR_IN_MILLIS) > 0) {
            } else {
            }
            i = arr;
            i = i3;
            if (i == 0) {
            }
            arr = new Object[arr];
            arr[i3] = ZendeskRequestStorage.HOURS_MINUTES_FORMAT.format(Long.valueOf(format));
            a.b("ZendeskRequestStorage", "Returning Read Requests from cache. Cached Read Requests will expire in %s", arr);
            return i;
            throw th;
        }
    }

    @Override // zendesk.support.RequestStorage
    public void markRequestAsRead(String string, int i2) {
        int create;
        boolean equals;
        final Object lock = this.lock;
        List requestData = getRequestData();
        ArrayList arrayList = new ArrayList(requestData.size());
        Iterator iterator = requestData.iterator();
        synchronized (lock) {
            while (iterator.hasNext()) {
                create = iterator.next();
                if (string.equals((RequestData)create.getId())) {
                } else {
                }
                arrayList.add(create);
                arrayList.add(RequestData.create(create.getId(), i2, i2));
            }
            storeRequestData(arrayList);
        }
    }

    @Override // zendesk.support.RequestStorage
    public void markRequestAsUnread(String string) {
        int create;
        int equals;
        final Object lock = this.lock;
        List requestData = getRequestData();
        ArrayList arrayList = new ArrayList(requestData.size());
        Iterator iterator = requestData.iterator();
        synchronized (lock) {
            while (iterator.hasNext()) {
                create = iterator.next();
                if (string.equals((RequestData)create.getId())) {
                } else {
                }
                arrayList.add(create);
                arrayList.add(RequestData.create(string, commentCount++, create.getReadCommentCount()));
            }
            storeRequestData(arrayList);
        }
    }

    public void storeRequestData(List<zendesk.support.RequestData> list) {
        if (list == null) {
        }
        final Object lock = this.lock;
        RequestDataList requestDataList = new RequestDataList(list);
        this.storage.put("zendesk_request_storage_request_data_list", requestDataList);
        this.storage.put("zendesk_request_storage_requests_data_cache_time", Long.toString(System.currentTimeMillis()));
        return;
        synchronized (lock) {
            lock = this.lock;
            requestDataList = new RequestDataList(list);
            this.storage.put("zendesk_request_storage_request_data_list", requestDataList);
            this.storage.put("zendesk_request_storage_requests_data_cache_time", Long.toString(System.currentTimeMillis()));
        }
    }

    public void updateRequestData(List<zendesk.support.Request> list) {
        final Object lock = this.lock;
        storeRequestData(ZendeskRequestStorage.updateRequests(getRequestData(), list));
        return;
        synchronized (lock) {
            lock = this.lock;
            storeRequestData(ZendeskRequestStorage.updateRequests(getRequestData(), list));
        }
    }
}
