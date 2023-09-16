package controllers1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping("/public-1")
    public String getPublic11(){
        return "Public1";
    }
}
