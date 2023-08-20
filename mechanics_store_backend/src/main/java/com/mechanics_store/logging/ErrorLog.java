package com.mechanics_store.logging;

import com.mechanics_store.controller.dto.UserDTO;
import java.time.LocalDateTime;

public record ErrorLog(UserDTO currentUser, LocalDateTime time, String stackTrace) implements Log {

}
