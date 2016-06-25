package com.hin.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by cpazstido on 2016/6/25.
 */
public class MultiController extends MultiActionController {

    public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("adddddddddddddddddddddddddd");
        return new ModelAndView("/test","method","add");

    }

    public ModelAndView update(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("updateeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        return new ModelAndView("/test","method","add");

    }

    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("deleteeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        return new ModelAndView("/test","method","add");

    }
}
