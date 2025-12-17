package zendesk.support;

import java.util.Arrays;
import java.util.Date;

/* loaded from: classes3.dex */
public class ArticleVote {

    private Date createdAt;
    private Long id;
    private Long itemId;
    private String itemType;
    private Date updatedAt;
    private String url;
    private Long userId;
    private Integer value;
    public boolean equals(Object object) {
        int equals3;
        boolean equals2;
        boolean equals4;
        Long userId;
        boolean equals;
        Long itemId;
        boolean itemType;
        boolean createdAt2;
        Class class;
        Object createdAt;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                Long num = this.id;
                if (num != null) {
                    if (!num.equals(object.id)) {
                        return i;
                    }
                } else {
                    if (object.id != null) {
                    }
                }
                String url = this.url;
                if (url != null) {
                    if (!url.equals(object.url)) {
                        return i;
                    }
                } else {
                    if (object.url != null) {
                    }
                }
                Long userId2 = this.userId;
                if (userId2 != null) {
                    if (!userId2.equals(object.userId)) {
                        return i;
                    }
                } else {
                    if (object.userId != null) {
                    }
                }
                Integer value = this.value;
                if (value != null) {
                    if (!value.equals(object.value)) {
                        return i;
                    }
                } else {
                    if (object.value != null) {
                    }
                }
                Long itemId2 = this.itemId;
                if (itemId2 != null) {
                    if (!itemId2.equals(object.itemId)) {
                        return i;
                    }
                } else {
                    if (object.itemId != null) {
                    }
                }
                String itemType2 = this.itemType;
                if (itemType2 != null) {
                    if (!itemType2.equals(object.itemType)) {
                        return i;
                    }
                } else {
                    if (object.itemType != null) {
                    }
                }
                Date createdAt3 = this.createdAt;
                if (createdAt3 != null) {
                    if (!createdAt3.equals(object.createdAt)) {
                        return i;
                    }
                } else {
                    if (object.createdAt != null) {
                    }
                }
                Date updatedAt = this.updatedAt;
                final Date obj5 = object.updatedAt;
                if (updatedAt != null) {
                    equals3 = updatedAt.equals(obj5);
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

    public Date getCreatedAt() {
        int date;
        long time;
        if (this.createdAt == null) {
            date = 0;
        } else {
            date = new Date(this.createdAt.getTime(), obj2);
        }
        return date;
    }

    public Long getId() {
        return this.id;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public String getItemType() {
        return this.itemType;
    }

    public Date getUpdatedAt() {
        int date;
        long time;
        if (this.updatedAt == null) {
            date = 0;
        } else {
            date = new Date(this.updatedAt.getTime(), obj2);
        }
        return date;
    }

    public String getUrl() {
        return this.url;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Integer getValue() {
        return this.value;
    }

    public int hashCode() {
        Object[] arr = new Object[8];
        return Arrays.hashCode(this.id, this.url, this.userId, this.value, this.itemId, this.itemType, this.createdAt, this.updatedAt);
    }
}
