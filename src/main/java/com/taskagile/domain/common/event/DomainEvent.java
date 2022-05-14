package com.taskagile.domain.common.event;

import com.taskagile.domain.model.user.UserId;
import com.taskagile.utils.IpAddress;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

/**
 * Domain event. It is about who did what at what time.
 */
@Getter
public abstract class DomainEvent implements Serializable {

    private static final long serialVersionUID = 8945128060450240352L;

    private final UserId userId;
    private final IpAddress ipAddress;
    private final Date occurredAt;

    public DomainEvent(TriggeredBy triggeredBy) {
        this.userId = triggeredBy.getUserId();
        this.ipAddress = triggeredBy.getIpAddress();
        this.occurredAt = new Date();
    }

    public DomainEvent(UserId userId, TriggeredFrom triggeredFrom) {
        this.userId = userId;
        this.ipAddress = triggeredFrom.getIpAddress();
        this.occurredAt = new Date();
    }
}
