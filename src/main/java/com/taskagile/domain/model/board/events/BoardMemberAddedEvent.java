package com.taskagile.domain.model.board.events;

import com.taskagile.domain.common.event.TriggeredBy;
import com.taskagile.domain.model.board.BoardId;
import com.taskagile.domain.model.user.User;
import com.taskagile.domain.model.user.UserId;
import lombok.Getter;

@Getter
public class BoardMemberAddedEvent extends BoardDomainEvent {

    private static final long serialVersionUID = -8979992986207557039L;

    private final UserId memberUserId;
    private final String memberName;

    public BoardMemberAddedEvent(BoardId boardId, User addedUser, TriggeredBy triggeredBy) {
        super(boardId, triggeredBy);
        this.memberUserId = addedUser.getId();
        this.memberName = addedUser.getFirstName() + " " + addedUser.getLastName();
    }

}
