package com.taskagile.domain.model.team.events;

import com.taskagile.domain.common.event.DomainEvent;
import com.taskagile.domain.common.event.TriggeredBy;
import com.taskagile.domain.model.team.Team;
import com.taskagile.domain.model.team.TeamId;
import lombok.Getter;

@Getter
public class TeamCreatedEvent extends DomainEvent {

    private static final long serialVersionUID = 2714833255396717504L;

    private final TeamId teamId;
    private final String teamName;

    public TeamCreatedEvent(Team team, TriggeredBy triggeredBy) {
        super(triggeredBy);
        this.teamId = team.getId();
        this.teamName = team.getName();
    }

    @Override
    public String toString() {
        return "TeamCreatedEvent{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}
