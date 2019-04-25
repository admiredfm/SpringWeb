package mybatispackage.control;


import mybatispackage.service.NameFind;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class QueryName {

    @RequestMapping("/")
    public String test(Model model) throws IOException {
        NameFind nameFind = new NameFind();

        int count = nameFind.findCount();
        model.addAttribute("cont",count);

        return "stuOrTeacher";
    }

    @RequestMapping("/findname")
    public String find(Model model, @RequestParam String line,String stuname,String teachername) throws IOException {


        NameFind nameFind = new NameFind();

        model.addAttribute("list",nameFind.findName(stuname,teachername));
        model.addAttribute("stuname",stuname);
        model.addAttribute("teachername",teachername);
        model.addAttribute("line",line);

        return "stuOrTeacher";
    }

}
