package jp.ne.simplex.jjug.module;


import jp.ne.simplex.jjug.repository.OnMemorySessionRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryModule {

    @Bean
    public OnMemorySessionRepositoryImpl getSessionRepository(){
        return new OnMemorySessionRepositoryImpl();
    }
}
