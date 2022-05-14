package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.board.BoardId;
import lombok.Getter;

@Getter
public class AddCardListCommand extends UserCommand {

    private final String name;
    private final BoardId boardId;
    private final int position;

    public AddCardListCommand(BoardId boardId, String name, int position) {
        this.boardId = boardId;
        this.name = name;
        this.position = position;
    }

}
