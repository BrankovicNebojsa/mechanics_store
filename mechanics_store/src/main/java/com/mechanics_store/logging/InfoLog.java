package com.mechanics_store.logging;

import com.mechanics_store.controller.dto.UserDTO;
import java.time.LocalDateTime;

public record InfoLog(UserDTO currentUser, LocalDateTime time, String message) implements Log {

}
