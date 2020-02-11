package com.juju.control;

import com.juju.po.ListUser;
import com.juju.po.TeacherAndUser;
import com.juju.po.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Controller
public class Control {

    @InitBinder
    public void initDataConvertor(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object parameterTest(String username,String password){
        System.out.println("参数："+username+"--"+password);
        return "接收到参数了！";
    }

    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    @ResponseBody
    public Object parameterTeat2(User user,HttpServletRequest request){
        System.out.println("获取到的User"+user);
        return "接收到参数了";
    }

    @PostMapping("/login2")
    public Object parameterTest3(HttpServletRequest request){
        request.setAttribute("msg","第一种传值方法");
        return "/success.jsp";
    }

    @PostMapping("/login3")
    public Object parameterTest4(User user, HttpServletRequest request, Model model){
        System.out.println("User:"+user.toString());
        model.addAttribute("msg","第二种传值方法");
        return "/success.jsp";
    }

    @PostMapping("/login4")
    public  Object parameterTest5(User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","第三种传值方式");
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    @PostMapping("/login5")
    @ResponseBody
    public Object parameterTest6(TeacherAndUser teacherAndUser){
        System.out.println(teacherAndUser.getTeacher());
        System.out.println(teacherAndUser.getUser());
        return "接收参数成功！";
    }

    @ResponseBody
    @PostMapping("/login6")
    public Object parameterTest7(int[] id){
        System.out.println("接收到的数据是："+ Arrays.toString(id));
        for (int a: id) {
            System.out.println(a);
        }
        return "接收参数成功！";
    }

    @PostMapping("/login7")
    @ResponseBody
    public  Object parameterTest8(ListUser users){
        System.out.println("接收到的数据："+users.getUsers());
        return "接收参数成功！";
    }

    @PostMapping("/file")
    @ResponseBody
    public Object fileUpload(@RequestParam("file") MultipartFile file) throws Exception {
        if(!file.isEmpty()){
//            file.transferTo(new File("D:/copy.txt"));
            String filename = file.getOriginalFilename();
            int i = filename.lastIndexOf(".");
            String substring = filename.substring(i+1);
            System.out.println(substring);
            return "接收到文件了";
        }
        return "接收到参数了";
    }

}
