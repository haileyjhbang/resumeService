package com.resume.backend.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/view")
class AccountController {

    @RequestMapping("/success")
    private fun success(request: HttpServletRequest): String {
        return "success"
    }
}

