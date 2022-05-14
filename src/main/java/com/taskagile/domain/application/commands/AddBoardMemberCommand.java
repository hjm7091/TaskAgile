package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.board.BoardId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AddBoardMemberCommand extends UserCommand {

    private final BoardId boardId;
    private final String usernameOrEmailAddress;

}
