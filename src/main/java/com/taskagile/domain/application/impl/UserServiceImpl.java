package com.taskagile.domain.application.impl;

import javax.transaction.Transactional;

import com.taskagile.domain.application.UserService;
import com.taskagile.domain.application.commands.RegisterCommand;
import com.taskagile.domain.common.event.DomainEventPublisher;
import com.taskagile.domain.common.mail.MailManager;
import com.taskagile.domain.common.mail.MessageVariable;
import com.taskagile.domain.model.user.*;
import com.taskagile.domain.model.user.events.UserRegisteredEvent;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final RegistrationManagement registrationManagement;
    private final DomainEventPublisher domainEventPublisher;
    private final MailManager mailManager;
    private final UserRepository userRepository;

    @Override
    public User findById(UserId userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void register(RegisterCommand command) throws RegistrationException {
        Assert.notNull(command, "Parameter `command` must not be null");
        User newUser = registrationManagement.register(
            command.getUsername(),
            command.getEmailAddress(),
            command.getFirstName(),
            command.getLastName(),
            command.getPassword());
    
        sendWelcomeMessage(newUser);
        domainEventPublisher.publish(new UserRegisteredEvent(newUser, command));
    }

    private void sendWelcomeMessage(User user) {
        mailManager.send(
            user.getEmailAddress(),
            "Welcome to TaskAgile",
            "welcome.ftl",
            MessageVariable.from("user", user)
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("No user found");
        }
        User user;
        if (username.contains("@")) {
            user = userRepository.findByEmailAddress(username);
        } else {
            user = userRepository.findByUsername(username);
        }
        if (user == null) {
            throw new UsernameNotFoundException("No user found by `" + username + "`");
        }
        return new SimpleUser(user);
    }
    
}
