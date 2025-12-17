package zendesk.support.request;

import android.content.Context;
import android.content.Intent;
import f.g.e.a;
import f.g.e.c;
import f.g.e.e;
import f.g.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import o.a.a;
import o.a.c;
import zendesk.support.AttachmentFile;
import zendesk.support.CustomField;
import zendesk.support.Request;
import zendesk.support.RequestStatus;
import zendesk.support.requestlist.RequestInfo;

/* loaded from: classes3.dex */
public class RequestConfiguration implements a {

    public static final long NO_TICKET_FORM_ID = -1L;
    private final List<a> configurations;
    private final List<CustomField> customFields;
    private final List<AttachmentFile> files;
    private final boolean hasAgentReplies;
    private final String localRequestId;
    private final String requestId;
    private final RequestStatus requestStatus;
    private final String requestSubject;
    private final List<String> tags;
    private final long ticketFormId;

    public static class Builder {

        private List<a> configurations;
        private List<CustomField> customFields;
        private List<AttachmentFile> files;
        private boolean hasAgentReplies = false;
        private String localRequestId;
        private String requestId;
        private RequestStatus requestStatus = null;
        private String requestSubject;
        private List<String> tags;
        private long ticketFormId = -1;
        public Builder() {
            super();
            String str = "";
            this.requestSubject = str;
            final int i3 = 0;
            ArrayList arrayList4 = new ArrayList(i3);
            this.tags = arrayList4;
            this.requestId = str;
            this.localRequestId = str;
            int i = 0;
            ArrayList arrayList = new ArrayList(i3);
            this.customFields = arrayList;
            int i2 = -1;
            ArrayList arrayList2 = new ArrayList(i3);
            this.files = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.configurations = arrayList3;
        }

        private void setConfigurations(List<a> list) {
            Class<zendesk.support.request.RequestConfiguration> obj;
            Object obj3;
            this.configurations = list;
            obj3 = c.d(list, RequestConfiguration.class);
            if ((RequestConfiguration)obj3 != null) {
                this.requestSubject = (RequestConfiguration)obj3.getRequestSubject();
                this.tags = obj3.getTags();
                this.ticketFormId = RequestConfiguration.access$000(obj3);
                this.customFields = RequestConfiguration.access$100(obj3);
                this.files = obj3.getFilesAsAttachments();
            }
        }

        public a config() {
            super(this.requestSubject, this.tags, this.requestId, this.localRequestId, this.requestStatus, this.customFields, this.ticketFormId, obj8, this.files, this.hasAgentReplies, this.configurations);
            return requestConfiguration;
        }

        public Intent deepLinkIntent(Context context, List<a> list2, Intent... intent3Arr3) {
            ArrayList arrayList = new ArrayList(Arrays.asList(intent3Arr3));
            Intent obj5 = new Intent(context, DeepLinkingBroadcastReceiver.class);
            obj5.putExtra("extra_request_intent", intent(context, list2));
            obj5.putExtra("extra_follow_up_activities", arrayList);
            return obj5;
        }

        public Intent deepLinkIntent(Context context, Intent... intent2Arr2) {
            ArrayList arrayList = new ArrayList(Arrays.asList(intent2Arr2));
            Intent obj4 = new Intent(context, DeepLinkingBroadcastReceiver.class);
            obj4.putExtra("extra_request_intent", intent(context, new a[0]));
            obj4.putExtra("extra_follow_up_activities", arrayList);
            return obj4;
        }

        public Intent intent(Context context, List<a> list2) {
            setConfigurations(list2);
            Intent intent = new Intent(context, RequestActivity.class);
            c.c(intent, config());
            return intent;
        }

        public Intent intent(Context context, a... a2Arr2) {
            return intent(context, Arrays.asList(a2Arr2));
        }

        public void show(Context context, List<a> list2) {
            context.startActivity(intent(context, list2));
        }

        public void show(Context context, a... a2Arr2) {
            context.startActivity(intent(context, a2Arr2));
        }

        public zendesk.support.request.RequestConfiguration.Builder withCustomFields(List<CustomField> list) {
            this.customFields = list;
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withFiles(List<File> list) {
            int size;
            String str;
            AttachmentFile attachmentFile;
            String name;
            ArrayList arrayList = new ArrayList(list.size());
            final Iterator obj6 = list.iterator();
            for (File size : obj6) {
                attachmentFile = new AttachmentFile(size.getName(), e.b(c.a(size.getName())), size);
                arrayList.add(attachmentFile);
            }
            this.files = arrayList;
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withFiles(File... fileArr) {
            return withFiles(Arrays.asList(fileArr));
        }

        public zendesk.support.request.RequestConfiguration.Builder withRequest(Request request) {
            this.requestId = request.getId();
            this.requestStatus = request.getStatus();
            this.hasAgentReplies = a.i(request.getLastCommentingAgents());
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withRequestId(String string) {
            this.requestId = string;
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withRequestInfo(RequestInfo requestInfo) {
            String localId = requestInfo.getLocalId();
            if (g.c(localId)) {
                this.localRequestId = localId;
            }
            String remoteId = requestInfo.getRemoteId();
            if (g.c(remoteId)) {
                this.requestId = remoteId;
            }
            this.requestStatus = requestInfo.getRequestStatus();
            this.hasAgentReplies = a.i(requestInfo.getAgentInfos());
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withRequestSubject(String string) {
            this.requestSubject = string;
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withTags(List<String> list) {
            this.tags = a.c(list);
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withTags(String... stringArr) {
            this.tags = a.c(Arrays.asList(stringArr));
            return this;
        }

        public zendesk.support.request.RequestConfiguration.Builder withTicketForm(long l, List<CustomField> list2) {
            this.ticketFormId = l;
            this.customFields = obj3;
            return this;
        }
    }
    RequestConfiguration(String string, List<String> list2, String string3, String string4, RequestStatus requestStatus5, List<CustomField> list6, long l7, List<AttachmentFile> list8, boolean z9, List<a> list10) {
        super();
        this.requestSubject = string;
        this.tags = a.e(list2);
        this.requestId = string3;
        this.localRequestId = string4;
        this.requestStatus = requestStatus5;
        this.hasAgentReplies = list10;
        this.customFields = list6;
        this.ticketFormId = l7;
        this.files = z9;
        this.configurations = obj11;
    }

    static long access$000(zendesk.support.request.RequestConfiguration requestConfiguration) {
        return requestConfiguration.ticketFormId;
    }

    static List access$100(zendesk.support.request.RequestConfiguration requestConfiguration) {
        return requestConfiguration.customFields;
    }

    public List<a> getConfigurations() {
        return c.a(this.configurations, this);
    }

    public List<CustomField> getCustomFields() {
        return this.customFields;
    }

    public List<zendesk.support.request.StateRequestAttachment> getFiles() {
        zendesk.support.request.StateRequestAttachment convert;
        ArrayList arrayList = new ArrayList(this.files.size());
        Iterator iterator = this.files.iterator();
        for (AttachmentFile next2 : iterator) {
            arrayList.add(StateRequestAttachment.convert(next2));
        }
        return arrayList;
    }

    public List<AttachmentFile> getFilesAsAttachments() {
        return this.files;
    }

    @Override // o.a.a
    public String getLocalRequestId() {
        return this.localRequestId;
    }

    @Override // o.a.a
    public String getRequestId() {
        return this.requestId;
    }

    @Override // o.a.a
    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    @Override // o.a.a
    public String getRequestSubject() {
        return this.requestSubject;
    }

    public List<String> getTags() {
        return this.tags;
    }

    @Override // o.a.a
    public zendesk.support.request.StateRequestTicketForm getTicketForm() {
        StateRequestTicketForm stateRequestTicketForm = new StateRequestTicketForm(this.ticketFormId, obj2, this.customFields);
        return stateRequestTicketForm;
    }

    @Override // o.a.a
    public long getTicketFormId() {
        return this.ticketFormId;
    }

    @Override // o.a.a
    boolean hasAgentReplies() {
        return this.hasAgentReplies;
    }
}
