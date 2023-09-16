package controllers2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController2 {

    @GetMapping("/public-2")
    public String getPublic2(){
        return "Public-2";
    }
}
