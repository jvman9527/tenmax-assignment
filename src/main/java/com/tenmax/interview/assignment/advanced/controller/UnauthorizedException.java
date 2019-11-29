package com.tenmax.interview.assignment.advanced.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Don't try this at home.")
class UnauthorizedException extends RuntimeException {}
