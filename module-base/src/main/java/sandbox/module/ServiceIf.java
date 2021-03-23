package sandbox.module;

import org.springframework.stereotype.Service;

public interface ServiceIf {
    public String saySomething();

    @Service
    class BaseService implements ServiceIf {
        @Override
        public String saySomething() {
            return "I'm base logic.";
        }
    }
}
