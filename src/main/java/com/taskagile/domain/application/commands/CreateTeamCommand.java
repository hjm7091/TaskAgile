package com.taskagile.domain.application.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CreateTeamCommand extends UserCommand {

    private final String name;

}
