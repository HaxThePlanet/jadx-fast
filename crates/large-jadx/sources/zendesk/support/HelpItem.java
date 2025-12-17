package zendesk.support;

/* loaded from: classes3.dex */
public interface HelpItem {

    public static final int TYPE_ARTICLE = 3;
    public static final int TYPE_CATEGORY = 1;
    public static final int TYPE_LOADING = 5;
    public static final int TYPE_NO_RESULTS = 7;
    public static final int TYPE_PADDING = 8;
    public static final int TYPE_SECTION = 2;
    public static final int TYPE_SEE_ALL = 4;
    public abstract Long getId();

    public abstract String getName();

    public abstract Long getParentId();

    public abstract int getViewType();
}
