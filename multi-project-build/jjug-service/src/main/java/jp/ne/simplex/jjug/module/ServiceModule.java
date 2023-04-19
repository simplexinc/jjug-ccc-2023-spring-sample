package jp.ne.simplex.jjug.module;


import jp.ne.simplex.jjug.repository.SessionRepository;
import jp.ne.simplex.jjug.service.SessionService;
import jp.ne.simplex.jjug.service.SessionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceModule {

    @Bean
    public SessionService getSessionService(SessionRepository sessionRepository) {
        return new SessionServiceImpl(sessionRepository);
    }
}
