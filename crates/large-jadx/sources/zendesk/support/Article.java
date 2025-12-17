package zendesk.support;

import f.g.c.a;
import f.g.e.a;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import zendesk.core.User;

/* loaded from: classes3.dex */
public class Article implements Serializable {

    private static final String LOG_TAG = "Article";
    public static final int UNKNOWN_VOTE_COUNT = -1;
    private User author;
    private Long authorId;
    private String body;
    private boolean commentsDisabled;
    private Date createdAt;
    private boolean draft;
    private String htmlUrl;
    private Long id;
    private List<String> labelNames;
    private String locale;
    private boolean outdated;
    private Integer position;
    private Long sectionId;
    private String sourceLocale;
    private String title;
    private Date updatedAt;
    private String url;
    private Integer voteCount;
    private Integer voteSum;
    @Override // java.io.Serializable
    public User getAuthor() {
        return this.author;
    }

    @Override // java.io.Serializable
    public Long getAuthorId() {
        return this.authorId;
    }

    @Override // java.io.Serializable
    public String getBody() {
        return this.body;
    }

    @Override // java.io.Serializable
    public Date getCreatedAt() {
        if (this.createdAt == null) {
            return null;
        }
        Date date = new Date(this.createdAt.getTime(), obj2);
        return date;
    }

    @Override // java.io.Serializable
    public int getDownvoteCount() {
        Integer voteCount;
        Integer voteSum = this.voteSum;
        if (voteSum != null && this.voteCount == null) {
            if (this.voteCount == null) {
            }
            return i2 /= 2;
        }
        a.e("Article", "Cannot determine vote count because vote_sum and / or vote_count are null", new Object[0]);
        return -1;
    }

    @Override // java.io.Serializable
    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    @Override // java.io.Serializable
    public Long getId() {
        return this.id;
    }

    public List<String> getLabelNames() {
        return a.c(this.labelNames);
    }

    @Override // java.io.Serializable
    public String getLocale() {
        return this.locale;
    }

    @Override // java.io.Serializable
    public Integer getPosition() {
        int intValue;
        Integer position = this.position;
        if (position == null) {
            intValue = 0;
        } else {
            intValue = position.intValue();
        }
        return Integer.valueOf(intValue);
    }

    @Override // java.io.Serializable
    public Long getSectionId() {
        return this.sectionId;
    }

    @Override // java.io.Serializable
    public String getSourceLocale() {
        return this.sourceLocale;
    }

    @Override // java.io.Serializable
    public String getTitle() {
        return this.title;
    }

    @Override // java.io.Serializable
    public Date getUpdatedAt() {
        if (this.updatedAt == null) {
            return null;
        }
        Date date = new Date(this.updatedAt.getTime(), obj2);
        return date;
    }

    @Override // java.io.Serializable
    public int getUpvoteCount() {
        Integer voteCount;
        Integer voteSum = this.voteSum;
        if (voteSum != null && this.voteCount == null) {
            if (this.voteCount == null) {
            }
            return i /= 2;
        }
        a.e("Article", "Cannot determine vote count because vote_sum and / or vote_count are null", new Object[0]);
        return -1;
    }

    @Override // java.io.Serializable
    public String getUrl() {
        return this.url;
    }

    @Override // java.io.Serializable
    public int getVoteCount() {
        int intValue;
        Integer voteCount = this.voteCount;
        if (voteCount == null) {
            intValue = 0;
        } else {
            intValue = voteCount.intValue();
        }
        return intValue;
    }

    @Override // java.io.Serializable
    public int getVoteSum() {
        int intValue;
        Integer voteSum = this.voteSum;
        if (voteSum == null) {
            intValue = 0;
        } else {
            intValue = voteSum.intValue();
        }
        return intValue;
    }

    @Override // java.io.Serializable
    public boolean isCommentsDisabled() {
        return this.commentsDisabled;
    }

    @Override // java.io.Serializable
    public boolean isDraft() {
        return this.draft;
    }

    @Override // java.io.Serializable
    public boolean isOutdated() {
        return this.outdated;
    }

    @Override // java.io.Serializable
    public void setAuthor(User user) {
        this.author = user;
    }
}
