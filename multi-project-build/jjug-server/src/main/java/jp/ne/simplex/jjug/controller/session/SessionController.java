package jp.ne.simplex.jjug.controller.session;

import jp.ne.simplex.jjug.domain.value.Id;
import jp.ne.simplex.jjug.service.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping(path = "/register")
    public long registerSession(RegisterRequest request) {
        return sessionService.register(request.to()).value();
    }

    @GetMapping(path = "/find")
    public FindResponse findSession(long id) {
        return FindResponse.from(sessionService.find(Id.of(id)));
    }
}
