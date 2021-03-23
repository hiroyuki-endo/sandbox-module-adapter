package sandbox.module.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sandbox.module.ServiceIf;

@RestController
public class Controller {

    @Autowired
    private ServiceIf service;

    @GetMapping("/")
    public String saySomething() {
        return service.saySomething();
    }
}
