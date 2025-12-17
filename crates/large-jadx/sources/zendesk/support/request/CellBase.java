package zendesk.support.request;

import android.graphics.Rect;
import java.util.Date;

/* loaded from: classes3.dex */
abstract class CellBase implements zendesk.support.request.CellType.Base {

    static final int GROUP_ID_END_USER = -2147483647;
    static final int GROUP_ID_SYSTEM_MESSAGE = Integer.MIN_VALUE;
    static final long ID_SYSTEM_MESSAGE_REQUEST_CLOSED = -9223372036854775807L;
    static final long ID_SYSTEM_MESSAGE_REQUEST_CREATED = Long.MIN_VALUE;
    private final long groupId;
    private final long id;
    private Rect insets;
    private final int layoutId;
    private int positionType = 1;
    private final Date timestamp;
    protected final zendesk.support.request.CellBindHelper utils;
    CellBase(zendesk.support.request.CellBindHelper cellBindHelper, int i2, long l3, long l4, Date date5) {
        super();
        this.utils = cellBindHelper;
        this.layoutId = i2;
        this.id = l3;
        this.groupId = date5;
        int obj1 = 1;
        this.timestamp = obj7;
        final int obj2 = 0;
        obj1 = new Rect(obj2, obj2, obj2, obj2);
        this.insets = obj1;
    }

    @Override // zendesk.support.request.CellType$Base
    public abstract boolean areContentsTheSame(zendesk.support.request.CellType.Base cellType$Base);

    @Override // zendesk.support.request.CellType$Base
    public abstract void bind(zendesk.support.request.ComponentRequestAdapter.RequestViewHolder componentRequestAdapter$RequestViewHolder);

    @Override // zendesk.support.request.CellType$Base
    public long getGroupId() {
        return this.groupId;
    }

    @Override // zendesk.support.request.CellType$Base
    public Rect getInsets() {
        return this.insets;
    }

    @Override // zendesk.support.request.CellType$Base
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // zendesk.support.request.CellType$Base
    public int getPositionType() {
        return this.positionType;
    }

    @Override // zendesk.support.request.CellType$Base
    public Date getTimeStamp() {
        return this.timestamp;
    }

    @Override // zendesk.support.request.CellType$Base
    public long getUniqueId() {
        return this.id;
    }

    @Override // zendesk.support.request.CellType$Base
    public void setPositionType(int i) {
        this.positionType = i |= positionType;
    }
}
