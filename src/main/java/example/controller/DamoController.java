package example.controller;

import example.dao.FlyImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 受人敬仰的Fm
 * @date 2019/1/28
 */
@Controller()
@RequestMapping("/")
public class DamoController {

    @RequestMapping("/")
    public String HelloWorld() {
        System.out.println("damo的");

        return "fly";
    }

    @RequestMapping("/flyController")
    public String Fly(Model model, @RequestParam()String takeoff,String aerodrome) {

        FlyImpl fly = new FlyImpl();

        String num = fly.inquire(takeoff,aerodrome);

        System.out.println(num);
        model.addAttribute("num",num);
        return "fly";
    }
}
