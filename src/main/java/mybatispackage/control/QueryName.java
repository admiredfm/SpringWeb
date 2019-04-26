package mybatispackage.control;


import mybatispackage.pojo.MyClass;
import mybatispackage.service.NameFind;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class QueryName {

    @RequestMapping("/")
    public String test(Model model) throws IOException {
        NameFind nameFind = new NameFind();

        int count = nameFind.findCount("","");
        model.addAttribute("count", count);

        return "stuOrTeacher";
    }

    @RequestMapping("/findname")
    public String find(Model model, String line, String stuname, String teachername) throws IOException {

        int lineNum = Integer.parseInt(line);

        int start = 0;
        int end = start + lineNum;

        NameFind nameFind = new NameFind();

        model.addAttribute("list", nameFind.findName(stuname, teachername, start, lineNum));
        model.addAttribute("stuname", stuname);
        model.addAttribute("teachername", teachername);
        model.addAttribute("line", line);

        return "stuOrTeacher";
    }

    @RequestMapping("/next")
    public String nextPage(Model model, HttpServletRequest request) throws IOException {

        String flag = request.getParameter("flag");
        String stuname = request.getParameter("stuname");
        String teachername = request.getParameter("teachername");
        int line = Integer.parseInt(request.getParameter("line"));
        int start = 0;
        int end = 2;
        switch (flag) {
            case "nextPage":
                start = Integer.parseInt(request.getParameter("end"));
                end = start + line;
                break;
            case "upPage":
                end = Integer.parseInt(request.getParameter("start"));
                start = end - line;
                break;
            default:
                end = line;
                break;
        }
        NameFind nameFind = new NameFind();

        int count = nameFind.findCount(stuname,teachername);

        List<MyClass> classList = nameFind.findName(stuname, teachername, start, line);

        model.addAttribute("list", classList);
        model.addAttribute("count", count);
        model.addAttribute("line", line);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        model.addAttribute("stuname", stuname);
        model.addAttribute("teachername", teachername);

        return "stuOrTeacher";
    }

}
