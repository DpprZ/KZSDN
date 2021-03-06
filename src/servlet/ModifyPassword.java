package servlet;

import bean.Message;
import dao.ResetPwd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifypwd")
public class ModifyPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        Message msg=new Message();
        msg.setUsername(username);
        msg.setPassword(password);
        boolean f= false;
        try {
            f = new ResetPwd().resetPwd(msg);
            if(f) {
                req.setAttribute("username", username);
                //req.setAttribute("password",password);
                req.setAttribute("tishi1", "密码已修改！");
                //resp.getWriter().write("\"<script>alert(\\\"注册成功\\\");</script>\"");
                req.getRequestDispatcher("/Menu.jsp").forward(req, resp);
            }
            else{
                req.setAttribute("tishi2","密码修改错误！");
                req.getRequestDispatcher("/ModifyPassword.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
