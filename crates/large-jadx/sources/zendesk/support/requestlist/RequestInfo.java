package zendesk.support.requestlist;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import zendesk.support.RequestStatus;

/* loaded from: classes3.dex */
public class RequestInfo {

    private final List<zendesk.support.requestlist.RequestInfo.AgentInfo> agentInfos;
    private final Set<String> failedMessageIds;
    private final zendesk.support.requestlist.RequestInfo.MessageInfo firstMessageInfo;
    private final zendesk.support.requestlist.RequestInfo.MessageInfo lastMessageInfo;
    private final Date lastUpdated;
    private final String localId;
    private final String remoteId;
    private final RequestStatus requestStatus;
    private final boolean unread;

    public static class AgentInfo {

        private final String avatar;
        private final String id;
        private final String name;
        public AgentInfo(String string, String string2, String string3) {
            super();
            this.id = string;
            this.name = string2;
            this.avatar = string3;
        }

        public boolean equals(Object object) {
            int equals3;
            boolean equals2;
            boolean equals;
            Class class;
            Object class2;
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (object != null) {
                if (getClass() != object.getClass()) {
                } else {
                    String str = this.id;
                    if (str != null) {
                        if (!str.equals(object.id)) {
                            return i;
                        }
                    } else {
                        if (object.id != null) {
                        }
                    }
                    String name = this.name;
                    if (name != null) {
                        if (!name.equals(object.name)) {
                            return i;
                        }
                    } else {
                        if (object.name != null) {
                        }
                    }
                    String avatar = this.avatar;
                    final String obj5 = object.avatar;
                    if (avatar != null) {
                        equals3 = avatar.equals(obj5);
                    } else {
                        if (obj5 == null) {
                        } else {
                            equals3 = i;
                        }
                    }
                }
                return equals3;
            }
            return i;
        }

        String getAvatar() {
            return this.avatar;
        }

        String getId() {
            return this.id;
        }

        String getName() {
            return this.name;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            String str = this.id;
            i2 = 0;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = i2;
            }
            String name = this.name;
            if (name != null) {
                i3 = name.hashCode();
            } else {
                i3 = i2;
            }
            String avatar = this.avatar;
            if (avatar != null) {
                i2 = avatar.hashCode();
            }
            return i6 += i2;
        }
    }

    static class LastUpdatedComparator implements Comparator<zendesk.support.requestlist.RequestInfo> {
        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return compare((RequestInfo)object, (RequestInfo)object2);
        }

        @Override // java.util.Comparator
        public int compare(zendesk.support.requestlist.RequestInfo requestInfo, zendesk.support.requestlist.RequestInfo requestInfo2) {
            int obj3;
            final int i = 1;
            if (requestInfo2 == null) {
                return i;
            }
            if (requestInfo.getLastUpdated() == null) {
                obj3 = requestInfo2.getLastUpdated() == null ? 0 : -1;
                return obj3;
            }
            if (requestInfo2.getLastUpdated() == null) {
                return i;
            }
            return requestInfo2.getLastUpdated().compareTo(requestInfo.getLastUpdated());
        }
    }

    public static class MessageInfo {

        private final String body;
        private final Date date;
        private final String id;
        public MessageInfo(String string, Date date2, String string3) {
            super();
            this.id = string;
            this.date = date2;
            this.body = string3;
        }

        public boolean equals(Object object) {
            int equals3;
            boolean equals;
            boolean equals2;
            Class class;
            Object class2;
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (object != null) {
                if (getClass() != object.getClass()) {
                } else {
                    String str = this.id;
                    if (str != null) {
                        if (!str.equals(object.id)) {
                            return i;
                        }
                    } else {
                        if (object.id != null) {
                        }
                    }
                    Date date = this.date;
                    if (date != null) {
                        if (!date.equals(object.date)) {
                            return i;
                        }
                    } else {
                        if (object.date != null) {
                        }
                    }
                    String body = this.body;
                    final String obj5 = object.body;
                    if (body != null) {
                        equals3 = body.equals(obj5);
                    } else {
                        if (obj5 == null) {
                        } else {
                            equals3 = i;
                        }
                    }
                }
                return equals3;
            }
            return i;
        }

        String getBody() {
            return this.body;
        }

        Date getDate() {
            return this.date;
        }

        String getId() {
            return this.id;
        }

        public int hashCode() {
            int i3;
            int i;
            int i2;
            String str = this.id;
            i = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = i;
            }
            Date date = this.date;
            if (date != null) {
                i2 = date.hashCode();
            } else {
                i2 = i;
            }
            String body = this.body;
            if (body != null) {
                i = body.hashCode();
            }
            return i6 += i;
        }
    }
    public RequestInfo(String string, String string2, RequestStatus requestStatus3, boolean z4, Date date5, List<zendesk.support.requestlist.RequestInfo.AgentInfo> list6, zendesk.support.requestlist.RequestInfo.MessageInfo requestInfo$MessageInfo7, zendesk.support.requestlist.RequestInfo.MessageInfo requestInfo$MessageInfo8, Set<String> set9) {
        super();
        this.localId = string;
        this.remoteId = string2;
        this.requestStatus = requestStatus3;
        this.unread = z4;
        this.lastUpdated = date5;
        this.agentInfos = list6;
        this.firstMessageInfo = messageInfo7;
        this.lastMessageInfo = messageInfo8;
        this.failedMessageIds = set9;
    }

    public boolean equals(Object object) {
        boolean equals;
        boolean localId;
        String remoteId2;
        Date lastUpdated;
        boolean agentInfos;
        boolean firstMessageInfo2;
        zendesk.support.requestlist.RequestInfo.MessageInfo lastMessageInfo;
        Class class;
        String remoteId;
        Object firstMessageInfo;
        Class class2;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.unread != object.unread) {
                    return i;
                }
                String localId2 = this.localId;
                if (localId2 != null) {
                    if (!localId2.equals(object.localId)) {
                        return i;
                    }
                } else {
                    if (object.localId != null) {
                    }
                }
                String remoteId3 = this.remoteId;
                if (remoteId3 != null) {
                    if (!remoteId3.equals(object.remoteId)) {
                        return i;
                    }
                } else {
                    if (object.remoteId != null) {
                    }
                }
                if (this.requestStatus != object.requestStatus) {
                    return i;
                }
                Date lastUpdated2 = this.lastUpdated;
                if (lastUpdated2 != null) {
                    if (!lastUpdated2.equals(object.lastUpdated)) {
                        return i;
                    }
                } else {
                    if (object.lastUpdated != null) {
                    }
                }
                List agentInfos2 = this.agentInfos;
                if (agentInfos2 != null) {
                    if (!agentInfos2.equals(object.agentInfos)) {
                        return i;
                    }
                } else {
                    if (object.agentInfos != null) {
                    }
                }
                zendesk.support.requestlist.RequestInfo.MessageInfo firstMessageInfo3 = this.firstMessageInfo;
                if (firstMessageInfo3 != null) {
                    if (!firstMessageInfo3.equals(object.firstMessageInfo)) {
                        return i;
                    }
                } else {
                    if (object.firstMessageInfo != null) {
                    }
                }
                zendesk.support.requestlist.RequestInfo.MessageInfo lastMessageInfo2 = this.lastMessageInfo;
                if (lastMessageInfo2 != null) {
                    if (!lastMessageInfo2.equals(object.lastMessageInfo)) {
                        return i;
                    }
                } else {
                    if (object.lastMessageInfo != null) {
                    }
                }
                Set failedMessageIds = this.failedMessageIds;
                final Set obj5 = object.failedMessageIds;
                if (failedMessageIds != null) {
                    equals = failedMessageIds.equals(obj5);
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

    public List<zendesk.support.requestlist.RequestInfo.AgentInfo> getAgentInfos() {
        return this.agentInfos;
    }

    Set<String> getFailedMessageIds() {
        return this.failedMessageIds;
    }

    zendesk.support.requestlist.RequestInfo.MessageInfo getFirstMessageInfo() {
        return this.firstMessageInfo;
    }

    zendesk.support.requestlist.RequestInfo.MessageInfo getLastMessageInfo() {
        return this.lastMessageInfo;
    }

    Date getLastUpdated() {
        return this.lastUpdated;
    }

    public String getLocalId() {
        return this.localId;
    }

    public String getRemoteId() {
        return this.remoteId;
    }

    public RequestStatus getRequestStatus() {
        return this.requestStatus;
    }

    public int hashCode() {
        int i2;
        int i;
        int i3;
        int i5;
        int i7;
        int i4;
        int i8;
        int i6;
        String localId = this.localId;
        i = 0;
        if (localId != null) {
            i2 = localId.hashCode();
        } else {
            i2 = i;
        }
        String remoteId = this.remoteId;
        if (remoteId != null) {
            i3 = remoteId.hashCode();
        } else {
            i3 = i;
        }
        RequestStatus requestStatus = this.requestStatus;
        if (requestStatus != null) {
            i5 = requestStatus.hashCode();
        } else {
            i5 = i;
        }
        Date lastUpdated = this.lastUpdated;
        if (lastUpdated != null) {
            i7 = lastUpdated.hashCode();
        } else {
            i7 = i;
        }
        List agentInfos = this.agentInfos;
        if (agentInfos != null) {
            i4 = agentInfos.hashCode();
        } else {
            i4 = i;
        }
        zendesk.support.requestlist.RequestInfo.MessageInfo firstMessageInfo = this.firstMessageInfo;
        if (firstMessageInfo != null) {
            i8 = firstMessageInfo.hashCode();
        } else {
            i8 = i;
        }
        zendesk.support.requestlist.RequestInfo.MessageInfo lastMessageInfo = this.lastMessageInfo;
        if (lastMessageInfo != null) {
            i6 = lastMessageInfo.hashCode();
        } else {
            i6 = i;
        }
        Set failedMessageIds = this.failedMessageIds;
        if (failedMessageIds != null) {
            i = failedMessageIds.hashCode();
        }
        return i23 += i;
    }

    boolean isClosed() {
        return RequestStatus.Closed.equals(this.requestStatus);
    }

    boolean isUnread() {
        return this.unread;
    }
}
