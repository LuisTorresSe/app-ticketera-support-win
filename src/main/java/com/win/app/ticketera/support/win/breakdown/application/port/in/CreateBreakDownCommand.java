package com.win.app.ticketera.support.win.breakdown.application.port.in;

import com.win.app.ticketera.support.win.utils.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.Duration;

@Getter
public class CreateBreakDownCommand  extends SelfValidating<CreateBreakDownCommand> {
    @NotBlank
    private final Long clientId;

    @NotBlank
    private final Long subticketId;

    private final Duration falltime;

    private final String breakDownStatus;

    public CreateBreakDownCommand(Long clientId, Long subticketId, Duration falltime, String breakDownStatus) {
        this.clientId = clientId;
        this.subticketId = subticketId;
        this.falltime = falltime;
        this.breakDownStatus = breakDownStatus;
        this.validateSelf();
    }
}
