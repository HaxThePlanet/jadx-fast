package zendesk.support.request;

import android.net.Uri;
import d.h.k.d;
import f.g.e.a;
import f.g.e.c;
import f.g.e.e;
import f.g.e.g;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zendesk.belvedere.s;
import zendesk.support.Attachment;
import zendesk.support.AttachmentFile;
import zendesk.support.CommentResponse;
import zendesk.support.IdUtil;

/* loaded from: classes3.dex */
class StateRequestAttachment implements Serializable, Comparable<zendesk.support.request.StateRequestAttachment> {

    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    private final int height;
    private final long id;
    private final transient File localFile;
    private final String localUri;
    private final String mimeType;
    private final String name;
    private final long size;
    private final String thumbnailUrl;
    private final String token;
    private final String url;
    private final int width;

    static class Builder {

        private int height;
        private long id;
        private File localFile;
        private String localUri;
        private String mimeType;
        private String name;
        private long size;
        private String thumbnailUrl;
        private String token;
        private String url;
        private int width;
        private Builder(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
            super();
            this.id = stateRequestAttachment.getId();
            this.localFile = stateRequestAttachment.getLocalFile();
            this.localUri = stateRequestAttachment.getLocalUri();
            this.url = stateRequestAttachment.getUrl();
            this.token = stateRequestAttachment.getToken();
            this.mimeType = stateRequestAttachment.getMimeType();
            this.name = stateRequestAttachment.getName();
            this.size = stateRequestAttachment.getSize();
            this.width = stateRequestAttachment.getWidth();
            this.height = stateRequestAttachment.getHeight();
            this.thumbnailUrl = stateRequestAttachment.getThumbnailUrl();
        }

        Builder(zendesk.support.request.StateRequestAttachment stateRequestAttachment, zendesk.support.request.StateRequestAttachment.1 stateRequestAttachment$12) {
            super(stateRequestAttachment);
        }

        static File access$000(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.localFile;
        }

        static String access$100(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.localUri;
        }

        static String access$1000(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.thumbnailUrl;
        }

        static String access$200(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.mimeType;
        }

        static String access$300(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.name;
        }

        static long access$400(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.id;
        }

        static String access$500(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.url;
        }

        static String access$600(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.token;
        }

        static long access$700(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.size;
        }

        static int access$800(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.width;
        }

        static int access$900(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
            return builder.height;
        }

        zendesk.support.request.StateRequestAttachment build() {
            StateRequestAttachment stateRequestAttachment = new StateRequestAttachment(this, 0);
            return stateRequestAttachment;
        }

        zendesk.support.request.StateRequestAttachment.Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setId(long l) {
            this.id = l;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setLocalFile(File file) {
            this.localFile = file;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setLocalUri(String string) {
            this.localUri = string;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setMimeType(String string) {
            this.mimeType = string;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setName(String string) {
            this.name = string;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setSize(long l) {
            this.size = l;
            return this;
        }

        void setThumbnailUrl(String string) {
            this.thumbnailUrl = string;
        }

        zendesk.support.request.StateRequestAttachment.Builder setToken(String string) {
            this.token = string;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setUrl(String string) {
            this.url = string;
            return this;
        }

        zendesk.support.request.StateRequestAttachment.Builder setWidth(int i) {
            this.width = i;
            return this;
        }
    }
    StateRequestAttachment(long l, String string2, File file3, String string4, String string5, String string6, String string7, long l8, int i9, int i10, String string11) {
        super();
        this.id = l;
        this.localUri = file3;
        this.localFile = string4;
        this.url = string5;
        this.token = string6;
        this.mimeType = string7;
        this.name = l8;
        this.size = i9;
        this.width = string11;
        this.height = obj12;
        this.thumbnailUrl = obj13;
    }

    private StateRequestAttachment(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder) {
        super();
        this.localFile = StateRequestAttachment.Builder.access$000(builder);
        this.localUri = StateRequestAttachment.Builder.access$100(builder);
        this.mimeType = StateRequestAttachment.Builder.access$200(builder);
        this.name = StateRequestAttachment.Builder.access$300(builder);
        this.id = StateRequestAttachment.Builder.access$400(builder);
        this.url = StateRequestAttachment.Builder.access$500(builder);
        this.token = StateRequestAttachment.Builder.access$600(builder);
        this.size = StateRequestAttachment.Builder.access$700(builder);
        this.width = StateRequestAttachment.Builder.access$800(builder);
        this.height = StateRequestAttachment.Builder.access$900(builder);
        this.thumbnailUrl = StateRequestAttachment.Builder.access$1000(builder);
    }

    StateRequestAttachment(zendesk.support.request.StateRequestAttachment.Builder stateRequestAttachment$Builder, zendesk.support.request.StateRequestAttachment.1 stateRequestAttachment$12) {
        super(builder);
    }

    static d<Map<Long, zendesk.support.request.StateRequestAttachment>, zendesk.support.request.StateIdMapper> convert(List<CommentResponse> list, Map<Long, s> map2, zendesk.support.request.StateIdMapper stateIdMapper3) {
        List attachments;
        ArrayList arrayList = new ArrayList();
        Iterator obj2 = list.iterator();
        for (CommentResponse next2 : obj2) {
            arrayList.addAll(next2.getAttachments());
        }
        return StateRequestAttachment.convert(arrayList, stateIdMapper3, map2);
    }

    static d<Map<Long, zendesk.support.request.StateRequestAttachment>, zendesk.support.request.StateIdMapper> convert(List<Attachment> list, zendesk.support.request.StateIdMapper stateIdMapper2, Map<Long, s> map3) {
        Object next;
        Object stateRequestAttachment;
        long longValue3;
        boolean string;
        Long size;
        Long width;
        Long height;
        String contentUrl;
        long l2;
        int i3;
        int longValue2;
        Long num;
        Long longValue;
        long longValue4;
        zendesk.support.request.StateRequestAttachment request;
        long l3;
        int i2;
        int i5;
        String contentUrl2;
        String str2;
        String contentType;
        String fileName;
        long l;
        int i;
        int i4;
        String str;
        Object obj = stateIdMapper2;
        final Object obj2 = map3;
        HashMap hashMap = new HashMap(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Attachment)next.getId() == null) {
            } else {
            }
            if (obj.hasLocalId(next.getId())) {
            } else {
            }
            obj.addIdMapping(next.getId(), Long.valueOf(IdUtil.newLongId()));
            if (obj2.containsKey(next.getId())) {
            } else {
            }
            i5 = i2;
            longValue2 = -1;
            if (next.getSize() != null) {
            } else {
            }
            l = longValue2;
            if (next.getWidth() != null) {
            } else {
            }
            longValue4 = longValue2;
            if (next.getHeight() != null) {
            }
            if (a.i(next.getThumbnails())) {
            } else {
            }
            contentUrl = "";
            super(longValue3, obj11, i2, i5, next.getContentUrl(), "", next.getContentType(), next.getFileName(), l, obj19, (int)longValue4, (int)longValue2, contentUrl);
            hashMap.put(next.getId(), stateRequestAttachment);
            contentUrl = (Attachment)next.getThumbnails().get(0).getContentUrl();
            longValue2 = next.getHeight().longValue();
            longValue4 = next.getWidth().longValue();
            l = longValue;
            Object obj4 = obj2.get(next.getId());
            i2 = string;
            i5 = i3;
            longValue3 = obj.getLocalId(next.getId()).longValue();
        }
        return d.a(hashMap, obj);
    }

    static s convert(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
        super(stateRequestAttachment.getLocalFile(), stateRequestAttachment.getParsedLocalUri(), stateRequestAttachment.getParsedLocalUri(), stateRequestAttachment.getName(), stateRequestAttachment.getMimeType(), stateRequestAttachment.getSize(), obj7, (long)width, obj9, (long)obj13, obj11);
        return sVar2;
    }

    static zendesk.support.request.StateRequestAttachment convert(File file) {
        super(IdUtil.newLongId(), obj2, Uri.fromFile(file).toString(), file, "", "", StateRequestAttachment.getMimeTypeForFile(file), file.getName(), file.length(), obj10, -1, -1, "");
        return stateRequestAttachment;
    }

    static zendesk.support.request.StateRequestAttachment convert(s s) {
        super(IdUtil.newLongId(), obj2, s.n().toString(), s.e(), "", "", s.i(), s.j(), s.m(), obj10, (int)l, (int)l2, "");
        return stateRequestAttachment;
    }

    static zendesk.support.request.StateRequestAttachment convert(AttachmentFile attachmentFile) {
        super(IdUtil.newLongId(), obj2, Uri.fromFile(attachmentFile.getFile()).toString(), attachmentFile.getFile(), "", "", StateRequestAttachment.getMimeTypeForFile(attachmentFile.getFile()), attachmentFile.getFileName(), attachmentFile.getFile().length(), obj10, -1, -1, "");
        return stateRequestAttachment;
    }

    private static String getMimeTypeForFile(File file) {
        return e.b(c.a(file.getName()));
    }

    @Override // java.io.Serializable
    public int compareTo(Object object) {
        return compareTo((StateRequestAttachment)object);
    }

    @Override // java.io.Serializable
    public int compareTo(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
        return (int)i;
    }

    @Override // java.io.Serializable
    int getHeight() {
        return this.height;
    }

    @Override // java.io.Serializable
    long getId() {
        return this.id;
    }

    @Override // java.io.Serializable
    File getLocalFile() {
        return this.localFile;
    }

    @Override // java.io.Serializable
    String getLocalUri() {
        return this.localUri;
    }

    @Override // java.io.Serializable
    String getMimeType() {
        String mimeType;
        mimeType = g.c(this.mimeType) ? this.mimeType : "application/octet-stream";
        return mimeType;
    }

    @Override // java.io.Serializable
    String getName() {
        return this.name;
    }

    @Override // java.io.Serializable
    Uri getParsedLocalUri() {
        return Uri.parse(this.localUri);
    }

    @Override // java.io.Serializable
    long getSize() {
        return this.size;
    }

    @Override // java.io.Serializable
    String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    @Override // java.io.Serializable
    String getToken() {
        return this.token;
    }

    @Override // java.io.Serializable
    String getUrl() {
        return this.url;
    }

    @Override // java.io.Serializable
    int getWidth() {
        return this.width;
    }

    @Override // java.io.Serializable
    boolean isAvailableLocally() {
        Object parsedLocalUri;
        int i;
        if (this.localUri != null && getParsedLocalUri() != null) {
            i = getParsedLocalUri() != null ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateRequestAttachment.Builder newBuilder() {
        StateRequestAttachment.Builder builder = new StateRequestAttachment.Builder(this, 0);
        return builder;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RequestAttachment{id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", localUri='");
        stringBuilder.append(this.localUri);
        int i = 39;
        stringBuilder.append(i);
        stringBuilder.append(", localFile=");
        stringBuilder.append(this.localFile);
        stringBuilder.append(", url='");
        stringBuilder.append(this.url);
        stringBuilder.append(i);
        stringBuilder.append(", token='");
        stringBuilder.append(this.token);
        stringBuilder.append(i);
        stringBuilder.append(", mimeType='");
        stringBuilder.append(this.mimeType);
        stringBuilder.append(i);
        stringBuilder.append(", name='");
        stringBuilder.append(this.name);
        stringBuilder.append(i);
        stringBuilder.append(", size='");
        stringBuilder.append(this.size);
        stringBuilder.append(i);
        stringBuilder.append(", width='");
        stringBuilder.append(this.width);
        stringBuilder.append(i);
        stringBuilder.append(", height='");
        stringBuilder.append(this.height);
        stringBuilder.append(i);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
