package zendesk.support;

/* loaded from: classes3.dex */
final class RequestData {

    private final int commentCount;
    private final String id;
    private int readCommentCount;
    private RequestData(String string, int i2, int i3) {
        super();
        this.commentCount = i2;
        this.id = string;
        this.readCommentCount = i3;
    }

    static zendesk.support.RequestData create(String string, int i2, int i3) {
        RequestData requestData = new RequestData(string, i2, i3);
        return requestData;
    }

    static zendesk.support.RequestData create(zendesk.support.Request request) {
        RequestData requestData = new RequestData(request.getId(), request.getCommentCount().intValue(), 0);
        return requestData;
    }

    public boolean equals(Object object) {
        int equals;
        Class<zendesk.support.RequestData> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (RequestData.class != object.getClass()) {
            } else {
                String str = this.id;
                final String obj5 = object.id;
                if (str != null) {
                    equals = str.equals(obj5);
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

    int getCommentCount() {
        return this.commentCount;
    }

    String getId() {
        return this.id;
    }

    int getReadCommentCount() {
        return this.readCommentCount;
    }

    public int hashCode() {
        int i;
        String str = this.id;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RequestData{commentCount=");
        stringBuilder.append(this.commentCount);
        stringBuilder.append("readCommentCount=");
        stringBuilder.append(this.readCommentCount);
        stringBuilder.append(", id='");
        stringBuilder.append(this.id);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    int unreadComments() {
        return commentCount -= readCommentCount;
    }
}
