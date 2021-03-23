package sandbox.module;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ServiceAImpl implements ServiceIf {
    @Override
    public String saySomething() {
        return "I'm module A!!!";
    }
}
