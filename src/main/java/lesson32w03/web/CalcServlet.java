package lesson32w03.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sx = req.getParameter("x");
        String sy = req.getParameter("y");
        String sop = req.getParameter("op");
        int x=Integer.parseInt(sx);
        int y=Integer.parseInt(sy);

        String result = "";

        switch (sop){
            case "add":
                result=x + "+" + y +"="+ (x+y);
                break;
            case "sub":
                result=x + "-" + y +"="+ (x-y);
                break;
            case "mul":
                result=x + "*" + y +"="+ (x*y);
                break;
            case "div":
                result=x + "/" + y +"="+ (x/y);
                if (y==0) result="You are divided by 0!";
                break;
            default:
                System.out.println("There is no operation");
        }

        //////

        try (PrintWriter w = resp.getWriter()) {
            w.write(result);
        }

    }
}
