package com.taskagile.domain.application.commands;

import com.taskagile.domain.model.team.TeamId;
import lombok.Getter;

@Getter
public class CreateBoardCommand extends UserCommand {

    private final String name;
    private final String description;
    private final TeamId teamId;

    public CreateBoardCommand(String name, String description, TeamId teamId) {
        this.name = name;
        this.description = description;
        this.teamId = teamId;
    }

}
